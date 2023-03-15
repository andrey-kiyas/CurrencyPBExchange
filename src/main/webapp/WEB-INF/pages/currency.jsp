<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>

    <title>Currency Page</title>
    <style><%@include file="/WEB-INF/pages/style.css"%></style>

</head>
<body>
<h1>Currency exchange working page</h1>
<a href="../../index.jsp">Back to main menu</a><br/><br/>

<h2>Currency List</h2>

<c:if test="${!empty listCurrency}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Operation</th>
            <th width="120">Currency</th>
            <th width="120">Sum</th>
            <th width="120">Sum ekv</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCurrency}" var="currency">
            <tr>
                <td>${currency.id}</td>
                <td><a href="/currencyData/${currency.id}">${currency.currOper}</a></td>
                <td>${currency.currCcy}</td>
                <td>${currency.currSumm}</td>
                <td>${currency.currSummEkv}</td>
                <td><a href="<c:url value='/edit/${currency.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${currency.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Currency operation</h2>

<c:url var="addAction" value="/currency/add"/>

<form:form action="${addAction}" commandName="currency">
    <table>
        <c:if test="${!empty currency.currOper}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="currOper">
                    <spring:message text="Operation"/>
                </form:label>
            </td>
            <td>
                <form:input path="currOper"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="currCcy">
                    <spring:message text="Currency"/>
                </form:label>
            </td>
            <td>
                <form:input path="currCcy"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="currSumm">
                    <spring:message text="Sum"/>
                </form:label>
            </td>
            <td>
                <form:input path="currSumm"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="currSummEkv">
                    <spring:message text="Sum ekv"/>
                </form:label>
            </td>
            <td>
                <form:input path="currSummEkv"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty currency.currOper}">
                    <input type="submit"
                           value="<spring:message text="Edit curr"/>"/>
                </c:if>
                <c:if test="${empty currency.currOper}">
                    <input type="submit"
                           value="<spring:message text="Add curr"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
