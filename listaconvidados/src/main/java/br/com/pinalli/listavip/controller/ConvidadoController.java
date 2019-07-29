package br.com.pinalli.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.pinalli.enviaremail.enviaremail.EmailService;
import br.com.pinalli.listavip.models.Convidado;
import br.com.pinalli.listavip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository repository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		Iterable<Convidado> convidados = repository.findAll();

		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping(value= "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
	                   @RequestParam("telefone") String telefone, Model model ){

	    Convidado novoConvidado = new Convidado(nome, email, telefone);
	    repository.save(novoConvidado);
	    
	    new EmailService().enviar(nome, email); //usando o jar

	    Iterable<Convidado> convidados = repository.findAll();
	    model.addAttribute("convidados", convidados);

	    return "listaconvidados";
	}
}
