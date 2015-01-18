<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Binder – let's read!</title>
<!-- Bootstrap -->
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-table.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/binder.css"/>" rel="stylesheet">
</head>
<body id="test">
	<div id="corps">
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
				<img alt="logo_binder" id="imageAcceuil" src="<c:url value="/images/logo_binder.png"/>" />
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
	</nav>


	<%-- <img alt="logo_binder" src="<c:url value="/images/logo_binder.png"/>" /> --%>
	<div id="imageBook" class="contenu">
			
				<img alt="Harry Potter" src="<c:url value="http://ecx.images-amazon.com/images/I/51MU5VilKpL.jpg" />"/>
				<img alt="The Hobbit" src="<c:url value="http://ecx.images-amazon.com/images/I/61-pkWxzvbL.jpg"/>"/>
				<img alt="H2G2" src="<c:url value="http://ecx.images-amazon.com/images/I/51RfX8a24oL.jpg" />" />
				<img alt="Millenium" src="<c:url value="http://ecx.images-amazon.com/images/I/71LzPtVof3L.jpg"/>"/>
				<img alt="anges-demons" src="<c:url value="/images/anges-demons.jpg" />"/>
				<img alt="assasin" src="<c:url value="/images/assasin-creed.jpg" />"/>
				<img alt="harry-potter" src="<c:url value="/images/harry-potter.jpg" />"/>
		</div>
	<!-- <div class="acceuilForm"> -->
		<div class="panel panel-default section">
  		<div class="panel-heading">Log in </div>
 		 <div class="panel-body">
		<form role="form" method="post" action="<c:url value="/connexion"/>">
			<div class="form-group">
				<c:if test="${!empty form.errors['email']}">
					<div class="alert alert-danger" role="alert">${form.errors['email'] }</div>
				</c:if>
				<c:choose>
					<c:when test="${sessionScope.admin==true}">
					
						<c:redirect url="restricted/adminProfile"/>
					</c:when>
					<c:when test="${sessionScope.admin==false}">
					<p> FUCk You</p>
					<c:redirect url="/userProfile"/>
					</c:when>
				</c:choose>
				
				<label for="email">Email addresse:</label> <input type="email" name="email" class="form-control" id="email">
			</div>
			<c:if test="${!empty form.errors['password']}">
					<div class="alert alert-danger" role="alert">${form.errors['password'] }</div>
				</c:if>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password" name="password" class="form-control" id="pwd">
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<!-- <button type="button" class="btn btn-default">Forgot password</button> -->
		</form>
		</div>
		</div>
		
		<div class="panel panel-default section">
  		<div class="panel-heading"><span class="newAccount">Create account</span></div>
 		 <div class="panel-body">			
			<form role="form" method="post" action="<c:url value="/inscription" />">
			<c:if test="${form.errors.isEmpty() }">
					<div class="alert alert-success" role="alert">Your inscription was successful.you will get a confirmation by email</div>
				</c:if>
				<div id="formNewAccount">
			<div class="form-group">
			
				<c:if test="${form.errors['email']!=null}">
					<div class="alert alert-danger" role="alert">${form.errors['email'] }</div>
				</c:if>
				<label for="email">Email addresse:</label> <input type="email"
				value="<c:out value="${user.email}"/>"	name="email" class="form-control" id="email">
			</div>
		<c:if test="${form.errors['password']!=null }">
				<div class="alert alert-danger" role="alert">${form.errors['password'] }</div>
			</c:if>
			<div class="form-group">
				<label for="user_password">New password:</label> <input
					type="password" name="password" class="form-control"
					id="user_password">
			</div>

			<div class="form-group">
				<label for="user_password_confirmation">Confirm password:</label> <input
					type="password" class="form-control" name="confirmation"
					id="user_password_confirmation">
			</div>
			<c:if test="${form.errors['username']!=null }">
				<div class="alert alert-danger" role="alert">${form.errors['username'] }</div>
			</c:if>
			<div class="form-group">
				<label for="pseudo">Username:</label> <input type="username"
					value="<c:out value="${user.username}"/>" name="username" class="form-control" id="username">
			</div>
			
			
			<c:if test="${form.errors['addresse']!=null }">
				<div class="alert alert-danger" role="alert">${form.errors['addresse'] }</div>
			</c:if>
			<div class="form-group">
				<label for="addresse">addresse:</label> <input type="addresse" value="<c:out value="${user.addresse}"/>"
					name="addresse" class="form-control" id="addresse">
			</div>
			<c:if test="${form.errors['phone']!=null }">
				<div class="alert alert-danger" role="alert">${form.errors['phone'] }</div>
			</c:if>
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="tel" name="phone" value="<c:out value="${user.telephone}"/>"
					class="form-control" id="phone">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
		</div>
	</div>
	</div>
	<!-- </div> -->
	<script
		src="<c:url value="/js/jquery.js"/>"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/js/binder.js"/>"></script>
</body>
</html>