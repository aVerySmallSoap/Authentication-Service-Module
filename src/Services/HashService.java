package Services;

import Interfaces.IConnector;
import Interfaces.IHashService;
import Interfaces.Service;

import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class HashService implements Service, IHashService {

    IConnector connector = ConnectionService.getInstance();

    @Override
    public String Hash(String pass) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] temp_salt = GenerateSalt();
            messageDigest.update(temp_salt);
            byte[] data = messageDigest.digest(pass.getBytes());
            connector.registerToDB(Base64.getEncoder().encodeToString(data), Base64.getEncoder().encodeToString(temp_salt));
            messageDigest.reset();
            return Arrays.toString(data);
        }catch (Exception e){
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
