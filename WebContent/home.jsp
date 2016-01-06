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
						The e-asset management application is developed to keep track of a
						number of assets that can be borrowed, their availability, their
						current location, the current borrower and the asset history.
						Assets include Computers, Books and Peripherals. The system should
						also be extensible for other types of assets.</p>
					<p class="description padding20 bg-grayLighter" id="_general">
						The roles involved in the application are the administrator
						(maximum of one) and borrowers (one or more). Both administrator
						and borrowers are authenticated using a username/password
						combination. The system may keep track of other attributes such as
						the Name, telephone number, position in the organization and email
						address.</p>
					<p class="description padding20 bg-grayLighter" id="_general">
						Assets are entered in the database by the administrator when
						acquired, deleted from the database when they become obsolete. The
						availability is updated whenever it is borrowed or returned. When
						a borrower fails to return an asset on time, the system should not
						allow lending anymore assets by him/her.</p>
					<p class="description padding20 bg-grayLighter" id="_general">
						The borrower searches for the assets in the database to determine
						their availability and borrows/returns assets. In case of overdue
						assets, fine should be levied.</p>
					<p class="description padding20 bg-grayLighter" id="_general">
						The persistent storage is to be realized with Oracle database and
						the business logic is to be realized with J2EE.</p>

				</div>
			</div>
		</div>

</body>
</html>