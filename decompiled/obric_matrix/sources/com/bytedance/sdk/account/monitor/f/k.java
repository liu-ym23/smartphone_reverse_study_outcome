package com.bytedance.sdk.account.monitor.f;

import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5686a = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final g a(String r8) {
            o.g(r8, "expression");
            int r7 = kotlin.u0.k.Q(r8, "=", 0, false, 6, null);
            boolean r0 = kotlin.u0.k.A(r8, "!", false, 2, null);
            if (r0 == false) goto L5;
            String r4 = r8.substring(1);
            o.b(r4, "(this as java.lang.String).substring(startIndex)");
        L6:
            if (r7 < 1) goto L10;
            int r5 = r7 - 1;
            if (r8.charAt(r5) != '!') goto L10;
            boolean r9 = true;
        L11:
            if (r5 >= 0) goto L14;
            g r10 = new l(r4);
        L22:
            if (r0 == true) goto L24;
            return r10;
        L24:
            return new h(r10);
        L14:
            if (r4 == null) goto L28;
            String r1 = r4.substring(0, r5);
            o.b(r1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int r11 = r7 + 1;
            if (r4 == null) goto L26;
            String r12 = r4.substring(r11);
            o.b(r12, "(this as java.lang.String).substring(startIndex)");
            if (r9 == false) goto L20;
            g r13 = new i(r1, r12);
        L21:
            r10 = r13;
            goto L22
        L20:
            r13 = new f(r1, r12);
            goto L21
        L26:
            throw new b0("null cannot be cast to non-null type java.lang.String");
        L28:
            throw new b0("null cannot be cast to non-null type java.lang.String");
        L10:
            r5 = r7;
            r9 = false;
            goto L11
        L5:
            r4 = r8;
            goto L6
        }
    }

    static {
        f5686a = new a(null);
    }

    private k() {
        super(null);
    }

    public /* synthetic */ k(kotlin.n0.d.g r1) {
        this();
    }
}
