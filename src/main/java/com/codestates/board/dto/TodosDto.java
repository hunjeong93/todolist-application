package com.codestates.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class TodosDto {

    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        private String title;
        @Positive
        private int todo_order;

        private boolean completed;
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private long id;
        private String title;
        private int todo_order;
        private boolean completed;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long id;

        private String title;
        private int todo_order;
        private boolean completed;
        public void setId(long id) { this.id = id;}
    }
}
