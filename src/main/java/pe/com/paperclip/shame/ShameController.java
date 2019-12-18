package pe.com.paperclip.shame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ShameController {

	@GetMapping("/")
	String home(Model model) {
		return "home";
	}
}
