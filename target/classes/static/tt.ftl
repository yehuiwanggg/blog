<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<LINK href="/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
<script src="/jquery/jquery-3.4.1.js"></script>
<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
<body>
<#list ['a', 'b', 'c'] as i>
    ${i?counter}: ${i}
</#list>
</body>
</html>