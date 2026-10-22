package com.obric.common.oea.style.scene.alpha.alphaplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import androidx.work.Data;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.utils.TextureCropUtil;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: VideoRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\tH\u0002J(\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0016J\b\u00101\u001a\u00020%H\u0016J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020%H\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u001dH\u0016J \u00108\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0016J\u0018\u0010;\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u00020=H\u0016J\u0012\u0010>\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u000104H\u0016J\b\u0010@\u001a\u00020%H\u0002J\u0010\u0010A\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010B\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/VideoRenderer;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "alphaVideoView", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;)V", "FLOAT_SIZE_BYTES", "", "GL_TEXTURE_EXTERNAL_OES", "TAG", "", "TRIANGLE_VERTICES_DATA_POS_OFFSET", "TRIANGLE_VERTICES_DATA_STRIDE_BYTES", "TRIANGLE_VERTICES_DATA_UV_OFFSET", "aPositionHandle", "aTextureHandle", "getAlphaVideoView", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "canDraw", "Ljava/util/concurrent/atomic/AtomicBoolean;", "halfRightVerticeData", "", "mVPMatrix", "programID", "sTMatrix", "scaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "surfaceListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender$SurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "textureID", "triangleVertices", "Ljava/nio/FloatBuffer;", "uMVPMatrixHandle", "uSTMatrixHandle", "updateSurface", "checkGlError", "", "op", "createProgram", "loadShader", "shaderType", DBHelper.BATTERY_COL_SOURCE, "measureInternal", "viewWidth", "", "viewHeight", "videoWidth", "videoHeight", "onCompletion", "onDrawFrame", "glUnused", "Ljavax/microedition/khronos/opengles/GL10;", "onFirstFrame", "onFrameAvailable", "surface", "onSurfaceChanged", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onSurfaceDestroyed", "gl", "prepareSurface", "setScaleType", "setSurfaceListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoRenderer implements IRender {
    private final int FLOAT_SIZE_BYTES;
    private final int GL_TEXTURE_EXTERNAL_OES;
    private final String TAG;
    private final int TRIANGLE_VERTICES_DATA_POS_OFFSET;
    private final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES;
    private final int TRIANGLE_VERTICES_DATA_UV_OFFSET;
    private int aPositionHandle;
    private int aTextureHandle;
    private final IAlphaVideoView alphaVideoView;
    private final AtomicBoolean canDraw;
    private float[] halfRightVerticeData;
    private final float[] mVPMatrix;
    private int programID;
    private final float[] sTMatrix;
    private ScaleType scaleType;
    private IRender.SurfaceListener surfaceListener;
    private SurfaceTexture surfaceTexture;
    private int textureID;
    private FloatBuffer triangleVertices;
    private int uMVPMatrixHandle;
    private int uSTMatrixHandle;
    private final AtomicBoolean updateSurface;

    public VideoRenderer(IAlphaVideoView r4) {
        Intrinsics.checkNotNullParameter(r4, "alphaVideoView");
        this.alphaVideoView = r4;
        this.TAG = "VideoRender";
        this.FLOAT_SIZE_BYTES = 4;
        this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 4 * 5;
        this.TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
        this.GL_TEXTURE_EXTERNAL_OES = 36197;
        this.halfRightVerticeData = new float[]{-1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mVPMatrix = new float[16];
        float[] r0 = new float[16];
        this.sTMatrix = r0;
        this.canDraw = new AtomicBoolean(false);
        this.updateSurface = new AtomicBoolean(false);
        this.scaleType = ScaleType.ScaleAspectFill;
        FloatBuffer r5 = ByteBuffer.allocateDirect(this.halfRightVerticeData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(r5, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.triangleVertices = r5;
        r5.put(this.halfRightVerticeData).position(0);
        Matrix.setIdentityM(r0, 0);
    }

    public final IAlphaVideoView getAlphaVideoView() {
        return this.alphaVideoView;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void setScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        this.scaleType = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void measureInternal(float r4, float r5, float r6, float r7) {
        float r1 = 0;
        if (r4 > r1) goto L5;
        return;
    L5:
        if (r5 > r1) goto L7;
        return;
    L7:
        if (r6 > r1) goto L9;
        return;
    L9:
        if (r7 <= r1) goto L16;
        float[] r8 = TextureCropUtil.calculateHalfRightVerticeData(this.scaleType, r4, r5, r6, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "TextureCropUtil.calculat… videoWidth, videoHeight)");
        this.halfRightVerticeData = r8;
        FloatBuffer r9 = ByteBuffer.allocateDirect(r8.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(r9, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.triangleVertices = r9;
        r9.put(this.halfRightVerticeData).position(0);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void setSurfaceListener(IRender.SurfaceListener r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceListener");
        this.surfaceListener = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r10) {
        Intrinsics.checkNotNullParameter(r10, "glUnused");
        if (this.updateSurface.compareAndSet(true, false) == true) goto L21;
    L15:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.canDraw.get() == true) goto L19;
        GLES20.glFinish();
        return;
    L19:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(this.programID);
        checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.textureID);
        this.triangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, this.triangleVertices);
        checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        checkGlError("glEnableVertexAttribArray aPositionHandle");
        this.triangleVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.aTextureHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, this.triangleVertices);
        checkGlError("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.aTextureHandle);
        checkGlError("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.mVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, this.mVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uSTMatrixHandle, 1, false, this.sTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glFinish();
        return;
    L21:
        SurfaceTexture r11 = this.surfaceTexture;     // Catch: Exception -> L9
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");     // Catch: Exception -> L9
    L7:
        r11.updateTexImage();     // Catch: Exception -> L9
    L11:
        SurfaceTexture r12 = this.surfaceTexture;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L14:
        r12.getTransformMatrix(this.sTMatrix);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "glUnused");
        GLES20.glViewport(0, 0, r2, r3);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r2, EGLConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "glUnused");
        Intrinsics.checkNotNullParameter(r3, "config");
        int r4 = createProgram();
        this.programID = r4;
        if (r4 != 0) goto L5;
        return;
    L5:
        this.aPositionHandle = GLES20.glGetAttribLocation(r4, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.aPositionHandle == (-1)) goto L22;
        this.aTextureHandle = GLES20.glGetAttribLocation(this.programID, "aTextureCoord");
        checkGlError("glGetAttribLocation aTextureCoord");
        if (this.aTextureHandle == (-1)) goto L20;
        this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.programID, "uMVPMatrix");
        checkGlError("glGetUniformLocation uMVPMatrix");
        if (this.uMVPMatrixHandle == (-1)) goto L18;
        this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.programID, "uSTMatrix");
        checkGlError("glGetUniformLocation uSTMatrix");
        if (this.uSTMatrixHandle == (-1)) goto L16;
        prepareSurface();
        return;
    L16:
        throw new RuntimeException("Could not get attrib location for uSTMatrix");
    L18:
        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    L20:
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
    L22:
        throw new RuntimeException("Could not get attrib location for aPosition");
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer
    public void onSurfaceDestroyed(GL10 r1) {
        IRender.SurfaceListener r0 = this.surfaceListener;
        if (r0 == null) goto L6;
        r0.onSurfaceDestroyed();
        return;
    }

    private final void prepareSurface() {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        int r2 = r1[0];
        this.textureID = r2;
        GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, r2);
        checkGlError("glBindTexture textureID");
        GLES20.glTexParameterf(this.GL_TEXTURE_EXTERNAL_OES, 10241, 9728);
        GLES20.glTexParameterf(this.GL_TEXTURE_EXTERNAL_OES, Data.MAX_DATA_BYTES, 9729);
        this.surfaceTexture = new SurfaceTexture(this.textureID);
        SurfaceTexture r3 = this.surfaceTexture;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L5:
        r3.setDefaultBufferSize(this.alphaVideoView.getMeasuredWidth(), this.alphaVideoView.getMeasuredHeight());
        SurfaceTexture r4 = this.surfaceTexture;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L8:
        r4.setOnFrameAvailableListener(this);
        SurfaceTexture r5 = this.surfaceTexture;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L11:
        Surface r6 = new Surface(r5);
        IRender.SurfaceListener r7 = this.surfaceListener;
        if (r7 == null) goto L14;
        r7.onSurfacePrepared(r6);
    L14:
        this.updateSurface.compareAndSet(true, false);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r3) {
        Intrinsics.checkNotNullParameter(r3, "surface");
        this.updateSurface.compareAndSet(false, true);
        this.alphaVideoView.requestRender();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void onFirstFrame() {
        this.canDraw.compareAndSet(false, true);
        Log.i(this.TAG, "onFirstFrame:    canDraw = " + this.canDraw.get());
        this.alphaVideoView.requestRender();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void onCompletion() {
        this.canDraw.compareAndSet(true, false);
        Log.i(this.TAG, "onCompletion:   canDraw = " + this.canDraw.get());
        this.alphaVideoView.requestRender();
    }

    private final int loadShader(int r5, String r6) {
        int r0 = GLES20.glCreateShader(r5);
        if (r0 == 0) goto L8;
        GLES20.glShaderSource(r0, r6);
        GLES20.glCompileShader(r0);
        int[] r7 = new int[1];
        GLES20.glGetShaderiv(r0, 35713, r7, 0);
        if (r7[0] != 0) goto L9;
        Log.e(this.TAG, "Could not compile shader " + r5 + ':');
        Log.e(this.TAG, GLES20.glGetShaderInfoLog(r0));
        GLES20.glDeleteShader(r0);
        return 0;
    L9:
        return r0;
    L8:
        return r0;
    }

    private final int createProgram() {
        int r0 = loadShader(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}");
        if (r0 != 0) goto L6;
        Log.e(this.TAG, "Failed to compile vertex shader");
        return 0;
    L6:
        int r2 = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\n\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec4 color2Map = vec4(1.0, 1.0, 1.0, 1.0);\n    if (vTextureCoord.x >= 0.5) {\n        color2Map = texture2D(sTexture, vec2(vTextureCoord.x - 0.5, vTextureCoord.y));\n        gl_FragColor = vec4(color.r, color.g, color.b, color2Map.g);\n    } else {\n        gl_FragColor = vec4(color.r, color.g, color.b, color.a);\n    }\n}");
        if (r2 != 0) goto L10;
        Log.e(this.TAG, "Failed to compile fragment shader");
        GLES20.glDeleteShader(r0);
        return 0;
    L10:
        int r3 = GLES20.glCreateProgram();
        if (r3 == 0) goto L16;
        GLES20.glAttachShader(r3, r0);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(r3, r2);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(r3);
        int[] r4 = new int[1];
        GLES20.glGetProgramiv(r3, 35714, r4, 0);
        if (r4[0] == 1) goto L16;
        Log.e(this.TAG, "Could not link programID: ");
        Log.e(this.TAG, GLES20.glGetProgramInfoLog(r3));
        GLES20.glDeleteProgram(r3);
        return 0;
    L16:
        return r3;
    }

    private final void checkGlError(String r3) {
        int r0 = GLES20.glGetError();
        if (r0 == 0) goto L6;
        Log.e(this.TAG, r3 + ": glError " + r0);
        return;
    }
}
