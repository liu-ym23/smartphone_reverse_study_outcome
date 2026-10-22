package yt;

import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f23344c;

    public j(Runnable r5, long r10, boolean r11) {
        super(r10, r11);
        this.f23344c = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23344c.run();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Task[");
        Runnable r10 = this.f23344c;
        r5.append(r10.getClass().getSimpleName());
        r5.append('@');
        r5.append(j0.f(r10));
        r5.append(", ");
        r5.append(this.f23342a);
        r5.append(", ");
        if (this.f23343b == false) goto L5;
        String r11 = "Blocking";
    L7:
        return ai.j0.p(r5, r11, ']');
    L5:
        r11 = "Non-blocking";
        goto L7
    }
}
