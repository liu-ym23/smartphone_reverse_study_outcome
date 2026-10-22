package zp;

import android.util.Log;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23576c;
    public boolean d;
    public e e;

    public final synchronized void a(GL10 r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f23575b == false) goto L7;
    L13:
        monitor-exit(this);
        return;
    L7:
        if (this.f23574a == true) goto L9;
        this.f23574a = true;     // Catch: Throwable -> L11
    L9:
        String r10 = r5.glGetString(7937);     // Catch: Throwable -> L11
        this.f23576c = !r10.startsWith("Q3Dimension MSM7500 ");     // Catch: Throwable -> L11
        notifyAll();     // Catch: Throwable -> L11
        this.d = !this.f23576c;     // Catch: Throwable -> L11
        Log.w("GLThreadManager", "checkGLDriver renderer = \"" + r10 + "\" multipleContextsAllowed = " + this.f23576c + " mLimitedGLESContexts = " + this.d);     // Catch: Throwable -> L11
        this.f23575b = true;     // Catch: Throwable -> L11
        goto L13
    }

    public final synchronized boolean b() {
        monitor-enter(this);
        boolean r5 = this.d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f23574a == true) goto L6;
        this.f23574a = true;     // Catch: Throwable -> L10
    L6:
        boolean r5 = !this.f23576c;
        monitor-exit(this);
        return r5;
    }

    public final synchronized void d(e r10) {
        monitor-enter(this);
        Log.i("GLThread", "exiting tid=" + r10.getId());     // Catch: Throwable -> L7
        r10.f23561b = true;     // Catch: Throwable -> L7
        if (this.e != r10) goto L9;
        this.e = null;     // Catch: Throwable -> L7
    L9:
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
