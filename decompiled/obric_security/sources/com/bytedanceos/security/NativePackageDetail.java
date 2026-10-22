package com.bytedanceos.security;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedanceos.application.AppEntry;
import com.bytedanceos.security.permission.AppNativePermission;
import com.bytedanceos.security.permission.AppNativePermissionLoader;
import com.bytedanceos.security.permission.DangerousPermissionUtil;
import com.bytedanceos.security.permission.NativePermissionGroup;
import com.bytedanceos.security.permission.NativePermissionManager;
import com.bytedanceos.security.permission.OpenSystemConstant;
import com.bytedanceos.security.permission.RiskPermissionControlGuard;
import com.bytedanceos.security.permission.SpecailPermissionUtil;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.ReflectHelper;
import com.bytedanceos.utils.PermissionUtil;
import com.bytedanceos.utils.Task;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.security.R;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class NativePackageDetail extends BaseActivity implements View.OnClickListener, AppNativePermissionLoader.AppPermissionLoaderListener {
    private static final String TAG = "PackageDetail";
    private int animInLeft;
    private int animOutRight;
    private AppOpsManager mAppOpsManager;
    private String mAppPackageName;
    private int mAppUid;
    private View mClickedView;
    private LinearLayout mDetailContainer;
    private boolean mIfMenuDialogCanShow;
    private LayoutInflater mInflater;
    private int mLinAnim;
    private int mLoutAnim;
    private OInsetSheet mMenuDialog;
    private View.OnClickListener mOnItemClickListener;
    private OpsManagerHelper mOpsManagerHelper;
    private PackageManager mPM;
    private PackageInfo mPackageInfo;
    private BroadcastReceiver mPackageReceiver;
    private AlertDialog mPermissionDialog;
    private PermissionReceiver mPermissionReceiver;
    private boolean mRefreshing;
    private int mRinAnim;
    private int mRoutAnim;
    private ScreenRecordObserver mScreenRecordObserver;
    private boolean mShowAppInfo;
    private ExecutorService mSingleThreadExecutor;
    private long mToastShowTime;
    private OListItemSettings mViewAllPermission;

    private class PermissionReceiver extends BroadcastReceiver {
        final /* synthetic */ NativePackageDetail this$0;

        private PermissionReceiver(final NativePackageDetail this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ PermissionReceiver(NativePackageDetail r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String r3 = intent.getStringExtra("package");
            int r4 = intent.getIntExtra("uid", -1);
            if (r4 != (-1)) goto L5;
            return;
        L5:
            if (NativePackageDetail.access$600(this.this$0) != null) goto L8;
            return;
        L8:
            if (TextUtils.equals(r3, NativePackageDetail.access$600(this.this$0).packageName) == true) goto L10;
            return;
        L10:
            if (r4 != NativePackageDetail.access$600(this.this$0).applicationInfo.uid) goto L15;
            NativePackageDetail.access$1800(this.this$0);
            return;
        }
    }

    private class ScreenRecordObserver extends ContentObserver {
        final /* synthetic */ NativePackageDetail this$0;

        public ScreenRecordObserver(final NativePackageDetail this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            NativePackageDetail.access$1800(this.this$0);
        }
    }

    public NativePackageDetail() {
        this.mIfMenuDialogCanShow = true;
        this.mShowAppInfo = true;
        this.mRefreshing = false;
        this.mOnItemClickListener = new AnonymousClass2(this);
    }

    static /* synthetic */ String access$000(NativePackageDetail r0) {
        return r0.mAppPackageName;
    }

    static /* synthetic */ PackageManager access$1000(NativePackageDetail r0) {
        return r0.mPM;
    }

    static /* synthetic */ void access$1100(NativePackageDetail r0, String r1, boolean r2) {
        r0.sendPermissionChangeBroadCast(r1, r2);
    }

    static /* synthetic */ boolean access$1200(NativePackageDetail r0) {
        return r0.isRiskPermissionChangeBlocked();
    }

    static /* synthetic */ OpsManagerHelper access$1300(NativePackageDetail r0) {
        return r0.mOpsManagerHelper;
    }

    static /* synthetic */ OInsetSheet access$1400(NativePackageDetail r0) {
        return r0.mMenuDialog;
    }

    static /* synthetic */ void access$1500(NativePackageDetail r0, int r1) {
        r0.onMenuItemClickForDangrous(r1);
    }

    static /* synthetic */ void access$1600(NativePackageDetail r0, int r1) {
        r0.onMenuItemClick(r1);
    }

    static /* synthetic */ String access$1700(NativePackageDetail r0, AppNativePermission r1) {
        return r0.getStatusText(r1);
    }

    static /* synthetic */ void access$1800(NativePackageDetail r0) {
        r0.refreshPermissions();
    }

    static /* synthetic */ boolean access$200(NativePackageDetail r0) {
        return r0.mIfMenuDialogCanShow;
    }

    static /* synthetic */ boolean access$202(NativePackageDetail r0, boolean r1) {
        r0.mIfMenuDialogCanShow = r1;
        return r1;
    }

    static /* synthetic */ View access$300(NativePackageDetail r0) {
        return r0.mClickedView;
    }

    static /* synthetic */ View access$302(NativePackageDetail r0, View r1) {
        r0.mClickedView = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(NativePackageDetail r0) {
        return r0.canClosePermission();
    }

    static /* synthetic */ long access$500(NativePackageDetail r2) {
        return r2.mToastShowTime;
    }

    static /* synthetic */ long access$502(NativePackageDetail r0, long r1) {
        r0.mToastShowTime = r1;
        return r1;
    }

    static /* synthetic */ PackageInfo access$600(NativePackageDetail r0) {
        return r0.mPackageInfo;
    }

    static /* synthetic */ int access$700(NativePackageDetail r0) {
        return r0.mLinAnim;
    }

    static /* synthetic */ int access$800(NativePackageDetail r0) {
        return r0.mRoutAnim;
    }

    static /* synthetic */ AppOpsManager access$900(NativePackageDetail r0) {
        return r0.mAppOpsManager;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_detail);
        if (isInKeyuard() == false) goto L5;
        getWindow().addFlags(524288);
    L5:
        AnonymousClass1 r0 = null;
        getWindow().setBackgroundDrawable(null);
        initTitleBar(false);
        this.mRinAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_right", "anim", R.anim.slide_in_from_right);
        this.mLoutAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_left", "anim", R.anim.slide_out_to_left);
        this.mLinAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.mRoutAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        this.mPM = getPackageManager();
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        this.mInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.mSingleThreadExecutor = Executors.newSingleThreadExecutor();
        initData(getIntent());
        this.mAppOpsManager = (AppOpsManager) getSystemService("appops");
        this.animInLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.animOutRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        this.mMenuDialog = new OInsetSheet(this);
        OScrollView r1 = (OScrollView) findViewById(R.id.scroller);
        if (r1 == null) goto L8;
        r1.setOverScrollMode(0);
    L8:
        IntentFilter r2 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r2.addDataScheme("package");
        BroadcastReceiver r3 = new AnonymousClass1(this);
        this.mPackageReceiver = r3;
        registerReceiver(r3, r2);
        if (Utils.isDesktop(this) == false) goto L11;
        IntentFilter r4 = new IntentFilter(DangerousPermissionUtil.BROADCAST_PERMISSION_CHANGE_ACTION);
        PermissionReceiver r5 = new PermissionReceiver(this, r0);
        this.mPermissionReceiver = r5;
        registerReceiver(r5, r4);
    L11:
        this.mScreenRecordObserver = new ScreenRecordObserver(this, new Handler());
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("screen_recorder_show_status"), false, this.mScreenRecordObserver);
        updateViewWidth(R.id.ll_container);
        jumpToPermissionManagePage();
    }

    private void jumpToPermissionManagePage() {
        if (this.mPackageInfo != null) goto L10;
        Intent r0 = getIntent();
        if (r0 == null) goto L10;
        Parcelable r1 = r0.getParcelableExtra("detail");
        if ((r1 instanceof PackageInfo) == false) goto L10;
        PackageInfo r2 = (PackageInfo) r1;
        this.mPackageInfo = r2;
        this.mAppUid = r2.applicationInfo.uid;
        this.mAppPackageName = this.mPackageInfo.packageName;
    L10:
        if (this.mPackageInfo != null) goto L13;
        LogTag.e(TAG, "jumpToPermissionManagePage: mPackageInfo is null, skip jump.");
        return;
    L13:
        String r3 = this.mAppPackageName;
        if (TextUtils.isEmpty(r3) == false) goto L17;
        r3 = this.mPackageInfo.packageName;
    L17:
        if (TextUtils.isEmpty(r3) == false) goto L20;
        LogTag.e(TAG, "jumpToPermissionManagePage: targetPackageName is empty, skip jump.");
        return;
    L20:
        Intent r4 = new Intent("com.android.permissioncontroller.permissionplus.AppPermissionGroup");
        r4.setPackage("com.android.permissioncontroller");
        r4.putExtra("android.intent.extra.PACKAGE_NAME", r3);
        r4.putExtra("USER", UserHandle.of(UserHandle.getUserId(this.mAppUid)));     // Catch: Throwable -> L23
    L25:
        String r5 = null;
        PackageManager r6 = this.mPM;     // Catch: PackageManager.NameNotFoundException -> L34
        if (r6 == null) goto L36;
        ApplicationInfo r7 = r6.getApplicationInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L34
        if (r7 == null) goto L36;
        CharSequence r8 = r7.loadLabel(this.mPM);     // Catch: PackageManager.NameNotFoundException -> L34
        if (r8 == null) goto L36;
        r5 = r8.toString();     // Catch: PackageManager.NameNotFoundException -> L34
    L36:
        if (TextUtils.isEmpty(r5) == true) goto L45;
        r4.putExtra("APP_NAME", r5);
    L45:
        startActivity(r4);     // Catch: Exception -> L40
        finish();     // Catch: Exception -> L40
        return;
    L40:
        e = move-exception;
        LogTag.e(TAG, "jumpToPermissionManagePage: startActivity failed: " + e.getMessage());
        return;
    L34:
        LogTag.e(TAG, "jumpToPermissionManagePage: getApplicationInfo failed for pkg=" + r3);
    L23:
        th = move-exception;
        LogTag.e(TAG, "jumpToPermissionManagePage: fail to resolve UserHandle, use default. msg=" + th.getMessage());
        goto L25
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initData(intent);
    }

    private void initData(Intent intent) {
        if (intent != null) goto L16;
        return;
    L16:
        Parcelable r0 = intent.getParcelableExtra("detail");     // Catch: Exception -> L13
        if ((r0 instanceof PackageInfo) == true) goto L8;
        finish();     // Catch: Exception -> L13
        return;
    L8:
        PackageInfo r1 = (PackageInfo) r0;     // Catch: Exception -> L13
        this.mPackageInfo = r1;     // Catch: Exception -> L13
        this.mAppUid = r1.applicationInfo.uid;     // Catch: Exception -> L13
        this.mAppPackageName = this.mPackageInfo.packageName;     // Catch: Exception -> L13
        boolean r3 = intent.getBooleanExtra(Utils.INTENT_KEY_SHOW_ICON, true);     // Catch: Exception -> L13
        this.mShowAppInfo = r3;     // Catch: Exception -> L13
        if (r3 == false) goto L11;
        setAppLabelAndIcon(this.mPackageInfo);     // Catch: Exception -> L13
    L11:
        setupViews();     // Catch: Exception -> L13
        refreshPermissions();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        refreshPermissions();
    }

    private void refreshPermissions() {
        if (this.mRefreshing == true) goto L6;
        new AppNativePermissionLoader(this, this.mPackageInfo, this).execute(new Void[0]);
        this.mRefreshing = true;
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        refreshPermissions();
    }

    @Override // com.bytedanceos.security.permission.AppNativePermissionLoader.AppPermissionLoaderListener
    public void onLoadFinish(List<NativePermissionGroup> groups) {
        this.mRefreshing = false;
        if (groups != null) goto L5;
    L34:
        View r12 = findViewById(R.id.all_permission);
        if (r12 == null) goto L51;
        r12.setVisibility(8);
        return;
    L51:
        return;
    L5:
        if (groups.size() < 1) goto L34;
        LinearLayout r2 = (LinearLayout) findViewById(R.id.detail_container);
        this.mDetailContainer = r2;
        if (r2 != null) goto L10;
        return;
    L10:
        r2.removeAllViews();
        boolean r3 = PermissionUtil.hasPermission(this.mPM, this.mPackageInfo.packageName, "android.permission.ACCESS_NOTIFICATION_POLICY");
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -2);
        r4.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.dimen_4));
        Iterator<NativePermissionGroup> r13 = groups.iterator();
    L12:
        if (r13.hasNext() == false) goto L30;
        NativePermissionGroup r5 = r13.next();
        List<AppNativePermission> r6 = r5.getAllPermissions();
        if (r6 == null) goto L12;
        if (r6.size() < 1) goto L12;
        int r7 = r6.size();
        TextView r8 = (TextView) this.mInflater.inflate(R.layout.detail_group_title, null);
        r8.setText(getString(r5.getLabelRes()));
        r8.setLayoutParams(r4);
        this.mDetailContainer.addView(r8);
        if (9 != r5.getType()) goto L22;
        if (r3 == false) goto L22;
        r7 = r7 + 1;
    L22:
        Iterator<AppNativePermission> r9 = r6.iterator();
        int r10 = 0;
    L24:
        if (r9.hasNext() == false) goto L27;
        int r11 = r10 + 1;
        this.mDetailContainer.addView(setupItemView(r9.next(), r7, r10));
        r10 = r11;
        goto L24
    L27:
        if (9 != r5.getType()) goto L12;
        if (r3 == false) goto L12;
        this.mDetailContainer.addView(setupZenAccessItemView(r7, r10));
        goto L12
    L30:
        OListItemSettings r14 = (OListItemSettings) findViewById(R.id.all_permission);
        this.mViewAllPermission = r14;
        if (r14 == null) goto L50;
        r14.setTitleString(getString(R.string.app_permission_detail));
        this.mViewAllPermission.setOnClickListener(this);
        return;
    }

    private void setupViews() {
        if (this.mShowAppInfo == false) goto L5;
        this.mTitle.setCenterTitle(getResources().getString(R.string.app_name));
        return;
    L5:
        String r0 = this.mPackageInfo.packageName;
        PackageManager r1 = this.mPM;     // Catch: PackageManager.NameNotFoundException -> L13
        if (r1 != null) goto L9;
        return;
    L9:
        ApplicationInfo r2 = r1.getApplicationInfo(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r2 == null) goto L18;
        this.mTitle.setCenterTitle(r2.loadLabel(this.mPM).toString());     // Catch: PackageManager.NameNotFoundException -> L13
        return;
    L18:
        return;
    L13:
        LogTag.e(TAG, " package not found " + r0);
    }

    private String getStatusText(AppNativePermission item) {
        String r0 = getResources().getString(R.string.permission_status_not_set);
        if (item.isDangerous() == true) goto L16;
        int r5 = item.getPermissionStatusMode();
        if (OpsManagerHelper.get_MODE_ALLOWED() != r5) goto L8;
        return getResources().getString(R.string.permission_status_allow);
    L8:
        if (OpsManagerHelper.get_MODE_ASK() != r5) goto L11;
        return getResources().getString(R.string.permission_status_prompt);
    L11:
        if (OpsManagerHelper.get_MODE_IGNORED() != r5) goto L14;
        return getResources().getString(R.string.permission_status_deny);
    L14:
        if (OpsManagerHelper.get_MODE_DURING_USE() == r5) goto L28;
        return r0;
    L28:
        return getResources().getString(R.string.permission_status_foreground_allow);
    L16:
        boolean r1 = item.foregroundPermissionGranted();
        boolean r6 = item.backgroudPermissionGranted();
        if (r1 == false) goto L20;
        if (r6 == false) goto L20;
        return getResources().getString(R.string.permission_status_allow);
    L20:
        if (r1 == false) goto L23;
        return getResources().getString(R.string.permission_allow_in_use);
    L23:
        return getResources().getString(R.string.permission_status_deny);
    }

    private View setupItemView(final AppNativePermission r8, int r9, int r10) {
        int r0 = r8.getShowMode();
        RelativeLayout r4 = null;
        if (r0 != 1) goto L5;
        r4 = (RelativeLayout) this.mInflater.inflate(R.layout.detail_item_switch, null);
        final OListItemSwitch r1 = (OListItemSwitch) r4.findViewById(R.id.app_info);
        OListItemSettings r2 = r1;
        if (r1 != null) goto L16;
    L24:
        if (r4 == null) goto L40;
        View r3 = r4.findViewById(R.id.empty_view);
        if (r3 == null) goto L28;
        r3.setVisibility(8);
    L28:
        if (r2 == null) goto L39;
        r2.setTitleString(getString(r8.getLabelRes()));
        if (r9 != 1) goto L33;
        if (r3 == null) goto L39;
        r3.setVisibility(0);
        goto L39
    L33:
        if (r10 == 0) goto L39;
        if (r10 != (r9 - 1)) goto L39;
        if (r3 == null) goto L39;
        r3.setVisibility(0);
    L39:
        r4.setTag(r8);
    L40:
        return r4;
    L16:
        if (r8.getPermissionName().equals(NativePermissionManager.PERMISSION_STORAGE_ALL) == false) goto L19;
        r1.setChecked(SpecailPermissionUtil.checkPermission(this.mAppOpsManager, this.mAppUid, this.mAppPackageName));
    L23:
        r1.getMTrailingElement().getChildAt(0).setOnTouchListener(new AnonymousClass3(this, r1));
        r1.setOnCheckedChangeListener(new AnonymousClass4(this, r8, r1));
        r2 = r1;
        goto L24
    L19:
        if (r8.getPermissionStatusMode() != OpsManagerHelper.get_MODE_ALLOWED()) goto L21;
        boolean r5 = true;
    L22:
        r1.setChecked(r5);
        goto L23
    L21:
        r5 = false;
        goto L22
    L5:
        if (r0 != 2) goto L7;
    L9:
        r4 = (RelativeLayout) this.mInflater.inflate(R.layout.detail_item_radio, null);
        OListItemSettings r6 = (OListItemSettings) r4.findViewById(R.id.app_info);
        r4.setOnClickListener(this.mOnItemClickListener);
        r2 = r6;
        if (r6 == null) goto L24;
        r6.setTrailingText(getStatusText(r8));
        r2 = r6;
        goto L24
    L7:
        if (r0 == 3) goto L9;
        r2 = null;
        goto L24
    }

    private View setupZenAccessItemView(final int count, final int index) {
        RelativeLayout r0 = (RelativeLayout) this.mInflater.inflate(R.layout.detail_item_radio, null);
        OListItemSettings r1 = (OListItemSettings) r0.findViewById(R.id.app_info);
        final boolean r2 = PermissionUtil.hasNotificationAccess(getBaseContext(), this.mAppPackageName);
        r1.setEnabled(!r2);
        final boolean r3 = hasAccess(getBaseContext(), this.mPackageInfo.packageName);
        if (r3 == false) goto L5;
        int r4 = R.string.permission_allow_button;
    L6:
        r1.setTrailingText(getString(r4));
        r0.setOnClickListener(new AnonymousClass5(this, r2, r3));
        if (r0 == null) goto L22;
        View r5 = r0.findViewById(R.id.empty_view);
        if (r5 == null) goto L11;
        r5.setVisibility(8);
    L11:
        if (r1 == null) goto L22;
        r1.setTitleString(getString(R.string.manage_zen_access_title));
        if (count != 1) goto L16;
        if (r5 == null) goto L22;
        r5.setVisibility(0);
        goto L22
    L16:
        if (index == 0) goto L22;
        if (index != (count - 1)) goto L22;
        if (r5 == null) goto L22;
        r5.setVisibility(0);
    L22:
        return r0;
    L5:
        r4 = R.string.permission_status_deny;
        goto L6
    }

    public boolean hasAccess(Context context, String pkg) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGrantedForPackage(pkg);
    }

    public void onSwitchDangerousPermission(final AppNativePermission item, final boolean checked) {
        if (item != null) goto L5;
        return;
    L5:
        if (isRiskPermissionChangeBlocked() == false) goto L8;
        RiskPermissionControlGuard.showBlockedToast(this);
        return;
    L8:
        this.mSingleThreadExecutor.execute(new AnonymousClass6(this, checked, item));
    }

    public void onSwitchSpecialPermission(final AppNativePermission item, final boolean checked) {
        if (item != null) goto L5;
        return;
    L5:
        if (isRiskPermissionChangeBlocked() == false) goto L8;
        RiskPermissionControlGuard.showBlockedToast(this);
        return;
    L8:
        this.mSingleThreadExecutor.execute(new AnonymousClass7(this, item, checked));
    }

    public void onSwitchSmtPermission(final OListItemSwitch switcher, final AppNativePermission item, boolean checked) {
        if (isRiskPermissionChangeBlocked() == false) goto L6;
        RiskPermissionControlGuard.showBlockedToast(this);
        return;
    L6:
        if (checked == false) goto L8;
        final int r0 = OpsManagerHelper.get_MODE_ALLOWED();
    L9:
        item.setPermissionStatus(r0);
        final int r4 = item.getOpCode();
        if (r4 != OpsManagerHelper.get_OP_REQUEST_INSTALL_PACKAGES()) goto L13;
        if (checked == false) goto L13;
        AlertDialog r3 = new AlertDialog.Builder(this, 5).setTitle(R.string.first_launch_dialog_title).setMessage(R.string.install_all_warning).setPositiveButton(R.string.first_launch_dialog_possitive, new AnonymousClass9(this, r4, r0)).setNegativeButton(R.string.first_launch_dialog_negative, new AnonymousClass8(this, switcher)).create();
        this.mPermissionDialog = r3;
        r3.setOnKeyListener(new AnonymousClass10(this));
        this.mPermissionDialog.setCancelable(false);
        this.mPermissionDialog.show();
        return;
    L13:
        this.mOpsManagerHelper.setMode(r4, this.mPackageInfo.applicationInfo.uid, this.mPackageInfo.packageName, r0);
        return;
    L8:
        r0 = OpsManagerHelper.get_MODE_IGNORED();
        goto L9
    }

    private void sendPermissionChangeBroadCast(String permission, boolean granted) {
        if (this.mPackageInfo != null) goto L5;
        return;
    L5:
        Intent r0 = new Intent(DangerousPermissionUtil.BROADCAST_PERMISSION_CHANGE_ACTION);
        r0.putExtra("package", this.mPackageInfo.packageName);
        r0.putExtra("uid", this.mPackageInfo.applicationInfo.uid);
        r0.putExtra("permission", permission);
        r0.putExtra("granted", granted);
        r0.putExtra(DBHelper.BATTERY_COL_SOURCE, 2);
        sendBroadcast(r0);
    }

    public void showMenuDialog(AppNativePermission permission) {
        prepareMenuDialog(permission);
        this.mMenuDialog.show();
    }

    private void prepareMenuDialog(final AppNativePermission permission) {
        Resources r0 = getResources();
        int r1 = permission.getLabelRes();
        OInsetSheet r2 = new OInsetSheet(this);
        this.mMenuDialog = r2;
        r2.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OInsetSheetTitleBar r3 = new OInsetSheetTitleBar(this);
        r3.setTitleText(r0.getString(R.string.menu_head_text, new Object[]{r0.getString(r1)}));
        r3.setShowLeftBack(false);
        OButton r4 = r3.createNeutralButton(this, r3.mLeftContainer);
        r4.setButtonSourceBitmap(R.drawable.o_ic_close);
        r4.setOnClickListener(new AnonymousClass11(this));
        this.mMenuDialog.setHeaderView(r3);
        this.mMenuDialog.setOnDismissListener(new AnonymousClass12(this));
        if (permission.isDangerous() == true) goto L5;
    L7:
        boolean r5 = true;
    L8:
        View r6 = LayoutInflater.from(this).inflate(R.layout.permission_menu_item, null);
        if (r5 == false) goto L11;
        OListItemSettings r7 = (OListItemSettings) r6.findViewById(R.id.permission_status_allow);
        r7.setVisibility(0);
        r7.mTrailingElement.setVisibility(8);
        r7.setOnClickListener(new AnonymousClass13(this, permission));
    L11:
        OListItemSettings r8 = (OListItemSettings) r6.findViewById(R.id.permission_allow_in_use);
        r8.mTrailingElement.setVisibility(8);
        if (permission.isInUseMode() == false) goto L14;
        r8.setTitleString(r0.getString(R.string.permission_allow_in_use));
    L15:
        r8.setOnClickListener(new AnonymousClass14(this, permission));
        OListItemSettings r9 = (OListItemSettings) r6.findViewById(R.id.permission_status_deny);
        r9.mTrailingElement.setVisibility(8);
        r9.setTitleString(r0.getString(R.string.permission_status_deny));
        r9.setOnClickListener(new AnonymousClass15(this, permission));
        this.mMenuDialog.setContainerView(r6);
        this.mIfMenuDialogCanShow = true;
        return;
    L14:
        r8.setTitleString(r0.getString(R.string.permission_status_prompt));
        goto L15
    L5:
        if (permission.hasBackgroundPermission() == true) goto L7;
        r5 = false;
        goto L8
    }

    private void onMenuItemClick(int position) {
        if (this.mClickedView != null) goto L6;
        return;
    L6:
        if (isRiskPermissionChangeBlocked() == false) goto L9;
        RiskPermissionControlGuard.showBlockedToast(this);
        this.mClickedView = null;
        return;
    L9:
        AppNativePermission r0 = (AppNativePermission) this.mClickedView.getTag();
        int r2 = r0.getOpCode();
        if (position != 0) goto L12;
        r0.setPermissionStatus(OpsManagerHelper.get_MODE_ALLOWED());
        this.mOpsManagerHelper.setMode(r2, this.mAppUid, this.mAppPackageName, OpsManagerHelper.get_MODE_ALLOWED());
    L22:
        OListItemSettings r7 = (OListItemSettings) this.mClickedView.findViewById(R.id.app_info);
        if (r7 == null) goto L25;
        r7.setTrailingText(getStatusText(r0));
    L25:
        this.mClickedView = null;
        return;
    L12:
        if (position != 1) goto L14;
        r0.setPermissionStatus(OpsManagerHelper.get_MODE_ASK());
        this.mOpsManagerHelper.setMode(r2, this.mAppUid, this.mAppPackageName, OpsManagerHelper.get_MODE_ASK());
        goto L22
    L14:
        if (position != 2) goto L16;
        r0.setPermissionStatus(OpsManagerHelper.get_MODE_IGNORED());
        this.mOpsManagerHelper.setMode(r2, this.mAppUid, this.mAppPackageName, OpsManagerHelper.get_MODE_IGNORED());
        goto L22
    L16:
        if (position != 3) goto L22;
        r0.setPermissionStatus(OpsManagerHelper.get_MODE_DURING_USE());
        this.mOpsManagerHelper.setMode(r2, this.mAppUid, this.mAppPackageName, OpsManagerHelper.get_MODE_DURING_USE());
        goto L22
    }

    private void onMenuItemClickForDangrous(final int position) {
        if (this.mClickedView != null) goto L6;
        return;
    L6:
        if (isRiskPermissionChangeBlocked() == false) goto L9;
        RiskPermissionControlGuard.showBlockedToast(this);
        this.mClickedView = null;
        return;
    L9:
        final AppNativePermission r0 = (AppNativePermission) this.mClickedView.getTag();
        Task.execute(new AnonymousClass16(this, position, r0), new AnonymousClass17(this, r0, position), "onMenuItemClickForDangrous");
    }

    private boolean isRiskPermissionChangeBlocked() {
        return RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this, this.mPackageInfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        if (view != this.mViewAllPermission) goto L9;
        Intent r4 = new Intent();
        r4.setClass(this, AllPermissionDetail.class);
        r4.putExtra(Utils.INTENT_KEY_FROM_CENTER, getIntent().getBooleanExtra(Utils.INTENT_KEY_FROM_CENTER, false));
        r4.putExtra(Utils.INTENT_KEY_INFO, this.mPackageInfo);
        r4.putExtra(Utils.INTENT_KEY_SHOW_ICON, this.mShowAppInfo);
        startActivity(r4);
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
        if (isInKeyuard() == false) goto L6;
        ReflectHelper.setForceHideKeyguard();
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver r0 = this.mPackageReceiver;
        if (r0 == null) goto L6;
        unregisterReceiver(r0);
    L6:
        if (this.mScreenRecordObserver == null) goto L9;
        getContentResolver().unregisterContentObserver(this.mScreenRecordObserver);
    L9:
        if (Utils.isDesktop(this) == false) goto L13;
        PermissionReceiver r1 = this.mPermissionReceiver;
        if (r1 == null) goto L13;
        unregisterReceiver(r1);
    L13:
        ExecutorService r2 = this.mSingleThreadExecutor;
        if (r2 == null) goto L17;
        r2.shutdown();
        return;
    }

    private void setAppLabelAndIcon(PackageInfo packageInfo) {
        if (packageInfo != null) goto L4;
        return;
    L4:
        View r0 = findViewById(R.id.first_empty_view);
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        View r1 = findViewById(R.id.app_snippet);
        if (r1 == null) goto L25;
        r1.setVisibility(0);
        ImageView r2 = (ImageView) r1.findViewById(R.id.app_icon);
        AppEntry r3 = new AppEntry(this, packageInfo.applicationInfo);
        if (r2 == null) goto L12;
        r2.setImageDrawable(r3.getIcon());
    L12:
        ImageView r4 = (ImageView) r1.findViewById(R.id.iv_doppleganger_icon);
        r4.setImageResource(R.color.transparent);
        if (r3.isDoppleganger == false) goto L15;
        r4.setImageResource(R.drawable.oic_doppleganger_badge);
    L15:
        TextView r5 = (TextView) r1.findViewById(R.id.app_name);
        if (r5 == null) goto L18;
        r5.setText(r3.getLabel());
    L18:
        TextView r6 = (TextView) r1.findViewById(R.id.app_size);
        if (r6 != null) goto L21;
        return;
    L21:
        if (packageInfo.versionName == null) goto L23;
        r6.setText(getString(R.string.version_text, new Object[]{String.valueOf(packageInfo.versionName)}));
        return;
    L23:
        r6.setVisibility(4);
        return;
    }

    private boolean isInKeyuard() {
        KeyguardManager r1 = (KeyguardManager) getSystemService("keyguard");
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.inKeyguardRestrictedInputMode();
    }

    private boolean canClosePermission() {
        if (TextUtils.equals(OpenSystemConstant.PKG_SCREEN_RECORDER, this.mAppPackageName) == true) goto L6;
        return true;
    L6:
        return !Utils.screenRecordIsShowing(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
