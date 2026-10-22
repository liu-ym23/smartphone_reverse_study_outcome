package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ApplicationErrorReport;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.InstrumentedFragment;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RunningServiceDetails extends InstrumentedFragment implements RunningState_.OnRefreshUiListener {
    static final int DIALOG_CONFIRM_STOP = 1;
    static final String KEY_BACKGROUND = "background";
    static final String KEY_PROCESS = "process";
    static final String KEY_UID = "uid";
    static final String KEY_USER_ID = "user_id";
    static final String TAG = "RunningServicesDetails";
    final ArrayList<ActiveDetail> mActiveDetails;
    ViewGroup mAllDetails;
    ActivityManager mAm;
    StringBuilder mBuilder;
    boolean mHaveData;
    LayoutInflater mInflater;
    RunningState_.MergedItem mMergedItem;
    int mNumProcesses;
    int mNumServices;
    String mProcessName;
    TextView mProcessesHeader;
    View mRootView;
    TextView mServicesHeader;
    boolean mShowBackground;
    ViewGroup mSnippet;
    RunningProcessesView_.ActiveItem mSnippetActiveItem;
    RunningProcessesView_.ViewHolder mSnippetViewHolder;
    RunningState_ mState;
    int mUid;
    int mUserId;

    class ActiveDetail implements View.OnClickListener {
        RunningProcessesView_.ActiveItem mActiveItem;
        ComponentName mInstaller;
        PendingIntent mManageIntent;
        OButton mReportButton;
        View mRootView;
        RunningState_.ServiceItem mServiceItem;
        OButton mStopButton;
        RunningProcessesView_.ViewHolder mViewHolder;
        final /* synthetic */ RunningServiceDetails this$0;

        ActiveDetail(RunningServiceDetails r1) {
            this.this$0 = r1;
        }

        void stopActiveService(boolean r4) {
            RunningState_.ServiceItem r0 = this.mServiceItem;
            if (r4 == false) goto L5;
        L8:
            this.this$0.getActivity().stopService(new Intent().setComponent(r0.mRunningService.service));
            if (this.this$0.mMergedItem != null) goto L12;
            this.this$0.mState.updateNow();
            RunningServiceDetails.access$100(this.this$0);
            return;
        L12:
            if (this.this$0.mShowBackground == false) goto L14;
        L16:
            this.this$0.mState.updateNow();
            return;
        L14:
            if (this.this$0.mMergedItem.mServices.size() > 1) goto L16;
            this.this$0.mState.updateNow();
            RunningServiceDetails.access$100(this.this$0);
            return;
        L5:
            if ((r0.mServiceInfo.applicationInfo.flags & 1) == 0) goto L8;
            RunningServiceDetails.access$000(this.this$0, r0.mRunningService.service);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r15) {
            if (r15 != this.mReportButton) goto L51;
            ApplicationErrorReport r16 = new ApplicationErrorReport();
            r16.type = 5;
            r16.packageName = this.mServiceItem.mServiceInfo.packageName;
            r16.installerPackageName = this.mInstaller.getPackageName();
            r16.processName = this.mServiceItem.mRunningService.process;
            r16.time = System.currentTimeMillis();
            if ((this.mServiceItem.mServiceInfo.applicationInfo.flags & 1) == 0) goto L7;
            boolean r2 = true;
        L8:
            r16.systemApp = r2;
            ApplicationErrorReport.RunningServiceInfo r3 = new ApplicationErrorReport.RunningServiceInfo();
            if (this.mActiveItem.mFirstRunTime < 0) goto L11;
            r3.durationMillis = SystemClock.elapsedRealtime() - this.mActiveItem.mFirstRunTime;
        L12:
            ComponentName r6 = new ComponentName(this.mServiceItem.mServiceInfo.packageName, this.mServiceItem.mServiceInfo.name);
            File r7 = this.this$0.getActivity().getFileStreamPath("service_dump.txt");
            FileOutputStream r8 = null;
            FileInputStream r9 = null;
            r9 = null;
            FileOutputStream r10 = new FileOutputStream(r7);     // Catch: Throwable -> L21 IOException -> L23
            Debug.dumpService("activity", r10.getFD(), new String[]{"-a", "service", r6.flattenToString()});     // Catch: Throwable -> L17 IOException -> L19
        L81:
            r10.close();     // Catch: IOException -> L68
        L72:
            FileInputStream r1 = new FileInputStream(r7);     // Catch: Throwable -> L36 IOException -> L38
            byte[] r4 = new byte[(int) r7.length()];     // Catch: Throwable -> L32 IOException -> L34
            r1.read(r4);     // Catch: Throwable -> L32 IOException -> L34
            r3.serviceDetails = new String(r4);     // Catch: Throwable -> L32 IOException -> L34
            r1.close();     // Catch: IOException -> L69
        L84:
            goto L42
        L34:
            e = e;
            r9 = r1;
        L39:
            OLog.w(RunningServiceDetails.TAG, "Can't read service dump: " + r6, e);     // Catch: Throwable -> L36
            if (r9 == null) goto L42;
            r9.close();     // Catch: IOException -> L69
        L32:
            th = th;
            r9 = r1;
        L44:
            if (r9 != null) goto L74;
        L46:
            throw th;
        L74:
            r9.close();     // Catch: IOException -> L70
        L36:
            th = th;
        L38:
            e = e;
        L42:
            r7.delete();
            OLog.i(RunningServiceDetails.TAG, "Details: " + r3.serviceDetails);
            r16.runningServiceInfo = r3;
            Intent r0 = new Intent("android.intent.action.APP_ERROR");
            r0.setComponent(this.mInstaller);
            r0.putExtra(LibUtil.PARCELABLE_EXTRA, r16);
            r0.addFlags(268435456);
            this.this$0.startActivity(r0);
            return;
        L19:
            e = e;
        L25:
            OLog.w(RunningServiceDetails.TAG, "Can't dump service: " + r6, e);     // Catch: Throwable -> L17
            if (r10 == null) goto L72;
        L17:
            th = th;
            r8 = r10;
        L47:
            if (r8 != null) goto L82;
        L49:
            throw th;
        L82:
            r8.close();     // Catch: IOException -> L71
        L23:
            e = e;
            r10 = null;
        L21:
            th = th;
            goto L47
        L11:
            r3.durationMillis = -1;
            goto L12
        L7:
            r2 = false;
            goto L8
        L51:
            if (this.mManageIntent == null) goto L61;
            this.this$0.getActivity().startIntentSender(this.mManageIntent.getIntentSender(), null, 268959744, 524288, 0);     // Catch: ActivityNotFoundException -> L54 IllegalArgumentException -> L56 IntentSender.SendIntentException -> L58
        L96:
            return;
        L54:
            e = move-exception;
            OLog.w(RunningServiceDetails.TAG, e);
            return;
        L58:
            e = move-exception;
            OLog.w(RunningServiceDetails.TAG, e);
            return;
        L56:
            e = move-exception;
            OLog.w(RunningServiceDetails.TAG, e);
            return;
        L61:
            if (this.mServiceItem == null) goto L64;
            stopActiveService(false);
            return;
        L64:
            if (this.mActiveItem.mItem.mBackground == false) goto L66;
            this.this$0.mAm.killBackgroundProcesses(this.mActiveItem.mItem.mPackageInfo.packageName);
            RunningServiceDetails.access$100(this.this$0);
            return;
        L66:
            this.this$0.mAm.forceStopPackage(this.mActiveItem.mItem.mPackageInfo.packageName);
            RunningServiceDetails.access$100(this.this$0);
        }
    }

    public static class MyAlertDialogFragment extends DialogFragment {
        public void com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public MyAlertDialogFragment() {
        }

        public static MyAlertDialogFragment newConfirmStop(int r3, ComponentName r4) {
            MyAlertDialogFragment r0 = new MyAlertDialogFragment();
            Bundle r1 = new Bundle();
            r1.putInt("id", r3);
            r1.putParcelable("comp", r4);
            r0.setArguments(r1);
            return r0;
        }

        RunningServiceDetails getOwner() {
            return (RunningServiceDetails) getTargetFragment();
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r5) {
            int r6 = getArguments().getInt("id");
            if (r6 != 1) goto L10;
            final ComponentName r7 = (ComponentName) getArguments().getParcelable("comp");
            if (getOwner().activeDetailForService(r7) != null) goto L8;
            return null;
        L8:
            return new AlertDialog.Builder(getActivity()).setTitle(getActivity().getString(R.string.runningservicedetails_stop_dlg_title)).setMessage(getActivity().getString(R.string.runningservicedetails_stop_dlg_text)).setPositiveButton(R.string.dlg_ok, new AnonymousClass1(this, r7)).setNegativeButton(R.string.dlg_cancel, null).create();
        L10:
            throw new IllegalArgumentException("unknown id " + r6);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MyAlertDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MyAlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MyAlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_applications_RunningServiceDetails$MyAlertDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_RunningServiceDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_RunningServiceDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public RunningServiceDetails() {
        this.mActiveDetails = new ArrayList();
        this.mBuilder = new StringBuilder(128);
    }

    static /* synthetic */ void access$000(RunningServiceDetails r0, ComponentName r1) {
        r0.showConfirmStopDialog(r1);
    }

    static /* synthetic */ void access$100(RunningServiceDetails r0) {
        r0.finish();
    }

    boolean findMergedItem() {
        if (this.mShowBackground == false) goto L5;
        ArrayList<RunningState_.MergedItem> r0 = this.mState.getCurrentBackgroundItems();
    L7:
        if (r0 == null) goto L29;
        int r2 = 0;
    L10:
        if (r2 >= r0.size()) goto L29;
        RunningState_.MergedItem r3 = r0.get(r2);
        if (r3.mUserId != this.mUserId) goto L28;
        if (this.mUid < 0) goto L22;
        if (r3.mProcess == null) goto L22;
        if (r3.mProcess.mUid != this.mUid) goto L28;
    L22:
        if (this.mProcessName == null) goto L31;
        if (r3.mProcess == null) goto L28;
        if (this.mProcessName.equals(r3.mProcess.mProcessName) == false) goto L28;
    L31:
        if (this.mMergedItem == r3) goto L34;
        this.mMergedItem = r3;
        return true;
    L34:
        return false;
    L28:
        r2 = r2 + 1;
    L29:
        r3 = null;
        goto L31
    L5:
        r0 = this.mState.getCurrentMergedItems();
        goto L7
    }

    void addServicesHeader() {
        if (this.mNumServices != 0) goto L5;
        TextView r0 = (TextView) this.mInflater.inflate(R.layout.separator_label, this.mAllDetails, false);
        this.mServicesHeader = r0;
        r0.setText(R.string.runningservicedetails_services_title);
        this.mAllDetails.addView(this.mServicesHeader);
    L5:
        this.mNumServices++;
    }

    void addProcessesHeader() {
        if (this.mNumProcesses != 0) goto L5;
        TextView r0 = (TextView) this.mInflater.inflate(R.layout.separator_label, this.mAllDetails, false);
        this.mProcessesHeader = r0;
        r0.setText(R.string.runningservicedetails_processes_title);
        this.mAllDetails.addView(this.mProcessesHeader);
    L5:
        this.mNumProcesses++;
    }

    void addServiceDetailsView(RunningState_.ServiceItem r8, RunningState_.MergedItem r9, boolean r10, boolean r11) {
        if (r10 == false) goto L5;
        addServicesHeader();
    L7:
        if (r8 == null) goto L9;
        RunningState_.BaseItem r0 = r8;
    L10:
        ActiveDetail r1 = new ActiveDetail(this);
        boolean r5 = false;
        View r2 = this.mInflater.inflate(R.layout.running_service_details_service, this.mAllDetails, false);
        this.mAllDetails.addView(r2);
        r1.mRootView = r2;
        r1.mServiceItem = r8;
        r1.mViewHolder = new RunningProcessesView_.ViewHolder(r2);
        r1.mActiveItem = r1.mViewHolder.bind(this.mState, r0, this.mBuilder);
        if (r11 == true) goto L13;
        r2.findViewById(R.id.service).setVisibility(8);
    L13:
        if (r8 != null) goto L15;
    L17:
        TextView r12 = (TextView) r2.findViewById(R.id.comp_description);
        r1.mStopButton = (OButton) r2.findViewById(R.id.left_button);
        r1.mReportButton = (OButton) r2.findViewById(R.id.right_button);
        if (r10 == false) goto L23;
        if (r9.mUserId == UserHandle.myUserId()) goto L23;
        r12.setVisibility(8);
        r2.findViewById(R.id.control_buttons_panel).setVisibility(8);
    L53:
        this.mActiveDetails.add(r1);
        return;
    L23:
        if (r8 == null) goto L28;
        if (r8.mServiceInfo.descriptionRes == 0) goto L28;
        r12.setText(getActivity().getPackageManager().getText(r8.mServiceInfo.packageName, r8.mServiceInfo.descriptionRes, r8.mServiceInfo.applicationInfo));
    L41:
        r1.mStopButton.setOnClickListener(r1);
        OButton r13 = r1.mStopButton;
        FragmentActivity r14 = getActivity();
        if (r1.mManageIntent == null) goto L44;
        int r3 = R.string.service_manage;
    L45:
        r13.setText(r14.getText(r3));
        r1.mReportButton.setOnClickListener(r1);
        r1.mReportButton.setText(android.R.string.status_bar_battery);
        if (Settings.Global.getInt(getActivity().getContentResolver(), LibUtil.KEY_ENABLE_BUG_REPORT, 0) == 0) goto L52;
        if (r8 == null) goto L52;
        r1.mInstaller = ApplicationErrorReport.getErrorReportReceiver(getActivity(), r8.mServiceInfo.packageName, r8.mServiceInfo.applicationInfo.flags);
        OButton r15 = r1.mReportButton;
        if (r1.mInstaller == null) goto L51;
        r5 = true;
    L51:
        r15.setEnabled(r5);
    L52:
        r1.mReportButton.setEnabled(false);
        goto L53
    L44:
        r3 = R.string.service_stop;
    L28:
        if (r9.mBackground == false) goto L31;
        r12.setText(R.string.background_process_stop_description);
        goto L41
    L31:
        if (r1.mManageIntent != null) goto L56;
        FragmentActivity r16 = getActivity();
        if (r8 == null) goto L39;
        int r4 = R.string.service_stop_description;
    L40:
        r12.setText(r16.getText(r4));
        goto L41
    L39:
        r4 = R.string.heavy_weight_stop_description;
        goto L40
    L56:
        Resources r17 = getActivity().getPackageManager().getResourcesForApplication(r8.mRunningService.clientPackage);     // Catch: PackageManager.NameNotFoundException -> L55
        if (r17 == null) goto L41;
        r12.setText(getActivity().getString(R.string.service_manage_description, new Object[]{r17.getString(r8.mRunningService.clientLabel)}));     // Catch: PackageManager.NameNotFoundException -> L55
        goto L41
    L15:
        if (r8.mRunningService.clientLabel == 0) goto L17;
        r1.mManageIntent = this.mAm.getRunningServiceControlPanel(r8.mRunningService.service);
        goto L17
    L9:
        r0 = r9;
        goto L10
    L5:
        if (r9.mUserId == UserHandle.myUserId()) goto L7;
        addProcessesHeader();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.android.settings.applications.RunningProcessesView_$ViewHolder] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r8v2, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void addProcessDetailsView(RunningState_.ProcessItem r8, boolean r9) {
        addProcessesHeader();
        ActiveDetail r0 = new ActiveDetail(this);
        View r1 = this.mInflater.inflate(R.layout.running_service_details_process, this.mAllDetails, false);
        this.mAllDetails.addView(r1);
        r0.mRootView = r1;
        r0.mViewHolder = new RunningProcessesView_.ViewHolder(r1);
        ?? r2 = r0.mViewHolder;
        RunningState_ r3 = this.mState;
        ?? r5 = this.mBuilder;
        r0.mActiveItem = r2.bind(r3, r8, r5);
        TextView r4 = (TextView) NullSafe.nonNull(r1.findViewById(R.id.comp_description));
        if (r8.mUserId == UserHandle.myUserId()) goto L5;
        r4.setVisibility(8);
    L22:
        this.mActiveDetails.add(r0);
        return;
    L5:
        if (r9 == false) goto L7;
        r4.setText(R.string.main_running_process_description);
        goto L22
    L7:
        ActivityManager.RunningAppProcessInfo r10 = r8.mRunningProcessInfo;
        ComponentName r11 = r10.importanceReasonComponent;
        int r12 = r10.importanceReasonCode;
        CharSequence r6 = null;
        if (r12 != 1) goto L10;
        r5 = 2131957330(0x7f131652, float:1.955124E38);
        r5 = 2131957330(0x7f131652, float:1.955124E38);
        if (r10.importanceReasonComponent == null) goto L19;
        ProviderInfo r13 = getActivity().getPackageManager().getProviderInfo(r10.importanceReasonComponent, 0);     // Catch: PackageManager.NameNotFoundException -> L24
        r6 = RunningState_.makeLabel(getActivity().getPackageManager(), r13.name, r13);     // Catch: PackageManager.NameNotFoundException -> L24
    L25:
        goto L19
    L10:
        if (r12 == 2) goto L12;
        r5 = 0;
        goto L19
    L12:
        r5 = 2131957331(0x7f131653, float:1.9551243E38);
        r5 = 2131957331(0x7f131653, float:1.9551243E38);
        if (r10.importanceReasonComponent == null) goto L19;
        ServiceInfo r14 = getActivity().getPackageManager().getServiceInfo(r10.importanceReasonComponent, 0);     // Catch: PackageManager.NameNotFoundException -> L24
        r6 = RunningState_.makeLabel(getActivity().getPackageManager(), r14.name, r14);     // Catch: PackageManager.NameNotFoundException -> L24
    L19:
        if (r5 == 0) goto L22;
        if (r6 == null) goto L22;
        r4.setText(getActivity().getString(r5, new Object[]{r6}));
        goto L22
    }

    void addDetailsViews(RunningState_.MergedItem r4, boolean r5, boolean r6) {
        if (r4 == null) goto L32;
        boolean r1 = true;
        if (r5 == false) goto L9;
        int r7 = 0;
    L7:
        if (r7 >= r4.mServices.size()) goto L9;
        addServiceDetailsView(r4.mServices.get(r7), r4, true, true);
        r7 = r7 + 1;
    L9:
        if (r6 == true) goto L11;
        return;
    L11:
        if (r4.mServices.size() <= 0) goto L13;
        int r8 = -1;
    L19:
        if (r8 >= r4.mOtherProcesses.size()) goto L39;
        if (r8 >= 0) goto L22;
        RunningState_.ProcessItem r9 = r4.mProcess;
    L23:
        if (r9 != null) goto L25;
    L27:
        if (r8 >= 0) goto L29;
        boolean r2 = true;
    L30:
        addProcessDetailsView(r9, r2);
    L31:
        r8 = r8 + 1;
        goto L19
    L29:
        r2 = false;
        goto L30
    L25:
        if (r9.mPid > 0) goto L27;
    L22:
        r9 = r4.mOtherProcesses.get(r8);
        goto L23
    L39:
        return;
    L13:
        if (r4.mUserId != UserHandle.myUserId()) goto L16;
        r1 = false;
    L16:
        addServiceDetailsView(null, r4, false, r1);
        return;
    }

    void addDetailViews() {
        int r0 = this.mActiveDetails.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mAllDetails.removeView(this.mActiveDetails.get(r0).mRootView);
        r0 = r0 - 1;
        goto L3
    L5:
        this.mActiveDetails.clear();
        TextView r1 = this.mServicesHeader;
        if (r1 == null) goto L8;
        this.mAllDetails.removeView(r1);
        this.mServicesHeader = null;
    L8:
        TextView r2 = this.mProcessesHeader;
        if (r2 == null) goto L11;
        this.mAllDetails.removeView(r2);
        this.mProcessesHeader = null;
    L11:
        this.mNumProcesses = 0;
        this.mNumServices = 0;
        RunningState_.MergedItem r3 = this.mMergedItem;
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.mUser != null) goto L16;
        addDetailsViews(this.mMergedItem, true, true);
        return;
    L16:
        if (this.mShowBackground == false) goto L18;
        ArrayList<RunningState_.MergedItem> r4 = new ArrayList(this.mMergedItem.mChildren);
        Collections.sort(r4, this.mState.mBackgroundComparator);
    L19:
        int r5 = 0;
    L21:
        if (r5 >= r4.size()) goto L23;
        addDetailsViews(r4.get(r5), true, false);
        r5 = r5 + 1;
        goto L21
    L23:
        int r6 = 0;
    L25:
        if (r6 >= r4.size()) goto L33;
        addDetailsViews(r4.get(r6), false, true);
        r6 = r6 + 1;
        goto L25
    L33:
        return;
    L18:
        r4 = this.mMergedItem.mChildren;
        goto L19
    }

    void refreshUi(boolean r4) {
        if (findMergedItem() == false) goto L5;
        r4 = true;
    L5:
        if (r4 == false) goto L15;
        RunningState_.MergedItem r5 = this.mMergedItem;
        if (r5 == null) goto L9;
        this.mSnippetActiveItem = this.mSnippetViewHolder.bind(this.mState, r5, this.mBuilder);
    L12:
        addDetailViews();
        return;
    L9:
        RunningProcessesView_.ActiveItem r6 = this.mSnippetActiveItem;
        if (r6 == null) goto L13;
        r6.mHolder.size.setText("");
        this.mSnippetActiveItem.mHolder.uptime.setText("");
        this.mSnippetActiveItem.mHolder.description.setText(R.string.no_services);
        goto L12
    L13:
        finish();
        return;
    }

    private void finish() {
        new Handler().post(new AnonymousClass1(this));
    }

    public void com_android_settings_applications_RunningServiceDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mUid = getArguments().getInt("uid", -1);
        this.mUserId = getArguments().getInt("user_id", 0);
        this.mProcessName = getArguments().getString("process", null);
        this.mShowBackground = getArguments().getBoolean(KEY_BACKGROUND, false);
        this.mAm = (ActivityManager) getActivity().getSystemService("activity");
        this.mInflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        this.mState = RunningState_.getInstance(getActivity());
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.running_service_details, r3, false);
        Utils.prepareCustomPreferencesList(r3, r5, r5, false);
        this.mRootView = r5;
        this.mAllDetails = (ViewGroup) r5.findViewById(R.id.all_details);
        this.mSnippet = (ViewGroup) r5.findViewById(R.id.snippet);
        this.mSnippetViewHolder = new RunningProcessesView_.ViewHolder(this.mSnippet);
        ensureData();
        return r5;
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHaveData = false;
        this.mState.pause();
    }

    public void com_android_settings_applications_RunningServiceDetails__onResume$___twin___() {
        super.onResume();
        ensureData();
    }

    ActiveDetail activeDetailForService(ComponentName r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mActiveDetails.size()) goto L13;
        ActiveDetail r1 = this.mActiveDetails.get(r0);
        if (r1.mServiceItem == null) goto L12;
        if (r1.mServiceItem.mRunningService == null) goto L12;
        if (r4.equals(r1.mServiceItem.mRunningService.service) == false) goto L12;
        return r1;
    L12:
        r0 = r0 + 1;
        goto L4
    L13:
        return null;
    }

    private void showConfirmStopDialog(ComponentName r2) {
        MyAlertDialogFragment r3 = MyAlertDialogFragment.newConfirmStop(1, r2);
        r3.setTargetFragment(this, 0);
        r3.show(getFragmentManager(), "confirmstop");
    }

    void ensureData() {
        if (this.mHaveData == true) goto L6;
        this.mHaveData = true;
        this.mState.resume(this);
        this.mState.waitForData();
        refreshUi(true);
        return;
    }

    void updateTimes() {
        RunningProcessesView_.ActiveItem r0 = this.mSnippetActiveItem;
        if (r0 == null) goto L5;
        r0.updateTime(getActivity(), this.mBuilder);
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.mActiveDetails.size()) goto L9;
        this.mActiveDetails.get(r1).mActiveItem.updateTime(getActivity(), this.mBuilder);
        r1 = r1 + 1;
        goto L7
    }

    @Override // com.android.settings.applications.RunningState_.OnRefreshUiListener
    public void onRefreshUi(int r3) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (r3 != 0) goto L7;
        updateTimes();
        return;
    L7:
        if (r3 != 1) goto L9;
        refreshUi(false);
        updateTimes();
        return;
    L9:
        if (r3 != 2) goto L17;
        refreshUi(true);
        updateTimes();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_RunningServiceDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RunningServiceDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_RunningServiceDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_RunningServiceDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RunningServiceDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_RunningServiceDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_RunningServiceDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RunningServiceDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_RunningServiceDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
