<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>User Info</title>
   </head>
   <body>
		<jsp:include page="menu.jsp"></jsp:include>
		<h3>Hello: ${loginedUser.uName}</h3>
		User Name: <b>${loginedUser.uName}</b><br />
		Gender: ${loginedUser.gender } <br />
   </body>
</html>