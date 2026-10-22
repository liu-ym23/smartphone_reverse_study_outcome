package com.obric.matrix.account_api;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&Ju\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J`\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001bH&J\b\u0010\u001c\u001a\u00020\u0003H&J\u001c\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&J\b\u0010\"\u001a\u00020\u0003H&J(\u0010#\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H&Jh\u0010&\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&JV\u0010'\u001a\u00020\u00032\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162:\b\u0002\u0010)\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J\u008c\u0001\u0010*\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b28\u0010(\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001028\u0010)\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&Jp\u0010/\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&Jn\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u00112\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162:\b\u0002\u0010)\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J`\u00105\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&Jh\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&Jh\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J`\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010=2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162:\b\u0002\u0010)\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&Jq\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\b2%\u0010(\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n28\u0010)\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J}\u0010A\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J}\u0010B\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J\u0085\u0001\u0010C\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u00104\u001a\u00020\u00112%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&¨\u0006D"}, d2 = {"Lcom/obric/matrix/account_api/IAccount;", "Lcom/bytedance/news/common/service/manager/IService;", "addAccountStatusListener", "", "listener", "Lcom/obric/matrix/account_api/IAccountStatusListener;", "checkMobileRegister", "mobile", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isRegistered", "onFailed", "Lkotlin/Function2;", "", "errorCode", "errorMsg", "checkPassword", "password", "Lkotlin/Function0;", "forceUpdateAccount", "getAccountInfo", "Lcom/obric/matrix/account_api/AccountInfo;", "getXttTokenMap", "", "init", "login", "context", "Landroid/content/Context;", "options", "Landroid/app/ActivityOptions;", "loginFinished", "loginWithLarkSSOCallback", "callbackIntent", "Landroid/app/PendingIntent;", "loginWithPassword", "logout", "onSuccessAction", "onFailedAction", "quickLogin", "code", "isNewUser", "hasPassword", "removeAccountStatusListener", "resetPassword", "smsCode", "sendCode", "pkgName", "account", "scene", "setInitPassword", "ticketResetPassword", "ticket", "updatePassword", "oldPassword", "newPassword", "updateUserInfo", "generalParams", "Landroid/os/Bundle;", "uploadAvatar", "path", "webUri", "verifyPassword", "verifyPasswordWithoutLogin", "verifySmsCode", "account_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAccount extends IService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IAccount r1, String r2, l r3, p r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r3 = null;
        L7:
            if ((r5 & 4) == 0) goto L9;
            r4 = null;
        L9:
            r1.checkMobileRegister(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkMobileRegister");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(IAccount r1, String r2, kotlin.n0.c.a r3, p r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r3 = null;
        L7:
            if ((r5 & 4) == 0) goto L9;
            r4 = null;
        L9:
            r1.checkPassword(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkPassword");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(IAccount r1, String r2, String r3, kotlin.n0.c.a r4, p r5, int r6, Object r7) {
            if (r7 != null) goto L12;
            if ((r6 & 4) == 0) goto L7;
            r4 = null;
        L7:
            if ((r6 & 8) == 0) goto L9;
            r5 = null;
        L9:
            r1.loginWithPassword(r2, r3, r4, r5);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginWithPassword");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(IAccount r7, String r8, String r9, String r10, kotlin.n0.c.a r11, p r12, int r13, Object r14) {
            if (r14 != null) goto L14;
            if ((r13 & 8) == 0) goto L6;
            kotlin.n0.c.a r5 = null;
        L8:
            if ((r13 & 16) == 0) goto L10;
            p r6 = null;
        L11:
            r7.resetPassword(r8, r9, r10, r5, r6);
            return;
        L10:
            r6 = r12;
            goto L11
        L6:
            r5 = r11;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPassword");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(IAccount r7, String r8, String r9, int r10, kotlin.n0.c.a r11, p r12, int r13, Object r14) {
            if (r14 != null) goto L14;
            if ((r13 & 8) == 0) goto L6;
            kotlin.n0.c.a r5 = null;
        L8:
            if ((r13 & 16) == 0) goto L10;
            p r6 = null;
        L11:
            r7.sendCode(r8, r9, r10, r5, r6);
            return;
        L10:
            r6 = r12;
            goto L11
        L6:
            r5 = r11;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCode");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void f(IAccount r1, String r2, kotlin.n0.c.a r3, p r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r3 = null;
        L7:
            if ((r5 & 4) == 0) goto L9;
            r4 = null;
        L9:
            r1.setInitPassword(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setInitPassword");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void g(IAccount r1, String r2, String r3, kotlin.n0.c.a r4, p r5, int r6, Object r7) {
            if (r7 != null) goto L12;
            if ((r6 & 4) == 0) goto L7;
            r4 = null;
        L7:
            if ((r6 & 8) == 0) goto L9;
            r5 = null;
        L9:
            r1.ticketResetPassword(r2, r3, r4, r5);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ticketResetPassword");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void h(IAccount r1, String r2, String r3, kotlin.n0.c.a r4, p r5, int r6, Object r7) {
            if (r7 != null) goto L12;
            if ((r6 & 4) == 0) goto L7;
            r4 = null;
        L7:
            if ((r6 & 8) == 0) goto L9;
            r5 = null;
        L9:
            r1.updatePassword(r2, r3, r4, r5);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePassword");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void i(IAccount r1, String r2, String r3, l r4, p r5, int r6, Object r7) {
            if (r7 != null) goto L12;
            if ((r6 & 4) == 0) goto L7;
            r4 = null;
        L7:
            if ((r6 & 8) == 0) goto L9;
            r5 = null;
        L9:
            r1.verifyPassword(r2, r3, r4, r5);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verifyPassword");
        }
    }

    void addAccountStatusListener(c r1);

    void checkMobileRegister(String r1, l<? super Boolean, f0> r2, p<? super Integer, ? super String, f0> r3);

    void checkPassword(String r1, kotlin.n0.c.a<f0> r2, p<? super Integer, ? super String, f0> r3);

    void forceUpdateAccount();

    com.obric.matrix.account_api.a getAccountInfo();

    Map<String, String> getXttTokenMap();

    void init();

    void login(Context r1, ActivityOptions r2);

    void loginFinished();

    void loginWithLarkSSOCallback(Context r1, ActivityOptions r2, PendingIntent r3);

    void loginWithPassword(String r1, String r2, kotlin.n0.c.a<f0> r3, p<? super Integer, ? super String, f0> r4);

    void logout(kotlin.n0.c.a<f0> r1, p<? super Integer, ? super String, f0> r2);

    void quickLogin(String r1, String r2, p<? super Boolean, ? super Boolean, f0> r3, p<? super Integer, ? super String, f0> r4);

    void removeAccountStatusListener(c r1);

    void resetPassword(String r1, String r2, String r3, kotlin.n0.c.a<f0> r4, p<? super Integer, ? super String, f0> r5);

    void sendCode(String r1, String r2, int r3, kotlin.n0.c.a<f0> r4, p<? super Integer, ? super String, f0> r5);

    void setInitPassword(String r1, kotlin.n0.c.a<f0> r2, p<? super Integer, ? super String, f0> r3);

    void ticketResetPassword(String r1, String r2, kotlin.n0.c.a<f0> r3, p<? super Integer, ? super String, f0> r4);

    void updatePassword(String r1, String r2, kotlin.n0.c.a<f0> r3, p<? super Integer, ? super String, f0> r4);

    void updateUserInfo(Bundle r1, kotlin.n0.c.a<f0> r2, p<? super Integer, ? super String, f0> r3);

    void uploadAvatar(String r1, l<? super String, f0> r2, p<? super Integer, ? super String, f0> r3);

    void verifyPassword(String r1, String r2, l<? super String, f0> r3, p<? super Integer, ? super String, f0> r4);

    void verifyPasswordWithoutLogin(String r1, String r2, l<? super String, f0> r3, p<? super Integer, ? super String, f0> r4);

    void verifySmsCode(String r1, String r2, int r3, l<? super String, f0> r4, p<? super Integer, ? super String, f0> r5);
}
