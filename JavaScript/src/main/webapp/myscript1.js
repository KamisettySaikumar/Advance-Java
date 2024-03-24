function toDolartoINR()
{
	//read the DolarInput store in variable
	const dolarInput=document.getElementById('dolarInput').value;
	//convert the dolarInput to INRoutput
	const INR=parseFloat(dolarInput*82.89);
	//set the output to  field
	document.getElementById('INRoutput').value=INR.toFixed(2);

}