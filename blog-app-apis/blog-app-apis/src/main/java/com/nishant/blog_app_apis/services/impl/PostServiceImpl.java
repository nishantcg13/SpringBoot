package com.nishant.blog_app_apis.services.impl;

import com.nishant.blog_app_apis.entites.Category;
import com.nishant.blog_app_apis.entites.Comment;
import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.entites.User;
import com.nishant.blog_app_apis.exceptions.ResourceNotFoundException;
import com.nishant.blog_app_apis.payloads.*;
import com.nishant.blog_app_apis.repositories.CategoryRepository;
import com.nishant.blog_app_apis.repositories.PostRepository;
import com.nishant.blog_app_apis.repositories.UserRepository;
import com.nishant.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        Post post = this.dtoToPost(postDto);
        post.setPostImageName("default.png");
        post.setPostAddedDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post savedPost = this.postRepository.save(post);

        return this.postToDto(savedPost);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        post.setPostImageName(postDto.getPostImageName());

        Post savedPost = this.postRepository.save(post);
        PostDto savedPostDto = this.postToDto(savedPost);
        return savedPostDto;
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

        this.postRepository.delete(post);
    }


    @Override
    @Transactional(readOnly = true)
    public PostDto getPostById(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        PostDto postDto = this.postToDto(post);
        return postDto;
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection) {

        Sort sort = null;
        if (sortDirection.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable page = PageRequest.of(pageNumber, pageSize, sort);
        Page<Post> pagePosts = this.postRepository.findAll(page);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> this.postToDto(post)).toList();

        PostResponse postResponse = new PostResponse();

        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());

        return postResponse;
    }

    @Transactional(readOnly = true)
    @Override
    public PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        Pageable page = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePosts = this.postRepository.findByCategory(category, page);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> this.postToDto(post)).toList();

        PostResponse postResponse = new PostResponse();

        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());
        return postResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponse getPostByUser(Integer userId, Integer pageNumber, Integer pageSize) {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

        Pageable page = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePosts = this.postRepository.findByUser(user, page);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map((post) -> this.postToDto(post)).toList();

        PostResponse postResponse = new PostResponse();

        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {

        List<Post> posts = this.postRepository.findByPostTitleContaining(keyword);
        List<PostDto> postDtos = posts.stream().map((post) -> this.postToDto(post)).toList();
        return postDtos;
    }


    //conversions
    private Post dtoToPost(PostDto postDto) {
        Post post = this.modelMapper.map(postDto, Post.class);
        return post;
    }

    private PostDto postToDto(Post post) {
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        postDto.setUserDto(modelMapper.map(post.getUser(), UserDto.class));
        postDto.setCategoryDto(modelMapper.map(post.getCategory(), CategoryDto.class));
        if (post.getComments() != null) {
            postDto.setComments(
                    post.getComments()
                            .stream()
                            .map(this::commentToDto)   // IMPORTANT
                            .toList()
            );
        }
        return postDto;
    }

    private CommentDto commentToDto(Comment comment) {

        CommentDto dto = this.modelMapper.map(comment, CommentDto.class);

        if (comment.getUser() != null) {
            dto.setUserId(comment.getUser().getUserId());
            dto.setUsername(comment.getUser().getUserName());
        }

        return dto;
    }

}
