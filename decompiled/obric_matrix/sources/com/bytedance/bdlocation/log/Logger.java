package com.bytedance.bdlocation.log;

import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    public static final String TAG = "BDLocation";
    private static final LogPrinter sLogPrinter = null;
    private static final Map<Class<?>, Printer> sPrinters = null;

    static {
        sPrinters = new ConcurrentHashMap();
        LogPrinter r0 = new LogPrinter();
        sLogPrinter = r0;
        r0.setEnable(BDLocationConfig.isDebug());
        addPrinter(r0);
    }

    public Logger() {
    }

    public static void addPrinter(Printer r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Map<Class<?>, Printer> r0 = sPrinters;
        if (r0.containsKey(r2.getClass()) == true) goto L8;
        r0.put(r2.getClass(), r2);
        return;
    }

    public static void d(String r1) {
        d("BDLocation", r1);
    }

    public static void d(String r1, String r2) {
        d(r1, r2, null);
    }

    public static void d(String r2, String r3, Throwable r4) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().d(r2, r3, r4);
        goto L4
    }

    public static void e(String r1) {
        e("BDLocation", r1);
    }

    public static void e(String r1, String r2) {
        e(r1, r2, null);
    }

    public static void e(String r2, String r3, Throwable r4) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().e(r2, r3, r4);
        goto L4
    }

    public static void e(String r1, Throwable r2) {
        e("BDLocation", r1, r2);
    }

    public static void i(String r1) {
        i("BDLocation", r1);
    }

    public static void i(String r1, String r2) {
        i(r1, r2, null);
    }

    public static void i(String r2, String r3, Throwable r4) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().i(r2, r3, r4);
        goto L4
    }

    public static void setEnabled(boolean r1) {
        sLogPrinter.setEnable(r1);
    }

    public static void v(String r1) {
        v("BDLocation", r1);
    }

    public static void v(String r1, String r2) {
        v(r1, r2, null);
    }

    public static void v(String r2, String r3, Throwable r4) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().v(r2, r3, r4);
        goto L4
    }

    public static void w(String r1) {
        w("BDLocation", r1);
    }

    public static void w(String r1, String r2) {
        w(r1, r2, null);
    }

    public static void w(String r2, String r3, Throwable r4) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().w(r2, r3, r4);
        goto L4
    }
}
