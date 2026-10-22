package x1;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22943a = 0;

    static {
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
    }

    public static String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "quoted");
        int r5 = r10.length();
        if (r5 >= 2) goto L5;
        return r10;
    L5:
        if (r10.charAt(0) != '\"') goto L23;
        int r11 = r5 - 1;
        if (r10.charAt(r11) != '\"') goto L24;
        StringBuffer r12 = new StringBuffer(r5);
        int r13 = 1;
    L9:
        if (r13 >= r11) goto L17;
        char r14 = r10.charAt(r13);
        if (r14 != '\\') goto L15;
        if (r13 == (r5 - 2)) goto L15;
        r13 = r13 + 1;
        r14 = r10.charAt(r13);
    L15:
        r12.append(r14);
        r13 = r13 + 1;
        goto L9
    L17:
        return r12.toString();
    L24:
        return r10;
    L23:
        return r10;
    }
}
