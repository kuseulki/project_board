package com.project_board.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Disabled("Spring data rest 통합테스트는 불필요하므로 제외시킴")
@DisplayName("Data REST API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc){
        this.mvc=mvc;
    }

    @DisplayName("api - 게시글 리스트 조회")
    @Test
    void givenNoting_whenRequestingArticles_thenReturnArticlesJsonResponse() throws Exception {

        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("api - 게시글 단건 조회")
    @Test
    void givenNoting_whenRequestingArticle_thenReturnArticlesJsonResponse() throws Exception {

        mvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("api - 게시글 댓글 리스트")
    @Test
    void givenNoting_whenRequestingArticleCommentsFromArticle_thenReturnArticlesJsonResponse() throws Exception {

        mvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("api - 게시글 댓글 리스트 조회")
    @Test
    void givenNoting_whenRequestingArticleComments_thenReturnArticlesJsonResponse() throws Exception {

        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("api - 게시글 댓글 단건 조회")
    @Test
    void givenNoting_whenRequestingArticleComment_thenReturnArticlesJsonResponse() throws Exception {

        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

}
