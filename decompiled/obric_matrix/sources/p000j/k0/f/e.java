package p000j.k0.f;

import java.io.IOException;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IOException f17843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IOException f17844g;

    public e(IOException r1) {
        super(r1);
        this.f17843f = r1;
        this.f17844g = r1;
    }

    public void a(IOException r2) {
        c.a(this.f17843f, r2);
        this.f17844g = r2;
    }

    public IOException b() {
        return this.f17843f;
    }

    public IOException c() {
        return this.f17844g;
    }
}
