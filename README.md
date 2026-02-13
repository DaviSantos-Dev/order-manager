# Order Manager

## 📌 Overview

Order Manager é um sistema de gerenciamento de pedidos desenvolvido como projeto de evolução técnica em backend Java.

O foco principal do projeto é aplicar princípios de arquitetura, separação de responsabilidades e desacoplamento entre camadas. A aplicação iniciou como uma estrutura simples e foi refatorada para suportar crescimento sustentável, preparando o terreno para implementação com JDBC, JPA e Spring Boot.

Além do objetivo técnico, o projeto poderá evoluir para auxiliar no gerenciamento de pedidos da sorveteria da minha irmã, servindo como aplicação prática do que está sendo desenvolvido.

---

## 🎯 Objetivo do Projeto

Este projeto tem como finalidade:

- Consolidar conhecimentos em orientação a objetos
- Aplicar princípios arquiteturais inspirados em Clean Architecture
- Praticar desacoplamento entre regras de negócio e infraestrutura
- Servir como ponte para aprendizado de JDBC, JPA e Spring Boot
- Evoluir gradualmente para uma API REST

O sistema começou como laboratório de estudo e está sendo evoluído de forma incremental.

---

## 🏗 Arquitetura

O projeto está estruturado em camadas:

- `domain` → Entidades, regras de negócio, enums e exceções
- `usecase` → Orquestração das ações do sistema
- `repository` → Interfaces que definem contratos de persistência
- `infra` → Implementação atual de persistência em memória
- `ui` → Interação via console

### Princípios aplicados

- Separação clara de responsabilidades
- Dependência de abstrações (use cases dependem de interfaces)
- Regras de negócio concentradas no domínio
- Infraestrutura desacoplada da lógica principal

---

## 🚀 Funcionalidades Atuais

- Cadastro de clientes
- Validação básica de autenticação
- Criação de pedidos
- Associação de produtos ao pedido
- Estrutura preparada para evolução da persistência

---

## 🛠 Tecnologias Utilizadas

### Atualmente
- Java 17
- Programação Orientada a Objetos
- Arquitetura em camadas
- Persistência em memória

### Planejadas
- JDBC
- JPA (Hibernate)
- Spring Boot
- PostgreSQL
- MySQL
- Testes unitários (JUnit)
- API REST

---

## 🔄 Roadmap

- [ ] Implementação com JDBC (MySQL)
- [ ] Migração para JPA
- [ ] API REST com Spring Boot
- [ ] Implementação de testes unitários
- [ ] Integração com frontend simples
- [ ] Implementação de desconto para clientes VIP
- [ ] Sistema de frete
- [ ] Evolução da autenticação

---

## ⚙️ Decisões Técnicas

Persistência em memória foi adotada como ponto de partida, servindo como marco arquitetural antes da introdução de banco de dados relacional.

A geração de ID foi movida para a camada de repositório, antecipando futura integração com banco de dados.

Foi criada uma `BusinessRuleException` para diferenciar falhas de regra de negócio de erros técnicos do sistema.

---

## 📚 Aprendizados

Durante o desenvolvimento, o projeto passou por uma mudança estrutural significativa.

Inicialmente, todas as classes estavam concentradas em uma única pasta, o que dificultava manutenção e crescimento. A reorganização em camadas marcou um ponto de virada, tornando o sistema mais previsível e sustentável.

Entre os principais aprendizados:

- Importância da separação de responsabilidades
- Benefícios do desacoplamento via interfaces
- Posicionamento correto das regras de negócio
- Diferença entre erro técnico e violação de regra
- Planejamento arquitetural antes do crescimento

O projeto representa uma transição de código funcional para código estruturado.

---

## ▶️ Como Executar

### Pré-requisitos
- JDK 17

### Passos

git clone <URL_DO_REPOSITORIO>
Abrir o projeto na IDE (preferencialmente IntelliJ) e executar a classe Main.
A aplicação é configurada automaticamente e inicia via console.

📌 Status

Projeto em evolução contínua, utilizado como laboratório técnico e futura aplicação prática.