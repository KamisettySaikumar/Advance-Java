function validateForm()
{
	//Read the form data
	var proId = document.getElementById("proId").value;
	var proName = document.getElementById("proName").value;
	var proPrice = document.getElementById("proPrice").value;
	var proBrand = document.getElementById("proBrand").value;
	var proMade= document.getElementById("proMade").value;
	
	if (proId.trim() === "" || proName.trim() === "" ||
	proPrice.trim() === "" || proBrand.trim() === "" ||
	proMadeIn.trim() === "") {
		alert("All fields must be filled out");
		return false;
	}
	
	if (parseFloat(proPrice) < 0) {
		alert("proPrice must be a non - negative value");
		return false;
	}
	
	if (proName.Length > 50 || proBrand.length > 50) {
		alert("Product name and proBrand must be less than 50 characters");
		return false;
	}
	
	//get the mfg & exp dates
	var proManfDate = document.getElementById("proManfactureDate").value;
	var proExpDate = document.getElementById("proExpirefDate").value;
	
	//convert into date format
	var ManfactureDateObj = new Date(proManfDate);
	var ExpirefDateObj = new Date(proExpDate);
	
	//check the validition of dates
	if(ManfactureDateObj > ExpirefDateObj) {
		alert("Manufacturing date cannot be greater then expiry date.");
		return false;
	}
	return true;
}
