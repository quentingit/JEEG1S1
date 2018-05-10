<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JEEG1S1</title>


<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
	    		
<style type="text/css">


.error {
	color: red;
}


</style>


</head>
<body>

<div class="container">


	<div class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container">
	    <div class="navbar-header">                                   
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="#">School</a>
	        </div>
	        <div class="navbar-collapse collapse">  
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="<c:url value="/" />">Home</a></li>
	            <li><a href="<c:url value="/users" />">Users</a></li>
	            <li><a href="<c:url value="/subjects" />">Subjects</a></li>
	            <li><a href="<c:url value="/mark" />">Mark</a></li>
	          </ul>
	        </div>   			      		 
	  </div>
	</div>


<div class="col-lg-12">
	  <fieldset>
	    <legend>User Input From</legend>
	    <form:form class="form" action="saveMark" method="post" modelAttribute="mark">
	      <table class="table table-striped">
	        <tr>
	          <th>Mark</th>
	          <td>
	            <form:input path="mark" /> 
	            <form:errors path="mark" cssClass="error" />
	          </td>
	          <td><button class="btn-primary"type="submit">Submit</button></td>
	        </tr>
	      </table>
	    </form:form>
	  </fieldset>
	  <br>
	  <br>
	
	  <fieldset>
	    <legend>Mark List</legend>
	    <table class="resltTable">
	      <tr>
	        <th>Mark</th>
	      </tr>
	      <c:forEach items="${marks}" var="mark">
	        <tr>
	          <td>${mark.mark} / 20 </td>
	          
	          <c:forEach var="usr" items="${mark.user}">
			        <div style="padding-left:15px">Category id: ${usr.id}</div>
			    </c:forEach>
	          
	          <td>${mark.user.name}  </td>
	        </tr>
	      </c:forEach>
	
	    </table>
	    
	    
	       <table class="resltTable">
	      <tr>
	        <th>Name</th>
	        <th>Email</th>
	      </tr>
	      <c:forEach items="${users}" var="user">
	        <tr>
	          <td>${user.id}</td>
	          <td>${user.name}</td>
	          <td>${user.email}</td>
	        </tr>
	      </c:forEach>
	
	    </table>
	  </fieldset>
	</div>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>