package com.obric.security.keymanager;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import system.bytedance.hardware.keymanager.IKeyManagerService;

/* JADX INFO: loaded from: classes.dex */
public class KeyManagerUtils {
    private static final String KEY_SERVICE_NAME = "system.bytedance.hardware.keymanager.IKeyManagerService/default";
    public static final String TAG = null;
    private static final IBinder.DeathRecipient deathRecipient = null;
    private static volatile IKeyManagerService keyserviceBinder;

    /* JADX INFO: renamed from: -$$Nest$sfgetdeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder.DeathRecipient m62$$Nest$sfgetdeathRecipient() {
        return deathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetkeyserviceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ IKeyManagerService m63$$Nest$sfgetkeyserviceBinder() {
        return keyserviceBinder;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputkeyserviceBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m64$$Nest$sfputkeyserviceBinder(IKeyManagerService r0) {
        keyserviceBinder = r0;
    }

    public KeyManagerUtils() {
    }

    static {
        TAG = KeyManager.class.getSimpleName();
        deathRecipient = new AnonymousClass1();
    }

    public static String getCurrentPkg(Context context) {
        int currentPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) goto L11;
        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = list.iterator();
    L6:
        if (r4.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo info = r4.next();
        if (info.pid != currentPid) goto L6;
        String processName = info.processName;
        return processName;
    L16:
        return "";
    L11:
        return "";
    }

    public static byte[] getSHA256(byte[] data) {
        if (data != null) goto L5;
    L12:
        Log.e(TAG, "Input data is null or empty");
        return new byte[0];
    L5:
        if (data.length == 0) goto L12;
        MessageDigest md = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L9
        return md.digest(data);
    L9:
        e = move-exception;
        Log.e(TAG, "SHA-256 algorithm not found, error: " + e.getMessage());
        return new byte[0];
    }

    public static byte[] getContextSignature(Context context) {
        if (context != null) goto L24;
        Log.e(TAG, "Context is null");
        return new byte[0];
    L24:
        PackageManager pm = context.getPackageManager();     // Catch: Exception -> L21
        if (pm != null) goto L10;
        Log.e(TAG, "PackageManager is null");     // Catch: Exception -> L21
        return new byte[0];
    L10:
        PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 64);     // Catch: Exception -> L21
        if (packageInfo != null) goto L13;
    L19:
        Log.e(TAG, "No signatures found");     // Catch: Exception -> L21
        return new byte[0];
    L13:
        if (packageInfo.signatures == null) goto L19;
        if (packageInfo.signatures.length == 0) goto L19;
        Signature signature = packageInfo.signatures[0];     // Catch: Exception -> L21
        return signature.toByteArray();
    L21:
        e = move-exception;
        Log.e(TAG, "Failed to get package signature, error: " + e.getMessage());
        return new byte[0];
    }

    public static byte[] getApkSignHash(Context context) {
        byte[] signature = getContextSignature(context);
        if (signature.length != 0) goto L7;
        Log.e(TAG, "Failed to get context signature");
        return new byte[0];
    L7:
        return getSHA256(signature);
    }

    public static JSONObject bundleToJson(Bundle bundle) {
        JSONObject json = new JSONObject();
        Set<String> keys = bundle.keySet();
        Iterator<String> r2 = keys.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        String key = r2.next();
    L10:
        e = move-exception;
        System.out.println(e.toString());
        goto L4
    L7:
        if (bundle.get(key) == null) goto L4;
        Object value = bundle.get(key);     // Catch: JSONException -> L10
        json.put(key, value);     // Catch: JSONException -> L10
        goto L4
    L13:
        return json;
    }

    public static byte[] hexStringToByte(String hexString) {
        if (hexString == null) goto L12;
        if (hexString.isEmpty() == true) goto L12;
        byte[] bytes = new byte[hexString.length() / 2];
        int i = 0;
    L8:
        if (i >= hexString.length()) goto L10;
        String subStr = hexString.substring(i, i + 2);
        bytes[i / 2] = (byte) Integer.parseInt(subStr, 16);
        i = i + 2;
        goto L8
    L10:
        return bytes;
    L12:
        return new byte[0];
    }

    public static IKeyManagerService getKeyService() {
        if (keyserviceBinder != null) goto L21;
        monitor-enter(KeyManagerUtils.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (keyserviceBinder != null) goto L10;
        keyserviceBinder = IKeyManagerService.Stub.asInterface(ServiceManager.getService(KEY_SERVICE_NAME));     // Catch: Throwable -> L17
    L10:
        if (keyserviceBinder != null) goto L22;
    L15:
        monitor-exit(KeyManagerUtils.class);     // Catch: Throwable -> L17
        goto L21
    L22:
        keyserviceBinder.asBinder().linkToDeath(deathRecipient, 0);     // Catch: RemoteException -> L13 Throwable -> L17
    L13:
        e = move-exception;
        Log.e(TAG, "Failed to link to death" + e.getMessage());     // Catch: Throwable -> L17
        keyserviceBinder = null;     // Catch: Throwable -> L17
    L21:
        return keyserviceBinder;
    }
}
