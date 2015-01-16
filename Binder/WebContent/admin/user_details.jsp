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
	<!-- /.container-fluid --> </nav>


	<h2>Admin page</h2>

	<p>Welcome on Binder, M. Admin.</p>
	<div style="margin: 10px;">
	<a href="users_list.jsp"><button type="button" class="btn btn-primary" aria-label="Left Align">
  <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> Back to users list
</button></a>
		<h3>His last reads</h3>
		<table data-toggle="table">
			<thead>
				<tr>
					<th data-field="Title">Title</th>
					<th data-field="Author">Author</th>
					<th data-field="Editor">Editor</th>
					<th data-field="Remove"></th>
				</tr>
			</thead>
			<tr>
				<td>Harry Potter and the Philosopher's Stone</td>
				<td>JK Rowling</td>
				<td>Bloomsbury</td>
				<td><span class="glyphicon glyphicon-minus" aria-hidden="true"></td>
			</tr>
			<tr>
				<td>The Hobbit</td>
				<td>JRR Tolkien</td>
				<td>Penguin's book</td>
				<td><span class="glyphicon glyphicon-minus" aria-hidden="true"></td>
			</tr>
		</table>
		<h3>His last evaluations</h3>
		<table data-toggle="table">
			<thead>
				<tr>
					<th data-field="Title">Title</th>
					<th data-field="Author">Author</th>
					<th data-field="Editor">Editor</th>
					<th data-field="Quality">Quality of writing</th>
					<th data-field="Interest">Interest</th>
					<th data-field="End">Desire to read the end</th>
					<th data-field="Other">Desire to read another book<br/>from the same author</th>
					<th data-field="Recommend">Desire to recommend it</th>
					<th data-field="Global">Global note</th>
					<th data-field="Remove"></th>
				</tr>
			</thead>
			<tr>
				<td>Harry Potter and the Philosopher's Stone</td>
				<td>JK Rowling</td>
				<td>Bloomsbury</td>
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
			<tr>
				<td>The Hobbit</td>
				<td>JRR Tolkien</td>
				<td>Penguin's book</td>
				<td>4</td>
				<td>2</td>
				<td>3</td>
				<td>1</td>
				<td>4</td>
				<td>2.5</td>
				<td><span class="glyphicon glyphicon-minus" aria-hidden="true"></td>
			</tr>
		</table>
		
		<h3>His last matches</h3>
		<table data-toggle="table">
			<thead>
				<tr>
					<th data-field="Username">Username</th>
					<th data-field="Email">E-mail address</th>
					<th data-field="Date">Date of match</th>
					<th data-field="Remove"></th>
				</tr>
			</thead>
			<tr>
				<td>jean</td>
				<td>jdupont@etu.utc.fr</td>
				<td>December 21th 2014</td>
				<td><span class="glyphicon glyphicon-minus" aria-hidden="true"></td>
			</tr>
		</table>
		
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/bootstrap-table.min.js"></script>
</body>
</html>