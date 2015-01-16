<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Binder – let's read!</title>

<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap-table.min.css" rel="stylesheet">


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
				<li><a href="users_list.jsp">Users</a></li>
				<li><a href="#">Catalog</a></li>
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
					data-toggle="dropdown" role="button" aria-expanded="false">Me <span
						class="caret"></span>
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
	<!-- /.container-fluid --> </nav>
	<a href="catalog.jsp"><button type="button"
				class="btn btn-primary" aria-label="Left Align">
				<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
				Back to books list
			</button></a>
	<div style="margin: 10px; float:right; max-width:55%;vertical-align:top;">
	<h3>Last evaluations</h3>
	<table data-toggle="table">
			<thead>
				<tr>
					<th data-field="Date">Date</th>
					<th data-field="Username">Username</th>
					<th data-field="Quality">Quality of writing</th>
					<th data-field="Interest">Interest</th>
					<th data-field="End">End</th>
					<th data-field="Other">Same author</th>
					<th data-field="Recommend">Recommend</th>
					<th data-field="Global">Global note</th>
					<th data-field="Remove"></th>
				</tr>
			</thead>
			<tr>
				<td>12-21-2014</td>
				<td><a href="user_info_admin.jsp">jean</a></td>
				<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span></td>
				<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></td>
				<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span></td>
				<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></td>
				<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span></td>
					<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span> <span
					class="glyphicon glyphicon-star" aria-hidden="true"></span></td>
				<td><span class="glyphicon glyphicon-minus" aria-hidden="true"></td>
			</tr>
		</table>
	</div>
	<div style="margin: 10px; max-width:40%;vertical-align:top;">
		
		<h3>Book details</h3>
		<form role="form">
			<div class="form-group">
				<label for="ISBN">ISBN:</label> <input type="email"
					class="form-control" id="email" value="9782070619177">
			</div>
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title"
					value="Harry Potter, Tome 1 : Harry Potter Ã  L'Ã©cole Des Sorciers : Edition De Luxe">
			</div>
			<div class="form-group">
				<label for="author">Author:</label> <input type="text"
					class="form-control" id="author" value="Rowling, J-k">
			</div>
			<div class="form-group">
				<label for="publication">Publication date:</label> <input
					type="date" class="form-control" id="publication"
					value="06-29-1997">
			</div>
			<div class="form-group">
				<label for="editor">Editor:</label> <input type="text"
					class="form-control" id="editor" value="Gallimard">
			</div>
			<div class="form-group">
				<label for="genre">Genre:</label> <input type="text"
					class="form-control" id="genre" value="Fantastique">
			</div>
			<button type="submit" form-action="welcome-page.jsp"
				class="btn btn-primary">Submit</button>
			<button type="button" class="btn btn-danger">Delete book</button>
		</form>
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/bootstrap-table.min.js"></script>
</body>
</html>