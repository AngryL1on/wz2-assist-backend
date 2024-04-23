package dev.angryl1on.wz2assistapi.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for defining beans.
 */
@Configuration
public class BeanConfig {
    /**
     * Creates a bean for the ModelMapper class.
     *
     * <p>The ModelMapper is a utility class that provides a convenient way to
     * map an instance of one object to an instance of another object type.
     * It automatically determines how one object model maps to another,
     * allowing for the construction of plain data objects from request
     * payloads or database responses.
     *
     * @return an instance of the ModelMapper class
     */
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
