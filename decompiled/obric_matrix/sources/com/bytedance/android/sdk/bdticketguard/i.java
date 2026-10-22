package com.bytedance.android.sdk.bdticketguard;

import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b&\n\u0002\u0010\u0003\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\b\b\u0002\u00105\u001a\u00020\t\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010I\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00107\u001a\u00020\t\u0012\b\b\u0002\u00108\u001a\u00020\t\u0012\b\b\u0002\u0010P\u001a\u00020\t\u0012\b\b\u0002\u0010L\u001a\u00020\t\u0012\b\b\u0002\u0010;\u001a\u00020\t\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010?\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010?¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010\u0010R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010\u0010R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010\u0010R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010\u0010R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b\f\u0010\u0004\"\u0004\b0\u0010\u0010R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\r\u001a\u0004\b3\u0010\u0004\"\u0004\b+\u0010\u0010R\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b5\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u00107\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b6\u0010\u0015\"\u0004\b/\u0010\u0017R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0013\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\u0017R$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b=\u0010\u0004\"\u0004\b2\u0010\u0010R$\u0010D\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b\u0012\u0010B\"\u0004\b \u0010CR\"\u0010I\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u0007\"\u0004\b:\u0010HR$\u0010J\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010A\u001a\u0004\bE\u0010B\"\u0004\b$\u0010CR\"\u0010L\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0013\u001a\u0004\bK\u0010\u0015\"\u0004\b@\u0010\u0017R$\u0010O\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\bM\u0010\u0004\"\u0004\bN\u0010\u0010R\"\u0010P\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0013\u001a\u0004\bP\u0010\u0015\"\u0004\bQ\u0010\u0017¨\u0006T"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/i;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "a", "j", "(Ljava/lang/String;)V", "attestationAdapter", "c", "Z", "isGenerateKey", "()Z", "p", "(Z)V", "", "n", "Ljava/util/Set;", "h", "()Ljava/util/Set;", "A", "(Ljava/util/Set;)V", "requestType", "q", "b", "m", "clientCert", "r", "f", "x", "recordTeePublicKey", "g", "z", "reePublicKey", "o", "i", "C", "teePublicKey", "s", "w", "recordReePublicKey", "l", "getExtraAppData", "extraAppData", "isDeleteOldKey", "getHasKey", "hasKey", "isTeeChanged", "B", "k", "isNeedUpgrade", "u", "getChallenge", "challenge", "", "t", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "(Ljava/lang/Throwable;)V", "getAltRequestParamsException", "d", "I", "getCertChainSize", "(I)V", "certChainSize", "getCertChainException", "getHasResult", "hasResult", "getOldAdapter", BaseSwitches.V, "oldAdapter", "isReeChanged", "y", "<init>", "(ZLjava/lang/String;ZILjava/lang/String;Ljava/lang/String;ZZZZZLjava/lang/String;Ljava/lang/Throwable;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("is_delete_old_key")
    private boolean f796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("challenge")
    private String f797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("is_generate_key")
    private boolean f798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("cert_chain_size")
    private int f799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("attestation_adapter")
    private String f800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("old_adapter")
    private String f801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("has_key")
    private boolean f802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.google.gson.y.c("is_tee_changed")
    private boolean f803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.google.gson.y.c("is_ree_changed")
    private boolean f804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.google.gson.y.c("has_result")
    private boolean f805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @com.google.gson.y.c("is_need_upgrade")
    private boolean f806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @com.google.gson.y.c("extra_app_data")
    private String f807l;
    private transient Throwable m;
    private transient Set<String> n;
    private transient String o;
    private transient String p;
    private transient String q;
    private transient String r;
    private transient String s;
    private transient Throwable t;

    public i() {
        this(false, null, false, 0, null, null, false, false, false, false, false, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public i(boolean r5, String r6, boolean r7, int r8, String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, String r16, Throwable r17, Set<String> r18, String r19, String r20, String r21, String r22, String r23, Throwable r24) {
        kotlin.n0.d.o.g(r16, "extraAppData");
        kotlin.n0.d.o.g(r18, "requestType");
        this.f796a = r5;
        this.f797b = r6;
        this.f798c = r7;
        this.f799d = r8;
        this.f800e = r9;
        this.f801f = r10;
        this.f802g = r11;
        this.f803h = r12;
        this.f804i = r13;
        this.f805j = r14;
        this.f806k = r15;
        this.f807l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
        this.p = r20;
        this.q = r21;
        this.r = r22;
        this.s = r23;
        this.t = r24;
    }

    public /* synthetic */ i(boolean r22, String r23, boolean r24, int r25, String r26, String r27, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32, String r33, Throwable r34, Set r35, String r36, String r37, String r38, String r39, String r40, Throwable r41, int r42, kotlin.n0.d.g r43) {
        boolean r2 = false;
        if ((r42 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r42 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r42 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r42 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r42 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r42 & 64) == 0) goto L29;
        boolean r9 = false;
    L31:
        if ((r42 & 128) == 0) goto L33;
        boolean r10 = false;
    L35:
        if ((r42 & 256) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r42 & 512) == 0) goto L41;
        boolean r12 = false;
    L43:
        if ((r42 & 1024) != 0) goto L47;
        r2 = r32;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r13 = "";
    L51:
        if ((r42 & 4096) == 0) goto L53;
        Throwable r14 = null;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        Set r15 = kotlin.i0.t0.b();
    L59:
        if ((r42 & 16384) == 0) goto L61;
        String r4 = null;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r42 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r42 & 524288) == 0) goto L81;
        Throwable r0 = null;
    L82:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r2, r13, r14, r15, r4, r16, r17, r18, r19, r0);
        return;
    L81:
        r0 = r41;
        goto L82
    L77:
        r19 = r40;
        goto L79
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r4 = r36;
        goto L63
    L57:
        r15 = r35;
        goto L59
    L53:
        r14 = r34;
        goto L55
    L49:
        r13 = r33;
        goto L51
    L41:
        r12 = r31;
        goto L43
    L37:
        r11 = r30;
        goto L39
    L33:
        r10 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r5 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }

    public final void A(Set<String> r2) {
        kotlin.n0.d.o.g(r2, "<set-?>");
        this.n = r2;
    }

    public final void B(boolean r1) {
        this.f803h = r1;
    }

    public final void C(String r1) {
        this.o = r1;
    }

    public final String a() {
        return this.f800e;
    }

    public final String b() {
        return this.q;
    }

    public final Throwable c() {
        return this.t;
    }

    public final Throwable d() {
        return this.m;
    }

    public final String e() {
        return this.s;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L72:
        return true;
    L5:
        if ((r5 instanceof i) == false) goto L71;
        i r6 = (i) r5;
        if (this.f796a != r6.f796a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L71;
        if (kotlin.n0.d.o.a(this.f797b, r6.f797b) == false) goto L71;
        if (this.f798c != r6.f798c) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L71;
        if (this.f799d != r6.f799d) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L71;
        if (kotlin.n0.d.o.a(this.f800e, r6.f800e) == false) goto L71;
        if (kotlin.n0.d.o.a(this.f801f, r6.f801f) == false) goto L71;
        if (this.f802g != r6.f802g) goto L30;
        boolean r4 = true;
    L31:
        if (r4 == false) goto L71;
        if (this.f803h != r6.f803h) goto L35;
        boolean r7 = true;
    L36:
        if (r7 == false) goto L71;
        if (this.f804i != r6.f804i) goto L40;
        boolean r8 = true;
    L41:
        if (r8 == false) goto L71;
        if (this.f805j != r6.f805j) goto L45;
        boolean r9 = true;
    L46:
        if (r9 == false) goto L71;
        if (this.f806k != r6.f806k) goto L50;
        boolean r10 = true;
    L51:
        if (r10 == false) goto L71;
        if (kotlin.n0.d.o.a(this.f807l, r6.f807l) == false) goto L71;
        if (kotlin.n0.d.o.a(this.m, r6.m) == false) goto L71;
        if (kotlin.n0.d.o.a(this.n, r6.n) == false) goto L71;
        if (kotlin.n0.d.o.a(this.o, r6.o) == false) goto L71;
        if (kotlin.n0.d.o.a(this.p, r6.p) == false) goto L71;
        if (kotlin.n0.d.o.a(this.q, r6.q) == false) goto L71;
        if (kotlin.n0.d.o.a(this.r, r6.r) == false) goto L71;
        if (kotlin.n0.d.o.a(this.s, r6.s) == false) goto L71;
        if (kotlin.n0.d.o.a(this.t, r6.t) == false) goto L71;
    L50:
        r10 = false;
        goto L51
    L45:
        r9 = false;
        goto L46
    L40:
        r8 = false;
        goto L41
    L35:
        r7 = false;
        goto L36
    L30:
        r4 = false;
        goto L31
    L21:
        r3 = false;
        goto L22
    L16:
        r2 = false;
        goto L17
    L9:
        r1 = false;
    L71:
        return false;
    }

    public final String f() {
        return this.r;
    }

    public final String g() {
        return this.p;
    }

    public final Set<String> h() {
        return this.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        boolean r0 = this.f796a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        String r4 = this.f797b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.f798c;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (((r7 + r9) * 31) + Integer.hashCode(this.f799d)) * 31;
        String r11 = this.f800e;
        if (r11 == null) goto L15;
        int r12 = r11.hashCode();
    L16:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f801f;
        if (r14 == null) goto L19;
        int r15 = r14.hashCode();
    L20:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.f802g;
        ?? r18 = r17;
        if (r17 == false) goto L23;
        r18 = 1;
    L23:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.f803h;
        ?? r21 = r20;
        if (r20 == false) goto L26;
        r21 = 1;
    L26:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.f804i;
        ?? r24 = r23;
        if (r23 == false) goto L29;
        r24 = 1;
    L29:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.f805j;
        ?? r27 = r26;
        if (r26 == false) goto L32;
        r27 = 1;
    L32:
        int r28 = (r25 + r27) * 31;
        boolean r29 = this.f806k;
        if (r29 == true) goto L36;
        r1 = r29;
    L36:
        int r30 = (r28 + r1) * 31;
        String r31 = this.f807l;
        if (r31 == null) goto L39;
        int r32 = r31.hashCode();
    L40:
        int r33 = (r30 + r32) * 31;
        Throwable r34 = this.m;
        if (r34 == null) goto L43;
        int r35 = r34.hashCode();
    L44:
        int r36 = (r33 + r35) * 31;
        Set<String> r37 = this.n;
        if (r37 == null) goto L47;
        int r38 = r37.hashCode();
    L48:
        int r39 = (r36 + r38) * 31;
        String r40 = this.o;
        if (r40 == null) goto L51;
        int r41 = r40.hashCode();
    L52:
        int r42 = (r39 + r41) * 31;
        String r43 = this.p;
        if (r43 == null) goto L55;
        int r44 = r43.hashCode();
    L56:
        int r45 = (r42 + r44) * 31;
        String r46 = this.q;
        if (r46 == null) goto L59;
        int r47 = r46.hashCode();
    L60:
        int r48 = (r45 + r47) * 31;
        String r49 = this.r;
        if (r49 == null) goto L63;
        int r50 = r49.hashCode();
    L64:
        int r51 = (r48 + r50) * 31;
        String r52 = this.s;
        if (r52 == null) goto L67;
        int r53 = r52.hashCode();
    L68:
        int r54 = (r51 + r53) * 31;
        Throwable r55 = this.t;
        if (r55 == null) goto L72;
        r5 = r55.hashCode();
    L72:
        return r54 + r5;
    L67:
        r53 = 0;
        goto L68
    L63:
        r50 = 0;
        goto L64
    L59:
        r47 = 0;
        goto L60
    L55:
        r44 = 0;
        goto L56
    L51:
        r41 = 0;
        goto L52
    L47:
        r38 = 0;
        goto L48
    L43:
        r35 = 0;
        goto L44
    L39:
        r32 = 0;
        goto L40
    L19:
        r15 = 0;
        goto L20
    L15:
        r12 = 0;
        goto L16
    L8:
        r6 = 0;
        goto L9
    }

    public final String i() {
        return this.o;
    }

    public final void j(String r1) {
        this.f800e = r1;
    }

    public final void k(int r1) {
        this.f799d = r1;
    }

    public final void l(String r1) {
        this.f797b = r1;
    }

    public final void m(String r1) {
        this.q = r1;
    }

    public final void n(boolean r1) {
        this.f796a = r1;
    }

    public final void o(String r2) {
        kotlin.n0.d.o.g(r2, "<set-?>");
        this.f807l = r2;
    }

    public final void p(boolean r1) {
        this.f798c = r1;
    }

    public final void q(Throwable r1) {
        this.t = r1;
    }

    public final void r(Throwable r1) {
        this.m = r1;
    }

    public final void s(boolean r1) {
        this.f802g = r1;
    }

    public final void t(boolean r1) {
        this.f805j = r1;
    }

    public String toString() {
        return "AttestationSnapshot(isDeleteOldKey=" + this.f796a + ", challenge=" + this.f797b + ", isGenerateKey=" + this.f798c + ", certChainSize=" + this.f799d + ", attestationAdapter=" + this.f800e + ", oldAdapter=" + this.f801f + ", hasKey=" + this.f802g + ", isTeeChanged=" + this.f803h + ", isReeChanged=" + this.f804i + ", hasResult=" + this.f805j + ", isNeedUpgrade=" + this.f806k + ", extraAppData=" + this.f807l + ", getCertChainException=" + this.m + ", requestType=" + this.n + ", teePublicKey=" + this.o + ", reePublicKey=" + this.p + ", clientCert=" + this.q + ", recordTeePublicKey=" + this.r + ", recordReePublicKey=" + this.s + ", getAltRequestParamsException=" + this.t + ")";
    }

    public final void u(boolean r1) {
        this.f806k = r1;
    }

    public final void v(String r1) {
        this.f801f = r1;
    }

    public final void w(String r1) {
        this.s = r1;
    }

    public final void x(String r1) {
        this.r = r1;
    }

    public final void y(boolean r1) {
        this.f804i = r1;
    }

    public final void z(String r1) {
        this.p = r1;
    }
}
