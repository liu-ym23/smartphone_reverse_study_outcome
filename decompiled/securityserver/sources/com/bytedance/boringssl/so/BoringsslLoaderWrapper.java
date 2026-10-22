package com.bytedance.boringssl.so;

import android.util.Log;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class BoringsslLoaderWrapper {
    private static volatile String DEFAULT_BORINGSSL_NAME = "ttboringssl";
    private static volatile String DEFAULT_CRYPTO_NAME = "ttcrypto";
    private static final String TAG = "BoringsslLoaderWrapper";
    private static volatile boolean hasLoadBoringssl = false;
    private static volatile boolean hasLoadCrypto = false;
    private static volatile IBoringsslLoader iBoringsslLoader;
    private static Lock lock;

    static {
        lock = new ReentrantLock();
    }

    public BoringsslLoaderWrapper() {
    }

    public static boolean loadBoringssl() {
        lock.lock();     // Catch: Throwable -> L8 Error -> L10
        if (iBoringsslLoader == null) goto L13;
        boolean r0 = iBoringsslLoader.loadBoringssl();     // Catch: Throwable -> L8 Error -> L10
        lock.unlock();
        return r0;
    L13:
        if (hasLoadCrypto == true) goto L16;
        System.loadLibrary(DEFAULT_CRYPTO_NAME);     // Catch: Throwable -> L8 Error -> L10
        hasLoadCrypto = true;     // Catch: Throwable -> L8 Error -> L10
    L16:
        if (hasLoadBoringssl == true) goto L18;
        System.loadLibrary(DEFAULT_BORINGSSL_NAME);     // Catch: Throwable -> L8 Error -> L10
        hasLoadBoringssl = true;     // Catch: Throwable -> L8 Error -> L10
    L18:
        lock.unlock();
        if (hasLoadBoringssl == true) goto L24;
    L26:
        return false;
    L24:
        if (hasLoadCrypto == false) goto L26;
        return true;
    L10:
        e = move-exception;
        Log.e(TAG, "load boringssl:" + hasLoadBoringssl + " load crypto:" + hasLoadCrypto + "  err:" + e.toString());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        lock.unlock();
        throw th;
    }

    public static void setBoringsslLoader(IBoringsslLoader r0) {
        iBoringsslLoader = r0;
    }

    public static void setDefaultBoringsslName(String r0) {
        DEFAULT_BORINGSSL_NAME = r0;
    }

    public static void setDefaultCryptoName(String r0) {
        DEFAULT_CRYPTO_NAME = r0;
    }
}
