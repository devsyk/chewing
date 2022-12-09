package io.web.chewing.domain;

import io.web.chewing.Entity.Member;
import io.web.chewing.Entity.Review;
import io.web.chewing.Entity.Store;
import io.web.chewing.config.security.dto.AuthMemberDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {


    private Long id;
    private String store_name;
    private double rate;
    private String member_nickname;
    private String content;
    private String create_time;
    private String modify_time;

    private List<String> fileNames;

    public Review toEntity(String store){

        return Review.builder()
                .store(Store.builder()
                        .id(1L)
                        .name(store).build())
                .rate(rate)
                .content(content).build();
    }

}
