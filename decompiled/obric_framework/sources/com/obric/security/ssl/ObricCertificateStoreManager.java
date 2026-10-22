package com.obric.security.ssl;

import android.app.AppGlobals;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.obric.security.keystore.ObricKeyStoreEcPrivateKey;
import com.obric.security.tls.TLSCertChainResult;
import com.obric.security.tls.TLSManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricCertificateStoreManager {
    private static final Object CERT_LOCK = null;
    private static final String DEFAULT_TLS_TEST_CERT = "-----BEGIN CERTIFICATE-----\nMIICUjCCAfigAwIBAgIUGAMw1RePryaaWFh0WQZvpn26lpgwCgYIKoZIzj0EAwIw\nVjESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMR8wHQYDVQQDExZCeXRlRGFuY2UgU21hcnQgVExTIENBMB4XDTI0MTAz\nMDA5MTYxM1oXDTQwMTIzMTE2MDAwMFowdTErMCkGA1UEAxMiQnl0ZURhbmNlIFNt\nYXJ0IFRMUyBUYXJvIGZvciBhcm02NDEfMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0\nIERldmljZTESMBAGA1UEChMJQnl0ZURhbmNlMREwDwYDVQQFEwhmNWI4MDg4YjBZ\nMBMGByqGSM49AgEGCCqGSM49AwEHA0IABEaiu4E9I6tyqhWZ4za/G+IvObilcerv\nD5P02M0x1duvKGvpGfBj8j4KCQdrl5n6Tx9siYpY33N/InRWlFo7tbijgYQwgYEw\nDAYDVR0TAQH/BAIwADAfBgNVHSMEGDAWgBS7vHbFSVyNYUHY/MW9OSA1D0bVsTBD\nBggrBgEFBQcBAQQ3MDUwMwYIKwYBBQUHMAGGJ2h0dHA6Ly9uZXh1cy1ib2UuYnl0\nZWRhbmNlLm5ldC9wY2Evb2NzcDALBgNVHQ8EBAMCB4AwCgYIKoZIzj0EAwIDSAAw\nRQIgSNQeN+L2fYhK0rnB9cHjPXBwfroxhz+M+1f3Iq9ntI4CIQCvGwj3iz9oWbzM\naPkaUKgnFR3ZbLh1gG4m3pMJ7XfTBQ==\n-----END CERTIFICATE-----";
    private static final String TAG = "ObricCertificateStoreManager";
    private static final String TLS_PRI_KEY_ALG = "EC";
    private static final String TLS_PRI_KEY_DER_TEST = "308187020100301306072a8648ce3d020106082a8648ce3d030107046d306b0201010420a9aa747b2fb77c5ef7cf27e076733c7c5862c60fe4ba27659a22f7fc16ee6418a1440342000446a2bb813d23ab72aa1599e336bf1be22f39b8a571eaef0f93f4d8cd31d5dbaf286be919f063f23e0a09076b9799fa4f1f6c898a58df737f227456945a3bb5b8";
    private static final String TLS_PRI_KEY_FORMAT = "PKCS#8";
    public static final String TLS_PRO_CERT = "SYSTEM_Device_TLS_cert";
    public static final String TLS_PRO_PKEY = "SYSTEM_Device_TLS_pkey";
    public static final String TLS_TEST_CERT = "SYSTEM_Device_TLS_cert_test";
    public static final String TLS_TEST_PKEY = "SYSTEM_Device_TLS_pkey_test";
    private final Map<String, String> mCertToPrivateAlias;
    private Pair<Integer, List<X509Certificate>> mTrustChain;
    private final Set<String> mValidCertAlias;
    private final Set<String> mValidPriKeyAlias;

    private static class SingleTonHolder {
        private static final ObricCertificateStoreManager INSTANCE = null;

        /* JADX INFO: renamed from: -$$Nest$sfgetINSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ ObricCertificateStoreManager m71$$Nest$sfgetINSTANCE() {
            return INSTANCE;
        }

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new ObricCertificateStoreManager(null);
        }
    }

    /* synthetic */ ObricCertificateStoreManager(ObricCertificateStoreManagerIA r1) {
        this();
    }

    static {
        CERT_LOCK = new Object();
    }

    private ObricCertificateStoreManager() {
        this.mTrustChain = null;
        this.mCertToPrivateAlias = new HashMap();
        this.mValidPriKeyAlias = new HashSet();
        this.mValidCertAlias = new HashSet();
        this.mCertToPrivateAlias.put("SYSTEM_Device_TLS_cert_test", "SYSTEM_Device_TLS_pkey_test");
        this.mCertToPrivateAlias.put("SYSTEM_Device_TLS_cert", "SYSTEM_Device_TLS_pkey");
        this.mValidCertAlias.add("SYSTEM_Device_TLS_cert_test");
        this.mValidCertAlias.add("SYSTEM_Device_TLS_cert");
        this.mValidPriKeyAlias.add("SYSTEM_Device_TLS_pkey_test");
        this.mValidPriKeyAlias.add("SYSTEM_Device_TLS_pkey");
    }

    public static ObricCertificateStoreManager getInstance() {
        return SingleTonHolder.m71$$Nest$sfgetINSTANCE();
    }

    public void verifyRootCertificate(X509Certificate certificate, int type) throws CertificateException {
        if (certificate == null) goto L29;
        Log.i(TAG, "cert issuer: " + certificate.getIssuerDN() + " type: " + type);
        monitor-enter(CERT_LOCK);
        List<X509Certificate> trustChain = loadCertChain(type);     // Catch: Throwable -> L25
        if (trustChain == null) goto L24;
        if (trustChain.isEmpty() == true) goto L24;
        Iterator<X509Certificate> r2 = trustChain.iterator();     // Catch: Throwable -> L25
    L11:
        if (r2.hasNext() == false) goto L22;
        X509Certificate trustCert = r2.next();     // Catch: Throwable -> L25
        if (certificate.getIssuerDN().equals(trustCert.getSubjectDN()) == false) goto L11;
        Log.i(TAG, "root cert: " + trustCert.getSubjectDN());     // Catch: Throwable -> L25
        certificate.verify(trustCert.getPublicKey(), "AndroidOpenSSL");     // Catch: Throwable -> L17 Throwable -> L25
        Log.i(TAG, "cert verify success.");     // Catch: Throwable -> L17 Throwable -> L25
    L17:
        e = move-exception;
        throw new CertificateException("cert verify failed, " + e.getMessage());     // Catch: Throwable -> L25
    L22:
        throw new CertificateException("cert verify failed, have not match root");     // Catch: Throwable -> L25
    L24:
        throw new CertificateException("cert verify failed, trust chain is null, type is error.");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L29:
        throw new CertificateException("cert verify failed, cert is null.");
    }

    List<X509Certificate> exportCertChina(String alias) {
        Log.d(TAG, "exportCertChina alias: " + alias);
        if (this.mValidCertAlias.contains(alias) == true) goto L5;
        return null;
    L5:
        TLSManager tlsManager = TLSManager.getInstance();
        if (tlsManager != null) goto L9;
        Log.d(TAG, "get TLSManager instace failed.");
        return null;
    L9:
        Context ctx = AppGlobals.getInitialApplication().getApplicationContext();
        if (tlsManager.contains(ctx, this.mCertToPrivateAlias.get(alias), new Bundle()) == 0) goto L20;
        Log.d(TAG, "exportCertChina, TEE have not cert");
        List<X509Certificate> chain = new ArrayList();     // Catch: CertificateException -> L17
        if ("SYSTEM_Device_TLS_cert".equals(alias) == false) goto L15;
        return null;
    L15:
        chain.add(loadCert(new ByteArrayInputStream(DEFAULT_TLS_TEST_CERT.getBytes())));     // Catch: CertificateException -> L17
        return chain;
    L17:
        e = move-exception;
        Log.e(TAG, "default cert load failed, " + e.getMessage());
        return null;
    L20:
        TLSCertChainResult certChainResult = tlsManager.exportCertificateChain(ctx, alias, new Bundle());
        return certChainResult.getCertChain();
    }

    PrivateKey loadPrivateKey(String alias) {
        Log.d(TAG, "loadPrivateKey alias: " + alias);
        if (this.mValidPriKeyAlias.contains(alias) == true) goto L6;
        return null;
    L6:
        TLSManager tlsManager = TLSManager.getInstance();
        if (tlsManager != null) goto L10;
        Log.d(TAG, "get TLSManager instace failed.");
        return createNullPrivateKey(alias);
    L10:
        Context ctx = AppGlobals.getInitialApplication().getApplicationContext();
        if (tlsManager.contains(ctx, alias, new Bundle()) == 0) goto L15;
        Log.i(TAG, "loadPrivateKey, TEE have not private key.");
        return loadDefaultTestKey(alias);
    L15:
        return createNullPrivateKey(alias);
    }

    private PrivateKey createNullPrivateKey(String alias) {
        if ("SYSTEM_Device_TLS_cert".equals(alias) == true) goto L5;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(hexStringToByteArray(TLS_PRI_KEY_DER_TEST));
    L6:
        ECPrivateKey finalKey = null;
        KeyFactory keyFactory = KeyFactory.getInstance(TLS_PRI_KEY_ALG);     // Catch: Throwable -> L9
        finalKey = (ECPrivateKey) keyFactory.generatePrivate(keySpec);     // Catch: Throwable -> L9
    L11:
        if (finalKey != null) goto L15;
        return null;
    L15:
        return new ObricKeyStoreEcPrivateKey(alias, 0, TLS_PRI_KEY_ALG, TLS_PRI_KEY_FORMAT, null, finalKey.getS(), finalKey.getParams());
    L9:
        e = move-exception;
        Log.e(TAG, "create private key failed, " + e.getMessage());
        goto L11
    L5:
        keySpec = null;
        goto L6
    }

    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        int i = 0;
    L3:
        if (i >= len) goto L5;
        data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        i = i + 2;
        goto L3
    L5:
        return data;
    }

    PrivateKey loadDefaultTestKey(String alias) {
        PKCS8EncodedKeySpec keySpec = null;
        if ("SYSTEM_Device_TLS_pkey".equals(alias) == true) goto L10;
        keySpec = new PKCS8EncodedKeySpec(hexStringToByteArray(TLS_PRI_KEY_DER_TEST));
    L10:
        KeyFactory keyFactory = KeyFactory.getInstance(TLS_PRI_KEY_ALG);     // Catch: Throwable -> L7
        return keyFactory.generatePrivate(keySpec);
    L7:
        e = move-exception;
        Log.e(TAG, "create private key failed, " + e.getMessage());
        return null;
    }

    long getDoSignAddress(String alias) {
        Log.d(TAG, "alias: " + alias);
        TLSManager tlsManager = TLSManager.getInstance();
        if (tlsManager != null) goto L7;
        Log.d(TAG, "get TLSManager instace failed.");
        return -1;
    L7:
        return tlsManager.callDoSignFunctionJNI(alias);
    }

    long getAlgorithmAddress() {
        TLSManager tlsManager = TLSManager.getInstance();
        if (tlsManager != null) goto L7;
        Log.d(TAG, "get TLSManager instace failed.");
        return -1;
    L7:
        return tlsManager.callAlgorithmPerferFunctionJNI();
    }

    boolean isContainsKey(String alias) {
        TLSManager tlsManager = TLSManager.getInstance();
        if (tlsManager != null) goto L6;
        Log.d(TAG, "get TLSManager instace failed.");
        return false;
    L6:
        Context ctx = AppGlobals.getInitialApplication().getApplicationContext();
        if (tlsManager.contains(ctx, alias, new Bundle()) != 0) goto L10;
        Log.d(TAG, "TEE have private key, " + alias);
        return true;
    L10:
        return false;
    }

    private List<X509Certificate> loadCertChain(int type) {
        Object r0 = CERT_LOCK;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrustChain != null) goto L7;
    L8:
        List<X509Certificate> chain = new ArrayList();     // Catch: Throwable -> L12
        this.mTrustChain = new Pair(Integer.valueOf(type), chain);     // Catch: Throwable -> L12
    L9:
        List<X509Certificate> r1 = (List) this.mTrustChain.second;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L7:
        if (((Integer) this.mTrustChain.first).intValue() == type) goto L9;
        goto L8
    }

    private static X509Certificate loadCert(InputStream stream) throws CertificateException {
        CertificateFactory factory = CertificateFactory.getInstance("X509", "AndroidOpenSSL");     // Catch: Throwable -> L4
        return (X509Certificate) factory.generateCertificate(stream);
    L4:
        e = move-exception;
        throw new CertificateException("cert load failed, " + e.getMessage());
    }
}
