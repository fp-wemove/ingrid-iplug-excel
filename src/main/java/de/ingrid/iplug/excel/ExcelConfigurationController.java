package de.ingrid.iplug.excel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.ingrid.admin.command.PlugdescriptionCommandObject;


@Controller
@RequestMapping(value = "/iplug/welcome.html")
@SessionAttributes("plugDescription")
public class ExcelConfigurationController {

	@RequestMapping(method = RequestMethod.GET)
	public String welcome(
			@ModelAttribute("plugDescription") PlugdescriptionCommandObject commandObject) {
		return "/iplug/welcome";
	}

}
