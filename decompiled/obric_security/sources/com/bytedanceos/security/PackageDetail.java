package com.bytedanceos.security;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.util.Features;
import bytedanceos.util.LogTag;
import com.bytedanceos.application.AppEntry;
import com.bytedanceos.application.AppListLoader;
import com.bytedanceos.cleaner.widget.SimpleSettingItemText;
import com.bytedanceos.security.permission.RiskPermissionControlGuard;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.HashMap;
import obric.app.MenuDialog;
import obric.widget.ListContentItem;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class PackageDetail extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "PackageDetail";
    private int animInLeft;
    private int animOutRight;
    private int mClickedItemIndex;
    private View mClickedView;
    private LinearLayout mDetailContainer;
    private boolean mFromManageUnknownAppSource;
    private boolean mIfMenuDialogCanShow;
    private LayoutInflater mInflater;
    private MenuDialog mMenuDialog;
    private View.OnClickListener mOnItemClickListener;
    private OpsManagerHelper mOpsManagerHelper;
    private PackageManager mPM;
    private PackageInfo mPackageInfo;
    private PackagePermissions mPackagePermissions;
    private BroadcastReceiver mPackageReceiver;
    private AlertDialog mPermissionDialog;
    private boolean mRiskPermissionReverting;
    private boolean mSetCheckUnknownAppSource;
    private int mSetupOP;
    private SimpleSettingItemText mViewAllPermission;

    public PackageDetail() {
        this.mIfMenuDialogCanShow = true;
        this.mOnItemClickListener = new AnonymousClass2(this);
    }

    static /* synthetic */ PackagePermissions access$000(PackageDetail r0) {
        return r0.mPackagePermissions;
    }

    static /* synthetic */ boolean access$100(PackageDetail r0) {
        return r0.mIfMenuDialogCanShow;
    }

    static /* synthetic */ boolean access$102(PackageDetail r0, boolean r1) {
        r0.mIfMenuDialogCanShow = r1;
        return r1;
    }

    static /* synthetic */ int access$202(PackageDetail r0, int r1) {
        r0.mClickedItemIndex = r1;
        return r1;
    }

    static /* synthetic */ View access$302(PackageDetail r0, View r1) {
        r0.mClickedView = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(PackageDetail r0) {
        return r0.mRiskPermissionReverting;
    }

    static /* synthetic */ boolean access$402(PackageDetail r0, boolean r1) {
        r0.mRiskPermissionReverting = r1;
        return r1;
    }

    static /* synthetic */ boolean access$500(PackageDetail r0) {
        return r0.isRiskPermissionChangeBlocked();
    }

    static /* synthetic */ AlertDialog access$600(PackageDetail r0) {
        return r0.mPermissionDialog;
    }

    static /* synthetic */ AlertDialog access$602(PackageDetail r0, AlertDialog r1) {
        r0.mPermissionDialog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$702(PackageDetail r0, boolean r1) {
        r0.mSetCheckUnknownAppSource = r1;
        return r1;
    }

    static /* synthetic */ OpsManagerHelper access$800(PackageDetail r0) {
        return r0.mOpsManagerHelper;
    }

    static /* synthetic */ void access$900(PackageDetail r0, int r1) {
        r0.onMenuItemClick(r1);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_detail);
        getWindow().setBackgroundDrawable(null);
        initTitleBar(false);
        this.mPM = getPackageManager();
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        this.mInflater = (LayoutInflater) getSystemService("layout_inflater");
        Intent r0 = getIntent();
        Parcelable r1 = r0.getParcelableExtra("detail");     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        if ((r1 instanceof PackagePermissions) == false) goto L7;
        this.mPackagePermissions = (PackagePermissions) r1;     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        goto L22
    L7:
        if ((r1 instanceof PackageInfo) == false) goto L9;
        PackageInfo r2 = (PackageInfo) r1;     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        this.mPackageInfo = r2;     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        this.mPackagePermissions = PackagesListLoader.getEntry(r2, this.mPM);     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        setAppLabelAndIcon(this.mPackageInfo);     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        goto L22
    L9:
        if (r1 != null) goto L22;
        if ("android.settings.MANAGE_UNKNOWN_APP_SOURCES".equals(r0.getAction()) == false) goto L22;
        Uri r3 = r0.getData();     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        if (r3 == null) goto L22;
        String r4 = r3.getSchemeSpecificPart();     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        PackageManager r5 = this.mPM;     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        if (r5 == null) goto L17;
        this.mPackageInfo = r5.getPackageInfo(r4, 0);     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
    L17:
        this.mPackagePermissions = PackagesListLoader.getEntry(this.mPackageInfo, this.mPM);     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        setAppLabelAndIcon(this.mPackageInfo);     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
        this.mFromManageUnknownAppSource = true;     // Catch: PackageManager.NameNotFoundException -> L19 RuntimeException -> L30
    L19:
        e = move-exception;
        e.printStackTrace();
    L22:
        if (this.mPackagePermissions != null) goto L25;
        LogTag.e(TAG, "invalid intent, no detail data");
        finish();
        return;
    L25:
        this.animInLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.animOutRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        this.mMenuDialog = new MenuDialog(this);
        this.mSetupOP = r0.getIntExtra(Utils.INTENT_KEY_OPS, -1);
        LogTag.i(TAG, "package detail for " + this.mPackagePermissions.getPackageName());
        OScrollView r6 = (OScrollView) findViewById(R.id.scroller);
        if (r6 == null) goto L28;
        r6.setOverScrollMode(0);
    L28:
        IntentFilter r7 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r7.addDataScheme("package");
        BroadcastReceiver r8 = new AnonymousClass1(this);
        this.mPackageReceiver = r8;
        registerReceiver(r8, r7);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setupViews();
    }

    private void setupViews() {
        int r2 = 0;
        if (this.mPackageInfo == null) goto L5;
        this.mTitle.setCenterTitle(getResources().getString(R.string.app_name));
    L16:
        if (this.mFromManageUnknownAppSource == false) goto L18;
        this.mTitle.removeAllStartAction();
    L18:
        LinearLayout r1 = (LinearLayout) findViewById(R.id.detail_container);
        this.mDetailContainer = r1;
        if (r1 == null) goto L21;
        r1.removeAllViews();
    L21:
        HashMap<Integer, PermissionGroup> r3 = this.mPackagePermissions.getGroupMap();
        boolean r4 = Features.isFeatureCMCCEnabled(this).booleanValue();
        int r5 = 0;
        View r6 = null;
    L23:
        if (r5 > 5) goto L44;
        if (r3.containsKey(Integer.valueOf(r5)) == false) goto L43;
        if (r5 != 0) goto L31;
        if (r4 == false) goto L31;
        if (AppListLoader.CMCC10086.equals(this.mPackagePermissions.getPackageName()) == true) goto L43;
    L31:
        TextView r7 = (TextView) this.mInflater.inflate(R.layout.detail_group_title, null);
        r7.setText(getString(getResources().getIdentifier(Utils.mGroupResName[r5], "string", getPackageName())));
        this.mDetailContainer.addView(r7);
        ArrayList<PermissionItem> r8 = r3.get(Integer.valueOf(r5)).getIncludePermissions();
        int r9 = r8.size();
        int r10 = r2;
    L32:
        if (r10 >= r9) goto L43;
        PermissionItem r11 = r8.get(r10);
        int r12 = r11.getId();
        if (r12 == 11) goto L36;
    L38:
        r11.setMode(this.mOpsManagerHelper.getMode(this.mPackagePermissions.getUid(), this.mPackagePermissions.getPackageName(), Utils.mOpCodes[r12]));
        View r13 = setupItemView(r11, r9, r10);
        this.mDetailContainer.addView(r13);
        int r14 = this.mSetupOP;
        if (r14 == (-1)) goto L42;
        if (r14 != r12) goto L42;
        r6 = r13;
    L42:
        r10 = r10 + 1;
        goto L32
    L36:
        if (Utils.isNfcSupport(this) == true) goto L38;
    L43:
        r5 = r5 + 1;
        r2 = 0;
        goto L23
    L44:
        SimpleSettingItemText r15 = (SimpleSettingItemText) findViewById(R.id.all_permission);
        this.mViewAllPermission = r15;
        if (r15 == null) goto L47;
        r15.setTitle(getString(R.string.app_permission_detail));
        this.mViewAllPermission.setOnClickListener(this);
    L47:
        if (r6 == null) goto L60;
        this.mSetupOP = -1;
        this.mOnItemClickListener.onClick(r6);
        return;
    L60:
        return;
    L5:
        String r16 = this.mPackagePermissions.getPackageName();
        PackageManager r17 = this.mPM;     // Catch: PackageManager.NameNotFoundException -> L14
        if (r17 == null) goto L16;
        ApplicationInfo r18 = r17.getApplicationInfo(r16, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        OFloatingTitleBar r19 = this.mTitle;     // Catch: PackageManager.NameNotFoundException -> L14
        if (r18 != null) goto L11;
        String r20 = "";
    L12:
        r19.setCenterTitle(r20);     // Catch: PackageManager.NameNotFoundException -> L14
        goto L16
    L11:
        r20 = r18.loadLabel(this.mPM).toString();     // Catch: PackageManager.NameNotFoundException -> L14
    L14:
        LogTag.e(TAG, " package not found " + r16);
        goto L16
    }

    private String getStatusText(PermissionItem item) {
        String r0 = getResources().getString(R.string.permission_status_not_set);
        int r3 = item.getMode();
        if (OpsManagerHelper.get_MODE_ALLOWED() != r3) goto L6;
        return getResources().getString(R.string.permission_status_allow);
    L6:
        if (OpsManagerHelper.get_MODE_ASK() != r3) goto L9;
        return getResources().getString(R.string.permission_status_prompt);
    L9:
        if (OpsManagerHelper.get_MODE_IGNORED() != r3) goto L12;
        return getResources().getString(R.string.permission_status_deny);
    L12:
        if (OpsManagerHelper.get_MODE_DURING_USE() == r3) goto L14;
        return r0;
    L14:
        return getResources().getString(R.string.permission_status_foreground_allow);
    }

    private View setupItemView(final PermissionItem r11, int r12, int r13) {
        int r0 = r11.getType();
        RelativeLayout r5 = null;
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L7;
        ListContentItem r1 = null;
    L16:
        if (r5 == null) goto L34;
        if (r1 == null) goto L34;
        View r2 = r5.findViewById(R.id.empty_view);
        r1.setTitle(getString(getResources().getIdentifier(Utils.mShortNames[r11.getId()], "string", getPackageName())));
        if (r2 == null) goto L21;
        r2.setVisibility(8);
    L21:
        if (r12 != 1) goto L25;
        r1.setBackgroundStyle(1);
        if (r2 == null) goto L33;
        r2.setVisibility(0);
    L33:
        r5.setTag(r11);
        goto L34
    L25:
        if (r13 != 0) goto L28;
        r1.setBackgroundStyle(2);
        goto L33
    L28:
        if (r13 != (r12 - 1)) goto L32;
        r1.setBackgroundStyle(4);
        if (r2 == null) goto L33;
        r2.setVisibility(0);
        goto L33
    L32:
        r1.setBackgroundStyle(3);
    L34:
        return r5;
    L7:
        r5 = (RelativeLayout) this.mInflater.inflate(R.layout.detail_item_switch, null);
        final ListContentItemSwitch r3 = (ListContentItemSwitch) r5.findViewById(R.id.app_info);
        r1 = r3;
        if (r3 == null) goto L16;
        if (r11.getMode() != OpsManagerHelper.get_MODE_ALLOWED()) goto L13;
        boolean r4 = true;
    L14:
        r3.setChecked(r4);
        r3.setOnCheckedChangeListener(new AnonymousClass3(this, r3, r11));
        r1 = r3;
        goto L16
    L13:
        r4 = false;
    L15:
        r5 = (RelativeLayout) this.mInflater.inflate(R.layout.detail_item_radio, null);
        ListContentItemText r6 = (ListContentItemText) r5.findViewById(R.id.app_info);
        r6.setSubtitle(getStatusText(r11));
        r5.setOnClickListener(this.mOnItemClickListener);
        r1 = r6;
        goto L16
    }

    public void showMenuDialog() {
        prepareMenuDialog();
    }

    private void prepareMenuDialog() {
        Resources r0 = getResources();
        r0.getIdentifier(Utils.mShortNames[this.mClickedItemIndex], "string", getPackageName());
        boolean r1 = Utils.mPromptHide[this.mClickedItemIndex];
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r2.add(r0.getString(R.string.permission_status_allow));
        r3.add(new AnonymousClass4(this));
        if (r1 == false) goto L5;
    L8:
        r2.add(r0.getString(R.string.permission_status_deny));
        r3.add(new AnonymousClass7(this));
        return;
    L5:
        if (Utils.mOpCodes[this.mClickedItemIndex][0] != OpsManagerHelper.get_OP_LOCATION()) goto L7;
        r2.add(r0.getString(R.string.permission_status_foreground_allow));
        r3.add(new AnonymousClass5(this));
        goto L8
    L7:
        r2.add(r0.getString(R.string.permission_status_prompt));
        r3.add(new AnonymousClass6(this));
        goto L8
    }

    private void onMenuItemClick(int position) {
        if (this.mClickedView != null) goto L6;
        return;
    L6:
        if (isRiskPermissionChangeBlocked() == false) goto L9;
        RiskPermissionControlGuard.showBlockedToast(this);
        this.mClickedView = null;
        this.mClickedItemIndex = -1;
        return;
    L9:
        PermissionItem r0 = (PermissionItem) this.mClickedView.getTag();
        int r3 = Utils.mOpCodes[r0.getId()][0];
        if (position != 0) goto L12;
        r0.setMode(OpsManagerHelper.get_MODE_ALLOWED());
        this.mOpsManagerHelper.setMode(r3, this.mPackagePermissions.getUid(), this.mPackagePermissions.getPackageName(), OpsManagerHelper.get_MODE_ALLOWED());
    L22:
        ListContentItemText r8 = (ListContentItemText) this.mClickedView.findViewById(R.id.app_info);
        if (r8 == null) goto L25;
        r8.setSubtitle(getStatusText(r0));
    L25:
        this.mClickedView = null;
        this.mClickedItemIndex = -1;
        return;
    L12:
        if (position != 1) goto L14;
        r0.setMode(OpsManagerHelper.get_MODE_ASK());
        this.mOpsManagerHelper.setMode(r3, this.mPackagePermissions.getUid(), this.mPackagePermissions.getPackageName(), OpsManagerHelper.get_MODE_ASK());
        goto L22
    L14:
        if (position != 2) goto L16;
        r0.setMode(OpsManagerHelper.get_MODE_IGNORED());
        this.mOpsManagerHelper.setMode(r3, this.mPackagePermissions.getUid(), this.mPackagePermissions.getPackageName(), OpsManagerHelper.get_MODE_IGNORED());
        goto L22
    L16:
        if (position != 3) goto L22;
        r0.setMode(OpsManagerHelper.get_MODE_DURING_USE());
        this.mOpsManagerHelper.setMode(r3, this.mPackagePermissions.getUid(), this.mPackagePermissions.getPackageName(), OpsManagerHelper.get_MODE_DURING_USE());
        goto L22
    }

    private boolean isRiskPermissionChangeBlocked() {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L5;
        PackagePermissions r1 = this.mPackagePermissions;
        if (r1 != null) goto L11;
        return false;
    L11:
        return RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this, r1.getPackageName(), UserHandle.getUserId(this.mPackagePermissions.getUid()));
    L5:
        return RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this, r0);
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
        r4.putExtra("detail", this.mPackagePermissions);
        r4.putExtra(Utils.INTENT_KEY_INFO, this.mPackageInfo);
        startActivity(r4);
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mFromManageUnknownAppSource == true) goto L5;
    L9:
        super.finish();
        return;
    L5:
        if (this.mSetCheckUnknownAppSource == false) goto L7;
        int r0 = -1;
    L8:
        setResult(r0);
        goto L9
    L7:
        r0 = 0;
        goto L8
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver r0 = this.mPackageReceiver;
        if (r0 == null) goto L6;
        unregisterReceiver(r0);
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
        AppEntry r2 = new AppEntry(this, packageInfo.applicationInfo);
        ImageView r3 = (ImageView) r1.findViewById(R.id.app_icon);
        if (r3 == null) goto L12;
        r3.setImageDrawable(r2.getIcon());
    L12:
        ImageView r4 = (ImageView) r1.findViewById(R.id.iv_doppleganger_icon);
        r4.setImageResource(R.color.transparent);
        if (r2.isDoppleganger == false) goto L15;
        r4.setImageResource(R.drawable.oic_doppleganger_badge);
    L15:
        TextView r5 = (TextView) r1.findViewById(R.id.app_name);
        if (r5 == null) goto L18;
        r5.setText(r2.getLabel());
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
}
