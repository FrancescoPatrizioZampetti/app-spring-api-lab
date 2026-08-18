# app-spring-api-lab

Backend Spring Boot stateless per un laboratorio Azure con autenticazione tramite Keycloak e deploy cloud-native su Azure.

L’obiettivo del progetto è costruire una piccola architettura realistica:

- Angular SPA per il frontend (ipotesi di frontend)
- Keycloak come Identity Provider / Authorization Server (con doppia gestione Microsoft Entra ID)
- Spring Boot come Resource Server stateless
- PostgreSQL managed per Keycloak e dati applicativi
- Azure Key Vault per i segreti
- Azure Blob Storage per upload file
- Azure Application Insights e Log Analytics per osservabilità
- Azure Container Registry e GitLab CI/CD per deploy containerizzato
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

### PostgreSQL Flexible Server
**`pg-spring-api-lab`**
- `keycloak_db`
- `app_db`

---

### Azure Container Apps

| Risorsa | Nome |
|---|---|
| Container Apps Environment | `cae-spring-api-lab` |
| Container App | `aca-spring-api-lab` |

---

### Azure App Service

| Risorsa | Nome |
|---|---|
| App Service Plan | `asp-spring-api-lab` |
| App Service | `app-spring-api-lab` |

---

### Azure Key Vault
**`kv-spring-api-lab`**

---

### Monitoraggio

| Risorsa | Nome |
|---|---|
| Application Insights | `appi-spring-api-lab` |
| Log Analytics Workspace | `law-spring-api-lab` |

---

### Altre Risorse

| Risorsa | Nome |
|---|---|
| Azure Container Registry | `acrspringapilab01` |
| Storage Account | `stspringapilab` |
| Budget Alert | `budget-spring-api-lab` |


## Come iniziare

Posizionarsi nella root del progetto ed eseguire:

```bash
docker compose up -d
```

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


