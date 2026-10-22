package com.obric.security.platformkey;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import system.bytedance.hardware.platformkey.IPlatformKeyService;
import vendor.bytedance.hardware.platformkey.PlatformKeyResult;
import vendor.bytedance.hardware.platformkey.PlatformKeyXcryptParams;

/* JADX INFO: loaded from: classes.dex */
public class PlatformKeyManager {
    private static final String KEY_SERVICE_NAME = "system.bytedance.hardware.platformkey.IPlatformKeyService/default";
    private static final String TAG = null;
    private static volatile PlatformKeyManager mPlatformKeyManager;
    private IPlatformKeyService mBinder;

    static {
        TAG = PlatformKeyManager.class.getSimpleName();
    }

    private PlatformKeyManager() {
    }

    private synchronized IPlatformKeyService getService() {
        monitor-enter(this);
        this.mBinder = IPlatformKeyService.Stub.asInterface(ServiceManager.getService(KEY_SERVICE_NAME));     // Catch: Throwable -> L6
        IPlatformKeyService r0 = this.mBinder;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private byte[] getContextSignSHA256(Context context) {
        byte[] sha256 = new byte[0];
        byte[] r2 = new byte[0];     // Catch: Exception -> L10 NoSuchAlgorithmException -> L12
        PackageManager pm = context.getPackageManager();     // Catch: Exception -> L10 NoSuchAlgorithmException -> L12
        if (pm != null) goto L7;
        Log.e(TAG, "Get PackageManager failed!!");     // Catch: Exception -> L10 NoSuchAlgorithmException -> L12
        return sha256;
    L7:
        PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 64);     // Catch: Exception -> L10 NoSuchAlgorithmException -> L12
        byte[] signature = packageInfo.signatures[0].toByteArray();     // Catch: Exception -> L10 NoSuchAlgorithmException -> L12
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L10 NoSuchAlgorithmException -> L12
        messageDigest.update(signature);     // Catch: Exception -> L10 NoSuchAlgorithmException -> L12
        return messageDigest.digest();
    L12:
        e = move-exception;
        Log.e(TAG, "Get message digest failed, error:" + e.getMessage());
        return sha256;
    L10:
        e = move-exception;
        Log.e(TAG, "Get signature failed, error:" + e.getMessage());
        return sha256;
    }

    private PlatformKeyXcryptParams constructXcryptParams(int mode, int platformVer, byte[] inData, byte[] bizPubKey, Bundle extra) {
        PlatformKeyXcryptParams params = new PlatformKeyXcryptParams();
        params.mode = mode;
        params.platformVer = platformVer;
        params.inData = inData;
        params.bizPubKey = bizPubKey;
        if (extra != null) goto L5;
    L7:
        return params;
    L5:
        if (extra.containsKey("aad") == false) goto L7;
        params.aad = extra.getByteArray("aad");
        goto L7
    }

    public static PlatformKeyManager getInstance() {
        if (mPlatformKeyManager != null) goto L15;
        monitor-enter(PlatformKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mPlatformKeyManager != null) goto L9;
        mPlatformKeyManager = new PlatformKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatformKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return mPlatformKeyManager;
    }

    public byte[] exportPubKey(Context context, Bundle extra) {
        if (context != null) goto L7;
        Log.e(TAG, "Invaild input params");
        return null;
    L7:
        if (getService() != null) goto L10;
        Log.e(TAG, "Service not ready");
        return null;
    L10:
        PlatformKeyResult result = null;
        result = this.mBinder.exportPlatformPubKey(getContextSignSHA256(context));     // Catch: RemoteException -> L13
    L15:
        if (result != null) goto L17;
        return null;
    L17:
        if (result.status == 0) goto L19;
        return null;
    L19:
        return result.output;
    L13:
        ex = move-exception;
        Log.e(TAG, "exportPubKey binder ipc failed, exceptionMsg:" + ex.getMessage());
        goto L15
    }

    public byte[] decrypt(Context context, int platform, byte[] cipher, byte[] bizPubKey, Bundle extra) {
        if (context == null) goto L28;
        if (cipher == null) goto L28;
        if (cipher.length == 0) goto L28;
        if (cipher.length > 4132) goto L28;
        if (bizPubKey == null) goto L28;
        if (bizPubKey.length != 65) goto L28;
        if (getService() != null) goto L17;
        Log.e(TAG, "Service not ready");
        return null;
    L17:
        PlatformKeyXcryptParams params = constructXcryptParams(1, platform, cipher, bizPubKey, extra);
        PlatformKeyResult result = null;
        result = this.mBinder.xcryptByPlatformKey(getContextSignSHA256(context), params);     // Catch: RemoteException -> L20
    L22:
        if (result != null) goto L24;
        return null;
    L24:
        if (result.status == 0) goto L26;
        return null;
    L26:
        return result.output;
    L20:
        ex = move-exception;
        Log.e(TAG, "decrypt binder ipc failed, exceptionMsg:" + ex.getMessage());
    L28:
        Log.e(TAG, "Invaild input params");
        return null;
    }

    public byte[] encrypt(Context context, int platform, byte[] data, byte[] bizPubKey, Bundle extra) {
        if (context == null) goto L28;
        if (data == null) goto L28;
        if (data.length == 0) goto L28;
        if (data.length > 4096) goto L28;
        if (bizPubKey == null) goto L28;
        if (bizPubKey.length != 65) goto L28;
        if (getService() != null) goto L17;
        Log.e(TAG, "Service not ready");
        return null;
    L17:
        PlatformKeyXcryptParams params = constructXcryptParams(0, platform, data, bizPubKey, extra);
        PlatformKeyResult result = null;
        result = this.mBinder.xcryptByPlatformKey(getContextSignSHA256(context), params);     // Catch: RemoteException -> L20
    L22:
        if (result != null) goto L24;
        return null;
    L24:
        if (result.status == 0) goto L26;
        return null;
    L26:
        return result.output;
    L20:
        ex = move-exception;
        Log.e(TAG, "encrypt binder ipc failed, exceptionMsg:" + ex.getMessage());
    L28:
        Log.e(TAG, "Invaild input params");
        return null;
    }
}
