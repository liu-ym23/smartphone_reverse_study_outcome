package com.bytedance.apm.block;

import android.view.View;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class GFXInfo {
    public GFXInfo() {
    }

    public static void getDisplayList() {
        Class<?> r1 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Exception -> L8
        Object r2 = r1.getMethod("getInstance", null).invoke(null, null);     // Catch: Exception -> L8
        Field r3 = r1.getDeclaredField("mRoots");     // Catch: Exception -> L8
        r3.setAccessible(true);     // Catch: Exception -> L8
        ArrayList r4 = (ArrayList) r3.get(r2);     // Catch: Exception -> L8
        Field r5 = Class.forName("android.view.ViewRootImpl").getDeclaredField("mView");     // Catch: Exception -> L8
        r5.setAccessible(true);     // Catch: Exception -> L8
        Field r6 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L8
        r6.setAccessible(true);     // Catch: Exception -> L8
        int r7 = 0;
        Method r8 = MainThreadMonitor.reflectHideMethod(Class.forName("android.graphics.RenderNode"), "output", new Class[0]);     // Catch: Exception -> L8
    L5:
        if (r7 >= r4.size()) goto L14;
        r8.invoke(r6.get(r5.get(r4.get(r7))), null);     // Catch: Exception -> L8
        r7 = r7 + 1;
        goto L5
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
