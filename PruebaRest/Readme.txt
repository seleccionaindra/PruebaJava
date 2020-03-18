Prueba servicio REST

GET http://localhost:8080/crud/obtenerPersonas

POST http://localhost:8080/crud/add
    {
        "cedula": "4543689",
        "nombres": "Erichdsad",
        "apellidos": "Gammadsa",
        "genero": "M",
        "edad": "26"
    }

PUT http://localhost:8080/crud/update

    {
        "cedula": "4543689",
        "nombres": "Erichdsad",
        "apellidos": "Gammadsa",
        "genero": "M",
        "edad": "26"
    }

DELETE http://localhost:8080/crud/delete/4543689