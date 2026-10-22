package tmsdkobf;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f87a;

    public interface a {
        void a(Bundle r1);

        void b(Bundle r1);
    }

    public a6() {
        this.f87a = null;
    }

    protected void a(int r2, Bundle r3) {
        a r1 = this.f87a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 != 1) goto L8;
        r1.a(r3);
        return;
    L8:
        if (r2 != 2) goto L13;
        r1.b(r3);
        return;
    }

    public void a(a r1) {
        this.f87a = r1;
    }
}
