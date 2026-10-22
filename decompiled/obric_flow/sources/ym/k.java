package ym;

import ai.j0;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static io.reactivex.internal.functions.d f23303a;

    public static final com.bytedance.ies.bullet.lynx.d a() {
        if (com.bytedance.ies.bullet.service.monitor.h.f6044p != null) goto L6;
        tc.c r5 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.monitor.h.f6044p = (com.bytedance.ies.bullet.lynx.d) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.lynx.d.class, com.bytedance.ies.bullet.lynx.d.class);
    L6:
        return com.bytedance.ies.bullet.service.monitor.h.f6044p;
    }

    public static boolean b(float r5) {
        if (Float.compare(r5, 1.0E9f) < 0) goto L5;
        return true;
    L5:
        if (Float.compare(r5, -1.0E9f) <= 0) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r5.getResources().getConfiguration().getLayoutDirection() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static final View d(Context r5, int r10, Function3 r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r11, "ofStyle");
        ContextThemeWrapper r12 = new ContextThemeWrapper(r5, r10);
        TypedArray r13 = r12.obtainStyledAttributes(null, new int[]{R.attr.layout_width, R.attr.layout_height}, 0, r10);
        int r14 = r13.getLayoutDimension(0, -2);     // Catch: Throwable -> L6
        int r15 = r13.getLayoutDimension(1, -2);     // Catch: Throwable -> L6
        View r16 = (View) r11.invoke(r12, Integer.valueOf(r14), Integer.valueOf(r15));     // Catch: Throwable -> L6
        r13.recycle();
        return r16;
    L6:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    public static String e() {
        StackTraceElement r5 = new Throwable().getStackTrace()[1];
        return ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ") " + r5.getMethodName() + "()";
    }

    public static String f() {
        StackTraceElement r5 = new Throwable().getStackTrace()[1];
        return ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ")";
    }

    public static String g(Context r5, int r10) {
        if (r10 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return r5.getResources().getResourceEntryName(r10);
    L9:
        return j0.g(r10, "?");
    }

    public static String h(View r5) {
        return r5.getContext().getResources().getResourceEntryName(r5.getId());
    L4:
        return "UNKNOWN";
    }

    public static String i(int r5, MotionLayout r10) {
        if (r5 != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        return r10.getContext().getResources().getResourceEntryName(r5);
    }

    public static LinkedList j(int r14) {
        File[] r15 = new File(j0.h(r14, "/proc/", "/task/")).listFiles();
        LinkedList r5 = new LinkedList();
        int r10 = r15.length;
        BufferedReader r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L18;
        BufferedReader r13 = new BufferedReader(new InputStreamReader(new FileInputStream(r15[r12].getPath() + "/stat")), 1000);     // Catch: Throwable -> L11 Exception -> L19 FileNotFoundException -> L16
        String r16 = r13.readLine();     // Catch: Throwable -> L8 Exception -> L10
        int r17 = r16.lastIndexOf(41);     // Catch: Throwable -> L8 Exception -> L10
        String r18 = r16.substring(0, r17);     // Catch: Throwable -> L8 Exception -> L10
        String r19 = r16.substring(r17 + 4);     // Catch: Throwable -> L8 Exception -> L10
        int r20 = r18.indexOf(40);     // Catch: Throwable -> L8 Exception -> L10
        int r21 = Integer.valueOf(r18.substring(0, r20 - 1)).intValue();     // Catch: Throwable -> L8 Exception -> L10
        String r22 = r18.substring(r20 + 1);     // Catch: Throwable -> L8 Exception -> L10
        String[] r23 = r19.split(" ");     // Catch: Throwable -> L8 Exception -> L10
        r5.add(new u6.a(r21, r22, Long.parseLong(r23[10]) + Long.parseLong(r23[11])));     // Catch: Throwable -> L8 Exception -> L10
        td.c.j(r13);
        r11 = r13;
    L17:
        r12 = r12 + 1;
        goto L3
    L10:
        r11 = r13;
    L8:
        th = th;
        r11 = r13;
    L12:
        td.c.j(r11);
        throw th;
    L16:
        td.c.j(r11);
    L11:
        th = th;
    L14:
        td.c.j(r11);
        return null;
    L18:
        return r5;
    }
}
