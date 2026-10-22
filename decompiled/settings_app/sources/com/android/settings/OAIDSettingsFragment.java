package com.android.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.StatusDialogUtils;
import com.android.settings.utils.ZteDeviceIdentify;
import com.obric.olog.OLog;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.utils.StyleUtil;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class OAIDSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private static final String ALLOW_USE_STATUS = "oaid_status_open";
    private static final int ALLOW_USE_STATUS_CLOSE = 0;
    private static final int ALLOW_USE_STATUS_OPEN = 1;
    private static final String DEVICE_ID_RESET_NOTIFY = "oaid_reset_notify";
    private static final int RESET_FINISH = 0;
    private static final int RESET_NOW = 1;
    private OAlertDialog mConfirmDialog;
    private OCardListItem mOaidSwitch;
    private View mResetBtn;
    private final ContentObserver mResetResetDeviceIdObserver;
    private StatusDialog mStatusDialog;

    public void com_android_settings_OAIDSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_OAIDSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OAIDSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_OAIDSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OAIDSettingsFragment() {
        this.mStatusDialog = null;
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.mResetResetDeviceIdObserver = new AnonymousClass2(this, r1);
    }

    static /* synthetic */ void access$000(OAIDSettingsFragment r0) {
        r0.showConfirmDialog();
    }

    static /* synthetic */ boolean access$100(OAIDSettingsFragment r0) {
        return r0.isDeviceIdResetFinish();
    }

    static /* synthetic */ void access$200(OAIDSettingsFragment r0) {
        r0.showResetLoading();
    }

    static /* synthetic */ void access$300(OAIDSettingsFragment r0) {
        r0.showResetFinishOAID();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.oaid_settings_layout, r4, false);
        this.mTitleResId = Integer.valueOf(R.string.oaid_title);
        this.mOaidSwitch = (OCardListItem) findViewById(R.id.switch_retrieve_oaid);
        OBottomActionBarNormalVertical r6 = (OBottomActionBarNormalVertical) this.mRootView.findViewById(R.id.bottom_action_bar);
        this.mResetBtn = StyleUtil.createWidgetWithStyle(this._mActivity, 2132017997, new OAIDSettingsFragment$$ExternalSyntheticLambda0(this));
        r6.showDivider(false);
        r6.addButton(this.mResetBtn);
        this.mResetBtn.setOnClickListener(new AnonymousClass1(this));
        clearResetDeviceId();
        this.mOaidSwitch.setSubTitle(ZteDeviceIdentify.getOAID(this.mContext));
        this.mOaidSwitch.showSubTitle(true);
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-OAIDSettingsFragment, reason: not valid java name */
    /* synthetic */ OButton m186lambda$onCreateView$0$comandroidsettingsOAIDSettingsFragment(Context r2, Integer r3, Integer r4) {
        OButton r5 = new OButton(r2, null);
        r5.setText(R.string.reset_oaid);
        r5.setTextColor(this._mActivity.getColor(R.color.oui_functional_red_6));
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, r4.intValue()));
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        OCardListItemUtils.setChecked(this.mOaidSwitch, isDiableGetOAIDEnable());
        OCardListItemUtils.setOnCheckedChangeListener(this.mOaidSwitch, this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        OCardListItemUtils.setChecked(this.mOaidSwitch, isDiableGetOAIDEnable());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != OCardListItemUtils.getSwitchView(this.mOaidSwitch)) goto L6;
        setDiableGetOAIDEnable(r3);
        return;
    }

    private void showConfirmDialog() {
        OAlertDialog r0 = this.mConfirmDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r1 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton(true).title(R.string.dialog_title_alert).message(R.string.reset_oaid_desc).positiveButton(R.string.reset, new OAIDSettingsFragment$$ExternalSyntheticLambda1(this)).negativeButton(R.string.cancel, new OAIDSettingsFragment$$ExternalSyntheticLambda2()).onDismiss(new OAIDSettingsFragment$$ExternalSyntheticLambda3(this)).build();
        this.mConfirmDialog = r1;
        r1.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    /* JADX INFO: renamed from: lambda$showConfirmDialog$1$com-android-settings-OAIDSettingsFragment, reason: not valid java name */
    /* synthetic */ void m187x4dde3997(DialogInterface r1, int r2) {
        resetDeviceId();
        r1.dismiss();
    }

    static /* synthetic */ void lambda$showConfirmDialog$2(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showConfirmDialog$3$com-android-settings-OAIDSettingsFragment, reason: not valid java name */
    /* synthetic */ void m188x18611719(DialogInterface r1) {
        this.mConfirmDialog = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OAlertDialog r0 = this.mConfirmDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mConfirmDialog.dismiss();
        return;
    }

    private boolean isDiableGetOAIDEnable() {
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), ALLOW_USE_STATUS, 1) != 1) goto L6;
        r2 = false;
    L6:
        OLog.i(this.TAG, "isDiableGetOAIDEnable:" + r2);
        return r2;
    }

    private void setDiableGetOAIDEnable(boolean r4) {
        android.provider.Settings.Global.putInt(getContentResolver(), ALLOW_USE_STATUS, !r4 ? 1 : 0);
        OLog.i(this.TAG, "setDiableGetOAIDEnable:" + r4);
    }

    private boolean isDeviceIdResetFinish() {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), DEVICE_ID_RESET_NOTIFY, 0) != 0) goto L5;
        r2 = true;
    L5:
        OLog.d(this.TAG, "isDeviceIdResetFinish:" + r2);
        return r2;
    }

    private void clearResetDeviceId() {
        if (isDeviceIdResetFinish() == true) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), DEVICE_ID_RESET_NOTIFY, 0);
        return;
    }

    private void resetDeviceId() {
        if (isDeviceIdResetFinish() == false) goto L6;
        registerResetDeviceIdObserver();
        android.provider.Settings.Global.putInt(getContentResolver(), DEVICE_ID_RESET_NOTIFY, 1);
        return;
    }

    private void registerResetDeviceIdObserver() {
        Uri r0 = android.provider.Settings.Global.getUriFor(DEVICE_ID_RESET_NOTIFY);     // Catch: Exception -> L4
        this.mContext.getContentResolver().registerContentObserver(r0, true, this.mResetResetDeviceIdObserver);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(this.TAG, "registerResetDeviceIdObserver:", e);
    }

    private void unregisterResetDeviceIdObserver() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mResetResetDeviceIdObserver);
    }

    private void showResetFinishOAID() {
        if (isFragmentVisible() == false) goto L5;
        this.mOaidSwitch.setSubTitle(ZteDeviceIdentify.getOAID(this.mContext));
        this.mOaidSwitch.showSubTitle(true);
    L5:
        StatusDialog r0 = this.mStatusDialog;
        if (r0 != null) goto L8;
    L10:
        unregisterResetDeviceIdObserver();
        return;
    L8:
        if (r0.isShowing() == false) goto L10;
        this.mStatusDialog.dismiss();
        goto L10
    }

    private void showResetLoading() {
        StatusDialog r0 = StatusDialogUtils.createStatusDialog(this._mActivity, getString(R.string.acquiring_url), "", getString(R.string.cancel), true, new OAIDSettingsFragment$$ExternalSyntheticLambda4(this));
        this.mStatusDialog = r0;
        r0.setOnCancelListener(new OAIDSettingsFragment$$ExternalSyntheticLambda5(this));
        this.mStatusDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showResetLoading$4$com-android-settings-OAIDSettingsFragment, reason: not valid java name */
    /* synthetic */ void m189xd8b19b93(View r1) {
        StatusDialog r2 = this.mStatusDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        clearResetDeviceId();
    }

    /* JADX INFO: renamed from: lambda$showResetLoading$5$com-android-settings-OAIDSettingsFragment, reason: not valid java name */
    /* synthetic */ void m190xbdf30a54(DialogInterface r1) {
        clearResetDeviceId();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_OAIDSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OAIDSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OAIDSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OAIDSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OAIDSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_OAIDSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OAIDSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OAIDSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OAIDSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
