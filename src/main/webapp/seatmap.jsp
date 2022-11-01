<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Check in - Seat Selection</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    <link rel="stylesheet" href="style_seatmap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
    <div id="navigation"></div>
    <div class="shadow bg-white">
        <div class="seatmap">
<img src="https://www.norwegian.com/globalassets/ip/media/travelling-with-us/seat-reservation/seat-maps/seatmap-737-800-max.png" alt="Seat Map" height="1500rem">
</div>
<div class="form-container form">
<form action="/seatmapping" method="post">
   <h3>Select the seats</h3>
   <p>Select the seats based on the seat map provided(to your left)</p>
   <p><strong>*Note : </strong> The rate may vary according to the seat selected</p>
   <p><strong>**The selected seats are only confirmed 5 hours before the departure</strong></p>
   <label for="check" class="form-check-label">Enter the seat number (Eg - B3 B4)</label><br>
   <input type="text" placeholder="B3 A2" name="seats" id="seats" class="form-input"><br><br>
    <input type="submit" class="btn btn-primary btn-sm" value="Check in">
</form>
</div>
</div>

</body>
<script>
    $(function(){
        $("#navigation").load("nav.jsp");
        $("#footer").load("footer.jsp");
    });
    </script>
</html>
