package com.planning.planning.service.Activite;

import com.planning.planning.Model.Activite;
import com.planning.planning.repositories.Activite.IActiviteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService implements IActiviteService {

    IActiviteRepository activityRepository;

    public ActiviteService(IActiviteRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    @Override
        public Activite addActivite(Activite activite) {
        activityRepository.save(activite);
        return activite;
    }

    @Override
    public Activite updateActivite(Activite activiteToUpdate, Activite activite) {
        activityRepository.save(activite);
        return activite;
    }

    @Override
    public Activite getActivite(Long activiteId) {
        Optional<Activite> activite = activityRepository.findById(activiteId);
        return activite.orElse(null);
    }

    @Override
    public List<Activite> getActivities() {
        return (List<Activite>) activityRepository.findAll();
    }

    @Override
    public void deleteActivite(Long activteId) {
        Optional<Activite> activite= activityRepository.findById(activteId);
        activite.ifPresent(value -> activityRepository.delete(value));

    }


}
