package org.example.hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    /**
     * JPA의 모든 데이터 변경은 트랜잭션 안에서 실행 ( 조회 제외 모두)
     */
    public static void main(String[] args) {
        /** Todo 1. 시작
         *  EMF 는 어플리케이션 하나로 전체에서 공유 (instance처럼 ) */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /** 쓰레드간 공유 x (사용하고 버려야함)
         *  객체를 대신 저장해주는 곳
         *  DB 커넥션 보유 (db 와 직업 연결 되는 곳 )
         *  EM 을 통해서 영속성 컨텍스에 접근
         *  */
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /** 생성 */
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");

//            em.persist(member);

            /** 검색 */
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            /** 삭제 */
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            /** 수정 */
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA");

            /** Todo. 2. JPQL
             *  JPA -> 엔티티 객체 중심으로 개발
             *      -> 필요한 데이터만 불러오려면 검색 SQL 작성 필요
             *  JPQL -> SQL을 추상화한 *객체 지향 쿼리*
             *       -> GROUP BY, HAVING , JOIN 지원
             * */
//            List<Member> result = em.createQuery("SELECT m FROM Member as m", Member.class)
//                /** pagination */
////                .setFirstResult(1)
////                .setMaxResults(10)
//                .getResultList();
//            for (Member member : result) {
//                System.out.println("member.get = " + member.getName());
//            }

            /**
             * Todo. 3. 영속성 컨텍스트 , 엔티티 상태
             *
             * 영속성 컨텍스트
             *  이점 -> 1차 캐시
             *      -> 동일성 보장
             *      -> 트랜잭션을 지원하는 쓰기 지연
             *      -> 변경 감지 (dirty checking)
             *      -> 지연 로딩
             */

            /** 비영속 */
//            Member member = new Member();
//            member.setName("name1");
//            member.setId(10L);

            /** (persist) 영속 -> EntityManager 로 영속성 컨텍스트에 접근 후 영속*/
//            System.out.println("----- BEFORE -----");
                /** 이 시점에 db에 쿼리문 보내는게 아니라 commit 할 때 보냄
                 *  -> 1차 캐시(영속성 컨텍스트)에 저장 */
//            em.persist(member);
//            System.out.println("----- AFTER -----");
              // 1차 캐시에서 조회
//            Member findMember = em.find(Member.class, "name1");
//
            /** 준영속 -> 영속성 컨텍스트에서 분리 */
//            em.detach(member);

            /** 영속 엔티티 동일성 보장 */
//            Member findMember1 = em.find(Member.class, 1L);
//            Member findMember2 = em.find(Member.class, 1L);
//            System.out.println("result = " + (findMember1 == findMember2));

            /** 트랜잭션을 지원하는 쓰기 지연 */
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

            /** 변경감지 (dirty checking) */
//            Member member = em.find(Member.class, 150L);
//            member.setName("dirtycheck");

            /** persist 하지 않아도 알아서 변경을 감지하여 update 쿼리 보내줌
             *  tx.commit() 실행시
             *  -> flush() -> 엔티티와 스냅샷(최초 시점 상태) 비교
             * */
//            em.persist(member);


            // 커밋하는 순간 데이터베이스에 SQL 보냄

            /**
             * Todo 4. 플러시
             * - 영속성 컨텍스트의 변경 내용을 DB에 반영
             * - 영속성 컨텍스트를 비우지 않음
             * - 영속성 컨텍스트의 변경 내용을 DB 에 *동기화*
             * - 트랜잭션 이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면됨
             *
             *  플러시 발생시
             *  -> 변경 감지
             *  -> 수정된 엔티티를  쓰기 지연 SQL 저장소에 등록
             *  -> 쓰기 지연 SQL 저장소의 쿼리 -> DB에 전송
             *  영속성 컨텍스트를 플러시 하는 법
             *  1. em.flush() - 직접 호출
             *  2. 트랜잭션 커밋 - 플러시 자동 호출
             *  3. JPQL 쿼리 실행 - 플러시 자동 호출
             *
             */
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();
//
//            System.out.println("-------------");

            /**
             * Todo 5. 준영속 상태
             * - 영속 상태의 엔티티가 영속성 컨텍스트에서 분리
             * - 영속성 컨텍스트가 제공하는 기능 사용 x
             *
             *  준영속 상태로 만드는 방법
             *  - em.detach(entity) : 특정 엔티티만 준영속 상태로 바꿈
             *  - em.clear() : 영속성 컨텍스트를 완전히 초기화
             *  - em.close() : 영속성 컨텍스트를 종료
             */
//            Member member = em.find(Member.class, 150L);
//            member.setName("detach");

//            em.detach(member);

//            em.clear();
//            Member member2 = em.find(Member.class, 150L);

//            em.close();

            /** @Enumerated 확인 */
//            Member member = new Member();
//            member.setId(1L);
//            member.setRoletype(Roletype.USER);
//
//            em.persist(member);

            /** @GeneratedValue  */
            Member member = new Member();
            member.setUsername("C");

            System.out.println("=============");
            em.persist(member);
            System.out.println("member.getId() = " + member.getId());
            System.out.println("=============");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }





        em.close();
        emf.close();
    }

}
