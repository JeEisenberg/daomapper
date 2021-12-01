package com.gavin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer BookId;
    private String BookName;
    private String BookPublish;
    private Double BookPrice;
    private String BookKind;
    private Integer BookCount;
}
