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
	
	
