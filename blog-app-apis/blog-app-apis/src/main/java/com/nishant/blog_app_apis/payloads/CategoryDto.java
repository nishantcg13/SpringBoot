package com.nishant.blog_app_apis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int categoryId;

    @NotBlank
    @Size(min = 2, max = 20)
    private String categoryTitle;

    @NotBlank
    @Size(min = 10)
    private String categoryDescription;

}
