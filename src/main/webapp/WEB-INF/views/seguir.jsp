<%@ include file="/WEB-INF/views/header.jsp" %>  
<title>Seguir</title>
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
				<li class="active"><a href="perfil.html"><%= session.getAttribute("usuarioSession") %> </a></li>				
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
		<div class="busqueda">
			
			<div class="row">				 
				<div class="col-md-5" id ="seguidores">
						<h2>Busca un usuario</h2>			
						<c:forEach var="usuario" items="${usuarios}">
						<div>
							<p>
							<a href='verPerfil.html?id=<c:out value="${usuario.id}"/>'>
							${usuario.nombre} ${usuario.apellido} (@${usuario.usuario}) </a>
							<span id ="seguir"> 
							<a href="${pageContext.request.contextPath}/seguir.html?id=${usuario.id}">
							Seguir</a>
							</span>
							</p> 
		                </div>
						</c:forEach>
		  	  	</div>					  
				<div class="col-md-4">
				 ${mensaje}
				</div>
			</div>		
			
		</div>		
	</div>
	<div align="center">
		<a class="btn btn-primary" href="<spring:url value="logout.html"/>">Iniciar sesión 
	con un usuario diferente?</a>
	</div>
	
		<div class="panel-body">
		<div class="alert alert-dismissable alert-success">
              <button type="button" class="close" data-dismiss="alert">Ocultar Consejo</button>
              Hacé click en <strong>Seguir</strong> para estar al tanto de todas las noticias de tus usuarios de interés.  
            </div>
		</div>
	<div></div>
	<div></div>


	
  
<%@ include file="/WEB-INF/views/footer.jsp" %>
