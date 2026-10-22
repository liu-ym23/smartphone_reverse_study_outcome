package com.android.settings.revone;

import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class TntModeFragment extends BaseFragment implements View.OnClickListener {
    private static final int DELAY_UPDATING_VIEW_TIME = 100;
    private static final int SHIFT_LEFT = 8;
    private Handler mHandler;
    private final ContentObserver mShareModeObserver;
    private final ContentObserver mTntModeObserver;
    private ListContentItemCheck mirrorModeCheck;
    private ListContentItemCheck tntModeCheck;
    private ListContentItemCheck tntShareModeCheck;

    public void com_android_settings_revone_TntModeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TntModeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TntModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TntModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(TntModeFragment r0) {
        r0.updateView();
    }

    static /* synthetic */ int access$100(TntModeFragment r0) {
        return r0.getTntDefaultMode();
    }

    static /* synthetic */ void access$200(TntModeFragment r0, int r1) {
        r0.checkMode(r1);
    }

    public TntModeFragment() {
        super(R.layout.revone_fragment_bytedance_mode);
        this.mHandler = new Handler(Looper.getMainLooper());
        final Handler r1 = null;
        this.mTntModeObserver = new AnonymousClass1(this, r1);
        this.mShareModeObserver = new AnonymousClass2(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        OFloatingTitleBar r3 = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        this.tntModeCheck = (ListContentItemCheck) findViewByIdNullable(R.id.tnt_mode_check);
        this.mirrorModeCheck = (ListContentItemCheck) findViewByIdNullable(R.id.mirror_mode_check);
        this.tntShareModeCheck = (ListContentItemCheck) findViewByIdNullable(R.id.tnt_share_mode_check);
        this.tntModeCheck.setOnClickListener(this);
        this.mirrorModeCheck.setOnClickListener(this);
        this.tntShareModeCheck.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        checkMode(getTntDefaultMode());
        registerTntModeObserver();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        checkMode(getTntDefaultMode());
        registerTntModeObserver();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterTntModeObserver();
        unregisterShareModeObserver();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.tntModeCheck) goto L5;
        this.mirrorModeCheck.setChecked(false);
        this.tntModeCheck.setChecked(true);
        this.tntShareModeCheck.setChecked(false);
        setTntDefaultMode(1);
        return;
    L5:
        ListContentItemCheck r0 = this.mirrorModeCheck;
        if (r5 != r0) goto L9;
        r0.setChecked(true);
        this.tntModeCheck.setChecked(false);
        this.tntShareModeCheck.setChecked(false);
        setTntDefaultMode(0);
        return;
    L9:
        if (r5 != this.tntShareModeCheck) goto L14;
        r0.setChecked(false);
        this.tntModeCheck.setChecked(false);
        this.tntShareModeCheck.setChecked(true);
        setTntDefaultMode(1);
        return;
    }

    private int getTntDefaultMode() {
        return Settings.Secure.getInt(getContentResolver(), "pc_mode_enable", 1);
    }

    private void setTntDefaultMode(int r4) {
        if (Settings.Secure.getInt(getContentResolver(), "pc_mode_enable", 1) == r4) goto L6;
        Settings.Secure.putInt(getContentResolver(), "pc_mode_enable", r4);
        return;
    }

    private void checkMode(int r3) {
        if (r3 != 0) goto L5;
        this.mirrorModeCheck.setChecked(true);
        this.tntModeCheck.setChecked(false);
        this.tntShareModeCheck.setChecked(false);
        return;
    L5:
        this.tntModeCheck.setChecked(true);
        this.mirrorModeCheck.setChecked(false);
        this.tntShareModeCheck.setChecked(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ListContentItemCheck r0 = this.tntModeCheck;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        ListContentItemCheck r1 = this.mirrorModeCheck;
        if (r1 == null) goto L8;
        r1.setOnClickListener(null);
    L8:
        ListContentItemCheck r2 = this.tntShareModeCheck;
        if (r2 == null) goto L12;
        r2.setOnClickListener(null);
        return;
    }

    private void registerTntModeObserver() {
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("pc_mode_enable"), true, this.mTntModeObserver);
    }

    private void unregisterTntModeObserver() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mTntModeObserver);
    }

    private void unregisterShareModeObserver() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mShareModeObserver);
    }

    private void updateView() {
        this.mHandler.postDelayed(new AnonymousClass3(this), 100);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TntModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TntModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TntModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TntModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TntModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TntModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TntModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TntModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TntModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
