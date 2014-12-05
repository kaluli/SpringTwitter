<%@ include file="/WEB-INF/views/header.jsp" %>  
<title>Buscar Usuarios</title>
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
				<li class="active">
				<c:choose>
				<c:when test="${logueado}"><a href="perfil.html"><%= session.getAttribute("usuarioSession") %></a></c:when>				
				<c:otherwise>
				<a href="login.html">Iniciar Sesión</a>
				</c:otherwise>
				</c:choose>				
			 	</li>				
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
				<li><c:if test="${logueado}"><a href="logout.html">Cerrar Sesión</a></c:if></li>				 				
			</ul>
			
		</div>
		<!-- /.nav-collapse -->
	</div>

	<div class="container">
		<div class="busqueda">
			
			<div class="row">				 
				<div class="col-md-5" id ="seguidores">
						<h2>Seguidores de ${usuario.nombre} ${usuario.apellido} </h2><br/>
						
						<c:forEach var="seguidor" items="${seguidores}">
						<div>
							<p>
								<a href='perfil.html?id=<c:out value="${seguidor.id}"/>'>
								${seguidor.nombre} ${seguidor.apellido} (@${seguidor.usuario}) </a>
							<c:choose>
								<c:when test="${seguidor.usuario != yomismo}">
								<span id ="seguir"> 
								<a href="${pageContext.request.contextPath}/seguir.html?id=${seguidor.id}">
								Seguir</a>
								</span>
								</c:when>
								<c:otherwise>
								<span id ="seguir"> 
								<a href="${pageContext.request.contextPath}/perfil.html?id=${seguidor.id}">
								Sigues a este usuario</a>
								</span>								
								</c:otherwise>				
							</c:choose>
    						</p> 
		                </div>
						</c:forEach>
						
		  	  	</div>					  
				<div class="col-md-4">
				 
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
