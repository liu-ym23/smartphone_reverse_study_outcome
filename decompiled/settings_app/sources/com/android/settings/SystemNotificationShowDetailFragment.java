package com.android.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.View;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SystemNotificationShowDetailFragment extends BaseFragment {
    private static final int DISABLE = 2;
    private static final int HIDE = 1;
    private static final int SHOW = 0;
    private static final String TAG = "SystemNotificationShowDetailFragment";
    private OCardListItem mDisable;
    private boolean mDlgHasShown;
    private OCardListItem mHide;
    private int mLockscreenSelectedValue;
    private OCardListItem mShow;

    private class ConfigureKeyGuardDialog implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private boolean mConfigureConfirmed;
        final /* synthetic */ SystemNotificationShowDetailFragment this$0;

        public ConfigureKeyGuardDialog(SystemNotificationShowDetailFragment r3) {
            this.this$0 = r3;
            if (SystemNotificationShowDetailFragment.access$000(r3) == false) goto L5;
            return;
        L5:
            OAlertDialog r0 = new OAlertDialogBuilder(r3.getActivity()).horizontalButton().title(android.R.string.dialog_alert_title).message(R.string.system_notification_lock_screen_hint).positiveButton(R.string.dialog_positive_button_setup, this).negativeButton(android.R.string.cancel, this).build();
            r0.setOnDismissListener(this);
            r0.show();
            SystemNotificationShowDetailFragment.access$002(r3, true);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            if (r2 != (-1)) goto L5;
            boolean r3 = true;
        L6:
            this.mConfigureConfirmed = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface r3) {
            SystemNotificationShowDetailFragment.access$002(this.this$0, false);
            if (this.mConfigureConfirmed == false) goto L6;
            this.mConfigureConfirmed = false;
            Intent r4 = new Intent("android.app.action.SET_NEW_PASSWORD");
            r4.putExtra("minimum_quality", 65536);
            this.this$0.startActivity(r4);
            return;
        L6:
            this.this$0.finish();
        }
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SystemNotificationShowDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SystemNotificationShowDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ boolean access$000(SystemNotificationShowDetailFragment r0) {
        return r0.mDlgHasShown;
    }

    static /* synthetic */ boolean access$002(SystemNotificationShowDetailFragment r0, boolean r1) {
        r0.mDlgHasShown = r1;
        return r1;
    }

    static /* synthetic */ void access$100(SystemNotificationShowDetailFragment r0, int r1) {
        r0.update(r1);
    }

    static /* synthetic */ boolean access$200(SystemNotificationShowDetailFragment r0) {
        return r0.checkKeyGuardQuality();
    }

    public SystemNotificationShowDetailFragment() {
        super(R.layout.system_notification_show_detail_layout);
        this.mDlgHasShown = false;
    }

    private boolean checkKeyGuardQuality() {
        int r0 = UserManager.get(getActivity()).getCredentialOwnerProfile(UserHandle.myUserId());
        if (new LockPatternUtils(getActivity()).getActivePasswordQuality(r0) < 65536) goto L5;
        return true;
    L5:
        return false;
    }

    public void com_android_settings_SystemNotificationShowDetailFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        OLog.d(TAG, "onCreate......");
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        OCardListItem r4 = (OCardListItem) findViewByIdNullable(R.id.show_detail_show);
        this.mShow = r4;
        r4.setOnContentClickListener(new AnonymousClass1(this));
        OCardListItemUtils.setCustomEndImageView(this.mShow);
        this.mShow.showCustomEnd(false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.show_detail_hide);
        this.mHide = r5;
        r5.setOnContentClickListener(new AnonymousClass2(this));
        OCardListItemUtils.setCustomEndImageView(this.mHide);
        this.mHide.showCustomEnd(false);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.show_detail_disable);
        this.mDisable = r6;
        r6.setOnContentClickListener(new AnonymousClass3(this));
        OCardListItemUtils.setCustomEndImageView(this.mDisable);
        this.mDisable.showCustomEnd(false);
    }

    public void com_android_settings_SystemNotificationShowDetailFragment__onResume$___twin___() {
        super.onResume();
        OLog.d(TAG, "onResume......");
        refresh(this.mContext);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private static boolean getLockscreenNotificationsEnabled(Context r2) {
        if (android.provider.Settings.Secure.getInt(r2.getContentResolver(), "lock_screen_show_notifications", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean getAllowPrivateNotifications(Context r2, int r3) {
        if (android.provider.Settings.Secure.getIntForUser(r2.getContentResolver(), "lock_screen_allow_private_notifications", 0, r3) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private static int getSummaryMode(Context r4) {
        boolean r0 = getLockscreenNotificationsEnabled(r4);
        if (new LockPatternUtils(r4).isSecure(UserHandle.myUserId()) == true) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r0 == true) goto L11;
        return 2;
    L11:
        if (r5 == false) goto L14;
        return 0;
    L14:
        return 1;
    L5:
        if (getAllowPrivateNotifications(r4, UserHandle.myUserId()) == true) goto L8;
        r5 = false;
        goto L9
    }

    public static int getSummaryResource(Context r1) {
        int r2 = getSummaryMode(r1);
        if (r2 != 0) goto L5;
        return R.string.lock_screen_notifications_summary_show;
    L5:
        if (r2 != 1) goto L7;
        return R.string.lock_screen_notifications_summary_hide;
    L7:
        if (r2 == 2) goto L9;
        return 0;
    L9:
        return R.string.lock_screen_notifications_summary_disable;
    }

    private void refresh(Context r5) {
        int r6 = getSummaryMode(r5);
        OCardListItem r0 = this.mShow;
        boolean r1 = false;
        if (r6 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.showCustomEnd(r3);
        OCardListItem r2 = this.mHide;
        if (r6 != 1) goto L9;
        boolean r4 = true;
    L10:
        r2.showCustomEnd(r4);
        OCardListItem r7 = this.mDisable;
        if (r6 != 2) goto L13;
        r1 = true;
    L13:
        r7.showCustomEnd(r1);
        this.mLockscreenSelectedValue = r6;
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private void update(int r4) {
        if (this.mLockscreenSelectedValue != r4) goto L5;
        return;
    L5:
        int r1 = 1;
        if (r4 == 2) goto L8;
        int r0 = 1;
    L9:
        if (r4 == 0) goto L12;
        r1 = 0;
    L12:
        android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), "lock_screen_allow_private_notifications", r1);
        android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), "lock_screen_show_notifications", r0);
        refresh(this.mContext);
        return;
    L8:
        r0 = 0;
        goto L9
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SystemNotificationShowDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SystemNotificationShowDetailFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SystemNotificationShowDetailFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SystemNotificationShowDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SystemNotificationShowDetailFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SystemNotificationShowDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SystemNotificationShowDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SystemNotificationShowDetailFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SystemNotificationShowDetailFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
