package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements l.b.b.a {
    static final long[] o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f21830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f21832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f21833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f21834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f21835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected long f21836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected long f21837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected long f21838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected long f21839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected long f21840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected long f21841l;
    private long[] m;
    private int n;

    static {
        o = new long[]{4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    }

    protected c() {
        this.f21830a = new byte[8];
        this.m = new long[80];
        this.f21831b = 0;
        r();
    }

    private long g(long r1, long r3, long r5) {
        long r0 = (~r1) & r5;
        return r0 ^ (r3 & r1);
    }

    private long h(long r3, long r5, long r7) {
        long r2 = r3 & r7;
        return (r2 ^ (r3 & r5)) ^ (r5 & r7);
    }

    private long i(long r7) {
        long r6 = r7 >>> 7;
        return r6 ^ (((r7 << 63) | (r7 >>> 1)) ^ ((r7 << 56) | (r7 >>> 8)));
    }

    private long j(long r7) {
        long r6 = r7 >>> 6;
        return r6 ^ (((r7 << 45) | (r7 >>> 19)) ^ ((r7 << 3) | (r7 >>> 61)));
    }

    private long k(long r7) {
        long r0 = ((r7 << 36) | (r7 >>> 28)) ^ ((r7 << 30) | (r7 >>> 34));
        long r6 = r7 >>> 39;
        return (r6 | (r7 << 25)) ^ r0;
    }

    private long l(long r7) {
        long r0 = ((r7 << 50) | (r7 >>> 14)) ^ ((r7 << 46) | (r7 >>> 18));
        long r6 = r7 >>> 41;
        return (r6 | (r7 << 23)) ^ r0;
    }

    private void m() {
        long r0 = this.f21832c;
        if (r0 <= 2305843009213693951L) goto L6;
        this.f21833d += r0 >>> 61;
        this.f21832c = r0 & 2305843009213693951L;
        return;
    }

    @Override // l.b.b.a
    public void b(byte[] r6, int r7, int r8) {
    L3:
        if (this.f21831b == 0) goto L7;
        if (r8 <= 0) goto L7;
        c(r6[r7]);
        r7 = r7 + 1;
        r8 = r8 - 1;
    L7:
        if (r8 <= this.f21830a.length) goto L9;
        q(r6, r7);
        byte[] r0 = this.f21830a;
        r7 = r7 + r0.length;
        r8 = r8 - r0.length;
        this.f21832c += (long) r0.length;
    L9:
        if (r8 <= 0) goto L11;
        c(r6[r7]);
        r7 = r7 + 1;
        r8 = r8 - 1;
        goto L9
    }

    @Override // l.b.b.a
    public void c(byte r5) {
        byte[] r0 = this.f21830a;
        int r1 = this.f21831b;
        int r2 = r1 + 1;
        this.f21831b = r2;
        r0[r1] = r5;
        if (r2 != r0.length) goto L5;
        q(r0, 0);
        this.f21831b = 0;
    L5:
        this.f21832c++;
    }

    public void n() {
        m();
        long r0 = this.f21832c << 3;
        long r2 = this.f21833d;
        byte r4 = -128;
    L3:
        c(r4);
        if (this.f21831b == 0) goto L6;
        r4 = 0;
        goto L3
    L6:
        p(r0, r2);
        o();
    }

    protected void o() {
        m();
        int r0 = 16;
    L4:
        if (r0 > 79) goto L6;
        long[] r1 = this.m;
        long r2 = j(r1[r0 - 2]);
        long[] r4 = this.m;
        r1[r0] = ((r2 + r4[r0 - 7]) + i(r4[r0 - 15])) + this.m[r0 - 16];
        r0 = r0 + 1;
        goto L4
    L6:
        long r3 = this.f21834e;
        long r5 = this.f21835f;
        long r6 = this.f21836g;
        long r9 = this.f21837h;
        long r11 = this.f21838i;
        long r13 = this.f21839j;
        long r8 = this.f21840k;
        long r21 = r13;
        long r19 = r9;
        int r23 = 0;
        long r14 = r5;
        long r15 = r6;
        long r7 = r11;
        int r10 = 0;
        long r12 = this.f21841l;
        long r16 = r3;
        long r17 = r8;
    L8:
        if (r10 >= 10) goto L10;
        long r27 = r7;
        long r24 = l(r7) + g(r7, r21, r17);
        long[] r29 = o;
        int r30 = r23 + 1;
        long r18 = r12 + ((r24 + r29[r23]) + this.m[r23]);
        long r20 = r19 + r18;
        long r110 = r18 + (k(r16) + h(r16, r14, r15));
        int r25 = r30 + 1;
        long r111 = r17 + (((l(r20) + g(r20, r27, r21)) + r29[r30]) + this.m[r30]);
        long r22 = r15 + r111;
        long r26 = r111 + (k(r110) + h(r110, r16, r14));
        int r112 = r25 + 1;
        long r28 = r21 + (((l(r22) + g(r22, r20, r27)) + r29[r25]) + this.m[r25]);
        long r113 = r14 + r28;
        long r31 = r28 + (k(r26) + h(r26, r110, r16));
        int r210 = r112 + 1;
        long r114 = r27 + (((l(r113) + g(r113, r22, r20)) + r29[r112]) + this.m[r112]);
        long r32 = r16 + r114;
        long r33 = r114 + (k(r31) + h(r31, r26, r110));
        int r115 = r210 + 1;
        long r116 = r20 + (((l(r32) + g(r32, r113, r22)) + r29[r210]) + this.m[r210]);
        long r34 = r110 + r116;
        long r35 = r116 + (k(r33) + h(r33, r31, r26));
        int r211 = r115 + 1;
        long r117 = r22 + (((l(r34) + g(r34, r32, r113)) + r29[r115]) + this.m[r115]);
        long r118 = r26 + r117;
        long r36 = r117 + (k(r35) + h(r35, r33, r31));
        r17 = r118;
        int r119 = r211 + 1;
        long r120 = r113 + (((l(r118) + g(r118, r34, r32)) + r29[r211]) + this.m[r211]);
        long r37 = r31 + r120;
        r21 = r37;
        r14 = r120 + (k(r36) + h(r36, r35, r33));
        long r121 = r32 + (((l(r37) + g(r37, r17, r34)) + r29[r119]) + this.m[r119]);
        long r38 = r121 + (k(r14) + h(r14, r36, r35));
        r10 = r10 + 1;
        r7 = r33 + r121;
        r15 = r36;
        r12 = r34;
        r19 = r35;
        r23 = r119 + 1;
        r16 = r38;
        goto L8
    L10:
        this.f21834e += r16;
        this.f21835f += r14;
        this.f21836g += r15;
        this.f21837h += r19;
        this.f21838i = this.f21838i + r7;
        this.f21839j += r21;
        this.f21840k += r17;
        this.f21841l += r12;
        this.n = 0;
        int r122 = 0;
    L11:
        if (r122 >= 16) goto L13;
        this.m[r122] = 0;
        r122 = r122 + 1;
        goto L11
    }

    protected void p(long r3, long r5) {
        if (this.n <= 14) goto L5;
        o();
    L5:
        long[] r2 = this.m;
        r2[14] = r5;
        r2[15] = r3;
    }

    protected void q(byte[] r3, int r4) {
        this.m[this.n] = l.b.h.e.b(r3, r4);
        int r5 = this.n + 1;
        this.n = r5;
        if (r5 != 16) goto L6;
        o();
        return;
    }

    public void r() {
        this.f21832c = 0;
        this.f21833d = 0;
        int r2 = 0;
        this.f21831b = 0;
        int r3 = 0;
    L3:
        byte[] r4 = this.f21830a;
        if (r3 >= r4.length) goto L6;
        r4[r3] = 0;
        r3 = r3 + 1;
        goto L3
    L6:
        this.n = 0;
    L7:
        long[] r5 = this.m;
        if (r2 == r5.length) goto L10;
        r5[r2] = 0;
        r2 = r2 + 1;
        goto L7
    }
}
