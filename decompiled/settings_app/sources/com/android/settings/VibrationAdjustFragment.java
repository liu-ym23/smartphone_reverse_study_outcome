package com.android.settings;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import bytedanceos.api.VibratorSmt;
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
public class VibrationAdjustFragment extends BaseFragment {
    private static final String TAG = "VibrationAdjustFragment";
    private BaseAdapter mAdapter;
    private int mCurrentValue;
    private ListView mOptionsList;

    private class OptionsAdapter extends BaseAdapter {
        private String[] mItemTitles;
        private int[] mSettingValues;
        final /* synthetic */ VibrationAdjustFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public OptionsAdapter(VibrationAdjustFragment r1, String[] r2, int[] r3) {
            this.this$0 = r1;
            this.mItemTitles = r2;
            this.mSettingValues = r3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] r0 = this.mItemTitles;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            String[] r0 = this.mItemTitles;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0[r1];
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            ListContentItemCheck r7 = new ListContentItemCheck(this.this$0.mContext);
            View r8 = r7;
        L5:
            boolean r1 = true;
            if (getCount() != 1) goto L8;
            r7.setBackgroundStyle(1);
        L14:
            r7.setTitle(this.mItemTitles[r4]);
            if (this.mSettingValues[r4] == VibrationAdjustFragment.access$500(this.this$0)) goto L18;
            r1 = false;
        L18:
            r7.setChecked(r1);
            return r8;
        L8:
            if (r4 != 0) goto L11;
            r7.setBackgroundStyle(2);
            goto L14
        L11:
            if (r4 != (getCount() - 1)) goto L13;
            r7.setBackgroundStyle(4);
            goto L14
        L13:
            r7.setBackgroundStyle(3);
            goto L14
        L4:
            r8 = r5;
            r7 = (ListContentItemCheck) r5;
            goto L5
        }
    }

    private int getVibrationValue(int r2) {
        if (r2 == 1) goto L7;
        if (r2 == 2) goto L8;
        return -1;
    L8:
        return 2;
    L7:
        return 2;
    }

    public void com_android_settings_VibrationAdjustFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_VibrationAdjustFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_VibrationAdjustFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_VibrationAdjustFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public VibrationAdjustFragment() {
    }

    static /* synthetic */ ListView access$000(VibrationAdjustFragment r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ void access$100(VibrationAdjustFragment r0, int r1) {
        r0.saveSettingOption(r1);
    }

    static /* synthetic */ int access$200(VibrationAdjustFragment r0, int r1) {
        return r0.getVibrationValue(r1);
    }

    static /* synthetic */ void access$300(VibrationAdjustFragment r0, int r1) {
        r0.vibrateIfNeed(r1);
    }

    static /* synthetic */ BaseAdapter access$400(VibrationAdjustFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$500(VibrationAdjustFragment r0) {
        return r0.mCurrentValue;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        final String[] r8 = getResources().getStringArray(R.array.navbar_vibration_setting_state_entries);
        final int[] r0 = getResources().getIntArray(R.array.navbar_vibration_setting_state_values);
        this.mCurrentValue = android.provider.Settings.System.getInt(getContentResolver(), "haptic_feedback_enabled", 1);
        this.mRootView = r5.inflate(R.layout.options_layout, r6, false);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        View r9 = Utils.inflateListTransparentHeader(this.mContext, this.mOptionsList, false);
        this.mOptionsList.addHeaderView(r9);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this, r8, r0));
        OptionsAdapter r10 = new OptionsAdapter(this, r8, r0);
        this.mAdapter = r10;
        this.mOptionsList.setAdapter(r10);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        OFloatingTitleBar r3 = this.mTitleView;
        if (r3 == null) goto L6;
        r3.setCenterTitle(Utils.getNavbarVibrationValueByMode(this.mContext));
        return;
    }

    private void saveSettingOption(int r2) {
        this.mCurrentValue = r2;
        android.provider.Settings.System.putInt(getContentResolver(), "haptic_feedback_enabled", r2);
    }

    private void vibrateIfNeed(int r2) {
        if (r2 != (-1)) goto L5;
        return;
    L5:
        VibratorSmt.vibrateEffectWithPrivilege((Vibrator) this.mContext.getSystemService("vibrator"), 0, r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_VibrationAdjustFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VibrationAdjustFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_VibrationAdjustFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_VibrationAdjustFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VibrationAdjustFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_VibrationAdjustFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_VibrationAdjustFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VibrationAdjustFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_VibrationAdjustFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
