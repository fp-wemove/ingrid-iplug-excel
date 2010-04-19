package de.ingrid.iplug.excel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.ingrid.iplug.excel.model.DocumentType;
import de.ingrid.iplug.excel.model.Sheet;

/**
 * Controller to define Settings for mapped excel sheet.
 *
 */
@Controller
@SessionAttributes("sheet")
public class SettingsController {

    /**
     * Add DocumentType into ModelMap. 
     * 
     * @param model
     * @param sheet
     * @return
     * 		Web request "/iplug-pages/settings"
     */
    @RequestMapping(value = "/iplug-pages/settings.html", method = RequestMethod.GET)
    public String settings(final ModelMap model, @ModelAttribute("sheet") final Sheet sheet) {
		model.addAttribute("documentTypes", DocumentType.values());
        return "/iplug-pages/settings";
	}

    /**
     * Submit settings.
     * 
     * @param sheet
     * @return
     * 		Web request "redirect:/iplug-pages/mapping.html"
     */
    @RequestMapping(value = "/iplug-pages/settings.html", method = RequestMethod.POST)
    public String postSettings(@ModelAttribute("sheet") final Sheet sheet) {
        return "redirect:/iplug-pages/mapping.html";
	}
}
