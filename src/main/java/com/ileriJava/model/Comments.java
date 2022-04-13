package com.ileriJava.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import com.ileriJava.model.FaultRecords;

@Entity
@Table(name = "Comments")
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CommentID", nullable = false)
    private Long commentid;

    //yorumun oluşturulma zamanını tutar
    @Column(name = "CreationTime", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationtime;


    //yorumun içeriğini belirtir
    @Column(name = "Context", nullable = false)
    private String context;


    //Bir Kullanıcı birden fazla yorum oluşturabilir
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userid")
    private User user;

    //Bir Başlıkta Birden fazla yorum olabilir yorumun hangi başlık altında olduğunu söyler
    @ManyToOne
    @JoinColumn(name = "FaultID", referencedColumnName = "faultid")
    private FaultRecords faultRecord;

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
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

    public User getUser() {
        return user;
    }

    public void setUser(User userid) {
        this.user = userid;
    }

    public FaultRecords getFaultRecord() {
        return faultRecord;
    }

    public void setFaultRecord(FaultRecords faultRecord) {
        this.faultRecord = faultRecord;
    }
}
