package com.bytedance.monitor.collector;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MessageQueue f5179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f5180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f5181c;

    static {
    }

    public static MessageQueue a() {
        if (f5179a != null) goto L18;
        if (Looper.getMainLooper() == null) goto L18;
        Looper r0 = Looper.getMainLooper();
        if (r0 != Looper.myLooper()) goto L11;
        MessageQueue r1 = Looper.myQueue();
    L9:
        f5179a = r1;
        goto L18
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        r1 = r0.getQueue();
        goto L9
    L19:
        Field r2 = r0.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L15
        r2.setAccessible(true);     // Catch: Throwable -> L15
        f5179a = (MessageQueue) r2.get(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        return f5179a;
    }

    public static Message b(MessageQueue r3) {
        Field r0 = f5180b;
        if (r0 != null) goto L12;
        Field r1 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L6
        f5180b = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f5180b.get(r3);
    L6:
        return null;
    L12:
        return (Message) r0.get(r3);
    L9:
        return null;
    }

    protected static Message c(Message r3) {
        Field r0 = f5181c;
        if (r0 != null) goto L12;
        Field r1 = Class.forName("android.os.Message").getDeclaredField("next");     // Catch: Exception -> L6
        f5181c = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f5181c.get(r3);
    L6:
        return null;
    L12:
        return (Message) r0.get(r3);
    L9:
        return null;
    }
}
