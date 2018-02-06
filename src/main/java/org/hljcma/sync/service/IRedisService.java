package org.hljcma.sync.service;

import java.util.List;

/**
 * 
 * @author zzw
 * @desc redis service
 */
public interface IRedisService {
	
	public boolean set(String key, String value);
	
	public String get(String key);

}