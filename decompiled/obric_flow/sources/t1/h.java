package t1;

import cn.nubia.neopush.commons.Constant;
import com.lynx.tasm.behavior.v0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22069c;
    public final String d;
    public final String e;
    public final boolean f;
    public final long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f22070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f22071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f22073k;

    public h(long r5, String r10, String r11, String r12, String r13, boolean r14, long r15, long r16, int r17, String r18, ArrayList r19) {
        Intrinsics.checkNotNullParameter(r10, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r13, "timeZone");
        Intrinsics.checkNotNullParameter(r19, "reminders");
        this.f22067a = r5;
        this.f22068b = r10;
        this.f22069c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f22070h = r16;
        this.f22071i = r17;
        this.f22072j = r18;
        this.f22073k = r19;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        long r5 = r11.f22067a;
        if (this.f22067a == r5) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22068b, r11.f22068b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22069c, r11.f22069c) == true) goto L18;
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
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (this.f22070h == r11.f22070h) goto L33;
        return false;
    L33:
        if (this.f22071i == r11.f22071i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f22072j, r11.f22072j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f22073k, r11.f22073k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r5 = kk.a.b(this.f22068b, Long.hashCode(this.f22067a) * 31, 31);
        int r10 = 0;
        String r11 = this.f22069c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.d;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = k5.d.a(this.f22071i, v0.a(v0.a(kn.e.a(kk.a.b(this.e, (r13 + r15) * 31, 31), 31, this.f), this.g), this.f22070h));
        String r17 = this.f22072j;
        if (r17 == null) goto L15;
        r10 = r17.hashCode();
    L15:
        return this.f22073k.hashCode() + ((r16 + r10) * 31);
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExceptionEvent(originalInstanceTime=" + this.f22067a + ", title=" + this.f22068b + ", description=" + this.f22069c + ", location=" + this.d + ", timeZone=" + this.e + ", allDay=" + this.f + ", newStart=" + this.g + ", newEnd=" + this.f22070h + ", status=" + this.f22071i + ", duration=" + this.f22072j + ", reminders=" + this.f22073k + ')';
    }
}
