package v0;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f22487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f22488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f22489c;
    public long d;
    public boolean e;
    public final /* synthetic */ c f;

    public b(c r5) {
        this.f = r5;
        this.f22487a = new Handler(Looper.getMainLooper());
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r5 = this.f;
        if (r5.getRootView() != null) goto L5;
        return;
    L5:
        if (r5.getRootView().getParent() != null) goto L8;
        return;
    L8:
        if (this.e == false) goto L10;
        float r10 = 1.0f;
    L11:
        float r11 = (this.f22488b - r5.getX()) * r10;
        float r12 = (this.f22489c - r5.getY()) * r10;
        int r13 = c.f22490p;
        r5.setX(r5.getX() + r11);
        r5.setY(r5.getY() + r12);
        if (r10 >= 1.0f) goto L16;
        this.f22487a.post(this);
        return;
    L16:
        return;
    L10:
        r10 = Math.min(1.0f, (System.currentTimeMillis() - this.d) / 400.0f);
        goto L11
    }
}
