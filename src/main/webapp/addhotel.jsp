<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add Hotel</title>

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
            margin-top: 200px;
        }

        .city-image {
            width: 100%;
            border-radius: 10px;
            object-fit: cover;
            height: 250px;
        }
    </style>
</head>
<body>

<%@ include file="header.jsp" %> <!-- Include the header file -->

<main role="main">
    <div class="container form-container">
        <form name="frm" id="frm" action="addhotel" method="get" onsubmit="" style="margin-left:100px;">
            <div class="form-group">
                <input type="text" required name="hotel_name" id="txtHotel" class="form-control" placeholder="Hotel Name" />
                <br>
                 <input type="text" required name="city" id="txthCity" class="form-control" placeholder="Hotel City" />
                <br>
                 <input type="text" required name="area" id="txtArea" class="form-control" placeholder="Hotel Area" />
                <br>
                 <input type="text" required name="price_per_night" id="txtPrice" class="form-control" placeholder="Price" />
                <br>
                 <input type="text" required name="amenities_name" id="txtAme" class="form-control" placeholder="Hotel Amenities" />
                <br>
                <span id="s"></span>
            </div>
            <div class="form-group">
                <input type="submit" id="btn" name="s" value="Add New Hotel" class="form-control" />
            </div>
        </form>
        <div class="image-container" style="margin-right:80px;">
            <img src="Imgs/city_img.jpg" alt="City Image" class="city-image" />
        </div>
    </div>
</main>

</body>
</html>
