package com.android.setupwizardlib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.setupwizardlib.template.ButtonFooterMixin;
import com.android.setupwizardlib.template.ColoredHeaderMixin;
import com.android.setupwizardlib.template.HeaderMixin;
import com.android.setupwizardlib.template.IconMixin;
import com.android.setupwizardlib.template.ProgressBarMixin;
import com.android.setupwizardlib.template.RequireScrollMixin;
import com.android.setupwizardlib.template.ScrollViewScrollHandlingDelegate;
import com.android.setupwizardlib.view.StatusBarBackgroundLayout;

/* JADX INFO: loaded from: classes.dex */
public class GlifLayout extends TemplateLayout {
    private static final String TAG = "GlifLayout";
    private ColorStateList backgroundBaseColor;
    private boolean backgroundPatterned;
    private boolean layoutFullscreen;
    private ColorStateList primaryColor;

    public GlifLayout(Context r2) {
        this(r2, 0, 0);
    }

    public GlifLayout(Context r2, int r3) {
        this(r2, r3, 0);
    }

    public GlifLayout(Context r1, int r2, int r3) {
        super(r1, r2, r3);
        this.backgroundPatterned = true;
        this.layoutFullscreen = true;
        init(null, R.attr.suwLayoutTheme);
    }

    public GlifLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.backgroundPatterned = true;
        this.layoutFullscreen = true;
        init(r2, R.attr.suwLayoutTheme);
    }

    public GlifLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.backgroundPatterned = true;
        this.layoutFullscreen = true;
        init(r2, r3);
    }

    private void init(AttributeSet r4, int r5) {
        registerMixin(HeaderMixin.class, new ColoredHeaderMixin(this, r4, r5));
        registerMixin(IconMixin.class, new IconMixin(this, r4, r5));
        registerMixin(ProgressBarMixin.class, new ProgressBarMixin(this));
        registerMixin(ButtonFooterMixin.class, new ButtonFooterMixin(this));
        RequireScrollMixin r0 = new RequireScrollMixin(this);
        registerMixin(RequireScrollMixin.class, r0);
        ScrollView r1 = getScrollView();
        if (r1 == null) goto L5;
        r0.setScrollHandlingDelegate(new ScrollViewScrollHandlingDelegate(r0, r1));
    L5:
        TypedArray r6 = getContext().obtainStyledAttributes(r4, R.styleable.SuwGlifLayout, r5, 0);
        ColorStateList r7 = r6.getColorStateList(R.styleable.SuwGlifLayout_suwColorPrimary);
        if (r7 == null) goto L8;
        setPrimaryColor(r7);
    L8:
        setBackgroundBaseColor(r6.getColorStateList(R.styleable.SuwGlifLayout_suwBackgroundBaseColor));
        setBackgroundPatterned(r6.getBoolean(R.styleable.SuwGlifLayout_suwBackgroundPatterned, true));
        int r8 = r6.getResourceId(R.styleable.SuwGlifLayout_suwFooter, 0);
        if (r8 == 0) goto L11;
        inflateFooter(r8);
    L11:
        int r9 = r6.getResourceId(R.styleable.SuwGlifLayout_suwStickyHeader, 0);
        if (r9 == 0) goto L14;
        inflateStickyHeader(r9);
    L14:
        this.layoutFullscreen = r6.getBoolean(R.styleable.SuwGlifLayout_suwLayoutFullscreen, true);
        r6.recycle();
        if (this.layoutFullscreen == false) goto L18;
        setSystemUiVisibility(1024);
        return;
    }

    @Override // com.android.setupwizardlib.TemplateLayout
    protected View onInflateTemplate(LayoutInflater r2, int r3) {
        if (r3 != 0) goto L5;
        r3 = R.layout.suw_glif_template;
    L5:
        return inflateTemplate(r2, R.style.SuwThemeGlif_Light, r3);
    }

    @Override // com.android.setupwizardlib.TemplateLayout
    protected ViewGroup findContainer(int r1) {
        if (r1 != 0) goto L5;
        r1 = R.id.suw_layout_content;
    L5:
        return super.findContainer(r1);
    }

    public View inflateFooter(int r2) {
        ViewStub r1 = (ViewStub) findManagedViewById(R.id.suw_layout_footer);
        r1.setLayoutResource(r2);
        return r1.inflate();
    }

    public View inflateStickyHeader(int r2) {
        ViewStub r1 = (ViewStub) findManagedViewById(R.id.suw_layout_sticky_header);
        r1.setLayoutResource(r2);
        return r1.inflate();
    }

    public ScrollView getScrollView() {
        View r1 = findManagedViewById(R.id.suw_scroll_view);
        if ((r1 instanceof ScrollView) == true) goto L7;
        return null;
    L7:
        return (ScrollView) r1;
    }

    public TextView getHeaderTextView() {
        return ((HeaderMixin) getMixin(HeaderMixin.class)).getTextView();
    }

    public void setHeaderText(int r2) {
        ((HeaderMixin) getMixin(HeaderMixin.class)).setText(r2);
    }

    public void setHeaderText(CharSequence r2) {
        ((HeaderMixin) getMixin(HeaderMixin.class)).setText(r2);
    }

    public CharSequence getHeaderText() {
        return ((HeaderMixin) getMixin(HeaderMixin.class)).getText();
    }

    public void setHeaderColor(ColorStateList r2) {
        ((ColoredHeaderMixin) getMixin(HeaderMixin.class)).setColor(r2);
    }

    public ColorStateList getHeaderColor() {
        return ((ColoredHeaderMixin) getMixin(HeaderMixin.class)).getColor();
    }

    public void setIcon(Drawable r2) {
        ((IconMixin) getMixin(IconMixin.class)).setIcon(r2);
    }

    public Drawable getIcon() {
        return ((IconMixin) getMixin(IconMixin.class)).getIcon();
    }

    public void setPrimaryColor(ColorStateList r2) {
        this.primaryColor = r2;
        updateBackground();
        ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).setColor(r2);
    }

    public ColorStateList getPrimaryColor() {
        return this.primaryColor;
    }

    public void setBackgroundBaseColor(ColorStateList r1) {
        this.backgroundBaseColor = r1;
        updateBackground();
    }

    public ColorStateList getBackgroundBaseColor() {
        return this.backgroundBaseColor;
    }

    public void setBackgroundPatterned(boolean r1) {
        this.backgroundPatterned = r1;
        updateBackground();
    }

    public boolean isBackgroundPatterned() {
        return this.backgroundPatterned;
    }

    private void updateBackground() {
        View r0 = findManagedViewById(R.id.suw_pattern_bg);
        if (r0 == null) goto L20;
        ColorStateList r1 = this.backgroundBaseColor;
        if (r1 == null) goto L7;
        int r2 = r1.getDefaultColor();
    L12:
        if (this.backgroundPatterned == false) goto L14;
        Drawable r3 = new GlifPatternDrawable(r2);
    L16:
        if ((r0 instanceof StatusBarBackgroundLayout) == false) goto L18;
        ((StatusBarBackgroundLayout) r0).setStatusBarBackground(r3);
        return;
    L18:
        r0.setBackgroundDrawable(r3);
        return;
    L14:
        r3 = new ColorDrawable(r2);
        goto L16
    L7:
        ColorStateList r4 = this.primaryColor;
        if (r4 == null) goto L10;
        r2 = r4.getDefaultColor();
        goto L12
    L10:
        r2 = 0;
        goto L12
    }

    public boolean isProgressBarShown() {
        return ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).isShown();
    }

    public void setProgressBarShown(boolean r2) {
        ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).setShown(r2);
    }

    public ProgressBar peekProgressBar() {
        return ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).peekProgressBar();
    }
}
