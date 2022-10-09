package no.hvl.norskekunger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KongerController {

	@GetMapping(value = "/registrer")
	public String mottaRegistrering(Model model,@RequestParam int kongeaar) {
		System.out.print(kongeaar);
		Konge k = Konger.norske.stream().filter(p -> p.getKongeFraAar() < kongeaar && p.getKongeTilAar() > kongeaar).findFirst().orElse(null);

		model.addAttribute("k", k);
		return "konge";
	}
}
