primero ejecute git clone https://github.com/pabloOcanto/candidates

En la carpeta donde se descargo el proyecto abra una terminal y escriba mvn spring-boot:run

y seguido con la opcion -D ingrese la variables de entorno host, port , db_name, user y password

Utilice una herramienta como PostMan para realizar request al siguiente endpoint localhost:9091/canidato/

Para crear un candidato utilice el metodo POST y el candidato pasado en formato json, las propiedas del candidato son:
    - dni
    -nombre (Referencia al nombre completo)
    -domicilio
    -telefono
    -mail

Para actualizar utilice el prefijo PUT, y eliminar DELETE.

Si quiere realizar una consulta de busqueda, al endpoint agregue search a la url y como parametro pase el nombre o dni.

Ejemplo:
 - localhost:9091/canidato/search/name?parameter="nombre del candidato"
 - localhost:9091/canidato/search/dni?parameter="documento"
 
En caso de no pasar ningun parametro a search retornara todos los canidatos paginados del 0 al 10.

    