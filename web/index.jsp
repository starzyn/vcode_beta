<%--
  Created by IntelliJ IDEA.
  User: starzyn
  Date: 4/19/18
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>hello world</title>
  </head>
  <body>

    验证码:<br> <img id="img" src="/servlet/VCodeServlet" border="1.5"> &nbsp;
    <a href="javascript:change()">看不清,换一张</a><br>
    <form action="/servlet/VCodeServlet" method="post">
      <input type="text" size="6" name="code">&nbsp;<input type="submit" value="提交">
    </form>
  <script type="text/javascript">
    function change() {
        var img = document.getElementById("img");
        img.src = "/servlet/VCodeServlet?time=" + new Date().getMilliseconds().toString();
        // alert(img.src);
    }

  </script>
  </body>
</html>
