package com.mybatis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:application.properties"})
public class MybatisProperties {
    @Value("${database.driver}")
    private String Driver;
    @Value("${database.url}")
    private String Url;
    @Value("${database.username}")
    private String Username;
    @Value("${database.password}")
    private String Password;
    @Value("${Resource}")
    private String mapperLocations;
    @Value("${TypeAliasesPackage}")
    private String TypeAliasesPackage;

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasesPackage() {
        return TypeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        TypeAliasesPackage = typeAliasesPackage;
    }

}
