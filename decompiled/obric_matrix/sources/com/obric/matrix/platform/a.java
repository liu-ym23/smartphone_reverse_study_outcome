package com.obric.matrix.platform;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/obric/matrix/platform/ArmV7SupportUtil;", "", "()V", "get32LibPath", "", "driverContext", "Landroid/content/Context;", "hookSystemLoadLib", "", "context", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9484a = null;

    static {
        f9484a = new a();
    }

    private a() {
    }

    public final String a(Context r3) {
        o.f(r3, "driverContext");
        String r2 = r3.getApplicationInfo().publicSourceDir + "!/lib/armeabi-v7a/";     // Catch: Exception -> L5
        Log.v("ArmV7SupportUtil", "get32LibPath loadLibPath = " + r2);     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        throw new RuntimeException("Failed to load vrapilinker", e);
    }

    public final void b(Context r8) {
        o.f(r8, "context");
        String r7 = a(r8);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return;
    L6:
        Class r1 = DexClassLoader.class.getSuperclass();     // Catch: Throwable -> L26
        o.e(r1, "DexClassLoader::class.java.superclass");     // Catch: Throwable -> L26
        Field r2 = r1.getDeclaredField("pathList");     // Catch: Throwable -> L26
        r2.setAccessible(true);     // Catch: Throwable -> L26
        Object r9 = r2.get(r8.getClassLoader());     // Catch: Throwable -> L26
        Class<?> r3 = r9.getClass();     // Catch: Throwable -> L26
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L26
        r4.add(new File(r7));     // Catch: Throwable -> L26
        Field r10 = r3.getDeclaredField("nativeLibraryDirectories");     // Catch: Throwable -> L26
        o.e(r10, "dexPathListClass.getDecl…ativeLibraryDirectories\")");     // Catch: Throwable -> L26
        r10.setAccessible(true);     // Catch: Throwable -> L26
        Object r11 = r10.get(r9);     // Catch: Throwable -> L26
        if (r11 == null) goto L24;
        r4.addAll((List) r11);     // Catch: Throwable -> L26
        Field r12 = r3.getDeclaredField("systemNativeLibraryDirectories");     // Catch: Throwable -> L26
        r12.setAccessible(true);     // Catch: Throwable -> L26
        Object r13 = r12.get(r9);     // Catch: Throwable -> L26
        if (r13 == null) goto L22;
        r4.addAll((List) r13);     // Catch: Throwable -> L26
        Method r14 = r3.getDeclaredMethod("makePathElements", new Class[]{List.class});     // Catch: Throwable -> L26
        r14.setAccessible(true);     // Catch: Throwable -> L26
        Object r15 = r14.invoke(null, new Object[]{r4});     // Catch: Throwable -> L26
        if (r15 == null) goto L20;
        Field r5 = r3.getDeclaredField("nativeLibraryPathElements");     // Catch: Throwable -> L26
        r5.setAccessible(true);     // Catch: Throwable -> L26
        r5.set(r9, (Object[]) r15);     // Catch: Throwable -> L26
        Field r16 = r3.getDeclaredField("nativeLibraryPathElements");     // Catch: Throwable -> L26
        r16.setAccessible(true);     // Catch: Throwable -> L26
        Object r17 = r16.get(r9);     // Catch: Throwable -> L26
        if (r17 == null) goto L18;
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L26
        r0.append("install: newNativeLibraryPathElements = ");     // Catch: Throwable -> L26
        String r18 = Arrays.toString((Object[]) r17);     // Catch: Throwable -> L26
        o.e(r18, "toString(this)");     // Catch: Throwable -> L26
        r0.append(r18);     // Catch: Throwable -> L26
        Log.d("ArmV7SupportUtil", r0.toString());     // Catch: Throwable -> L26
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");     // Catch: Throwable -> L26
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");     // Catch: Throwable -> L26
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<java.io.File>");     // Catch: Throwable -> L26
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<java.io.File>");     // Catch: Throwable -> L26
    }
}
