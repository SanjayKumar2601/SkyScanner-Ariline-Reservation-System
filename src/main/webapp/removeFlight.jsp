<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Remove Flight</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_addFlights.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>

  <div id="navigation"></div>
  <div class="shadow bg-white rounded">
    <center><h4>Remove Flight</h4> </center> <br>
    
    
  
      <table class="table table-bordered">
        <thead>
            <tr>
                
                <th scope="col">Flight Number</th>
              <th scope="col">Departure</th>
              <th scope="col">Destination</th>
              <th scope="col">Start Time</th>
              <th scope="col">End Time</th>
              <th scope="col">Price</th>
              <th scope="col">Seats Left</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="ticket" items="${flights}">
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
    <br>
 
    


  <form action="/removeFlight" method="post">
    


        <input type="text" class="form-input" name="f"  id="f" required>
        <br><br>
        <button type="submit" name="Remove Flight" class="btn btn-primary">Remove Flight</button>
    </form>
</div>

<div id="footer"></div>
</body>
<script>
  $(function(){
      $("#navigation").load("navadmin.jsp");
      $("#footer").load("footer.jsp");
  });
  </script>

</html>
