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
	            <li class="active"><a href="<c:url value="/mark" />">Teacher</a></li>
	          </ul>
	        </div>   			      		 
	  </div>
	</div>	


<div class="col-lg-12">
		<br/><br/><br/><br/>
	  <fieldset>
	    <legend>Add Mark</legend>
	    <form:form class="form" action="addmarkuser" method="post"  commandName="all" >
	      <table class="table table-striped">
	        <tr>
	          <th>User</th>
	          <th>Mark</th>
	          <th>Subject</th>
	          <th></th> 
	          <tr>
		          <td>
						
					  <form:select  path="user.id"> 
			            <form:option value="" label="select"> -----  </form:option>  
			            
			             <c:forEach items="${users}" var="user">
			                     <form:option value="${user.id}" label="select"> ${user.name} </form:option>            
			             </c:forEach>   
			                
			 		   </form:select>
		             
		          </td>
		          <td>
				        <form:input path="mark.mark" />  /20	          
		          </td>
		          <td>
		                <form:select  path="subject.id"> 
			            <form:option value="" label="select"> -----  </form:option>  
			            
			             <c:forEach items="${subjects}" var="subject">
			                     <form:option value="${subject.id}" label="select"> ${subject.name} </form:option>            
			             </c:forEach>   
			                
			 		   </form:select>
		          
		          </td>
		          <td><button class="btn-primary"type="submit">Submit</button></td>
	           </tr>
	      	   </table>
	          
	    
	    </form:form>
	  </fieldset>




	  <fieldset>
	    <legend>Mark List</legend>
	    <table class="table">
	      <tr>
	        <th>Id</th>
	        <th>Name</th>
	        <th>Email</th>
	        <th>Note</th>
	      </tr>
	      <c:forEach items="${users}" var="user">
	       <tr>
	          <td>${user.id} </td>
	          <td>${user.name} </td>
	          <td><i>${user.email} </i></td>
	          
	          <td>
	          <c:forEach items="${user.studentNote}" var="mark">        
			     
			      ${mark.mark} - ${mark.note_formation.name} - ${mark.id}
			      <form:form class="form" action="deletemark" method="post" modelAttribute="mark">       
			        <form:hidden path="id" value="${mark.id}"  />
			        <button class="btn-primary"type="submit">Delete</button>
				  </form:form>  
				  
			       <br/>              	
			  </c:forEach>
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