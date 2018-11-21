# Dados importantes

Recomendacao: https://6h3yzrpuwj.execute-api.sa-east-1.amazonaws.com/v1/recommend?city=
Maps API Key `AIzaSyDdXLUyZosLC8fQftguJ-F953J_ANTQQ5A`


## Contratos da API

`/dish-list/:lat/:lon`
Recupera uma lista de pratos com base nos dados de lat/long enviados pelo aplicativo.

Parametros:
- :lat - latitude
- :lon - longitude

Retorna:
- Array com os nomes dos pratos desse tipo de cozinha

Exemplo:
```
[
    "Pizza de mussarela",
    "Hamburger simples"
]
```

`/dish-detail/:dish`
Recupera os detalhes de um determinado prato

Parametros:
- :dish - nome do prato

Retorna:
Um objeto contendo o nome do restaurante daquele prato e o nome do prato

Exemplo:
```
{
    restaurant: "Pizza Hut Limao",
    dish: "Pizza Supreme"
}
```