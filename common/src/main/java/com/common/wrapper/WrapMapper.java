package com.common.wrapper;

/**
 * @author: laizc
 * @date: 2025/12/10 11:56
 * @desc: 统一返回包装类
 */
public class WrapMapper {

    private WrapMapper() {}

    public static <E> Wrapper<E> wrap(int code) {
        return wrap(code, null);
    }

    public static <E> Wrapper<E> wrap(int code, String message) {
        return wrap(code, message, null);
    }

    public static <E> Wrapper<E> wrap(int code, String message, E o) {
        return new Wrapper<>(code, message, o);
    }

    public static <E> Wrapper<E> error(int code,String message) {
        return wrap(code, message);
    }


}
