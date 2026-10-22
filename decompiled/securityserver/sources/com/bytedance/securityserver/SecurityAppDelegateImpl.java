package com.bytedance.securityserver;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.securityserver.adapter.OceanTeaReportBridge;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.broadcast.BroadcastManager;
import com.bytedance.securityserver.network.NetworkConfig;
import com.bytedance.securityserver.observer.OnSettingChangedListenerImpl;
import com.bytedance.securityserver.observer.SettingsObserver;
import com.bytedance.securityserver.observer.SettingsViaMatrixListener;
import com.bytedance.securityserver.permission.MinPermissionManager;
import com.bytedance.securityserver.policy.SecurityPolicyManager;
import com.bytedance.securityserver.trustcircle.TrustCircleException;
import com.bytedance.securityserver.trustcircle.TrustCircleUtils;
import com.bytedance.securityserver.trustcircle.account.AccountBridgeImpl;
import com.bytedance.securityserver.trustcircle.account.AccountLogger;
import com.bytedance.securityserver.trustcircle.account.AccountStatusListener;
import com.bytedance.securityserver.trustcircle.account.AccountUtils;
import com.bytedance.securityserver.trustcircle.account.EnvBridgeImpl;
import com.bytedance.securityserver.trustcircle.account.MatrixBridgeImpl;
import com.bytedance.securityserver.trustcircle.account.PrivacyAccountBridge;
import com.bytedance.securityserver.utils.EventUploadUtils;
import com.bytedance.securityserver.utils.NetworkMonitor;
import com.bytedance.securityserver.utils.WiFiMonitor;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class SecurityAppDelegateImpl implements ISecurityAppDelegate {
    private static final String TAG = "SecurityAppDelegate";
    private AccountStatusListener listener;
    private final AtomicBoolean mAuditReportTriggeredByDeviceInfo;
    private BroadcastManager mBroadcastManager;
    private MinPermissionManager mMinPermissionManager;
    private Handler observerHandler;
    private PrivacyAccountBridge privacyAccountBridge;
    private SettingsObserver settingsObserver;
    private SettingsViaMatrixListener settingsViaMatrixListener;

    public SecurityAppDelegateImpl() {
        this.observerHandler = new Handler(Looper.getMainLooper());
        this.mAuditReportTriggeredByDeviceInfo = new AtomicBoolean(false);
    }

    public static /* synthetic */ int a(SecurityAppDelegateImpl r0, Application r1) {
        return r0.lambda$onCreate$0(r1);
    }

    public static /* synthetic */ void b() {
        lambda$triggerSecurityAuditReportAfterDeviceInfo$2();
    }

    private MatrixTeaConfig buildTeaConfig(Application r8) {
        String r7 = "1.0";
        int r1 = 1;
        PackageInfo r2 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 0);     // Catch: Throwable -> L10
        long r3 = r2.getLongVersionCode();     // Catch: Throwable -> L10
        if (r3 <= 2147483647L) goto L6;
        r1 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L7:
        String r4 = r2.versionName;     // Catch: Throwable -> L10
        if (r4 == null) goto L13;
        r7 = r4;
    L13:
        return new MatrixTeaConfig.Builder().setPackageName(r8.getPackageName()).setVersionCode(r1).setVersionName(r7).setIsBoe(false).build();
    L6:
        r1 = (int) r3;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Log.w(TAG, "get package version failed, use fallback version", th);
        goto L13
    }

    public static /* synthetic */ int c(Application r0) {
        return lambda$onCreate$1(r0);
    }

    public static /* bridge */ /* synthetic */ void d(SecurityAppDelegateImpl r0) {
        r0.triggerSecurityAuditReportAfterDeviceInfo();
    }

    private void initTeaSdkAndAccount(Application r4) {
        MatrixOnesSdk r0 = MatrixOnesSdk.INSTANCE;     // Catch: Throwable -> L14
        MatrixBridgeImpl r1 = new MatrixBridgeImpl();     // Catch: Throwable -> L14
        r1.f74a = r4;     // Catch: Throwable -> L14
        r0.init(r4, r1);     // Catch: Throwable -> L14
        MatrixTeaConfig r2 = buildTeaConfig(r4);     // Catch: Throwable -> L14
        MatrixTeaManager.Companion.init(r4, r2);     // Catch: Throwable -> L14
        OceanTeaReportBridge r5 = new OceanTeaReportBridge();     // Catch: Throwable -> L14
        monitor-enter(SecurityLibFactory.class);     // Catch: Throwable -> L14
        SecurityLibFactory.g = r5;     // Catch: Throwable -> L16
        monitor-exit(SecurityLibFactory.class);     // Catch: Throwable -> L14
        Log.i(TAG, "Ocean Tea SDK initialized and bridge registered");     // Catch: Throwable -> L14
        registerDeviceInfoAuditReporter();     // Catch: Throwable -> L14
        r0.enableLog(true);     // Catch: Throwable -> L10
    L12:
        EventUploadUtils.b();     // Catch: Throwable -> L14
    L29:
        PrivacyAccountBridge r6 = this.privacyAccountBridge;     // Catch: Throwable -> L22
        AccountStatusListener r3 = this.listener;     // Catch: Throwable -> L22
        r6.getClass();     // Catch: Throwable -> L22
        OAccount r7 = OAccount.INSTANCE;     // Catch: Throwable -> L22
        AccountLogger r8 = new AccountLogger();     // Catch: Throwable -> L22
        AccountBridgeImpl r9 = new AccountBridgeImpl();     // Catch: Throwable -> L22
        r7.init(r6.f75a, r8, r9);     // Catch: Throwable -> L22
        r7.addAccountStatusListener(r3);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        StringBuilder r10 = new StringBuilder("accountInit failed: ");
        if (th.getMessage() != null) goto L26;
        String r11 = th.getClass().getSimpleName();
    L27:
        r10.append(r11);
        Log.e(TAG, r10.toString());
        return;
    L26:
        r11 = th.getMessage();
        goto L27
    L10:
        th = move-exception;
        Log.w(TAG, "MatrixOnesSdk enableLog failed", th);     // Catch: Throwable -> L14
        goto L12
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.e(TAG, "initTeaSdk failed", th);
        goto L29
    }

    private /* synthetic */ int lambda$onCreate$0(Application r1) {
        initTeaSdkAndAccount(r1);
        return 0;
    }

    private static int lambda$onCreate$1(Application r5) {
        Object r0 = AccountUtils.f72a;
        PrivacyAccountBridge.f(r5).getClass();     // Catch: TrustCircleException -> L10
        if (PrivacyAccountBridge.g() == false) goto L12;
        boolean r2 = AccountUtils.d(r5, 0);     // Catch: TrustCircleException -> L10
        boolean r4 = !TrustCircleUtils.b().isEmpty();
        if (r2 == true) goto L19;
        if (r4 == true) goto L12;
    L19:
        Log.i("SecurityServer-AccountUtils", "needIssueAccountCert");
        return AccountUtils.i(r5, 0);
    L12:
        PrivacyAccountBridge.f(r5).getClass();
        if (PrivacyAccountBridge.g() == true) goto L15;
        boolean r3 = AccountUtils.d(r5, 1);
    L16:
        if (r3 == false) goto L23;
        Log.i("SecurityServer-AccountUtils", "needRevokeAccountCert");
        return AccountUtils.i(r5, 1);
    L23:
        return 0;
    L15:
        r3 = false;
    L10:
        e = move-exception;
        Log.e("SecurityServer-AccountUtils", "needIssueAccountCert failed, exception: " + e);
        goto L19
    }

    private static /* synthetic */ void lambda$triggerSecurityAuditReportAfterDeviceInfo$2() {
        EventUploadUtils.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e(TAG, "report security audit after device info failed", th);
    }

    private void registerDeviceInfoAuditReporter() {
        MatrixTeaManager.Companion.getInstance().addDeviceInfoListener(new AnonymousClass1(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.w(TAG, "register device info listener failed", th);
    }

    private void triggerSecurityAuditReportAfterDeviceInfo() {
        if (this.mAuditReportTriggeredByDeviceInfo.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        new Thread(new b(0), "OceanTeaDeviceInfoAuditReport").start();
    }

    @Override // com.bytedance.securityserver.ISecurityAppDelegate
    public void onCreate(Application r6) {
        Log.i(TAG, "Ocean SecurityAppDelegate onCreate start");
        this.mBroadcastManager = BroadcastManager.a(r6);     // Catch: Error -> L5 Exception -> L7
        this.mMinPermissionManager = new MinPermissionManager(r6);     // Catch: Error -> L5 Exception -> L7
        SecurityPolicyManager.initSecurityPolicy(r6);     // Catch: Error -> L5 Exception -> L7
    L12:
        if (AccountStatusListener.c == null) goto L14;
    L24:
        this.listener = AccountStatusListener.c;
        this.privacyAccountBridge = PrivacyAccountBridge.f(r6);
        if (EnvBridgeImpl.b == null) goto L27;
    L37:
        EnvBridgeImpl r0 = EnvBridgeImpl.b;
        NetworkConfig.a().f55a = r0;
        PrivacySdk.init(this.privacyAccountBridge, r0);     // Catch: BdPrivacyException -> L40
    L42:
        a r1 = new a(this, r6);
        if (NetworkMonitor.f == null) goto L45;
    L55:
        NetworkMonitor.f.a();
        SettingsObserver r2 = new SettingsObserver(r6, this.observerHandler);
        this.settingsObserver = r2;
        OnSettingChangedListenerImpl r3 = new OnSettingChangedListenerImpl();
        Uri r4 = Settings.Global.getUriFor("device_name");
        r2.b.put("device_name", r3);
        r2.f56a.registerContentObserver(r4, false, r2);
        SettingsObserver r5 = this.settingsObserver;
        Uri r7 = Settings.Secure.getUriFor("enable_oaid");
        r5.b.put("enable_oaid", r3);
        r5.f56a.registerContentObserver(r7, false, r5);
        androidx.constraintlayout.core.state.a r8 = new androidx.constraintlayout.core.state.a(r6);
        if (WiFiMonitor.f == null) goto L58;
    L68:
        WiFiMonitor.f.a();
        SettingsViaMatrixListener r9 = SettingsViaMatrixListener.e(r6);
        r9.getClass();
        HandlerThread r10 = new HandlerThread("SettingsHandlerThread");
        r10.start();
        Handler r11 = new Handler(r10.getLooper());
        r9.c = r11;
        r11.post(new androidx.constraintlayout.helper.widget.a(1, r9));
        return;
    L58:
        monitor-enter(WiFiMonitor.class);
    L62:
        th = move-exception;
        throw th;
    L60:
        if (WiFiMonitor.f != null) goto L64;
        WiFiMonitor.f = new WiFiMonitor(r6, r8);     // Catch: Throwable -> L62
    L64:
        monitor-exit(WiFiMonitor.class);     // Catch: Throwable -> L62
        goto L68
    L45:
        monitor-enter(NetworkMonitor.class);
    L49:
        th = move-exception;
        throw th;
    L47:
        if (NetworkMonitor.f != null) goto L51;
        NetworkMonitor.f = new NetworkMonitor(r6, r1);     // Catch: Throwable -> L49
    L51:
        monitor-exit(NetworkMonitor.class);     // Catch: Throwable -> L49
    L40:
        e = move-exception;
        Log.e(TAG, "PrivacySdk init failed, exception: " + e.getMessage());
        goto L42
    L27:
        monitor-enter(EnvBridgeImpl.class);
    L31:
        th = move-exception;
        throw th;
    L29:
        if (EnvBridgeImpl.b != null) goto L33;
        EnvBridgeImpl.b = new EnvBridgeImpl(r6);     // Catch: Throwable -> L31
    L33:
        monitor-exit(EnvBridgeImpl.class);     // Catch: Throwable -> L31
        goto L37
    L14:
        monitor-enter(AccountStatusListener.class);
    L18:
        th = move-exception;
        throw th;
    L16:
        if (AccountStatusListener.c != null) goto L20;
        AccountStatusListener.c = new AccountStatusListener(r6);     // Catch: Throwable -> L18
    L20:
        monitor-exit(AccountStatusListener.class);     // Catch: Throwable -> L18
    L5:
        e = move-exception;
        Log.e(TAG, "onCreate: " + e.getMessage());
    L7:
        e = move-exception;
        a.a.C(e, new StringBuilder("onCreate: "), TAG);
        goto L12
    }
}
