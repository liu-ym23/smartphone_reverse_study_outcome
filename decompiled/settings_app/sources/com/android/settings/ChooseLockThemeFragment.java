package com.android.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseLockThemeFragment extends BaseFragment implements View.OnClickListener {
    private ImageView firstCheckIcon;
    private ListContentItemCustom firstOption;
    private ImageView firstPreview;
    private ImageView fourthCheckIcon;
    private ListContentItemCustom fourthOption;
    private ImageView fourthPreview;
    private List<View> mCheckIcons;
    private int mStyle;
    private ImageView secondCheckIcon;
    private ListContentItemCustom secondOption;
    private ImageView secondPreview;
    private ImageView thirdCheckIcon;
    private ListContentItemCustom thirdOption;
    private ImageView thirdPreview;

    public void com_android_settings_ChooseLockThemeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ChooseLockThemeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ChooseLockThemeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ChooseLockThemeFragment() {
        this.mCheckIcons = new ArrayList(4);
    }

    public static ChooseLockThemeFragment newInstance() {
        ChooseLockThemeFragment r0 = new ChooseLockThemeFragment();
        r0.setArguments(new Bundle());
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.choose_clock_theme_layout, r3, false);
        this.firstOption = (ListContentItemCustom) this.mRootView.findViewById(R.id.first_option);
        this.firstPreview = (ImageView) this.mRootView.findViewById(R.id.first_preview);
        this.firstCheckIcon = (ImageView) this.mRootView.findViewById(R.id.first_check_icon);
        this.firstOption.setOnClickListener(this);
        this.mCheckIcons.add(this.firstCheckIcon);
        this.secondOption = (ListContentItemCustom) this.mRootView.findViewById(R.id.second_option);
        this.secondPreview = (ImageView) this.mRootView.findViewById(R.id.second_preview);
        this.secondCheckIcon = (ImageView) this.mRootView.findViewById(R.id.second_check_icon);
        this.secondOption.setOnClickListener(this);
        this.mCheckIcons.add(this.secondCheckIcon);
        this.thirdOption = (ListContentItemCustom) this.mRootView.findViewById(R.id.third_option);
        this.thirdPreview = (ImageView) this.mRootView.findViewById(R.id.third_preview);
        this.thirdCheckIcon = (ImageView) this.mRootView.findViewById(R.id.third_check_icon);
        this.thirdOption.setOnClickListener(this);
        this.mCheckIcons.add(this.thirdCheckIcon);
        this.fourthOption = (ListContentItemCustom) this.mRootView.findViewById(R.id.fourth_option);
        this.fourthPreview = (ImageView) this.mRootView.findViewById(R.id.fourth_preview);
        this.fourthCheckIcon = (ImageView) this.mRootView.findViewById(R.id.fourth_check_icon);
        this.fourthOption.setOnClickListener(this);
        this.mCheckIcons.add(this.fourthCheckIcon);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        initCheck();
    }

    public void com_android_settings_ChooseLockThemeFragment__onResume$___twin___() {
        super.onResume();
        initCheck();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.firstOption) goto L6;
        this.mStyle = 0;
    L14:
        changeCheck(this.mStyle);
        return;
    L6:
        if (r2 != this.secondOption) goto L9;
        this.mStyle = 1;
        goto L14
    L9:
        if (r2 != this.thirdOption) goto L12;
        this.mStyle = 2;
        goto L14
    L12:
        if (r2 != this.fourthOption) goto L14;
        this.mStyle = 3;
        goto L14
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        setKeyguardStyle(this.mStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initCheck() {
        int r0 = getKeyguardStyle();
        this.mStyle = r0;
        int r2 = 0;
    L4:
        if (r2 >= this.mCheckIcons.size()) goto L13;
        if (r2 != r0) goto L10;
        if (this.mCheckIcons.get(r2).getVisibility() == 0) goto L12;
        this.mCheckIcons.get(r2).setVisibility(0);
    L12:
        r2 = r2 + 1;
        goto L4
    L10:
        if (this.mCheckIcons.get(r2).getVisibility() == 4) goto L12;
        this.mCheckIcons.get(r2).setVisibility(4);
        goto L12
    }

    private void changeCheck(int r5) {
        int r1 = 0;
    L4:
        if (r1 >= this.mCheckIcons.size()) goto L13;
        if (r1 != r5) goto L10;
        if (this.mCheckIcons.get(r1).getVisibility() == 0) goto L12;
        this.mCheckIcons.get(r1).setVisibility(0);
    L12:
        r1 = r1 + 1;
        goto L4
    L10:
        if (this.mCheckIcons.get(r1).getVisibility() == 4) goto L12;
        this.mCheckIcons.get(r1).setVisibility(4);
        goto L12
    }

    private int getKeyguardStyle() {
        return android.provider.Settings.Global.getInt(getContentResolver(), "clock_theme_style", 0);
    }

    private void setKeyguardStyle(int r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "clock_theme_style", r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ChooseLockThemeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChooseLockThemeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChooseLockThemeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseLockThemeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChooseLockThemeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ChooseLockThemeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseLockThemeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChooseLockThemeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChooseLockThemeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
