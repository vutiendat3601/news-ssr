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
@Table(name = "articles")
@Where(clause = "deleted = false")
@Entity
public class Article extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    private String title;

    private String code;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(columnDefinition = "text NOT NULL DEFAULT ''")
    private String content;

    private String thumbnail;

    @Column(name = "view_count")
    private long viewCount;

    private Boolean deleted = false;

    /* Begin: References */
    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "writer_id")
    private Writer writer;

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    private Topic topic;
    /* End: References */

}
