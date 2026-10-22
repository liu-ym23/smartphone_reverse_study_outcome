package com.ss.android.i.n.a.d;

import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.y.c;
import d.b.h.b.a.b;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.d.o;
import kotlin.u0.d;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b:\u0010;R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010(\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R.\u0010.\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u00109\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010\u001e\"\u0004\b\n\u0010 ¨\u0006<"}, d2 = {"Lcom/ss/android/i/n/a/d/a;", "", "", "j", "Ljava/lang/String;", "getAccountExtra", "()Ljava/lang/String;", "setAccountExtra", "(Ljava/lang/String;)V", "accountExtra", "b", "getUserName", "f", "userName", "d", "getUserAvatarUri", "e", "userAvatarUri", "k", "getErrMsg", "setErrMsg", "errMsg", "i", "getFromInstallId", "setFromInstallId", "fromInstallId", "", "g", "I", "getAppid", "()I", "setAppid", "(I)V", "appid", "getAccountType", "setAccountType", "accountType", "", "l", "Ljava/lang/Boolean;", "isKidMode", "()Ljava/lang/Boolean;", "setKidMode", "(Ljava/lang/Boolean;)V", "value", "getUserSession", "userSession", "m", "getDTicket", "a", "dTicket", "getSecUserId", "c", "secUserId", "getUserAvatar", "userAvatar", "h", "isLogin", "<init>", "()V", "sec_share_data_release"}, k = 1, mv = {1, 1, 15})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c("sec_user_id")
    private String f11918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c("user_name")
    private String f11919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c("user_avatar")
    private String f11920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c("user_avatar_uri")
    private String f11921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c("user_session")
    private String f11922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c("account_type")
    private int f11923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c(IBdInstall.PARAM_APP_ID)
    private int f11924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c("account_online")
    private int f11925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c("from_install_id")
    private String f11926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c("account_extra")
    private String f11927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c("error_msg")
    private String f11928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @c("is_key_mode")
    private Boolean f11929l;

    @c("d_ticket")
    private String m;

    public a() {
    }

    public final void a(String r1) {
        this.m = r1;
    }

    public final void b(int r1) {
        this.f11925h = r1;
    }

    public final void c(String r1) {
        this.f11918a = r1;
    }

    public final void d(String r1) {
        this.f11920c = r1;
    }

    public final void e(String r1) {
        this.f11921d = r1;
    }

    public final void f(String r1) {
        this.f11919b = r1;
    }

    public final void g(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L12;
        if (r4 == null) goto L10;
        Charset r0 = d.f21429a;
        if (r4 == null) goto L9;
        byte[] r1 = r4.getBytes(r0);
        o.b(r1, "(this as java.lang.String).getBytes(charset)");
        byte[] r5 = r4.getBytes(r0);
        o.b(r5, "(this as java.lang.String).getBytes(charset)");
        this.f11922e = Base64.encodeToString(b.a(r1, r5.length), 2);
        return;
    L9:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L10:
        o.p();
        throw null;
    }
}
