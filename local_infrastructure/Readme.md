# Starting Infrastructure

## Docker
Use docker compose within this directory
```bash
docker compose up -d 
docker compose down
```

## Podman
A bit more challenging.

To be able to mount the files and folders, when having SELinux activated, for e.g. the file `init_user_dbs.sql`
```bash
chcon -t container_file_t init_user_dbs.sql
```
make sure the network you are using has `"dns_enabled": true`.
```bash
> podman network ls
NETWORK ID    NAME                         DRIVER
2f259bab93aa  podman                       bridge
ddb1b8f554aa  podman-default-kube-network  bridge
```

```bash
podman network inspect podman-default-kube-network
[
     {
          "name": "podman-default-kube-network",
          "id": "ddb1b8f554aa05ae47a11ffd615e097dab62e1c42e8cfaa9f03f3d62fad4136d",
          "driver": "bridge",
          "network_interface": "podman1",
          "created": "2023-07-05T18:25:34.821373959+02:00",
          "subnets": [
               {
                    "subnet": "10.89.0.0/24",
                    "gateway": "10.89.0.1"
               }
          ],
          "ipv6_enabled": false,
          "internal": false,
          "dns_enabled": true,
          "ipam_options": {
               "driver": "host-local"
          }
     }
]
```
If that's not the case, make sure to create a network with an enabled network.
Check `podman network create ..` and also check [containers.conf](https://github.com/containers/common/blob/main/docs/containers.conf.5.md) and `netavark`. 

The connection between the pods runs via the names of the service within the kube.yaml file.
* To start e.g. the Pod/Deployment for postgres use: `podman kube play postgres.yaml`
* To remove the Pod: `podman kube down postgres.yaml` -> usually in development mode
* To stop/start/restart a pod, identify the pod with e.g. `podman pod ps`  
  * Stop it with `podman pod stop <>`
  * Start it again with `podman pod start <>`
  * Or stop/start in one command `podman pod restart <>`

### Starting the Podman infrastrcture with ansible
* Pre-requirement: ansible installed
* commands for starting all on localhost:
```bash
ansible-playbook drop_podman_kubes.yaml
ansible-playbook create_podman_kubes.yaml
ansible-playbook stop_podman_kubes.yaml
ansible-playbook start_podman_kubes.yaml
```
* check with: `podman pod ps` and `podman ps