package xl;

import android.app.Application;
import android.content.Context;
import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IHostContextDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final int getAppId() {
        return 0;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getAppName() {
        return k5.d.f18605j;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final Application getApplication() {
        Application r5 = k5.d.s;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getBoeChannel() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getChannel() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getCurrentTelcomCarrier() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getDeviceId() {
        return k5.d.f18610o;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getPPEChannel() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getPackageName() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final List getSettings(List r5) {
        Intrinsics.checkNotNullParameter(r5, "settingKeys");
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getSkinName() {
        return WidgetView.UI_MODE_LIGHT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getSkinType() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getUpdateVersion() {
        return k5.d.f18608m;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final long getVersionCode() {
        return Long.parseLong(k5.d.f18606k);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getVersionName() {
        return k5.d.f18606k;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isBaseMode() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isBoeEnable() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isDebuggable() {
        return k5.d.f18611p;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isPPEEnable() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isTeenMode() {
        return false;
    }
}
