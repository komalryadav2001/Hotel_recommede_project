function validateCity()
{
	var cityName=document.getElementById("txtCity").value;
	let regExp=/^[a-zA-Z]+$/;
	let result=regExp.test(cityName);
	if(result==false){
		let span=document.getElementById("s");
		span.innerHTML="invalid city name";
		let button=document.getElementById("btn");
		button.disabled=true;
		return false;
	}
	else{
		let span=document.getElementById("s");
		span.innerHTML="";
		let button=document.getElementById("btn");
		button.disabled=false;
		return true;
	}
}
/*//search data
function serchUsingAjax(str){
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("showGrid").innerHTML=this.responseText;
		}
	};
	xhttp.open("GET","searchCity?n="+str,true);
	xhttp.send();
}*/

//update data
 function showUpdateForm(cityName) {
        document.getElementById("cityListDiv").style.display = "none";
        document.getElementById("updateFormDiv").style.display = "block";
        document.getElementById("cityNameInput").value = cityName;
    }

    function hideUpdateForm() {
        document.getElementById("updateFormDiv").style.display = "none";
        document.getElementById("cityListDiv").style.display = "block";
    }