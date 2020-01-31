<%-- 
    Document   : quotepage
    Created on : Jan 30, 2020, 5:09:59 PM
    Author     : lpeters
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quote Page</title>
    </head>
    <body>
        <p>Welcome, ${sessionScope.firstname}</p>
        <p>The last thing you said was "<i>${requestScope.quote}</i>"</p>
        <p>The list of numbers is: ${numbers}</p>
        <p>The last number entered was: ${inputnum}</p>
        <p>The average of these numbers is: ${average}</p>

        <form method="POST">
        <input type="text" name="frmName" />
        <input type="submit" name="btnName" value="Change Name" />
        </form>

        <form method="POST">
        <input type="text" name="frmQuote" />
        <input type="submit" name="btnPost" value="Post Quote" />
        </form>
        
        <form method="POST">
        <input type="text" name="frmNumber" />
        <input type="submit" name="btnAvg" value="Update Average" />
        </form>
    </body>
</html>
