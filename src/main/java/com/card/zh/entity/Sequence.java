package com.card.zh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {
    private String idName;
    private Long currval;
    private Long nextval;
}
