package com.planning.planning.Model;

import javax.persistence.*;

@Entity
public class CahierTuteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resourcesTuteur;
    private String indicationsTuteur;

    @OneToOne
    //@JoinColumn(name = "id", referencedColumnName = "id")
    private Planning planning;

    @OneToOne
    //@JoinColumn(name = "activite_id", referencedColumnName = "id")
    private Activite activite;

    public CahierTuteur() {
    }

    public CahierTuteur(String resourcesTuteur, String indicationsTuteur, Planning planning, Activite activite) {
        this.resourcesTuteur = resourcesTuteur;
        this.indicationsTuteur = indicationsTuteur;
        this.planning = planning;
        this.activite = activite;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public String getResourcesTuteur() {
        return resourcesTuteur;
    }

    public void setResourcesTuteur(String resourcesTuteur) {
        this.resourcesTuteur = resourcesTuteur;
    }

    public String getIndicationsTuteur() {
        return indicationsTuteur;
    }

    public void setIndicationsTuteur(String indicationsTuteur) {
        this.indicationsTuteur = indicationsTuteur;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }


}
