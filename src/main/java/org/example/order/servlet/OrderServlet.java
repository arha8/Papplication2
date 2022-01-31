package org.example.order.servlet;

import org.example.order.business.OrderService;
import org.example.order.domain.OrderList;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = {"/orderList"})
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        WebApplicationContext webCtx = WebApplicationContextUtils.getWebApplicationContext(ctx);

        OrderService service = webCtx.getBean(OrderService.class);
        List<OrderList> list = service.getOrdersList();

        req.setAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        req.setAttribute("orders", list);

        //getServletContext().getRequestDispatcher("/orderList_jstl.jsp").forward(req, resp);
        getServletContext().getRequestDispatcher("/orderList.jsp").forward(req, resp);
    }
}
