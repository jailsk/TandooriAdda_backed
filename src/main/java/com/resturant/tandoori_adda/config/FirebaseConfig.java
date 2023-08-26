package com.resturant.tandoori_adda.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("D:\\SpringProjects\\tandoori_adda\\src\\main\\java\\com\\resturant\\tandoori_adda\\config\\serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tandooriadda-ab3b6-default-rtdb.asia-southeast1.firebasedatabase.app")
                .build();

        return FirebaseApp.initializeApp(options);
    }
    
   
}