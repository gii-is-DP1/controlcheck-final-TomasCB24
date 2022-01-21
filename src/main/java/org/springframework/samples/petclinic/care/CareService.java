package org.springframework.samples.petclinic.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CareService {    

    @Autowired
    private CareProvisionRepository cRepo;

    public List<Care> getAllCares(){
        return cRepo.findAllCares();
    }

    public List<CareProvision> getAllCaresProvisions(){
        return cRepo.findAll();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        return cRepo.findCompatibleCares(petTypeName);
    }

    public Care getCare(String careName) {
        return cRepo.findCareByName(careName);
    }

    
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        return null;   
    }

    public List<CareProvision> getAllCaresProvided(){
        return cRepo.findAll();
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return null;

    }
    
}
