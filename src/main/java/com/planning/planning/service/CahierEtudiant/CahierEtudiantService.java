package com.planning.planning.service.CahierEtudiant;


import com.planning.planning.Model.CahierEtudiant;
import com.planning.planning.repositories.Activite.IActiviteRepository;
import com.planning.planning.repositories.CahierEtudiant.ICahierEtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CahierEtudiantService implements ICahierEtudiantService {

    ICahierEtudiantRepository cahierEtudiantRepository;

    public CahierEtudiantService(ICahierEtudiantRepository cahierEtudiantRepository) {
        this.cahierEtudiantRepository = cahierEtudiantRepository;
    }

    @Override
    public CahierEtudiant addCahierEtudiant(CahierEtudiant cahierEtudiant) {
        cahierEtudiantRepository.save(cahierEtudiant);
        return cahierEtudiant;
    }

    @Override
    public CahierEtudiant updateCahierEtudiant(CahierEtudiant cahierEtudiantToUpdate, CahierEtudiant cahierEtudiant) {
        cahierEtudiantToUpdate.setPlanning(cahierEtudiant.getPlanning() != null ? cahierEtudiant.getPlanning() : cahierEtudiantToUpdate.getPlanning());
        cahierEtudiantToUpdate.setActivite(cahierEtudiant.getActivite() != null ? cahierEtudiant.getActivite() : cahierEtudiantToUpdate.getActivite());

        cahierEtudiantRepository.save(cahierEtudiantToUpdate);
        return cahierEtudiantToUpdate;
    }

    @Override
    public CahierEtudiant getCahierEtudiant(Long cahierEtudiantId) {
        Optional<CahierEtudiant> cahierEtudiant = cahierEtudiantRepository.findById(cahierEtudiantId);
        return cahierEtudiant.orElse(null);
    }

    @Override
    public List<CahierEtudiant> getCahierEtudiants() {
        return (List<CahierEtudiant>) cahierEtudiantRepository.findAll();
    }

    @Override
    public void deleteCahierEtudiant(Long cahierEtudiantId) {
        Optional<CahierEtudiant> cahierEtudiant = cahierEtudiantRepository.findById(cahierEtudiantId);
        cahierEtudiant.ifPresent(value -> cahierEtudiantRepository.delete(value));

    }
}
