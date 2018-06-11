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
	            <li class="active"><a href="<c:url value="/subjects" />">Subjects</a></li>
	            <li><a href="<c:url value="/mark" />">Teacher</a></li>
	          </ul>
	        </div>   			      		 
	  </div>
	</div>


<div class="col-lg-12">
<br/><br/><br/><br/>
	  <fieldset>
	    <legend>Add Subject</legend>
	    <form:form class="form" action="saveSubject" method="post" modelAttribute="subject">
	      <table class="table-striped table" >
	        <tr>
	          <th>Name</th>
	          <td>
	            <form:input path="name" /> 
	            <form:errors path="name" cssClass="error" />
	          </td>
	          <td><button class="btn-primary"type="submit">Submit</button></td>
	        </tr>
	      </table>
	    </form:form>
	  </fieldset>
	  <br>
	  <br>
	
	  <fieldset>
	    <legend>Subjects List</legend>
	    <table class="resltTable table">
	      <tr>
	        <th>Name</th>
	        <th>Modify</th>
	        <th>Delete</th>
	      </tr>
	      <c:forEach items="${subjects}" var="subject">
	        <tr>
	          
	          <!-- FORM TO UPDATE -->  
	            <form:form class="form" action="updatesubject" method="post" modelAttribute="subject">   
	          <td>  <form:input path="name" value="${subject.name}"/>  </td>
	          <td>          
			        <form:hidden path="id" value="${subject.id}"  />
			        <button class="btn-primary"type="submit">Modify</button>
		     </form:form>  
		     <!--  ENF FORM UPDATE -->    
	          </td>
			  <td>
			      <form:form class="form" action="deletesubject" method="post" modelAttribute="subject">       
			        <form:hidden path="id" value="${subject.id}"  />
			        <button class="btn-primary"type="submit">Delete</button>
				  </form:form>          
	          </td>
	          
	          
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