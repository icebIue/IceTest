package icewine.study.Config;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.config.Profiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configurable
@EnableSwagger2     //开启Swagger2
public class SwaggerConfig {


    //配置了swagger的docket的bean实例
    @Bean
    public Docket docket(Environment environment){

//        //设置要显示的swagger环境
//        Profiles profiles = Profiles.of("dev","master");
//        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                /*以下是一套的，.apiInfo(apiInfo())，.select()，
                 .apis(RequestHandlerSelectors.basePackage("icewine.study.controller"))，
                 .build();
                  四个不能缺。
                 */
                .apiInfo(apiInfo())
                //配置API文档的分组
                .groupName("ice")
                //enable是否启动Swagger，如果为false，则swagger不能在浏览器中访问
//                .enable(true)
                .select()
                /*RequestHandlerSelectors,配置要扫描接口的方式
                  basePackage：指定要扫描的包
                  ant():扫描全部
                  none():不扫描
                  withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                  withMethodAnnotation：扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("icewine.study.Controller"))
                //paths():过滤什么路径
//                .paths(PathSelectors.ant("/study/**"))
                .build();

    }

    //配置swagger信息：apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("ice",null,"3376129179@qq.com");
        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "https://github.com/icebIue/IceTest",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

    //配置多个分组，多个docker实例即可
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");

    }

}
