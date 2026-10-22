package tj;

import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e8.f {
    public final /* synthetic */ String d;

    public b(String r5) {
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TTNetInit.onClientIPChanged(this.d);
    }
}
