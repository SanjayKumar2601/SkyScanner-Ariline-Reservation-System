
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Admin - Home</title>
    <link rel="icon" type="image/x-icon" href="logo.png">
    
    <link rel="stylesheet" href="style_adminhome.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
<div id="navigation"></div>

 
  <main>
  <div class="container">
    <a href="adminviewusers.jsp">  
      <button class="btn btn-primary">View Users</button>  <br>
    </a>
    <a href="addFlights.jsp">  
      <button class="btn btn-primary">Add Fligths</button>  <br>
    </a>
      <a href="adminviewflights.jsp">  
        <button class="btn btn-primary">View Flights</button>  <br>
      </a>

         <form action="/displayremoveFlights"> <button class="btn btn-primary">Remove Flights</button></form>  <br>
    <!-- </a> -->
    
  </div>

</main>
<div id="footer"></div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>
  $(function(){
      $("#navigation").load("navadmin.jsp");
      // $("#footer").load("footer.jsp");
  });
  </script>
</html>
