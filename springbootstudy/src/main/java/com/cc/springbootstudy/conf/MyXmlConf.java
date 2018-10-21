package com.cc.springbootstudy.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"applicationContext.xml"})
public class MyXmlConf {

}
