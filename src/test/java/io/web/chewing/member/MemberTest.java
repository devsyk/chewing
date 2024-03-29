package io.web.chewing.member;

import io.web.chewing.Entity.Categories;
import io.web.chewing.Entity.Member;
import io.web.chewing.Entity.MemberRole;
import io.web.chewing.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;


@SpringBootTest
@Slf4j
public class MemberTest {

     @Autowired
    private MemberRepository memberRepository;



    @Test
    public void insertUser(){
        // 1~4User 5ADMIN
        IntStream.rangeClosed(6,10).forEach(i ->{
            Member member = Member.builder()
                    .email("user"+i+"@studym.com")
                    .password("1234")
                    .delete_yn('0')
                    .nickname("user"+i)
                    .provider("test")
                    .name("name")
                    .gender("s")
                    .phone("01012345678")
                    .verify(true)
                    .profile("냥냥펀치url")
                    .build();
            // 기본롤
            member.addMemberRole(MemberRole.USER);
            member.addCategories(Categories.Cafe);
            member.addCategories(Categories.Korean);
            if(i > 4){
                member.addMemberRole(MemberRole.ADMIN);
            }

            memberRepository.save(member);
        });
    }

    @Test
    public void testRead(){


    }


}
