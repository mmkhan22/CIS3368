<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title> Covid-19 </title>
    <style><%@include file="../css/style.css"%></style>
</head>
<body>
    <hr>
    <h1>Covid-19</h1>
        <form method=get" action="/get/">
            <select name="id">
                <option value = "united-states">United States</option>
            </select>

            <input type="submit" value="Submit">


        </form>
    </hr>

    <div>
        <h2>Country</h2> <h3><%=request.getParameter("Country")%></h3>
        <h2>Confirmed</h2> <h3><%=request.getParameter("Confirmed")%></h3>
        <h2>Deaths</h2> <h3><%=request.getParameter("Deaths")%></h3>
        <h2>Recovered</h2> <h3><%=request.getParameter("Recovered")%></h3>
        <h2>Active</h2> <h3><%=request.getParameter("Active")%></h3>
    </div>

</body>

</html>