package com.datvutech.news.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.datvutech.news.data.entity.type.AbstractEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "regions")
@Entity
public class Region extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;

    private String name;

    private String code;

    private String description;

    /* Begin: References */
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "region_id")
    private Region parentRegion;

    @OneToMany(mappedBy = "parentRegion")
    private List<Region> childRegions;

    @OneToMany(mappedBy = "region")
    private List<Article> articles;
    /* End: References */

}
