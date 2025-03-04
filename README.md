﻿# CEP Service

Um serviço REST para consulta e armazenamento de endereços brasileiros através do CEP, integrado com a API ViaCEP.

## 🚀 Tecnologias

- Java 21
- Spring Boot 3.4.2
- Spring Cloud OpenFeign
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven 3.6 ou superior

## 🔧 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/cep-service.git
```

2. Entre no diretório do projeto:
```bash
cd cep-service
```

3. Execute o build com Maven:
```bash
mvn clean install
```

4. Inicie a aplicação:
```bash
mvn spring-boot:run
```

## 🔍 Uso

O serviço disponibiliza um endpoint REST para consulta de endereços por CEP:

### Consultar CEP

```http
GET /api/{cep}
```

Exemplo de requisição:
```bash
curl http://localhost:8080/api/01001000
```

Exemplo de resposta:
```json
{
    "cep": "01001-000",
    "logradouro": "Praça da Sé",
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "localidade": "São Paulo",
    "uf": "SP",
    "ibge": "3550308",
    "gia": "1004",
    "ddd": "11",
    "siafi": "7107"
}
```

## 🗃️ Banco de Dados

O serviço utiliza um banco de dados H2 em memória para persistência dos endereços consultados.
O console do H2 pode ser acessado em: http://localhost:8080/h2-console

Configurações de acesso:
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: [em branco]

## 🛠️ Arquitetura

O serviço segue uma arquitetura em camadas:

- **Controller**: Responsável pelo tratamento das requisições HTTP
- **Service**: Contém a lógica de negócio e integração com a API ViaCEP
- **Repository**: Camada de persistência com Spring Data JPA
- **Model**: Entidades e objetos de domínio

## 📦 Features

- Consulta de endereços via CEP na API ViaCEP
- Persistência automática dos endereços consultados
- Validação de CEPs inexistentes
- Logging de operações
- CORS habilitado para integração com frontends

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'feat: Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## ✨ Autor

Diogo Marcelo - [dmsvianadev@gmail.com]

---
⌨️ por [dmsvianadev] 😊
