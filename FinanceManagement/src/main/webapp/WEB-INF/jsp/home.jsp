<%-- 
    Document   : home
    Created on : Jul 29, 2022, 10:16:15 AM
    Author     : inmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<sec:authorize access="!isAuthenticated()">
    <strong>Vui long <a href="<c:url value="/" />">dang nhap</a> de su dung cac tinh nang cua he thong!!!</strong>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div class="row">
        <div class="col-md-3">
            <div id="accordion">
                <div class="card">
                    <div class="card-header" style="position: relative">
                        <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
                            Expense
                        </a>
                        <a class="btn" href="<c:url value="/stats"/>">
                            Detail
                        </a>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">

                            <a href="<c:url value="/"/>" class="btn" style=" position: absolute; right: -27px;top: 8px; z-index: 1; font-size: 30px; color: green"><i class="fa-solid fa-circle-plus"></i></a>

                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="<c:url value="/expense"/>" class="btn" style=" position: absolute; right: -27px;top: 8px; z-index: 1; font-size: 30px; color: green"><i class="fa-solid fa-circle-plus"></i></a>

                        </c:if>

                    </div>
                    <div></div>

                </div>
                <div class="card">
                    <div class="card-header">
                        <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
                            Income
                        </a>
                        <a class="btn" data-bs-toggle="collapse" href="<c:url value="/stats"/>">
                            Detail
                        <c:if test="${pageContext.request.userPrincipal.name == null}">

                            <a href="<c:url value="/"/>" class="btn" style=" position: absolute; right: -27px;top: 8px; z-index: 1; font-size: 30px; color: green"><i class="fa-solid fa-circle-plus"></i></a>

                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="<c:url value="/income"/>" class="btn" style=" position: absolute; right: -27px;top: 8px; z-index: 1; font-size: 30px; color: green"><i class="fa-solid fa-circle-plus"></i></a>

                        </c:if>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="container">

                <section>
                    <h1>Total Income</h1>

                </section>
                <section>
                    <h1>Total Expense</h1>
                </section>



                <section class="page-contain">
                    <div class="d-flex justify-content-between">
                        <ul class="pagination">
                            <c:forEach begin="1" end="${Math.ceil(expenseCounter/10)}" var="i">
                                <c:url value="/home" var="c">
                                    <c:param value="${i}" name="page"  />
                                </c:url>
                                <li class="page-item"><a class="page-link" href="${c}">${i}</a></li>
                                </c:forEach>
                        </ul>
                        
                            <form >
                            <input class="form-control" list="listamount" name="size" id="size">
                            <datalist id="listamount">
                                <option value="1">
                                <option value="5">
                                <option value="50">
                               
                            </datalist>    
                            <button type="submit" class="btn btn-primary mt-3">Submit</button>
                        </form>
                        
                        
                    </div>

                    <c:forEach items="${expenses}" var="e">
                        <a href="<c:url value="/stats"/>" class="data-card">
                            <h3 class="costex"> <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${e.expenseCost}" /> VND</h3>
                            <h4>${e.note}</h4>
                            <p>${e.noteDate}</p>

                        </a>
                    </c:forEach>

                </section>

            </div>

        </div>
    </div>
</sec:authorize>