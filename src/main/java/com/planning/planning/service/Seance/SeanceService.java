package com.planning.planning.service.Seance;

import com.planning.planning.Model.Seance;
import com.planning.planning.repositories.Seance.ISeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService implements ISeanceService {

    ISeanceRepository seanceRepository;

    public SeanceService(ISeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public Seance addSeance(Seance seance) {
        seanceRepository.save(seance);
        return seance;
    }

    @Override
    public Seance updateSeance(Seance seanceToUpdate, Seance seance) {
        seanceToUpdate.setSujet(seance.getSujet() != null ? seance.getSujet() : seanceToUpdate.getSujet());
        seanceToUpdate.setObjectif(seance.getObjectif() != null ? seance.getObjectif() : seanceToUpdate.getObjectif());
        seanceToUpdate.setAller(seance.getAller() != null ? seance.getAller() : seanceToUpdate.getAller());
        seanceToUpdate.setRetour(seance.getRetour() != null ? seance.getRetour() : seanceToUpdate.getRetour());
        seanceToUpdate.setStartTimeRetour(seance.getStartTimeRetour()  != null ? seance.getStartTimeRetour() : seanceToUpdate.getStartTimeRetour());
        seanceToUpdate.setEndTimeRetour(seance.getEndTimeRetour()  != null ? seance.getEndTimeRetour() : seanceToUpdate.getEndTimeRetour());
        seanceToUpdate.setDate(seance.getDate()  != null ? seance.getDate() : seanceToUpdate.getDate());
        seanceToUpdate.setCreneau(seance.getCreneau()  != null ? seance.getCreneau() : seanceToUpdate.getCreneau());
       // seanceToUpdate.setPhases(seance.getPhases()  != null ? seance.getPhases() : seanceToUpdate.getPhases());
        seanceToUpdate.setPlanning(seance.getPlanning()  != null ? seance.getPlanning() : seanceToUpdate.getPlanning());

        if (seance.getPhases() != null) {
            seanceToUpdate.setPhases(seance.getPhases());
        }
        seanceRepository.save(seanceToUpdate);
        return seanceToUpdate;
    }

    @Override
    public Seance getSeance(Long seanceId) {
        Optional<Seance> seance = seanceRepository.findById(seanceId);
        return seance.orElse(null);
    }

    @Override
    public List<Seance> getSeances() {
        return (List<Seance>) seanceRepository.findAll();
    }

    @Override
    public void deleteSeance(Long seanceId) {
        Optional<Seance> seance = seanceRepository.findById(seanceId);
        // equivalent to if seance.isPresent ---> delete seance object
        seance.ifPresent(value -> seanceRepository.delete(value));
    }
}
