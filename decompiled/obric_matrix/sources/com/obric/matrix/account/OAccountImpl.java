package com.obric.matrix.account;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.app.AppInfoProvider;
import com.obric.matrix.account_api.IAccount;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.m0;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016Jq\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\\\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040*H\u0016J\"\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u00020\u0014H\u0016J\u001a\u00103\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00104\u001a\u00020\u0014H\u0016J$\u00105\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016Jd\u00106\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016JR\u00107\u001a\u00020\u00142\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%28\u00109\u001a4\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\u008c\u0001\u0010:\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u000428\u00108\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(<\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001f28\u00109\u001a4\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016Jl\u0010?\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016Jj\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020 2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%28\u00109\u001a4\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\\\u0010E\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\u0006\u0010F\u001a\u00020\u0014Jd\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016Jd\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\\\u0010L\u001a\u00020\u00142\b\u0010M\u001a\u0004\u0018\u00010N2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%28\u00109\u001a4\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016Jq\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u00042%\u00108\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(Q\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a28\u00109\u001a4\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016Jy\u0010R\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016Jy\u0010S\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\u0081\u0001\u0010T\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0006\u0010D\u001a\u00020 2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2:\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fH\u0016J\u000e\u0010\"\u001a\u00020\u0004*\u0004\u0018\u00010UH\u0002J\f\u0010V\u001a\u00020\u0004*\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006W"}, d2 = {"Lcom/obric/matrix/account/OAccountImpl;", "Lcom/obric/matrix/account_api/IAccount;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bdAccountImpl", "Lcom/bytedance/sdk/account/api/BDAccountAPIV2Impl;", "getBdAccountImpl", "()Lcom/bytedance/sdk/account/api/BDAccountAPIV2Impl;", "bdAccountImpl$delegate", "Lkotlin/Lazy;", "logouting", "", "getLogouting", "()Z", "setLogouting", "(Z)V", "addAccountStatusListener", "", "listener", "Lcom/obric/matrix/account_api/IAccountStatusListener;", "checkMobileRegister", "mobile", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isRegistered", "onFailed", "Lkotlin/Function2;", "", "errorCode", "errorMsg", "checkPassword", "password", "Lkotlin/Function0;", "forceUpdateAccount", "getAccountInfo", "Lcom/obric/matrix/account_api/AccountInfo;", "getXttTokenMap", "", "goToLogin", "context", "Landroid/content/Context;", "options", "Landroid/app/ActivityOptions;", "callbackIntent", "Landroid/app/PendingIntent;", "init", "login", "loginFinished", "loginWithLarkSSOCallback", "loginWithPassword", "logout", "onSuccessAction", "onFailedAction", "quickLogin", "code", "isNewUser", "hasPassword", "removeAccountStatusListener", "resetPassword", "smsCode", "sendCode", "pkgName", "account", "scene", "setInitPassword", "testSessionExipred", "ticketResetPassword", "ticket", "updatePassword", "oldPassword", "newPassword", "updateUserInfo", "generalParams", "Landroid/os/Bundle;", "uploadAvatar", "path", "webUri", "verifyPassword", "verifyPasswordWithoutLogin", "verifySmsCode", "Lcom/bytedance/sdk/account/api/call/BaseApiResponse;", "mapToReadableMsg", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccountImpl implements IAccount {
    private final String TAG;
    private final kotlin.h bdAccountImpl$delegate;
    private volatile boolean logouting;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/sdk/account/api/BDAccountAPIV2Impl;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<d.b.s.a.q.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8387f = null;

        static {
            f8387f = new a();
        }

        a() {
            super(0);
        }

        public final d.b.s.a.q.a a() {
            return new d.b.s.a.q.a();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ d.b.s.a.q.a invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account/OAccountImpl$checkMobileRegister$1", "Lcom/bytedance/sdk/account/api/call/AbsApiCall;", "Lcom/bytedance/sdk/account/api/call/CheckMobileRegisterResponse;", "onResponse", "", "response", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends d.b.s.a.q.j.a<d.b.s.a.q.j.c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<Boolean, f0> f8389d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8390e;

        /* JADX WARN: Multi-variable type inference failed */
        b(OAccountImpl r1, kotlin.n0.c.l<? super Boolean, f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8388c = r1;
            this.f8389d = r2;
            this.f8390e = r3;
        }

        @Override // d.b.s.a.q.j.a
        public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
            g((d.b.s.a.q.j.c) r1);
        }

        public void g(d.b.s.a.q.j.c r4) {
            boolean r0 = true;
            if (r4 != null) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L12;
            com.obric.matrix.r.c.c.b(this.f8388c.getTAG(), "checkMobileRegister success.");
            kotlin.n0.c.l<Boolean, f0> r3 = this.f8389d;
            if (r3 == null) goto L19;
            r3.invoke(Boolean.valueOf(r4.p));
            return;
        L19:
            return;
        L12:
            com.obric.matrix.r.c.c.f(this.f8388c.getTAG(), "checkMobileRegister failed: " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.p<Integer, String, f0> r1 = this.f8390e;
            if (r1 == null) goto L21;
            if (r4 == null) goto L16;
            int r2 = r4.f14891g;
        L17:
            r1.invoke(Integer.valueOf(r2), OAccountImpl.access$errorMsg(this.f8388c, r4));
            return;
        L16:
            r2 = -1;
            goto L17
        L21:
            return;
        L5:
            if (r4.f14887c != true) goto L7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/OAccountImpl$checkPassword$1", "Lcom/bytedance/sdk/account/api/callback/CheckPwdCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/response/CheckPwdResponse;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends d.b.s.a.q.k.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8393e;

        /* JADX WARN: Multi-variable type inference failed */
        c(OAccountImpl r1, kotlin.n0.c.a<f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8391c = r1;
            this.f8392d = r2;
            this.f8393e = r3;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.b) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.b) r1);
        }

        public void m(d.b.s.a.q.m.b r4, int r5) {
            com.obric.matrix.r.c.c.b(this.f8391c.getTAG(), "checkPassword, onError: " + com.obric.matrix.account.r.a.f8616a.b(r4) + ", error: " + r5);
            kotlin.n0.c.p<Integer, String, f0> r6 = this.f8393e;
            if (r6 == null) goto L9;
            if (r4 == null) goto L6;
            int r0 = r4.f14891g;
        L7:
            r6.invoke(Integer.valueOf(r0), OAccountImpl.access$errorMsg(this.f8391c, r4));
            return;
        L6:
            r0 = -1;
            goto L7
        }

        public void n(d.b.s.a.q.m.b r4) {
            com.obric.matrix.r.c.c.b(this.f8391c.getTAG(), "checkPassword, onSuccess: " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.a<f0> r3 = this.f8392d;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/account/OAccountImpl$loginWithPassword$1", "Lcom/bytedance/sdk/account/mobile/thread/call/UserPasswordLoginQueryCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/UserPasswordLoginQueryObj;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends d.b.s.a.b0.b.g.e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f8395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8396e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8397f;

        /* JADX WARN: Multi-variable type inference failed */
        d(OAccountImpl r1, String r2, kotlin.n0.c.a<f0> r3, kotlin.n0.c.p<? super Integer, ? super String, f0> r4) {
            this.f8394c = r1;
            this.f8395d = r2;
            this.f8396e = r3;
            this.f8397f = r4;
        }

        @Override // d.b.s.a.j
        public void p(d.b.s.a.q.j.e<d.b.s.a.b0.a.g> r4, int r5) {
            com.obric.matrix.r.c.c.b(this.f8394c.getTAG(), "loginWithPassword, onError: " + com.obric.matrix.account.r.a.f8616a.b(r4) + ", error: " + r5);
            kotlin.n0.c.p<Integer, String, f0> r6 = this.f8397f;
            if (r6 == null) goto L9;
            if (r4 == null) goto L6;
            int r0 = r4.f14891g;
        L7:
            r6.invoke(Integer.valueOf(r0), OAccountImpl.access$errorMsg(this.f8394c, r4));
            return;
        L6:
            r0 = -1;
            goto L7
        }

        @Override // d.b.s.a.j
        public void q(d.b.s.a.q.j.e<d.b.s.a.b0.a.g> r5) {
            com.obric.matrix.r.c.c.b(this.f8394c.getTAG(), "loginWithPassword, onSuccess: " + com.obric.matrix.account.r.a.f8616a.b(r5));
            com.obric.matrix.account.a r6 = com.obric.matrix.account.a.f8438a;
            r6.z(System.currentTimeMillis());
            r6.y(this.f8395d);
            com.obric.matrix.r.c.e.a(this.f8394c.getTAG(), "loginWithPassword loginInfo: loginUtcTime=" + r6.i() + ", loginPhoneNumber=" + r6.h());
            kotlin.n0.c.a<f0> r4 = this.f8396e;
            if (r4 == null) goto L6;
            r4.invoke();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account/OAccountImpl$logout$1", "Lcom/bytedance/sdk/account/api/call/AbsApiCall;", "Lcom/bytedance/sdk/account/api/call/LogoutApiResponse;", "onResponse", "", "response", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends d.b.s.a.q.j.a<d.b.s.a.q.j.d> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8400e;

        /* JADX WARN: Multi-variable type inference failed */
        e(OAccountImpl r1, kotlin.n0.c.a<f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8398c = r1;
            this.f8399d = r2;
            this.f8400e = r3;
        }

        @Override // d.b.s.a.q.j.a
        public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
            g((d.b.s.a.q.j.d) r1);
        }

        public void g(d.b.s.a.q.j.d r4) {
            boolean r0 = true;
            if (r4 != null) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L12;
            com.obric.matrix.r.c.c.b(this.f8398c.getTAG(), "Logout success.");
            this.f8398c.setLogouting(false);
            kotlin.n0.c.a<f0> r3 = this.f8399d;
            if (r3 == null) goto L16;
            r3.invoke();
            return;
        L16:
            return;
        L12:
            this.f8398c.setLogouting(false);
            com.obric.matrix.r.c.c.f(this.f8398c.getTAG(), "Logout failed, " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.p<Integer, String, f0> r1 = this.f8400e;
            if (r1 == null) goto L18;
            kotlin.n0.d.o.c(r4);
            r1.invoke(Integer.valueOf(r4.f14891g), OAccountImpl.access$errorMsg(this.f8398c, r4));
            return;
        L18:
            return;
        L5:
            if (r4.f14887c != true) goto L7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/account/OAccountImpl$quickLogin$1", "Lcom/bytedance/sdk/account/mobile/thread/call/QuickLoginCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/QuickLoginQueryObj;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends d.b.s.a.b0.b.g.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Boolean, Boolean, f0> f8403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8404f;

        /* JADX WARN: Multi-variable type inference failed */
        f(String r1, OAccountImpl r2, kotlin.n0.c.p<? super Boolean, ? super Boolean, f0> r3, kotlin.n0.c.p<? super Integer, ? super String, f0> r4) {
            this.f8401c = r1;
            this.f8402d = r2;
            this.f8403e = r3;
            this.f8404f = r4;
        }

        @Override // d.b.s.a.j
        public void p(d.b.s.a.q.j.e<d.b.s.a.b0.a.d> r5, int r6) {
            String r0 = this.f8402d.getTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("quickLogin, onError, ");
            com.obric.matrix.account.r.a r2 = com.obric.matrix.account.r.a.f8616a;
            r1.append(r2.b(r5));
            com.obric.matrix.r.c.c.f(r0, r1.toString());
            JSONObject r3 = new JSONObject();
            if (r5 == null) goto L9;
            d.b.s.a.b0.a.d r4 = (d.b.s.a.b0.a.d) r5.p;
            if (r4 == null) goto L9;
            d.b.s.a.k0.a r7 = r4.p;
            if (r7 == null) goto L9;
            boolean r8 = r7.p();
        L10:
            r3.put("is_new_user", r8);
            String r9 = r2.a(OAccountImpl.access$errorMsg(this.f8402d, r5), r3);
            kotlin.n0.c.p<Integer, String, f0> r10 = this.f8404f;
            if (r10 == null) goto L14;
            r10.invoke(Integer.valueOf(r6), r9);
            return;
        L14:
            return;
        L9:
            r8 = false;
            goto L10
        }

        @Override // d.b.s.a.j
        public void q(d.b.s.a.q.j.e<d.b.s.a.b0.a.d> r9) {
            if (r9 == null) goto L6;
            d.b.s.a.b0.a.d r0 = (d.b.s.a.b0.a.d) r9.p;
            if (r0 == null) goto L6;
            d.b.s.a.k0.a r1 = r0.p;
        L7:
            boolean r2 = false;
            if (r1 == null) goto L10;
            boolean r3 = r1.p();
        L11:
            if (r1 == null) goto L13;
            r2 = r1.f14839l;
        L13:
            com.obric.matrix.account.a r4 = com.obric.matrix.account.a.f8438a;
            r4.z(System.currentTimeMillis());
            r4.y(this.f8401c);
            com.obric.matrix.r.c.e.a(this.f8402d.getTAG(), "quickLogin loginInfo: loginUtcTime=" + r4.i() + ", loginPhoneNumber=" + r4.h());
            com.obric.matrix.r.c.c.b(this.f8402d.getTAG(), "quickLogin onSuccess, " + com.obric.matrix.account.r.a.f8616a.b(r9) + ", isNewUser:" + r3 + ", hasPassword:" + r2);
            com.obric.matrix.account.k.f8544a.c(r1, "quickLogin onSuccess");
            kotlin.n0.c.p<Boolean, Boolean, f0> r10 = this.f8403e;
            if (r10 == null) goto L16;
            r10.invoke(Boolean.valueOf(r3), Boolean.valueOf(r2));
        L16:
            this.f8402d.loginFinished();
            return;
        L10:
            r3 = false;
        L6:
            r1 = null;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/account/OAccountImpl$resetPassword$1", "Lcom/bytedance/sdk/account/mobile/thread/call/ResetPasswordCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/ResetPasswordQueryObj;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g extends d.b.s.a.b0.b.g.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8407e;

        /* JADX WARN: Multi-variable type inference failed */
        g(OAccountImpl r1, kotlin.n0.c.a<f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8405c = r1;
            this.f8406d = r2;
            this.f8407e = r3;
        }

        @Override // d.b.s.a.j
        public void p(d.b.s.a.q.j.e<d.b.s.a.b0.a.e> r4, int r5) {
            com.obric.matrix.r.c.c.b(this.f8405c.getTAG(), "resetPassword, onError: " + com.obric.matrix.account.r.a.f8616a.b(r4) + ", error: " + r5);
            kotlin.n0.c.p<Integer, String, f0> r6 = this.f8407e;
            if (r6 == null) goto L9;
            if (r4 == null) goto L6;
            int r0 = r4.f14891g;
        L7:
            r6.invoke(Integer.valueOf(r0), OAccountImpl.access$errorMsg(this.f8405c, r4));
            return;
        L6:
            r0 = -1;
            goto L7
        }

        @Override // d.b.s.a.j
        public void q(d.b.s.a.q.j.e<d.b.s.a.b0.a.e> r4) {
            com.obric.matrix.r.c.c.b(this.f8405c.getTAG(), "resetPassword, onSuccess: " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.a<f0> r3 = this.f8406d;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/account/OAccountImpl$sendCode$1", "Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/SendCodeQueryObj;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h extends d.b.s.a.b0.b.g.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f8409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f8410e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8411f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8412g;

        /* JADX WARN: Multi-variable type inference failed */
        h(OAccountImpl r1, String r2, int r3, kotlin.n0.c.a<f0> r4, kotlin.n0.c.p<? super Integer, ? super String, f0> r5) {
            this.f8408c = r1;
            this.f8409d = r2;
            this.f8410e = r3;
            this.f8411f = r4;
            this.f8412g = r5;
        }

        @Override // d.b.s.a.j
        public void p(d.b.s.a.q.j.e<d.b.s.a.b0.a.f> r4, int r5) {
            com.obric.matrix.r.c.c.f(this.f8408c.getTAG(), "sendCode, onError, " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.p<Integer, String, f0> r0 = this.f8412g;
            if (r0 == null) goto L6;
            r0.invoke(Integer.valueOf(r5), OAccountImpl.access$errorMsg(this.f8408c, r4));
            return;
        }

        @Override // d.b.s.a.j
        public void q(d.b.s.a.q.j.e<d.b.s.a.b0.a.f> r4) {
            String r0 = this.f8408c.getTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("sendCode, onSuccess, pkgName:");
            r1.append(this.f8409d);
            r1.append(" scene:");
            r1.append(this.f8410e);
            r1.append(" logId:");
            if (r4 == null) goto L5;
            String r5 = r4.f14885a;
        L6:
            r1.append(r5);
            com.obric.matrix.r.c.c.j(r0, r1.toString());
            kotlin.n0.c.a<f0> r3 = this.f8411f;
            if (r3 == null) goto L10;
            r3.invoke();
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/account/OAccountImpl$setInitPassword$1", "Lcom/bytedance/sdk/account/mobile/thread/call/SetPassCall;", "onResponse", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/thread/SetpassThread$SetPassObj;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class i extends d.b.s.a.b0.b.g.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8415e;

        /* JADX WARN: Multi-variable type inference failed */
        i(OAccountImpl r1, kotlin.n0.c.a<f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8413c = r1;
            this.f8414d = r2;
            this.f8415e = r3;
        }

        @Override // d.b.s.a.q.j.a
        public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
            g((d.b.s.a.q.j.e) r1);
        }

        public void g(d.b.s.a.q.j.e<d.b.s.a.b0.b.e.a> r4) {
            com.obric.matrix.r.c.c.b(this.f8413c.getTAG(), "setInitPassword, onResponse: " + com.obric.matrix.account.r.a.f8616a.b(r4));
            boolean r0 = true;
            if (r4 != null) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L12;
            kotlin.n0.c.a<f0> r3 = this.f8414d;
            if (r3 == null) goto L19;
            r3.invoke();
            return;
        L19:
            return;
        L12:
            kotlin.n0.c.p<Integer, String, f0> r1 = this.f8415e;
            if (r1 == null) goto L21;
            if (r4 == null) goto L16;
            int r2 = r4.f14891g;
        L17:
            r1.invoke(Integer.valueOf(r2), OAccountImpl.access$errorMsg(this.f8413c, r4));
            return;
        L16:
            r2 = -1;
            goto L17
        L21:
            return;
        L5:
            if (r4.f14887c != true) goto L7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account/OAccountImpl$testSessionExipred$1", "Lcom/bytedance/sdk/account/api/call/AbsApiCall;", "Lcom/bytedance/sdk/account/api/call/LogoutApiResponse;", "onResponse", "", "response", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class j extends d.b.s.a.q.j.a<d.b.s.a.q.j.d> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8416c;

        j(OAccountImpl r1) {
            this.f8416c = r1;
        }

        @Override // d.b.s.a.q.j.a
        public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
            g((d.b.s.a.q.j.d) r1);
        }

        public void g(d.b.s.a.q.j.d r3) {
            boolean r0 = true;
            if (r3 != null) goto L5;
        L7:
            r0 = false;
        L8:
            String r4 = this.f8416c.getTAG();
            if (r0 == false) goto L11;
            com.obric.matrix.r.c.c.b(r4, "Logout success.");
        L12:
            this.f8416c.setLogouting(false);
            return;
        L11:
            com.obric.matrix.r.c.c.f(r4, "Logout failed.");
            goto L12
        L5:
            if (r3.f14887c != true) goto L7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/OAccountImpl$ticketResetPassword$1", "Lcom/bytedance/sdk/account/api/callback/TicketResetPasswordCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/response/TicketResetPasswordResponse;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class k extends d.b.s.a.q.k.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8419e;

        /* JADX WARN: Multi-variable type inference failed */
        k(OAccountImpl r1, kotlin.n0.c.a<f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8417c = r1;
            this.f8418d = r2;
            this.f8419e = r3;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.f) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.f) r1);
        }

        public void m(d.b.s.a.q.m.f r4, int r5) {
            com.obric.matrix.r.c.c.b(this.f8417c.getTAG(), "ticketResetPassword, onError: " + com.obric.matrix.account.r.a.f8616a.b(r4) + ", error: " + r5);
            kotlin.n0.c.p<Integer, String, f0> r6 = this.f8419e;
            if (r6 == null) goto L9;
            if (r4 == null) goto L6;
            int r0 = r4.f14891g;
        L7:
            r6.invoke(Integer.valueOf(r0), OAccountImpl.access$errorMsg(this.f8417c, r4));
            return;
        L6:
            r0 = -1;
            goto L7
        }

        public void n(d.b.s.a.q.m.f r4) {
            com.obric.matrix.r.c.c.b(this.f8417c.getTAG(), "ticketResetPassword, onSuccess: " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.a<f0> r3 = this.f8418d;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/OAccountImpl$updatePassword$1", "Lcom/bytedance/sdk/account/api/callback/UpdatePwdCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/response/UpdatePwdResponse;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class l extends d.b.s.a.q.k.e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8421d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8422e;

        /* JADX WARN: Multi-variable type inference failed */
        l(OAccountImpl r1, kotlin.n0.c.a<f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8420c = r1;
            this.f8421d = r2;
            this.f8422e = r3;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.g) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.g) r1);
        }

        public void m(d.b.s.a.q.m.g r4, int r5) {
            com.obric.matrix.r.c.c.b(this.f8420c.getTAG(), "updatePassword, onError: " + com.obric.matrix.account.r.a.f8616a.b(r4) + ", error: " + r5);
            kotlin.n0.c.p<Integer, String, f0> r6 = this.f8422e;
            if (r6 == null) goto L9;
            if (r4 == null) goto L6;
            int r0 = r4.f14891g;
        L7:
            r6.invoke(Integer.valueOf(r0), OAccountImpl.access$errorMsg(this.f8420c, r4));
            return;
        L6:
            r0 = -1;
            goto L7
        }

        public void n(d.b.s.a.q.m.g r4) {
            com.obric.matrix.r.c.c.b(this.f8420c.getTAG(), "updatePassword, onSuccess: " + r4);
            kotlin.n0.c.a<f0> r3 = this.f8421d;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/OAccountImpl$updateUserInfo$1", "Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/information/method/update_user_info/UpdateUserInfoResponse;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class m extends d.b.s.a.x.d.b.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<f0> f8424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8425e;

        /* JADX WARN: Multi-variable type inference failed */
        m(OAccountImpl r1, kotlin.n0.c.a<f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8423c = r1;
            this.f8424d = r2;
            this.f8425e = r3;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.x.d.b.c) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.x.d.b.c) r1);
        }

        public void m(d.b.s.a.x.d.b.c r4, int r5) {
            com.obric.matrix.r.c.c.f(this.f8423c.getTAG(), "updateUserInfo error, " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.p<Integer, String, f0> r0 = this.f8425e;
            if (r0 == null) goto L6;
            r0.invoke(Integer.valueOf(r5), OAccountImpl.access$errorMsg(this.f8423c, r4));
            return;
        }

        public void n(d.b.s.a.x.d.b.c r4) {
            String r0 = this.f8423c.getTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("updateUserInfo() onSuccess  logId:");
            if (r4 == null) goto L5;
            String r5 = r4.f14885a;
        L6:
            r1.append(r5);
            com.obric.matrix.r.c.c.j(r0, r1.toString());
            kotlin.n0.c.a<f0> r3 = this.f8424d;
            if (r3 == null) goto L10;
            r3.invoke();
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/OAccountImpl$uploadAvatar$1", "Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/information/method/upload_avatar/UploadAvatarResponse;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class n extends d.b.s.a.x.d.c.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<String, f0> f8427d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8428e;

        /* JADX WARN: Multi-variable type inference failed */
        n(OAccountImpl r1, kotlin.n0.c.l<? super String, f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8426c = r1;
            this.f8427d = r2;
            this.f8428e = r3;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.x.d.c.c) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.x.d.c.c) r1);
        }

        public void m(d.b.s.a.x.d.c.c r4, int r5) {
            com.obric.matrix.r.c.c.f(this.f8426c.getTAG(), "uploadAvatar, " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.p<Integer, String, f0> r0 = this.f8428e;
            if (r0 == null) goto L6;
            r0.invoke(Integer.valueOf(r5), OAccountImpl.access$errorMsg(this.f8426c, r4));
            return;
        }

        public void n(d.b.s.a.x.d.c.c r4) {
            com.obric.matrix.r.c.c.j(this.f8426c.getTAG(), "uploadAvatar, " + com.obric.matrix.account.r.a.f8616a.b(r4));
            kotlin.n0.c.l<String, f0> r3 = this.f8427d;
            if (r3 == null) goto L9;
            if (r4 == null) goto L6;
            String r5 = r4.b();
        L7:
            r3.invoke(r5);
            return;
        L6:
            r5 = null;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/OAccountImpl$verifyPassword$1", "Lcom/bytedance/sdk/account/api/callback/VerifyAccountPasswordCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/response/VerifyAccountPasswordResponse;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class o extends d.b.s.a.q.k.g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<String, f0> f8430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8431e;

        /* JADX WARN: Multi-variable type inference failed */
        o(OAccountImpl r1, kotlin.n0.c.l<? super String, f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8429c = r1;
            this.f8430d = r2;
            this.f8431e = r3;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.i) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.i) r1);
        }

        public void m(d.b.s.a.q.m.i r4, int r5) {
            com.obric.matrix.r.c.c.b(this.f8429c.getTAG(), "verifyPassword, onError: " + com.obric.matrix.account.r.a.f8616a.c(r4) + ", error: " + r5);
            kotlin.n0.c.p<Integer, String, f0> r6 = this.f8431e;
            if (r6 == null) goto L9;
            if (r4 == null) goto L6;
            int r0 = r4.f14891g;
        L7:
            r6.invoke(Integer.valueOf(r0), OAccountImpl.access$errorMsg(this.f8429c, r4));
            return;
        L6:
            r0 = -1;
            goto L7
        }

        public void n(d.b.s.a.q.m.i r4) {
            com.obric.matrix.r.c.c.b(this.f8429c.getTAG(), "verifyPassword, onSuccess: " + com.obric.matrix.account.r.a.f8616a.c(r4));
            kotlin.n0.c.l<String, f0> r3 = this.f8430d;
            if (r3 == null) goto L11;
            if (r4 == null) goto L6;
            String r5 = r4.b();
        L7:
            if (r5 != null) goto L9;
            r5 = "";
        L9:
            r3.invoke(r5);
            return;
        L6:
            r5 = null;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account/OAccountImpl$verifyPasswordWithoutLogin$1", "Lcom/bytedance/sdk/account/api/call/AbsApiCall;", "Lcom/bytedance/sdk/account/api/response/CommonRequestResponse;", "onResponse", "", "response", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class p extends d.b.s.a.q.j.a<d.b.s.a.q.m.c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<String, f0> f8433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8434e;

        /* JADX WARN: Multi-variable type inference failed */
        p(OAccountImpl r1, kotlin.n0.c.l<? super String, f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8432c = r1;
            this.f8433d = r2;
            this.f8434e = r3;
        }

        @Override // d.b.s.a.q.j.a
        public /* bridge */ /* synthetic */ void c(d.b.s.a.q.j.b r1) {
            g((d.b.s.a.q.m.c) r1);
        }

        public void g(d.b.s.a.q.m.c r7) {
            String r0 = this.f8432c.getTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("verifyPasswordWithoutLogin, onResponse: ");
            com.obric.matrix.account.r.a r2 = com.obric.matrix.account.r.a.f8616a;
            r1.append(r2.c(r7));
            com.obric.matrix.r.c.c.b(r0, r1.toString());
            boolean r3 = true;
            if (r7 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == false) goto L25;
            JSONObject r8 = r7.q;
            Boolean r5 = null;
            if (r8 == null) goto L12;
            String r9 = r8.optString("ticket");
        L13:
            String r6 = this.f8432c.getTAG();
            StringBuilder r10 = new StringBuilder();
            r10.append("verifyPasswordWithoutLogin, ticket.empty: ");
            if (r9 != null) goto L16;
        L20:
            r10.append(r5);
            com.obric.matrix.r.c.c.b(r6, r10.toString());
            kotlin.n0.c.l<String, f0> r11 = this.f8433d;
            if (r11 == null) goto L32;
            if (r9 != null) goto L24;
            r9 = "";
        L24:
            r11.invoke(r9);
            return;
        L32:
            return;
        L16:
            if (r9.length() == 0) goto L19;
            r3 = false;
        L19:
            r5 = Boolean.valueOf(r3);
            goto L20
        L12:
            r9 = null;
            goto L13
        L25:
            com.obric.matrix.r.c.c.f(this.f8432c.getTAG(), "verifyPasswordWithoutLogin, onError: " + r2.c(r7));
            kotlin.n0.c.p<Integer, String, f0> r12 = this.f8434e;
            if (r12 == null) goto L34;
            if (r7 == null) goto L29;
            int r13 = r7.f14891g;
        L30:
            r12.invoke(Integer.valueOf(r13), OAccountImpl.access$errorMsg(this.f8432c, r7));
            return;
        L29:
            r13 = -1;
            goto L30
        L34:
            return;
        L5:
            if (r7.f14887c != true) goto L7;
            r4 = true;
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/OAccountImpl$verifySmsCode$1", "Lcom/bytedance/sdk/account/api/callback/CheckCodeCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/response/CheckCodeResponse;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class q extends d.b.s.a.q.k.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAccountImpl f8435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<String, f0> f8436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.p<Integer, String, f0> f8437e;

        /* JADX WARN: Multi-variable type inference failed */
        q(OAccountImpl r1, kotlin.n0.c.l<? super String, f0> r2, kotlin.n0.c.p<? super Integer, ? super String, f0> r3) {
            this.f8435c = r1;
            this.f8436d = r2;
            this.f8437e = r3;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.a) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.a) r1);
        }

        public void m(d.b.s.a.q.m.a r4, int r5) {
            com.obric.matrix.r.c.c.b(this.f8435c.getTAG(), "verifySmsCode, onError: " + com.obric.matrix.account.r.a.f8616a.b(r4) + ", error: " + r5);
            kotlin.n0.c.p<Integer, String, f0> r6 = this.f8437e;
            if (r6 == null) goto L9;
            if (r4 == null) goto L6;
            int r0 = r4.f14891g;
        L7:
            r6.invoke(Integer.valueOf(r0), OAccountImpl.access$errorMsg(this.f8435c, r4));
            return;
        L6:
            r0 = -1;
            goto L7
        }

        public void n(d.b.s.a.q.m.a r5) {
            String r0 = this.f8435c.getTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("verifySmsCode, onSuccess: ");
            r1.append(com.obric.matrix.account.r.a.f8616a.b(r5));
            r1.append(", ticket: ");
            String r2 = null;
            if (r5 == null) goto L5;
            String r3 = r5.p;
        L6:
            r1.append(r3);
            com.obric.matrix.r.c.c.b(r0, r1.toString());
            kotlin.n0.c.l<String, f0> r4 = this.f8436d;
            if (r4 == null) goto L14;
            if (r5 == null) goto L10;
            r2 = r5.p;
        L10:
            if (r2 != null) goto L12;
            r2 = "";
        L12:
            r4.invoke(r2);
            return;
        L14:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public OAccountImpl() {
        this.TAG = "OAccountImpl";
        this.bdAccountImpl$delegate = kotlin.i.b(a.f8387f);
    }

    public static final /* synthetic */ String access$errorMsg(OAccountImpl r0, d.b.s.a.q.j.b r1) {
        return r0.errorMsg(r1);
    }

    private final String errorMsg(d.b.s.a.q.j.b r5) {
        String r0 = "unknown error";
        if (r5 == null) goto L21;
        String r1 = r5.f14893i;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        r0 = r5.f14893i;
        goto L21
    L14:
        String r4 = r5.f14894j;
        if (r4 != null) goto L17;
    L18:
        r2 = true;
    L19:
        if (r2 == true) goto L21;
        r0 = r5.f14894j;
        goto L21
    L17:
        if (r4.length() != 0) goto L19;
    L8:
        if (r1.length() == 0) goto L11;
        r3 = false;
    L21:
        kotlin.n0.d.o.e(r0, "rawErrorMsg");
        return mapToReadableMsg(r0);
    }

    private final d.b.s.a.q.a getBdAccountImpl() {
        return (d.b.s.a.q.a) this.bdAccountImpl$delegate.getValue();
    }

    private final String mapToReadableMsg(String r2) {
        Context r1 = d.g.f.a.a.f16974a.d();
        if (kotlin.n0.d.o.a(r2, "no net work") == false) goto L6;
        String r3 = r1.getString(com.obric.matrix.account.j.f8534c);
        kotlin.n0.d.o.e(r3, "context.getString(R.stri…account_error_no_network)");
        return r3;
    L6:
        return r2;
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void addAccountStatusListener(com.obric.matrix.account_api.c r1) {
        kotlin.n0.d.o.f(r1, "listener");
        com.obric.matrix.account.p.b.f8600a.i(r1);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void checkMobileRegister(String r3, kotlin.n0.c.l<? super Boolean, f0> r4, kotlin.n0.c.p<? super Integer, ? super String, f0> r5) {
        kotlin.n0.d.o.f(r3, "mobile");
        com.obric.matrix.r.c.c.b(this.TAG, "checkMobileRegister");
        getBdAccountImpl().b(r3, new b(this, r4, r5));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void checkPassword(String r3, kotlin.n0.c.a<f0> r4, kotlin.n0.c.p<? super Integer, ? super String, f0> r5) {
        kotlin.n0.d.o.f(r3, "password");
        com.obric.matrix.r.c.c.b(this.TAG, "checkPassword");
        getBdAccountImpl().m(r3, new c(this, r4, r5));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void forceUpdateAccount() {
        if (com.obric.matrix.account.a.f8438a.v() == true) goto L6;
        com.obric.matrix.r.c.c.f(this.TAG, "Didn't login.");
        return;
    L6:
        com.obric.matrix.account.p.a.f8593f.l("forceUpdateAccount", true);
        com.ss.android.token.n.y();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public com.obric.matrix.account_api.a getAccountInfo() {
        if (com.obric.matrix.account.p.b.f8600a.k() == true) goto L7;
        return new com.obric.matrix.account_api.a(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);
    L7:
        return com.obric.matrix.account.a.f8438a.b();
    }

    public final boolean getLogouting() {
        return this.logouting;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.obric.matrix.account_api.IAccount
    public Map<String, String> getXttTokenMap() {
        if (com.obric.matrix.account.p.b.f8600a.k() == true) goto L7;
        return m0.h();
    L7:
        return com.obric.matrix.account.a.f8438a.n();
    }

    public final void goToLogin(Context r4, ActivityOptions r5, PendingIntent r6) {
        kotlin.n0.d.o.f(r4, "context");
        if (com.obric.matrix.account.a.f8438a.v() == false) goto L6;
        com.obric.matrix.r.c.c.f(this.TAG, "goToLogin failed, login already.");
        return;
    L6:
        com.obric.matrix.account.d.f8446a.b(r6);
        Intent r0 = new Intent("com.obric.account.action.OBRIC_ACCOUNT_LOGIN");     // Catch: Exception -> L16
        r0.setPackage("com.obric.account");     // Catch: Exception -> L16
        r0.putExtra("destination", "welcome");     // Catch: Exception -> L16
        Bundle r2 = null;
        if (r6 == null) goto L10;
        String r7 = r6.getCreatorPackage();     // Catch: Exception -> L16
    L11:
        r0.putExtra("enter_from", r7);     // Catch: Exception -> L16
        r0.addFlags(270532608);     // Catch: Exception -> L16
        if (r5 == null) goto L14;
        r2 = r5.toBundle();     // Catch: Exception -> L16
    L14:
        r4.startActivity(r0, r2);     // Catch: Exception -> L16
        return;
    L10:
        r7 = null;
    L16:
        e = move-exception;
        com.obric.matrix.r.c.c.g(this.TAG, "login error.", e);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void init() {
        com.obric.matrix.account.o.a.f8592a.a();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void login(Context r2, ActivityOptions r3) {
        kotlin.n0.d.o.f(r2, "context");
        loginWithLarkSSOCallback(r2, r3, null);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void loginFinished() {
        com.obric.matrix.account.d.f8446a.a();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void loginWithLarkSSOCallback(Context r2, ActivityOptions r3, PendingIntent r4) {
        kotlin.n0.d.o.f(r2, "context");
        if (com.obric.matrix.account.a.f8438a.v() == false) goto L6;
        com.obric.matrix.r.c.c.f(this.TAG, "login failed, login already.");
        return;
    L6:
        goToLogin(r2, r3, r4);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void loginWithPassword(String r3, String r4, kotlin.n0.c.a<f0> r5, kotlin.n0.c.p<? super Integer, ? super String, f0> r6) {
        kotlin.n0.d.o.f(r3, "mobile");
        kotlin.n0.d.o.f(r4, "password");
        com.obric.matrix.r.c.c.b(this.TAG, "loginWithPassword");
        getBdAccountImpl().j(r3, r4, "", new d(this, r3, r5, r6));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void logout(kotlin.n0.c.a<f0> r4, kotlin.n0.c.p<? super Integer, ? super String, f0> r5) {
        if (com.obric.matrix.account.a.f8438a.v() == true) goto L9;
        com.obric.matrix.r.c.c.f(this.TAG, "Didn't login.");
        if (r5 == null) goto L16;
        String r3 = d.g.f.a.a.f16974a.d().getString(com.obric.matrix.account.j.o);
        kotlin.n0.d.o.e(r3, "AppGlobals.getApplicatio….account_logout_no_login)");
        r5.invoke(1001, r3);
        return;
    L16:
        return;
    L9:
        if (this.logouting == false) goto L14;
        com.obric.matrix.r.c.c.f(this.TAG, "Logouting.");
        if (r5 == null) goto L17;
        String r6 = d.g.f.a.a.f16974a.d().getString(com.obric.matrix.account.j.n);
        kotlin.n0.d.o.e(r6, "AppGlobals.getApplicatio…tring.account_logout_ing)");
        r5.invoke(1001, r6);
        return;
    L17:
        return;
    L14:
        this.logouting = true;
        getBdAccountImpl().h("user_logout", null, new e(this, r4, r5));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void quickLogin(String r11, String r12, kotlin.n0.c.p<? super Boolean, ? super Boolean, f0> r13, kotlin.n0.c.p<? super Integer, ? super String, f0> r14) {
        kotlin.n0.d.o.f(r11, "mobile");
        kotlin.n0.d.o.f(r12, "code");
        boolean r1 = false;
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L14:
        if (r14 == null) goto L17;
        r14.invoke(-1, "info can not empty.");
        return;
    L17:
        return;
    L8:
        if (r12.length() != 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L14;
        LinkedHashMap r8 = new LinkedHashMap();
        String r2 = ((AppInfoProvider) com.bytedance.news.common.service.manager.d.a(AppInfoProvider.class)).getAppName();
        kotlin.n0.d.o.e(r2, "getService(AppInfoProvider::class.java).appName");
        r8.put(IBdInstall.PARAM_APP_NAME, r2);
        getBdAccountImpl().n(r11, r12, 1, null, r8, new f(r11, this, r13, r14));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void removeAccountStatusListener(com.obric.matrix.account_api.c r1) {
        kotlin.n0.d.o.f(r1, "listener");
        com.obric.matrix.account.p.b.f8600a.r(r1);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void resetPassword(String r9, String r10, String r11, kotlin.n0.c.a<f0> r12, kotlin.n0.c.p<? super Integer, ? super String, f0> r13) {
        kotlin.n0.d.o.f(r9, "mobile");
        kotlin.n0.d.o.f(r10, "smsCode");
        kotlin.n0.d.o.f(r11, "password");
        com.obric.matrix.r.c.c.b(this.TAG, "resetPassword");
        getBdAccountImpl().i(r9, r10, r11, "", new g(this, r12, r13));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void sendCode(String r10, String r11, int r12, kotlin.n0.c.a<f0> r13, kotlin.n0.c.p<? super Integer, ? super String, f0> r14) {
        kotlin.n0.d.o.f(r10, "pkgName");
        kotlin.n0.d.o.f(r11, "account");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("origin_app_name", r10);
        r0.put("is6Digits", LocationInfoConst.ALLOW_USE_LOCATION);
        String r1 = ((AppInfoProvider) com.bytedance.news.common.service.manager.d.a(AppInfoProvider.class)).getAppName();
        kotlin.n0.d.o.e(r1, "getService(AppInfoProvider::class.java).appName");
        r0.put(IBdInstall.PARAM_APP_NAME, r1);
        getBdAccountImpl().e(r11, r12, r0, new h(this, r10, r12, r13, r14));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void setInitPassword(String r3, kotlin.n0.c.a<f0> r4, kotlin.n0.c.p<? super Integer, ? super String, f0> r5) {
        kotlin.n0.d.o.f(r3, "password");
        com.obric.matrix.r.c.c.b(this.TAG, "setInitPassword");
        getBdAccountImpl().g(r3, "", new i(this, r4, r5));
    }

    public final void setLogouting(boolean r1) {
        this.logouting = r1;
    }

    public final void testSessionExipred() {
        if (com.obric.matrix.account.a.f8438a.v() == true) goto L7;
        com.obric.matrix.r.c.c.f(this.TAG, "Didn't login.");
        return;
    L7:
        if (this.logouting == false) goto L10;
        com.obric.matrix.r.c.c.f(this.TAG, "Logouting.");
        return;
    L10:
        this.logouting = true;
        getBdAccountImpl().h("sdk_expired_logout", null, new j(this));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void ticketResetPassword(String r3, String r4, kotlin.n0.c.a<f0> r5, kotlin.n0.c.p<? super Integer, ? super String, f0> r6) {
        kotlin.n0.d.o.f(r3, "ticket");
        kotlin.n0.d.o.f(r4, "password");
        com.obric.matrix.r.c.c.b(this.TAG, "ticketResetPassword");
        getBdAccountImpl().k(r4, r3, new k(this, r5, r6));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void updatePassword(String r3, String r4, kotlin.n0.c.a<f0> r5, kotlin.n0.c.p<? super Integer, ? super String, f0> r6) {
        kotlin.n0.d.o.f(r3, "oldPassword");
        kotlin.n0.d.o.f(r4, "newPassword");
        com.obric.matrix.r.c.c.b(this.TAG, "updatePassword");
        getBdAccountImpl().f(r3, r4, new l(this, r5, r6));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void updateUserInfo(Bundle r5, kotlin.n0.c.a<f0> r6, kotlin.n0.c.p<? super Integer, ? super String, f0> r7) {
        if (r5 != null) goto L6;
        if (r7 == null) goto L27;
        r7.invoke(-1, "info can not empty.");
        return;
    L27:
        return;
    L6:
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        kotlin.n0.d.o.e(r2, "key");
        r0.put(r2, r5.getString(r2));
        goto L8
    L10:
        com.obric.matrix.r.c.c.j(this.TAG, "updateUserInfo:" + r0);
        if (r0.keySet().size() == 1) goto L13;
    L24:
        d.b.s.a.x.b r8 = d.b.s.a.x.a.c();
        kotlin.n0.d.o.e(r8, "instance()");
        r8.b(r0, null, new m(this, r6, r7));
        return;
    L13:
        if (r0.get("name") == null) goto L24;
        com.obric.matrix.account_api.a r3 = getAccountInfo();
        if (r3 == null) goto L17;
        String r4 = r3.p();
    L19:
        if (kotlin.n0.d.o.a(r4, r0.get("name")) == false) goto L24;
        com.obric.matrix.r.c.c.j(this.TAG, "name same,return success.");
        if (r6 == null) goto L28;
        r6.invoke();
        return;
    L28:
        return;
    L17:
        r4 = null;
        goto L19
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void uploadAvatar(String r4, kotlin.n0.c.l<? super String, f0> r5, kotlin.n0.c.p<? super Integer, ? super String, f0> r6) {
        kotlin.n0.d.o.f(r4, "path");
        com.obric.matrix.r.c.c.j(this.TAG, "uploadAvatar path:" + r4);
        d.b.s.a.x.b r0 = d.b.s.a.x.a.c();
        kotlin.n0.d.o.e(r0, "instance()");
        r0.a(r4, new n(this, r5, r6));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void verifyPassword(String r3, String r4, kotlin.n0.c.l<? super String, f0> r5, kotlin.n0.c.p<? super Integer, ? super String, f0> r6) {
        kotlin.n0.d.o.f(r3, "mobile");
        kotlin.n0.d.o.f(r4, "password");
        com.obric.matrix.r.c.c.b(this.TAG, "verifyPassword");
        getBdAccountImpl().l(r3, r4, "", new o(this, r5, r6));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void verifyPasswordWithoutLogin(String r6, String r7, kotlin.n0.c.l<? super String, f0> r8, kotlin.n0.c.p<? super Integer, ? super String, f0> r9) {
        kotlin.n0.d.o.f(r6, "mobile");
        kotlin.n0.d.o.f(r7, "password");
        com.obric.matrix.r.c.c.b(this.TAG, "verifyPasswordWithoutLogin in OAccountImpl");
        d.b.s.a.q.i r2 = com.bytedance.sdk.account.impl.f.a();
        HashMap r3 = new HashMap();
        String r10 = com.bytedance.common.utility.k.a(r6);
        kotlin.n0.d.o.e(r10, "encryptWithXor(mobile)");
        r3.put("mobile", r10);
        String r11 = com.bytedance.common.utility.k.a(r7);
        kotlin.n0.d.o.e(r11, "encryptWithXor(password)");
        r3.put("password", r11);
        r3.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        r2.a("/passport/account/verify_pwd_without_login/", r3, new p(this, r8, r9));
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void verifySmsCode(String r3, String r4, int r5, kotlin.n0.c.l<? super String, f0> r6, kotlin.n0.c.p<? super Integer, ? super String, f0> r7) {
        kotlin.n0.d.o.f(r3, "mobile");
        kotlin.n0.d.o.f(r4, "code");
        com.obric.matrix.r.c.c.b(this.TAG, "verifySmsCode");
        getBdAccountImpl().a(r3, r4, r5, new q(this, r6, r7));
    }
}
