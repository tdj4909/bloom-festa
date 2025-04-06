package com.papasong.bloomfesta.festa.dto;

import lombok.Data;

@Data
public class Body {
    private Items items;
    private String numOfRows;
    private String pageNo;
    private String totalCount;
}
