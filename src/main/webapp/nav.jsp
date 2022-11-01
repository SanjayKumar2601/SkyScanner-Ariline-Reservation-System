<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Navbar</title>
    <link rel="stylesheet" href="nav.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  </head>
 
  <body>
 <nav class="navbar">

 	<a href="Home.jsp" class="navbar-brand"><img src="logo.png" height="40px" alt="logo"></img>  <span style="font-size:20px">SkyScanner</span> </a>
    <div class="d-md-flex d-block flex-row mx-md-auto mx-0">
        <a class="navbar-item" href="Home.jsp">Home</a>

        <a class="navbar-item" href="search.jsp">Book Flight</a>
        <form action="/manage"><button class="btn btn-lg">Manage</button></form>
        <a class="navbar-item" href="aboutus.jsp">About us</a>
        <div class="dropdown">
          <a
            class="dropdown-toggle d-flex align-items-center hidden-arrow"
            href="#"
            id="navbarDropdownMenuAvatar"
            role="button"
            data-mdb-toggle="dropdown"
            aria-expanded="false"
          >
            Services
          </a>
          <ul
            class="dropdown-menu dropdown-menu-end"
            aria-labelledby="navbarDropdownMenuAvatar"
            style="right: 0;"
          >

            
            <li>

              <form action="/displaycheckin" method="post"><button class="btn">Check in</button></form>
            </li>

             
            <li>

              <form action="/displaycancelTicket" method="post"><button class="btn">Cancel Ticket</button></form>
            </li>
          </ul>
        </div>
    </div>
   
     <div class="dropdown">
        <a
          class="dropdown-toggle d-flex align-items-center hidden-arrow"
          href="#"
          id="navbarDropdownMenuAvatar"
          role="button"
          data-mdb-toggle="dropdown"
          aria-expanded="false"
        >
          <img
            src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
            class="rounded-circle"
            height="25"
            alt="profile"
          />
        </a>
        <ul
          class="dropdown-menu dropdown-menu-end"
          aria-labelledby="navbarDropdownMenuAvatar"
          style="right: 0;"
        >
          
          <li>
            <a class="dropdown-item" href="Signup.jsp">Sign in</a>
          </li>
          <li>

            <form action="/logout" method="post"><button class="btn">Log Out</button></form>
          </li>
        </ul>
      </div>
    </div>
</nav>

  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  <script></script>
</html>


