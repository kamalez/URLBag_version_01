<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>URLBag</title>

<link type="text/CSS" rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<% 
String data=(String) request.getAttribute("DATA");
String name=(String) request.getAttribute("NAME");
String pwd=(String) request.getAttribute("PWD");
%>
<br />
<div class="container">
<h1 style="color:black;">Welcome to the URL-Bag</h1>



<table cellspacing="10" cellpadding="10" class="table table-condensed">
<thead>
<tr><th>Link</th><th>Description</th></tr></thead>
<% 
if (data!=null){
	out.println(data);
	} %><br />
 
<tr><td>
<form action="Servlet3" method="get">

<div class="form-group">



<input type="text" name="adding1" class="form-control" >
</div>


</td><td>


<div class="form-group">



<input type="text" name="adding2" class="form-control" >
</div>
</td></tr>
<input type="hidden" name="name" value=<%= name %>>
<input type="hidden" name="pwd" value=<%= pwd %>>
<tr><td></td><td style="text-align:left;">
<button type="submit" name="submit">Add</button></td>
</form>
</tr></table></div>

</body>
</html>