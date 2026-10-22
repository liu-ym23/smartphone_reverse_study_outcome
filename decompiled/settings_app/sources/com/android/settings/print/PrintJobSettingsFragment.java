package com.android.settings.print;

import android.os.Bundle;
import android.print.PrintJob;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.print.PrintManager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.preference.Preference;
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
public class PrintJobSettingsFragment extends SettingsPreferenceFragment {
    private static final String EXTRA_PRINT_JOB_ID = "EXTRA_PRINT_JOB_ID";
    private static final int MENU_ITEM_ID_CANCEL = 1;
    private static final int MENU_ITEM_ID_RESTART = 2;
    private static final String PRINT_JOB_MESSAGE_PREFERENCE = "print_job_message_preference";
    private static final String PRINT_JOB_PREFERENCE = "print_job_preference";
    private Preference mMessagePreference;
    private PrintJobId mPrintJobId;
    private Preference mPrintJobPreference;
    private final PrintManager.PrintJobStateChangeListener mPrintJobStateChangeListener;
    private PrintManager mPrintManager;

    public void com_android_settings_print_PrintJobSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_print_PrintJobSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_print_PrintJobSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrintJobSettingsFragment() {
        this.mPrintJobStateChangeListener = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(PrintJobSettingsFragment r0) {
        r0.updateUi();
    }

    public void com_android_settings_print_PrintJobSettingsFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        addPreferencesFromResource(R.xml.print_job_settings);
        this.mPrintJobPreference = findPreference(PRINT_JOB_PREFERENCE);
        this.mMessagePreference = findPreference(PRINT_JOB_MESSAGE_PREFERENCE);
        this.mPrintManager = ((PrintManager) getActivity().getSystemService("print")).getGlobalPrintManagerForUser(getActivity().getUserId());
        getActivity().getActionBar().setTitle(R.string.print_print_job);
        processArguments();
        setHasOptionsMenu(true);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        getListView().setEnabled(false);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPrintManager.addPrintJobStateChangeListener(this.mPrintJobStateChangeListener);
        updateUi();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPrintManager.removePrintJobStateChangeListener(this.mPrintJobStateChangeListener);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r4, MenuInflater r5) {
        super.onCreateOptionsMenu(r4, r5);
        PrintJob r6 = getPrintJob();
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.getInfo().isCancelling() == true) goto L9;
        r4.add(0, 1, 0, getString(R.string.print_cancel)).setShowAsAction(1);
    L9:
        if (r6.isFailed() == false) goto L12;
        r4.add(0, 2, 0, getString(R.string.print_restart)).setShowAsAction(1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r5) {
        PrintJob r0 = getPrintJob();
        if (r0 == null) goto L14;
        int r1 = r5.getItemId();
        if (r1 != 1) goto L7;
        r0.cancel();
        finish();
        return true;
    L7:
        if (r1 != 2) goto L14;
        r0.restart();
        finish();
        return true;
    L14:
        return super.onOptionsItemSelected(r5);
    }

    private void processArguments() {
        String r0 = getArguments().getString(EXTRA_PRINT_JOB_ID);
        if (r0 != null) goto L5;
        finish();
        return;
    L5:
        this.mPrintJobId = PrintJobId.unflattenFromString(r0);
    }

    private PrintJob getPrintJob() {
        return this.mPrintManager.getPrintJob(this.mPrintJobId);
    }

    private void updateUi() {
        PrintJob r1 = getPrintJob();
        if (r1 != null) goto L7;
        finish();
        return;
    L7:
        if (r1.isCancelled() == false) goto L9;
    L43:
        finish();
        return;
    L9:
        if (r1.isCompleted() == true) goto L43;
        PrintJobInfo r2 = r1.getInfo();
        int r3 = r2.getState();
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L23;
        if (r3 == 4) goto L19;
        if (r3 != 6) goto L26;
        this.mPrintJobPreference.setTitle(getString(R.string.print_failed_state_title_template, new Object[]{r2.getLabel()}));
    L26:
        this.mPrintJobPreference.setSummary(getString(R.string.print_job_summary, new Object[]{r2.getPrinterName(), DateUtils.formatSameDayTime(r2.getCreationTime(), r2.getCreationTime(), 3, 3)}));
        int r4 = r2.getState();
        if (r4 == 2) goto L33;
        if (r4 == 3) goto L33;
        if (r4 == 4) goto L32;
        if (r4 == 6) goto L32;
    L34:
        CharSequence r5 = r2.getStatus(getPackageManager());
        if (TextUtils.isEmpty(r5) == false) goto L37;
        getPreferenceScreen().removePreference(this.mMessagePreference);
    L41:
        getActivity().invalidateOptionsMenu();
        return;
    L37:
        if (getPreferenceScreen().findPreference(PRINT_JOB_MESSAGE_PREFERENCE) != null) goto L39;
        getPreferenceScreen().addPreference(this.mMessagePreference);
    L39:
        this.mMessagePreference.setSummary(r5);
    L32:
        this.mPrintJobPreference.setIcon(R.drawable.ic_print_error);
    L33:
        this.mPrintJobPreference.setIcon(R.drawable.ic_print);
        goto L34
    L19:
        if (r1.getInfo().isCancelling() == true) goto L21;
        this.mPrintJobPreference.setTitle(getString(R.string.print_blocked_state_title_template, new Object[]{r2.getLabel()}));
        goto L26
    L21:
        this.mPrintJobPreference.setTitle(getString(R.string.print_cancelling_state_title_template, new Object[]{r2.getLabel()}));
    L23:
        if (r1.getInfo().isCancelling() == true) goto L25;
        this.mPrintJobPreference.setTitle(getString(R.string.print_printing_state_title_template, new Object[]{r2.getLabel()}));
        goto L26
    L25:
        this.mPrintJobPreference.setTitle(getString(R.string.print_cancelling_state_title_template, new Object[]{r2.getLabel()}));
        goto L26
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_print_PrintJobSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrintJobSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_print_PrintJobSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_print_PrintJobSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrintJobSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_print_PrintJobSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_print_PrintJobSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrintJobSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_print_PrintJobSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
