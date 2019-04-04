package utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 获取配置文件信息
 */
public class ProjectConfig {
    private static ProjectConfig config;
    private static Properties properties;

    public ProjectConfig(){
        try{
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("decpt.properties");
            properties = new Properties();
            properties.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 获取ProjectConfig实例
     * @return
     */
    public static ProjectConfig getInstance(){
        if (config != null)
            return config;
        else
            return new ProjectConfig();
    }
    public static String getVue(String key){
        if (null != properties)
            return properties.get(key) == null?"":properties.get(key).toString();
        else
            return "";
    }
}
