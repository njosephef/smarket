<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ttd</title>
	<meta name="viewport" content="width=device-width,initial-scale=1" />
    
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.css"/>">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
  </head>

  <body>
    <%@ include file="NavigationBar.jsp" %>

    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div>
      	<div>
			<form:form  method="post" commandName="user" action="${pageContext.request.contextPath}/user/create">
				<table>
				<tr><td>First Name :</td>
				<td><form:input path="firstName" placeholder="Enter your first name" required="true" />
				<form:errors class="text-error" path="firstName"/>
				</td></tr>
				<tr><td>Last Name :</td>
				<td><form:input path="lastName" placeholder="Enter your last name" />
				<form:errors class="text-error" path="lastName"/>
				</td></tr>
				<tr><td>Email Address :</td>
				<td><form:input path="email" placeholder="Enter your mail" type="email" required="true" />
				<form:errors class="text-error" path="email"/>
				</td></tr>
				<tr><td>Password :</td>
				<td><form:input path="password" type="password" required="true" />
				<form:errors class="text-error" path="password"/>
				</td></tr>
				<tr><td>Mobile Number : </td>
				<td><form:input path="mobileNum" type="number" required="true" />
				<form:errors class="text-error" path="mobileNum" />
				</td></tr>
				<tr><td><input class="btn" type="submit" value="Submit"></td></tr>
				</table>
			</form:form>
			</div>
      </div>
		<footer>
        	<p class="text-center muted ">&copy; Copyright 2013 - ttd</p>
     	 </footer>
    </div> 
    
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
        var contexPath = "<%=request.getContextPath() %>";
    </script>
	
  </body>
</html>


