package xp;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.Intrinsics;
import zp.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f23195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FloatBuffer f23196c;
    public final float[] d;
    public final float[] e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f23197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f23199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f23200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f23201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f23202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SurfaceTexture f23203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f23204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScaleType f23205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f23206q;

    /* JADX WARN: Multi-variable type inference failed */
    public c(k r5) {
        Intrinsics.checkNotNullParameter(r5, "alphaVideoView");
        this.f23206q = (View) r5;
        this.f23194a = 20;
        this.f23195b = new float[]{-1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.d = new float[16];
        float[] r10 = new float[16];
        this.e = r10;
        this.f23201l = new AtomicBoolean(false);
        this.f23202m = new AtomicBoolean(false);
        this.f23205p = ScaleType.ScaleAspectFill;
        FloatBuffer r11 = ByteBuffer.allocateDirect(this.f23195b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f23196c = r11;
        r11.put(this.f23195b).position(0);
        Matrix.setIdentityM(r10, 0);
    }

    public static void a(String r5) {
        int r10 = GLES20.glGetError();
        if (r10 == 0) goto L6;
        Log.e("VideoRender", r5 + ": glError " + r10);
        return;
    }

    public static int b(int r5, String r10) {
        int r11 = GLES20.glCreateShader(r5);
        if (r11 == 0) goto L8;
        GLES20.glShaderSource(r11, r10);
        GLES20.glCompileShader(r11);
        int[] r12 = new int[1];
        GLES20.glGetShaderiv(r11, 35713, r12, 0);
        if (r12[0] != 0) goto L9;
        Log.e("VideoRender", "Could not compile shader " + r5 + ':');
        Log.e("VideoRender", GLES20.glGetShaderInfoLog(r11));
        GLES20.glDeleteShader(r11);
        return 0;
    L9:
        return r11;
    L8:
        return r11;
    }

    public final void c(float r10, float r11, float r12, float r13) {
        float r5 = 0;
        if (r10 > r5) goto L5;
        return;
    L5:
        if (r11 > r5) goto L7;
        return;
    L7:
        if (r12 > r5) goto L9;
        return;
    L9:
        if (r13 <= r5) goto L36;
        ScaleType r14 = this.f23205p;
        float r15 = r10 / r11;
        float r16 = r12 / r13;
        float r17 = 0.0f;
        if (r15 <= r16) goto L14;
        float r18 = (1.0f - (r11 / (r10 / r16))) / 2.0f;
        float r19 = 0.0f;
    L16:
        switch(yp.a.f23315a[r14.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L17;
        };
    L17:
        float[] r110 = f4.a.h(0.0f, 0.0f, 0.0f, 0.0f);
    L31:
        this.f23195b = r110;
        FloatBuffer r111 = ByteBuffer.allocateDirect(r110.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f23196c = r111;
        r111.put(this.f23195b).position(0);
        return;
    L18:
        r110 = f4.a.j(((1.0f - ((r11 * r16) / r10)) / 2.0f) * 2.0f, 0.0f, 0.0f, 0.0f);
        goto L31
    L19:
        r110 = f4.a.j(0.0f, 0.0f, ((1.0f - ((r11 * r16) / r10)) / 2.0f) * 2.0f, 0.0f);
        goto L31
    L20:
        r110 = f4.a.j(0.0f, ((1.0f - ((r10 / r16) / r11)) / 2.0f) * 2.0f, 0.0f, 0.0f);
        goto L31
    L21:
        r110 = f4.a.j(0.0f, 0.0f, 0.0f, ((1.0f - ((r10 / r16) / r11)) / 2.0f) * 2.0f);
        goto L31
    L22:
        r110 = f4.a.h(r19 * 2.0f, r18, 0.0f, r18);
        goto L31
    L23:
        r110 = f4.a.h(0.0f, r18, r19 * 2.0f, r18);
        goto L31
    L24:
        r110 = f4.a.h(r19, r18 * 2.0f, r19, 0.0f);
        goto L31
    L25:
        r110 = f4.a.h(r19, 0.0f, r19, r18 * 2.0f);
        goto L31
    L26:
        r110 = f4.a.h(r19, r18, r19, r18);
        goto L31
    L27:
        if (r15 <= r16) goto L29;
        r17 = (1.0f - ((r11 * r16) / r10)) / 2.0f;
        float r20 = 0.0f;
    L30:
        r110 = f4.a.j(r17, r20, r17, r20);
        goto L31
    L29:
        r20 = (1.0f - ((r10 / r16) / r11)) / 2.0f;
        goto L30
    L14:
        r19 = (1.0f - (r10 / (r11 * r16))) / 2.0f;
        r18 = 0.0f;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, zp.k] */
    public final void d() {
        AtomicBoolean r5 = this.f23201l;
        r5.compareAndSet(true, false);
        Log.i("VideoRender", "onCompletion:   canDraw = " + r5.get());
        this.f23206q.requestRender();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, zp.k] */
    public final void e() {
        AtomicBoolean r5 = this.f23201l;
        r5.compareAndSet(false, true);
        Log.i("VideoRender", "onFirstFrame:    canDraw = " + r5.get());
        this.f23206q.requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r11) {
        Intrinsics.checkNotNullParameter(r11, "glUnused");
        boolean r12 = this.f23202m.compareAndSet(true, false);
        float[] r5 = this.e;
        if (r12 == true) goto L22;
    L16:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.f23201l.get() == true) goto L20;
        GLES20.glFinish();
        return;
    L20:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(this.f);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.g);
        this.f23196c.position(0);
        int r10 = this.f23199j;
        FloatBuffer r13 = this.f23196c;
        GLES20.glVertexAttribPointer(r10, 3, 5126, false, this.f23194a, r13);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f23199j);
        a("glEnableVertexAttribArray aPositionHandle");
        this.f23196c.position(3);
        int r14 = this.f23200k;
        FloatBuffer r15 = this.f23196c;
        GLES20.glVertexAttribPointer(r14, 3, 5126, false, this.f23194a, r15);
        a("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f23200k);
        a("glEnableVertexAttribArray aTextureHandle");
        float[] r16 = this.d;
        Matrix.setIdentityM(r16, 0);
        GLES20.glUniformMatrix4fv(this.f23197h, 1, false, r16, 0);
        GLES20.glUniformMatrix4fv(this.f23198i, 1, false, r5, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
        return;
    L22:
        SurfaceTexture r17 = this.f23203n;     // Catch: Exception -> L7
        if (r17 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");     // Catch: Exception -> L7
    L9:
        r17.updateTexImage();     // Catch: Exception -> L7
    L12:
        SurfaceTexture r18 = this.f23203n;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L15:
        r18.getTransformMatrix(r5);
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View, zp.k] */
    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r5) {
        Intrinsics.checkNotNullParameter(r5, "surface");
        this.f23202m.compareAndSet(false, true);
        this.f23206q.requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "glUnused");
        GLES20.glViewport(0, 0, r10, r11);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.View, zp.k] */
    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r5, EGLConfig r10) {
        Intrinsics.checkNotNullParameter(r5, "glUnused");
        Intrinsics.checkNotNullParameter(r10, "config");
        int r11 = b(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}");
        if (r11 != 0) goto L6;
        Log.e("VideoRender", "Failed to compile vertex shader");
    L5:
        int r12 = 0;
    L14:
        this.f = r12;
        if (r12 != 0) goto L17;
        return;
    L17:
        this.f23199j = GLES20.glGetAttribLocation(r12, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.f23199j == (-1)) goto L43;
        this.f23200k = GLES20.glGetAttribLocation(this.f, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.f23200k == (-1)) goto L41;
        this.f23197h = GLES20.glGetUniformLocation(this.f, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.f23197h == (-1)) goto L39;
        this.f23198i = GLES20.glGetUniformLocation(this.f, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.f23198i == (-1)) goto L37;
        int[] r13 = new int[1];
        GLES20.glGenTextures(1, r13, 0);
        int r14 = r13[0];
        this.g = r14;
        GLES20.glBindTexture(36197, r14);
        a("glBindTexture textureID");
        GLES20.glTexParameterf(36197, 10241, 9728);
        GLES20.glTexParameterf(36197, 10240, 9729);
        SurfaceTexture r15 = new SurfaceTexture(this.g);
        this.f23203n = r15;
        ?? r16 = this.f23206q;
        r15.setDefaultBufferSize(r16.getMeasuredWidth(), r16.getMeasuredHeight());
        SurfaceTexture r17 = this.f23203n;
        if (r17 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L28:
        r17.setOnFrameAvailableListener(this);
        SurfaceTexture r18 = this.f23203n;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L31:
        Surface r19 = new Surface(r18);
        a r20 = this.f23204o;
        if (r20 == null) goto L34;
        r20.c(r19);
    L34:
        this.f23202m.compareAndSet(true, false);
        return;
    L37:
        throw new RuntimeException("Could not get attrib location for uSTMatrix");
    L39:
        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    L41:
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
    L43:
        throw new RuntimeException("Could not get attrib location for aPosition");
    L6:
        int r21 = b(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\n\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec4 color2Map = vec4(1.0, 1.0, 1.0, 1.0);\n    if (vTextureCoord.x >= 0.5) {\n        color2Map = texture2D(sTexture, vec2(vTextureCoord.x - 0.5, vTextureCoord.y));\n        gl_FragColor = vec4(color.r, color.g, color.b, color2Map.g);\n    } else {\n        gl_FragColor = vec4(color.r, color.g, color.b, color.a);\n    }\n}");
        if (r21 != 0) goto L9;
        Log.e("VideoRender", "Failed to compile fragment shader");
        GLES20.glDeleteShader(r11);
        goto L5
    L9:
        r12 = GLES20.glCreateProgram();
        if (r12 == 0) goto L14;
        GLES20.glAttachShader(r12, r11);
        a("glAttachShader");
        GLES20.glAttachShader(r12, r21);
        a("glAttachShader");
        GLES20.glLinkProgram(r12);
        int[] r22 = new int[1];
        GLES20.glGetProgramiv(r12, 35714, r22, 0);
        if (r22[0] == 1) goto L14;
        Log.e("VideoRender", "Could not link programID: ");
        Log.e("VideoRender", GLES20.glGetProgramInfoLog(r12));
        GLES20.glDeleteProgram(r12);
        goto L5
    }
}
