package com.android.settingslib.enterprise;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.settingslib.RestrictedLockUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionDisabledLearnMoreButtonLauncher {
    public static ResolveActivityChecker DEFAULT_RESOLVE_ACTIVITY_CHECKER;

    interface ResolveActivityChecker {
        boolean canResolveActivityAsUser(PackageManager r1, String r2, UserHandle r3);
    }

    protected void finishSelf() {
    }

    protected abstract void launchShowAdminPolicies(Context r1, UserHandle r2, ComponentName r3);

    protected abstract void launchShowAdminSettings(Context r1);

    public abstract void setLearnMoreButton(Runnable r1);

    public ActionDisabledLearnMoreButtonLauncher() {
    }

    static {
        DEFAULT_RESOLVE_ACTIVITY_CHECKER = new ActionDisabledLearnMoreButtonLauncher$$ExternalSyntheticLambda1();
    }

    static /* synthetic */ boolean lambda$static$0(PackageManager r1, String r2, UserHandle r3) {
        if (r1.resolveActivityAsUser(createLearnMoreIntent(r2), 65536, r3.getIdentifier()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setupLearnMoreButtonToShowAdminPolicies(final Context r2, int r3, final RestrictedLockUtils.EnforcedAdmin r4) {
        Objects.requireNonNull(r2, "context cannot be null");
        if (isSameProfileGroup(r2, r3) == false) goto L5;
    L6:
        setLearnMoreButton(new ActionDisabledLearnMoreButtonLauncher$$ExternalSyntheticLambda0(this, r2, r4));
        return;
    L5:
        if (isEnforcedByDeviceOwnerOnSystemUserMode(r2, r3) == true) goto L6;
    }

    /* JADX INFO: renamed from: lambda$setupLearnMoreButtonToShowAdminPolicies$1$com-android-settingslib-enterprise-ActionDisabledLearnMoreButtonLauncher, reason: not valid java name */
    /* synthetic */ void m759xd743b19d(Context r1, RestrictedLockUtils.EnforcedAdmin r2) {
        showAdminPolicies(r1, r2);
    }

    public final void setupLearnMoreButtonToLaunchHelpPage(final Context r2, final String r3, final UserHandle r4) {
        Objects.requireNonNull(r2, "context cannot be null");
        Objects.requireNonNull(r3, "url cannot be null");
        setLearnMoreButton(new ActionDisabledLearnMoreButtonLauncher$$ExternalSyntheticLambda2(this, r2, r3, r4));
    }

    /* JADX INFO: renamed from: lambda$setupLearnMoreButtonToLaunchHelpPage$2$com-android-settingslib-enterprise-ActionDisabledLearnMoreButtonLauncher, reason: not valid java name */
    /* synthetic */ void m758xbb0b65cf(Context r1, String r2, UserHandle r3) {
        showHelpPage(r1, r2, r3);
    }

    protected boolean isSameProfileGroup(Context r1, int r2) {
        UserManager r0 = (UserManager) r1.getSystemService(UserManager.class);
        return r0.isSameProfileGroup(r2, r0.getProcessUserId());
    }

    private boolean isEnforcedByDeviceOwnerOnSystemUserMode(Context r2, int r3) {
        if (r3 == 0) goto L6;
        return false;
    L6:
        if (r3 != ((DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class)).getDeviceOwnerUserId()) goto L9;
        return true;
    L9:
        return false;
    }

    public void showHelpPage(Context r1, String r2, UserHandle r3) {
        r1.startActivityAsUser(createLearnMoreIntent(r2), r3);
        finishSelf();
    }

    protected final boolean canLaunchHelpPage(PackageManager r1, String r2, UserHandle r3, ResolveActivityChecker r4) {
        return r4.canResolveActivityAsUser(r1, r2, r3);
    }

    private void showAdminPolicies(Context r2, RestrictedLockUtils.EnforcedAdmin r3) {
        if (r3 != null) goto L4;
    L6:
        launchShowAdminSettings(r2);
    L7:
        finishSelf();
        return;
    L4:
        if (r3.component == null) goto L6;
        launchShowAdminPolicies(r2, r3.user, r3.component);
        goto L7
    }

    private static Intent createLearnMoreIntent(String r2) {
        return new Intent("android.intent.action.VIEW", Uri.parse(r2)).setFlags(276824064);
    }
}
