package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareProvisionRepository extends CrudRepository<CareProvision,Integer>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
	
    @Query("SELECT P FROM CareProvision P")
    List<CareProvision> metodo();

    @Query("SELECT P FROM Care P")
    List<Care> findAllCares();
    
    
    @Query("SELECT g FROM Care g INNER JOIN g.compatiblePetTypes p WHERE p.name = :petTypeName")
    List<Care> findCompatibleCares(String petTypeName);

    @Query("SELECT P FROM Care P WHERE P.name LIKE :name")
    Care findCareByName(String name);
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
