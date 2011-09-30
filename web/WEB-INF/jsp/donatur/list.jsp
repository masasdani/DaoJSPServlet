<%-- 
    Document   : list
    Created on : Jun 11, 2011, 6:43:53 PM
    Author     : badak
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    
</head>

<body>
<h1>Daftar Donatur</h1>
<a href="Donatur?action=insert">Tambah Baru</a>
<table border="1">
    <tbody>
    <tr>
        <th>
            Id
        </th>
        <th>
            Nama
        </th>
        <th>
            Alamat
        </th>
        <th></th>
        <th></th>
    </tr>
    <c:if test="${not empty data}">
        <c:forEach var="donatur" items="${data}">
            <tr>
                <td>${donatur.id}</td>
                <td>${donatur.nama}</td>
                <td>${donatur.alamat}</td>
                <td><a href="Donatur?action=update&id=${donatur.id}">Update</a></td>
                <td><a href="Donatur?action=delete&id=${donatur.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
