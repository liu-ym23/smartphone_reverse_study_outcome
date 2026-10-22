package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class LooperUtil {
    private static MessageQueue mMainQueue;
    private static Field mMessagesField;
    private static Field mNextMessageField;

    public LooperUtil() {
    }

    public static MessageQueue getMainMessageQueue() {
        if (mMainQueue != null) goto L11;
        if (Looper.getMainLooper() == null) goto L11;
        Looper r0 = Looper.getMainLooper();
        if (r0 != Looper.myLooper()) goto L9;
        mMainQueue = Looper.myQueue();
        goto L11
    L9:
        mMainQueue = r0.getQueue();
    L11:
        return mMainQueue;
    }

    public static Message getMessageObject(MessageQueue r3) {
        Field r0 = mMessagesField;
        if (r0 != null) goto L12;
        Field r1 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L6
        mMessagesField = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) mMessagesField.get(r3);
    L6:
        return null;
    L12:
        return (Message) r0.get(r3);
    L9:
        return null;
    }

    public static Message getNextMessage(Message r3) {
        Field r0 = mNextMessageField;
        if (r0 != null) goto L12;
        Field r1 = Class.forName("android.os.Message").getDeclaredField("next");     // Catch: Exception -> L6
        mNextMessageField = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) mNextMessageField.get(r3);
    L6:
        return null;
    L12:
        return (Message) r0.get(r3);
    L9:
        return null;
    }
}
