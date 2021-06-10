package com.planning.planning.Model;


import javax.persistence.*;
import java.time.Duration;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private Duration duration;



    @OneToOne(mappedBy = "activite")
    private CahierEtudiant cahierEtudiant;

    @OneToOne(mappedBy = "activite")
    private CahierTuteur cahierTuteur;

    public Activite() {
    }

    public Activite(String titre, String description, Duration duration, CahierEtudiant cahierEtudiant, CahierTuteur cahierTuteur) {

        this.titre = titre;
        this.description = description;
        this.duration = duration;
        this.cahierEtudiant = cahierEtudiant;
        this.cahierTuteur = cahierTuteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public CahierEtudiant getCahierEtudiant() {
        return cahierEtudiant;
    }

    public void setCahierEtudiant(CahierEtudiant cahierEtudiant) {
        this.cahierEtudiant = cahierEtudiant;
    }

    public CahierTuteur getCahierTuteur() {
        return cahierTuteur;
    }

    public void setCahierTuteur(CahierTuteur cahierTuteur) {
        this.cahierTuteur = cahierTuteur;
    }


}
