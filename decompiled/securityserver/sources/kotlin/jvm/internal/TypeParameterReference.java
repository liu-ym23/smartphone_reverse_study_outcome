package kotlin.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final class TypeParameterReference implements KTypeParameter {
    public volatile List b;

    @Metadata
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] r0 = new int[KVariance.values().length];
                r0[0] = 1;
                r0[1] = 2;
                r0[2] = 3;
            }
        }
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof TypeParameterReference) == false) goto L9;
        TypeParameterReference r3 = (TypeParameterReference) r2;
        r3.getClass();
        if (Intrinsics.a(null, null) == false) goto L9;
        r3.getClass();
        if (Intrinsics.a(null, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final List getUpperBounds() {
        List r0 = this.b;
        if (r0 != null) goto L6;
        ClassReference r1 = Reflection.a(Object.class);
        List r2 = Collections.emptyList();
        Reflection.f343a.getClass();
        List r3 = CollectionsKt.j(new TypeReference(r1, r2));
        this.b = r3;
        return r3;
    L6:
        return r0;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
