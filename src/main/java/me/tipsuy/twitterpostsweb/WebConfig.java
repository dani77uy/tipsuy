package me.tipsuy.twitterpostsweb;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import me.tipsuy.twitterpostsweb.web.TeamController;
import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * @author Daniel Baharian
 * @since 11 oct. 2021
 */
@Configuration
@ComponentScan(basePackageClasses = { TeamController.class })
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

   private ApplicationContext applicationContext;

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      this.applicationContext = applicationContext;
   }

//   @Bean
//   public ViewResolver viewResolver() {
//      final var resolver = new ThymeleafViewResolver();
//      resolver.setTemplateEngine(templateEngine());
//      resolver.setCharacterEncoding("UTF-8");
//      return resolver;
//   }
//
//   @Bean
//   public ISpringTemplateEngine templateEngine() {
//      final var engine = new SpringTemplateEngine();
//      engine.setEnableSpringELCompiler(true);
//      engine.setTemplateResolver(templateResolver());
//      engine.addDialect(new LayoutDialect());
//      return engine;
//   }
//
//   private ITemplateResolver templateResolver() {
//      final var resolver = new SpringResourceTemplateResolver();
//      resolver.setApplicationContext(applicationContext);
//      resolver.setPrefix("classpath:/templates/");
//      resolver.setSuffix(".html");
//      resolver.setTemplateMode(TemplateMode.HTML);
//      return resolver;
//   }

   @Bean
   public SpringResourceTemplateResolver teamTemplateResolver() {
      final var templateResolver = new SpringResourceTemplateResolver();
      templateResolver.setPrefix("classpath:/templates/team/");
      templateResolver.setSuffix(".html");
      templateResolver.setTemplateMode(TemplateMode.HTML);
      templateResolver.setCharacterEncoding("UTF-8");
      templateResolver.setOrder(0);
      templateResolver.setCheckExistence(true);
      return templateResolver;
   }

   @Bean
   public SpringResourceTemplateResolver playerTemplateResolver() {
      final var templateResolver = new SpringResourceTemplateResolver();
      templateResolver.setPrefix("classpath:/templates/player/");
      templateResolver.setSuffix(".html");
      templateResolver.setTemplateMode(TemplateMode.HTML);
      templateResolver.setCharacterEncoding("UTF-8");
      templateResolver.setOrder(1);
      templateResolver.setCheckExistence(true);
      return templateResolver;
   }

//   @Bean
//   public ClassLoaderTemplateResolver secondTemplateResolver() {
//      ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//      templateResolver.setPrefix("templates/templatelocation/other/");
//      templateResolver.setSuffix(".html");
//      templateResolver.setTemplateMode(TemplateMode.HTML);
//      templateResolver.setCharacterEncoding("UTF-8");
//      templateResolver.setOrder(1);
//      templateResolver.setCheckExistence(true);
//
//      return templateResolver;
//   }
//
//   @Bean
//   public ClassLoaderTemplateResolver thirdTemplateResolver() {
//      ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//      templateResolver.setPrefix("templates/templatelocation/another/");
//      templateResolver.setSuffix(".html");
//      templateResolver.setTemplateMode(TemplateMode.HTML);
//      templateResolver.setCharacterEncoding("UTF-8");
//      templateResolver.setOrder(2);
//      templateResolver.setCheckExistence(true);
//
//      return templateResolver;
//   }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
   }
}
