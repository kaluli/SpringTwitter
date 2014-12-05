<%@ include file="/WEB-INF/views/header.jsp" %>  
<style>
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
<title>Recuperar contraseña</title>
</head>
<body>
	<script src="jquery-1.8.3.js">
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/programacionII">Inicio</a></li>
				<li><a href="registro.html">Registro</a></li>
				<li class="active"><a href="login.html">Iniciar Sesión</a></li>			
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<div class="container">
		<div class="row">
    	<div class="col-md-5 col-md-offset-4"><h1>Iniciar Sesión</h1> </div>	
		</div>
	</div><br/>
	<div class="form-login">
	<form:form id="myForm" method="post"
		class="col-md-6" commandName="usuarioLogin">
		<fieldset>
			Ingrese su Email
			<div class="form-group">				
			</div>
			<div class="row">
			 	<div class="col-md-8 col-md-offset-0">
			 	<form>
			 	<input type="text">	<br/><br/><button class="btn btn-primary">Enviar Email</button>
  				</div>
			 	</form>
			 	
			</div>
		</fieldset> 
	</form:form>
	<br/>			
	</div>
	
<%@ include file="/WEB-INF/views/footer.jsp" %>