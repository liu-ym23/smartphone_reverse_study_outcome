package com.obric.oui.titlebar.optimize;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OBaseTextView;
import com.obric.oui.utils.log.L;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OCTitleBar extends RelativeLayout {
    public static final /* synthetic */ int q = 0;
    public final boolean b;
    public View c;
    public View e;
    public View f;
    public List i;
    public List j;
    public OButton k;
    public TextView l;
    public String m;
    public TextView n;
    public String o;
    public final ViewTreeObserver.OnGlobalLayoutListener p;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OCTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        Intrinsics.f(r10, "context");
        super(r10, r11, 0);
        ViewTreeObserver.OnGlobalLayoutListener r12 = new OCTitleBar$onGlobalLayoutListener$1(this);
        this.p = r12;
        if (r11 == null) goto L44;
        Context r2 = getContext();
        Intrinsics.e(r2, "context");
        TypedArray r13 = r2.getTheme().obtainStyledAttributes(r11, R.styleable.f, 0, 0);
        com.obric.oui.titlebar.OCTitleBar.TitlePosition r3 = com.obric.oui.titlebar.OCTitleBar.TitlePosition.values()[r13.getInt(3, 0)];
        String r4 = r13.getString(4);
        if (r4 == null) goto L8;
        setCenterText(r4);
    L8:
        if (r13.getBoolean(5, true) == false) goto L39;
        Context r5 = getContext();
        Intrinsics.e(r5, "context");
        View r6 = LayoutInflater.from(r5).inflate(com.bytedance.securityserver.R.layout.o_widget_titlebar_trans_icon_button, this, false);
        if (r6 == null) goto L38;
        OButton r7 = (OButton) r6;
        r7.setButtonSourceBitmap(com.bytedance.securityserver.R.drawable.oui_ic_back_24_24);
        this.k = r7;
        RelativeLayout.LayoutParams r8 = a(r7, false);
        int r9 = getLeftViewCount();
        Intrinsics.f(r8, "layoutParams");
        r8.alignWithParent = true;
        r8.leftMargin = 0;
        r7.setId(View.generateViewId());
        if (this.e != null) goto L14;
        r8.addRule(9);
        r9 = 0;
    L31:
        r8.addRule(15);
        List r14 = this.i;
        if (r14 != null) goto L34;
    L35:
        this.e = r7;
    L36:
        getLeftViewListOrCreate().add(r9, r7);
        addView(r7, r8);
        goto L39
    L34:
        if (r9 != r14.size()) goto L36;
    L14:
        if (r9 < 0) goto L30;
        List r15 = this.i;
        Intrinsics.c(r15);
        if (r9 >= r15.size()) goto L30;
        if (r9 != 0) goto L25;
        r8.addRule(9);
        List r16 = this.i;
        Intrinsics.c(r16);
        ViewGroup.LayoutParams r17 = ((View) r16.get(r9)).getLayoutParams();
        if (r17 == null) goto L24;
        RelativeLayout.LayoutParams r18 = (RelativeLayout.LayoutParams) r17;
        r18.removeRule(9);
        r18.addRule(1, r7.getId());
        goto L31
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L25:
        List r19 = this.i;
        Intrinsics.c(r19);
        View r20 = (View) r19.get(r9 - 1);
        List r21 = this.i;
        Intrinsics.c(r21);
        View r22 = (View) r21.get(r9);
        r8.addRule(1, r20.getId());
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L29;
        ((RelativeLayout.LayoutParams) r23).addRule(1, r7.getId());
        goto L31
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L30:
        List r24 = this.i;
        Intrinsics.c(r24);
        r9 = r24.size();
        View r25 = this.e;
        Intrinsics.c(r25);
        r8.addRule(1, r25.getId());
        goto L31
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L39:
        String r26 = r13.getString(1);
        if (r26 == null) goto L42;
        setCenterSubText(r26);
    L42:
        this.b = r13.getBoolean(0, true);
        Context r110 = getContext();
        Intrinsics.e(r110, "context");
        int r111 = (int) r110.getResources().getDimension(com.bytedance.securityserver.R.dimen.oui_p_title_bar_default);
        setPadding(r111, 0, r111, 0);
    L44:
        if (this.b == false) goto L52;
        getViewTreeObserver().addOnGlobalLayoutListener(r12);     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        L.c("OCTitleBar", "addGlobalLayoutListener: ", e);
        return;
    }

    public static int b(List r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.size() <= 0) goto L18;
        int r1 = r5.size();
        int r2 = 0;
    L7:
        if (r0 >= r1) goto L13;
        if (((View) r5.get(r0)).getVisibility() == 8) goto L11;
        r2 = r2 + 1;
    L11:
        r0 = r0 + 1;
        goto L7
    L13:
        return r2;
    L18:
        return 0;
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.i != null) goto L5;
        this.i = new ArrayList();
    L5:
        List<View> r1 = this.i;
        Intrinsics.c(r1);
        return r1;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.j != null) goto L5;
        this.j = new ArrayList();
    L5:
        List<View> r1 = this.j;
        Intrinsics.c(r1);
        return r1;
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Context r1 = getContext();
        Intrinsics.e(r1, "context");
        OBaseTextView r2 = new OBaseTextView(r1, null, 6);
        r2.setMaxLines(1);
        r2.setEllipsize(TextUtils.TruncateAt.END);
        r2.setTextAppearance(com.bytedance.securityserver.R.style.Label_M);
        Context r3 = r2.getContext();
        Intrinsics.e(r3, "context");
        r2.setTextColor(r3.getResources().getColor(com.bytedance.securityserver.R.color.oui_text_3b));
        this.n = r2;
        ViewGroup.LayoutParams r4 = generateDefaultLayoutParams();
        if (r4 == null) goto L10;
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r4;
        r5.addRule(14);
        r5.topMargin = a.d("Resources.getSystem()", 1, 30);
        addView(this.n, r5);
        TextView r6 = this.n;
        Intrinsics.c(r6);
        return r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final TextView getTitleViewOrCreate() {
        View r0 = this.c;
        if (r0 == null) goto L8;
        TextView r1 = this.l;
        if (r0 != r1) goto L8;
        Intrinsics.c(r1);
        return r1;
    L8:
        if (this.l != null) goto L10;
        Context r2 = getContext();
        Intrinsics.e(r2, "context");
        OBaseTextView r3 = new OBaseTextView(r2, null, 6);
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.setTextAppearance(com.bytedance.securityserver.R.style.Title_Title_M_Thick);
        Context r4 = r3.getContext();
        Intrinsics.e(r4, "context");
        r3.setTextColor(r4.getResources().getColor(com.bytedance.securityserver.R.color.oui_text_1));
        this.l = r3;
    L10:
        View r5 = this.c;
        if (r5 == null) goto L14;
        if (r5 == null) goto L14;
        removeView(r5);
        this.c = null;
    L14:
        View r6 = this.l;
        ViewGroup.LayoutParams r7 = generateDefaultLayoutParams();
        if (r7 == null) goto L19;
        RelativeLayout.LayoutParams r8 = (RelativeLayout.LayoutParams) r7;
        r8.addRule(13);
        addView(r6, r8);
        TextView r9 = this.l;
        this.c = r9;
        Intrinsics.c(r9);
        return r9;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final void setCenterSubText(String r6) {
        getSubtitleViewOrCreate().setText(r6);
        TextView r7 = this.l;
        if (r7 != null) goto L5;
        return;
    L5:
        if (this.n == null) goto L20;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L18;
        RelativeLayout.LayoutParams r9 = (RelativeLayout.LayoutParams) r8;
        r9.removeRule(13);
        r9.addRule(14);
        r9.topMargin = a.d("Resources.getSystem()", 1, 9);
        Context r1 = getContext();
        Intrinsics.e(r1, "context");
        Resources r2 = r1.getResources();
        Intrinsics.e(r2, "context.resources");
        if (r2.getConfiguration().fontScale <= 1.0f) goto L21;
        r9.topMargin = a.d("Resources.getSystem()", 1, 6);
        TextView r5 = this.n;
        if (r5 == null) goto L22;
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if (r10 == null) goto L16;
        ((RelativeLayout.LayoutParams) r10).topMargin = a.d("Resources.getSystem()", 1, 31);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L22:
        return;
    L21:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final RelativeLayout.LayoutParams a(View r2, boolean r3) {
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if ((r4 instanceof RelativeLayout.LayoutParams) == false) goto L6;
        return (RelativeLayout.LayoutParams) r4;
    L6:
        if (r3 == false) goto L12;
        ViewGroup.LayoutParams r1 = generateDefaultLayoutParams();
        if (r1 == null) goto L11;
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r1;
        r5.addRule(13);
        Object r6 = r5;
    L13:
        if (r6 == null) goto L17;
        return (RelativeLayout.LayoutParams) r6;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L12:
        r6 = generateDefaultLayoutParams();
        goto L13
    }

    public final int getLeftViewCount() {
        return b(this.i);
    }

    @Nullable
    public final View getMCenterView() {
        return this.c;
    }

    @Nullable
    public final OButton getMLeftActionBack() {
        return this.k;
    }

    @Nullable
    public final View getMLeftLastView() {
        return this.e;
    }

    @Nullable
    public final List<View> getMLeftViewList() {
        return this.i;
    }

    @Nullable
    public final View getMRightLastView() {
        return this.f;
    }

    @Nullable
    public final List<View> getMRightViewList() {
        return this.j;
    }

    @Nullable
    public final TextView getMSubTitleView() {
        return this.n;
    }

    @Nullable
    public final TextView getMTitleView() {
        return this.l;
    }

    public final int getRightViewCount() {
        return b(this.j);
    }

    @Nullable
    public final String getSubTitleText() {
        return this.o;
    }

    @Nullable
    public final String getTitleText() {
        return this.m;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        Context r4 = getContext();
        Intrinsics.e(r4, "context");
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec((int) r4.getResources().getDimension(com.bytedance.securityserver.R.dimen.oui_h_title_bar_window), BasicMeasure.EXACTLY));
    }

    public final void setCenterText(int r2) {
        setCenterText(getContext().getString(r2));
    }

    public final void setCenterView(@Nullable View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        RelativeLayout.LayoutParams r0 = a(r3, true);
        if (Intrinsics.a(this.c, r3) == true) goto L12;
        View r1 = this.c;
        if (r1 == null) goto L10;
        removeView(r1);
        this.c = null;
    L10:
        this.c = r3;
        addView(r3, r0);
        return;
    }

    public final void setMCenterView(@Nullable View r1) {
        this.c = r1;
    }

    public final void setMLeftActionBack(@Nullable OButton r1) {
        this.k = r1;
    }

    public final void setMLeftLastView(@Nullable View r1) {
        this.e = r1;
    }

    public final void setMLeftViewList(@Nullable List<View> r1) {
        this.i = r1;
    }

    public final void setMRightLastView(@Nullable View r1) {
        this.f = r1;
    }

    public final void setMRightViewList(@Nullable List<View> r1) {
        this.j = r1;
    }

    public final void setMSubTitleView(@Nullable TextView r1) {
        this.n = r1;
    }

    public final void setMTitleView(@Nullable TextView r1) {
        this.l = r1;
    }

    public final void setSubTitleText(@Nullable String r1) {
        this.o = r1;
        setCenterSubText(r1);
    }

    public final void setTitleText(@Nullable String r1) {
        this.m = r1;
        setCenterText(r1);
    }

    private final void setCenterText(String r1) {
        getTitleViewOrCreate().setText(r1);
    }
}
