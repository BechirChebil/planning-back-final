package com.planning.planning.service.Activite;

import com.planning.planning.Model.Activite;
import com.planning.planning.Model.Planning;

import java.util.List;

public interface IActiviteService {

   Activite addActivite(Activite activite);
   Activite updateActivite(Activite activiteToUpdate, Activite activite);
   public Activite getActivite(Long activiteId);
   public List<Activite> getActivities();
   public void deleteActivite(Long activteId);
}
