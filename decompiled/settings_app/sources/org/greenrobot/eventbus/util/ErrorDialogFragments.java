package org.greenrobot.eventbus.util;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes6.dex */
public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON;
    public static Class<?> EVENT_TYPE_ON_CLICK;

    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.app.DialogFragment, android.app.Fragment
        public void onCreate(Bundle r1) {
            org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
        }

        @Override // android.app.Fragment
        public void onPause() {
            org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
        }

        @Override // android.app.Fragment
        public void onResume() {
            org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
        }

        public void org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb__onPause$___twin___() {
            super.onPause();
        }

        public void org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb__onResume$___twin___() {
            super.onResume();
        }

        public Honeycomb() {
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle r2) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            ErrorDialogFragments.handleOnClick(r2, r3, getActivity(), getArguments());
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(Honeycomb r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(Honeycomb r2) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_Fragment " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(Honeycomb r2) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogFragments$Honeycomb__onPause$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Fragment " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            org_greenrobot_eventbus_util_ErrorDialogFragments$Support_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            org_greenrobot_eventbus_util_ErrorDialogFragments$Support_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public void org_greenrobot_eventbus_util_ErrorDialogFragments$Support__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void org_greenrobot_eventbus_util_ErrorDialogFragments$Support__onResume$___twin___() {
            super.onResume();
        }

        public Support() {
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r2) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            ErrorDialogFragments.handleOnClick(r2, r3, getActivity(), getArguments());
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void org_greenrobot_eventbus_util_ErrorDialogFragments$Support_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(Support r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogFragments$Support__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void org_greenrobot_eventbus_util_ErrorDialogFragments$Support_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(Support r2) {
            String r0 = r2.getClass().getName();
            org_greenrobot_eventbus_util_ErrorDialogFragments$Support_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void org_greenrobot_eventbus_util_ErrorDialogFragments$Support_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(Support r2) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogFragments$Support__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    static {
    }

    public ErrorDialogFragments() {
    }

    public static Dialog createDialog(Context r1, Bundle r2, DialogInterface.OnClickListener r3) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r1);
        r0.setTitle(r2.getString(ErrorDialogManager.KEY_TITLE));
        r0.setMessage(r2.getString(ErrorDialogManager.KEY_MESSAGE));
        int r4 = ERROR_DIALOG_ICON;
        if (r4 == 0) goto L5;
        r0.setIcon(r4);
    L5:
        r0.setPositiveButton(R.string.ok, r3);
        return r0.create();
    }

    public static void handleOnClick(DialogInterface r0, int r1, Activity r2, Bundle r3) {
        Class<?> r4 = EVENT_TYPE_ON_CLICK;
        if (r4 == null) goto L10;
        Object r5 = r4.newInstance();     // Catch: Exception -> L6
        ErrorDialogManager.factory.config.getEventBus().post(r5);
    L6:
        e = move-exception;
        throw new RuntimeException("Event cannot be constructed", e);
    L10:
        if (r3.getBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) == false) goto L16;
        if (r2 == null) goto L17;
        r2.finish();
        return;
    L17:
        return;
    }
}
