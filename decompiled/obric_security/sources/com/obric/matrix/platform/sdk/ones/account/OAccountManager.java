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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAccountManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\u0012\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\u0012\u00103\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u000104H\u0016J\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/OAccountManager;", "Lcom/obric/matrix/platform/sdk/ones/account/AccountStatusListener;", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountManager;", "()V", "TAG", "", "mAccountInfo", "Lcom/obric/matrix/platform/sdk/ones/account/AccountInfo;", "mAccountStatusListenerSet", "", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountStatusListener;", "mAsyncHandler", "Landroid/os/Handler;", "mCallbackHandler", "mSecureAccountStatusListener", "Lcom/obric/matrix/platform/sdk/ones/account/SecureAccountStatusListener;", "getMSecureAccountStatusListener", "()Lcom/obric/matrix/platform/sdk/ones/account/SecureAccountStatusListener;", "setMSecureAccountStatusListener", "(Lcom/obric/matrix/platform/sdk/ones/account/SecureAccountStatusListener;)V", "mSecureAccountStatusListenerSet", "mTokenMap", "", "accountInfo", "addAccountStatusListener", "", "accountStatusListener", "addSecureAccountStatusListener", "asyncInvoke", "runnable", "Ljava/lang/Runnable;", AccountConst.METHOD_GET_MATRIX_VERSION_INFO, "Landroid/os/Bundle;", "init", "asyncInit", "", "innerToken", "isLogin", AccountInfoBundleKey.LOGOUT_SCENE, "", "onAccountInfoUpdate", "onLogin", "onLogout", "removeAccountStatusListener", AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER, AccountConst.KEY_PHONE_NUMBER, "updateAccountInfo", "updateAccountInfoAsync", "callback", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateAccountInfoCallback;", "updateXttTokenMap", "updateXttTokenMapAsync", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateTokenMapCallback;", "xttTokenMap", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccountManager extends AccountStatusListener implements IAccountManager {
    public static final OAccountManager INSTANCE = null;
    private static final String TAG = "AccountSDK_OAccountManager";
    private static volatile AccountInfo mAccountInfo;
    private static final Set<IAccountStatusListener> mAccountStatusListenerSet = null;
    private static Handler mAsyncHandler;
    private static Handler mCallbackHandler;
    private static SecureAccountStatusListener mSecureAccountStatusListener;
    private static final Set<IAccountStatusListener> mSecureAccountStatusListenerSet = null;
    private static volatile Map<String, String> mTokenMap;

    public static /* synthetic */ void $r8$lambda$KTks0Qy8pME4QD5ztq_nxY1MJ04(IUpdateAccountInfoCallback r0) {
        m153updateAccountInfoAsync$lambda3$lambda2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$OUf9rwiupOJnexUL0wi3LCoHg-c, reason: not valid java name */
    public static /* synthetic */ void m150$r8$lambda$OUf9rwiupOJnexUL0wi3LCoHgc(IUpdateAccountInfoCallback r0) {
        m152updateAccountInfoAsync$lambda3(r0);
    }

    public static /* synthetic */ void $r8$lambda$OYpRoIQFXVXyaWHww1pnGXt8BM8(IUpdateTokenMapCallback r0) {
        m154updateXttTokenMapAsync$lambda5(r0);
    }

    public static /* synthetic */ void $r8$lambda$yEcTYicgV8F9iVnai9tZsMSfhk8() {
        m151init$lambda1();
    }

    public static /* synthetic */ void $r8$lambda$z1uObTax7gtTnd4seTcotY6h5EQ(IUpdateTokenMapCallback r0) {
        m155updateXttTokenMapAsync$lambda5$lambda4(r0);
    }

    private OAccountManager() {
    }

    public static final /* synthetic */ Handler access$getMAsyncHandler$p() {
        return mAsyncHandler;
    }

    public static final /* synthetic */ Set access$getMSecureAccountStatusListenerSet$p() {
        return mSecureAccountStatusListenerSet;
    }

    static {
        INSTANCE = new OAccountManager();
        mAccountStatusListenerSet = new CopyOnWriteArraySet();
        mSecureAccountStatusListener = new OAccountManager$mSecureAccountStatusListener$1();
        mSecureAccountStatusListenerSet = new CopyOnWriteArraySet();
        mCallbackHandler = new Handler(Looper.getMainLooper());
        HandlerThread r0 = new HandlerThread("OAccountManager");
        r0.start();
        mAsyncHandler = new Handler(r0.getLooper());
    }

    public final SecureAccountStatusListener getMSecureAccountStatusListener() {
        return mSecureAccountStatusListener;
    }

    public final void setMSecureAccountStatusListener(SecureAccountStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        mSecureAccountStatusListener = r1;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void init(boolean r2) {
        startListen();
        mSecureAccountStatusListener.startListen();
        if (r2 == false) goto L5;
        asyncInvoke(new OAccountManager$$ExternalSyntheticLambda0());
        return;
    L5:
        onAccountInfoUpdate();
    }

    /* JADX INFO: renamed from: init$lambda-1, reason: not valid java name */
    private static final void m151init$lambda1() {
        INSTANCE.onAccountInfoUpdate();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public boolean isLogin() {
        return accountInfo().getLoginState();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public int logoutScene() {
        return accountInfo().getLogoutScene();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public String innerToken() {
        return accountInfo().getInnerSSOToken();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public synchronized AccountInfo accountInfo() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (mAccountInfo != null) goto L6;
        updateAccountInfo();     // Catch: Throwable -> L9
    L6:
        AccountInfo r0 = mAccountInfo;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00f3: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:32:0x00f3 */
    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public synchronized void updateAccountInfo() {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        ContentProviderClient r3 = null;
        Boolean r4 = null;
        ContentProviderClient r5 = AppGlobals.INSTANCE.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(AccountConst.AUTHORITY_ACCOUNT);     // Catch: Throwable -> L18 Exception -> L20
        if (r5 != null) goto L41;
        Bundle r0 = null;
    L12:
        if (r0 == null) goto L14;
        mAccountInfo = AccountInfoKt.fromBundle(new AccountInfo(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null), r0);     // Catch: Exception -> L9 Throwable -> L31
    L15:
        if (r5 == null) goto L25;
    L16:
        r5.close();     // Catch: Throwable -> L36
    L25:
        StringBuilder r2 = new StringBuilder("updateAccountInfo loginState: ");     // Catch: Throwable -> L36
        AccountInfo r1 = mAccountInfo;     // Catch: Throwable -> L36
        if (r1 == null) goto L28;
        r4 = Boolean.valueOf(r1.getLoginState());     // Catch: Throwable -> L36
    L28:
        OLog.i(TAG, r2.append(r4).toString());     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L14:
        mAccountInfo = new AccountInfo(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Exception -> L9 Throwable -> L31
        OLog.e(TAG, "updateAccountInfo getAccountInfo: result is null");     // Catch: Exception -> L9 Throwable -> L31
        goto L15
    L41:
        r0 = r5.call(AccountConst.AUTHORITY_ACCOUNT, AccountConst.METHOD_GET_ACCOUNT_INFO, null, null);     // Catch: Exception -> L9 Throwable -> L31
    L9:
        e = e;
    L22:
        mAccountInfo = new AccountInfo(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Throwable -> L31
        OLog.INSTANCE.e(TAG, "updateAccountInfo getAccountInfo err: " + e, e);     // Catch: Throwable -> L31
        if (r5 == null) goto L25;
    L31:
        th = th;
        r3 = r4;
    L33:
        if (r3 == null) goto L35;
        r3.close();     // Catch: Throwable -> L36
    L35:
        throw th;     // Catch: Throwable -> L36
    L20:
        e = e;
        r5 = null;
    L18:
        th = th;
        goto L33
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void updateAccountInfoAsync(final IUpdateAccountInfoCallback r2) {
        mAsyncHandler.post(new OAccountManager$$ExternalSyntheticLambda2(r2));
    }

    /* JADX INFO: renamed from: updateAccountInfoAsync$lambda-3, reason: not valid java name */
    private static final void m152updateAccountInfoAsync$lambda3(final IUpdateAccountInfoCallback r2) {
        INSTANCE.updateAccountInfo();
        mCallbackHandler.post(new OAccountManager$$ExternalSyntheticLambda4(r2));
    }

    /* JADX INFO: renamed from: updateAccountInfoAsync$lambda-3$lambda-2, reason: not valid java name */
    private static final void m153updateAccountInfoAsync$lambda3$lambda2(IUpdateAccountInfoCallback r1) {
        if (r1 == null) goto L5;
        AccountInfo r0 = mAccountInfo;
        Intrinsics.checkNotNull(r0);
        r1.onResult(r0);
        return;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public synchronized Map<String, String> xttTokenMap() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (mTokenMap != null) goto L6;
        updateXttTokenMap();     // Catch: Throwable -> L9
    L6:
        Map<String, String> r0 = mTokenMap;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public synchronized void updateXttTokenMap() {
        monitor-enter(this);
        Context r1 = AppGlobals.INSTANCE.getApplicationContext();     // Catch: Throwable -> L40
        ContentProviderClient r2 = 0;
        Integer r3 = null;
        ContentProviderClient r4 = r1.getContentResolver().acquireUnstableContentProviderClient(AccountConst.AUTHORITY_ACCOUNT);     // Catch: Throwable -> L22 Exception -> L24
        if (r4 != null) goto L43;
        Bundle r5 = null;
    L12:
        if (r5 == null) goto L18;
        Serializable r6 = r5.getSerializable(AccountConst.KEY_TOKEN_MAP);     // Catch: Exception -> L9 Throwable -> L35
        if (r6 == null) goto L17;
        mTokenMap = (Map) r6;     // Catch: Exception -> L9 Throwable -> L35
    L19:
        if (r4 == null) goto L29;
    L20:
        r4.close();     // Catch: Throwable -> L40
    L29:
        StringBuilder r7 = new StringBuilder("updateXttTokenMap: ");     // Catch: Throwable -> L40
        Map<String, String> r0 = mTokenMap;     // Catch: Throwable -> L40
        if (r0 == null) goto L32;
        r3 = Integer.valueOf(r0.size());     // Catch: Throwable -> L40
    L32:
        OLog.d(TAG, r7.append(r3).toString());     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L9 Throwable -> L35
    L18:
        mTokenMap = new HashMap();     // Catch: Exception -> L9 Throwable -> L35
        OLog.w(TAG, "getXttTokenMap: result is null");     // Catch: Exception -> L9 Throwable -> L35
        goto L19
    L43:
        r5 = r4.call(AccountConst.AUTHORITY_ACCOUNT, AccountConst.METHOD_GET_TOKEN_MAP, null, null);     // Catch: Exception -> L9 Throwable -> L35
    L9:
        e = e;
    L26:
        mTokenMap = new HashMap();     // Catch: Throwable -> L35
        OLog.INSTANCE.e(TAG, "getXttTokenMap: ", e);     // Catch: Throwable -> L35
        if (r4 == null) goto L29;
    L35:
        th = th;
        r2 = r1;
    L37:
        if (r2 == 0) goto L39;
        r2.close();     // Catch: Throwable -> L40
    L39:
        throw th;     // Catch: Throwable -> L40
    L24:
        e = e;
        r4 = null;
    L22:
        th = th;
    L40:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void updateXttTokenMapAsync(final IUpdateTokenMapCallback r2) {
        mAsyncHandler.post(new OAccountManager$$ExternalSyntheticLambda1(r2));
    }

    /* JADX INFO: renamed from: updateXttTokenMapAsync$lambda-5, reason: not valid java name */
    private static final void m154updateXttTokenMapAsync$lambda5(final IUpdateTokenMapCallback r2) {
        INSTANCE.updateAccountInfo();
        mCallbackHandler.post(new OAccountManager$$ExternalSyntheticLambda3(r2));
    }

    /* JADX INFO: renamed from: updateXttTokenMapAsync$lambda-5$lambda-4, reason: not valid java name */
    private static final void m155updateXttTokenMapAsync$lambda5$lambda4(IUpdateTokenMapCallback r1) {
        if (r1 == null) goto L5;
        Map<String, String> r0 = mTokenMap;
        Intrinsics.checkNotNull(r0);
        r1.onResult(r0);
        return;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void addAccountStatusListener(IAccountStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "accountStatusListener");
        Set<IAccountStatusListener> r0 = mAccountStatusListenerSet;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void removeAccountStatusListener(IAccountStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "accountStatusListener");
        Set<IAccountStatusListener> r0 = mAccountStatusListenerSet;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener, com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogin() {
        super.onLogin();
        onAccountInfoUpdate();
        Set<IAccountStatusListener> r2 = mAccountStatusListenerSet;
        monitor-enter(r2);
        Iterator<IAccountStatusListener> r0 = r2.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().onLogin();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r2);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener, com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogout(int r3) {
        super.onLogout(r3);
        onAccountInfoUpdate();
        Set<IAccountStatusListener> r2 = mAccountStatusListenerSet;
        monitor-enter(r2);
        Iterator<IAccountStatusListener> r0 = r2.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().onLogout(r3);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r2);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener, com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onAccountInfoUpdate() {
        super.onAccountInfoUpdate();
        updateAccountInfo();
        updateXttTokenMap();
        Set<IAccountStatusListener> r2 = mAccountStatusListenerSet;
        monitor-enter(r2);
        Iterator<IAccountStatusListener> r0 = r2.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().onAccountInfoUpdate();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r2);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.AccountStatusListener
    protected void asyncInvoke(Runnable r1) {
        Intrinsics.checkNotNullParameter(r1, "runnable");
        mAsyncHandler.post(r1);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void setLoginPhoneNumber(String r8) {
        Intrinsics.checkNotNullParameter(r8, AccountConst.KEY_PHONE_NUMBER);
        OLog.i(TAG, AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER);
        ContentProviderClient r5 = null;
        Bundle r6 = null;
        r5 = null;
        ContentProviderClient r4 = AppGlobals.INSTANCE.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(AccountConst.AUTHORITY_ACCOUNT);     // Catch: Throwable -> L17 Exception -> L19
        if (r4 != null) goto L30;
    L6:
        if (r6 == null) goto L12;
        int r7 = r6.getInt(AccountConst.KEY_SET_LOGIN_PHONE_NUMBER_RESULT);     // Catch: Throwable -> L8 Exception -> L10
    L13:
        if (r7 == 0) goto L15;
        OLog.e(TAG, "setLoginPhoneNumber failed, resCode: " + r7);     // Catch: Throwable -> L8 Exception -> L10
    L10:
        e = e;
        r5 = r4;
    L20:
        OLog.INSTANCE.e(TAG, "setLoginPhoneNumber error: ", e);     // Catch: Throwable -> L17
        if (r5 == null) goto L34;
        r5.close();
        return;
    L34:
        return;
    L8:
        th = th;
        r5 = r4;
    L24:
        if (r5 == null) goto L26;
        r5.close();
    L26:
        throw th;
    L15:
        if (r4 == null) goto L32;
        r4.close();
        return;
    L32:
        return;
    L12:
        r7 = -1;
        goto L13
    L30:
        Bundle r9 = new Bundle();     // Catch: Throwable -> L8 Exception -> L10
        r9.putString(AccountConst.KEY_PHONE_NUMBER, r8);     // Catch: Throwable -> L8 Exception -> L10
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8 Exception -> L10
        r6 = r4.call(AccountConst.AUTHORITY_ACCOUNT, AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER, null, r9);     // Catch: Throwable -> L8 Exception -> L10
    L19:
        e = e;
    L17:
        th = th;
        goto L24
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public Bundle getMatrixVersionInfo() {
        OLog.i(TAG, AccountConst.METHOD_GET_MATRIX_VERSION_INFO);
        ContentProviderClient r3 = null;
        Bundle r4 = null;
        r3 = null;
        ContentProviderClient r2 = AppGlobals.INSTANCE.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(AccountConst.AUTHORITY_ACCOUNT);     // Catch: Throwable -> L16 Exception -> L18
        if (r2 != null) goto L31;
    L6:
        if (r4 != null) goto L13;
        r4 = new Bundle();     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = e;
        r3 = r2;
    L19:
        OLog.INSTANCE.e(TAG, "setLoginPhoneNumber error: ", e);     // Catch: Throwable -> L16
        if (r3 == null) goto L23;
        r3.close();
    L23:
        return new Bundle();
    L9:
        th = th;
        r3 = r2;
    L24:
        if (r3 == null) goto L26;
        r3.close();
    L26:
        throw th;
    L13:
        if (r2 == null) goto L15;
        r2.close();
    L15:
        return r4;
    L31:
        r4 = r2.call(AccountConst.AUTHORITY_ACCOUNT, AccountConst.METHOD_GET_MATRIX_VERSION_INFO, null, null);     // Catch: Throwable -> L9 Exception -> L11
    L16:
        th = th;
    L18:
        e = e;
        goto L19
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountManager
    public void addSecureAccountStatusListener(IAccountStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "accountStatusListener");
        Set<IAccountStatusListener> r0 = mSecureAccountStatusListenerSet;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
