package utils;

import comm.commConstant;

import javax.crypto.KeyGenerator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;


public class keyGenerator extends commConstant {
    static Key def_DKey; //默认对称秘钥

    static {
        if (DEF_OPEN_KEY.equals(Open_Def_Key)){
            def_DKey = DGenKey(0,0);
        }
    }
    /**
     * 对称秘钥生成器
     * @param KeySize
     * @param seed
     * @return
     */
    public static Key DGenKey(int KeySize,long seed){
        try{
            String ALGORITHM = DEF_KEY_ALGORITHM.isEmpty()?DES_ALGORITHM:DEF_KEY_ALGORITHM;
            //设置秘钥算法
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            //初始化秘钥
            initKey(keyGenerator,KeySize >0?KeySize:56,seed >0?seed:0);
            //生成秘钥
            Key key = keyGenerator.generateKey();
            //是否输出秘钥
            if (DEF_KEY_ISOUT.equals(Yes_Key_Out)) {
                if (DEF_KEY_OUT_PATH.isEmpty()) throw new RuntimeException("获取秘钥输出路径失败，请设置！！！");

                if (DEF_KEY_DOUT_NAME.isEmpty()) { //生成默认对称秘钥名称
                    DEF_KEY_DOUT_NAME = "DK_"+new Date()+".pfx";
                }
                String fileName = DEF_KEY_OUT_PATH + DEF_KEY_DOUT_NAME;
                FileOutputStream outputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(key);
                objectOutputStream.close();
                outputStream.close();
            }
            return  key;
        }catch (Exception e){
            System.out.print(e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 初始化秘钥
     * @param keyGenerator
     * @param KeySize
     * @param seed
     */
    private static final void initKey(KeyGenerator keyGenerator,int KeySize,long seed){
        if (!DEF_CMDGN_DKEY.isEmpty()) {
            keyGenerator.init(KeySize,new SecureRandom(DEF_CMDGN_DKEY.getBytes()));
        }else{
            if (seed >0){
                SecureRandom secureRandom = new SecureRandom();
                secureRandom .setSeed(seed);
                keyGenerator.init(KeySize,secureRandom);
            }else{
                keyGenerator.init(KeySize,new SecureRandom());
            }
        }
    }
}
