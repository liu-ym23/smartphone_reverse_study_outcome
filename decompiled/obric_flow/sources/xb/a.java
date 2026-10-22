package xb;

import kn.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f23004c;

    public a(String r5, long r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "filePath");
        this.f23002a = r5;
        this.f23003b = r11;
        this.f23004c = r10;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        String r5 = r11.f23002a;
        if (Intrinsics.areEqual(this.f23002a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f23003b == r11.f23003b) goto L15;
        return false;
    L15:
        if (this.f23004c == r11.f23004c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = e.a(this.f23002a.hashCode() * 31, 31, this.f23003b);
        return Long.hashCode(this.f23004c) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("JSFileCacheModel(filePath=");
        r5.append(this.f23002a);
        r5.append(", fromOffline=");
        r5.append(this.f23003b);
        r5.append(", loadDuration=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f23004c, ')');
    }
}
