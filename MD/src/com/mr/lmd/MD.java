package com.mr.lmd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@SuppressWarnings("unused")
public class MD {

	private static final String srcStr = "security MD";

	public static void main(String[] args) {
		// jdkMD5();
		// jdkMD2();
		// bcMD4();
		// bcMD5();
		ccMD5();
	}

	public static void jdkMD5() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5byte = md.digest(srcStr.getBytes());
			System.out.println("jdk md5:" + Hex.encodeHexString(md5byte));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void jdkMD2() {
		try {
			// ע�⣺��û���ṩMD4��ʵ��
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md5byte = md.digest(srcStr.getBytes());
			System.out.println("jdk md2:" + Hex.encodeHexString(md5byte));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void bcMD4() {

		// ʵ�ַ�ʽ2����jdk��̬������һ��Provider(�㷨��ʵ���ṩ��),��ȻҲ����ͨ�������ļ�(properties)��ʽ����
		Security.addProvider(new BouncyCastleProvider());
		try {
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] md5byte = md.digest(srcStr.getBytes());
			System.out.println("bc md4:" + Hex.encodeHexString(md5byte));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// ʵ�ַ�ʽ1��
		// Digest digest = new MD4Digest();
		// digest.update(srcStr.getBytes(), 0, srcStr.getBytes().length);
		// byte[] md4Bytes = new byte[digest.getDigestSize()];
		// digest.doFinal(md4Bytes, 0);
		// System.out.println("bc md4:" +
		// org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
	}

	public static void bcMD5() {
		Digest digest = new MD5Digest();
		digest.update(srcStr.getBytes(), 0, srcStr.getBytes().length);
		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println("bc md5:" + Hex.encodeHexString(md5Bytes));
	}

	// cc��DigestUtils��û��ȥʵ��md5����md2��ֻ�Ǽ���jdk��md5��md2������ccû��md4,��Ϊjdkû��md4

	// d1292ccbac43fd87d3c925fff9b452f3
	public static void ccMD5() {
		System.out.println("cc md5:" + DigestUtils.md5Hex(srcStr));
		// MessageDigest md5Digest = DigestUtils.getMd5Digest();
		// byte[] md5byte = md5Digest.digest(srcStr.getBytes());
		// System.out.println("cc md5:" + Hex.encodeHexString(md5byte));
	}

	public static void ccMD2() {
		System.out.println("cc md2:" + DigestUtils.md2Hex(srcStr));
	}

}