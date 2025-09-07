package io.github.lucasfrancobn.soap_api.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurer;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig implements WsConfigurer {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition userWsdlDefinition(XsdSchema usersSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("UserPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://example.com/soap/users");
        definition.setSchema(usersSchema);
        return definition;
    }

    @Bean(name = "address")
    public DefaultWsdl11Definition addressWsdlDefinition(XsdSchema addressSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("AddressPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://example.com/soap/address");
        definition.setSchema(addressSchema);
        return definition;
    }

    @Bean
    public XsdSchema usersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/users/users.xsd"));
    }

    @Bean
    public XsdSchema addressSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/address/address.xsd"));
    }
}
