package t1;

import cn.nubia.neopush.commons.Constant;
import com.lynx.tasm.behavior.v0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22076c;
    public final long d;
    public final long e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f22077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f22078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f22080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f22081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f22082m;

    public i(long r10, String r11, String r12, long r13, long r14, String r16, String r17, ArrayList r18, boolean r19, String r20, String r21, String r22, List r23) {
        Intrinsics.checkNotNullParameter(r11, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r17, "timeZone");
        Intrinsics.checkNotNullParameter(r18, "reminders");
        Intrinsics.checkNotNullParameter(r23, "exceptions");
        this.f22074a = r10;
        this.f22075b = r11;
        this.f22076c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r16;
        this.g = r17;
        this.f22077h = r18;
        this.f22078i = r19;
        this.f22079j = r20;
        this.f22080k = r21;
        this.f22081l = r22;
        this.f22082m = r23;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        long r5 = r11.f22074a;
        if (this.f22074a == r5) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22075b, r11.f22075b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22076c, r11.f22076c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f22077h, r11.f22077h) == true) goto L33;
        return false;
    L33:
        if (this.f22078i == r11.f22078i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f22079j, r11.f22079j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f22080k, r11.f22080k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f22081l, r11.f22081l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f22082m, r11.f22082m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r5 = kk.a.b(this.f22075b, Long.hashCode(this.f22074a) * 31, 31);
        int r10 = 0;
        String r11 = this.f22076c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = v0.a(v0.a((r5 + r12) * 31, this.d), this.e);
        String r14 = this.f;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = kn.e.a((this.f22077h.hashCode() + kk.a.b(this.g, (r13 + r15) * 31, 31)) * 31, 31, this.f22078i);
        String r17 = this.f22079j;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.f22080k;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.f22081l;
        if (r23 == null) goto L23;
        r10 = r23.hashCode();
    L23:
        return this.f22082m.hashCode() + ((r22 + r10) * 31);
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LocalCalendarEvent(eventId=");
        r5.append(this.f22074a);
        r5.append(", title=");
        r5.append(this.f22075b);
        r5.append(", description=");
        r5.append(this.f22076c);
        r5.append(", start=");
        r5.append(this.d);
        r5.append(", end=");
        r5.append(this.e);
        r5.append(", location=");
        r5.append(this.f);
        r5.append(", timeZone=");
        r5.append(this.g);
        r5.append(", reminders=");
        r5.append(this.f22077h);
        r5.append(", allDay=");
        r5.append(this.f22078i);
        r5.append(", rrule=");
        r5.append(this.f22079j);
        r5.append(", rDate=");
        r5.append(this.f22080k);
        r5.append(", duration=");
        r5.append(this.f22081l);
        r5.append(", exceptions=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f22082m, ')');
    }
}
