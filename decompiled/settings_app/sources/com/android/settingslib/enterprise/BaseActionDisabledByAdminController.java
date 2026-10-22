package com.android.settingslib.enterprise;

import com.android.internal.util.Preconditions;
import com.android.settingslib.RestrictedLockUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseActionDisabledByAdminController implements ActionDisabledByAdminController {
    protected RestrictedLockUtils.EnforcedAdmin mEnforcedAdmin;
    protected int mEnforcementAdminUserId;
    protected ActionDisabledLearnMoreButtonLauncher mLauncher;
    protected final DeviceAdminStringProvider mStringProvider;

    BaseActionDisabledByAdminController(DeviceAdminStringProvider r1) {
        this.mStringProvider = r1;
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public final void initialize(ActionDisabledLearnMoreButtonLauncher r2) {
        this.mLauncher = (ActionDisabledLearnMoreButtonLauncher) Objects.requireNonNull(r2, "launcher cannot be null");
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public final void updateEnforcedAdmin(RestrictedLockUtils.EnforcedAdmin r1, int r2) {
        assertInitialized();
        this.mEnforcementAdminUserId = r2;
        this.mEnforcedAdmin = (RestrictedLockUtils.EnforcedAdmin) Objects.requireNonNull(r1, "admin cannot be null");
    }

    protected final void assertInitialized() {
        if (this.mLauncher == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "must call initialize() first");
        return;
    L5:
        r1 = false;
        goto L6
    }
}
