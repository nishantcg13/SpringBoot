package com.nishant.blog_app_apis.payloads;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private int commentId;

    @NotBlank(message = "comment should be not blank")
    private String content;
}
