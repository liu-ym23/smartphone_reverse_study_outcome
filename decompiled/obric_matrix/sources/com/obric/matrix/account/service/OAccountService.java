package com.obric.matrix.account.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.account_api.OAccount;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\n\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J&\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0 J-\u0010!\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010&J\u001b\u0010'\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006*"}, d2 = {"Lcom/obric/matrix/account/service/OAccountService;", "Landroid/app/Service;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mBinder", "com/obric/matrix/account/service/OAccountService$mBinder$1", "Lcom/obric/matrix/account/service/OAccountService$mBinder$1;", "ensurePermission", "", "callingUid", "", "callingPid", "isValidDid", "", "did", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "tryRun", "methodName", "callback", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback;", "block", "Lkotlin/Function0;", "onResultError", WsConstants.KEY_EXTRA, "Landroid/os/Bundle;", "errorCode", "errorMsg", "(Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback;Landroid/os/Bundle;ILjava/lang/String;)Lkotlin/Unit;", "onResultOk", "(Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback;Landroid/os/Bundle;)Lkotlin/Unit;", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccountService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f8626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f8627g;

    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u0016\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010(\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010)\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J.\u0010*\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"com/obric/matrix/account/service/OAccountService$mBinder$1", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService$Stub;", "mDidRunnable", "Ljava/lang/Runnable;", "authFailed", "", "pkgName", "", "action", "callback", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback;", "checkPassword", "password", "forceUpdateAccount", "login", "Landroid/app/PendingIntent;", "loginWithPassword", "mobile", "logout", "quickLogin", "account", "code", "resetPassword", "smsCode", "sendCode", "scene", "", "sendInternal", "setInitPassword", "ticketResetPassword", "ticket", "updatePassword", "oldPassword", "newPassword", "updateUserInfo", "updateInfo", "Landroid/os/Bundle;", "customizedParams", "uploadAvatar", "path", "verifyPassword", "verifyPasswordWithoutLogin", "verifySmsCode", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends com.obric.matrix.platform.d.a.a.b.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Runnable f8628f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OAccountService f8629g;

        /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0227a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8630f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ OAccountService f8631g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8632h;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0228a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8633f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8634g;

                C0228a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8633f = r1;
                    this.f8634g = r2;
                    super(0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ f0 invoke() {
                    invoke2();
                    return f0.f18324a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f8633f.f(this.f8634g, new Bundle());
                }
            }

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$a$b */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8635f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8636g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8635f = r1;
                    this.f8636g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    this.f8635f.e(this.f8636g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            C0227a(String r1, OAccountService r2, com.obric.matrix.platform.d.a.a.a r3) {
                this.f8630f = r1;
                this.f8631g = r2;
                this.f8632h = r3;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8630f;
                if (r0 != null) goto L5;
            L8:
                boolean r1 = true;
            L10:
                if ((!r1) == false) goto L14;
                OAccountService r2 = this.f8631g;
                r2.b(r2.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount.INSTANCE.checkPassword(this.f8630f, new C0228a(this.f8631g, this.f8632h), new b(this.f8631g, this.f8632h));
                return;
            L14:
                throw new IllegalArgumentException("password can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r1 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8637f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8638g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ OAccountService f8639h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8640i;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$b$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0229a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8641f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8642g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f8643h;

                C0229a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2, String r3) {
                    this.f8641f = r1;
                    this.f8642g = r2;
                    this.f8643h = r3;
                    super(0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ f0 invoke() {
                    invoke2();
                    return f0.f18324a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f8641f.f(this.f8642g, new Bundle());
                    d.b.s.a.j0.a.c(this.f8643h);
                }
            }

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$b$b, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0230b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8644f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8645g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f8646h;

                C0230b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2, String r3) {
                    this.f8644f = r1;
                    this.f8645g = r2;
                    this.f8646h = r3;
                    super(2);
                }

                public final void a(int r4, String r5) {
                    this.f8644f.e(this.f8645g, new Bundle(), r4, r5);
                    d.b.s.a.j0.a.c(this.f8646h);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            b(String r1, String r2, OAccountService r3, com.obric.matrix.platform.d.a.a.a r4) {
                this.f8637f = r1;
                this.f8638g = r2;
                this.f8639h = r3;
                this.f8640i = r4;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8637f;
                boolean r1 = false;
                if (r0 != null) goto L5;
            L8:
                boolean r2 = true;
            L10:
                if ((!r2) == false) goto L27;
                String r3 = this.f8638g;
                if (r3 != null) goto L14;
            L15:
                r1 = true;
            L17:
                if ((!r1) == false) goto L25;
                OAccountService r4 = this.f8639h;
                r4.b(r4.c(), Binder.getCallingUid(), Binder.getCallingPid());
                boolean r5 = com.bytedance.sdk.account.ticketguard.f.s();
                com.obric.matrix.r.c.c.f("OAccountService", "loginWithPassword isEnableTokenGuard=" + r5);
                if (r5 == false) goto L22;
                d.b.s.a.j0.a.b("login");
                OAccount.INSTANCE.loginWithPassword(this.f8637f, this.f8638g, new C0229a(this.f8639h, this.f8640i, "login"), new C0230b(this.f8639h, this.f8640i, "login"));
                return;
            L22:
                com.obric.matrix.r.c.c.f("OAccountService", "loginWithPassword token guard error.");
                com.bytedance.news.common.settings.e.g(true);
                throw new Exception("token guard error");
            L25:
                throw new IllegalArgumentException("password can't be empty".toString());
            L14:
                if (r3.length() != 0) goto L17;
            L27:
                throw new IllegalArgumentException("mobile can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r2 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8647f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8648g;

            c(String r1, com.obric.matrix.platform.d.a.a.a r2) {
                this.f8647f = r1;
                this.f8648g = r2;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.obric.matrix.r.c.c.b("OAccountService", this.f8647f + " Try logout success.");
                com.obric.matrix.account.q.b r0 = com.obric.matrix.account.q.b.a();
                if (r0 == null) goto L12;
                r0.f(this.f8647f, true, 0, null);
            L12:
                com.obric.matrix.platform.d.a.a.a r1 = this.f8648g;     // Catch: Exception -> L9
                if (r1 == null) goto L14;
                r1.B(true, new Bundle());     // Catch: Exception -> L9
                return;
            L14:
                return;
            L9:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "callback " + this.f8647f + " failed: ", e);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class d extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8649f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8650g;

            d(String r1, com.obric.matrix.platform.d.a.a.a r2) {
                this.f8649f = r1;
                this.f8650g = r2;
                super(2);
            }

            public final void a(int r7, String r8) {
                kotlin.n0.d.o.f(r8, "errorMsg");
                com.obric.matrix.r.c.c.b("OAccountService", this.f8649f + " Try logout failed.");
                com.obric.matrix.account.q.b r1 = com.obric.matrix.account.q.b.a();
                if (r1 == null) goto L12;
                r1.f(this.f8649f, false, r7, r8);
            L12:
                com.obric.matrix.platform.d.a.a.a r2 = this.f8650g;     // Catch: Exception -> L9
                if (r2 == null) goto L14;
                Bundle r4 = new Bundle();     // Catch: Exception -> L9
                r4.putInt("errorCode", r7);     // Catch: Exception -> L9
                r4.putString("errorMsg", r8);     // Catch: Exception -> L9
                f0 r9 = f0.f18324a;     // Catch: Exception -> L9
                r2.B(false, r4);     // Catch: Exception -> L9
                return;
            L14:
                return;
            L9:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "callback " + this.f8649f + " failed: ", e);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                a(r1.intValue(), r2);
                return f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "isNewUser", "", "hasPassword", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class e extends kotlin.n0.d.q implements kotlin.n0.c.p<Boolean, Boolean, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8651f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8652g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f8653h;

            e(com.obric.matrix.platform.d.a.a.a r1, String r2, String r3) {
                this.f8651f = r1;
                this.f8652g = r2;
                this.f8653h = r3;
                super(2);
            }

            public final void a(boolean r5, boolean r6) {
                com.obric.matrix.platform.d.a.a.a r0 = this.f8651f;     // Catch: Throwable -> L6 Exception -> L8
                if (r0 == null) goto L5;
                Bundle r2 = new Bundle();     // Catch: Throwable -> L6 Exception -> L8
                r2.putBoolean("is_new_user", r5);     // Catch: Throwable -> L6 Exception -> L8
                r2.putBoolean("has_password", r6);     // Catch: Throwable -> L6 Exception -> L8
                f0 r7 = f0.f18324a;     // Catch: Throwable -> L6 Exception -> L8
                r0.B(true, r2);     // Catch: Throwable -> L6 Exception -> L8
            L5:
                d.b.s.a.j0.a.c(this.f8653h);
                return;
            L8:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "sendCode callback " + this.f8652g + " failed: ", e);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                d.b.s.a.j0.a.c(this.f8653h);
                throw th;
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(Boolean r1, Boolean r2) {
                a(r1.booleanValue(), r2.booleanValue());
                return f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class f extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8654f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8655g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f8656h;

            f(com.obric.matrix.platform.d.a.a.a r1, String r2, String r3) {
                this.f8654f = r1;
                this.f8655g = r2;
                this.f8656h = r3;
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
            public final void a(int r6, String r7) {
                kotlin.n0.d.o.f(r7, "errorMsg");
                com.obric.matrix.platform.d.a.a.a r1 = this.f8654f;     // Catch: Throwable -> L7 Exception -> L9
                if (r1 == null) goto L6;
                Bundle r3 = new Bundle();     // Catch: Throwable -> L7 Exception -> L9
                r3.putInt("errorCode", r6);     // Catch: Throwable -> L7 Exception -> L9
                r3.putString("errorMsg", r7);     // Catch: Throwable -> L7 Exception -> L9
                f0 r8 = f0.f18324a;     // Catch: Throwable -> L7 Exception -> L9
                r1.B(false, r3);     // Catch: Throwable -> L7 Exception -> L9
            L6:
                f this = this.f8656h;
                d.b.s.a.j0.a.c(this);
                return;
            L7:
                th = move-exception;
                d.b.s.a.j0.a.c(this.f8656h);
                throw th;
            L9:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "sendCode callback " + this.f8655g + " failed: ", e);     // Catch: Throwable -> L7
                goto L6
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                a(r1.intValue(), r2);
                return f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8657f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8658g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f8659h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ OAccountService f8660i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8661j;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$g$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0231a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8662f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8663g;

                C0231a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8662f = r1;
                    this.f8663g = r2;
                    super(0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ f0 invoke() {
                    invoke2();
                    return f0.f18324a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f8662f.f(this.f8663g, new Bundle());
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8664f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8665g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8664f = r1;
                    this.f8665g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    this.f8664f.e(this.f8665g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            g(String r1, String r2, String r3, OAccountService r4, com.obric.matrix.platform.d.a.a.a r5) {
                this.f8657f = r1;
                this.f8658g = r2;
                this.f8659h = r3;
                this.f8660i = r4;
                this.f8661j = r5;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8657f;
                boolean r1 = false;
                if (r0 != null) goto L5;
            L8:
                boolean r2 = true;
            L10:
                if ((!r2) == false) goto L34;
                String r3 = this.f8658g;
                if (r3 != null) goto L14;
            L17:
                boolean r4 = true;
            L19:
                if ((!r4) == false) goto L32;
                String r5 = this.f8659h;
                if (r5 != null) goto L23;
            L24:
                r1 = true;
            L26:
                if ((!r1) == false) goto L30;
                OAccountService r6 = this.f8660i;
                r6.b(r6.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount.INSTANCE.resetPassword(this.f8657f, this.f8658g, this.f8659h, new C0231a(this.f8660i, this.f8661j), new b(this.f8660i, this.f8661j));
                return;
            L30:
                throw new IllegalArgumentException("password can't be empty".toString());
            L23:
                if (r5.length() != 0) goto L26;
            L32:
                throw new IllegalArgumentException("smsCode can't be empty".toString());
            L14:
                if (r3.length() == 0) goto L17;
                r4 = false;
                goto L19
            L34:
                throw new IllegalArgumentException("mobile can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r2 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/account/service/OAccountService$mBinder$1$sendCode$listener$1", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class h implements com.obric.matrix.ostracker_api.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f8666a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8667b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f8668c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f8669d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8670e;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$h$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0232a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ a f8671f;

                C0232a(a r1) {
                    this.f8671f = r1;
                    super(0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ f0 invoke() {
                    invoke2();
                    return f0.f18324a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Runnable r0 = a.a(this.f8671f);
                    if (r0 == null) goto L6;
                    com.obric.matrix.r.e.o.f(r0);
                    return;
                }
            }

            h(a r1, String r2, String r3, int r4, com.obric.matrix.platform.d.a.a.a r5) {
                this.f8666a = r1;
                this.f8667b = r2;
                this.f8668c = r3;
                this.f8669d = r4;
                this.f8670e = r5;
            }

            @Override // com.obric.matrix.ostracker_api.a
            public void a(String r5) {
                com.obric.matrix.r.c.c.b("OAccountService", "onDeviceIdLoaded called with: did = " + r5);
                com.obric.matrix.r.e.o.c(new C0232a(this.f8666a));
                a.c(this.f8666a, this.f8667b, this.f8668c, this.f8669d, this.f8670e);
                com.obric.matrix.ostracker_api.b.h(this);
            }

            @Override // com.obric.matrix.ostracker_api.a
            public void b(String r4) {
                a.c(this.f8666a, this.f8667b, this.f8668c, this.f8669d, this.f8670e);
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class i extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8672f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8673g;

            i(com.obric.matrix.platform.d.a.a.a r1, String r2) {
                this.f8672f = r1;
                this.f8673g = r2;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.obric.matrix.platform.d.a.a.a r1 = this.f8672f;     // Catch: Exception -> L8
                if (r1 == null) goto L6;
                r1.B(true, new Bundle());     // Catch: Exception -> L8
            L6:
                com.obric.matrix.r.c.c.j("OAccountService", "sendCode success " + this.f8673g);     // Catch: Exception -> L8
                return;
            L8:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "sendCode callback " + this.f8673g + " failed: ", e);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class j extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8674f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8675g;

            j(com.obric.matrix.platform.d.a.a.a r1, String r2) {
                this.f8674f = r1;
                this.f8675g = r2;
                super(2);
            }

            public final void a(int r7, String r8) {
                kotlin.n0.d.o.f(r8, "errorMsg");
                com.obric.matrix.platform.d.a.a.a r2 = this.f8674f;     // Catch: Exception -> L8
                if (r2 == null) goto L6;
                Bundle r4 = new Bundle();     // Catch: Exception -> L8
                r4.putInt("errorCode", r7);     // Catch: Exception -> L8
                r4.putString("errorMsg", r8);     // Catch: Exception -> L8
                f0 r9 = f0.f18324a;     // Catch: Exception -> L8
                r2.B(false, r4);     // Catch: Exception -> L8
            L6:
                com.obric.matrix.r.c.c.s("OAccountService", "sendCode failed " + this.f8675g + " failed.");     // Catch: Exception -> L8
                return;
            L8:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "sendCode callback " + this.f8675g + " failed: ", e);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                a(r1.intValue(), r2);
                return f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class k extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8676f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ OAccountService f8677g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8678h;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$k$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0233a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8679f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8680g;

                C0233a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8679f = r1;
                    this.f8680g = r2;
                    super(0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ f0 invoke() {
                    invoke2();
                    return f0.f18324a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f8679f.f(this.f8680g, new Bundle());
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8681f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8682g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8681f = r1;
                    this.f8682g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    this.f8681f.e(this.f8682g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            k(String r1, OAccountService r2, com.obric.matrix.platform.d.a.a.a r3) {
                this.f8676f = r1;
                this.f8677g = r2;
                this.f8678h = r3;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8676f;
                if (r0 != null) goto L5;
            L8:
                boolean r1 = true;
            L10:
                if ((!r1) == false) goto L14;
                OAccountService r2 = this.f8677g;
                r2.b(r2.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount.INSTANCE.setInitPassword(this.f8676f, new C0233a(this.f8677g, this.f8678h), new b(this.f8677g, this.f8678h));
                return;
            L14:
                throw new IllegalArgumentException("password can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r1 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class l extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8683f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8684g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ OAccountService f8685h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8686i;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$l$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0234a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8687f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8688g;

                C0234a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8687f = r1;
                    this.f8688g = r2;
                    super(0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ f0 invoke() {
                    invoke2();
                    return f0.f18324a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f8687f.f(this.f8688g, new Bundle());
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8689f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8690g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8689f = r1;
                    this.f8690g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    this.f8689f.e(this.f8690g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            l(String r1, String r2, OAccountService r3, com.obric.matrix.platform.d.a.a.a r4) {
                this.f8683f = r1;
                this.f8684g = r2;
                this.f8685h = r3;
                this.f8686i = r4;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8683f;
                boolean r1 = false;
                if (r0 != null) goto L5;
            L8:
                boolean r2 = true;
            L10:
                if ((!r2) == false) goto L23;
                String r3 = this.f8684g;
                if (r3 != null) goto L14;
            L15:
                r1 = true;
            L17:
                if ((!r1) == false) goto L21;
                OAccountService r4 = this.f8685h;
                r4.b(r4.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount.INSTANCE.ticketResetPassword(this.f8683f, this.f8684g, new C0234a(this.f8685h, this.f8686i), new b(this.f8685h, this.f8686i));
                return;
            L21:
                throw new IllegalArgumentException("password can't be empty".toString());
            L14:
                if (r3.length() != 0) goto L17;
            L23:
                throw new IllegalArgumentException("ticket can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r2 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class m extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8691f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ OAccountService f8692g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f8693h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8694i;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$m$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0235a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8695f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8696g;

                C0235a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8695f = r1;
                    this.f8696g = r2;
                    super(0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ f0 invoke() {
                    invoke2();
                    return f0.f18324a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f8695f.f(this.f8696g, new Bundle());
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8697f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8698g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8697f = r1;
                    this.f8698g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    this.f8697f.e(this.f8698g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            m(String r1, OAccountService r2, String r3, com.obric.matrix.platform.d.a.a.a r4) {
                this.f8691f = r1;
                this.f8692g = r2;
                this.f8693h = r3;
                this.f8694i = r4;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8691f;
                if (r0 != null) goto L5;
            L8:
                boolean r1 = true;
            L10:
                if ((!r1) == false) goto L17;
                OAccountService r2 = this.f8692g;
                r2.b(r2.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount r3 = OAccount.INSTANCE;
                String r4 = this.f8693h;
                if (r4 != null) goto L14;
                r4 = "";
            L14:
                r3.updatePassword(r4, this.f8691f, new C0235a(this.f8692g, this.f8694i), new b(this.f8692g, this.f8694i));
                return;
            L17:
                throw new IllegalArgumentException("newPassword can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r1 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class n extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8699f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8700g;

            n(com.obric.matrix.platform.d.a.a.a r1, String r2) {
                this.f8699f = r1;
                this.f8700g = r2;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.obric.matrix.platform.d.a.a.a r0 = this.f8699f;     // Catch: Exception -> L6
                if (r0 == null) goto L11;
                r0.B(true, new Bundle());     // Catch: Exception -> L6
                return;
            L11:
                return;
            L6:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "updateUserInfo callback " + this.f8700g + " failed: ", e);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class o extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8701f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8702g;

            o(com.obric.matrix.platform.d.a.a.a r1, String r2) {
                this.f8701f = r1;
                this.f8702g = r2;
                super(2);
            }

            public final void a(int r6, String r7) {
                kotlin.n0.d.o.f(r7, "errorMsg");
                com.obric.matrix.platform.d.a.a.a r1 = this.f8701f;     // Catch: Exception -> L7
                if (r1 == null) goto L12;
                Bundle r3 = new Bundle();     // Catch: Exception -> L7
                r3.putInt("errorCode", r6);     // Catch: Exception -> L7
                r3.putString("errorMsg", r7);     // Catch: Exception -> L7
                f0 r8 = f0.f18324a;     // Catch: Exception -> L7
                r1.B(false, r3);     // Catch: Exception -> L7
                return;
            L12:
                return;
            L7:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "updateUserInfo callback " + this.f8702g + " failed: ", e);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                a(r1.intValue(), r2);
                return f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", WsConstants.KEY_CONNECTION_URL, "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class p extends kotlin.n0.d.q implements kotlin.n0.c.l<String, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8703f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8704g;

            p(com.obric.matrix.platform.d.a.a.a r1, String r2) {
                this.f8703f = r1;
                this.f8704g = r2;
                super(1);
            }

            public final void a(String r5) {
                com.obric.matrix.platform.d.a.a.a r0 = this.f8703f;     // Catch: Exception -> L6
                if (r0 == null) goto L11;
                Bundle r2 = new Bundle();     // Catch: Exception -> L6
                r2.putString("avatar_url", r5);     // Catch: Exception -> L6
                f0 r6 = f0.f18324a;     // Catch: Exception -> L6
                r0.B(true, r2);     // Catch: Exception -> L6
                return;
            L11:
                return;
            L6:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "uploadAvatar callback " + this.f8704g + " failed: ", e);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(String r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class q extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8705f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8706g;

            q(com.obric.matrix.platform.d.a.a.a r1, String r2) {
                this.f8705f = r1;
                this.f8706g = r2;
                super(2);
            }

            public final void a(int r6, String r7) {
                kotlin.n0.d.o.f(r7, "errorMsg");
                com.obric.matrix.platform.d.a.a.a r1 = this.f8705f;     // Catch: Exception -> L7
                if (r1 == null) goto L12;
                Bundle r3 = new Bundle();     // Catch: Exception -> L7
                r3.putInt("errorCode", r6);     // Catch: Exception -> L7
                r3.putString("errorMsg", r7);     // Catch: Exception -> L7
                f0 r8 = f0.f18324a;     // Catch: Exception -> L7
                r1.B(false, r3);     // Catch: Exception -> L7
                return;
            L12:
                return;
            L7:
                e = move-exception;
                com.obric.matrix.r.c.c.t("OAccountService", "sendCode callback " + this.f8706g + " failed: ", e);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                a(r1.intValue(), r2);
                return f0.f18324a;
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class r extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8707f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8708g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ OAccountService f8709h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8710i;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$r$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "ticket", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0236a extends kotlin.n0.d.q implements kotlin.n0.c.l<String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8711f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8712g;

                C0236a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8711f = r1;
                    this.f8712g = r2;
                    super(1);
                }

                public final void a(String r4) {
                    kotlin.n0.d.o.f(r4, "ticket");
                    OAccountService r1 = this.f8711f;
                    com.obric.matrix.platform.d.a.a.a r3 = this.f8712g;
                    Bundle r2 = new Bundle();
                    r2.putString("ticket", r4);
                    f0 r5 = f0.f18324a;
                    r1.f(r3, r2);
                }

                @Override // kotlin.n0.c.l
                public /* bridge */ /* synthetic */ f0 invoke(String r1) {
                    a(r1);
                    return f0.f18324a;
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8713f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8714g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8713f = r1;
                    this.f8714g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    this.f8713f.e(this.f8714g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            r(String r1, String r2, OAccountService r3, com.obric.matrix.platform.d.a.a.a r4) {
                this.f8707f = r1;
                this.f8708g = r2;
                this.f8709h = r3;
                this.f8710i = r4;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8707f;
                boolean r1 = false;
                if (r0 != null) goto L5;
            L8:
                boolean r2 = true;
            L10:
                if ((!r2) == false) goto L23;
                String r3 = this.f8708g;
                if (r3 != null) goto L14;
            L15:
                r1 = true;
            L17:
                if ((!r1) == false) goto L21;
                OAccountService r4 = this.f8709h;
                r4.b(r4.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount.INSTANCE.verifyPassword(this.f8707f, this.f8708g, new C0236a(this.f8709h, this.f8710i), new b(this.f8709h, this.f8710i));
                return;
            L21:
                throw new IllegalArgumentException("password can't be empty".toString());
            L14:
                if (r3.length() != 0) goto L17;
            L23:
                throw new IllegalArgumentException("mobile can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r2 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class s extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8715f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8716g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ OAccountService f8717h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8718i;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$s$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "ticket", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0237a extends kotlin.n0.d.q implements kotlin.n0.c.l<String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8719f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8720g;

                C0237a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8719f = r1;
                    this.f8720g = r2;
                    super(1);
                }

                public final void a(String r4) {
                    kotlin.n0.d.o.f(r4, "ticket");
                    com.obric.matrix.r.c.c.b("OAccountService", "verifyPasswordWithoutLogin success in OAccountService, ticket: " + r4);
                    OAccountService r1 = this.f8719f;
                    com.obric.matrix.platform.d.a.a.a r3 = this.f8720g;
                    Bundle r2 = new Bundle();
                    r2.putString("ticket", r4);
                    f0 r5 = f0.f18324a;
                    r1.f(r3, r2);
                }

                @Override // kotlin.n0.c.l
                public /* bridge */ /* synthetic */ f0 invoke(String r1) {
                    a(r1);
                    return f0.f18324a;
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8721f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8722g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8721f = r1;
                    this.f8722g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    com.obric.matrix.r.c.c.b("OAccountService", "verifyPasswordWithoutLogin failed in OAccountService");
                    this.f8721f.e(this.f8722g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            s(String r1, String r2, OAccountService r3, com.obric.matrix.platform.d.a.a.a r4) {
                this.f8715f = r1;
                this.f8716g = r2;
                this.f8717h = r3;
                this.f8718i = r4;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8715f;
                boolean r1 = false;
                if (r0 != null) goto L5;
            L8:
                boolean r2 = true;
            L10:
                if ((!r2) == false) goto L23;
                String r3 = this.f8716g;
                if (r3 != null) goto L14;
            L15:
                r1 = true;
            L17:
                if ((!r1) == false) goto L21;
                OAccountService r4 = this.f8717h;
                r4.b(r4.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount.INSTANCE.verifyPasswordWithoutLogin(this.f8715f, this.f8716g, new C0237a(this.f8717h, this.f8718i), new b(this.f8717h, this.f8718i));
                return;
            L21:
                throw new IllegalArgumentException("password can't be empty".toString());
            L14:
                if (r3.length() != 0) goto L17;
            L23:
                throw new IllegalArgumentException("mobile can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r2 = false;
                goto L10
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class t extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8723f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f8724g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ OAccountService f8725h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f8726i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8727j;

            /* JADX INFO: renamed from: com.obric.matrix.account.service.OAccountService$a$t$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "ticket", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C0238a extends kotlin.n0.d.q implements kotlin.n0.c.l<String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8728f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8729g;

                C0238a(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8728f = r1;
                    this.f8729g = r2;
                    super(1);
                }

                public final void a(String r4) {
                    kotlin.n0.d.o.f(r4, "ticket");
                    OAccountService r1 = this.f8728f;
                    com.obric.matrix.platform.d.a.a.a r3 = this.f8729g;
                    Bundle r2 = new Bundle();
                    r2.putString("ticket", r4);
                    f0 r5 = f0.f18324a;
                    r1.f(r3, r2);
                }

                @Override // kotlin.n0.c.l
                public /* bridge */ /* synthetic */ f0 invoke(String r1) {
                    a(r1);
                    return f0.f18324a;
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<Integer, String, f0> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ OAccountService f8730f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ com.obric.matrix.platform.d.a.a.a f8731g;

                b(OAccountService r1, com.obric.matrix.platform.d.a.a.a r2) {
                    this.f8730f = r1;
                    this.f8731g = r2;
                    super(2);
                }

                public final void a(int r3, String r4) {
                    this.f8730f.e(this.f8731g, new Bundle(), r3, r4);
                }

                @Override // kotlin.n0.c.p
                public /* bridge */ /* synthetic */ f0 invoke(Integer r1, String r2) {
                    a(r1.intValue(), r2);
                    return f0.f18324a;
                }
            }

            t(String r1, String r2, OAccountService r3, int r4, com.obric.matrix.platform.d.a.a.a r5) {
                this.f8723f = r1;
                this.f8724g = r2;
                this.f8725h = r3;
                this.f8726i = r4;
                this.f8727j = r5;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String r0 = this.f8723f;
                boolean r1 = false;
                if (r0 != null) goto L5;
            L8:
                boolean r2 = true;
            L10:
                if ((!r2) == false) goto L23;
                String r3 = this.f8724g;
                if (r3 != null) goto L14;
            L15:
                r1 = true;
            L17:
                if ((!r1) == false) goto L21;
                OAccountService r4 = this.f8725h;
                r4.b(r4.c(), Binder.getCallingUid(), Binder.getCallingPid());
                OAccount.INSTANCE.verifySmsCode(this.f8723f, this.f8724g, this.f8726i, new C0238a(this.f8725h, this.f8727j), new b(this.f8725h, this.f8727j));
                return;
            L21:
                throw new IllegalArgumentException("smsCode can't be empty".toString());
            L14:
                if (r3.length() != 0) goto L17;
            L23:
                throw new IllegalArgumentException("mobile can't be empty".toString());
            L5:
                if (r0.length() == 0) goto L8;
                r2 = false;
                goto L10
            }
        }

        a(OAccountService r1) {
            this.f8629g = r1;
        }

        public static final /* synthetic */ Runnable a(a r0) {
            return r0.f8628f;
        }

        public static final /* synthetic */ void c(a r0, String r1, String r2, int r3, com.obric.matrix.platform.d.a.a.a r4) {
            r0.o(r1, r2, r3, r4);
        }

        private final void k(String r4, String r5, com.obric.matrix.platform.d.a.a.a r6) {
            com.obric.matrix.r.c.c.b("OAccountService", "try " + r5 + " isAuth failed callPkg = " + r4);
            if (r6 != null) goto L10;
            return;
        L10:
            Bundle r0 = new Bundle();     // Catch: Exception -> L7
            r0.putInt("errorCode", -1000);     // Catch: Exception -> L7
            r0.putString("errorMsg", "Permission denied");     // Catch: Exception -> L7
            f0 r1 = f0.f18324a;     // Catch: Exception -> L7
            r6.B(false, r0);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.obric.matrix.r.c.c.t("OAccountService", "sendCode callback " + r4 + " failed: ", e);
        }

        public static /* synthetic */ void m(h r0, a r1, String r2, String r3, int r4, com.obric.matrix.platform.d.a.a.a r5) {
            n(r0, r1, r2, r3, r4, r5);
        }

        private static final void n(h r2, a r3, String r4, String r5, int r6, com.obric.matrix.platform.d.a.a.a r7) {
            kotlin.n0.d.o.f(r2, "$listener");
            kotlin.n0.d.o.f(r3, "this$0");
            kotlin.n0.d.o.f(r4, "$pkgName");
            kotlin.n0.d.o.f(r5, "$account");
            com.obric.matrix.r.c.c.f("OAccountService", "get did timeout.");     // Catch: Exception -> L5
            com.obric.matrix.ostracker_api.b.h(r2);     // Catch: Exception -> L5
            r3.o(r4, r5, r6, r7);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.obric.matrix.r.c.c.t("OAccountService", "sendCode callback " + r4 + " failed: ", e);
        }

        private final void o(String r7, String r8, int r9, com.obric.matrix.platform.d.a.a.a r10) {
            OAccount.INSTANCE.sendCode(r7, r8, r9, new i(r10, r7), new j(r10, r7));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void M(String r2, com.obric.matrix.platform.d.a.a.a r3) {
            OAccountService r1 = this.f8629g;
            r1.g("checkPassword", r3, new C0227a(r2, r1, r3));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void N(String r8, String r9, int r10, com.obric.matrix.platform.d.a.a.a r11) {
            OAccountService r7 = this.f8629g;
            r7.g("verifySmsCode", r11, new t(r8, r9, r7, r10, r11));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void P(String r2, String r3, com.obric.matrix.platform.d.a.a.a r4) {
            OAccountService r1 = this.f8629g;
            r1.g("ticketResetPassword", r4, new l(r2, r3, r1, r4));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void S(String r6, String r7, com.obric.matrix.platform.d.a.a.a r8) {
            boolean r0 = true;
            if (r6 != null) goto L5;
        L10:
            boolean r2 = false;
        L11:
            if (r2 == true) goto L34;
            if (r7 != null) goto L14;
        L19:
            r0 = false;
        L20:
            if (r0 == true) goto L34;
            String r1 = this.f8629g.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (r1 != null) goto L26;
            r1 = "";
        L26:
            if (com.obric.matrix.q.a.a.f9829a.f(this.f8629g.c(), Binder.getCallingUid(), r1) == true) goto L29;
            com.obric.matrix.r.c.c.b("OAccountService", "quickLogin isAuth failed callPkg = " + r1);
            k(r1, "quickLogin", r8);
            return;
        L29:
            d.b.s.a.j0.a.b("login");
            com.obric.matrix.r.c.c.b("OAccountService", r1 + " Try quickLogin.");
            com.obric.matrix.account.q.b r3 = com.obric.matrix.account.q.b.a();
            if (r3 == null) goto L32;
            r3.i("quickLogin", r1);
        L32:
            OAccount r4 = OAccount.INSTANCE;
            kotlin.n0.d.o.c(r6);
            kotlin.n0.d.o.c(r7);
            r4.quickLogin(r6, r7, new e(r8, r1, "login"), new f(r8, r1, "login"));
            return;
        L14:
            if (r7.length() != 0) goto L16;
            boolean r5 = true;
        L17:
            if (r5 != true) goto L19;
        L16:
            r5 = false;
        L34:
            if (r8 == null) goto L37;
            Bundle r9 = new Bundle();
            r9.putInt("errorCode", -1);
            r9.putString("errorMsg", "info can not empty.");
            f0 r10 = f0.f18324a;
            r8.B(false, r9);
            return;
        L37:
            return;
        L5:
            if (r6.length() != 0) goto L7;
            boolean r11 = true;
        L8:
            if (r11 != true) goto L10;
            r2 = true;
            goto L11
        L7:
            r11 = false;
            goto L8
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void T(String r2, String r3, com.obric.matrix.platform.d.a.a.a r4) {
            OAccountService r1 = this.f8629g;
            r1.g("loginWithPassword", r4, new b(r2, r3, r1, r4));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void V(String r2, String r3, com.obric.matrix.platform.d.a.a.a r4) {
            OAccountService r1 = this.f8629g;
            r1.g("verifyPasswordWithoutLogin in OAccountService", r4, new s(r2, r3, r1, r4));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void X(String r2, String r3, com.obric.matrix.platform.d.a.a.a r4) {
            OAccountService r1 = this.f8629g;
            r1.g("verifyPassword", r4, new r(r2, r3, r1, r4));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void Z(String r8, String r9, String r10, com.obric.matrix.platform.d.a.a.a r11) {
            OAccountService r7 = this.f8629g;
            r7.g("resetPassword", r11, new g(r8, r9, r10, r7, r11));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void c0(com.obric.matrix.platform.d.a.a.a r6) {
            String r0 = this.f8629g.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            com.obric.matrix.r.c.c.b("OAccountService", r0 + " Try logout.");
            if (com.obric.matrix.q.a.a.f9829a.f(this.f8629g.c(), Binder.getCallingUid(), r0) == true) goto L9;
            com.obric.matrix.r.c.c.b("OAccountService", "logout isAuth failed callPkg = " + r0);
            k(r0, "logout", r6);
            return;
        L9:
            com.obric.matrix.account.q.b r5 = com.obric.matrix.account.q.b.a();
            if (r5 == null) goto L12;
            r5.i("logout", r0);
        L12:
            OAccount.INSTANCE.logout(new c(r0, r6), new d(r0, r6));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void forceUpdateAccount() {
            String r0 = this.f8629g.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (com.obric.matrix.q.a.a.f9829a.f(this.f8629g.c(), Binder.getCallingUid(), r0) == true) goto L6;
            com.obric.matrix.r.c.c.b("OAccountService", "query isAuth failed callPkg = " + r0);
            return;
        L6:
            com.obric.matrix.r.c.c.b("OAccountService", r0 + " Try forceUpdateAccount.");
            com.obric.matrix.account.q.b r3 = com.obric.matrix.account.q.b.a();
            if (r3 == null) goto L9;
            r3.i("forceUpdateAccount", r0);
        L9:
            com.obric.matrix.account.q.b r4 = com.obric.matrix.account.q.b.a();
            if (r4 == null) goto L12;
            r4.d(r0);
        L12:
            OAccount.INSTANCE.forceUpdateAccount();
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void j(String r2, String r3, com.obric.matrix.platform.d.a.a.a r4) {
            OAccountService r1 = this.f8629g;
            r1.g("updatePassword", r4, new m(r3, r1, r2, r4));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void q(String r5, com.obric.matrix.platform.d.a.a.a r6) {
            boolean r0 = true;
            if (r5 != null) goto L5;
        L10:
            r0 = false;
        L11:
            if (r0 == false) goto L15;
            if (r6 == null) goto L27;
            Bundle r4 = new Bundle();
            r4.putInt("errorCode", -1);
            r4.putString("errorMsg", "info can not empty.");
            f0 r7 = f0.f18324a;
            r6.B(false, r4);
            return;
        L27:
            return;
        L15:
            String r1 = this.f8629g.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (r1 != null) goto L19;
            r1 = "";
        L19:
            if (com.obric.matrix.q.a.a.f9829a.f(this.f8629g.c(), Binder.getCallingUid(), r1) == true) goto L22;
            com.obric.matrix.r.c.c.b("OAccountService", "uploadAvatar isAuth failed callPkg = " + r1);
            k(r1, "uploadAvatar", r6);
            return;
        L22:
            com.obric.matrix.r.c.c.b("OAccountService", r1 + " Try uploadAvatar.");
            com.obric.matrix.account.q.b r8 = com.obric.matrix.account.q.b.a();
            if (r8 == null) goto L25;
            r8.i("uploadAvatar", r1);
        L25:
            OAccount r9 = OAccount.INSTANCE;
            kotlin.n0.d.o.c(r5);
            r9.uploadAvatar(r5, new p(r6, r1), new q(r6, r1));
            return;
        L5:
            if (r5.length() != 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 != true) goto L10;
        L7:
            r2 = false;
            goto L8
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void v(PendingIntent r6) {
            String r0 = this.f8629g.getPackageManager().getNameForUid(Binder.getCallingUid());
            com.obric.matrix.r.c.c.b("OAccountService", r0 + " Try login. callback = " + r6);
            if (com.obric.matrix.q.a.a.f9829a.f(this.f8629g.c(), Binder.getCallingUid(), r0) == true) goto L6;
            com.obric.matrix.r.c.c.b("OAccountService", "query isAuth failed callPkg = " + r0);
            return;
        L6:
            com.obric.matrix.account.q.b r1 = com.obric.matrix.account.q.b.a();
            if (r1 == null) goto L9;
            r1.i("login", r0);
        L9:
            OAccount.INSTANCE.loginWithLarkSSOCallback(this.f8629g, null, r6);
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void w(String r2, com.obric.matrix.platform.d.a.a.a r3) {
            OAccountService r1 = this.f8629g;
            r1.g("setInitPassword", r3, new k(r2, r1, r3));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void x(Bundle r4, String r5, com.obric.matrix.platform.d.a.a.a r6) {
            if (r4 != null) goto L6;
            if (r6 == null) goto L18;
            Bundle r7 = new Bundle();
            r7.putInt("errorCode", -1);
            r7.putString("errorMsg", "info can not empty.");
            f0 r8 = f0.f18324a;
            r6.B(false, r7);
            return;
        L18:
            return;
        L6:
            String r9 = this.f8629g.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (r9 != null) goto L10;
            r9 = "";
        L10:
            if (com.obric.matrix.q.a.a.f9829a.f(this.f8629g.c(), Binder.getCallingUid(), r9) == true) goto L13;
            com.obric.matrix.r.c.c.b("OAccountService", "updateUserInfo isAuth failed callPkg = " + r9);
            k(r9, "updateUserInfo", r6);
            return;
        L13:
            com.obric.matrix.r.c.c.b("OAccountService", r9 + " Try updateUserInfo.");
            com.obric.matrix.account.q.b r3 = com.obric.matrix.account.q.b.a();
            if (r3 == null) goto L16;
            r3.i("quickLogin", r9);
        L16:
            OAccount.INSTANCE.updateUserInfo(r4, new n(r6, r9), new o(r6, r9));
        }

        @Override // com.obric.matrix.platform.d.a.a.b
        public void y(final String r11, final int r12, final com.obric.matrix.platform.d.a.a.a r13) {
            kotlin.n0.d.o.f(r11, "account");
            String r0 = this.f8629g.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            if (com.obric.matrix.q.a.a.f9829a.f(this.f8629g.c(), Binder.getCallingUid(), r0) == true) goto L9;
            k(r0, "sendCode", r13);
            return;
        L9:
            boolean r1 = com.bytedance.sdk.account.ticketguard.f.s();
            com.obric.matrix.r.c.c.f("OAccountService", "sendCode isEnableTokenGuard=" + r1);
            if (r1 == true) goto L19;
            com.obric.matrix.r.c.c.f("OAccountService", "sendCode token guard error.");
            com.bytedance.news.common.settings.e.g(true);
            if (r13 != null) goto L30;
            return;
        L30:
            Bundle r14 = new Bundle();     // Catch: Exception -> L16
            r14.putInt("errorCode", -1);     // Catch: Exception -> L16
            r14.putString("errorMsg", "token guard error.");     // Catch: Exception -> L16
            f0 r15 = f0.f18324a;     // Catch: Exception -> L16
            r13.B(false, r14);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            com.obric.matrix.r.c.c.g("OAccountService", "sendCode callback " + r0 + " failed: ", e);
            return;
        L19:
            String r2 = com.obric.matrix.ostracker_api.b.c();
            com.obric.matrix.r.c.c.j("OAccountService", r0 + " Try sendCode did:" + r2);
            com.obric.matrix.account.q.b r3 = com.obric.matrix.account.q.b.a();
            if (r3 == null) goto L23;
            r3.i("sendCode", r0);
        L23:
            if (OAccountService.a(this.f8629g, r2) == false) goto L25;
            o(r0, r11, r12, r13);
            return;
        L25:
            final h r8 = new h(this, r0, r11, r12, r13);
            final String r4 = r0;
            Runnable r9 = new com.obric.matrix.account.service.a(r8, this, r4, r11, r12, r13);
            this.f8628f = r9;
            if (r9 == null) goto L28;
            com.obric.matrix.r.e.o.e(6000, r9);
        L28:
            com.obric.matrix.ostracker_api.b.a(r8);
        }
    }

    static {
    }

    public OAccountService() {
        this.f8627g = new a(this);
    }

    public static final /* synthetic */ boolean a(OAccountService r0, String r1) {
        return r0.d(r1);
    }

    private final boolean d(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        c.s("OAccountService", "invalid did: " + r3);
    L10:
        return r2;
    L5:
        if (o.a(r3, BDLocationException.ERROR_TIMEOUT) == true) goto L7;
        r2 = true;
        goto L8
    }

    public final void b(Context r5, int r6, int r7) {
        if (r5 == null) goto L13;
        String r4 = getPackageManager().getNameForUid(r6);
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        if (com.obric.matrix.q.a.a.f9829a.f(r5, r6, r4) == false) goto L10;
        c.b("OAccountService", "check permission success, callPkg = " + r4 + ", callPid = " + r7 + ", callUid = " + r6);
        return;
    L10:
        c.b("OAccountService", "check permission failed, callPkg = " + r4 + ", callPid = " + r7 + ", callUid = " + r6);
        throw new com.obric.matrix.s.a();
    L13:
        throw new IllegalArgumentException("context is null".toString());
    }

    public final Context c() {
        return this.f8626f;
    }

    public final f0 e(com.obric.matrix.platform.d.a.a.a r2, Bundle r3, int r4, String r5) {
        o.f(r3, WsConstants.KEY_EXTRA);
        if (r2 != null) goto L15;
        f0 r6 = null;
    L14:
        return r6;
    L15:
        r3.putInt("errorCode", r4);     // Catch: Exception -> L10
        if (r5 != null) goto L8;
        r5 = "unknown error";
    L8:
        r3.putString("errorMsg", r5);     // Catch: Exception -> L10
        r6 = f0.f18324a;     // Catch: Exception -> L10
        r2.B(false, r3);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        c.g("OAccountService", "onResultError, error", e);
        return f0.f18324a;
    }

    public final f0 f(com.obric.matrix.platform.d.a.a.a r1, Bundle r2) {
        o.f(r2, WsConstants.KEY_EXTRA);
        if (r1 != null) goto L11;
        return null;
    L11:
        r1.B(true, r2);     // Catch: Exception -> L7
        return f0.f18324a;
    L7:
        e = move-exception;
        c.g("OAccountService", "onResultOk, error", e);
        return f0.f18324a;
    }

    public final void g(String r4, com.obric.matrix.platform.d.a.a.a r5, kotlin.n0.c.a<f0> r6) {
        o.f(r4, "methodName");
        o.f(r6, "block");
        r6.invoke();     // Catch: Exception -> L5 com.obric.matrix.s.a -> L9 IllegalArgumentException -> L13
    L25:
        return;
    L9:
        e = move-exception;
        c.g("OAccountService", r4 + ", no permission: ", e);
        if (r5 == null) goto L22;
        e(r5, new Bundle(), -1000, "Permission denied");
        return;
    L22:
        return;
    L13:
        e = move-exception;
        c.g("OAccountService", r4 + ", illegal argument: ", e);
        if (r5 == null) goto L24;
        Bundle r7 = new Bundle();
        String r8 = "illegal argument: " + e.getMessage();
    L17:
        e(r5, r7, -1, r8);
        return;
    L24:
        return;
    L5:
        e = move-exception;
        c.g("OAccountService", r4 + ", error: ", e);
        if (r5 == null) goto L21;
        r7 = new Bundle();
        r8 = e.getMessage();
        goto L17
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        o.f(r2, "intent");
        c.b("OAccountService", "onBind()");
        return this.f8627g;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f8626f = this;
        c.b("OAccountService", "onCreate()");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c.b("OAccountService", "onDestroy()");
    }
}
