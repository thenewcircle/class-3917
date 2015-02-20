package com.example.pacman;


public class JndiHelper {

	public static <T> T jndiLookup(String string, Class<T> type) {
		Object obj = null; //jndi lookup
		T result = type.cast(obj);
		return result;
	}

}
