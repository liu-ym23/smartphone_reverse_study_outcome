package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AppGlobals;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.IPackageDataObserver;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.MutableInt;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.deviceinfo.StorageWizardMoveConfirm;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppStorageSettings extends AppInfoWithHeader implements View.OnClickListener, com.android.settingslib.applications.ApplicationsState.Callbacks, DialogInterface.OnClickListener {
    private static final int DLG_CANNOT_CLEAR_DATA = 2;
    private static final int DLG_CLEAR_DATA = 1;
    private static final String KEY_APP_SIZE = "app_size";
    private static final String KEY_CACHE_SIZE = "cache_size";
    private static final String KEY_CHANGE_STORAGE = "change_storage_button";
    private static final String KEY_CLEAR_CACHE = "clear_cache_button";
    private static final String KEY_CLEAR_DATA = "clear_data_button";
    private static final String KEY_CLEAR_URI = "clear_uri_button";
    private static final String KEY_DATA_SIZE = "data_size";
    private static final String KEY_EXTERNAL_CODE_SIZE = "external_code_size";
    private static final String KEY_EXTERNAL_DATA_SIZE = "external_data_size";
    private static final String KEY_STORAGE_CATEGORY = "storage_category";
    private static final String KEY_STORAGE_SPACE = "storage_space";
    private static final String KEY_STORAGE_USED = "storage_used";
    private static final String KEY_TOTAL_SIZE = "total_size";
    private static final String KEY_URI_CATEGORY = "uri_category";
    private static final int MSG_CLEAR_CACHE = 3;
    private static final int MSG_CLEAR_USER_DATA = 1;
    private static final int OP_FAILED = 2;
    private static final int OP_SUCCESSFUL = 1;
    public static final int REQUEST_MANAGE_SPACE = 2;
    private static final int SIZE_INVALID = -1;
    private static final String TAG = "AppStorageSettings";
    private Preference mAppSize;
    private Preference mCacheSize;
    private boolean mCanClearData;
    private VolumeInfo[] mCandidates;
    private Button mChangeStorageButton;
    private Button mClearCacheButton;
    private ClearCacheObserver mClearCacheObserver;
    private Button mClearDataButton;
    private ClearUserDataObserver mClearDataObserver;
    private LayoutPreference mClearUri;
    private Button mClearUriButton;
    private CharSequence mComputingStr;
    private Preference mDataSize;
    private AlertDialog.Builder mDialogBuilder;
    private Preference mExternalCodeSize;
    private Preference mExternalDataSize;
    private final Handler mHandler;
    private boolean mHaveSizes;
    private CharSequence mInvalidSizeStr;
    private long mLastCacheSize;
    private long mLastCodeSize;
    private long mLastDataSize;
    private long mLastExternalCodeSize;
    private long mLastExternalDataSize;
    private long mLastTotalSize;
    private Preference mStorageUsed;
    private Preference mTotalSize;
    private PreferenceCategory mUri;

    class ClearCacheObserver extends IPackageDataObserver.Stub {
        final /* synthetic */ AppStorageSettings this$0;

        ClearCacheObserver(AppStorageSettings r1) {
            this.this$0 = r1;
        }

        public void onRemoveCompleted(String r2, boolean r3) {
            Message r4 = AppStorageSettings.access$300(this.this$0).obtainMessage(3);
            if (r3 == false) goto L5;
            int r5 = 1;
        L6:
            r4.arg1 = r5;
            AppStorageSettings.access$300(this.this$0).sendMessage(r4);
            return;
        L5:
            r5 = 2;
            goto L6
        }
    }

    class ClearUserDataObserver extends IPackageDataObserver.Stub {
        final /* synthetic */ AppStorageSettings this$0;

        ClearUserDataObserver(AppStorageSettings r1) {
            this.this$0 = r1;
        }

        public void onRemoveCompleted(String r2, boolean r3) {
            int r0 = 1;
            Message r4 = AppStorageSettings.access$300(this.this$0).obtainMessage(1);
            if (r3 == true) goto L6;
            r0 = 2;
        L6:
            r4.arg1 = r0;
            AppStorageSettings.access$300(this.this$0).sendMessage(r4);
        }
    }

    static {
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_AppStorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_AppStorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppStorageSettings() {
        this.mCanClearData = true;
        this.mHaveSizes = false;
        this.mLastCodeSize = -1;
        this.mLastDataSize = -1;
        this.mLastExternalCodeSize = -1;
        this.mLastExternalDataSize = -1;
        this.mLastCacheSize = -1;
        this.mLastTotalSize = -1;
        this.mHandler = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(AppStorageSettings r0) {
        r0.initiateClearUserData();
    }

    static /* synthetic */ Button access$100(AppStorageSettings r0) {
        return r0.mClearDataButton;
    }

    static /* synthetic */ void access$200(AppStorageSettings r0, Message r1) {
        r0.processClearMsg(r1);
    }

    static /* synthetic */ Handler access$300(AppStorageSettings r0) {
        return r0.mHandler;
    }

    public void com_android_settings_applications_AppStorageSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        addPreferencesFromResource(R.xml.app_storage_settings);
        setupViews();
        initMoveDialog();
    }

    public void com_android_settings_applications_AppStorageSettings__onResume$___twin___() {
        super.onResume();
        this.mState.requestSize(this.mPackageName, this.mUserId);
    }

    private void setupViews() {
        this.mComputingStr = getActivity().getText(R.string.computing_size);
        this.mInvalidSizeStr = getActivity().getText(R.string.invalid_size_value);
        this.mTotalSize = findPreference(KEY_TOTAL_SIZE);
        this.mAppSize = findPreference(KEY_APP_SIZE);
        this.mDataSize = findPreference(KEY_DATA_SIZE);
        this.mExternalCodeSize = findPreference(KEY_EXTERNAL_CODE_SIZE);
        this.mExternalDataSize = findPreference(KEY_EXTERNAL_DATA_SIZE);
        if (Environment.isExternalStorageEmulated() == false) goto L5;
        PreferenceCategory r0 = (PreferenceCategory) findPreference(KEY_STORAGE_CATEGORY);
        r0.removePreference(this.mExternalCodeSize);
        r0.removePreference(this.mExternalDataSize);
    L5:
        this.mClearDataButton = (Button) ((LayoutPreference) findPreference(KEY_CLEAR_DATA)).findViewById(R.id.button);
        this.mStorageUsed = findPreference(KEY_STORAGE_USED);
        Button r1 = (Button) ((LayoutPreference) findPreference(KEY_CHANGE_STORAGE)).findViewById(R.id.button);
        this.mChangeStorageButton = r1;
        r1.setText(R.string.change);
        this.mChangeStorageButton.setOnClickListener(this);
        this.mCacheSize = findPreference(KEY_CACHE_SIZE);
        Button r2 = (Button) ((LayoutPreference) findPreference(KEY_CLEAR_CACHE)).findViewById(R.id.button);
        this.mClearCacheButton = r2;
        r2.setText(R.string.clear_cache_btn_text);
        PreferenceCategory r3 = (PreferenceCategory) findPreference(KEY_URI_CATEGORY);
        this.mUri = r3;
        LayoutPreference r4 = (LayoutPreference) r3.findPreference(KEY_CLEAR_URI);
        this.mClearUri = r4;
        Button r5 = (Button) r4.findViewById(R.id.button);
        this.mClearUriButton = r5;
        r5.setText(R.string.clear_uri_btn_text);
        this.mClearUriButton.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mClearCacheButton) goto L15;
        if (this.mAppsControlDisallowedAdmin == null) goto L11;
        if (this.mAppsControlDisallowedBySystem == true) goto L11;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), this.mAppsControlDisallowedAdmin);
        return;
    L11:
        if (this.mClearCacheObserver != null) goto L13;
        this.mClearCacheObserver = new ClearCacheObserver(this);
    L13:
        this.mPm.deleteApplicationCacheFiles(this.mPackageName, this.mClearCacheObserver);
        return;
    L15:
        if (r3 != this.mClearDataButton) goto L28;
        if (this.mAppsControlDisallowedAdmin == null) goto L22;
        if (this.mAppsControlDisallowedBySystem == true) goto L22;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), this.mAppsControlDisallowedAdmin);
        return;
    L22:
        if (this.mAppEntry.info.manageSpaceActivityName != null) goto L24;
        showDialogInner(1, 0);
        return;
    L24:
        if (Utils.isMonkeyRunning() == true) goto L45;
        Intent r4 = new Intent("android.intent.action.VIEW");
        r4.setClassName(this.mAppEntry.info.packageName, this.mAppEntry.info.manageSpaceActivityName);
        startActivityForResult(r4, 2);
        return;
    L45:
        return;
    L28:
        if (r3 != this.mChangeStorageButton) goto L35;
        if (this.mDialogBuilder == null) goto L35;
        if (isMoveInProgress() == true) goto L35;
        this.mDialogBuilder.show();
        return;
    L35:
        if (r3 == this.mClearUriButton) goto L37;
        return;
    L37:
        if (this.mAppsControlDisallowedAdmin != null) goto L39;
    L41:
        clearUriPermissions();
        return;
    L39:
        if (this.mAppsControlDisallowedBySystem == true) goto L41;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), this.mAppsControlDisallowedAdmin);
    }

    private boolean isMoveInProgress() {
        AppGlobals.getPackageManager().checkPackageStartable(this.mPackageName, UserHandle.myUserId());     // Catch: Throwable -> L5
        return false;
    L5:
        return true;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r4, int r5) {
        FragmentActivity r0 = getActivity();
        VolumeInfo r6 = this.mCandidates[r5];
        if (Objects.equals(r6, r0.getPackageManager().getPackageCurrentVolume(this.mAppEntry.info)) == true) goto L5;
        Intent r1 = new Intent(r0, StorageWizardMoveConfirm.class);
        r1.putExtra("android.os.storage.extra.VOLUME_ID", r6.getId());
        r1.putExtra("android.intent.extra.PACKAGE_NAME", this.mAppEntry.info.packageName);
        startActivity(r1);
    L5:
        r4.dismiss();
    }

    private String getSizeStr(long r3) {
        if (r3 != (-1)) goto L7;
        return this.mInvalidSizeStr.toString();
    L7:
        return Formatter.formatFileSize(getActivity(), r3).replace('k', 'K');
    }

    private boolean isCacheClearableApp() {
        String r0 = this.mPackageInfo.packageName;
        String[] r5 = getResources().getStringArray(R.array.no_cache_clear_package_list);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        int r1 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r0.equals(r5[r3]) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private void refreshSizeInfo() {
        if (this.mAppEntry.size != (-2)) goto L5;
    L42:
        this.mLastTotalSize = -1;
        this.mLastCacheSize = -1;
        this.mLastDataSize = -1;
        this.mLastCodeSize = -1;
        if (this.mHaveSizes == true) goto L45;
        this.mAppSize.setSummary(this.mComputingStr);
        this.mDataSize.setSummary(this.mComputingStr);
        this.mCacheSize.setSummary(this.mComputingStr);
        this.mTotalSize.setSummary(this.mComputingStr);
    L45:
        this.mClearDataButton.setEnabled(false);
        this.mClearCacheButton.setEnabled(false);
    L47:
        if (this.mAppsControlDisallowedBySystem == false) goto L50;
        this.mClearCacheButton.setEnabled(false);
        this.mClearDataButton.setEnabled(false);
        return;
    L50:
        return;
    L5:
        if (this.mAppEntry.size == (-1)) goto L42;
        this.mHaveSizes = true;
        long r1 = this.mAppEntry.codeSize;
        long r4 = this.mAppEntry.dataSize;
        if (Environment.isExternalStorageEmulated() == false) goto L11;
        r1 = r1 + this.mAppEntry.externalCodeSize;
        r4 = r4 + this.mAppEntry.externalDataSize;
    L17:
        if (this.mLastCodeSize == r1) goto L20;
        this.mLastCodeSize = r1;
        this.mAppSize.setSummary(getSizeStr(r1));
    L20:
        if (this.mLastDataSize == r4) goto L22;
        this.mLastDataSize = r4;
        this.mDataSize.setSummary(getSizeStr(r4));
    L22:
        long r2 = this.mAppEntry.cacheSize + this.mAppEntry.externalCacheSize;
        if (this.mLastCacheSize == r2) goto L26;
        this.mLastCacheSize = r2;
        this.mCacheSize.setSummary(getSizeStr(r2));
    L26:
        if (this.mLastTotalSize == this.mAppEntry.size) goto L29;
        this.mLastTotalSize = this.mAppEntry.size;
        this.mTotalSize.setSummary(getSizeStr(this.mAppEntry.size));
    L29:
        if ((this.mAppEntry.dataSize + this.mAppEntry.externalDataSize) > 0) goto L31;
    L34:
        this.mClearDataButton.setEnabled(false);
    L36:
        if (r2 > 0) goto L38;
    L41:
        this.mClearCacheButton.setEnabled(false);
        goto L47
    L38:
        if (isCacheClearableApp() == false) goto L41;
        this.mClearCacheButton.setEnabled(true);
        this.mClearCacheButton.setOnClickListener(this);
        goto L47
    L31:
        if (this.mCanClearData == false) goto L34;
        this.mClearDataButton.setEnabled(true);
        this.mClearDataButton.setOnClickListener(this);
        goto L36
    L11:
        if (this.mLastExternalCodeSize == this.mAppEntry.externalCodeSize) goto L14;
        this.mLastExternalCodeSize = this.mAppEntry.externalCodeSize;
        this.mExternalCodeSize.setSummary(getSizeStr(this.mAppEntry.externalCodeSize));
    L14:
        if (this.mLastExternalDataSize == this.mAppEntry.externalDataSize) goto L17;
        this.mLastExternalDataSize = this.mAppEntry.externalDataSize;
        this.mExternalDataSize.setSummary(getSizeStr(this.mAppEntry.externalDataSize));
        goto L17
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        retrieveAppEntry();
        if (this.mAppEntry != null) goto L6;
        return false;
    L6:
        refreshSizeInfo();
        refreshGrantedUriPermissions();
        VolumeInfo r0 = getActivity().getPackageManager().getPackageCurrentVolume(this.mAppEntry.info);
        StorageManager r1 = (StorageManager) getContext().getSystemService(StorageManager.class);
        this.mStorageUsed.setSummary(r1.getBestVolumeDescription(r0));
        refreshButtons();
        return true;
    }

    private void refreshButtons() {
        initMoveDialog();
        initDataButtons();
    }

    private void initDataButtons() {
        if (this.mAppEntry.info.manageSpaceActivityName != null) goto L10;
        if ((this.mAppEntry.info.flags & 65) != 1) goto L7;
    L8:
        this.mClearDataButton.setText(R.string.clear_user_data_text);
        this.mClearDataButton.setEnabled(false);
        this.mCanClearData = false;
    L15:
        if (this.mAppsControlDisallowedBySystem == false) goto L18;
        this.mClearDataButton.setEnabled(false);
        return;
    L18:
        return;
    L7:
        if (this.mDpm.packageHasActiveAdmins(this.mPackageName) == true) goto L8;
    L10:
        if (this.mAppEntry.info.manageSpaceActivityName == null) goto L12;
        this.mClearDataButton.setText(R.string.manage_space_text);
    L13:
        this.mClearDataButton.setOnClickListener(this);
        goto L15
    L12:
        this.mClearDataButton.setText(R.string.clear_user_data_text);
        goto L13
    }

    private void initMoveDialog() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        StorageManager r1 = (StorageManager) r0.getSystemService(StorageManager.class);
        if (r1 != null) goto L8;
        return;
    L8:
        PackageManager r2 = r0.getPackageManager();
        if (r2 != null) goto L11;
        return;
    L11:
        List r3 = r2.getPackageCandidateVolumes(this.mAppEntry.info);
        if (r3 != null) goto L14;
    L23:
        removePreference(KEY_STORAGE_USED);
        removePreference(KEY_CHANGE_STORAGE);
        removePreference(KEY_STORAGE_SPACE);
        return;
    L14:
        if (r3.size() <= 1) goto L23;
        Collections.sort(r3, VolumeInfo.getDescriptionComparator());
        CharSequence[] r4 = new CharSequence[r3.size()];
        int r5 = -1;
        int r6 = 0;
    L17:
        if (r6 >= r3.size()) goto L22;
        String r7 = r1.getBestVolumeDescription((VolumeInfo) r3.get(r6));
        if (Objects.equals(r7, this.mStorageUsed.getSummary()) == false) goto L21;
        r5 = r6;
    L21:
        r4[r6] = r7;
        r6 = r6 + 1;
        goto L17
    L22:
        this.mCandidates = (VolumeInfo[]) r3.toArray(new VolumeInfo[r3.size()]);
        this.mDialogBuilder = new AlertDialog.Builder(getContext()).setTitle(R.string.change_storage).setSingleChoiceItems(r4, r5, this).setNegativeButton(R.string.cancel, null);
    }

    private void initiateClearUserData() {
        this.mClearDataButton.setEnabled(false);
        String r0 = this.mAppEntry.info.packageName;
        String r2 = TAG;
        OLog.i(r2, "Clearing user data for package : " + r0);
        if (this.mClearDataObserver != null) goto L5;
        this.mClearDataObserver = new ClearUserDataObserver(this);
    L5:
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L8;
        return;
    L8:
        ActivityManager r4 = (ActivityManager) r3.getSystemService("activity");
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.clearApplicationUserData(r0, this.mClearDataObserver) == true) goto L14;
        OLog.i(r2, "Couldnt clear application user data for package:" + r0);
        showDialogInner(2, 0);
        return;
    L14:
        this.mClearDataButton.setText(R.string.recompute_size);
    }

    private void processClearMsg(Message r4) {
        int r5 = r4.arg1;
        String r0 = this.mAppEntry.info.packageName;
        this.mClearDataButton.setText(R.string.clear_user_data_text);
        if (r5 != 1) goto L5;
        OLog.i(TAG, "Cleared user data for package : " + r0);
        this.mState.requestSize(this.mPackageName, this.mUserId);
        return;
    L5:
        this.mClearDataButton.setEnabled(true);
    }

    private void refreshGrantedUriPermissions() {
        removeUriPermissionsFromUi();
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");
        if (r1 != null) goto L8;
        return;
    L8:
        List<MultiSDKAdapter.UriPermissionCompat> r2 = MultiSDKAdapter.getGrantedUriPermissionsCompat(r1, this.mAppEntry.info.packageName);
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.isEmpty() == false) goto L15;
        this.mClearUriButton.setVisibility(8);
        return;
    L15:
        PackageManager r3 = getActivity().getPackageManager();
        if (r3 != null) goto L18;
        return;
    L18:
        TreeMap r4 = new TreeMap();
        Iterator<MultiSDKAdapter.UriPermissionCompat> r5 = r2.iterator();
    L20:
        if (r5.hasNext() == false) goto L31;
        Uri r6 = r5.next().getUri();
        if (r6 == null) goto L20;
        ProviderInfo r7 = r3.resolveContentProvider(r6.getAuthority(), 0);
        if (r7 == null) goto L26;
        CharSequence r8 = r7.applicationInfo.loadLabel(r3);
        MutableInt r9 = (MutableInt) r4.get(r8);
        if (r9 == null) goto L29;
        r9.value++;
        goto L20
    L29:
        r4.put(r8, new MutableInt(1));
        goto L20
    L26:
        return;
    L31:
        Iterator r10 = r4.entrySet().iterator();
    L33:
        if (r10.hasNext() == false) goto L36;
        Map.Entry r11 = (Map.Entry) r10.next();
        int r12 = ((MutableInt) r11.getValue()).value;
        Preference r13 = new Preference(getPrefContext());
        r13.setTitle((CharSequence) r11.getKey());
        r13.setSummary(getPrefContext().getResources().getQuantityString(R.plurals.uri_permissions_text, r12, new Object[]{Integer.valueOf(r12)}));
        r13.setSelectable(false);
        r13.setLayoutResource(R.layout.horizontal_preference);
        r13.setOrder(0);
        OLog.v(TAG, "Adding preference '" + r13 + "' at order 0");
        this.mUri.addPreference(r13);
        goto L33
    L36:
        if (this.mAppsControlDisallowedBySystem == false) goto L38;
        this.mClearUriButton.setEnabled(false);
    L38:
        this.mClearUri.setOrder(0);
        this.mClearUriButton.setVisibility(0);
    }

    private void clearUriPermissions() {
        ((ActivityManager) getActivity().getSystemService("activity")).clearGrantedUriPermissions(this.mAppEntry.info.packageName);
        refreshGrantedUriPermissions();
    }

    private void removeUriPermissionsFromUi() {
        int r0 = this.mUri.getPreferenceCount() - 1;
    L3:
        if (r0 < 0) goto L8;
        Preference r1 = this.mUri.getPreference(r0);
        if (r1 == this.mClearUri) goto L7;
        this.mUri.removePreference(r1);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r4, int r5) {
        if (r4 == 1) goto L10;
        if (r4 == 2) goto L8;
        return null;
    L8:
        return new AlertDialog.Builder(getActivity()).setTitle(getActivity().getText(R.string.clear_failed_dlg_title)).setMessage(getActivity().getText(R.string.clear_failed_dlg_text)).setNeutralButton(R.string.dlg_ok, new AnonymousClass2(this)).create();
    L10:
        return new AlertDialog.Builder(getActivity()).setTitle(getActivity().getText(R.string.clear_data_dlg_title)).setMessage(getActivity().getText(R.string.clear_data_dlg_text)).setPositiveButton(R.string.dlg_ok, new AnonymousClass1(this)).setNegativeButton(R.string.dlg_cancel, null).create();
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r2) {
        if (this.mAppEntry != null) goto L5;
        return;
    L5:
        if (this.mAppEntry.info != null) goto L8;
        return;
    L8:
        if (r2.equals(this.mAppEntry.info.packageName) == false) goto L12;
        refreshSizeInfo();
        return;
    }

    public static CharSequence getSummary(com.android.settingslib.applications.ApplicationsState.AppEntry r4, Context r5) {
        if (r4.size == (-2)) goto L14;
        if (r4.size == (-1)) goto L14;
        if ((r4.info.flags & 262144) == 0) goto L10;
        int r0 = R.string.storage_type_external;
    L12:
        return r5.getString(R.string.storage_summary_format, new Object[]{getSize(r4, r5), r5.getString(r0)});
    L10:
        r0 = R.string.storage_type_internal;
    L14:
        return r5.getText(R.string.computing_size);
    }

    private static CharSequence getSize(com.android.settingslib.applications.ApplicationsState.AppEntry r4, Context r5) {
        long r0 = r4.size;
        if (r0 != (-1)) goto L7;
        return r5.getText(R.string.invalid_size_value);
    L7:
        return Formatter.formatFileSize(r5, r0).replace('k', 'K');
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_AppStorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppStorageSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AppStorageSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AppStorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppStorageSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_AppStorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AppStorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppStorageSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AppStorageSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
