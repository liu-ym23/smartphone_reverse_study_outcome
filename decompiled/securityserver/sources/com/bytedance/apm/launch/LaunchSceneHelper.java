package com.bytedance.apm.launch;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.bytedance.monitor.util.ActivityThreadUtils;
import com.bytedance.monitor.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LaunchSceneHelper {
    private static final String TAG = "LaunchSceneHelper";

    public LaunchSceneHelper() {
    }

    public static Intent getActivityComponentIntent(Message r3) {
        Object r0 = r3.obj;
        if (r3.what != 159) goto L26;
        List r4 = (List) FieldUtils.readField(r0, "mActivityCallbacks");     // Catch: IllegalAccessException -> L14
        if (r4 == null) goto L27;
        int r1 = 0;
    L8:
        if (r1 >= r4.size()) goto L28;
        Object r2 = r4.get(r1);     // Catch: IllegalAccessException -> L14
        if (r2 == null) goto L16;
        Intent r5 = (Intent) FieldUtils.readField(r2, "mIntent");     // Catch: IllegalAccessException -> L14
        if (r5 == null) goto L16;
        return r5;
    L16:
        r1 = r1 + 1;
        goto L8
    L28:
        return null;
    L27:
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L26:
        return null;
    }

    private static Intent getComponentIntent(Message r2) {
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
        return getReceiverComponentIntent(r2);
    L14:
        return getServiceComponentIntent(r2);
    L16:
        return getActivityComponentIntent(r2);
    }

    public static Intent getFirstActivityIntent() {
        MessageQueue r0 = (MessageQueue) FieldUtils.readField(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L40
        monitor-enter(r0);     // Catch: Throwable -> L40
        Message r1 = (Message) FieldUtils.readField(r0, "mMessages");     // Catch: Throwable -> L18
        if (r1 != null) goto L7;
    L20:
        Field r4 = FieldUtils.getField(Message.class, "next");     // Catch: Throwable -> L18
        r4.setAccessible(true);     // Catch: Throwable -> L18
    L21:
        if (r1 == null) goto L36;
        r1 = (Message) FieldUtils.readField(r4, r1);     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L21;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L21;
        int r5 = r1.what;     // Catch: Throwable -> L18
        if (r5 == 100) goto L32;
        if (r5 != 159) goto L21;
    L32:
        Intent r6 = getComponentIntent(r1);     // Catch: Throwable -> L18
        if (r6 == null) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r6;
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    L7:
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L20;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L20;
        int r7 = r1.what;     // Catch: Throwable -> L18
        if (r7 == 100) goto L14;
        if (r7 != 159) goto L20;
    L14:
        Intent r8 = getComponentIntent(r1);     // Catch: Throwable -> L18
        if (r8 == null) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r8;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Intent getFirstComponentIntent() {
        MessageQueue r0 = (MessageQueue) FieldUtils.readField(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L32
        monitor-enter(r0);     // Catch: Throwable -> L32
        Message r1 = (Message) FieldUtils.readField(r0, "mMessages");     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
    L16:
        Field r2 = FieldUtils.getField(Message.class, "next");     // Catch: Throwable -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L14
    L17:
        if (r1 == null) goto L28;
        r1 = (Message) FieldUtils.readField(r2, r1);     // Catch: Throwable -> L14
        if (r1 == null) goto L17;
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L17;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L17;
        Intent r3 = getComponentIntent(r1);     // Catch: Throwable -> L14
        if (r3 == null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r3;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return null;
    L7:
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L16;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L16;
        Intent r4 = getComponentIntent(r1);     // Catch: Throwable -> L14
        if (r4 == null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r4;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Intent getReceiverComponentIntent(Message r2) {
        if (r2.what != 113) goto L5;
        String r0 = "intent";
    L7:
        if (r0.isEmpty() == true) goto L18;
        Object r3 = r2.obj;
        if (r3 == null) goto L19;
        return (Intent) FieldUtils.readField(r3, r0);
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

    public static Intent getServiceComponentIntent(Message r2) {
        int r0 = r2.what;
        if (r0 != 114) goto L5;
    L11:
        String r1 = "intent";
    L13:
        if (r1.isEmpty() == true) goto L24;
        Object r3 = r2.obj;
        if (r3 == null) goto L25;
        return (Intent) FieldUtils.readField(r3, r1);
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
