package com.android.settings.users;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.utils.NullSafe;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDialogs {
    public UserDialogs() {
    }

    public static Dialog createRemoveDialog(Context r3, int r4, DialogInterface.OnClickListener r5) {
        UserInfo r0 = (UserInfo) NullSafe.nonNull(((UserManager) r3.getSystemService(PickApplicationActivity.EXTRA_USER)).getUserInfo(r4));
        AlertDialog.Builder r6 = new AlertDialog.Builder(r3).setPositiveButton(R.string.user_delete_button, r5).setNegativeButton(android.R.string.cancel, null);
        if (r0.isManagedProfile() == false) goto L9;
        r6.setTitle(R.string.work_profile_confirm_remove_title);
        View r7 = createRemoveManagedUserDialogView(r3, r4);
        if (r7 == null) goto L7;
        r6.setView(r7);
    L16:
        return r6.create();
    L7:
        r6.setMessage(R.string.work_profile_confirm_remove_message);
        goto L16
    L9:
        if (UserHandle.myUserId() != r4) goto L12;
        r6.setTitle(R.string.user_confirm_remove_self_title);
        r6.setMessage(R.string.user_confirm_remove_self_message);
        goto L16
    L12:
        if (r0.isRestricted() == false) goto L14;
        r6.setTitle(R.string.user_profile_confirm_remove_title);
        r6.setMessage(R.string.user_profile_confirm_remove_message);
        goto L16
    L14:
        r6.setTitle(R.string.user_confirm_remove_title);
        r6.setMessage(R.string.user_confirm_remove_message);
        goto L16
    }

    private static View createRemoveManagedUserDialogView(Context r5, int r6) {
        PackageManager r0 = r5.getPackageManager();
        ApplicationInfo r1 = Utils.getAdminApplicationInfo(r5, r6);
        if (r1 != null) goto L5;
        return null;
    L5:
        View r7 = ((LayoutInflater) r5.getSystemService("layout_inflater")).inflate(R.layout.delete_managed_profile_dialog, null);
        ((ImageView) r7.findViewById(R.id.delete_managed_profile_mdm_icon_view)).setImageDrawable(r0.getUserBadgedIcon(r0.getApplicationIcon(r1), new UserHandle(r6)));
        CharSequence r2 = r0.getApplicationLabel(r1);
        CharSequence r8 = r0.getUserBadgedLabel(r2, new UserHandle(r6));
        TextView r3 = (TextView) r7.findViewById(R.id.delete_managed_profile_device_manager_name);
        r3.setText(r2);
        if (r2.toString().contentEquals(r8) == true) goto L8;
        r3.setContentDescription(r8);
    L8:
        return r7;
    }

    public static Dialog createEnablePhoneCallsAndSmsDialog(Context r1, DialogInterface.OnClickListener r2) {
        return new AlertDialog.Builder(r1).setTitle(R.string.user_enable_calling_and_sms_confirm_title).setMessage(R.string.user_enable_calling_and_sms_confirm_message).setPositiveButton(R.string.okay, r2).setNegativeButton(android.R.string.cancel, null).create();
    }

    public static Dialog createEnablePhoneCallsDialog(Context r1, DialogInterface.OnClickListener r2) {
        return new AlertDialog.Builder(r1).setTitle(R.string.user_enable_calling_confirm_title).setMessage(R.string.user_enable_calling_confirm_message).setPositiveButton(R.string.okay, r2).setNegativeButton(android.R.string.cancel, null).create();
    }
}
