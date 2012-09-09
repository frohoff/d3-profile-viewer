package com.bc.d3.web;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

public final class Functions {

	private static final URLCodec URL_CODEC = new URLCodec("utf8");

	public static String urlencode(String url) {
		try {
			return URL_CODEC.encode(url);
		} catch (EncoderException exception) {
			throw new RuntimeException(exception);
		}
	}

	private Functions() {
	}

}
