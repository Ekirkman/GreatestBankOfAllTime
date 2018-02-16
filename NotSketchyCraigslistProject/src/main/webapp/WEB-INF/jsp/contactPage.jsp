<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width,initial-scale=1" name="viewport">
  <meta content="Page description" name="description">
  <meta name="google" content="notranslate" />
 
  <!-- Disable tap highlight on IE -->
  <meta name="msapplication-tap-highlight" content="no">
  
  <link href="./assets/apple-icon-180x180.png" rel="apple-touch-icon">
  <link href="./assets/favicon.ico" rel="icon">



  <title>Talk To Us</title>  

<link href="./styles/main.82cfd66e.css" rel="stylesheet">
<link href="./styles/SideBar.css" rel="stylesheet">
<style type="text/css">
.sidebar{
background-color: #990000;
}
.icey{
color:white
}

.nav-footer a, .nav>li>a {
    color: #fdffff;
}
body{
	background-color: #ffff;
}
.site-brand{
color:#fff
}
body{color: black;
}
body { 
    /* The image used */
    background-image: url("./images/ucla2.jpg");

    /* Set a specific height */
    height: 500px; 

    /* Create the parallax scrolling effect */
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
</style>
</head>



<body>

 <!-- Add your content of header -->
<header class="">
  <div class="navbar navbar-default visible-xs">
    <button type="button" class="navbar-toggle collapsed">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a href="./index.html" class="navbar-brand"></a>
  </div>

  <nav class="sidebar">
    <div class="navbar-collapse" id="navbar-collapse">
      <div class="site-header hidden-xs">
          <a class="site-brand" href="./" title="">
            <img src="images/FuegoBlanco3.png">
            Thirsty Thursdays
          </a>
        <p><span class="icey">Where you can find all the best stuff on campus & still make it to class Friday .</span></p>
      </div>
      
      
      <ul class="nav">
        <li><a href="/" title="">Home</a></li>
        <li><a href="/login" title="">Log in</a></li>
        <li><a href="./signup" title="">Sign Up</a></li>
        <li><a href="./viewProfile" title="">View Profile</a></li>
        <li><a href="./contactPage" title="">Contact</a></li>
        <li><a href="/about" title="">About Us</a></li>	
      </ul>
    
      <br>
      
      <nav class="nav-footer">
        <p class="nav-footer-social-buttons">
          <a class="fa-icon" href="https://www.linkedin.com/in/ekirkman" title="">
            <i class="fa fa-linkedin"></i>
          </a>
          <a class="fa-icon" href="https://www.github.com/ekirkman" title="">
            <i class="fa fa-github"></i>
          </a>
          <a class="fa-icon" href="https://google.com/" title="">
            <i class="fa fa-google-plus"></i>
          </a>
        </p>
        </div>

        
        <p><span class="icey">© Thirsty Thursdays |</span> </p>
        </div>
      </nav>   
   
  </nav>
</header>
<main class="" id="main-collapse">


<div class="row">
  <div class="col-xs-12">
    <div class="section-container-spacer">
      <h1>Contact</h1>
      <p>Thirsty Thursdays is devoted to being as not sketchy as possible any questions,comments,or ideas about being less sketchy please let us know.</p>
    </div>
    <div class="section-container-spacer">
       <form:form action="/contactPage" modelAttribute="email" class="reveal-content" method="POST">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <form:input type="email" class="form-control" path="fromEmail" placeholder="Email"></form:input>
              </div>
              <div class="form-group">
                <form:input type="text" class="form-control" path="subject" placeholder="Subject"></form:input>
              </div>
              <div class="form-group">
                <form:textarea class="form-control" path="message" rows="3" placeholder="Enter your message"></form:textarea>
              </div>
              <button type="submit" class="btn btn-primary btn-lg">Send</button>
            </div>
            </form:form>
            <div class="col-md-6">
              <ul class="list-unstyled address-container">
                <li>
                  <span class="fa-icon">
                    <i class="fa fa-phone" aria-hidden="true"></i>
                  </span>
                  (314)625-4478
                </li>
                <li>
                  <span class="fa-icon">
                    <i class="fa fa-linkedin" aria-hidden="true"></i>
                  </span>
                  https://www.linkedin.com/in/ekirkman/
                </li>
                <li>
                  <span class="fa-icon">
                    <i class="fa fa fa-map-marker" aria-hidden="true"></i>
                  </span>
                 777 Lucky Street, St.Louis, MO
                </li>
              </ul>
            </div>
          </div>
    </div>
  </div>
</div>


</main>

<script>
document.addEventListener("DOMContentLoaded", function (event) {
  navbarToggleSidebar();
  navActivePage();
});
</script>

<!-- Google Analytics: change UA-XXXXX-X to be your site's ID 

<script>
  (function (i, s, o, g, r, a, m) {
    i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
      (i[r].q = i[r].q || []).push(arguments)
    }, i[r].l = 1 * new Date(); a = s.createElement(o),
      m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
  })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
  ga('create', 'UA-XXXXX-X', 'auto');
  ga('send', 'pageview');
</script>

--> <script type="text/javascript" src="./js/main.85741bff.js"></script></body>