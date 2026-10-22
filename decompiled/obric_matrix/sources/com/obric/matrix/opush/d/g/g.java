package com.obric.matrix.opush.d.g;

import android.content.Intent;
import com.obric.matrix.v.a.j;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/opush/base/message/ReceiptContextCodec;", "", "()V", "EXTRA_APP_ID", "", "EXTRA_DID", "EXTRA_ENV", "EXTRA_PUSH_TOKEN", "EXTRA_REQ_ID", "EXTRA_REQ_TS", "EXTRA_SESSION_ID", "EXTRA_TAG", "EXTRA_VERSION", "fromIntent", "Lcom/obric/matrix/opush/base/message/ReceiptContext;", "intent", "Landroid/content/Intent;", "fromJson", "json", "Lorg/json/JSONObject;", "fromMessage", "message", "Lcom/obric/matrix/o/push/Message;", "parseMessageTag", "writeToIntent", "", "context", "writeToJson", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9359a = null;

    static {
        f9359a = new g();
    }

    private g() {
    }

    private final String d(com.obric.matrix.v.a.g r4) {
        Object r3 = "";
        v.a r0 = v.f21457g;     // Catch: Throwable -> L14
        com.obric.matrix.opush.g.e r1 = com.obric.matrix.opush.g.e.f9429a;     // Catch: Throwable -> L14
        k.h r5 = r4.r;     // Catch: Throwable -> L14
        Object r2 = null;
        if (r5 == null) goto L6;
        byte[] r6 = r5.E();     // Catch: Throwable -> L14
    L7:
        j r7 = (j) com.obric.matrix.r.e.e.a(new String(r1.a(r6), kotlin.u0.d.f21429a), j.class);     // Catch: Throwable -> L14
        if (r7 == null) goto L10;
        r2 = r7.f10115d;     // Catch: Throwable -> L14
    L10:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        v.b(r2);     // Catch: Throwable -> L14
    L17:
        if (v.f(r2) == true) goto L21;
        r3 = r2;
    L21:
        return (String) r3;
    L6:
        r6 = null;
    L14:
        th = move-exception;
        v.a r8 = v.f21457g;
        r2 = w.a(th);
        v.b(r2);
        goto L17
    }

    public final f a(Intent r19) {
        o.f(r19, "intent");
        String r1 = r19.getStringExtra("msg_id");
        String r2 = "";
        if (r1 != null) goto L5;
        String r10 = "";
    L7:
        if (r10.length() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        return null;
    L13:
        int r5 = r19.getIntExtra("receipt_version", 1);
        String r4 = r19.getStringExtra("receipt_env");
        if (r4 != null) goto L16;
        String r6 = "";
    L17:
        String r7 = r19.getStringExtra("receipt_did");
        if (r7 != null) goto L20;
        String r8 = "";
    L21:
        long r11 = r19.getLongExtra("receipt_session_id", 0);
        int r13 = r19.getIntExtra("receipt_app_id", 0);
        String r9 = r19.getStringExtra("receipt_req_id");
        if (r9 != null) goto L24;
        String r14 = "";
    L25:
        String r12 = r19.getStringExtra("receipt_push_token");
        if (r12 != null) goto L28;
        String r15 = "";
    L29:
        String r16 = r19.getStringExtra("receipt_tag");
        if (r16 == null) goto L34;
        r2 = r16;
    L34:
        return new f(r5, r6, r8, r11, r13, r10, r14, r15, r2, r19.getLongExtra("receipt_req_ts", 0));
    L28:
        r15 = r12;
        goto L29
    L24:
        r14 = r9;
        goto L25
    L20:
        r8 = r7;
        goto L21
    L16:
        r6 = r4;
        goto L17
    L9:
        r3 = false;
        goto L10
    L5:
        r10 = r1;
        goto L7
    }

    public final f b(JSONObject r19) {
        if (r19 != null) goto L5;
        return null;
    L5:
        String r10 = r19.optString("msg_id");
        o.e(r10, "msgId");
        if (r10.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return null;
    L11:
        int r3 = r19.optInt("receipt_version", 1);
        String r5 = r19.optString("receipt_env");
        o.e(r5, "json.optString(EXTRA_ENV)");
        String r6 = r19.optString("receipt_did");
        o.e(r6, "json.optString(EXTRA_DID)");
        long r11 = r19.optLong("receipt_session_id", 0);
        int r9 = r19.optInt("receipt_app_id", 0);
        String r13 = r19.optString("receipt_req_id");
        o.e(r13, "json.optString(EXTRA_REQ_ID)");
        String r14 = r19.optString("receipt_push_token");
        o.e(r14, "json.optString(EXTRA_PUSH_TOKEN)");
        String r15 = r19.optString("receipt_tag");
        o.e(r15, "json.optString(EXTRA_TAG)");
        return new f(r3, r5, r6, r11, r9, r10, r13, r14, r15, r19.optLong("receipt_req_ts", 0));
    L8:
        r2 = false;
        goto L9
    }

    public final f c(com.obric.matrix.v.a.g r18) {
        if (r18 == null) goto L5;
        String r10 = r18.m;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        String r13 = d(r18);
        Integer r2 = r18.f10088f;
        if (r2 != null) goto L11;
        int r3 = 1;
    L12:
        int r4 = r3;
        String r5 = r18.f10089g;
        if (r5 != null) goto L15;
        String r6 = "";
    L16:
        String r7 = r18.f10090h;
        if (r7 != null) goto L19;
        String r8 = "";
    L20:
        Long r9 = r18.f10091i;
        long r11 = 0;
        if (r9 != null) goto L23;
        long r12 = 0;
    L24:
        Integer r14 = r18.f10092j;
        if (r14 != null) goto L27;
        int r15 = 0;
    L28:
        int r16 = r15;
        String r17 = r18.f10094l;
        if (r17 != null) goto L31;
        r17 = "";
    L31:
        String r19 = r18.f10093k;
        if (r19 != null) goto L34;
        r19 = "";
    L34:
        Long r0 = r18.s;
        if (r0 == null) goto L39;
        r11 = r0.longValue();
    L39:
        return new f(r4, r6, r8, r12, r16, r10, r17, r19, r13, r11);
    L27:
        r15 = r14.intValue();
        goto L28
    L23:
        r12 = r9.longValue();
        goto L24
    L19:
        r8 = r7;
        goto L20
    L15:
        r6 = r5;
        goto L16
    L11:
        r3 = r2.intValue();
        goto L12
    L5:
        r10 = null;
        goto L6
    }

    public final void e(Intent r3, f r4) {
        o.f(r3, "intent");
        o.f(r4, "context");
        r3.putExtra("receipt_version", r4.j());
        r3.putExtra("receipt_env", r4.c());
        r3.putExtra("receipt_did", r4.b());
        r3.putExtra("receipt_session_id", r4.h());
        r3.putExtra("receipt_app_id", r4.a());
        r3.putExtra("receipt_req_id", r4.f());
        r3.putExtra("receipt_push_token", r4.e());
        r3.putExtra("receipt_tag", r4.i());
        r3.putExtra("receipt_req_ts", r4.g());
    }

    public final void f(JSONObject r3, f r4) {
        o.f(r3, "json");
        o.f(r4, "context");
        r3.put("msg_id", r4.d());
        r3.put("receipt_version", r4.j());
        r3.put("receipt_env", r4.c());
        r3.put("receipt_did", r4.b());
        r3.put("receipt_session_id", r4.h());
        r3.put("receipt_app_id", r4.a());
        r3.put("receipt_req_id", r4.f());
        r3.put("receipt_push_token", r4.e());
        r3.put("receipt_tag", r4.i());
        r3.put("receipt_req_ts", r4.g());
    }
}
