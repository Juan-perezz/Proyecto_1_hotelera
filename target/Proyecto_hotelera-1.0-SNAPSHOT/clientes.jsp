
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
    <!--<link href="css/csss.css" rel="stylesheet" />-->
    
    </head>
    <body>
        
 
        
        
        

        <div class="container">
            <h1>REGISTRO DE CLIENTES</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>

            </jsp:include>
            <br>
            <a href="ClienteControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
            <br>
            <table class="table table-success table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombres</th>
                    <th>Apelldios</th>
                    <th>CI</th>
                    <th>Celular</th>
                    <th>Direccion</th>
                    <th></th>
                    <th></th>

                </tr>
                <c:forEach var="item" items="${clientes}">
                    <tr>
                        <td>${item.id_cliente}</td>
                        <td>${item.nombres}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.ci}</td>
                        <td>${item.celular}</td>
                        <td>${item.direccion}</td>
                        <td><a href="ClienteControlador?action=edit&id_cliente=${item.id_cliente}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="ClienteControlador?action=delete&id_cliente=${item.id_cliente}" onclick="return(confirm('Estas seguro de eliminar'))"><i class="fa-solid fa-trash"></i></a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>