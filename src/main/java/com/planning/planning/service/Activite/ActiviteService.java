package com.planning.planning.service.Activite;

import com.planning.planning.Model.Activite;
import com.planning.planning.repositories.Activite.IActiviteRepository;
import jdk.vm.ci.meta.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService implements IActiviteService {

    IActiviteRepository activiteRepository;

    public ActiviteService(IActiviteRepository activiteRepository){
        this.activiteRepository = activiteRepository;
    }

    @Override
        public Activite addActivite(Activite activite) {
        activiteRepository.save(activite);
        return activite;
    }

    @Override
    public Activite updateActivite(Activite activiteToUpdate, Activite activite) {
        activiteRepository.save(activite);
        return activite;
    }

    @Override
    public Activite getActivite(Long activiteId) {
        Optional<Activite> activite = activiteRepository.findById(activiteId);
        return activite.orElse(null);
    }

    @Override
    public List<Activite> getActivities() {
        return (List<Activite>) activiteRepository.findAll();
    }

    @Override
    public void deleteActivite(Long activteId) {
        Optional<Activite> activite= activiteRepository.findById(activteId);
        activite.ifPresent(value -> activiteRepository.delete(value));

    }


}
