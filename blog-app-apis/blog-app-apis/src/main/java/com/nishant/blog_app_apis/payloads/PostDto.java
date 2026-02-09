package com.nishant.blog_app_apis.payloads;

import com.nishant.blog_app_apis.entites.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer postId;

    @NotBlank(message = "Post title cannot be blank")
    @Size(min = 5 , message = "Post Title should be min of 4 char")
    private String postTitle;

    @NotBlank(message = "Post Content should not be blank")
    private String postContent;

    private String postImageName;

    private Date postAddedDate;

    private CategoryDto categoryDto;

    private UserDto userDto;

    private List<CommentDto> comments = new ArrayList<>();
}
