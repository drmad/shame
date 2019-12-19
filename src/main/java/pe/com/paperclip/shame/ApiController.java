package pe.com.paperclip.shame;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final AtomicLong requestCounter = new AtomicLong();
	
	private ActionResponse response;
	
	@Autowired
	private ContactRepository contactRepository; 

	@GetMapping("")
	public ActionResponse info() {
		//this.Response = new InfoResponse(requestCounter.incrementAndGet(), "Hello there!");
		response = new ActionResponse(requestCounter.incrementAndGet());
		
		response.setStatus("ok");
		response.setMessage("Hello there! This cute CRUD API is bought to you by drmad/paperclip 😎");
		
		return response;
	}
	
	@GetMapping("contacts")
	public ActionResponse listUsers() {
		response = new ActionResponse(requestCounter.incrementAndGet());
		response.setStatus("ok");
		response.setMessage("Contact list follows.");
		response.setData(contactRepository.findAll());
		
		return response;
	}
	
	@GetMapping("contact/{contactId}")
	public ActionResponse getContact(@PathVariable Integer contactId) {
		Optional<ContactEntity> contact = contactRepository.findById(contactId);
		
		response = new ActionResponse(requestCounter.incrementAndGet());
		
		if (contact.isPresent()) {
			response.setStatus("ok");
			response.setMessage("Contact follows.");
			response.setData(contact);
		} else {
			response.setStatus("error");
			response.setMessage("Contact " + Integer.toString(contactId) + " not found.");
		}
				
				
		return response;
	}
	
	@PostMapping("contact")
	public ActionResponse createContact(@RequestParam String name, @RequestParam String email) {
	
		ContactEntity contact = new ContactEntity();
		contact.setName(name);
		contact.setEmail(email);
		
		contactRepository.save(contact);
	
		response = new ActionResponse(requestCounter.incrementAndGet());
		
		response.setStatus("ok");
		response.setMessage("User created.");
		
		return response;
	}
}