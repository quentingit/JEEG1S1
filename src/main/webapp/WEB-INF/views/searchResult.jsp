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
	            <li ><a href="<c:url value="/" />">Home</a></li>
	            <li><a href="<c:url value="/users" />">Users</a></li>
	            <li><a href="<c:url value="/subjects" />">Subjects</a></li>
	            <li><a href="<c:url value="/mark" />">Teacher</a></li>
	          </ul>
	        </div>   			      		 
	  </div>
	</div>


<div class="col-lg-12">
	  
	  <br><br><br>
	
	   <fieldset>
	    <legend>Recherche :  </legend>
	    <table class=" table ">
	      <tr>
	        <th>Name</th>
	        <th>Mail</th>
	        <th>Notes</th>
	      </tr>
	      <c:forEach items="${users}" var="user">
	        <tr>
	          <td><u>${user.name} </u></td>
	          <td><u>${user.email}</u></td>
	          <td>
	          <c:forEach items="${user.studentNote}" var="mark">
			       ${mark.mark} - ${mark.note_formation.name}</br>			              		
			  </c:forEach>
			  </td>
	        </tr>
	        <br/> <br/>
           
	      </c:forEach>
	
	    </table>
	  </fieldset>
	</div>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>