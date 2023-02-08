package com.datvutech.news.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.datvutech.news.data.entity.type.AbstractEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "topics")
@Where(clause = "deleted = false")
@Entity
public class Topic extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long topicId;

    private String name;

    private String code;

    private String description;

    private Boolean deleted = false;

    /* Begin: References */
    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "parent_id", referencedColumnName = "topic_id")
    private Topic parentTopic;

    @OneToMany(mappedBy = "parentTopic", fetch = FetchType.EAGER)
    private List<Topic> childTopics;

    @OneToMany(mappedBy = "topic")
    private List<Article> articles;
    /* End: References */
}
