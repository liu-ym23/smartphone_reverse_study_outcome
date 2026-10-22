package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.securityserver.R;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSectionTitleBar extends LinearLayout {
    public final TextView b;
    public final FrameLayout c;
    public final ImageView e;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OSectionTitleBar(@NotNull Context r5, @Nullable AttributeSet r6) {
        Intrinsics.f(r5, "context");
        super(r5, r6, 0);
        setOrientation(0);
        LayoutInflater.from(r5).inflate(R.layout.o_section_title_bar, this, true);
        View r1 = findViewById(R.id.container);
        Intrinsics.e(r1, "findViewById(R.id.container)");
        LinearLayout r2 = (LinearLayout) r1;
        View r3 = findViewById(R.id.titleTextView);
        Intrinsics.e(r3, "findViewById(R.id.titleTextView)");
        this.b = (TextView) r3;
        View r4 = findViewById(R.id.custom_end_container);
        Intrinsics.e(r4, "findViewById(R.id.custom_end_container)");
        this.c = (FrameLayout) r4;
        View r7 = findViewById(R.id.tail_icon);
        Intrinsics.e(r7, "findViewById(R.id.tail_icon)");
        this.e = (ImageView) r7;
        TypedArray r8 = r5.getTheme().obtainStyledAttributes(r6, com.obric.common.oui.R.styleable.y, 0, 0);
        Intrinsics.e(r8, "context.theme.obtainStyl…           0, 0\n        )");
    L6:
        th = move-exception;
        r8.recycle();
        throw th;
    L4:
        if (r8.hasValue(8) == false) goto L9;
        setTitleText(r8.getString(8));     // Catch: Throwable -> L6
    L9:
        if (r8.hasValue(7) == false) goto L12;
        setTitleStyle(r8.getResourceId(7, R.style.OSectionTitleBar_S));     // Catch: Throwable -> L6
    L12:
        if (r8.hasValue(0) == false) goto L15;
        setCustomEndView(r8.getResourceId(0, 0));     // Catch: Throwable -> L6
    L15:
        if (r8.hasValue(1) == false) goto L18;
        setDefaultCustomEndView(r8.getInt(1, 0));     // Catch: Throwable -> L6
    L18:
        if (r8.hasValue(3) == false) goto L21;
        setDetailEndText(r8.getString(3));     // Catch: Throwable -> L6
    L21:
        if (r8.hasValue(4) == false) goto L24;
        a(r8.getBoolean(4, false));     // Catch: Throwable -> L6
    L24:
        if (r8.hasValue(6) == false) goto L27;
        setTailIcon(r8.getResourceId(6, 0));     // Catch: Throwable -> L6
    L27:
        if (r8.hasValue(2) == false) goto L30;
        setDefaultTailIcon(r8.getInt(2, 0));     // Catch: Throwable -> L6
    L30:
        if (r8.hasValue(5) == false) goto L32;
        b(r8.getBoolean(5, false));     // Catch: Throwable -> L6
    L32:
        r8.recycle();
    }

    public final void a(boolean r3) {
        FrameLayout r2 = this.c;
        int r1 = 8;
        if (r2.getChildCount() == 0) goto L7;
        if (r3 == false) goto L6;
        r1 = 0;
    L6:
        r2.setVisibility(r1);
        return;
    L7:
        r2.setVisibility(8);
    }

    public final void b(boolean r3) {
        ImageView r2 = this.e;
        int r1 = 8;
        if (r2.getDrawable() == null) goto L7;
        if (r3 == false) goto L6;
        r1 = 0;
    L6:
        r2.setVisibility(r1);
        return;
    L7:
        r2.setVisibility(8);
    }

    @Nullable
    public final View getCustomEndView() {
        FrameLayout r1 = this.c;
        if (r1.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r1.getChildAt(0);
    }

    @Nullable
    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OTextView) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public final void setCustomEndView(@Nullable View r2) {
        FrameLayout r0 = this.c;
        r0.removeAllViews();
        if (r2 == null) goto L5;
        r0.addView(r2);
        return;
    L5:
        a(false);
    }

    public final void setDefaultCustomEndView(int r2) {
        this.c.removeAllViews();
        if (r2 != 0) goto L5;
        setCustomEndView(R.layout.o_section_titlebar_custom_end_detail);
        return;
    L5:
        a(false);
    }

    public final void setDefaultTailIcon(int r2) {
        if (r2 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R.drawable.o_section_titlebar_tail_icon_arrow));
        return;
    L4:
        b(false);
    }

    public final void setDetailEndText(@Nullable CharSequence r2) {
        setDefaultCustomEndView(0);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r1 = getCustomEndView();
        if (r1 == null) goto L8;
        ((OTextView) r1).setText(r2);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void setTailIcon(@Nullable Drawable r1) {
        if (r1 == null) goto L4;
        this.e.setImageDrawable(r1);
        return;
    L4:
        b(false);
    }

    public final void setTitleStyle(int r1) {
        this.b.setTextAppearance(r1);
    }

    public final void setTitleText(@Nullable CharSequence r1) {
        this.b.setText(r1);
    }

    public final void setTitleTextColor(int r1) {
        this.b.setTextColor(r1);
    }

    public final void setTitleTextSize(float r1) {
        this.b.setTextSize(r1);
    }

    public final void setTailIcon(int r2) {
        ImageView r0 = this.e;
        if (r2 == 0) goto L5;
        r0.setImageResource(r2);
        return;
    L5:
        r0.setImageDrawable(null);
        b(false);
    }

    public final void setCustomEndView(int r3) {
        FrameLayout r0 = this.c;
        r0.removeAllViews();
        if (r3 != 0) goto L9;
    L6:
        a(false);
        return;
    L9:
        View.inflate(getContext(), r3, r0);     // Catch: Exception -> L8
    }
}
