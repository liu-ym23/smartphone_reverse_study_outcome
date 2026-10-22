package com.obric.security.keystore;

import android.util.Log;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyStoreCipherSpiBase extends CipherSpi {
    private static final String TAG = "BDKeyStoreCipherSpiBase";

    public ObricKeyStoreCipherSpiBase() {
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetMode(String mode) throws NoSuchAlgorithmException {
        Log.i(TAG, "engineSetMode");
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetPadding(String padding) throws NoSuchPaddingException {
        Log.i(TAG, "engineSetPadding");
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetBlockSize() {
        Log.i(TAG, "engineGetBlockSize");
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetOutputSize(int inputLen) {
        Log.i(TAG, "engineGetOutputSize");
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineGetIV() {
        Log.i(TAG, "engineGetIV");
        return new byte[0];
    }

    @Override // javax.crypto.CipherSpi
    protected AlgorithmParameters engineGetParameters() {
        Log.i(TAG, "engineGetParameters");
        return null;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        Log.i(TAG, "engineInit");
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int opmode, Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException, InvalidKeyException {
        Log.i(TAG, "engineInit");
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int opmode, Key key, AlgorithmParameters params, SecureRandom random) throws InvalidAlgorithmParameterException, InvalidKeyException {
        Log.i(TAG, "engineInit");
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        Log.i(TAG, "engineUpdate");
        return new byte[0];
    }

    @Override // javax.crypto.CipherSpi
    protected int engineUpdate(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws ShortBufferException {
        Log.i(TAG, "engineUpdate");
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen) throws BadPaddingException, IllegalBlockSizeException {
        Log.i(TAG, "engineDoFinal");
        return new byte[0];
    }

    @Override // javax.crypto.CipherSpi
    protected int engineDoFinal(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        Log.i(TAG, "engineDoFinal");
        return 0;
    }
}
