package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.Application;
import android.app.Dialog;
import android.app.INotificationManager;
import android.app.NotificationChannel;
import android.app.admin.DevicePolicyManager;
import android.appwidget.AppWidgetManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoEx;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.usb.IUsbManager;
import android.icu.text.DateFormat;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.BatteryStatsManager;
import android.os.BatteryUsageStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Trace;
import android.os.UidBatteryConsumer;
import android.os.UserHandle;
import android.os.UserHandleSmtEx;
import android.os.UserManager;
import android.security.bytedance.guard.BDSettingsEvent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.IWebViewUpdateService;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.GlobalProxyLancet;
import com.android.internal.telephony.ISms;
import com.android.settings.AppDataUsageDetailFragment;
import com.android.settings.Constants;
import com.android.settings.DeviceAdminAdd;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.NotificationDetailsFragment;
import com.android.settings.NotificationSettingsFragment;
import com.android.settings.PermissionControllerHelp;
import com.android.settings.ProductFlavor;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.applications.feature.IAppAllService;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.autoaction.SecurityEventMonitor;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.fuelgauge.appBatteryUseOptimization.AppBatteryUseOptimizationControlFragment;
import com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse.BatteryPowerViewModel;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DataUsageStatHelper;
import com.android.settings.utils.DisplayUtils;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.applications.AppUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.android.vcard.VCardConfig;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.systemapp.SystemAppRecorder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog;

/* JADX INFO: loaded from: classes2.dex */
public class InstalledAppDetails extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ApplicationsState.Callbacks {
    public static final String ACTION_KEYGUARD_ON = "action_keyguard_on";
    public static final String ARG_APP_UID = "UID";
    public static final String ARG_PACKAGE_NAME = "package";
    private static final String BLACK_LIST = "com.intsig.BizCardReader.ActivityForBytedance";
    private static final int DLG_APP_NOT_FOUND = 3;
    private static final int DLG_BASE = 0;
    private static final int DLG_CANNOT_CLEAR_DATA = 4;
    private static final int DLG_CLEAR_DATA = 1;
    private static final int DLG_DISABLE = 7;
    private static final int DLG_DISABLE_NOTIFICATIONS = 8;
    private static final int DLG_FACTORY_RESET = 2;
    private static final int DLG_FORCE_STOP = 5;
    private static final int DLG_MOVE_FAILED = 6;
    private static final int DLG_SPECIAL_DISABLE = 9;
    private static final int DLG_UNINSTALL_DOUBAO_APP = 11;
    private static final int DLG_UNINSTALL_INSTANT_APP = 12;
    private static final int DLG_UNINSTALL_OBRIC_APP = 10;
    public static final String FROM_POWER_USAGE_SUMMARY = "from_power_usage_summary";
    private static final String NOTIFICATION_TUNER_SETTING = "show_importance_slider";
    private static final String NOT_ALLOW_FORCE_STOP_APP = "com.bytedanceos.securitycenter";
    public static final String POWER_TOTAL_USAGE = "power_total_usage";
    public static final String POWER_USAGE = "power_usage";
    public static final String POWER_USAGE_CYCLE = "power_usage_cycle";
    private static final String PUSH_APP_PACKAGE_NAME = "com.obric.matrix";
    private static final String PUSH_DEFAULT_CHANNEL = "_push_notify";
    private static final int REQUEST_REMOVE_DEVICE_ADMIN = 1;
    public static final int REQUEST_UNINSTALL = 1;
    private static final int SIZE_INVALID = -1;
    private static final String TAG = "InstalledAppDetails";
    private static final int TEXT_WIDTH = 910;
    public static final int UNINSTALL_ALL_USERS_MENU = 1;
    private static final boolean localLOGV = false;
    private final String FEEDBACK_APP;
    private final String FEEDBACK_ENTRY;
    Observer<Float> batteryPowerObserver;
    private BatteryPowerViewModel batteryPowerViewModel;
    private HibernationSwitchPreferenceController hibernationSwitchPreferenceController;
    private OCardListItem mActivitiesButton;
    private List<String> mAllowDisabledAppList;
    private boolean mAppControlRestricted;
    private ApplicationsState.AppEntry mAppEntry;
    private OCardListItem mAppStorageItemView;
    private TextView mAppVersion;
    private AppWidgetManager mAppWidgetManager;
    private RestrictedLockUtils.EnforcedAdmin mAppsControlDisallowedAdmin;
    private boolean mAppsControlDisallowedBySystem;
    private Bundle mArgsBundle;
    private OCardListItem mAskCompatibilityCB;
    private OCardListItem mBatteryManagerItemView;
    private BatteryStatsManager mBatteryStatsManager;
    BatteryUsageStats mBatteryUsageStats;
    private final BroadcastReceiver mCheckKillProcessesReceiver;
    private CharSequence mComputingStr;
    private Context mContext;
    private OCardListItem mDataUsageItemView;
    private DataUsageStatHelper mDataUsageStatHelper;
    private boolean mDisableAfterUninstall;
    private DevicePolicyManager mDpm;
    private OCardListItem mEnableCompatibilityCB;
    private View mForceStopButton;
    private Handler mHandler;
    private boolean mHaveSizes;
    private final HashSet<String> mHomePackages;
    private boolean mInitialized;
    private boolean mIsPackageInLocked;
    private BroadcastReceiver mKeyguardOnReceiver;
    private long mLastCacheSize;
    private long mLastCodeSize;
    private long mLastDataSize;
    private long mLastExternalCodeSize;
    private long mLastExternalDataSize;
    private long mLastTotalSize;
    private View mLaunchAppButton;
    private Intent mLauncherIntent;
    private List<String> mMenuDialogContent;
    private boolean mMoveInProgress;
    private OAlertDialog mNotificationDialog;
    private OCardListItem mNotificationItemView;
    private OCardListItem mNotificationSwitch;
    private PackageInfo mPackageInfo;
    private OCardListItem mPermManagerItemView;
    PackageDeleteObserver mPkgDeleteObserver;
    private PackageManager mPm;
    private BroadcastReceiver mReceiver;
    private View mScreenCompatSection;
    private ScrollView mScrollView;
    private ApplicationsState.Session mSession;
    private boolean mShowUninstalled;
    private ISms mSmsManager;
    private String[] mSocialAppList;
    private OButton mSpecialDisableButton;
    private ApplicationsState mState;
    UidBatteryConsumer mUidBatteryConsumer;
    private View mUninstallButton;
    private OTextView mUninstallButtonText;
    private boolean mUpdatedSysApp;
    private IUsbManager mUsbManager;
    private int mUserId;
    private UserManager mUserManager;
    private String pkgName;

    /* JADX INFO: renamed from: com.android.settings.applications.InstalledAppDetails$10, reason: invalid class name */
    class AnonymousClass10 implements View.OnClickListener {
        final /* synthetic */ InstalledAppDetails this$0;
        final /* synthetic */ OMenuDialog val$dialog;

        AnonymousClass10(InstalledAppDetails r1, OMenuDialog r2) {
            this.this$0 = r1;
            this.val$dialog = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.val$dialog.show();
        }
    }

    /* JADX INFO: renamed from: com.android.settings.applications.InstalledAppDetails$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        final /* synthetic */ InstalledAppDetails this$0;
        final /* synthetic */ String val$packageName;
        final /* synthetic */ OCardListItem val$spinner;

