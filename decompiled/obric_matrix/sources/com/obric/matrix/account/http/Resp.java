package com.obric.matrix.account.http;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 '*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001'B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J@\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0012\u0010\u0019\u001a\u00020\u001a8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/obric/matrix/account/http/Resp;", "T", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", WsConstants.KEY_PAYLOAD, "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getPayload", "setPayload", "success", "", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/obric/matrix/account/http/Resp;", "equals", "other", "hashCode", "toString", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Resp<T> {
    public static final int CODE_RISK_CONTROL = 710012005;
    public static final int CODE_UNKNOWN = -999;
    public static final a Companion = null;

    @com.google.gson.y.c("code")
    private int code;

    @com.google.gson.y.c("data")
    private T data;

    @com.google.gson.y.c(NotificationCompat.CATEGORY_MESSAGE)
    private String msg;

    @com.google.gson.y.c(WsConstants.KEY_PAYLOAD)
    private String payload;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/account/http/Resp$Companion;", "", "()V", "CODE_RISK_CONTROL", "", "CODE_UNKNOWN", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public Resp() {
        this(0, null, null, null, 15, null);
    }

    public Resp(int r2, String r3, T r4, String r5) {
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        this.code = r2;
        this.msg = r3;
        this.data = r4;
        this.payload = r5;
    }

    public /* synthetic */ Resp(int r2, String r3, Object r4, String r5, int r6, kotlin.n0.d.g r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = CODE_UNKNOWN;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Resp copy$default(Resp r0, int r1, String r2, Object r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.msg;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.payload;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final T component3() {
        return this.data;
    }

    public final String component4() {
        return this.payload;
    }

    public final Resp<T> copy(int r1, String r2, T r3, String r4) {
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        return new Resp(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Resp) == true) goto L8;
        return false;
    L8:
        Resp r6 = (Resp) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (o.a(this.payload, r6.payload) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
        T r1 = this.data;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.payload;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setData(T r1) {
        this.data = r1;
    }

    public final void setMsg(String r2) {
        o.f(r2, "<set-?>");
        this.msg = r2;
    }

    public final void setPayload(String r1) {
        this.payload = r1;
    }

    public String toString() {
        return "Resp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", payload=" + this.payload + ')';
    }
}
