package l.b.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class h extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Throwable f21587f;

    h(String r1) {
        super(r1);
    }

    h(String r1, Throwable r2) {
        super(r1);
        this.f21587f = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21587f;
    }
}
