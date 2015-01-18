<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8" />
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
				<li class="active"><a href="#">Home</a></li>
				<li><a href="<c:url value="/userBook" />">book Handler</a></li>
				<li><a href="#">My matches</a></li>
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
						<li><a href="<c:url value="/Binder/userProfile" />">My profile</a></li>
						<li class="divider"></li>
						<li><a href="#">Disconnect</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div id="overview">
	<h1>Overview</h1>
		<div id="imageBook" class="contenu">
			
				<img alt="Harry Potter" src="<c:url value="http://ecx.images-amazon.com/images/I/51MU5VilKpL.jpg" />"/>
				<img alt="The Hobbit" src="<c:url value="http://ecx.images-amazon.com/images/I/61-pkWxzvbL.jpg"/>"/>
				<img alt="H2G2" src="<c:url value="http://ecx.images-amazon.com/images/I/51RfX8a24oL.jpg" />" />
				<img alt="Millenium" src="<c:url value="http://ecx.images-amazon.com/images/I/71LzPtVof3L.jpg"/>"/>
				<img alt="anges-demons" src="<c:url value="/images/anges-demons.jpg" />"/>
				<img alt="assasin" src="<c:url value="/images/assasin-creed.jpg" />"/>
				<img alt="harry-potter" src="<c:url value="/images/harry-potter.jpg" />"/>
		</div>
		<p id="infoAcceuil">
		Welcome on Binder, <strong><em><c:out value="${sessionScope.username}" /></em></strong>
		</p>
		 <!-- zone recherche  -->
		
		<div class="input-group" id="recherche" >
		
 		 <div class="input-group-btn" id="infoSearch">  <!-- <span aria-hidden="true"></span> -->
 		
 		 <input type="text" class="form-control "  id="paramRecherche" placeholder="Search by author or isbn or name and validate..." />
		   <button type=button  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
		   		<span class="caret"></span>
		   	</button>
		   	<button class="btn btn-default" type="button">find a book </button>
		   		<ul class="dropdown-menu dropdown-menu-right " role="menu">
				      <li ><a class="linkRecherche" href="#" >title</a></li>
				      <li ><a class="linkRecherche" href="#" >isbn</a></li>
				      <li ><a  class="linkRecherche" href="">author</a></li>
		    </ul>
		  
		    </div> 
		    
		 </div>
		<h3>My Books read</h3>
		<table  class="table" data-toggle="table">
			<thead>
				<tr>
					<th data-field="Title">Title</th>
					<th data-field="ISBN">ISBN</th>
					<th data-field="Author">Author</th>
					<th data-field="Genre">Genre</th>
					<th data-field="Remove">Remove</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookLu}" var="book" varStatus="status">
			<tr class="cible">
				<td class="title"><c:out value="${book.title}"/></td>
				<td class="isbn"><c:out value="${book.ISBN}"/></td>
				<td class="auteur"><c:out value="${book.auteur}"/></td>
				<td class="genre"><c:out value="${book.genre}"/></td>
				<td class="remove"><button	class="btn btn-danger">Remove</button></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<h3>My valued Books</h3>
		<table class="table" data-toggle="table">
			<thead>
				<tr>
					<th data-field="Title">Title</th>
					<th data-field="Author">Author</th>
					<th data-field="ISBN">ISBN</th>
					<th data-field="Quality">writing Quality</th>
					<th data-field="Interest">Interest</th>
					<th data-field="End">reading to end</th>
					<th data-field="Other">reading Author</th>
					<th data-field="Recommend">Recommend</th>
					<th data-field="Global">Global Note</th>
					<th data-field="Change">Change</th>
				</tr>
			</thead>
			<tbody>
			<%-- <c:out value="${note.completed}" />--%>
				<c:forEach items="${evaluation}" var="note">
			<tr class="cibleEvaluation">
				<td class="title"><c:out value="${note.booktitle}"/></td>
				<td class="author"><c:out value="${note.auteur}"/></td>
				<td class="isbn"><c:out value="${note.isbn}"/></td>
				<td class="decoration"><c:out value="${note.qWriting}" /></td>
				<td class="decoration"><c:out value="${note.iSubject}" /></td>
				<td class="decoration"><c:out value="${note.dEnd}" /></td>
				<td class="decoration"><c:out value="${note.dAuteur}" /></td>
				<td class="decoration"><c:out value="${note.recommend}" /></td>
				<td class="decoration">
				<c:forEach var="i" begin="1" end="${note.completed}"  step="1" > 
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				</c:forEach>
				</td> 
				
				<td class="evaluation">
				<a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		
		 <!-- display the result of the search -->
		 
	 <div id="search">
		<h3>my Recherche Result</h3>
		
		<table class="table" data-toggle="table"  >
			<thead>
				<tr>
					<th data-field="Title">Title</th>
					<th data-field="ISBN">ISBN</th>
					<th data-field="Author">Author</th>
					<th data-field="Genre">Genre</th>
					<th data-field="Read">Read</th>
				</tr>
			</thead>
			<tbody id="repSearch"></tbody>
		</table>
	</div>
	</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="<c:url value="/js/jquery.js"/>" ></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/js/pagination.js"/>"></script>
	<script src="<c:url value="/js/binder.js"/>"></script>
</body>
</html>