package com.android.settings.deviceinfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeRecord;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.InstrumentedFragment;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrivateVolumeForget extends InstrumentedFragment {
    private static final String TAG_FORGET_CONFIRM = "forget_confirm";
    private final View.OnClickListener mConfirmListener;
    private VolumeRecord mRecord;

    public static class ForgetConfirmFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ForgetConfirmFragment() {
        }

        public static void show(Fragment r2, String r3) {
            Bundle r0 = new Bundle();
            r0.putString("android.os.storage.extra.FS_UUID", r3);
            ForgetConfirmFragment r4 = new ForgetConfirmFragment();
            r4.setArguments(r0);
            r4.setTargetFragment(r2, 0);
            r4.show(r2.getParentFragmentManager(), PrivateVolumeForget.TAG_FORGET_CONFIRM);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r9) {
            FragmentActivity r0 = getActivity();
            if (r0 == null) goto L15;
            final StorageManager r1 = (StorageManager) r0.getSystemService(StorageManager.class);
            final String r2 = getArguments().getString("android.os.storage.extra.FS_UUID");
            if (r1 == null) goto L7;
            VolumeRecord r3 = r1.findRecordByUuid(r2);
            if (r3 == null) goto L11;
            AlertDialog.Builder r10 = new AlertDialog.Builder(r0);
            r10.setTitle(TextUtils.expandTemplate(getText(R.string.storage_internal_forget_confirm_title), new CharSequence[]{r3.getNickname()}));
            r10.setMessage(TextUtils.expandTemplate(getText(R.string.storage_internal_forget_confirm), new CharSequence[]{r3.getNickname()}));
            r10.setPositiveButton(R.string.storage_menu_forget, new AnonymousClass1(this, r1, r2));
            r10.setNegativeButton(R.string.cancel, null);
            return r10.create();
        L11:
            return super.onCreateDialog(r9);
        L7:
            return super.onCreateDialog(r9);
        L15:
            return super.onCreateDialog(r9);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ForgetConfirmFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ForgetConfirmFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ForgetConfirmFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeForget$ForgetConfirmFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public void com_android_settings_deviceinfo_PrivateVolumeForget__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_deviceinfo_PrivateVolumeForget__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_PrivateVolumeForget_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_deviceinfo_PrivateVolumeForget_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrivateVolumeForget() {
        this.mConfirmListener = new AnonymousClass1(this);
    }

    static /* synthetic */ VolumeRecord access$000(PrivateVolumeForget r0) {
        return r0.mRecord;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        View r8 = r5.inflate(R.layout.storage_internal_forget, r6, false);
        TextView r9 = (TextView) r8.findViewById(R.id.body);
        Button r10 = (Button) r8.findViewById(R.id.confirm);
        if (getActivity() == null) goto L13;
        if (r9 == null) goto L13;
        if (r10 == null) goto L13;
        String r1 = getArguments().getString("android.os.storage.extra.FS_UUID");
        StorageManager r2 = (StorageManager) getActivity().getSystemService(StorageManager.class);
        if (r2 == null) goto L10;
        this.mRecord = r2.findRecordByUuid(r1);
    L10:
        if (this.mRecord == null) goto L12;
        r9.setText(TextUtils.expandTemplate(getText(R.string.storage_internal_forget_details), new CharSequence[]{this.mRecord.getNickname()}));
    L12:
        r10.setOnClickListener(this.mConfirmListener);
    L13:
        return r8;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_PrivateVolumeForget_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrivateVolumeForget r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeForget__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeForget_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrivateVolumeForget r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_deviceinfo_PrivateVolumeForget_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeForget_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrivateVolumeForget r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeForget__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
