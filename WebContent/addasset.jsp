<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Asset</title>
<%
	String uname = session.getAttribute("userName").toString();
	if (uname == "") {
response.sendRedirect("login.jsp");
	}
%>
<link href="css/metro-bootstrap.css" rel="stylesheet">
    <link href="css/metro-bootstrap-responsive.css" rel="stylesheet">

 <!-- Load JavaScript Libraries -->
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/jquery/jquery.widget.min.js"></script>
    <script src="js/jquery/jquery.mousewheel.js"></script>
    <script src="js/prettify/prettify.js"></script>

 <!-- Metro UI CSS JavaScript plugins -->
    <script src="js/jquery/metro.min.js"></script> 

 <!-- Metro UI CSS JavaScript plugins -->
    <script src="js/load-metro.js"></script>

    <title>E-Assets</title>
</head><body class="metro">
<div class="grid fluid">
			
	       		<div class="row span6 offset3 ">

<form action="AddAssetServlet" method="post">
	
<fieldset>                                   
			<legend>NEW ASSET</legend>
				<label>asset type</label>					
					<div class="input-control select">
    <select name="type">
        <option value="book">Books</option>
        <option value="electronics">Electronics</option>
    </select>
</div>
					<label>sub type</label>
					<div class="input-control text" data-role="input-control">
                                            <input type="text" name="subType" placeholder="eg. C,C++,Java,Math etc.">
                                            <button class="btn-clear" tabindex="-1"></button>
                                        </div>

					<label>asset name</label>
					<div class="input-control text" data-role="input-control">
                                            <input type="text" name="assetName" placeholder="enter asset name">
                                            <button class="btn-clear" tabindex="-1"></button>
                                        </div>


					<label>purchase date</label>
					<div class="input-control text" data-role="input-control">
                                            <input type="text" name="purchaseDate" placeholder="enter purchase date">
                                            <button class="btn-clear" tabindex="-1"></button>
                                        </div>


					<label>vendor name</label>
					<div class="input-control text" data-role="input-control">
                                            <input type="text" name="vendorName" placeholder="enter vendor name">
                                            <button class="btn-clear" tabindex="-1"></button>
                                        </div>


					<label>deposit amount(%)</label>
					<div class="input-control text" data-role="input-control">
                                            <input type="text" name="depositPercent" placeholder="enter deposit percent">
                                            <button class="btn-clear" tabindex="-1"></button>
                                        </div>


					<label>price</label>
					<div class="input-control text" data-role="input-control">
                                            <input type="text" name="price" placeholder="enter price">
                                            <button class="btn-clear" tabindex="-1"></button>
                                        </div>


					<label>quantity</label>
					<div class="input-control text" data-role="input-control">
                                            <input type="text" name="quantity" value="1" placeholder="enter quantity">
                                            <button class="btn-clear" tabindex="-1"></button>
                                        </div>

</br>
                                        <input type="submit" value="SUBMIT">
					<input type="submit" value="CLEAR">
             </fieldset>



</form>
</body>
</html>