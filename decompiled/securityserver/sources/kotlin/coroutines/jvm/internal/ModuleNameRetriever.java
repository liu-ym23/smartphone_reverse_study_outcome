package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ModuleNameRetriever {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Cache f337a = null;
    public static Cache b;

    @Metadata
    public static final class Cache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f338a;
        public final Method b;
        public final Method c;

        public Cache(Method r1, Method r2, Method r3) {
            this.f338a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        f337a = new Cache(null, null, null);
    }
}
