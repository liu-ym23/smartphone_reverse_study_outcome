package com.obric.oui.paneltitlebar;

import a.a;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPanelTitleBar extends ConstraintLayout {
    public int b;
    public boolean c;
    public boolean e;
    public boolean f;
    public String i;
    public String j;
    public OTextView k;
    public OTextView l;
    public ImageView m;
    public ImageView n;
    public FrameLayout o;
    public View p;

    @Metadata
    public static final class Companion {
    }

    public final void setActionView(@Nullable View r3) {
        this.p = r3;
        FrameLayout r0 = this.o;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        FrameLayout r2 = this.o;
        if (r2 == null) goto L11;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 21;
        r2.addView(r3, r1);
        return;
    }

    public final void setInfo(@Nullable String r1) {
        this.j = r1;
        OTextView r0 = this.l;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public final void setTitle(@Nullable String r1) {
        this.i = r1;
        OTextView r0 = this.k;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public final void setType(int r7) {
        if (r7 == 0) goto L6;
        if (r7 == 1) goto L6;
        return;
    L6:
        if (r7 == this.b) goto L28;
        this.b = r7;
        if (r7 == 0) goto L14;
        int r3 = R.layout.o_panel_title_bar_regular;
        if (r7 == 1) goto L13;
        float r8 = 12;
        setPadding(a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8), a.d("Resources.getSystem()", 1, r8));
    L15:
        removeAllViews();
        View r9 = LayoutInflater.from(getContext()).inflate(r3, this, true);
        this.k = (OTextView) r9.findViewById(R.id.panel_title);
        this.l = (OTextView) r9.findViewById(R.id.panel_info);
        this.m = (ImageView) r9.findViewById(R.id.panel_expand_icon);
        this.n = (ImageView) r9.findViewById(R.id.panel_info_icon);
        this.o = (FrameLayout) r9.findViewById(R.id.panel_action_container);
        setTitle(this.i);
        setInfo(this.j);
        boolean r10 = this.c;
        this.c = r10;
        OTextView r0 = this.l;
        if (r0 == null) goto L18;
        ViewExtensionsKt.f(r0, r10);
    L18:
        boolean r11 = this.f;
        this.f = r11;
        ImageView r1 = this.m;
        if (r1 == null) goto L21;
        ViewExtensionsKt.f(r1, r11);
    L21:
        boolean r12 = this.e;
        this.e = r12;
        ImageView r2 = this.n;
        if (r2 == null) goto L24;
        ViewExtensionsKt.f(r2, r12);
    L24:
        View r13 = this.p;
        if (r13 == null) goto L29;
        setActionView(r13);
        return;
    L29:
        return;
    L13:
        float r14 = 12;
        setPadding(a.d("Resources.getSystem()", 1, r14), a.d("Resources.getSystem()", 1, r14), a.d("Resources.getSystem()", 1, r14), a.d("Resources.getSystem()", 1, r14));
        goto L15
    L14:
        float r15 = 12;
        setPadding(a.d("Resources.getSystem()", 1, r15), a.d("Resources.getSystem()", 1, 14), a.d("Resources.getSystem()", 1, r15), a.d("Resources.getSystem()", 1, 8));
        r3 = R.layout.o_panel_title_bar_display;
        goto L15
    }
}
