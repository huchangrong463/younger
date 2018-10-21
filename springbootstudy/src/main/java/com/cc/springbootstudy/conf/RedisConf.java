package com.cc.springbootstudy.conf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConf {

	@Bean
	@Primary
	public RedisTemplate myReidsTemplate(RedisConnectionFactory rcf) {
		RedisTemplate rt = new RedisTemplate();
		rt.setConnectionFactory(rcf);

		//定义key的序列化策略
		rt.setKeySerializer(new StringRedisSerializer());
		
		//定义value的序列化策略
		rt.setValueSerializer(new RedisSerializer<Object>() {

			@Override
			public Object deserialize(byte[] bs) throws SerializationException {
				if(bs == null) {
					return null;
				}
				
				ByteArrayInputStream bais = null;
				
				try {
					
					bais = new ByteArrayInputStream(bs);
					ObjectInputStream ois = new ObjectInputStream(bais);
					
					return ois.readObject();
				}catch(Exception  err) {
					err.printStackTrace();
				}finally {
					try {
						bais.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				return null;
			}

			@Override
			public byte[] serialize(Object obj) throws SerializationException {
				ObjectOutputStream oos = null;
				ByteArrayOutputStream boos = null;
				
				try {
					boos = new ByteArrayOutputStream();
					oos = new ObjectOutputStream(boos);
					
					oos.writeObject(obj);
					
					return boos.toByteArray();
				}catch(Exception  err) {
					err.printStackTrace();
				}finally {
					try {
						oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return null;
			}
			
		});
		
		return rt;
	}
}
