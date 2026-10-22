package com.bytedance.apm.agent.wrapper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class TTToastWrapper {

    public @interface Duration {
    }

    private static class ProxyTNHandler extends Handler {
        private Method handleHideMethod;
        private Method handleShowMethod;
        private Object tnObject;

        ProxyTNHandler(Object r7) {
            this.tnObject = r7;
            Method r0 = r7.getClass().getDeclaredMethod("handleShow", new Class[]{IBinder.class});     // Catch: NoSuchMethodException -> L5
            this.handleShowMethod = r0;     // Catch: NoSuchMethodException -> L5
            r0.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r8 = r7.getClass().getDeclaredMethod("handleHide", new Class[0]);     // Catch: NoSuchMethodException -> L5
            this.handleHideMethod = r8;     // Catch: NoSuchMethodException -> L5
            r8.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            int r0 = r6.what;
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            Method r1 = this.handleHideMethod;
            if (r1 != null) goto L36;
        L34:
            super.handleMessage(r6);
            return;
        L36:
            r1.invoke(this.tnObject, new Object[0]);     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L22
        L22:
            e = move-exception;
            e.printStackTrace();
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L34
        L6:
            if (r0 != 2) goto L34;
            Method r2 = this.handleHideMethod;
            if (r2 == null) goto L34;
            r2.invoke(this.tnObject, new Object[0]);     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L34
        L24:
            IBinder r3 = (IBinder) r6.obj;
            Method r4 = this.handleShowMethod;
            if (r4 == null) goto L34;
            r4.invoke(this.tnObject, new Object[]{r3});     // Catch: WindowManager.BadTokenException -> L28 InvocationTargetException -> L30 IllegalAccessException -> L32
        L28:
            e = move-exception;
            e.printStackTrace();
        L32:
            e = move-exception;
            e.printStackTrace();
        L30:
            e = move-exception;
            e.printStackTrace();
            goto L34
        }
    }

    public static boolean initToastHook(Toast r0) {
        return true;
    }

    public TTToastWrapper() {
    }

    public static Toast makeText(Context r1, CharSequence r2, int r3) {
        Toast r4 = Toast.makeText(r1, r2 + "__wrapper", r3);
        initToastHook(r4);
        return r4;
    }

    public static Toast makeText(Context r2, int r3, int r4) throws Resources.NotFoundException {
        return makeText(r2, r2.getResources().getText(r3) + "__wrapper", r4);
    }

    private static boolean reflectAndoridNTNHandler(Toast r4) {
    L20:
        e = move-exception;
        e.printStackTrace();
    L24:
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L5:
        if (r4.getClass().getSuperclass() != null) goto L7;
    L9:
        Field r1 = r4.getClass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
    L10:
        if (r1 != null) goto L12;
        return false;
    L12:
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        Object r5 = r1.get(r4);     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        if (r5 != null) goto L15;
        return false;
    L15:
        Field r2 = r5.getClass().getDeclaredField("mHandler");     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        if (r2 != null) goto L18;
        return false;
    L18:
        r2.setAccessible(true);     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        r2.set(r5, new ProxyTNHandler(r5));     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        return true;
    L7:
        if (Toast.class.getName().equals(r4.getClass().getSuperclass().getName()) == false) goto L9;
        r1 = r4.getClass().getSuperclass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        goto L10
    }
}
