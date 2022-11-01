<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="icon" type="image/x-icon" href="logo.png">

    <link rel="stylesheet" href="style_home.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
<div id="navigation"></div>
<header>
  <br>
  <center><h3>Welcome to Sky Scanner:)</h3>
    <h3>The No.1 Airline Reservation Webstie</h3></center>
</header>
<main>
  <div class="toast align-items-center" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="d-flex">
      <div class="toast-body">
        Hello, world! This is a toast message.
      </div>
      <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
    </div>
  </div>
  <div class="container py-5">
    <div class="login">
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="true">
          <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          </div>
          <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="10000">
              <img src="https://img.freepik.com/free-vector/happy-children-jumping-summer-meadow_74855-5852.jpg?w=2000" class="overlay-image" alt="...">
              <div class="carousel-caption d-none d-md-block" id="text">
                <h3 style="color:black;">Christmas Special</h3>
                <p style="color:black;">Now book tickets for children under 14 with 50% off</p>
              </div> 
            </div>
            <div class="carousel-item" data-bs-interval="10000">

              <img src="https://wallpaperaccess.com/full/767252.jpg" class="overlay-image " alt="...">
              <div class="continer">
                  <p>Now with more offers</p>
              </div>
               <div class="carousel-caption d-none d-md-block" id="text">
                <h3>New Menu</h3>
                <p>Now enjoy our all new MENU</p>
              </div> 
            </div>
            <div class="carousel-item" data-bs-interval="10000">
              <img src="https://images.hdqwalls.com/wallpapers/plane-artwork-4k-4g.jpg" class="overlay-image" alt="...">
              <div class="carousel-caption d-none d-md-block" id="text">
                <h3>Now with more exciting offers</h3>
                <p>Lowest Price Gurante</p>
              </div> 
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
        
  </div>
  </div>
  <div class="container">
    <center><h5>Why Airline Reservation Website is benificial for ticket booking?</h5></center>
    <br>
    <p>Airline reservation systems incorporate airline schedules, fare tariffs, passenger reservations and ticket records. An airline's direct distribution works within their own reservation system, as well as pushing out information to the GDS. The second type of direct distribution channel are consumers who use the internet or mobile applications to make their own reservations. Travel agencies and other indirect distribution channels access the same GDS as those accessed by the airline reservation systems, and all messaging is transmitted by a standardized messaging system that functions on two types of messaging that transmit on SITA's high level network (HLN). These messaging types are called Type A [usually EDIFACT format] for real time interactive communication and Type B [TTY] for informational and booking type of messages. Message construction standards set by IATA and ICAO, are global, and apply to more than air transportation. Since airline reservation systems are business critical applications, and they are functionally quite complex, the operation of an in-house airline reservation system is relatively expensive.

      Prior to deregulation, airlines owned their own reservation systems with travel agents subscribing to them. Today, the GDS are run by independent companies with airlines and travel agencies being major subscribers.
      
      As of February 2009, there are only four major GDS providers in the market: Amadeus, Travelport (which operates the Apollo, Worldspan and Galileo systems), Sabre and Shares. There is one major Regional GDS, Abacus, serving the Asian market and a number of regional players serving single countries, including Travelsky (China), Infini and Axess (both Japan) and Topas (South Korea). Of these, Infini is hosted within the Sabre complex, Axess is in the process of moving into a partition within the Worldspan complex, and Topas agencies will be migrating into Amadeus.
      
      Reservation systems may host "ticket-less" airlines and "hybrid" airlines that use e-ticketing in addition to ticket-less to accommodate code-shares and interlines.
      
      In addition to these "standardized" GDS, some airlines have proprietary versions which they use to run their flight operations. A few examples are Delta's OSS and Deltamatic systems and EDS SHARES. SITA Reservations remains the largest neutral multi-host airline reservations system, with over 100 airlines currently managing inventory.</p>
      <br>
      <center><h5>Fare quote and ticketing</h5></center><br>
      <p>
        The Fares data store contains fare tariffs, rule sets, routing maps, class of service tables, and some tax information that construct the price – "the fare". Rules like booking conditions (e.g. minimum stay, advance purchase, etc.) are tailored differently between different city pairs or zones, and assigned a class of service corresponding to its appropriate inventory bucket. Inventory control can also be manipulated manually through the availability feeds, dynamically controlling how many seats are offered for a particular price by opening and closing particular classes.

The compiled set of fare conditions is called a fare basis code. There are two systems set up for the interchange of fares data — ATPCO and SITA, plus some system to system direct connects. This system distributes the fare tariffs and rule sets to all GDSs and other subscribers. Every airline employs staff who code air fare rules in accordance with yield management intent. There are also revenue managers who watch fares as they are filed into the public tariffs and make competitive recommendations. Inventory control is typically manipulated from here, using availability feeds to open and close classes of service.

The role of the ticketing complex is to issue and store electronic ticket records and the very small number of paper tickets that are still issued. Miscellaneous charges order (MCO) is still a paper document; IATA has working groups defining the replacement document the electronic multipurpose document (EMD) as at 2010. The electronic ticket information is stored in a database containing the data that historically was printed on a paper ticket including items such as the ticket number, the fare and tax components of the ticket price or exchange rate information. In the past, airlines issued paper tickets; since 2008, IATA has been supporting a resolution to move to 100% electronic ticketing. So far, the industry has not been able to comply due to various technological and international limitations. The industry is at 98% electronic ticket issuance today, although electronic processing for MCOs was not available in time for the IATA mandate.
      </p>

  </div>
</main>
<div id="footer"></div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>
  $(function(){
      $("#navigation").load("nav.jsp");
      $("#footer").load("footer.jsp");
  });
  </script>
</html>
