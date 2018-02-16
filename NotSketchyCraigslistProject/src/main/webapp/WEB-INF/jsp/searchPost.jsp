<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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



  <title>Craiglist But Safer</title>  

<link href="./styles/main.82cfd66e.css" rel="stylesheet">
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
body{color: white;
}
body { 
    /* The image used */
    background-image: url("./images/ucla1.jpg");

    /* Set a specific height */
    height: 500px; 

    /* Create the parallax scrolling effect */
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
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
  <div class="col-xs-12 section-container-spacer">
    <h1>${category}</h1>
    <h4>These are the items for posted at your school</h4>
  </div>
  <div class="row">
  <div class="form-group col-md-6">
              	<label for="search"></label>
 				 <form:input type="text" class="form-control" path="searchPost" placeholder="Search"></form:input>
 				 <a href="./searchPost" class="btn btn-primary" method=GET title="">Search</a>
              </div>
 			</div>
 			<br>

		<c:forEach items="${searchPost}" var="post">
			<div class="col-xs-12 col-md-4 section-container-spacer">
				<img alt="" src="./images/TvPic.jpg" width="300px" height="200px">
				<h2>${post.postTitle}</h2>
				<p>${post.postDescription}</p>
				<a href="./postDetails" class="btn btn-primary" title="">
					Details</a>
			</div>

		</c:forEach>
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

</html>