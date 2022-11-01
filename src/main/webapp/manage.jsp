<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Booked Ticket - History</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_manage.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
  
  <div id="navigation"></div>
<header>

</header>
<center><h2><c:out value='${login}'/></h2></center>
<div class="shadow bg-white rounded"><!--bg-white-->
    <center><h3>Booked Tickets</h3></center>
    <form action="/manage">
  <table class="table table-bordered">
    <thead>
        <tr>
            <th scope="col">Ticket Number</th>
          <th scope="col">Flight Number</th>
          <th scope="col">Adult Count</th>
          <th scope="col">Passenger Count</th>
          <th scope="col">Total Price</th>
          <th scope="col">Payment Status</th>
          <th scope="col">Check In(Seats)</th>
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
          <td><c:out value="${ticket.paymentstatus}"/></td>
          <td><c:out value="${ticket.seats}"/></td>
          
        </tr>
        </c:forEach>
      </tbody>
  </table>
      <br>
      </form>
      

</div>

<div class="toast align-items-center  border-0" role="alert" aria-live="assertive" aria-atomic="true" data-autohide="false">
  <div class="d-flex">
    <div class="toast-body">
      Offer Alert!! ,Now book tickets with 50% off* for children(under 14)
    </div>
    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
  </div>
</div>


<div id="footer"></div>
</body>
<script>
  
  $(function(){
      $("#navigation").load("nav.jsp");
      $("#footer").load("footer.jsp");
  });
  </script>
  <script>$('.toast').toast('show')</script>
</html>
