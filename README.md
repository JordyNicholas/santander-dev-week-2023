# santander-dev-week-2023
Java RESTful API criada para a Santander Dev Week 2023


## Diagrama de Classes 

``` mermaid
classDiagram
  class User {
    -name: string
      account: Account
      feature: Feature[]
      card: Card
      news: News[]
  }

  class Account {
    number: String
    agency: String
    balance: Float
    limit: Float
  }

  class Feature {
    icon: String
    description: String
  }

  class Card {
    number: String
    limit: Number
  }

  class News {
    icon: String
    description: String
  }

  User "1"*--"1" Account
  User "1"*--"N" Feature
  User "1"*--"1" Card
  User "1"*--"N" News

```

## OBSERVAÇÃO
O parâmetro distributionUrl do arquivo gradle/wrapper/gradle-wrapper.properties foi mantido na versão 8.3. 
Caso qualquer alteração seja necessária, mudar para a versão 7.6.1 trocando para o seguinte parâmetro:

distributionUrl=https\://services.gradle.org/distributions/gradle-7.6.1-bin.zip