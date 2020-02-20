package com.hhh.order.VO;

import lombok.Data;

/**
 *
 * 2020-02-18 18:02
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
