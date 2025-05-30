# Sistema de Reservas

Este é um sistema de reservas desenvolvido com Spring Boot, projetado para gerenciar reservas de mesas em estabelecimentos. O sistema permite que usuários façam reservas de mesas e gerenciem seus status.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.3
- Spring Security
- PostgreSQL
- Docker
- JWT para autenticação
- Flyway para migração de banco de dados
- Maven

## Funcionalidades

- Autenticação e autorização de usuários
- Gerenciamento de mesas (CRUD)
- Sistema de reservas
- Verificação de disponibilidade de mesas
- Atualização de status de reservas

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

- **Controllers**: Gerenciam as requisições HTTP
- **DTOs**: Objetos de transferência de dados
- **Domain**: Entidades e regras de negócio
- **Repositories**: Camada de acesso a dados
- **Security**: Configurações de segurança e autenticação

## Como Rodar

### Pré-requisitos

- Docker
- Docker Compose

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone <seu-repositorio>
   cd <diretorio-do-projeto>
   ```

2. Execute com Docker Compose:
   ```bash
   docker-compose up --build
   ```

   Isso irá:
   - Construir a imagem da aplicação
   - Iniciar o container do PostgreSQL
   - Iniciar a aplicação Spring Boot
   - Configurar todas as variáveis de ambiente necessárias

3. A aplicação estará disponível em:
   - API: http://localhost:8080
   - Banco de dados: localhost:5432

### Variáveis de Ambiente

O projeto já está configurado com as seguintes variáveis no docker-compose:

- `SPRING_DATASOURCE_URL`: URL do banco de dados
- `SPRING_DATASOURCE_USERNAME`: Usuário do banco
- `SPRING_DATASOURCE_PASSWORD`: Senha do banco
- `JWT_SECRET`: Chave secreta para tokens JWT

## Endpoints da API

### Autenticação
- POST `/user/login`: Login de usuário
- POST `/user/register`: Registro de novo usuário

### Mesas
- GET `/mesas`: Lista todas as mesas
- POST `/mesas`: Cria nova mesa (requer ADMIN)
- PATCH `/mesas/{id}`: Atualiza mesa
- DELETE `/mesas/{id}`: Remove mesa

### Reservas
- POST `/booking`: Cria nova reserva
- GET `/booking`: Lista todas as reservas
- PATCH `/booking`: Atualiza status da reserva

## Status das Mesas

As mesas podem ter os seguintes status:
- `DISPONIVEL`: Mesa livre para reserva
- `INDISPONIVEL`: Mesa já reservada
- `INATIVO`: Mesa fora de operação

## Status das Reservas

As reservas podem ter os seguintes status:
- `ATIVO`: Reserva confirmada
- `CANCELADO`: Reserva cancelada

## Segurança

O sistema utiliza JWT (JSON Web Tokens) para autenticação. Todas as rotas (exceto login e registro) requerem um token válido.

## Docker

### Imagem no Docker Hub

A imagem do projeto está disponível no Docker Hub:
```bash
docker pull donruan3001/sistema-reserva:latest
```

### Construir Localmente

Se preferir construir a imagem localmente:
```bash
docker build -t sistema-reserva .
```

## Contribuição

Para contribuir com o projeto:
1. Faça um fork
2. Crie uma branch para sua feature
3. Faça commit das mudanças
4. Faça push para a branch
5. Abra um Pull Request

## Licença

[Sua licença aqui] 