<%-- 
    Document   : add-income
    Created on : Aug 24, 2022, 10:51:51 AM
    Author     : inmac
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container" style="width:50%;">

    <h1 class="text-center text-info">Add Income</h1>
    <c:url value="/income" var="action" />
    <sec:authorize access="!isAuthenticated()">
        <strong>Vui long <a href="<c:url value="/login" />">dang nhap</a> de them phieu thu!!!</strong>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <form:form method="post" action="${action}" modelAttribute="income">
            <div class="mb-3 mt-3">
                <label for="" class="incomeCost">Amount</label>
                <form:input type="number" id="incomeCost" placeholder="Enter the amount"  path="incomeCost" />

                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="mb-3">
                <label for="pwd" class="incomeItem">Item</label>
                <form:select path="incomeItem" class="form-select" id="incomeItem" >
                    <c:forEach items="${incomeitem}" var="item">
                        <option value="${item.id}">${item.inSource}</option>
                    </c:forEach>
                </form:select>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>
                <div class="mb-3 mt-3">
                <label for="" class="expenseCost">Note</label>
                <form:textarea type="text" class="form-control" id="note" placeholder="Enter your note"  path="note" />

                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>

            <button type="submit" class="btn btn-primary">Add</button>
        </form:form>
    </sec:authorize>
    
</div>

