package com.bytedanceos.storage;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemProperties;
import android.os.storage.DiskInfo;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import android.os.storage.VolumeRecord;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.securitycenter.StorageNotificationReceiver;
import com.bytedanceos.utils.Constants;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.security.R;
import com.obric.security.cleanerpage.StoreageViewModel;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FileSystemUtils;

/* JADX INFO: loaded from: classes2.dex */
public class StorageActivity extends BaseActivity {
    private static final String BIG_FILE_SCANNING_STATE = "BigFileScanningState";
    private static final int BIG_FILE_SCAN_DONE = 1;
    private static final String TAG = "Security_StorageActivity";
    StorageVolumeView categorie;
    private OCardListItem mAppManagement;
    private ContentObserver mBigFileScanObserver;
    private View mBigFileScanProgressBar;
    private OCardListItem mBigFilesCleanUp;
    private ArrayList<StorageVolumeView> mCategories;
    private ContentResolver mContentResolver;
    private final ViewTreeObserver.OnScrollChangedListener mFpsScrollChangedListener;
    protected boolean mFromSecurityCenter;
    private boolean mHasClean;
    private int mLastScrollX;
    private int mLastScrollY;
    private View mPortableStorage;
    private LinearLayout mSandiskContent;
    private final Handler mScrollFpsHandler;
    private final PerformanceMonitors.FpsSceneSession mScrollFpsSession;
    private boolean mScrollFpsStarted;
    private final Runnable mScrollFpsStopRunnable;
    private ONestedScrollView mScrollView;
    private final ContentObserver mSettingValueObserver;
    private StorageEventListener mStorageListener;
    private StorageManager mStorageManager;
    private VolumeInfo mVolume;
    private StoreageViewModel viewModel;

    private static class MyStorageEventListener extends StorageEventListener {
        private WeakReference<StorageActivity> reference;

        public MyStorageEventListener(StorageActivity activity) {
            this.reference = new WeakReference(activity);
        }

        public void onStorageStateChanged(String path, String oldState, String newState) {
            OLog.i(StorageActivity.TAG, "Received storage state changed notification that " + path + " changed state from " + oldState + " to " + newState);
            StorageActivity r2 = this.reference.get();
            if (r2 != null) goto L5;
            return;
        L5:
            Iterator r3 = StorageActivity.access$600(r2).iterator();
        L7:
            if (r3.hasNext() == false) goto L20;
            StorageVolumeView r4 = (StorageVolumeView) r3.next();
            StorageVolume r5 = r4.getStorageVolume();
            if (r5 == null) goto L7;
            if (path.equals(r5.getPath()) == false) goto L7;
            r4.onStorageStateChanged();
            return;
        }

        public void onVolumeStateChanged(final VolumeInfo vol, int oldState, int newState) {
            final StorageActivity r1 = this.reference.get();
            if (r1 != null) goto L5;
            return;
        L5:
            if (vol != null) goto L7;
            return;
        L7:
            if (vol.getType() == 0) goto L9;
            return;
        L9:
            if (vol.getDisk() == null) goto L14;
            OLog.i(StorageActivity.TAG, "onVolumeStateChanged vol.id=" + vol.id + ", diskIdStr=" + vol.getDisk().id);
            OLog.i(StorageActivity.TAG, "onVolumeStateChanged isSd=" + vol.getDisk().isSd() + ", isUsb=" + vol.getDisk().isUsb());
            r1.runOnUiThread(new StorageActivity$MyStorageEventListener$$ExternalSyntheticLambda0(vol, r1));
            return;
        }

        static /* synthetic */ void lambda$onVolumeStateChanged$0(VolumeInfo r2, StorageActivity r3) {
            if (r2.getDisk() != null) goto L5;
        L7:
            StorageActivity.access$800(r3, r2);
            return;
        L5:
            if (r2.getDisk().isSd() == false) goto L7;
            OLog.i(StorageActivity.TAG, "onVolumeStateChanged isSd");
            StorageActivity.access$902(r3, r2);
            goto L7
        }

