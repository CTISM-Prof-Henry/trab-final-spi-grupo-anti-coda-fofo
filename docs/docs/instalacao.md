# Guia de Instalação e Configuração

## Pré-requisitos

### Software Necessário

| Software | Versão Mínima | Descrição |
|----------|---------------|-----------|
| **Docker** | 20.10+ | Para containerização dos serviços |
| **Docker Compose** | 2.0+ | Para orquestração dos containers |
| **Java** | 21+ | Para desenvolvimento do backend |
| **Node.js** | 18+ | Para desenvolvimento do frontend |
| **npm** | 8+ | Gerenciador de pacotes do Node.js |
| **Maven** | 3.8+ | Para build do backend  |

### Sistema Operacional

- **Linux** (recomendado)
- **Windows** com WSL2

## Instalação

### 1. Clone do Repositório

```bash
git clone https://github.com/CTISM-Prof-Henry/trab-final-spi-grupo-anti-coda-fofo.git
cd ./trab-final-spi-grupo-anti-coda-fofo/
```

### 2. Configuração do Backend


```bash
cd backend
docker compose up -d
```

Este comando irá:

- Criar e iniciar o container do PostgreSQL
- Criar e iniciar o container do pgAdmin
- Configurar a rede interna dos containers



### 3. Configuração do Frontend

```bash
cd frontend
npm install
npm start
```

## Configuração de Ambiente

### Variáveis de Ambiente

#### Backend (application.properties)

```properties
# Aplicação
spring.application.name=politecnico
server.servlet.context-path=/api
server.port=3000

# Banco de dados
spring.datasource.url=jdbc:postgresql://localhost:5010/agenda
spring.datasource.username=postgres
spring.datasource.password=1234

# JPA
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

# Flyway
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```

#### Docker Compose

```yaml
services:
  dbAgenda:
    image: postgres:17
    container_name: dbAgenda
    ports:
      - "5010:5432"
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: 1234
      POSTGRES_DB: agenda
    networks:
      - agenda_poli
    healthcheck:
      test: ["CMD", "pg_isready", "-U", "postgres", "-d", "agenda"]
      interval: 5s
      timeout: 5s
      retries: 5
      start_period: 10s

  adminAgenda:
    image: dpage/pgadmin4:8
    container_name: adminAgenda
    ports: 
      - "5050:80"
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@admin.com
      PGADMIN_DEFAULT_PASSWORD: admin1234
    depends_on:
      - dbAgenda
    networks:
      - agenda_poli

networks:
  agenda_poli:
    driver: bridge

```

## Verificação da Instalação

### 1. Verificar Containers

```bash
docker ps
```

Deve mostrar os containers `dbAgenda` e `adminAgenda` rodando.

### 2. Verificar Logs

```bash
# Logs do banco
docker logs dbAgenda

# Logs do pgAdmin
docker logs adminAgenda
```

### 3. Testar Conectividade

#### Backend
```bash
curl http://localhost:3000/api/salas
```

#### Frontend
```bash
curl http://localhost:4200
```

#### pgAdmin
Acesse: <a href="http://localhost:5050" target="_BLANK">http://localhost:5050</a>



## Configuração do Banco de Dados

### 1. Conectar ao pgAdmin

1. Acesse http://localhost:5050
2. Faça login com as credenciais acima
3. Clique em "Add New Server"

### 2. Configurar Servidor

| Campo | Valor |
|-------|-------|
| **Name** | Agenda Database |
| **Host** | dbAgenda |
| **Port** | 5432 |
| **Username** | postgres |
| **Password** | 1234 |
| **Database** | agenda |

### 3. Inserir Dados Mockados

  Coloque o V2__script_dados_inicializacao.sql no db.migration no backend ou insira manualmente no banco de dados.


### Urls Importantes

- **Swagger UI**: <a href="http://localhost:3000/api/swagger-ui.html" target="_BLANK">http://localhost:3000/api/swagger-ui.html</a>
- **pgAdmin**: <a href="http://localhost:5050" target="_BLANK">http://localhost:5050</a>
