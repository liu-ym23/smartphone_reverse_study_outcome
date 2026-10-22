package com.obric.matrix.platform.sdk.ones.account;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountManager;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import com.obric.matrix.platform.sdk.ones.account.api.ILogger;
import com.obric.matrix.platform.sdk.ones.account.api.IUpdateAccountInfoCallback;
import com.obric.matrix.platform.sdk.ones.account.api.IUpdateTokenMapCallback;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAccount {

    @NotNull
    public static final OAccount INSTANCE = null;

    @NotNull
    private static final String TAG = "AccountSDK_OAccount";

    @NotNull
    private static final Lazy defaultErrorMsg$delegate = null;

    @NotNull
    private static final CountDownLatch initCountDownLatch = null;
    private static IAccountBridge mAccountBridge;
    private static IAccountManager mAccountManager;

    @Nullable
    private static IAccountService mAccountService;

    @NotNull
    private static final ServiceConnection mAccountServiceCon = null;

    @NotNull
    private static Handler mCallbackHandler;

    @NotNull
    private static volatile AtomicBoolean mInit;

    @Metadata
    public static final class AsyncResultCallback extends IAccountActionCallback.Stub {

        @Nullable
        private Function2<? super Integer, ? super String, Unit> _onFailed;

        @Nullable
        private Function0<Unit> _onSuccess;

        @Nullable
        private Function1<? super Bundle, Unit> _onSuccessEx;

        @NotNull
        private final String methodName;

        public /* synthetic */ AsyncResultCallback(String r1, Function0 r2, Function2 r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 8) == 0) goto L5;
            r4 = null;
        L5:
            this(r1, r2, r3, r4);
        }

        public static final /* synthetic */ void access$set_onFailed$p(AsyncResultCallback r0, Function2 r1) {
            r0._onFailed = r1;
        }

        public static final /* synthetic */ void access$set_onSuccess$p(AsyncResultCallback r0, Function0 r1) {
            r0._onSuccess = r1;
        }

        public static final /* synthetic */ void access$set_onSuccessEx$p(AsyncResultCallback r0, Function1 r1) {
            r0._onSuccessEx = r1;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(boolean r9, @Nullable Bundle r10) {
            OAccount.access$asyncResultCallback(OAccount.INSTANCE, this.methodName, r9, r10, this._onSuccess, this._onSuccessEx, this._onFailed, new OAccount$AsyncResultCallback$onResult$1(this));
        }

        public AsyncResultCallback(@NotNull String r2, @Nullable Function0<Unit> r3, @Nullable Function2<? super Integer, ? super String, Unit> r4, @Nullable Function1<? super Bundle, Unit> r5) {
            Intrinsics.f(r2, "methodName");
            this.methodName = r2;
            this._onSuccess = r3;
            this._onFailed = r4;
            this._onSuccessEx = r5;
        }
    }

    static {
        INSTANCE = new OAccount();
        mInit = new AtomicBoolean(false);
        initCountDownLatch = new CountDownLatch(1);
        mCallbackHandler = new Handler(Looper.getMainLooper());
        mAccountServiceCon = new OAccount$mAccountServiceCon$1();
        defaultErrorMsg$delegate = LazyKt.b(OAccount$defaultErrorMsg$2.INSTANCE);
    }

    private OAccount() {
    }

    public static /* synthetic */ void a(boolean r0, String r1, Function1 r2, Bundle r3, Function0 r4, Function0 r5, Function2 r6) {
        m13asyncResultCallback$lambda3(r0, r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ void access$asyncResultCallback(OAccount r0, String r1, boolean r2, Bundle r3, Function0 r4, Function1 r5, Function2 r6, Function0 r7) {
        r0.asyncResultCallback(r1, r2, r3, r4, r5, r6, r7);
    }

    public static final /* synthetic */ void access$setMAccountService$p(IAccountService r0) {
        mAccountService = r0;
    }

    public static final /* synthetic */ void access$startBindService(OAccount r0) {
        r0.startBindService();
    }

    public static /* synthetic */ AccountInfo accountInfo$default(OAccount r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.accountInfo(r1);
    }

    private final void asyncResultCallback(final String r11, final boolean r12, final Bundle r13, final Function0<Unit> r14, final Function1<? super Bundle, Unit> r15, final Function2<? super Integer, ? super String, Unit> r16, final Function0<Unit> r17) {
        mCallbackHandler.post(new b(r12, r11, r15, r13, r14, r17, r16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void asyncResultCallback$default(OAccount r10, String r11, boolean r12, Bundle r13, Function0 r14, Function1 r15, Function2 r16, Function0 r17, int r18, Object r19) {
        if ((r18 & 8) == 0) goto L5;
        Function0 r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        Function1 r7 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        Function2 r8 = null;
    L15:
        if ((r18 & 64) == 0) goto L17;
        Function0 r9 = null;
    L18:
        r10.asyncResultCallback(r11, r12, r13, r6, r7, r8, r9);
        return;
    L17:
        r9 = r17;
        goto L18
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    /* JADX INFO: renamed from: asyncResultCallback$lambda-3, reason: not valid java name */
    private static final void m13asyncResultCallback$lambda3(boolean r3, String r4, Function1 r5, Bundle r6, Function0 r7, Function0 r8, Function2 r9) {
        Intrinsics.f(r4, "$method");
        if (r3 == false) goto L11;
        OLog.d(TAG, "asyncResult, " + r4 + ", success");
        if (r5 == null) goto L7;
        r5.invoke(r6);
    L9:
        if (r8 == null) goto L17;
        r8.invoke();
        return;
    L17:
        return;
    L7:
        if (r7 == null) goto L9;
        r7.invoke();
        goto L9
    L11:
        OAccount r10 = INSTANCE;
        int r11 = r10.getErrorCode(r6, -1);
        String r12 = r10.getDefaultErrorMsg();
        Intrinsics.e(r12, "defaultErrorMsg");
        String r13 = r10.getErrorMsg(r6, r12);
        OLog.e(TAG, "asyncResult, " + r4 + " failed. errorCode: " + r11 + " errorMsg: " + r13 + '.');
        if (r9 == null) goto L14;
        r9.mo7invoke(Integer.valueOf(r11), r13);
    L14:
        if (r8 == null) goto L19;
        r8.invoke();
        return;
    }

    private final void callAccountService(Function1<? super IAccountService, Unit> r4, Function2<? super Integer, ? super String, Unit> r5) {
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L8;
        OLog.w(TAG, "AccountService is null.");
        if (r5 == null) goto L7;
        r5.mo7invoke(1002, "");
    L7:
        startBindService();
        return;
    L8:
        r4.invoke(r0);
    }

    private final void checkInit(boolean r9) {
        if (r9 == false) goto L11;
        if (mInit.get() == false) goto L15;
        return;
    L15:
        initCountDownLatch.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new AccountException(1002, "account init timeout", null, 4, null);
    L11:
        if (mInit.get() == false) goto L14;
        return;
    L14:
        throw new AccountException(1001, "please call init first ", null, 4, null);
    }

    public static /* synthetic */ void checkInit$default(OAccount r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.checkInit(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkPassword$default(OAccount r1, String r2, Function0 r3, Function2 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.checkPassword(r2, r3, r4);
    }

    private final void doInit(Application r2, ILogger r3, IAccountBridge r4, boolean r5) {
        OLog.i(TAG, "init, asyncInit: " + r5);
        AtomicBoolean r1 = mInit;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (mInit.get() == false) goto L11;
        OLog.w(TAG, "Init already.");     // Catch: Throwable -> L9
        monitor-exit(r1);
        return;
    L11:
        OLog.INSTANCE.setLoggerProxy(r3);     // Catch: Throwable -> L9
        mAccountBridge = r4;     // Catch: Throwable -> L9
        mAccountManager = OAccountManager.INSTANCE;     // Catch: Throwable -> L9
        OAccount r6 = INSTANCE;     // Catch: Throwable -> L9
        r6.init(r5);     // Catch: Throwable -> L9
        mInit.set(true);     // Catch: Throwable -> L9
        initCountDownLatch.countDown();     // Catch: Throwable -> L9
        r6.startBindService();     // Catch: Throwable -> L9
        monitor-exit(r1);
    }

    private final String getDefaultErrorMsg() {
        return (String) defaultErrorMsg$delegate.getValue();
    }

    private final int getErrorCode(Bundle r1, int r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        return r1.getInt(AccountConst.KEY_ERROR_CODE, r2);
    }

    private final String getErrorMsg(Bundle r1, String r2) {
        if (r1 == null) goto L4;
        String r0 = r1.getString(AccountConst.KEY_ERROR_MSG, r2);
    L5:
        if (r0 != null) goto L8;
        return r2;
    L8:
        return r0;
    L4:
        r0 = null;
        goto L5
    }

    private final void goToHome(Context r3, boolean r4, ActivityOptions r5, Function1<? super Exception, Unit> r6) {
        Intent r0 = new Intent("com.obric.account.action.OBRIC_ACCOUNT_ACTION");     // Catch: Exception -> L6
        r0.setClassName("com.obric.account", "com.obric.account.AccountMainActivity");     // Catch: Exception -> L6
        r0.setPackage("com.obric.account");     // Catch: Exception -> L6
        r0.putExtra("destination", "account_main");     // Catch: Exception -> L6
        if (r4 == false) goto L8;
        r0.addFlags(270532608);     // Catch: Exception -> L6
    L8:
        if (r5 == null) goto L10;
        Bundle r2 = r5.toBundle();     // Catch: Exception -> L6
    L11:
        r3.startActivity(r0, r2);     // Catch: Exception -> L6
        return;
    L10:
        r2 = null;
    L6:
        e = move-exception;
        MLog.e(TAG, "login error.", e);
        if (r6 == null) goto L19;
        r6.invoke(e);
        return;
    }

    public static /* synthetic */ boolean isLogin$default(OAccount r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.isLogin(r1);
    }

    public static /* synthetic */ void login$default(OAccount r0, Context r1, ActivityOptions r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.login(r1, r2);
    }

    public static /* synthetic */ int loginWithCallback$default(OAccount r1, Context r2, ActivityOptions r3, PendingIntent r4, boolean r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        return r1.loginWithCallback(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loginWithPassword$default(OAccount r1, String r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.loginWithPassword(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void logout$default(OAccount r1, Function0 r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.logout(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void quickLogin$default(OAccount r1, String r2, String r3, Function1 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.quickLogin(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendCode$default(OAccount r1, String r2, int r3, Function0 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.sendCode(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setInitPassword$default(OAccount r1, String r2, Function0 r3, Function2 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.setInitPassword(r2, r3, r4);
    }

    private final void startBindService() {
        checkInit$default(this, false, 1, null);
        OLog.i(TAG, "startBindService: ");
        Intent r0 = new Intent();
        r0.setClassName("com.obric.matrix", AccountConst.ACCOUNT_SERVICE_NAME);
    L6:
        th = move-exception;
        Object r1 = ResultKt.a(th);
    L11:
        Throwable r2 = Result.a(r1);
        if (r2 == null) goto L17;
        OLog.INSTANCE.e(TAG, "onFailure startBindService: failed", r2);
        return;
    L17:
        return;
    L4:
        if (AppGlobals.INSTANCE.getApplicationContext().bindService(r0, mAccountServiceCon, 1) == true) goto L8;
        OLog.e(TAG, "startBindService: failed");     // Catch: Throwable -> L6
    L8:
        r1 = Unit.f330a;     // Catch: Throwable -> L6
        goto L11
    }

    public static /* synthetic */ void startLogoutActivity$default(OAccount r0, Activity r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.startLogoutActivity(r1, r2);
    }

    public static /* synthetic */ void startSetInitPassword$default(OAccount r0, Activity r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.startSetInitPassword(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ticketResetPassword$default(OAccount r1, String r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.ticketResetPassword(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updatePassword$default(OAccount r1, String r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.updatePassword(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateUserInfo$default(OAccount r1, Bundle r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.updateUserInfo(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void uploadAvatar$default(OAccount r1, String r2, Function1 r3, Function2 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.uploadAvatar(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void verifyPassword$default(OAccount r1, String r2, String r3, Function1 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.verifyPassword(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void verifyPasswordWithoutLogin$default(OAccount r1, String r2, String r3, Function1 r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.verifyPasswordWithoutLogin(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void verifySmsCode$default(OAccount r7, String r8, String r9, int r10, Function1 r11, Function2 r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        Function1 r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Function2 r6 = null;
    L10:
        r7.verifySmsCode(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    @NotNull
    public final IAccountBridge accountBridge() {
        checkInit$default(this, false, 1, null);
        IAccountBridge r3 = mAccountBridge;
        if (r3 == null) goto L5;
        return r3;
    L5:
        Intrinsics.m("mAccountBridge");
        throw null;
    }

    @NotNull
    public final AccountInfo accountInfo(boolean r3) {
        checkInit$default(this, false, 1, null);
        IAccountManager r2 = mAccountManager;
        if (r2 != null) goto L5;
        Intrinsics.m("mAccountManager");
        throw null;
    L5:
        return r2.accountInfo();
    }

    public final void accountLaunchIntent(@NotNull Context r4, @NotNull Intent r5) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "intent");
        if (isLogin$default(this, false, 1, null) == false) goto L5;
        r5.setClassName("com.obric.account", "com.obric.account.ui.home.HomeActivity");
    L6:
        r5.setPackage("com.obric.account");
        r5.addFlags(268435456);
        r5.putExtra("enter_from", r4.getPackageName());
        return;
    L5:
        r5.setClassName("com.obric.account", "com.obric.account.ui.login.LoginActivity");
        goto L6
    }

    public final void addAccountStatusListener(@NotNull IAccountStatusListener r1) {
        Intrinsics.f(r1, "accountStatusListener");
        IAccountManager r0 = mAccountManager;
        if (r0 == null) goto L6;
        r0.addAccountStatusListener(r1);
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }

    public final void asyncInit(@NotNull Application r2, @NotNull ILogger r3, @NotNull IAccountBridge r4) {
        Intrinsics.f(r2, "application");
        Intrinsics.f(r3, "logger");
        Intrinsics.f(r4, "bridge");
        doInit(r2, r3, r4, true);
    }

    public final void checkPassword(@NotNull final String r3, @Nullable final Function0<Unit> r4, @Nullable final Function2<? super Integer, ? super String, Unit> r5) {
        Intrinsics.f(r3, "password");
        OLog.d(TAG, "checkPassword");
        callAccountService(new AnonymousClass1(r3, r4, r5), r5);
    }

    public final void forceUpdateAccount() {
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L6;
        OLog.e(TAG, "AccountService is null.");
        startBindService();
        return;
    L6:
        Intrinsics.c(r0);
        r0.forceUpdateAccount();
    }

    public final void init(@NotNull Application r2, @NotNull ILogger r3, @NotNull IAccountBridge r4) {
        Intrinsics.f(r2, "application");
        Intrinsics.f(r3, "logger");
        Intrinsics.f(r4, "bridge");
        doInit(r2, r3, r4, false);
    }

    @NotNull
    public final String innerToken() {
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.m("mAccountManager");
        throw null;
    L5:
        return r3.innerToken();
    }

    public final boolean isLogin(boolean r1) {
        checkInit(r1);
        IAccountManager r0 = mAccountManager;
        if (r0 != null) goto L5;
        Intrinsics.m("mAccountManager");
        throw null;
    L5:
        return r0.isLogin();
    }

    public final void login(@NotNull Context r11, @Nullable ActivityOptions r12) {
        Intrinsics.f(r11, "context");
        checkInit$default(this, false, 1, null);
        loginWithCallback$default(this, r11, r12, null, false, 8, null);
    }

    public final int loginWithCallback(@NotNull Context r1, @Nullable ActivityOptions r2, @Nullable PendingIntent r3, boolean r4) {
        Intrinsics.f(r1, "context");
        checkInit(r4);
        if (isLogin$default(this, false, 1, null) == false) goto L6;
        OLog.e(TAG, "login failed, login already.");
        return 1003;
    L6:
        IAccountService r5 = mAccountService;
        if (r5 != null) goto L10;
        OLog.e(TAG, "AccountService is null.");
        startBindService();
        return 1002;
    L10:
        Intrinsics.c(r5);
        r5.login(r3);
        return 1;
    }

    public final void loginWithPassword(@NotNull final String r3, @NotNull final String r4, @Nullable final Function0<Unit> r5, @Nullable final Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.f(r3, "mobile");
        Intrinsics.f(r4, "password");
        OLog.d(TAG, "loginWithPassword");
        callAccountService(new C00261(r3, r4, r5, r6), r6);
    }

    public final void logout(@Nullable Function0<Unit> r9, @Nullable Function2<? super Integer, ? super String, Unit> r10) {
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r10 == null) goto L7;
        r10.mo7invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.c(r0);
        String r2 = "logout";
        Function1 r5 = null;
        r0.logout(new AsyncResultCallback(r2, r9, r10, r5, 8, null));
    }

    public final int logoutScene() {
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.m("mAccountManager");
        throw null;
    L5:
        return r3.logoutScene();
    }

    public final void quickLogin(@NotNull String r4, @NotNull String r5, @Nullable Function1<? super Bundle, Unit> r6, @Nullable Function2<? super Integer, ? super String, Unit> r7) {
        Intrinsics.f(r4, "mobile");
        Intrinsics.f(r5, "code");
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r7 == null) goto L7;
        r7.mo7invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.c(r0);
        r0.quickLogin(r4, r5, new AsyncResultCallback("quickLogin", null, r7, r6));
    }

    public final void removeAccountStatusListener(@NotNull IAccountStatusListener r1) {
        Intrinsics.f(r1, "accountStatusListener");
        IAccountManager r0 = mAccountManager;
        if (r0 == null) goto L6;
        r0.removeAccountStatusListener(r1);
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }

    public final void sendCode(@NotNull String r9, int r10, @Nullable Function0<Unit> r11, @Nullable Function2<? super Integer, ? super String, Unit> r12) {
        Intrinsics.f(r9, "account");
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L8;
        OLog.e(TAG, "AccountService is null.");
        startBindService();
        if (r12 == null) goto L10;
        r12.mo7invoke(1002, "");
        return;
    L10:
        return;
    L8:
        Intrinsics.c(r0);
        String r2 = "sendCode";
        Function1 r5 = null;
        r0.sendCode(r9, r10, new AsyncResultCallback(r2, r11, r12, r5, 8, null));
    }

    public final void setInitPassword(@NotNull final String r3, @Nullable final Function0<Unit> r4, @Nullable final Function2<? super Integer, ? super String, Unit> r5) {
        Intrinsics.f(r3, "password");
        OLog.d(TAG, "setInitPassword");
        callAccountService(new C00271(r3, r4, r5), r5);
    }

    public final void setLoginPhoneNumber(@NotNull String r4) {
        Intrinsics.f(r4, AccountConst.KEY_PHONE_NUMBER);
        checkInit$default(this, false, 1, null);
        OLog.i(TAG, AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER);
        IAccountManager r0 = mAccountManager;
        if (r0 == null) goto L6;
        r0.setLoginPhoneNumber(r4);
        OLog.i(TAG, "setLoginPhoneNumber updateAccountInfo");
        updateAccountInfo();
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }

    public final void startLogoutActivity(@NotNull Activity r3, @Nullable Integer r4) {
        Intrinsics.f(r3, "activity");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.account", "com.obric.account.ui.security.LogoutActivity2");
        r2.setPackage("com.obric.account");
        r2.putExtra("enter_from", r3.getPackageName());
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        r3.startActivityForResult(r2, r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final void startSetInitPassword(@NotNull Activity r3, @Nullable Integer r4) {
        Intrinsics.f(r3, "activity");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.account", "com.obric.account.ui.security.SetInitPasswordActivity");
        r2.setPackage("com.obric.account");
        r2.addFlags(268435456);
        r2.putExtra("enter_from", r3.getPackageName());
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        r3.startActivityForResult(r2, r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final void startVerifyActivity(@NotNull Activity r3, @NotNull String r4, int r5) {
        Intrinsics.f(r3, "activity");
        Intrinsics.f(r4, "verifyReason");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.account", "com.obric.account.ui.security.VerifyPasswordActivity");
        r2.setPackage("com.obric.account");
        r2.putExtra("enter_from", r3.getPackageName());
        r2.putExtra("extra_key_verify_reason", r4);
        r3.startActivityForResult(r2, r5);
    }

    public final void ticketResetPassword(@NotNull final String r3, @NotNull final String r4, @Nullable final Function0<Unit> r5, @Nullable final Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.f(r3, AccountConst.KEY_TICKET);
        Intrinsics.f(r4, "password");
        OLog.d(TAG, "ticketResetPassword");
        callAccountService(new C00281(r3, r4, r5, r6), r6);
    }

    public final void updateAccountInfo() {
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 == null) goto L6;
        r3.updateAccountInfo();
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }

    public final void updateAccountInfoAsync(@Nullable IUpdateAccountInfoCallback r4) {
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 == null) goto L6;
        r3.updateAccountInfoAsync(r4);
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }

    public final void updatePassword(@NotNull final String r3, @NotNull final String r4, @Nullable final Function0<Unit> r5, @Nullable final Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.f(r3, "oldPassword");
        Intrinsics.f(r4, "newPassword");
        OLog.d(TAG, "updatePassword");
        callAccountService(new C00291(r3, r4, r5, r6), r6);
    }

    public final void updateUserInfo(@NotNull Bundle r9, @Nullable String r10, @Nullable Function0<Unit> r11, @Nullable Function2<? super Integer, ? super String, Unit> r12) {
        Intrinsics.f(r9, "updateInfo");
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r12 == null) goto L7;
        r12.mo7invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.c(r0);
        String r2 = "updateUserInfo";
        Function1 r5 = null;
        r0.updateUserInfo(r9, r10, new AsyncResultCallback(r2, r11, r12, r5, 8, null));
    }

    public final void updateXttTokenMap() {
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 == null) goto L6;
        r3.updateXttTokenMap();
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }

    public final void updateXttTokenMapAsync(@Nullable IUpdateTokenMapCallback r4) {
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 == null) goto L6;
        r3.updateXttTokenMapAsync(r4);
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }

    public final void uploadAvatar(@NotNull String r4, @Nullable Function1<? super Bundle, Unit> r5, @Nullable Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.f(r4, ApmTrafficStats.KEY_PATH);
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r6 == null) goto L7;
        r6.mo7invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.c(r0);
        r0.uploadAvatar(r4, new AsyncResultCallback("uploadAvatar", null, r6, r5));
    }

    public final void verifyPassword(@NotNull final String r3, @NotNull final String r4, @Nullable final Function1<? super Bundle, Unit> r5, @Nullable final Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.f(r3, "mobile");
        Intrinsics.f(r4, "password");
        OLog.d(TAG, "verifyPassword");
        callAccountService(new C00301(r3, r4, r6, r5), r6);
    }

    public final void verifyPasswordWithoutLogin(@NotNull final String r3, @NotNull final String r4, @Nullable final Function1<? super Bundle, Unit> r5, @Nullable final Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.f(r3, "mobile");
        Intrinsics.f(r4, "password");
        OLog.d(TAG, "verifyPasswordWithoutLogin in OAccount");
        callAccountService(new C00311(r3, r4, r6, r5), r6);
    }

    public final void verifySmsCode(@NotNull final String r9, @NotNull final String r10, final int r11, @Nullable final Function1<? super Bundle, Unit> r12, @Nullable final Function2<? super Integer, ? super String, Unit> r13) {
        Intrinsics.f(r9, "mobile");
        Intrinsics.f(r10, "code");
        OLog.d(TAG, "verifySmsCode");
        callAccountService(new C00321(r9, r10, r11, r13, r12), r13);
    }

    @NotNull
    public final Map<String, String> xttTokenMap() {
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.m("mAccountManager");
        throw null;
    L5:
        return r3.xttTokenMap();
    }

    private final void init(boolean r1) {
        IAccountManager r0 = mAccountManager;
        if (r0 == null) goto L6;
        r0.init(r1);
        return;
    L6:
        Intrinsics.m("mAccountManager");
        throw null;
    }
}
