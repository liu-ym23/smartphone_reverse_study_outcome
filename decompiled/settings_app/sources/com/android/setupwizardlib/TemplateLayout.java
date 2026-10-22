package com.android.setupwizardlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.android.setupwizardlib.template.Mixin;
import com.android.setupwizardlib.util.FallbackThemeWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TemplateLayout extends FrameLayout {
    private ViewGroup container;
    private final Map<Class<? extends Mixin>, Mixin> mixins;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private float xFraction;

    @Deprecated
    protected int getContainerId() {
        return 0;
    }

    protected void onTemplateInflated() {
    }

    static /* synthetic */ ViewTreeObserver.OnPreDrawListener access$000(TemplateLayout r0) {
        return r0.preDrawListener;
    }

    static /* synthetic */ float access$100(TemplateLayout r0) {
        return r0.xFraction;
    }

    public TemplateLayout(Context r2, int r3, int r4) {
        super(r2);
        this.mixins = new HashMap();
        init(r3, r4, null, R.attr.suwLayoutTheme);
    }

    public TemplateLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mixins = new HashMap();
        init(0, 0, r3, R.attr.suwLayoutTheme);
    }

    public TemplateLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mixins = new HashMap();
        init(0, 0, r2, r3);
    }

    private void init(int r4, int r5, AttributeSet r6, int r7) {
        TypedArray r8 = getContext().obtainStyledAttributes(r6, R.styleable.SuwTemplateLayout, r7, 0);
        if (r4 != 0) goto L5;
        r4 = r8.getResourceId(R.styleable.SuwTemplateLayout_android_layout, 0);
    L5:
        if (r5 != 0) goto L7;
        r5 = r8.getResourceId(R.styleable.SuwTemplateLayout_suwContainer, 0);
    L7:
        inflateTemplate(r4, r5);
        r8.recycle();
    }

    protected <M extends Mixin> void registerMixin(Class<M> r1, M r2) {
        this.mixins.put(r1, r2);
    }

    public <T extends View> T findManagedViewById(int r1) {
        return (T) findViewById(r1);
    }

    public <M extends Mixin> M getMixin(Class<M> r1) {
        return (M) this.mixins.get(r1);
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        this.container.addView(r1, r2, r3);
    }

    private void addViewInternal(View r3) {
        super.addView(r3, -1, generateDefaultLayoutParams());
    }

    private void inflateTemplate(int r2, int r3) {
        addViewInternal(onInflateTemplate(LayoutInflater.from(getContext()), r2));
        ViewGroup r4 = findContainer(r3);
        this.container = r4;
        if (r4 == null) goto L7;
        onTemplateInflated();
        return;
    L7:
        throw new IllegalArgumentException("Container cannot be null in TemplateLayout");
    }

    protected final View inflateTemplate(LayoutInflater r2, int r3, int r4) {
        if (r4 == 0) goto L8;
        if (r3 == 0) goto L6;
        r2 = LayoutInflater.from(new FallbackThemeWrapper(r2.getContext(), r3));
    L6:
        return r2.inflate(r4, this, false);
    L8:
        throw new IllegalArgumentException("android:layout not specified for TemplateLayout");
    }

    protected View onInflateTemplate(LayoutInflater r2, int r3) {
        return inflateTemplate(r2, 0, r3);
    }

    protected ViewGroup findContainer(int r1) {
        if (r1 != 0) goto L5;
        r1 = getContainerId();
    L5:
        return (ViewGroup) findViewById(r1);
    }

    public void setXFraction(float r2) {
        this.xFraction = r2;
        int r0 = getWidth();
        if (r0 == 0) goto L6;
        setTranslationX(r0 * r2);
        return;
    L6:
        if (this.preDrawListener != null) goto L10;
        this.preDrawListener = new AnonymousClass1(this);
        getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        return;
    }

    public float getXFraction() {
        return this.xFraction;
    }
}
