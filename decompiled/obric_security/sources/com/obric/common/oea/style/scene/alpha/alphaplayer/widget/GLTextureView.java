package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import androidx.core.os.EnvironmentCompat;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IMonitor;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = true;
    private static final boolean LOG_EGL = true;
    private static final boolean LOG_PAUSE_RESUME = true;
    private static final boolean LOG_RENDERER = true;
    private static final boolean LOG_RENDERER_DRAW_FRAME = true;
    private static final boolean LOG_SURFACE = true;
    private static final boolean LOG_THREADS = true;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLTextureView";
    private static final GLThreadManager sGLThreadManager = null;
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private Renderer mRenderer;
    private final WeakReference<GLTextureView> mThisWeakRef;
    private IMonitor monitor;

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;
        final /* synthetic */ GLTextureView this$0;

        abstract EGLConfig chooseConfig(EGL10 r1, EGLDisplay r2, EGLConfig[] r3);

        public BaseConfigChooser(GLTextureView r1, int[] r2) {
            this.this$0 = r1;
            this.mConfigSpec = filterConfigSpec(r2);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 r9, EGLDisplay r10) {
            int[] r0 = new int[1];
            if (r9.eglChooseConfig(r10, this.mConfigSpec, null, 0, r0) == false) goto L17;
            int r5 = r0[0];
            if (r5 <= 0) goto L16;
            EGLConfig[] r7 = new EGLConfig[r5];
            if (r9.eglChooseConfig(r10, this.mConfigSpec, r7, r5, r0) == false) goto L14;
            EGLConfig r8 = chooseConfig(r9, r10, r7);
            if (r8 == null) goto L12;
            return r8;
        L12:
            throw new IllegalArgumentException("No config chosen");
        L14:
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        L16:
            throw new IllegalArgumentException("No configs match configSpec");
        L17:
            GLTextureView.access$300(this.this$0, false, Log.getStackTraceString(new IllegalArgumentException("eglChooseConfig failed")));
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] filterConfigSpec(int[] r4) {
            if (GLTextureView.access$200(this.this$0) == 2) goto L5;
            return r4;
        L5:
            int r3 = r4.length;
            int[] r0 = new int[r3 + 2];
            int r1 = r3 - 1;
            System.arraycopy(r4, 0, r0, 0, r1);
            r0[r1] = 12352;
            r0[r3] = 4;
            r0[r3 + 1] = 12344;
            return r0;
        }
    }

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;
        final /* synthetic */ GLTextureView this$0;

        public ComponentSizeChooser(GLTextureView r5, int r6, int r7, int r8, int r9, int r10, int r11) {
            this.this$0 = r5;
            super(r5, new int[]{12324, r6, 12323, r7, 12322, r8, 12321, r9, 12325, r10, 12326, r11, 12344});
            this.mValue = new int[1];
            this.mRedSize = r6;
            this.mGreenSize = r7;
            this.mBlueSize = r8;
            this.mAlphaSize = r9;
            this.mDepthSize = r10;
            this.mStencilSize = r11;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 r13, EGLDisplay r14, EGLConfig[] r15) {
            int r0 = r15.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L18;
            EGLConfig r8 = r15[r1];
            int r9 = findConfigAttrib(r13, r14, r8, 12325, 0);
            int r2 = findConfigAttrib(r13, r14, r8, 12326, 0);
            if (r9 < this.mDepthSize) goto L17;
            if (r2 < this.mStencilSize) goto L17;
            int r10 = findConfigAttrib(r13, r14, r8, 12324, 0);
            int r11 = findConfigAttrib(r13, r14, r8, 12323, 0);
            int r12 = findConfigAttrib(r13, r14, r8, 12322, 0);
            int r3 = findConfigAttrib(r13, r14, r8, 12321, 0);
            if (r10 != this.mRedSize) goto L17;
            if (r11 != this.mGreenSize) goto L17;
            if (r12 != this.mBlueSize) goto L17;
            if (r3 != this.mAlphaSize) goto L17;
            return r8;
        L17:
            r1 = r1 + 1;
            goto L3
        L18:
            return null;
        }

        private int findConfigAttrib(EGL10 r2, EGLDisplay r3, EGLConfig r4, int r5, int r6) {
            if (r2.eglGetConfigAttrib(r3, r4, r5, this.mValue) == true) goto L5;
            return r6;
        L5:
            return this.mValue[0];
        }
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;
        final /* synthetic */ GLTextureView this$0;

        private DefaultContextFactory(GLTextureView r1) {
            this.this$0 = r1;
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ DefaultContextFactory(GLTextureView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLContextFactory
        public EGLContext createContext(EGL10 r4, EGLDisplay r5, EGLConfig r6) {
            int[] r0 = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.access$200(this.this$0), 12344};
            EGLContext r1 = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.access$200(this.this$0) != 0) goto L7;
            r0 = null;
        L7:
            return r4.eglCreateContext(r5, r6, r1, r0);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLContextFactory
        public void destroyContext(EGL10 r3, EGLDisplay r4, EGLContext r5) {
            if (r3.eglDestroyContext(r4, r5) == true) goto L6;
            Log.e("DefaultContextFactory", "display:" + r4 + " context: " + r5);
            Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
            EglHelper.throwEglException("eglDestroyContex", r3.eglGetError());
            return;
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        /* synthetic */ DefaultWindowSurfaceFactory(AnonymousClass1 r1) {
            this();
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 r1, EGLDisplay r2, EGLConfig r3, Object r4) {
            return r1.eglCreateWindowSurface(r2, r3, r4, null);
        L5:
            e = move-exception;
            Log.e(GLTextureView.TAG, "eglCreateWindowSurface", e);
            return null;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 r1, EGLDisplay r2, EGLSurface r3) {
            r1.eglDestroySurface(r2, r3);
        }
    }

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 r1, EGLDisplay r2);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 r1, EGLDisplay r2, EGLConfig r3);

        void destroyContext(EGL10 r1, EGLDisplay r2, EGLContext r3);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 r1, EGLDisplay r2, EGLConfig r3, Object r4);

        void destroySurface(EGL10 r1, EGLDisplay r2, EGLSurface r3);
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLTextureView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLTextureView> r1) {
            this.mGLSurfaceViewWeakRef = r1;
        }

        public void start() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 r0 = (EGL10) EGLContext.getEGL();
            this.mEgl = r0;
            EGLDisplay r1 = r0.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = r1;
            if (r1 == EGL10.EGL_NO_DISPLAY) goto L20;
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2]) == false) goto L18;
            GLTextureView r2 = this.mGLSurfaceViewWeakRef.get();
            if (r2 != null) goto L9;
            this.mEglConfig = null;
            this.mEglContext = null;
        L10:
            EGLContext r3 = this.mEglContext;
            if (r3 != null) goto L13;
        L14:
            this.mEglContext = null;
            throwEglException("createContext");
        L15:
            Log.w("EglHelper", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId());
            this.mEglSurface = null;
            return;
        L13:
            if (r3 != EGL10.EGL_NO_CONTEXT) goto L15;
        L9:
            this.mEglConfig = GLTextureView.access$400(r2).chooseConfig(this.mEgl, this.mEglDisplay);
            this.mEglContext = GLTextureView.access$500(r2).createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
            goto L10
        L18:
            throw new RuntimeException("eglInitialize failed");
        L20:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean createSurface() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.mEgl == null) goto L32;
            if (this.mEglDisplay == null) goto L30;
            if (this.mEglConfig == null) goto L28;
            destroySurfaceImp();
            GLTextureView r0 = this.mGLSurfaceViewWeakRef.get();
            if (r0 == null) goto L11;
            this.mEglSurface = GLTextureView.access$600(r0).createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, r0.getSurfaceTexture());
        L12:
            EGLSurface r1 = this.mEglSurface;
            if (r1 == null) goto L24;
            if (r1 == EGL10.EGL_NO_SURFACE) goto L24;
            EGL10 r2 = this.mEgl;
            EGLDisplay r3 = this.mEglDisplay;
            EGLSurface r4 = this.mEglSurface;
            if (r2.eglMakeCurrent(r3, r4, r4, this.mEglContext) == true) goto L21;
            logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
            return false;
        L21:
            return true;
        L24:
            if (this.mEgl.eglGetError() != 12299) goto L26;
            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        L26:
            return false;
        L11:
            this.mEglSurface = null;
            goto L12
        L28:
            throw new RuntimeException("mEglConfig not initialized");
        L30:
            throw new RuntimeException("eglDisplay not initialized");
        L32:
            throw new RuntimeException("egl not initialized");
        }

        GL createGL() {
            GL r0 = this.mEglContext.getGL();
            GLTextureView r3 = this.mGLSurfaceViewWeakRef.get();
            if (r3 != null) goto L5;
            return r0;
        L5:
            if (GLTextureView.access$700(r3) == null) goto L8;
            r0 = GLTextureView.access$700(r3).wrap(r0);
        L8:
            if ((GLTextureView.access$800(r3) & 3) == 0) goto L20;
            int r2 = 1;
            if ((GLTextureView.access$800(r3) & 1) != 0) goto L14;
            r2 = 0;
        L14:
            if ((GLTextureView.access$800(r3) & 2) == 0) goto L16;
            LogWriter r4 = new LogWriter();
        L18:
            return GLDebugHelper.wrap(r0, r2, r4);
        L16:
            r4 = null;
            goto L18
        L20:
            return r0;
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface) == false) goto L5;
            return 12288;
        L5:
            return this.mEgl.eglGetError();
        }

        public void destroySurface() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface r0 = this.mEglSurface;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0 == EGL10.EGL_NO_SURFACE) goto L12;
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GLTextureView r1 = this.mGLSurfaceViewWeakRef.get();
            if (r1 == null) goto L9;
            GLTextureView.access$600(r1).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
        L9:
            this.mEglSurface = null;
            return;
        }

        public void finish() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.mEglContext == null) goto L8;
            GLTextureView r0 = this.mGLSurfaceViewWeakRef.get();
            if (r0 == null) goto L7;
            GLTextureView.access$500(r0).destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
        L7:
            this.mEglContext = null;
        L8:
            EGLDisplay r1 = this.mEglDisplay;
            if (r1 == null) goto L12;
            this.mEgl.eglTerminate(r1);
            this.mEglDisplay = null;
            return;
        }

        private void throwEglException(String r1) {
            throwEglException(r1, this.mEgl.eglGetError());
        }

        public static void throwEglException(String r2, int r3) {
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + formatEglError(r2, r3));
        }

        public static void logEglErrorAsWarning(String r0, String r1, int r2) {
            Log.w(r0, formatEglError(r1, r2));
        }

        public static String formatEglError(String r1, int r2) {
            return r1 + " failed: " + r2;
        }
    }

    static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue;
        private boolean mExited;
        private WeakReference<GLTextureView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode;
        private boolean mRequestPaused;
        private boolean mRequestRender;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int mWidth;

        static /* synthetic */ boolean access$1202(GLThread r0, boolean r1) {
            r0.mExited = r1;
            return r1;
        }

        GLThread(WeakReference<GLTextureView> r3) {
            this.mEventQueue = new ArrayList();
            this.mSizeChanged = true;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mRequestRender = true;
            this.mRenderMode = 1;
            this.mGLSurfaceViewWeakRef = r3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            guardedRun();     // Catch: InterruptedException -> L9 Throwable -> L5
        L5:
            th = move-exception;
            GLTextureView.access$900().threadExiting(this);
            throw th;
        L4:
            GLTextureView.access$900().threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface == false) goto L6;
            this.mHaveEglSurface = false;
            this.mEglHelper.destroySurface();
            return;
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext == false) goto L6;
            this.mEglHelper.finish();
            this.mHaveEglContext = false;
            GLTextureView.access$900().releaseEglContextLocked(this);
            return;
        }

        private void guardedRun() throws InterruptedException {
            GLThread r1 = this;
            r1.mEglHelper = new EglHelper(r1.mGLSurfaceViewWeakRef);
            r1.mHaveEglContext = false;
            r1.mHaveEglSurface = false;
            boolean r4 = false;
            boolean r5 = false;
            boolean r6 = false;
            boolean r7 = false;
            boolean r8 = false;
            boolean r9 = false;
            boolean r10 = false;
            boolean r11 = false;
            int r12 = 0;
            int r13 = 0;
            GL10 r3 = null;
        L3:
            Runnable r14 = null;
        L184:
            GLThreadManager r15 = GLTextureView.access$900();     // Catch: Throwable -> L160
            monitor-enter(r15);     // Catch: Throwable -> L160
        L187:
        L152:
            th = th;
        L154:
            monitor-exit(r15);     // Catch: Throwable -> L158
            throw th;     // Catch: Throwable -> L156
        L156:
            th = th;
        L162:
            GLThreadManager r2 = GLTextureView.access$900();
            monitor-enter(r2);
            stopEglSurfaceLocked();     // Catch: Throwable -> L167
            stopEglContextLocked();     // Catch: Throwable -> L167
            monitor-exit(r2);     // Catch: Throwable -> L167
            throw th;
        L167:
            th = move-exception;
            throw th;
        L158:
            th = th;
            goto L154
        L7:
            if (r1.mShouldExit == true) goto L8;
            if (r1.mEventQueue.isEmpty() == false) goto L19;
            boolean r16 = r1.mPaused;     // Catch: Throwable -> L152
            boolean r0 = r1.mRequestPaused;     // Catch: Throwable -> L152
            if (r16 == r0) goto L23;
            r1.mPaused = r0;     // Catch: Throwable -> L152
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L152
            boolean r17 = r0;
            Log.i("GLThread", "mPaused is now " + r1.mPaused + " tid=" + getId());     // Catch: Throwable -> L152
        L25:
            if (r1.mShouldReleaseEglContext == false) goto L27;
            Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());     // Catch: Throwable -> L152
            stopEglSurfaceLocked();     // Catch: Throwable -> L152
            stopEglContextLocked();     // Catch: Throwable -> L152
            r1.mShouldReleaseEglContext = false;     // Catch: Throwable -> L152
            r11 = true;
        L27:
            if (r7 == false) goto L29;
            stopEglSurfaceLocked();     // Catch: Throwable -> L152
            stopEglContextLocked();     // Catch: Throwable -> L152
            r7 = false;
        L29:
            if (r17 == true) goto L31;
        L33:
            if (r17 == true) goto L35;
        L44:
            if (r17 == false) goto L49;
            if (GLTextureView.access$900().shouldTerminateEGLWhenPausing() == false) goto L49;
            r1.mEglHelper.finish();     // Catch: Throwable -> L152
            Log.i("GLThread", "terminating EGL because paused tid=" + getId());     // Catch: Throwable -> L152
        L49:
            if (r1.mHasSurface == true) goto L57;
            if (r1.mWaitingForSurface == true) goto L57;
            Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());     // Catch: Throwable -> L152
            if (r1.mHaveEglSurface == false) goto L55;
            stopEglSurfaceLocked();     // Catch: Throwable -> L152
        L55:
            r1.mWaitingForSurface = true;     // Catch: Throwable -> L152
            r1.mSurfaceIsBad = false;     // Catch: Throwable -> L152
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L152
        L57:
            if (r1.mHasSurface == true) goto L59;
        L61:
            if (r10 == false) goto L64;
            Log.i("GLThread", "sending render notification tid=" + getId());     // Catch: Throwable -> L152
            r1.mRenderComplete = true;     // Catch: Throwable -> L152
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L152
            r9 = false;
            r10 = false;
        L64:
            if (readyToDraw() == true) goto L66;
            r4 = r4;
        L174:
            Log.i("GLThread", new StringBuilder().append("waiting tid=").append(getId()).append(" mHaveEglContext: ").append(this.mHaveEglContext).append(" mHaveEglSurface: ").append(this.mHaveEglSurface).append(" mPaused: ").append(this.mPaused).append(" mHasSurface: ").append(this.mHasSurface).append(" mSurfaceIsBad: ").append(this.mSurfaceIsBad).append(" mWaitingForSurface: ").append(this.mWaitingForSurface).append(" mWidth: ").append(this.mWidth).append(" mHeight: ").append(this.mHeight).append(" mRequestRender: ").append(this.mRequestRender).append(" mRenderMode: ").append(this.mRenderMode).toString());     // Catch: Throwable -> L158
            GLTextureView.access$900().wait();     // Catch: Throwable -> L158
            r1 = this;
            r3 = r3;
            goto L187
        L190:
            th = th;
            goto L154
        L66:
            if (r1.mHaveEglContext == true) goto L77;
            if (r11 == false) goto L70;
            r4 = r4;
            r11 = false;
        L79:
            if (r1.mHaveEglContext == false) goto L85;
            if (r1.mHaveEglSurface == true) goto L85;
            r1.mHaveEglSurface = true;     // Catch: Throwable -> L152
            r5 = true;
            r6 = true;
            r8 = true;
        L85:
            if (r1.mHaveEglSurface == false) goto L174;
            if (r1.mSizeChanged == false) goto L90;
            int r18 = r1.mWidth;     // Catch: Throwable -> L152
            int r19 = r1.mHeight;     // Catch: Throwable -> L152
            Log.i("GLThread", "noticing that we want render notification tid=" + getId());     // Catch: Throwable -> L152
            r1.mSizeChanged = false;     // Catch: Throwable -> L152
            r12 = r18;
            r13 = r19;
            boolean r20 = false;
            r5 = true;
            r8 = true;
            r9 = true;
        L91:
            r1.mRequestRender = r20;     // Catch: Throwable -> L146
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L146
        L176:
            monitor-exit(r15);     // Catch: Throwable -> L146
            if (r14 != null) goto L94;
            if (r5 == false) goto L108;
            Log.w("GLThread", "egl createSurface");     // Catch: Throwable -> L160
            if (r1.mEglHelper.createSurface() == false) goto L98;
            r5 = r20;
            goto L108
        L98:
            GLThreadManager r21 = GLTextureView.access$900();     // Catch: Throwable -> L160
            monitor-enter(r21);     // Catch: Throwable -> L160
            r1.mSurfaceIsBad = true;     // Catch: Throwable -> L104
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L104
            monitor-exit(r21);     // Catch: Throwable -> L104
            r3 = r3;
            goto L184
        L104:
            th = move-exception;
            throw th;     // Catch: Throwable -> L160
        L108:
            if (r6 == false) goto L110;
            r3 = (GL10) r1.mEglHelper.createGL();     // Catch: Throwable -> L160
            GLTextureView.access$900().checkGLDriver(r3);     // Catch: Throwable -> L160
            r6 = r20;
        L111:
            if (r4 == false) goto L116;
            Log.w("GLThread", "onSurfaceCreated");     // Catch: Throwable -> L160
            GLTextureView r22 = r1.mGLSurfaceViewWeakRef.get();     // Catch: Throwable -> L160
            if (r22 == null) goto L115;
            GLTextureView.access$1100(r22).onSurfaceCreated(r3, r1.mEglHelper.mEglConfig);     // Catch: Throwable -> L160
        L115:
            r4 = r20;
        L116:
            if (r8 == false) goto L188;
            Log.w("GLThread", "onSurfaceChanged(" + r12 + ", " + r13 + ")");     // Catch: Throwable -> L160
            GLTextureView r23 = r1.mGLSurfaceViewWeakRef.get();     // Catch: Throwable -> L160
            if (r23 == null) goto L120;
            GLTextureView.access$1100(r23).onSurfaceChanged(r3, r12, r13);     // Catch: Throwable -> L160
        L120:
            r8 = r20;
        L188:
            boolean r110 = r4;
            boolean r111 = r5;
            Log.w("GLThread", new StringBuilder().append("onDrawFrame tid=").append(getId()).toString());     // Catch: Throwable -> L144
            GLTextureView r24 = r1.mGLSurfaceViewWeakRef.get();     // Catch: Throwable -> L144
            if (r24 == null) goto L124;
            GLTextureView.access$1100(r24).onDrawFrame(r3);     // Catch: Throwable -> L160
        L124:
            int r25 = r1.mEglHelper.swap();     // Catch: Throwable -> L144
            if (r25 != 12288) goto L128;
        L141:
            if (r9 == false) goto L143;
            r10 = true;
        L143:
            r1 = this;
            r5 = r111;
            r4 = r110;
            goto L184
        L128:
            if (r25 == 12302) goto L139;
            EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r25);     // Catch: Throwable -> L160
            GLThreadManager r26 = GLTextureView.access$900();     // Catch: Throwable -> L160
            monitor-enter(r26);     // Catch: Throwable -> L160
            r1.mSurfaceIsBad = true;     // Catch: Throwable -> L135
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L135
            monitor-exit(r26);     // Catch: Throwable -> L135
        L135:
            th = move-exception;
            throw th;     // Catch: Throwable -> L160
        L139:
            Log.i("GLThread", "egl context lost tid=" + getId());     // Catch: Throwable -> L144
            r7 = true;
        L144:
            th = th;
            goto L162
        L110:
            r3 = r3;
            goto L111
        L94:
            r14.run();     // Catch: Throwable -> L160
            r3 = r3;
        L146:
            th = th;
            goto L154
        L90:
            r20 = false;
            goto L91
        L70:
            if (GLTextureView.access$900().tryAcquireEglContextLocked(r1) == false) goto L77;
            r1.mEglHelper.start();     // Catch: RuntimeException -> L74 Throwable -> L152
        L73:
            r1.mHaveEglContext = true;     // Catch: Throwable -> L152
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L152
            r4 = true;
        L74:
            e = move-exception;
            GLTextureView.access$900().releaseEglContextLocked(r1);     // Catch: Throwable -> L152
            throw e;     // Catch: Throwable -> L152
        L77:
            r4 = r4;
            goto L79
        L59:
            if (r1.mWaitingForSurface == false) goto L61;
            Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());     // Catch: Throwable -> L152
            r1.mWaitingForSurface = false;     // Catch: Throwable -> L152
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L152
            goto L61
        L35:
            if (r1.mHaveEglContext == false) goto L44;
            GLTextureView r27 = r1.mGLSurfaceViewWeakRef.get();     // Catch: Throwable -> L152
            if (r27 != null) goto L39;
            boolean r28 = false;
        L40:
            if (r28 == true) goto L42;
        L43:
            stopEglContextLocked();     // Catch: Throwable -> L152
            Log.i("GLThread", "releasing EGL context because paused tid=" + getId());     // Catch: Throwable -> L152
            goto L44
        L42:
            if (GLTextureView.access$900().shouldReleaseEGLContextWhenPausing() == false) goto L44;
        L39:
            r28 = GLTextureView.access$1000(r27);     // Catch: Throwable -> L152
            goto L40
        L31:
            if (r1.mHaveEglSurface == false) goto L33;
            Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());     // Catch: Throwable -> L152
            stopEglSurfaceLocked();     // Catch: Throwable -> L152
            goto L33
        L23:
            r17 = false;
            goto L25
        L19:
            r14 = r1.mEventQueue.remove(0);     // Catch: Throwable -> L152
            r3 = r3;
            r20 = false;
            goto L176
        L8:
            monitor-exit(r15);     // Catch: Throwable -> L152
            GLThreadManager r29 = GLTextureView.access$900();
            monitor-enter(r29);
            stopEglSurfaceLocked();     // Catch: Throwable -> L14
            stopEglContextLocked();     // Catch: Throwable -> L14
            monitor-exit(r29);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L160:
            th = th;
            goto L162
        }

        public boolean ableToDraw() {
            if (this.mHaveEglContext == true) goto L5;
        L9:
            return false;
        L5:
            if (this.mHaveEglSurface == false) goto L9;
            if (readyToDraw() == false) goto L9;
            return true;
        }

        private boolean readyToDraw() {
            if (this.mPaused == false) goto L5;
        L17:
            return false;
        L5:
            if (this.mHasSurface == false) goto L17;
            if (this.mSurfaceIsBad == true) goto L17;
            if (this.mWidth <= 0) goto L17;
            if (this.mHeight <= 0) goto L17;
            if (this.mRequestRender == false) goto L15;
            return true;
        L15:
            if (this.mRenderMode != 1) goto L17;
            return true;
        }

        public void setRenderMode(int r2) {
            if (r2 < 0) goto L14;
            if (r2 > 1) goto L14;
            GLThreadManager r0 = GLTextureView.access$900();
            monitor-enter(r0);
            this.mRenderMode = r2;     // Catch: Throwable -> L10
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalArgumentException("renderMode");
        }

        public int getRenderMode() {
            GLThreadManager r0 = GLTextureView.access$900();
            monitor-enter(r0);
            int r1 = this.mRenderMode;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void requestRender() {
            GLThreadManager r0 = GLTextureView.access$900();
            monitor-enter(r0);
            this.mRequestRender = true;     // Catch: Throwable -> L8
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void surfaceCreated() {
            GLThreadManager r1 = GLTextureView.access$900();
            monitor-enter(r1);
            Log.i("GLThread", "surfaceCreated tid=" + getId());     // Catch: Throwable -> L14
            this.mHasSurface = true;     // Catch: Throwable -> L14
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L14
        L6:
            if (this.mWaitingForSurface == false) goto L12;
            if (this.mExited == true) goto L12;
            GLTextureView.access$900().wait();     // Catch: InterruptedException -> L11 Throwable -> L14
        L11:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L14
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void surfaceDestroyed() {
            GLThreadManager r1 = GLTextureView.access$900();
            monitor-enter(r1);
            Log.i("GLThread", "surfaceDestroyed tid=" + getId());     // Catch: Throwable -> L14
            this.mHasSurface = false;     // Catch: Throwable -> L14
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L14
        L6:
            if (this.mWaitingForSurface == true) goto L12;
            if (this.mExited == true) goto L12;
            GLTextureView.access$900().wait();     // Catch: InterruptedException -> L11 Throwable -> L14
        L11:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L14
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void onPause() {
            GLThreadManager r1 = GLTextureView.access$900();
            monitor-enter(r1);
            Log.i("GLThread", "onPause tid=" + getId());     // Catch: Throwable -> L15
            this.mRequestPaused = true;     // Catch: Throwable -> L15
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L15
        L6:
            if (this.mExited == true) goto L13;
            if (this.mPaused == true) goto L13;
            Log.i("Main thread", "onPause waiting for mPaused.");     // Catch: Throwable -> L15
            GLTextureView.access$900().wait();     // Catch: InterruptedException -> L12 Throwable -> L15
        L12:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public void onResume() {
            GLThreadManager r1 = GLTextureView.access$900();
            monitor-enter(r1);
            Log.i("GLThread", "onResume tid=" + getId());     // Catch: Throwable -> L17
            this.mRequestPaused = false;     // Catch: Throwable -> L17
            this.mRequestRender = true;     // Catch: Throwable -> L17
            this.mRenderComplete = false;     // Catch: Throwable -> L17
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L17
        L6:
            if (this.mExited == true) goto L15;
            if (this.mPaused == false) goto L15;
            if (this.mRenderComplete == true) goto L15;
            Log.i("Main thread", "onResume waiting for !mPaused.");     // Catch: Throwable -> L17
            GLTextureView.access$900().wait();     // Catch: InterruptedException -> L14 Throwable -> L17
        L14:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L17
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        public void onWindowResize(int r4, int r5) {
            GLThreadManager r0 = GLTextureView.access$900();
            monitor-enter(r0);
            this.mWidth = r4;     // Catch: Throwable -> L19
            this.mHeight = r5;     // Catch: Throwable -> L19
            this.mSizeChanged = true;     // Catch: Throwable -> L19
            this.mRequestRender = true;     // Catch: Throwable -> L19
            this.mRenderComplete = false;     // Catch: Throwable -> L19
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L19
        L6:
            if (this.mExited == true) goto L17;
            if (this.mPaused == true) goto L17;
            if (this.mRenderComplete == true) goto L17;
            if (ableToDraw() == false) goto L17;
            Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());     // Catch: Throwable -> L19
            GLTextureView.access$900().wait();     // Catch: InterruptedException -> L16 Throwable -> L19
        L16:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void requestExitAndWait() {
            GLThreadManager r0 = GLTextureView.access$900();
            monitor-enter(r0);
            this.mShouldExit = true;     // Catch: Throwable -> L13
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L13
        L7:
            if (this.mExited == true) goto L11;
            GLTextureView.access$900().wait();     // Catch: InterruptedException -> L10 Throwable -> L13
        L10:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLTextureView.access$900().notifyAll();
        }

        public void queueEvent(Runnable r2) {
            if (r2 == null) goto L12;
            GLThreadManager r0 = GLTextureView.access$900();
            monitor-enter(r0);
            this.mEventQueue.add(r2);     // Catch: Throwable -> L8
            GLTextureView.access$900().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L12:
            throw new IllegalArgumentException("r must not be null");
        }
    }

    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        static {
        }

        private GLThreadManager() {
        }

        /* synthetic */ GLThreadManager(AnonymousClass1 r1) {
            this();
        }

        public synchronized void threadExiting(GLThread r6) {
            monitor-enter(this);
            Log.i("GLThread", "exiting tid=" + r6.getId());     // Catch: Throwable -> L10
            GLThread.access$1202(r6, true);     // Catch: Throwable -> L10
            if (this.mEglOwner != r6) goto L7;
            this.mEglOwner = null;     // Catch: Throwable -> L10
        L7:
            notifyAll();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public boolean tryAcquireEglContextLocked(GLThread r3) {
            GLThread r0 = this.mEglOwner;
            if (r0 == r3) goto L14;
            if (r0 == null) goto L14;
            checkGLESVersion();
            if (this.mMultipleGLESContextsAllowed == false) goto L9;
            return true;
        L9:
            GLThread r2 = this.mEglOwner;
            if (r2 == null) goto L16;
            r2.requestReleaseEglContextLocked();
            return false;
        L16:
            return false;
        L14:
            this.mEglOwner = r3;
            notifyAll();
            return true;
        }

        public void releaseEglContextLocked(GLThread r2) {
            if (this.mEglOwner != r2) goto L5;
            this.mEglOwner = null;
        L5:
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            monitor-enter(this);
            boolean r0 = this.mLimitedGLESContexts;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            monitor-enter(this);
            checkGLESVersion();     // Catch: Throwable -> L7
            boolean r0 = !this.mMultipleGLESContextsAllowed;
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized void checkGLDriver(GL10 r6) {
            monitor-enter(this);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (this.mGLESDriverCheckComplete == true) goto L17;
            checkGLESVersion();     // Catch: Throwable -> L19
            String r7 = r6.glGetString(7937);     // Catch: Throwable -> L19
            boolean r3 = false;
            if (this.mGLESVersion >= 131072) goto L14;
            if (r7.startsWith(kMSM7K_RENDERER_PREFIX) == true) goto L11;
            boolean r1 = true;
        L12:
            this.mMultipleGLESContextsAllowed = r1;     // Catch: Throwable -> L19
            notifyAll();     // Catch: Throwable -> L19
            goto L14
        L11:
            r1 = false;
        L14:
            if (this.mMultipleGLESContextsAllowed == true) goto L16;
            r3 = true;
        L16:
            this.mLimitedGLESContexts = r3;     // Catch: Throwable -> L19
            Log.w(TAG, "checkGLDriver renderer = \"" + r7 + "\" multipleContextsAllowed = " + this.mMultipleGLESContextsAllowed + " mLimitedGLESContexts = " + this.mLimitedGLESContexts);     // Catch: Throwable -> L19
            this.mGLESDriverCheckComplete = true;     // Catch: Throwable -> L19
        L17:
            monitor-exit(this);
        }

        private void checkGLESVersion() {
            if (this.mGLESVersionCheckComplete == true) goto L6;
            this.mGLESVersionCheckComplete = true;
            return;
        }
    }

    public interface GLWrapper {
        GL wrap(GL r1);
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder;

        LogWriter() {
            this.mBuilder = new StringBuilder();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] r4, int r5, int r6) {
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L9;
            char r1 = r4[r5 + r0];
            if (r1 != '\n') goto L7;
            flushBuilder();
        L8:
            r0 = r0 + 1;
            goto L3
        L7:
            this.mBuilder.append(r1);
            goto L8
        }

        private void flushBuilder() {
            if (this.mBuilder.length() <= 0) goto L6;
            Log.v(GLTextureView.TAG, this.mBuilder.toString());
            StringBuilder r2 = this.mBuilder;
            r2.delete(0, r2.length());
            return;
        }
    }

    public interface Renderer {
        void onDrawFrame(GL10 r1);

        void onSurfaceChanged(GL10 r1, int r2, int r3);

        void onSurfaceCreated(GL10 r1, EGLConfig r2);

        void onSurfaceDestroyed(GL10 r1);
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        final /* synthetic */ GLTextureView this$0;

        public SimpleEGLConfigChooser(GLTextureView r9, boolean r10) {
            this.this$0 = r9;
            if (r10 == false) goto L5;
            int r11 = 16;
        L6:
            super(r9, 8, 8, 8, 0, r11, 0);
            return;
        L5:
            r11 = 0;
            goto L6
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    static /* synthetic */ boolean access$1000(GLTextureView r0) {
        return r0.mPreserveEGLContextOnPause;
    }

    static /* synthetic */ Renderer access$1100(GLTextureView r0) {
        return r0.mRenderer;
    }

    static /* synthetic */ int access$200(GLTextureView r0) {
        return r0.mEGLContextClientVersion;
    }

    static /* synthetic */ void access$300(GLTextureView r0, boolean r1, String r2) {
        r0.sendMonitor(r1, r2);
    }

    static /* synthetic */ EGLConfigChooser access$400(GLTextureView r0) {
        return r0.mEGLConfigChooser;
    }

    static /* synthetic */ EGLContextFactory access$500(GLTextureView r0) {
        return r0.mEGLContextFactory;
    }

    static /* synthetic */ EGLWindowSurfaceFactory access$600(GLTextureView r0) {
        return r0.mEGLWindowSurfaceFactory;
    }

    static /* synthetic */ GLWrapper access$700(GLTextureView r0) {
        return r0.mGLWrapper;
    }

    static /* synthetic */ int access$800(GLTextureView r0) {
        return r0.mDebugFlags;
    }

    static /* synthetic */ GLThreadManager access$900() {
        return sGLThreadManager;
    }

    public GLTextureView(Context r1) {
        super(r1);
        this.mThisWeakRef = new WeakReference(this);
        init();
    }

    public GLTextureView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mThisWeakRef = new WeakReference(this);
        init();
    }

    protected void finalize() throws Throwable {
        GLThread r0 = this.mGLThread;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.requestExitAndWait();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setMonitor(IMonitor r1) {
        this.monitor = r1;
    }

    private void sendMonitor(boolean r7, String r8) {
        IMonitor r0 = this.monitor;
        if (r0 == null) goto L6;
        r0.monitor(r7, EnvironmentCompat.MEDIA_UNKNOWN, 0, 0, r8);
        return;
    }

    public void setGLWrapper(GLWrapper r1) {
        this.mGLWrapper = r1;
    }

    public void setDebugFlags(int r1) {
        this.mDebugFlags = r1;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean r1) {
        this.mPreserveEGLContextOnPause = r1;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer r3) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser != null) goto L5;
        this.mEGLConfigChooser = new SimpleEGLConfigChooser(this, true);
    L5:
        AnonymousClass1 r1 = null;
        if (this.mEGLContextFactory != null) goto L9;
        this.mEGLContextFactory = new DefaultContextFactory(this, r1);
    L9:
        if (this.mEGLWindowSurfaceFactory != null) goto L11;
        this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory(r1);
    L11:
        this.mRenderer = r3;
        GLThread r4 = new GLThread(this.mThisWeakRef);
        this.mGLThread = r4;
        r4.start();
    }

    public void setEGLContextFactory(EGLContextFactory r1) {
        checkRenderThreadState();
        this.mEGLContextFactory = r1;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory r1) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = r1;
    }

    public void setEGLConfigChooser(EGLConfigChooser r1) {
        checkRenderThreadState();
        this.mEGLConfigChooser = r1;
    }

    public void setEGLConfigChooser(boolean r2) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(this, r2));
    }

    public void setEGLConfigChooser(int r10, int r11, int r12, int r13, int r14, int r15) {
        setEGLConfigChooser(new ComponentSizeChooser(this, r10, r11, r12, r13, r14, r15));
    }

    public void setEGLContextClientVersion(int r1) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = r1;
    }

    public void setRenderMode(int r1) {
        this.mGLThread.setRenderMode(r1);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void surfaceCreated(SurfaceTexture r1) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceTexture r1) {
        this.mGLThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceTexture r1, int r2, int r3, int r4) {
        this.mGLThread.onWindowResize(r3, r4);
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable r1) {
        this.mGLThread.queueEvent(r1);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow reattach =" + this.mDetached);
        if (this.mDetached == true) goto L5;
    L14:
        this.mDetached = false;
        return;
    L5:
        if (this.mRenderer == null) goto L14;
        GLThread r0 = this.mGLThread;
        if (r0 == null) goto L9;
        int r1 = r0.getRenderMode();
    L10:
        GLThread r2 = new GLThread(this.mThisWeakRef);
        this.mGLThread = r2;
        if (r1 == 1) goto L13;
        r2.setRenderMode(r1);
    L13:
        this.mGLThread.start();
        goto L14
    L9:
        r1 = 1;
        goto L10
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow");
        GLThread r0 = this.mGLThread;
        if (r0 == null) goto L5;
        r0.requestExitAndWait();
    L5:
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        surfaceChanged(getSurfaceTexture(), 0, r4 - r2, r5 - r3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r2, int r3, int r4) {
        surfaceCreated(r2);
        surfaceChanged(r2, 0, r3, r4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r2, int r3, int r4) {
        surfaceChanged(r2, 0, r3, r4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r1) {
        surfaceDestroyed(r1);
        return true;
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    static {
        sGLThreadManager = new GLThreadManager(null);
    }
}
