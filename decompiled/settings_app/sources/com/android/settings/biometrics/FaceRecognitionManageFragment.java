package com.android.settings.biometrics;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.face.Face;
import android.hardware.face.FaceManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.security.bytedance.guard.BDSettingsEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.autoaction.SecurityEventMonitor;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FaceRecognitionManageFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private OAlertDialog mAlertDialog;
    private TextView mFaceDataView;
    private FaceRecognitionHelper mFaceRecognitionHelper;
    private boolean mIsActionFinished;
    private OCheckBox mLockScreenCheckbox;
    private OCardListItem mNotificationTurnOnScreen;
    private OCardListItem mPrivacyPasswordCheckbox;
    private OCardListItem mStayInLockedScreen;
    private OAlertDialog mTipsDialog;

    public void com_android_settings_biometrics_FaceRecognitionManageFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_biometrics_FaceRecognitionManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_biometrics_FaceRecognitionManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FaceRecognitionManageFragment() {
        this.mIsActionFinished = false;
    }

    static /* synthetic */ String access$000(FaceRecognitionManageFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$100(FaceRecognitionManageFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$200(FaceRecognitionManageFragment r0) {
        r0.resetSettingsDefault();
    }

    public void com_android_settings_biometrics_FaceRecognitionManageFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mFaceRecognitionHelper = new FaceRecognitionHelper(this._mActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.manage_face_recognition_data_fragment, r3, false);
        this.mLockScreenCheckbox = (OCheckBox) findViewByIdNullable(R.id.use_fc_in_lock_screen_setting);
        this.mPrivacyPasswordCheckbox = (OCardListItem) findViewByIdNullable(R.id.use_fc_in_privacy_password_setting);
        this.mNotificationTurnOnScreen = (OCardListItem) findViewByIdNullable(R.id.face_data_manage_switch_2);
        this.mStayInLockedScreen = (OCardListItem) findViewByIdNullable(R.id.face_data_manage_switch_3);
        this.mFaceDataView = (TextView) findViewByIdNullable(R.id.face_data_title_view);
        findViewByIdNullable(R.id.remove_face_data).setOnClickListener(this);
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(this.mRootView.findViewById(R.id.fake_status_bar));
        ViewGroup r5 = (ViewGroup) this.mRootView.findViewById(R.id.page_container);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        UIUtils.fitMaskTitleInCommon((ViewGroup) r1, r1.findViewById(R.id.page_scrollview));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationTurnOnScreen, this);
        OCardListItemUtils.setOnCheckedChangeListener(this.mStayInLockedScreen, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void updateViews() {
        setupSwitchCheckedState();
        this.mLockScreenCheckbox.setOnClickListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mLockScreenCheckbox.setOnClickListener(null);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != OCardListItemUtils.getSwitchView(this.mNotificationTurnOnScreen)) goto L6;
        saveNotificationTurnOnScreenFREnable(r3);
        return;
    L6:
        if (r2 != OCardListItemUtils.getSwitchView(this.mStayInLockedScreen)) goto L10;
        saveEnterDesktopWhenFaceRecognized(this.mContext, r3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != R.id.remove_face_data) goto L5;
        alertWarningDialog();
        return;
    L5:
        if (r3 != R.id.use_fc_in_lock_screen_setting) goto L11;
        saveFaceDataLockScreenEnable(!isFaceDataLockScreenEnable());
        return;
    }

    private void alertWarningDialog() {
        final int r0 = BDSettingsEvent.EVENT_TYPE_DELETE_FACE.getType();
        SecurityEventMonitor.INSTANCE.start(this._mActivity, r0);
        this.mIsActionFinished = false;
        if (this.mTipsDialog != null) goto L6;
        this.mTipsDialog = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).autoDismiss(true).horizontalButton(true).title(R.string.dialog_title_alert).message(R.string.face_recognition_delete_dialog_msg).horizontalButton().negativeButton(R.string.cancel, new FaceRecognitionManageFragment$$ExternalSyntheticLambda0()).positiveButton(R.string.delete, new FaceRecognitionManageFragment$$ExternalSyntheticLambda1(this, r0)).onDismiss(new FaceRecognitionManageFragment$$ExternalSyntheticLambda2(this, r0)).build();
    L6:
        if (this.mTipsDialog.isShowing() == true) goto L9;
        this.mTipsDialog.show();
        return;
    }

    static /* synthetic */ void lambda$alertWarningDialog$0(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$alertWarningDialog$1$com-android-settings-biometrics-FaceRecognitionManageFragment, reason: not valid java name */
    /* synthetic */ void m336x2fe6c24b(int r1, DialogInterface r2, int r3) {
        removeFaceRecognitionData();
        SecurityEventMonitor.INSTANCE.finish(this._mActivity, r1);
        this.mIsActionFinished = true;
    }

    /* JADX INFO: renamed from: lambda$alertWarningDialog$2$com-android-settings-biometrics-FaceRecognitionManageFragment, reason: not valid java name */
    /* synthetic */ void m337x2376468c(int r1, DialogInterface r2) {
        if (this.mIsActionFinished == true) goto L6;
        SecurityEventMonitor.INSTANCE.cancel(this._mActivity, r1);
        return;
    }

    private void removeFaceRecognitionData() {
        FaceManager r0 = Utils.getFaceManagerOrNull(this.mContext);
        if (r0 == null) goto L12;
        List r1 = r0.getEnrolledFaces(UserHandle.myUserId());
        OLog.i(this.TAG, "removeFaceRecognitionData: faces = " + r1);
        if (r1 != null) goto L7;
    L10:
        OLog.e(this.TAG, "removeFaceRecognitionData: faces is null");
        finish();
        return;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r0.remove((Face) r1.get(0), UserHandle.myUserId(), new AnonymousClass1(this));
        return;
    }

    private void resetSettingsDefault() {
        saveNotificationTurnOnScreenFREnable(false);
        saveEnterDesktopWhenFaceRecognized(this.mContext, false);
    }

    private void setupSwitchCheckedState() {
        this.mLockScreenCheckbox.setChecked(isFaceDataLockScreenEnable());
        OCardListItemUtils.setChecked(this.mNotificationTurnOnScreen, isNotificationTurnOnScreenFREnable());
        OCardListItemUtils.setChecked(this.mStayInLockedScreen, isEnterDesktopWhenFaceRecognized(this.mContext));
    }

    private boolean isNotificationTurnOnScreenFREnable() {
        if (Settings.Global.getInt(getContentResolver(), "face_data_enable_when_notification_turn_on_screen", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void saveNotificationTurnOnScreenFREnable(boolean r2) {
        Settings.Global.putInt(getContentResolver(), "face_data_enable_when_notification_turn_on_screen", r2 ? 1 : 0);
    }

    static boolean isEnterDesktopWhenFaceRecognized(Context r2) {
        boolean r0 = r2.getResources().getBoolean(android.R.bool.config_flexibleSplitRatios);
        if (Settings.Secure.getInt(r2.getContentResolver(), "face_unlock_dismisses_keyguard_customize", r0 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static void saveEnterDesktopWhenFaceRecognized(Context r1, boolean r2) {
        Settings.Secure.putInt(r1.getContentResolver(), "face_unlock_dismisses_keyguard_customize", r2 ? 1 : 0);
    }

    private boolean isFaceDataLockScreenEnable() {
        if (Settings.Global.getInt(getContentResolver(), "faceid_enable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void saveFaceDataLockScreenEnable(boolean r3) {
        Settings.Global.putInt(getContentResolver(), "faceid_enable", r3 ? 1 : 0);
        setupSwitchCheckedState();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_biometrics_FaceRecognitionManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FaceRecognitionManageFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionManageFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FaceRecognitionManageFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_biometrics_FaceRecognitionManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FaceRecognitionManageFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionManageFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
