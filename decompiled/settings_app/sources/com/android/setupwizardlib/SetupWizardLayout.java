package com.android.setupwizardlib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.setupwizardlib.template.HeaderMixin;
import com.android.setupwizardlib.template.NavigationBarMixin;
import com.android.setupwizardlib.template.ProgressBarMixin;
import com.android.setupwizardlib.template.RequireScrollMixin;
import com.android.setupwizardlib.template.ScrollViewScrollHandlingDelegate;
import com.android.setupwizardlib.view.Illustration;
import com.android.setupwizardlib.view.NavigationBar;

/* JADX INFO: loaded from: classes.dex */
public class SetupWizardLayout extends TemplateLayout {
    private static final String TAG = "SetupWizardLayout";

    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isProgressBarShown;

        public SavedState(Parcelable r1) {
            super(r1);
            this.isProgressBarShown = false;
        }

        public SavedState(Parcel r2) {
            super(r2);
            boolean r0 = false;
            this.isProgressBarShown = false;
            if (r2.readInt() == 0) goto L5;
            r0 = true;
        L5:
            this.isProgressBarShown = r0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.isProgressBarShown ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public SetupWizardLayout(Context r2) {
        super(r2, 0, 0);
        init(null, R.attr.suwLayoutTheme);
    }

    public SetupWizardLayout(Context r2, int r3) {
        this(r2, r3, 0);
    }

    public SetupWizardLayout(Context r1, int r2, int r3) {
        super(r1, r2, r3);
        init(null, R.attr.suwLayoutTheme);
    }

    public SetupWizardLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2, R.attr.suwLayoutTheme);
    }

    public SetupWizardLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2, r3);
    }

    private void init(AttributeSet r4, int r5) {
        registerMixin(HeaderMixin.class, new HeaderMixin(this, r4, r5));
        registerMixin(ProgressBarMixin.class, new ProgressBarMixin(this));
        registerMixin(NavigationBarMixin.class, new NavigationBarMixin(this));
        RequireScrollMixin r0 = new RequireScrollMixin(this);
        registerMixin(RequireScrollMixin.class, r0);
        ScrollView r1 = getScrollView();
        if (r1 == null) goto L5;
        r0.setScrollHandlingDelegate(new ScrollViewScrollHandlingDelegate(r0, r1));
    L5:
        TypedArray r6 = getContext().obtainStyledAttributes(r4, R.styleable.SuwSetupWizardLayout, r5, 0);
        Drawable r7 = r6.getDrawable(R.styleable.SuwSetupWizardLayout_suwBackground);
        if (r7 == null) goto L8;
        setLayoutBackground(r7);
    L11:
        Drawable r8 = r6.getDrawable(R.styleable.SuwSetupWizardLayout_suwIllustration);
        if (r8 == null) goto L14;
        setIllustration(r8);
    L18:
        int r9 = r6.getDimensionPixelSize(R.styleable.SuwSetupWizardLayout_suwDecorPaddingTop, -1);
        if (r9 != (-1)) goto L21;
        r9 = getResources().getDimensionPixelSize(R.dimen.suw_decor_padding_top);
    L21:
        setDecorPaddingTop(r9);
        float r10 = r6.getFloat(R.styleable.SuwSetupWizardLayout_suwIllustrationAspectRatio, -1.0f);
        if (r10 != (-1.0f)) goto L24;
        TypedValue r11 = new TypedValue();
        getResources().getValue(R.dimen.suw_illustration_aspect_ratio, r11, true);
        r10 = r11.getFloat();
    L24:
        setIllustrationAspectRatio(r10);
        r6.recycle();
        return;
    L14:
        Drawable r12 = r6.getDrawable(R.styleable.SuwSetupWizardLayout_suwIllustrationImage);
        Drawable r2 = r6.getDrawable(R.styleable.SuwSetupWizardLayout_suwIllustrationHorizontalTile);
        if (r12 == null) goto L18;
        if (r2 == null) goto L18;
        setIllustration(r12, r2);
        goto L18
    L8:
        Drawable r13 = r6.getDrawable(R.styleable.SuwSetupWizardLayout_suwBackgroundTile);
        if (r13 == null) goto L11;
        setBackgroundTile(r13);
        goto L11
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.isProgressBarShown = isProgressBarShown();
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof SavedState) == true) goto L6;
        Log.w(TAG, "Ignoring restore instance state " + r3);
        super.onRestoreInstanceState(r3);
        return;
    L6:
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        setProgressBarShown(r4.isProgressBarShown);
    }

    @Override // com.android.setupwizardlib.TemplateLayout
    protected View onInflateTemplate(LayoutInflater r2, int r3) {
        if (r3 != 0) goto L5;
        r3 = R.layout.suw_template;
    L5:
        return inflateTemplate(r2, R.style.SuwThemeMaterial_Light, r3);
    }

    @Override // com.android.setupwizardlib.TemplateLayout
    protected ViewGroup findContainer(int r1) {
        if (r1 != 0) goto L5;
        r1 = R.id.suw_layout_content;
    L5:
        return super.findContainer(r1);
    }

    public NavigationBar getNavigationBar() {
        return ((NavigationBarMixin) getMixin(NavigationBarMixin.class)).getNavigationBar();
    }

    public ScrollView getScrollView() {
        View r1 = findManagedViewById(R.id.suw_bottom_scroll_view);
        if ((r1 instanceof ScrollView) == true) goto L7;
        return null;
    L7:
        return (ScrollView) r1;
    }

    public void requireScrollToBottom() {
        RequireScrollMixin r0 = (RequireScrollMixin) getMixin(RequireScrollMixin.class);
        NavigationBar r1 = getNavigationBar();
        if (r1 == null) goto L5;
        r0.requireScrollWithNavigationBar(r1);
        return;
    L5:
        Log.e(TAG, "Cannot require scroll. Navigation bar is null.");
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

    public TextView getHeaderTextView() {
        return ((HeaderMixin) getMixin(HeaderMixin.class)).getTextView();
    }

    public void setIllustration(Drawable r2) {
        View r1 = findManagedViewById(R.id.suw_layout_decor);
        if ((r1 instanceof Illustration) == false) goto L6;
        ((Illustration) r1).setIllustration(r2);
        return;
    }

    public void setIllustration(int r3, int r4) {
        View r0 = findManagedViewById(R.id.suw_layout_decor);
        if ((r0 instanceof Illustration) == false) goto L6;
        ((Illustration) r0).setIllustration(getIllustration(r3, r4));
        return;
    }

    private void setIllustration(Drawable r3, Drawable r4) {
        View r0 = findManagedViewById(R.id.suw_layout_decor);
        if ((r0 instanceof Illustration) == false) goto L6;
        ((Illustration) r0).setIllustration(getIllustration(r3, r4));
        return;
    }

    public void setIllustrationAspectRatio(float r2) {
        View r1 = findManagedViewById(R.id.suw_layout_decor);
        if ((r1 instanceof Illustration) == false) goto L6;
        ((Illustration) r1).setAspectRatio(r2);
        return;
    }

    public void setDecorPaddingTop(int r4) {
        View r3 = findManagedViewById(R.id.suw_layout_decor);
        if (r3 == null) goto L6;
        r3.setPadding(r3.getPaddingLeft(), r4, r3.getPaddingRight(), r3.getPaddingBottom());
        return;
    }

    public void setLayoutBackground(Drawable r2) {
        View r1 = findManagedViewById(R.id.suw_layout_decor);
        if (r1 == null) goto L6;
        r1.setBackgroundDrawable(r2);
        return;
    }

    public void setBackgroundTile(int r2) {
        setBackgroundTile(getContext().getResources().getDrawable(r2));
    }

    private void setBackgroundTile(Drawable r4) {
        if ((r4 instanceof BitmapDrawable) == false) goto L5;
        ((BitmapDrawable) r4).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    L5:
        setLayoutBackground(r4);
    }

    private Drawable getIllustration(int r3, int r4) {
        Context r0 = getContext();
        return getIllustration(r0.getResources().getDrawable(r3), r0.getResources().getDrawable(r4));
    }

    private Drawable getIllustration(Drawable r4, Drawable r5) {
        if (getContext().getResources().getBoolean(R.bool.suwUseTabletLayout) == true) goto L5;
        r4.setAutoMirrored(true);
        return r4;
    L5:
        if ((r5 instanceof BitmapDrawable) == false) goto L8;
        BitmapDrawable r3 = (BitmapDrawable) r5;
        r3.setTileModeX(Shader.TileMode.REPEAT);
        r3.setGravity(48);
    L8:
        if ((r4 instanceof BitmapDrawable) == false) goto L10;
        ((BitmapDrawable) r4).setGravity(51);
    L10:
        LayerDrawable r6 = new LayerDrawable(new Drawable[]{r5, r4});
        r6.setAutoMirrored(true);
        return r6;
    }

    public boolean isProgressBarShown() {
        return ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).isShown();
    }

    public void setProgressBarShown(boolean r2) {
        ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).setShown(r2);
    }

    @Deprecated
    public void showProgressBar() {
        setProgressBarShown(true);
    }

    @Deprecated
    public void hideProgressBar() {
        setProgressBarShown(false);
    }

    public void setProgressBarColor(ColorStateList r2) {
        ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).setColor(r2);
    }

    public ColorStateList getProgressBarColor() {
        return ((ProgressBarMixin) getMixin(ProgressBarMixin.class)).getColor();
    }
}
