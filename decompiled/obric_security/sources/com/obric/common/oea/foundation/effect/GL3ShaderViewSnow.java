package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import androidx.work.Data;
import com.obric.common.oea.foundation.animation.engine.FloatValueHolder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewSnow extends GLSurfaceView implements Choreographer.FrameCallback {
    private static String TAG = "GL2ShaderView";
    private Renderer mRenderer;

    private static class Renderer implements GLSurfaceView.Renderer {
        private int mAlphaHandle;
        private FloatValueHolder mAlphaValue;
        private Bitmap mBackgroundImage;
        private Context mContext;
        private int mFBOId;
        private int mFBOPositionHandle;
        private int mFBOProgram;
        private int mFBOResolutionHandle;
        private int mFBOTextureHandle;
        private int mFBOTextureId;
        private final String mFragmentShaderFbo;
        private final String mFragmentShaderRain;
        private Bitmap mFrostImage;
        private int mFrostTextureId;
        private int mHeight;
        private int mIntensityHandle;
        private FloatValueHolder mIntensityValue;
        private float mLastAlpha;
        private int mLastColor;
        private int mLastHeight;
        private float mLastIntensity;
        private float mLastSpeed;
        private int mLastWidth;
        private int mProgram;
        private int mResolutionHandle;
        private int mSpeedHandle;
        private FloatValueHolder mSpeedValue;
        private int mTextureBgHandle;
        private int mTextureFrostHandle;
        private int mTextureHandle;
        private int mTextureId;
        private int mTimeHandle;
        private final float[] mTriangleVerticesData;
        private int mVAOId;
        private int mVBOId;
        private FloatBuffer mVertexBuffer;
        private final String mVertexShader;
        private int mWidth;
        private int mvPositionHandle;

        static /* synthetic */ FloatValueHolder access$000(Renderer r0) {
            return r0.mAlphaValue;
        }

        static /* synthetic */ FloatValueHolder access$100(Renderer r0) {
            return r0.mIntensityValue;
        }

        static /* synthetic */ FloatValueHolder access$200(Renderer r0) {
            return r0.mSpeedValue;
        }

        public Renderer(Context r5) {
            this.mVertexShader = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.mFragmentShaderFbo = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.mFragmentShaderRain = "#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.mLastAlpha = -1.0f;
            this.mLastIntensity = -1.0f;
            this.mLastSpeed = -1.0f;
            this.mLastColor = 0;
            this.mWidth = 0;
            this.mLastWidth = 0;
            this.mHeight = 0;
            this.mLastHeight = 0;
            this.mAlphaValue = new FloatValueHolder(1.0f);
            this.mIntensityValue = new FloatValueHolder(0.5f);
            this.mSpeedValue = new FloatValueHolder(1.0f);
            float[] r1 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.mTriangleVerticesData = r1;
            this.mFBOProgram = 0;
            this.mFBOId = 0;
            this.mFBOTextureId = 0;
            this.mContext = r5;
            FloatBuffer r6 = ByteBuffer.allocateDirect(r1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r1);
            this.mVertexBuffer = r6;
            r6.position(0);
        }

        public void setBackgroundImage(Bitmap r1) {
            this.mBackgroundImage = r1;
        }

        public void setFrostImage(Bitmap r1) {
            this.mFrostImage = r1;
        }

        private void initFBO() {
            if (this.mFBOProgram != 0) goto L5;
            int r0 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.mFBOProgram = r0;
            this.mFBOPositionHandle = GLES30.glGetAttribLocation(r0, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mFBOTextureHandle = GLES30.glGetUniformLocation(this.mFBOProgram, "u_background");
            checkGlError("glGetAttribLocation");
            this.mFBOResolutionHandle = GLES30.glGetUniformLocation(this.mFBOProgram, "u_resolution");
            checkGlError("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.mFBOProgram);
            if (this.mFBOId != 0) goto L8;
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            this.mFBOId = r1[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.mFBOId);
            if (this.mFBOTextureId != 0) goto L11;
            int[] r2 = new int[1];
            GLES30.glGenTextures(1, r2, 0);
            this.mFBOTextureId = r2[0];
        L11:
            GLES30.glBindTexture(3553, this.mFBOTextureId);
            GLES30.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.mFBOTextureId, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        private void renderFBO() {
            GLES30.glBindFramebuffer(36160, this.mFBOId);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mFBOProgram);
            GLES30.glUniform2f(this.mFBOResolutionHandle, this.mWidth, this.mHeight);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.mTextureId);
            GLES30.glUniform1i(this.mFBOTextureHandle, 0);
            GLES30.glEnableVertexAttribArray(this.mFBOPositionHandle);
            GLES30.glVertexAttribPointer(this.mFBOPositionHandle, 2, 5126, false, 0, this.mVertexBuffer);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.mFBOTextureId);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r5) {
            if (this.mWidth == this.mLastWidth) goto L5;
        L6:
            initFBO();
            renderFBO();
        L7:
            long r0 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgram);
            GLES30.glUniform1f(this.mTimeHandle, (r0 % 1000000) / 1000.0f);
            int r6 = this.mWidth;
            if (r6 == this.mLastWidth) goto L10;
        L11:
            this.mLastWidth = r6;
            int r1 = this.mHeight;
            this.mLastHeight = r1;
            GLES30.glUniform2f(this.mResolutionHandle, r6, r1);
        L13:
            if (this.mAlphaValue.getValue() == this.mLastAlpha) goto L16;
            float r7 = this.mAlphaValue.getValue();
            this.mLastAlpha = r7;
            GLES30.glUniform1f(this.mAlphaHandle, r7);
        L16:
            if (this.mIntensityValue.getValue() == this.mLastIntensity) goto L19;
            float r8 = this.mIntensityValue.getValue();
            this.mLastIntensity = r8;
            GLES30.glUniform1f(this.mIntensityHandle, r8);
        L19:
            if (this.mSpeedValue.getValue() == this.mLastSpeed) goto L21;
            float r9 = this.mSpeedValue.getValue();
            this.mLastSpeed = r9;
            GLES30.glUniform1f(this.mSpeedHandle, r9);
        L21:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.mTextureId);
            GLES30.glUniform1i(this.mTextureBgHandle, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.mFBOTextureId);
            GLES30.glUniform1i(this.mTextureHandle, 1);
            GLES30.glActiveTexture(33986);
            GLES30.glBindTexture(3553, this.mFrostTextureId);
            GLES30.glUniform1i(this.mTextureFrostHandle, 2);
            GLES30.glBindVertexArray(this.mVAOId);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.mHeight == this.mLastHeight) goto L13;
        L5:
            if (this.mHeight == this.mLastHeight) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r1, int r2, int r3) {
            this.mWidth = r2;
            this.mHeight = r3;
            GLES30.glViewport(0, 0, r2, r3);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r8, EGLConfig r9) {
            int r10 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.mProgram = r10;
            if (r10 != 0) goto L5;
            return;
        L5:
            this.mvPositionHandle = GLES30.glGetAttribLocation(r10, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureBgHandle = GLES30.glGetUniformLocation(this.mProgram, "u_background");
            checkGlError("glGetAttribLocation");
            this.mTextureHandle = GLES30.glGetUniformLocation(this.mProgram, "u_prepass");
            checkGlError("glGetAttribLocation");
            this.mTextureFrostHandle = GLES30.glGetUniformLocation(this.mProgram, "u_frostTex");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandle = GLES30.glGetUniformLocation(this.mProgram, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mTimeHandle = GLES30.glGetUniformLocation(this.mProgram, "u_time");
            checkGlError("glGetUniformLocation");
            this.mAlphaHandle = GLES30.glGetUniformLocation(this.mProgram, "u_alpha");
            checkGlError("glGetUniformLocation");
            this.mIntensityHandle = GLES30.glGetUniformLocation(this.mProgram, "u_intensity");
            checkGlError("glGetUniformLocation");
            this.mSpeedHandle = GLES30.glGetUniformLocation(this.mProgram, "u_speed");
            checkGlError("glGetUniformLocation");
            GLES30.glUseProgram(this.mProgram);
            this.mTextureId = loadTexture(this.mContext, this.mBackgroundImage);
            this.mFrostTextureId = loadTexture(this.mContext, this.mFrostImage);
            int[] r11 = new int[1];
            GLES30.glGenVertexArrays(1, r11, 0);
            int r12 = r11[0];
            this.mVAOId = r12;
            GLES30.glBindVertexArray(r12);
            int[] r13 = new int[1];
            GLES30.glGenBuffers(1, r13, 0);
            int r14 = r13[0];
            this.mVBOId = r14;
            GLES30.glBindBuffer(34962, r14);
            GLES30.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mVertexBuffer, 35044);
            GLES30.glEnableVertexAttribArray(this.mvPositionHandle);
            GLES30.glVertexAttribPointer(this.mvPositionHandle, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }

        private int loadShader(int r4, String r5) {
            int r3 = GLES30.glCreateShader(r4);
            if (r3 == 0) goto L8;
            GLES30.glShaderSource(r3, r5);
            GLES30.glCompileShader(r3);
            int[] r6 = new int[1];
            GLES30.glGetShaderiv(r3, 35713, r6, 0);
            if (r6[0] != 0) goto L9;
            Log.e(GL3ShaderViewSnow.access$300(), "Could not compile shader " + r4 + ":");
            Log.e(GL3ShaderViewSnow.access$300(), GLES30.glGetShaderInfoLog(r3));
            GLES30.glDeleteShader(r3);
            return 0;
        L9:
            return r3;
        L8:
            return r3;
        }

        private int createProgram(String r3, String r4) {
            int r5 = loadShader(35633, r3);
            if (r5 != 0) goto L5;
            return 0;
        L5:
            int r6 = loadShader(35632, r4);
            if (r6 != 0) goto L8;
            return 0;
        L8:
            int r1 = GLES30.glCreateProgram();
            if (r1 == 0) goto L14;
            GLES30.glAttachShader(r1, r5);
            checkGlError("glAttachShader");
            GLES30.glAttachShader(r1, r6);
            checkGlError("glAttachShader");
            GLES30.glLinkProgram(r1);
            int[] r7 = new int[1];
            GLES30.glGetProgramiv(r1, 35714, r7, 0);
            if (r7[0] == 1) goto L14;
            Log.e(GL3ShaderViewSnow.access$300(), "Could not link program: ");
            Log.e(GL3ShaderViewSnow.access$300(), GLES30.glGetProgramInfoLog(r1));
            GLES30.glDeleteProgram(r1);
            return 0;
        L14:
            return r1;
        }

        private void checkGlError(String r4) {
            int r3 = GLES30.glGetError();
            if (r3 != 0) goto L5;
            return;
        L5:
            Log.e(GL3ShaderViewSnow.access$300(), r4 + ": glError " + r3);
            throw new RuntimeException(r4 + ": glError " + r3);
        }

        private static int loadTexture(Context r4, Bitmap r5) {
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            int r6 = r0[0];
            if (r6 == 0) goto L6;
            GLES30.glBindTexture(3553, r6);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLUtils.texImage2D(3553, 0, r5, 0);
            GLES30.glBindTexture(3553, 0);
            r5.recycle();
        L6:
            return r0[0];
        }
    }

    static {
    }

    static /* synthetic */ String access$300() {
        return TAG;
    }

    public GL3ShaderViewSnow(Context r2) {
        super(r2, null);
    }

    public GL3ShaderViewSnow(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        Renderer r0 = new Renderer(getContext());
        this.mRenderer = r0;
        setRenderer(r0);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }

    public void setBackgroundImage(Bitmap r1) {
        this.mRenderer.setBackgroundImage(r1);
    }

    public void setFrostImage(Bitmap r1) {
        this.mRenderer.setFrostImage(r1);
    }

    public void setShaderAlpha(float r1) {
        Renderer.access$000(this.mRenderer).setValue(r1);
    }

    public void setShaderIntensity(float r1) {
        Renderer.access$100(this.mRenderer).setValue(r1);
    }

    public void setShaderSpeed(float r1) {
        Renderer.access$200(this.mRenderer).setValue(r1);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }
}
