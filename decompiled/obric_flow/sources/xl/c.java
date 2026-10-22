package xl;

import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IReportADLogResultCallback;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements IHostLogDependV2 {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final void handleReportADLog(cj.d r5, String r10, hj.c r11, IReportADLogResultCallback r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(null, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final void onEventV3Map(String r5, Map r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        ConcurrentHashMap r11 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.a.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.a.class) != null) goto L9;
        if (r10 == null) goto L6;
        new JSONObject(r10);
    L6:
        Intrinsics.checkNotNullParameter(r5, "event");
        return;
    L9:
        throw new ClassCastException();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final void putCommonParams(Map r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        ConcurrentHashMap r11 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.a.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.a.class) != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final Unit reportJSBError(cj.d r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final Unit reportJSBFetchError(cj.d r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2
    public final void onEventV3Map(String r5, Map r10, cj.d r11) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        ConcurrentHashMap r12 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.a.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.a.class) != null) goto L9;
        if (r10 == null) goto L6;
        new JSONObject(r10);
    L6:
        Intrinsics.checkNotNullParameter(r5, "event");
        return;
    L9:
        throw new ClassCastException();
    }
}
