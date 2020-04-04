package app.config;

import app.converter.PdfHttpMessageConverterImpl;
import app.model.User;
import com.sun.xml.bind.v2.runtime.JAXBContextImpl;
import com.sun.xml.bind.v2.runtime.MarshallerImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.Marshaller;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
  }

  @Bean
  ServletRegistrationBean h2servletRegistration() {
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
    registrationBean.addUrlMappings("/h2-console/*");
    return registrationBean;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
  }
  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(userToPdfConverter());
    converters.add(jsonConverter());
  }




  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer
        .defaultContentType(MediaType.TEXT_HTML)
        .parameterName("type")
        .favorParameter(true)
        .ignoreUnknownPathExtensions(false)
        .ignoreAcceptHeader(false);
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.freeMarker();
    registry.enableContentNegotiation(new PdfReportViewGenerator(), new MappingJackson2JsonView());
  }

  @Bean
  PdfHttpMessageConverterImpl userToPdfConverter() {
    return new PdfHttpMessageConverterImpl();
  }

  @Bean
  MappingJackson2HttpMessageConverter jsonConverter() {
    return new MappingJackson2HttpMessageConverter();
  }
}