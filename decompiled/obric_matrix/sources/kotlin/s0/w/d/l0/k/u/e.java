package kotlin.s0.w.d.l0.k.u;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.s0.w.d.l0.b.i;

/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f20606j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f20607k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f20608l = null;
    public static final e m = null;
    public static final e n = null;
    public static final e o = null;
    public static final e p = null;
    public static final e q = null;
    private static final Set<kotlin.s0.w.d.l0.g.c> r = null;
    private static final Map<String, e> s = null;
    private static final Map<i, e> t = null;
    private static final Map<String, e> u = null;
    private static final /* synthetic */ e[] v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f20609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f20610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f20611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f20612i;

    static {
        e r7 = new e("BOOLEAN", 0, i.f18690k, TypedValues.Custom.S_BOOLEAN, "Z", "java.lang.Boolean");
        f20606j = r7;
        e r0 = new e("CHAR", 1, i.f18691l, "char", "C", "java.lang.Character");
        f20607k = r0;
        e r1 = new e("BYTE", 2, i.m, "byte", "B", "java.lang.Byte");
        f20608l = r1;
        e r2 = new e("SHORT", 3, i.n, "short", "S", "java.lang.Short");
        m = r2;
        e r3 = new e("INT", 4, i.o, "int", "I", "java.lang.Integer");
        n = r3;
        e r4 = new e("FLOAT", 5, i.p, TypedValues.Custom.S_FLOAT, "F", "java.lang.Float");
        o = r4;
        e r5 = new e("LONG", 6, i.q, "long", "J", "java.lang.Long");
        p = r5;
        e r6 = new e("DOUBLE", 7, i.r, "double", "D", "java.lang.Double");
        q = r6;
        int r9 = 0;
        v = new e[]{r7, r0, r1, r2, r3, r4, r5, r6};
        r = new HashSet();
        s = new HashMap();
        t = new EnumMap(i.class);
        u = new HashMap();
        e[] r8 = values();
        int r10 = r8.length;
    L3:
        if (r9 >= r10) goto L5;
        e r11 = r8[r9];
        r.add(r11.l());
        s.put(r11.j(), r11);
        t.put(r11.k(), r11);
        u.put(r11.g(), r11);
        r9 = r9 + 1;
        goto L3
    }

    private e(String r2, int r3, i r4, String r5, String r6, String r7) {
        if (r4 == null) goto L15;
        if (r5 == null) goto L13;
        if (r6 == null) goto L11;
        if (r7 == null) goto L9;
        super(r2, r3);
        this.f20609f = r4;
        this.f20610g = r5;
        this.f20611h = r6;
        this.f20612i = new kotlin.s0.w.d.l0.g.c(r7);
        return;
    L9:
        a(9);
        throw null;
    L11:
        a(8);
        throw null;
    L13:
        a(7);
        throw null;
    L15:
        a(6);
        throw null;
    }

    private static /* synthetic */ void a(int r7) {
        if (r7 == 2) goto L7;
        if (r7 == 4) goto L7;
        switch(r7) {
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L6;
        };
    L6:
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r7 == 2) goto L12;
        if (r7 == 4) goto L44;
        switch(r7) {
            case 10: goto L45;
            case 11: goto L45;
            case 12: goto L45;
            case 13: goto L45;
            default: goto L11;
        };
    L11:
        int r3 = 3;
    L13:
        Object[] r4 = new Object[r3];
        switch(r7) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L21;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L20;
            case 13: goto L20;
            default: goto L15;
        };
    L15:
        r4[0] = "className";
    L23:
        if (r7 == 2) goto L31;
        if (r7 == 4) goto L31;
        switch(r7) {
            case 10: goto L30;
            case 11: goto L29;
            case 12: goto L28;
            case 13: goto L27;
            default: goto L26;
        };
    L26:
        r4[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
    L32:
        switch(r7) {
            case 1: goto L36;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L34;
            case 8: goto L34;
            case 9: goto L34;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L37;
            case 13: goto L37;
            default: goto L33;
        };
    L33:
        r4[2] = "isWrapperClassName";
        goto L37
    L34:
        r4[2] = "<init>";
        goto L37
    L35:
        r4[2] = "getByDesc";
        goto L37
    L36:
        r4[2] = "get";
    L37:
        String r5 = String.format(r2, r4);
        if (r7 == 2) goto L43;
        if (r7 == 4) goto L43;
        switch(r7) {
            case 10: goto L43;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L43;
            default: goto L46;
        };
    L46:
        throw new IllegalArgumentException(r5);
    L43:
        throw new IllegalStateException(r5);
    L27:
        r4[1] = "getWrapperFqName";
        goto L32
    L28:
        r4[1] = "getDesc";
        goto L32
    L29:
        r4[1] = "getJavaKeywordName";
        goto L32
    L30:
        r4[1] = "getPrimitiveType";
    L31:
        r4[1] = "get";
        goto L32
    L16:
        r4[0] = "wrapperClassName";
        goto L23
    L17:
        r4[0] = "primitiveType";
        goto L23
    L18:
        r4[0] = "desc";
        goto L23
    L19:
        r4[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L23
    L20:
        r4[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
        goto L23
    L21:
        r4[0] = "name";
        goto L23
    L45:
        r3 = 2;
        goto L13
    L44:
        r3 = 2;
        goto L13
    L12:
        r3 = 2;
    L7:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public static e b(String r3) {
        if (r3 == null) goto L12;
        e r1 = s.get(r3);
        if (r1 == null) goto L11;
        if (r1 == null) goto L8;
        return r1;
    L8:
        a(2);
        throw null;
    L11:
        throw new AssertionError("Non-primitive type name passed: " + r3);
    L12:
        a(1);
        throw null;
    }

    public static e c(i r2) {
        if (r2 == null) goto L9;
        e r3 = t.get(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        a(4);
        throw null;
    L9:
        a(3);
        throw null;
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) v.clone();
    }

    public String g() {
        String r0 = this.f20611h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(12);
        throw null;
    }

    public String j() {
        String r0 = this.f20610g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(11);
        throw null;
    }

    public i k() {
        i r0 = this.f20609f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(10);
        throw null;
    }

    public kotlin.s0.w.d.l0.g.c l() {
        kotlin.s0.w.d.l0.g.c r0 = this.f20612i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(13);
        throw null;
    }
}
