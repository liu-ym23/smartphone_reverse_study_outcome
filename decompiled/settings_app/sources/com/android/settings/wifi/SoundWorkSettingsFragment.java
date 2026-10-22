package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioSystem;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.RingtoneSettingsActivity;
import com.android.settings.SoundSettingsFragment;
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

/* JADX INFO: loaded from: classes.dex */
public class SoundWorkSettingsFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "SoundWorkSettingsFragment";
    private OAlertDialog mAlertDialog;
    private int mManagedProfileId;
    private final BroadcastReceiver mManagedProfileReceiver;
    private UserManager mUserManager;
    private boolean mVoiceCapable;
    private OCardListItem mWorkAlarmRingtoneItem;
    private OCardListItem mWorkNotificationRingtoneItem;
    private OCardListItem mWorkRingtoneItem;
    private OCardListItem mWorkUsePersonalSoundsItem;

    public void com_android_settings_wifi_SoundWorkSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_SoundWorkSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_SoundWorkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_SoundWorkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SoundWorkSettingsFragment() {
        this.mManagedProfileReceiver = new AnonymousClass1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.sound_work_settings_layout, r3, false);
        OCardListItem r5 = (OCardListItem) this.mRootView.findViewById(R.id.work_use_personal_sounds_item);
        this.mWorkUsePersonalSoundsItem = r5;
        r5.setOnContentClickListener(this);
        this.mWorkUsePersonalSoundsItem.getEndSwitch().setClickable(false);
        OCardListItem r6 = (OCardListItem) this.mRootView.findViewById(R.id.work_ringtone_item);
        this.mWorkRingtoneItem = r6;
        r6.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) this.mRootView.findViewById(R.id.work_notification_ringtone_item);
        this.mWorkNotificationRingtoneItem = r7;
        r7.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) this.mRootView.findViewById(R.id.work_alarm_ringtone_item);
        this.mWorkAlarmRingtoneItem = r8;
        r8.setOnContentClickListener(this);
        this.mVoiceCapable = com.android.settings.Utils.isVoiceCapable(this.mContext);
        this.mUserManager = UserManager.get(this._mActivity);
        IntentFilter r9 = new IntentFilter();
        r9.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
        r9.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mManagedProfileReceiver, r9);
        this.mManagedProfileId = com.android.settings.Utils.getManagedProfileId(UserManager.get(this._mActivity), UserHandle.myUserId());
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4 == this.mWorkUsePersonalSoundsItem.getContentContainer()) goto L5;
    L8:
        Intent r0 = new Intent();
        r0.putExtra("user_id", this.mManagedProfileId);
        Context r1 = getManagedProfileContext(this.mContext, this.mManagedProfileId);
        if (r1 != null) goto L12;
        return;
    L12:
        if (r4 != this.mWorkRingtoneItem.getContentContainer()) goto L15;
        r0.putExtras(SoundSettingsFragment.prepareRingtonePickerIntent((String) this.mWorkRingtoneItem.getTitle(), SoundSettingsFragment.TYPE_RINGTONE));
        r0.setClass(r1, RingtoneSettingsActivity.class);
        com.android.settings.Utils.startActivity(this._mActivity, r0);
        return;
    L15:
        if (r4 != this.mWorkNotificationRingtoneItem.getContentContainer()) goto L18;
        r0.putExtras(SoundSettingsFragment.prepareRingtonePickerIntent((String) this.mWorkNotificationRingtoneItem.getTitle(), SoundSettingsFragment.TYPE_DEFAULT));
        r0.setClass(r1, RingtoneSettingsActivity.class);
        com.android.settings.Utils.startActivity(this._mActivity, r0);
        return;
    L18:
        if (r4 != this.mWorkAlarmRingtoneItem.getContentContainer()) goto L23;
        r0.putExtras(SoundSettingsFragment.prepareRingtonePickerIntent((String) this.mWorkAlarmRingtoneItem.getTitle(), SoundSettingsFragment.TYPE_ALARM));
        r0.setClass(r1, RingtoneSettingsActivity.class);
        com.android.settings.Utils.startActivity(this._mActivity, r0);
        return;
    L23:
        return;
    L5:
        if ((!this.mWorkUsePersonalSoundsItem.getEndSwitch().isChecked()) == false) goto L7;
        showWorkUsePersonalSoundsDialog();
        goto L8
    L7:
        disableWorkSync();
        goto L8
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        if (this.mVoiceCapable == true) goto L5;
        this.mWorkRingtoneItem.setVisibility(8);
    L5:
        boolean r3 = false;
        if (Settings.Secure.getIntForUser(getManagedProfileContext(this.mContext, this.mManagedProfileId).getContentResolver(), "sync_parent_sounds", 0, this.mManagedProfileId) != 1) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L10;
        enableWorkSyncSettings();
        return;
    L10:
        disableWorkSyncSettings();
    }

    private void disableWorkSync() {
        Settings.Secure.putIntForUser(getManagedProfileContext(this.mContext, this.mManagedProfileId).getContentResolver(), "sync_parent_sounds", 0, this.mManagedProfileId);
        disableWorkSyncSettings();
    }

    private void disableWorkSyncSettings() {
        this.mWorkUsePersonalSoundsItem.getEndSwitch().setChecked(false);
        Context r0 = getManagedProfileContext(this.mContext, this.mManagedProfileId);
        this.mWorkRingtoneItem.setEnabled(true);
        this.mWorkRingtoneItem.setSubTitle(getRingtoneItemSubtitle(r0, 1));
        this.mWorkRingtoneItem.showSubTitle(true);
        this.mWorkNotificationRingtoneItem.setEnabled(true);
        this.mWorkNotificationRingtoneItem.setSubTitle(getRingtoneItemSubtitle(r0, 2));
        this.mWorkNotificationRingtoneItem.showSubTitle(true);
        this.mWorkAlarmRingtoneItem.setEnabled(true);
        this.mWorkAlarmRingtoneItem.setSubTitle(getRingtoneItemSubtitle(r0, 4));
        this.mWorkAlarmRingtoneItem.showSubTitle(true);
    }

    private void enableWorkSyncSettings() {
        this.mWorkUsePersonalSoundsItem.getEndSwitch().setChecked(true);
        String r0 = this.mContext.getString(R.string.work_sound_same_as_personal);
        this.mWorkRingtoneItem.setSubTitle(r0);
        this.mWorkRingtoneItem.showSubTitle(true);
        this.mWorkRingtoneItem.setEnabled(false);
        this.mWorkNotificationRingtoneItem.setSubTitle(r0);
        this.mWorkNotificationRingtoneItem.showSubTitle(true);
        this.mWorkNotificationRingtoneItem.setEnabled(false);
        this.mWorkAlarmRingtoneItem.setSubTitle(r0);
        this.mWorkAlarmRingtoneItem.showSubTitle(true);
        this.mWorkAlarmRingtoneItem.setEnabled(false);
    }

    private CharSequence getRingtoneItemSubtitle(Context r3, int r4) {
        if (r3 == null) goto L9;
        if (this.mUserManager.isUserUnlocked(r3.getUserId()) == false) goto L9;
        return Ringtone.getTitle(r3, RingtoneManager.getActualDefaultRingtoneUri(r3, r4), false, true);
    L9:
        return this.mContext.getString(R.string.managed_profile_not_available_label);
    }

    private void showWorkUsePersonalSoundsDialog() {
        if (this.mAlertDialog != null) goto L6;
        this.mAlertDialog = new OAlertDialogBuilder(this._mActivity).title(R.string.work_sync_dialog_title).message(R.string.work_sync_dialog_message).horizontalButton().positiveButton(R.string.work_sync_dialog_yes, new SoundWorkSettingsFragment$$ExternalSyntheticLambda0(this)).negativeButton(R.string.cancel, new SoundWorkSettingsFragment$$ExternalSyntheticLambda1(this)).build();
    L6:
        if (this.mAlertDialog.isShowing() == false) goto L8;
        this.mAlertDialog.dismiss();
    L8:
        this.mAlertDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showWorkUsePersonalSoundsDialog$0$com-android-settings-wifi-SoundWorkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m678x31b0c08b(DialogInterface r3, int r4) {
        Settings.Secure.putIntForUser(getManagedProfileContext(this.mContext, this.mManagedProfileId).getContentResolver(), "sync_parent_sounds", 1, this.mManagedProfileId);
        enableWorkSyncSettings();
    }

    /* JADX INFO: renamed from: lambda$showWorkUsePersonalSoundsDialog$1$com-android-settings-wifi-SoundWorkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m679xbeeb720c(DialogInterface r1, int r2) {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public void onManagedProfileRemoved(int r2) {
        if (this.mManagedProfileId != r2) goto L9;
        this.mManagedProfileId = com.android.settings.Utils.getManagedProfileId(this.mUserManager, UserHandle.myUserId());
        if (isSupportWorkProfileSound(this._mActivity) == true) goto L7;
        finish();
        return;
    L7:
        updateViews();
        return;
    }

    public static boolean isSupportWorkProfileSound(Context r4) {
        if (com.android.settings.Utils.getManagedProfileId(UserManager.get(r4), UserHandle.myUserId()) == (-10000)) goto L5;
        boolean r0 = true;
    L6:
        boolean r5 = !AudioSystem.isSingleVolume(r4);
        if (r0 == false) goto L11;
        if (r5 == true) goto L10;
        return false;
    L10:
        return true;
    L11:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static Context getManagedProfileContext(Context r1, int r2) {
        if (r2 != (-10000)) goto L7;
        return null;
    L7:
        return createPackageContextAsUser(r1, r2);
    }

    private static Context createPackageContextAsUser(Context r2, int r3) {
        return r2.createPackageContextAsUser(r2.getPackageName(), 0, UserHandle.of(r3));
    L4:
        e = move-exception;
        OLog.e(TAG, "Failed to create user context", e);
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_SoundWorkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SoundWorkSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_SoundWorkSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SoundWorkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SoundWorkSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_SoundWorkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SoundWorkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SoundWorkSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_SoundWorkSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
