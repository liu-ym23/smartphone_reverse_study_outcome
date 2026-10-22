package com.android.settingslib.enterprise;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class ManagedDeviceActionDisabledByAdminController extends BaseActionDisabledByAdminController {
    public static final ForegroundUserChecker DEFAULT_FOREGROUND_USER_CHECKER = null;
    private final ForegroundUserChecker mForegroundUserChecker;
    private final UserHandle mPreferredUserHandle;
    private final ActionDisabledLearnMoreButtonLauncher.ResolveActivityChecker mResolveActivityChecker;

    interface ForegroundUserChecker {
        boolean isUserForeground(Context r1, UserHandle r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$1BlMmvhgLvZD2w6t-oOUkGMFaKI, reason: not valid java name */
    public static /* synthetic */ boolean m760$r8$lambda$1BlMmvhgLvZD2w6toOUkGMFaKI(Context r0, UserHandle r1) {
        return isUserForeground(r0, r1);
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public void setupLearnMoreButton(Context r1) {
    }

    static {
        DEFAULT_FOREGROUND_USER_CHECKER = new ManagedDeviceActionDisabledByAdminController$$ExternalSyntheticLambda0();
    }

    ManagedDeviceActionDisabledByAdminController(DeviceAdminStringProvider r1, UserHandle r2, ForegroundUserChecker r3, ActionDisabledLearnMoreButtonLauncher.ResolveActivityChecker r4) {
        super(r1);
        this.mPreferredUserHandle = (UserHandle) Objects.requireNonNull(r2);
        this.mForegroundUserChecker = (ForegroundUserChecker) Objects.requireNonNull(r3);
        this.mResolveActivityChecker = (ActionDisabledLearnMoreButtonLauncher.ResolveActivityChecker) Objects.requireNonNull(r4);
    }

    private static boolean isUserForeground(Context r1, UserHandle r2) {
        return ((UserManager) r1.createContextAsUser(r2, 0).getSystemService(UserManager.class)).isUserForeground();
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public String getAdminSupportTitle(String r1) {
        return this.mStringProvider.getDefaultDisabledByPolicyTitle();
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public CharSequence getAdminSupportContentString(Context r1, CharSequence r2) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        return this.mStringProvider.getDefaultDisabledByPolicyContent();
    }
}
