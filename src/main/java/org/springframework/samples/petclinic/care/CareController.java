package org.springframework.samples.petclinic.care;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit")
public class CareController {
    @Autowired
    private CareService cs;

    @Autowired
    private PetService pService;

    @GetMapping(path = "/{X}/care/create")
	public String initCreationForm(@PathVariable("X") int X,ModelMap model) {
		CareProvision care = new CareProvision();
		model.put("providedCare", care);
        model.put("cares",cs.getAllCompatibleCares(pService.findVisitById(X).getPet().getType().getName()));
        return "care/createOrUpdateProvidedCareForm";
	}

    // @PostMapping(value = "{X}/care/create")
	// public String processCreationForm(@Valid CareProvision care, BindingResult result, ModelMap model){		
	// 	if (result.hasErrors()) {
	// 		model.put("providedCare", care);
	// 		return "care/createOrUpdateProvidedCareForm";
	// 	}
	// 	else {

    //         try{
    //             this.cs.save(care);
    //             return "welcome";
    //         }catch(UnfeasibleVaccinationException ex){
    //             result.rejectValue("vaccine", "La mascota seleccionada no puede recibir la vacuna especificada.", "La mascota seleccionada no puede recibir la vacuna especificada.");
    //             //model.put("message", "La mascota seleccionada no puede recibir la vacuna especificada.");
    //             return "care/createOrUpdateProvidedCareForm";
    //         }


	// 	}
	// }

}
