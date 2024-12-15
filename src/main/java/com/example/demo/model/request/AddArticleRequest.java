
package com.example.demo.model.request;

import com.example.demo.model.domain.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddArticleRequest {
    private String title;
    private String content;
    private String user;
    private String newdate;
    private int count;
    private int likec;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .user(user)
                .newdate(newdate)
                .count(count)
                .likec(likec)
                .build();
    }
}
