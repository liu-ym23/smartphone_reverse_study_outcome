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
public class GL3ShaderViewRain extends GLSurfaceView implements Choreographer.FrameCallback {
    public static final /* synthetic */ int b = 0;

    public static class Renderer implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f138a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f139d;
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
            int r1 = GL3ShaderViewRain.b;
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
            int r6 = GL3ShaderViewRain.b;
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
            int r6 = GL3ShaderViewRain.b;
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
            GLES20.glUseProgram(this.f138a);
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
            GLES20.glBindTexture(3553, this.f139d);
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
            int r5 = b("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f138a = r5;
            if (r5 != 0) goto L5;
            return;
        L5:
            GLES20.glGetAttribLocation(r5, "vPosition");
            a("glGetAttribLocation");
            GLES20.glGetUniformLocation(this.f138a, "u_background");
            a("glGetAttribLocation");
            GLES20.glGetUniformLocation(this.f138a, "u_prepass");
            a("glGetAttribLocation");
            this.b = GLES20.glGetUniformLocation(this.f138a, "u_resolution");
            a("glGetUniformLocation");
            this.c = GLES20.glGetUniformLocation(this.f138a, "u_time");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f138a, "u_alpha");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f138a, "u_intensity");
            a("glGetUniformLocation");
            GLES20.glGetUniformLocation(this.f138a, "u_speed");
            a("glGetUniformLocation");
            GLES20.glUseProgram(this.f138a);
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
            this.f139d = r7;
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

    public void setShaderIntensity(float r1) {
        throw null;
    }

    public void setShaderSpeed(float r1) {
        throw null;
    }
}
