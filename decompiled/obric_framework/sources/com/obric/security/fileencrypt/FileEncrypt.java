package com.obric.security.fileencrypt;

import android.app.clickviewtree.ClickViewTreeConstants;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.storage.IStorageManager;
import android.util.Log;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class FileEncrypt {
    private static final String TAG = null;
    public static int aiKernelId;
    public static int audioServiceId;
    public static int gallerymedia;
    private static volatile FileEncrypt mFileEncrypt;
    public static int maxServiceId;
    public static int memorydataServiceId;
    private IStorageManager mStorageManager;
    private String prefixDir;
    private String[] serviceDirs;

    static {
        TAG = FileEncrypt.class.getSimpleName();
        aiKernelId = 0;
        audioServiceId = 1;
        memorydataServiceId = 2;
        gallerymedia = 3;
        maxServiceId = 6;
    }

    private FileEncrypt() {
        this.serviceDirs = new String[]{"aikernel/", "audio_service/", "memorydata/", "gallerymedia/", "/", "/", "keymanagertest/"};
        this.prefixDir = "/data/fbe/";
    }

    public static FileEncrypt getInstance() {
        if (mFileEncrypt != null) goto L15;
        monitor-enter(FileEncrypt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mFileEncrypt != null) goto L9;
        mFileEncrypt = new FileEncrypt();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FileEncrypt.class);     // Catch: Throwable -> L11
    L15:
        return mFileEncrypt;
    }

    public void serviceKeyInit(int serviceId, byte[] secret) {
        if (serviceId >= aiKernelId) goto L5;
    L22:
        Log.e(TAG, "serviceId is err");
        return;
    L5:
        if (serviceId > maxServiceId) goto L22;
        if (secret != null) goto L9;
    L20:
        Log.e(TAG, "secret is err");
        return;
    L9:
        if (secret.length == 0) goto L20;
        this.mStorageManager = getStorageManager();
        if (this.mStorageManager != null) goto L24;
        Log.e(TAG, "get storage manager failed");
        return;
    L24:
        this.mStorageManager.serviceKeyInit(serviceId, UserHandle.myUserId(), secret);     // Catch: RemoteException -> L17
        return;
    L17:
        ex = move-exception;
        Log.e(TAG, "get device secure state binder failed, exceptionMsg:" + ex.getMessage());
    }

    public void serviceKeyInitWithId(int serviceId, byte[] secret, int UserId) {
        if (serviceId >= aiKernelId) goto L5;
    L22:
        Log.e(TAG, "serviceId is err");
        return;
    L5:
        if (serviceId > maxServiceId) goto L22;
        if (secret != null) goto L9;
    L20:
        Log.e(TAG, "secret is err");
        return;
    L9:
        if (secret.length == 0) goto L20;
        this.mStorageManager = getStorageManager();
        if (this.mStorageManager != null) goto L24;
        Log.e(TAG, "get storage manager failed");
        return;
    L24:
        this.mStorageManager.serviceKeyInit(serviceId, UserId, secret);     // Catch: RemoteException -> L17
        return;
    L17:
        ex = move-exception;
        Log.e(TAG, "get device secure state binder failed, exceptionMsg:" + ex.getMessage());
    }

    public void serviceUnlockStorage(int serviceId, byte[] secret) {
        if (serviceId >= aiKernelId) goto L5;
    L22:
        Log.e(TAG, "serviceId is err");
        return;
    L5:
        if (serviceId > maxServiceId) goto L22;
        if (secret != null) goto L9;
    L20:
        Log.e(TAG, "secret is err");
        return;
    L9:
        if (secret.length == 0) goto L20;
        this.mStorageManager = getStorageManager();
        if (this.mStorageManager != null) goto L24;
        Log.e(TAG, "get storage manager failed");
        return;
    L24:
        this.mStorageManager.serviceUnlockStorage(serviceId, UserHandle.myUserId(), secret);     // Catch: RemoteException -> L17
        return;
    L17:
        ex = move-exception;
        Log.e(TAG, "get device secure state binder failed, exceptionMsg:" + ex.getMessage());
    }

    public void serviceLockStorage(int serviceId) {
        if (serviceId >= aiKernelId) goto L5;
    L16:
        Log.e(TAG, "serviceId is err");
        return;
    L5:
        if (serviceId > maxServiceId) goto L16;
        this.mStorageManager = getStorageManager();
        if (this.mStorageManager != null) goto L18;
        Log.e(TAG, "get storage manager failed");
        return;
    L18:
        this.mStorageManager.serviceLockStorage(serviceId, UserHandle.myUserId());     // Catch: RemoteException -> L13
        return;
    L13:
        ex = move-exception;
        Log.e(TAG, "get device secure state binder failed, exceptionMsg:" + ex.getMessage());
    }

    public void serviceKeyDelete(int serviceId) {
        if (serviceId >= aiKernelId) goto L5;
    L16:
        Log.e(TAG, "serviceId is err");
        return;
    L5:
        if (serviceId > maxServiceId) goto L16;
        this.mStorageManager = getStorageManager();
        if (this.mStorageManager != null) goto L18;
        Log.e(TAG, "get storage manager failed");
        return;
    L18:
        this.mStorageManager.serviceKeyDelete(serviceId, UserHandle.myUserId());     // Catch: RemoteException -> L13
        return;
    L13:
        ex = move-exception;
        Log.e(TAG, "get device secure state binder failed, exceptionMsg:" + ex.getMessage());
    }

    public void serviceKeyDeleteWithId(int serviceId, int UserId) {
        if (serviceId >= aiKernelId) goto L5;
    L16:
        Log.e(TAG, "serviceId is err");
        return;
    L5:
        if (serviceId > maxServiceId) goto L16;
        this.mStorageManager = getStorageManager();
        if (this.mStorageManager != null) goto L18;
        Log.e(TAG, "get storage manager failed");
        return;
    L18:
        this.mStorageManager.serviceKeyDelete(serviceId, UserId);     // Catch: RemoteException -> L13
        return;
    L13:
        ex = move-exception;
        Log.e(TAG, "get device secure state binder failed, exceptionMsg:" + ex.getMessage());
    }

    public String getStorageDir(int serviceId) {
        if (serviceId >= aiKernelId) goto L5;
    L15:
        String serviceDir = TAG;
        Log.e(serviceDir, "serviceId is err");
        return null;
    L5:
        if (serviceId > maxServiceId) goto L15;
        String serviceDir2 = "";
        int i = 0;
    L9:
        if (i >= this.serviceDirs.length) goto L13;
        if (serviceId != i) goto L12;
        serviceDir2 = this.serviceDirs[i];
    L12:
        i = i + 1;
        goto L9
    L13:
        int i2 = UserHandle.myUserId();
        String userId = Integer.toString(i2);
        return this.prefixDir + serviceDir2 + userId;
    }

    public String getStorageDirWithId(int serviceId, int UserId) {
        if (serviceId >= aiKernelId) goto L5;
    L15:
        String serviceDir = TAG;
        Log.e(serviceDir, "serviceId is err");
        return null;
    L5:
        if (serviceId > maxServiceId) goto L15;
        String serviceDir2 = "";
        int i = 0;
    L9:
        if (i >= this.serviceDirs.length) goto L13;
        if (serviceId != i) goto L12;
        serviceDir2 = this.serviceDirs[i];
    L12:
        i = i + 1;
        goto L9
    L13:
        String userId = Integer.toString(UserId);
        return this.prefixDir + serviceDir2 + userId;
    }

    public IStorageManager getStorageManager() {
        IBinder service = ServiceManager.getService("mount");
        if (service != null) goto L5;
        return null;
    L5:
        return IStorageManager.Stub.asInterface(service);
    }

    public byte[] genSecret(String password, byte[] salt) throws Exception {
        if (password == null) goto L13;
        if (password.isEmpty() == true) goto L13;
        if (salt == null) goto L11;
        if (salt.length == 0) goto L11;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ClickViewTreeConstants.MAX_VIEW_NODE_COUNT, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] derivedKey = factory.generateSecret(spec).getEncoded();
        return derivedKey;
    L11:
        throw new IllegalArgumentException("Salt cannot be null or empty");
    L13:
        throw new IllegalArgumentException("Password cannot be null or empty");
    }
}
