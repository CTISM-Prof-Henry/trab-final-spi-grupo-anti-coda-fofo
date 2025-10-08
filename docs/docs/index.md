# Polisalas

## Visão Geral

O **Polisalas** é o sistema de agendamento de salas do colégio politécnico desenvolvido para gerenciar o uso de salas de aula, laboratórios e auditórios dentro do campus universitário.

O sistema permite que professores reservem espaços de forma simples, transparente e organizada, evitando conflitos de horários e otimizando a ocupação das salas.

## Início Rápido

### Pré-requisitos
- **JDK 21+**
- **Docker**
- **Node.js 18+** e **npm**
- **Git**

### Instalação

```bash
# Clone o repositório
git clone https://github.com/CTISM-Prof-Henry/trab-final-spi-grupo-anti-coda-fofo.git
cd ./trab-final-spi-grupo-anti-coda-fofo/

# Backend
cd backend
docker compose up -d

# Frontend
cd ../frontend
npm install
npm start
```

### Acesso
- **API**: http://localhost:3000/api
- **Swagger UI**: http://localhost:3000/api/swagger-ui.html
- **pgAdmin**: http://localhost:5050
- **Frontend**: http://localhost:4200

## Funcionalidades

| Módulo                         | Descrição                                                                                       |
| ------------------------------ | ----------------------------------------------------------------------------------------------- |
| **Cadastro de Salas**          | Registro e gerenciamento de salas                                        |
| **Agendamento**                | Criação, edição e cancelamento de reservas com verificação de disponibilidade                  |
| **Calendário Interativo**      | Visualização das reservas em formato semanal/mensal                                            |
| **Gestão de Eventos**          | Criação e organização de eventos acadêmicos                                                     |
| **Controle de Conflitos**      | Verificação automática de sobreposição de horários                                             |

## Arquitetura do Sistema

| Camada               | Tecnologia             | Versão        |
| -------------------- | ---------------------- | ------------- |
| **Backend**          | Java + Spring Boot     | 21 + 3.5.5    |
| **Frontend**         | Angular                | 20.2.0        |
| **Banco de Dados**   | PostgreSQL             | 17            |
| **Autenticação**     | Spring Security + JWT  | -             |
| **Build & Deploy**   | Maven + Docker         | -             |
| **Documentação API** | OpenAPI / Swagger      | 2.8.13        |

## Documentação

### Para Desenvolvedores
- [**Guia de Instalação**](instalacao.md) - Configuração completa do ambiente
- [**Documentação da API**](api.md) - Endpoints e exemplos de uso
- [**Banco de Dados**](banco-dados.md) - Estrutura e migrações
- [**Frontend**](frontend.md) - Componentes e arquitetura Angular
- [**Exemplos e Testes**](exemplos.md) - Casos de uso e testes


## Tecnologias Utilizadas

### Backend
- **Spring Boot 3.5.5** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **Flyway** - Migrações de banco
- **Lombok** - Redução de boilerplate
- **PostgreSQL** - Banco de dados
- **Docker** - Containerização

### Frontend
- **Angular 20.2.0** - Framework principal
- **TypeScript 5.9.2** - Linguagem


### DevOps
- **Docker Compose** - Orquestração
- **Maven** - Build do backend
- **npm** - Gerenciamento de dependências
- **Git** - Controle de versão

## Deploy

### Desenvolvimento

```bash
# Backend
cd backend
docker compose up -d

# Frontend
cd frontend
npm start
```


## Suporte

- **Github**:  [GitHub](https://github.com/CTISM-Prof-Henry/trab-final-spi-grupo-anti-coda-fofo)
- **Issues**: [GitHub Issues](https://github.com/CTISM-Prof-Henry/trab-final-spi-grupo-anti-coda-fofo/issues)
