package com.android.settings.applications;

import android.app.ActivityManagerNative;
import android.app.admin.DevicePolicyManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.IPackageDataObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.security.bytedance.guard.BDSettingsEvent;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.autoaction.SecurityEventMonitor;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppStorageDetailFragment extends BaseFragment implements View.OnClickListener, ApplicationsState.Callbacks {
    private static final int CLEAR_CACHE = 3;
    private static final int CLEAR_USER_DATA = 1;
    private static final int DLG_CANNOT_CLEAR_DATA = 2;
    private static final int DLG_CLEAR_DATA = 1;
    private static final String KEY_CACHE_CLEARED = "cache_cleared";
    private static final String KEY_DATA_CLEARED = "data_cleared";
    private static final String MOBILE_SCREEN_RECORDER_SHOW_STATUS = "screen_recorder_show_status";
    private static final int MSG_CLEAR_DATA_DELAY = 5;
    private static final int OP_FAILED = 2;
    private static final int OP_SUCCESSFUL = 1;
    private static final int PACKAGE_MOVE = 4;
    private static final String PACKAGE_SCREENRECORDER = "com.obric.screenrecorder";
    public static final int REQUEST_MANAGE_SPACE = 2;
    public static final int REQUEST_VERIFY_LAUNCHER_PASSWORD = 3;
    private static final int SIZE_INVALID = -1;
    private static final String TNT_SCREEN_RECORDER_SHOW_STATUS = "screen_recorder_show_in_ext";
    private boolean firstInit;
    private ApplicationsState.AppEntry mAppEntry;
    private OCardListItem mAppSize;
    private int mAppUid;
    private TextView mAppVersion;
    private RestrictedLockUtils.EnforcedAdmin mAppsControlDisallowedAdmin;
    private boolean mAppsControlDisallowedBySystem;
    private TextView mAvaiSpaceTipsView;
    private boolean mCacheCleared;
    private OCardListItem mCacheSize;
    private TextView mCacheSizeText;
    private CanBeOnSdCardChecker mCanBeOnSdCardChecker;
    private boolean mCanClearData;
    private OCardListItem mClearCacheButton;
    private ClearCacheObserver mClearCacheObserver;
    private OCardListItem mClearDataButton;
    private ClearUserDataObserver mClearDataObserver;
    private String mComputingStr;
    private boolean mDataCleared;
    private OCardListItem mDataSize;
    private DevicePolicyManager mDpm;
    private OCardListItem mExternalCodeSize;
    private OCardListItem mExternalDataSize;
    private final Handler mHandler;
    private boolean mHaveSizes;
    private boolean mIsActionFinished;
    private long mLastCacheSize;
    private long mLastCodeSize;
    private long mLastDataSize;
    private long mLastExternalCodeSize;
    private long mLastExternalDataSize;
    private long mLastTotalSize;
    private OCardListItem mMoveAppButton;
    private PackageInfo mPackageInfo;
    private String mPackageName;
    private ApplicationsState.Session mSession;
    private ApplicationsState mState;
    private OCardListItem mTotalSize;
    private int mUserId;
    private OAlertDialog mWarningDialog;

    class ClearCacheObserver extends IPackageDataObserver.Stub {
        final /* synthetic */ AppStorageDetailFragment this$0;

        ClearCacheObserver(AppStorageDetailFragment r1) {
            this.this$0 = r1;
        }

        public void onRemoveCompleted(String r2, boolean r3) {
            Message r4 = AppStorageDetailFragment.access$1200(this.this$0).obtainMessage(3);
            if (r3 == false) goto L5;
            int r5 = 1;
        L6:
            r4.arg1 = r5;
            AppStorageDetailFragment.access$1200(this.this$0).sendMessage(r4);
            return;
        L5:
            r5 = 2;
            goto L6
        }
    }

    class ClearUserDataObserver extends IPackageDataObserver.Stub {
        final /* synthetic */ AppStorageDetailFragment this$0;

        ClearUserDataObserver(AppStorageDetailFragment r1) {
            this.this$0 = r1;
        }

        public void onRemoveCompleted(String r2, boolean r3) {
            int r0 = 1;
            Message r4 = AppStorageDetailFragment.access$1200(this.this$0).obtainMessage(1);
            if (r3 == true) goto L6;
            r0 = 2;
        L6:
            r4.arg1 = r0;
            AppStorageDetailFragment.access$1200(this.this$0).sendMessage(r4);
        }
    }

    public void com_android_settings_applications_AppStorageDetailFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_AppStorageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r1) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_AppStorageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    public AppStorageDetailFragment() {
        this.mHaveSizes = false;
        this.mLastCodeSize = -1;
        this.mLastDataSize = -1;
        this.mLastExternalCodeSize = -1;
        this.mLastExternalDataSize = -1;
        this.mLastCacheSize = -1;
        this.mLastTotalSize = -1;
        this.mCanClearData = true;
        this.mIsActionFinished = false;
        this.mUserId = -10000;
        this.mAppsControlDisallowedAdmin = null;
        this.mAppsControlDisallowedBySystem = false;
        this.mHandler = new AnonymousClass1(this);
        this.firstInit = true;
    }

    static /* synthetic */ ApplicationsState.AppEntry access$000(AppStorageDetailFragment r0) {
        return r0.mAppEntry;
    }

    static /* synthetic */ void access$1000(AppStorageDetailFragment r0, boolean r1, boolean r2) {
        r0.setIntentAndFinish(r1, r2);
    }

    static /* synthetic */ boolean access$102(AppStorageDetailFragment r0, boolean r1) {
        r0.mDataCleared = r1;
        return r1;
    }

    static /* synthetic */ OAlertDialog access$1100(AppStorageDetailFragment r0) {
        return r0.mWarningDialog;
    }

    static /* synthetic */ OAlertDialog access$1102(AppStorageDetailFragment r0, OAlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ Handler access$1200(AppStorageDetailFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ boolean access$202(AppStorageDetailFragment r0, boolean r1) {
        r0.mCacheCleared = r1;
        return r1;
    }

    static /* synthetic */ void access$300(AppStorageDetailFragment r0, Message r1) {
        r0.processClearMsg(r1);
    }

    static /* synthetic */ ApplicationsState access$400(AppStorageDetailFragment r0) {
        return r0.mState;
    }

    static /* synthetic */ void access$500(AppStorageDetailFragment r0, int r1) {
        r0.showWarningDialog(r1);
    }

    static /* synthetic */ void access$600(AppStorageDetailFragment r0) {
        r0.initiateClearUserData();
    }

    static /* synthetic */ boolean access$702(AppStorageDetailFragment r0, boolean r1) {
        r0.mIsActionFinished = r1;
        return r1;
    }

    static /* synthetic */ OCardListItem access$800(AppStorageDetailFragment r0) {
        return r0.mClearDataButton;
    }

    static /* synthetic */ void access$900(AppStorageDetailFragment r0, OCardListItem r1, int r2, boolean r3) {
        r0.setButtonState(r1, r2, r3);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        boolean r1 = false;
        this.mRootView = r3.inflate(R.layout.app_storage_detail_layout, r4, false);
        if (r5 == null) goto L9;
        this.mCacheCleared = r5.getBoolean(KEY_CACHE_CLEARED, false);
        boolean r6 = r5.getBoolean(KEY_DATA_CLEARED, false);
        this.mDataCleared = r6;
        if (this.mCacheCleared == true) goto L7;
        if (r6 == true) goto L7;
    L8:
        this.mCacheCleared = r1;
    L7:
        r1 = true;
    L9:
        ApplicationsState r7 = ApplicationsState.getInstance(requireActivity().getApplication(), true);
        this.mState = r7;
        this.mSession = r7.newSession(this);
        this.mDpm = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        this.mCanBeOnSdCardChecker = new CanBeOnSdCardChecker();
        this.mComputingStr = getResources().getString(R.string.memory_calculating_size);
        initViews();
        retrieveAppEntry();
        Utils.setAppLabelAndIconViews(this.mRootView, this.mPackageName, this.mAppUid);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mRootView);
        return this.mRootView;
    }

    private void initViews() {
        this.mTotalSize = (OCardListItem) findViewByIdNullable(R.id.total_size);
        this.mAppSize = (OCardListItem) findViewByIdNullable(R.id.application_size);
        this.mExternalCodeSize = (OCardListItem) findViewByIdNullable(R.id.external_code_size);
        this.mDataSize = (OCardListItem) findViewByIdNullable(R.id.info_size);
        this.mExternalDataSize = (OCardListItem) findViewByIdNullable(R.id.external_data_size_prefix);
        this.mClearDataButton = (OCardListItem) findViewByIdNullable(R.id.right_button);
        this.mMoveAppButton = (OCardListItem) findViewByIdNullable(R.id.left_button);
        this.mCacheSize = (OCardListItem) findViewByIdNullable(R.id.cache_size);
        OCardListItem r0 = (OCardListItem) findViewByIdNullable(R.id.clear_cache_button);
        this.mClearCacheButton = r0;
        setButtonText(r0, R.string.clear_cache_btn_text);
        if (Environment.isExternalStorageEmulated() == false) goto L5;
        this.mExternalCodeSize.setVisibility(8);
        this.mExternalDataSize.setVisibility(8);
    L5:
        this.mAvaiSpaceTipsView = (TextView) findViewByIdNullable(R.id.id_bottom_tips);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        OFloatingTitleBar r3 = this.mTitleView;
        if (r3 == null) goto L5;
        r3.setFitsSystemWindows(true);
        r3.requestApplyInsets();
    L5:
        resumeAndUpdate();
    }

    private void resumeAndUpdate() {
        this.mSession.resume(true);
        if (Utils.isPackageInstalled(this.mContext, this.mPackageName) == false) goto L7;
        ApplicationsState.AppEntry r0 = this.mAppEntry;
        if (r0 == null) goto L7;
        this.mState.requestSizeByUserId(r0.info);
        refreshUi();
        return;
    L7:
        finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean(KEY_CACHE_CLEARED, this.mCacheCleared);
        r3.putBoolean(KEY_DATA_CLEARED, this.mDataCleared);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OAlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        ApplicationsState.Session r1 = this.mSession;
        if (r1 == null) goto L10;
        r1.release();
    L10:
        this.mHandler.removeCallbacksAndMessages(null);
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mWarningDialog.dismiss();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        if (r1 == 3) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L9;
        this.mHandler.sendEmptyMessageDelayed(5, 500);
        return;
    }

    private void setIntentAndFinish(boolean r3, boolean r4) {
        OLog.i(this.TAG, "appChanged=" + r4);
        new Intent().putExtra("chg", r4);
        finish();
    }

    private void refreshUi() {
        initDataButtons();
        initMoveButton();
        refreshSizeInfo();
    }

    private void setButtonText(OCardListItem r1, int r2) {
        OTextView r0 = getButtonTextView(r1);
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    private void setButtonState(final OCardListItem r2, int r3, boolean r4) {
        OTextView r0 = getButtonTextView(r2);
        if (r0 == null) goto L5;
        r0.setTextColor(getColor(r3));
    L5:
        if (r2 == null) goto L12;
        r2.setClickable(r4);
        if (r4 == false) goto L9;
        View.OnClickListener r5 = new AppStorageDetailFragment$$ExternalSyntheticLambda0(this, r2);
    L10:
        r2.setOnContentClickListener(r5);
        return;
    L9:
        r5 = null;
        goto L10
    }

    /* JADX INFO: renamed from: lambda$setButtonState$0$com-android-settings-applications-AppStorageDetailFragment, reason: not valid java name */
    /* synthetic */ void m286x54f481e3(OCardListItem r1, View r2) {
        onClick(r1);
    }

    private OTextView getButtonTextView(OCardListItem r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.getCustomStartView() == null) goto L12;
        OTextView r0 = (OTextView) r1.getCustomStartView().findViewById(R.id.settings_text);
        if (r0 == null) goto L9;
        r0.setTextAppearance(R.style.Title_1_Bold);
    L9:
        return r0;
    L12:
        return null;
    }

    private int getColor(int r1) {
        return getContext().getColor(r1);
    }

    private void initDataButtons() {
        ApplicationsState.AppEntry r0 = this.mAppEntry;
        if (r0 != null) goto L5;
    L9:
        ApplicationsState.AppEntry r1 = this.mAppEntry;
        if (r1 != null) goto L12;
    L14:
        setButtonText(this.mClearDataButton, R.string.clear_user_data_text);
    L15:
        setButtonState(this.mClearDataButton, R.color.oui_functional_red_6, true);
        return;
    L12:
        if (r1.info.manageSpaceActivityName == null) goto L14;
        setButtonText(this.mClearDataButton, R.string.manage_space_text);
        goto L15
    L5:
        if ((r0.info.flags & 65) != 1) goto L7;
    L8:
        setButtonText(this.mClearDataButton, R.string.clear_user_data_text);
        setButtonState(this.mClearDataButton, R.color.oui_basic_text_4, false);
        this.mCanClearData = false;
        return;
    L7:
        if (this.mDpm.packageHasActiveAdmins(this.mAppEntry.info.packageName) == false) goto L9;
        goto L8
    }

    private void initMoveButton() {
        this.mMoveAppButton.setVisibility(8);
    }

    private void refreshSizeInfo() {
        this.mAvaiSpaceTipsView.setText(getString(R.string.device_avai_memory_size, new Object[]{Formatter.formatFileSize(this.mContext, Utils.getAvailableSize(Environment.getDataDirectory())).replace('k', 'K')}));
        ApplicationsState.AppEntry r0 = this.mAppEntry;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.size != (-2)) goto L8;
    L58:
        this.mLastTotalSize = -1;
        this.mLastCacheSize = -1;
        this.mLastDataSize = -1;
        this.mLastCodeSize = -1;
        if (this.mHaveSizes == true) goto L61;
        OCardListItemUtils.setTrailingText(this.mAppSize, this.mComputingStr);
        OCardListItemUtils.setTrailingText(this.mDataSize, this.mComputingStr);
        OCardListItemUtils.setTrailingText(this.mCacheSize, this.mComputingStr);
        OCardListItemUtils.setTrailingText(this.mTotalSize, this.mComputingStr);
    L61:
        setButtonState(this.mClearDataButton, R.color.oui_basic_text_4, false);
    L62:
        findViewByIdNullable(R.id.page_container).invalidate();
        return;
    L8:
        if (this.mAppEntry.size == (-1)) goto L58;
        this.mHaveSizes = true;
        long r5 = this.mAppEntry.codeSize;
        if (this.mDataCleared == false) goto L13;
        long r9 = 0;
    L15:
        if (Environment.isExternalStorageEmulated() == false) goto L18;
        r5 = r5 + this.mAppEntry.externalCodeSize;
        r9 = r9 + this.mAppEntry.externalDataSize;
    L24:
        if (this.mLastCodeSize == r5) goto L27;
        this.mLastCodeSize = r5;
        OCardListItemUtils.setTrailingText(this.mAppSize, getSizeStr(r5));
    L27:
        if (this.mLastDataSize == r9) goto L30;
        this.mLastDataSize = r9;
        OCardListItemUtils.setTrailingText(this.mDataSize, getSizeStr(r9));
    L30:
        if (this.mDataCleared == false) goto L32;
    L35:
        long r6 = 0;
    L37:
        if (this.mLastCacheSize == r6) goto L40;
        this.mLastCacheSize = r6;
        OCardListItemUtils.setTrailingText(this.mCacheSize, getSizeStr(r6));
    L40:
        if (this.mLastTotalSize == this.mAppEntry.size) goto L43;
        this.mLastTotalSize = this.mAppEntry.size;
        OCardListItemUtils.setTrailingText(this.mTotalSize, getSizeStr(this.mAppEntry.size));
    L43:
        if ((this.mAppEntry.dataSize + this.mAppEntry.externalDataSize) > 0) goto L45;
    L50:
        setButtonState(this.mClearDataButton, R.color.oui_basic_text_4, false);
    L52:
        if (r6 > 0) goto L54;
    L57:
        setButtonState(this.mClearCacheButton, R.color.oui_basic_text_4, false);
        goto L62
    L54:
        if (this.mCacheCleared == true) goto L57;
        setButtonState(this.mClearCacheButton, R.color.oui_functional_red_6, true);
        goto L62
    L45:
        if (this.mCanClearData == false) goto L50;
        if (this.mDataCleared == true) goto L50;
        setButtonState(this.mClearDataButton, R.color.oui_functional_red_6, true);
        goto L52
    L32:
        if (this.mCacheCleared == true) goto L35;
        r6 = this.mAppEntry.cacheSize + this.mAppEntry.externalCacheSize;
        goto L37
    L18:
        if (this.mLastExternalCodeSize == this.mAppEntry.externalCodeSize) goto L21;
        this.mLastExternalCodeSize = this.mAppEntry.externalCodeSize;
        OCardListItemUtils.setTrailingText(this.mExternalCodeSize, getSizeStr(this.mAppEntry.externalCodeSize));
    L21:
        if (this.mLastExternalDataSize == this.mAppEntry.externalDataSize) goto L24;
        this.mLastExternalDataSize = this.mAppEntry.externalDataSize;
        OCardListItemUtils.setTrailingText(this.mExternalDataSize, getSizeStr(this.mAppEntry.externalDataSize));
        goto L24
    L13:
        r9 = this.mAppEntry.dataSize;
        goto L15
    }

    private String getSizeStr(long r3) {
        if (r3 != (-1)) goto L7;
        return this.mComputingStr.toString();
    L7:
        return Utils.formatFileSize(this.mContext, r3);
    }

    private void retrieveAppEntry() {
        Bundle r0 = getArguments();
        String r1 = r0.getString("package");
        this.mPackageName = r1;
        if (r1 != null) goto L6;
        finish();
        return;
    L6:
        int r2 = r0.getInt(InstalledAppDetails.ARG_APP_UID, Utils.getAppUid(this.mContext, this.mPackageName));
        this.mAppUid = r2;
        int r3 = UserHandle.getUserId(r2);
        ApplicationsState.AppEntry r4 = this.mState.getEntryByUserId(this.mPackageName, r3);
        this.mAppEntry = r4;
        if (r4 != null) goto L14;
        OLog.w(this.TAG, "Missing AppEntry; maybe reinstalling?");
        this.mPackageInfo = null;
        finish();
        return;
    L14:
        this.mPackageInfo = getActivity().getPackageManager().getPackageInfoAsUser(this.mAppEntry.info.packageName, 8768, r3);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        OLog.e(this.TAG, "Exception when retrieving package:" + this.mAppEntry.info.packageName, e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4 != this.mClearDataButton) goto L25;
        if (this.mAppsControlDisallowedAdmin != null) goto L7;
    L9:
        ApplicationsState.AppEntry r5 = this.mAppEntry;
        if (r5 != null) goto L12;
    L16:
        ApplicationsState.AppEntry r6 = this.mAppEntry;
        if (r6 != null) goto L19;
    L23:
        showWarningDialog(1);
        return;
    L19:
        if ("com.bytedanceos.launcher".equals(r6.info.packageName) == false) goto L23;
        if (Utils.hasLockedPackages(this.mContext.getPackageManager()) == false) goto L23;
        Utils.startActivity(this, new Intent("com.bytedanceos.launcher.verify_password"), 2, 3);
        return;
    L12:
        if (r5.info.manageSpaceActivityName == null) goto L16;
        if (Utils.isMonkeyRunning() == true) goto L44;
        Intent r7 = new Intent("android.intent.action.VIEW");
        r7.setClassName(this.mAppEntry.info.packageName, this.mAppEntry.info.manageSpaceActivityName);
        startActivityForResult(r7, 2);
        return;
    L44:
        return;
    L7:
        if (this.mAppsControlDisallowedBySystem == true) goto L9;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, this.mAppsControlDisallowedAdmin);
        return;
    L25:
        if (r4 == this.mClearCacheButton) goto L27;
        return;
    L27:
        if (this.mAppsControlDisallowedAdmin == null) goto L33;
        if (this.mAppsControlDisallowedBySystem == true) goto L33;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, this.mAppsControlDisallowedAdmin);
        return;
    L33:
        if (this.mClearCacheObserver != null) goto L35;
        this.mClearCacheObserver = new ClearCacheObserver(this);
    L35:
        PackageManager r8 = this.mContext.getPackageManager();
        r8.deleteApplicationCacheFilesAsUser(this.mPackageName, UserHandle.getUserId(this.mAppEntry.info.uid), this.mClearCacheObserver);     // Catch: Exception -> L38
        return;
    L38:
        e = move-exception;
        e.printStackTrace();
    }

    private void showWarningDialog(final int r12) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        final FragmentActivity r0 = getActivity();
        if (r0 != null) goto L9;
        OLog.e(this.TAG, "showWarningDialog, activity is null, return");
        return;
    L9:
        final int r1 = BDSettingsEvent.EVENT_TYPE_APP_DATA_CLEAR.getType();
        if (r12 != 1) goto L12;
        SecurityEventMonitor.INSTANCE.start(r0, r1);
    L12:
        this.mIsActionFinished = false;
        if (this.mWarningDialog != null) goto L23;
        if (r12 != 1) goto L16;
        int r3 = R.string.clear_data_dlg_title;
        int r2 = R.string.clear_data_dlg_text;
        int r4 = R.string.clear_cts;
    L20:
        int r7 = r2;
        int r6 = r3;
        int r8 = r4;
    L21:
        showOWarningDialog(r6, r7, r8, R.string.dlg_cancel, new AnonymousClass2(this, r12, r0, r1));
        return;
    L16:
        if (r12 == 2) goto L18;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        goto L21
    L18:
        r3 = R.string.clear_failed_dlg_title;
        r2 = R.string.clear_failed_dlg_text;
        r4 = R.string.dlg_ok;
        goto L20
    }

    private void showOWarningDialog(int r3, int r4, int r5, int r6, DialogInterface.OnClickListener r7) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "showOWarningDialog, activity is null, return");
        return;
    L6:
        OAlertDialog r8 = new OAlertDialogBuilder(r0).autoDismiss(false).horizontalButton(true).title(r3).message(r4).forceHideFirstFrame().positiveButton(r5, r7).negativeButton(r6, new AnonymousClass3(this)).build();
        this.mWarningDialog = r8;
        if (r8.isShowing() == true) goto L10;
        this.mWarningDialog.show();
        return;
    }

    private void initiateClearUserData() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        setButtonState(this.mClearDataButton, R.color.oui_basic_text_4, false);
        OLog.i(this.TAG, "Clearing user data for package : " + this.mPackageName);
        if (this.mClearDataObserver != null) goto L8;
        this.mClearDataObserver = new ClearUserDataObserver(this);
    L8:
        ApplicationsState.AppEntry r1 = this.mAppEntry;
        if (r1 != null) goto L11;
    L23:
    L20:
        e = move-exception;
        OLog.e(this.TAG, "clearApplicationUserData error: " + e);
        return;
    L16:
        if (ActivityManagerNative.getDefault().clearApplicationUserData(this.mPackageName, false, this.mClearDataObserver, UserHandle.getUserId(this.mAppUid)) == true) goto L18;
        OLog.i(this.TAG, "Couldnt clear application user data for package:" + this.mPackageName);     // Catch: RemoteException -> L20
        showWarningDialog(2);     // Catch: RemoteException -> L20
        return;
    L18:
        setButtonText(this.mClearDataButton, R.string.recompute_size);     // Catch: RemoteException -> L20
        return;
    L11:
        if (PACKAGE_SCREENRECORDER.equals(r1.info.packageName) == false) goto L23;
        if (Utils.isAppRunning(this.mContext, PACKAGE_SCREENRECORDER) == false) goto L23;
        Settings.Global.putInt(this.mContext.getContentResolver(), TNT_SCREEN_RECORDER_SHOW_STATUS, 0);
        Settings.Global.putInt(this.mContext.getContentResolver(), MOBILE_SCREEN_RECORDER_SHOW_STATUS, 0);
        Settings.Global.putInt(this.mContext.getContentResolver(), "screen_recorder_status", 0);
        Settings.System.putInt(this.mContext.getContentResolver(), "show_touches", 0);
        goto L23
    }

    private void processClearMsg(Message r4) {
        int r5 = r4.arg1;
        setButtonText(this.mClearDataButton, R.string.clear_user_data_text);
        if (r5 != 1) goto L18;
        ApplicationsState.AppEntry r6 = this.mAppEntry;
        if (r6 == null) goto L7;
        String r7 = r6.info.packageName;
    L8:
        OLog.i(this.TAG, "Cleared user data for package : " + r7);
        ApplicationsState.AppEntry r0 = this.mAppEntry;
        if (r0 == null) goto L12;
        this.mState.requestSizeByUserId(r0.info);
    L12:
        if (PACKAGE_SCREENRECORDER.equals(r7) == true) goto L14;
        return;
    L14:
        if (this.mIsExtDisplaying == false) goto L16;
        Settings.Global.putInt(this.mContext.getContentResolver(), TNT_SCREEN_RECORDER_SHOW_STATUS, 0);
    L17:
        Settings.Global.putInt(this.mContext.getContentResolver(), "screen_recorder_status", 0);
        return;
    L16:
        Settings.Global.putInt(this.mContext.getContentResolver(), MOBILE_SCREEN_RECORDER_SHOW_STATUS, 0);
        goto L17
    L7:
        r7 = "";
        goto L8
    L18:
        setButtonState(this.mClearDataButton, R.color.oui_functional_red_6, true);
    }

    @Override // com.android.settings.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
        refreshUi();
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

    private boolean isWorkProfile() {
        if (this.mAppUid != (-1)) goto L10;
        return false;
    L10:
        return ((UserManager) SettingsApplication.getContext().getSystemService(PickApplicationActivity.EXTRA_USER)).isManagedProfile(UserHandle.getUserId(this.mAppUid));
    L7:
        e = move-exception;
        OLog.e(this.TAG, "isWorkProfile fail", e);
        return false;
    }

    public void com_android_settings_applications_AppStorageDetailFragment__onResume$___twin___() {
        super.onResume();
        if (this.firstInit == false) goto L5;
        this.firstInit = false;
    L7:
        if (isWorkProfile() == false) goto L9;
        this.mUserId = UserHandle.getUserId(this.mAppUid);
        this.mAppsControlDisallowedAdmin = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(getActivity(), "no_control_apps", this.mUserId);
        this.mAppsControlDisallowedBySystem = RestrictedLockUtilsInternal.hasBaseUserRestriction(getActivity(), "no_control_apps", this.mUserId);
        return;
    L9:
        this.mUserId = UserHandle.myUserId();
        this.mAppsControlDisallowedAdmin = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(getActivity(), "no_control_apps", UserHandle.myUserId());
        this.mAppsControlDisallowedBySystem = RestrictedLockUtilsInternal.hasBaseUserRestriction(getActivity(), "no_control_apps", UserHandle.myUserId());
        return;
    L5:
        resumeAndUpdate();
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSession.pause();
        this.mDataCleared = false;
        this.mCacheCleared = false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_AppStorageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppStorageDetailFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AppStorageDetailFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AppStorageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppStorageDetailFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_AppStorageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AppStorageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppStorageDetailFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AppStorageDetailFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
