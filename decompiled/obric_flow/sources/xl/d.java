package xl;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements IHostMediaDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend
    public final void handleJsInvoke(Context r5, hj.a r10, IChooseMediaResultCallback r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(null, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        throw null;
    }
}
