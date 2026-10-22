package com.obric.security.keystore;

import android.app.AppGlobals;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.obric.security.tls.TLSManager;
import com.obric.security.tls.TLSSignResult;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.SignatureSpi;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObricKeyStoreSignatureSpiBase extends SignatureSpi {
    private static final String DEFAULT_PROVIDER = "AndroidOpenSSL";
    private static final String TAG = "BDKeyStoreSignatureSpiBase";
    private byte[] mDigest;
    private ObricKeyStoreKey mKey;
    private Signature mSignature;
    private boolean mSigning;

    protected abstract String getAlgorithm();

    public ObricKeyStoreSignatureSpiBase() {
    }

    @Override // java.security.SignatureSpi
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        resetAll();
        Log.d(TAG, "engineInitVerify, algorithm: " + getAlgorithm());
        Signature signature = Signature.getInstance(getAlgorithm(), DEFAULT_PROVIDER);     // Catch: Throwable -> L5
        this.mSignature = signature;     // Catch: Throwable -> L5
        signature.initVerify(publicKey);     // Catch: Throwable -> L5
        this.mSigning = false;     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidKeyException(e);
    }

    @Override // java.security.SignatureSpi
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        engineInitSign(privateKey, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.SignatureSpi
    protected void engineInitSign(PrivateKey r4, SecureRandom random) throws InvalidKeyException {
        resetAll();
        Log.d(TAG, "engineInitSign, algorithm: " + getAlgorithm());
        if (r4 == 0) goto L11;
        if ((r4 instanceof ObricKeyStoreKey) == false) goto L9;
        this.mKey = (ObricKeyStoreKey) r4;
        this.mSigning = true;
        this.appRandom = random;
        this.mSignature = null;
        Log.d(TAG, "engineInitSign, alias: " + this.mKey.getAlias());
        return;
    L9:
        throw new InvalidKeyException("Unsupported key type, only support BDKeyStoreKey.");
    L11:
        throw new InvalidKeyException("Unsupported key: null");
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte b) throws SignatureException {
        engineUpdate(new byte[b], 0, 1);
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte[] b, int off, int len) throws SignatureException {
        Signature signature = this.mSignature;
        if (signature == null) goto L7;
        signature.update(b, off, len);
        return;
    L7:
        if (off < 0) goto L21;
        if (len < 1) goto L19;
        if ((off + len) > b.length) goto L19;
        byte[] bArr = new byte[len];
        this.mDigest = bArr;
        System.arraycopy(b, off, bArr, 0, len);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        throw new SignatureException(e);
    L19:
        throw new SignatureException("sign data is error.");
    L21:
        throw new SignatureException("sign data is error.");
    }

    @Override // java.security.SignatureSpi
    protected byte[] engineSign() throws SignatureException {
        if (this.mSigning == false) goto L7;
        TLSManager tlsManager = TLSManager.getInstance();
        Context ctx = AppGlobals.getInitialApplication().getApplicationContext();
        Log.d(TAG, "alg: " + getAlgorithm() + ", alias: " + this.mKey.getAlias());
        TLSSignResult signResult = tlsManager.sign(ctx, getAlgorithm(), this.mDigest, this.mKey.getAlias(), new Bundle());
        Log.d(TAG, "signResult.errorCode: " + signResult.getErrorCode());
        return signResult.getSignature();
    L7:
        throw new SignatureException("init type error");
    }

    @Override // java.security.SignatureSpi
    protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
        if (this.mSigning == true) goto L7;
        return this.mSignature.verify(sigBytes);
    L7:
        throw new SignatureException("init type error");
    }

    @Override // java.security.SignatureSpi
    protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
    }

    @Override // java.security.SignatureSpi
    protected Object engineGetParameter(String param) throws InvalidParameterException {
        return null;
    }

    protected void resetAll() {
        this.mDigest = null;
        this.mKey = null;
        this.mSigning = false;
        this.mSignature = null;
        this.appRandom = null;
    }
}
