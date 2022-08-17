<%-- 
    Document   : login
    Created on : Aug 11, 2022, 7:31:11 PM
    Author     : inmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/login" var="action"/>
<div class="container">
    <h1 class="text-info text-center">Dang Nhap</h1>
    
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">Da co loi xay ra</div>
        </c:if>
        <c:if test="${param.accessDenied!=null}">
            <div class="alert alert-danger">Ban khong co quyen truy cap!!</div>
        </c:if>
   

    <form method="post" action="${action}">
        <div class="mb-3 mt-3">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-check mb-3">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Dang Nhap</button>
    </form><!-- comment -->
</div>
