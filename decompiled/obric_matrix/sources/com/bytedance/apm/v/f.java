package com.bytedance.apm.v;

import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {
    static Intent a(Message r5) {
        Object r0 = r5.obj;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 28) goto L5;
    L10:
        if (r1 >= 28) goto L12;
        return null;
    L12:
        if (r5.what != 159) goto L32;
        List r6 = (List) d.b.l.a.b.c(r0, "mActivityCallbacks");     // Catch: IllegalAccessException -> L8
        if (r6 == null) goto L33;
        int r2 = 0;
    L17:
        if (r2 >= r6.size()) goto L34;
        Object r3 = r6.get(r2);     // Catch: IllegalAccessException -> L8
        if (r3 == null) goto L23;
        Intent r4 = (Intent) d.b.l.a.b.c(r3, "mIntent");     // Catch: IllegalAccessException -> L8
        if (r4 == null) goto L23;
        return r4;
    L23:
        r2 = r2 + 1;
        goto L17
    L34:
        return null;
    L33:
        return null;
    L32:
        return null;
    L5:
        if (r5.what != 100) goto L10;
        return (Intent) d.b.l.a.b.c(r0, "intent");
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static Intent b(Message r2) {
        int r0 = r2.what;
        if (r0 == 100) goto L16;
        if (r0 == 121) goto L14;
        if (r0 == 159) goto L16;
        switch(r0) {
            case 113: goto L12;
            case 114: goto L14;
            case 115: goto L14;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return d(r2);
    L14:
        return e(r2);
    L16:
        return a(r2);
    }

    public static Intent c() {
        MessageQueue r0 = (MessageQueue) d.b.l.a.b.c(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L39
        monitor-enter(r0);     // Catch: Throwable -> L39
        Message r1 = (Message) d.b.l.a.b.c(r0, "mMessages");     // Catch: Throwable -> L36
        if (r1 != null) goto L7;
    L18:
        Field r4 = d.b.l.a.b.a(Message.class, "next");     // Catch: Throwable -> L36
        r4.setAccessible(true);     // Catch: Throwable -> L36
    L19:
        if (r1 == null) goto L34;
        r1 = (Message) d.b.l.a.b.d(r4, r1);     // Catch: Throwable -> L36
        if (r1 == null) goto L19;
        if (r1.getTarget() != d.b.l.a.a.f()) goto L19;
        if (d.b.l.a.a.h(r1) == false) goto L19;
        int r5 = r1.what;     // Catch: Throwable -> L36
        if (r5 == 100) goto L30;
        if (r5 != 159) goto L19;
    L30:
        Intent r6 = b(r1);     // Catch: Throwable -> L36
        if (r6 == null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r6;
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L36
        return null;
    L7:
        if (r1.getTarget() != d.b.l.a.a.f()) goto L18;
        if (d.b.l.a.a.h(r1) == false) goto L18;
        int r7 = r1.what;     // Catch: Throwable -> L36
        if (r7 == 100) goto L14;
        if (r7 != 159) goto L18;
    L14:
        Intent r8 = b(r1);     // Catch: Throwable -> L36
        if (r8 == null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r8;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    static Intent d(Message r2) {
        if (r2.what != 113) goto L5;
        String r0 = "intent";
    L7:
        if (r0.isEmpty() == true) goto L18;
        Object r3 = r2.obj;
        if (r3 == null) goto L19;
        return (Intent) d.b.l.a.b.c(r3, r0);
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    L19:
        return null;
    L18:
        return null;
    L5:
        r0 = "";
        goto L7
    }

    static Intent e(Message r2) {
        int r0 = r2.what;
        if (r0 != 114) goto L5;
    L11:
        String r1 = "intent";
    L13:
        if (r1.isEmpty() == true) goto L24;
        Object r3 = r2.obj;
        if (r3 == null) goto L25;
        return (Intent) d.b.l.a.b.c(r3, r1);
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    L25:
        return null;
    L24:
        return null;
    L5:
        if (r0 == 121) goto L11;
        if (r0 != 115) goto L10;
        r1 = "args";
        goto L13
    L10:
        r1 = "";
        goto L13
    }
}
