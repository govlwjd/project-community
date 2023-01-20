package com.example.community.domain;


import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false) // 수정 시에는 관여하지 않는다.
    private LocalDateTime regDt;

    @UpdateTimestamp
    @Column(insertable = false) // 생성 시에는 관여하지 않는다.
    private LocalDateTime updDt;
}
