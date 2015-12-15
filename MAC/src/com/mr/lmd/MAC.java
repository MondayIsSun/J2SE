package com.mr.lmd;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * MAC��Ϊ����SHA��MD5,�����ֱ�����HMAC
 * 
 * ʵ����MACֻ�Ƕ�MD5��SHA�ṩ����Կ����
 * 
 * @author LinMingDao
 *
 */
public class MAC {

	private static String src = "security hmac";

	public static void main(String[] args) {
		jdkHMacMD5();
		bcHMacMD5();
	}

	public static void jdkHMacMD5() {
		KeyGenerator keyGenerator;
		try {
			// ������Կ
			// keyGenerator = KeyGenerator.getInstance("HmacMD5");
			// SecretKey secretKey = keyGenerator.generateKey();
			// byte[] key = secretKey.getEncoded();
			byte[] key = Hex.decodeHex(new char[] { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' });

			// ��ԭ��Կ
			SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");

			// ʵ���ͳ�ʼ��Mac
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			mac.init(restoreSecretKey);

			// ִ��ժҪ
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());
			System.out.println("jdk hmacMD5:" + Hex.encodeHexString(hmacMD5Bytes));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
	}

	public static void bcHMacMD5() {
		HMac hmac = new HMac(new MD5Digest());
		hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
		hmac.update(src.getBytes(), 0, src.getBytes().length);

		byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];
		hmac.doFinal(hmacMD5Bytes, 0);

		System.out.println("bc hmacMD5:" + org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
	}

}
