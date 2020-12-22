package com.github.xiaolyuh.cache.properties;


import com.github.xiaolyuh.util.StringUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "layering-cache.redis")
public class LayeringCacheRedisProperties {
    Integer database = 0;
    /**
     * 不为空表示集群版，示例
     * localhost:7379,localhost2:7379
     */
    String cluster = "";
    String host = "localhost";
    Integer port = 6379;
    String password = null;
    /**
     * 序列化方式:
     * com.github.xiaolyuh.redis.serializer.KryoRedisSerializer
     * com.github.xiaolyuh.redis.serializer.FastJsonRedisSerializer
     * com.github.xiaolyuh.redis.serializer.JackJsonRedisSerializer
     * com.github.xiaolyuh.redis.serializer.JdkRedisSerializer
     * com.github.xiaolyuh.redis.serializer.ProtostuffRedisSerializer（暂时不建议使用）
     */
    String serializer = "com.github.xiaolyuh.redis.serializer.KryoRedisSerializer";

    public String getPassword() {
        return StringUtils.isBlank(password) ? null : password;
    }
}