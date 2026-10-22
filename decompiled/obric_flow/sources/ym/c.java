package ym;

import android.view.Choreographer;
import com.lynx.tasm.b0;
import com.lynx.tasm.core.LynxLayoutProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a6.a f23295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f23296b;

    public c(d r5, a6.a r10) {
        this.f23296b = r5;
        this.f23295a = r10;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r5) {
        b0 r10 = (b0) this.f23296b.f23297a;
        boolean r11 = r10.M;
        a6.a r12 = this.f23295a;
        if (r11 == false) goto L9;
        LynxLayoutProxy r13 = (LynxLayoutProxy) r10.f10144l.get();
        if (r13 != null) goto L7;
        return;
    L7:
        r13.b(r12);
        return;
    L9:
        r12.run();
    }
}
