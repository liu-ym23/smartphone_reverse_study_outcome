package com.android.settings.nfc;

import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import com.android.settings.InstrumentedFragment;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SwitchBar;
import com.android.settingslib.HelpUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidBeam extends InstrumentedFragment implements SwitchBar.OnSwitchChangeListener {
    private boolean mBeamDisallowedByBase;
    private boolean mBeamDisallowedByOnlyAdmin;
    private NfcAdapter mNfcAdapter;
    private CharSequence mOldActivityTitle;
    private SwitchBar mSwitchBar;
    private View mView;

    public void com_android_settings_nfc_AndroidBeam__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_nfc_AndroidBeam_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_nfc_AndroidBeam_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AndroidBeam() {
    }

    public void com_android_settings_nfc_AndroidBeam__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mNfcAdapter = NfcAdapter.getDefaultAdapter(getActivity());
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        super.onCreateOptionsMenu(r2, r3);
        HelpUtils.prepareHelpMenuItem(getActivity(), r2, R.string.help_uri_beam, getClass().getName());
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        MultiSDKAdapterNew.checkIfRestrictionEnforced(getActivity(), "no_outgoing_beam", UserHandle.myUserId());
        UserManager.get(getActivity());
        this.mBeamDisallowedByBase = MultiSDKAdapterNew.hasBaseUserRestriction(getActivity(), "no_outgoing_beam", UserHandle.myUserId());
        View r6 = r3.inflate(R.layout.android_beam, r4, false);
        this.mView = r6;
        return r6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        SettingsActivity r4 = (SettingsActivity) getActivity();
        this.mOldActivityTitle = r4.getActionBar().getTitle();
        SwitchBar r5 = r4.getSwitchBar();
        this.mSwitchBar = r5;
        if (this.mBeamDisallowedByOnlyAdmin == false) goto L6;
        r5.hide();
        return;
    L6:
        if (this.mBeamDisallowedByBase == false) goto L8;
    L10:
        boolean r0 = false;
    L11:
        r5.setChecked(r0);
        this.mSwitchBar.addOnSwitchChangeListener(this);
        this.mSwitchBar.setEnabled(!this.mBeamDisallowedByBase);
        this.mSwitchBar.show();
        return;
    L8:
        if (this.mNfcAdapter.isNdefPushEnabled() == false) goto L10;
        r0 = true;
        goto L11
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mOldActivityTitle == null) goto L6;
        getActivity().getActionBar().setTitle(this.mOldActivityTitle);
    L6:
        if (this.mBeamDisallowedByOnlyAdmin == true) goto L9;
        this.mSwitchBar.removeOnSwitchChangeListener(this);
        this.mSwitchBar.hide();
        return;
    }

    @Override // com.android.settings.widget.SwitchBar.OnSwitchChangeListener
    public void onSwitchChanged(Switch r2, boolean r3) {
        this.mSwitchBar.setEnabled(false);
        if (r3 == false) goto L5;
        boolean r4 = this.mNfcAdapter.enableNdefPush();
    L6:
        if (r4 == false) goto L8;
        this.mSwitchBar.setChecked(r3);
    L8:
        this.mSwitchBar.setEnabled(true);
        return;
    L5:
        r4 = this.mNfcAdapter.disableNdefPush();
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_nfc_AndroidBeam_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AndroidBeam r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_nfc_AndroidBeam__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_nfc_AndroidBeam_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AndroidBeam r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_nfc_AndroidBeam_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_nfc_AndroidBeam_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AndroidBeam r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_nfc_AndroidBeam__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
