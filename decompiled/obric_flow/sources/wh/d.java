package wh;

import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.plugins.PrefetchPlugin;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.worker.Worker$Status;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rh.i;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f22866a = null;

    static {
        f22866a = new ah.b("pia.postWorkerMessage", PiaMethod$Scope.f6953b, a.f22863a);
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        b r13 = (b) r10;
        Intrinsics.checkNotNullParameter(r5, "bridge");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        if (r13.a() != null) goto L6;
        td.b.c("Parameter 'data' requested!", r12);
        return;
    L6:
        nh.d r14 = r5.f17099b;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.pia.core.runtime.PiaRuntime");
        nh.c r15 = r14.j("prefetch");
        Worker$Status r16 = null;
        if ((r15 instanceof PrefetchPlugin) == false) goto L9;
        PrefetchPlugin r17 = (PrefetchPlugin) r15;
    L10:
        if (r17 == null) goto L14;
        p r18 = r17.d;
        if (r18 == null) goto L14;
        i r19 = (i) r18.f23313c;
    L15:
        if (r19 == null) goto L17;
        r16 = r19.f21775u;
    L17:
        if (r16 != null) goto L19;
        int r20 = -1;
    L21:
        if (r20 != 1) goto L23;
        String r21 = r13.a();
        if (r19.e() == false) goto L37;
        r19.f21769n.postMessage(r21);
        j.A(r19.f21763h + "Post message to worker (Message: " + r21 + ")");
    L37:
        r11.accept(Unit.INSTANCE);
        return;
    L23:
        if (r20 != 2) goto L25;
    L32:
        r12.accept(new PiaMethod$Error("{\"state\":\"fetching\"}"));
        return;
    L25:
        if (r20 == 3) goto L32;
        if (r20 == 4) goto L30;
        r12.accept(new PiaMethod$Error("{\"state\":\"unusable\"}"));
        return;
    L30:
        r12.accept(new PiaMethod$Error("{\"state\":\"terminate\"}"));
        return;
    L19:
        r20 = c.f22865a[r16.ordinal()];
    L14:
        r19 = null;
        goto L15
    L9:
        r17 = null;
        goto L10
    }
}
