package org.example.hellojpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Member {

    /**
     * Todo 7. 식별자 전략
     * 권장 : Long 타입 + 대체키(자연키 x) + 키 생성전략 사용
     */
    @Id @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    /**
     * TODO 6-1 : 엔티티 매핑 - ENUM
     * @Enumerated (EnumType.ORDINAL) enum 의 위치 번호 대로 db에 전송
     * @Enumerated (EnumType.STRING) enum의 자체 이름 값으로 db에 전송
     */
    @Enumerated(EnumType.STRING)
    private Roletype roletype;

    /**
     * Todo 6-2 : 엔티티 매핑 - @Temporal
     * 날짜 관련
     *  - TIMESTAMP : 날짜 시간
     *  - TIME , DATE
     *
     *  TEMPORAL 대신 LocalDateTime, LocalDate 로 처리 가능
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    /**
     * Todo 6-3 @Lob
     * 구조화되지 않은 대형 데이터
     * - CLob : 문자열 ex)
     * - BLob : 이진 대형 객체 ex) 이미지, 동영상, 노래..
     *
     */
    @Lob
    private String description;

    /**
     * Todo 6-4 @Transient
     *  엔티티 객체의 데이터와 테이블의 컬럼(column)과 매핑하고 있는 관계를 제외하는 어노테이션
     */
    @Transient
    private int temp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Roletype getRoletype() {
        return roletype;
    }

    public void setRoletype(Roletype roletype) {
        this.roletype = roletype;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDate getTestLocalDate() {
        return testLocalDate;
    }

    public void setTestLocalDate(LocalDate testLocalDate) {
        this.testLocalDate = testLocalDate;
    }

    public LocalDateTime getTestLocalDateTime() {
        return testLocalDateTime;
    }

    public void setTestLocalDateTime(LocalDateTime testLocalDateTime) {
        this.testLocalDateTime = testLocalDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
