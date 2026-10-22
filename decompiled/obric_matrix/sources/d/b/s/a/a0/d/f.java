package d.b.s.a.a0.d;

import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import kotlin.u0.k;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14648a = null;

    static final class a extends q implements l<Object, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f14649f;

        a(Object r1) {
            this.f14649f = r1;
            super(1);
        }

        public final String a(Object r3) {
            StringBuilder r0 = new StringBuilder();
            r0.append("  ");
            if (r3 != this.f14649f) goto L5;
            String r2 = "<Self Reference!>";
        L6:
            r0.append(r2);
            return r0.toString();
        L5:
            f r4 = f.f14648a;
            r2 = f.a(r4, r4.c(r3), 2);
            goto L6
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(Object r1) {
            return a(r1);
        }
    }

    static final class b extends q implements l<Object, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f14650f;

        b(Object r1) {
            this.f14650f = r1;
            super(1);
        }

        public final CharSequence a(Object r2) {
            if (r2 != this.f14650f) goto L5;
            return "<Self Reference!>";
        L5:
            f r1 = f.f14648a;
            return f.a(r1, r1.c(r2), 2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Object r1) {
            return a(r1);
        }
    }

    static {
        f14648a = new f();
    }

    private f() {
    }

    public static final /* synthetic */ String a(f r0, String r1, int r2) {
        return r0.d(r1, r2);
    }

    private final String d(String r9, int r10) {
        int r0 = 0;
        if (k.F(r9, "\n", false, 2, null) == true) goto L5;
        return r9;
    L5:
        List r11 = k.n0(r9, new String[]{"\n"}, false, 0, 6, null);
        StringBuilder r1 = new StringBuilder();
        int r2 = r11.size();
    L6:
        if (r0 >= r2) goto L13;
        if (r0 == 0) goto L9;
        r1.append(k.s(" ", r10));
    L9:
        r1.append((String) r11.get(r0));
        if (r0 >= (r11.size() - 1)) goto L12;
        r1.append("\n");
    L12:
        r0 = r0 + 1;
        goto L6
    L13:
        String r8 = r1.toString();
        o.b(r8, "sb.toString()");
        return r8;
    }

    public final String b(u<String, ? extends Object>[] r7) {
        o.g(r7, "params");
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        u<String, ? extends Object> r3 = r7[r2];
        String r4 = r3.a();
        Object r5 = r3.b();
        r0.append(r4);
        r0.append(" = ");
        r0.append(d(c(r5), r4.length() + 3));
        r0.append("\n");
        r2 = r2 + 1;
        goto L3
    L5:
        String r6 = r0.toString();
        o.b(r6, "sb.toString()");
        return r6;
    }

    public final String c(Object r15) {
        String r1 = "java.util.Arrays.toString(this)";
        if ((r15 instanceof Object[]) == false) goto L7;
        String r14 = Arrays.toString((Object[]) r15);
    L5:
        o.b(r14, r1);
        return r14;
    L7:
        if ((r15 instanceof int[]) == false) goto L10;
        r14 = Arrays.toString((int[]) r15);
        goto L5
    L10:
        if ((r15 instanceof boolean[]) == false) goto L13;
        r14 = Arrays.toString((boolean[]) r15);
        goto L5
    L13:
        if ((r15 instanceof char[]) == false) goto L16;
        r14 = Arrays.toString((char[]) r15);
        goto L5
    L16:
        if ((r15 instanceof byte[]) == false) goto L19;
        r14 = Arrays.toString((byte[]) r15);
        goto L5
    L19:
        if ((r15 instanceof short[]) == false) goto L22;
        r14 = Arrays.toString((short[]) r15);
        goto L5
    L22:
        if ((r15 instanceof long[]) == false) goto L25;
        r14 = Arrays.toString((long[]) r15);
        goto L5
    L25:
        if ((r15 instanceof float[]) == false) goto L28;
        r14 = Arrays.toString((float[]) r15);
        goto L5
    L28:
        if ((r15 instanceof double[]) == false) goto L30;
        r14 = Arrays.toString((double[]) r15);
        goto L5
    L30:
        r1 = "value.toString(2)";
        if ((r15 instanceof JSONObject) == false) goto L34;
        r14 = ((JSONObject) r15).toString(2);
        goto L5
    L34:
        if ((r15 instanceof JSONArray) == false) goto L36;
        r14 = ((JSONArray) r15).toString(2);
        goto L5
    L36:
        int r9 = 0;
        if ((r15 instanceof Map) == false) goto L52;
        StringBuilder r0 = new StringBuilder();
        r0.append("{\n");
        Map r10 = (Map) r15;
        Iterator r11 = r10.entrySet().iterator();
    L40:
        if (r11.hasNext() == false) goto L50;
        Map.Entry r12 = (Map.Entry) r11.next();
        Object r13 = r12.getKey();
        Object r16 = r12.getValue();
        r0.append("  ");
        r0.append(r13);
        r0.append(" = ");
        if (r16 != r15) goto L44;
        String r17 = "<Self Reference!>";
    L45:
        r0.append(r17);
        if (r9 != (r10.entrySet().size() - 1)) goto L48;
        String r18 = "";
    L49:
        r0.append(r18);
        r9 = r9 + 1;
        goto L40
    L48:
        r18 = ",\n";
        goto L49
    L44:
        r17 = d(c(r16), 2);
    L50:
        r0.append("\n}");
        String r19 = r0.toString();
        o.b(r19, "sb.toString()");
        return r19;
    L52:
        if ((r15 instanceof Collection) == false) goto L58;
        if (((Collection) r15).size() <= 5) goto L85;
        return r.Z((Iterable) r15, ", \n", "[\n", "\n]", 0, null, new a(r15), 24, null);
    L85:
        return r.Z((Iterable) r15, ", ", "[", "]", 0, null, new b(r15), 24, null);
    L58:
        if ((r15 instanceof Throwable) == false) goto L61;
        String r110 = Log.getStackTraceString((Throwable) r15);
        o.b(r110, "Log.getStackTraceString(value)");
        return r110;
    L61:
        if ((r15 instanceof Bundle) == false) goto L75;
        r0 = new StringBuilder();
        r0.append("Bundle {\n");
        Bundle r111 = (Bundle) r15;
        Set<String> r112 = r111.keySet();
        o.b(r112, "value.keySet()");
        Iterator<T> r113 = r112.iterator();
    L64:
        if (r113.hasNext() == false) goto L50;
        String r114 = (String) r113.next();
        Object r115 = r111.get(r114);
        r0.append("  ");
        r0.append(r114);
        r0.append(" = ");
        if (r115 != r15) goto L68;
        String r116 = "<Self Reference!>";
    L69:
        r0.append(r116);
        if (r9 != (r111.size() - 1)) goto L72;
        String r117 = "";
    L73:
        r0.append(r117);
        r9 = r9 + 1;
        goto L64
    L72:
        r117 = ",\n";
        goto L73
    L68:
        r116 = d(c(r115), 2);
        goto L69
    L75:
        return String.valueOf(r15);
    }
}
