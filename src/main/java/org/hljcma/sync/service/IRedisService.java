package org.hljcma.sync.service;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;

import java.util.List;

/**
 * 
 * @author zzw
 * @desc redis service
 */
public interface IRedisService {

	public void flushdb();

	public boolean set(String key, String value);
	
	public String get(String key);

}