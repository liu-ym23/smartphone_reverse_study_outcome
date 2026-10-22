package com.android.settings;

import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.admin.DeviceAdminInfo;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.privacy.GrantUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAdminAdd extends BaseActivity {
    private static final long DELAY_MILLIS = 1000;
    static final int DIALOG_WARNING = 1;
    public static final String EXTRA_CALLED_FROM_SUPPORT_DIALOG = "android.app.extra.CALLED_FROM_SUPPORT_DIALOG";
    public static final String EXTRA_DEVICE_ADMIN_PACKAGE_NAME = "android.app.extra.DEVICE_ADMIN_PACKAGE_NAME";
    private static final int MAX_ADD_MSG_LINES = 15;
    private static final int MAX_ADD_MSG_LINES_LANDSCAPE = 2;
    private static final int MAX_ADD_MSG_LINES_PORTRAIT = 5;
    static final String TAG = "DeviceAdminAdd";
    OButton mActionButton;
    TextView mAddMsg;
    boolean mAddMsgEllipsized;
    ImageView mAddMsgExpander;
    CharSequence mAddMsgText;
    boolean mAdding;
    private OAlertDialog mAddingDialog;
    boolean mAddingProfileOwner;
    TextView mAdminDescription;
    ImageView mAdminIcon;
    TextView mAdminName;
    ViewGroup mAdminPolicies;
    boolean mAdminPoliciesInitialized;
    TextView mAdminWarning;
    AppOpsManager mAppOps;
    int mCurSysAppOpMode;
    int mCurToastAppOpMode;
    DevicePolicyManager mDPM;
    DeviceAdminInfo mDeviceAdmin;
    Handler mHandler;
    boolean mIsCalledFromSupportDialog;
    String mProfileOwnerName;
    TextView mProfileOwnerWarning;
    boolean mRefreshing;
    boolean mUninstalling;
    boolean mWaitingForRemoveMsg;

    public void com_android_settings_DeviceAdminAdd__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_DeviceAdminAdd__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DeviceAdminAdd() {
        this.mAddMsgEllipsized = true;
        this.mUninstalling = false;
        this.mIsCalledFromSupportDialog = false;
    }

    static /* synthetic */ OAlertDialog access$000(DeviceAdminAdd r0) {
        return r0.mAddingDialog;
    }

    static /* synthetic */ OAlertDialog access$002(DeviceAdminAdd r0, OAlertDialog r1) {
        r0.mAddingDialog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(DeviceAdminAdd r0, DeviceAdminInfo r1) {
        return r0.isManagedProfile(r1);
    }

    public void com_android_settings_DeviceAdminAdd__onCreate$___twin___(Bundle r13) {
        super.onCreate(r13);
        this.mHandler = new Handler(getMainLooper());
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mAppOps = (AppOpsManager) getSystemService("appops");
        PackageManager r14 = getPackageManager();
        if ((getIntent().getFlags() & 268435456) == 0) goto L6;
        OLog.w(TAG, "Cannot start ADD_DEVICE_ADMIN as a new task");
        finish();
        return;
    L6:
        int r4 = 0;
        this.mIsCalledFromSupportDialog = getIntent().getBooleanExtra(EXTRA_CALLED_FROM_SUPPORT_DIALOG, false);
        String r1 = getIntent().getAction();
        ActivityInfo r3 = null;
        ComponentName r5 = (ComponentName) getIntent().getParcelableExtra("android.app.extra.DEVICE_ADMIN");     // Catch: Exception -> L9
    L11:
        if (r5 != null) goto L17;
        Optional<ComponentName> r6 = findAdminWithPackageName(getIntent().getStringExtra(EXTRA_DEVICE_ADMIN_PACKAGE_NAME));
        if (r6.isPresent() == true) goto L16;
        OLog.w(TAG, "No component specified in " + r1);
        finish();
        return;
    L16:
        r5 = r6.get();
        this.mUninstalling = true;
    L17:
        if (r1 == null) goto L34;
        if (r1.equals("android.app.action.SET_PROFILE_OWNER") == false) goto L34;
        setResult(0);
        setFinishOnTouchOutside(true);
        this.mAddingProfileOwner = true;
        this.mProfileOwnerName = Utils.getStringExtraSafely(getIntent(), "android.app.extra.PROFILE_OWNER_NAME");
        String r2 = getCallingPackage();
        if (r2 != null) goto L23;
    L31:
        OLog.e(TAG, "Unknown or incorrect caller");
        finish();
        return;
    L23:
        if (r2.equals(r5.getPackageName()) == false) goto L31;
    L29:
        OLog.e(TAG, "Cannot find the package " + r2);
        finish();
        return;
    L26:
        if ((r14.getPackageInfo(r2, 0).applicationInfo.flags & 1) != 0) goto L34;
        OLog.e(TAG, "Cannot set a non-system app as a profile owner");     // Catch: PackageManager.NameNotFoundException -> L29
        finish();     // Catch: PackageManager.NameNotFoundException -> L29
        return;
    L34:
        if (r5 != null) goto L103;
    L41:
        DevicePolicyManager r7 = this.mDPM;
        if (r7 != null) goto L44;
    L68:
        ResolveInfo r15 = new ResolveInfo();
        r15.activityInfo = r3;
        this.mDeviceAdmin = new DeviceAdminInfo(this, r15);     // Catch: IOException -> L97 XmlPullParserException -> L100
    L71:
        if ("android.app.action.ADD_DEVICE_ADMIN".equals(getIntent().getAction()) == false) goto L90;
        this.mRefreshing = false;
        if (this.mDPM.isAdminActive(r5) == false) goto L90;
        if (this.mDPM.isRemovingAdmin(r5, Process.myUserHandle().getIdentifier()) == false) goto L78;
        OLog.w(TAG, "Requested admin is already being removed: " + r5);
        finish();
        return;
    L78:
        ArrayList r16 = this.mDeviceAdmin.getUsedPolicies();
    L80:
        if (r4 >= r16.size()) goto L86;
        if (this.mDPM.hasGrantedPolicy(r5, ((DeviceAdminInfo.PolicyInfo) r16.get(r4)).ident) == false) goto L83;
        r4 = r4 + 1;
        goto L80
    L83:
        this.mRefreshing = true;
    L86:
        if (this.mRefreshing == true) goto L90;
        setResult(-1);
        finish();
        return;
    L90:
        if (this.mAddingProfileOwner == true) goto L92;
    L95:
        this.mAddMsgText = getIntent().getCharSequenceExtra("android.app.extra.ADD_EXPLANATION");
        setContentView(R.layout.device_admin_add);
        this.mAdminIcon = (ImageView) findViewById(R.id.admin_icon);
        this.mAdminName = (TextView) findViewById(R.id.admin_name);
        this.mAdminDescription = (TextView) findViewById(R.id.admin_description);
        this.mProfileOwnerWarning = (TextView) findViewById(R.id.profile_owner_warning);
        this.mAddMsg = (TextView) findViewById(R.id.add_msg);
        this.mAddMsgExpander = (ImageView) findViewById(R.id.add_msg_expander);
        View.OnClickListener r17 = new AnonymousClass1(this);
        this.mAddMsgExpander.setOnClickListener(r17);
        this.mAddMsg.setOnClickListener(r17);
        this.mAddMsg.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(this));
        toggleMessageEllipsis(this.mAddMsg);
        this.mAdminWarning = (TextView) findViewById(R.id.admin_warning);
        this.mAdminPolicies = (ViewGroup) findViewById(R.id.admin_policies);
        OButton r18 = (OButton) findViewById(R.id.action_button);
        this.mActionButton = r18;
        r18.setOnClickListener(new AnonymousClass3(this));
        setupTitleView();
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(findViewById(R.id.fake_status_bar));
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewById(R.id.page_container));
        return;
    L92:
        if (this.mDPM.hasUserSetupCompleted() == true) goto L95;
        addAndFinish();
        return;
    L97:
        e = move-exception;
        OLog.w(TAG, "Unable to retrieve device policy " + r5, e);
        finish();
        return;
    L100:
        e = move-exception;
        OLog.w(TAG, "Unable to retrieve device policy " + r5, e);
        finish();
        return;
    L44:
        if (r7.isAdminActive(r5) == true) goto L68;
        List<ResolveInfo> r19 = r14.queryBroadcastReceivers(new Intent("android.app.action.DEVICE_ADMIN_ENABLED"), 32768);
        if (r19 != null) goto L48;
        int r8 = 0;
    L49:
        int r9 = 0;
    L50:
        if (r9 >= r8) goto L64;
        ResolveInfo r10 = r19.get(r9);
        if (r3 == null) goto L63;
        if (r3.packageName.equals(r10.activityInfo.packageName) == false) goto L63;
        if (r3.name.equals(r10.activityInfo.name) == false) goto L63;
        r10.activityInfo = r3;     // Catch: IOException -> L59 XmlPullParserException -> L61
        new DeviceAdminInfo(this, r10);     // Catch: IOException -> L59 XmlPullParserException -> L61
        boolean r110 = true;
    L65:
        if (r110 == true) goto L68;
        OLog.w(TAG, "Request to add invalid device admin: " + r5);
        finish();
        return;
    L59:
        e = move-exception;
        OLog.w(TAG, "Bad " + r10.activityInfo, e);
    L61:
        e = move-exception;
        OLog.w(TAG, "Bad " + r10.activityInfo, e);
    L63:
        r9 = r9 + 1;
    L64:
        r110 = false;
        goto L65
    L48:
        r8 = r19.size();
        goto L49
    L103:
        r3 = r14.getReceiverInfo(r5, 128);     // Catch: Throwable -> L38
    L38:
        e = move-exception;
        OLog.w(TAG, "Unable to retrieve device policy " + r5, e);
        finish();
        return;
    L9:
        r5 = null;
        goto L11
    }

    private void setupTitleView() {
        if (this.mTitle != null) goto L5;
        return;
    L5:
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass4(this));
        String r0 = getString(R.string.short_cancel);
        Bundle r4 = getIntent().getExtras();
        if (r4 != null) goto L9;
        r4 = new Bundle();
    L9:
        if (r4.containsKey("back_text") == true) goto L12;
        r4.putString("back_text", r0);
        return;
    }

    void addAndFinish() {
        this.mDPM.setActiveAdmin(this.mDeviceAdmin.getComponent(), this.mRefreshing);     // Catch: RuntimeException -> L5
        setResult(-1);     // Catch: RuntimeException -> L5
    L10:
        if (this.mAddingProfileOwner == true) goto L16;
    L14:
        finish();
        return;
    L16:
        this.mDPM.setProfileOwner(this.mDeviceAdmin.getComponent(), UserHandle.myUserId());     // Catch: RuntimeException -> L13
    L13:
        setResult(0);
    L5:
        e = move-exception;
        OLog.w(TAG, "Exception trying to activate admin " + this.mDeviceAdmin.getComponent(), e);
        if (this.mDPM.isAdminActive(this.mDeviceAdmin.getComponent()) == false) goto L10;
        setResult(-1);
        goto L10
    }

    void continueRemoveAction(CharSequence r3) {
        if (this.mWaitingForRemoveMsg == true) goto L5;
        return;
    L5:
        this.mWaitingForRemoveMsg = false;
        if (r3 != null) goto L16;
        ActivityManagerNative.getDefault().resumeAppSwitches();     // Catch: RemoteException -> L12
    L8:
        this.mDPM.removeActiveAdmin(this.mDeviceAdmin.getComponent());
        finish();
        return;
    L16:
        ActivityManagerNative.getDefault().stopAppSwitches();     // Catch: RemoteException -> L13
    L10:
        Bundle r0 = new Bundle();
        r0.putCharSequence("android.app.extra.DISABLE_WARNING", r3);
        showDialog(1, r0);
    }

    public void com_android_settings_DeviceAdminAdd__onResume$___twin___() {
        super.onResume();
        updateInterface();
        int r0 = this.mDeviceAdmin.getActivityInfo().applicationInfo.uid;
        String r1 = this.mDeviceAdmin.getActivityInfo().applicationInfo.packageName;
        this.mCurSysAppOpMode = this.mAppOps.checkOpNoThrow(24, r0, r1);
        this.mCurToastAppOpMode = this.mAppOps.checkOpNoThrow(45, r0, r1);
        this.mAppOps.setMode(24, r0, r1, 1);
        this.mAppOps.setMode(45, r0, r1, 1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
    }

    public void com_android_settings_DeviceAdminAdd__onPause$___twin___() {
        super.onPause();
        int r0 = this.mDeviceAdmin.getActivityInfo().applicationInfo.uid;
        String r1 = this.mDeviceAdmin.getActivityInfo().applicationInfo.packageName;
        this.mAppOps.setMode(24, r0, r1, this.mCurSysAppOpMode);
        this.mAppOps.setMode(45, r0, r1, this.mCurToastAppOpMode);
        ActivityManagerNative.getDefault().resumeAppSwitches();     // Catch: RemoteException -> L5
        return;
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (this.mIsCalledFromSupportDialog == false) goto L6;
        finish();
        return;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r3, Bundle r4) {
        if (r3 != 1) goto L5;
        CharSequence r5 = r4.getCharSequence("android.app.extra.DISABLE_WARNING");
        AlertDialog.Builder r6 = new AlertDialog.Builder(this, getResources().getInteger(R.integer.dialog_style_id));
        r6.setTitle(R.string.warning);
        r6.setMessage(r5);
        r6.setPositiveButton(R.string.dlg_ok, new AnonymousClass5(this));
        r6.setNegativeButton(R.string.dlg_cancel, null);
        return r6.create();
    L5:
        return super.onCreateDialog(r3, r4);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void setTitle(int r1) {
        setTitle(getString(r1));
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void setTitle(CharSequence r3) {
        DeviceAdminInfo r0 = this.mDeviceAdmin;
        if (r0 == null) goto L8;
        CharSequence r1 = r0.loadLabel(getPackageManager());
        if (TextUtils.isEmpty(r1) == true) goto L8;
        super.setTitle(r1);
        return;
    L8:
        super.setTitle(r3);
    }

    void updateInterface() {
        this.mAdminIcon.setImageDrawable(this.mDeviceAdmin.loadIcon(getPackageManager()));
        this.mAdminName.setText(this.mDeviceAdmin.loadLabel(getPackageManager()));
        this.mAdminDescription.setText(this.mDeviceAdmin.loadDescription(getPackageManager()));     // Catch: Resources.NotFoundException -> L5
        this.mAdminDescription.setVisibility(0);     // Catch: Resources.NotFoundException -> L5
    L7:
        if (this.mAddingProfileOwner == false) goto L9;
        this.mProfileOwnerWarning.setVisibility(0);
    L9:
        CharSequence r2 = this.mAddMsgText;
        if (r2 == null) goto L12;
        this.mAddMsg.setText(r2);
        this.mAddMsg.setVisibility(0);
    L14:
        if (this.mRefreshing == false) goto L16;
    L37:
        addDeviceAdminPolicies(true);
        this.mAdminWarning.setText(getString(R.string.device_admin_warning, new Object[]{this.mDeviceAdmin.getActivityInfo().applicationInfo.loadLabel(getPackageManager())}));
        if (this.mAddingProfileOwner == false) goto L40;
        setTitle(getText(R.string.profile_owner_add_title));
    L41:
        this.mActionButton.setText(getText(R.string.add_device_admin));
        isAdminUninstallable();
        this.mAdding = true;
        return;
    L40:
        setTitle(getText(R.string.add_device_admin_msg));
        goto L41
    L16:
        if (this.mAddingProfileOwner == true) goto L37;
        if (this.mDPM.isAdminActive(this.mDeviceAdmin.getComponent()) == false) goto L37;
        this.mAdding = false;
        boolean r0 = this.mDeviceAdmin.getComponent().equals(this.mDPM.getProfileOwner());
        boolean r3 = isManagedProfile(this.mDeviceAdmin);
        if (r0 == false) goto L24;
        if (r3 == false) goto L24;
        this.mAdminWarning.setText(R.string.admin_profile_owner_message);
        this.mActionButton.setText(R.string.remove_managed_profile_label);
    L36:
        this.mDPM.getLongSupportMessageForUser(this.mDeviceAdmin.getComponent(), UserHandle.myUserId());
        return;
    L24:
        if (r0 == false) goto L26;
    L32:
        if (r0 == false) goto L34;
        this.mAdminWarning.setText(R.string.admin_profile_owner_user_message);
    L35:
        this.mActionButton.setText(R.string.remove_device_admin);
        this.mActionButton.setEnabled(false);
        goto L36
    L34:
        this.mAdminWarning.setText(R.string.admin_device_owner_message);
        goto L35
    L26:
        if (this.mDeviceAdmin.getComponent().equals(this.mDPM.getDeviceOwnerComponentOnCallingUser()) == true) goto L32;
        addDeviceAdminPolicies(true);
        this.mAdminWarning.setText(getString(R.string.device_admin_status, new Object[]{this.mDeviceAdmin.getActivityInfo().applicationInfo.loadLabel(getPackageManager())}));
        setTitle(R.string.active_device_admin_msg);
        if (this.mUninstalling == false) goto L31;
        this.mActionButton.setText(R.string.remove_and_uninstall_device_admin);
        goto L36
    L31:
        this.mActionButton.setText(R.string.remove_device_admin);
        goto L36
    L12:
        this.mAddMsg.setVisibility(8);
        this.mAddMsgExpander.setVisibility(8);
    L5:
        this.mAdminDescription.setVisibility(8);
        goto L7
    }

    private void addDeviceAdminPolicies(boolean r10) {
        if (this.mAdminPoliciesInitialized == true) goto L27;
        boolean r0 = UserManager.get(this).isAdminUser();
        ArrayList r1 = this.mDeviceAdmin.getUsedPolicies();
        int r2 = (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
        int r5 = 0;
    L6:
        if (r5 >= r1.size()) goto L22;
        DeviceAdminInfo.PolicyInfo r6 = (DeviceAdminInfo.PolicyInfo) r1.get(r5);
        if (r0 == false) goto L10;
        int r7 = r6.description;
    L11:
        if (r0 == false) goto L13;
        int r8 = r6.label;
    L14:
        CharSequence r9 = getText(r8);
        if (r10 == false) goto L17;
        CharSequence r11 = getText(r7);
    L18:
        View r12 = getPermissionItemViewBytedance(this, r9, r11);
        if (r5 < 0) goto L21;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        r13.setMargins(0, r2, 0, 0);
        r12.setLayoutParams(r13);
    L21:
        this.mAdminPolicies.addView(r12);
        r5 = r5 + 1;
        goto L6
    L17:
        r11 = "";
        goto L18
    L13:
        r8 = r6.labelForSecondaryUsers;
        goto L14
    L10:
        r7 = r6.descriptionForSecondaryUsers;
        goto L11
    L22:
        this.mAdminPoliciesInitialized = true;
        return;
    }

    private View getPermissionItemViewBytedance(Context r2, CharSequence r3, CharSequence r4) {
        View r1 = View.inflate(r2, R.layout.app_permission_item_bytedance, null);
        TextView r5 = (TextView) r1.findViewById(R.id.permission_group);
        TextView r0 = (TextView) r1.findViewById(R.id.permission_list);
        if (r3 == null) goto L5;
        r5.setText(r3);
        r0.setText(r4);
    L6:
        return r1;
    L5:
        r5.setText(r4);
        r0.setVisibility(8);
        goto L6
    }

    void toggleMessageEllipsis(View r2) {
        TextView r3 = (TextView) r2;
        boolean r0 = !this.mAddMsgEllipsized;
        this.mAddMsgEllipsized = r0;
        if (r0 == false) goto L5;
        TextUtils.TruncateAt r1 = TextUtils.TruncateAt.END;
    L6:
        r3.setEllipsize(r1);
        if (this.mAddMsgEllipsized == false) goto L9;
        int r4 = getEllipsizedLines();
    L10:
        r3.setMaxLines(r4);
        ImageView r5 = this.mAddMsgExpander;
        if (this.mAddMsgEllipsized == false) goto L13;
        int r6 = android.R.drawable.ic_media_route_connecting_dark_material;
    L14:
        r5.setImageResource(r6);
        return;
    L13:
        r6 = android.R.drawable.ic_media_route_connecting_dark_30_mtrl;
        goto L14
    L9:
        r4 = 15;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    int getEllipsizedLines() {
        android.view.Display r1 = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        if (r1.getHeight() <= r1.getWidth()) goto L5;
        return 5;
    L5:
        return 2;
    }

    private boolean isManagedProfile(DeviceAdminInfo r1) {
        UserInfo r0 = UserManager.get(this).getUserInfo(UserHandle.getUserId(r1.getActivityInfo().applicationInfo.uid));
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isManagedProfile();
    }

    private Optional<ComponentName> findAdminWithPackageName(final String r2) {
        List<ComponentName> r1 = this.mDPM.getActiveAdmins();
        if (r1 != null) goto L7;
        return Optional.empty();
    L7:
        return r1.stream().filter(new DeviceAdminAdd$$ExternalSyntheticLambda0(r2)).findAny();
    }

    static /* synthetic */ boolean lambda$findAdminWithPackageName$0(String r0, ComponentName r1) {
        return r1.getPackageName().equals(r0);
    }

    private boolean isAdminUninstallable() {
        return !this.mDeviceAdmin.getActivityInfo().applicationInfo.isSystemApp();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DeviceAdminAdd_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DeviceAdminAdd r1) {
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onCreate(DeviceAdminAdd r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceAdminAdd r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_DeviceAdminAdd__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_BatchedActivityLancet_onResume(DeviceAdminAdd r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DeviceAdminAdd r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DeviceAdminAdd r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DeviceAdminAdd r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_DeviceAdminAdd__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_BatchedActivityLancet_onStop(DeviceAdminAdd r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_DeviceAdminAdd_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onResume(DeviceAdminAdd r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceAdminAdd r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_DeviceAdminAdd__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DeviceAdminAdd r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onPause(DeviceAdminAdd r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceAdminAdd r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_DeviceAdminAdd__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DeviceAdminAdd r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DeviceAdminAdd r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_DeviceAdminAdd_com_obric_hook_lancet_PrivacyHook_onStop(DeviceAdminAdd r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DeviceAdminAdd r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_DeviceAdminAdd__onStop$___twin___();
    }
}
