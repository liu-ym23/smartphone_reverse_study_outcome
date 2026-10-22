package yh;

import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.utils.m;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f23274a = null;

    static {
        f23274a = new ah.b("pia.removeSnapshot", PiaMethod$Scope.f6953b, a.f23267b);
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        b r13 = (b) r10;
        Intrinsics.checkNotNullParameter(r5, "bridge");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        m.b(new i(r13, 24, r12, r11));
    }
}
