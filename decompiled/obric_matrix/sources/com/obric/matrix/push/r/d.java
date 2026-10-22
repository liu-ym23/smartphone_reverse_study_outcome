package com.obric.matrix.push.r;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/obric/matrix/push/utils/CompressUtils;", "", "()V", "compress", "", "mnw", "unCompress", "miw", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9793a = null;

    static {
        f9793a = new d();
    }

    private d() {
    }

    public final String a(String r5) {
        o.f(r5, "mnw");
        StringBuilder r4 = new StringBuilder();
        int r1 = 1;
    L4:
        if (r1 >= r5.length()) goto L7;
        r4.append((char) ((r5.charAt(r1 - 1) << '\b') + r5.charAt(r1)));
        r1 = r1 + 2;
        goto L4
    L7:
        if (r1 != r5.length()) goto L9;
        r4.append(r5.charAt(r1 - 1));
    L9:
        String r6 = r4.toString();
        o.e(r6, "sb.toString()");
        return r6;
    }

    public final String b(String r9) {
        o.f(r9, "miw");
        StringBuilder r8 = new StringBuilder();
        int r0 = r9.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        char r3 = r9.charAt(r2);
        String r4 = Integer.toBinaryString(r3);
        if (r4.length() >= 8) goto L7;
        char r5 = r3;
    L8:
        r8.append(r5);
        r2 = r2 + 1;
        goto L3
    L7:
        o.e(r4, "binaryString");
        String r6 = r4.substring(0, r4.length() - 8);
        o.e(r6, "this as java.lang.String…ing(startIndex, endIndex)");
        kotlin.u0.a.a(2);
        int r7 = Integer.parseInt(r6, 2);
        String r10 = r4.substring(r4.length() - 8);
        o.e(r10, "this as java.lang.String).substring(startIndex)");
        kotlin.u0.a.a(2);
        int r11 = Integer.parseInt(r10, 2);
        r8.append((char) r7);
        r5 = (char) r11;
        goto L8
    L9:
        String r12 = r8.toString();
        o.e(r12, "sb.toString()");
        return r12;
    }
}
