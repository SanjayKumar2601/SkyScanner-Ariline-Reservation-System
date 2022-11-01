<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Admin - View Flights</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_adminviewflights.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
  
  <div id="navigation"></div>
<header>
  <sql:setDataSource
  var="myDS"
  driver="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/skyscanner"
  user="root" password="root"
/>
<sql:query var="list_ticket" dataSource="${myDS}">
  SELECT * FROM users;
</sql:query>
</header>

<div class="shadow bg-white rounded"><!--bg-white-->
    <div class="trip">
   <form action="/viewusers" method="post">
    <table class="table table-bordered">
        <thead>
            <tr>

                <th scope="col">User Id</th>
              <th scope="col">Email</th>
              <th scope="col">Name</th>
              <th scope="col">Password</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="ticket" items="${list_ticket.rows}">
            <tr>

              <td><c:out value="${ticket.id}"/></td>
              <td><c:out value="${ticket.email}"/></td>
              <td><c:out value="${ticket.name}"/></td>
              <td>*********</td>
            </c:forEach>
          </tbody>
      </table>
     
    </form>
      
</div>
</div>




<div id="footer"></div>
</body>
<script>
  
  $(function(){
      $("#navigation").load("navadmin.jsp");
      // $("#footer").load("footer.jsp");
  });
  </script>
  <script>$('.toast').toast('show')</script>
</html>
