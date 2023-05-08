### Acerca de la funcionalidad expuesta
Crea un cliente en la base de datos.

### URI de acceso a la API
| Método | URI             |
|--------|-----------------|
|POST| /api/v1/cliente |


##### Trama Request

```javascript
{
    "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```
