<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="author" content="Riddle">

<link href="css/metro-bootstrap.css" rel="stylesheet">
<link href="css/metro-bootstrap-responsive.css" rel="stylesheet">

<!-- Load JavaScript Libraries -->
<script src="js/metro-dropdown.js"></script>
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery.widget.min.js"></script>
<script src="js/jquery/jquery.mousewheel.js"></script>
<script src="js/prettify/prettify.js"></script>

<!-- Metro UI CSS JavaScript plugins -->
<script src="js/jquery/metro.min.js"></script>

<!-- Metro UI CSS JavaScript plugins -->
<script src="js/load-metro.js"></script>


<title>E-ASSET</title>

<script src="js/metro-dropdown.js"></script>
</head>



<body class="metro">



	<%
		String nm = session.getAttribute("userName").toString();
	%>
	<div class="container">
		<h1>
			Welcome
			<%=nm%>
		</h1>

		<div class="grid offset1">
			<div class="row">
				<div class="span9">
					<p class="description padding20 bg-grayLighter" id="_general">
						This is user home page</p>

				</div>
			</div>
		</div>

</body>
</html>