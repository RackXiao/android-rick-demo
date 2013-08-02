package com.otiga.dress.data.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Parse JSON String to ConcurrentHashMap
 * @author Jason.Chaung
 *
 */
public class JsonHandler {
	
	
	public static Object parseJson(String jsonString) {
		if (jsonString == null)
			return null;
		
		if (jsonString.length() == 0)
			return null;
		
		JsonContent content = new JsonContent();
		while (content.offset != jsonString.length()) {
			String s = jsonString.substring(content.offset, content.offset + 1);
			if (s.equals("{")) {
				++content.offset;
				JsonContent result = parseHashmap(jsonString, content.offset);
				content.offset = result.offset;
				content.object = result.object;
			} else if (s.equals("[")) {
				++content.offset;
				JsonContent result = parseHashmapList(jsonString, content.offset);
				content.offset = result.offset;
				content.object = result.object;
			}
				
		}
		return content.object;
	}
	
	public static JsonContent parseHashmap(String jsonString, int offset) {
		
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
		JsonContent content = new JsonContent();
		content.offset = offset;
		content.object = map;
		
		boolean isReadKey = true;
		boolean isReadKeyValueSeparate = false;
		boolean isReadValue = false;
		boolean isEscapeValue = false;
		boolean isSaveValue = false;
		String s = "";
		String key = "";
		String value = "";
		
		do {
			s = jsonString.substring(content.offset, content.offset + 1);
			isEscapeValue = (jsonString.substring(content.offset - 1, content.offset).equals("\\")) ? true : false;
			++content.offset;
			if (isReadKey) {
				if (s.equals("\"")) {
					isReadKey = !(key.length() > 0);
				} else {
					key += s;
				}
			} else {
				if (s.equals("[")) {
					JsonContent result = parseHashmapList(jsonString, content.offset);
					content.offset = result.offset;
					map.put(key, result.object);
					isSaveValue = true;
				} else if (s.equals("{")) {
					JsonContent result = parseHashmap(jsonString, content.offset);
					content.offset = result.offset;
					map.put(key, result.object);
					isSaveValue = true;
				} else if (s.equals("}")) {
				} else if (s.equals("\"")&&!isEscapeValue) {
					if (map.get(key) == null) {
						map.put(key, "");
						value = "";
						isReadValue = true;
					} else {
						map.put(key, decodeUTF8String(value));
						isSaveValue = true;
						isReadValue = false;
					}
				} else if (s.equals(",")&&!isReadValue) {
					isReadKeyValueSeparate = false;
					isReadKey = true;
					isSaveValue = false;
					key = "";
					value = "";
				} else {
					if (isReadKeyValueSeparate) {
						value += s;
					} else {
						if (s.equals(":"))
							isReadKeyValueSeparate = true;
					}
				}
			}
		} while (!s.equals("}"));
		
		if (!isSaveValue) {
			map.put(key, decodeUTF8String(value));
		}
		
		return content;
	}
	
	@SuppressWarnings("unchecked")
	public static JsonContent parseHashmapList(String jsonString, int offset) {
		
		List<ConcurrentHashMap<String, Object>> list = new ArrayList<ConcurrentHashMap<String,Object>>();
		JsonContent content = new JsonContent();
		content.object = list;
		content.offset = offset;
		
		String s = "";
		
		do {
			s = jsonString.substring(content.offset, content.offset + 1);
			++content.offset;
			if (s.equals("{")) {
				JsonContent result = parseHashmap(jsonString, content.offset);
				content.offset = result.offset;
				list.add((ConcurrentHashMap<String, Object>)result.object);
			} else if (s.equals(",")) {
			}
		} while (!s.equals("]"));
		
		return content;
	}
	
	// http://www.java2s.com/Code/Android/Development/decodeUTF8toString.htm
	public static final String HEX_DIGITS = "0123456789ABCDEF";

	public static char decodeUTF8(String src) {
		if (src == null) {
			throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
		}

		if (!(src.startsWith("\\u") && src.length() <= 6)) {
			throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
		}

		char[] sources = src.substring(2).toCharArray();
		char res = 0;
		for (char nextChar : sources) {
			int digit = HEX_DIGITS.indexOf(Character.toUpperCase(nextChar));
			res = (char) (res * 16 + digit);
		}
		return res;
	}

	public static String decodeUTF8String(String src) {
		StringBuilder sb = new StringBuilder();
		char[] sources = src.toCharArray();
		for (int i = 0; i < sources.length; i++) {
			if (sources[i] == '\\' && i < sources.length - 5 && sources[i + 1] == 'u') {
				String utf8 = "" + sources[i++] + sources[i++] + sources[i++] + sources[i++] + sources[i++] + sources[i];
				sb.append(decodeUTF8(utf8));
			} else if (sources[i] == '\\') {
				// 略過反斜線，不知道會不會怎樣
			} else {
				sb.append(sources[i]);
			}
		}
		return sb.toString();
	}
	
	static class JsonContent {
		public int offset;
		public Object object;
		public JsonContent() {
			offset = 0;
			object = null;
		}
	}
	
}
