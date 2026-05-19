# sviluppo locale di Keycloak con Docker
# docs: https://www.keycloak.org/getting-started/getting-started-docker
# user : admin psw: admin

# http://localhost:8080/realms/spring-lab-realm/account
# user: testuser
# password: test1234
#docker run -p 127.0.0.1:8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.6.2 start-dev
#docker run --rm --name keycloak-lab -p 127.0.0.1:8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin -v ./docker/keycloak/import:/opt/keycloak/data/import:ro quay.io/keycloak/keycloak:26.6.2 start-dev --import-realm

docker compose up