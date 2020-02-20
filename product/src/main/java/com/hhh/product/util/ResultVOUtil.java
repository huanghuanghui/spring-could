package com.hhh.product.util;

import com.hhh.product.VO.ResultVO;

/**
 *
 * 2017-12-09 22:53
 */
public class ResultVOUtil<T> {

    public static <T> ResultVO success(T data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setCode(Constant.SUCCESS);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
