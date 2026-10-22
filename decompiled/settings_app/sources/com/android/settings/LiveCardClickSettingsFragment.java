package com.android.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LiveCardClickSettingsFragment extends BaseFragment implements View.OnClickListener {
    public static final int DEFAULT_MODE = 0;
    public static final String LiveCardClickAction = "live_card_click_action";
    public static final int MODE_EXPAND = 0;
    public static final int MODE_OPEN_APP = 1;
    private OCardListItem mLiveCardExpandActionView;
    private OCardListItem mLiveCardOpenActionView;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveCardClickMode {
    }

    public void com_android_settings_LiveCardClickSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_LiveCardClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_LiveCardClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LiveCardClickSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mTitleResId = Integer.valueOf(R.string.live_card_click_title);
        this.mRootView = r2.inflate(R.layout.live_card_click_settings_fragment, r3, false);
        OCardListItem r5 = (OCardListItem) this.mRootView.findViewById(R.id.live_card_expand);
        this.mLiveCardExpandActionView = r5;
        OCardListItemUtils.setCustomEndImageView(r5);
        this.mLiveCardExpandActionView.showCustomEnd(false);
        this.mLiveCardExpandActionView.setOnContentClickListener(this);
        OCardListItem r6 = (OCardListItem) this.mRootView.findViewById(R.id.live_card_open_app);
        this.mLiveCardOpenActionView = r6;
        OCardListItemUtils.setCustomEndImageView(r6);
        this.mLiveCardOpenActionView.showCustomEnd(false);
        this.mLiveCardOpenActionView.setOnContentClickListener(this);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setupViewData();
    }

    public void com_android_settings_LiveCardClickSettingsFragment__onResume$___twin___() {
        super.onResume();
        setupViewData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mLiveCardExpandActionView.getContentContainer()) goto L6;
        setLiveCardClickMode(0);
        return;
    L6:
        if (r2 != this.mLiveCardOpenActionView.getContentContainer()) goto L10;
        setLiveCardClickMode(1);
        return;
    }

    private void setupViewData() {
        int r0 = getLiveCardClickMode(this.mContext);
        OCardListItem r1 = this.mLiveCardExpandActionView;
        boolean r2 = false;
        if (r0 != 0) goto L5;
        boolean r4 = true;
    L6:
        r1.showCustomEnd(r4);
        OCardListItem r5 = this.mLiveCardOpenActionView;
        if (r0 != 1) goto L9;
        r2 = true;
    L9:
        r5.showCustomEnd(r2);
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void setLiveCardClickMode(int r3) {
        android.provider.Settings.Secure.putInt(getContentResolver(), LiveCardClickAction, r3);
        setupViewData();
    }

    public static int getLiveCardClickMode(Context r2) {
        return android.provider.Settings.Secure.getInt(r2.getContentResolver(), LiveCardClickAction, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LiveCardClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LiveCardClickSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LiveCardClickSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LiveCardClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LiveCardClickSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_LiveCardClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LiveCardClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LiveCardClickSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LiveCardClickSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
