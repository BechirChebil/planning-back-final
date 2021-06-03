package com.planning.planning.Model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet;
    private String objectif;

    private String aller;
    private String retour;
    @JsonFormat(pattern="HH:mm")
    private Date startTimeRetour;
    @JsonFormat(pattern="HH:mm")
    private Date endTimeRetour;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date endTime;
    private String creneau;

    @OneToMany(mappedBy = "seance")
    private Set<Phase> phases;

    @ManyToOne
    @JoinColumn(nullable = true)
    @JsonIgnore
    private Planning planning;

    public Seance() {
    }



    public Seance(List<Phase> phases, String sujet, String objectif,
                  String aller, String retour, Date startTimeRetour, Date endTimeRetour,
                  Date startTime, Date endTime, String creneau) {
        this.sujet = sujet;
        this.objectif = objectif;
        this.aller = aller;
        this.retour = retour;
        this.startTimeRetour = startTimeRetour;
        this.endTimeRetour = endTimeRetour;
        this.startTime = startTime;
        this.endTime = endTime;
        this.creneau = creneau;
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

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getAller() {
        return aller;
    }

    public void setAller(String aller) {
        this.aller = aller;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreneau() {
        return creneau;
    }

    public void setCreneau(String creneau) {
        this.creneau = creneau;
    }

    public Set<Phase> getPhases() {
        return phases;
    }

    public void setPhases(Set<Phase> phases) {
        this.phases = phases;
    }

    public Planning getPlannig() {
        return planning;
    }

    public void setPlannig(Planning planning) {
        this.planning = planning;
    }

    public String getRetour() {
        return retour;
    }

    public void setRetour(String retour) {
        this.retour = retour;
    }

    public Date getStartTimeRetour() {
        return startTimeRetour;
    }

    public void setStartTimeRetour(Date startTimeRetour) {
        this.startTimeRetour = startTimeRetour;
    }

    public Date getEndTimeRetour() {
        return endTimeRetour;
    }

    public void setEndTimeRetour(Date endTimeRetour) {
        this.endTimeRetour = endTimeRetour;
    }
}
