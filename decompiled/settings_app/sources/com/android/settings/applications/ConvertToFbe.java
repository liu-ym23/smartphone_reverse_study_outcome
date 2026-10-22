package com.android.settings.applications;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ConvertToFbe extends SettingsPreferenceFragment {
    static final String CONVERT_FBE_EXTRA = "ConvertFBE";
    private static final int KEYGUARD_REQUEST = 55;
    static final String TAG = "ConvertToFBE";

    public void com_android_settings_applications_ConvertToFbe__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_ConvertToFbe__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ConvertToFbe_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ConvertToFbe_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ConvertToFbe() {
    }

    static /* synthetic */ boolean access$000(ConvertToFbe r0, int r1) {
        return r0.runKeyguardConfirmation(r1);
    }

    static /* synthetic */ void access$100(ConvertToFbe r0) {
        r0.convert();
    }

    private boolean runKeyguardConfirmation(int r4) {
        Resources r0 = getActivity().getResources();
        return new ChooseLockSettingsHelper(getActivity(), this).launchConfirmationActivity(r4, r0.getText(R.string.convert_to_file_encryption), 2);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = r1.inflate(R.layout.convert_fbe, null);
        ((Button) r4.findViewById(R.id.button_convert_fbe)).setOnClickListener(new AnonymousClass1(this));
        return r4;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 55) goto L6;
        return;
    L6:
        if (r2 != (-1)) goto L9;
        convert();
        return;
    }

    private void convert() {
        Fragment r7 = (Fragment) null;
        ((SettingsActivity) getActivity()).startPreferencePanel(ConfirmConvertToFbe.class.getName(), null, R.string.convert_to_file_encryption, null, null, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ConvertToFbe_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConvertToFbe r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ConvertToFbe__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ConvertToFbe_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConvertToFbe r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ConvertToFbe_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ConvertToFbe_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConvertToFbe r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ConvertToFbe__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
