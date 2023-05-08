# technical-exercise-client
Technical Exercise 

Microservicio basado en spring boot con documentacion swagger.

Endpoints disponibles:

1- Crea un cliente en la base de datos.

| Método | URI |
|--------|-----|
|POST|/api/cliente|

##### Trama Request

```javascript
{
    "name": "Juan",
    "lastName": "Perez",
    "age": "30",
    "birthDate": "13/02/1988"
}
```

2- Obtiene el promedio de edades de los clientes y la desviacion estandar.

| Método | URI |
|--------|-----|
|GET|/api/cliente/kpi|

3- Obtiene todos los clientes registrados con la fecha probable de muerte de cada uno de ellos

| Método | URI |
|--------|-----|
|GET|/api/cliente|
