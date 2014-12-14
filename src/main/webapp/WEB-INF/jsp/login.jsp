<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<!-- Main Container -->
    <div class="container">
      <div class="row">
      	<div>
			<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/j_spring_security_check">
				<div class="control-group">
					<label class="control-label" for="inputEmail">Email</label>
					<div class="controls">
						<input type="text" id="j_username" placeholder="email"
							name="j_username">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">Password</label>
					<div class="controls">
						<input type="password" id="j_password" placeholder="password"
							name="j_password">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<label class="checkbox">
							<input id="rememeberMe" type="checkbox" name="_spring_security_remember_me">
							Remember me
						</label>
						<button type="submit" class="btn">Sign in</button>
						<p>
							<font color="red">${error}</font>
						</p>
					</div>
				</div>
			</form>
			</div>
		</div>
      <footer>
        <p class="text-center muted ">&copy; Copyright 2013 - ttd</p>
      </footer>
    </div>
	<!-- Main Container Ends -->

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
        var contexPath = "<%=request.getContextPath() %>";
    </script>
	
  </body>
</html>


