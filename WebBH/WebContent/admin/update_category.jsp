<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page import="dao.CategoryDAOImpl"%>
<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật danh mục</title>

    </head>
    <body>
        
        <%
            String error = "";
        String cat_id = "";
        String select = "";
        Category cat = null;
            if(request.getParameter("error")!=null){
                error = (String) request.getParameter("error");
            }
            if(request.getParameter("category_id")!=null){
            	cat_id = (String) request.getParameter("category_id");
            cat = CategoryDAOImpl.getListCategoryAllByid(Long.parseLong(cat_id));
            }
        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Cập nhật danh mục</h3>
                    <form action="/WebBH/ManagerCategoryServlet" method="post">
                    <input type="hidden" name="cat_id" value="<%= cat.getCategory_id() %>"  >
                    <table width="95%">
                        <tr>
                            <td style="float: right"><b>Tên danh mục:</b></td>
                            <td><input type="text" class="sedang" name="tenDanhMuc" value="<%= cat.getCategory_name() %>" ><%=error%></td>
                        </tr>
                        <tr>
                            <td style="float: right"><b>Tên danh mục cha:</b></td>
                            <td>
                            	<select name="category_cha">
                            	<% 
                            	if(cat.getCategory_cha().trim().equals("")){
                        			select = "selected";
                        			%>
                                	<option value=" "  <%= select %>>---Category---</option>
                        		
                            	<% 
                            	select = "";
                            	}
                            	%>
                            	<%for(Category c : CategoryDAOImpl.getListCategoryCha() ){
                            		if(!cat.getCategory_cha().trim().equals("")){
                            		if(Long.parseLong(cat.getCategory_cha())==c.getCategory_id()){
                            			select = "selected";
                            		}
                            		else{select ="";}
                            		}
                            	%>
                            		<option value="<%= c.getCategory_id() %>" <%= select %> ><%= c.getCategory_name() %></option>
                            		<%} %>
                            	</select>
                            </td>
                        </tr>
                        <tr><td></td><td>
                                <input type="hidden" name="command" value="update">
                                <input type="hidden" name="category_id" value="<%=request.getParameter("category_id")%>">
                                <input type="submit" class="button" value="Lưu dữ liệu">
                            </td>
                        </tr>
                    </table>
                    </form>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
