 
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
            <h1>REGISTRO DE RESERVAS</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="reservas"/>

            </jsp:include>
            <br>
            <a href="ReservaControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
            <br>
            <table class="table table-success table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre de Cliente</th>
                    <th>Numero de habitacion</th>
                    <th>Cantidad de habitaciones</th>
                    <th>Fecha de Entrada</th>
                    <th>Fecha de Salida</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${reservas}">
                <tr>
                    <td>${item.id_reserva}</td>
                    <td>${item.cliente}</td>
                    <td>${item.habitacion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.fecha_entrada}</td>
                    <td>${item.fecha_salida}</td>
                    <td><a href="ReservaControlador?action=edit&id_reserva=${item.id_reserva}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                    <td><a href="ReservaControlador?action=delete&id_reserva=${item.id_reserva}" onclick="return(confirm('Estas seguro de eliminar'))"><i class="fa-solid fa-trash"></i></a></td>
                </tr>                    
                </c:forEach>
                
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>