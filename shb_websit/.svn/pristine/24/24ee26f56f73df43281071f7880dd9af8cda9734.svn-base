package com.shb.web.web.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5 {

	public static final String encode(String str) throws NoSuchAlgorithmException {
		String encode = str;
		StringBuilder stringbuilder = new StringBuilder();

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(encode.getBytes());
		byte[] str_encoded = md5.digest();
		for (int i = 0; i < str_encoded.length; i++) {
			if ((str_encoded[i] & 0xff) < 0x10) {
				stringbuilder.append("0");
			}
			stringbuilder.append(Long.toString(str_encoded[i] & 0xff, 16));
		}
		return stringbuilder.toString();
	}

	/**
	 * 利用MD5进行加密
	 * 
	 * @param str
	 *            待加密的字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static final String EncoderByMd5(String str) {
		if (str == null) {
			return null;
		}
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			// 加密后的字符a串
			return base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			return null;
		}
	}

}
