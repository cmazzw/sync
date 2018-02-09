package org.hljcma.sync.service.impl;

import org.hljcma.sync.service.IRedisService;
import org.hljcma.sync.service.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author
 * @desc resdis servicezzw
 *
 */
@Service
public class RedisServiceImpl implements IRedisService{

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

    @Override
    public void flushdb(){
        redisTemplate.execute(new RedisCallback<Object>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

	@Override
	public boolean set(final String key, final String value) {
        ValueOperations<String,String> stringOperations = redisTemplate.opsForValue();
        stringOperations.set(key,value);
        return(true);
	}

    @Override
	public String get(final String key){
        ValueOperations<String,String> stringOperations = redisTemplate.opsForValue();
		return stringOperations.get(key);
	}
}

