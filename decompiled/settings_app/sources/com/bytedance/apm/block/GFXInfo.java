package com.bytedance.apm.block;

import android.view.View;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class GFXInfo {
    public GFXInfo() {
    }

    public static void getDisplayList() {
        Class<?> r0 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Exception -> L7
        Object r1 = r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L7
        Field r2 = r0.getDeclaredField("mRoots");     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        ArrayList r3 = (ArrayList) r2.get(r1);     // Catch: Exception -> L7
        Field r4 = Class.forName("android.view.ViewRootImpl").getDeclaredField("mView");     // Catch: Exception -> L7
        r4.setAccessible(true);     // Catch: Exception -> L7
        Field r5 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L7
        r5.setAccessible(true);     // Catch: Exception -> L7
        Method r6 = MainThreadMonitor.reflectHideMethod(Class.forName("android.graphics.RenderNode"), "output", new Class[0]);     // Catch: Exception -> L7
        int r7 = 0;
    L4:
        if (r7 >= r3.size()) goto L13;
        r6.invoke(r5.get(r4.get(r3.get(r7))), new Object[0]);     // Catch: Exception -> L7
        r7 = r7 + 1;
        goto L4
    L13:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
