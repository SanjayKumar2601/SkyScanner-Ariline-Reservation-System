<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_payment.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
  
</head>

<body>
    
  <div id="navigation"></div>
    
      <div class="shadow bg-white rounded">
        
        <div class="trip">
            <h3><strong> Select Payment method</strong></h3><br>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                  Upi
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                <label class="form-check-label" for="flexRadioDefault2">
                  Neft / Debit Card
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                <label class="form-check-label" for="flexRadioDefault2">
                  Wallet
                </label>
              </div><br>
           <form action="/payment" method="post">
                <label class="form-check-label" for="amount">Amount to be paid </label>
              <input type="number" name="amount" id="amount" value="${totalcost}" disabled>
            </div><br>
              <button type="submit" class="btn btn-success" >Pay</button> 
              <p><c:out value='${count}'/></p>
        </div>
      </form>
      </div>
   
      <div id="footer"></div>
          <script>
            function alertf() {
            alert("Payment success");
          }
          $(function(){
      $("#navigation").load("nav.jsp");
      $("#footer").load("footer.jsp");
        });
          </script>
           
          <script  src="script.js"></script>
</body>
</html>