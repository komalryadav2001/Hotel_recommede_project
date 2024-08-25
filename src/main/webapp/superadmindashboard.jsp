<%@page import="org.recommend.service.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,org.recommend.model.*,org.recommend.repository.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/style.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<script type='text/javascript' src='JS/validate.js'></script>
</head>
<body>
	<div class="container myflex">
		<div class="nav flex-column nav-pills menubar mt-5" id="v-pills-tab"
			role="tablist" aria-orientation="vertical">
			<a class="nav-link active" id="v-pills-home-tab" data-toggle="pill"
				href="#v-pills-home" role="tab" aria-controls="v-pills-home"
				aria-selected="true">Master</a> <a class="nav-link"
				id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile"
				role="tab" aria-controls="v-pills-profile" aria-selected="false">Profile</a>
			<a class="nav-link" id="v-pills-messages-tab" data-toggle="pill"
				href="#v-pills-messages" role="tab" aria-controls="v-pills-messages"
				aria-selected="false">Messages</a> <a class="nav-link"
				id="v-pills-settings-tab" data-toggle="pill"
				href="#v-pills-settings" role="tab" aria-controls="v-pills-settings"
				aria-selected="false">Settings</a>
		</div>
		<div class="content">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active p-5 bg-white"
					id="v-pills-home" role="tabpanel"
					aria-labelledby="v-pills-home-tab">
					<!-- Company Master Tabs  -->

					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							id="pills-home-tab" data-toggle="pill" href="#pills-home"
							role="tab" aria-controls="pills-home" aria-selected="true">New
								City</a></li>
						<li class="nav-item"><a class="nav-link"
							id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
							role="tab" aria-controls="pills-profile" aria-selected="false">View
								City</a></li>
						<li class="nav-item"><a class="nav-link"
							id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
							role="tab" aria-controls="pills-contact" aria-selected="false">Search</a>
						</li>
					</ul>
					<div class="tab-content" id="pills-tabContent">
						<div class="tab-pane fade show active" id="pills-home"
							role="tabpanel" aria-labelledby="pills-home-tab">
							<form name='frm' id="frm" action='savecity' method='POST'
								onsubmit="validateCity()">
								<div class="form-group">
									<input type='text' required name='name' value='' id="txtCity"
										class="form-control" placeholder="City Name"
										onkeyup='validateCity()' /> <br> <span id="s"></span>
								</div>
								<div class="form-group">
									<input type='submit' id="btn" name='s' value='Add New City'
										class="form-control" />
								</div>
							</form>
						</div>

						<div class="tab-pane fade" id="pills-profile" role="tabpanel"
							aria-labelledby="pills-profile-tab">
							<%@page import="org.recommend.service.*,org.recommend.model.*"%>
							<div class="form-group">
									<input type='text' required name='name' value='' id="txtCity"
										class="form-control" placeholder="Search City"
										onkeyup="serchUsingAjax(this.value)"/> <br> <span id="s"></span>
								</div>
								<div id="showGrid">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">ID</th>
										<th scope="col">CITY NAME</th>
										<th scope="col">DELETE</th>
										<th scope="col">UPDATE</th>
									</tr>
								</thead>
								<tbody>
									<%
									CityService serv = new CityServiceImpl();
									List<viewCityListModel> cityList = serv.isViewCityList();

									if (cityList != null && !cityList.isEmpty()) {
										int i = 1;
										for (viewCityListModel city : cityList) {
									%>
									
									<tr>
										<th scope="row"><%=i++%></th>
										<td><%=city.getCname()%></td>
										<td><a href='delcity?cid=<%=city.getCid()%>'>DELETE</a></td>
										<td><a href='updatecity?cid=<%=city.getCid()%>&cname=<%=city.getCname()%>'>UPDATE</a></td>
									</tr>
									<%
									}
									} else {
									%>
									<tr>
										<td colspan="2">No cities found</td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
							</div>
						</div>


						<div id="updateFormDiv" style="display: none;">
							<form action="updatecity" method="post">
								<input type='hidden' name='cid'
									value='<%=request.getParameter("cid")%>' /> <input type='text'
									name='cityName' id="cityNameInput" value='' /> <br>
								<br> <input type='submit' name='s' value='Update City'
									onclick="hideUpdateForm();" />
							</form>
						</div>

						<div class="tab-pane fade" id="pills-contact" role="tabpanel"
							aria-labelledby="pills-contact-tab">
							</div>
					</div>
				</div>
				<div class="tab-pane fade p-5" id="v-pills-profile" role="tabpanel"
					aria-labelledby="v-pills-profile-tab">Cillum ad ut irure
					tempor velit nostrud occaecat ullamco aliqua anim Lorem sint.
					Veniam sint duis incididunt do esse magna mollit excepteur laborum
					qui. Id id reprehenderit sit est eu aliqua occaecat quis et velit
					excepteur laborum mollit dolore eiusmod. Ipsum dolor in occaecat
					commodo et voluptate minim reprehenderit mollit pariatur. Deserunt
					non laborum enim et cillum eu deserunt excepteur ea incididunt
					minim occaecat.</div>
				<div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
					aria-labelledby="v-pills-messages-tab">...</div>
				<div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
					aria-labelledby="v-pills-settings-tab">...</div>
			</div>
		</div>
	</div>
</body>
</html>