        public void onVolumeRecordChanged(VolumeRecord rec) {
            final StorageActivity r1 = this.reference.get();
            if (r1 != null) goto L5;
            return;
        L5:
            final VolumeInfo r2 = StorageActivity.access$700(r1).findVolumeByUuid(rec.getFsUuid());
            if (r2 != null) goto L8;
            return;
        L8:
            if (r2.isMountedReadable() == false) goto L12;
            r1.runOnUiThread(new StorageActivity$MyStorageEventListener$$ExternalSyntheticLambda1(r1, r2));
            return;
        }

        static /* synthetic */ void lambda$onVolumeRecordChanged$1(StorageActivity r1, VolumeInfo r2) {
            if (r1.getUsbVolumeIndexById(r2.id) != 0) goto L6;
            StorageActivity.access$800(r1, r2);
            return;
        L6:
            if (r1.getSdVolumeIndexById(r2.id) != 0) goto L10;
            StorageActivity.access$902(r1, r2);
            StorageActivity.access$800(r1, r2);
            return;
        }
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "storage_space_page";
    }

    public StorageActivity() {
        this.mCategories = new ArrayList();
        final Handler r1 = new Handler();
        this.mBigFileScanObserver = new AnonymousClass1(this, r1);
        this.mScrollFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_STORAGE_MANAGER_SCROLL);
        this.mScrollFpsStarted = false;
        this.mScrollFpsHandler = new Handler(Looper.getMainLooper());
        this.mScrollFpsStopRunnable = new AnonymousClass2(this);
        this.mFpsScrollChangedListener = new AnonymousClass3(this);
        final Handler r2 = new Handler();
        this.mSettingValueObserver = new AnonymousClass4(this, r2);
    }

    static /* synthetic */ void access$000(StorageActivity r0) {
        r0.setBigFileScanProgress();
    }

    static /* synthetic */ void access$100(StorageActivity r0) {
        r0.stopScrollFps();
    }

    static /* synthetic */ String access$1000(StorageActivity r0, File r1) {
        return r0.getStorageUsageInfo(r1);
    }

    static /* synthetic */ ONestedScrollView access$200(StorageActivity r0) {
        return r0.mScrollView;
    }

    static /* synthetic */ int access$300(StorageActivity r0) {
        return r0.mLastScrollX;
    }

    static /* synthetic */ int access$302(StorageActivity r0, int r1) {
        r0.mLastScrollX = r1;
        return r1;
    }

    static /* synthetic */ int access$400(StorageActivity r0) {
        return r0.mLastScrollY;
    }

    static /* synthetic */ int access$402(StorageActivity r0, int r1) {
        r0.mLastScrollY = r1;
        return r1;
    }

    static /* synthetic */ void access$500(StorageActivity r0) {
        r0.onScrollChangedForFps();
    }

    static /* synthetic */ ArrayList access$600(StorageActivity r0) {
        return r0.mCategories;
    }

    static /* synthetic */ StorageManager access$700(StorageActivity r0) {
        return r0.mStorageManager;
    }

    static /* synthetic */ void access$800(StorageActivity r0, VolumeInfo r1) {
        r0.onPublicVolumeStateChangedInternal(r1);
    }

    static /* synthetic */ VolumeInfo access$902(StorageActivity r0, VolumeInfo r1) {
        r0.mVolume = r1;
        return r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = StoreageViewModel.Companion.getStoreageViewModel(this);
        initObserve();
        this.viewModel.popPermissionDialogIfNeeded(this, PreferenceMgr.getInstance(this).isAllowed());
        setContentView(R.layout.memory_manage_layout);
        checkFromStorageNotificationReceiver();
        this.mFromSecurityCenter = isFromSecurityCenter();
        ContentResolver r4 = getContentResolver();
        this.mContentResolver = r4;
        r4.registerContentObserver(Settings.System.getUriFor(BIG_FILE_SCANNING_STATE), false, this.mBigFileScanObserver);
        this.mStorageListener = new MyStorageEventListener(this);
        StorageManager r5 = StorageManager.from(getApplicationContext());
        this.mStorageManager = r5;
        if (r5 == null) goto L5;
        r5.registerListener(this.mStorageListener);
    L5:
        preloadSecurityProcess();
        initView();
        updateViewWidth(R.id.ll_container);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(Constants.MEMORY_OPT_ENABLE), true, this.mSettingValueObserver);
        getWindow();
    }

    private void checkFromStorageNotificationReceiver() {
        if (getIntent().getBooleanExtra(StorageNotificationReceiver.TAG, false) == false) goto L6;
        StorageNotificationReceiver.cancelNotification(this);
        return;
    }

    private void initObserve() {
        this.viewModel.getAgreeGrant().observe(this, new StorageActivity$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$initObserve$0$com-bytedanceos-storage-StorageActivity, reason: not valid java name */
    /* synthetic */ void m133lambda$initObserve$0$combytedanceosstorageStorageActivity(Boolean r1) {
        if (r1.booleanValue() == true) goto L6;
        finish();
        return;
    }

    private void initView() {
        OCardListItem r0 = (OCardListItem) findViewById(R.id.big_files_cleanup);
        this.mBigFilesCleanUp = r0;
        if (r0 == null) goto L5;
        r0.setOnContentClickListener(new StorageActivity$$ExternalSyntheticLambda0(this));
        this.mBigFilesCleanUp.showSubTitle(true);
    L5:
        this.mBigFileScanProgressBar = LayoutInflater.from(this).inflate(R.layout.progress_white_small_layout, this.mBigFilesCleanUp, false);
        this.mBigFilesCleanUp.setDefaultTailIcon(0);
        this.mBigFilesCleanUp.showTailIcon(true);
        this.mBigFilesCleanUp.setCardPosition(3);
        StorageVolumeView r1 = (StorageVolumeView) findViewById(R.id.ll_content);
        this.categorie = r1;
        if (r1 == null) goto L8;
        r1.initView();
        addCategory(this.categorie);
    L8:
        setBigFileScanProgress();
        if (findViewById(R.id.app_management) == null) goto L11;
        OCardListItem r2 = (OCardListItem) findViewById(R.id.app_management);
        this.mAppManagement = r2;
        r2.setOnContentClickListener(new StorageActivity$$ExternalSyntheticLambda1(this));
        this.mAppManagement.setDefaultTailIcon(0);
        this.mAppManagement.showTailIcon(true);
        this.mAppManagement.setCardPosition(2);
    L11:
        OCardListItem r3 = (OCardListItem) findViewById(R.id.junk_files_cleanup);
        if (r3 == null) goto L14;
        r3.setOnContentClickListener(new StorageActivity$$ExternalSyntheticLambda2(this));
        r3.setDefaultTailIcon(0);
        r3.showTailIcon(true);
        r3.setCardPosition(1);
    L14:
        this.mPortableStorage = findViewById(R.id.portable_storage_layout);
        this.mSandiskContent = (LinearLayout) findViewById(R.id.sandisk_content);
        View r4 = this.mPortableStorage;
        if (r4 == null) goto L17;
        r4.setVisibility(8);
    L17:
        initTitleBar(false, false);
        ONestedScrollView r5 = (ONestedScrollView) findViewById(R.id.scroll_view);
        this.mScrollView = r5;
        if (r5 == null) goto L21;
        this.mLastScrollX = r5.getScrollX();
        this.mLastScrollY = this.mScrollView.getScrollY();
        this.mScrollView.getViewTreeObserver().addOnScrollChangedListener(this.mFpsScrollChangedListener);
        return;
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-bytedanceos-storage-StorageActivity, reason: not valid java name */
    /* synthetic */ void m134lambda$initView$1$combytedanceosstorageStorageActivity(View r1) {
        navigate(R.id.big_files_cleanup);
    }

    /* JADX INFO: renamed from: lambda$initView$2$com-bytedanceos-storage-StorageActivity, reason: not valid java name */
    /* synthetic */ void m135lambda$initView$2$combytedanceosstorageStorageActivity(View r1) {
        navigate(R.id.app_management);
    }

    /* JADX INFO: renamed from: lambda$initView$3$com-bytedanceos-storage-StorageActivity, reason: not valid java name */
    /* synthetic */ void m136lambda$initView$3$combytedanceosstorageStorageActivity(View r1) {
        navigate(R.id.junk_files_cleanup);
    }

    private void onScrollChangedForFps() {
        if (this.mScrollFpsStarted == true) goto L5;
        this.mScrollFpsStarted = true;
        this.mScrollFpsSession.start();
    L5:
        this.mScrollFpsHandler.removeCallbacks(this.mScrollFpsStopRunnable);
        this.mScrollFpsHandler.postDelayed(this.mScrollFpsStopRunnable, 250);
    }

    private void stopScrollFps() {
        if (this.mScrollFpsStarted == true) goto L5;
        return;
    L5:
        this.mScrollFpsStarted = false;
        this.mScrollFpsSession.stop();
    }

    private int needGenerateFile() {
        long r0 = (((long) SystemProperties.getInt(Constants.SWAP_FEATURE_PROPERTY_SIZE, 8192)) * 1048576) + Constants.SWAP_FEATURE_PROPERTY_SIZE_2G;
        File r8 = new File(Constants.SWAP_FILE_PATH);
        if (r8.isFile() == false) goto L21;
        if (r8.exists() == false) goto L21;
        if (r8.length() == r0) goto L23;
        return 1;
    L23:
        return -1;
    L21:
        long r6 = FileSystemUtils.freeSpaceKb("/data/");     // Catch: IOException -> L13
    L16:
        if (r6 > 0) goto L18;
        return 1;
    L18:
        if ((r6 * 1024) >= r0) goto L25;
        return -2;
    L25:
        return 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        r6 = 0;
        goto L16
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        if (PreferenceMgr.getInstance(this).isAllowed() == false) goto L5;
        this.categorie.init(this, null);
        new Handler().postDelayed(new StorageActivity$$ExternalSyntheticLambda3(this), 50);
    L5:
        super.onResume();
    }

    /* JADX INFO: renamed from: lambda$onResume$4$com-bytedanceos-storage-StorageActivity, reason: not valid java name */
    /* synthetic */ void m137lambda$onResume$4$combytedanceosstorageStorageActivity() {
        StorageManager r0 = this.mStorageManager;
        if (r0 == null) goto L18;
        Iterator r1 = r0.getVolumes().iterator();
        boolean r2 = false;
    L6:
        if (r1.hasNext() == false) goto L18;
        VolumeInfo r3 = (VolumeInfo) r1.next();
        if (r3 == null) goto L6;
        if (r3.getType() != 0) goto L6;
        if (r3.getDisk() == null) goto L17;
        if (r3.getDisk().isSd() == false) goto L17;
        if (r2 == true) goto L6;
        this.mVolume = r3;
        r2 = true;
    L17:
        onPublicVolumeStateChangedInternal(r3);
    L18:
        Iterator<StorageVolumeView> r4 = this.mCategories.iterator();
    L20:
        if (r4.hasNext() == false) goto L22;
        r4.next().onResume();
        goto L20
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        stopScrollFps();
        this.mScrollFpsHandler.removeCallbacks(this.mScrollFpsStopRunnable);
        super.onPause();
        if (PreferenceMgr.getInstance(this).isAllowed() == false) goto L8;
        Iterator<StorageVolumeView> r2 = this.mCategories.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        r2.next().onPause();
        goto L6
    L10:
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        stopScrollFps();
        this.mScrollFpsHandler.removeCallbacks(this.mScrollFpsStopRunnable);
        ONestedScrollView r0 = this.mScrollView;
        if (r0 == null) goto L8;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == false) goto L7;
        r1.removeOnScrollChangedListener(this.mFpsScrollChangedListener);
    L7:
        this.mScrollView = null;
    L8:
        StorageManager r2 = this.mStorageManager;
        if (r2 == null) goto L13;
        StorageEventListener r3 = this.mStorageListener;
        if (r3 == null) goto L13;
        r2.unregisterListener(r3);
    L13:
        this.mStorageListener = null;
        this.mStorageManager = null;
        ContentResolver r4 = this.mContentResolver;
        if (r4 == null) goto L19;
        ContentObserver r5 = this.mBigFileScanObserver;
        if (r5 == null) goto L19;
        r4.unregisterContentObserver(r5);
    L19:
        if (this.mSettingValueObserver == null) goto L21;
        getContentResolver().unregisterContentObserver(this.mSettingValueObserver);
    L21:
        super.onDestroy();
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        Intent r0 = new Intent();
        r0.putExtra("hasClean", this.mHasClean);
        setResult(-1, r0);
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.mHasClean == false) goto L5;
        return;
    L5:
        if (data == null) goto L8;
        this.mHasClean = data.getBooleanExtra("hasClean", false);
        return;
    }

    private void addCategory(StorageVolumeView category) {
        this.mCategories.add(category);
    }

    private void setBigFileScanProgress() {
        if (this.mBigFilesCleanUp != null) goto L5;
        return;
    L5:
        Settings.System.getInt(this.mContentResolver, BIG_FILE_SCANNING_STATE, 1);
    }

    private void preloadSecurityProcess() {
        new Intent("com.bytedanceos.settings.FAKE_SERVICE").setPackage("com.obric.security");
    }

    private void navigate(int itemId) {
        Intent r0 = new Intent();
        r0.putExtra(Utils.INTENT_KEY_FROM_CENTER, this.mFromSecurityCenter);
        if (itemId != R.id.app_management) goto L5;
        r0.setClassName(BatteryEntry.SETTING_PACKAGE, "com.android.settings.applications.ManageApplicationsActivity");
        r0.putExtra("back_text", getString(R.string.advanced_item_storage));
    L12:
        int r6 = -1;
    L13:
        DeviceUtils.startActivity(r0, this, r6);
        return;
    L5:
        if (itemId != R.id.big_files_cleanup) goto L7;
        r0.setClassName("com.obric.security", "com.obric.security.cleaner.bigfile.BigFileListActivity");
        r0.putExtra("back_text", getString(R.string.advanced_item_storage));
        goto L12
    L7:
        if (itemId == R.id.junk_files_cleanup) goto L9;
        return;
    L9:
        r0.setClassName("com.obric.security", "com.bytedanceos.cleaner.CleanerActivity");
        r6 = 1020;
        goto L13
    }

    private String getStorageUsageInfo(File path) {
        String r0 = "0.00B";
        if (path != null) goto L5;
    L13:
        String r8 = "0.00B";
    L15:
        return getString(R.string.sd_memory_init_size, new Object[]{r0, r8});
    L5:
        if (path.exists() == false) goto L13;
        long r1 = DeviceUtils.getTotalSize(path);
        long r3 = DeviceUtils.getAvailableSize(path);
        if (r1 <= 0) goto L9;
        r8 = DeviceUtils.formatSize(this, r1);
    L11:
        if (r3 <= 0) goto L15;
        r0 = DeviceUtils.formatSize(this, r3);
        goto L15
    L9:
        r8 = "0.00B";
        goto L11
    }

    private void onPublicVolumeStateChangedInternal(VolumeInfo vol) {
        if (vol != null) goto L4;
        return;
    L4:
        if (vol.getDisk() == null) goto L35;
        DiskInfo r0 = vol.getDisk();
        if (r0.isUsb() == false) goto L9;
        boolean r1 = true;
    L10:
        int r2 = vol.getState();
        if (r2 != 0) goto L13;
        if (r1 == false) goto L34;
        updateSandiskView(vol, 8);
        return;
    L34:
        return;
    L13:
        if (r2 != 2) goto L15;
    L24:
        if (r1 == false) goto L32;
        updateSandiskView(vol, 0);
        return;
    L32:
        return;
    L15:
        if (r2 == 3) goto L24;
        if (r2 != 6) goto L19;
    L22:
        if (r1 == false) goto L30;
        updateSandiskView(vol, 8);
        return;
    L30:
        return;
    L19:
        if (r2 == 7) goto L22;
        if (r2 == 8) goto L22;
        return;
    L9:
        r0.isSd();
        r1 = false;
        goto L10
    }

    private void updateSandiskViewInfo(VolumeInfo vol, View itemView) {
        if (vol == null) goto L16;
        if (itemView != null) goto L5;
        return;
    L5:
        if (vol.getDisk() == null) goto L18;
        OListItemSettings r4 = (OListItemSettings) itemView.findViewById(R.id.storage_item);
        if (r4 != null) goto L10;
        return;
    L10:
        TextView r0 = r4.getMTvTitle();
        if (vol.getDisk().label.isEmpty() == false) goto L13;
        r0.setText(getUsbDiskName());
    L14:
        updateStorageUsageViewAsync(r4.getSettingsTrailingView().getTextView(), vol.getPath());
        return;
    L13:
        r0.setText(vol.getDisk().label);
        goto L14
    L18:
        return;
    }

    private LinearLayout requireSandiskContent() {
        if (this.mSandiskContent != null) goto L6;
        this.mSandiskContent = (LinearLayout) findViewById(R.id.sandisk_content);
    L6:
        return this.mSandiskContent;
    }

    private View requirePortableStorage() {
        if (this.mPortableStorage != null) goto L6;
        this.mPortableStorage = findViewById(R.id.portable_storage_layout);
    L6:
        return this.mPortableStorage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedanceos.storage.StorageActivity$5] */
    private void updateStorageUsageViewAsync(final TextView targetView, final File path) {
        new AnonymousClass5(this, path, targetView).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new TextView[]{targetView});
    }

    public String getUsbDiskName() {
        StorageManager r4 = this.mStorageManager;
        if (r4 != null) goto L5;
        return null;
    L5:
        List r5 = r4.getVolumes();
        if (r5 != null) goto L8;
    L29:
        return null;
    L8:
        if (r5.isEmpty() == true) goto L29;
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L29;
        VolumeInfo r1 = (VolumeInfo) r6.next();
        if (r1 == null) goto L12;
        if (r1.getType() != 0) goto L12;
        DiskInfo r2 = r1.getDisk();
        if (r2 == null) goto L12;
        if (r2.isUsb() == false) goto L12;
        if (r1.isMountedReadable() == false) goto L12;
        String r3 = r2.label;
        if (TextUtils.isEmpty(r3) == true) goto L12;
        return r3;
    }

    public void updateSandiskView(final VolumeInfo vol, int visible) {
        OLog.i(TAG, "updateSandiskView, vol: " + vol);
        if (vol != null) goto L5;
        return;
    L5:
        LinearLayout r0 = requireSandiskContent();
        if (r0 != null) goto L9;
        OLog.w(TAG, "updateSandiskView ignored: sandisk_content view is null");
        return;
    L9:
        final File r1 = vol.getPath();
        int r2 = r0.getChildCount();
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L19;
        View r6 = r0.getChildAt(r4);
        if (r6 == null) goto L18;
        if (TextUtils.equals(vol.id, (String) r6.getTag()) == false) goto L18;
        LinearLayout r7 = (LinearLayout) r6;
    L20:
        boolean r5 = true;
        if (r1 != null) goto L23;
    L25:
        boolean r8 = false;
    L27:
        if (visible != 8) goto L30;
        if (r7 == null) goto L30;
        r0.removeView(r7);
    L35:
        View r9 = requirePortableStorage();
        if (r9 != null) goto L38;
        return;
    L38:
        if (r0.getChildCount() > 0) goto L41;
        r5 = false;
    L41:
        if (r5 == true) goto L44;
        r3 = 8;
    L44:
        r9.setVisibility(r3);
        return;
    L30:
        if (visible != 0) goto L35;
        if (r8 == false) goto L35;
        if (r7 != null) goto L34;
        r7 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.storage_item_layout_oui, null, false);
        r7.setTag(vol.id);
        r0.addView(r7);
    L34:
        updateSandiskViewInfo(vol, r7);
        r7.setOnClickListener(new AnonymousClass6(this, r1));
        this.mPortableStorage.setVisibility(0);
        goto L35
    L23:
        if (r1.exists() == false) goto L25;
        r8 = true;
    L18:
        r4 = r4 + 1;
        goto L11
    L19:
        r7 = null;
        goto L20
    }

    public int getUsbVolumeIndexById(String id) {
        Iterator r3 = this.mStorageManager.getVolumes().iterator();
        int r0 = -1;
    L4:
        if (r3.hasNext() == false) goto L11;
        VolumeInfo r1 = (VolumeInfo) r3.next();
        if (r1.getDisk() == null) goto L4;
        if (r1.getDisk().isUsb() == false) goto L4;
        r0 = r0 + 1;
        if (Objects.equals(r1.id, id) == false) goto L4;
    L11:
        return r0;
    }

    public int getSdVolumeIndexById(String id) {
        Iterator r3 = this.mStorageManager.getVolumes().iterator();
        int r0 = -1;
    L4:
        if (r3.hasNext() == false) goto L11;
        VolumeInfo r1 = (VolumeInfo) r3.next();
        if (r1.getDisk() == null) goto L4;
        if (r1.getDisk().isSd() == false) goto L4;
        r0 = r0 + 1;
        if (Objects.equals(r1.id, id) == false) goto L4;
    L11:
        return r0;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
