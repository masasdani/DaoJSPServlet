<%-- 
    Document   : form
    Created on : Jun 11, 2011, 6:44:33 PM
    Author     : badak
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="Donatur">
            <table>
                <tr>
                    <c:if test="${not empty data}">
                        <tr><td>Nama</td><td><input type="hidden" name="id" value="${data.id}"></input><input type="text" name="nama" value="${data.nama}"/></td></tr>
                        <tr><td>Alamat</td><td><textarea name="alamat">${data.alamat}</textarea></td></tr>
                        <tr><td>&nbsp;</td><td align="right"><input type="submit" name="submit"></td></tr>
                    </c:if>
                    <c:if test="${empty data}">
                        <tr><td>Nama</td><td><input type="hidden" name="id"></input><input type="text" name="nama"/></td></tr>
                        <tr><td>Alamat</td><td><textarea name="alamat"></textarea></td></tr>
                        <tr><td>&nbsp;</td><td align="right"><input type="submit" name="submit"></td></tr>
                    </c:if>
                    
                </tr>
            </table>
        </form>
    </body>
</html>
