function ativaNome(){
		document.getElementById("txtNome").disabled = false;
	}
	function ativaEndereco(){
		document.getElementById("txtEndereco").disabled = false;
	}
	function ativaEmail(){
		document.getElementById("txtEmail").disabled = false;
	}
	function ativaTelefone(){
		document.getElementById("txtTelefone").disabled = false;
	}
	function showPopup() {
		var popup = document.getElementById('popup');
		popup.style.display = "block";
	}
	function closePopup() {
		var popup = document.getElementById('popup');
		popup.style.display = "none";
	}