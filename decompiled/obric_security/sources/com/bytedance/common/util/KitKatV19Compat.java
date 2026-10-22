package com.bytedance.common.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class KitKatV19Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.KitKatV19Compat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        public void setWebContentsDebuggingEnabled(boolean r1) {
        }

        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }

        public void setAlarmTime(AlarmManager r1, int r2, long r3, PendingIntent r5) {
            if (r1 == null) goto L10;
            r1.set(r2, r3, r5);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
            return;
        }
    }

    private static class KitKatImpl extends BaseImpl {
        private KitKatImpl() {
            super(null);
        }

        /* synthetic */ KitKatImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.util.KitKatV19Compat.BaseImpl
        public void setWebContentsDebuggingEnabled(boolean r1) {
            WebView.setWebContentsDebuggingEnabled(r1);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.bytedance.common.util.KitKatV19Compat.BaseImpl
        public void setAlarmTime(AlarmManager r2, int r3, long r4, PendingIntent r6) {
            if (r2 == null) goto L19;
            r2.setExact(r3, r4, r6);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if ((th instanceof NoSuchMethodError) == false) goto L13;
            if (r2 == null) goto L20;
            r2.set(r3, r4, r6);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            th.printStackTrace();
            return;
        L20:
            return;
        L13:
            th.printStackTrace();
            return;
        }
    }

    public KitKatV19Compat() {
    }

    static {
        mImpl = new KitKatImpl(null);
    }

    public static void setWebContentsDebuggingEnabled(boolean r1) {
        mImpl.setWebContentsDebuggingEnabled(r1);
    }

    public static void setAlarmTime(AlarmManager r6, int r7, long r8, PendingIntent r10) {
        mImpl.setAlarmTime(r6, r7, r8, r10);
    }
}
