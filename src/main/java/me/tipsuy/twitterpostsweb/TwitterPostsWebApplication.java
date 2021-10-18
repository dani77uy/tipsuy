package me.tipsuy.twitterpostsweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterPostsWebApplication {

   public static void main(String[] args) {
      SpringApplication.run(TwitterPostsWebApplication.class, args);
   }

   //
   //   @Bean
   //   @Description("Thymeleaf Template Resolver")
   //   public ServletContextTemplateResolver templateResolver() {
   //      ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
   //      templateResolver.setPrefix("/WEB-INF/views/");
   //      templateResolver.setSuffix(".html");
   //      templateResolver.setTemplateMode("HTML5");
   //
   //      return templateResolver;
   //   }
   //
   //   @Bean
   //   @Description("Thymeleaf Template Engine")
   //   public SpringTemplateEngine templateEngine() {
   //      SpringTemplateEngine templateEngine = new SpringTemplateEngine();
   //      templateEngine.setTemplateResolver(templateResolver());
   //      templateEngine.setTemplateEngineMessageSource(messageSource());
   //      return templateEngine;
   //   }
   //
   //   @Bean
   //   @Description("Thymeleaf View Resolver")
   //   public ThymeleafViewResolver viewResolver() {
   //      ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
   //      viewResolver.setTemplateEngine(templateEngine());
   //      viewResolver.setOrder(1);
   //      return viewResolver;
   //   }
   //
   //   @Bean
   //   @Description("Spring Message Resolver")
   //   public ResourceBundleMessageSource messageSource() {
   //      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
   //      messageSource.setBasename("messages");
   //      return messageSource;
   //   }
   //

}
