<%@page import=" com.satya.Servlet.ProductDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>productList</title>
<!-- BootStrap CDN Link to Get this Support of BootStrap-->
<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<tabel class="table table-bordered table-striped">
<thead class="thead-dark">
<tr>
<th>product Id</th>
<th>product Name</th>
<th>product Price</th>
<th>product Mode</th>
<th>product ManfactureDate</th>
<th>product ExpireDate</th>
<th>Image</th>
</tr>
</thead>

<tbody>
<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
<tr>
<td>${product.proId}</td>
<td>${product.proName}</td>
<td>${product.proPrice}</td>
<td>${product.proMade}</td>
<td>${product.proManfactureDate}</td>
<td>${product.proExpireDate}</td>
</tr>
</c:forEach>
</tbody>
</tabel>
</body>
</html>