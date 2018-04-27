<%--
  Created by IntelliJ IDEA.
  User: starzyn
  Date: 4/24/18
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>say hello</title>
</head>
<body>
    <script type="text/javascript" src="lib/jquery-3.2.1.js"></script>


    <script type="text/javascript">
        $(function(){
            $("form").submit(function () {
                alert("helloword");
            })
        })

    </script>
    <form>
        name:&nbsp;<input type="text" name="name" id="name"><br>
        password:&nbsp;<input type="password" name="password" id="password"><br>
        <input type="submit" id="submit" id="submit" value="submit">
    </form>
</body>
</html>
