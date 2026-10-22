package com.android.settings.eldership;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.android.settings.ExecutorManager;
import com.android.settings.R;
import com.android.settings.RingtoneSettingsActivity;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.widget.SettingListItem;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimRingtoneSettingFragment extends BaseFragment implements View.OnClickListener {
    private static final int MSG_UPDATE_RINGTONE_SUB_1 = 1;
    private static final int MSG_UPDATE_RINGTONE_SUB_2 = 2;
    private final Handler mHandler;
    private SettingListItem mItemRingtone;
    private SettingListItem mItemRingtoneSim2;
    private final BroadcastReceiver mSimStateReceiver;
    private final Runnable mUpdateSubTitleTask;

    public void com_android_settings_eldership_MultiSimRingtoneSettingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_eldership_MultiSimRingtoneSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_eldership_MultiSimRingtoneSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ SettingListItem access$000(MultiSimRingtoneSettingFragment r0) {
        return r0.mItemRingtone;
    }

    static /* synthetic */ SettingListItem access$100(MultiSimRingtoneSettingFragment r0) {
        return r0.mItemRingtoneSim2;
    }

    static /* synthetic */ Handler access$200(MultiSimRingtoneSettingFragment r0) {
        return r0.mHandler;
    }

    public MultiSimRingtoneSettingFragment() {
        super(R.layout.fragment_multi_sim_ringtone_setting);
        this.mSimStateReceiver = new AnonymousClass1(this);
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass2(this, r1);
        this.mUpdateSubTitleTask = new AnonymousClass3(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mItemRingtone = (SettingListItem) findViewByIdNullable(R.id.ringtone);
        this.mItemRingtoneSim2 = (SettingListItem) findViewByIdNullable(R.id.ringtone_sim_2);
        this.mItemRingtone.getTitleTextView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.settings_oic_card_1_fill, 0);
        this.mItemRingtoneSim2.getTitleTextView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.settings_oic_card_2_fill, 0);
        int r4 = getResources().getDimensionPixelSize(R.dimen.slot_icon_padding_text);
        this.mItemRingtone.getTitleTextView().setCompoundDrawablePadding(r4);
        this.mItemRingtoneSim2.getTitleTextView().setCompoundDrawablePadding(r4);
        this.mItemRingtone.setTag(SoundSettingsFragment.TYPE_RINGTONE);
        this.mItemRingtoneSim2.setTag(SoundSettingsFragment.TYPE_RINGTONE_SUB2);
        this.mItemRingtone.setOnClickListener(this);
        this.mItemRingtoneSim2.setOnClickListener(this);
    }

    public void com_android_settings_eldership_MultiSimRingtoneSettingFragment__onResume$___twin___() {
        super.onResume();
        registerReceiver(this.mSimStateReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        if (Utils.hasMultiSimInDevice() == false) goto L5;
        ExecutorManager.execute(this.mUpdateSubTitleTask);
        return;
    L5:
        finish();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mSimStateReceiver);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        int r0 = r3.getId();
        if (r0 != R.id.ringtone) goto L5;
    L7:
        Intent r1 = new Intent();
        r1.putExtras(SoundSettingsFragment.prepareRingtonePickerIntent(getString(R.string.sound_settings_text_phone_ring), (String) r3.getTag()));
        r1.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r1);
        return;
    L5:
        if (r0 == R.id.ringtone_sim_2) goto L7;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_eldership_MultiSimRingtoneSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MultiSimRingtoneSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eldership_MultiSimRingtoneSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eldership_MultiSimRingtoneSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MultiSimRingtoneSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_eldership_MultiSimRingtoneSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eldership_MultiSimRingtoneSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MultiSimRingtoneSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eldership_MultiSimRingtoneSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
