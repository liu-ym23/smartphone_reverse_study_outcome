package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.common.oui.e;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PopupWindow f11078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f11079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f11080h;

    public b(Context r3, AttributeSet r4) {
        o.f(r3, "context");
        super(r3, r4);
        View r5 = LayoutInflater.from(r3).inflate(g.p, null);
        this.f11079g = (TextView) r5.findViewById(f.F0);
        this.f11080h = (ImageView) r5.findViewById(f.E0);
        PopupWindow r6 = new PopupWindow(r5, -2, -2, false);
        this.f11078f = r6;
        if (r6 == null) goto L6;
        r6.setBackgroundDrawable(getResources().getDrawable(e.x));
        return;
    }

    public /* synthetic */ b(Context r1, AttributeSet r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final void a() {
        PopupWindow r0 = this.f11078f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L11;
        PopupWindow r2 = this.f11078f;
        if (r2 == null) goto L12;
        r2.dismiss();
        return;
    L12:
        return;
    }

    public final void b(String r3, Bitmap r4, int r5, int r6) {
        o.f(r3, "letter");
        if (r4 != null) goto L13;
        TextView r7 = this.f11079g;
        if (r7 == null) goto L7;
        r7.setText(r3);
    L7:
        ImageView r8 = this.f11080h;
        if (r8 == null) goto L10;
        r8.setVisibility(8);
    L10:
        TextView r9 = this.f11079g;
        if (r9 == null) goto L22;
        r9.setVisibility(0);
    L22:
        PopupWindow r10 = this.f11078f;
        if (r10 != null) goto L25;
    L29:
        PopupWindow r2 = this.f11078f;
        if (r2 == null) goto L35;
        r2.update(r5, r6, -2, -2);
        return;
    L35:
        return;
    L25:
        if (r10.isShowing() == true) goto L29;
        PopupWindow r11 = this.f11078f;
        if (r11 == null) goto L33;
        r11.showAtLocation(this, 0, r5, r6);
        return;
    L33:
        return;
    L13:
        TextView r12 = this.f11079g;
        if (r12 == null) goto L16;
        r12.setVisibility(8);
    L16:
        ImageView r13 = this.f11080h;
        if (r13 == null) goto L19;
        r13.setVisibility(0);
    L19:
        ImageView r14 = this.f11080h;
        if (r14 == null) goto L22;
        r14.setImageBitmap(r4);
        goto L22
    }
}
