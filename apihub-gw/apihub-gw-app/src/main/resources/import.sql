INSERT INTO provider (id, baseurl, authurl) VALUES ('test', 'https://localhost:8085/mock', 'https://localhost:8090/auth');

INSERT INTO client (id) VALUES ('81aad69b-8093-40a9-87ec-9992d5ffb6c9');

INSERT INTO callback_url (id, url) VALUES ('d567dc94-805c-4a00-8a8e-766358ceeaf1', 'https://www.google.com');

INSERT INTO client_app (id, client_id, defaultcallbackurl_id) VALUES ('be85467d-a8a8-43a3-9e3a-62e923728296', '81aad69b-8093-40a9-87ec-9992d5ffb6c9', 'd567dc94-805c-4a00-8a8e-766358ceeaf1');

INSERT INTO consent (id, scope, client_id, provider_id, userid, status) VALUES ('474de9a8-067c-41a9-8970-da27955caa80', 'test:scope', '81aad69b-8093-40a9-87ec-9992d5ffb6c9', 'test', 'fa088584-2f55-409f-82a3-fadba639233f', 'CREATED');