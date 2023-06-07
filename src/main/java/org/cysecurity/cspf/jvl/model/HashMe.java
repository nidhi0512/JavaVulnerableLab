package org.cysecurity.cspf.jvl.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author breakthesec
 */
public class HashMe {
    public static String hashMe(String str) 
    {
         StringBuffer sb=null;
        try
        {   
        SecretKey key = new SecretKeySpec(SECRET_KEY_FROM_CONFIG, "MD5");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // Consider a stronger mode, such as GCM / CCM / or other AEAD mode, if required
        cipher.init(Cipher.ENCRYPT_MODE, key);
        encData = cipher.doFinal(plainText.getBytes("UTF-8"));
        byte[] iv = cipher.getIV();
          //  MessageDigest md = MessageDigest.getInstance("MD5");
          //  md.update(str.getBytes());
          //  byte byteData[] = md.digest();
           sb= new StringBuffer();
            for (int i = 0; i < iv.length; i++) 
            {
             sb.append(Integer.toString((iv[i] & 0xff) + 0x100, 16).substring(1));
            }   
        }
        catch(NoSuchAlgorithmException e)
        {
            
        }
         catch (GeneralSecurityException e) {
        handleError(e);
    }
        return sb.toString();
    }
}
