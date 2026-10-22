package com.android.settings.nfc;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.PreferenceScreen;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentSettings extends SettingsPreferenceFragment {
    public static final String TAG = "PaymentSettings";
    private PaymentBackend mPaymentBackend;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_nfc_PaymentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_nfc_PaymentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PaymentSettings() {
    }

    public void com_android_settings_nfc_PaymentSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mPaymentBackend = new PaymentBackend(getActivity());     // Catch: Exception -> L11
        setHasOptionsMenu(true);
        PreferenceScreen r5 = getPreferenceManager().createPreferenceScreen(getActivity());
        List<PaymentBackend.PaymentAppInfo> r0 = this.mPaymentBackend.getPaymentAppInfos();
        if (r0 != null) goto L7;
    L9:
        setPreferenceScreen(r5);
        return;
    L7:
        if (r0.size() <= 0) goto L9;
        NfcPaymentPreference r1 = new NfcPaymentPreference(getPrefContext(), this.mPaymentBackend);
        r1.setKey(Constants.TYPE_PAYMENT);
        r5.addPreference(r1);
        r5.addPreference(new NfcForegroundPreference(getPrefContext(), this.mPaymentBackend));
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        ViewGroup r5 = (ViewGroup) getListView().getParent();
        View r6 = getActivity().getLayoutInflater().inflate(R.layout.nfc_payment_empty, r5, false);
        r5.addView(r6);
        setEmptyView(r6);
    }

    public void com_android_settings_nfc_PaymentSettings__onResume$___twin___() {
        super.onResume();
        this.mPaymentBackend.onResume();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPaymentBackend.onPause();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        super.onCreateOptionsMenu(r2, r3);
        MenuItem r4 = r2.add(R.string.nfc_payment_how_it_works);
        r4.setIntent(new Intent(getActivity(), HowItWorks.class));
        r4.setShowAsActionFlags(0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_nfc_PaymentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PaymentSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_nfc_PaymentSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_nfc_PaymentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PaymentSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_nfc_PaymentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_nfc_PaymentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PaymentSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_nfc_PaymentSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
