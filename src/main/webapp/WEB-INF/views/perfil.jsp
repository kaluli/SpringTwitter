<%@ include file="/WEB-INF/views/header.jsp" %>  
<title>Mi Cuenta</title>
<script src="jquery-1.8.3.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>	 
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
				<li class="active"><a href="perfil.html"><%= session.getAttribute("usuarioSession") %></a></li>				
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
				<div class="col-md-3" id="cuadro">
					<h2>Mi cuenta</h2>
					<br/><strong>${usuario.nombre} ${usuario.apellido}</strong>
					<br/><p>@${usuario.usuario}</p>
					<br/>Mensajes: 2
					<br/>Seguidores: <a href="seguidores.html">${seguidores}</a>
					<br/>Siguiendo: <a href="siguiendo.html">${siguiendo}</a>
					
									
				</div>
				<div class="col-md-6" id="cuadro">	
					<h2>Mensajes</h2>					
					<c:forEach var="mensaje" items="${usuario.mensajes}">
						<div id="mensaje">
							<a href="perfil.html?id=${usuario.id}"><c:out value="${usuario.nombre}"/> 
									<c:out value="${usuario.apellido}"/> 
							</a>		
							<span id="usuario">@<c:out value="${usuario.usuario}"/></span> -
						 	<fmt:formatDate value="${mensaje.fecha}" pattern="dd/MM/yyyy HH:mm" />						
							<br/>
							<c:out value="${mensaje.texto}"/><br/>
							<div class="imagenes">
								<a href="#"><img src="assets/img/reply.png"></a>
								<c:if test="${yomismo}">
								<a href="perfil.html?action=delete&idmensaje=${mensaje.id}"><img src="assets/img/delete.png"></a>
								</c:if>							
								<c:if test="${not yomismo}">
								<a href="#"><img src="assets/img/retwitt.png"></a>
								</c:if>															
							</div>			
							</div>
						</c:forEach>
				</div>
				<div class="col-md-3" id="cuadro">
					<h2>Escribe algo</h2>							
					 <form:form id="enviaMensaje" method="post" class="bs-example form-horizontal" commandName="mensaje" >				
						<div class="form-group">										
							<form:input type="text" class="form-control" path="texto"
							id="textoInput" placeholder="¿Qué estas pensando?" />
							<form:errors path="texto" cssClass="error" />							
						</div>						
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#themodal">Enviar</button>
						<button class="btn btn-default">Cancelar</button>						
						<div id="themodal" class="modal fade" data-backdrop="static">									
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h3>Enviar Mensaje</h3>
									</div>
									<div class="modal-body">
										<p>Está seguro?</p>
										<div class="progress progress-striped active">
											<div id="doitprogress" class="progress-bar"></div>
										</div>
									</div>
									<div class="modal-footer">
										<a href="#" class="btn btn-default" data-dismiss="modal">Cerrar</a>
										<input type="submit" value="Si" id="yesbutton"
											class="btn btn-primary" data-loading-text="Guardando.."
											data-complete-text="Mensaje Enviado!">
									</div>
								</div>
							</div>
						</div>
						<div><h3>A quién seguir</h3></div>
					</form:form>						
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
	
	<br/><br/>Tag al escribir en el perfil de otro usuario y con @		
	<br/><br/>Busqueda  Seguir, crear BD y opcion Seguir	
	<br/><br/>Mi cuenta  
	<br/>  Retwittear
	<br/>  Responder
	<br/> Hacer Notificaciones -> Tiene un nuevo seguidor
	<br/> Hacer Mi cuenta -> Cambiar nombre y contraseña VER MD5    
	<br/> Recuperar contraseña    VER MD5
	<br/> Leer acerca de Servicios -> y repository
	<br/> Crear regla de url amigables en bean xml
	<br/>   @Autowired - @Override - @Transactional
	<br/>  Anotaciones, como se hacen - Leer acerca de reflexion
	
	<script type="text/javascript">
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");		
			
			yesButton.click(function() {		
				yesButton.button("loading");

				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};
				
				setTimeout(countDown, 100);
			});
			
		});
	</script>
	

</body>
</html>