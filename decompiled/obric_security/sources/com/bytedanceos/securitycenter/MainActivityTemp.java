package com.bytedanceos.securitycenter;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import bytedanceos.api.DeviceIdleControllerSmt;
import com.android.calendar.privacy.GrantUtil;
import com.android.internal.util.CustomizedStatusBarUtil;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.powerusage.PowerSaveModeActivity;
import com.bytedanceos.preventdisturb.DisturbActivity;
import com.bytedanceos.rotateview.BezierBubbleView;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.widget.SecurityItemText2;
import com.bytedanceos.securitycenter.task.MemoryWorkTask;
import com.bytedanceos.securitycenter.task.TrashFileWorkTask;
import com.bytedanceos.securitycenter.task.WorkGroup;
import com.bytedanceos.storage.StorageMeasurement;
import com.bytedanceos.utils.Constants;
import com.obric.olog.OLog;
import com.obric.oui.animation.RotatePannelManager;
import com.obric.oui.animation.RotatePannelView;
import com.obric.security.R;
import com.obric.security.mainpage.view.OTAUpdateView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivityTemp extends BaseActivity implements View.OnClickListener {
    public static final boolean DBG = false;
    private static final int ENABLE_ALL_NET_RESTRICT_BG = 1;
    private static final int FIRST_CHECK_TIME = 60000;
    private static final String FROM = "FROM";
    private static final int FROM_SETTINGS = 1;
    private static final int MESSAGE_CHECK = 3;
    private static final int MESSAGE_CHECK_TIME = 60000;
    private static final int MESSAGE_SCAN = 1;
    private static final int MESSAGE_SET_SCORE = 2;
    private static final String RESTRICT_ALL_NET_BG_STATE = "restrict_all_net_background_state";
    public static final int RESULT_CODE_MEMORY = 1010;
    public static final int RESULT_CODE_STORAGE = 1020;
    public static final int RESULT_CODE_TRASH = 1000;
    public static final String RESULT_PARAM_HASCLEAN = "hasClean";
    private static final int SCAN_DELAY = 500;
    private static final String TAG = "MainActivity";
    private int animInLeft;
    private int animInRight;
    private int animOutLeft;
    private int animOutRight;
    private BroadcastReceiver mBatteryInfoReceiver;
    private BatteryManager mBatteryManager;
    private BezierBubbleView.BezierBubbleListener mBezierBubbleListener;
    private int mCurrentScore;
    private boolean mFromOther;
    public Handler mHandler;
    private boolean mIsAllowed;
    private ViewGroup mItemDataUsage;
    private LinearLayout mLinearLayoutBottom;
    private LinearLayout mLinearLayoutParent;
    private LinearLayout mLinearLayoutTop;
    private RelativeLayout mListContentItemText;
    private StorageMeasurement mMeasure;
    private MemoryWorkTask mMemoryWorkTask;
    private OTAUpdateView mOTAUpdateView;
    private AlertDialog mPermissionDialog;
    private SecurityItemText2 mPowerLowView;
    private PowerManager mPowerManager;
    private PowerRankView mPowerRankView;
    private PreferenceMgr mPreferenceMgr;
    private RotatePannelManager.RotateListener mRotateListener;
    private RotatePannelManager mRotatePannel;
    private RotatePannelView mRotatePannelView;
    private Score mScore;
    private int mTotalScore;
    private TrashFileWorkTask mTrashFileWorkTask;
    private WorkGroup mWorkGroup;

    public class Score {
        public int memoryScore;
        public int otaScore;
        final /* synthetic */ MainActivityTemp this$0;
        public int trashScore;

        public Score(final MainActivityTemp this$0) {
            this.this$0 = this$0;
            this.otaScore = 0;
        }

        public int getCleanScore() {
            return this.trashScore + this.memoryScore;
        }
    }

    private class StaticAsyncTask extends AsyncTask<Void, Void, Boolean> {
        private WeakReference<MainActivityTemp> activityReference;
        final /* synthetic */ MainActivityTemp this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] params) {
            return doInBackground2(params);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean allowed) {
            onPostExecute2(allowed);
        }

        StaticAsyncTask(final MainActivityTemp this$0, MainActivityTemp context) {
            this.this$0 = this$0;
            this.activityReference = new WeakReference(context);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... params) {
            MainActivityTemp r5 = this.activityReference.get();
            if (r5 == null) goto L13;
            if (r5.isFinishing() == true) goto L13;
            if (MainActivityTemp.access$1100(this.this$0).getBoolean(PreferenceMgr.SETTINGS_HAS_BG_ALLOWED, false) == true) goto L11;
            DeviceIdleControllerSmt.getInstance().setDozeMode(true, true);
            Settings.Global.putInt(r5.getContentResolver(), MainActivityTemp.RESTRICT_ALL_NET_BG_STATE, 1);
            MainActivityTemp.access$1100(this.this$0).putBoolean(PreferenceMgr.SETTINGS_HAS_BG_ALLOWED, true);
        L11:
            return Boolean.valueOf(MainActivityTemp.access$1100(this.this$0).isAllowed());
        L13:
            return true;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean allowed) {
            final MainActivityTemp r0 = this.activityReference.get();
            if (allowed.booleanValue() == true) goto L10;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.isFinishing() == true) goto L12;
            GrantUtil.INSTANCE.requestGrant(r0, new AnonymousClass1(this, r0), "", false);
            return;
        L12:
            return;
        L10:
            r0.getWindow().getDecorView().postDelayed(new AnonymousClass2(this, r0), 0);
        }
    }

    protected boolean needSetThemeBySuper() {
        return false;
    }

    public MainActivityTemp() {
        this.mFromOther = false;
        this.mTotalScore = 100;
        this.mCurrentScore = 100;
        this.mRotateListener = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
        this.mBatteryInfoReceiver = new AnonymousClass3(this);
        this.mBezierBubbleListener = new AnonymousClass4(this);
    }

    static /* synthetic */ WorkGroup access$000(MainActivityTemp r0) {
        return r0.mWorkGroup;
    }

    static /* synthetic */ TrashFileWorkTask access$100(MainActivityTemp r0) {
        return r0.mTrashFileWorkTask;
    }

    static /* synthetic */ SecurityItemText2 access$1000(MainActivityTemp r0) {
        return r0.mPowerLowView;
    }

    static /* synthetic */ PreferenceMgr access$1100(MainActivityTemp r0) {
        return r0.mPreferenceMgr;
    }

    static /* synthetic */ void access$1200(MainActivityTemp r0) {
        checkSystemUpdate(r0);
    }

    static /* synthetic */ Score access$200(MainActivityTemp r0) {
        return r0.mScore;
    }

    static /* synthetic */ MemoryWorkTask access$300(MainActivityTemp r0) {
        return r0.mMemoryWorkTask;
    }

    static /* synthetic */ int access$400(MainActivityTemp r0) {
        return r0.mCurrentScore;
    }

    static /* synthetic */ int access$402(MainActivityTemp r0, int r1) {
        r0.mCurrentScore = r1;
        return r1;
    }

    static /* synthetic */ RotatePannelManager access$500(MainActivityTemp r0) {
        return r0.mRotatePannel;
    }

    static /* synthetic */ void access$600(MainActivityTemp r0, Intent r1) {
        r0.updateBatteryStatus(r1);
    }

    static /* synthetic */ void access$700(MainActivityTemp r0) {
        r0.onScanFinish();
    }

    static /* synthetic */ void access$800(MainActivityTemp r0) {
        r0.onCleanFinish();
    }

    static /* synthetic */ PowerManager access$900(MainActivityTemp r0) {
        return r0.mPowerManager;
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DBG = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OLog.i("OceanDownloaderHelper1", "onCreate: ");
        requestWindowFeature(1);
    L15:
        e = move-exception;
        OLog.e(TAG, "intent exception :" + e);
    L18:
        if (this.mFromOther == false) goto L20;
        CustomizedStatusBarUtil.mCustomizedSmartianStatusBar = true;
    L20:
        this.mPreferenceMgr = PreferenceMgr.getInstance(this);
        popPermissionDialogIfNeeded();
        setContentView(R.layout.security_layout);
        initTitleBar(false);
        removeTitleBarLeft();
        ApplicationLabelCache.getInstance().init(this);
        this.mPowerManager = (PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.mBatteryManager = (BatteryManager) getSystemService("batterymanager");
        ViewGroup r0 = (ViewGroup) findViewById(R.id.item_data_usage);
        this.mItemDataUsage = r0;
        if (r0 == null) goto L23;
        r0.setOnClickListener(this);
    L23:
        this.animInLeft = com.bytedanceos.security.Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.animInRight = com.bytedanceos.security.Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_right", "anim", R.anim.slide_in_from_right);
        this.animOutLeft = com.bytedanceos.security.Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_left", "anim", R.anim.slide_out_to_left);
        this.animOutRight = com.bytedanceos.security.Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        this.mLinearLayoutTop = (LinearLayout) findViewById(R.id.container_top);
        this.mLinearLayoutBottom = (LinearLayout) findViewById(R.id.container_bottom);
        this.mLinearLayoutParent = (LinearLayout) findViewById(R.id.type_container);
        this.mListContentItemText = (RelativeLayout) findViewById(R.id.list_content_container);
        findViewById(R.id.memory_completely_cleanup).setOnClickListener(this);
        findViewById(R.id.battery_optimization).setOnClickListener(this);
        findViewById(R.id.junk_files_cleanup).setOnClickListener(this);
        findViewById(R.id.prevent_disturb).setOnClickListener(this);
        findViewById(R.id.item_storage).setOnClickListener(this);
        findViewById(R.id.item_advanced).setOnClickListener(this);
        findViewById(R.id.application_manager).setOnClickListener(this);
        this.mOTAUpdateView = (OTAUpdateView) findViewById(R.id.ota_update);
        this.mPowerRankView = (PowerRankView) findViewById(R.id.power_rank_status);
        this.mRotatePannelView = (RotatePannelView) findViewById(R.id.main_rotate_pannel);
        RotatePannelManager r1 = new RotatePannelManager(this.mRotatePannelView);
        this.mRotatePannel = r1;
        r1.setRotateListener(this.mRotateListener);
        this.mScore = new Score(this);
        this.mWorkGroup = new WorkGroup();
        TrashFileWorkTask r2 = new TrashFileWorkTask();
        this.mTrashFileWorkTask = r2;
        this.mWorkGroup.addTask(r2);
        MemoryWorkTask r3 = new MemoryWorkTask();
        this.mMemoryWorkTask = r3;
        this.mWorkGroup.addTask(r3);
        this.mWorkGroup.setWorkStatusListener(new AnonymousClass5(this));
        initBatteyView();
        this.mPowerRankView.doCreate(this, savedInstanceState);
        this.mWorkGroup.onCreate(getApplicationContext());
        this.mMeasure = StorageMeasurement.getInstance(this, null);
        boolean r6 = this.mPreferenceMgr.getBoolean(PreferenceMgr.SETTINGS_PREFERENCES_PERMISSION_ALLOWED, false);
        this.mIsAllowed = r6;
        if (r6 == false) goto L29;
        this.mOTAUpdateView.doCreate();
        return;
    L29:
        return;
    L4:
        if (getIntent().getIntExtra(FROM, 0) != 1) goto L6;
        boolean r4 = true;
    L7:
        boolean r5 = getIntent().getBooleanExtra("from_search", false);     // Catch: Exception -> L15
        if (r4 == true) goto L12;
        if (r5 == true) goto L12;
        boolean r7 = false;
    L13:
        this.mFromOther = r7;     // Catch: Exception -> L15
    L12:
        r7 = true;
        goto L13
    L6:
        r4 = false;
        goto L7
    }

    private void onScanFinish() {
        if (this.mOTAUpdateView.needUpdate() == false) goto L5;
        this.mScore.otaScore = 5;
    L5:
        this.mScore.trashScore = this.mTrashFileWorkTask.getScore();
        this.mScore.memoryScore = this.mMemoryWorkTask.getScore();
        int r0 = this.mTotalScore - this.mScore.otaScore;
        this.mTotalScore = r0;
        this.mRotatePannel.setMaxScore(r0);
        int r1 = this.mTotalScore - this.mScore.getCleanScore();
        this.mCurrentScore = r1;
        setScore(r1);
        if (DBG == false) goto L9;
        OLog.d(TAG, "onScanFinish mCurrentScore=" + this.mCurrentScore + "trashScore=" + this.mScore.trashScore + ",memoryScore=" + this.mScore.memoryScore);
    L9:
        if (this.mScore.getCleanScore() > 0) goto L12;
        this.mRotatePannel.skipClean();
    L12:
        if (this.mRotatePannel.isScanning() == false) goto L15;
        this.mRotatePannel.continueAnim();
        return;
    }

    private void onCleanFinish() {
        int r0 = this.mCurrentScore + this.mScore.getCleanScore();
        this.mCurrentScore = r0;
        setScore(r0);
        if (this.mRotatePannel.isCleanning() == false) goto L6;
        this.mRotatePannel.continueAnim();
        return;
    }

    private void initBatteyView() {
        SecurityItemText2 r0 = (SecurityItemText2) findViewById(R.id.battery_status_low);
        this.mPowerLowView = r0;
        r0.setRightLayout(3);
        this.mPowerLowView.setContentImage(getResources().getDrawable(R.drawable.oic_low_battery_ranking));
        SecurityItemText2 r1 = this.mPowerLowView;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setOnCheckedChangeListener(new AnonymousClass6(this));
    }

    private void updateBatteryStatus(Intent intent) {
        int r0 = this.mBatteryManager.getIntProperty(4);
        this.mPowerLowView.setVisibility(8);
        int r5 = intent.getIntExtra("status", -1);
        if (r5 != 2) goto L5;
    L8:
        boolean r6 = true;
    L9:
        boolean r1 = PowerSaveModeActivity.isLowBatteryMode(this);
        if (r0 > 20) goto L15;
        if (r6 == true) goto L16;
        if (r1 == true) goto L17;
        this.mPowerLowView.setChecked(false);
        this.mPowerLowView.setVisibility(0);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r5 == 5) goto L8;
        r6 = false;
        goto L9
    }

    private void setScore(int score) {
        Message r0 = this.mHandler.obtainMessage(2);
        r0.obj = Integer.valueOf(score);
        this.mHandler.sendMessage(r0);
    }

    public void updateStatusOnResume() {
        updateBatteryStatus(registerReceiver(this.mBatteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mWorkGroup.onResume();
        this.mPowerRankView.doResume();
        boolean r0 = this.mPreferenceMgr.getBoolean(PreferenceMgr.SETTINGS_PREFERENCES_PERMISSION_ALLOWED, false);
        this.mIsAllowed = r0;
        if (r0 == false) goto L5;
        this.mOTAUpdateView.doResume();
    L5:
        updateStatusOnResume();
        if (this.mPermissionDialog == null) goto L8;
        dismissPermissionDialogIfNeeded();
    L8:
        updateWidth();
    }

    private void updateWidth() {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mListContentItemText.getLayoutParams();
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mLinearLayoutTop.getLayoutParams();
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) this.mLinearLayoutBottom.getLayoutParams();
        r1.weight = 1.0f;
        r2.weight = 1.0f;
        this.mLinearLayoutTop.setLayoutParams(r1);
        this.mLinearLayoutBottom.setLayoutParams(r2);
        this.mListContentItemText.setLayoutParams(r0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mWorkGroup.onPause();
        this.mPowerRankView.doPause();
        unregisterReceiver(this.mBatteryInfoReceiver);
        this.mOTAUpdateView.doPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (com.bytedanceos.security.Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        int r3 = -1;
        switch(v.getId()) {
            case 2131296447: goto L15;
            case 2131296498: goto L14;
            case 2131297152: goto L13;
            case 2131297157: goto L12;
            case 2131297168: goto L11;
            case 2131297223: goto L10;
            case 2131297344: goto L9;
            case 2131297669: goto L8;
            default: goto L17;
        };
    L8:
        r0 = new Intent(this, DisturbActivity.class);
        goto L17
    L9:
        r0.setClassName("com.obric.security", "com.bytedanceos.clearmemory.ManagerApplicationsRunningActivity");
        r3 = 1010;
        goto L17
    L10:
        r0.setClassName("com.obric.security", "com.bytedanceos.cleaner.CleanerActivity");
        r3 = 1000;
        goto L17
    L11:
        r0.setClassName("com.obric.security", "com.bytedanceos.storage.StorageActivity");
        r0.putExtra("from_where", "1");
        r3 = 1020;
        goto L17
    L12:
        r0.setClassName("com.obric.security", "com.bytedanceos.datausage.DataUsageActivity");
        goto L17
    L13:
        r0.setClassName(BatteryEntry.SETTING_PACKAGE, "com.android.settings.SecuritySettingsActivity");
        goto L17
    L14:
        r0.setClassName("com.obric.security", "com.obric.security.battertpower.BatteryPowerActivity");
        goto L17
    L15:
        r0.setClassName("com.obric.security", "com.bytedanceos.appmanager.ApplicationManagerActivity");
    L17:
        if (v.getId() != R.id.memory_completely_cleanup) goto L19;
    L24:
        r0.putExtra("from", GrantUtil.securitymanager);
    L25:
        r0.putExtra(com.bytedanceos.security.Utils.INTENT_KEY_FROM_CENTER, !this.mFromOther);
        r0.putExtra("back_text_res_name", "security_center");
        r0.putExtra(Constants.EXTRA_BYTEDANCE_ANIM_RESOURCE_ID, new int[]{this.animInLeft, this.animOutRight});
        if (r3 <= 0) goto L28;
        startActivityForResult(r0, r3);     // Catch: Exception -> L30
    L33:
        return;
    L28:
        startActivity(r0);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        if (v.getId() == R.id.junk_files_cleanup) goto L24;
        if (v.getId() == R.id.battery_optimization) goto L24;
        if (v.getId() != R.id.prevent_disturb) goto L25;
        goto L24
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    private static void checkSystemUpdate(MainActivityTemp activity) {
        if (activity == null) goto L8;
        OTAUpdateView r0 = activity.mOTAUpdateView;
        if (r0 == null) goto L9;
        r0.doCreate();
        return;
    L9:
        return;
    }

    private void popPermissionDialogIfNeeded() {
        if (this.mPreferenceMgr.isAllowed() == true) goto L5;
        GrantUtil.INSTANCE.requestGrant(this, new AnonymousClass7(this, this), "", false);
        return;
    L5:
        getWindow().getDecorView().postDelayed(new AnonymousClass8(this, this), 0);
    }

    private void dismissPermissionDialogIfNeeded() {
        if (getPreferences(0).getBoolean(PreferenceMgr.SETTINGS_PREFERENCES_PERMISSION_ALLOWED, false) == false) goto L10;
        AlertDialog r0 = this.mPermissionDialog;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isShowing() == false) goto L12;
        this.mPermissionDialog.dismiss();
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mPowerRankView.doStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mPowerRankView.doStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) goto L5;
        return;
    L5:
        if (data.getBooleanExtra("hasClean", false) == true) goto L7;
        return;
    L7:
        if (this.mRotatePannel.isScannEnd() == true) goto L10;
        return;
    L10:
        if (DBG == false) goto L13;
        OLog.d(TAG, "onActivityResult requestCode=" + requestCode + ",trashScore=" + this.mScore.trashScore + ",memoryScore=" + this.mScore.memoryScore);
    L13:
        if (requestCode == 1000) goto L23;
        if (requestCode == 1020) goto L23;
        if (requestCode == 1010) goto L20;
        return;
    L20:
        if (this.mScore.memoryScore <= 0) goto L28;
        int r2 = this.mCurrentScore + this.mScore.memoryScore;
        this.mCurrentScore = r2;
        setScore(r2);
        this.mScore.memoryScore = 0;
        this.mWorkGroup.removeTask(this.mMemoryWorkTask);
        return;
    L28:
        return;
    L23:
        if (this.mScore.trashScore <= 0) goto L30;
        int r3 = this.mCurrentScore + this.mScore.trashScore;
        this.mCurrentScore = r3;
        setScore(r3);
        this.mScore.trashScore = 0;
        this.mWorkGroup.removeTask(this.mTrashFileWorkTask);
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mWorkGroup.onDestory(getApplicationContext());
        this.mHandler.removeMessages(3);
        this.mRotatePannel.onDestory();
        AlertDialog r0 = this.mPermissionDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        StorageMeasurement r1 = this.mMeasure;
        if (r1 == null) goto L8;
        r1.cleanUp();
    L8:
        this.mOTAUpdateView.doDestory();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateWidth();
    }

    public void toOTA(Intent intent) {
        startActivity(intent);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
