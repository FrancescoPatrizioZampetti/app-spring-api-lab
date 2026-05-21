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

**Resource Group:** `rg-spring-keycloak-lab-dev`

---

### PostgreSQL Flexible Server
**`pg-spring-keycloak-lab`**
- `keycloak_db`
- `app_db`

---

### Azure Container Apps

| Risorsa | Nome |
|---|---|
| Container Apps Environment | `cae-spring-keycloak-lab` |
| Container App | `aca-keycloak-lab` |

---

### Azure App Service

| Risorsa | Nome |
|---|---|
| App Service Plan | `asp-spring-keycloak-lab` |
| App Service | `app-spring-api-lab` |

---

### Azure Key Vault
**`kv-spring-keycloak-lab`**

---

### Monitoraggio

| Risorsa | Nome |
|---|---|
| Application Insights | `appi-spring-api-lab` |
| Log Analytics Workspace | `law-spring-keycloak-lab` |

---

### Altre Risorse

| Risorsa | Nome |
|---|---|
| Azure Container Registry | `acrspringkclab01` |
| Storage Account | `stspringkeycloaklab` |
| Budget Alert | `budget-spring-keycloak-lab` |
