<%@ include file="/WEB-INF/views/header.jsp" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>							

<title>Mi cuenta</title>
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
				<li class="active"><a href="micuenta.html">Mi cuenta</a></li>			
				<li><a href="notificaciones.html">Notificaciones</a></li>				
				<li>
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
				<div class="col-md-4">
				 
				</div>				 
				<div class="col-md-6" >
						<h2>Mi cuenta</h2>		
						<form>	
						Usuario: ${usuario.usuario}<br/>
						Nombre: ${usuario.nombre}<br/>
						Apellido: ${usuario.apellido}<br/>
						Fecha de Nacimiento:
						<fmt:formatDate value="${usuario.nacimiento}" pattern="dd/MM/yyyy" /><br/>												
						Email: ${usuario.email}<br/>
		                Contraseña: ********** <a href="cambiarpassword.html">(Modificar Contraseña)</a><br/>
		                </form>
		              
		  	  	</div>					  
				<div class="col-md-2">
				 
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
              Ponga una contraseña segura.  
            </div>
		</div>
	<div></div>
	<div></div>


	
  
<%@ include file="/WEB-INF/views/footer.jsp" %>
