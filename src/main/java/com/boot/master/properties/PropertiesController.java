package com.boot.master.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prop")
public class PropertiesController {

    @Value("${prop.prop1}")
    private String prop1;
    @Value("${prop.prop2}")
    private String prop2;

    @Autowired
    private PropConfiguration propConfiguration;

    @Autowired
    private Environment environment;


    @GetMapping("/specific")
    public ResponseEntity<List<String>> getSpecificProperties() {
        List<String> props = List.of(prop1, prop2);
        return new ResponseEntity<>(props, HttpStatus.OK);
    }

    @GetMapping("via-config")
    public ResponseEntity<List<String>> getPropertiesFromConfig() {
        List<String> props = List.of(propConfiguration.getTestProp1(),
                propConfiguration.getTestProp2(),
                propConfiguration.getTestProp3());
        return new ResponseEntity<>(props, HttpStatus.OK);
    }

}
