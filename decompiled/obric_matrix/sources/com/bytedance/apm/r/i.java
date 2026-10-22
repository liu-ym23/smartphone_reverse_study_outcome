package com.bytedance.apm.r;

import android.os.Build;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a() {
        Class<?> r0 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Exception -> L12
        Object r1 = r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L12
        Field r2 = r0.getDeclaredField("mRoots");     // Catch: Exception -> L12
        r2.setAccessible(true);     // Catch: Exception -> L12
        ArrayList r3 = (ArrayList) r2.get(r1);     // Catch: Exception -> L12
        Field r4 = Class.forName("android.view.ViewRootImpl").getDeclaredField("mView");     // Catch: Exception -> L12
        r4.setAccessible(true);     // Catch: Exception -> L12
        Field r5 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L12
        r5.setAccessible(true);     // Catch: Exception -> L12
        if (Build.VERSION.SDK_INT <= 28) goto L6;
        String r6 = "android.graphics.RenderNode";
    L7:
        Method r7 = com.bytedance.apm.r.m.e.J(Class.forName(r6), "output", new Class[0]);     // Catch: Exception -> L12
        int r8 = 0;
    L9:
        if (r8 >= r3.size()) goto L18;
        r7.invoke(r5.get(r4.get(r3.get(r8))), new Object[0]);     // Catch: Exception -> L12
        r8 = r8 + 1;
        goto L9
    L18:
        return;
    L6:
        r6 = "android.view.RenderNode";
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}
