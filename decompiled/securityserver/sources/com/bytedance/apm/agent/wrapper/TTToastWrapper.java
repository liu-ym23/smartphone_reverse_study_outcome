package com.bytedance.apm.agent.wrapper;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StringRes;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TTToastWrapper {

    public @interface Duration {
    }

    public static class ProxyTNHandler extends Handler {
        private Method handleHideMethod;
        private Method handleShowMethod;
        private Object tnObject;

        public ProxyTNHandler(Object r4) {
            this.tnObject = r4;
            Method r0 = r4.getClass().getDeclaredMethod("handleShow", new Class[]{IBinder.class});     // Catch: NoSuchMethodException -> L5
            this.handleShowMethod = r0;     // Catch: NoSuchMethodException -> L5
            r0.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r5 = r4.getClass().getDeclaredMethod("handleHide", null);     // Catch: NoSuchMethodException -> L5
            this.handleHideMethod = r5;     // Catch: NoSuchMethodException -> L5
            r5.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            int r0 = r4.what;
            if (r0 != 0) goto L5;
            IBinder r1 = (IBinder) r4.obj;
            Method r2 = this.handleShowMethod;
            if (r2 != null) goto L48;
        L42:
            super.handleMessage(r4);
            return;
        L48:
            r2.invoke(this.tnObject, new Object[]{r1});     // Catch: WindowManager.BadTokenException -> L33 InvocationTargetException -> L35 IllegalAccessException -> L37
        L33:
            e = move-exception;
            e.printStackTrace();
        L37:
            e = move-exception;
            e.printStackTrace();
        L35:
            e = move-exception;
            e.printStackTrace();
            goto L42
        L5:
            if (r0 != 1) goto L7;
            Method r3 = this.handleHideMethod;
            if (r3 == null) goto L42;
            r3.invoke(this.tnObject, null);     // Catch: InvocationTargetException -> L23 IllegalAccessException -> L25
        L25:
            e = move-exception;
            e.printStackTrace();
        L23:
            e = move-exception;
            e.printStackTrace();
            goto L42
        L7:
            if (r0 != 2) goto L42;
            Method r5 = this.handleHideMethod;
            if (r5 == null) goto L42;
            r5.invoke(this.tnObject, null);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15
        L15:
            e = move-exception;
            e.printStackTrace();
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L42
        }
    }

    public TTToastWrapper() {
    }

    public static boolean initToastHook(Toast r0) {
        return true;
    }

    public static Toast makeText(Context r1, CharSequence r2, @Duration int r3) {
        Toast r4 = Toast.makeText(r1, r2 + "__wrapper", r3);
        initToastHook(r4);
        return r4;
    }

    private static boolean reflectAndoridNTNHandler(Toast r4) {
    L9:
        e = move-exception;
        e.printStackTrace();
    L26:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L5:
        if (r4.getClass().getSuperclass() != null) goto L7;
    L13:
        Field r1 = r4.getClass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
    L14:
        if (r1 != null) goto L16;
        return false;
    L16:
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        Object r5 = r1.get(r4);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        if (r5 != null) goto L19;
        return false;
    L19:
        Field r2 = r5.getClass().getDeclaredField("mHandler");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        if (r2 != null) goto L22;
        return false;
    L22:
        r2.setAccessible(true);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        r2.set(r5, new ProxyTNHandler(r5));     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        return true;
    L7:
        if (Toast.class.getName().equals(r4.getClass().getSuperclass().getName()) == false) goto L13;
        r1 = r4.getClass().getSuperclass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        goto L14
    }

    public static Toast makeText(Context r2, @StringRes int r3, @Duration int r4) {
        return makeText(r2, r2.getResources().getText(r3) + "__wrapper", r4);
    }
}
