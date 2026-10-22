package com.android.settings;

import android.app.Activity;
import com.android.settings.servicemanager.IPermissionControllerHelp;
import kotlin.Metadata;

/* JADX INFO: compiled from: PermissionControllerHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/PermissionControllerHelp;", "Lcom/android/settings/servicemanager/IPermissionControllerHelp;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PermissionControllerHelp implements IPermissionControllerHelp {
    public static final PermissionControllerHelp INSTANCE = null;

    static {
        INSTANCE = new PermissionControllerHelp();
    }

    private PermissionControllerHelp() {
    }

    @Override // com.android.settings.servicemanager.IPermissionControllerHelp
    public void launchPermissionPage(Activity r1) {
        IPermissionControllerHelp.DefaultImpls.launchPermissionPage(this, r1);
    }

    @Override // com.android.settings.servicemanager.IPermissionControllerHelp
    public void startManageLocationPermissionsActivity(Activity r1) {
        IPermissionControllerHelp.DefaultImpls.startManageLocationPermissionsActivity(this, r1);
    }

    @Override // com.android.settings.servicemanager.IPermissionControllerHelp
    public void startManagePermissionsActivity(Activity r1, CharSequence r2, int r3, String r4) {
        IPermissionControllerHelp.DefaultImpls.startManagePermissionsActivity(this, r1, r2, r3, r4);
    }
}
