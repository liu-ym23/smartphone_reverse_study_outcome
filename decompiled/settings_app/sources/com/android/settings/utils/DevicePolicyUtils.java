package com.android.settings.utils;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.core.content.ContextCompat;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.SettingsApplication;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DevicePolicyUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lcom/android/settings/utils/DevicePolicyUtils;", "", "()V", "hasUserRestriction", "", "context", "Landroid/content/Context;", "restrictionKey", "", "showMaximumTimeToLock", "", "trySendShowAdminSupportDetailsIntent", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DevicePolicyUtils {
    public static final DevicePolicyUtils INSTANCE = null;

    static {
        INSTANCE = new DevicePolicyUtils();
    }

    private DevicePolicyUtils() {
    }

    @JvmStatic
    public static final boolean trySendShowAdminSupportDetailsIntent(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "restrictionKey");
        RestrictedLockUtils.EnforcedAdmin r3 = MultiSDKAdapterNew.checkIfRestrictionEnforced(r1, r2, UserHandle.myUserId());
        if (r3 != null) goto L6;
        return false;
    L6:
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(r1, r3);
        return true;
    }

    @JvmStatic
    public static final void showMaximumTimeToLock() {
        Context r0 = SettingsApplication.getContext();
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(r0, RestrictedLockUtilsInternal.checkIfMaximumTimeToLockIsSet(r0));
    }

    @JvmStatic
    public static final boolean hasUserRestriction(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "restrictionKey");
        UserManager r3 = (UserManager) ContextCompat.getSystemService(r1, UserManager.class);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.hasUserRestriction(r2);
    }
}
