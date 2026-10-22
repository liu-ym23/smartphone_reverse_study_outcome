package com.obric.common.oea.foundation.effect;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import android.view.Choreographer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    public class Renderer implements GLSurfaceView.Renderer {
        public int A;
        public int B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f134a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f135d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public Bitmap r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public int z;

        public static void a(String r4) {
            int r0 = GLES20.glGetError();
            if (r0 != 0) goto L5;
            return;
        L5:
            Log.e("GL3BlurRenderer", r4 + ": glError " + r0);
            throw new RuntimeException(r4 + ": glError " + r0);
        }

        public static int[] b(int r15, int r16) {
            int[] r1 = new int[1];
            GLES20.glGenFramebuffers(1, r1, 0);
            GLES20.glBindFramebuffer(36160, r1[0]);
            int[] r3 = new int[1];
            GLES20.glGenTextures(1, r3, 0);
            GLES20.glBindTexture(3553, r3[0]);
            GLES20.glTexImage2D(3553, 0, 6408, r15, r16, 0, 6408, 5121, null);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, r3[0], 0);
            GLES20.glBindFramebuffer(36160, 0);
            return new int[]{r1[0], r3[0]};
        }

        public static int c(int r3, String r4) {
            int r0 = GLES20.glCreateShader(r3);
            if (r0 == 0) goto L8;
            GLES20.glShaderSource(r0, r4);
            GLES20.glCompileShader(r0);
            int[] r5 = new int[1];
            GLES20.glGetShaderiv(r0, 35713, r5, 0);
            if (r5[0] != 0) goto L9;
            Log.e("GL3BlurRenderer", "Could not compile shader " + r3 + ":");
            Log.e("GL3BlurRenderer", GLES20.glGetShaderInfoLog(r0));
            GLES20.glDeleteShader(r0);
            return 0;
        L9:
            return r0;
        L8:
            return r0;
        }

        public static void d(int r3, int r4, float r5, int r6, int r7) {
            GLES20.glViewport(0, 0, r6, r7);
            GLES20.glBindFramebuffer(36160, r4);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(0);
            GLES20.glUniform2f(0, r6, r7);
            GLES20.glUniform1f(0, r5);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, r3);
            GLES20.glUniform1i(0, 0);
            GLES30.glBindVertexArray(0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r4 == 0) goto L6;
            GLES20.glBindFramebuffer(36160, 0);
            return;
        }

        public static void e(int r2, int r3, float r4, int r5, int r6) {
            GLES20.glViewport(0, 0, r5, r6);
            GLES20.glBindFramebuffer(36160, r3);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(0);
            GLES20.glUniform2f(0, r5, r6);
            GLES20.glUniform1f(0, r4);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, r2);
            GLES20.glUniform1i(0, 0);
            GLES30.glBindVertexArray(0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES20.glBindFramebuffer(36160, 0);
        }

        public final void f(int r4, int r5, float r6, boolean r7) {
            GLES20.glViewport(0, 0, this.g, this.i);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(0);
            GLES20.glUniform2f(0, this.g, this.i);
            GLES20.glUniform1i(0, r7 ? 1 : 0);
            GLES20.glUniform1f(0, r6);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, r4);
            GLES20.glUniform1i(0, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, r5);
            GLES20.glUniform1i(0, 1);
            GLES30.glBindVertexArray(0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
        }

        public final void g(int r6, int r7) {
            if (r7 == 0) goto L5;
            GLES20.glViewport(0, 0, this.k, this.l);
            GLES20.glBindFramebuffer(36160, r7);
        L6:
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(this.f134a);
            if (r7 == 0) goto L9;
            GLES20.glUniform2f(this.c, this.k, this.l);
            GLES20.glUniform1i(this.f135d, 1);
        L10:
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, r6);
            GLES20.glUniform1i(this.b, 0);
            GLES30.glBindVertexArray(0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES20.glBindTexture(3553, 0);
            if (r7 == 0) goto L14;
            GLES20.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES20.glUniform2f(this.c, this.g, this.i);
            GLES20.glUniform1i(this.f135d, 0);
            goto L10
        L5:
            GLES20.glViewport(0, 0, this.g, this.i);
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r24) {
            int r1 = this.g;
            if (r1 == 0) goto L30;
            int r2 = this.i;
            if (r2 != 0) goto L8;
            return;
        L8:
            if (r1 == this.h) goto L10;
        L13:
            boolean r3 = true;
        L15:
            if (this.r == null) goto L23;
            int r4 = this.e;
            if (r4 == 0) goto L19;
            GLES20.glDeleteTextures(1, new int[]{r4}, 0);
        L19:
            int[] r5 = new int[1];
            GLES20.glGenTextures(1, r5, 0);
            int r6 = r5[0];
            if (r6 == 0) goto L22;
            GLES20.glBindTexture(3553, r6);
            GLUtils.texImage2D(3553, 0, null, 0);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindTexture(3553, 0);
        L22:
            this.e = r5[0];
            r3 = true;
        L23:
            if (r3 == false) goto L28;
            g(this.e, this.s);
            if (this.f != 0) goto L27;
            int r7 = this.k;
            int r8 = this.l;
            int[] r15 = new int[1];
            GLES20.glGenTextures(1, r15, 0);
            GLES20.glBindTexture(3553, r15[0]);
            GLES20.glTexImage2D(3553, 0, 6408, r7, r8, 0, 6408, 5121, null);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindTexture(3553, 0);
            this.f = r15[0];
        L27:
            GLES20.glBindFramebuffer(36160, this.s);
            GLES20.glBindTexture(3553, this.f);
            GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.k, this.l);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glBindTexture(3553, 0);
        L28:
            d(this.f, this.s, 1.0f, this.k, this.l);
            e(this.t, this.u, 1.0f, this.k, this.l);
            d(this.v, this.s, 1.0f, this.k, this.l);
            e(this.t, this.u, 1.0f, this.k, this.l);
            d(this.v, this.s, 1.0f, this.k, this.l);
            e(this.t, this.u, 1.0f, this.k, this.l);
            f(this.e, this.v, 0.0f, true);
            this.h = this.g;
            this.j = this.i;
            this.r = null;
            return;
        L10:
            if (r2 != this.j) goto L13;
            r3 = false;
            goto L15
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r4, int r5, int r6) {
            this.g = r5;
            this.i = r6;
            if (r5 == 0) goto L43;
            if (r6 != 0) goto L7;
            return;
        L7:
            if (r5 == this.h) goto L9;
        L11:
            int r7 = this.s;
            if (r7 == 0) goto L14;
            GLES20.glDeleteFramebuffers(1, new int[]{r7}, 0);
        L14:
            int r8 = this.t;
            if (r8 == 0) goto L17;
            GLES20.glDeleteTextures(1, new int[]{r8}, 0);
        L17:
            int r9 = this.u;
            if (r9 == 0) goto L20;
            GLES20.glDeleteFramebuffers(1, new int[]{r9}, 0);
        L20:
            int r10 = this.v;
            if (r10 == 0) goto L23;
            GLES20.glDeleteTextures(1, new int[]{r10}, 0);
        L23:
            int r11 = this.w;
            if (r11 == 0) goto L26;
            GLES20.glDeleteFramebuffers(1, new int[]{r11}, 0);
        L26:
            int r12 = this.x;
            if (r12 == 0) goto L29;
            GLES20.glDeleteTextures(1, new int[]{r12}, 0);
        L29:
            int r13 = this.y;
            if (r13 == 0) goto L32;
            GLES20.glDeleteFramebuffers(1, new int[]{r13}, 0);
        L32:
            int r14 = this.z;
            if (r14 == 0) goto L35;
            GLES20.glDeleteTextures(1, new int[]{r14}, 0);
        L35:
            int r15 = this.A;
            if (r15 == 0) goto L38;
            GLES20.glDeleteFramebuffers(1, new int[]{r15}, 0);
        L38:
            int r16 = this.B;
            if (r16 == 0) goto L41;
            GLES20.glDeleteTextures(1, new int[]{r16}, 0);
        L41:
            int r17 = this.g / 4;
            this.k = r17;
            int r0 = this.i / 4;
            this.l = r0;
            int[] r18 = b(r17, r0);
            this.s = r18[0];
            this.t = r18[1];
            int[] r19 = b(this.k, this.l);
            this.u = r19[0];
            this.v = r19[1];
            this.m = (int) Math.ceil(this.k / 2.0f);
            int r20 = (int) Math.ceil(this.l / 2.0f);
            this.n = r20;
            int[] r21 = b(this.m, r20);
            this.w = r21[0];
            this.x = r21[1];
            this.o = (int) Math.ceil(this.m / 2.0f);
            int r22 = (int) Math.ceil(this.n / 2.0f);
            this.p = r22;
            int[] r23 = b(this.o, r22);
            this.y = r23[0];
            this.z = r23[1];
            this.q = (int) Math.ceil(this.o / 2.0f);
            int[] r24 = b(this.q, (int) Math.ceil(this.p / 2.0f));
            this.A = r24[0];
            this.B = r24[1];
            return;
        L9:
            if (r6 != this.j) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r4, EGLConfig r5) {
            int r6 = c(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
            if (r6 == 0) goto L11;
            int r1 = c(35632, "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
            if (r1 == 0) goto L11;
            int r2 = GLES20.glCreateProgram();
            if (r2 == 0) goto L12;
            GLES20.glAttachShader(r2, r6);
            a("glAttachShader");
            GLES20.glAttachShader(r2, r1);
            a("glAttachShader");
            GLES20.glLinkProgram(r2);
            int[] r7 = new int[1];
            GLES20.glGetProgramiv(r2, 35714, r7, 0);
            if (r7[0] == 1) goto L12;
            Log.e("GL3BlurRenderer", "Could not link program: ");
            Log.e("GL3BlurRenderer", GLES20.glGetProgramInfoLog(r2));
            GLES20.glDeleteProgram(r2);
        L12:
            this.f134a = r2;
            GLES20.glGetAttribLocation(r2, "vPosition");
            a("glGetAttribLocation");
            this.b = GLES20.glGetUniformLocation(this.f134a, "u_background");
            a("glGetAttribLocation");
            this.c = GLES20.glGetUniformLocation(this.f134a, "u_resolution");
            a("glGetUniformLocation");
            this.f135d = GLES20.glGetUniformLocation(this.f134a, "u_revert");
            a("glGetUniformLocation");
            GLES20.glUseProgram(this.f134a);
            int[] r3 = new int[1];
            GLES30.glGenVertexArrays(1, r3, 0);
            GLES30.glBindVertexArray(r3[0]);
            int[] r8 = new int[1];
            GLES20.glGenBuffers(1, r8, 0);
            GLES20.glBindBuffer(34962, r8[0]);
            throw null;
        L11:
            r2 = 0;
            goto L12
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r1) {
        throw null;
    }

    public void setBlurRadius(float r1) {
        throw null;
    }
}
