package com.obric.oui.indexscrollbar;

import android.graphics.Bitmap;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0291a f11074d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap[] f11077c;

    /* JADX INFO: renamed from: com.obric.oui.indexscrollbar.a$a, reason: collision with other inner class name */
    public static final class C0291a {
        private C0291a() {
        }

        public /* synthetic */ C0291a(g r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final a a(String r3) {
            o.f(r3, "letter");
            return new a(0, r3, null, 0 == true ? 1 : 0);
        }
    }

    static {
        C0291a r0 = new C0291a(null);
        f11074d = r0;
        r0.a("#");
    }

    private a(int r2, String r3, Bitmap[] r4) {
        this.f11075a = r2;
        this.f11076b = r3;
        this.f11077c = r4;
        if (r2 != 2) goto L15;
        boolean r5 = false;
        if (r4 == null) goto L7;
        int r6 = r4.length;
    L9:
        if (r6 != 3) goto L11;
        r5 = true;
    L11:
        if (r5 == false) goto L14;
        this.f11077c = r4;
        return;
    L14:
        throw new IllegalStateException("symbol must have 3 bitmaps!".toString());
    L7:
        r6 = 0;
        goto L9
    }

    public /* synthetic */ a(int r1, String r2, Bitmap[] r3, g r4) {
        this(r1, r2, r3);
    }

    public final String a() {
        return this.f11076b;
    }

    public final Bitmap[] b() {
        return this.f11077c;
    }

    public final int c() {
        return this.f11075a;
    }
}
