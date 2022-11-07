<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Cancel Ticket</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_cancel.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
  
</head>

<body>
  
  <div id="navigation"></div>
<header>

</header>

<center><h2><c:out value='${login}'/></h2></center>
<div class="shadow bg-white rounded">
  <form action="/cancelTicket" method="post">
 <center><h3>Cancel Ticket</h3></center> 
 <p>Select the booking to cancel</p>
    <div class="trip">
      <table class="table table-bordered">
        <thead>
            <tr>
                <th scope="col">Ticket Number</th>
              <th scope="col">Flight Number</th>
              <th scope="col">Adult Count</th>
              <th scope="col">Children Count</th>
             <th scope="col">Price</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="ticket" items="${tickets}">
            <tr>
            
              <td><c:out value="${ticket.tid}"/></td>
              <td><c:out value="${ticket.flightnumber}"/></td>
              <td><c:out value="${ticket.adultcount}"/></td>
              <td><c:out value="${ticket.childrencount}"/></td>
             <td><c:out value="${ticket.price}"/></td>
            </tr>
            </c:forEach>
          </tbody>
          
      </table>
      <br>
      

      <input type="number" class="form-input" name="ticketid" id="ticketid">
      <button type="submit" class="btn btn-primary" name="cancelbtn" onclick="alertf()">Cancel Ticket</button>
    </form>
</div>
</div>



<div id="footer"></div>
</body>
<script>
  function alertf() {
   
  alert("Ticket cancelled successfuly, Refresh the page for the update!");
    
  }
  $(function(){
      $("#navigation").load("nav.jsp");
      $("#footer").load("footer.jsp");
  });
  </script>

</html>
