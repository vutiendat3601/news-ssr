package com.datvutech.news.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.datvutech.news.data.entity.type.AbstractEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "images")
@Where(clause = "deleted = false")
@Entity
public class Image
        extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    private String description;

    private String path;

    private Integer index;

    private Boolean deleted = false;

    /* Begin: References */
    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
    private Article article;
    /* End: References */

}
