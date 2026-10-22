package com.obric.security.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.List;
import system.bytedance.hardware.keymanager.CloudSyncKeyParams;
import system.bytedance.hardware.keymanager.CloudSyncKeyParamsLegacy;
import system.bytedance.hardware.keymanager.IKeyManagerService;
import vendor.bytedance.hardware.keymanager.AttestationResult;
import vendor.bytedance.hardware.keymanager.KeyAgreementResult;
import vendor.bytedance.hardware.keymanager.KeyParameter;
import vendor.bytedance.hardware.keymanager.SignResult;
import vendor.bytedance.hardware.keymanager.UDIDResult;
import vendor.bytedance.hardware.keymanager.XcryptResult;

/* JADX INFO: loaded from: classes.dex */
public class KeyManager {
    private static List<String> AGREE_KEY_REQUIRED_FILEDS = null;
    private static List<String> GEN_KEY_REQUIRED_FILEDS = null;
    private static final String KEY_SERVICE_NAME = "system.bytedance.hardware.keymanager.IKeyManagerService/default";
    private static final String TAG = null;
    private static volatile KeyManager mKeyManager;
    private IKeyManagerService mBinder;

    static {
        TAG = KeyManager.class.getSimpleName();
        GEN_KEY_REQUIRED_FILEDS = List.of(KeyManagerConst.KEY_ALGO, KeyManagerConst.KEY_LEN, KeyManagerConst.KEY_PURPOSE);
        AGREE_KEY_REQUIRED_FILEDS = List.of(KeyManagerConst.KEY_ALGO, KeyManagerConst.KEY_LEN);
    }

    private KeyManager() {
    }

    public static KeyManager getInstance() {
        if (mKeyManager != null) goto L15;
        monitor-enter(KeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mKeyManager != null) goto L9;
        mKeyManager = new KeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(KeyManager.class);     // Catch: Throwable -> L11
    L15:
        return mKeyManager;
    }

