function validateForm()
{
	//Read the form Data
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var promadeIn=document.getElementById("promadeIn").value;
	
	
	if(proId.trim() === "" || proName.trim() === "" ||
	proPrice.trim() === "" || proBrand.trim() === ""||
	promadeIn.trim() === "")
	{
		alert("All fileds must be filled out");
		return false;
	}
	
	
	if(parseFloat(proPrice) < 0)
	{
		alert("proPrice must be a non-negative value");	
		return false;
	}
	
	
	if(proName.length > 50 || proBrand.length > 50)
	{
		alert("Product name and brand must be less than 50 Characters");
		return false;
	}
	
	//get the mfg & exp dates
	var promDate=document.getElementById("promDate").value;
	var promeDate=document.getElementById("proeDate").value;
	
	//convert into data format
	var manufacturingDataObj = new Date(promDate);
	var expiryDateObj = new Date(promeDate);
	
	//Check the validation of dates
	if(manufacturingDataObj > expiryDateObj)
	{
		alert("manufacturing date cannot be grater than expiry date.");
		return false;
	}
	return true;
}