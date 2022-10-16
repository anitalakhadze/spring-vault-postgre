export VAULT_TOKEN='hvs.8AvxoTS1aaLA0gVp7YNrmetP'
export VAULT_ADDRESS='http://0.0.0.0:8200'


docker run --cap-add=IPC_LOCK -d -p 8200:8200 --name=dev-vault vault