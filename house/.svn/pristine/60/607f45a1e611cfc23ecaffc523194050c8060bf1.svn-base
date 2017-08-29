package com.qfedu.house.cipher;

import com.qfedu.house.cipher.impl.AESCipher;
import com.qfedu.house.cipher.impl.RSACipher;

public class ThyCiphers {

	private ThyCiphers() {
		throw new AssertionError();
	}
	
	public static ThyCipher getThyCipher(String algorithm) {
		algorithm = algorithm.toLowerCase();
		ThyCipher thyCipher = null;
		switch (algorithm) {
		case "aes":
			thyCipher = new AESCipher();
			break;
		case "rsa":
			thyCipher = new RSACipher();
			break;
		default:
			throw new CipherAlgorithmNotSupportedException();
		}
		return thyCipher;
	}
}
