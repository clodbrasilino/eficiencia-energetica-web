/**
 * 		
 */

function confirmaExclusaoGerente(id){
	if(confirm("Tem certeza de que deseja excluir este Gerente de Salas?")){
		window.location="/see/ServletExcluirGerente?id="+id;
	}else{
		window.location="/see/JSP/administrador/administrador.jsp";
	}
}

function confirmaExclusaoSala(id){
	if(confirm("Tem certeza de que deseja excluir esta Sala?")){
		window.location="/see/ServletExcluirSala?id="+id;
	}else{
		window.location="/see/JSP/gerente/gerente.jsp";
	}
}

function confirmaExclusaoMicroControlador(id) {
	if(confirm("Tem certeza de que deseja excluir este MicroControlador?")) {
		window.location="/see/ServletExcluirMicroControlador?id=" + id;
	} else {
		window.location="/see/JSP/gerente/alterarSala.jsp";
	}
}
	
	