    private synchronized IKeyManagerService getService() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mBinder != null) goto L6;
        Log.e(TAG, "KEY_SERVICE_NAME system.bytedance.hardware.keymanager.IKeyManagerService/default");     // Catch: Throwable -> L9
        this.mBinder = IKeyManagerService.Stub.asInterface(ServiceManager.getService(KEY_SERVICE_NAME));     // Catch: Throwable -> L9
    L6:
        IKeyManagerService r0 = this.mBinder;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> KeyManagerResult buildKeyManagerResult(T r5) {
        if (r5 != 0) goto L7;
        Log.e(TAG, "binderResult is null, cannot build KeyManagerResult");
        return null;
    L7:
        if ((r5 instanceof AttestationResult) == false) goto L11;
        AttestationResult attestationResult = (AttestationResult) r5;
        return new KeyManagerResult(attestationResult.status, attestationResult.attestCertChain, true);
    L11:
        if ((r5 instanceof SignResult) == false) goto L15;
        SignResult signResult = (SignResult) r5;
        return new KeyManagerResult(signResult.status, signResult.signature);
    L15:
        if ((r5 instanceof XcryptResult) == false) goto L19;
        XcryptResult xcryptResult = (XcryptResult) r5;
        return new KeyManagerResult(xcryptResult.status, xcryptResult.outData);
    L19:
        if ((r5 instanceof KeyAgreementResult) == false) goto L22;
        KeyAgreementResult keyAgreementResult = (KeyAgreementResult) r5;
        return new KeyManagerResult(keyAgreementResult.status, keyAgreementResult.secret);
    L22:
        Log.e(TAG, "Unsupported binderResult type: " + r5.getClass().getName());
        return null;
    }

    public int importKeyLegacy(Context context, Bundle bundle) {
        Log.d(TAG, "KeyManager framework importKeyLegacy enter");
        if (context == null) goto L20;
        if (bundle == null) goto L20;
        CloudSyncKeyParamsLegacy params = KeyManagerParamsHandler.parseImportSyncKeyParameterLegacy(bundle);
        if (params != null) goto L11;
        Log.e(TAG, "parse cloud Sync Key Parameter error!!");
        return -1002;
    L11:
        if (getService() != null) goto L22;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L22:
        int result = this.mBinder.importSyncKeyLegacy(params);     // Catch: RemoteException -> L17
        return result;
    L17:
        ex = move-exception;
        Log.e(TAG, "importKeyLegacy binder failed, error:" + ex.getMessage());
        return -1000;
    L20:
        Log.e(TAG, "Input param error!!");
        return -1002;
    }

    public int importKey(Context context, Bundle bundle) {
        Log.e(TAG, "KeyManager framework importKey enter");
        if (context == null) goto L20;
        if (bundle == null) goto L20;
        CloudSyncKeyParams params = KeyManagerParamsHandler.parseImportSyncKeyParameter(bundle);
        if (params != null) goto L11;
        Log.e(TAG, "parse cloud Sync Key Parameter error!!");
        return -1002;
    L11:
        if (getService() != null) goto L22;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L22:
        int result = this.mBinder.importSyncKey(params);     // Catch: RemoteException -> L17
        return result;
    L17:
        ex = move-exception;
        Log.e(TAG, "importKey binder failed, error:" + ex.getMessage());
        return -1000;
    L20:
        Log.e(TAG, "Input param error!!");
        return -1002;
    }

    public KeyManagerResult xcrypt(Context context, int mode, byte[] inData, Bundle bundle) {
        Log.e(TAG, "KeyManager framework xcrypt enter");
        if (context == null) goto L24;
        if (bundle == null) goto L24;
        String alias = bundle.getString(KeyManagerConst.KEY_ALIAS, null);
        String additionalData = bundle.getString("aad", null);
        if (KeyManagerParamsHandler.isNullOrEmpty(alias) == false) goto L9;
    L22:
        Log.e(TAG, "Input alias or additionalData invalid!!");
        return new KeyManagerResult(-1002, null);
    L9:
        if (KeyManagerParamsHandler.isNullOrEmpty(additionalData) == true) goto L22;
        if (getService() != null) goto L15;
        Log.e(TAG, "Service not ready!!");
        return new KeyManagerResult(-1003, null);
    L15:
        XcryptResult result = null;
        result = this.mBinder.cloudSyncXcrypt(mode, alias, inData, additionalData);     // Catch: RemoteException -> L18
    L21:
        return buildKeyManagerResult(result);
    L18:
        ex = move-exception;
        Log.e(TAG, "xcrypt binder failed, error:" + ex.getMessage());
    L24:
        Log.e(TAG, "Input param error!!");
        return new KeyManagerResult(-1002, null);
    }

    public int deleteSyncKey(Context context, String keyAlias) {
        Log.e(TAG, "KeyManager framework deleteSyncKey enter");
        if (context == null) goto L16;
        if (keyAlias == null) goto L16;
        if (getService() != null) goto L18;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L18:
        int result = this.mBinder.deleteSyncKey(keyAlias);     // Catch: RemoteException -> L13
        return result;
    L13:
        ex = move-exception;
        Log.e(TAG, "deleteSyncKey binder failed, error:" + ex.getMessage());
        return -1000;
    L16:
        Log.e(TAG, "Input param error!!");
        return -1002;
    }

    public int generateKeyPair(Context context, String keyAlias, Bundle bundle) {
        if (context != null) goto L5;
    L26:
        Log.e(TAG, "Input param error!!");
        return -1002;
    L5:
        if (KeyManagerParamsHandler.isValidKeyAlias(keyAlias) == false) goto L26;
        if (bundle == null) goto L26;
        if (KeyManagerParamsHandler.checkBundleForRequiredFields(GEN_KEY_REQUIRED_FILEDS, bundle) == true) goto L12;
        Log.e(TAG, "Input bundle error!!");
        return -1002;
    L12:
        KeyParameter[] params = KeyManagerParamsHandler.parseKeyParameter(bundle);
        if (params != null) goto L17;
        Log.e(TAG, "parse Key Parameter error!!");
        return -1002;
    L17:
        if (getService() != null) goto L28;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L28:
        int result = this.mBinder.generateKeyPair(keyAlias, params);     // Catch: RemoteException -> L23
        return result;
    L23:
        ex = move-exception;
        Log.e(TAG, "generateKeyPair binder failed, error:" + ex.getMessage());
        return -1000;
    }

    public KeyManagerResult keyAttestation(Context context, String keyAlias, Bundle bundle) {
        if (context != null) goto L5;
    L27:
        Log.e(TAG, "Input param error!!");
        return new KeyManagerResult(-1002, null);
    L5:
        if (KeyManagerParamsHandler.isValidKeyAlias(keyAlias) == false) goto L27;
        if (bundle == null) goto L27;
        String challenge = bundle.getString("challenge", null);
        if (KeyManagerParamsHandler.isValidChallenge(challenge) == true) goto L12;
        Log.e(TAG, "Invalid challenge or missing CHALLENGE field!");
        return new KeyManagerResult(-1002, null);
    L12:
        KeyParameter[] params = KeyManagerParamsHandler.parseKeyParameter(bundle);
        if (params != null) goto L17;
        Log.e(TAG, "parse Key Parameter error!!");
        return new KeyManagerResult(-1002, null);
    L17:
        if (getService() != null) goto L20;
        Log.e(TAG, "Service not ready!!");
        return new KeyManagerResult(-1003, null);
    L20:
        AttestationResult attestationResult = null;
        attestationResult = this.mBinder.keyAttestation(keyAlias, challenge, params);     // Catch: RemoteException -> L23
    L26:
        return buildKeyManagerResult(attestationResult);
    L23:
        ex = move-exception;
        Log.e(TAG, "keyAttestation binder failed, error:" + ex.getMessage());
        goto L26
    }

    public KeyManagerResult getCertificateChain(Context context, String keyAlias, Bundle bundle) {
        if (context != null) goto L5;
    L19:
        Log.e(TAG, "Input param error!!");
        return new KeyManagerResult(-1002, null);
    L5:
        if (KeyManagerParamsHandler.isValidKeyAlias(keyAlias) == false) goto L19;
        if (bundle == null) goto L19;
        if (getService() != null) goto L12;
        Log.e(TAG, "Service not ready!!");
        return new KeyManagerResult(-1003, null);
    L12:
        AttestationResult certChainResult = null;
        certChainResult = this.mBinder.getCertificateChain(keyAlias);     // Catch: RemoteException -> L15
    L18:
        return buildKeyManagerResult(certChainResult);
    L15:
        ex = move-exception;
        Log.e(TAG, "getCertificateChain binder failed, error:" + ex.getMessage());
        goto L18
    }

    public KeyManagerResult sign(Context context, String keyAlias, byte[] data, Bundle bundle) {
        if (context != null) goto L5;
    L23:
        Log.e(TAG, "Input param error!!");
        return new KeyManagerResult(-1002, null);
    L5:
        if (KeyManagerParamsHandler.isValidKeyAlias(keyAlias) == false) goto L23;
        if (bundle == null) goto L23;
        if (KeyManagerParamsHandler.isValidData(data) == true) goto L13;
        return new KeyManagerResult(KeyManagerErrorCode.KM_INVALID_INPUT_DATA_SIZE, null);
    L13:
        if (getService() != null) goto L16;
        Log.e(TAG, "Service not ready!!");
        return new KeyManagerResult(-1003, null);
    L16:
        SignResult signResult = null;
        signResult = this.mBinder.sign(keyAlias, data);     // Catch: RemoteException -> L19
    L22:
        return buildKeyManagerResult(signResult);
    L19:
        ex = move-exception;
        Log.e(TAG, "sign binder failed, error:" + ex.getMessage());
        goto L22
    }

    public int verify(Context context, String keyAlias, byte[] data, byte[] signature, Bundle bundle) {
        if (context != null) goto L4;
    L24:
        Log.e(TAG, "Input param error!!");
        return -1002;
    L4:
        if (KeyManagerParamsHandler.isValidKeyAlias(keyAlias) == false) goto L24;
        if (bundle == null) goto L24;
        if (KeyManagerParamsHandler.isValidData(data) == true) goto L10;
        return KeyManagerErrorCode.KM_INVALID_INPUT_DATA_SIZE;
    L10:
        if (KeyManagerParamsHandler.isValidSignature(signature) == true) goto L13;
        return KeyManagerErrorCode.KM_INVALID_INPUT_DATA_SIZE;
    L13:
        if (getService() != null) goto L26;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L26:
        int result = this.mBinder.verify(keyAlias, data, signature);     // Catch: RemoteException -> L19
        return result;
    L19:
        ex = move-exception;
        Log.e(TAG, "verify binder failed, error:" + ex.getMessage());
        return -1000;
    }

    public int deleteKey(Context context, String keyAlias, Bundle bundle) {
        if (context != null) goto L4;
    L17:
        Log.e(TAG, "Input param error!!");
        return -1002;
    L4:
        if (KeyManagerParamsHandler.isValidKeyAlias(keyAlias) == false) goto L17;
        if (bundle == null) goto L17;
        if (getService() != null) goto L19;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L19:
        int result = this.mBinder.deleteKey(keyAlias);     // Catch: RemoteException -> L14
        return result;
    L14:
        ex = move-exception;
        Log.e(TAG, "deleteKey binder failed, error:" + ex.getMessage());
        return -1000;
    }

    public int clearAppKeyData(String packageName, int uid, Bundle extra) {
        if (packageName != null) goto L5;
    L20:
        Log.e(TAG, "clearAppData input packageName is invalid!!");
        return -1002;
    L5:
        if (packageName.isEmpty() == true) goto L20;
        if (uid > 0) goto L11;
        Log.e(TAG, "clearAppData input uid is invalid!!");
        return -1002;
    L11:
        if (getService() != null) goto L22;
        Log.e(TAG, "Service not ready!!");
        return -1003;
    L22:
        int result = this.mBinder.clearAppKeyData(packageName, uid);     // Catch: RemoteException -> L17
        return result;
    L17:
        ex = move-exception;
        Log.e(TAG, "clearAppData binder failed, error:" + ex.getMessage());
        return -1000;
    }

    public KeyManagerResult keyAgreement(Context context, String keyAlias, byte[] publicKey, Bundle bundle) {
        if (context != null) goto L5;
    L30:
        Log.e(TAG, "Input param error!!");
        return new KeyManagerResult(-1002, null);
    L5:
        if (KeyManagerParamsHandler.isValidKeyAlias(keyAlias) == false) goto L30;
        if (publicKey == null) goto L30;
        if (publicKey.length == 0) goto L30;
        if (bundle == null) goto L30;
        if (KeyManagerParamsHandler.checkBundleForRequiredFields(AGREE_KEY_REQUIRED_FILEDS, bundle) == true) goto L15;
        Log.e(TAG, "Input bundle error!!");
        return new KeyManagerResult(-1002, null);
    L15:
        KeyParameter[] params = KeyManagerParamsHandler.parseKeyParameter(bundle);
        if (params != null) goto L20;
        Log.e(TAG, "parse Key Parameter error!!");
        return new KeyManagerResult(-1002, null);
    L20:
        if (getService() != null) goto L23;
        Log.e(TAG, "Service not ready!!");
        return new KeyManagerResult(-1003, null);
    L23:
        KeyAgreementResult keyAgreementResult = null;
        keyAgreementResult = this.mBinder.keyAgreement(keyAlias, publicKey, params);     // Catch: RemoteException -> L26
    L29:
        return buildKeyManagerResult(keyAgreementResult);
    L26:
        ex = move-exception;
        Log.e(TAG, "keyAgreement binder failed, error:" + ex.getMessage());
        goto L29
    }

    public UDIDManagerResult getUDID(Context context, Bundle bundle) {
        if (context == null) goto L24;
        if (bundle == null) goto L24;
        if (getService() != null) goto L10;
        Log.e(TAG, "Service not ready!!");
        return new UDIDManagerResult(-1003, null);
    L10:
        UDIDResult udidResult = null;
        udidResult = this.mBinder.getUDID();     // Catch: RemoteException -> L13
    L15:
        String udidString = null;
        int status = -1000;
        if (udidResult == null) goto L23;
        status = udidResult.status;
        if (status != 0) goto L23;
        if (udidResult.udid == null) goto L23;
        udidString = new String(udidResult.udid, StandardCharsets.UTF_8);
    L23:
        return new UDIDManagerResult(status, udidString);
    L13:
        ex = move-exception;
        Log.e(TAG, "getUDID binder failed, error:" + ex.getMessage());
    L24:
        Log.e(TAG, "Input param error!!");
        return new UDIDManagerResult(-1002, null);
    }
}
