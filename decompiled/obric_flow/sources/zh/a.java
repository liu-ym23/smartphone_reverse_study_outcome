package zh;

import java.util.Arrays;
import k5.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f23445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23446c;
    public final String d;
    public final String e;
    public final int f;
    public final long g;

    public a(String r5, String[] r10, String r11, String r12, String r13, int r14, long r15) {
        Intrinsics.checkNotNullParameter(r5, "urlWithQuery");
        Intrinsics.checkNotNullParameter(r10, "queryKeys");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r12, "head");
        Intrinsics.checkNotNullParameter(r13, "version");
        this.f23444a = r5;
        this.f23445b = r10;
        this.f23446c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        String r5 = r11.f23444a;
        if (Intrinsics.areEqual(this.f23444a, r5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23445b, r11.f23445b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23446c, r11.f23446c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = ((this.f23444a.hashCode() * 31) + Arrays.hashCode(this.f23445b)) * 31;
        int r10 = kk.a.b(this.f23446c, r5, 31);
        int r11 = kk.a.b(this.d, r10, 31);
        int r12 = kk.a.b(this.e, r11, 31);
        int r13 = d.a(this.f, r12);
        return Long.hashCode(this.g) + r13;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("SnapshotEntity(uri='");
        r5.append(this.f23444a);
        r5.append("', queryKeys='");
        r5.append(this.f23445b);
        r5.append("', content='");
        r5.append(this.f23446c);
        r5.append("', head='");
        r5.append(this.d);
        r5.append("', version=");
        r5.append(this.e);
        r5.append(", sdk=");
        r5.append(this.f);
        r5.append(", expireTime=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.g, ')');
    }
}
