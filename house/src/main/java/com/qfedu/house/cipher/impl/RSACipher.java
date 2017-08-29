package com.qfedu.house.cipher.impl;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

import com.qfedu.house.cipher.CipherAlgorithmNotSupportedException;
import com.qfedu.house.cipher.ThyCipher;

public class RSACipher implements ThyCipher {
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public RSACipher() {
		this._generateKey();
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	@Override
	public String encodeString(String originalStr) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] buffer = cipher.doFinal(originalStr.getBytes());
			return Base64.getEncoder().encodeToString(buffer);
		} catch (Exception e) {
			throw new CipherAlgorithmNotSupportedException();
		}
	}

	@Override
	public String decodeString(String cipheredStr) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] buffer = cipher.doFinal(Base64.getDecoder().decode(cipheredStr));
			return new String(buffer, "utf-8");
		} catch (Exception e) {
			throw new CipherAlgorithmNotSupportedException();
		}
	}

	private void _generateKey() {
		try {
			KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
			gen.initialize(1024);
			KeyPair pair = gen.generateKeyPair();
			privateKey = pair.getPrivate();
			publicKey = pair.getPublic();
		} catch (Exception e) {
			throw new CipherAlgorithmNotSupportedException();
		}
	}

}
