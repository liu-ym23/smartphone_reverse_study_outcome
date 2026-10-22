package kotlin.k0.j.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", LocationMonitorConst.CACHE, "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f18411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f18412b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f18413c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f18414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f18415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f18416c;

        public a(Method r1, Method r2, Method r3) {
            this.f18414a = r1;
            this.f18415b = r2;
            this.f18416c = r3;
        }
    }

    static {
        f18411a = new i();
        f18412b = new a(null, null, null);
    }

    private i() {
    }

    private final a a(kotlin.k0.j.a.a r5) {
        a r1 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), r5.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), r5.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));     // Catch: Exception -> L4
        f18413c = r1;     // Catch: Exception -> L4
        return r1;
    L4:
        a r4 = f18412b;
        f18413c = r4;
        return r4;
    }

    public final String b(kotlin.k0.j.a.a r5) {
        o.f(r5, "continuation");
        a r0 = f18413c;
        if (r0 != null) goto L6;
        r0 = a(r5);
    L6:
        if (r0 != f18412b) goto L8;
        return null;
    L8:
        Method r4 = r0.f18414a;
        if (r4 == null) goto L11;
        Object r6 = r4.invoke(r5.getClass(), new Object[0]);
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        Method r7 = r0.f18415b;
        if (r7 == null) goto L17;
        Object r8 = r7.invoke(r6, new Object[0]);
    L18:
        if (r8 != null) goto L20;
        return null;
    L20:
        Method r9 = r0.f18416c;
        if (r9 == null) goto L23;
        Object r10 = r9.invoke(r8, new Object[0]);
    L25:
        if ((r10 instanceof String) == true) goto L27;
        return null;
    L27:
        return (String) r10;
    L23:
        r10 = null;
        goto L25
    L17:
        r8 = null;
        goto L18
    L11:
        r6 = null;
        goto L12
    }
}
