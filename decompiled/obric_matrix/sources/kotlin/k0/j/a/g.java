package kotlin.k0.j.a;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class g {
    private static final void a(int r3, int r4) {
        if (r4 > r3) goto L5;
        return;
    L5:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + r3 + ", got " + r4 + ". Please update the Kotlin standard library.").toString());
    }

    private static final f b(a r1) {
        return (f) r1.getClass().getAnnotation(f.class);
    }

    private static final int c(a r2) {
        Field r0 = r2.getClass().getDeclaredField("label");     // Catch: Exception -> L11
        r0.setAccessible(true);     // Catch: Exception -> L11
        Object r3 = r0.get(r2);     // Catch: Exception -> L11
        if ((r3 instanceof Integer) == false) goto L5;
        Integer r4 = (Integer) r3;     // Catch: Exception -> L11
    L6:
        if (r4 == null) goto L9;
        int r5 = r4.intValue();     // Catch: Exception -> L11
    L15:
        return r5 - 1;
    L9:
        r5 = 0;
        goto L15
    L5:
        r4 = null;
    L11:
        return -1;
    }

    public static final StackTraceElement d(a r4) {
        o.f(r4, "<this>");
        f r0 = b(r4);
        if (r0 != null) goto L6;
        return null;
    L6:
        a(1, r0.v());
        int r1 = c(r4);
        if (r1 >= 0) goto L9;
        int r2 = -1;
    L10:
        String r5 = i.f18411a.b(r4);
        if (r5 != null) goto L13;
        String r6 = r0.c();
    L15:
        return new StackTraceElement(r6, r0.m(), r0.f(), r2);
    L13:
        r6 = r5 + '/' + r0.c();
        goto L15
    L9:
        r2 = r0.l()[r1];
        goto L10
    }
}
