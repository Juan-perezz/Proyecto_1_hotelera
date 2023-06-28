
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
            <h1>Formulario de Clientes</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>

            </jsp:include>
            <br>
            <form action="ClienteControlador" method="post">
                <input type="hidden" name="id_cliente" value="${cliente.id_cliente}">
                <div class="form-group">
                    <label for="" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" value="${cliente.nombres}" placeholder="Escriba sus nombres">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos" value="${cliente.apellidos}" placeholder="Escriba sus apellidos">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">CI</label>
                    <input type="text" class="form-control" name="ci" value="${cliente.ci}" placeholder="Escriba su CI">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Celular</label>
                    <input type="text" class="form-control" name="celular" value="${cliente.celular}" placeholder="Escriba su celular">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Direccion</label>
                    <input type="text" class="form-control" name="direccion" value="${cliente.direccion}" placeholder="Escriba su direccion">
                </div>
               
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>