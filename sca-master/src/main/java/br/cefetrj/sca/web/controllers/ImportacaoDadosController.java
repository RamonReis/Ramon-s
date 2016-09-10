package br.cefetrj.sca.web.controllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.cefetrj.sca.service.ImportacaoDadosService;

@Controller
@RequestMapping("/importacaoDados")
public class ImportacaoDadosController {

	@Autowired
	private ImportacaoDadosService service;

	DescritorImportacaoDados descritor = new DescritorImportacaoDados();

	protected Logger logger = Logger.getLogger(ImportacaoDadosController.class
			.getName());

	@RequestMapping(value = "/{*}", method = RequestMethod.GET)
	public String get(Model model) {
		model.addAttribute("error", "Erro: página não encontrada.");
		return "/homeView";
	}

	@RequestMapping(value = "/homeImportacaoDados", method = RequestMethod.GET)
	public String homeImportacaoDados(HttpServletRequest request,
			Model model) {
		try {
			model.addAttribute("descritor", descritor);
			return "/importacaoDados/homeImportacaoDadosView";
		} catch (Exception exc) {
			model.addAttribute("error", exc.getMessage());
			return "/homeView";
		}

	}

	@RequestMapping(value = "/importacaoDados", method = RequestMethod.POST)
	public String importacaoDados(HttpServletRequest request,
			Model model, @RequestParam("historicoFile") MultipartFile file,
			Long tipoImportacao) {
		try {
			String response = service.importar(file, tipoImportacao);
			model.addAttribute("response", response);
			model.addAttribute("descritor", descritor);
			return "/importacaoDados/homeImportacaoDadosView";
		} catch (Exception exc) {
			exc.printStackTrace();
			model.addAttribute("error", exc.getMessage());
			return "/homeView";
		}
	}

}
