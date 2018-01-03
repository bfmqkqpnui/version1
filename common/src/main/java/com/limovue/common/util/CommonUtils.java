package com.limovue.common.util;

import java.util.List;
import java.util.Map;

public class CommonUtils {
    /**
     * 数组是否为空
     * @param obj
     * @return
     */
    public static boolean isExist(Object obj){
        boolean flag = false;
        if(null != obj){
            if(obj instanceof List){
                List list = (List) obj;
                if(null != list && list.size() > 0){
                    flag = true;
                }
            }else if(obj instanceof Map){
                Map map = (Map) obj;
                if(null != map && map.size() > 0){
                    flag = true;
                }
            }
        }
        return flag;
    }

}
