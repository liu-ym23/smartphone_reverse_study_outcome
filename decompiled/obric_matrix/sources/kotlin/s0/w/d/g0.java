package kotlin.s0.w.d;

import java.lang.reflect.Method;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class g0 {

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<Class<?>, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18550f = null;

        static {
            f18550f = new a();
        }

        a() {
            super(1);
        }

        public final CharSequence a(Class<?> r1) {
            kotlin.n0.d.o.e(r1, "it");
            return kotlin.s0.w.d.l0.c.s1.b.d.b(r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Class<?> r1) {
            return a(r1);
        }
    }

    public static final /* synthetic */ String a(Method r0) {
        return b(r0);
    }

    private static final String b(Method r11) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r11.getName());
        Class<?>[] r2 = r11.getParameterTypes();
        kotlin.n0.d.o.e(r2, "parameterTypes");
        r0.append(kotlin.i0.i.N(r2, "", "(", ")", 0, null, a.f18550f, 24, null));
        Class<?> r12 = r11.getReturnType();
        kotlin.n0.d.o.e(r12, "returnType");
        r0.append(kotlin.s0.w.d.l0.c.s1.b.d.b(r12));
        return r0.toString();
    }
}
