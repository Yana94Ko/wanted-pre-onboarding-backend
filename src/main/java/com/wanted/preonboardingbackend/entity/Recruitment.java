package com.wanted.preonboardingbackend.entity;

import com.wanted.preonboardingbackend.global.auditable.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@Table(name = "RECRUITMENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Recruitment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private int reward;
    @Column(nullable = false)
    private String description;
    // TODO : recrutement_skill 확장성 관련 별도 테이블 분리 검토
    @Column(nullable = false)
    private String skill;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "recruitment")
    private List<Apply> applies;
}
