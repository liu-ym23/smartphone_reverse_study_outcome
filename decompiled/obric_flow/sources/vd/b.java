package vd;

import android.graphics.Color;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f22570c;

    public b(rd.b r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter("content_bg_color", STGroup.DICT_KEY);
        super(null, 10);
        Boolean r5 = Boolean.FALSE;
        this.f22570c = r5;
        this.f22570c = (Boolean) new a(r10, "use_argb", r5).f22372b;
        j(r10, "content_bg_color", null);
    }

    @Override // um.a
    public final Object h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "string");
    L29:
        return null;
    L4:
        if (StringsKt.P(r10, "#") == false) goto L7;
        r10 = r10.substring(1);     // Catch: Exception -> L29
    L7:
        if (StringsKt.P(r10, "%23") == false) goto L12;
        if (r10 == null) goto L11;
        r10 = r10.substring(3);     // Catch: Exception -> L29
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L29
    L12:
        int r5 = r10.length();     // Catch: Exception -> L29
        if (r5 != 3) goto L16;
        String r11 = "#FF" + r10.charAt(0) + r10.charAt(0) + r10.charAt(1) + r10.charAt(1) + r10.charAt(2) + r10.charAt(2);     // Catch: Exception -> L29
    L23:
        r10 = r11;
    L28:
        return Integer.valueOf(Color.parseColor(r10));
    L16:
        if (r5 != 6) goto L18;
        r11 = "#FF".concat(r10);     // Catch: Exception -> L29
        goto L23
    L18:
        if (r5 != 8) goto L28;
        if (Intrinsics.areEqual(this.f22570c, Boolean.TRUE) == false) goto L24;
        r11 = "#".concat(r10);     // Catch: Exception -> L29
        goto L23
    L24:
        r11 = "#" + StringsKt.c0(r10) + StringsKt.dropLast(r10, 2);     // Catch: Exception -> L29
        goto L23
    }

    @Override // um.a
    public final String i() {
        Integer r5 = (Integer) this.f22372b;
        if (r5 == null) goto L6;
        int r10 = r5.intValue();
        int r11 = r10 >> 24;
        int r12 = (16711680 & r10) >> 16;
        int r13 = (65280 & r10) >> 8;
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        return String.format("%x%x%x%x", Arrays.copyOf(new Object[]{Integer.valueOf(r12), Integer.valueOf(r13), Integer.valueOf(r10 & 255), Integer.valueOf(r11)}, 4));
    L6:
        return null;
    }
}
