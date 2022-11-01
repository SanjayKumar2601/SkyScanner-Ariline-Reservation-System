<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>

<html lang="en">
  
  <head>
    <meta charset="UTF-8">
    <title>Search</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_search.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

  
</head>

<body>

  <div id="navigation"></div>
<header>

</header>

<sql:setDataSource
    var="myDS"
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/skyscanner"
    user="root" password="root"
/>
<sql:query var="depa" dataSource="${myDS}">
    select * from flights;
</sql:query>
<center><h2><c:out value='${login}'/></h2></center>
  <div class="shadow bg-white rounded">
    <h5 class="text-center mb-4">Search</h5>


    <form class="form-card form-control" action="/SearchFlights" method="post">
      
        <div class="col-md-3">
         <label class="form-control-label px-1">From<span class="text-danger"> *</span></label>
            
            <input type="text" name="from" id="from" class="form-control form-text">
        </div>
        <div class="col-md-3">
           <label class="form-control-label px-1">To<span class="text-danger"> *</span></label> 
            
            <input type="text" name="to" id="to" class="form-control form-text">
        </div>
        <div class="col-md-2">
          <label class="form-control-label px-1">Date<span class="text-danger"> *</span></label> 
            <input class="form-select form-select" type="Date" id="date" name="date" >
           </div>
        
        
        <br>
        <div class="col-12">
          <button class="btn btn-primary btn-sm" id="b3" type="submit">Search</button>
        </div>
        
      </form>
     
      
 
<form action="/BookFlights" class="form-control" method="post">
    <table class="table table-bordered">
        <thead>
            <tr>
  
              <th scope="col">Flight Number</th>
              <th scope="col">Departure</th>
              <th scope="col">Destination</th>
              <th scope="col">Start Time</th>
              <th scope="col">End Time</th>
              <th scope="col">Price</th>
              <th scope="col">Tickets Left</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="ticket" items="${l}">
            <tr>
            
              <td><c:out value="${ticket.flightnumber}"/></td>
              <td><c:out value="${ticket.departure}"/></td>
              <td><c:out value="${ticket.destination}"/></td>
              <td><c:out value="${ticket.starttime}"/></td>
              <td><c:out value="${ticket.endtime}"/></td>
              <td><c:out value="${ticket.price}"/></td>
              <td><c:out value="${ticket.seatcount}"/></td>
              
            </tr>
            </c:forEach>
          </tbody>
      </table>
      
      <div class="col-md-2">
      <label for="flightnumber" class="form-control-label px-1">Flight Number</label><br>
      <input type="text" name="flightnumber" id="flightnumber" placeholder="flightnumber" class="form-control form-text" required><br>   
      <label for="adultcount" class="form-control-label px-1">Adult</label><br>      
      <input   type="number" id="adultcount" name="adultcount" value="1" class="form-control form-number"><br>
      <label for="childrencount" class="form-control-label px-1">Children</label><br>
      <input  type="number" id="childrencount" name="childrencount" value="0" class="form-control form-number"><br>
      </div>
      <button class="btn btn-primary" id="b3" type="submit">Book</button>
      <p><c:out value='${count}'/></p>
    </form>
    </div>
  
    <div id="footer"></div>
  </body>
  <script>
    $(function(){
        $("#navigation").load("nav.jsp");
        $("#footer").load("footer.jsp");
    });
    </script>
</html>
