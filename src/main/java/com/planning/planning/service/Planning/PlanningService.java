package com.planning.planning.service.Planning;

import com.planning.planning.Model.Planning;
import com.planning.planning.repositories.Plannig.IPlanningRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanningService implements IPlanningService{

    IPlanningRepository IPlanningRepository;

    public PlanningService(IPlanningRepository planningRepository){
        this.IPlanningRepository = planningRepository;
    }

    @Override
    public Planning addPlanning(Planning planning) {
        IPlanningRepository.save(planning);
        return planning;
    }

    @Override
    public Planning updatePlanning(Planning planningToUpdate, Planning planning) {

        planningToUpdate.setTitre(planning.getTitre() != null ? planning.getTitre() : planningToUpdate.getTitre());
       // planningToUpdate.setStartTime(planning.getDiscription() != null ? planning.getDiscription() : planningToUpdate.getDiscription());
        //planningToUpdate.setRendu(planning.getRendu() != null ? planning.getRendu() : planningToUpdate.getRendu());
        planningToUpdate.setStartTime(planning.getStartTime() != null ? planning.getStartTime() : planningToUpdate.getStartTime());
        //planningToUpdate.setSeances(planning.getSeances()  != null ? planning.getSeances() : planningToUpdate.getSeances());

        if (planning.getSeances() != null) {
            planningToUpdate.setSeances(planning.getSeances());
        }

        IPlanningRepository.save(planningToUpdate);
        return planningToUpdate;
    }

    @Override
    public Planning getPlanning(Long planningId) {
        Optional<Planning> planning = IPlanningRepository.findById(planningId);
        return planning.orElse(null);
    }

    @Override
    public List<Planning> getPlannings() {
        return (List<Planning>) IPlanningRepository.findAll();
    }

    @Override
    public void deletePlanning(Long planningId) {
        Optional<Planning> planning = IPlanningRepository.findById(planningId);
        planning.ifPresent(value->IPlanningRepository.delete(value));
    }
}
