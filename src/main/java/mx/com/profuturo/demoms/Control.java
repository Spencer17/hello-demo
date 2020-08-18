package mx.com.profuturo.demoms;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Control {

	private static final String TEMPLATE = "Hello, %s y la propiedad demo es %s !";

	private final AtomicLong counter = new AtomicLong();

	@Value("${propiedad.demo}")
	private String ejemploPropiedad;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/saveUser")
	public Boolean saveUser(@RequestBody User u) {
		return userService.saveUser(u);
	}

	@GetMapping("/hello-world")
	@ResponseBody
	public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name, ejemploPropiedad));
	}

}
