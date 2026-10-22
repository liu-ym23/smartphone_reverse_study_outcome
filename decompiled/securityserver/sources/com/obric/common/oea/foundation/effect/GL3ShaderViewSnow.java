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
public class GL3ShaderViewSnow extends GLSurfaceView implements Choreographer.FrameCallback {
    public static final /* synthetic */ int b = 0;

    public static class Renderer implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f140a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f141d;
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
            int r1 = GL3ShaderViewSnow.b;
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
            int r6 = GL3ShaderViewSnow.b;
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
            int r6 = GL3ShaderViewSnow.b;
            Log.e("GL2ShaderView", "Could not compile shader " + r3 + ":");
            Log.e("GL2ShaderView", GLES20.glGetShaderInfoLog(r0));
            GLES20.glDeleteShader(r0);
            return 0;
        L9:
            return r0;
        L8:
            return r0;
        }

        public static int d() {
            int[] r1 = new int[1];
            GLES20.glGenTextures(1, r1, 0);
            int r0 = r1[0];
            if (r0 != 0) goto L5;
            return r0;
        L5:
            GLES20.glBindTexture(3553, r0);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, null, 0);
            GLES20.glBindTexture(3553, 0);
            throw null;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r15) {
            if (this.e != this.f) goto L7;
            if (this.g != this.h) goto L7;
        L16:
            long r3 = System.currentTimeMillis();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUseProgram(this.f140a);
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
            GLES20.glBindTexture(3553, this.f141d);
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
        public final void onSurfaceCreated(GL10 r2, EGLConfig r3) {
            int r4 = b("#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f140a = r4;
            if (r4 != 0) goto L5;
            return;
        L5:
            GLES20.glGetAttribLocation(r4, "vPosition");
            a("glGetAttribLocation");
            GLES20.glGetUniformLocation(this.f140a, "u_background");
            a("glGetAttribLocation");
            GLES20.glGetUniformLocation(this.f140a, "u_prepass");
            a("glGetAttribLocation");
            GLES20.glGetUniformLocation(this.f140a, "u_frostTex");
            a("glGetAttribLocation");
            this.b = GLES20.glGetUniformLocation(this.f140a, "u_resolution");
            a("glGetUniformLocation");
            this.c = GLES20.glGetUniformLocation(this.f140a, "u_time");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f140a, "u_alpha");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f140a, "u_intensity");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f140a, "u_speed");
            a("glGetUniformLocation");
            GLES20.glUseProgram(this.f140a);
            this.f141d = d();
            d();
            int[] r5 = new int[1];
            GLES30.glGenVertexArrays(1, r5, 0);
            GLES30.glBindVertexArray(r5[0]);
            int[] r6 = new int[1];
            GLES20.glGenBuffers(1, r6, 0);
            GLES20.glBindBuffer(34962, r6[0]);
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

    public void setFrostImage(Bitmap r1) {
        throw null;
    }

    public void setShaderAlpha(float r1) {
        throw null;
    }

    public void setShaderIntensity(float r1) {
        throw null;
    }

    public void setShaderSpeed(float r1) {
        throw null;
    }
}
