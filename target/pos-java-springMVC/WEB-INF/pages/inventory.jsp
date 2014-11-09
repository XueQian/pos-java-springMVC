<%@ page import="com.thoughtworks.entity.Calculator" %>
<%@ page import="com.thoughtworks.entity.CartItem" %>
<%@ page import="com.thoughtworks.util.DataTransfer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<html>
<body>
<h1>let us go</h1>
<%=new Date()%>
<%
    Set<String> categories = (Set<String>) request.getAttribute("cartCategories");
    for (String category : categories) {
        request.setAttribute("category", category);
%>
<h2>${category}</h2>

<%
    List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
    for (CartItem cartItem : cartItems) {
        request.setAttribute("cartItem", cartItem);
        if (category.equals(cartItem.getItem().getCategory())) {
            double subtotal = DataTransfer.transfer(Calculator.getSubtotal(cartItem));
            request.setAttribute("subtotal", subtotal);

%>

<h3>${cartItem.item.name}|${cartItem.count}|${cartItem.item.price}|${cartItem.item.unit}|${subtotal}</h3>

<%
        }
    }
    double totalMoney = Calculator.getTotalMoney(cartItems);
    request.setAttribute("totalMoney", totalMoney);
    double promotionMoney = Calculator.getTotalMoneyAfterPromoting(cartItems);
    request.setAttribute("promotionMoney", promotionMoney);
    double totalSavedMoney = Calculator.getTotalSavedMoney(cartItems);
    request.setAttribute("totalSavedMoney", totalSavedMoney);


    request.removeAttribute("cartItem");

%>

<%
    }

    request.removeAttribute("category");
%>
<h3>${totalMoney}|${promotionMoney}|${totalSavedMoney}</h3>

</body>
</html>

