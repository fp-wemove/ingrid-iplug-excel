package de.ingrid.iplug.excel.controller;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.ingrid.iplug.excel.model.Sheet;
import de.ingrid.iplug.excel.model.Sheets;

@Controller
@SessionAttributes("sheets")
public class PreviewExcelFileController {

    @RequestMapping(value = "/iplug-pages/previewExcelFile.html", method = RequestMethod.GET)
	public String settings(final ModelMap model,
			@ModelAttribute("sheets") final Sheets sheets) {

        return "/iplug-pages/previewExcelFile";
	}

    @RequestMapping(value = "/iplug-pages/previewExcelFile.html", method = RequestMethod.POST)
	public String postSettings(@ModelAttribute("sheets") final Sheets sheets, @RequestParam(required=false) final Integer sheetIndex){
		if (null == sheetIndex) {
            return "/iplug-pages/previewExcelFile";
		}

		final Iterator<Sheet> iterator = sheets.getSheets().iterator();
		while (iterator.hasNext()) {
			final Sheet next = iterator.next();
			if (next.getSheetIndex() != sheetIndex.intValue()) {
				iterator.remove();
			}
		}
        return "redirect:/iplug-pages/settings.html";
	}

}
