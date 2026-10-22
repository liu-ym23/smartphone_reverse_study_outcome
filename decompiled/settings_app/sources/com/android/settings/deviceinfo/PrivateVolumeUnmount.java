package com.android.settings.deviceinfo;

import android.os.Bundle;
import android.os.storage.DiskInfo;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrivateVolumeUnmount extends SettingsPreferenceFragment {
    private final View.OnClickListener mConfirmListener;
    private DiskInfo mDisk;
    private VolumeInfo mVolume;

    public void com_android_settings_deviceinfo_PrivateVolumeUnmount__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_deviceinfo_PrivateVolumeUnmount__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_PrivateVolumeUnmount_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_deviceinfo_PrivateVolumeUnmount_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrivateVolumeUnmount() {
        this.mConfirmListener = new AnonymousClass1(this);
    }

    static /* synthetic */ VolumeInfo access$000(PrivateVolumeUnmount r0) {
        return r0.mVolume;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        StorageManager r8 = (StorageManager) getActivity().getSystemService(StorageManager.class);
        VolumeInfo r0 = r8.findVolumeById(getArguments().getString("android.os.storage.extra.VOLUME_ID"));
        this.mVolume = r0;
        this.mDisk = r8.findDiskById(r0.getDiskId());
        View r9 = r5.inflate(R.layout.storage_internal_unmount, r6, false);
        TextView r10 = (TextView) r9.findViewById(R.id.body);
        Button r11 = (Button) r9.findViewById(R.id.confirm);
        r10.setText(TextUtils.expandTemplate(getText(R.string.storage_internal_unmount_details), new CharSequence[]{this.mDisk.getDescription()}));
        r11.setOnClickListener(this.mConfirmListener);
        return r9;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_PrivateVolumeUnmount_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrivateVolumeUnmount r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeUnmount__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeUnmount_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrivateVolumeUnmount r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_deviceinfo_PrivateVolumeUnmount_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeUnmount_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrivateVolumeUnmount r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeUnmount__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
