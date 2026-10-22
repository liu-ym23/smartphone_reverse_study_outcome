package ms.bd.c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

/* JADX INFO: loaded from: classes2.dex */
public class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f22418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f22419b = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EGLDisplay f22420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private EGLContext f22421b;

        public a(EGLContext r12, int r13) {
            EGLDisplay r14 = EGL14.EGL_NO_DISPLAY;
            this.f22420a = r14;
            this.f22421b = EGL14.EGL_NO_CONTEXT;
            if (r14 != EGL14.EGL_NO_DISPLAY) goto L29;
            EGLContext r15 = EGL14.EGL_NO_CONTEXT;
            EGLDisplay r1 = EGL14.eglGetDisplay(0);
            this.f22420a = r1;
            if (r1 == EGL14.EGL_NO_DISPLAY) goto L27;
            int[] r3 = new int[2];
            if (EGL14.eglInitialize(r1, r3, 0, r3, 1) == true) goto L9;
            this.f22420a = null;
            throw new RuntimeException((String) m.a(16777217, 0, 0, "b00b26", new byte[]{102, 60, 66, 20, 1, 36, 33, 5, 110, 114, 122, 60, 74, 2, 4, 32, 109, 24, 123, 55, 51, 23, 100, 58, 92, 117}));
        L9:
            if ((r13 & 2) == 0) goto L16;
            EGLConfig r2 = a(r13, 3);
            if (r2 == null) goto L16;
            EGLDisplay r6 = this.f22420a;
            EGLContext r4 = EGL14.eglCreateContext(r6, r2, r15, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() != 12288) goto L16;
            this.f22421b = r4;
        L16:
            if (this.f22421b != EGL14.EGL_NO_CONTEXT) goto L22;
            EGLConfig r16 = a(r13, 2);
            if (r16 == null) goto L21;
            EGLDisplay r5 = this.f22420a;
            EGLContext r17 = EGL14.eglCreateContext(r5, r16, r15, new int[]{12440, 2, 12344}, 0);
            d((String) m.a(16777217, 0, 0, "299ffd", new byte[]{38, 60, 70, 49, 75, 118, 48, 12, 109, 21, 44, 53, 94, 23, 65, 103}));
            this.f22421b = r17;
            goto L22
        L21:
            throw new RuntimeException((String) m.a(16777217, 0, 0, "85b01f", new byte[]{28, 57, 16, 70, 2, 116, 123, 0, 60, 32, 47, 62, 31, 64, 78, 112, 123, 7, 38, 105, 61, 54, 19, 72, 11, 49, 30, 51, 31, 67, 38, 57, 23, 77, 9}));
        L22:
            EGLDisplay r18 = this.f22420a;
            EGLContext r11 = this.f22421b;
            EGL14.eglQueryContext(r18, r11, 12440, new int[1], 0);
            return;
        L27:
            throw new RuntimeException((String) m.a(16777217, 0, 0, "07941e", new byte[]{52, 59, 75, 66, 2, 119, 115, 2, 103, 36, 38, 48, 94, 0, 43, 85, 31, 71, 60, 36, 37, 60, 89, 80, 2, 115, 42}));
        L29:
            throw new RuntimeException((String) m.a(16777217, 0, 0, "c10c64", new byte[]{87, 20, 111, 87, 8, 47, 114, 21, 96, 55, 107, 115, 80, 18, 29, 99, 117, 0}));
        }

        private EGLConfig a(int r13, int r14) {
            if (r14 < 3) goto L5;
            int r15 = 68;
        L6:
            int[] r4 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r15, 12344, 0, 12344};
            if ((r13 & 1) == 0) goto L9;
            r4[10] = 12610;
            r4[11] = 1;
        L9:
            EGLConfig[] r16 = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f22420a, r4, 0, r16, 0, 1, new int[1], 0) == true) goto L14;
            return null;
        L14:
            return r16[0];
        L5:
            r15 = 4;
            goto L6
        }

        private void d(String r9) {
            int r8 = EGL14.eglGetError();
            if (r8 != 12288) goto L6;
            return;
        L6:
            throw new RuntimeException(r9 + ((String) m.a(16777217, 0, 0, "63b2df", new byte[]{125, 113, 52, 97, 119, 49, 48, 0, 33, 109, 53, 107, 81, 22, 67})) + Integer.toHexString(r8));
        }

        public void b() {
            EGLDisplay r0 = this.f22420a;
            if (r0 == EGL14.EGL_NO_DISPLAY) goto L5;
            EGL14.eglDestroyContext(r0, this.f22421b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f22420a);
        L5:
            this.f22420a = EGL14.EGL_NO_DISPLAY;
            this.f22421b = EGL14.EGL_NO_CONTEXT;
        }

        public void c(EGLSurface r7) {
            if (EGL14.eglMakeCurrent(this.f22420a, r7, r7, this.f22421b) == false) goto L6;
            return;
        L6:
            throw new RuntimeException((String) m.a(16777217, 0, 0, "d3ea03", new byte[]{112, 54, 26, 56, 14, 47, 98, 49, 33, 35, 103, 52, 24, 1, 79, 34, 102, 27, 56, 52, 113}));
        }

        protected void finalize() {
        L7:
            th = move-exception;
            super.finalize();
            throw th;
        L3:
            if (this.f22420a == EGL14.EGL_NO_DISPLAY) goto L5;
            b();     // Catch: Throwable -> L7
        L5:
            super.finalize();
        }
    }

    static {
        String r0 = (String) m.a(16777217, 0, 0, "9712c5", new byte[]{105, 32, 76, 85, 73, 50, 42, 25, 114, 118, 45, 49, 3});
        f22419b = (String) m.a(16777217, 0, 0, "37d3f1", new byte[]{99, 48, 5, 85, 24});
    }

    public static String a() {
        String r0 = f22418a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        StringBuilder r1 = new StringBuilder();
        a r2 = new a(null, 2);     // Catch: Exception -> L12
        r2.c(EGL14.EGL_NO_SURFACE);     // Catch: Exception -> L12
        r1.append(GLES20.glGetString(7936));     // Catch: Exception -> L12
        r1.append((String) m.a(16777217, 0, 0, "2c99df", new byte[]{63}));     // Catch: Exception -> L12
        r1.append(GLES20.glGetString(7937));     // Catch: Exception -> L12
        r1.append((String) m.a(16777217, 0, 0, "941758", new byte[]{52}));     // Catch: Exception -> L12
        r1.append(GLES20.glGetString(7938));     // Catch: Exception -> L12
        f22418a = r1.toString();     // Catch: Exception -> L12
        r2.b();     // Catch: Exception -> L12
    L14:
        return f22418a;
    L12:
        f22418a = f22419b;
        goto L14
    }
}
