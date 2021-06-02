package com.planning.planning.service.Planning;

import com.planning.planning.Model.Planning;
import com.planning.planning.repositories.Plannig.IPlanningRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanningService implements IPlanningService{

    IPlanningRepository planningRepository;

    public PlanningService(IPlanningRepository planningRepository){
        this.planningRepository = planningRepository;
    }

    @Override
    public Planning addPlanning(Planning planning) {
        planningRepository.save(planning);
        return planning;
    }

    @Override
    public Planning updatePlanning(Planning planningToUpdate, Planning planning) {
        planningRepository.save(planning);
        return planning;
    }

    @Override
    public Planning getPlanning(Long planningId) {
        return null;
    }

    @Override
    public List<Planning> getPlannings() {
        return null;
    }

    @Override
    public void deletePlanning(Long planningId) {

    }
}
