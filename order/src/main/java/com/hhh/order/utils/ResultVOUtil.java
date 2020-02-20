package com.hhh.order.utils;

import com.hhh.order.VO.ResultVO;

/**
 *
 * 2020-02-18 18:03
 */
public class ResultVOUtil<T> {

    public static <T> ResultVO success(T object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
