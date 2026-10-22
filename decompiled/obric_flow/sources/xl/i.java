package xl;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements IHostUserDepend {
    public static void a() {
        ConcurrentHashMap r5 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.f.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.f.class) != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getAvatarURL() {
        a();
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getBoundPhone() {
        a();
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getNickname() {
        a();
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getSecUid() {
        a();
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getUniqueID() {
        a();
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final String getUserId() {
        a();
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final IHostUserDepend.UserModelExt getUserModelExt() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final boolean hasLogin() {
        a();
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final void login(Activity r5, IHostUserDepend.ILoginStatusCallback r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "loginStatusCallback");
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final void logout(Activity r5, IHostUserDepend.ILogoutStatusCallback r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "logoutStatusCallback");
        a();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend
    public final void login(Activity r5, IHostUserDepend.ILoginStatusCallback r10, Map r11, IHostUserDepend.LoginParamsExt r12) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "loginStatusCallback");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
    }
}
