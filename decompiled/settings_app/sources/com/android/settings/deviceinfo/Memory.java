package com.android.settings.deviceinfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.IPackageDataObserver;
import android.database.ContentObserver;
import android.hardware.usb.UsbManager;
import android.icu.text.PluralRules;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.storage.DiskInfo;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sremlib.LibUtil;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class Memory extends BaseFragment {
    private static final String BIG_FILE_SCANNING_STATE = "BigFileScanningState";
    private static final int BIG_FILE_SCAN_DONE = 1;
    private static final int DLG_CONFIRM_UNMOUNT = 1;
    private static final int DLG_ERROR_UNMOUNT = 2;
    private static final int ERASE_EXTERNAL_STORAGE = 2;
    private static final int INSTALL_EXTERNAL_STORAGE = 0;
    private static final String TAG = "MemorySettings";
    private static final String TAG_CONFIRM_CLEAR_CACHE = "confirmClearCache";
    private static String sClickedMountPoint = null;
    private static Preference sLastClickedMountToggle = null;
    private static final int unmount_external_storage = 1;
    private ContentObserver mBigFileScanObserver;
    private View mBigFileScanProgressBar;
    private SettingItemText mBigFilesCleanUp;
    private ArrayList<StorageVolumeView> mCategories;
    private final View.OnClickListener mClickListener;
    private ContentResolver mContentResolver;
    private View mExternalStorage;
    private View mInstallStorage;
    private View mInstallStorageContent;
    private TextView mInstallStorageTips;
    private View mPortableStorage;
    private LinearLayout mSandiskContent;
    private ScrollView mScrollView;
    private View mSdManageDetail;
    private final StorageEventListener mStorageListener;
    private StorageManager mStorageManager;
    private StorageVolume mStorageVolume;
    private int mTitleRes;
    private UsbManager mUsbManager;
    private VolumeInfo mVolume;

    private static class ClearCacheObserver extends IPackageDataObserver.Stub {
        private int mRemaining;
        private final Memory mTarget;

        public ClearCacheObserver(Memory r1, int r2) {
            this.mTarget = r1;
            this.mRemaining = r2;
        }

        public void onRemoveCompleted(String r1, boolean r2) {
            monitor-enter(this);
            int r3 = this.mRemaining - 1;     // Catch: Throwable -> L8
            this.mRemaining = r3;     // Catch: Throwable -> L8
            if (r3 != 0) goto L6;
            Memory.access$800(this.mTarget);     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static class ConfirmClearCacheFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ConfirmClearCacheFragment() {
        }

        public static void show(Memory r2) {
            if (r2.isAdded() == true) goto L5;
            return;
        L5:
            ConfirmClearCacheFragment r0 = new ConfirmClearCacheFragment();
            r0.setTargetFragment(r2, 0);
            r0.show(r2.getParentFragmentManager(), Memory.TAG_CONFIRM_CLEAR_CACHE);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            final FragmentActivity r4 = getActivity();
            AlertDialog.Builder r0 = new AlertDialog.Builder(r4);
            r0.setTitle(R.string.memory_clear_cache_title);
            r0.setMessage(getString(R.string.memory_clear_cache_message));
            r0.setPositiveButton(android.R.string.ok, new AnonymousClass1(this, r4));
            r0.setNegativeButton(android.R.string.cancel, null);
            return r0.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmClearCacheFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmClearCacheFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmClearCacheFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_Memory$ConfirmClearCacheFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    private class MountTask extends AsyncTask<Void, Void, Exception> {
        final /* synthetic */ Memory this$0;

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Exception r1) {
        }

        private MountTask(Memory r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MountTask(Memory r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Exception doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Exception r1) {
            onPostExecute2(r1);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Memory.access$900(this.this$0).setEnabled(false);
            Memory.access$1000(this.this$0).setText(R.string.installing_external_storage_tips);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Exception doInBackground2(Void... r5) {
            Iterator r6 = Memory.access$700(this.this$0).getVolumes().iterator();     // Catch: Exception -> L11
        L4:
            if (r6.hasNext() == false) goto L9;
            VolumeInfo r0 = (VolumeInfo) r6.next();     // Catch: Exception -> L11
            if (StorageUtils.isValidSdVolume(r0) == false) goto L4;
            OLog.d(Memory.TAG, "mount vol id " + r0.id);     // Catch: Exception -> L11
            Memory.access$700(this.this$0).mount(r0.id);     // Catch: Exception -> L11
            goto L4
        L9:
            return null;
        L11:
            e = move-exception;
            return e;
        }
    }

    public void com_android_settings_deviceinfo_Memory__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_Memory_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_deviceinfo_Memory_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public Memory() {
        final Handler r1 = new Handler();
        this.mBigFileScanObserver = new AnonymousClass1(this, r1);
        this.mTitleRes = R.string.advanced_item_storate;
        this.mCategories = Lists.newArrayList();
        this.mClickListener = new AnonymousClass3(this);
        this.mStorageListener = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(Memory r0) {
        r0.setBigFileScanProgress();
    }

    static /* synthetic */ ScrollView access$100(Memory r0) {
        return r0.mScrollView;
    }

    static /* synthetic */ TextView access$1000(Memory r0) {
        return r0.mInstallStorageTips;
    }

    static /* synthetic */ String access$1100(Memory r0, File r1) {
        return r0.getStorageUsageInfo(r1);
    }

    static /* synthetic */ int access$300(Memory r0) {
        return r0.mTitleRes;
    }

    static /* synthetic */ ArrayList access$400(Memory r0) {
        return r0.mCategories;
    }

    static /* synthetic */ VolumeInfo access$502(Memory r0, VolumeInfo r1) {
        r0.mVolume = r1;
        return r1;
    }

    static /* synthetic */ void access$600(Memory r0, VolumeInfo r1) {
        r0.onPublicVolumeStateChangedInternal(r1);
    }

    static /* synthetic */ StorageManager access$700(Memory r0) {
        return r0.mStorageManager;
    }

    static /* synthetic */ void access$800(Memory r0) {
        r0.onCacheCleared();
    }

    static /* synthetic */ View access$900(Memory r0) {
        return r0.mInstallStorage;
    }

    public void com_android_settings_deviceinfo_Memory__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        ContentResolver r5 = this.mContext.getContentResolver();
        this.mContentResolver = r5;
        r5.registerContentObserver(Settings.System.getUriFor(BIG_FILE_SCANNING_STATE), false, this.mBigFileScanObserver);
        this.mUsbManager = (UsbManager) getActivity().getSystemService("usb");
        StorageManager r6 = StorageManager.from(this.mContext);
        this.mStorageManager = r6;
        r6.registerListener(this.mStorageListener);
        preloadSecurityProcess();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.memory_manage_layout, r3, false);
        this.mScrollView = (ScrollView) this.mRootView.findViewById(R.id.scroll_view);
        SettingItemText r5 = (SettingItemText) this.mRootView.findViewById(R.id.big_files_cleanup);
        this.mBigFilesCleanUp = r5;
        r5.setOnClickListener(this.mClickListener);
        this.mBigFileScanProgressBar = r2.inflate(R.layout.progress_white_small_layout, this.mBigFilesCleanUp, false);
        addCategory((StorageVolumeView) this.mRootView.findViewById(R.id.ll_content));
        setBigFileScanProgress();
        this.mRootView.findViewById(R.id.app_management).setOnClickListener(this.mClickListener);
        this.mRootView.findViewById(R.id.junk_files_cleanup).setOnClickListener(this.mClickListener);
        this.mExternalStorage = this.mRootView.findViewById(R.id.external_storage);
        this.mInstallStorageContent = this.mRootView.findViewById(R.id.install_external_storage_context);
        this.mInstallStorage = this.mRootView.findViewById(R.id.install_external_storage);
        this.mInstallStorageTips = (TextView) this.mRootView.findViewById(R.id.install_external_storage_tips);
        this.mInstallStorage.setOnClickListener(this.mClickListener);
        View r6 = this.mRootView.findViewById(R.id.sd_manage);
        this.mSdManageDetail = r6;
        ((TextView) r6.findViewById(R.id.title)).setText(R.string.sd_manage);
        this.mSdManageDetail.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
        this.mSdManageDetail.setOnClickListener(this.mClickListener);
        this.mPortableStorage = this.mRootView.findViewById(R.id.portable_storage_layout);
        this.mSandiskContent = (LinearLayout) this.mRootView.findViewById(R.id.sandisk_content);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        this.mCategories.get(0).initView();
        String r4 = getActivity().getIntent().getStringExtra("view_name");
        final View r5 = Utils.findViewByName(getContext(), getView(), r4);
        if (r5 == null) goto L6;
        this.mScrollView.post(new AnonymousClass2(this, r5));
        return;
    }

    private void preloadSecurityProcess() {
        new Intent("com.bytedanceos.settings.FAKE_SERVICE").setPackage(Constants.PKG_SECURITY);
    }

    private void setBigFileScanProgress() {
        if (this.mBigFilesCleanUp != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (Settings.System.getInt(this.mContentResolver, BIG_FILE_SCANNING_STATE, 1) == 1) goto L9;
        r2 = false;
    L9:
        SettingItemText r0 = this.mBigFilesCleanUp;
        if (r2 == false) goto L12;
        View r3 = null;
    L13:
        r0.setRightExpandView(r3);
        return;
    L12:
        r3 = this.mBigFileScanProgressBar;
        goto L13
    }

    private void addCategory(StorageVolumeView r1) {
        this.mCategories.add(r1);
    }

    private boolean isMassStorageEnabled() {
        StorageVolume r0 = StorageManager.getPrimaryVolume(this.mStorageManager.getVolumeList());
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.allowMassStorage() == false) goto L7;
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void updateViews() {
        boolean r1 = false;
        if (SettingsFeature.isSupportSd() == false) goto L5;
        this.mExternalStorage.setVisibility(0);
        this.mInstallStorageContent.setVisibility(0);
        this.mInstallStorage.setEnabled(false);
    L6:
        Iterator r0 = this.mStorageManager.getVolumes().iterator();
    L8:
        if (r0.hasNext() == false) goto L20;
        VolumeInfo r2 = (VolumeInfo) r0.next();
        if (r2 == null) goto L8;
        if (r2.getType() != 0) goto L8;
        if (r2.getDisk() == null) goto L19;
        if (r2.getDisk().isSd() == false) goto L19;
        if (r1 == true) goto L8;
        this.mVolume = r2;
        r1 = true;
    L19:
        onPublicVolumeStateChangedInternal(r2);
        goto L8
    L20:
        Iterator<StorageVolumeView> r4 = this.mCategories.iterator();
    L22:
        if (r4.hasNext() == false) goto L24;
        r4.next().onResume();
        goto L22
    L24:
        return;
    L5:
        this.mExternalStorage.setVisibility(8);
        goto L6
    }

    public int getSdVolumeIndexById(String r4) {
        Iterator r3 = this.mStorageManager.getVolumes().iterator();
        int r0 = -1;
    L4:
        if (r3.hasNext() == false) goto L11;
        VolumeInfo r1 = (VolumeInfo) r3.next();
        if (r1.getDisk() == null) goto L4;
        if (r1.getDisk().isSd() == false) goto L4;
        r0 = r0 + 1;
        if (Objects.equals(r1.id, r4) == false) goto L4;
    L11:
        return r0;
    }

    public int getUsbVolumeIndexById(String r4) {
        Iterator r3 = this.mStorageManager.getVolumes().iterator();
        int r0 = -1;
    L4:
        if (r3.hasNext() == false) goto L11;
        VolumeInfo r1 = (VolumeInfo) r3.next();
        if (r1.getDisk() == null) goto L4;
        if (r1.getDisk().isUsb() == false) goto L4;
        r0 = r0 + 1;
        if (Objects.equals(r1.id, r4) == false) goto L4;
    L11:
        return r0;
    }

    private void onPublicVolumeStateChangedInternal(VolumeInfo r7) {
        DiskInfo r0 = r7.getDisk();
        if (r0.isUsb() == false) goto L6;
        boolean r1 = true;
        boolean r2 = false;
    L9:
        int r4 = r7.getState();
        if (r4 != 0) goto L12;
        if (r1 == false) goto L31;
        updateSandiskView(r7, 8);
        return;
    L31:
        if (r2 == false) goto L41;
        this.mSdManageDetail.setVisibility(8);
        this.mExternalStorage.setVisibility(0);
        this.mInstallStorageContent.setVisibility(0);
        this.mInstallStorage.setEnabled(true);
        this.mInstallStorageTips.setText(R.string.click_install_external_storage_tips);
        return;
    L41:
        return;
    L12:
        if (r4 != 2) goto L14;
    L25:
        if (r1 == false) goto L27;
        updateSandiskView(r7, 0);
        return;
    L27:
        if (r2 == false) goto L38;
        updateSdMangeView(r7);
        return;
    L38:
        return;
    L14:
        if (r4 == 3) goto L25;
        if (r4 != 6) goto L18;
    L21:
        if (r1 == false) goto L23;
        updateSandiskView(r7, 8);
        return;
    L23:
        if (r2 == false) goto L35;
        this.mInstallStorage.setEnabled(false);
        this.mInstallStorageContent.setVisibility(0);
        this.mSdManageDetail.setVisibility(8);
        this.mInstallStorageTips.setText(R.string.install_external_storage_tips);
        return;
    L35:
        return;
    L18:
        if (r4 == 7) goto L21;
        if (r4 == 8) goto L21;
        return;
    L6:
        if (r0.isSd() == false) goto L8;
        r2 = true;
        r1 = false;
        goto L9
    L8:
        r1 = false;
        r2 = false;
        goto L9
    }

    private void updateSdMangeView(VolumeInfo r3) {
        this.mInstallStorageContent.setVisibility(8);
        this.mSdManageDetail.setVisibility(0);
        updateStorageUsageViewAsync((TextView) this.mSdManageDetail.findViewById(R.id.storage_info), r3.getPath());
    }

    private String getStorageUsageInfo(File r8) {
        String r0 = "0.00B";
        if (r8 != null) goto L5;
    L13:
        String r9 = "0.00B";
    L15:
        return this.mContext.getString(R.string.sd_memory_init_size, new Object[]{r0, r9});
    L5:
        if (r8.exists() == false) goto L13;
        long r1 = Utils.getTotalSize(r8);
        long r3 = Utils.getAvailableSize(r8);
        if (r1 <= 0) goto L9;
        r9 = Utils.formatSize(this.mContext, r1);
    L11:
        if (r3 <= 0) goto L15;
        r0 = Utils.formatSize(this.mContext, r3);
        goto L15
    L9:
        r9 = "0.00B";
        goto L11
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Iterator<StorageVolumeView> r1 = this.mCategories.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onPause();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        trackStorageInfo();
        StorageManager r0 = this.mStorageManager;
        if (r0 == null) goto L7;
        StorageEventListener r1 = this.mStorageListener;
        if (r1 == null) goto L7;
        r0.unregisterListener(r1);
    L7:
        ContentResolver r2 = this.mContentResolver;
        if (r2 == null) goto L12;
        ContentObserver r3 = this.mBigFileScanObserver;
        if (r3 == null) goto L12;
        r2.unregisterContentObserver(r3);
    L12:
        super.onDestroy();
    }

    private void trackStorageInfo() {
        ArrayList<StorageVolumeView> r0 = this.mCategories;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L13;
        StorageVolumeView.StorageSizeInfo r1 = this.mCategories.get(0).getStorageSizeInfo();
        if (r1 != null) goto L10;
        return;
    L10:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("all_rom", Double.valueOf(bytesToGB(r1.mTotalSize)));
        r2.put("pic_video", Double.valueOf(bytesToGB(r1.mPicSize)));
        r2.put("available_rom", Double.valueOf(bytesToGB(r1.mAvailableSize)));
        r2.put(LibUtil.EXCEPTION_APPLICATION, Double.valueOf(bytesToGB(r1.mAppSize)));
        r2.put("download", Double.valueOf(bytesToGB(r1.mDownloadsSize)));
        r2.put("audio", Double.valueOf(bytesToGB(r1.mMusicSize)));
        r2.put(PluralRules.KEYWORD_OTHER, Double.valueOf(bytesToGB(r1.mOtherSize)));
        r2.put("cache", Double.valueOf(bytesToGB(r1.mCacheSize)));
        SettingsTracker.onEvent("O000007", r2);
        return;
    }

    private double bytesToGB(long r3) {
        return new BigDecimal(r3 / 1.073741824E9d).setScale(2, 4).doubleValue();
    }

    private void onCacheCleared() {
        Iterator<StorageVolumeView> r1 = this.mCategories.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onCacheCleared();
        goto L4
    }

    public void updateSandiskView(VolumeInfo r9, int r10) {
        OLog.d(TAG, "updateSandiskView, vol: " + r9);
        final File r0 = r9.getPath();
        int r1 = this.mSandiskContent.getChildCount();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L9;
        View r5 = this.mSandiskContent.getChildAt(r3);
        if (TextUtils.equals(r9.id, (String) r5.getTag()) == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        LinearLayout r6 = (LinearLayout) r5;
    L11:
        if (r0 != null) goto L13;
    L15:
        boolean r4 = false;
    L17:
        if (r10 != 8) goto L20;
        if (r6 == null) goto L20;
        this.mSandiskContent.removeView(r6);
    L25:
        int r11 = this.mSandiskContent.getChildCount();
    L26:
        if (r2 >= r11) goto L38;
        View r12 = this.mSandiskContent.getChildAt(r2);
        if (r11 != 1) goto L30;
        r12.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
    L36:
        r2 = r2 + 1;
        goto L26
    L30:
        if (r2 != 0) goto L33;
        r12.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_top);
        goto L36
    L33:
        if (r2 != (r11 - 1)) goto L35;
        r12.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_bottom);
        goto L36
    L35:
        r12.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_middle);
        goto L36
    L38:
        if (this.mSandiskContent.getChildCount() != 0) goto L48;
        this.mPortableStorage.setVisibility(8);
        return;
    L48:
        return;
    L20:
        if (r10 != 0) goto L25;
        if (r4 == false) goto L25;
        if (r6 != null) goto L24;
        r6 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.storage_item_layout, null, false);
        r6.setTag(r9.id);
        this.mSandiskContent.addView(r6);
    L24:
        updateSandiskViewInfo(r9, r6);
        r6.setOnClickListener(new AnonymousClass5(this, r0));
        this.mPortableStorage.setVisibility(0);
        goto L25
    L13:
        if (r0.exists() == false) goto L15;
        r4 = true;
        goto L17
    L9:
        r6 = null;
        goto L11
    }

    private void updateSandiskViewInfo(VolumeInfo r3, View r4) {
        TextView r0 = (TextView) r4.findViewById(R.id.title);
        TextView r5 = (TextView) r4.findViewById(R.id.storage_info);
        r0.setText(r3.getDisk().label);
        updateStorageUsageViewAsync(r5, r3.getPath());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.deviceinfo.Memory$6] */
    private void updateStorageUsageViewAsync(final TextView r3, final File r4) {
        new AnonymousClass6(this, r4, r3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new TextView[]{r3});
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_Memory_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(Memory r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_Memory__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_Memory_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(Memory r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_deviceinfo_Memory_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_Memory_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(Memory r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_Memory__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
