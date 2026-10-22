package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import com.android.settings.pinyin.PinyinUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class VolleyLog {
    private static final String CLASS_NAME = null;
    public static boolean DEBUG = false;
    public static String TAG = "Volley";

    static class MarkerLog {
        public static final boolean ENABLED = false;
        private static final long MIN_DURATION_FOR_LOGGING_MS = 0;
        private boolean mFinished;
        private final List<Marker> mMarkers;

        private static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String r1, long r2, long r4) {
                this.name = r1;
                this.thread = r2;
                this.time = r4;
            }
        }

        MarkerLog() {
            this.mMarkers = new ArrayList();
            this.mFinished = false;
        }

        static {
            ENABLED = VolleyLog.DEBUG;
        }

        public synchronized void add(String r9, long r10) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mFinished == true) goto L9;
            this.mMarkers.add(new Marker(r9, r10, SystemClock.elapsedRealtime()));     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L9:
            throw new IllegalStateException("Marker added to finished log");     // Catch: Throwable -> L10
        }

        public synchronized void finish(String r11) {
            monitor-enter(this);
            this.mFinished = true;     // Catch: Throwable -> L16
            long r1 = getTotalDuration();     // Catch: Throwable -> L16
            if (r1 > 0) goto L9;
            monitor-exit(this);
            return;
        L9:
            long r5 = this.mMarkers.get(0).time;     // Catch: Throwable -> L16
            VolleyLog.d("(%-4d ms) %s", new Object[]{Long.valueOf(r1), r11});     // Catch: Throwable -> L16
            Iterator<Marker> r12 = this.mMarkers.iterator();     // Catch: Throwable -> L16
        L11:
            if (r12.hasNext() == false) goto L14;
            Marker r2 = r12.next();     // Catch: Throwable -> L16
            long r3 = r2.time;     // Catch: Throwable -> L16
            VolleyLog.d("(+%-4d) [%2d] %s", new Object[]{Long.valueOf(r3 - r5), Long.valueOf(r2.thread), r2.name});     // Catch: Throwable -> L16
            r5 = r3;
            goto L11
        L14:
            monitor-exit(this);
            return;
        L16:
            th = move-exception;
            throw th;
        }

        protected void finalize() throws Throwable {
            if (this.mFinished == true) goto L6;
            finish("Request on the loose");
            VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            return;
        }

        private long getTotalDuration() {
            if (this.mMarkers.size() != 0) goto L6;
            return 0;
        L6:
            long r0 = this.mMarkers.get(0).time;
            List<Marker> r4 = this.mMarkers;
            return r4.get(r4.size() - 1).time - r0;
        }
    }

    public VolleyLog() {
    }

    static {
        DEBUG = Log.isLoggable("Volley", 2);
        CLASS_NAME = VolleyLog.class.getName();
    }

    public static void setTag(String r2) {
        d("Changing log tag to %s", new Object[]{r2});
        TAG = r2;
        DEBUG = Log.isLoggable(r2, 2);
    }

    public static void v(String r1, Object... r2) {
        if (DEBUG == false) goto L6;
        Log.v(TAG, buildMessage(r1, r2));
        return;
    }

    public static void d(String r1, Object... r2) {
        Log.d(TAG, buildMessage(r1, r2));
    }

    public static void e(String r1, Object... r2) {
        Log.e(TAG, buildMessage(r1, r2));
    }

    public static void e(Throwable r1, String r2, Object... r3) {
        Log.e(TAG, buildMessage(r2, r3), r1);
    }

    public static void wtf(String r1, Object... r2) {
        Log.wtf(TAG, buildMessage(r1, r2));
    }

    public static void wtf(Throwable r1, String r2, Object... r3) {
        Log.wtf(TAG, buildMessage(r2, r3), r1);
    }

    private static String buildMessage(String r6, Object... r7) {
        if (r7 == null) goto L5;
        r6 = String.format(Locale.US, r6, r7);
    L5:
        StackTraceElement[] r8 = new Throwable().fillInStackTrace().getStackTrace();
        int r1 = 2;
    L7:
        if (r1 >= r8.length) goto L12;
        if (r8[r1].getClassName().equals(CLASS_NAME) == false) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        String r2 = r8[r1].getClassName();
        String r3 = r2.substring(r2.lastIndexOf(46) + 1);
        String r9 = r3.substring(r3.lastIndexOf(36) + 1) + "." + r8[r1].getMethodName();
    L14:
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), r9, r6});
    L12:
        r9 = PinyinUtils.UNKNOWN_STRING;
        goto L14
    }
}
