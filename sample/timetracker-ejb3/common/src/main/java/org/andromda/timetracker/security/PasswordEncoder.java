package org.andromda.timetracker.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

public class PasswordEncoder
{
    /**
     * @param plaintext
     * @return new String(org.apache.commons.codec.binary.Base64.encodeBase64(raw))
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getMD5Base64EncodedPassword(String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plaintext.getBytes("UTF8"));
        byte raw[] = md.digest();
        // if error in eclipse
        // Go to Window-->Preferences-->Java-->Compiler-->Error/Warnings.
        // Select Deprecated and Restricted API. Change it to warning.
        // Change forbidden and Discouraged Reference and change it to warning. (or as your need.)
        // String hash = new sun.misc.BASE64Encoder().encode(raw);
        String hash = new String(Base64.encodeBase64(raw));
        return hash;
    }
}
