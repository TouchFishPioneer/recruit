package cn.herculas.recruit.util.penetrator;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DatabasePenetrator {
    public static <T> List<T> statisticsPenetrator(Supplier<List<T>> supplier,
                                                   StringRedisTemplate stringRedisTemplate,
                                                   String key,
                                                   Integer expires) {
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(supplier.get()), expires, TimeUnit.SECONDS);
        return supplier.get();
    }
}
