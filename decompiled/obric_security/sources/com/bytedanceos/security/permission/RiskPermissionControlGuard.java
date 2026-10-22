package com.bytedanceos.security.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedanceos.application.AppEntry;
import com.bytedanceos.application.AppListLoader;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.safecheck.riskcontrol.domain.settings.RiskControlSettingsSnapshotStore;
import com.obric.safecheck.riskcontrol.ui.RiskAppDetailActivity;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RiskPermissionControlGuard {
    private RiskPermissionControlGuard() {
    }

    public static boolean isSensitivePermissionChangeBlocked(Context context, PackageInfo packageInfo) {
        if (packageInfo != null) goto L4;
        return false;
    L4:
        if (packageInfo.applicationInfo != null) goto L7;
        return false;
    L7:
        return isSensitivePermissionChangeBlocked(context, packageInfo.packageName, UserHandle.getUserId(packageInfo.applicationInfo.uid));
    }

    public static boolean isSensitivePermissionChangeBlocked(PackageInfo packageInfo) {
        return isSensitivePermissionChangeBlocked(SecurityCenterApplication.getContext(), packageInfo);
    }

    public static boolean isSensitivePermissionChangeBlocked(Context context, PermissionApp entry) {
        if (entry != null) goto L6;
        return false;
    L6:
        return isSensitivePermissionChangeBlocked(context, entry.getPackageName(), entry.getUserId());
    }

    public static boolean isSensitivePermissionChangeBlocked(Context context, String packageName, int userId) {
        return isPermissionChangeBlocked(context, packageName, userId, 28);
    }

    public static boolean isNetworkPermissionChangeBlocked(Context context, String packageName, int userId) {
        return isPermissionChangeBlocked(context, packageName, userId, 3);
    }

    public static boolean isNetworkPermissionChangeBlocked(Context context, AppEntry entry) {
        if (entry != null) goto L4;
        return false;
    L4:
        if (entry.getApplicationInfo() != null) goto L7;
        return false;
    L7:
        return isNetworkPermissionChangeBlocked(context, entry.getApplicationInfo().packageName, UserHandle.getUserId(entry.getApplicationInfo().uid));
    }

    public static boolean interceptNetworkPermissionChange(Context context, AppEntry entry, String logTag, String source) {
        if (isNetworkPermissionChangeBlocked(context, entry) == true) goto L6;
        return false;
    L6:
        showNetworkPermissionBlockedDialog(context, entry);
        return true;
    }

    private static boolean isPermissionChangeBlocked(Context context, String packageName, int userId, int flag) {
        if (context != null) goto L5;
    L12:
        return false;
    L5:
        if (TextUtils.isEmpty(packageName) == true) goto L12;
        if (AppListLoader.isWhitePackage(packageName) == false) goto L11;
        return false;
    L11:
        return RiskControlSettingsSnapshotStore.isFlagControlled(context, packageName, userId, flag);
    }

    public static void showBlockedToast(Context context) {
        if (context != null) goto L4;
        return;
    L4:
        Toast.makeText(context, R.string.risk_permission_blocked_message, 0).show();
    }

    public static void showNetworkPermissionBlockedDialog(final Context context, final AppEntry entry) {
        if (context != null) goto L4;
        return;
    L4:
        Drawable r0 = null;
        if (entry == null) goto L7;
        String r1 = entry.getLabel();
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L11;
        String r2 = r1.toString();
    L12:
        OAlertDialogBuilder r3 = new OAlertDialogBuilder(context).title(context.getString(R.string.risk_app_feature_limited_title, new Object[]{r2}), false).message(context.getString(R.string.risk_app_feature_limited_message)).horizontalButton(true).positiveButton(context.getString(R.string.go_detail), new RiskPermissionControlGuard$$ExternalSyntheticLambda0(entry, context)).negativeButton(context.getString(R.string.ok2), new RiskPermissionControlGuard$$ExternalSyntheticLambda1());
        if (entry == null) goto L15;
        r0 = entry.getIcon();
    L15:
        if (r0 == null) goto L17;
        r3.icon(r0).imageSize(OUnitExtensionKt.dp2px(56), OUnitExtensionKt.dp2px(56));
    L17:
        OAlertDialog r7 = r3.build();
        if ((r7.getPositiveButton() instanceof TextView) == false) goto L20;
        ((TextView) r7.getPositiveButton()).setTextColor(ContextCompat.getColor(context, R.color.oui_accent_6_bg));
    L20:
        r7.show();
        return;
    L11:
        r2 = context.getString(R.string.app_name);
        goto L12
    L7:
        r1 = null;
        goto L9
    }

    static /* synthetic */ void lambda$showNetworkPermissionBlockedDialog$0(AppEntry r0, Context r1, DialogInterface r2, int r3) {
        r2.dismiss();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getApplicationInfo() == null) goto L10;
        r1.startActivity(RiskAppDetailActivity.createIntent(r1, r0.getApplicationInfo().packageName, UserHandle.getUserId(r0.getApplicationInfo().uid)));
        return;
    }

    static /* synthetic */ void lambda$showNetworkPermissionBlockedDialog$1(DialogInterface r0, int r1) {
        r0.dismiss();
    }
}
