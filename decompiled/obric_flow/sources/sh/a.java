package sh;

import com.bytedance.pia.core.worker.binding.BaseModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callback f21904b;

    public /* synthetic */ a(Callback r5, int r10) {
        this.f21903a = r10;
        this.f21904b = r5;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        int r10 = this.f21903a;
        Callback r11 = this.f21904b;
        String r12 = (String) r5;
        switch(r10) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        BaseModule.a(r11, r12);
        return;
    L6:
        BaseModule.b(r11, r12);
    }
}
