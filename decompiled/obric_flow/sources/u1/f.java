package u1;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.e0;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f22233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f22234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StatusLine f22235c;
    public final ArrayList d;
    public final ArrayList e;
    public final e0 f;
    public final Lazy g;

    public f(e0 r5, e0 r10, StatusLine r11, ArrayList r12, ArrayList r13, e0 r14) {
        Intrinsics.checkNotNullParameter(r5, "requestedUrl");
        Intrinsics.checkNotNullParameter(r10, "href");
        Intrinsics.checkNotNullParameter(r12, "propstat");
        this.f22233a = r5;
        this.f22234b = r10;
        this.f22235c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = LazyKt.lazy(new com.bytedance.ai.resource.core.db.b(this, 3));
    }

    public final h a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        return (h) CollectionsKt.firstOrNull(CollectionsKt.l((List) this.g.getValue(), r5));
    }

    public final boolean b() {
        StatusLine r5 = this.f22235c;
        if (r5 != null) goto L5;
        return true;
    L5:
        if ((r5.code / 100) == 2) goto L11;
        return false;
    L11:
        return true;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        e0 r11 = r10.f22233a;
        if (Intrinsics.areEqual(this.f22233a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22234b, r10.f22234b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22235c, r10.f22235c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.f22233a.f20644j.hashCode() * 31, 31, this.f22234b.f20644j);
        int r10 = 0;
        StatusLine r11 = this.f22235c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (this.d.hashCode() + ((r5 + r12) * 31)) * 31;
        ArrayList r14 = this.e;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        e0 r17 = this.f;
        if (r17 == null) goto L15;
        r10 = r17.f20644j.hashCode();
    L15:
        return r16 + r10;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalDavResponse(requestedUrl=" + this.f22233a + ", href=" + this.f22234b + ", status=" + this.f22235c + ", propstat=" + this.d + ", error=" + this.e + ", newLocation=" + this.f + ')';
    }
}
