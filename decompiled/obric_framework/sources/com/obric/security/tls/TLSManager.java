package com.obric.security.tls;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.obric.security.keymanager.KeyManagerParamsHandler;
import com.obric.security.keymanager.KeyManagerUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import system.bytedance.hardware.keymanager.IKeyManagerService;
import vendor.bytedance.hardware.keymanager.KeyParameter;
import vendor.bytedance.hardware.keymanager.SignResult;
import vendor.bytedance.hardware.keymanager.Tag;
import vendor.bytedance.hardware.keymanager.TlsCertChainResult;

/* JADX INFO: loaded from: classes.dex */
public class TLSManager {
    private static final Map<String, Integer> SUPPORTED_ALGORITHM_MAP = null;
    private static final String TAG = null;
    private static final String TLS_JNI_SO_NAME = "/system/lib64/libtlsjnihelper.so";
    private static volatile TLSManager mTLSManager;

    private native long AlgorithmPerferFunctionJNI();

    private native long DoSignFunctionJNI(String r1);

    static {
        TAG = TLSManager.class.getSimpleName();
        SUPPORTED_ALGORITHM_MAP = Map.of(TLSConst.NONEwithECDSA, 0, TLSConst.SHA1withECDSA, 2, TLSConst.SHA256withECDSA, 4, TLSConst.SHA384withECDSA, 5, TLSConst.SHA512withECDSA, 6);
        System.load(TLS_JNI_SO_NAME);     // Catch: Exception -> L5 SecurityException -> L7 UnsatisfiedLinkError -> L9
    L17:
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "SecurityException when loading so: " + e.getMessage());
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "other exception: " + e.getMessage());
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "Failed to load so: " + e.getMessage());
    }

    private TLSManager() {
    }

    public static TLSManager getInstance() {
        if (mTLSManager != null) goto L15;
        monitor-enter(TLSManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mTLSManager != null) goto L9;
        mTLSManager = new TLSManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TLSManager.class);     // Catch: Throwable -> L11
    L15:
        return mTLSManager;
    }

    private KeyParameter[] buildKeyParameters(String algorithm) {
        if (SUPPORTED_ALGORITHM_MAP.containsKey(algorithm) == true) goto L6;
        Log.e(TAG, "Unsupport algorithm: " + algorithm);
        return null;
    L6:
        List<KeyParameter> params = new ArrayList();
        params.add(KeyManagerParamsHandler.makeEnum(Tag.ALGORITHM, 2));
        params.add(KeyManagerParamsHandler.makeEnum(Tag.DIGEST, SUPPORTED_ALGORITHM_MAP.get(algorithm).intValue()));
        return (KeyParameter[]) params.toArray(new KeyParameter[params.size()]);
    }

    public TLSCertChainResult exportCertificateChain(Context context, String certAlias, Bundle extras) {
        if (context == null) goto L25;
        if (certAlias == null) goto L25;
        if (certAlias.isEmpty() == true) goto L25;
        if (certAlias.length() > 128) goto L25;
        if (extras == null) goto L25;
        IKeyManagerService keyserviceBinder = KeyManagerUtils.getKeyService();
        if (keyserviceBinder != null) goto L15;
        Log.e(TAG, "Service not ready!!");
        return new TLSCertChainResult(-1003, null);
    L15:
        TlsCertChainResult tlsCertChainResult = null;
        tlsCertChainResult = keyserviceBinder.exportTlsCertChain(certAlias);     // Catch: RemoteException -> L18
    L20:
        if (tlsCertChainResult != null) goto L24;
        return new TLSCertChainResult(-1004, null);
    L24:
        return new TLSCertChainResult(tlsCertChainResult.status, tlsCertChainResult.certChain);
    L18:
        ex = move-exception;
        Log.e(TAG, "exportTlsCertChain binder failed, error:" + ex.getMessage());
    L25:
        Log.e(TAG, "Invaild input params");
        return new TLSCertChainResult(-1002, null);
    }

    public TLSSignResult sign(Context context, String algorithm, byte[] data, String keyAlias, Bundle extras) {
        if (context == null) goto L37;
        if (algorithm == null) goto L37;
        if (algorithm.isEmpty() == true) goto L37;
        if (data == null) goto L37;
        if (data.length == 0) goto L37;
        if (data.length > 4096) goto L37;
        if (keyAlias == null) goto L37;
        if (keyAlias.isEmpty() == true) goto L37;
        if (keyAlias.length() > 128) goto L37;
        if (extras == null) goto L37;
        KeyParameter[] params = buildKeyParameters(algorithm);
        if (params == null) goto L22;
        IKeyManagerService keyserviceBinder = KeyManagerUtils.getKeyService();
        if (keyserviceBinder != null) goto L27;
        Log.e(TAG, "Service not ready!!");
        return new TLSSignResult(-1003, null);
    L27:
        SignResult signResult = null;
        signResult = keyserviceBinder.signTlsData(keyAlias, data, params);     // Catch: RemoteException -> L30
    L32:
        if (signResult != null) goto L36;
        return new TLSSignResult(-1004, null);
    L36:
        return new TLSSignResult(signResult.status, signResult.signature);
    L30:
        ex = move-exception;
        Log.e(TAG, "exportTlsCertChain binder failed, error:" + ex.getMessage());
        goto L32
    L22:
        return new TLSSignResult(-1005, null);
    L37:
        Log.e(TAG, "Invaild input params");
        return new TLSSignResult(-1002, null);
    }

    public int contains(Context context, String keyAlias, Bundle extras) {
        if (context == null) goto L20;
        if (keyAlias == null) goto L20;
        if (keyAlias.isEmpty() == true) goto L20;
        if (keyAlias.length() > 128) goto L20;
        if (extras == null) goto L20;
        IKeyManagerService keyserviceBinder = KeyManagerUtils.getKeyService();
        if (keyserviceBinder != null) goto L22;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L22:
        int ret = keyserviceBinder.containsTlsKey(keyAlias);     // Catch: RemoteException -> L17
        return ret;
    L17:
        ex = move-exception;
        Log.e(TAG, "containsTlsKey binder failed, error:" + ex.getMessage());
        return -1004;
    L20:
        Log.e(TAG, "Invaild input params");
        return -1002;
    }

    public long callDoSignFunctionJNI(String keyAlias) {
        return DoSignFunctionJNI(keyAlias);
    }

    public long callAlgorithmPerferFunctionJNI() {
        return AlgorithmPerferFunctionJNI();
    }
}
