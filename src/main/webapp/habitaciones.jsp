 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
        <title>Bootstrap demo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body>

        <div class="container">
            <h1>REGISTRO DE HABITACIONES</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="habitaciones"/>

            </jsp:include>
            <br>
            <a href="HabitacionControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
            <br>
            <table class="table table-success table-striped">
                <tr>
                    <th>Id Habitacion</th>
                    <th>Numero de habitacion</th>
                    <th>Descripcion</th>
                    <th>Maximo de Ocupantes</th>
                    <th>Precio</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${habitaciones}">
                <tr>
                    <td>${item.id_habitacion}</td>
                    <td>${item.numero_habitacion}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.max_ocupantes}</td>
                    <td>${item.precio}</td>
                    <td><a href="HabitacionControlador?action=edit&id_habitacion=${item.id_habitacion}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                    <td><a href="HabitacionControlador?action=delete&id_habitacion=${item.id_habitacion}" onclick="return(confirm('Estas seguro de eliminar'))"><i class="fa-solid fa-trash"></i></a></td>
                </tr>                    
                </c:forEach>
                
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>