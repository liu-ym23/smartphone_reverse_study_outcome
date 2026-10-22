package yt;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.d1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f23341a;

    public h(long r10, String r11, int r12, int r13) {
        this.f23341a = new c(r10, r11, r12, r13);
    }

    public void close() {
        this.f23341a.close();
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        c.e(this.f23341a, r10, false, 6);
    }

    @Override // kotlinx.coroutines.z
    public final void dispatchYield(CoroutineContext r5, Runnable r10) {
        c.e(this.f23341a, r10, true, 2);
    }
}
