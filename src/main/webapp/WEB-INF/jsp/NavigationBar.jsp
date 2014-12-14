<!-- Navigation Bar -->
	<div class="navbar navbar-inverse navbar-fixed-top">
	  <div class="navbar-inner">
	    <div class="container">
	        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	            </a>
	 
	    <a href="${pageContext.request.contextPath}" class="brand">My Blog</a>
	 
	    <div class="nav-collapse collapse pull-right">
	        <ul class="nav">
	            
	            <li><a href="${pageContext.request.contextPath}/login" data-toggle="modal"><i class="icon-user icon-white"></i> Log in</a></li>
	            <li class="divider-vertical"></li>
	            
	            <li><a href="${pageContext.request.contextPath}/user/signup" data-toggle="modal"><i class="icon-user icon-white"></i> Sign up</a></li>
	            <li class="divider-vertical"></li>
	            
	            <li><a href="#forgot" data-toggle="modal"><i class="icon-user icon-white"></i> Forgot Password</a></li>
	            <li class="divider-vertical"></li>
	            
	            <li><a href="#contact" data-toggle="modal"><i class="icon-envelope icon-white"></i> Contact Us</a></li>
	            <li class="divider-vertical"></li>
	            
	            <li><a href="${pageContext.request.contextPath}/j_spring_security_logout" data-toggle="modal"><i class="icon-user icon-white"></i> Log out</a></li>
	            <li class="divider-vertical"></li>
	            
	        </ul>
	    </div>
	 
	    </div>
	  </div>
	</div>
	<!-- Navigation Ends -->