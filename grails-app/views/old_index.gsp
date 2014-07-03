<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main"/>
<r:require modules="bootstrap"/>
<title>Jobbyy</title>
</head>
<body>

<table style="height:100%">
<tr><td>
         <sec:ifNotGranted roles="ROLE_USER">
             <a href="/login/auth"/>- Login</a>
  <facebookAuth:connect />
</sec:ifNotGranted>
<sec:ifAllGranted roles="ROLE_USER">
  Welcome <sec:username/>! (<g:link uri="/j_spring_security_logout">Logout</g:link>)
</sec:ifAllGranted>
        

</td></tr>
<tr><td>
<a href="/register/"/>- Registro</a>
</td></tr>
<tr><td>

</td></tr>

<tr><td>
<a href="/tripas/"/>- Administración</a>
</td></tr>
</table>



</body>
</html>
