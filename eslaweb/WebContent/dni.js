
//aquí empieza el código javascritp
	const SECUENCIA = "TRWAGMYFPDXBNJZSQVHLCKE";//esto es una constante
	const DIVISOR = 23;
	
	function calcularLetraDni() 
	{
		var dni = document.getElementById("dni").value;
		var resto = dni % DIVISOR;
		var letra = SECUENCIA.substring(resto, resto + 1);
		document.getElementById("letra").value = letra;
	}
	
	function tocoImagen()
	{
		console.log ("Toco imagen");
		//si está abierto
			//cerro
			//cambio imagen a ojocerrado 
			//cambio type a password
		//si no, está cerrado
			//abro
			//cambio imagen a ojoabierto
			//cambio type a text
		
		
		var tipo = document.getElementById("cajapwd").type;
		if (tipo == "text")
			{ //está abierto
			console.log("abierto, lo voy a cerrar");
			document.getElementById("cajapwd").type = "password";
			document.getElementById("ojo").src = "ojocerrado.png";
			
			//var divcomen = document.getElementById("comentarios");
			//divcomen.innerHTML = "ADIOS";
			var elto_img = document.createElement('img');
			elto_img = "ojocerrado.png";
			
			document.getElementById("comentarios").appendChild(elto_img);// .appendChild(elto_img);
			
			}
		else{//ponía password, estaba cerrado
			console.log("cerrado, lo voy a abrir");
			document.getElementById("cajapwd").type = "text";
			document.getElementById("ojo").src = "ojoabierto.png";
			}
		
		//document.getElementById("cajapwd").type = "text";
		//document.getElementById("ojo").src = "ojoabierto.png";
	}
	
	
	
	
	
	
//aquí acaba el código javascritp