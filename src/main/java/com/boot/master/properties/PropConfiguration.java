package com.boot.master.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "test")
public class PropConfiguration {
    private String testProp1;
    private String testProp2;
    private String testProp3;
}
