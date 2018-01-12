<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add an account</title>
<link rel="stylesheet" type="text/css" href="./styles/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body class="mybody">
<div class="jumbotron">
	<div class="container">
	 <h1> Getting a new account?</h1>
	</div>
	</div>
<form action="AddAccountServlet" method="post">
  <div class="form-group col-md-6">
    <label for="accountName">Name this account</label>
    <input type="text" class="form-control" id="accountName" name="accountName" placeholder="Ex: Joe's Checking">
  </div>
  <div class="form-group col-md-2">
    <label for="balance">Enter Starting Balance</label>
    <input type="double" class="form-control" id="balance" name="balance" placeholder="min. 5.00">
  </div>

  <button type="submit" class="btn btn-primary">Add new account</button>
</form>
</body>
</html>