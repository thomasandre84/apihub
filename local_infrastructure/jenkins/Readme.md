# Starting Jenkins with Podman
attached an example kube.yml

Start with:
```
sudo podman kube play ./kube.yml
```

Important: do not use the option when starting the kube `--userns=keep-id`

In addition configure your `/etc/containers/storage.conf`
``` 
# AdditionalImageStores is used to pass paths to additional Read/Only image stores
# Must be comma separated list.
additionalimagestores = [
"/var/opt/containers/storage"
]

```
to find the newly build images with `sudo podman images`