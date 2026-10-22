package com.android.settings.security;

import android.app.Activity;
import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserManager;
import android.security.AppUriAuthenticationPolicy;
import android.security.KeyChain;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RequestManageCredentials extends Activity {
    private static final String TAG = "ManageCredentials";
    private AppUriAuthenticationPolicy mAuthenticationPolicy;
    private LinearLayout mButtonPanel;
    private String mCredentialManagerPackage;
    private boolean mDisplayingButtonPanel;
    private OButton mExtendedFab;
    private boolean mIsLandscapeMode;
    private KeyChain.KeyChainConnection mKeyChainConnection;
    private HandlerThread mKeyChainTread;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public void com_android_settings_security_RequestManageCredentials__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_security_RequestManageCredentials__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_security_RequestManageCredentials__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_security_RequestManageCredentials__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // android.app.Activity
    public void onPause() {
        com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public RequestManageCredentials() {
        this.mDisplayingButtonPanel = false;
        this.mIsLandscapeMode = false;
    }

    static /* synthetic */ boolean access$000(RequestManageCredentials r0) {
        return r0.mDisplayingButtonPanel;
    }

    static /* synthetic */ OButton access$100(RequestManageCredentials r0) {
        return r0.mExtendedFab;
    }

    static /* synthetic */ boolean access$200(RequestManageCredentials r0) {
        return r0.isRecyclerScrollable();
    }

    static /* synthetic */ void access$300(RequestManageCredentials r0) {
        r0.hideButtonPanel();
    }

    static /* synthetic */ void access$400(RequestManageCredentials r0) {
        r0.showButtonPanel();
    }

    public void com_android_settings_security_RequestManageCredentials__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        if ("android.security.MANAGE_CREDENTIALS".equals(getIntent().getAction()) == true) goto L7;
        OLog.e(TAG, "Unable to start activity because intent action is not android.security.MANAGE_CREDENTIALS");
        logRequestFailure();
        finishWithResultCancelled();
        return;
    L7:
        if (isManagedDevice() == false) goto L10;
        OLog.e(TAG, "Credential management on managed devices should be done by the Device Policy Controller, not a credential management app");
        logRequestFailure();
        finishWithResultCancelled();
        return;
    L10:
        String r7 = getLaunchedFromPackage();
        this.mCredentialManagerPackage = r7;
        if (TextUtils.isEmpty(r7) == false) goto L14;
        OLog.e(TAG, "Unknown credential manager app");
        logRequestFailure();
        finishWithResultCancelled();
        return;
    L14:
        DevicePolicyEventLogger.createEvent(178).setStrings(new String[]{this.mCredentialManagerPackage}).write();
        setContentView(R.layout.request_manage_credentials);
        getWindow().addSystemFlags(524288);
        if (getResources().getConfiguration().orientation != 2) goto L17;
        boolean r8 = true;
    L18:
        this.mIsLandscapeMode = r8;
        HandlerThread r9 = new HandlerThread("KeyChainConnection");
        this.mKeyChainTread = r9;
        r9.start();
        this.mKeyChainConnection = getKeyChainConnection(this, this.mKeyChainTread);
        AppUriAuthenticationPolicy r10 = (AppUriAuthenticationPolicy) getIntent().getParcelableExtra("android.security.extra.AUTHENTICATION_POLICY");
        if (isValidAuthenticationPolicy(r10) == true) goto L22;
        OLog.e(TAG, "Invalid authentication policy");
        logRequestFailure();
        finishWithResultCancelled();
        return;
    L22:
        this.mAuthenticationPolicy = r10;
        DevicePolicyEventLogger.createEvent(179).setStrings(new String[]{getNumberOfAuthenticationPolicyApps(this.mAuthenticationPolicy), getNumberOfAuthenticationPolicyUris(this.mAuthenticationPolicy)}).write();
        if (this.mIsLandscapeMode == false) goto L25;
        loadHeader();
    L25:
        loadRecyclerView();
        loadButtons();
        loadExtendedFloatingActionButton();
        addOnScrollListener();
        return;
    L17:
        r8 = false;
        goto L18
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        KeyChain.KeyChainConnection r0 = this.mKeyChainConnection;
        if (r0 == null) goto L6;
        r0.close();
        this.mKeyChainConnection = null;
        this.mKeyChainTread.quitSafely();
        return;
    }

    private boolean isValidAuthenticationPolicy(AppUriAuthenticationPolicy r4) {
        if (r4 != null) goto L5;
    L17:
        return false;
    L5:
        if (r4.getAppAndUriMappings().isEmpty() == true) goto L17;
        Iterator r5 = r4.getAliases().iterator();     // Catch: RemoteException -> L15
    L9:
        if (r5.hasNext() == false) goto L13;
        String r1 = (String) r5.next();     // Catch: RemoteException -> L15
        if (this.mKeyChainConnection.getService().requestPrivateKey(r1) == null) goto L9;
        return false;
    L13:
        return true;
    L15:
        e = move-exception;
        OLog.e(TAG, "Invalid authentication policy", e);
        goto L17
    }

    private boolean isManagedDevice() {
        DevicePolicyManager r0 = (DevicePolicyManager) getSystemService(DevicePolicyManager.class);
        if (r0.getDeviceOwnerUser() == null) goto L5;
    L10:
        return true;
    L5:
        if (r0.getProfileOwner() != null) goto L10;
        if (hasManagedProfile() == true) goto L10;
        return false;
    }

    private boolean hasManagedProfile() {
        Iterator r1 = ((UserManager) getSystemService(UserManager.class)).getProfiles(getUserId()).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (((UserInfo) r1.next()).isManagedProfile() == false) goto L4;
        return true;
    L9:
        return false;
    }

    private void loadRecyclerView() {
        this.mLayoutManager = new LinearLayoutManager(this);
        RecyclerView r0 = (RecyclerView) findViewById(R.id.apps_list);
        this.mRecyclerView = r0;
        r0.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setAdapter(new CredentialManagementAppAdapter(this, this.mCredentialManagerPackage, this.mAuthenticationPolicy.getAppAndUriMappings(), !this.mIsLandscapeMode, false));
    }

    private void loadButtons() {
        this.mButtonPanel = (LinearLayout) findViewById(R.id.button_panel);
        Button r0 = (Button) findViewById(R.id.dont_allow_button);
        r0.setFilterTouchesWhenObscured(true);
        Button r2 = (Button) findViewById(R.id.allow_button);
        r2.setFilterTouchesWhenObscured(true);
        r0.setOnClickListener(new RequestManageCredentials$$ExternalSyntheticLambda1(this));
        r2.setOnClickListener(new RequestManageCredentials$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: lambda$loadButtons$0$com-android-settings-security-RequestManageCredentials, reason: not valid java name */
    /* synthetic */ void m591x7f110ccf(View r1) {
        DevicePolicyEventLogger.createEvent(181).write();
        finishWithResultCancelled();
    }

    /* JADX INFO: renamed from: lambda$loadButtons$1$com-android-settings-security-RequestManageCredentials, reason: not valid java name */
    /* synthetic */ void m592x80475fae(View r1) {
        setOrUpdateCredentialManagementAppAndFinish();
    }

    private void loadExtendedFloatingActionButton() {
        OButton r0 = (OButton) findViewById(R.id.extended_fab);
        this.mExtendedFab = r0;
        r0.setOnClickListener(new RequestManageCredentials$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$loadExtendedFloatingActionButton$2$com-android-settings-security-RequestManageCredentials, reason: not valid java name */
    /* synthetic */ void m593xcfa73621(View r2) {
        if (this.mIsLandscapeMode == false) goto L5;
        int r3 = this.mAuthenticationPolicy.getAppAndUriMappings().size() - 1;
    L6:
        this.mRecyclerView.scrollToPosition(r3);
        this.mExtendedFab.setVisibility(8);
        showButtonPanel();
        return;
    L5:
        r3 = this.mAuthenticationPolicy.getAppAndUriMappings().size();
        goto L6
    }

    private void loadHeader() {
        ImageView r0 = (ImageView) findViewById(R.id.credential_management_app_icon);
        TextView r1 = (TextView) findViewById(R.id.credential_management_app_title);
        ApplicationInfo r5 = getPackageManager().getApplicationInfo(this.mCredentialManagerPackage, 0);     // Catch: PackageManager.NameNotFoundException -> L5
        r0.setImageDrawable(getPackageManager().getApplicationIcon(r5));     // Catch: PackageManager.NameNotFoundException -> L5
        r1.setText(TextUtils.expandTemplate(getText(R.string.request_manage_credentials_title), new CharSequence[]{r5.loadSafeLabel(getPackageManager(), 1000.0f, 5)}));     // Catch: PackageManager.NameNotFoundException -> L5
        return;
    L5:
        r0.setImageDrawable(null);
        r1.setText(TextUtils.expandTemplate(getText(R.string.request_manage_credentials_title), new CharSequence[]{this.mCredentialManagerPackage}));
    }

    private void setOrUpdateCredentialManagementAppAndFinish() {
        this.mKeyChainConnection.getService().setCredentialManagementApp(this.mCredentialManagerPackage, this.mAuthenticationPolicy);     // Catch: RemoteException -> L4
        DevicePolicyEventLogger.createEvent(180).write();     // Catch: RemoteException -> L4
        setResult(-1);     // Catch: RemoteException -> L4
    L6:
        finish();
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "Unable to set credential manager app", e);
        logRequestFailure();
        goto L6
    }

    KeyChain.KeyChainConnection getKeyChainConnection(Context r1, HandlerThread r2) {
        Handler r0 = new Handler(r2.getLooper());
        return KeyChain.bindAsUser(r1, r0, Process.myUserHandle());
    L5:
        e = move-exception;
        throw new RuntimeException("Faile to bind to KeyChain", e);
    }

    private void addOnScrollListener() {
        this.mRecyclerView.addOnScrollListener(new AnonymousClass1(this));
    }

    private void showButtonPanel() {
        int r0 = (int) ((getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        this.mRecyclerView.setPadding(0, 0, 0, r0);
        this.mButtonPanel.setVisibility(0);
        this.mDisplayingButtonPanel = true;
    }

    private void hideButtonPanel() {
        this.mRecyclerView.setPadding(0, 0, 0, 0);
        this.mButtonPanel.setVisibility(8);
    }

    private boolean isRecyclerScrollable() {
        if (this.mLayoutManager != null) goto L5;
        return false;
    L5:
        if (this.mRecyclerView.getAdapter() != null) goto L8;
        return false;
    L8:
        if (this.mLayoutManager.findLastCompletelyVisibleItemPosition() < (this.mRecyclerView.getAdapter().getItemCount() - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    private void finishWithResultCancelled() {
        setResult(0);
        finish();
    }

    private void logRequestFailure() {
        DevicePolicyEventLogger.createEvent(182).write();
    }

    private String getNumberOfAuthenticationPolicyUris(AppUriAuthenticationPolicy r2) {
        Iterator<Map.Entry<String, Map<Uri, String>>> r1 = r2.getAppAndUriMappings().entrySet().iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L7;
        r3 = r3 + r1.next().getValue().size();
        goto L4
    L7:
        return String.valueOf(r3);
    }

    private String getNumberOfAuthenticationPolicyApps(AppUriAuthenticationPolicy r1) {
        return String.valueOf(r1.getAppAndUriMappings().size());
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_security_RequestManageCredentials_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RequestManageCredentials r1) {
        r1.com_android_settings_security_RequestManageCredentials__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_BatchedActivityLancet_onResume(RequestManageCredentials r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(RequestManageCredentials r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_security_RequestManageCredentials__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        RequestManageCredentials r5 = r4;
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
    public static void com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(RequestManageCredentials r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_security_RequestManageCredentials__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_BatchedActivityLancet_onStop(RequestManageCredentials r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_security_RequestManageCredentials_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(RequestManageCredentials r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_security_RequestManageCredentials__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_security_RequestManageCredentials_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(RequestManageCredentials r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_security_RequestManageCredentials__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        RequestManageCredentials r5 = r3;
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
}