        AnonymousClass7(InstalledAppDetails r1, String r2, OCardListItem r3) {
            this.this$0 = r1;
            this.val$packageName = r2;
            this.val$spinner = r3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            InstalledAppDetails.access$1000(this.this$0).setPremiumSmsPermission(this.val$packageName, 1);     // Catch: RemoteException -> L4
            OCardListItemUtils.setTrailingText(this.val$spinner, (CharSequence) InstalledAppDetails.access$1100(this.this$0).get(0));     // Catch: RemoteException -> L4
            return;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.applications.InstalledAppDetails$8, reason: invalid class name */
    class AnonymousClass8 implements View.OnClickListener {
        final /* synthetic */ InstalledAppDetails this$0;
        final /* synthetic */ String val$packageName;
        final /* synthetic */ OCardListItem val$spinner;

        AnonymousClass8(InstalledAppDetails r1, String r2, OCardListItem r3) {
            this.this$0 = r1;
            this.val$packageName = r2;
            this.val$spinner = r3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            InstalledAppDetails.access$1000(this.this$0).setPremiumSmsPermission(this.val$packageName, 2);     // Catch: RemoteException -> L4
            OCardListItemUtils.setTrailingText(this.val$spinner, (CharSequence) InstalledAppDetails.access$1100(this.this$0).get(1));     // Catch: RemoteException -> L4
            return;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.applications.InstalledAppDetails$9, reason: invalid class name */
    class AnonymousClass9 implements View.OnClickListener {
        final /* synthetic */ InstalledAppDetails this$0;
        final /* synthetic */ String val$packageName;
        final /* synthetic */ OCardListItem val$spinner;

        AnonymousClass9(InstalledAppDetails r1, String r2, OCardListItem r3) {
            this.this$0 = r1;
            this.val$packageName = r2;
            this.val$spinner = r3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            InstalledAppDetails.access$1000(this.this$0).setPremiumSmsPermission(this.val$packageName, 3);     // Catch: RemoteException -> L4
            OCardListItemUtils.setTrailingText(this.val$spinner, (CharSequence) InstalledAppDetails.access$1100(this.this$0).get(2));     // Catch: RemoteException -> L4
            return;
        }
    }

    static class DisableChanger extends AsyncTask<Object, Object, Object> {
        final ApplicationInfo mInfo;
        final PackageManager mPm;
        final int mState;

        DisableChanger(PackageManager r1, ApplicationInfo r2, int r3) {
            this.mPm = r1;
            this.mInfo = r2;
            this.mState = r3;
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... r3) {
            this.mPm.setApplicationEnabledSetting(this.mInfo.packageName, this.mState, 0);
            return null;
        }
    }

    public static class MyAlertDialogFragment extends DialogFragment {
        private OAlertDialog mNotificationDlg;

        static /* synthetic */ void lambda$onCreateDialog$0(DialogInterface r0, int r1) {
        }

        static /* synthetic */ void lambda$onCreateDialog$1(DialogInterface r0, int r1) {
        }

        static /* synthetic */ void lambda$onCreateDialog$2(DialogInterface r0, int r1) {
        }

        static /* synthetic */ void lambda$onCreateDialog$3(DialogInterface r0, int r1) {
        }

        static /* synthetic */ void lambda$onCreateDialog$4(DialogInterface r0, int r1) {
        }

        public void com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public MyAlertDialogFragment() {
        }

        public static MyAlertDialogFragment newInstance(int r3, int r4) {
            MyAlertDialogFragment r0 = new MyAlertDialogFragment();
            Bundle r1 = new Bundle();
            r1.putInt("id", r3);
            r1.putInt("moveError", r4);
            r0.setArguments(r1);
            return r0;
        }

        InstalledAppDetails getOwner() {
            return (InstalledAppDetails) getParentFragment();
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r7) {
            int r8 = getArguments().getInt("id");
            int r0 = getArguments().getInt("moveError");
            switch(r8) {
                case 2: goto L25;
                case 3: goto L23;
                case 4: goto L5;
                case 5: goto L21;
                case 6: goto L19;
                case 7: goto L17;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L11;
                case 11: goto L9;
                case 12: goto L7;
                default: goto L5;
            };
        L14:
            OAlertDialog r9 = new OAlertDialogBuilder(requireActivity()).title(R.string.app_disable_notifications_dlg_title).horizontalButton(true).message(getActivity().getText(R.string.app_disable_notifications_dlg_text)).positiveButton(R.string.dlg_ok, new AnonymousClass6(this)).negativeButton(R.string.dlg_cancel, new AnonymousClass5(this)).build();
            this.mNotificationDlg = r9;
            return r9;
        L5:
            throw new IllegalArgumentException("unknown id " + r8);
        L7:
            return InstalledAppDetails.access$2300(getOwner(), (ApplicationInfo) getArguments().getParcelable("showInstantAppUninstallDialog.info"));
        L9:
            return InstalledAppDetails.access$2200(getOwner(), (ApplicationInfo) getArguments().getParcelable("handleUninstallDoubao.info"));
        L11:
            return InstalledAppDetails.access$2100(getOwner(), (ApplicationInfo) getArguments().getParcelable("handleObricApp.info"), getArguments().getBoolean("handleObricApp.updatedSysApp"));
        L13:
            return new OAlertDialogBuilder(requireActivity()).title(getActivity().getText(R.string.app_special_disable_dlg_title), false).horizontalButton(true).message(getActivity().getText(R.string.app_special_disable_dlg_text)).positiveButton(R.string.dlg_ok, new AnonymousClass7(this)).negativeButton(R.string.dlg_cancel, new InstalledAppDetails$MyAlertDialogFragment$$ExternalSyntheticLambda4()).build();
        L17:
            return new OAlertDialogBuilder(requireActivity()).title(InstalledAppDetails.access$400(getOwner()).label, false).horizontalButton(true).message(getActivity().getText(R.string.app_disable_warning_dlg_text)).positiveButton(R.string.disable_text, new AnonymousClass4(this)).negativeButton(R.string.dlg_cancel, new InstalledAppDetails$MyAlertDialogFragment$$ExternalSyntheticLambda3()).build();
        L19:
            return new OAlertDialogBuilder(getActivity()).title(R.string.move_app_failed_dlg_title).message(getActivity().getString(R.string.move_app_failed_dlg_text, new Object[]{InstalledAppDetails.access$1800(getOwner(), r0)})).neutralButton(R.string.dlg_ok, new InstalledAppDetails$MyAlertDialogFragment$$ExternalSyntheticLambda2()).build();
        L21:
            return new OAlertDialogBuilder(requireActivity()).title(R.string.force_stop_dlg_title).horizontalButton(true).message(getActivity().getText(R.string.force_stop_dlg_text)).positiveButton(R.string.dlg_ok, new AnonymousClass3(this)).negativeButton(R.string.dlg_cancel, new InstalledAppDetails$MyAlertDialogFragment$$ExternalSyntheticLambda1()).build();
        L23:
            return new OAlertDialogBuilder(getActivity()).title(R.string.app_not_found_dlg_title).message(getActivity().getText(R.string.app_not_found_dlg_title)).neutralButton(getActivity().getText(R.string.dlg_ok), new AnonymousClass2(this)).build();
        L25:
            return new OAlertDialogBuilder(getActivity()).title(InstalledAppDetails.access$400(getOwner()).label, false).horizontalButton(true).message(R.string.uninstall_updated_sys_app_message).positiveButton(R.string.app_factory_reset, new AnonymousClass1(this)).negativeButton(R.string.dlg_cancel, new InstalledAppDetails$MyAlertDialogFragment$$ExternalSyntheticLambda0()).build();
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r2) {
            super.onCancel(r2);
            if (r2 != this.mNotificationDlg) goto L6;
            OCardListItemUtils.setChecked(InstalledAppDetails.access$1300(getOwner()), true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MyAlertDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MyAlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MyAlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_applications_InstalledAppDetails$MyAlertDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    class PackageDeleteObserver extends IPackageDeleteObserver.Stub {
        final /* synthetic */ InstalledAppDetails this$0;

        PackageDeleteObserver(InstalledAppDetails r1) {
            this.this$0 = r1;
        }

        public void packageDeleted(String r2, int r3) {
            if (InstalledAppDetails.access$000(this.this$0) == null) goto L6;
            InstalledAppDetails.access$100(this.this$0).post(new AnonymousClass1(this));
        L6:
            if (Utils.isPackageInstalled(InstalledAppDetails.access$200(this.this$0), r2) == false) goto L9;
            ToastUtils.show(this.this$0.getActivity(), R.string.uninstall_updated_sys_app_done);
            return;
        }
    }

    private static class PermissionCountRefreshTask extends AsyncTask<Void, Void, Integer> {
        private final WeakReference<InstalledAppDetails> mFragmentRef;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Integer doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Integer r1) {
            onPostExecute2(r1);
        }

        PermissionCountRefreshTask(InstalledAppDetails r2) {
            this.mFragmentRef = new WeakReference(r2);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Integer doInBackground2(Void... r5) {
            InstalledAppDetails r4 = getFragment();
            if (r4 == null) goto L5;
            long r0 = System.currentTimeMillis();
            int r6 = InstalledAppDetails.access$800(r4.getActivity(), InstalledAppDetails.access$300(r4));
            OLog.d(InstalledAppDetails.TAG, "getPermissionCount cost " + (System.currentTimeMillis() - r0) + DateFormat.MINUTE_SECOND);
            return Integer.valueOf(r6);
        L5:
            return 0;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Integer r1) {
            InstalledAppDetails r0 = getFragment();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r1.intValue() <= 0) goto L9;
            OCardListItemUtils.setEnabled(InstalledAppDetails.access$900(r0), true);
            return;
        }

        private InstalledAppDetails getFragment() {
            WeakReference<InstalledAppDetails> r2 = this.mFragmentRef;
            if (r2 != null) goto L5;
            return null;
        L5:
            InstalledAppDetails r3 = r2.get();
            if (r3 != null) goto L8;
        L11:
            return null;
        L8:
            if (r3.isAdded() == false) goto L11;
            return r3;
        }
    }

    private static class PremiumSmsSelectionListener implements AdapterView.OnItemClickListener {
        private final String mPackageName;
        private final ISms mSmsManager;

        PremiumSmsSelectionListener(String r1, ISms r2) {
            this.mPackageName = r1;
            this.mSmsManager = r2;
        }

        private void setPremiumSmsPermission(String r1, int r2) {
            ISms r0 = this.mSmsManager;     // Catch: RemoteException -> L6
            if (r0 == null) goto L9;
            r0.setPremiumSmsPermission(r1, r2);     // Catch: RemoteException -> L6
            return;
        L9:
            return;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
            if (r3 >= 0) goto L5;
        L7:
            OLog.e(InstalledAppDetails.TAG, "Error: unknown premium SMS policy " + r3);
            return;
        L5:
            if (r3 >= 3) goto L7;
            OLog.d(InstalledAppDetails.TAG, "Selected premium SMS policy " + r3);
            setPremiumSmsPermission(this.mPackageName, r3 + 1);
        }
    }

    private double calculateBatteryPercent(double r3, double r5, int r7) {
        if (r5 != 0.0d) goto L6;
        return 0.0d;
    L6:
        return (r3 / r5) * ((double) r7);
    }

    private void refreshSecurityPermissionViews() {
    }

    public void com_android_settings_applications_InstalledAppDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_InstalledAppDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_InstalledAppDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    public InstalledAppDetails() {
        this.mMoveInProgress = false;
        this.mUpdatedSysApp = false;
        this.mAppControlRestricted = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPkgDeleteObserver = new PackageDeleteObserver(this);
        this.mHomePackages = new HashSet();
        this.mHaveSizes = false;
        this.mLastCodeSize = -1;
        this.mLastDataSize = -1;
        this.mLastExternalCodeSize = -1;
        this.mLastExternalDataSize = -1;
        this.mLastCacheSize = -1;
        this.mLastTotalSize = -1;
        this.mMenuDialogContent = new ArrayList();
        this.mAllowDisabledAppList = new ArrayList();
        this.mUserId = -10000;
        this.mAppsControlDisallowedBySystem = false;
        this.mAppsControlDisallowedAdmin = null;
        this.mReceiver = new AnonymousClass1(this);
        this.mKeyguardOnReceiver = new AnonymousClass2(this);
        this.mCheckKillProcessesReceiver = new AnonymousClass15(this);
        this.FEEDBACK_ENTRY = "com.obric.feedbackserviceproject";
        this.FEEDBACK_APP = Constants.PKG_BUG2GO;
        this.batteryPowerObserver = new AnonymousClass16(this);
    }

    static /* synthetic */ View access$000(InstalledAppDetails r0) {
        return r0.mUninstallButton;
    }

    static /* synthetic */ Handler access$100(InstalledAppDetails r0) {
        return r0.mHandler;
    }

    static /* synthetic */ ISms access$1000(InstalledAppDetails r0) {
        return r0.mSmsManager;
    }

    static /* synthetic */ List access$1100(InstalledAppDetails r0) {
        return r0.mMenuDialogContent;
    }

    static /* synthetic */ void access$1200(InstalledAppDetails r0, DataUsageStatHelper.AppDataUsageInfo r1) {
        r0.refreshDataUsageSummary(r1);
    }

    static /* synthetic */ OCardListItem access$1300(InstalledAppDetails r0) {
        return r0.mNotificationSwitch;
    }

    static /* synthetic */ void access$1400(InstalledAppDetails r0, boolean r1) {
        r0.setNotificationsEnabled(r1);
    }

    static /* synthetic */ void access$1500(InstalledAppDetails r0, String r1) {
        r0.uninstallPkgDirectly(r1);
    }

    static /* synthetic */ void access$1600(InstalledAppDetails r0, boolean r1, boolean r2) {
        r0.setIntentAndFinish(r1, r2);
    }

    static /* synthetic */ void access$1700(InstalledAppDetails r0, ApplicationInfo r1) {
        r0.forceStopPackage(r1);
    }

    static /* synthetic */ CharSequence access$1800(InstalledAppDetails r0, int r1) {
        return r0.getMoveErrMsg(r1);
    }

    static /* synthetic */ PackageManager access$1900(InstalledAppDetails r0) {
        return r0.mPm;
    }

    static /* synthetic */ Context access$200(InstalledAppDetails r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$2000(InstalledAppDetails r0, String r1, boolean r2, boolean r3) {
        r0.uninstallPkg(r1, r2, r3);
    }

    static /* synthetic */ Dialog access$2100(InstalledAppDetails r0, ApplicationInfo r1, boolean r2) {
        return r0.handleObricAppDialog(r1, r2);
    }

    static /* synthetic */ Dialog access$2200(InstalledAppDetails r0, ApplicationInfo r1) {
        return r0.handleUninstallDoubaoDialog(r1);
    }

    static /* synthetic */ Dialog access$2300(InstalledAppDetails r0, ApplicationInfo r1) {
        return r0.handleInstantAppUninstallDialog(r1);
    }

    static /* synthetic */ void access$2400(InstalledAppDetails r0, boolean r1) {
        r0.updateForceStopButton(r1);
    }

    static /* synthetic */ OCardListItem access$2500(InstalledAppDetails r0) {
        return r0.mBatteryManagerItemView;
    }

    static /* synthetic */ BatteryStatsManager access$2600(InstalledAppDetails r0) {
        return r0.mBatteryStatsManager;
    }

    static /* synthetic */ PackageInfo access$2700(InstalledAppDetails r0) {
        return r0.mPackageInfo;
    }

    static /* synthetic */ UidBatteryConsumer access$2800(InstalledAppDetails r0, BatteryUsageStats r1, int r2) {
        return r0.findTargetUidBatteryConsumer(r1, r2);
    }

    static /* synthetic */ double access$2900(InstalledAppDetails r0, double r1, double r3, int r5) {
        return r0.calculateBatteryPercent(r1, r3, r5);
    }

    static /* synthetic */ String access$300(InstalledAppDetails r0) {
        return r0.pkgName;
    }

    static /* synthetic */ ApplicationsState.AppEntry access$400(InstalledAppDetails r0) {
        return r0.mAppEntry;
    }

    static /* synthetic */ boolean access$500(InstalledAppDetails r0) {
        return r0.refreshUi();
    }

    static /* synthetic */ void access$600(InstalledAppDetails r0) {
        r0.startAllServicesActivity();
    }

    static /* synthetic */ HibernationSwitchPreferenceController access$700(InstalledAppDetails r0) {
        return r0.hibernationSwitchPreferenceController;
    }

    static /* synthetic */ int access$800(Context r0, String r1) {
        return getPermissionCount(r0, r1);
    }

    static /* synthetic */ OCardListItem access$900(InstalledAppDetails r0) {
        return r0.mPermManagerItemView;
    }

    private String getSizeStr(long r1) {
        return Utils.formatFileSize(getActivity(), r1);
    }

    private CharSequence getMoveErrMsg(int r2) {
        if (r2 != (-4)) goto L7;
        return getActivity().getString(R.string.app_forward_locked);
    L7:
        if (r2 == (-5)) goto L23;
        if (r2 == (-3)) goto L21;
        if (r2 == (-2)) goto L19;
        if (r2 == (-1)) goto L17;
        return "";
    L17:
        return getActivity().getString(R.string.insufficient_storage);
    L19:
        return getActivity().getString(R.string.does_not_exist);
    L21:
        return getActivity().getString(R.string.system_package);
    L23:
        return getActivity().getString(R.string.invalid_location);
    }

    private boolean handleDisableable(TextView r6) {
        if (this.mAllowDisabledAppList.contains(this.mAppEntry.info.packageName) == false) goto L5;
    L22:
        this.mPm.getPackageInfo(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME, 64);     // Catch: PackageManager.NameNotFoundException -> L19
        Intent r0 = new Intent("android.intent.action.MAIN");     // Catch: PackageManager.NameNotFoundException -> L19
        r0.addCategory("android.intent.category.HOME");     // Catch: PackageManager.NameNotFoundException -> L19
        r0.setPackage(this.mAppEntry.info.packageName);     // Catch: PackageManager.NameNotFoundException -> L19
        List<ResolveInfo> r1 = this.mPm.queryIntentActivities(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r1 == null) goto L12;
        if (r1.size() <= 0) goto L12;
    L13:
        r6.setText(R.string.disable_text);     // Catch: PackageManager.NameNotFoundException -> L19
        return false;
    L12:
        if (Utils.isSystemPackage(getResources(), this.mPm, this.mPackageInfo) == true) goto L13;
        if (this.mAppEntry.info.enabled == false) goto L17;
        r6.setText(R.string.disable_text);     // Catch: PackageManager.NameNotFoundException -> L19
    L24:
        return true;
    L17:
        r6.setText(R.string.enable_text);     // Catch: PackageManager.NameNotFoundException -> L19
    L19:
        e = move-exception;
        OLog.w(TAG, "Unable to get package info", e);
        return false;
    L5:
        if (ProductFlavor.isNeridaHk() == true) goto L22;
        return false;
    }

    private void initUninstallButtons() {
        boolean r1 = true;
        boolean r2 = false;
        if ((this.mAppEntry.info.flags & 128) == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mUpdatedSysApp = r0;
        OLog.d(TAG, "mUpdatedSysApp " + this.mUpdatedSysApp);
        boolean r3 = !Utils.canBundledUninstall(this.mAppEntry.info);
        this.mUninstallButton.setEnabled(true);
        int r5 = 8;
        if (this.mUpdatedSysApp == false) goto L24;
        this.mUninstallButtonText.setText(R.string.app_factory_reset);
        if (TextUtils.equals("com.bytedanceos.securitycenter", this.mAppEntry.info.packageName) == true) goto L11;
        this.mUninstallButton.setEnabled(true);
    L12:
        if (r3 == false) goto L14;
        boolean r4 = handleDisableable(this.mSpecialDisableButton);
        this.mSpecialDisableButton.setOnClickListener(this);
    L16:
        if (this.mAppControlRestricted == false) goto L18;
        r4 = false;
    L18:
        OButton r6 = this.mSpecialDisableButton;
        if (r4 == false) goto L21;
        r5 = 0;
    L21:
        r6.setVisibility(r5);
        if (r3 == true) goto L46;
        this.mUninstallButton.setEnabled(true);
        this.mUninstallButtonText.setText(R.string.uninstall_text);
    L46:
        boolean r7 = true;
    L47:
        if (r3 == false) goto L52;
        if (this.mDpm.packageHasActiveAdmins(this.mPackageInfo.packageName) == false) goto L52;
        r7 = false;
    L52:
        if (this.mDpm.isUninstallInQueue(this.mPackageInfo.packageName) == false) goto L54;
        r7 = false;
    L54:
        if (r7 == true) goto L56;
    L65:
        RestrictedLockUtils.EnforcedAdmin r8 = MultiSDKAdapterNew.checkIfUninstallBlocked(getActivity(), this.mAppEntry.info.packageName, UserHandle.myUserId());
        boolean r9 = this.mAppControlRestricted;
        if (r9 == true) goto L70;
        if (r8 != null) goto L70;
        boolean r10 = false;
    L71:
        if (r9 == true) goto L75;
        r1 = r7;
    L75:
        if (MultiSDKAdapterNew.isFallbackPackage(IWebViewUpdateService.Stub.asInterface(ServiceManager.getService("webviewupdate")), this.mAppEntry.info.packageName) == false) goto L78;
        r1 = false;
    L78:
        if (Constants.PKG_BUG2GO.equals(this.mAppEntry.info.packageName) == false) goto L81;
        r1 = Utils.isPackageInstalled(this.mContext, "com.obric.feedbackserviceproject");
    L81:
        if (isMinorApp() == true) goto L84;
        r2 = r1;
    L84:
        this.mUninstallButton.setEnabled(r2);
        View r11 = this.mUninstallButton;
        if (r2 == false) goto L89;
        if (r10 == true) goto L89;
        float r12 = 1.0f;
    L90:
        r11.setAlpha(r12);
        if (r2 == false) goto L94;
        this.mUninstallButton.setOnClickListener(this);
        return;
    L94:
        return;
    L89:
        r12 = 0.4f;
    L70:
        r10 = true;
        goto L71
    L56:
        if (this.mHomePackages.contains(this.mPackageInfo.packageName) == false) goto L65;
        if (r3 == false) goto L59;
    L58:
        r7 = false;
        goto L65
    L59:
        ComponentName r13 = this.mPm.getHomeActivities(new ArrayList());
        if (r13 == null) goto L62;
        r7 = !this.mPackageInfo.packageName.equals(r13.getPackageName());
        goto L65
    L62:
        if (this.mHomePackages.size() <= 1) goto L58;
        r7 = true;
        goto L65
    L14:
        r4 = false;
        goto L16
    L11:
        this.mUninstallButton.setEnabled(false);
        goto L12
    L24:
        this.mSpecialDisableButton.setVisibility(8);
        if (r3 == false) goto L40;
        r7 = handleDisableable(this.mSpecialDisableButton);
        this.mUninstallButton.setEnabled(r7);
        this.mSpecialDisableButton.setOnClickListener(this);
        if (this.mAppControlRestricted == false) goto L29;
        boolean r14 = false;
    L30:
        OButton r15 = this.mSpecialDisableButton;
        if (r14 == false) goto L33;
        r5 = 0;
    L33:
        r15.setVisibility(r5);
        if ((this.mAppEntry.info.flags & 1) == 0) goto L47;
        if (Utils.canBundledUninstall(this.mAppEntry.info) == true) goto L47;
        if (r14 == false) goto L47;
    L44:
        r7 = false;
        goto L47
    L29:
        r14 = r7;
        goto L30
    L40:
        if ((this.mPackageInfo.applicationInfo.flags & 8388608) == 0) goto L42;
    L45:
        this.mUninstallButtonText.setText(R.string.uninstall_text);
        goto L46
    L42:
        if (this.mUserManager.getUsers().size() < 2) goto L45;
        this.mUninstallButtonText.setText(R.string.uninstall_text);
        goto L44
    L5:
        r0 = false;
        goto L6
    }

    private void initNotificationButton() {
        boolean r1 = INotificationManager.Stub.asInterface(ServiceManager.getService("notification")).areNotificationsEnabledForPackage(this.mAppEntry.info.packageName, this.mAppEntry.info.uid);     // Catch: RemoteException -> L5
    L8:
        if (isSocialPackage(this.mAppEntry.info.packageName) == false) goto L16;
        this.mNotificationItemView.setVisibility(0);
        this.mNotificationSwitch.setVisibility(8);
        OCardListItemUtils.setEnabled(this.mNotificationItemView, true);
        OCardListItem r3 = this.mNotificationItemView;
        if (r1 == false) goto L12;
        int r6 = R.string.notification_enabled;
    L13:
        OCardListItemUtils.setTrailingText(r3, getString(r6));
        if ("com.android.contacts".equals(this.mAppEntry.info.packageName) == false) goto L23;
        this.mNotificationItemView.setVisibility(8);
    L23:
        boolean r4 = !NotificationSettingsFragment.isAllNotificationsDisabled(this.mContext);
        OLog.i(TAG, "isEnableAll :" + r4);
        NotificationHelper.AppRow r5 = new NotificationHelper.AppRow();
        NotificationHelper.getInstance().recordCanBeBlocked(this.mPackageInfo, r5);
        r5.banned = !r1;
        if (r5.systemApp == true) goto L26;
    L31:
        boolean r2 = true;
    L32:
        if (r2 == true) goto L34;
    L36:
        boolean r7 = false;
    L37:
        OLog.i(TAG, "systemApp :" + r5.systemApp + ", lockedImportance: " + r5.lockedImportance);
        boolean r8 = NotificationHelper.notificationPermissionFixed(this.mContext, this.mPackageInfo.packageName, this.mPackageInfo.applicationInfo.uid);
        OLog.i(TAG, "fixed: " + r8);
        if (r4 == false) goto L42;
        if (r7 == false) goto L42;
        if (r8 == true) goto L42;
        boolean r0 = true;
    L43:
        if (r0 == true) goto L46;
        OCardListItemUtils.setEnabled(this.mNotificationSwitch, false);
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationSwitch, null);
        return;
    L46:
        if (NotificationHelper.isRootOrSystemUid(this.mAppEntry.info.uid) == false) goto L48;
        OCardListItemUtils.setEnabled(this.mNotificationSwitch, false);
    L49:
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationSwitch, this);
        setNotificationSwitchTouchInterceptor();
        return;
    L48:
        OCardListItemUtils.setEnabled(this.mNotificationSwitch, true);
    L42:
        r0 = false;
        goto L43
    L34:
        if (r5.lockedImportance == true) goto L36;
        r7 = true;
        goto L37
    L26:
        if (r5.systemApp == true) goto L28;
    L30:
        r2 = false;
        goto L32
    L28:
        if (r5.banned == false) goto L30;
    L12:
        r6 = R.string.notification_disabled;
        goto L13
    L16:
        this.mNotificationItemView.setVisibility(8);
        this.mNotificationSwitch.setVisibility(0);
        OCardListItemUtils.setChecked(this.mNotificationSwitch, r1);
        if (Utils.isNotificationWhiteApp(this.mContext, this.mState, this.mAppEntry.info) == false) goto L19;
    L22:
        OCardListItemUtils.setEnabled(this.mNotificationSwitch, false);
        goto L23
    L19:
        if (NotificationSettingsFragment.isAllNotificationsDisabled(getActivity()) == true) goto L22;
        OCardListItemUtils.setEnabled(this.mNotificationSwitch, true);
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationSwitch, this);
        setNotificationSwitchTouchInterceptor();
    L5:
        e = move-exception;
        OLog.e(TAG, "initNotificationButton error:" + e);
        r1 = true;
        goto L8
    }

    private void setNotificationSwitchTouchInterceptor() {
        OCardListItem r0 = this.mNotificationSwitch;
        if (r0 != null) goto L5;
        return;
    L5:
        if (OCardListItemUtils.getSwitchView(r0) == null) goto L14;
        ApplicationsState.AppEntry r1 = this.mAppEntry;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.info == null) goto L16;
        OCardListItemUtils.getSwitchView(this.mNotificationSwitch).setOnTouchListener(new InstalledAppDetails$$ExternalSyntheticLambda4(this));
        return;
    L16:
        return;
    }

    /* JADX INFO: renamed from: lambda$setNotificationSwitchTouchInterceptor$0$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ boolean m295xe6f79dc3(View r3, MotionEvent r4) {
        return RiskPermissionControlGuard.interceptOnActionUp(getActivity(), this.mAppEntry.info.packageName, UserHandle.getUserId(this.mAppEntry.info.uid), 64, r4);
    }

    public void com_android_settings_applications_InstalledAppDetails__onCreate$___twin___(Bundle r12) {
        long r6 = System.currentTimeMillis();
        Trace.beginSection("InstalledAppDetails-onCreate");     // Catch: Throwable -> L11
        OLog.i(TAG, "onCreate");     // Catch: Throwable -> L11
        super.onCreate(r12);     // Catch: Throwable -> L11
        Trace.beginSection("InstalledAppDetails-onCreate-1");     // Catch: Throwable -> L11
        this.mContext = getContext();     // Catch: Throwable -> L11
        OLog.i(TAG, "before getActivity.getApplication");     // Catch: Throwable -> L11
        Application r13 = getActivity().getApplication();     // Catch: Throwable -> L11
        OLog.i(TAG, "before ApplicationsState.getInstance");     // Catch: Throwable -> L11
        this.mState = ApplicationsState.getInstance(r13, true);     // Catch: Throwable -> L11
        OLog.i(TAG, "before ApplicationsState.newSession");     // Catch: Throwable -> L11
        this.mSession = this.mState.newSession(this);     // Catch: Throwable -> L11
        OLog.i(TAG, "onCreate 1=" + (System.currentTimeMillis() - r6));     // Catch: Throwable -> L11
        Trace.endSection();     // Catch: Throwable -> L11
        this.mPm = getActivity().getPackageManager();     // Catch: Throwable -> L11
        this.mUserManager = (UserManager) getActivity().getSystemService(PickApplicationActivity.EXTRA_USER);     // Catch: Throwable -> L11
        this.mUsbManager = IUsbManager.Stub.asInterface(ServiceManager.getService("usb"));     // Catch: Throwable -> L11
        this.mAppWidgetManager = AppWidgetManager.getInstance(getActivity());     // Catch: Throwable -> L11
        this.mDpm = (DevicePolicyManager) getActivity().getSystemService("device_policy");     // Catch: Throwable -> L11
        this.mSmsManager = ISms.Stub.asInterface(ServiceManager.getService("isms"));     // Catch: Throwable -> L11
        this.mDataUsageStatHelper = DataUsageStatHelper.getInstance(this.mContext);     // Catch: Throwable -> L11
        OLog.i(TAG, "onCreate 2=" + (System.currentTimeMillis() - r6));     // Catch: Throwable -> L11
        this.mSession.resume(true);     // Catch: Throwable -> L11
        OLog.i(TAG, "onCreate 3=" + (System.currentTimeMillis() - r6));     // Catch: Throwable -> L11
        this.mArgsBundle = getArguments();     // Catch: Throwable -> L11
        this.pkgName = retrieveAppEntry();     // Catch: Throwable -> L11
        OLog.i(TAG, "onCreate 4=" + (System.currentTimeMillis() - r6));     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(this.pkgName) == false) goto L8;
        finish();     // Catch: Throwable -> L11
        OLog.i(TAG, "onCreate finally=" + (System.currentTimeMillis() - r6));
        Trace.endSection();
        return;
    L8:
        this.mAllowDisabledAppList = Arrays.asList(getResources().getStringArray(R.array.allow_disable_app_list));     // Catch: Throwable -> L11
        this.mSocialAppList = getResources().getStringArray(android.R.array.config_autoBrightnessLcdBacklightValues);     // Catch: Throwable -> L11
        setHasOptionsMenu(true);     // Catch: Throwable -> L11
        this.mBatteryStatsManager = (BatteryStatsManager) this.mContext.getSystemService("batterystats");     // Catch: Throwable -> L11
        OLog.i(TAG, "onCreate finally=" + (System.currentTimeMillis() - r6));
        Trace.endSection();
        return;
    L11:
        th = move-exception;
        OLog.i(TAG, "onCreate finally=" + (System.currentTimeMillis() - r6));
        Trace.endSection();
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        long r0 = System.currentTimeMillis();
        Trace.beginSection("InstalledAppDetails-onCreateView");
        boolean r2 = false;
        View r11 = r8.inflate(R.layout.installed_app_details, r9, false);
        ((FrameLayout) r11.findViewById(R.id.frame_layout)).addView(UIUtils.buildNoScaledView(this._mActivity, R.layout.view_app_info_button));
        this.mRootView = r11;
        ViewGroup r12 = (ViewGroup) NullSafe.nonNull(r11.findViewById(R.id.page_container));
        this.mComputingStr = getActivity().getText(R.string.computing_size);
        this.mForceStopButton = NullSafe.nonNull(r11.findViewById(R.id.force_stop_app));
        View r13 = NullSafe.nonNull(r11.findViewById(R.id.launch_app));
        this.mLaunchAppButton = r13;
        r13.setOnClickListener(this);
        this.mForceStopButton.setEnabled(false);
        this.mForceStopButton.setOnClickListener(null);
        View r14 = NullSafe.nonNull(r11.findViewById(R.id.uninstall_app));
        this.mUninstallButton = r14;
        r14.setOnClickListener(this);
        this.mUninstallButtonText = (OTextView) NullSafe.nonNull(r11.findViewById(R.id.uninstall_app_text));
        setupControlPanelView();
        OButton r15 = (OButton) NullSafe.nonNull(r11.findViewById(R.id.special_disable_button));
        this.mSpecialDisableButton = r15;
        r15.setVisibility(8);
        OCardListItem r16 = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.clear_activities_button));
        this.mActivitiesButton = r16;
        View r17 = r16.getCustomStartView();
        if (r17 == null) goto L7;
        ViewGroup.LayoutParams r4 = r17.getLayoutParams();
        r4.height = UIUtils.INSTANCE.dp2px(48);
        r17.setLayoutParams(r4);
        TextView r18 = (TextView) r17.findViewById(R.id.settings_text);
        if (r18 == null) goto L7;
        r18.setText(getString(R.string.clear_activities));
        r18.setTextColor(getActivity().getColor(R.color.oui_functional_red_6));
    L7:
        this.mScreenCompatSection = NullSafe.nonNull(r11.findViewById(R.id.screen_compatibility_section));
        this.mAskCompatibilityCB = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.ask_compatibility_cb));
        this.mEnableCompatibilityCB = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.enable_compatibility_cb));
        this.mNotificationSwitch = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.notification_switch));
        OCardListItem r19 = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.id_notification_item));
        this.mNotificationItemView = r19;
        r19.setOnContentClickListener(this);
        OCardListItem r110 = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.id_storage_item));
        this.mAppStorageItemView = r110;
        r110.setOnContentClickListener(this);
        OCardListItem r111 = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.id_data_usage_item));
        this.mDataUsageItemView = r111;
        r111.setOnContentClickListener(this);
        OCardListItem r112 = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.id_perm_manager));
        this.mPermManagerItemView = r112;
        OCardListItemUtils.setEnabled(r112, true);
        this.mPermManagerItemView.setOnContentClickListener(this);
        OCardListItem r113 = (OCardListItem) NullSafe.nonNull(r11.findViewById(R.id.id_battery_manager));
        this.mBatteryManagerItemView = r113;
        r113.setOnContentClickListener(this);
        this.mScrollView = (ScrollView) NullSafe.nonNull(r11.findViewById(R.id.page_scrollview));
        if (this.mIsExtDisplaying == false) goto L11;
        this.mScrollView.setVerticalScrollBarEnabled(false);
    L11:
        if (Utils.isSystemPackage(getActivity(), this.pkgName) == false) goto L16;
        if (Utils.isOpenSystemApp(this.pkgName) == true) goto L16;
        this.mPermManagerItemView.setVisibility(8);
    L16:
        if (Utils.isSystemPackageOrSystemProcess(getActivity(), this.pkgName) == false) goto L21;
        if (Utils.isBatteryManagerWhitelistApp(this.pkgName) == true) goto L21;
        this.mBatteryManagerItemView.setVisibility(8);
    L21:
        if (this.mAppEntry != null) goto L23;
    L25:
        this.mIsPackageInLocked = r2;
        if (r2 == false) goto L28;
        registerKeyguardReceiver();
    L28:
        ViewGroup r20 = (ViewGroup) r11.findViewById(R.id.page_container);
        initAllServiceItem();
        setupViewContainer();
        PackageInfo r21 = this.mPackageInfo;
        if (r21 == null) goto L31;
        Utils.setAppLabelAndIconViews(r11, r21);
    L31:
        initCtsTestItem();
        OLog.i(TAG, "onCreateView finally=" + (System.currentTimeMillis() - r0));
        Trace.endSection();
        return r11;
    L23:
        if (Utils.isPackageInLockedBlock(this.mContext.getPackageManager(), this.mAppEntry.info.packageName) == false) goto L25;
        r2 = true;
        goto L25
    }

    private void initAllServiceItem() {
        ViewGroup r0 = (ViewGroup) findViewByIdNullable(R.id.item_container);
        IAppAllService r1 = (IAppAllService) com.bytedance.news.common.service.manager.ServiceManager.getService(IAppAllService.class);
        if (r1 == null) goto L6;
        r0.addView(r1.create(this._mActivity, this.pkgName));
        return;
    }

    private void initCtsTestItem() {
        OLog.i(TAG, "initCtsTestItem");
        ((TextView) findViewByIdNullable(R.id.cts_all_services_item)).setOnClickListener(new AnonymousClass3(this));
        ((TextView) findViewByIdNullable(R.id.cts_services_summary_item)).setOnClickListener(new AnonymousClass4(this));
        if (XTSUtils.isInXtsMode() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        final OCardListItem r2 = (OCardListItem) findViewByIdNullable(R.id.unused_apps_switch);
        if (r0 == false) goto L11;
        r2.setVisibility(0);
        OSwitch r1 = r2.getEndSwitch();
        HibernationSwitchPreferenceController r3 = new HibernationSwitchPreferenceController(this.mContext);
        this.hibernationSwitchPreferenceController = r3;
        r3.setPackage(this.pkgName);
        this.hibernationSwitchPreferenceController.updateState(r1, r2);
        r1.setOnCheckedChangeListener(new AnonymousClass5(this));
        r2.setOnContentClickListener(new AnonymousClass6(this, r2));
        return;
    L11:
        r2.setVisibility(8);
        return;
    L5:
        if (XTSUtils.isCTSWithPackage(this.pkgName) == false) goto L7;
        r0 = true;
        goto L8
    }

    private void updateCtsTestItemVisibility() {
        int r0 = 0;
        if (getResolveInfo(0) != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        TextView r3 = (TextView) findViewByIdNullable(R.id.cts_all_services_item);
        if (r1 == true) goto L12;
        r0 = 8;
    L12:
        r3.setVisibility(r0);
        return;
    L5:
        if (isLocationProvider() == false) goto L7;
        r1 = true;
        goto L8
    }

    private boolean isLocationProvider() {
        Context r0 = this.mContext;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.pkgName != null) goto L8;
        return false;
    L8:
        return ((LocationManager) r0.getSystemService(LocationManager.class)).isProviderPackage(this.pkgName);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Trace.beginSection("InstalledAppDetails-onViewCreated");
        long r0 = System.currentTimeMillis();
        super.onViewCreated(r3, r4);
        OFloatingTitleBar r2 = this.mTitleView;
        if (r2 == null) goto L5;
        r2.setFitsSystemWindows(true);
        r2.requestApplyInsets();
    L5:
        OLog.i(TAG, "onViewCreated=" + (System.currentTimeMillis() - r0));
        Trace.endSection();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void registerKeyguardReceiver() {
        IntentFilter r0 = new IntentFilter(ACTION_KEYGUARD_ON);
        registerReceiver(this.mKeyguardOnReceiver, r0);
    }

    private void setupControlPanelView() {
        this.mLauncherIntent = null;
        PackageInfo r1 = this.mPackageInfo;
        if (r1 == null) goto L11;
        Intent r2 = this.mPm.getLaunchIntentForPackage(r1.packageName);
        this.mLauncherIntent = r2;
        if (r2 == null) goto L11;
        r2.setPackage(null);
        ComponentName r0 = this.mLauncherIntent.getComponent();
        if (r0 == null) goto L11;
        if (BLACK_LIST.equals(r0.getClassName()) == false) goto L11;
        boolean r3 = true;
    L13:
        if (this.mLauncherIntent == null) goto L16;
        if (r3 == true) goto L16;
        this.mLaunchAppButton.setEnabled(true);
        return;
    L16:
        this.mLaunchAppButton.setEnabled(false);
        return;
    L11:
        r3 = false;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        if (r4 == 1) goto L5;
        if (r4 == 1) goto L22;
        return;
    L22:
        if (refreshUi() == true) goto L31;
        setIntentAndFinish(true, true);
        return;
    L31:
        return;
    L5:
        if (this.mDisableAfterUninstall == false) goto L16;
        this.mDisableAfterUninstall = false;
        FragmentActivity r7 = getActivity();     // Catch: PackageManager.NameNotFoundException -> L25
        if (r7 == null) goto L16;
        PackageManager r8 = r7.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L25
        if (r8 == null) goto L16;
        ApplicationInfo r9 = r8.getApplicationInfo(this.mAppEntry.info.packageName, 8704);     // Catch: PackageManager.NameNotFoundException -> L25
        if (r9 == null) goto L16;
        if ((r9.flags & 128) != 0) goto L16;
        new DisableChanger(this.mPm, this.mAppEntry.info, 3).execute(new Object[]{null});     // Catch: PackageManager.NameNotFoundException -> L25
    L16:
        int r10 = BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType();
        if (refreshUi() == true) goto L19;
        setIntentAndFinish(true, true);
        SecurityEventMonitor.INSTANCE.finish(requireActivity(), r10);
        return;
    L19:
        SecurityEventMonitor.INSTANCE.cancel(requireActivity(), r10);
    }

    public void updateArgs(Bundle r2) {
        if (isAdded() == true) goto L6;
        finish();
        return;
    L6:
        this.mArgsBundle = r2;
        reloadAppEntryIfIsOnNewIntent(r2);
    }

    private void reloadAppEntryIfIsOnNewIntent(Bundle r2) {
        String r3 = getAppPackageName(r2);
        String r0 = this.pkgName;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        retrieveAppEntry();
        this.pkgName = r3;
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationSwitch, null);
        return;
    L11:
        return;
    L5:
        if (r0.equals(r3) == true) goto L7;
        r1 = true;
        goto L8
    }

    public void updateViews() {
        long r0 = System.currentTimeMillis();
        reloadAppEntryIfIsOnNewIntent(this.mArgsBundle);
        OLog.d(TAG, "pkgName " + this.pkgName);
        this.mAppControlRestricted = this.mUserManager.hasUserRestriction("no_control_apps");
        updateAppsControlDisallowedAdminInfo();
        this.mSession.resume(true);
        ApplicationsState.AppEntry r2 = this.mAppEntry;
        if (r2 == null) goto L5;
        this.mState.requestSizeByUserId(r2.info);
    L7:
        if (refreshUi() == true) goto L10;
        setIntentAndFinish(true, true);
    L10:
        if (isAdded() == false) goto L12;
        IntentFilter r3 = new IntentFilter("android.intent.action.PACKAGE_CHANGED");
        r3.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, r3, 2);
    L12:
        updateCtsTestItemVisibility();
        OLog.i(TAG, "updateViews=" + (System.currentTimeMillis() - r0));
        return;
    L5:
        OLog.d(TAG, "app entry is null.");
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateAppsControlDisallowedAdminInfo() {
        if (isWorkProfile() == false) goto L5;
        this.mUserId = UserHandle.getUserId(getAppPackageUid());
    L6:
        this.mAppsControlDisallowedBySystem = RestrictedLockUtilsInternal.hasBaseUserRestriction(this.mContext, "no_control_apps", this.mUserId);
        this.mAppsControlDisallowedAdmin = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_control_apps", this.mUserId);
        return;
    L5:
        this.mUserId = UserHandle.myUserId();
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSession.pause();
        unregisterReceiver(this.mReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mSession.release();
        BatteryPowerViewModel r0 = this.batteryPowerViewModel;
        if (r0 == null) goto L6;
        r0.getPercent().removeObserver(this.batteryPowerObserver);
    L6:
        if (this.mIsPackageInLocked == false) goto L9;
        unregisterReceiver(this.mKeyguardOnReceiver);
        return;
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
        if (refreshUi() == true) goto L6;
        setIntentAndFinish(true, true);
        return;
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r1) {
        OLog.i(TAG, "onRebuildComplete");
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r2) {
        if (r2 == null) goto L12;
        ApplicationsState.AppEntry r0 = this.mAppEntry;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.info != null) goto L9;
        return;
    L9:
        if (r2.equals(this.mAppEntry.info.packageName) == false) goto L14;
        refreshSizeInfo();
        return;
    L14:
        return;
    }

    private String getAppPackageName(Bundle r3) {
        String r0 = null;
        if (r3 != null) goto L26;
    L5:
        if (r0 != null) goto L15;
        if (r3 == null) goto L8;
    L10:
        Intent r4 = (Intent) r3.getParcelable("intent");
    L11:
        if (r4 == null) goto L15;
        if (r4.getData() == null) goto L15;
        r0 = r4.getData().getSchemeSpecificPart();
        goto L15
    L8:
        if (getActivity() == null) goto L10;
        r4 = getActivity().getIntent();
    L15:
        if (r0 != null) goto L22;
        if (getActivity() == null) goto L22;
        if (getActivity().getIntent().getData() == null) goto L22;
        r0 = getActivity().getIntent().getData().getSchemeSpecificPart();
    L22:
        if ("com.obric.feedbackserviceproject".equals(r0) == false) goto L28;
        return Constants.PKG_BUG2GO;
    L28:
        return r0;
    L26:
        r0 = r3.getString("package");     // Catch: Exception -> L25
        goto L5
    }

    private int getOriginatingUid() {
        return ActivityManagerNative.getDefault().getLaunchedFromUid(getActivity().getActivityToken());
    L4:
        return -1;
    }

    private int getAppPackageUid() {
        Bundle r2 = getArguments();
        if (r2 == null) goto L10;
        return r2.getInt(ARG_APP_UID, -1);
    L11:
        return -1;
    L10:
        return -1;
    }

    private int getAppPackageUerId() {
        Bundle r2 = getArguments();
        int r0 = UserHandle.getCallingUserId();
        if (r2 == null) goto L10;
        return r2.getInt(AccountInfoBundleKey.USER_ID, r0);
    L11:
        return r0;
    L10:
        return r0;
    }

    private String retrieveAppEntry() {
        Trace.beginSection("InstalledAppDetails-retrieveAppEntry");
        OLog.i(TAG, "retrieveAppEntry");
        String r0 = getAppPackageName(this.mArgsBundle);
        OLog.i(TAG, "retrieveAppEntry after getAppPackageName");
        int r2 = getAppPackageUid();
        OLog.i(TAG, "retrieveAppEntry after getAppPackageUid");
        if (r2 != (-1)) goto L5;
        r2 = getOriginatingUid();
    L5:
        OLog.i(TAG, "retrieveAppEntry after getOriginatingUid");
        if (r2 == (-1)) goto L8;
        int r3 = UserHandle.getUserId(r2);
    L9:
        OLog.i(TAG, "retrieveAppEntry after getUserId/getAppPackageUerId uid=" + r2);
        if (r0 != null) goto L18;
        OLog.w(TAG, "Missing AppEntry; maybe reinstalling?");
        this.mPackageInfo = null;
        finish();
    L16:
        OLog.i(TAG, "retrieveAppEntry end");
        Trace.endSection();
        return r0;
    L18:
        PackageManager r4 = getActivity().getPackageManager();     // Catch: Exception -> L13
        OLog.i(TAG, "retrieveAppEntry after getPackageManager");     // Catch: Exception -> L13
        this.mPackageInfo = r4.getPackageInfoAsUser(r0, 12864, r3);     // Catch: Exception -> L13
        OLog.i(TAG, "retrieveAppEntry after getPackageInfoAsUser");     // Catch: Exception -> L13
        this.mAppEntry = this.mState.getEntryWithoutPinyin(this.mContext, this.mPackageInfo.applicationInfo);     // Catch: Exception -> L13
        OLog.i(TAG, "retrieveAppEntry after getEntryWithoutPinyin");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        OLog.e(TAG, "Exception when retrieving package:" + r0, e);
        goto L16
    L8:
        r3 = getAppPackageUerId();
        goto L9
    }

    private boolean refreshUi() {
        boolean r2 = false;
        if (isAdded() == true) goto L5;
        return false;
    L5:
        String r1 = retrieveAppEntry();
        if (this.mAppEntry != null) goto L9;
        return false;
    L9:
        if (this.mPackageInfo != null) goto L11;
        return false;
    L11:
        if (r1 != null) goto L13;
        return false;
    L13:
        ArrayList r3 = new ArrayList();
        this.mPm.getPreferredActivities(new ArrayList(), r3, r1);
        boolean r4 = this.mUsbManager.hasDefaults(r1, UserHandle.getUserId(this.mAppEntry.info.uid));     // Catch: RemoteException -> L16
    L77:
        boolean r5 = this.mAppWidgetManager.hasBindAppWidgetPermission(this.mAppEntry.info.packageName, UserHandle.getUserId(this.mAppEntry.info.uid));     // Catch: IllegalStateException -> L20
    L22:
        OSectionSupportiveText r6 = (OSectionSupportiveText) NullSafe.nonNull(this.mRootView.findViewById(R.id.auto_launch));
        if (r3.size() > 0) goto L27;
        if (r4 == true) goto L27;
        boolean r7 = false;
    L28:
        if (r7 == true) goto L31;
        if (r5 == true) goto L31;
        resetLaunchDefaultsUi(r6);
    L54:
        ((ActivityManager) getActivity().getSystemService("activity")).getPackageScreenCompatMode(r1);
        this.mScreenCompatSection.setVisibility(8);
        refreshSecurityPermissionViews();
        checkForceStop();
        Utils.setAppLabelAndIconViews(getView(), this.mPackageInfo.packageName, this.mPackageInfo.applicationInfo.uid);
        refreshButtons();
        this.mState.refreshSizeInfo(this._mActivity, this.mPackageInfo.applicationInfo, this.mAppEntry);
        refreshSizeInfo();
        refreshDataUsageAsync();
        refreshPowerUsage(r1);
        refreshPermissionCount();
        setupControlPanelView();
        setupViewContainer();
        if (this.mInitialized == true) goto L73;
        this.mInitialized = true;
        if ((this.mAppEntry.info.flags & 8388608) != 0) goto L59;
        r2 = true;
    L59:
        this.mShowUninstalled = r2;
    L69:
        return true;
    L73:
        ApplicationInfo r8 = getActivity().getPackageManager().getApplicationInfoAsUser(this.mAppEntry.info.packageName, 8704, UserHandle.getUserId(this.mAppEntry.info.uid));     // Catch: PackageManager.NameNotFoundException -> L70
        if (this.mShowUninstalled == true) goto L69;
        if (r8 != null) goto L64;
        return false;
    L64:
        if ((8388608 & r8.flags) == 0) goto L80;
        if (r8.uid == this.mAppEntry.info.uid) goto L68;
        return false;
    L68:
        return true;
    L80:
        return false;
    L70:
        e = move-exception;
        OLog.e(TAG, "NameNotFoundException: " + e);
        return false;
    L31:
        if (r5 == false) goto L34;
        if (r7 == false) goto L34;
        boolean r9 = true;
    L35:
        int r10 = getResources().getDimensionPixelSize(R.dimen.installed_app_details_bullet_offset);
        if (r7 == false) goto L40;
        CharSequence r11 = getText(R.string.auto_launch_enable_text);
        SpannableString r12 = new SpannableString(r11);
        CharSequence r13 = r12;
        if (r9 == false) goto L41;
        r12.setSpan(new BulletSpan(r10), 0, r11.length(), 0);
        r13 = r12;
    L41:
        if (r5 == false) goto L48;
        CharSequence r14 = getText(R.string.always_allow_bind_appwidgets_text);
        SpannableString r15 = new SpannableString(r14);
        if (r9 == false) goto L45;
        r15.setSpan(new BulletSpan(r10), 0, r14.length(), 0);
    L45:
        if (r13 != null) goto L47;
        r13 = r15;
        goto L48
    L47:
        r13 = TextUtils.concat(new CharSequence[]{r13, "\n", r15});
    L48:
        if (r6 == null) goto L53;
        if (r13 != null) goto L51;
        String r16 = "";
    L52:
        r6.setSectionDes(r16);
        goto L53
    L51:
        r16 = r13.toString();
    L53:
        this.mActivitiesButton.setOnContentClickListener(new InstalledAppDetails$$ExternalSyntheticLambda7(this));
        goto L54
    L40:
        r13 = null;
    L34:
        r9 = false;
    L27:
        r7 = true;
    L20:
        e = move-exception;
        e.printStackTrace();
        r5 = false;
    L16:
        e = move-exception;
        OLog.e(TAG, "mUsbManager.hasDefaults", e);
        r4 = false;
        goto L77
    }

    /* JADX INFO: renamed from: lambda$refreshUi$1$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ void m294x6df4b8cc(View r1) {
        onClick(this.mActivitiesButton);
    }

    private void refreshPermissionCount() {
        if (this.mPermManagerItemView != null) goto L5;
        return;
    L5:
        new PermissionCountRefreshTask(this).execute(new Void[0]);
    }

    private void resetLaunchDefaultsUi(OSectionSupportiveText r2) {
        r2.setSectionDes(getString(R.string.auto_launch_disable_text));
        OCardListItemUtils.setEnabled(this.mActivitiesButton, false);
    }

    private void setIntentAndFinish(boolean r2, boolean r3) {
        new Intent().putExtra("chg", r3);
        finish();
    }

    private void refreshSizeInfo() {
        if (this.mAppStorageItemView != null) goto L7;
        OLog.e(TAG, "refreshSizeInfo: mAppStorageItemView is null");
        return;
    L7:
        if (this.mAppEntry.size != (-2)) goto L9;
    L14:
        this.mLastTotalSize = -1;
        this.mLastCacheSize = -1;
        this.mLastDataSize = -1;
        this.mLastCodeSize = -1;
        if (this.mHaveSizes == true) goto L20;
        OCardListItemUtils.setTrailingText(this.mAppStorageItemView, this.mComputingStr.toString());
        return;
    L20:
        return;
    L9:
        if (this.mAppEntry.size == (-1)) goto L14;
        this.mHaveSizes = true;
        if (this.mLastTotalSize == this.mAppEntry.size) goto L18;
        this.mLastTotalSize = this.mAppEntry.size;
        OCardListItemUtils.setTrailingText(this.mAppStorageItemView, getString(R.string.already_used_size, new Object[]{getSizeStr(this.mAppEntry.size)}));
        return;
    }

    private void refreshDataUsageAsync() {
        if (this.mAppEntry.info.uid != 1000) goto L6;
        this.mDataUsageItemView.setVisibility(8);
        return;
    L6:
        this.mDataUsageStatHelper.forceUpdateAsync(this.mAppEntry.info.uid, new AnonymousClass11(this));
    }

    private void setupViewContainer() {
        OCardListItemUtils.updateGroupContainer((ViewGroup) findViewByIdNullable(R.id.item_container));
    }

    private void refreshDataUsageSummary(DataUsageStatHelper.AppDataUsageInfo r6) {
        if (this.mAppEntry != null) goto L5;
        return;
    L5:
        String r0 = Formatter.formatFileSize(this.mContext, r6.todayTotal, 8).replace('k', 'K');
        if (r6.todayTotal <= 0) goto L8;
        String r7 = getString(R.string.today_total_data_usage_summary, new Object[]{r0});
    L9:
        OCardListItemUtils.setTrailingText(this.mDataUsageItemView, r7);
        return;
    L8:
        r7 = getString(R.string.today_no_data_usage_summary);
        goto L9
    }

    private void refreshButtons() {
        if (this.mMoveInProgress == true) goto L5;
        initUninstallButtons();
        initNotificationButton();
        return;
    L5:
        this.mUninstallButton.setEnabled(false);
        this.mSpecialDisableButton.setEnabled(false);
    }

    private void showNotificationWarningDialog() {
        if (this.mNotificationDialog != null) goto L6;
        this.mNotificationDialog = (OAlertDialog) new OAlertDialogBuilder(getActivity()).horizontalButton().title(R.string.app_disable_notifications_dlg_title).message(getActivity().getText(R.string.app_disable_notifications_dlg_text)).positiveButton(R.string.dlg_ok, new AnonymousClass14(this)).negativeButton(R.string.dlg_cancel, new AnonymousClass13(this)).onCancel(new AnonymousClass12(this)).build();
    L6:
        if (this.mNotificationDialog.isShowing() == true) goto L9;
        this.mNotificationDialog.show();
        return;
    }

    private void showDialogInner(int r2, int r3) {
        showDialogInner(r2, r3, new Bundle());
    }

    private void showDialogInner(int r2, int r3, Bundle r4) {
        if (getActivity() != null) goto L5;
    L17:
        OLog.d(TAG, "Illegal state : The parent activity has been destroyed!");
        return;
    L5:
        if (getActivity().isResumed() == false) goto L17;
        if (r2 != 8) goto L11;
        showNotificationWarningDialog();
        return;
    L11:
        MyAlertDialogFragment r5 = MyAlertDialogFragment.newInstance(r2, r3);
        if (r5.getArguments() == null) goto L14;
        r5.getArguments().putAll(r4);
    L15:
        r5.show(getChildFragmentManager(), "dialog " + r2);
        return;
    L14:
        r5.setArguments(r4);
        goto L15
    }

    private void uninstallPkg(String r3, boolean r4, boolean r5) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if ("com.larus.nova".equals(r3) == false) goto L7;
        handleUninstallDoubao(this.mAppEntry.info);     // Catch: ActivityNotFoundException -> L9
        return;
    L7:
        Intent r0 = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + r3));     // Catch: ActivityNotFoundException -> L9
        r0.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", r4);     // Catch: ActivityNotFoundException -> L9
        r0.putExtra("isFromSecurityCenter", this.mFromSecurityCenter);     // Catch: ActivityNotFoundException -> L9
        r0.addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);     // Catch: ActivityNotFoundException -> L9
        startActivityForResult(r0, 1);     // Catch: ActivityNotFoundException -> L9
        this.mDisableAfterUninstall = r5;     // Catch: ActivityNotFoundException -> L9
    }

    private void uninstallPkgByUid(String r3, boolean r4, boolean r5, int r6) {
        if ("com.larus.nova".equals(r3) == false) goto L6;
        handleUninstallDoubao(this.mAppEntry.info);
        return;
    L6:
        Intent r0 = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + r3));
        r0.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", r4);
        r0.putExtra("android.intent.extra.USER", UserHandle.getUserId(r6));
        r0.putExtra("isFromSecurityCenter", this.mFromSecurityCenter);
        r0.addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);
        startActivityForResult(r0, 1);
        this.mDisableAfterUninstall = r5;
    }

    private void uninstallDoppelgangerPkg(String r3, boolean r4) {
        if ("com.larus.nova".equals(r3) == false) goto L6;
        handleUninstallDoubao(this.mAppEntry.info);
        return;
    L6:
        Intent r0 = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + r3));
        r0.putExtra("android.intent.extra.USER", new UserHandle(10));
        r0.putExtra("isFromSecurityCenter", this.mFromSecurityCenter);
        r0.addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);
        startActivityForResult(r0, 1);
        this.mDisableAfterUninstall = r4;
    }

    private void uninstallPkgDirectly(String r4) {
        if ((this.mAppEntry.info.flags & 1) != 0) goto L5;
    L7:
        this.mPm.deletePackageAsUser(r4, this.mPkgDeleteObserver, 0, this.mUserId);
        return;
    L5:
        if ((this.mAppEntry.info.flags & 128) != 0) goto L7;
        this.mPm.deletePackage(r4, this.mPkgDeleteObserver, 4);
    }

    private void clearInstantApp(String r4) {
        this.mPm.deletePackageAsUser(r4, this.mPkgDeleteObserver, 0, this.mUserId);
    }

    private void forceStopPackage(ApplicationInfo r4) {
        OLog.i(TAG, "forceStopPackage: " + this.pkgName);
        ((ActivityManager) getActivity().getSystemService("activity")).forceStopPackageAsUser(this.pkgName, UserHandle.getUserId(r4.uid));
        this.mState.invalidatePackageByUid(this.pkgName, UserHandle.getUserId(r4.uid));
        ApplicationsState.AppEntry r5 = this.mState.getEntryByUserId(this.pkgName, UserHandle.getUserId(r4.uid));
        if (r5 == null) goto L5;
        this.mAppEntry = r5;
    L5:
        checkForceStop();
    }

    private void updateForceStopButton(boolean r4) {
        if (this.mAppEntry != null) goto L7;
        OLog.e(TAG, "updateForceStopButton: ");
        return;
    L7:
        if (isAdded() == true) goto L10;
        OLog.e(TAG, "updateForceStopButton: not added");
        return;
    L10:
        InstalledAppDetails r1 = null;
        float r2 = 0.4f;
        if (TextUtils.equals("com.bytedanceos.securitycenter", this.mAppEntry.info.packageName) == false) goto L14;
        this.mForceStopButton.setEnabled(false);
        this.mForceStopButton.setOnClickListener(null);
        this.mForceStopButton.setAlpha(0.4f);
        return;
    L14:
        if (this.mAppControlRestricted == false) goto L16;
        this.mForceStopButton.setEnabled(true);
        this.mForceStopButton.setOnClickListener(this);
        this.mForceStopButton.setAlpha(0.4f);
        return;
    L16:
        this.mForceStopButton.setEnabled(r4);
        View r0 = this.mForceStopButton;
        if (r4 == false) goto L19;
        r1 = this;
    L19:
        r0.setOnClickListener(r1);
        View r3 = this.mForceStopButton;
        if (r4 == false) goto L22;
        r2 = 1.0f;
    L22:
        r3.setAlpha(r2);
    }

    private void checkForceStop() {
        OLog.i(TAG, "checkForceStop: " + this.pkgName);
        if (this.mDpm.packageHasActiveAdmins(this.mPackageInfo.packageName) == false) goto L6;
        OLog.i(TAG, "checkForceStop: packageHasActiveAdmins");
        updateForceStopButton(false);
    L13:
        if (isMinorApp() == false) goto L16;
        updateForceStopButton(false);
        return;
    L16:
        return;
    L6:
        if ((this.mAppEntry.info.flags & 2097152) != 0) goto L8;
        OLog.i(TAG, "checkForceStop: FLAG_STOPPED false");
        updateForceStopButton(true);
        goto L13
    L8:
        OLog.i(TAG, "checkForceStop: send ACTION_QUERY_PACKAGE_RESTART");
        Intent r5 = new Intent("android.intent.action.QUERY_PACKAGE_RESTART", Uri.fromParts("package", this.mAppEntry.info.packageName, null));
        r5.putExtra("android.intent.extra.PACKAGES", new String[]{this.mAppEntry.info.packageName});
        r5.putExtra("android.intent.extra.UID", this.mAppEntry.info.uid);
        r5.putExtra("android.intent.extra.user_handle", UserHandle.getUserId(this.mAppEntry.info.uid));
        UserHandle r0 = UserHandle.CURRENT;
        if (UserHandle.getUserId(this.mAppEntry.info.uid) != 10) goto L11;
        r0 = UserHandleSmtEx.DOPPELGANGER;
    L11:
        getActivity().sendOrderedBroadcastAsUser(r5, r0, null, this.mCheckKillProcessesReceiver, null, 0, null, null);
        goto L13
    }

    private boolean isAppProcessRunning() {
        List<ActivityManager.RunningAppProcessInfo> r0 = ((ActivityManager) getActivity().getSystemService("activity")).getRunningAppProcesses();
        if (r0 == null) goto L13;
        Iterator<ActivityManager.RunningAppProcessInfo> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        ActivityManager.RunningAppProcessInfo r2 = r1.next();
        if (r2.processName.equals(this.mAppEntry.info.processName) == true) goto L11;
        if (Arrays.binarySearch(r2.pkgList, this.mAppEntry.info.packageName) < 0) goto L6;
        return true;
    L11:
        return true;
    L13:
        OLog.d(TAG, "pkg:" + this.mAppEntry.info.packageName + " is not running");
        return false;
    }

    private void setNotificationsEnabled(boolean r4) {
        String r0 = this.mAppEntry.info.packageName;
        INotificationManager.Stub.asInterface(ServiceManager.getService("notification")).setNotificationsEnabledForPackage(r0, this.mAppEntry.info.uid, r4);     // Catch: RemoteException -> L5
    L6:
        setPushNotificationsEnabled(r4);
        ApplicationsState.setFeedbackAppNotificationsEnabled(this.mContext, r0, r4);
        return;
    L5:
        OCardListItemUtils.setChecked(this.mNotificationSwitch, !r4);
        goto L6
    }

    private void setPushNotificationsEnabled(boolean r10) {
        String r0 = this.mAppEntry.info.packageName;
        INotificationManager r1 = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        int r8 = 0;
        ApplicationInfo r9 = getActivity().getPackageManager().getApplicationInfo("com.obric.matrix", 0);     // Catch: Throwable -> L9
        NotificationChannel r2 = r1.getNotificationChannelForPackage(r9.packageName, r9.uid, r0 + PUSH_DEFAULT_CHANNEL, null, true);     // Catch: Throwable -> L9
        if (r2 == null) goto L14;
        if (r10 == false) goto L7;
        r8 = 4;
    L7:
        r2.setImportance(r8);     // Catch: Throwable -> L9
        r1.updateNotificationChannelForPackage(r9.packageName, r9.uid, r2);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    private int getPremiumSmsPermission(String r1) {
        ISms r0 = this.mSmsManager;     // Catch: RemoteException -> L8
        if (r0 == null) goto L6;
        return r0.getPremiumSmsPermission(r1);
    L6:
        return 0;
    L11:
        return 0;
    }

    private boolean handleAppSkipped(String r3) {
        if (Constants.PKG_SCREEN_RECORDER.equals(r3) == false) goto L8;
        if (Utils.isScreenRecording(this.mContext) == false) goto L12;
        ToastUtils.show(getActivity(), R.string.toast_quit_screen_record_mode);
        return true;
    L12:
        return false;
    L8:
        if ("com.obric.recorder".equals(r3) == false) goto L12;
        if (Utils.isRecorderRecording(this.mContext) == false) goto L12;
        ToastUtils.show(getActivity(), R.string.toast_please_exit_record);
        return true;
    }

    private boolean handleFeedbackApp(String r5) {
        if (Constants.PKG_BUG2GO.equals(r5) == true) goto L11;
        return false;
    L11:
        ApplicationInfo r6 = this.mPm.getApplicationInfo("com.obric.feedbackserviceproject", 0);     // Catch: Exception -> L6
        OLog.e(TAG, "handleFeedbackApp isObricApp=" + ApplicationInfoEx.isObricApp(r6));     // Catch: Exception -> L6
        handleObricApp(r6, false);     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        OLog.i(TAG, "handleFeedbackApp error=" + e);
        return true;
    }

    private boolean isMinorApp() {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.packageName != null) goto L7;
        return false;
    L7:
        return TextUtils.equals(this.mPackageInfo.packageName, "com.zte.usebalance");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (this.mAppEntry != null) goto L5;
    L146:
        finish();
        return;
    L5:
        if (this.mPackageInfo == null) goto L146;
        if (isAdded() == true) goto L10;
        return;
    L10:
        String r0 = this.mAppEntry.info.packageName;
        if (r10 != this.mUninstallButton) goto L78;
        OLog.e("heyan", "onClick:packageName" + r0);
        OLog.e("heyan", "onClick:packageNamedd" + ApplicationInfoEx.isObricApp(this.mAppEntry.info));
        if (Utils.isFastDoubleClick(-1, 500) == false) goto L16;
        return;
    L16:
        if (handleAppSkipped(r0) == false) goto L19;
        return;
    L19:
        if (handleFeedbackApp(r0) == false) goto L22;
        return;
    L22:
        if (isMinorApp() == false) goto L24;
        return;
    L24:
        SecurityEventMonitor.INSTANCE.start(this._mActivity, BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType());
        SettingsTracker.onItemClick(170103);
        if (this.mAppControlRestricted == false) goto L31;
        if (this.mAppsControlDisallowedAdmin == null) goto L31;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), this.mAppsControlDisallowedAdmin);
        return;
    L31:
        if (this.mDpm.packageHasActiveAdmins(this.mPackageInfo.packageName) == false) goto L36;
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L153;
        Intent r11 = new Intent(r9, DeviceAdminAdd.class);
        r11.putExtra(DeviceAdminAdd.EXTRA_DEVICE_ADMIN_PACKAGE_NAME, r0);
        r9.startActivityForResult(r11, 1);
        return;
    L153:
        return;
    L36:
        RestrictedLockUtils.EnforcedAdmin r12 = MultiSDKAdapterNew.checkIfUninstallBlocked(getActivity(), r0, this.mUserId);
        if (r12 != null) goto L42;
        if (this.mAppControlRestricted == false) goto L42;
        r12 = this.mAppsControlDisallowedAdmin;
    L42:
        if (this.mAppsControlDisallowedBySystem == false) goto L44;
    L47:
        boolean r1 = true;
    L48:
        if (r12 == null) goto L52;
        if (r1 == true) goto L52;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), r12);
        return;
    L52:
        if (AppUtils.isInstant(this.mAppEntry.info) == false) goto L55;
        showInstantAppUninstallDialog(this.mAppEntry.info);
        return;
    L55:
        if (ApplicationInfoEx.isObricApp(this.mAppEntry.info) == false) goto L58;
        handleObricApp(this.mAppEntry.info, false);
        return;
    L58:
        if (this.mUpdatedSysApp == false) goto L61;
        handleObricApp(this.mAppEntry.info, this.mUpdatedSysApp);
        return;
    L61:
        if ((this.mAppEntry.info.flags & 1) == 0) goto L71;
        if (Utils.canBundledUninstall(this.mAppEntry.info) == false) goto L67;
        uninstallPkgByUid(r0, false, false, this.mAppEntry.info.uid);
        return;
    L67:
        if (this.mAppEntry.info.enabled == false) goto L69;
        showDialogInner(7, 0);
        return;
    L69:
        new DisableChanger(this.mPm, this.mAppEntry.info, 0).execute(new Object[]{null});
        return;
    L71:
        if ((this.mAppEntry.info.flags & 8388608) != 0) goto L74;
        uninstallPkgByUid(r0, false, false, this.mAppEntry.info.uid);
        return;
    L74:
        if (UserHandle.getUserId(this.mAppEntry.info.uid) != 10) goto L76;
        uninstallDoppelgangerPkg(r0, false);
        return;
    L76:
        uninstallPkg(r0, false, false);
        return;
    L44:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(getActivity(), r0, this.mUserId) == true) goto L47;
        r1 = false;
        goto L48
    L78:
        if (r10 != this.mSpecialDisableButton) goto L86;
        if ((this.mAppEntry.info.flags & 1) != 0) goto L82;
        return;
    L82:
        if (this.mAppEntry.info.enabled == false) goto L84;
        showDialogInner(7, 0);
        return;
    L84:
        new DisableChanger(this.mPm, this.mAppEntry.info, 0).execute(new Object[]{null});
        return;
    L86:
        if (r10 != this.mActivitiesButton) goto L94;
        SettingsTracker.onItemClick(170108);
        this.mPm.clearPackagePreferredActivities(r0);
        this.mUsbManager.clearDefaults(r0, this.mUserId);     // Catch: RemoteException -> L90
    L92:
        this.mAppWidgetManager.setBindAppWidgetPermission(r0, false);
        resetLaunchDefaultsUi((OSectionSupportiveText) NullSafe.nonNull(findViewByIdNullable(R.id.auto_launch)));
        return;
    L90:
        e = move-exception;
        OLog.e(TAG, "mUsbManager.clearDefaults", e);
        goto L92
    L94:
        if (r10 != this.mForceStopButton) goto L112;
        if (isMinorApp() == false) goto L98;
        return;
    L98:
        SettingsTracker.onItemClick(170101);
    L103:
        e = move-exception;
        OLog.e(TAG, "onClick, isPackageStateProtected error: " + e);
    L106:
        if (this.mAppsControlDisallowedAdmin != null) goto L108;
    L110:
        showDialogInner(5, 0);
        return;
    L108:
        if (this.mAppsControlDisallowedBySystem == true) goto L110;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), this.mAppsControlDisallowedAdmin);
        return;
    L100:
        if (this.mPm.isPackageStateProtected(this.mAppEntry.info.packageName, this.mUserId) == false) goto L106;
        Context r13 = this.mContext;     // Catch: Exception -> L103
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(r13, RestrictedLockUtilsInternal.getDeviceOwner(r13));     // Catch: Exception -> L103
        return;
    L112:
        if (r10 != this.mLaunchAppButton) goto L131;
        SettingsTracker.onItemClick(170102);
        if (this.mLauncherIntent == null) goto L169;
        PackageManager r14 = getPackageManager();     // Catch: Throwable -> L128
        int r2 = UserHandle.getUserId(this.mAppEntry.info.uid);     // Catch: Throwable -> L128
        if (r2 != 10) goto L119;
        startDoppelgangerApp(this.mLauncherIntent, UserHandleSmtEx.DOPPELGANGER);     // Catch: Throwable -> L128
        return;
    L119:
        if (r2 == 0) goto L121;
    L126:
        startActivity(this.mLauncherIntent);     // Catch: Throwable -> L128
        return;
    L121:
        if ((this.mAppEntry.info.flags & 1) != 0) goto L126;
        if (Utils.doppelgangerAppExist(r14, UserHandle.getUid(10, this.mAppEntry.info.uid)) == false) goto L126;
        startDoppelgangerApp(this.mLauncherIntent, UserHandle.OWNER);     // Catch: Throwable -> L128
        return;
    L128:
        th = move-exception;
        OLog.e(TAG, "LaunchApp error: " + th);
        th.printStackTrace();
        return;
    L169:
        return;
    L131:
        if (r10 != OCardListItemUtils.getContentView(this.mNotificationItemView)) goto L134;
        Bundle r15 = new Bundle();
        r15.putInt("back_text_id", R.string.application_info_label);
        r15.putInt("title_id", R.string.notification_more_title);
        r15.putParcelable("appInfo", this.mAppEntry.info);
        r15.putBoolean("from_app_detail", true);
        NotificationDetailsFragment r3 = new NotificationDetailsFragment();
        r3.setArguments(r15);
        start(r3);
        return;
    L134:
        if (r10 != OCardListItemUtils.getContentView(this.mAppStorageItemView)) goto L137;
        SettingsTracker.onItemClick(170104);
        Bundle r16 = new Bundle();
        r16.putString("package", this.pkgName);
        r16.putInt(ARG_APP_UID, this.mAppEntry.info.uid);
        r16.putInt(AccountInfoBundleKey.USER_ID, getAppPackageUerId());
        r16.putInt("back_text_id", R.string.application_info_label);
        start(AppStorageDetailFragment.class, r16);
        return;
    L137:
        if (r10 != OCardListItemUtils.getContentView(this.mDataUsageItemView)) goto L140;
        SettingsTracker.onItemClick(170105);
        Bundle r17 = new Bundle();
        r17.putString("package", this.pkgName);
        r17.putInt(ARG_APP_UID, this.mAppEntry.info.uid);
        r17.putInt(AccountInfoBundleKey.USER_ID, getAppPackageUerId());
        r17.putInt("back_text_id", R.string.application_info_label);
        start(AppDataUsageDetailFragment.class, r17);
        return;
    L140:
        if (r10 != OCardListItemUtils.getContentView(this.mPermManagerItemView)) goto L143;
        SettingsTracker.onItemClick(170106);
        PermissionControllerHelp.INSTANCE.startManagePermissionsActivity(getActivity(), this.mPackageInfo.applicationInfo.loadLabel(this.mPm), this.mPackageInfo.applicationInfo.uid, this.pkgName);
        return;
    L143:
        if (r10 != OCardListItemUtils.getContentView(this.mBatteryManagerItemView)) goto L175;
        SettingsTracker.onItemClick(170107);
        Bundle r18 = new Bundle();
        r18.putInt("title_id", R.string.battery_manager_title);
        r18.putInt("back_text_id", R.string.application_info_label);
        r18.putString("package_name", this.mPackageInfo.applicationInfo.packageName);
        r18.putInt("application_uid", this.mPackageInfo.applicationInfo.uid);
        r18.putBoolean(BaseActivity.EXTRA_FROM_SECURITY, this.mFromSecurityCenter);
        r18.putDoubleArray(POWER_USAGE, (double[]) this.mBatteryManagerItemView.getTag());
        start(AppBatteryUseOptimizationControlFragment.class, r18);
        return;
    }

    private void handleObricApp(ApplicationInfo r3, boolean r4) {
        if ("com.larus.nova".equals(r3.packageName) == false) goto L6;
        handleUninstallDoubao(r3);
        return;
    L6:
        Bundle r0 = new Bundle();
        r0.putParcelable("handleObricApp.info", r3);
        r0.putBoolean("handleObricApp.updatedSysApp", r4);
        showDialogInner(10, 0, r0);
    }

    private Dialog handleObricAppDialog(final ApplicationInfo r6, boolean r7) {
        if (r7 == false) goto L5;
        String r8 = getString(R.string.uninstall_system_app_title, new Object[]{r6.loadLabel(this.mPm)});
        String r2 = getString(R.string.uninstal_update);
    L6:
        OAlertDialogBuilder r5 = new OAlertDialogBuilder(requireActivity()).autoDismiss(false).title(r8, false).message(SystemAppRecorder.INSTANCE.getUninstallDescription(r6.packageName, this.mContext)).icon(r6.loadIcon(this.mPm)).imageSize((int) DisplayUtils.dip2px(56.0f), (int) DisplayUtils.dip2px(56.0f)).positiveButton(r2, new InstalledAppDetails$$ExternalSyntheticLambda5(this, r6)).negativeButton(getString(R.string.cancel), new InstalledAppDetails$$ExternalSyntheticLambda6(this));
        r5.horizontalButton(true);
        return r5.createDialog();
    L5:
        r8 = getString(R.string.uninstall_app_title, new Object[]{r6.loadLabel(this.mPm)});
        r2 = getString(R.string.uninstal);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$handleObricAppDialog$2$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ void m290xc186450(ApplicationInfo r1, DialogInterface r2, int r3) {
        uninstallPkgDirectly(r1.packageName);
        r2.dismiss();
        SecurityEventMonitor.INSTANCE.finish(requireActivity(), BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType());
    }

    /* JADX INFO: renamed from: lambda$handleObricAppDialog$3$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ void m291x356cb991(DialogInterface r1, int r2) {
        r1.dismiss();
        SecurityEventMonitor.INSTANCE.cancel(requireActivity(), BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType());
    }

    private void showInstantAppUninstallDialog(ApplicationInfo r3) {
        Bundle r0 = new Bundle();
        r0.putParcelable("showInstantAppUninstallDialog.info", r3);
        showDialogInner(12, 0, r0);
    }

    private Dialog handleInstantAppUninstallDialog(final ApplicationInfo r7) {
        String r1 = getString(R.string.uninstall_app_title, new Object[]{r7.loadLabel(this.mPm)});
        OAlertDialogBuilder r6 = new OAlertDialogBuilder(requireActivity()).autoDismiss(false).title(r1, false).icon(r7.loadIcon(this.mPm)).imageSize((int) DisplayUtils.dip2px(56.0f), (int) DisplayUtils.dip2px(56.0f)).positiveButton(getString(R.string.uninstal), new InstalledAppDetails$$ExternalSyntheticLambda0(this, r7)).negativeButton(getString(R.string.cancel), new InstalledAppDetails$$ExternalSyntheticLambda1(this));
        r6.horizontalButton(true);
        return r6.createDialog();
    }

    /* JADX INFO: renamed from: lambda$handleInstantAppUninstallDialog$4$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ void m288x829e0762(ApplicationInfo r1, DialogInterface r2, int r3) {
        clearInstantApp(r1.packageName);
        r2.dismiss();
        SecurityEventMonitor.INSTANCE.finish(requireActivity(), BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType());
    }

    /* JADX INFO: renamed from: lambda$handleInstantAppUninstallDialog$5$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ void m289xabf25ca3(DialogInterface r1, int r2) {
        r1.dismiss();
        SecurityEventMonitor.INSTANCE.cancel(requireActivity(), BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType());
    }

    private void handleUninstallDoubao(ApplicationInfo r3) {
        Bundle r0 = new Bundle();
        r0.putParcelable("handleUninstallDoubao.info", r3);
        showDialogInner(11, 0, r0);
    }

    private Dialog handleUninstallDoubaoDialog(final ApplicationInfo r7) {
        String r1 = getString(R.string.uninstall_app_title_doubao, new Object[]{r7.loadLabel(this.mPm)});
        return new OAlertDialogBuilder(requireActivity()).autoDismiss(false).horizontalButton(true).title(r1, false).message(R.string.uninstall_app_title_doubao_des).icon(r7.loadIcon(this.mPm)).imageSize((int) DisplayUtils.dip2px(56.0f), (int) DisplayUtils.dip2px(56.0f)).positiveButton(getString(R.string.uninstal), new InstalledAppDetails$$ExternalSyntheticLambda2(this, r7)).negativeButton(getString(R.string.cancel), new InstalledAppDetails$$ExternalSyntheticLambda3(this)).createDialog();
    }

    /* JADX INFO: renamed from: lambda$handleUninstallDoubaoDialog$6$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ void m292xf2b26aaa(ApplicationInfo r1, DialogInterface r2, int r3) {
        uninstallPkgDirectly(r1.packageName);
        r2.dismiss();
        SecurityEventMonitor.INSTANCE.finish(requireActivity(), BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType());
    }

    /* JADX INFO: renamed from: lambda$handleUninstallDoubaoDialog$7$com-android-settings-applications-InstalledAppDetails, reason: not valid java name */
    /* synthetic */ void m293x1c06bfeb(DialogInterface r1, int r2) {
        r1.dismiss();
        SecurityEventMonitor.INSTANCE.cancel(requireActivity(), BDSettingsEvent.EVENT_TYPE_UNINSTALL_APP.getType());
    }

    private void startDoppelgangerApp(Intent r3, UserHandle r4) {
        r3.putExtra("com.bytedanceos.doppelganger.had_choose", true);
        getActivity().startActivityAsUser(r3, null, r4);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        String r0 = this.mAppEntry.info.packageName;
        ActivityManager r1 = (ActivityManager) getActivity().getSystemService("activity");
        if (r4 != OCardListItemUtils.getSwitchView(this.mAskCompatibilityCB)) goto L9;
        r1.setPackageAskScreenCompat(r0, r5);
        return;
    L9:
        if (r4 != OCardListItemUtils.getSwitchView(this.mEnableCompatibilityCB)) goto L12;
        r1.setPackageScreenCompatMode(r0, r5 ? 1 : 0);
        return;
    L12:
        if (r4 == OCardListItemUtils.getSwitchView(this.mNotificationSwitch)) goto L14;
        return;
    L14:
        if (RiskPermissionControlGuard.intercept(getActivity(), this.mAppEntry.info.packageName, UserHandle.getUserId(this.mAppEntry.info.uid), 64) == false) goto L17;
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationSwitch, null);
        OCardListItemUtils.setChecked(this.mNotificationSwitch, !r5);
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationSwitch, this);
        return;
    L17:
        SettingsTracker.onSwitcherClick(170109, r5);
        if (r5 == true) goto L20;
        setNotificationsEnabled(false);
        return;
    L20:
        setNotificationsEnabled(true);
    }

    private void refreshPowerUsage(String r4) {
        if (this.batteryPowerViewModel != null) goto L5;
        BatteryPowerViewModel r0 = (BatteryPowerViewModel) new ViewModelProvider(getActivity()).get(BatteryPowerViewModel.class);
        this.batteryPowerViewModel = r0;
        r0.getPercent().observe(getActivity(), this.batteryPowerObserver);
    L5:
        this.batteryPowerViewModel.getPowerPercent(getActivity(), r4);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settings.applications.InstalledAppDetails$17] */
    private void refreshPowerUsage(Bundle r1) {
        new AnonymousClass17(this).execute(new Void[0]);
    }

    private UidBatteryConsumer findTargetUidBatteryConsumer(BatteryUsageStats r4, int r5) {
        List r3 = r4.getUidBatteryConsumers();
        int r6 = r3.size();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L8;
        UidBatteryConsumer r1 = (UidBatteryConsumer) r3.get(r0);
        if (r1.getUid() == r5) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    private boolean isSocialPackage(String r6) {
        if ("com.android.contacts".equals(r6) == false) goto L5;
    L18:
        return true;
    L5:
        if (Constants.PKG_MMS.equals(r6) == true) goto L18;
        if (r6 == null) goto L17;
        String[] r5 = this.mSocialAppList;
        if (r5 == null) goto L17;
        int r2 = r5.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L17;
        if (r6.equals(r5[r3]) == true) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    private static int getPermissionCount(Context r5, String r6) {
        Uri r2 = Uri.parse("content://com.bytedanceos.security.apiprovider");     // Catch: Exception -> L9
        ContentResolver r7 = r5.getContentResolver();     // Catch: Exception -> L9
        if (r7 == null) goto L14;
        Bundle r8 = r7.call(r2, "getPermissionCount", r6, null);     // Catch: Exception -> L9
        if (r8 == null) goto L15;
        String r9 = r8.getString("extra_result");     // Catch: Exception -> L9
        OLog.d(TAG, "getPermissionCount " + r9);     // Catch: Exception -> L9
        return Integer.parseInt(r9);
    L15:
        return 0;
    L14:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private void startAllServicesActivity() {
        Intent r0 = new Intent("android.intent.action.VIEW_APP_FEATURES");     // Catch: Exception -> L4
        ResolveInfo r1 = getResolveInfo(0);     // Catch: Exception -> L4
        r0.setComponent(new ComponentName(this.pkgName, r1.activityInfo.name));     // Catch: Exception -> L4
        Utils.startActivity(this._mActivity, r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "startAllServicesActivity fail", e);
    }

    private ResolveInfo getResolveInfo(int r3) {
        if (this.pkgName != null) goto L6;
        return null;
    L6:
        Intent r0 = new Intent("android.intent.action.VIEW_APP_FEATURES");
        r0.setPackage(this.pkgName);
        return getPackageManager().resolveActivity(r0, r3);
    }

    private boolean isWorkProfile() {
        int r0 = getAppPackageUid();
        if (r0 != (-1)) goto L13;
        return false;
    L13:
    L10:
        e = move-exception;
        OLog.e(TAG, "isWorkProfile fail", e);
        return false;
    L6:
        if (this.mUserManager != null) goto L8;
        this.mUserManager = (UserManager) SettingsApplication.getContext().getSystemService(PickApplicationActivity.EXTRA_USER);     // Catch: Exception -> L10
    L8:
        return this.mUserManager.isManagedProfile(UserHandle.getUserId(r0));
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_InstalledAppDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(InstalledAppDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_InstalledAppDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_InstalledAppDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(InstalledAppDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_InstalledAppDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_InstalledAppDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(InstalledAppDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_InstalledAppDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
