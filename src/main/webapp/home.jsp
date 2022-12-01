<%@page import="model.entities.Categoria"%>
<%@page import="model.entities.Chiste"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<% 
  	ArrayList<Chiste> chistes = (ArrayList<Chiste>)session.getAttribute("bicis");
  	ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("marcas");
  	
  	%>
<head>
    <title>Chistes</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container">

        <nav class="navbar navbar-expand-lg  bg-nav">
            <a class="navbar-brand" href="#">
                <img src="img/logo (2).png" alt="logo">
            </a>

            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">


                </ul>
                <h1 class="text-white">Azarquiel</h1>
            </div>
        </nav>
            <div class="card flex-fill">
               
                <div class="card-body">
                    <h4 class="card-title text-center bg-nav text-white estrechar">Por Categorias</h4>
                    <form class ="estrechar mb-2"action="Controller?op=vamarca" method="post">

                        <select class="form-control " name="marca" id="marca" onchange="this.form.submit()">
                            <option value="" disabled selected class="text-center">Elija marca</option>
                            <option value="%">Todas</option>
                            <%
                  	for (Categoria marca:categorias){%>
                  		<option value="<%=marca.getId() %>"><%=marca.getNombre() %></option>
                  <%}
                  %>

                        </select>
                        

                    </form>
                   <% for (Chiste chiste:chistes){%>
                    <div class="card flex-fill">
                        <div class="card-body gris">
                            <h4 class="card-title text-white"><%=chiste.getTitulo() %>
                            <%for(int i=0; i < 5; i++){ %>
											<% String color = i < chiste.getPuntos() ? "text-warning" : "text-muted"; %>
											<span class="<%=color%>"><i class="fa fa-star text-center" aria-hidden="true"></i></span>
											<%} %></h4> 	
                            <p class="card-text text-white"><%=chiste.getDescripcion() %></p>
                            <span class="display-4 text-secondary">&#9733;</span> <span class="display-4 text-secondary">&#9733;</span>
                            <span class="display-4 text-secondary">&#9733;</span> <span class="display-4 text-secondary">&#9733;</span>
                            <span class="display-4 text-secondary">&#9733;</span>
                            
                        </div>
                    </div>
                    <%} %>
                </div>
                
            </div>
    </div>
        
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>