<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<!--
   div.ta0 {text-align: left;}
   div.ta1 {text-align: center;}
   div.ta2 {text-align: right;}
   div.ta3 {text-align: justify;}
-->
</style>
<title>いいねこ！！！</title>
</head>
<body>
<div class="ta1">
<p><a href="/iine/YoineServlet?action=yoine">
<img src="/iine/finger-163689_640.jpg" alt="いいね！" width="300" height="200"></a>
<a href="/iine/YoineServlet?action=yoine">
<img src="/iine/2cat-323262_1280.jpg" alt="いいね！" width="300" height="200"></a>
</p>
<p><font size="5"><b>いいねこ！：${yoine.yoineCount}</b></font></p>
</div>
</body>
</html>