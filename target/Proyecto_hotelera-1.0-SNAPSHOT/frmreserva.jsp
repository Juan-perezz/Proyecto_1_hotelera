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
            <h1>FORMULARIO DE RESERVA</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="reservas"/>

            </jsp:include>
            <br>
            <form action="ReservaControlador" method="post">
                <input type="hidden" name="id_reserva" value="${reserva.id_reserva}">
                <div class="form-group">
                    <label for="" class="form-label">Nombre de cliente</label>
                    <select name="id_cliente" class="form-control">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_clientes}">
                            <option value="${item.id_cliente}" <c:if test="${reserva.id_cliente == item.id_cliente}">selected</c:if> >${item.nombres}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Numero de habitacion</label>
                    <select name="id_habitacion" class="form-control">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_habitacion}">
                            <option value="${item.id_habitacion}" <c:if test="${reserva.id_habitacion == item.id_habitacion}">selected</c:if> >${item.numero_habitacion}</option>
                        </c:forEach>
                        
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="" class="form-label">Cantidad de habitacion</label>
                    <input type="text" class="form-control" name="cantidad" value="${reserva.cantidad}" placeholder="Habitaciones a ocupar">
                </div>
                
                <div class="form-group">
                    <label for="" class="form-label">Fecha Entrada</label>
                    <input type="text" class="form-control" name="fecha_entrada" value="${reserva.fecha_entrada}" placeholder="Escriba la fecha">
                </div>
                
                <div class="form-group">
                    <label for="" class="form-label">Fecha Salida</label>
                    <input type="text" class="form-control" name="fecha_salida" value="${reserva.fecha_salida}" placeholder="Escriba la fecha">
                </div>
               
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>