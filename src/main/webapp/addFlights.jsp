
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <title>Admin - Add Flights</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_addFlights.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>

  <div id="navigation"></div>

<div class="shadow bg-white rounded">
    <center><h3>Add Flight</h3> </center>
    <form action="/addFlights" method="POST">
        <label for="flightnumber" class="form-check-label">Flight number</label>
        <input type="number" class="input" placeholder="1" name="flightnumber"><br><br>
        <label for="departure" class="form-check-label">departure</label>
        <input type="text" class="input" placeholder="Delhi" name="departure"><br><br>
        <label for="destination" class="form-check-label">destination</label>
        <input type="text" class="input" placeholder="Mumbai" name="destination"><br><br>
        <label for="starttime" class="form-check-label">start time</label>
        <input type="text" class="input" placeholder="10:00" name="starttime"><br><br>
        <label for="endtime" class="form-check-label">end time</label>
        <input type="text" class="input" placeholder="23:00" name="endtime"><br><br>
        <label for="price" class="form-check-label">price</label>
        <input type="number" class="input" placeholder="1000" name="price"><br><br>
        <label for="seatcount" class="form-check-label">Number of Seats</label>
        <input type="number" class="input" placeholder="100" name="seatcount"><br><br>
        <button type="submit" value="Add Flight" class="btn btn-success">Add Flight</button>
    </form>
</div>
</form>
<div id="footer"></div>
</body>
<script>
  $(function(){
      $("#navigation").load("navadmin.jsp");
      // $("#footer").load("footer.jsp");
  });
  </script>

</html>
