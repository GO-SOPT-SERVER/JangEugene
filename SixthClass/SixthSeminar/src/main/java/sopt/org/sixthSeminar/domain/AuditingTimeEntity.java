package sopt.org.sixthSeminar.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingTimeEntity {

    @CreatedDate
    private LocalDateTime createdAt;
    // 공통으로 사용하는 부분들을 따로 빼줌.

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
