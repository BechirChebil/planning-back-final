package com.planning.planning.Model;

import javax.persistence.*;

@Entity
public class CahierTuteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resourcesTuteur;
    private String indicationsTuteur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activite_id", referencedColumnName = "id")
    private Activite activite;

    public CahierTuteur() {
    }

    public CahierTuteur(String resourcesTuteur, String indicationsTuteur, Activite activite) {
        this.resourcesTuteur = resourcesTuteur;
        this.indicationsTuteur = indicationsTuteur;
        this.activite = activite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
