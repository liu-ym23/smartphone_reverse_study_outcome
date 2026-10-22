package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ModuleNameRetriever {
    public static final ModuleNameRetriever INSTANCE = null;
    private static Cache cache;
    private static final Cache notOnJava9 = null;

    /* JADX INFO: compiled from: DebugMetadata.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method r1, Method r2, Method r3) {
            this.getModuleMethod = r1;
            this.getDescriptorMethod = r2;
            this.nameMethod = r3;
        }
    }

    private ModuleNameRetriever() {
    }

    static {
        INSTANCE = new ModuleNameRetriever();
        notOnJava9 = new Cache(null, null, null);
    }

    public final String getModuleName(BaseContinuationImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "continuation");
        Cache r0 = cache;
        if (r0 != null) goto L6;
        r0 = buildCache(r5);
    L6:
        if (r0 != notOnJava9) goto L8;
        return null;
    L8:
        Method r4 = r0.getModuleMethod;
        if (r4 == null) goto L11;
        Object r6 = r4.invoke(r5.getClass(), new Object[0]);
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        Method r7 = r0.getDescriptorMethod;
        if (r7 == null) goto L17;
        Object r8 = r7.invoke(r6, new Object[0]);
    L18:
        if (r8 != null) goto L20;
        return null;
    L20:
        Method r9 = r0.nameMethod;
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

    private final Cache buildCache(BaseContinuationImpl r5) {
        Cache r1 = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), r5.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), r5.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));     // Catch: Exception -> L4
        cache = r1;     // Catch: Exception -> L4
        return r1;
    L4:
        Cache r4 = notOnJava9;
        cache = r4;
        return r4;
    }
}
