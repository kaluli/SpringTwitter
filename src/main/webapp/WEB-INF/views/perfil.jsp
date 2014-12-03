<%@ include file="/WEB-INF/views/header.jsp" %>  
<title>Mi Cuenta</title>
</head>
<body>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
									
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/programacionII">Inicio</a></li>				
				<li class="active"><a href="micuenta.html"><%= session.getAttribute("usuario") %> </a></li>				
				<li>
				<form:form modelAttribute="buscar" action="${pageContext.request.contextPath}/buscar.html" method="get">
				<div class="search-box">
						<input type="text" PlaceHolder="Buscar" name="buscar" />															
						<span id="search-image">
							<button class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-search" ></span>
	  						</button>
						</span>
					</div>
					</form:form>					
				</li>
				<li><a href="logout.html">Cerrar Sesión</a></li>				 				
			</ul>
			
		</div>
		<!-- /.nav-collapse -->
	</div>

	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-3">
					Mi cuenta
					<br/>${nombre} ${apellido}
					<br/><p>@${username}</p>
					<br/>Mensajes:
					<br/>Seguidores:
					<br/>Siguiendo: 				
				</div>
				<div class="col-md-6">
					<form >			 		  
	      		 	 	<textarea class="form-control" placeholder="Deja un mensaje" rows="4"></textarea>
	      		 	 	<div align="right"> 
							<button class="btn btn-primary" data-target="#themodal" data-toggle="modal">Enviar Mensaje</button>
						</div>
					</form>				
		  	  	</div>					  
				<div class="col-md-3">
					A quién seguir?
				</div>
			</div>		
		</div>		
	</div>
	
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Inicio de sesión con exito</h3>
		</div>
		<div class="panel-body">
		<div class="alert alert-dismissable alert-success">
              <button type="button" class="close" data-dismiss="alert">a</button>
              <strong>Bien!</strong> El inicio de sesión fue satisfactorio.
              Bienvenido  
            </div>
		</div>
	</div>
	<div></div>
	<div></div>
	<a class="btn btn-primary" href="<spring:url value="login.html"/>">Iniciar sesión 
	con un usuario diferente?</a>
	<br/><br/>Busqueda  HECHO
	<br/><br/>Busqueda  Seguir, crear BD y opcion Seguir	
	<br/><br/>Mi muro...Comentarios.. Mi cuenta  
	<br/> Hacer tabla de Comentarios -> idDe idPara Comentario 
	<br/> Hacer tabla de seguidores  -> idPropio IdSigueA
	<br/> Hacer Notificaciones -> Tiene un nuevo seguidor
	<br/> Hacer Mi cuenta -> Cambiar nombre y contraseña VER MD5    
	<br/> Recuperar contraseña    VER MD5
	<br/> Leer acerca de Servicios -> y repository
	<br/> que no se siga a si mismo
	<br/> Crear regla de url amigables en bean xml
  
<%@ include file="/WEB-INF/views/footer.jsp" %>
