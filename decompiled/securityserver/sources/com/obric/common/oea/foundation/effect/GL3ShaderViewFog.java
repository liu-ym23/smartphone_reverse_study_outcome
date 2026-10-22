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
public class GL3ShaderViewFog extends GLSurfaceView implements Choreographer.FrameCallback {
    public static final /* synthetic */ int b = 0;

    public static class Renderer implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f132a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f133d;
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

        public static void a(String r4) {
            int r0 = GLES20.glGetError();
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = GL3ShaderViewFog.b;
            Log.e("GL2ShaderView", r4 + ": glError " + r0);
            throw new RuntimeException(r4 + ": glError " + r0);
        }

        public static int b(String r4) {
            int r0 = c(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
            if (r0 != 0) goto L5;
            return 0;
        L5:
            int r5 = c(35632, r4);
            if (r5 != 0) goto L8;
            return 0;
        L8:
            int r2 = GLES20.glCreateProgram();
            if (r2 == 0) goto L14;
            GLES20.glAttachShader(r2, r0);
            a("glAttachShader");
            GLES20.glAttachShader(r2, r5);
            a("glAttachShader");
            GLES20.glLinkProgram(r2);
            int[] r1 = new int[1];
            GLES20.glGetProgramiv(r2, 35714, r1, 0);
            if (r1[0] == 1) goto L14;
            int r6 = GL3ShaderViewFog.b;
            Log.e("GL2ShaderView", "Could not link program: ");
            Log.e("GL2ShaderView", GLES20.glGetProgramInfoLog(r2));
            GLES20.glDeleteProgram(r2);
            return 0;
        L14:
            return r2;
        }

        public static int c(int r3, String r4) {
            int r0 = GLES20.glCreateShader(r3);
            if (r0 == 0) goto L8;
            GLES20.glShaderSource(r0, r4);
            GLES20.glCompileShader(r0);
            int[] r5 = new int[1];
            GLES20.glGetShaderiv(r0, 35713, r5, 0);
            if (r5[0] != 0) goto L9;
            int r6 = GL3ShaderViewFog.b;
            Log.e("GL2ShaderView", "Could not compile shader " + r3 + ":");
            Log.e("GL2ShaderView", GLES20.glGetShaderInfoLog(r0));
            GLES20.glDeleteShader(r0);
            return 0;
        L9:
            return r0;
        L8:
            return r0;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r15) {
            if (this.e != this.f) goto L7;
            if (this.g != this.h) goto L7;
        L16:
            long r3 = System.currentTimeMillis();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(this.f132a);
            GLES20.glUniform1f(this.c, (r3 % 1000000) / 1000.0f);
            int r16 = this.e;
            if (r16 == this.f) goto L19;
        L20:
            this.f = r16;
            int r0 = this.g;
            this.h = r0;
            GLES20.glUniform2f(this.b, r16, r0);
        L22:
            throw null;
        L19:
            if (this.g == this.h) goto L22;
        L7:
            if (this.i != 0) goto L9;
            int r17 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.i = r17;
            this.j = GLES20.glGetAttribLocation(r17, "vPosition");
            a("glGetAttribLocation");
            this.k = GLES20.glGetUniformLocation(this.i, "u_background");
            a("glGetAttribLocation");
            this.l = GLES20.glGetUniformLocation(this.i, "u_resolution");
            a("glGetUniformLocation");
        L9:
            GLES20.glUseProgram(this.i);
            if (this.m != 0) goto L12;
            int[] r18 = new int[1];
            GLES20.glGenFramebuffers(1, r18, 0);
            this.m = r18[0];
        L12:
            GLES20.glBindFramebuffer(36160, this.m);
            if (this.n != 0) goto L15;
            int[] r19 = new int[1];
            GLES20.glGenTextures(1, r19, 0);
            this.n = r19[0];
        L15:
            GLES20.glBindTexture(3553, this.n);
            GLES20.glTexImage2D(3553, 0, 6408, this.e, this.g, 0, 6408, 5121, null);
            GLES20.glTexParameteri(3553, 10241, 9987);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glUseProgram(0);
            GLES20.glBindFramebuffer(36160, this.m);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(this.i);
            GLES20.glUniform2f(this.l, this.e, this.g);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.f133d);
            GLES20.glUniform1i(this.k, 0);
            GLES20.glEnableVertexAttribArray(this.j);
            GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, null);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glBindTexture(3553, this.n);
            GLES20.glGenerateMipmap(3553);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            goto L16
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r1, int r2, int r3) {
            this.e = r2;
            this.g = r3;
            GLES20.glViewport(0, 0, r2, r3);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r3, EGLConfig r4) {
            int r5 = b("#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f132a = r5;
            if (r5 != 0) goto L5;
            return;
        L5:
            GLES20.glGetAttribLocation(r5, "vPosition");
            a("glGetAttribLocation");
            GLES20.glGetUniformLocation(this.f132a, "u_background");
            a("glGetAttribLocation");
            GLES20.glGetUniformLocation(this.f132a, "u_prepass");
            a("glGetAttribLocation");
            this.b = GLES20.glGetUniformLocation(this.f132a, "u_resolution");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f132a, "u_color");
            a("glGetUniformLocation");
            this.c = GLES20.glGetUniformLocation(this.f132a, "u_time");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f132a, "u_alpha");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f132a, "u_intensity");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f132a, "u_speed");
            a("glGetUniformLocation");
            GLES20.glUseProgram(this.f132a);
            int[] r6 = new int[1];
            GLES20.glGenTextures(1, r6, 0);
            int r7 = r6[0];
            if (r7 == 0) goto L9;
            GLES20.glBindTexture(3553, r7);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, null, 0);
            GLES20.glBindTexture(3553, 0);
            throw null;
        L9:
            this.f133d = r7;
            int[] r2 = new int[1];
            GLES30.glGenVertexArrays(1, r2, 0);
            GLES30.glBindVertexArray(r2[0]);
            int[] r8 = new int[1];
            GLES20.glGenBuffers(1, r8, 0);
            GLES20.glBindBuffer(34962, r8[0]);
            throw null;
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

    public void setShaderAlpha(float r1) {
        throw null;
    }

    public void setShaderColor(int r1) {
        throw null;
    }

    public void setShaderIntensity(float r1) {
        throw null;
    }

    public void setShaderSpeed(float r1) {
        throw null;
    }
}
