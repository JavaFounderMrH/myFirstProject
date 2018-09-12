package com.shb.web.web.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomCode {

	public static String randomCode() {

		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		String code = "7A5D"; // 默认

		StringBuilder sb = null;

		try {

			sb = new StringBuilder(4);

			for (int i = 0; i < 4; i++) {

				char ch = str.charAt(new Random().nextInt(str.length()));

				sb.append(ch);

			}

			code = sb.toString();

			System.out.println(sb.toString());

			return code;

		} catch (Exception e) {

			return code;
		}

	}

	public String random() {

		String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "0", "1" };

		List list = Arrays.asList(beforeShuffle);

		Collections.shuffle(list);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {

			sb.append(list.get(i));

		}

		String afterShuffle = sb.toString();

		String result = afterShuffle.substring(5, 9);

		return result;

	}

}
