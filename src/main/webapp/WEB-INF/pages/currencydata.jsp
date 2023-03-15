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
<h1>Currency Details</h1>
<a href="/currency">Back to currency List</a><br/><br/>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Operation</th>
        <th width="120">Currency</th>
        <th width="120">Sum</th>
        <th width="120">Sum ekv</th>
    </tr>
    <tr>
        <td>${currency.id}</td>
        <td>${currency.currOper}</td>
        <td>${currency.currCcy}</td>
        <td>${currency.currSumm}</td>
        <td>${currency.currSummEkv}</td>
    </tr>
</table>
</body>
</html>