package com.planning.planning.Model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String objectif;
    private String creneau;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    private String indicationTuteur;
    private String indicationEtudiant;

    @OneToMany(mappedBy="seance")
    private List<Phase> phases;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="planning_id")//, referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Planning planning;

    public Seance() {
    }

    public Seance(String titre, String objectif,String indicationTuteur,
                   String indicationEtudiant, Date date, String creneau )
    {

        this.titre = titre;
        this.objectif = objectif;
        this.indicationTuteur = indicationTuteur;
        this.indicationEtudiant = indicationEtudiant;
        this.date = date;
        this.creneau = creneau;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
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

    public void setTitre(String sujet) {
        this.titre = sujet;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getIndicationTuteur() {
        return indicationTuteur;
    }

    public void setIndicationTuteur(String aller) {
        this.indicationTuteur = aller;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreneau() {
        return creneau;
    }

    public void setCreneau(String creneau) {
        this.creneau = creneau;
    }

    public String getIndicationEtudiant() {
        return indicationEtudiant;
    }

    public void setIndicationEtudiant(String retour) {
        this.indicationEtudiant = retour;
    }


}
