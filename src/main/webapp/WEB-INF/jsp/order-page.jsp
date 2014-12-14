<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>">
	</script>
	<script type="text/javascript">
	    var jq = jQuery.noConflict();
	</script>
	
	<title>TTD</title>

</head>
<body>

<h3>TTD</h3>
<h4>AJAX version</h4>

Demo 1
<div style="border: 1px solid #ccc; width: 250px;">
	Add Two Numbers: <br/>
	<input id="inputNumber1" type="text" size="5"> +
	<input id="inputNumber2" type="text" size="5">
	<input type="submit" value="Add" onclick="add()" /> <br/>
	Sum: <span id="sum">(Result will be shown here)</span>
</div>


<script type="text/javascript"> 

function add() {
	jq(function() {
		// Call a URL and pass two arguments
		// Also pass a call back function
		// See http://api.jquery.com/jQuery.post/
		// See http://api.jquery.com/jQuery.ajax/
		// You might find a warning in Firefox: Warning: Unexpected token in attribute selector: '!' 
		// See http://bugs.jquery.com/ticket/7535
		jq.post("${baseURL}/order/place",
					{ 	inputNumber1:  jq("#inputNumber1").val(),
				  		inputNumber2:  jq("#inputNumber2").val() },
						function(data){
							// data contains the result
							// Assign result to the sum id
							jq("#sum").replaceWith('<span id="sum">'+ data + '</span>');
					});
	});
}

</script>
</body>
</html>