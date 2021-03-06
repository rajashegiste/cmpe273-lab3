package edu.sjsu.cmpe.cache.client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConsistentHash {

	public static int getConsistentHashingKey(String algo, Long key, int servers)
			throws NoSuchAlgorithmException {

		
		MessageDigest messageDigest = MessageDigest.getInstance(algo);
		messageDigest.update(key.byteValue());
		byte[] digest = messageDigest.digest();
		BigInteger digestInt = new BigInteger(1, digest);
		return digestInt.mod(BigInteger.valueOf(servers)).intValue();

	}

}