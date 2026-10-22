package uu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.instance.e;
import xq.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f22469c;
    public final HashMap d;
    public final HashSet e;
    public final ArrayList f;

    public a(boolean r5) {
        this.f22467a = r5;
        this.f22468b = UUID.randomUUID().toString();
        this.f22469c = new HashSet();
        this.d = new HashMap();
        this.e = new HashSet();
        this.f = new ArrayList();
    }

    public final void a(e r5) {
        Intrinsics.checkNotNullParameter(r5, "instanceFactory");
        org.koin.core.definition.a r10 = r5.f21015a;
        wu.a r11 = r10.f21008c;
        wu.a r12 = r10.f21006a;
        String r13 = b.r(r10.f21007b, r11, r12);
        Intrinsics.checkNotNullParameter(r13, "mapping");
        Intrinsics.checkNotNullParameter(r5, "factory");
        this.d.put(r13, r5);
    }

    public final void b(e r5) {
        Intrinsics.checkNotNullParameter(r5, "instanceFactory");
        this.f22469c.add(r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (a.class != r5.getClass()) goto L14;
        if (Intrinsics.areEqual(this.f22468b, ((a) r5).f22468b) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f22468b.hashCode();
    }
}
