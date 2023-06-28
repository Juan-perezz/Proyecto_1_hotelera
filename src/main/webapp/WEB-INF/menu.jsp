<%
    String opcion= request.getParameter("opcion");

%>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%=(opcion.equals("habitaciones") ? "active" : "")%> " href="HabitacionControlador">Habitacion</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=(opcion.equals("clientes") ? "active" : "")%> " href="ClienteControlador">Clientes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=(opcion.equals("reservas") ? "active" : "")%> " href="ReservaControlador">Reserva</a>
    </li>
    <li>-</li>
    <li>-</li>
     <li></li>
    <li class="nav-item">
                     <a href="Logout" class="btn btn-danger">SALIR</a>

    </li>

</ul>