package com.android.settings.enterprise;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.view.View;
import com.android.settings.DeviceAdminAdd;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settingslib.enterprise.ActionDisabledLearnMoreButtonLauncher;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ActionDisabledLearnMoreButtonLauncherImpl extends ActionDisabledLearnMoreButtonLauncher {
    private final Activity mActivity;
    private final OAlertDialog mBuilder;

    ActionDisabledLearnMoreButtonLauncherImpl(Activity r2, OAlertDialog r3) {
        this.mActivity = (Activity) Objects.requireNonNull(r2, "activity cannot be null");
        this.mBuilder = (OAlertDialog) Objects.requireNonNull(r3, "builder cannot be null");
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledLearnMoreButtonLauncher
    public void setLearnMoreButton(final Runnable r4) {
        Objects.requireNonNull(r4, "action cannot be null");
        View r0 = this.mBuilder.getNegativeButton();
        if ((r0 instanceof OButton) == false) goto L5;
        r0.setVisibility(0);
        ((OButton) r0).setText(R.string.learn_more);
        r0.setOnClickListener(new ActionDisabledLearnMoreButtonLauncherImpl$$ExternalSyntheticLambda0(r4));
    L5:
        View r1 = this.mBuilder.rootView.findViewById(android.R.id.button3);
        if (r1 == null) goto L9;
        r1.setOnClickListener(new AnonymousClass1(this, r4));
        return;
    }

    static /* synthetic */ void lambda$setLearnMoreButton$0(Runnable r0, View r1) {
        r0.run();
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledLearnMoreButtonLauncher
    protected void launchShowAdminPolicies(Context r3, UserHandle r4, ComponentName r5) {
        Objects.requireNonNull(r3, "context cannot be null");
        Objects.requireNonNull(r4, "user cannot be null");
        Objects.requireNonNull(r5, "admin cannot be null");
        Intent r6 = new Intent().setClass(this.mActivity, DeviceAdminAdd.class).putExtra("android.app.extra.DEVICE_ADMIN", r5).putExtra(DeviceAdminAdd.EXTRA_CALLED_FROM_SUPPORT_DIALOG, true);
        this.mActivity.startActivityAsUser(r6, r4);
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledLearnMoreButtonLauncher
    protected void launchShowAdminSettings(Context r3) {
        Objects.requireNonNull(r3, "context cannot be null");
        Intent r4 = new Intent().setClass(this.mActivity, Settings.DeviceManagerActivity.class).addFlags(268435456);
        this.mActivity.startActivity(r4);
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledLearnMoreButtonLauncher
    protected void finishSelf() {
        this.mActivity.finish();
    }
}
