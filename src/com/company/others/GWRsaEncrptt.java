package com.company.others;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class GWRsaEncrptt {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        //配置文件里的密码
        String cipherBase64 = "ivbwe7tpQApl5dvMYJCo8EUpGwpH73K7Xxng4RMEsqucGkQktxHF0hpkro90VhOnby5CN1G8z2I9JGJoXFG+Sg==";
        //配置文件里的公钥
        String publicKeyStr = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJELP9JPL+T1s7VtMlno2adOU2gaHNwGzgw7+wojM1lfiFIW8sw6ZVwj4ElUaXX9UNH8suwIAIW4K/QYCsk6MB8CAwEAAQ==";

        //公钥解密
        cipher.init(Cipher.DECRYPT_MODE, str2PublicKey(publicKeyStr));
        byte[] bb = cipher.doFinal(new BASE64Decoder().decodeBuffer(cipherBase64));
        System.out.println(new String(bb));

        //私钥加密
        String privateKeyStr = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAkQs/0k8v5PWztW0yWejZp05TaBoc3AbODDv7CiMzWV+IUhbyzDplXCPgSVRpdf1Q0fyy7AgAhbgr9BgKyTowHwIDAQABAkAnsWtq047o2rCucs63ujhuR8odkB/buuUChhuiX5W63DcZATIczxdvTaQ1EwGTQ4Kq8I6GpCg/HG2o3uvylOYRAiEA00QofUE7gx0x5sbA2fchIiFdjJY10oEizVVr0mczaCkCIQCvwXZ1OpauimjW23+5mWweubX7KyWgNEbaVy5xQbZ/BwIhAMGG1Bg5I0zt94JRWuPPr/hV3B4mk1MrnDfAIi7w/nRRAiAnjFX2fQ+JCPYcWtn7zo0owMs1UHkv+nNzECkQLSQ+owIgAzwTgPZMytdpb9D68Z4YqinLCjm4R482T/sLEooy8ms=";
        //明文密码
        String content = "wutengfei";
        cipher.init(Cipher.ENCRYPT_MODE, str2PrivateKey(privateKeyStr));
        byte[] b = cipher.doFinal(content.getBytes());
        String pwd = new BASE64Encoder().encode(b);
        System.out.println("encrypt pwd:" + pwd);

    }


    public static PublicKey str2PublicKey(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(str));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey str2PrivateKey(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(str));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }


}
