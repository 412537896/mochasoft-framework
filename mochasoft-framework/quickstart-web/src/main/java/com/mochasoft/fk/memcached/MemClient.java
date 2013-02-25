//package com.mochasoft.fk.memcached;
//
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//
//public class MemClient {
//	
//	//配置memcached的服务器，需要改成自己的，以后配置在配置文件里或者与spring整合
//	private static final String[] server = {"192.168.159.129:11211", "192.168.159.128:11211"};
//	
//	private static MemCachedClient client = null;
//	
//	//初始化连接池，之后可以与spring整合
//	private MemClient() {
//		SockIOPool pool = SockIOPool.getInstance();
//		pool.setServers(server);
//		pool.setFailover(true);
//		pool.setFailover(true);
//		pool.setInitConn(10);
//		pool.setMinConn(5);
//		pool.setMaxConn(250);
//		pool.setMaintSleep(30);
//		pool.setNagle(false);
//		pool.setSocketTO(3000);
//		pool.setAliveCheck(true);
//		pool.initialize();
//	}
//	
//	public static MemCachedClient getClient() {
//		if(client == null){
//			new MemClient();
//			client = new MemCachedClient();
//		}
//		return client;
//	}
//}
