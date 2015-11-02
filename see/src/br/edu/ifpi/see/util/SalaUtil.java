package br.edu.ifpi.see.util;

import java.util.List;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.model.Status;

public class SalaUtil {
	
	public static Sala getSala(int i, List<Sala> salas) {
		if(i >= salas.size()){
			Sala s = new Sala();
			s.setNumero("");
			s.setStatus(new Status("", "#eee", null));
			return s;
		}else{
			return salas.get(i);
		}
	}

}
