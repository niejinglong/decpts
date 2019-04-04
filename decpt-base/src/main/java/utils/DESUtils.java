package utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.Key;

public class DESUtils extends keyGenerator  {
    /**
     * DES加密
     * @param data 待加密数据流
     * @param key 加密秘钥
     * @param isDefKey 是否使用默认秘钥 “false”不使用、“true”使用
     * @return
     */
    public static byte[] gEncrypt(byte[] data,Key key,boolean isDefKey) throws Exception{
        try{
            //设置加密算法
            Cipher cipher = Cipher.getInstance(DEF_KEY_ALGORITHM.isEmpty()?DES_ALGORITHM:DEF_KEY_ALGORITHM);
            //设置秘钥
            if (isDefKey){
                cipher.init(Cipher.ENCRYPT_MODE,def_DKey);
            }else{
                cipher.init(Cipher.DECRYPT_MODE,key);
            }
            //生成加密流
            byte[] outPut = cipher.doFinal(data);
            return outPut;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * DES 解密
     * @param data 待解密数据流
     * @param key 解密秘钥
     * @param isDefKey 是否使用默认秘钥 “false”不使用、“true”使用
     * @return
     */
    public static byte[] gDEncrypt(byte[] data,Key key,boolean isDefKey) throws Exception{
        try{
            //设置解密算法
            Cipher cipher = Cipher.getInstance(DEF_KEY_ALGORITHM.isEmpty()?DES_ALGORITHM:DEF_KEY_ALGORITHM);
            //设置秘钥
            if (isDefKey){
                cipher.init(Cipher.DECRYPT_MODE,def_DKey);
            }else{
                cipher.init(Cipher.DECRYPT_MODE,key);
            }
            //生成解密流
            byte[] outPut = cipher.doFinal(data);
            return outPut;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 字符串转二进制
     * @param str
     * @return
     * @throws Exception
     */
    public static byte[] StrToByte(String str) throws Exception{
        return str.getBytes(DEF_CHARSETNAME);
    }

    /**
     * 二进制转字符串
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String byteToStr(byte[] bytes) throws Exception{
        String string = new String(bytes,DEF_CHARSETNAME);
        return string;
    }
    /**
     * base64编码
     * @return
     * @throws Exception
     */
    public static String encode(byte[] by) throws Exception{
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(by);
    }
    /**
     * base64 解码
     * @param str
     * @return
     * @throws Exception
     */
    public static byte[] dEncode(String str) throws Exception{
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(str);
    }
}
