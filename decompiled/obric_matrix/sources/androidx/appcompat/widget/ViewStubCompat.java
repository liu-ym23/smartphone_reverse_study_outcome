package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewStubCompat extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    public interface OnInflateListener {
        void onInflate(ViewStubCompat r1, View r2);
    }

    public ViewStubCompat(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ViewStubCompat(@NonNull Context r3, @Nullable AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mLayoutResource = 0;
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.ViewStubCompat, r5, 0);
        this.mInflatedId = r6.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = r6.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(r6.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        r6.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas r1) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas r1) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == false) goto L24;
        if (this.mLayoutResource == 0) goto L22;
        ViewGroup r1 = (ViewGroup) r0;
        LayoutInflater r2 = this.mInflater;
        if (r2 != null) goto L10;
        r2 = LayoutInflater.from(getContext());
    L10:
        View r3 = r2.inflate(this.mLayoutResource, r1, false);
        int r4 = this.mInflatedId;
        if (r4 == (-1)) goto L13;
        r3.setId(r4);
    L13:
        int r5 = r1.indexOfChild(this);
        r1.removeViewInLayout(this);
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if (r6 == null) goto L16;
        r1.addView(r3, r5, r6);
    L17:
        this.mInflatedViewRef = new WeakReference(r3);
        OnInflateListener r7 = this.mInflateListener;
        if (r7 == null) goto L20;
        r7.onInflate(this, r3);
    L20:
        return r3;
    L16:
        r1.addView(r3, r5);
        goto L17
    L22:
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    L24:
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    protected void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int r1) {
        this.mInflatedId = r1;
    }

    public void setLayoutInflater(LayoutInflater r1) {
        this.mInflater = r1;
    }

    public void setLayoutResource(int r1) {
        this.mLayoutResource = r1;
    }

    public void setOnInflateListener(OnInflateListener r1) {
        this.mInflateListener = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        WeakReference<View> r0 = this.mInflatedViewRef;
        if (r0 == null) goto L9;
        View r1 = r0.get();
        if (r1 == null) goto L8;
        r1.setVisibility(r2);
        return;
    L8:
        throw new IllegalStateException("setVisibility called on un-referenced view");
    L9:
        super.setVisibility(r2);
        if (r2 != 0) goto L12;
    L13:
        inflate();
        return;
    L12:
        if (r2 == 4) goto L13;
    }
}
