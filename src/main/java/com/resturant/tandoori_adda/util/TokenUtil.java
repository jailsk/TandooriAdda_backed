package com.resturant.tandoori_adda.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

public class TokenUtil {
    public static String extractUsernameFromToken(String idToken) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        if (Boolean.TRUE.equals(decodedToken.getClaims().get("admin"))) {
        	 System.out.println("admin");
        	}
        return decodedToken.getEmail();
    }
}