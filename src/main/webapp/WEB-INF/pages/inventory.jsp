<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.thoughtworks.entity.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%--<%@ page import="com.thoughtworks.entity.Calculator" %>--%>
<html>
<body>
<h1>let us go</h1>
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
        if(category.equals(cartItem.getItem().getCategory())){


%>

<h1>${cartItem.item.name}|${cartItem.count}|${cartItem.item.price}|${cartItem.item.unit}</h1>

<%
        }
    }
    request.removeAttribute("cartItem");

%>


<%
    }
    request.removeAttribute("category");
%>


</body>
</html>

