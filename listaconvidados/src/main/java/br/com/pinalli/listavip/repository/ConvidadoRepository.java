package br.com.pinalli.listavip.repository;
/* A interface apenas tem os indicadores que quais classes são a entidade e o identificador único, 
 * que neste caso são: A classe Convidado e o atributo do tipo Long. */
import org.springframework.data.repository.CrudRepository;

import br.com.pinalli.listavip.models.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
	
}

