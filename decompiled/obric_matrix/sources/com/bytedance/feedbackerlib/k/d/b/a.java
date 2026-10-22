package com.bytedance.feedbackerlib.k.d.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import d.b.k.a.q;
import d.b.k.a.t;
import d.b.k.a.u;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.feedbackerlib.k.d.a {
    public a() {
    }

    @Override // com.bytedance.feedbackerlib.k.d.a
    public void a(Context r1, int r2, int r3, ImageView r4, Uri r5) {
        t r0 = q.f(r5);
        r0.a(u.f14079l);
        r0.d("GlideEngine");
        r0.b(true);
        r0.a0(r2, r3);
        r0.h(true);
        r0.S(r4);
        r0.g();
    }

    @Override // com.bytedance.feedbackerlib.k.d.a
    public void b(Context r1, int r2, Drawable r3, ImageView r4, Uri r5) {
        t r0 = q.f(r5);
        r0.a(u.f14079l);
        r0.d("GlideEngine");
        r0.b(true);
        r0.a0(r2, r2);
        r0.h(true);
        r0.S(r4);
        r0.g();
    }

    @Override // com.bytedance.feedbackerlib.k.d.a
    public void c(Context r1, int r2, Drawable r3, ImageView r4, Uri r5) {
        t r0 = q.f(r5);
        r0.a(u.f14079l);
        r0.d("GlideEngine");
        r0.b(true);
        r0.a0(r2, r2);
        r0.h(true);
        r0.S(r4);
        r0.g();
    }
}
