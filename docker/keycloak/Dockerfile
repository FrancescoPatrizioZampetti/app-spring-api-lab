# creo un immagine custom con keycloak e i realm importati per il deploy su app service
# le environment variabiles si trovano su app service
FROM quay.io/keycloak/keycloak:26.6.2

COPY import/ /opt/keycloak/data/import/

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev", "--import-realm"]