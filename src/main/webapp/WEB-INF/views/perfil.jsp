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
				<div class="col-md-3">
					Mi cuenta
					<br/>${usuario.nombre} ${usuario.apellido}
					<br/><p>@${usuario.usuario}</p>
					<br/>Mensajes: 2
					<br/>Seguidores: <a href="seguidores.html">${seguidores}</a>
					<br/>Siguiendo: <a href="siguiendo.html">${siguiendo}</a>
					
									
				</div>
				<div class="col-md-3">
					A quién seguir?
				</div>
				<div class="col-md-6">
					 <form:form id="enviaMensaje" method="post" class="bs-example form-horizontal" commandName="mensaje" >				
						<div class="form-group">										
							<form:input type="text" class="form-control" path="texto"
							id="textoInput" placeholder="Escribe un mensaje" />
							<form:errors path="texto" cssClass="error" />
							
							
							
						</div>
<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default">Cancelar</button>
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#themodal">Enviar</button>
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

								</div>
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