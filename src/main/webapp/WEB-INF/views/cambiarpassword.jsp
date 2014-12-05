<%@ include file="/WEB-INF/views/header.jsp" %>  
<title>Cambio de contraseña</title>
<link href="datepicker/css/datepicker.css" rel="stylesheet" />

<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
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
				<li class="active"><a href="registro.html">Registro</a></li>
				<li><a href="login.html">Iniciar Sesión</a></li>				
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<script src="jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>	 
	<script src="datepicker/js/bootstrap-datepicker.js"></script>


	<div class="container">
		<div class="row">
    	<div class="col-md-5 col-md-offset-4"><h1>Cambio de Contraseña</h1></div>	
		</div>
	</div>

	<c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>
	<div class="container">		
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<form:form method="post" class="bs-example form-horizontal" commandName="usuario">
							<fieldset>
								<legend>Cambiar contraseña</legend>

								<div class="form-group">
									<label for="usuarioInput" class="col-lg-3 control-label">Usuario</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="usuario"
											id="usuarioInput" placeholder="Usuario" />
										<form:errors path="usuario" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="passwordInput" class="col-lg-3 control-label">Contraseña</label>
									<div class="col-lg-9">
										<form:input type="password" class="form-control"
											path="password" id="passwordInput" placeholder="Password" />
										<form:errors path="password" cssClass="error" />
									</div>
									<label for="passwordInput" class="col-lg-3 control-label">Escriba de nuevo su contraseña</label>
									<div class="col-lg-9">
										<form:input type="password" class="form-control"
											path="password" id="passwordInput" placeholder="Password" />
										<form:errors path="password" cssClass="error" />
									</div>
								</div>
							
								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default">Cancelar</button>

									<button class="btn btn-primary" data-toggle="modal"
										data-target="#themodal">Guardar</button>
									<div id="themodal" class="modal fade" data-backdrop="static">									
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h3>Cambiar Contraseña</h3>
												</div>
												<div class="modal-body">
													<p>EstÃ¡ seguro?</p>
													<div class="progress progress-striped active">
														<div id="doitprogress" class="progress-bar"></div>
													</div>
												</div>
												<div class="modal-footer">
													<a href="#" class="btn btn-default" data-dismiss="modal">Cerrar</a>
													<input type="submit" value="Si" id="yesbutton"
														class="btn btn-primary" data-loading-text="Guardando.."
														data-complete-text="Registro Completo!">
												</div>
											</div>
										</div>
									</div>

								</div>

							</fieldset>
						</form:form>
					</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			$('#nacimientoInput').datepicker();
		});
	</script>

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