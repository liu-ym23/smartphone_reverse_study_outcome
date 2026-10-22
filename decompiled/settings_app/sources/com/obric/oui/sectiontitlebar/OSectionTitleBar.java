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
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSectionTitleBar.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "customEndContainer", "Landroid/widget/FrameLayout;", "tailIcon", "Landroid/widget/ImageView;", "titleTextView", "Landroid/widget/TextView;", "getCustomEndView", "Landroid/view/View;", "getEndDetail", "Lcom/obric/oui/text/OTextView;", "setCustomEndView", "", "view", "resId", "setDefaultCustomEndView", "defaultCustomEnd", "setDefaultTailIcon", "defaultTailIcon", "setDetailEndText", "text", "", "setTailIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setTitleStyle", "setTitleText", "setTitleTextColor", "color", "setTitleTextSize", PerfConsts.PERF_DISK_FILE_SIZE, "", "showCustomEnd", "show", "", "showTailIcon", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSectionTitleBar extends LinearLayout {
    private static final int CUSTOM_END_DETAIL = 0;
    public static final Companion Companion = null;
    private static final int TAIL_ICON_ARROW = 0;
    private LinearLayout container;
    private final FrameLayout customEndContainer;
    private final ImageView tailIcon;
    private TextView titleTextView;

    /* JADX INFO: compiled from: OSectionTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar$Companion;", "", "()V", "CUSTOM_END_DETAIL", "", "getCUSTOM_END_DETAIL", "()I", "TAIL_ICON_ARROW", "getTAIL_ICON_ARROW", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getCUSTOM_END_DETAIL() {
            return OSectionTitleBar.access$getCUSTOM_END_DETAIL$cp();
        }

        public final int getTAIL_ICON_ARROW() {
            return OSectionTitleBar.access$getTAIL_ICON_ARROW$cp();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OSectionTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OSectionTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OSectionTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ int access$getCUSTOM_END_DETAIL$cp() {
        return CUSTOM_END_DETAIL;
    }

    public static final /* synthetic */ int access$getTAIL_ICON_ARROW$cp() {
        return TAIL_ICON_ARROW;
    }

    public OSectionTitleBar(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        setOrientation(0);
        LayoutInflater.from(r5).inflate(R.layout.o_section_title_bar, this, true);
        View r0 = findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.container)");
        this.container = (LinearLayout) r0;
        View r1 = findViewById(R.id.titleTextView);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.titleTextView)");
        this.titleTextView = (TextView) r1;
        View r2 = findViewById(R.id.custom_end_container);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.custom_end_container)");
        this.customEndContainer = (FrameLayout) r2;
        View r3 = findViewById(R.id.tail_icon);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tail_icon)");
        this.tailIcon = (ImageView) r3;
        TypedArray r8 = r5.getTheme().obtainStyledAttributes(r6, R.styleable.SectionTitleBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r8, "context.theme.obtainStyl…           0, 0\n        )");
    L32:
        th = move-exception;
        r8.recycle();
        throw th;
    L4:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_titleText) == false) goto L7;
        setTitleText(r8.getString(R.styleable.SectionTitleBar_sectionTitle_titleText));     // Catch: Throwable -> L32
    L7:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_titleStyle) == false) goto L10;
        setTitleStyle(r8.getResourceId(R.styleable.SectionTitleBar_sectionTitle_titleStyle, R.style.OSectionTitleBar_S));     // Catch: Throwable -> L32
    L10:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_customEnd) == false) goto L13;
        setCustomEndView(r8.getResourceId(R.styleable.SectionTitleBar_sectionTitle_customEnd, 0));     // Catch: Throwable -> L32
    L13:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_defaultCustomEnd) == false) goto L16;
        setDefaultCustomEndView(r8.getInt(R.styleable.SectionTitleBar_sectionTitle_defaultCustomEnd, 0));     // Catch: Throwable -> L32
    L16:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_detailEndText) == false) goto L19;
        setDetailEndText(r8.getString(R.styleable.SectionTitleBar_sectionTitle_detailEndText));     // Catch: Throwable -> L32
    L19:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_showCustomEnd) == false) goto L22;
        showCustomEnd(r8.getBoolean(R.styleable.SectionTitleBar_sectionTitle_showCustomEnd, false));     // Catch: Throwable -> L32
    L22:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_tail) == false) goto L25;
        setTailIcon(r8.getResourceId(R.styleable.SectionTitleBar_sectionTitle_tail, 0));     // Catch: Throwable -> L32
    L25:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_defaultTail) == false) goto L28;
        setDefaultTailIcon(r8.getInt(R.styleable.SectionTitleBar_sectionTitle_defaultTail, 0));     // Catch: Throwable -> L32
    L28:
        if (r8.hasValue(R.styleable.SectionTitleBar_sectionTitle_showTail) == false) goto L30;
        showTailIcon(r8.getBoolean(R.styleable.SectionTitleBar_sectionTitle_showTail, false));     // Catch: Throwable -> L32
    L30:
        r8.recycle();
    }

    public final void setTitleText(CharSequence r1) {
        this.titleTextView.setText(r1);
    }

    public final void setTitleStyle(int r1) {
        this.titleTextView.setTextAppearance(r1);
    }

    public final void setTitleTextSize(float r1) {
        this.titleTextView.setTextSize(r1);
    }

    public final void setTitleTextColor(int r1) {
        this.titleTextView.setTextColor(r1);
    }

    public final void setCustomEndView(View r2) {
        this.customEndContainer.removeAllViews();
        if (r2 == null) goto L5;
        this.customEndContainer.addView(r2);
        return;
    L5:
        showCustomEnd(false);
    }

    public final void setCustomEndView(int r3) {
        this.customEndContainer.removeAllViews();
        if (r3 != 0) goto L9;
    L6:
        showCustomEnd(false);
        return;
    L9:
        LinearLayout.inflate(getContext(), r3, this.customEndContainer);     // Catch: Exception -> L8
    }

    public final void setDefaultCustomEndView(int r2) {
        this.customEndContainer.removeAllViews();
        if (r2 != CUSTOM_END_DETAIL) goto L5;
        setCustomEndView(R.layout.o_section_titlebar_custom_end_detail);
        return;
    L5:
        showCustomEnd(false);
    }

    public final View getCustomEndView() {
        if (this.customEndContainer.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.customEndContainer.getChildAt(0);
    }

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

    public final void setDetailEndText(CharSequence r2) {
        setDefaultCustomEndView(CUSTOM_END_DETAIL);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r1 = getCustomEndView();
        if (r1 == null) goto L8;
        ((OTextView) r1).setText(r2);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void showCustomEnd(boolean r3) {
        int r1 = 8;
        if (this.customEndContainer.getChildCount() == 0) goto L8;
        FrameLayout r2 = this.customEndContainer;
        if (r3 == false) goto L7;
        r1 = 0;
    L7:
        r2.setVisibility(r1);
        return;
    L8:
        this.customEndContainer.setVisibility(8);
    }

    public final void setTailIcon(Drawable r1) {
        if (r1 == null) goto L4;
        this.tailIcon.setImageDrawable(r1);
        return;
    L4:
        showTailIcon(false);
    }

    public final void setTailIcon(int r2) {
        if (r2 == 0) goto L4;
        this.tailIcon.setImageResource(r2);
        return;
    L4:
        this.tailIcon.setImageDrawable(null);
        showTailIcon(false);
    }

    public final void setDefaultTailIcon(int r2) {
        if (r2 != TAIL_ICON_ARROW) goto L5;
        setTailIcon(getResources().getDrawable(R.drawable.o_section_titlebar_tail_icon_arrow));
        return;
    L5:
        showTailIcon(false);
    }

    public final void showTailIcon(boolean r3) {
        int r1 = 8;
        if (this.tailIcon.getDrawable() == null) goto L8;
        ImageView r2 = this.tailIcon;
        if (r3 == false) goto L7;
        r1 = 0;
    L7:
        r2.setVisibility(r1);
        return;
    L8:
        this.tailIcon.setVisibility(8);
    }
}
