<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/libs/jquery.js"></script>
        <script src="resources/js/libs/jquery.lightbox_me.js"></script>
        <script src="resources/js/atm.js"></script>
        <link type="text/css" rel="stylesheet" href="resources/style.css"/>        
        <title>ATM</title>
    </head>
    <body>
        <div class="header">
        </div>
        <div class="main">
        	<div class="ccrow"></div>
        	<div class="buttons left-buttons">
        		<div class="button"></div>
        		<div class="button"></div>
        		<div id="withdraw" class="button"></div>
        		<div id="deposit" class="button"></div>
        		
        	</div>
        	<div class="display">
        		<h3>Please make a choice</h3>
        		<div class="labels left-labels">
        			<p>Withdraw</p>
        			<p>Deposit</p>
        		</div>
        		<div class="labels right-labels">
        			<p>Balance</p>
        			<p>Re-Enter PIN</p>
        		</div>
        	</div>
        	<div class="buttons right-buttons">
        		<div class="button"></div>
        		<div class="button"></div>
        		<div id="balance" class="button"></div>
        		<div id="pin" class="button"></div>
        	</div>
        </div>
        
        <div id="model" class="model">
        	<p>Enter Value</p>
        	<input class="input" type="text"></input>
        	<input type="submit" name="submit" class="submit">
        	<p class="error">insufficient funds</p>
        	
        </div>
        
        <div id="pinmodel"  class="model">
        	<p>Enter PIN</p>
        	<label>Account Number</label><input class="account" type="text"></input>
        	<label>PIN</label><input class="input" type="password"></input>
        	<input type="submit" name="submit" class="submit">
        	<p class="error">invalid pin</p>
        </div>
        
         <div id="balancemodel"  class="model">
        	<p>Your Balance</p>
        	<input class="input" type="text"></input>
        	<input type="button" name="ok" class="submit">
        </div>
        
    </body>
</html>
