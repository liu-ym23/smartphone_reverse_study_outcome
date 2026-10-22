package zp;

import android.opengl.GLDebugHelper;
import android.util.Log;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView;
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
public final class e extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23562c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f23563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f23565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f23566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f23567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f23568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f23569n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f23570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f23571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f23572q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ug.d f23573r;
    public final WeakReference s;

    public e(WeakReference r5) {
        this.f23571p = new ArrayList();
        this.f23572q = true;
        this.f23566k = 0;
        this.f23567l = 0;
        this.f23569n = true;
        this.f23568m = 1;
        this.s = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final void a() {
        WeakReference r5 = this.s;
        ug.d r10 = new ug.d(12);
        r10.f22357b = r5;
        this.f23573r = r10;
        ?? r11 = 0;
        this.f23563h = false;
        this.f23564i = false;
        ?? r12 = 0;
        ?? r13 = 0;
        ?? r14 = 0;
        boolean r15 = false;
        ?? r16 = 0;
        boolean r17 = false;
        boolean r18 = false;
        boolean r19 = false;
        int r110 = 0;
        int r111 = 0;
        GL10 r20 = null;
        Runnable r112 = null;
    L197:
        f r113 = GLTextureView.f11364k;     // Catch: Throwable -> L112
        ?? r21 = r11;
        ?? r22 = r12;
        ?? r23 = r13;
        ?? r24 = r14;
        ?? r25 = r16;
        monitor-enter(r113);     // Catch: Throwable -> L112
    L196:
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L6:
        if (this.f23560a == true) goto L7;
        if (this.f23571p.isEmpty() == false) goto L20;
        boolean r26 = this.d;     // Catch: Throwable -> L16
        boolean r27 = this.f23562c;     // Catch: Throwable -> L16
        if (r26 == r27) goto L24;
        this.d = r27;     // Catch: Throwable -> L16
        GLTextureView.f11364k.notifyAll();     // Catch: Throwable -> L16
        StringBuilder r28 = new StringBuilder();     // Catch: Throwable -> L16
        boolean r114 = r27;
        r28.append("mPaused is now ");     // Catch: Throwable -> L16
        r28.append(this.d);     // Catch: Throwable -> L16
        r28.append(" tid=");     // Catch: Throwable -> L16
        r28.append(getId());     // Catch: Throwable -> L16
        Log.i("GLThread", r28.toString());     // Catch: Throwable -> L16
    L26:
        if (this.f23565j == false) goto L28;
        Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());     // Catch: Throwable -> L16
        f();     // Catch: Throwable -> L16
        e();     // Catch: Throwable -> L16
        this.f23565j = false;     // Catch: Throwable -> L16
        r19 = true;
    L28:
        if (r15 == false) goto L30;
        f();     // Catch: Throwable -> L16
        e();     // Catch: Throwable -> L16
        r15 = false;
    L30:
        if (r114 == true) goto L32;
    L34:
        if (r114 == true) goto L36;
    L45:
        if (r114 == false) goto L50;
        if (GLTextureView.f11364k.c() == false) goto L50;
        this.f23573r.n();     // Catch: Throwable -> L16
        Log.i("GLThread", "terminating EGL because paused tid=" + getId());     // Catch: Throwable -> L16
    L50:
        if (this.e == true) goto L58;
        if (this.g == true) goto L58;
        Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());     // Catch: Throwable -> L16
        if (this.f23564i == false) goto L56;
        f();     // Catch: Throwable -> L16
    L56:
        this.g = true;     // Catch: Throwable -> L16
        this.f = false;     // Catch: Throwable -> L16
        GLTextureView.f11364k.notifyAll();     // Catch: Throwable -> L16
    L58:
        if (this.e == true) goto L60;
    L62:
        if (r18 == false) goto L65;
        Log.i("GLThread", "sending render notification tid=" + getId());     // Catch: Throwable -> L16
        this.f23570o = true;     // Catch: Throwable -> L16
        GLTextureView.f11364k.notifyAll();     // Catch: Throwable -> L16
        r17 = false;
        r18 = false;
    L65:
        if (b() == true) goto L67;
        ?? r29 = r22;
    L179:
        StringBuilder r30 = new StringBuilder();     // Catch: Throwable -> L16
        r30.append("waiting tid=");     // Catch: Throwable -> L16
        r30.append(getId());     // Catch: Throwable -> L16
        r30.append(" mHaveEglContext: ");     // Catch: Throwable -> L16
        r30.append(this.f23563h);     // Catch: Throwable -> L16
        r30.append(" mHaveEglSurface: ");     // Catch: Throwable -> L16
        r30.append(this.f23564i);     // Catch: Throwable -> L16
        r30.append(" mPaused: ");     // Catch: Throwable -> L16
        r30.append(this.d);     // Catch: Throwable -> L16
        r30.append(" mHasSurface: ");     // Catch: Throwable -> L16
        r30.append(this.e);     // Catch: Throwable -> L16
        r30.append(" mSurfaceIsBad: ");     // Catch: Throwable -> L16
        r30.append(this.f);     // Catch: Throwable -> L16
        r30.append(" mWaitingForSurface: ");     // Catch: Throwable -> L16
        r30.append(this.g);     // Catch: Throwable -> L16
        r30.append(" mWidth: ");     // Catch: Throwable -> L16
        r30.append(this.f23566k);     // Catch: Throwable -> L16
        r30.append(" mHeight: ");     // Catch: Throwable -> L16
        r30.append(this.f23567l);     // Catch: Throwable -> L16
        r30.append(" mRequestRender: ");     // Catch: Throwable -> L16
        r30.append(this.f23569n);     // Catch: Throwable -> L16
        r30.append(" mRenderMode: ");     // Catch: Throwable -> L16
        r30.append(this.f23568m);     // Catch: Throwable -> L16
        Log.i("GLThread", r30.toString());     // Catch: Throwable -> L16
        GLTextureView.f11364k.wait();     // Catch: Throwable -> L16
        r20 = r20;
        r22 = r29 == true ? 1 : 0;
        r23 = r23 == true ? 1 : 0;
        r21 = 0;
        r24 = r24;
        r25 = r25;
        goto L196
    L67:
        if (this.f23563h == true) goto L95;
        if (r19 == false) goto L70;
        r29 = r22;
        boolean r31 = false;
        Runnable r32 = null;
    L96:
        r23 = r23;
        r24 = r24;
        r25 = r25;
        if (this.f23563h == false) goto L102;
        r23 = r23;
        r24 = r24;
        r25 = r25;
        if (this.f23564i == true) goto L102;
        this.f23564i = true;     // Catch: Throwable -> L16
        r23 = 1;
        r24 = 1;
        r25 = 1;
    L102:
        if (this.f23564i == true) goto L104;
        r19 = r31;
        goto L179
    L104:
        if (this.f23572q == false) goto L106;
        r110 = this.f23566k;     // Catch: Throwable -> L16
        r111 = this.f23567l;     // Catch: Throwable -> L16
        Log.i("GLThread", "noticing that we want render notification tid=" + getId());     // Catch: Throwable -> L16
        this.f23572q = false;     // Catch: Throwable -> L16
        boolean r33 = false;
        ?? r34 = 1;
        ?? r35 = 1;
        r17 = true;
    L107:
        this.f23569n = r33;     // Catch: Throwable -> L16
        GLTextureView.f11364k.notifyAll();     // Catch: Throwable -> L16
        r19 = r31;
        ?? r36 = r33;
        r12 = r29;
        r13 = r34;
        r14 = r24;
        r16 = r35;
    L108:
        monitor-exit(r113);     // Catch: Throwable -> L16
        if (r112 != null) goto L110;
        if (r13 == 0) goto L127;
        Log.w("GLThread", "egl createSurface");     // Catch: Throwable -> L112
        if (this.f23573r.l() == false) goto L117;
        r13 = r36;
        goto L127
    L117:
        f r37 = GLTextureView.f11364k;     // Catch: Throwable -> L112
        monitor-enter(r37);     // Catch: Throwable -> L112
        this.f = true;     // Catch: Throwable -> L123
        r37.notifyAll();     // Catch: Throwable -> L123
        monitor-exit(r37);     // Catch: Throwable -> L123
    L111:
        r11 = r36;
        r20 = r20;
    L123:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L127:
        if (r14 == 0) goto L142;
        ug.d r38 = this.f23573r;     // Catch: Throwable -> L112
        GL r39 = ((EGLContext) r38.g).getGL();     // Catch: Throwable -> L112
        GLTextureView r40 = (GLTextureView) ((WeakReference) r38.f22357b).get();     // Catch: Throwable -> L112
        if (r40 == null) goto L141;
        f r41 = GLTextureView.f11364k;     // Catch: Throwable -> L112
        int r42 = r40.f11368h;     // Catch: Throwable -> L112
        if ((r42 & 3) == 0) goto L141;
        if ((r42 & 1) == 0) goto L135;
        ?? r43 = 1;
    L137:
        if ((r42 & 2) == 0) goto L139;
        h r44 = new h();     // Catch: Throwable -> L112
    L140:
        r39 = GLDebugHelper.wrap(r39, r43, r44);     // Catch: Throwable -> L112
        goto L141
    L139:
        r44 = null;
        goto L140
    L135:
        r43 = r36;
    L141:
        GL10 r45 = (GL10) r39;     // Catch: Throwable -> L112
        GLTextureView.f11364k.a(r45);     // Catch: Throwable -> L112
        r20 = r45;
        r14 = r36;
    L142:
        if (r12 == 0) goto L147;
        Log.w("GLThread", "onSurfaceCreated");     // Catch: Throwable -> L112
        GLTextureView r46 = (GLTextureView) this.s.get();     // Catch: Throwable -> L112
        if (r46 == null) goto L146;
        ((xp.c) r46.f11367c).onSurfaceCreated(r20, (EGLConfig) this.f23573r.f);     // Catch: Throwable -> L112
    L146:
        r12 = r36;
    L147:
        if (r16 == 0) goto L152;
        Log.w("GLThread", "onSurfaceChanged(" + r110 + ", " + r111 + ")");     // Catch: Throwable -> L112
        GLTextureView r47 = (GLTextureView) this.s.get();     // Catch: Throwable -> L112
        if (r47 == null) goto L151;
        ((xp.c) r47.f11367c).onSurfaceChanged(r20, r110, r111);     // Catch: Throwable -> L112
    L151:
        r16 = r36;
    L152:
        StringBuilder r48 = new StringBuilder();     // Catch: Throwable -> L112
        r48.append("onDrawFrame tid=");     // Catch: Throwable -> L112
        ?? r115 = r12;
        r48.append(getId());     // Catch: Throwable -> L112
        Log.w("GLThread", r48.toString());     // Catch: Throwable -> L112
        GLTextureView r49 = (GLTextureView) this.s.get();     // Catch: Throwable -> L112
        if (r49 == null) goto L155;
        ((xp.c) r49.f11367c).onDrawFrame(r20);     // Catch: Throwable -> L112
    L155:
        ug.d r50 = this.f23573r;     // Catch: Throwable -> L112
        if (((EGL10) r50.f22358c).eglSwapBuffers((EGLDisplay) r50.d, (EGLSurface) r50.e) == true) goto L158;
        int r51 = ((EGL10) r50.f22358c).eglGetError();     // Catch: Throwable -> L112
    L159:
        if (r51 != 12288) goto L161;
        boolean r52 = true;
    L174:
        if (r17 == false) goto L176;
        r18 = r52;
    L176:
        r20 = r20;
        r12 = r115 == true ? 1 : 0;
        r13 = r13;
        r11 = 0;
        goto L197
    L161:
        if (r51 == 12302) goto L171;
        Log.w("GLThread", "eglSwapBuffers failed: " + r51);     // Catch: Throwable -> L112
        f r53 = GLTextureView.f11364k;     // Catch: Throwable -> L112
        monitor-enter(r53);     // Catch: Throwable -> L112
        r52 = true;
        this.f = true;     // Catch: Throwable -> L168
        r53.notifyAll();     // Catch: Throwable -> L168
        monitor-exit(r53);     // Catch: Throwable -> L168
    L168:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L171:
        r52 = true;
        Log.i("GLThread", "egl context lost tid=" + getId());     // Catch: Throwable -> L112
        r15 = true;
        goto L174
    L158:
        r51 = 12288;
        goto L159
    L110:
        r112.run();     // Catch: Throwable -> L112
        r112 = r32;
        goto L111
    L106:
        r33 = false;
        r34 = r23;
        r35 = r25;
        goto L107
    L70:
        f r54 = GLTextureView.f11364k;     // Catch: Throwable -> L16
        e r55 = r54.e;     // Catch: Throwable -> L16
        if (r55 == this) goto L83;
        if (r55 == null) goto L83;
        if (r54.f23574a == true) goto L78;
        r54.f23574a = true;     // Catch: Throwable -> L16
    L78:
        if (r54.f23576c == false) goto L80;
    L79:
        boolean r56 = true;
    L85:
        if (r56 == false) goto L95;
        this.f23573r.o();     // Catch: Throwable -> L16 RuntimeException -> L89
    L88:
        this.f23563h = true;     // Catch: Throwable -> L16
        r54.notifyAll();     // Catch: Throwable -> L16
        r31 = r19;
        r32 = null;
        r29 = 1;
    L89:
        e = move-exception;
        f r57 = GLTextureView.f11364k;     // Catch: Throwable -> L16
        if (r57.e != this) goto L93;
        r57.e = null;     // Catch: Throwable -> L16
    L93:
        r57.notifyAll();     // Catch: Throwable -> L16
        throw e;     // Catch: Throwable -> L16
    L80:
        if (r55 == null) goto L82;
        r55.f23565j = true;     // Catch: Throwable -> L16
        r54.notifyAll();     // Catch: Throwable -> L16
    L82:
        r56 = false;
    L83:
        r54.e = this;     // Catch: Throwable -> L16
        r54.notifyAll();     // Catch: Throwable -> L16
    L95:
        r32 = null;
        r31 = r19;
        r29 = r22;
        goto L96
    L60:
        if (this.g == false) goto L62;
        Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());     // Catch: Throwable -> L16
        this.g = false;     // Catch: Throwable -> L16
        GLTextureView.f11364k.notifyAll();     // Catch: Throwable -> L16
        goto L62
    L36:
        if (this.f23563h == false) goto L45;
        GLTextureView r58 = (GLTextureView) this.s.get();     // Catch: Throwable -> L16
        if (r58 != null) goto L40;
        boolean r59 = false;
    L41:
        if (r59 == true) goto L43;
    L44:
        e();     // Catch: Throwable -> L16
        Log.i("GLThread", "releasing EGL context because paused tid=" + getId());     // Catch: Throwable -> L16
        goto L45
    L43:
        if (GLTextureView.f11364k.b() == false) goto L45;
    L40:
        r59 = r58.f11370j;     // Catch: Throwable -> L16
        goto L41
    L32:
        if (this.f23564i == false) goto L34;
        Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());     // Catch: Throwable -> L16
        f();     // Catch: Throwable -> L16
        goto L34
    L24:
        r114 = false;
        goto L26
    L20:
        r112 = (Runnable) this.f23571p.remove(r21);     // Catch: Throwable -> L16
        r20 = r20;
        r32 = null;
        r36 = r21;
        r12 = r22;
        r13 = r23;
        r14 = r24;
        r16 = r25;
        goto L108
    L7:
        monitor-exit(r113);     // Catch: Throwable -> L16
        f r60 = GLTextureView.f11364k;
        monitor-enter(r60);
        f();     // Catch: Throwable -> L13
        e();     // Catch: Throwable -> L13
        monitor-exit(r60);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L112:
        th = move-exception;
        monitor-enter(GLTextureView.f11364k);
        f();     // Catch: Throwable -> L187
        e();     // Catch: Throwable -> L187
        throw th;
    L187:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        if (this.d == false) goto L5;
    L17:
        return false;
    L5:
        if (this.e == false) goto L17;
        if (this.f == true) goto L17;
        if (this.f23566k <= 0) goto L17;
        if (this.f23567l <= 0) goto L17;
        if (this.f23569n == false) goto L15;
        return true;
    L15:
        if (this.f23568m != 1) goto L17;
        return true;
    }

    public final void c() {
        f r5 = GLTextureView.f11364k;
        monitor-enter(r5);
        this.f23560a = true;     // Catch: Throwable -> L10
        r5.notifyAll();     // Catch: Throwable -> L10
    L7:
        if (this.f23561b == true) goto L13;
        GLTextureView.f11364k.wait();     // Catch: Throwable -> L10 InterruptedException -> L12
    L12:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L10
        goto L7
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void d(int r5) {
        if (r5 < 0) goto L14;
        if (r5 > 1) goto L14;
        f r10 = GLTextureView.f11364k;
        monitor-enter(r10);
        this.f23568m = r5;     // Catch: Throwable -> L10
        r10.notifyAll();     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalArgumentException("renderMode");
    }

    public final void e() {
        if (this.f23563h == false) goto L9;
        this.f23573r.n();
        this.f23563h = false;
        f r5 = GLTextureView.f11364k;
        if (r5.e != this) goto L7;
        r5.e = null;
    L7:
        r5.notifyAll();
        return;
    }

    public final void f() {
        if (this.f23564i == false) goto L6;
        this.f23564i = false;
        ug.d r5 = this.f23573r;
        r5.getClass();
        Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
        r5.m();
        return;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("GLThread " + getId());
        Log.i("GLThread", "starting tid=" + getId());
        a();     // Catch: Throwable -> L5 InterruptedException -> L8
    L4:
        GLTextureView.f11364k.d(this);
        return;
    L8:
        f r5 = GLTextureView.f11364k;
    L5:
        th = move-exception;
        f r10 = GLTextureView.f11364k;
        GLTextureView.f11364k.d(this);
        throw th;
    }
}
