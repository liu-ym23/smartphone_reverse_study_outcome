package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TypesJVMKt {

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345a = null;

        static {
            int[] r0 = new int[KVariance.values().length];
            r0[1] = 1;
            r0[0] = 2;
            r0[2] = 3;
            f345a = r0;
        }
    }

    public static final String a(Type r4) {
        if ((r4 instanceof Class) == false) goto L26;
        Class r0 = (Class) r4;
        if (r0.isArray() == false) goto L23;
        Sequence r5 = SequencesKt.c(r4, TypesJVMKt$typeToString$unwrap$1.e);
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = r5.iterator();
        if (r2.hasNext() == false) goto L22;
        Object r3 = r2.next();
    L10:
        if (r2.hasNext() == false) goto L12;
        r3 = r2.next();
        goto L10
    L12:
        r1.append(((Class) r3).getName());
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L14:
        if (r6.hasNext() == false) goto L20;
        r6.next();
        r7 = r7 + 1;
        if (r7 >= 0) goto L14;
        throw new ArithmeticException("Count overflow has happened.");
    L20:
        r1.append(StringsKt.A(r7, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
        String r8 = r1.toString();
    L24:
        Intrinsics.e(r8, "{\n        if (type.isArr…   } else type.name\n    }");
        return r8;
    L22:
        throw new NoSuchElementException("Sequence is empty.");
    L23:
        r8 = r0.getName();
        goto L24
    L26:
        return r4.toString();
    }

    public static final Type b(Class r4, List r5) {
        Class<?> r0 = r4.getDeclaringClass();
        if (r0 != null) goto L11;
        ArrayList r1 = new ArrayList(CollectionsKt.e(r5, 10));
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        r1.add(c((KTypeProjection) r6.next()));
        goto L6
    L9:
        return new ParameterizedTypeImpl(r4, null, r1);
    L11:
        if (Modifier.isStatic(r4.getModifiers()) == false) goto L18;
        ArrayList r2 = new ArrayList(CollectionsKt.e(r5, 10));
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        r2.add(c((KTypeProjection) r7.next()));
        goto L14
    L17:
        return new ParameterizedTypeImpl(r4, r0, r2);
    L18:
        int r3 = r4.getTypeParameters().length;
        Type r8 = b(r0, r5.subList(r3, r5.size()));
        List r9 = r5.subList(0, r3);
        ArrayList r10 = new ArrayList(CollectionsKt.e(r9, 10));
        Iterator r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L23;
        r10.add(c((KTypeProjection) r11.next()));
        goto L20
    L23:
        return new ParameterizedTypeImpl(r4, r8, r10);
    }

    public static final Type c(KTypeProjection r0) {
        r0.getClass();
        return WildcardTypeImpl.e;
    }
}
