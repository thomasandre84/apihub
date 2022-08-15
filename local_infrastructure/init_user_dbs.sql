-- CREATE DATABASE apihub;
-- CREATE USER apihub WITH PASSWORD 'apihub';
-- GRANT ALL PRIVILEGES ON DATABASE apihub TO apihub;

CREATE USER apihub_gw WITH PASSWORD 'apihub_gw';
CREATE SCHEMA AUTHORIZATION apihub_gw;

CREATE USER apihub_admission WITH PASSWORD 'apihub_admission';
CREATE SCHEMA AUTHORIZATION apihub_admission;

CREATE USER apihub_billing WITH PASSWORD 'apihub_billing';
CREATE SCHEMA AUTHORIZATION apihub_billing;

CREATE USER apihub_cd WITH PASSWORD 'apihub_cd';
CREATE SCHEMA AUTHORIZATION apihub_cd;

CREATE USER apihub_portal WITH PASSWORD 'apihub_portal';
CREATE SCHEMA AUTHORIZATION apihub_portal;

CREATE USER apihub_reporting WITH PASSWORD 'apihub_reporting';
CREATE SCHEMA AUTHORIZATION apihub_reporting;

CREATE USER apihub_keycloak WITH PASSWORD 'apihub_keycloak';
CREATE SCHEMA AUTHORIZATION apihub_keycloak;
