package com.obric.matrix.common_ui.utils;

import android.app.Application;
import androidx.annotation.DimenRes;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bb\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0010\u0010g\u001a\u00020h2\b\b\u0001\u0010i\u001a\u00020\u0005\u001a\u0010\u0010j\u001a\u00020\u00052\b\b\u0001\u0010i\u001a\u00020\u0005\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007\"\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007\"\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007\"\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007\"\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007\"\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007\"\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007\"\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007\"\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007\"\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b&\u0010\u0007\"\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b)\u0010\u0007\"\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007\"\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b/\u0010\u0007\"\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b2\u0010\u0007\"\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\u0007\"\u001b\u00107\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007\"\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b;\u0010\u0007\"\u001b\u0010=\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b>\u0010\u0007\"\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bA\u0010\u0007\"\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007\"\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010\u0007\"\u001b\u0010I\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010\u0007\"\u001b\u0010L\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010\u0007\"\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bP\u0010\u0007\"\u001b\u0010R\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bS\u0010\u0007\"\u001b\u0010U\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bV\u0010\u0007\"\u001b\u0010X\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\bY\u0010\u0007\"\u001b\u0010[\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b\\\u0010\u0007\"\u001b\u0010^\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\t\u001a\u0004\b_\u0010\u0007\"\u001b\u0010a\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\t\u001a\u0004\bb\u0010\u0007\"\u001b\u0010d\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\be\u0010\u0007¨\u0006k"}, d2 = {"application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "dp_1", "", "getDp_1", "()I", "dp_1$delegate", "Lkotlin/Lazy;", "dp_10", "getDp_10", "dp_10$delegate", "dp_104", "getDp_104", "dp_104$delegate", "dp_12", "getDp_12", "dp_12$delegate", "dp_14", "getDp_14", "dp_14$delegate", "dp_146", "getDp_146", "dp_146$delegate", "dp_15", "getDp_15", "dp_15$delegate", "dp_16", "getDp_16", "dp_16$delegate", "dp_164", "getDp_164", "dp_164$delegate", "dp_17", "getDp_17", "dp_17$delegate", "dp_18", "getDp_18", "dp_18$delegate", "dp_2", "getDp_2", "dp_2$delegate", "dp_200", "getDp_200", "dp_200$delegate", "dp_22", "getDp_22", "dp_22$delegate", "dp_24", "getDp_24", "dp_24$delegate", "dp_250", "getDp_250", "dp_250$delegate", "dp_28", "getDp_28", "dp_28$delegate", "dp_3", "getDp_3", "dp_3$delegate", "dp_312", "getDp_312", "dp_312$delegate", "dp_32", "getDp_32", "dp_32$delegate", "dp_36", "getDp_36", "dp_36$delegate", "dp_4", "getDp_4", "dp_4$delegate", "dp_44", "getDp_44", "dp_44$delegate", "dp_48", "getDp_48", "dp_48$delegate", "dp_5", "getDp_5", "dp_5$delegate", "dp_50", "getDp_50", "dp_50$delegate", "dp_52", "getDp_52", "dp_52$delegate", "dp_58", "getDp_58", "dp_58$delegate", "dp_6", "getDp_6", "dp_6$delegate", "dp_60", "getDp_60", "dp_60$delegate", "dp_76", "getDp_76", "dp_76$delegate", "dp_8", "getDp_8", "dp_8$delegate", "resDimension", "", "id", "resDimensionPixelSize", "common_ui_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {
    private static final kotlin.h A = null;
    private static final kotlin.h B = null;
    private static final kotlin.h C = null;
    private static final kotlin.h D = null;
    private static final kotlin.h E = null;
    private static final kotlin.h F = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.h f8961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f8962b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.h f8963c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.h f8964d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlin.h f8965e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.h f8966f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.h f8967g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final kotlin.h f8968h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final kotlin.h f8969i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final kotlin.h f8970j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final kotlin.h f8971k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final kotlin.h f8972l = null;
    private static final kotlin.h m = null;
    private static final kotlin.h n = null;
    private static final kotlin.h o = null;
    private static final kotlin.h p = null;
    private static final kotlin.h q = null;
    private static final kotlin.h r = null;
    private static final kotlin.h s = null;
    private static final kotlin.h t = null;
    private static final kotlin.h u = null;
    private static final kotlin.h v = null;
    private static final kotlin.h w = null;
    private static final kotlin.h x = null;
    private static final kotlin.h y = null;
    private static final kotlin.h z = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8973f = null;

        static {
            f8973f = new a();
        }

        a() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16736a));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a0 extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a0 f8974f = null;

        static {
            f8974f = new a0();
        }

        a0() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.B));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f8975f = null;

        static {
            f8975f = new b();
        }

        b() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16737b));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b0 extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b0 f8976f = null;

        static {
            f8976f = new b0();
        }

        b0() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.C));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.common_ui.utils.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0241c extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0241c f8977f = null;

        static {
            f8977f = new C0241c();
        }

        C0241c() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16738c));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c0 extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c0 f8978f = null;

        static {
            f8978f = new c0();
        }

        c0() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.D));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f8979f = null;

        static {
            f8979f = new d();
        }

        d() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16739d));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d0 extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d0 f8980f = null;

        static {
            f8980f = new d0();
        }

        d0() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.E));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f8981f = null;

        static {
            f8981f = new e();
        }

        e() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16740e));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e0 extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e0 f8982f = null;

        static {
            f8982f = new e0();
        }

        e0() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.F));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f8983f = null;

        static {
            f8983f = new f();
        }

        f() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16741f));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class f0 extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f0 f8984f = null;

        static {
            f8984f = new f0();
        }

        f0() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.G));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g f8985f = null;

        static {
            f8985f = new g();
        }

        g() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16742g));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class h extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f8986f = null;

        static {
            f8986f = new h();
        }

        h() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16743h));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class i extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final i f8987f = null;

        static {
            f8987f = new i();
        }

        i() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16744i));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class j extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final j f8988f = null;

        static {
            f8988f = new j();
        }

        j() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16745j));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class k extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final k f8989f = null;

        static {
            f8989f = new k();
        }

        k() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16746k));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class l extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final l f8990f = null;

        static {
            f8990f = new l();
        }

        l() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.f16747l));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class m extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final m f8991f = null;

        static {
            f8991f = new m();
        }

        m() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.n));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class n extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final n f8992f = null;

        static {
            f8992f = new n();
        }

        n() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.o));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class o extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final o f8993f = null;

        static {
            f8993f = new o();
        }

        o() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.p));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class p extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final p f8994f = null;

        static {
            f8994f = new p();
        }

        p() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.q));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class q extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final q f8995f = null;

        static {
            f8995f = new q();
        }

        q() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.r));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class r extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final r f8996f = null;

        static {
            f8996f = new r();
        }

        r() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.s));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class s extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final s f8997f = null;

        static {
            f8997f = new s();
        }

        s() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.t));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class t extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final t f8998f = null;

        static {
            f8998f = new t();
        }

        t() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.u));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class u extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final u f8999f = null;

        static {
            f8999f = new u();
        }

        u() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.v));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class v extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final v f9000f = null;

        static {
            f9000f = new v();
        }

        v() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.w));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class w extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final w f9001f = null;

        static {
            f9001f = new w();
        }

        w() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.x));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class x extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final x f9002f = null;

        static {
            f9002f = new x();
        }

        x() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.y));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class y extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final y f9003f = null;

        static {
            f9003f = new y();
        }

        y() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.z));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class z extends kotlin.n0.d.q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final z f9004f = null;

        static {
            f9004f = new z();
        }

        z() {
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(c.c(d.g.c.a.a.A));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    static {
        f8961a = kotlin.i.b(a.f8973f);
        f8962b = kotlin.i.b(l.f8990f);
        f8963c = kotlin.i.b(r.f8996f);
        f8964d = kotlin.i.b(v.f9000f);
        f8965e = kotlin.i.b(y.f9003f);
        f8966f = kotlin.i.b(c0.f8978f);
        f8967g = kotlin.i.b(f0.f8984f);
        f8968h = kotlin.i.b(b.f8975f);
        f8969i = kotlin.i.b(d.f8979f);
        f8970j = kotlin.i.b(e.f8981f);
        f8971k = kotlin.i.b(g.f8985f);
        f8972l = kotlin.i.b(h.f8986f);
        m = kotlin.i.b(j.f8988f);
        n = kotlin.i.b(k.f8989f);
        o = kotlin.i.b(n.f8992f);
        p = kotlin.i.b(o.f8993f);
        q = kotlin.i.b(q.f8995f);
        r = kotlin.i.b(t.f8998f);
        s = kotlin.i.b(u.f8999f);
        t = kotlin.i.b(w.f9001f);
        u = kotlin.i.b(x.f9002f);
        v = kotlin.i.b(z.f9004f);
        w = kotlin.i.b(a0.f8974f);
        x = kotlin.i.b(b0.f8976f);
        y = kotlin.i.b(d0.f8980f);
        z = kotlin.i.b(e0.f8982f);
        A = kotlin.i.b(C0241c.f8977f);
        B = kotlin.i.b(f.f8983f);
        C = kotlin.i.b(i.f8987f);
        D = kotlin.i.b(m.f8991f);
        E = kotlin.i.b(p.f8994f);
        F = kotlin.i.b(s.f8997f);
    }

    private static final Application a() {
        return d.g.f.a.a.f16974a.c();
    }

    public static final float b(@DimenRes int r1) {
        return a().getResources().getDimension(r1);
    }

    public static final int c(@DimenRes int r1) {
        return a().getResources().getDimensionPixelSize(r1);
    }
}
