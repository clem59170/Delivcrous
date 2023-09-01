//package com.example.delivcrous;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.FileCopyUtils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class DatabaseInitializer {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    ResourceLoader resourceLoader;
//
//    @PostConstruct
//    public void initialize() throws IOException {
//        // Charger le fichier SQL en tant que Resource
//        InputStream inputStream = resourceLoader.getResource("classpath:data_old.sql").getInputStream();
//        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
//        String sql = new String(bdata, StandardCharsets.UTF_8);
//
//        // Exécuter le SQL
//        jdbcTemplate.execute(sql);
//    }
//}
