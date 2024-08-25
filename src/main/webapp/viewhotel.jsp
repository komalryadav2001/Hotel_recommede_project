<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,org.recommend.model.*,org.recommend.repository.*,org.recommend.service.*"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View Hotels</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
body {
	background-image: url("Imgs/bg5.jpg");
	background-size: 100% auto;
}

.form-container {
	display: flex;
	align-items: center;
	justify-content: space-between;
	background-color: rgba(255, 255, 255, 0.5);
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 80%;
	margin: 20px auto;
}

.city-image {
	width: 100%;
	border-radius: 10px;
	object-fit: cover;
	height: 250px;
}

.table thead th, .table tbody tr td {
	color: white;
}

.action-link {
	color: white;
	text-decoration: none;
}

.action-link:hover {
	text-decoration: none;
	text-color: white;
}

.id-cell {
	color: white;
}

a {
	color: white;
	text-decoration: none;
}

a:hover {
	color: white;
	text-decoration: none;
	cursor: pointer;
}
</style>

<script type="text/javascript">
function serchUsingAjax() {
    let city = document.getElementById("txtCity").value;
    let area = document.getElementById("txtArea").value;

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("showGrid").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "searchhotel?city=" + city + "&area=" + area, true);
    xhttp.send();
}

</script>

</head>
<body>

	<%@ include file="header.jsp"%>
	<!-- Include the header file -->

	<main role="main" style="margin-top: 60px;">
		<div class="container form-container">

			<input type="text" required name="city" id="txtCity"
				class="form-control mr-5" placeholder="Search City"
				onkeyup="serchUsingAjax()" /> <br> <input type="text" required
				name="area" id="txtArea" class="form-control"
				placeholder="Search Area" onkeyup="serchUsingAjax()" /> <br> <span
				id="searchResults"></span>

		</div>

		<div id="showGrid" class="container">
			<!-- Initial city list will be loaded here -->
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Hotel NAME</th>
						<th scope="col">City</th>
						<th scope="col">Area</th>
						<th scope="col">Price</th>
						<th scope="col">Amenities</th>
						<th scope="col">DELETE</th>
						<th scope="col">UPDATE</th>
					</tr>
				</thead>
				<tbody>
					<%
					HotelService serv = new HotelServiceImpl();
					List<HotelModel> hotelList = serv.isViewHotelList();

					if (hotelList != null && !hotelList.isEmpty()) {
						int i = 1;
						for (HotelModel hotel : hotelList) {
					%>
					<tr>
						<th scope="row" class="id-cell"><%=i++%></th>
						<td><%=hotel.getHname()%></td>
						<td><%=hotel.getCity()%></td>
						<td><%=hotel.getArea()%></td>
						<td><%=hotel.getPrice()%></td>
						<td><%=hotel.getAmenities()%></td>
						<td><a href='delhotel?hotel_id=<%=hotel.getHid()%>'
							class="action-link">DELETE</a></td>
						<td><a
							href='updatehotel?hotel_id=<%=hotel.getHid()%>&hotel_name=<%=hotel.getHname()%>&price_per_night=<%=hotel.getPrice()%>&amenities_name=<%=hotel.getAmenities()%>'
							class="action-link">UPDATE</a></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="4" class="text-center">No cities found</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</main>

</body>
</html>
