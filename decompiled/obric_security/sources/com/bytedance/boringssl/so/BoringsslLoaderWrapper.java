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

    public BoringsslLoaderWrapper() {
    }

    static {
        lock = new ReentrantLock();
    }

    public static void setDefaultBoringsslName(String r0) {
        DEFAULT_BORINGSSL_NAME = r0;
    }

    public static void setDefaultCryptoName(String r0) {
        DEFAULT_CRYPTO_NAME = r0;
    }

    public static void setBoringsslLoader(IBoringsslLoader r0) {
        iBoringsslLoader = r0;
    }

    public static boolean loadBoringssl() {
        lock.lock();     // Catch: Throwable -> L15 Error -> L17
        if (iBoringsslLoader == null) goto L9;
        boolean r0 = iBoringsslLoader.loadBoringssl();     // Catch: Throwable -> L15 Error -> L17
        lock.unlock();
        return r0;
    L9:
        if (hasLoadCrypto == true) goto L12;
        System.loadLibrary(DEFAULT_CRYPTO_NAME);     // Catch: Throwable -> L15 Error -> L17
        hasLoadCrypto = true;     // Catch: Throwable -> L15 Error -> L17
    L12:
        if (hasLoadBoringssl == true) goto L14;
        System.loadLibrary(DEFAULT_BORINGSSL_NAME);     // Catch: Throwable -> L15 Error -> L17
        hasLoadBoringssl = true;     // Catch: Throwable -> L15 Error -> L17
    L14:
        lock.unlock();
        if (hasLoadBoringssl == true) goto L23;
    L25:
        return false;
    L23:
        if (hasLoadCrypto == false) goto L25;
        return true;
    L15:
        th = move-exception;
        lock.unlock();
        throw th;
    L17:
        e = move-exception;
        Log.e(TAG, "load boringssl:" + hasLoadBoringssl + " load crypto:" + hasLoadCrypto + "  err:" + e.toString());     // Catch: Throwable -> L15
        goto L14
    }
}
