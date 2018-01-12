<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.user.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <% Customer customer = (Customer)session.getAttribute("customer"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">s
<title>Welcome</title>
<link src= "http://java.sun.com/jsp/jstl/core">
<link rel="stylesheet" type="text/css" href="./styles/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>
<body class="mybody">
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-3">Hello,<%out.print(customer.getFirstName()); %></h1>
  </div>
</div>
<br>
<a class="btn btn-primary" href="OpenAccountServelet" role="button" >Open new Account</a>
 <button type="button" class="btn btn-danger" href="ClosePrimaryServlet">Close This Account</button>
<h2> Account Name: </h2>
<h3><%out.print(customer.getAccounts().get(0).getAccountName()); %></h3>
<h2>Balance:</h2>
<h2><%out.print(customer.getAccounts().get(0).getBalance()); %></h2>
<form class="form-inline" action="DepositServlet" method="post">
  <div class="form-group">
    <label for="makeDepositeLabel" class="sr-only">makeDepositeLabel</label>
    <input type="text" readonly class="form-control-plaintext" id="makeDepositeLabel" value="Make a Deposit">
  </div>
  <div class="form-group mx-sm-3">
    <label for="depositeAmount" class="sr-only">depositeAmount</label>
    <input type="text" class="form-control" id="transactionAmount" name="transactionAmount" placeholder="Ex: 100.00">
  </div>
  <button type="submit" class="btn btn-primary">Send</button>
</form>
<form class="form-inline" action="WithdrawlServlet" method="post">
  <div class="form-group">
    <label for="makeWithdrawlLabel" class="sr-only">makeWithdrawlLabel</label>
    <input type="text" readonly class="form-control-plaintext" id="makeWithdrawlLabel" value="Make a Withdrawl">
  </div>
  <div class="form-group mx-sm-3">
    <label for="withdrawlAmount" class="sr-only">withdrawlAmount</label>
    <input type="text" class="form-control" id="transactionAmount1" name="transactionAmount1" placeholder="Ex: 100.00">
  </div>
  <button type="submit" class="btn btn-primary">Send</button>
</form>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Previous Balance</th>
      <th scope="col">Transaction Type</th>
      <th scope="col">Transaction Amount</th>
      <th scope="col">New Balance</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="trans" items="${customer.getAccounts().get(0).getStatement()}">
    <tr>
      <td><c:out value="${trans.previousBal}"/></td>
      <td><c:out value="${trans.transactionType}"/></td>
      <td><c:out value="${trans.transactionAmount}"/></td>
      <td><c:out value="${trans.currentBal}"/></td>
     
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>