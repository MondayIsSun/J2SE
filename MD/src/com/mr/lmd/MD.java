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
			// 注意：并没有提供MD4的实现
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md5byte = md.digest(srcStr.getBytes());
			System.out.println("jdk md2:" + Hex.encodeHexString(md5byte));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void bcMD4() {

		// 实现方式2：给jdk动态地添加一个Provider(算法的实现提供者),当然也可以通过配置文件(properties)方式添加
		Security.addProvider(new BouncyCastleProvider());
		try {
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] md5byte = md.digest(srcStr.getBytes());
			System.out.println("bc md4:" + Hex.encodeHexString(md5byte));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// 实现方式1：
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

	// cc的DigestUtils并没有去实现md5或者md2，只是简化了jdk的md5和md2，所以cc没有md4,因为jdk没有md4

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
