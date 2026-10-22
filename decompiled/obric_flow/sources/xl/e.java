package xl;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements IHostPermissionDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend
    public final boolean isPermissionAllGranted(Context r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "permission");
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend
    public final void requestPermission(Activity r5, cj.d r10, String r11, String[] r12, OnPermissionCallback r13) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        Intrinsics.checkNotNullParameter(r12, "permission");
        Intrinsics.checkNotNullParameter(r13, "callback");
    }
}
