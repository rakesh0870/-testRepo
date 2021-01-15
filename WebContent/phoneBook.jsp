<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Phone Book</title>
</head>
<script>
	function loadDoc() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var text = "";
				var i;
				for (i = 0; i < this.responseText.length; i++) {
					text += cars[i] + "<br>";
				}
				document.getElementById("displayNames").innerHTML = text;
			}
		};
		xhttp.open("GET", "/getNames", true);
		xhttp.send();
	}
</script>
<body>
	<h1>Phone Book</h1>
	<h2>
		<a href="list">Phone Book</a>
	</h2>
	<div align="center">
		name : <input type="text" onclick="loadDoc()" /> <span
			class="displayNames" id="displayNames"></span>
	</div>
</body>
</html>
