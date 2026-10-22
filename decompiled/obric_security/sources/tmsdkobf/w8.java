package tmsdkobf;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class w8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f598a;

    public w8(Context r1) {
        this.f598a = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        n9.a(this.f598a);     // Catch: Throwable -> L4
        return;
    }
}
