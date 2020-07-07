<%
	int x = 3;
	int y = 4;

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input{
	width:50px;
	height:50px;	
}
.output{
	height: 50px;
	background : #e9e9e9;
	font-size:24px;
	font_weight:bold;
	text-align: right;
	padding:0px 5px;
}	
</style>
</head>
<body>
  <div>
  <form action="calc3" method="post">
  <table>
  	<tr>
  	</tr>
  	<tr>
  		<td><input name="operator" type="submit" value="CE" /></td>
  		<td><input name="operator" type="submit" value="C" /></td>
  		<td><input name="operator" type="submit" value="BS" /></td>
  		<td><input name="operator" type="submit" value="/" /></td>
  	</tr>
  	<tr>
  		<td><input name="value" type="submit" value="7" /></td>
  		<td><input name="value" type="submit" value="8" /></td>
  		<td><input name="value" type="submit" value="9" /></td>
  		<td><input name="operator" type="submit" value="*" /></td>
  	</tr>
  	<tr>
  		<td><input name="value" type="submit" value="4" /></td>
  		<td><input name="value" type="submit" value="5" /></td>
  		<td><input name="value" type="submit" value="6" /></td>
  		<td><input name="operator" type="submit" value="-" /></td>
  	</tr>
  	<tr>
  		<td><input name="value" type="submit" value="1" /></td>
  		<td><input name="value" type="submit" value="2" /></td>
  		<td><input name="value" type="submit" value="3" /></td>
  		<td><input name="operator" type="submit" value="+" /></td>
  	</tr>
  	<tr>
  		<td></td>
  		<td><input name="value" type="submit" value="0" /></td>
  		<td><input name="dot" type="submit" value="." /></td>
  		<td><input name="operator" type="submit" value="=" /></td>
  	</tr>		
  </table>
  </form>
  </div>
</body>
</html>