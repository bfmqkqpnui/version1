package com.limovue.common.util;

import com.limovue.common.myEnum.MathType;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    /**
     * 数组是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isExist(Object obj) {
        boolean flag = false;
        if (null != obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (null != list && list.size() > 0) {
                    flag = true;
                }
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                if (null != map && map.size() > 0) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 邮箱格式校验
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        boolean flag = false;
        if (StringUtils.isNotBlank(email)) {
            Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
            Matcher m = p.matcher(email);
            flag = m.matches();
        }
        return flag;
    }

    /**
     * 查找数组中最小或者最大的值
     *
     * @param array 需要查找的数组
     * @param type  查询类型: MIN-->最小  MAX-->最大  默认最大
     * @return
     */
    public static Integer fingMinOrMax(Integer[] array, MathType type) {
        Integer result = null;
        if (null != array) {
            switch (type) {
                case MIN:
                    result = Collections.min(Arrays.asList(array));
                    break;
                case MAX:
                    result = Collections.max(Arrays.asList(array));
                    break;
                default:
                    result = Collections.max(Arrays.asList(array));
            }
        }
        return result;
    }

    /**
     * 递增排序
     *
     * @param array
     * @return
     */
    public static void sortByEsc(Integer[] array) {
        if (null != array && array.length > 0) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int y = i + 1; y < array.length; y++) {
                    if (array[i] < array[y]) {
                        int temp = array[i].intValue();
                        array[i] = array[y].intValue();
                        array[y] = temp;
                    }
                }
            }
        }
    }

    /**
     * 递减排序
     *
     * @param array
     */
    public static void sortByDesc(Integer[] array) {
        if (null != array && array.length > 0) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int y = i + 1; y < array.length; y++) {
                    if (array[i] > array[y]) {
                        int temp = array[i].intValue();
                        array[i] = array[y].intValue();
                        array[y] = temp;
                    }
                }
            }
        }
    }

    /**
     * 生成一个随机整型数组
     *
     * @param length 数组长度
     * @return
     */
    private static Integer[] getRandomArrayByLength(Integer length) {
        int defaultLegth = 20;
        if (null != length) {
            defaultLegth = length.intValue();
        }
        int scope = defaultLegth * 5 + 1;  //随机数的范围
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < defaultLegth) {
            set.add(random.nextInt(scope));
        }
        Integer[] it = set.toArray(new Integer[]{});
        return it;
    }


    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        System.out.println("开始");
        Integer[] att = getRandomArrayByLength(4000);
        System.out.println("初始数组长度为[" + att.length + "],具体如下:");
        for (int i = 0; i < att.length; i++) {
            System.out.print(att[i] + " ");
        }
        System.out.println("");
        Integer max = fingMinOrMax(att, MathType.MAX);
        Integer min = fingMinOrMax(att, MathType.MIN);
        if (null == max) {
            System.err.println("未找到");
        } else {
            System.out.println("最大的值为[" + max + "]");
        }
        if (null == min) {
            System.err.println("未找到");
        } else {
            System.err.println("最小的值为[" + min + "]");
        }
        System.out.println("耗时[" + (System.currentTimeMillis() - beg) + "]毫秒");
    }

}

