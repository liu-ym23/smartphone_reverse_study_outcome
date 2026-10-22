package xl;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements IHostLocationPermissionDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend
    public final void requestPermission(Activity r5, cj.d r10, String r11, OnPermissionGrantCallback r12) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        Intrinsics.checkNotNullParameter(r12, "callback");
    }
}
