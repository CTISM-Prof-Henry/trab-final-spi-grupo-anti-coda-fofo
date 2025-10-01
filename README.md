# Projeto Agenda Pol

> [!NOTE]
> Um sistema de agendamento para salas para professores agendarem horários e alunos visualizarem o agendamento de salas, com um administrador geral para o sistema
___

## Sumário

### **DEPENDÊNCIAS**
   1. [dependencias](#dependencias)

### **DEPLOY**
   1. [deploy do backend](#deploy-backend)

### UML
   1. [diagrama casos de uso](#uml)

### **BACKEND**
   1. [modeloER](#modelo-er)
   2. [Funcionalidades](#funcionalidades)
   3. [regras](#regras)

### **FRONTEND**
   1. [figma](#link-figma)
   2. [protótipos](#protótipos)
   3. [funcionalidades](#funcionalidades)
___

## DEPENDÊNCIAS
> [!NOTE]
> Todas as dependencias serão gerenciadas pelo docker em ambientes isolados cabendo ao desenvolvedor ter o docker devidamente instalado no seu sistema

- JDK21
- docker
- npm
- nodejs
- visual studio / intellij
- ambiente linux (wsl, ou maquina virtual)
___

## DEPLOY

### deploy backend

Estando na pasta /backed execute:

```bash
docker compose up -d
```

>[!NOTE]
>Verifique os serviços:

>```bash
>docker ps
>docker logs dbAgenda
>docker logs adminAgenda
>```

Neste ponto a API já esta sendo executada se preferir acesse a interface grafica do pgadmin
com o seguinte link na url do seu navegador

```bash
http://localhost:5050
```

![interface grafica do pgadmin web](/docs/adminAgenda.png)

insira as credencias do pgadmin definido nas variaveis de ambiente e configure um servidor novo
colocando o nome do host como o nome do container do banco ou seu endereço ip, senha usuario e nome do banco

![interface gráfica do pgadmin web](/docs/adminAgendaServer.png.png)
___

## **UML**
### Diagramas de casos de uso
![diagrama de casos de uso](/docs/CasosDeUso.drawio(1).png)

## **BACKEND**

### modelo ER
![modelo er](/docs/modeloER.png)

### funcionalidades
- [ ] Haverá um usuário administrador que cadastra professores e salas
- [ ] Os professores cadastram eventos e quando criam um agendameno estão associando um evento a uma sala
- [ ] Nos agendamento que são por formato data hora[yy-mm-dd hh-mm-ss] os professores e alunos poderão consultar as salas ocupadas em um período específico de tempo, mostrando o nome e o horário com o tipo da sala e evento 
- [ ] Os professores e alunos também poderão ver as salas livres em um período de tempo
- [ ] Os professores podem associar um evento a uma sala que estiver livre naquele período
- [ ] Tanto os professores como alunos poderão filtrar
salas por tipo, e prédio
- [ ] Tanto professores e alunos poderão pesquisar os agendamentos em uma sala e filtrar por uma data e tipo de evento
- [ ] os professores podem editar o evento
- [ ] os professores podem editar o horário do agendamento bem como cancelar(excluir)

### regras
- [ ] a aplicação deve verificar se o evento que o professor deseja associar a aquela sala
não entrará em conflito com horário a outro evento
- [ ] os professores não podem editar nem excluir agendamentos depois que a data do evento passar da data atual, afim de preservar o histórico
- [ ] os professores e o administrador devem ser autenticados com credenciais próprias
___

## **FRONTEND**

### link figma

- [link para o figma](https://www.figma.com/design/cZoiSPsSOjAio7jQksXsnF/Marca%C3%A7%C3%A3o-de-sala--Eng-De-Software-?node-id=0-1&t=VGR2Ehy1dGJEXv2G-1)

### protótipos

### funcionalidades
