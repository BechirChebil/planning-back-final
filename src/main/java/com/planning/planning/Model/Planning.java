package com.planning.planning.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @OneToMany(mappedBy = "planning")
    private Set<Seance> seances;

    @OneToOne(mappedBy = "planning")
    private CahierEtudiant cahierEtudiant;

    @OneToOne(mappedBy = "planning")
    private CahierTuteur cahierTuteur;

    public Planning() {
    }

    public Planning(String sujet, Date startTime, Set<Seance> seances,
                    CahierEtudiant cahierEtudiant, CahierTuteur cahierTuteur) {
        this.sujet = sujet;
        this.startTime = startTime;
        this.seances = seances;
        this.cahierEtudiant = cahierEtudiant;
        this.cahierTuteur = cahierTuteur;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Set<Seance> seances) {
        this.seances = seances;
    }
}
