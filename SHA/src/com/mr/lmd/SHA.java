package com.mr.lmd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;

public class SHA {

	private static final String srcStr = "SHA MessageDigestAlgorithm";

	public static void main(String[] args) {
		jdkSHA1();
		bcSHA1();
		ccSHA1();
	}

	// adeead78e1e15dc666fe318ae9ec78adf0e95a7a
	public static void jdkSHA1() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			// ע��jdk��û��ʵ��SHA-224�㷨�ģ�bc����ʵ�ֵ�
			// MessageDigest md = MessageDigest.getInstance("SHA-384");
			md.update(srcStr.getBytes());
			System.out.println("jdk sha1:" + Hex.encodeHexString(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	// adeead78e1e15dc666fe318ae9ec78adf0e95a7a
	public static void bcSHA1() {
		Digest digest = new SHA1Digest();
		// digest = new SHA224Digest();
		digest.update(srcStr.getBytes(), 0, srcStr.length());
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println("bc sha1:" + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
	}

	// ע�⣺cc�������Ƕ�jdk�ļ�
	public static void ccSHA1() {
		System.out.println("cc sha1:" + DigestUtils.sha1Hex(srcStr.getBytes()));
		System.out.println("cc sha1:" + DigestUtils.sha1Hex(srcStr));
	}
}
