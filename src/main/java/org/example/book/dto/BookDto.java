package org.example.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

//TODO вроде должно быть разные дто на запрос и ответ
@Getter
public record BookDto(String title, String author) {
}
