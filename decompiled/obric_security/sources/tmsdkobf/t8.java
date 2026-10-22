package tmsdkobf;

import android.view.MotionEvent;
import android.view.Window;

/* JADX INFO: loaded from: classes5.dex */
public class t8 extends wi {
    public final String b;
    public final g2 c;

    public t8(Window.Callback r1, String r2, g2 r3) {
        super(r1);
        this.b = r2;
        this.c = r3;
    }

    @Override // tmsdkobf.wi, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r6) {
        g2 r0 = this.c;
        String r1 = this.b;
        wk.a r2 = (wk.a) r0;
        if (r2.f607a.get() == true) goto L17;
        Object r3 = v8.i;
        monitor-enter(r3);
        v8 r4 = v8.k;     // Catch: Throwable -> L18
        if (r4 != null) goto L12;
        r4 = new v8();     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
    L15:
        r4.b = r1;
        r4.c = r6.getAction();
        r4.d = r6.getDeviceId();
        r4.e = r6.getToolType(0);
        r4.f = r6.getPressure();
        r4.g = r6.getSize();
        r4.h = System.currentTimeMillis();
        r2.b.obtainMessage(2, r4).sendToTarget();
        goto L17
    L12:
        v8.k = r4.f571a;     // Catch: Throwable -> L18
        v8.j--;     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        r4.f571a = null;
    L18:
        th = move-exception;
        throw th;
    L17:
        return super.dispatchTouchEvent(r6);
    }
}
