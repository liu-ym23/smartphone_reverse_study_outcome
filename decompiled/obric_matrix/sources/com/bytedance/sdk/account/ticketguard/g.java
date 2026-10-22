package com.bytedance.sdk.account.ticketguard;

import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f5796i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f5801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f5802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f5803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f5804h;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.sdk.account.ticketguard.g$a$a, reason: collision with other inner class name */
        static final class C0186a extends q implements p<String, Boolean, Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ JSONObject f5805f;

            C0186a(JSONObject r1) {
                this.f5805f = r1;
                super(2);
            }

            public final boolean a(String r2, boolean r3) {
                o.g(r2, "key");
                return this.f5805f.optBoolean(r2, r3);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Boolean invoke(String r1, Boolean r2) {
                return Boolean.valueOf(a(r1, r2.booleanValue()));
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final g a(JSONObject r10, g r11) {
            o.g(r11, "defaultConfig");
            if (r10 != null) goto L5;
            return r11;
        L5:
            C0186a r9 = new C0186a(r10);
            boolean r1 = r9.a("enable", false);
            if (r1 == true) goto L8;
        L10:
            boolean r2 = false;
        L11:
            if (r1 == true) goto L13;
        L15:
            boolean r3 = false;
        L16:
            if (r1 == true) goto L18;
        L20:
            boolean r4 = false;
        L21:
            if (r1 == true) goto L23;
        L25:
            boolean r5 = false;
        L26:
            if (r1 == true) goto L28;
        L30:
            boolean r6 = false;
        L31:
            if (r1 == true) goto L33;
        L35:
            boolean r7 = false;
        L36:
            if (r1 == true) goto L38;
        L40:
            boolean r8 = false;
        L42:
            return new g(r1, r2, r3, r4, r5, r6, r7, r8);
        L38:
            if (r9.a("enable_hmac_cache", true) == false) goto L40;
            r8 = true;
            goto L42
        L33:
            if (r9.a("enable_new_init_callback", true) == false) goto L35;
            r7 = true;
            goto L36
        L28:
            if (r9.a("enable_ticket_init_refactor", true) == false) goto L30;
            r6 = true;
            goto L31
        L23:
            if (r9.a("enable_tee_ree_parallel", true) == false) goto L25;
            r5 = true;
            goto L26
        L18:
            if (r9.a("enable_pre_init_in_account_init", true) == false) goto L20;
            r4 = true;
            goto L21
        L13:
            if (r9.a("enable_high_thread_priority", true) == false) goto L15;
            r3 = true;
            goto L16
        L8:
            if (r9.a("enable_service_pre_init", true) == false) goto L10;
            r2 = true;
            goto L11
        }
    }

    static {
        f5796i = new a(null);
    }

    public g() {
        this(false, false, false, false, false, false, false, false, 255, null);
    }

    public g(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        this.f5797a = r1;
        this.f5798b = r2;
        this.f5799c = r3;
        this.f5800d = r4;
        this.f5801e = r5;
        this.f5802f = r6;
        this.f5803g = r7;
        this.f5804h = r8;
    }

    public /* synthetic */ g(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, kotlin.n0.d.g r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = false;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = false;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = false;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = false;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = false;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static final g i(JSONObject r1, g r2) {
        return f5796i.a(r1, r2);
    }

    public final boolean a() {
        return this.f5797a;
    }

    public final boolean b() {
        return this.f5799c;
    }

    public final boolean c() {
        return this.f5804h;
    }

    public final boolean d() {
        return this.f5803g;
    }

    public final boolean e() {
        return this.f5800d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L48:
        return true;
    L5:
        if ((r5 instanceof g) == false) goto L47;
        g r6 = (g) r5;
        if (this.f5797a != r6.f5797a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L47;
        if (this.f5798b != r6.f5798b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L47;
        if (this.f5799c != r6.f5799c) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L47;
        if (this.f5800d != r6.f5800d) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L47;
        if (this.f5801e != r6.f5801e) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == false) goto L47;
        if (this.f5802f != r6.f5802f) goto L34;
        boolean r8 = true;
    L35:
        if (r8 == false) goto L47;
        if (this.f5803g != r6.f5803g) goto L39;
        boolean r9 = true;
    L40:
        if (r9 == false) goto L47;
        if (this.f5804h != r6.f5804h) goto L44;
        boolean r10 = true;
    L45:
        if (r10 == false) goto L47;
    L44:
        r10 = false;
        goto L45
    L39:
        r9 = false;
        goto L40
    L34:
        r8 = false;
        goto L35
    L29:
        r7 = false;
        goto L30
    L24:
        r4 = false;
        goto L25
    L19:
        r3 = false;
        goto L20
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L47:
        return false;
    }

    public final boolean f() {
        return this.f5798b;
    }

    public final boolean g() {
        return this.f5801e;
    }

    public final boolean h() {
        return this.f5802f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean r0 = this.f5797a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.f5798b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.f5799c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.f5800d;
        ?? r11 = r10;
        if (r10 == false) goto L14;
        r11 = 1;
    L14:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.f5801e;
        ?? r14 = r13;
        if (r13 == false) goto L17;
        r14 = 1;
    L17:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.f5802f;
        ?? r17 = r16;
        if (r16 == false) goto L20;
        r17 = 1;
    L20:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.f5803g;
        ?? r20 = r19;
        if (r19 == false) goto L23;
        r20 = 1;
    L23:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.f5804h;
        if (r22 == true) goto L28;
        r1 = r22;
    L28:
        return r21 + r1;
    }

    public String toString() {
        return "TokenInitOptConfig(enable=" + this.f5797a + ", enableServicePreInit=" + this.f5798b + ", enableHighThreadPriorityInit=" + this.f5799c + ", enablePreInitInAccountInit=" + this.f5800d + ", enableTeeReeParallelInit=" + this.f5801e + ", enableTicketInitRefactor=" + this.f5802f + ", enableNewInitCallback=" + this.f5803g + ", enableHmacCache=" + this.f5804h + ")";
    }
}
