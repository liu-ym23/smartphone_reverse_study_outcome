package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes6.dex */
public class ErrorDialogManager {
    public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
    public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
    public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
    protected static final String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
    protected static final String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
    public static ErrorDialogFragmentFactory<?> factory;

    public static class HoneycombManagerFragment extends Fragment {
        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;

        @Override // android.app.Fragment
        public void onCreate(Bundle r1) {
            org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
        }

        @Override // android.app.Fragment
        public void onPause() {
            org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
        }

        @Override // android.app.Fragment
        public void onResume() {
            org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
        }

        public void org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public HoneycombManagerFragment() {
        }

        public void org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment__onResume$___twin___() {
            super.onResume();
            EventBus r0 = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus = r0;
            r0.register(this);
        }

        public void org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment__onPause$___twin___() {
            this.eventBus.unregister(this);
            super.onPause();
        }

        public void onEventMainThread(ThrowableFailureEvent r5) {
            if (ErrorDialogManager.access$000(this.executionScope, r5) == true) goto L5;
            return;
        L5:
            ErrorDialogManager.checkLogException(r5);
            FragmentManager r0 = getFragmentManager();
            r0.executePendingTransactions();
            DialogFragment r2 = (DialogFragment) r0.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG);
            if (r2 == null) goto L8;
            r2.dismiss();
        L8:
            DialogFragment r4 = (DialogFragment) ErrorDialogManager.factory.prepareErrorFragment(r5, this.finishAfterDialog, this.argumentsForErrorDialog);
            if (r4 == null) goto L12;
            r4.show(r0, ErrorDialogManager.TAG_ERROR_DIALOG);
            return;
        }

        public static void attachTo(Activity r3, Object r4, boolean r5, Bundle r6) {
            FragmentManager r7 = r3.getFragmentManager();
            HoneycombManagerFragment r1 = (HoneycombManagerFragment) r7.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (r1 != null) goto L5;
            r1 = new HoneycombManagerFragment();
            r7.beginTransaction().add(r1, ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER).commit();
            r7.executePendingTransactions();
        L5:
            r1.finishAfterDialog = r5;
            r1.argumentsForErrorDialog = r6;
            r1.executionScope = r4;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(HoneycombManagerFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(HoneycombManagerFragment r2) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_Fragment " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(HoneycombManagerFragment r2) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogManager$HoneycombManagerFragment__onPause$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Fragment " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {
        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;
        private boolean skipRegisterOnNextResume;

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public SupportManagerFragment() {
        }

        public void org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
            EventBus r2 = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus = r2;
            r2.register(this);
            this.skipRegisterOnNextResume = true;
        }

        public void org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment__onResume$___twin___() {
            super.onResume();
            if (this.skipRegisterOnNextResume == false) goto L5;
            this.skipRegisterOnNextResume = false;
            return;
        L5:
            EventBus r0 = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus = r0;
            r0.register(this);
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.eventBus.unregister(this);
            super.onPause();
        }

        public void onEventMainThread(ThrowableFailureEvent r5) {
            if (ErrorDialogManager.access$000(this.executionScope, r5) == true) goto L5;
            return;
        L5:
            ErrorDialogManager.checkLogException(r5);
            androidx.fragment.app.FragmentManager r0 = getFragmentManager();
            r0.executePendingTransactions();
            androidx.fragment.app.DialogFragment r2 = (androidx.fragment.app.DialogFragment) r0.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG);
            if (r2 == null) goto L8;
            r2.dismiss();
        L8:
            androidx.fragment.app.DialogFragment r4 = (androidx.fragment.app.DialogFragment) ErrorDialogManager.factory.prepareErrorFragment(r5, this.finishAfterDialog, this.argumentsForErrorDialog);
            if (r4 == null) goto L12;
            r4.show(r0, ErrorDialogManager.TAG_ERROR_DIALOG);
            return;
        }

        public static void attachTo(Activity r3, Object r4, boolean r5, Bundle r6) {
            androidx.fragment.app.FragmentManager r7 = ((FragmentActivity) r3).getSupportFragmentManager();
            SupportManagerFragment r1 = (SupportManagerFragment) r7.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (r1 != null) goto L5;
            r1 = new SupportManagerFragment();
            r7.beginTransaction().add(r1, ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER).commit();
            r7.executePendingTransactions();
        L5:
            r1.finishAfterDialog = r5;
            r1.argumentsForErrorDialog = r6;
            r1.executionScope = r4;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SupportManagerFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SupportManagerFragment r2) {
            String r0 = r2.getClass().getName();
            org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SupportManagerFragment r2) {
            String r0 = r2.getClass().getName();
            r2.org_greenrobot_eventbus_util_ErrorDialogManager$SupportManagerFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public ErrorDialogManager() {
    }

    static /* synthetic */ boolean access$000(Object r0, ThrowableFailureEvent r1) {
        return isInExecutionScope(r0, r1);
    }

    public static void attachTo(Activity r2) {
        attachTo(r2, false, null);
    }

    public static void attachTo(Activity r1, boolean r2) {
        attachTo(r1, r2, null);
    }

    public static void attachTo(Activity r1, boolean r2, Bundle r3) {
        attachTo(r1, r1.getClass(), r2, r3);
    }

    public static void attachTo(Activity r1, Object r2, boolean r3, Bundle r4) {
        if (factory == null) goto L10;
        if (isSupportActivity(r1) == false) goto L7;
        SupportManagerFragment.attachTo(r1, r2, r3, r4);
        return;
    L7:
        HoneycombManagerFragment.attachTo(r1, r2, r3, r4);
        return;
    L10:
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }

    private static boolean isSupportActivity(Activity r3) {
        Class<?> r0 = r3.getClass();
    L3:
        r0 = r0.getSuperclass();
        if (r0 == null) goto L24;
        String r1 = r0.getName();
        if (r1.equals("androidx.fragment.app.FragmentActivity") == true) goto L7;
        if (r1.startsWith("com.actionbarsherlock.app") == false) goto L20;
        if (r1.endsWith(".SherlockActivity") == true) goto L18;
        if (r1.endsWith(".SherlockListActivity") == true) goto L18;
        if (r1.endsWith(".SherlockPreferenceActivity") == false) goto L20;
    L18:
        throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + r1);
    L20:
        if (r1.equals("android.app.Activity") == false) goto L3;
        return false;
    L7:
        return true;
    L24:
        throw new RuntimeException("Illegal activity type: " + r3.getClass());
    }

    protected static void checkLogException(ThrowableFailureEvent r2) {
        if (factory.config.logExceptions == false) goto L9;
        String r0 = factory.config.tagForLoggingExceptions;
        if (r0 != null) goto L7;
        r0 = EventBus.TAG;
    L7:
        Log.i(r0, "Error dialog manager received exception", r2.throwable);
        return;
    }

    private static boolean isInExecutionScope(Object r0, ThrowableFailureEvent r1) {
        if (r1 == null) goto L9;
        Object r2 = r1.getExecutionScope();
        if (r2 != null) goto L6;
        return true;
    L6:
        if (r2.equals(r0) == true) goto L12;
        return false;
    L12:
        return true;
    L9:
        return true;
    }
}
