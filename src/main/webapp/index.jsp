<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>EBCalculator</title>
<style type="text/css">
.btn{
width:7.5vw;
height:3vw;
font-size: 1vw;
color:white;
cursor: pointer;
background-color: #1B1A55;
}
.btn:hover{
background-color: #1D24CA;
}
.btn:active{
transition-property: background-color;
background-color: #98ABEE;
transition-duration: 2ms;
}
.but{
margin: 0 0 0 15vw;
}
body{
background-image: url("images/bgimg.webp");
background-size: cover;
background-repeat: no-repeat;
}
form{
padding: 50px 30px 50px 30px;
margin:50px 400px 0px 400px;
border:5px solid gray;
border-radius: 15px 15px 15px 15px;
background-color: rgba(174,188,188,0.3);
}
#total[type=number]{
text-align: center;
}
.input{
width:15vw;
height:2vw;}
#total{
margin: 0px 0px 0px 50px;
}
.cl{
font-size:1.5vw;
color:white;}
.inf{
font-size:20px;
color:white;
}
input:hover{
border: 2px solid blue;
}
h1{
background: linear-gradient(to right, yellow, red);
-webkit-background-clip: text;
-webkit-text-fill-color: transparent;
font-family: serif;
text-align: center;
}
.it:hover{
text-shadow: 0 0 0 lightblue;
transition-duration: 0.1ms;
}
</style>
</head>
<body>

<h1 class="it">TNEB BILL CALCULATOR</h1><div class="main">
<form action="CalAmt" method="post">
<div>
<label  for="ucon" class="inf">Total Unit Consumption: </label>
<input type="number" class="input" name="ucon" placeholder="Enter the Unit" required/><label class="cl"> kwh</label>
</div><br>
<div class="but">
<button class="btn">Calculate</button>
<button class="btn" type="reset" style="margin-left:2px;">Reset</button>
</div>
<br>
<label for="totalamt" class="inf">Total Bill Amount:</label>
<input class="input" disabled type="number" id="total" value="<%= request.getAttribute("totalamt") %>" ><label class="cl"> INR</label>
</form>
</div>
</body>
</html>