package tmsdk.common.roach.nest;

import android.content.Context;
import android.os.HandlerThread;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.ub;

/* JADX INFO: loaded from: classes5.dex */
public class PowerNest {
    public static final int CALLBACK_RUN_ON_NET_THREAD = 16;
    public static final int CALLBACK_RUN_ON_THREAD = 0;
    public static final int CALLBACK_RUN_ON_UI = 8;
    public static final int SHARK_HTTP = 512;
    public static final int SHARK_TCP = 1024;
    public static final int S_ERR_NONE = 0;
    public static final int sNestVersion = 201;

    public PowerNest() {
    }

    public static void addTask(Runnable r0, String r1) {
        ub.a(r0, r1);
    }

    public static int bsPatch(String r0, String r1, String r2, int r3) {
        return ub.a(r0, r1, r2, r3);
    }

    public static byte[] decrypt(byte[] r0, byte[] r1) {
        return ub.a(r0, r1);
    }

    public static int download(String r0, String r1, String r2) {
        return ub.a(r0, r1, r2);
    }

    public static byte[] encrypt(byte[] r0, byte[] r1) {
        return ub.b(r0, r1);
    }

    public static String fileMd5(String r0) {
        return ub.a(r0);
    }

    public static Context getAppContext() {
        return ub.a();
    }

    public static String getByteMd5(byte[] r0) {
        return ub.a(r0);
    }

    public static String getGuid() {
        return ub.b();
    }

    public static int getInt(String r0, int r1) {
        return ub.a(r0, r1);
    }

    public static long getLong(String r0, long r1) {
        return ub.a(r0, r1);
    }

    public static String getString(String r0, String r1) {
        return ub.a(r0, r1);
    }

    public static HandlerThread newFreeHandlerThread(String r0) {
        return ub.b(r0);
    }

    public static Thread newFreeThread(Runnable r0, String r1) {
        return ub.b(r0, r1);
    }

    public static void putInt(String r0, int r1) {
        ub.b(r0, r1);
    }

    public static void putLong(String r0, long r1) {
        ub.b(r0, r1);
    }

    public static void putString(String r0, String r1) {
        ub.b(r0, r1);
    }

    public static void remove(String r0) {
        ub.c(r0);
    }

    public static int runHttpSession(int r0, String r1, String r2, HashMap<String, Object> r3, String r4, Class<?> r5, AtomicReference<Object> r6) {
        return ub.a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static void saveActionData(int r0) {
        ub.a(r0);
    }

    public static void saveMultiValueData(int r0, int r1) {
        ub.a(r0, r1);
    }

    public static void saveStringData(int r0, String r1) {
        ub.a(r0, r1);
    }

    public static boolean sendShark(int r0, JceStruct r1, JceStruct r2, int r3, ISharkCallBackNest r4, long r5) {
        return ub.a(r0, r1, r2, r3, r4, r5);
    }

    public static void tryReportData() {
        ub.c();
    }
}
