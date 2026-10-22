package tj;

import com.bytedance.ttnet.TTNetInit;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e8.f {
    public final /* synthetic */ List d;
    public final /* synthetic */ List e;

    public c(List r5, List r10) {
        this.d = r5;
        this.e = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TTNetInit.onPublicIPsChanged(this.d, this.e);
    }
}
