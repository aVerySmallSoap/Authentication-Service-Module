package Interfaces;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;

public interface IHashService {

    String Encrypt(String str) throws NoSuchAlgorithmException, InvalidKeyException, InvalidParameterException;
    String Decrypt(String str) throws NoSuchAlgorithmException, InvalidKeyException, InvalidParameterException;
}
