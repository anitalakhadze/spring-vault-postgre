#!/bin/sh
set -e

# export VAULT_TOKEN='hvs.8AvxoTS1aaLA0gVp7YNrmetP'
# export VAULT_ADDR='http://0.0.0.0:8200'

vault secrets enable database

vault write database/config/my-postgresql-database \
    plugin_name="postgresql-database-plugin" \
    allowed_roles="my-role" \
    connection_url="postgresql://{{username}}:{{password}}@172.17.0.1:5432/postgres" \
    username=$POSTGRES_USERNAME \
    password=$POSTGRES_PASSWORD

vault write database/roles/my-role \
    db_name="my-postgresql-database" \
    creation_statements="CREATE ROLE \"{{name}}\" WITH LOGIN PASSWORD '{{password}}' VALID UNTIL '{{expiration}}'; \
        GRANT SELECT, UPDATE ON ALL TABLES IN SCHEMA public TO \"{{name}}\";" \
    default_ttl="1m" \
    max_ttl="24h"

vault read database/creds/my-role