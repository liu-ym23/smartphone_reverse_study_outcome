package vu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f22651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f22652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22653c;

    public a(List r5, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r5 = new ArrayList();
    L5:
        Intrinsics.checkNotNullParameter(r5, "_values");
        this.f22651a = r5;
        this.f22652b = null;
    }

    public final Object a(KClass r5) {
        int r10 = this.f22653c;
        List r11 = this.f22651a;
        Object r12 = r11.get(r10);
        Object r13 = null;
        if (r5.isInstance(r12) == true) goto L6;
        r12 = null;
    L6:
        if (r12 == null) goto L8;
        r13 = r12;
    L8:
        if (r13 != null) goto L10;
    L12:
        return r13;
    L10:
        if (this.f22653c >= CollectionsKt.getLastIndex(r11)) goto L12;
        this.f22653c++;
        goto L12
    }

    public Object b(KClass r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        List r10 = this.f22651a;
        if (r10.isEmpty() == true) goto L42;
        Boolean r11 = this.f22652b;
        if (r11 != null) goto L20;
        Object r12 = a(r5);
        if (r12 != null) goto L39;
        Iterator r13 = r10.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Object r14 = r13.next();
        if (r5.isInstance(r14) == false) goto L11;
    L16:
        if (r14 != null) goto L38;
        return null;
    L38:
        return r14;
    L15:
        r14 = null;
        goto L16
    L39:
        return r12;
    L20:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == true) goto L40;
        Iterator r15 = r10.iterator();
    L24:
        if (r15.hasNext() == false) goto L28;
        r14 = r15.next();
        if (r5.isInstance(r14) == false) goto L24;
    L29:
        if (r14 != null) goto L38;
        return null;
    L28:
        r14 = null;
        goto L29
    L40:
        return a(r5);
    L42:
        return null;
    }

    public final String toString() {
        return "DefinitionParameters" + CollectionsKt.toList(this.f22651a);
    }
}
