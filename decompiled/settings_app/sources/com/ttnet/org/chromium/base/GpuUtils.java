package com.ttnet.org.chromium.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes5.dex */
public class GpuUtils {
    private static String TAG = "GpuUtils";
    private static String sGlRenderer = "unknown";
    private static String sGlVendor = "unknown";
    private static final Object sGpuInfoLock = null;
    private static boolean sInitialized;

    public GpuUtils() {
    }

    static {
        sGpuInfoLock = new Object();
    }

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        EGLDisplay r2 = null;
        boolean r3 = false;
        EGLContext r6 = EGL14.eglGetCurrentContext();     // Catch: Throwable -> L90 Exception -> L92
        if (r6 != null) goto L144;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L146;
        r6 = r6;
        EGLSurface r4 = null;
    L130:
        Object r7 = sGpuInfoLock;     // Catch: Exception -> L88 Throwable -> L110
        monitor-enter(r7);     // Catch: Exception -> L88 Throwable -> L110
        sGlVendor = GLES20.glGetString(7936);     // Catch: Throwable -> L85
        sGlRenderer = GLES20.glGetString(7937);     // Catch: Throwable -> L85
        monitor-exit(r7);     // Catch: Throwable -> L85
        if (r5 == true) goto L139;
    L83:
        sInitialized = true;
        return true;
    L139:
        EGL14.eglMakeCurrent(r2, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L127
        if (r4 != null) goto L73;
    L75:
        if (r6 != null) goto L77;
    L79:
        if (r2 == null) goto L83;
        if (r2.equals(EGL14.EGL_NO_DISPLAY) == true) goto L83;
        EGL14.eglTerminate(r2);     // Catch: Exception -> L127
        goto L83
    L77:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L79;
        EGL14.eglDestroyContext(r2, r6);     // Catch: Exception -> L127
        goto L79
    L73:
        if (r4.equals(EGL14.EGL_NO_SURFACE) == true) goto L75;
        EGL14.eglDestroySurface(r2, r4);     // Catch: Exception -> L127
    L85:
        th = move-exception;
        throw th;     // Catch: Exception -> L88 Throwable -> L110
    L88:
        e = e;
    L94:
        e.printStackTrace();     // Catch: Throwable -> L110
        if (r5 == true) goto L132;
    L109:
        return false;
    L132:
        EGL14.eglMakeCurrent(r2, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L128
        if (r4 != null) goto L99;
    L101:
        if (r6 != null) goto L103;
    L105:
        if (r2 == null) goto L109;
        if (r2.equals(EGL14.EGL_NO_DISPLAY) == true) goto L109;
        EGL14.eglTerminate(r2);     // Catch: Exception -> L128
        goto L109
    L103:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L105;
        EGL14.eglDestroyContext(r2, r6);     // Catch: Exception -> L128
        goto L105
    L99:
        if (r4.equals(EGL14.EGL_NO_SURFACE) == true) goto L101;
        EGL14.eglDestroySurface(r2, r4);     // Catch: Exception -> L128
    L110:
        th = th;
        r3 = r5;
    L112:
        if (r3 == true) goto L137;
    L126:
        throw th;
    L137:
        EGL14.eglMakeCurrent(r2, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L129
        if (r4 != null) goto L116;
    L118:
        if (r6 != null) goto L120;
    L122:
        if (r2 == null) goto L126;
        if (r2.equals(EGL14.EGL_NO_DISPLAY) == true) goto L126;
        EGL14.eglTerminate(r2);     // Catch: Exception -> L129
        goto L126
    L120:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L122;
        EGL14.eglDestroyContext(r2, r6);     // Catch: Exception -> L129
        goto L122
    L116:
        if (r4.equals(EGL14.EGL_NO_SURFACE) == true) goto L118;
        EGL14.eglDestroySurface(r2, r4);     // Catch: Exception -> L129
        goto L118
    L146:
        EGLDisplay r14 = EGL14.eglGetDisplay(0);     // Catch: Throwable -> L59 Exception -> L61
        if (r14 == null) goto L54;
    L57:
        e = e;
        r6 = r6;
        r4 = null;
        r2 = r14;
    L55:
        th = th;
        r6 = r6;
        r3 = r5;
        r4 = null;
        r2 = r14;
        goto L112
    L23:
        if (r14.equals(EGL14.EGL_NO_DISPLAY) == true) goto L54;
        int[] r0 = new int[2];     // Catch: Throwable -> L55 Exception -> L57
        if (EGL14.eglInitialize(r14, r0, 0, r0, 1) == false) goto L52;
        int[] r15 = new int[1];     // Catch: Throwable -> L55 Exception -> L57
        EGLConfig[] r13 = new EGLConfig[1];     // Catch: Throwable -> L55 Exception -> L57
        if (EGL14.eglChooseConfig(r14, new int[]{12344}, 0, r13, 0, 1, r15, 0) == false) goto L50;
        if (r15[0] <= 0) goto L48;
        EGLConfig r8 = r13[0];     // Catch: Throwable -> L55 Exception -> L57
        EGLContext r9 = EGL14.eglCreateContext(r14, r8, EGL14.EGL_NO_CONTEXT, new int[]{12344}, 0);     // Catch: Throwable -> L55 Exception -> L57
        if (r9 == null) goto L46;
        if (r9.equals(EGL14.EGL_NO_CONTEXT) == true) goto L46;
        EGLSurface r10 = EGL14.eglCreatePbufferSurface(r14, r8, new int[]{12344}, 0);     // Catch: Throwable -> L55 Exception -> L57
        if (r10 == null) goto L44;
        if (r10.equals(EGL14.EGL_NO_SURFACE) == true) goto L44;
        if (EGL14.eglMakeCurrent(r14, r10, r10, r9) == false) goto L42;
        r6 = r9;
        r4 = r10;
        r2 = r14;
        goto L130
    L42:
        throw new Exception("eglMakeCurrent error");     // Catch: Throwable -> L55 Exception -> L57
    L44:
        throw new Exception("eglCreatePbufferSurface error");     // Catch: Throwable -> L55 Exception -> L57
    L46:
        throw new Exception("eglCreateContext error");     // Catch: Throwable -> L55 Exception -> L57
    L48:
        throw new Exception("no egl config chosen");     // Catch: Throwable -> L55 Exception -> L57
    L50:
        throw new Exception("eglChooseConfig error");     // Catch: Throwable -> L55 Exception -> L57
    L52:
        throw new Exception("eglInitialize error");     // Catch: Throwable -> L55 Exception -> L57
    L54:
        throw new Exception("eglGetDisplay error");     // Catch: Throwable -> L55 Exception -> L57
    L61:
        e = e;
    L17:
        r6 = r6;
        r4 = null;
    L59:
        th = th;
        r3 = r5;
    L14:
        r4 = null;
        goto L112
    L144:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L18;
        r5 = false;
        goto L19
    L15:
        e = e;
        r5 = false;
    L12:
        th = th;
        goto L14
    L92:
        e = e;
        r4 = null;
        r6 = null;
        r5 = false;
    L90:
        th = th;
        r4 = null;
        r6 = null;
        goto L112
    }

    public static String getGPUVendor() {
        Object r0 = sGpuInfoLock;
        monitor-enter(r0);
        String r1 = sGlVendor;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getGPUModel() {
        Object r0 = sGpuInfoLock;
        monitor-enter(r0);
        String r1 = sGlRenderer;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
