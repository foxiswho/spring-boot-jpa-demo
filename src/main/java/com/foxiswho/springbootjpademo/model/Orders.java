package com.foxiswho.springbootjpademo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="orders")
@DynamicInsert
@DynamicUpdate
@Data
public class Orders implements Serializable {
    private static final long serialVersionUID = -1811960778993500439L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.foxiswho.springbootjpademo.generator.id.CustomIDGenerator")
    @Column(name = "id")
    private Long id;

    /**
     * 忽略字段，用于自定义生成主键，直接传入
     */
    @Transient
    @Column(name = "idCustomPrimaryKey")
    private Long idCustomPrimaryKey;

    @Column(name = "no")
    private String no;

    /**
     * 创建时间
     */
    @JsonProperty(value = "gmt_create")
    @Column(name="gmt_create")
    private Date gmtCreate;
    /**
     * 更新时间
     */
    @JsonProperty(value = "gmt_modified")
    @Column(name="gmt_modified")
    private Date gmtModified;
}
