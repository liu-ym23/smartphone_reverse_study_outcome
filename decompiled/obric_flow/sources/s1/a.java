package s1;

import com.google.gson.JsonObject;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f21805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21806c;
    public String d;

    public a(String r5, JsonObject r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.f21804a = r5;
        this.f21805b = r10;
        this.f21806c = r11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        a r10 = (a) r5;
        Intrinsics.checkNotNullParameter(r10, "other");
        long r11 = r10.f21806c;
        long r12 = this.f21806c;
        if (r12 != r11) goto L5;
        return -1;
    L5:
        return ComparisonsKt.compareValues(Long.valueOf(r12), Long.valueOf(r10.f21806c));
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        String r5 = r11.f21804a;
        if (Intrinsics.areEqual(this.f21804a, r5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21805b, r11.f21805b) == true) goto L15;
        return false;
    L15:
        if (this.f21806c == r11.f21806c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f21804a.hashCode() * 31;
        JsonObject r10 = this.f21805b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r5 + r11) * 31;
        return Long.hashCode(this.f21806c) + r12;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AIBridgeEvent(eventName=");
        r5.append(this.f21804a);
        r5.append(", params=");
        r5.append(this.f21805b);
        r5.append(", timestamp=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f21806c, ')');
    }
}
