//此文件用于java类配置与xml文件进行对比
//package cn.edu.cdu.itcast.config;
//
//import com.google.code.kaptcha.impl.DefaultKaptcha;
//import com.google.code.kaptcha.util.Config;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Properties;
//
//
//
//public class kaptcha {
//    @Bean
//    public DefaultKaptcha producer(){
//        Properties properties= new Properties();
//        properties.put("kaptcha.border","no");
//        properties.put("kaptcha.textProducer.font.color","black");
//        properties.put("kaptcha.textProducer.char.length","1");
//        Config config=new Config(properties);
//        DefaultKaptcha defaultKaptcha=new DefaultKaptcha();
//        defaultKaptcha.setConfig(config);
//        return defaultKaptcha;
//    }
//}
