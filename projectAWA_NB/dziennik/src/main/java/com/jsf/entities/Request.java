/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsf.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author wiktor
 */
@Entity
@Table(name = "request")
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByIdRequest", query = "SELECT r FROM Request r WHERE r.idRequest = :idRequest"),
    @NamedQuery(name = "Request.findByTitle", query = "SELECT r FROM Request r WHERE r.title = :title"),
    @NamedQuery(name = "Request.findByCreatedBy", query = "SELECT r FROM Request r WHERE r.createdBy = :createdBy"),
    @NamedQuery(name = "Request.findByCreatedAt", query = "SELECT r FROM Request r WHERE r.createdAt = :createdAt"),
    @NamedQuery(name = "Request.findBySentTo", query = "SELECT r FROM Request r WHERE r.sentTo = :sentTo"),
    @NamedQuery(name = "Request.findBySeen", query = "SELECT r FROM Request r WHERE r.seen = :seen"),
    @NamedQuery(name = "Request.findByAccepted", query = "SELECT r FROM Request r WHERE r.accepted = :accepted")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_request")
    private Integer idRequest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "created_at")
    private String createdAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sent_to")
    private String sentTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seen")
    private short seen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accepted")
    private short accepted;

    public Request() {
    }

    public Request(Integer idRequest) {
        this.idRequest = idRequest;
    }

    public Request(Integer idRequest, String title, String createdBy, String createdAt, String sentTo, short seen, short accepted) {
        this.idRequest = idRequest;
        this.title = title;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.sentTo = sentTo;
        this.seen = seen;
        this.accepted = accepted;
    }

    public Integer getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Integer idRequest) {
        this.idRequest = idRequest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public short getSeen() {
        return seen;
    }

    public void setSeen(short seen) {
        this.seen = seen;
    }

    public short getAccepted() {
        return accepted;
    }

    public void setAccepted(short accepted) {
        this.accepted = accepted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequest != null ? idRequest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.idRequest == null && other.idRequest != null) || (this.idRequest != null && !this.idRequest.equals(other.idRequest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsf.entities.Request[ idRequest=" + idRequest + " ]";
    }
    
}
