package Services;

import Interfaces.IHashService;
import Interfaces.Service;

import java.security.*;
import java.util.Arrays;

public class HashService implements Service, IHashService {

    byte[] temp_salt = GenerateSalt();

    @Override
    public String Hash(String pass) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(temp_salt);
            byte[] data = messageDigest.digest(pass.getBytes());
            messageDigest.reset();
            return Arrays.toString(data);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private byte[] GenerateSalt(){
        try {
            byte[] salt = new byte[16];
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
