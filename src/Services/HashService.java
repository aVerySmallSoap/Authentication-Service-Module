package Services;

import Interfaces.IHashService;
import Interfaces.Service;

import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;

public class HashService implements Service, IHashService {
    @Override
    public String Encrypt(String str){
        try{
            return null;
        }catch (NoSuchAlgorithmException | InvalidParameterException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String Decrypt(String str){
        try{
            return null;
        }catch (NoSuchAlgorithmException | InvalidParameterException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
