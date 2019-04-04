package comm;

import utils.ProjectConfig;

public class commConstant {
    public static String DEF_OPEN_KEY = "close"; // 是否开启默认秘钥 默认“close”不开启、“open”开启
    public static String DEF_OPEN_SMGEPT ="colse"; //是否开启分段加解密 默认“close”不开启、“open”开启
    public static String DEF_CMDGN_DKEY; // 定制对称秘钥
    public static String DEF_KEY_ISOUT = "NO"; //是否输出秘钥
    public static String DEF_KEY_OUT_PATH ; //秘钥输出路径 注：如果输出秘钥则必须配置秘钥输出路径
    public static String DEF_KEY_DOUT_NAME; //对称秘钥输出名称 默认秘钥名称为 [DK_yyyy-MM-dd.pfx]
    public static String DEF_KEY_FGOUT_NAME; //非称公钥输出名称 默认秘钥名称为 [FGK_yyyy-MM-dd.pfx]
    public static String DEF_KEY_FSOUT_NAME; //非称私钥输出名称 默认秘钥名称为 [FSK_yyyy-MM-dd.pfx]
    //字符集
    public static String DEF_CHARSETNAME = "UTF-8"; // 编码字符集 默认UTF-8
    //算法
    public static String DEF_KEY_ALGORITHM; //默认算法名称
    public static String DEF_CIPHER_ALGORITHM = "DES/ECB/NoPadding"; //算法名称/加密模式/填充方式 DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式

    //开启或关闭默认秘钥
    public static String Open_Def_Key  = "open";
    public static String Close_Def_Key = "colse";
    //是否输出秘钥
    public static String Yes_Key_Out = "YES";
    public static String No_Key_Out  = "NO";
    //对称算法类型
    public static String AES_ALGORITHM = "AES";
    public static String DES_ALGORITHM = "DES";
    public static String RC4_ALGORITHM = "RC4";
    public static String BlowFish_ALGORITHM = "BlowFish";
    //非称算法类型
    public static String RSA_ALGORITHM = "RSA";
    //RSA秘钥类型
    public static String PUB_RSA_KEY ="G";
    public static String PRV_RSA_KEY ="S";

    static {
        ProjectConfig pf = ProjectConfig.getInstance();
        //秘钥配置
        DEF_OPEN_KEY = pf.getVue("de.def_Open_Key").isEmpty()?DEF_OPEN_KEY:pf.getVue("de.def_Open_Key");
        DEF_OPEN_SMGEPT = pf.getVue("de.def_Open_Smgept").isEmpty()?DEF_OPEN_SMGEPT:pf.getVue("de.def_Open_Smgept");
        DEF_CMDGN_DKEY = pf.getVue("de.def_CmDgn_Key").isEmpty()?"":pf.getVue("de.def_CmDgn_Key");
        DEF_KEY_ISOUT = pf.getVue("de.def_Key_IsOut").isEmpty()?DEF_KEY_ISOUT:pf.getVue("de.def_Key_IsOut");
        DEF_KEY_OUT_PATH = pf.getVue("de.def_Key_Out_Path").isEmpty()?"":pf.getVue("de.def_Key_Out_Path");
        DEF_KEY_DOUT_NAME = pf.getVue("de.def_Key_DOut_Name").isEmpty()?"":pf.getVue("de.def_Key_DOut_Name");
        DEF_KEY_FGOUT_NAME = pf.getVue("de.def_Key_FGOut_Name").isEmpty()?"":pf.getVue("de.def_Key_FGOut_Name");
        DEF_KEY_FSOUT_NAME = pf.getVue("de.def_Key_FSOut_Name").isEmpty()?"":pf.getVue("de.def_Key_FSOut_Name");
        //字符集配置
        DEF_CHARSETNAME = pf.getVue("de.def_CharsetName").isEmpty()?DEF_CHARSETNAME:pf.getVue("de.def_CharsetName");
        //算法配置
        DEF_KEY_ALGORITHM = pf.getVue("de.def_Key_Algorithm").isEmpty()?"":pf.getVue("de.def_Key_Algorithm");
        DEF_CIPHER_ALGORITHM = pf.getVue("de.def_Cipher_Algorithm").isEmpty()?"":pf.getVue("de.def_Cipher_Algorithm");

        System.out.print("\n");
        System.out.print("是否使用默认秘钥===:"+DEF_OPEN_KEY);
        System.out.print("\n");
        System.out.print("定制秘钥===:"+DEF_CMDGN_DKEY);
        System.out.print("\n");
        System.out.print("加载字符集配置===:"+DEF_CHARSETNAME);
        System.out.print("\n");
        System.out.print("加载算法===:"+DEF_KEY_ALGORITHM);
        System.out.print("\n");
    }
}
