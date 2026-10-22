package com.android.settings;

import android.content.ContentResolver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SwitchEx;
import obric.widget.editor.SimpleEditor;

/* JADX INFO: loaded from: classes2.dex */
public class OwnerInfoSettingsFragment extends BaseFragment {
    private SwitchEx mCheckbox;
    private EditText mEditText;

    public void com_android_settings_OwnerInfoSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_OwnerInfoSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OwnerInfoSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_OwnerInfoSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OwnerInfoSettingsFragment() {
    }

    static /* synthetic */ EditText access$000(OwnerInfoSettingsFragment r0) {
        return r0.mEditText;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.ownerinfo, r3, false);
        String r5 = android.provider.Settings.Secure.getString(getContentResolver(), "lock_screen_owner_info");
        isOwnerInfoEnable();
        this.mCheckbox = ((SettingItemSwitch) findViewByIdNullable(R.id.show_owner_info_on_lockscreen_checkbox)).getSwitch();
        EditText r6 = ((SimpleEditor) findViewByIdNullable(R.id.owner_info_edit_text)).getEditText();
        this.mEditText = r6;
        r6.addTextChangedListener(new AnonymousClass1(this));
        if (r5 == null) goto L6;
        this.mEditText.setText(r5);
        this.mEditText.setSelection(r5.length());
    L6:
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mEditText.postDelayed(new AnonymousClass2(this), 500);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r3) {
        super.onViewStateRestored(r3);
        final ContentResolver r4 = getContentResolver();
        boolean r0 = isOwnerInfoEnable();
        this.mCheckbox.setChecked(r0);
        this.mCheckbox.setOnCheckedChangeListener(new AnonymousClass3(this, r4));
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        saveToDb();
    }

    @Override // com.android.settings.base.BaseFragment
    public void finish() {
        super.finish();
        if (getActivity() == null) goto L6;
        Utils.hideInputMethod(getActivity());
        return;
    }

    private boolean isOwnerInfoEnable() {
        if (android.provider.Settings.Secure.getInt(getContentResolver(), "lock_screen_owner_info_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void saveToDb() {
        android.provider.Settings.Secure.putString(getContentResolver(), "lock_screen_owner_info", this.mEditText.getText().toString());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_OwnerInfoSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OwnerInfoSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OwnerInfoSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OwnerInfoSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OwnerInfoSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_OwnerInfoSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OwnerInfoSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OwnerInfoSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OwnerInfoSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
