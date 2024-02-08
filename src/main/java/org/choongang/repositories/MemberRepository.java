package org.choongang.repositories;

import org.choongang.entities.Member;
//import org.choongang.entities.QMember;
import org.choongang.entities.QMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    default boolean exists(String email) {
        // 오류 수정
        return exists(String.valueOf(QMember.member.email.eq(email)));
    }
}
