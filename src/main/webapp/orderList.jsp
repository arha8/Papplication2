<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.example.order.domain.OrderList, java.util.List"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders List</title>
    </head>
    <body>
        <h1>List of orders ${today}</h1>

                <%
                    List<OrderList> list = (List<OrderList>)request.getAttribute("orders");
                    for(OrderList o : list) {
                        out.println(o.getOrderName());
                        out.println("<br/>");
                    }
                %>


    </body>
</html>