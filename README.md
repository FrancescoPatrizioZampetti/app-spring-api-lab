# app-spring-api-lab

Backend Spring Boot stateless per un laboratorio Azure con autenticazione tramite Keycloak e deploy cloud-native su Azure.

L’obiettivo del progetto è costruire un piccolo progetto di esempio su azure che simuli il backend di un'applicazione web con un ipotetico front-end angular:

- Keycloak come Identity Provider / Authorization Server (con doppia gestione Microsoft Entra ID)
- Spring Boot come Resource Server stateless
- Azure Key Vault per i segreti
- App Service
- Azure Container Registry
- GitLab CI/CD

[//]: # (- Azure Application Insights e Log Analytics per osservabilità)

[//]: # (- PostgreSQL managed per Keycloak e dati applicativi&#41;)

[//]: # (- Azure Blob Storage per upload file&#41;)
---

Il progetto usa questo flusso standard per mantenere il backend stateless:

```text
Ipotizzando un front-end Angular:

1. L'utente effettua il login su Keycloak
2. Viene restituito un access token JWT
3. Angular chiama il backend Spring Boot con Authorization: Bearer <token>
4. L'app Spring Boot valida il token ed esegue la logica richiesta
```

## Infrastruttura Azure

**Resource Group:** `rg-spring-api-lab`

---

[//]: # (### PostgreSQL Flexible Server)

[//]: # (**`pg-spring-api-lab`**)

[//]: # (- `keycloak_db`)

[//]: # (- `app_db`)

[//]: # ()
[//]: # (---)

[//]: # (### Azure Container Apps)

[//]: # ()
[//]: # (| Risorsa | Nome |)

[//]: # (|---|---|)

[//]: # (| Container Apps Environment | `cae-spring-api-lab` |)

[//]: # (| Container App | `aca-spring-api-lab` |)

[//]: # ()
[//]: # (---)

### Azure App Service

Al momento essendo un laboratorio Keycloak e spring-api-lab condividono lo stesso App Service Plan.
Per semplicità Keycloak viene deployato su un App Service usando un'immagine custom che importa il realm e gli utenti dal json [spring-api-lab-realm.json](docker/keycloak/import/spring-api-lab-realm.json)

| Risorsa | Nome |
|---|---|
| App Service Plan | `asp-spring-api-lab` |
| App Service | `app-spring-api-lab` |
| App Service | `app-keycloak-lab` |

---

### Azure Key Vault
**`kv-spring-api-lab`**

---

[//]: # (### Monitoraggio)

[//]: # ()
[//]: # (| Risorsa | Nome |)

[//]: # (|---|---|)

[//]: # (| Application Insights | `appi-spring-api-lab` |)

[//]: # (| Log Analytics Workspace | `law-spring-api-lab` |)

[//]: # ()
[//]: # (---)

### Altre Risorse

| Risorsa | Nome |
|---|---|
| Azure Container Registry | `acrdevlab01` |
| Storage Account | `stspringapilab` |

[//]: # (| Budget Alert | `budget-spring-api-lab` |)


## Come iniziare

Per sviluppo in locale posizionarsi nella root del progetto ed eseguire:

```bash
docker compose up -d
```
Verranno avviati i container Docker necessari, keycloack e app-spring-api-lab.

## Keycloak

L'Admin Console di Keycloak è disponibile all'indirizzo:

http://localhost:8080/admin/

### Realm

```text
spring-api-lab
```

### Utenza amministratore

| Campo | Valore |
|---|---|
| Username | `admin` |
| Password | `admin` |

### Utenza applicativa di test

| Campo | Valore |
|---|---|
| Username | `testuser` |
| Password | `test1234` |

## Swagger UI

Swagger UI è disponibile all'indirizzo:

http://localhost:8081/swagger-ui.html


