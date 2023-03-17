package com.easemob.im.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class SortHistory {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(36) COMMENT 'ID'", updatable = false, nullable = false, unique = true)
    String id;

    @Column(name = "sort_before", columnDefinition = "VARCHAR(100) COMMENT '排序前'", nullable = false)
    String sortBefore;

    @Column(name = "sort_after", columnDefinition = "VARCHAR(100) COMMENT '排序后'", nullable = false)
    String sortAfter;

    @Column(name = "ip", columnDefinition = "VARCHAR(255) COMMENT '请求ip'")
    String ip;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createTime;

}

