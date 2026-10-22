package kotlin.jvm.internal;

import a.a;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes2.dex */
public class TypeIntrinsics {
    public static List a(Object r1) {
        if ((r1 instanceof KMappedMarker) == true) goto L5;
    L14:
        return (List) r1;
    L11:
        e = move-exception;
        Intrinsics.j(e, TypeIntrinsics.class.getName());
        throw e;
    L5:
        if ((r1 instanceof KMutableList) == true) goto L14;
        c(r1, "kotlin.collections.MutableList");
        throw null;
    }

    public static void b(int r2, Object r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((r3 instanceof Function) == true) goto L6;
    L80:
        c(r3, "kotlin.jvm.functions.Function" + r2);
        throw null;
    L6:
        if ((r3 instanceof FunctionBase) == false) goto L9;
        int r0 = ((FunctionBase) r3).getArity();
    L78:
        if (r0 != r2) goto L80;
        return;
    L9:
        if ((r3 instanceof Function0) == false) goto L12;
        r0 = 0;
        goto L78
    L12:
        if ((r3 instanceof Function1) == false) goto L15;
        r0 = 1;
        goto L78
    L15:
        if ((r3 instanceof Function2) == false) goto L18;
        r0 = 2;
        goto L78
    L18:
        if ((r3 instanceof Function3) == false) goto L21;
        r0 = 3;
        goto L78
    L21:
        if ((r3 instanceof Function4) == false) goto L24;
        r0 = 4;
        goto L78
    L24:
        if ((r3 instanceof Function5) == false) goto L27;
        r0 = 5;
        goto L78
    L27:
        if ((r3 instanceof Function6) == false) goto L30;
        r0 = 6;
        goto L78
    L30:
        if ((r3 instanceof Function7) == false) goto L33;
        r0 = 7;
        goto L78
    L33:
        if ((r3 instanceof Function8) == false) goto L36;
        r0 = 8;
        goto L78
    L36:
        if ((r3 instanceof Function9) == false) goto L39;
        r0 = 9;
        goto L78
    L39:
        if ((r3 instanceof Function10) == false) goto L42;
        r0 = 10;
        goto L78
    L42:
        if ((r3 instanceof Function11) == false) goto L45;
        r0 = 11;
        goto L78
    L45:
        if ((r3 instanceof Function12) == false) goto L48;
        r0 = 12;
        goto L78
    L48:
        if ((r3 instanceof Function13) == false) goto L51;
        r0 = 13;
        goto L78
    L51:
        if ((r3 instanceof Function14) == false) goto L54;
        r0 = 14;
        goto L78
    L54:
        if ((r3 instanceof Function15) == false) goto L57;
        r0 = 15;
        goto L78
    L57:
        if ((r3 instanceof Function16) == false) goto L60;
        r0 = 16;
        goto L78
    L60:
        if ((r3 instanceof Function17) == false) goto L63;
        r0 = 17;
        goto L78
    L63:
        if ((r3 instanceof Function18) == false) goto L66;
        r0 = 18;
        goto L78
    L66:
        if ((r3 instanceof Function19) == false) goto L69;
        r0 = 19;
        goto L78
    L69:
        if ((r3 instanceof Function20) == false) goto L72;
        r0 = 20;
        goto L78
    L72:
        if ((r3 instanceof Function21) == false) goto L75;
        r0 = 21;
        goto L78
    L75:
        if ((r3 instanceof Function22) == false) goto L77;
        r0 = 22;
        goto L78
    L77:
        r0 = -1;
        goto L78
    }

    public static void c(Object r1, String r2) {
        if (r1 != null) goto L4;
        String r3 = "null";
    L5:
        ClassCastException r4 = new ClassCastException(a.B(r3, " cannot be cast to ", r2));
        Intrinsics.j(r4, TypeIntrinsics.class.getName());
        throw r4;
    L4:
        r3 = r1.getClass().getName();
        goto L5
    }
}
