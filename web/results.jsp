<%-- 
    Document   : results
    Created on : 26.06.2018, 15:46:21
    Author     : Леван
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.Parse,org.mypackage.Result" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <form name="Search" action="results.jsp">
            <h1>Searchx2</h1>
            <input type="text" name="search" />
            <input type="submit" value="Search"/>
        </form>
        
        <h1>Google:</h1>
        <% String search=request.getParameter("search");
            Parse parse=new Parse();
            parse.search(search);
            int i=0;
            while(i<5&&parse.getResultFromGoogle(i)!=null){
                Result result = parse.getResultFromGoogle(i);
                out.println("<a href="+"\""+result.getUrl()+"\""+"><p>"+result.getTitle()+"</p><a>");
                i++;
            }
        %>
        <h1>Bing:</h1>
        <%
            int a=0;
            while(a<5&&parse.getResultFromBing(a)!=null){
                Result result = parse.getResultFromBing(a);
                out.println("<a href="+"\""+result.getUrl()+"\""+"><p>"+result.getTitle()+"</p><a>");
                a++;
            }
            %>
    </body>
</html>
