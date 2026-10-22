package d.b.s.a.c0.a;

import android.os.Message;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    public d(BlockingQueue<e> r1, String r2, String r3) {
        super(r1, r2, r3);
    }

    @Override // d.b.s.a.c0.a.a
    public void a(c r1) {
        if (r1 == null) goto L5;
        r1.j();
        return;
    }

    @Override // d.b.s.a.c0.a.a
    public void b() {
        this.f14673f.removeMessages(1);
    }

    @Override // d.b.s.a.c0.a.a
    public void f() {
        b();
        this.f14673f.sendEmptyMessageDelayed(1, 2000);
    }

    @Override // d.b.s.a.c0.a.a, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.what != 1) goto L12;
        a.f14671k.g();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }
}
