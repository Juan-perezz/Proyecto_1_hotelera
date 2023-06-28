
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
            <h1>FORMULARIO DE HABITACION</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="habitaciones"/>

            </jsp:include>
            <br>
            <form action="HabitacionControlador" method="post">
                <input type="hidden" name="id_habitacion" value="${habitacion.id_habitacion}">
                <div class="form-group">
                    <label for="" class="form-label">Numero Habitacion</label>
                    <input type="text" class="form-control" name="numero_habitacion" value="${habitacion.numero_habitacion}" placeholder="Numero de Habitacion">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value="${habitacion.descripcion}" placeholder="escriba una descripcion">
                </div>
                
                <div class="form-group">
                    <label for="" class="form-label">Maximo de Ocupantes</label>
                    <input type="text" class="form-control" name="max_ocupantes" value="${habitacion.max_ocupantes}" placeholder="Maximo de Ocupantes">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Precio</label>
                    <input type="text" class="form-control" name="precio" value="${habitacion.precio}" placeholder="Escriba su Precio">
                </div>
               
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>