package com.ileriJava.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import com.ileriJava.model.User;

@Entity
@Table(name = "FaultRecords")
public class FaultRecords  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FaultID", nullable = false)
    private Long faultid;

    @Column(name = "FaultTitle", nullable = false)
    private String faulttitle;

    @Column(name = "isResolved", nullable = false)
    private Boolean isresolved;

    @Column(name = "CreationTime", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationtime;

    @Column(name="Context",nullable = false, columnDefinition = "TEXT")
    private String context;

    @Column(name = "İsExpired")
    private Boolean isexpired;

    //Bir Kullanıcı birden fazla başlık açabilir
    @ManyToOne
    @JoinColumn(name = "Userid", referencedColumnName = "userid")
    private User userid;

    public Long getFaultid() {
        return faultid;
    }
    public void setFaultid(Long faultid) {
        this.faultid = faultid;
    }

    public String getFaulttitle() {
        return faulttitle;
    }
    public void setFaulttitle(String faulttitle) {
        this.faulttitle = faulttitle;
    }

    public Boolean getIsresolved()
    {
        return isresolved;
    }
    public void setIsresolved(Boolean isresolved)
    {
        this.isresolved=isresolved;
    }
    public Date getCreationtime() {
        return creationtime;
    }
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public User getUserid()
    {
        return userid;
    }
    public void setUserid(User userid)
    {
        this.userid=userid;
    }
    public Boolean getIsexpired()
    {
        return isexpired;
    }
    public void setIsexpired(Boolean isexpired)
    {
        this.isexpired=isexpired;
    }

}
