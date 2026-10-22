package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes5.dex */
public class ShadowFrameLayout extends FrameLayout {
    public static final int BOTTOM_SHADOW_RES_ID = 0;
    public static final int TOP_SHADOW_RES_ID = 0;
    private int mBottomShadowHeight;
    private Context mContext;
    private int mDividerHeight;
    private boolean mIsBottomBar;
    private int mShadowResId;
    private View mShadowView;
    private int mTopShadowHeight;

    static {
        TOP_SHADOW_RES_ID = R.drawable.obric_title_bar_shadow;
        BOTTOM_SHADOW_RES_ID = R.drawable.bottom_bar_shadow;
    }

    public ShadowFrameLayout(Context context) {
        this(context, null);
    }

    public ShadowFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int r0 = TOP_SHADOW_RES_ID;
        this.mShadowResId = r0;
        this.mContext = context;
        this.mTopShadowHeight = getResources().getDimensionPixelOffset(R.dimen.title_bar_shadow_height);
        this.mBottomShadowHeight = getResources().getDimensionPixelOffset(R.dimen.bottom_bar_shadow_height);
        this.mDividerHeight = getResources().getDimensionPixelOffset(R.dimen.bar_divider_height);
        TypedArray r4 = this.mContext.obtainStyledAttributes(attrs, R.styleable.ShadowFrameLayout, defStyleAttr, 0);
        boolean r5 = r4.getBoolean(R.styleable.ShadowFrameLayout_bottom_type, false);
        this.mIsBottomBar = r5;
        if (r5 == false) goto L5;
        r0 = BOTTOM_SHADOW_RES_ID;
    L5:
        this.mShadowResId = r0;
        setElevation(0.1f);
        addShadowAndDividerView();
        r4.recycle();
    }

    public void setShadowBackgroundRes(int id) {
        this.mShadowResId = id;
        notifyShadowChange();
    }

    public void setShadowVisible(boolean visible) {
        View r0 = this.mShadowView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (visible == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    private void notifyShadowChange() {
        View r0 = this.mShadowView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBackgroundResource(this.mShadowResId);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r1 = getParent();
        if ((r1 instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        ((ViewGroup) r1).setClipChildren(false);
    }

    private void addShadowAndDividerView() {
        View r0 = prepareShadowView();
        this.mShadowView = r0;
        addView(r0, prepareShadowOrDividerViewLayoutParams(true));
        addView(prepareDividerView(), prepareShadowOrDividerViewLayoutParams(false));
    }

    private View prepareShadowView() {
        View r0 = new View(this.mContext);
        r0.setBackgroundResource(this.mShadowResId);
        if (this.mIsBottomBar == false) goto L5;
        int r2 = -this.mBottomShadowHeight;
    L6:
        r0.setTranslationY(r2);
        return r0;
    L5:
        r2 = this.mTopShadowHeight;
        goto L6
    }

    private View prepareDividerView() {
        View r0 = new View(this.mContext);
        r0.setBackgroundResource(R.drawable.divider_bg);
        r0.setId(R.id.shadow_divider);
        boolean r1 = this.mIsBottomBar;
        int r2 = this.mDividerHeight;
        if (r1 == false) goto L5;
        r2 = -r2;
    L5:
        r0.setTranslationY(r2);
        return r0;
    }

    private FrameLayout.LayoutParams prepareShadowOrDividerViewLayoutParams(boolean isShadowView) {
        int r0 = this.mDividerHeight;
        if (isShadowView == true) goto L5;
    L9:
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, r0);
        if (this.mIsBottomBar == false) goto L12;
        int r2 = 48;
    L13:
        r3.gravity = r2;
        return r3;
    L12:
        r2 = 80;
        goto L13
    L5:
        if (this.mIsBottomBar == false) goto L7;
        int r4 = this.mBottomShadowHeight;
    L8:
        r0 = r4;
        goto L9
    L7:
        r4 = this.mTopShadowHeight;
        goto L8
    }
}
