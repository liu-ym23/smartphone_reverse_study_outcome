package w0;

import android.view.View;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ai.model.widgets.c f22672a;

    public b(com.bytedance.ai.model.widgets.c r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        this.f22672a = r5;
    }

    @Override // w0.i
    public final void a(long r5, long r10) {
    }

    @Override // w0.g
    public final void b() {
    }

    @Override // w0.i
    public final View d() {
        return null;
    }

    @Override // w0.d
    public final m1.k i() {
        return null;
    }

    @Override // w0.k
    public final void onMessageToAIBridge(String r5, JsonObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
    }

    @Override // w0.k
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        String r10 = "ViewProvider-" + this.f22672a.f2330b.getPageType();
        String r11 = "onMessageToJS service null msg " + r5;
        Intrinsics.checkNotNullParameter(r10, "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L6;
        r12.d(r10, r11);
        return;
    }

    @Override // m2.a
    public final m3.a d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        return null;
    }
}
