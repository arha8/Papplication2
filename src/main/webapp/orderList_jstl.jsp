<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <h3>List of Orders ${today}</h3>

        <table border="1">
            <tbody>
                <c:forEach var="orders" items="${orders}">

                        <td>Order ${orders.orderId}</td>
                        <td>${orders.orderName}</td>
                        <td>${orders.orderDate}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>