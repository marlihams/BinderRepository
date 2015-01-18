<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Binder – let's read!</title>

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
<body id="test">
<div id="corps">
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> <span class="icon-bar"></span> 
				<span	class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img alt="logo_binder"
				src="<c:url value="/images/logo_binder.png"/>" height="30px"></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li ><a href="<c:url value="/userProfile"/>">Home</a></li>
				<li><a href="my_books.jsp">My books</a></li>
				<li><a href="evaluations.jsp">My evaluations</a></li>
				<li><a href="my_matches.jsp">My matches</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Me <span
						class="caret"></span>
				</a></li>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">My profile</a></li>
						<li><a href="#">Security details</a></li>
						<li><a href="#">Other settings</a></li>
						<li class="divider"></li>
						<li><a href="#">Disconnect</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

		<h1>Overview</h1>
		<!-- <div id="imageBook" class="contenu"> -->
		<div id="imageBook" class="contenu">
				<img alt="Harry Potter" src="<c:url value="http://ecx.images-amazon.com/images/I/51MU5VilKpL.jpg" />"/>
				<img alt="The Hobbit" src="<c:url value="http://ecx.images-amazon.com/images/I/61-pkWxzvbL.jpg"/>"/>
				<img alt="H2G2" src="<c:url value="http://ecx.images-amazon.com/images/I/51RfX8a24oL.jpg" />" />
				<img alt="Millenium" src="<c:url value="http://ecx.images-amazon.com/images/I/71LzPtVof3L.jpg"/>"/>
				<img alt="anges-demons" src="<c:url value="/images/anges-demons.jpg" />"/>
				<img alt="assasin" src="<c:url value="/images/assasin-creed.jpg" />"/>
				<img alt="harry-potter" src="<c:url value="/images/harry-potter.jpg" />"/>
		</div>
		<div > <!-- class="acceuilForm" -->
		<p >
		Welcome on Binder, <strong><em><c:out value="${sessionScope.username}" /></em></strong>
		</p>
		<div class="panel panel-default section">
  		<div class="panel-heading">Adding a new Book</div>
 		 <div class="panel-body">
		
		<form role="form"  method="post" action="<c:url value="/userBook" />">
		<c:if test="${form.errors.isEmpty() }">
					<div class="alert alert-success" role="alert">Your book has been added please go to your user Profile  and look for it if you want to read it  </div>
				</c:if>
				
			<div class="form-group">
			<c:if test="${form.errors['isbn']!=null}">
					<div class="alert alert-danger" role="alert">${form.errors['isbn'] }</div>
				</c:if>
				<label for="isbn">ISBN:</label> <input type="text" name="isbn"  class="form-control" id="isbn" />
			</div>
			<div class="form-group">
			<c:if test="${form.errors['title']!=null}">
					<div class="alert alert-danger" role="alert">${form.errors['title'] }</div>
				</c:if>
				<label for="title">Title:</label> <input type="text"  name="title"  class="form-control" id="title" />
			</div>
			
			
			<div class="form-group">
			<c:if test="${form.errors['author']!=null}">
					<div class="alert alert-danger" role="alert">${form.errors['author'] }</div>
				</c:if>
				<label for="author">Author:</label> <input type="text"  name="author" class="form-control" id="author">
			</div>
			
			<div class="form-group">
			<c:if test="${form.errors['genre']!=null}">
					<div class="alert alert-danger" role="alert">${form.errors['genre'] }</div>
				</c:if>
				<label for="genre">Genre:</label> <input type="text" name="genre" class="form-control" id="genre">
			</div>
			
			<button type="submit" name="addbook" value="true" class="btn btn-primary">Submit</button>
		</form>
		</div>
		</div> <!-- fermeture panel 1 -->
		
		 <c:if test="${!empty book.title && !form.errors.isEmpty()}"> 
		 <div class="panel panel-default section">
  		<div class="panel-heading">Evaluat a book</div>
 		 <div class="panel-body">
		 <div id="formEvaluation">
		<form  id="form2" action="<c:url value="/userProfile"/>" method="post">
		<table data-toggle="table">
		
				<tr>
					<th data-field="title">title</th>
					<th data-field="author">Author</th>
					<th data-field="isbn">ISBN</th>
					<th data-field="Quality">Quality of writing</th>
					<th data-field="Interest">Interest</th>
					<th data-field="End">Desire to read the end</th>
					<th data-field="readingAuthor">reading Author Book</th>
					<th data-field="Recommend">recommend to other</th>
					<th data-field="Global">Global note</th>
				</tr>
				<tr> 
					<td ><input type="text" value="<c:out value="${book.title}"/>" 	name="title" disabled /></td>
					<td ><input type="text" value="<c:out value="${book.auteur}"/>"  name="author" disabled  /></td>
					<td ><input type="text" value="<c:out value="${book.ISBN}"/>"   name="isbn" disabled /></td>
			
					<td>
						<select class="form-control"  name="qWriting" class="note">
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
						
						</select>	
					</td>
					<td>
						<select class="form-control"   name="iSubject" class="note" >
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
						</select>	
					</td>
					<td>
						<select class="form-control"  name="dEnd" class="note" >
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
						</select>	
					</td>
					<td>
						<select class="form-control"   name="dAuteur" class="note" >
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
						</select>	
					</td>
				
					<td>
						<select class="form-control"   name="recommend" class="note" >
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
						</select>	
					</td>
				<td>
						<select class="form-control"   name="completed" class="note">
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
						</select>	
					</td>
				</tr>
			</table>
			<br/>
			<button type="button" class="btn btn-primary formEval">Submit</button>
		 </form>
		 </div>
		 </div>
		 </div>
		 </c:if>
	</div>
	</div>
	<!-- </div> -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<c:url value="/js/jquery.js"/>"></script>
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap-table.min.js"/>"></script>
	
	<script src="<c:url value="/js/test.js"/>"></script>
</body>
</html>