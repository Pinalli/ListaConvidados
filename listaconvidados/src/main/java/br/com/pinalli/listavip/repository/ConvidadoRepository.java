package br.com.pinalli.listavip.repository;
/* A interface apenas tem os indicadores que quais classes s�o a entidade e o identificador �nico, 
 * que neste caso s�o: A classe Convidado e o atributo do tipo Long. */
import org.springframework.data.repository.CrudRepository;

import br.com.pinalli.listavip.models.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
	
}

