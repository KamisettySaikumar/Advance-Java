function reversed()
{
	const String=document.getElementById("stringvalue").value;
	var re="";
	for(i=String.length-1;i>=0;i--){
		re=re+String.charAt(i);
		}
		document.getElementById("Reverset").value=re;
		}
