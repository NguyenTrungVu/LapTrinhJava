<%-- 
    Document   : header
    Created on : Aug 6, 2022, 2:57:49 PM
    Author     : inmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Logo</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">Home</a>
                </li>

                <li class="dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Expenses</a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${expenseitem}" var ="c">

                            <li>
                                <c:url value="/" var="ItemPath">
                                    <c:param name="expenseSet" value="${c.id}" />
                                </c:url>
                                <a class="dropdown-item" href="${ItemPath}">${c.itemName}</a>

                            </li>
                        </c:forEach>
                    </ul>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li>
                            <a class="nav-link" href="<c:url value="/register" />">
                                <i class="fa-solid fa-user"></i>Dang Ky
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="<c:url value="/login" />">Dang Nhap</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li>
                            <a class="nav-link" href="<c:url value="/"/>">
                                <c:if test="${currentUser.avatar}!= null">
                                    <img src="${currentUser.avatar}" class="img-fluid"/>
                                </c:if>
                                <c:if test="${currentUser.avatar} == null">
                                    <i class="fa-solid fa-user"></i>
                                </c:if>
                                ${pageContext.request.userPrincipal.name}
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                        </li>
                    </c:when>
                </c:choose>

            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-primary" type="button">Search</button>
            </form>
        </div>
    </div>
</nav>
