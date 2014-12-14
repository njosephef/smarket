<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
	
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ttd</title>
	<meta name="viewport" content="width=device-width,initial-scale=1" />
    
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
    <link href="<c:url value="/resources/css/bootstrap-responsive.css"/>" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
  </head>

  <body>
  	<%@ include file="NavigationBar.jsp" %>
  		
    <div class="container" style="height: 500px">

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


