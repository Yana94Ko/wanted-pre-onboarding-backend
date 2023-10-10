package com.wanted.preonboardingbackend.entity;

import com.wanted.preonboardingbackend.global.auditable.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "COMPANY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Company extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;
    // TODO : company_country 확장성 관련 테이블 분리, vaildation 검토
    @Column(length = 20, nullable = false)
    private String country;
    @Column(length = 20, nullable = false)
    private String location;
    @OneToMany(mappedBy = "company")
    private List<Recruitment> recruitments;
}