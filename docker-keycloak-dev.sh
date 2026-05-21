# sviluppo locale di Keycloak con Docker
# docs: https://www.keycloak.org/getting-started/getting-started-docker
# user tmp : admin psw: admin

# http://localhost:8080/admin/master/console/
# http://localhost:8080/realms/spring-api-lab/account
# user: testuser
# user: admin-lab
# user: master-admin
# password: test1234
#docker run -p 127.0.0.1:8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.6.2 start-dev
#docker run --rm --name keycloak-lab -p 127.0.0.1:8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin -v ./docker/keycloak/import:/opt/keycloak/data/import:ro quay.io/keycloak/keycloak:26.6.2 start-dev --import-realm

docker compose up

# per esportare i dati del realm in un file json
#docker run --rm -v keycloak-lab-data:/opt/keycloak/data -v %cd%/docker/keycloak/export:/opt/keycloak/export quay.io/keycloak/keycloak:26.6.2 export --dir /opt/keycloak/export --realm spring-api-lab --users realm_file