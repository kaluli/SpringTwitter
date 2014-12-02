<html>
<head>
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<style>
body {
	height: 100%;
	margin: 0;
	background-size: 1440px 800px;
	background-repeat: no-repeat;
	display: compact;
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
				<li class="active"><a href="#">Inicio</a></li>
				<li><a href="registro.html">Registro</a></li>
				<li><a href="login.html">Iniciar Sesión</a></li>				
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Final Programación II</h1>
				<p>Karina Pángaro</p>
				<p> QUE? <%= session.getAttribute("usuario") %> </p>
			</div>

			<a class="btn btn-primary" href="registro.html">Registro » </a> <a
				class="btn btn-primary" href="login.html">Iniciar sesión » </a>
		</div>
	</div>
	<script src="jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>

</body>
</html>
