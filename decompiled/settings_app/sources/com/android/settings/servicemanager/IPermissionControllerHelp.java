package com.android.settings.servicemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.UserHandle;
import com.android.settings.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IPermissionControllerHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/android/settings/servicemanager/IPermissionControllerHelp;", "", "launchPermissionPage", "", "activity", "Landroid/app/Activity;", "startManageLocationPermissionsActivity", "startManagePermissionsActivity", "appName", "", "uid", "", "pkgName", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IPermissionControllerHelp {

    /* JADX INFO: compiled from: IPermissionControllerHelp.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void launchPermissionPage(IPermissionControllerHelp r1, Activity r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            Intent r3 = new Intent("com.security.ACTION_VIEW_PERMISSION_PRIVACY");
            r3.setPackage("com.android.permissioncontroller");
            Utils.startActivity(r2, r3);
        }

        public static void startManagePermissionsActivity(IPermissionControllerHelp r1, Activity r2, CharSequence r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "appName");
            Intrinsics.checkNotNullParameter(r5, "pkgName");
            Intent r6 = new Intent("com.android.permissioncontroller.permissionplus.AppPermissionGroup");
            r6.putExtra("PACKAGE_NAME", r5);
            r6.putExtra("APP_NAME", r3);
            r6.putExtra("USER", UserHandle.getUserHandleForUid(r4));
            Utils.startActivity(r2, r6, 0);
        }

        public static void startManageLocationPermissionsActivity(IPermissionControllerHelp r1, Activity r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            Utils.startActivity(r2, new Intent("com.android.permissioncontroller.action.PermissionGroupApp"));
        }
    }

    void launchPermissionPage(Activity r1);

    void startManageLocationPermissionsActivity(Activity r1);

    void startManagePermissionsActivity(Activity r1, CharSequence r2, int r3, String r4);
}
