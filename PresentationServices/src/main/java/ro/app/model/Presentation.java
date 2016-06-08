/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Devi7
 */
@Entity
@Table(name = "presentation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentation.findAll", query = "SELECT p FROM Presentation p"),
    @NamedQuery(name = "Presentation.findById", query = "SELECT p FROM Presentation p WHERE p.id = :id"),
    @NamedQuery(name = "Presentation.findByTitle", query = "SELECT p FROM Presentation p WHERE p.title = :title"),
    @NamedQuery(name = "Presentation.findByHeldOn", query = "SELECT p FROM Presentation p WHERE p.heldOn = :heldOn")})
public class Presentation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "held_on")
    @Temporal(TemporalType.DATE)
    private Date heldOn;
    @JoinTable(name = "presentation_speaker", joinColumns = {
        @JoinColumn(name = "id_presentation", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_speaker", referencedColumnName = "id")})
    @JsonIgnore
    @ManyToMany
    private List<Speaker> speakerList;
    @OneToMany(mappedBy = "presentationId", fetch=FetchType.EAGER)
    private List<Feedback> feedbackList;

    public Presentation() {
    }

    public Presentation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getHeldOn() {
        return heldOn;
    }

    public void setHeldOn(Date heldOn) {
        this.heldOn = heldOn;
    }

    @JsonIgnore
    @XmlTransient
    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentation)) {
            return false;
        }
        Presentation other = (Presentation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ro.app.model.Presentation[ id=" + id + " ]";
    }
    
}
