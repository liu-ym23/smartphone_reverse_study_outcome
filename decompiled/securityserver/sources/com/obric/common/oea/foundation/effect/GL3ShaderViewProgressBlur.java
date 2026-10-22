package com.obric.common.oea.foundation.effect;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.Choreographer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    public class Renderer implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f136a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f137d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public static void a(String r4) {
            int r0 = GLES20.glGetError();
            if (r0 != 0) goto L5;
            return;
        L5:
            Log.e("GL3BlurRenderer", r4 + ": glError " + r0);
            throw new RuntimeException(r4 + ": glError " + r0);
        }

        public static int b(int r3, String r4) {
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

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r8) {
            int r9 = this.f;
            if (r9 == 0) goto L15;
            int r0 = this.g;
            if (r0 == 0) goto L16;
            int r2 = this.h;
            GLES20.glViewport(0, 0, r9, r0);
            if (r2 == 0) goto L10;
            GLES20.glBindFramebuffer(36160, r2);
        L10:
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(this.f136a);
            GLES20.glUniform2f(this.c, this.f, this.g);
            GLES20.glUniform1i(this.f137d, 1);
            GLES20.glUniform2f(this.e, 0.0f, 0.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUniform1i(this.b, 0);
            GLES30.glBindVertexArray(0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES20.glBindTexture(3553, 0);
            if (r2 == 0) goto L14;
            GLES20.glBindFramebuffer(36160, 0);
        L14:
            throw null;
        L16:
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r13, int r14, int r15) {
            this.f = r14;
            this.g = r15;
            if (r14 == 0) goto L17;
            if (r15 == 0) goto L18;
            if (r14 != 0) goto L9;
            if (r15 != 0) goto L9;
            return;
        L9:
            int r16 = this.h;
            if (r16 == 0) goto L12;
            GLES20.glDeleteFramebuffers(1, new int[]{r16}, 0);
        L12:
            int r17 = this.i;
            if (r17 == 0) goto L15;
            GLES20.glDeleteTextures(1, new int[]{r17}, 0);
        L15:
            int r3 = this.f;
            int r4 = this.g;
            int[] r18 = new int[1];
            GLES20.glGenFramebuffers(1, r18, 0);
            GLES20.glBindFramebuffer(36160, r18[0]);
            int[] r10 = new int[1];
            GLES20.glGenTextures(1, r10, 0);
            GLES20.glBindTexture(3553, r10[0]);
            GLES20.glTexImage2D(3553, 0, 6408, r3, r4, 0, 6408, 5121, null);
            GLES20.glTexParameteri(3553, 10242, 33648);
            GLES20.glTexParameteri(3553, 10243, 33648);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, r10[0], 0);
            GLES20.glBindFramebuffer(36160, 0);
            int[] r19 = {r18[0], r10[0]};
            this.h = r19[0];
            this.i = r19[1];
            throw null;
        L18:
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r4, EGLConfig r5) {
            int r6 = b(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
            if (r6 == 0) goto L11;
            int r1 = b(35632, "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
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
            this.f136a = r2;
            GLES20.glGetAttribLocation(r2, "vPosition");
            a("glGetAttribLocation");
            this.b = GLES20.glGetUniformLocation(this.f136a, "u_background");
            a("glGetAttribLocation");
            this.c = GLES20.glGetUniformLocation(this.f136a, "u_resolution");
            a("glGetUniformLocation");
            this.f137d = GLES20.glGetUniformLocation(this.f136a, "u_revert");
            a("glGetUniformLocation");
            this.e = GLES20.glGetUniformLocation(this.f136a, "u_uvOffset");
            a("glGetUniformLocation");
            GLES20.glUseProgram(this.f136a);
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

    public void setClipRect(Rect r1) {
        throw null;
    }

    public void setDirection(int r1) {
        throw null;
    }
}
