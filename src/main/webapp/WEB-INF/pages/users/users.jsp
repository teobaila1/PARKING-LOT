<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Users">
    <div class="container text-center">
        <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser">Add user</a>
            <button type="submit">Invoice</button>
        </c:if>

    <div class="container text-center">
        <u:forEach var="user" items="${users}">
            <div class="row">
                <div class="col">
                    <c:if test="${pageContext.request.isUserInRole('READ_USERS')}">
                        <input type="checkbox" name="user_ids" value="${user.id}"/>
                    </c:if>
                </div>
                    <div class="col">
                            ${user.username}
                    </div>
                </div>
                <div class="col">
                        ${user.email}
                </div>
            <div class="row">

            </div>
    </div>
        </u:forEach>
    </div>
    </form>
    <c:if test="${not empty invoices}">
        <h2>Invoices</h2>
        <c:forEach var="username" items="${invoices}" varStatus="status">
            ${status.index + 1}.${username}
            <br/>
        </c:forEach>
    </c:if>
</t:pageTemplate>
