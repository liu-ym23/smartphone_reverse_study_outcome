package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import com.obric.common.oea.foundation.animation.engine.FloatValueHolder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes4.dex */
public class GL3ShaderViewFog extends GLSurfaceView implements Choreographer.FrameCallback {
    private static String TAG = "GL2ShaderView";
    private Renderer mRenderer;

    private static class Renderer implements GLSurfaceView.Renderer {
        private int mAlphaHandle;
        private FloatValueHolder mAlphaValue;
        private Bitmap mBackgroundImage;
        private int mColorHandle;
        private int mColorValue;
        private Context mContext;
        private int mFBOId;
        private int mFBOPositionHandle;
        private int mFBOProgram;
        private int mFBOResolutionHandle;
        private int mFBOTextureHandle;
        private int mFBOTextureId;
        private final String mFragmentShaderFbo;
        private final String mFragmentShaderRain;
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

        static /* synthetic */ int access$302(Renderer r0, int r1) {
            r0.mColorValue = r1;
            return r1;
        }

        public Renderer(Context r4) {
            this.mVertexShader = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.mFragmentShaderFbo = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.mFragmentShaderRain = "#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.mLastAlpha = -1.0f;
            this.mLastIntensity = -1.0f;
            this.mLastSpeed = -1.0f;
            this.mLastColor = 0;
            this.mWidth = 0;
            this.mLastWidth = 0;
            this.mHeight = 0;
            this.mLastHeight = 0;
            this.mAlphaValue = new FloatValueHolder(1.0f);
            this.mIntensityValue = new FloatValueHolder(0.8f);
            this.mSpeedValue = new FloatValueHolder(0.5f);
            this.mColorValue = -3618616;
            float[] r1 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.mTriangleVerticesData = r1;
            this.mFBOProgram = 0;
            this.mFBOId = 0;
            this.mFBOTextureId = 0;
            this.mContext = r4;
            FloatBuffer r5 = ByteBuffer.allocateDirect(r1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r1);
            this.mVertexBuffer = r5;
            r5.position(0);
        }

        public void setBackgroundImage(Bitmap r1) {
            this.mBackgroundImage = r1;
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
            GLES30.glTexParameteri(3553, 10240, 9729);
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
            int r10 = this.mColorValue;
            if (r10 == this.mLastColor) goto L24;
            this.mLastColor = r10;
            GLES30.glUniform3f(this.mColorHandle, Color.red(r10) / 255.0f, Color.green(this.mLastColor) / 255.0f, Color.blue(this.mLastColor) / 255.0f);
        L24:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.mTextureId);
            GLES30.glUniform1i(this.mTextureBgHandle, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.mFBOTextureId);
            GLES30.glUniform1i(this.mTextureHandle, 1);
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
            int r10 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
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
            this.mResolutionHandle = GLES30.glGetUniformLocation(this.mProgram, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mColorHandle = GLES30.glGetUniformLocation(this.mProgram, "u_color");
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
            Log.e(GL3ShaderViewFog.access$400(), "Could not compile shader " + r4 + ":");
            Log.e(GL3ShaderViewFog.access$400(), GLES30.glGetShaderInfoLog(r3));
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
            Log.e(GL3ShaderViewFog.access$400(), "Could not link program: ");
            Log.e(GL3ShaderViewFog.access$400(), GLES30.glGetProgramInfoLog(r1));
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
            Log.e(GL3ShaderViewFog.access$400(), r4 + ": glError " + r3);
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
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r5, 0);
            GLES30.glBindTexture(3553, 0);
            r5.recycle();
        L6:
            return r0[0];
        }
    }

    static {
    }

    static /* synthetic */ String access$400() {
        return TAG;
    }

    public GL3ShaderViewFog(Context r2) {
        super(r2, null);
    }

    public GL3ShaderViewFog(Context r1, AttributeSet r2) {
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

    public void setShaderAlpha(float r1) {
        Renderer.access$000(this.mRenderer).setValue(r1);
    }

    public void setShaderIntensity(float r1) {
        Renderer.access$100(this.mRenderer).setValue(r1);
    }

    public void setShaderSpeed(float r1) {
        Renderer.access$200(this.mRenderer).setValue(r1);
    }

    public void setShaderColor(int r1) {
        Renderer.access$302(this.mRenderer, r1);
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
