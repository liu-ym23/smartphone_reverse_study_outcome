package com.android.settings.spa.app.appinfo;

import androidx.fragment.app.Fragment;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.obric.capabilitykit.common.Ext;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: AppInfoSettingsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ0\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/android/settings/spa/app/appinfo/AppInfoSettingsProvider;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "getRoute", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, AccountInfoBundleKey.USER_ID, "", "startAppInfoSettings", "", "uid", "source", "Landroidx/fragment/app/Fragment;", Ext.KEY_REQUEST, "sourceMetricsCategory", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppInfoSettingsProvider {
    public static final AppInfoSettingsProvider INSTANCE = null;
    private static final String name = null;

    @JvmStatic
    public static final void startAppInfoSettings(String r0, int r1, Fragment r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r0, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    private AppInfoSettingsProvider() {
    }

    static {
        INSTANCE = new AppInfoSettingsProvider();
        name = "AppInfoSettings";
    }

    public final String getName() {
        return name;
    }

    public final String getRoute(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        return name + IOUtils.DIR_SEPARATOR_UNIX + r2 + IOUtils.DIR_SEPARATOR_UNIX + r3;
    }
}
