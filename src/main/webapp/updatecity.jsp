<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,org.recommend.model.*,org.recommend.repository.*,org.recommend.service.*"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update Cities</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
body {
	background-image: url("Imgs/bg5.jpg");
	background-size: cover;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

#updateFormDiv {
	background-color: rgba(255, 255, 255, 0.9);
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	margin-right: 200px;
}

input[type="text"], input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-top: 10px;
	margin-bottom: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>

</head>
<body>

	<%@ include file="header.jsp"%>
	<!-- Include the header file -->

	<main role="main">
		<div id="updateFormDiv">
			<form action="updatecity" method="post">
				<input type='hidden' name='cid'
					value='<%=request.getAttribute("cityId")%>' /> <input
					type='text' name='cname' id="cityNameInput"
					value='<%=request.getAttribute("cityName")%>'> <br>
				<input type='submit' name='s' value='Update City' />
			</form>

		</div>
	</main>

</body>
</html>