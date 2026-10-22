package tmsdkobf;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class vd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f580a;

    public vd(int r1) {
        this.f580a = new AtomicInteger();
    }

    public boolean a() {
        if (this.f580a.get() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(int r1) {
        this.f580a.set(r1);
    }
}
