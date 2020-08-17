# Stock-Trade-API-Hackerrank
This is a prototype for building a brokerage company's account and trades management platform. One Requirement is for a REST API service to manage trades using Spring Boot framework. Add functionality to add or delete transations as well as to perform some queries.


# Reach out to me

[<img align="left" alt="LinkedIn" width="22px" src="https://cdn.jsdelivr.net/npm/simple-icons@v3/icons/linkedin.svg" />](https://www.linkedin.com/in/sai-eshwar-reddy-bobbili/)
[<img align="left" alt="Gmail" width="22px" src="https://cdn.jsdelivr.net/npm/simple-icons@v3/icons/gmail.svg" />](<mailto:bobbilisaieshwarreddy@gmail.com>)

<br/>

 Each trade is a JSON entry with the following keys:

_id_: This is the trade unique ID.

_type_: This is the trade type, buy or sell.

_user_: The user responsible for the trade. The user itself is a JSON entry consisting of following fields:

_id_: This is the user unique ID.

_name_: This is the user name.

_symbol_: This is the stock symbol.

_price_: This is the stock price for one stock (upto two places of decimal) at the time of the trade. The stock price is between 130.42 and 195.65inclusive.

_timestamp_: This is the timestamp for the trade creation given in the format yyyy-MM-dd HH:mm:ss. The timezone is EST (UTC -4).

# Execution
```
# To build the project standard maven build is sufficient
mvn clean install

# To start/run the project spring boot maven plugin is included just run
mvn spring-boot:run

# The integration test may be executed using
mvn test
```

# Usage 
Once the application is started,

1. Erase all the trades, run below command in [cURL](https://en.wikipedia.org/wiki/CURL)
```
$curl -i -X DELETE http://localhost:8080/erase
````
2. Add a new trade,
```
$curl -X POST http://localhost:8080/trades/  -H "content-type: application/json"
-d "
    {
        "id": 1,
        "type": "buy",
        "user": {
            "id": 2,
            "name": "Amy Palmer"
        },
        "symbol": "AA",
        "shares": 11,
        "price": 174.82,
        "timestamp": "2018-12-28 13:18:48"
    }"
```
3. Return a trade filtered by ID, http://localhost:8080/trades/1 (1 -> id of trade).
4. http://localhost:8080/trades/ , return all trades the response should be sorted in ascending order by trade ID.
5.  Get all the trades filtered by USER ID,goto http://localhost:8080/trades/users/2 the response should be sorted in ascending order by trade ID.(2 -> id of user)
6. http://localhost:8080/trades/stocks/AA, return all the trades filtered by STOCK SYMBOL the response should be sorted in ascending order by trade ID. (AA -> stock symbol)
7. Return all the trades filtered by USER ID & STOCK SYMBOL the response should be sorted in ascending order by trade ID, http://localhost:8080/trades/users/2/stocks/AA (2 -> id of user, AA-> stock symbol).

