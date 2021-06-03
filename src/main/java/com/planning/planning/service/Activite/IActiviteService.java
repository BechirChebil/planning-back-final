package com.planning.planning.service.Activite;

import com.planning.planning.Model.Activite;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActiviteService {

   Activite addActivite(Activite activite);
   Activite updateActivite(Activite activiteToUpdate, Activite activite);
   public Activite getActivite(Long activiteId);
   public List<Activite> getActivities();
   public void deleteActivite(Long activteId);
}
