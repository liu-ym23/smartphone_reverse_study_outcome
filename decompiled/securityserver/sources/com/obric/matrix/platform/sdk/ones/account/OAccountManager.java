package com.obric.matrix.platform.sdk.ones.account;

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountManager;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import com.obric.matrix.platform.sdk.ones.account.api.IUpdateAccountInfoCallback;
import com.obric.matrix.platform.sdk.ones.account.api.IUpdateTokenMapCallback;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAccountManager extends AccountStatusListener implements IAccountManager {

    @NotNull
    public static final OAccountManager INSTANCE = null;

    @NotNull
    private static final String TAG = "AccountSDK_OAccountManager";

    @Nullable
    private static volatile AccountInfo mAccountInfo;

    @NotNull
    private static final Set<IAccountStatusListener> mAccountStatusListenerSet = null;

    @NotNull
    private static Handler mAsyncHandler;

    @NotNull
    private static Handler mCallbackHandler;

    @Nullable
    private static volatile Map<String, String> mTokenMap;

    static {
        INSTANCE = new OAccountManager();
        mAccountStatusListenerSet = new CopyOnWriteArraySet();
        mCallbackHandler = new Handler(Looper.getMainLooper());
        HandlerThread r0 = new HandlerThread("OAccountManager");
        r0.start();
        mAsyncHandler = new Handler(r0.getLooper());
    }

    private OAccountManager() {
    }

    public static /* synthetic */ void a(IUpdateTokenMapCallback r0) {
        m18updateXttTokenMapAsync$lambda5(r0);
    }

    public static /* synthetic */ void b(IUpdateTokenMapCallback r0) {
        m19updateXttTokenMapAsync$lambda5$lambda4(r0);
    }

    public static /* synthetic */ void c(IUpdateAccountInfoCallback r0) {
        m17updateAccountInfoAsync$lambda3$lambda2(r0);
    }

    public static /* synthetic */ void d() {
        m15init$lambda1();
    }

    public static /* synthetic */ void e(IUpdateAccountInfoCallback r0) {
        m16updateAccountInfoAsync$lambda3(r0);
    }

    /* JADX INFO: renamed from: init$lambda-1, reason: not valid java name */
    private static final void m15init$lambda1() {
        INSTANCE.onAccountInfoUpdate();
    }

    /* JADX INFO: renamed from: updateAccountInfoAsync$lambda-3, reason: not valid java name */
    private static final void m16updateAccountInfoAsync$lambda3(IUpdateAccountInfoCallback r3) {
        INSTANCE.updateAccountInfo();
        mCallbackHandler.post(new c(r3, 0));
    }

    /* JADX INFO: renamed from: updateAccountInfoAsync$lambda-3$lambda-2, reason: not valid java name */
    private static final void m17updateAccountInfoAsync$lambda3$lambda2(IUpdateAccountInfoCallback r1) {
        if (r1 == null) goto L5;
        AccountInfo r0 = mAccountInfo;
        Intrinsics.c(r0);
        r1.onResult(r0);
        return;
    }

    /* JADX INFO: renamed from: updateXttTokenMapAsync$lambda-5, reason: not valid java name */
    private static final void m18updateXttTokenMapAsync$lambda5(IUpdateTokenMapCallback r3) {
        INSTANCE.updateAccountInfo();
        mCallbackHandler.post(new d(r3, 1));
    }

    /* JADX INFO: renamed from: updateXttTokenMapAsync$lambda-5$lambda-4, reason: not valid java name */
    private static final void m19updateXttTokenMapAsync$lambda5$lambda4(IUpdateTokenMapCallback r1) {
        if (r1 == null) goto L5;
        Map<String, String> r0 = mTokenMap;
        Intrinsics.c(r0);
        r1.onResult(r0);
        return;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    @NotNull
    public synchronized AccountInfo accountInfo() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (mAccountInfo != null) goto L8;
        updateAccountInfo();     // Catch: Throwable -> L6
    L8:
        AccountInfo r0 = mAccountInfo;     // Catch: Throwable -> L6
        Intrinsics.c(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void addAccountStatusListener(@NotNull IAccountStatusListener r1) {
        Intrinsics.f(r1, "accountStatusListener");
        Set<IAccountStatusListener> r0 = mAccountStatusListenerSet;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener
    public void asyncInvoke(@NotNull Runnable r1) {
        Intrinsics.f(r1, "runnable");
        mAsyncHandler.post(r1);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void init(boolean r2) {
        startListen();
        if (r2 == false) goto L5;
        asyncInvoke(new com.bytedance.securityserver.b(1));
        return;
    L5:
        onAccountInfoUpdate();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    @NotNull
    public String innerToken() {
        return accountInfo().getInnerSSOToken();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public boolean isLogin() {
        return accountInfo().getLoginState();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public int logoutScene() {
        return accountInfo().getLogoutScene();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener, com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onAccountInfoUpdate() {
        super.onAccountInfoUpdate();
        updateAccountInfo();
        updateXttTokenMap();
        Set<IAccountStatusListener> r2 = mAccountStatusListenerSet;
        monitor-enter(r2);
        Iterator<IAccountStatusListener> r0 = r2.iterator();     // Catch: Throwable -> L9
    L6:
        if (r0.hasNext() == false) goto L11;
        r0.next().onAccountInfoUpdate();     // Catch: Throwable -> L9
        goto L6
    L11:
        monitor-exit(r2);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener, com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogin() {
        super.onLogin();
        onAccountInfoUpdate();
        Set<IAccountStatusListener> r2 = mAccountStatusListenerSet;
        monitor-enter(r2);
        Iterator<IAccountStatusListener> r0 = r2.iterator();     // Catch: Throwable -> L9
    L6:
        if (r0.hasNext() == false) goto L11;
        r0.next().onLogin();     // Catch: Throwable -> L9
        goto L6
    L11:
        monitor-exit(r2);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener, com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogout(int r3) {
        super.onLogout(r3);
        onAccountInfoUpdate();
        Set<IAccountStatusListener> r2 = mAccountStatusListenerSet;
        monitor-enter(r2);
        Iterator<IAccountStatusListener> r0 = r2.iterator();     // Catch: Throwable -> L9
    L6:
        if (r0.hasNext() == false) goto L11;
        r0.next().onLogout(r3);     // Catch: Throwable -> L9
        goto L6
    L11:
        monitor-exit(r2);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void removeAccountStatusListener(@NotNull IAccountStatusListener r1) {
        Intrinsics.f(r1, "accountStatusListener");
        Set<IAccountStatusListener> r0 = mAccountStatusListenerSet;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.os.BaseBundle] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void setLoginPhoneNumber(@NotNull String r8) {
        Intrinsics.f(r8, AccountConst.KEY_PHONE_NUMBER);
        OLog.i(TAG, AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER);
        ?? r5 = 0;
        r5 = 0;
        r5 = 0;
        ContentProviderClient r4 = AppGlobals.INSTANCE.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(AccountConst.AUTHORITY_ACCOUNT);     // Catch: Throwable -> L17 Exception -> L19
        if (r4 != null) goto L31;
    L10:
        if (r5 == 0) goto L12;
        int r7 = r5.getInt(AccountConst.KEY_SET_LOGIN_PHONE_NUMBER_RESULT);     // Catch: Throwable -> L6 Exception -> L8
    L13:
        if (r7 == 0) goto L15;
        OLog.e(TAG, "setLoginPhoneNumber failed, resCode: " + r7);     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = e;
        r5 = r4;
    L20:
        OLog.INSTANCE.e(TAG, "setLoginPhoneNumber error: ", e);     // Catch: Throwable -> L17
        if (r5 == 0) goto L27;
        r5.close();
    L27:
        return;
    L6:
        th = th;
        r5 = r4;
    L24:
        if (r5 == 0) goto L26;
        r5.close();
    L26:
        throw th;
    L15:
        if (r4 == null) goto L27;
        r4.close();
        goto L27
    L12:
        r7 = -1;
        goto L13
    L31:
        Bundle r6 = new Bundle();     // Catch: Throwable -> L6 Exception -> L8
        r6.putString(AccountConst.KEY_PHONE_NUMBER, r8);     // Catch: Throwable -> L6 Exception -> L8
        r5 = r4.call(AccountConst.AUTHORITY_ACCOUNT, AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER, null, r6);     // Catch: Throwable -> L6 Exception -> L8
    L17:
        th = th;
    L19:
        e = e;
        goto L20
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0022: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:10:0x0022 */
    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public synchronized void updateAccountInfo() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        ContentProviderClient r3 = null;
        Boolean r4 = null;
        ContentProviderClient r5 = AppGlobals.INSTANCE.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(AccountConst.AUTHORITY_ACCOUNT);     // Catch: Throwable -> L22 Exception -> L24
        if (r5 != null) goto L42;
        Bundle r0 = null;
    L14:
        if (r0 == null) goto L16;
        mAccountInfo = AccountInfoKt.fromBundle(new AccountInfo(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null), r0);     // Catch: Throwable -> L9 Exception -> L11
    L17:
        if (r5 == null) goto L29;
    L18:
        r5.close();     // Catch: Throwable -> L20
    L29:
        StringBuilder r2 = new StringBuilder("updateAccountInfo loginState: ");     // Catch: Throwable -> L20
        AccountInfo r1 = mAccountInfo;     // Catch: Throwable -> L20
        if (r1 == null) goto L32;
        r4 = Boolean.valueOf(r1.getLoginState());     // Catch: Throwable -> L20
    L32:
        r2.append(r4);     // Catch: Throwable -> L20
        OLog.i(TAG, r2.toString());     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L16:
        mAccountInfo = new AccountInfo(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Throwable -> L9 Exception -> L11
        OLog.e(TAG, "updateAccountInfo getAccountInfo: result is null");     // Catch: Throwable -> L9 Exception -> L11
        goto L17
    L42:
        r0 = r5.call(AccountConst.AUTHORITY_ACCOUNT, AccountConst.METHOD_GET_ACCOUNT_INFO, null, null);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = e;
    L26:
        mAccountInfo = new AccountInfo(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Throwable -> L9
        OLog.INSTANCE.e(TAG, "updateAccountInfo getAccountInfo err: " + e, e);     // Catch: Throwable -> L9
        if (r5 == null) goto L29;
    L9:
        th = th;
        r3 = r4;
    L35:
        if (r3 == null) goto L37;
        r3.close();     // Catch: Throwable -> L20
    L37:
        throw th;     // Catch: Throwable -> L20
    L24:
        e = e;
        r5 = null;
    L22:
        th = th;
        goto L35
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void updateAccountInfoAsync(@Nullable IUpdateAccountInfoCallback r3) {
        mAsyncHandler.post(new c(r3, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public synchronized void updateXttTokenMap() {
        monitor-enter(this);
        Context r1 = AppGlobals.INSTANCE.getApplicationContext();     // Catch: Throwable -> L24
        ContentProviderClient r2 = 0;
        Integer r3 = null;
        ContentProviderClient r4 = r1.getContentResolver().acquireUnstableContentProviderClient(AccountConst.AUTHORITY_ACCOUNT);     // Catch: Throwable -> L26 Exception -> L28
        if (r4 != null) goto L45;
        Bundle r5 = null;
    L14:
        if (r5 == null) goto L20;
        Serializable r6 = r5.getSerializable(AccountConst.KEY_TOKEN_MAP);     // Catch: Throwable -> L9 Exception -> L11
        if (r6 == null) goto L19;
        mTokenMap = (Map) r6;     // Catch: Throwable -> L9 Exception -> L11
    L21:
        if (r4 == null) goto L33;
    L22:
        r4.close();     // Catch: Throwable -> L24
    L33:
        StringBuilder r7 = new StringBuilder("updateXttTokenMap: ");     // Catch: Throwable -> L24
        Map<String, String> r0 = mTokenMap;     // Catch: Throwable -> L24
        if (r0 == null) goto L36;
        r3 = Integer.valueOf(r0.size());     // Catch: Throwable -> L24
    L36:
        r7.append(r3);     // Catch: Throwable -> L24
        OLog.d(TAG, r7.toString());     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Throwable -> L9 Exception -> L11
    L20:
        mTokenMap = new HashMap();     // Catch: Throwable -> L9 Exception -> L11
        OLog.w(TAG, "getXttTokenMap: result is null");     // Catch: Throwable -> L9 Exception -> L11
        goto L21
    L45:
        r5 = r4.call(AccountConst.AUTHORITY_ACCOUNT, AccountConst.METHOD_GET_TOKEN_MAP, null, null);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = e;
    L30:
        mTokenMap = new HashMap();     // Catch: Throwable -> L9
        OLog.INSTANCE.e(TAG, "getXttTokenMap: ", e);     // Catch: Throwable -> L9
        if (r4 == null) goto L33;
    L9:
        th = th;
        r2 = r1;
    L39:
        if (r2 == 0) goto L41;
        r2.close();     // Catch: Throwable -> L24
    L41:
        throw th;     // Catch: Throwable -> L24
    L28:
        e = e;
        r4 = null;
    L26:
        th = th;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void updateXttTokenMapAsync(@Nullable IUpdateTokenMapCallback r3) {
        mAsyncHandler.post(new d(r3, 0));
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    @NotNull
    public synchronized Map<String, String> xttTokenMap() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (mTokenMap != null) goto L8;
        updateXttTokenMap();     // Catch: Throwable -> L6
    L8:
        Map<String, String> r0 = mTokenMap;     // Catch: Throwable -> L6
        Intrinsics.c(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }
}
