package com.bytedance.wirelesscast;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes3.dex */
public class LeBoControllerDialogFragment extends DialogFragment {
    private SmtLinkInfo.OnConnectedListener mListener;
    private String mTitle;

    public void com_bytedance_wirelesscast_LeBoControllerDialogFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_bytedance_wirelesscast_LeBoControllerDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_bytedance_wirelesscast_LeBoControllerDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_bytedance_wirelesscast_LeBoControllerDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ SmtLinkInfo.OnConnectedListener access$000(LeBoControllerDialogFragment r0) {
        return r0.mListener;
    }

    public LeBoControllerDialogFragment(String r1, SmtLinkInfo.OnConnectedListener r2) {
        this.mTitle = r1;
        this.mListener = r2;
        setCancelable(true);
    }

    public LeBoControllerDialogFragment() {
        setCancelable(true);
    }

    public LeBoControllerDialog onCreateControllerDialog(Context r3, Bundle r4) {
        return new LeBoControllerDialog(r3, getTheme(), this.mTitle, this.mListener);
    }

    public OAlertDialog onCreateControllerDialog(Context r3) {
        return new OAlertDialogBuilder(r3).autoDismiss(false).horizontalButton().title(this.mTitle, true).negativeButton(R.string.media_route_controller_disconnect, new AnonymousClass1(this)).createDialog();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r1) {
        return onCreateControllerDialog(getContext());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_bytedance_wirelesscast_LeBoControllerDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LeBoControllerDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_bytedance_wirelesscast_LeBoControllerDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_bytedance_wirelesscast_LeBoControllerDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LeBoControllerDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_bytedance_wirelesscast_LeBoControllerDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_bytedance_wirelesscast_LeBoControllerDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LeBoControllerDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_bytedance_wirelesscast_LeBoControllerDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
