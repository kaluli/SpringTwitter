<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<title>Perfil</title>
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
				<li><a href="micuenta.html">Mi cuenta</a></li>			
				<li><a href="notificaciones.html">Notificaciones</a></li>			
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
				<li><a href="logout.html">Cerrar Sesi�n</a></li>				 				
			</ul>
			
		</div>
		<!-- /.nav-collapse -->
	</div>

	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-3" id="cuadro">
					<c:if test="${not yomismo}">
						<span id ="seguir">
						<c:if test="${losigues}">
						<a href="${pageContext.request.contextPath}/perfil.html?id=${usuario.id}&action=dejarseguir">						
						Dejar de Seguir</a>
						</c:if>
						<c:if test="${not losigues}">
						<a href="${pageContext.request.contextPath}/seguir.html?id=${usuario.id}">						
						Seguir</a>						
						</c:if>
						</span>
						
					</c:if>													
					<c:if test="${yomismo}">
						Mi cuenta
					</c:if>													
					
					<br/><strong>${usuario.nombre} ${usuario.apellido}</strong>
					<br/><p>@${usuario.usuario}</p>
					<br/>Mensajes: ${mensajes}
					<br/>Seguidores: <a href="seguidores.html?idusuario=${usuario.id}">${seguidores}</a>
					<br/>Siguiendo: <a href="siguiendo.html?idusuario=${usuario.id}">${siguiendo}</a>
					
									
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
							<c:if test="${fn:contains(mensaje.texto, '@')}">
   							<a href="perfil.html?id=${mensaje.idDestino}">${mensaje.texto}</a>							
   							</c:if>
   							
							<c:out value="${mensaje.texto}"/><br/>							
							
							<div class="imagenes">
								<c:if test="${yomismo}">
								<a href="perfil.html?action=delete&idmensaje=${mensaje.id}"><img src="assets/img/delete.png"></a>
								</c:if>							
								<c:if test="${not yomismo}">
								<a href="perfil.html?action=retwittear&idmensaje=${mensaje.id}&id=${usuario.id}"><img src="assets/img/retwitt.png"></a>
								</c:if>															
							</div>			
							</div>
						</c:forEach>
				</div>
				<div class="col-md-3" id="cuadro">
					<c:if test="${yomismo}">
					<h2>Escribe algo</h2>
					</c:if>
					<c:if test="${not yomismo}">
					<h2>Twittear</h2>
					</c:if>							
					 <form:form id="enviaMensaje" method="post" class="bs-example form-horizontal" commandName="mensaje" >				
						<div class="form-group">			
							<c:if test="${yomismo}">							
							<form:input type="text" class="form-control" path="texto"
							id="textoInput" placeholder="�Qu� estas pensando?" />
							<form:errors path="texto" cssClass="error" />
							</c:if>
							<c:if test="${not yomismo}">							
							<form:input type="text" class="form-control" path="texto"
							id="textoInput" value="@${usuario.usuario} " placeholder="Escribile a ${usuario.usuario}" />
							<form:errors path="texto" cssClass="error" />
							</c:if>							
						</div>						
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
										<p>Est� seguro?</p>
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
					</form:form>						
                </div>				     
	  	  	</div>					  
				
		</div>		
	</div>		
	
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Inicio de sesi�n con exito</h3>
		</div>
		<div class="panel-body">
		<div class="alert alert-dismissable alert-success">
              <button type="button" class="close" data-dismiss="alert">a</button>
              <strong>Bien!</strong> El inicio de sesi�n fue satisfactorio.
              Bienvenido  
            </div>
		</div>
	</div>
	<div></div>
	<div></div>
	<a class="btn btn-primary" href="<spring:url value="login.html"/>">Iniciar sesi�n 
	con un usuario diferente?</a>

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