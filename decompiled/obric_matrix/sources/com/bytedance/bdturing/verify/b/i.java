package com.bytedance.bdturing.verify.b;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.ttnet.TTNetInit;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f3243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f3245j;

    public i(String r2) {
        o.g(r2, "riskInfo");
        this(null, r2);
    }

    public i(String r23, String r24) {
        this.f3245j = r24;
        this.f3244i = BdTuringConfig.DEFAULT_EVENT_COUNT;
        JSONObject r4 = new JSONObject(r24);     // Catch: Exception -> L113
        String r1 = r4.optString("region");     // Catch: Exception -> L113
        String r5 = r4.optString("subtype");     // Catch: Exception -> L113
        String r6 = r4.optString("verify_ticket");     // Catch: Exception -> L113
        String r7 = r4.optString("channel_mobile");     // Catch: Exception -> L113
        String r8 = r4.optString("sms_content");     // Catch: Exception -> L113
        String r9 = r4.optString("mobile");     // Catch: Exception -> L113
        String r10 = r4.optString("maxEVS");     // Catch: Exception -> L113
        String r11 = r4.optString("log_id");     // Catch: Exception -> L113
        if (r4.optLong("code") != 30000) goto L11;
        String r12 = r4.optString("identity_scene");     // Catch: Exception -> L113
        String r15 = r4.optString("flow");     // Catch: Exception -> L113
        o.b(r15, "riskJson.optString(\"flow\")");     // Catch: Exception -> L113
        String r13 = r4.optString("identity_action");     // Catch: Exception -> L113
        o.b(r13, "riskJson.optString(\"identity_action\")");     // Catch: Exception -> L113
        String r3 = r4.optString("detail", "");     // Catch: Exception -> L113
        o.b(r3, "riskJson.optString(\"detail\", \"\")");     // Catch: Exception -> L113
        String r2 = r4.optString("identity_ticket", "");     // Catch: Exception -> L113
        o.b(r2, "riskJson.optString(\"identity_ticket\", \"\")");     // Catch: Exception -> L113
        if (r4.optBoolean("identity_no_need_popups", false) == true) goto L8;
        boolean r21 = true;
    L9:
        o.b(r12, "identityScene");     // Catch: Exception -> L113
        this.f3243h = new e(r12, r15, r13, r3, r2, r21);     // Catch: Exception -> L113
        goto L11
    L8:
        r21 = false;
    L11:
        if (TextUtils.isEmpty(r10) == true) goto L17;
        o.b(r10, "limitStr");     // Catch: Exception -> L14
        this.f3244i = Integer.parseInt(r10);     // Catch: Exception -> L14
    L15:
        this.f3244i = BdTuringConfig.DEFAULT_EVENT_COUNT;     // Catch: Exception -> L113
    L17:
        if (this.f3243h != null) goto L67;
        kotlin.n0.d.g r14 = null;
        if (r5 != null) goto L23;
    L66:
        int r16 = 0;
        a r17 = new f(r16, 1, r14);     // Catch: Exception -> L113
    L59:
        this.f3243h = r17;     // Catch: Exception -> L113
        goto L67
    L23:
        switch(r5.hashCode()) {
            case -797498437: goto L64;
            case -135762164: goto L61;
            case 1681: goto L57;
            case 3600: goto L54;
            case 114009: goto L51;
            case 3556653: goto L48;
            case 109526449: goto L45;
            case 112386354: goto L42;
            case 113101810: goto L39;
            case 300626556: goto L36;
            case 307350857: goto L33;
            case 312290780: goto L30;
            case 705104230: goto L26;
            default: goto L66;
        };
    L26:
        if (r5.equals("mobile_up_sms_verify") == false) goto L66;
        o.b(r6, "verifyTicket");     // Catch: Exception -> L113
        o.b(r7, "channelMobile");     // Catch: Exception -> L113
        o.b(r8, "smsContent");     // Catch: Exception -> L113
        a r18 = new l(r6, r7, r8);     // Catch: Exception -> L113
    L28:
        this.f3243h = r18;     // Catch: Exception -> L113
        goto L67
    L30:
        if (r5.equals("mobile_sms_verify") == false) goto L66;
        r18 = new b(r6, r9);     // Catch: Exception -> L113
        goto L28
    L33:
        if (r5.equals("mobile_voice_sms_verify") == false) goto L66;
        o.b(r6, "verifyTicket");     // Catch: Exception -> L113
        r18 = new n(r6);     // Catch: Exception -> L113
        goto L28
    L36:
        if (r5.equals("email_verify") == false) goto L66;
        o.b(r6, "verifyTicket");     // Catch: Exception -> L113
        r18 = new c(r6);     // Catch: Exception -> L113
        goto L28
    L39:
        if (r5.equals("whirl") == false) goto L66;
    L58:
        int r19 = 0;
        r17 = new f(r19, 1, r14);     // Catch: Exception -> L113
        goto L59
    L42:
        if (r5.equals("voice") == false) goto L66;
        r18 = new m();     // Catch: Exception -> L113
        goto L28
    L45:
        if (r5.equals("slide") == false) goto L66;
    L48:
        if (r5.equals("text") == false) goto L66;
    L51:
        if (r5.equals("sms") == false) goto L66;
        r18 = new k(null, false, r23, 3, null);     // Catch: Exception -> L113
        goto L28
    L54:
        if (r5.equals("qa") == false) goto L66;
        r18 = new h(r23);     // Catch: Exception -> L113
        goto L28
    L57:
        if (r5.equals("3d") == false) goto L66;
    L61:
        if (r5.equals("identify") == false) goto L66;
        r17 = new d(null, null, 3, null);     // Catch: Exception -> L113
        goto L59
    L64:
        if (r5.equals("pwd_verify") == false) goto L66;
        o.b(r6, "verifyTicket");     // Catch: Exception -> L113
        r18 = new g(r6);     // Catch: Exception -> L113
    L67:
        a r20 = this.f3243h;     // Catch: Exception -> L113
        if (r20 == null) goto L71;
        o.b(r11, "logId");     // Catch: Exception -> L113
        r20.o(r11);     // Catch: Exception -> L113
    L71:
        o.b(r11, "logId");     // Catch: Exception -> L113
        o(r11);     // Catch: Exception -> L113
        if (r1 == null) goto L120;
        int r0 = r1.hashCode();     // Catch: Exception -> L113
        if (r0 == 3179) goto L108;
        if (r0 == 3365) goto L103;
        if (r0 == 3668) goto L98;
        if (r0 == 3755) goto L93;
        if (r0 == 97720) goto L87;
        return;
    L87:
        if (r1.equals(TTNetInit.DOMAIN_BOE_KEY) == false) goto L121;
        com.bytedance.bdturing.b r22 = com.bytedance.bdturing.b.f();     // Catch: Exception -> L113
        o.b(r22, "BdTuring.getInstance()");     // Catch: Exception -> L113
        BdTuringConfig r25 = r22.e();     // Catch: Exception -> L113
        if (r25 == null) goto L122;
        BdTuringConfig.c r26 = BdTuringConfig.c.f3014k;     // Catch: Exception -> L113
    L91:
        r25.setRegionType(r26);     // Catch: Exception -> L113
        return;
    L122:
        return;
    L121:
        return;
    L93:
        if (r1.equals("va") == false) goto L124;
        com.bytedance.bdturing.b r27 = com.bytedance.bdturing.b.f();     // Catch: Exception -> L113
        o.b(r27, "BdTuring.getInstance()");     // Catch: Exception -> L113
        r25 = r27.e();     // Catch: Exception -> L113
        if (r25 == null) goto L125;
        r26 = BdTuringConfig.c.f3012i;     // Catch: Exception -> L113
        goto L91
    L125:
        return;
    L124:
        return;
    L98:
        if (r1.equals("sg") == false) goto L126;
        com.bytedance.bdturing.b r28 = com.bytedance.bdturing.b.f();     // Catch: Exception -> L113
        o.b(r28, "BdTuring.getInstance()");     // Catch: Exception -> L113
        r25 = r28.e();     // Catch: Exception -> L113
        if (r25 == null) goto L127;
        r26 = BdTuringConfig.c.f3011h;     // Catch: Exception -> L113
        goto L91
    L127:
        return;
    L126:
        return;
    L103:
        if (r1.equals("in") == false) goto L128;
        com.bytedance.bdturing.b r29 = com.bytedance.bdturing.b.f();     // Catch: Exception -> L113
        o.b(r29, "BdTuring.getInstance()");     // Catch: Exception -> L113
        r25 = r29.e();     // Catch: Exception -> L113
        if (r25 == null) goto L129;
        r26 = BdTuringConfig.c.f3013j;     // Catch: Exception -> L113
        goto L91
    L129:
        return;
    L128:
        return;
    L108:
        if (r1.equals("cn") == false) goto L130;
        com.bytedance.bdturing.b r30 = com.bytedance.bdturing.b.f();     // Catch: Exception -> L113
        o.b(r30, "BdTuring.getInstance()");     // Catch: Exception -> L113
        r25 = r30.e();     // Catch: Exception -> L113
        if (r25 == null) goto L131;
        r26 = BdTuringConfig.c.f3010g;     // Catch: Exception -> L113
        goto L91
    L131:
        return;
    L130:
        return;
    L120:
        return;
    L113:
        e = move-exception;
        com.bytedance.bdturing.g.e(e);
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public void a(StringBuilder r2) {
        o.g(r2, "queryBuilder");
        a r0 = this.f3243h;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        com.bytedance.bdturing.x.e.c(r2, "verify_data", this.f3245j);
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int c() {
        return this.f3244i;
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public boolean d() {
        a r0 = this.f3243h;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public String i() {
        a r0 = this.f3243h;
        if (r0 == null) goto L7;
        String r1 = r0.i();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return "";
    }

    @Override // com.bytedance.bdturing.verify.b.a
    public int j() {
        a r0 = this.f3243h;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.j();
    }

    public final a q() {
        return this.f3243h;
    }
}
