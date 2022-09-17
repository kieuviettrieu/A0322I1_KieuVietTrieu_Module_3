<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Search</title>
</head>
<body>
<h1>Search Products</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<c:if test="${productSearch.size()<1}">
    <h4 style="color: red">Not found!</h4>
</c:if>

<c:if test="${productSearch.size()>0}">
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>

        <c:forEach items="${productSearch}" var="product">
            <tr>
                <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                <td>${product.getPrice()}</td>
                <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>