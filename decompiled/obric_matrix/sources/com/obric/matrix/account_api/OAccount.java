package com.obric.matrix.account_api;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001Jv\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001Ja\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001cH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0004H\u0096\u0001J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0001J\t\u0010#\u001a\u00020\u0004H\u0096\u0001J)\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0001Ji\u0010'\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001JW\u0010(\u001a\u00020\u00042\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172:\b\u0002\u0010*\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001J\u008d\u0001\u0010+\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t28\u0010)\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001128\u0010*\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001J\u0011\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001Jq\u00100\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001Jo\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\u00122\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172:\b\u0002\u0010*\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001Ja\u00106\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001Ji\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001Ji\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001Ja\u0010<\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172:\b\u0002\u0010*\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001Jr\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\t2%\u0010)\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b28\u0010*\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001J~\u0010B\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001J~\u0010C\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001J\u0086\u0001\u0010D\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u00105\u001a\u00020\u00122%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2<\b\u0002\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0096\u0001¨\u0006E"}, d2 = {"Lcom/obric/matrix/account_api/OAccount;", "Lcom/obric/matrix/account_api/IAccount;", "()V", "addAccountStatusListener", "", "listener", "Lcom/obric/matrix/account_api/IAccountStatusListener;", "checkMobileRegister", "mobile", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isRegistered", "onFailed", "Lkotlin/Function2;", "", "errorCode", "errorMsg", "checkPassword", "password", "Lkotlin/Function0;", "forceUpdateAccount", "getAccountInfo", "Lcom/obric/matrix/account_api/AccountInfo;", "getXttTokenMap", "", "init", "login", "context", "Landroid/content/Context;", "options", "Landroid/app/ActivityOptions;", "loginFinished", "loginWithLarkSSOCallback", "callbackIntent", "Landroid/app/PendingIntent;", "loginWithPassword", "logout", "onSuccessAction", "onFailedAction", "quickLogin", "code", "isNewUser", "hasPassword", "removeAccountStatusListener", "resetPassword", "smsCode", "sendCode", "pkgName", "account", "scene", "setInitPassword", "ticketResetPassword", "ticket", "updatePassword", "oldPassword", "newPassword", "updateUserInfo", "generalParams", "Landroid/os/Bundle;", "uploadAvatar", "path", "webUri", "verifyPassword", "verifyPasswordWithoutLogin", "verifySmsCode", "account_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccount implements IAccount {
    public static final OAccount INSTANCE = null;
    private final /* synthetic */ IAccount $$delegate_0;

    static {
        INSTANCE = new OAccount();
    }

    private OAccount() {
        this.$$delegate_0 = d.a();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void addAccountStatusListener(c r2) {
        o.f(r2, "listener");
        this.$$delegate_0.addAccountStatusListener(r2);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void checkMobileRegister(String r2, l<? super Boolean, f0> r3, p<? super Integer, ? super String, f0> r4) {
        o.f(r2, "mobile");
        this.$$delegate_0.checkMobileRegister(r2, r3, r4);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void checkPassword(String r2, kotlin.n0.c.a<f0> r3, p<? super Integer, ? super String, f0> r4) {
        o.f(r2, "password");
        this.$$delegate_0.checkPassword(r2, r3, r4);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void forceUpdateAccount() {
        this.$$delegate_0.forceUpdateAccount();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public a getAccountInfo() {
        return this.$$delegate_0.getAccountInfo();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public Map<String, String> getXttTokenMap() {
        return this.$$delegate_0.getXttTokenMap();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void login(Context r2, ActivityOptions r3) {
        o.f(r2, "context");
        this.$$delegate_0.login(r2, r3);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void loginFinished() {
        this.$$delegate_0.loginFinished();
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void loginWithLarkSSOCallback(Context r2, ActivityOptions r3, PendingIntent r4) {
        o.f(r2, "context");
        this.$$delegate_0.loginWithLarkSSOCallback(r2, r3, r4);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void loginWithPassword(String r2, String r3, kotlin.n0.c.a<f0> r4, p<? super Integer, ? super String, f0> r5) {
        o.f(r2, "mobile");
        o.f(r3, "password");
        this.$$delegate_0.loginWithPassword(r2, r3, r4, r5);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void logout(kotlin.n0.c.a<f0> r1, p<? super Integer, ? super String, f0> r2) {
        this.$$delegate_0.logout(r1, r2);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void quickLogin(String r2, String r3, p<? super Boolean, ? super Boolean, f0> r4, p<? super Integer, ? super String, f0> r5) {
        o.f(r2, "mobile");
        o.f(r3, "code");
        this.$$delegate_0.quickLogin(r2, r3, r4, r5);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void removeAccountStatusListener(c r2) {
        o.f(r2, "listener");
        this.$$delegate_0.removeAccountStatusListener(r2);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void resetPassword(String r8, String r9, String r10, kotlin.n0.c.a<f0> r11, p<? super Integer, ? super String, f0> r12) {
        o.f(r8, "mobile");
        o.f(r9, "smsCode");
        o.f(r10, "password");
        this.$$delegate_0.resetPassword(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void sendCode(String r8, String r9, int r10, kotlin.n0.c.a<f0> r11, p<? super Integer, ? super String, f0> r12) {
        o.f(r8, "pkgName");
        o.f(r9, "account");
        this.$$delegate_0.sendCode(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void setInitPassword(String r2, kotlin.n0.c.a<f0> r3, p<? super Integer, ? super String, f0> r4) {
        o.f(r2, "password");
        this.$$delegate_0.setInitPassword(r2, r3, r4);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void ticketResetPassword(String r2, String r3, kotlin.n0.c.a<f0> r4, p<? super Integer, ? super String, f0> r5) {
        o.f(r2, "ticket");
        o.f(r3, "password");
        this.$$delegate_0.ticketResetPassword(r2, r3, r4, r5);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void updatePassword(String r2, String r3, kotlin.n0.c.a<f0> r4, p<? super Integer, ? super String, f0> r5) {
        o.f(r2, "oldPassword");
        o.f(r3, "newPassword");
        this.$$delegate_0.updatePassword(r2, r3, r4, r5);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void updateUserInfo(Bundle r1, kotlin.n0.c.a<f0> r2, p<? super Integer, ? super String, f0> r3) {
        this.$$delegate_0.updateUserInfo(r1, r2, r3);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void uploadAvatar(String r2, l<? super String, f0> r3, p<? super Integer, ? super String, f0> r4) {
        o.f(r2, "path");
        this.$$delegate_0.uploadAvatar(r2, r3, r4);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void verifyPassword(String r2, String r3, l<? super String, f0> r4, p<? super Integer, ? super String, f0> r5) {
        o.f(r2, "mobile");
        o.f(r3, "password");
        this.$$delegate_0.verifyPassword(r2, r3, r4, r5);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void verifyPasswordWithoutLogin(String r2, String r3, l<? super String, f0> r4, p<? super Integer, ? super String, f0> r5) {
        o.f(r2, "mobile");
        o.f(r3, "password");
        this.$$delegate_0.verifyPasswordWithoutLogin(r2, r3, r4, r5);
    }

    @Override // com.obric.matrix.account_api.IAccount
    public void verifySmsCode(String r8, String r9, int r10, l<? super String, f0> r11, p<? super Integer, ? super String, f0> r12) {
        o.f(r8, "mobile");
        o.f(r9, "code");
        this.$$delegate_0.verifySmsCode(r8, r9, r10, r11, r12);
    }
}
