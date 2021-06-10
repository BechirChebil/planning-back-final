package com.planning.planning.Model;

import com.planning.planning.Model.*;
import javax.persistence.*;

@Entity
public class CahierEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resourcesEtudiant;
    private String indicationsEtudiant;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activite_id", referencedColumnName = "id")
    private Activite activite;

    public CahierEtudiant() {
    }

    public CahierEtudiant(String resourcesEtudiant, String indicationsEtudiant, Activite activite) {
        this.resourcesEtudiant = resourcesEtudiant;
        this.indicationsEtudiant = indicationsEtudiant;
        this.activite = activite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourcesEtudiant() {
        return resourcesEtudiant;
    }

    public void setResourcesEtudiant(String resourcesEtudiant) {
        this.resourcesEtudiant = resourcesEtudiant;
    }

    public String getIndicationsEtudiant() {
        return indicationsEtudiant;
    }

    public void setIndicationsEtudiant(String indicationsEtudiant) {
        this.indicationsEtudiant = indicationsEtudiant;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }
}
