package com.limovue.common.util;

import java.util.HashMap;
import java.util.Map;

import com.limovue.common.propertiesClass.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis工具类
 *
 * @author lance
 */
public class JedisUtil {

    // 连接池集合
    private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();
    //日志
    private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    private static final String HOST = "127.0.0.1";
    private static final Integer PORT = 6379;

    /**
     * 获取连接
     *
     * @return
     */
    public static Jedis getJedis() {
        String key = HOST + ":" + PORT;
        logger.info("redis 信息:" + HOST + "<<<>>>" + PORT);
        JedisPool pool = null;
        if (!maps.containsKey(key)) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(200);
            config.setMaxTotal(300);
            config.setTestOnBorrow(false);
            config.setTestOnReturn(false);
            pool = new JedisPool(config, HOST, PORT, 3000);
            maps.put(key, pool);
        } else {
            pool = maps.get(key);
        }

        return pool.getResource();

    }

    /**
     * 设置键值
     *
     * @param key   键
     * @param value 值
     * @return 字符串
     */
    public static void set(String key, String value) {
        Jedis jds = getJedis();
        jds.set(key, value);
        jds.expire(key, 30 * 60);
        jds.close();

        logger.info("JedisUtil.set,key{},value{}", key, value);
    }

    /**
     * 根据键取值
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {

        Jedis jds = getJedis();
        String str = jds.get(key);
        jds.close();

        logger.info("JedisUtil.get,key{},value{}", key, str);

        return str;
    }

    /**
     * 关闭连接池
     *
     * @param ip
     * @param port
     */
    public static void closePool(String ip, int port) {

        String key = ip + ":" + port;
        if (maps.containsKey(key)) {
            JedisPool pool = maps.remove(key);
            pool.destroy();
        }
    }

    public static void main(String[] args) {
        JedisUtil.getJedis();
    }

}