package com.android.settings;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.editor.SimpleEditor;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceNameFragment extends BaseFragment {
    private SimpleEditor mEditText;
    private View mOkButton;

    public void com_android_settings_DeviceNameFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_DeviceNameFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DeviceNameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DeviceNameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DeviceNameFragment() {
    }

    static /* synthetic */ View access$000(DeviceNameFragment r0) {
        return r0.mOkButton;
    }

    static /* synthetic */ SimpleEditor access$100(DeviceNameFragment r0) {
        return r0.mEditText;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.device_name_layout, r4, false);
        this.mEditText = (SimpleEditor) findViewByIdNullable(R.id.device_name);
        String r6 = Utils.getDeviceName(this.mContext);
        SimpleEditor r7 = this.mEditText;
        if (r7 == null) goto L6;
        r7.setText(r6);
        this.mEditText.getEditText().setSelectAllOnFocus(true);
        this.mEditText.getEditText().setSelection(r6.length());
        this.mEditText.getEditText().setFilters(new InputFilter[]{new Utf8ByteLengthFilter(Utils.DEVICE_NAME_MAX_LENGTH)});
        this.mEditText.getEditText().addTextChangedListener(new AnonymousClass1(this));
    L6:
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        OFloatingTitleBar r5 = this.mTitleView;
        if (r5 == null) goto L5;
        View r6 = r5.addEndAction(R.string.device_name_title_save, -1, null);
        this.mOkButton = r6;
        r6.setEnabled(false);
        this.mOkButton.setOnClickListener(new AnonymousClass2(this));
    L5:
        this.mEditText.postDelayed(new DeviceNameFragment$$ExternalSyntheticLambda0(this), 500);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$0$com-android-settings-DeviceNameFragment, reason: not valid java name */
    /* synthetic */ void m130lambda$onViewCreated$0$comandroidsettingsDeviceNameFragment() {
        Utils.showSoftInputMethod(this.mContext, this.mEditText.getEditText());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DeviceNameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DeviceNameFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceNameFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceNameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DeviceNameFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DeviceNameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceNameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DeviceNameFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceNameFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
