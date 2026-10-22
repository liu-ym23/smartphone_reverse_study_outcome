package com.android.settings.eldership;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.android.settings.LauncherSettingsFragment;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.LauncherPreview;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class EldershipLauncherSettingFragment extends BaseFragment implements LauncherPreview.Callback, View.OnClickListener {
    public static final String EXTRA_LAUNCHER_MODE = "extra_launcher_mode";
    public static final String EXTRA_LAUNCHER_THEME = "extra_launcher_theme";
    public static final String EXTRA_REQUEST_AS_RESULT = "extra_request_as_result";
    private AlertDialog mDialog;
    private boolean mIsTransparentTheme;
    private boolean mIsTransparentThemeOld;
    private int mLauncherMode;
    private int mLauncherModeOld;
    private LauncherPreview mLauncherPreview;
    private Button mOkButton;
    private boolean mRequestSettingAsResult;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_eldership_EldershipLauncherSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_eldership_EldershipLauncherSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(EldershipLauncherSettingFragment r0) {
        r0.sendSettingResult();
    }

    public static EldershipLauncherSettingFragment newInstance(int r2, int r3, boolean r4) {
        Bundle r0 = new Bundle();
        r0.putInt(EXTRA_LAUNCHER_MODE, r2);
        r0.putInt(EXTRA_LAUNCHER_THEME, r3);
        r0.putBoolean("extra_request_as_result", r4);
        EldershipLauncherSettingFragment r5 = new EldershipLauncherSettingFragment();
        r5.setArguments(r0);
        return r5;
    }

    public EldershipLauncherSettingFragment() {
        super(R.layout.fragment_eldership_launcher_setting);
    }

    public void com_android_settings_eldership_EldershipLauncherSettingFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        int r0 = r3.getInt(EXTRA_LAUNCHER_MODE);
        this.mLauncherModeOld = r0;
        this.mLauncherMode = r0;
        boolean r1 = EldershipUtils.isTransparentLauncherTheme(r3.getInt(EXTRA_LAUNCHER_THEME));
        this.mIsTransparentThemeOld = r1;
        this.mIsTransparentTheme = r1;
        this.mRequestSettingAsResult = r3.getBoolean("extra_request_as_result");
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        LauncherPreview r3 = (LauncherPreview) findViewByIdNullable(R.id.launcher_preview);
        this.mLauncherPreview = r3;
        r3.setCallback(this);
        this.mOkButton = (Button) findViewByIdNullable(R.id.btn_ok);
        View r4 = findViewByIdNullable(R.id.bottom_line);
        if (this.mRequestSettingAsResult == false) goto L5;
        this.mBackView.setOnClickListener(this);
        r4.setVisibility(0);
        this.mOkButton.setVisibility(0);
        this.mOkButton.setOnClickListener(this);
    L6:
        updatePreview();
        return;
    L5:
        r4.setVisibility(8);
        this.mOkButton.setVisibility(8);
        goto L6
    }

    public void com_android_settings_eldership_EldershipLauncherSettingFragment__onResume$___twin___() {
        super.onResume();
        updatePreview();
    }

    private void updatePreview() {
        if (this.mRequestSettingAsResult == false) goto L9;
        boolean r0 = areSettingsChanged();
        this.mOkButton.setEnabled(r0);
        Drawable r1 = this.mOkButton.getBackground();
        if (r0 == false) goto L7;
        int r2 = 255;
    L8:
        r1.setAlpha(r2);
    L10:
        this.mLauncherPreview.updateViews(this.mLauncherMode, this.mIsTransparentTheme);
        return;
    L7:
        r2 = 76;
        goto L8
    L9:
        int r3 = Utils.getCurrentLauncherMode(this.mContext);
        this.mLauncherModeOld = r3;
        this.mLauncherMode = r3;
        boolean r4 = EldershipUtils.isTransparentLauncherTheme(Utils.getCurrentLauncherTheme(this.mContext));
        this.mIsTransparentThemeOld = r4;
        this.mIsTransparentTheme = r4;
        goto L10
    }

    private boolean areSettingsChanged() {
        if (this.mLauncherMode == this.mLauncherModeOld) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsTransparentTheme != this.mIsTransparentThemeOld) goto L8;
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mBackView) goto L10;
        if (areSettingsChanged() == false) goto L7;
        showSettingChangedDialog();
        return;
    L7:
        finish();
        return;
    L10:
        if (r2.getId() != R.id.btn_ok) goto L15;
        sendSettingResult();
        return;
    }

    private void sendSettingResult() {
        Intent r0 = new Intent();
        r0.putExtra(EXTRA_LAUNCHER_MODE, this.mLauncherMode);
        r0.putExtra(EXTRA_LAUNCHER_THEME, this.mIsTransparentTheme ? 1 : 0);
        this._mActivity.setResult(-1, r0);
        finish();
    }

    @Override // com.android.settings.widget.LauncherPreview.Callback
    public void onLauncherTypeChanged(int r2) {
        if (this.mRequestSettingAsResult == false) goto L5;
        this.mLauncherMode = r2;
        updatePreview();
        return;
    L5:
        showLauncherModeWarningDialog(r2);
    }

    @Override // com.android.settings.widget.LauncherPreview.Callback
    public void onLauncherThemeChanged(boolean r2) {
        if (this.mRequestSettingAsResult == false) goto L5;
        this.mIsTransparentTheme = r2;
        updatePreview();
        return;
    L5:
        showLauncherThemeWarningDialog(r2);
    }

    private void showLauncherModeWarningDialog(int r2) {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        this.mDialog = LauncherSettingsFragment.showLauncherModeDialog(this, Utils.getCurrentLauncherMode(this.mContext), r2);
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void showLauncherThemeWarningDialog(boolean r2) {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        this.mDialog = LauncherSettingsFragment.showLauncherThemeDialog(this, r2);
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void showSettingChangedDialog() {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        this.mDialog = new AlertDialog.Builder(this._mActivity).setTitle(R.string.dialog_title_alert).setMessage(R.string.launcher_setting_changed_msg).setNegativeButton(R.string.dlg_cancel, new AnonymousClass2(this)).setPositiveButton(R.string.ok, new AnonymousClass1(this)).show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_eldership_EldershipLauncherSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(EldershipLauncherSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eldership_EldershipLauncherSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eldership_EldershipLauncherSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(EldershipLauncherSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_eldership_EldershipLauncherSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eldership_EldershipLauncherSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(EldershipLauncherSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eldership_EldershipLauncherSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
