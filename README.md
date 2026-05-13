# app-spring-api-lab

> Progetto di studio per il flusso di autenticazione/autorizzazione verso **Keycloak** in ambiente **Azure**.

---

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
