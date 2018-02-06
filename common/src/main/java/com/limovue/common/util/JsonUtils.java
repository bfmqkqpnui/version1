package com.limovue.common.util;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * json工具类
 */
public class JsonUtils {

    /**
     * 转成对象
     * @param jsonStr
     * @param clz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T jsonString2Bean(String jsonStr, Class<T> clz)
            throws IOException {
        try {
            return JSON.parseObject(jsonStr, clz);
        } catch (Exception e) {
            throw new IOException("jsonString2Bean转换异常", e);
        }
    }

    /**
     * 转成list
     * @param jsonStr
     * @param clz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> josn2List(String jsonStr, Class<T> clz)
            throws Exception {
        return JSON.parseArray(jsonStr, clz);
    }

    /**
     * 转成字符串
     * @param obj
     * @return
     */
    public static String object2JsonString(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static Map<String, Object> parseJSON2Map(String jsonStr)
            throws Exception {
        return (Map) JSON.parse(jsonStr);
    }

    /**
     * 转成Map
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> parseJSON2Map(String json, Class<T> clz) {
        return (Map) JSON.parse(json);
    }
}
