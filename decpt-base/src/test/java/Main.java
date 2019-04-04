import utils.DESUtils;

public class Main {

    public static void main (String arge[]){
        try{
            String str = "你好吗？";
            System.out.print("加密前:"+str);
            byte[]  jm = DESUtils.gEncrypt(DESUtils.StrToByte(str),null,true);
            String s1 = DESUtils.encode(jm);
            System.out.print("\n");
            System.out.print("加密后:"+s1);
            System.out.print("\n");
            System.out.print("解密前:"+s1);
            byte[] jjm = DESUtils.gDEncrypt(DESUtils.dEncode(s1),null,true);
            String s2 = DESUtils.byteToStr(jjm);
            System.out.print("\n");
            System.out.print("解密后:"+s2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
