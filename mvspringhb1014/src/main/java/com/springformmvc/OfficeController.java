package com.springformmvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import model.*;

@RestController
@RequestMapping("/office")
public class OfficeController {
	
	@RequestMapping(value="/{code}" , method=RequestMethod.GET )
    public Office getById(@PathVariable("code") String code) {
      Office o=OfficeDAO.getOfficeById(code);
      return o;
    }
}

