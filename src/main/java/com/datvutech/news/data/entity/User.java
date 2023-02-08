package com.datvutech.news.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.datvutech.news.data.entity.type.AbstractEntity;
import com.datvutech.news.data.entity.type.RoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Where(clause = "deleted = false")
@Entity
public class User extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private Boolean verified;

    private Boolean deleted = false;

    /* Begin: References */
    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "writer_id", referencedColumnName = "writer_id")
    private Writer writer;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @ManyToMany(mappedBy = "likedUsers")
    private Set<Comment> likedComments;
    /* End: References */
}