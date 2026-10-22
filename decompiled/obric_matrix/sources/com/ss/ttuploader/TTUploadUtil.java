package com.ss.ttuploader;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.common.utility.k;
import d.b.d.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadUtil {
    private static final int UPDATE_PEROID = 300000;
    private static volatile boolean mIsLibraryLoaded = false;
    private static final ReentrantLock mLock = null;
    private static volatile TTLibraryLoaderProxy mProxy;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;

    static {
        mLock = new ReentrantLock();
    }

    public TTUploadUtil() {
    }

    static /* synthetic */ String access$002(String r0) {
        mServerIP = r0;
        return r0;
    }

    static /* synthetic */ long access$102(long r0) {
        mServerIPTime = r0;
        return r0;
    }

    public static String getDNSServerIP() {
        updateDNSServerIP();
        return mServerIP;
    }

    public static synchronized boolean initInternal() {
        monitor-enter(TTUploadUtil.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (loadLibrary() == true) goto L9;
        Log.e("ttmn", String.format("proxy library load fail", new Object[0]));     // Catch: Throwable -> L21
        monitor-exit(TTUploadUtil.class);
        return false;
    L9:
        Log.d("ttmn", "use defaullt loadLibrary()");     // Catch: Throwable -> L21
        if (mProxy == null) goto L12;
        boolean r1 = true;
    L14:
        if (systemLoadInit(r1) == 1) goto L18;
        Log.e("ttmn", String.format("library has not been loaded", new Object[0]));     // Catch: Throwable -> L21
        monitor-exit(TTUploadUtil.class);
        return false;
    L18:
        Log.d("ttmn", "init()");     // Catch: Throwable -> L21
        monitor-exit(TTUploadUtil.class);
        return true;
    L12:
        r1 = false;
        goto L14
    }

    public static Map<String, String> jsonToHashMap(JSONObject r4) {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = String.valueOf(r1.next());
        r0.put(r2, r4.optString(r2));
        goto L4
    L6:
        return r0;
    }

    private static boolean loadLibrary() {
        boolean r1 = true;
        if (mProxy != null) goto L6;
        return true;
    L6:
        if (mProxy == null) goto L22;
        if (mIsLibraryLoaded == true) goto L22;
        boolean r0 = a.a();
        boolean r2 = mProxy.loadLibrary("ttopenssl");
        if (r0 == true) goto L14;
        if (r2 == true) goto L14;
        boolean r3 = false;
    L15:
        mProxy.loadLibrary("vcn");
        mProxy.loadLibrary("vcnverify");
        boolean r4 = mProxy.loadLibrary("ttvideouploader");
        if (r3 == false) goto L19;
        if (r4 == false) goto L19;
    L20:
        mIsLibraryLoaded = r1;
    L19:
        r1 = false;
    L14:
        r3 = true;
    L22:
        return mIsLibraryLoaded;
    }

    private static boolean loadVcn() {
        if (d.i.b.a.a.a() == true) goto L6;
        Log.e("ttmn", "Can't load vcn");
    L6:
        if (d.i.b.a.a.b() == true) goto L10;
        Log.e("ttmn", "Can't load vcn verify");
        return true;
    L10:
        return true;
    }

    public static JSONObject mapToJSON(Map<String, Object> r6) {
        if (r6 != null) goto L17;
        return null;
    L17:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L14
        Iterator<String> r2 = r6.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r2.hasNext() == false) goto L13;
        String r3 = r2.next();     // Catch: Exception -> L14
        Object r4 = r6.get(r3);     // Catch: Exception -> L14
        if (k.c(r3) == true) goto L7;
        r1.put(r3, r4);     // Catch: Exception -> L14
        goto L7
    L13:
        return r1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String mapToString(Map<String, Object> r6) {
        if (r6 != null) goto L15;
        return null;
    L15:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L14
        Iterator<String> r2 = r6.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();     // Catch: Exception -> L14
        Object r4 = r6.get(r3);     // Catch: Exception -> L14
        if (k.c(r3) == true) goto L7;
        r1.put(r3, r4);     // Catch: Exception -> L14
        goto L7
    L12:
        return r1.toString();
    L14:
        return null;
    }

    public static void setLoadProxy(TTLibraryLoaderProxy r1) {
        ReentrantLock r0 = mLock;
        r0.lock();
        if (r1 != null) goto L11;
    L9:
        r0.unlock();
        return;
    L11:
        mProxy = r1;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        mLock.unlock();
        throw th;
    }

    private static int systemLoadInit(boolean r4) {
        if (mIsLibraryLoaded == false) goto L5;
        return 1;
    L5:
        mIsLibraryLoaded = r4;
        if (mIsLibraryLoaded == true) goto L31;
        if (a.a() == true) goto L11;
        Log.e("ttmn", "load boringssl fail!");
    L11:
        if (d.i.b.a.a.a() == true) goto L14;
        Log.e("ttmn", "Can't load vcn");
    L14:
        if (d.i.b.a.a.b() == true) goto L37;
        Log.e("ttmn", "Can't load vcn verify");
    L37:
        Log.e("ttmn", "load openssl");     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
        System.loadLibrary("ttopenssl");     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
    L35:
        System.loadLibrary("ttvideouploader");     // Catch: Throwable -> L25 UnsatisfiedLinkError -> L27
        mIsLibraryLoaded = true;     // Catch: Throwable -> L25 UnsatisfiedLinkError -> L27
    L27:
        e = e;
        StringBuilder r2 = new StringBuilder();
        String r3 = "Can't load avmdl library: ";
    L29:
        r2.append(r3);
        r2.append(e);
        Log.e("ttmn", r2.toString());
    L25:
        e = th;
        r2 = new StringBuilder();
        r3 = "other exception when loading avmdl library: ";
        goto L29
    L20:
        e = e;
        StringBuilder r5 = new StringBuilder();
        String r6 = "Can't load openssl library: ";
    L22:
        r5.append(r6);
        r5.append(e);
        Log.e("ttmn", r5.toString());
    L18:
        e = th;
        r5 = new StringBuilder();
        r6 = "other exception when loading openssl library: ";
    L31:
        if (mIsLibraryLoaded == true) goto L34;
        return -1;
    L34:
        return 1;
    }

    public static synchronized void updateDNSServerIP() {
        monitor-enter(TTUploadUtil.class);
    L12:
        th = move-exception;
        throw th;
    L6:
        if ((SystemClock.elapsedRealtime() - mServerIPTime) >= 300000) goto L9;
        monitor-exit(TTUploadUtil.class);
        return;
    L9:
        new Thread(new AnonymousClass1()).start();     // Catch: Throwable -> L12
        monitor-exit(TTUploadUtil.class);
    }
}
