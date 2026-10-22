package com.ttnet.org.chromium.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class GpuUtils {
    private static String TAG = "GpuUtils";
    private static String sGlRenderer = "unknown";
    private static String sGlVendor = "unknown";
    private static final Object sGpuInfoLock = null;
    private static boolean sInitialized;

    static {
        sGpuInfoLock = new Object();
    }

    public GpuUtils() {
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

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        boolean r3 = false;
        if (Build.VERSION.SDK_INT >= 20) goto L8;
        return false;
    L8:
        EGLDisplay r2 = null;
        EGLContext r6 = EGL14.eglGetCurrentContext();     // Catch: Throwable -> L93 Exception -> L95
        if (r6 != null) goto L144;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L149;
        r6 = r6;
        EGLSurface r4 = null;
    L133:
        Object r7 = sGpuInfoLock;     // Catch: Exception -> L91 Throwable -> L113
        monitor-enter(r7);     // Catch: Exception -> L91 Throwable -> L113
        sGlVendor = GLES20.glGetString(7936);     // Catch: Throwable -> L88
        sGlRenderer = GLES20.glGetString(7937);     // Catch: Throwable -> L88
        monitor-exit(r7);     // Catch: Throwable -> L88
        if (r5 == true) goto L137;
    L86:
        sInitialized = true;
        return true;
    L137:
        EGLSurface r0 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L130
        EGL14.eglMakeCurrent(r2, r0, r0, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L130
        if (r4 != null) goto L76;
    L78:
        if (r6 != null) goto L80;
    L82:
        if (r2 == null) goto L86;
        if (r2.equals(EGL14.EGL_NO_DISPLAY) == true) goto L86;
        EGL14.eglTerminate(r2);     // Catch: Exception -> L130
        goto L86
    L80:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L82;
        EGL14.eglDestroyContext(r2, r6);     // Catch: Exception -> L130
        goto L82
    L76:
        if (r4.equals(EGL14.EGL_NO_SURFACE) == true) goto L78;
        EGL14.eglDestroySurface(r2, r4);     // Catch: Exception -> L130
    L88:
        th = move-exception;
        throw th;     // Catch: Exception -> L91 Throwable -> L113
    L91:
        e = e;
    L97:
        e.printStackTrace();     // Catch: Throwable -> L113
        if (r5 == true) goto L135;
    L112:
        return false;
    L135:
        EGLSurface r1 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L131
        EGL14.eglMakeCurrent(r2, r1, r1, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L131
        if (r4 != null) goto L102;
    L104:
        if (r6 != null) goto L106;
    L108:
        if (r2 == null) goto L112;
        if (r2.equals(EGL14.EGL_NO_DISPLAY) == true) goto L112;
        EGL14.eglTerminate(r2);     // Catch: Exception -> L131
        goto L112
    L106:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L108;
        EGL14.eglDestroyContext(r2, r6);     // Catch: Exception -> L131
        goto L108
    L102:
        if (r4.equals(EGL14.EGL_NO_SURFACE) == true) goto L104;
        EGL14.eglDestroySurface(r2, r4);     // Catch: Exception -> L131
    L113:
        th = th;
        r3 = r5;
    L115:
        if (r3 == true) goto L142;
    L129:
        throw th;
    L142:
        EGLSurface r8 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L132
        EGL14.eglMakeCurrent(r2, r8, r8, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L132
        if (r4 != null) goto L119;
    L121:
        if (r6 != null) goto L123;
    L125:
        if (r2 == null) goto L129;
        if (r2.equals(EGL14.EGL_NO_DISPLAY) == true) goto L129;
        EGL14.eglTerminate(r2);     // Catch: Exception -> L132
        goto L129
    L123:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L125;
        EGL14.eglDestroyContext(r2, r6);     // Catch: Exception -> L132
        goto L125
    L119:
        if (r4.equals(EGL14.EGL_NO_SURFACE) == true) goto L121;
        EGL14.eglDestroySurface(r2, r4);     // Catch: Exception -> L132
        goto L121
    L149:
        EGLDisplay r14 = EGL14.eglGetDisplay(0);     // Catch: Throwable -> L62 Exception -> L64
        if (r14 == null) goto L57;
    L60:
        e = e;
        r6 = r6;
        r4 = null;
        r2 = r14;
    L58:
        th = th;
        r6 = r6;
        r3 = r5;
        r4 = null;
        r2 = r14;
        goto L115
    L26:
        if (r14.equals(EGL14.EGL_NO_DISPLAY) == true) goto L57;
        int[] r9 = new int[2];     // Catch: Throwable -> L58 Exception -> L60
        if (EGL14.eglInitialize(r14, r9, 0, r9, 1) == false) goto L55;
        int[] r15 = new int[1];     // Catch: Throwable -> L58 Exception -> L60
        EGLConfig[] r13 = new EGLConfig[1];     // Catch: Throwable -> L58 Exception -> L60
        if (EGL14.eglChooseConfig(r14, new int[]{12344}, 0, r13, 0, 1, r15, 0) == false) goto L53;
        if (r15[0] <= 0) goto L51;
        EGLConfig r10 = r13[0];     // Catch: Throwable -> L58 Exception -> L60
        EGLContext r11 = EGL14.eglCreateContext(r14, r10, EGL14.EGL_NO_CONTEXT, new int[]{12344}, 0);     // Catch: Throwable -> L58 Exception -> L60
        if (r11 == null) goto L49;
        if (r11.equals(EGL14.EGL_NO_CONTEXT) == true) goto L49;
        EGLSurface r12 = EGL14.eglCreatePbufferSurface(r14, r10, new int[]{12344}, 0);     // Catch: Throwable -> L58 Exception -> L60
        if (r12 == null) goto L47;
        if (r12.equals(EGL14.EGL_NO_SURFACE) == true) goto L47;
        if (EGL14.eglMakeCurrent(r14, r12, r12, r11) == false) goto L45;
        r6 = r11;
        r4 = r12;
        r2 = r14;
        goto L133
    L45:
        throw new Exception("eglMakeCurrent error");     // Catch: Throwable -> L58 Exception -> L60
    L47:
        throw new Exception("eglCreatePbufferSurface error");     // Catch: Throwable -> L58 Exception -> L60
    L49:
        throw new Exception("eglCreateContext error");     // Catch: Throwable -> L58 Exception -> L60
    L51:
        throw new Exception("no egl config chosen");     // Catch: Throwable -> L58 Exception -> L60
    L53:
        throw new Exception("eglChooseConfig error");     // Catch: Throwable -> L58 Exception -> L60
    L55:
        throw new Exception("eglInitialize error");     // Catch: Throwable -> L58 Exception -> L60
    L57:
        throw new Exception("eglGetDisplay error");     // Catch: Throwable -> L58 Exception -> L60
    L64:
        e = e;
    L20:
        r6 = r6;
        r4 = null;
    L62:
        th = th;
        r3 = r5;
    L17:
        r4 = null;
        goto L115
    L144:
        if (r6.equals(EGL14.EGL_NO_CONTEXT) == true) goto L21;
        r5 = false;
        goto L22
    L18:
        e = e;
        r5 = false;
    L15:
        th = th;
        goto L17
    L95:
        e = e;
        r4 = null;
        r6 = null;
        r5 = false;
    L93:
        th = th;
        r4 = null;
        r6 = null;
        goto L115
    }
}
