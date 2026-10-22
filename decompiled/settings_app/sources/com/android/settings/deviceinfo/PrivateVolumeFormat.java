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
import androidx.fragment.app.FragmentActivity;
import com.android.settings.InstrumentedFragment;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrivateVolumeFormat extends InstrumentedFragment {
    private final View.OnClickListener mConfirmListener;
    private DiskInfo mDisk;
    private VolumeInfo mVolume;

    public void com_android_settings_deviceinfo_PrivateVolumeFormat__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_deviceinfo_PrivateVolumeFormat__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_PrivateVolumeFormat_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_deviceinfo_PrivateVolumeFormat_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrivateVolumeFormat() {
        this.mConfirmListener = new AnonymousClass1(this);
    }

    static /* synthetic */ DiskInfo access$000(PrivateVolumeFormat r0) {
        return r0.mDisk;
    }

    static /* synthetic */ VolumeInfo access$100(PrivateVolumeFormat r0) {
        return r0.mVolume;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        StorageManager r8 = (StorageManager) ((FragmentActivity) NullSafe.nonNull(getActivity())).getSystemService(StorageManager.class);
        VolumeInfo r0 = r8.findVolumeById(getArguments().getString("android.os.storage.extra.VOLUME_ID"));
        this.mVolume = r0;
        this.mDisk = r8.findDiskById(r0.getDiskId());
        View r9 = r5.inflate(R.layout.storage_internal_format, r6, false);
        TextView r10 = (TextView) r9.findViewById(R.id.body);
        Button r11 = (Button) r9.findViewById(R.id.confirm);
        r10.setText(TextUtils.expandTemplate(getText(R.string.storage_internal_format_details), new CharSequence[]{this.mDisk.getDescription()}));
        r11.setOnClickListener(this.mConfirmListener);
        return r9;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_PrivateVolumeFormat_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrivateVolumeFormat r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeFormat__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeFormat_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrivateVolumeFormat r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_deviceinfo_PrivateVolumeFormat_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeFormat_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrivateVolumeFormat r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeFormat__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
