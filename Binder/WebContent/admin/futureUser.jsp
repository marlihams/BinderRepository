<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Binder – let's read!</title>

<!-- Bootstrap -->
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-table.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/binder.css"/>" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img alt="logo_binder"
				src="../images/logo_binder.png" height="30px"></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Users<span class="sr-only">(current)</span></a></li>
				<li><a href="catalog.jsp">Catalog</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Administration
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Statistics</a></li>
						<li><a href="#">Grant administration rights</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Me
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
					<li><a href="#">My profile</a></li>
					<li><a href="#">Security details</a></li>
					<li><a href="#">Other settings</a></li>
					<li class="divider"></li>
					<li><a href="#">Disconnect</a></li>
				</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	</nav>
	<!-- /.container-fluid --> </nav>
	<div style="margin: 10px;">
	<a href="<c:url value="/userList" />"><button type="button" class="btn btn-primary" aria-label="Left Align">
  <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> Back to users list
</button></a>
	<p>Create a new account</p>
		<form role="form"   method="post" action="<c:url value="/userList" />">
			<div class="form-group">
				<label for="pseudo">Username:</label> <input type="text" class="form-control" name="username" id="username" value="${user.username }">
			</div>
			<div class="form-group">
				<label for="email">Email address:</label> <input type="email" class="form-control" name="email" id="email" value="${user.email }">
			</div>
			<div class="form-group">
				<label for="telephone">Phone:</label> <input type="tel" class="form-control" name="telephone" id="telephone" name="telephone" value="${user.telephone}">
			</div>
			<div class="form-group">
				<label for="phone">Status:</label> <input type="text" class="form-control" name="status" id="status" value="${user.status}">
			</div>
			<div class="form-group">
				<label for="addresse">Address:</label> <input type="text" class="form-control" id="addresse" name="addresse" value="${user.addresse}">
			</div>
			
			
			<button type="submit" name="add" class="btn btn-primary">add</button>
			<button type="sbmit" class="btn btn-danger">delete</button>
		</form>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/js/pagination.js"/>"></script>
	<script src="<c:url value="/js/admin.js"/>"></script>
	<script src="<c:url value="/js/binder.js"/>"></script>
</body>
</html>