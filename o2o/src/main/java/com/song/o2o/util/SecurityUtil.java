package com.song.o2o.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;



public class SecurityUtil
{
	public static final String PASSWORD_MD5 = "47348484874984984384747439202";
	private static final String HEX_NUMS_STR = "0123456789ABCDEF";

	/**
	 * 掌中彩16位加密方法
	 * @param plainText
	 * @return
	 */
	public static String ZhangZhongCaiMd5(String plainText, String codeType)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			try
			{
				md.update(plainText.getBytes(codeType));
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++)
			{
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString().substring(8, 24).toUpperCase();// 32
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**   
	
	* 将16进制字符串转换成字节数组   
	* @param hex   
	* @return   
	*/
	public static byte[] hexStringToByte(String hex)
	{
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] hexChars = hex.toCharArray();
		for (int i = 0; i < len; i++)
		{
			int pos = i * 2;
			result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
		}
		return result;
	}

	/** 
	 * 将指定byte数组转换成16进制字符串 
	 * @param b 
	 * @return 
	 */
	public static String byteToHexString(byte[] b)
	{
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++)
		{
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1)
			{
				hex = '0' + hex;
			}
			hexString.append(hex.toUpperCase());
		}
		return hexString.toString();
	}

	public static String byte2hex(byte abyte0[])
	{
		StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
		for (int i = 0; i < abyte0.length; i++)
		{
			if ((abyte0[i] & 0xff) < 16)
			{
				stringbuffer.append("0");
			}
			stringbuffer.append(Long.toString((long) abyte0[i] & (long) 255, 16));
		}

		return stringbuffer.toString().toUpperCase();
	}

	public static String getMd5(String s)
	{
		byte abyte0[] = null;
		MessageDigest messagedigest;
		try
		{
			messagedigest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException nosuchalgorithmexception)
		{
			throw new IllegalArgumentException("no md5 support");
		}
		//此处指定默认UTF-8编码，避免部署在WINDOWS机器时读取默认的GBK编码，导致编码密钥时不正确
		try
		{
			messagedigest.update(s.getBytes("UTF-8"));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		abyte0 = messagedigest.digest();
		return byte2hex(abyte0);
	}

	public static String getMd5(String s, String charset) throws UnsupportedEncodingException
	{
		byte abyte0[] = null;
		MessageDigest messagedigest;
		try
		{
			messagedigest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException nosuchalgorithmexception)
		{
			throw new IllegalArgumentException("no md5 support");
		}
		messagedigest.update(s.getBytes(charset));
		abyte0 = messagedigest.digest();
		return byte2hex(abyte0);
	}

	public static String hmacmd5(String ssn, int seed) throws Exception
	{
		try
		{
			byte[] plainText = ssn.getBytes();

			KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
			SecureRandom sr = new SecureRandom();

			//			LoggerUtil.debug("seed=" + seed, "SecurityUtil", "hmacmd5");

			sr.setSeed(seed);
			keyGen.init(64, sr);
			SecretKey MD5key = keyGen.generateKey();
			Mac mac = Mac.getInstance("HmacMD5");
			mac.init(MD5key);
			mac.update(plainText);

			return URLEncoder.encode(new String(mac.doFinal()), "UTF-8");
		}
		catch (Exception e)
		{
			//			LoggerUtil.warn(e.getMessage(), SecurityUtil.class.getName(), "hmacmd5");
			throw new Exception(e);
		}
	}

	

	public static void main(String[] args)
	{
		String value = SecurityUtil.getMd5(PASSWORD_MD5 + "1");
		String ss = SecurityUtil.ZhangZhongCaiMd5("123456", "UTF-8");
		System.out.println("Zhongzhongcaimd5  "+ss);
		System.out.println("md5  "+value);
	}
}
