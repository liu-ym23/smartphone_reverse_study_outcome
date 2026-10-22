package com.android.settings.fingerprint;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.setupwizardlib.util.SystemBarHelper;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SetupSkipDialog extends DialogFragment implements DialogInterface.OnClickListener {
    private static final String ARG_FRP_SUPPORTED = "frp_supported";
    public static final String EXTRA_FRP_SUPPORTED = ":settings:frp_supported";
    private static final int RESULT_SKIP = 11;
    private static final String TAG_SKIP_DIALOG = "skip_dialog";

    public void com_android_settings_fingerprint_SetupSkipDialog__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_fingerprint_SetupSkipDialog__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_SetupSkipDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fingerprint_SetupSkipDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SetupSkipDialog() {
    }

    public static SetupSkipDialog newInstance(boolean r3) {
        SetupSkipDialog r0 = new SetupSkipDialog();
        Bundle r1 = new Bundle();
        r1.putBoolean(ARG_FRP_SUPPORTED, r3);
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r1) {
        AlertDialog r0 = onCreateDialogBuilder().create();
        SystemBarHelper.hideSystemBars(r0);
        return r0;
    }

    public AlertDialog.Builder onCreateDialogBuilder() {
        Bundle r0 = getArguments();
        AlertDialog.Builder r3 = new AlertDialog.Builder(getContext()).setPositiveButton(R.string.skip_anyway_button_label, this).setNegativeButton(R.string.go_back_button_label, this);
        if (r0.getBoolean(ARG_FRP_SUPPORTED) == false) goto L5;
        int r1 = R.string.lock_screen_intro_skip_dialog_text_frp;
    L7:
        return r3.setMessage(r1);
    L5:
        r1 = R.string.lock_screen_intro_skip_dialog_text;
        goto L7
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (r2 != (-1)) goto L7;
        FragmentActivity r0 = getActivity();
        r0.setResult(11);
        r0.finish();
        return;
    }

    public void show(FragmentManager r2) {
        show(r2, TAG_SKIP_DIALOG);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_SetupSkipDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SetupSkipDialog r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_SetupSkipDialog__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_SetupSkipDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SetupSkipDialog r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fingerprint_SetupSkipDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_SetupSkipDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SetupSkipDialog r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_SetupSkipDialog__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
