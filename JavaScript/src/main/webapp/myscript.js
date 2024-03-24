function ConvertToFahrenhit()
{
	//read the fahrenhit input store in variable
	const fahrenhitinput=document.getElementById('fahrenhitinput').value;
	//convert the fahrenhit input to celsius
	const CalsiusTemparature=parseFloat((fahrenhitinput-32)*5/9);
	//set the output to celsius output field
	document.getElementById('calsiusoutput').value=CalsiusTemparature.toFixed(2);
}
