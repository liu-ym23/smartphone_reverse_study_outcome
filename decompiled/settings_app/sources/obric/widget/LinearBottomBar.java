package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class LinearBottomBar extends LinearLayout {
    private BottomBarInnerClickCallBack mBottomCallBack;
    private ImageButton[] mBottomItems;
    private int mButtonMarginLeft;
    private int mFixedBtnHeight;
    private boolean mForceRemeasureChild;
    private int[] mIconRefArray;
    private boolean mIconRefShowBackgroudMode;
    private ShadowComponent mShadowComponent;
    private int mWidth;

    public interface BottomBarInnerClickCallBack {
        void onClick(int index, View view);
    }

    static /* synthetic */ void access$000(LinearBottomBar r0) {
        r0.buildItems();
    }

    static /* synthetic */ BottomBarInnerClickCallBack access$100(LinearBottomBar r0) {
        return r0.mBottomCallBack;
    }

    public void setBottomInnerClickListener(BottomBarInnerClickCallBack bottomCallback) {
        this.mBottomCallBack = bottomCallback;
    }

    public LinearBottomBar(Context context) {
        this(context, null);
    }

    public LinearBottomBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearBottomBar(Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.SmartisanBottomBar);
        int r0 = r4.getResourceId(R.styleable.SmartisanBottomBar_bottomBarIconArray, -1);
        this.mIconRefShowBackgroudMode = r4.getBoolean(R.styleable.SmartisanBottomBar_bottomBarIconShowBackgroudMode, false);
        r4.recycle();
        this.mShadowComponent = new AnonymousClass1(this, this, attrs, defStyleAttr);
        setBackgroundResource(R.drawable.bottom_bar);
        int r5 = getContext().getResources().getDimensionPixelSize(R.dimen.obric_small_blank_spacing_width);
        setPadding(r5, 0, r5, 0);
        this.mFixedBtnHeight = getContext().getResources().getDimensionPixelSize(R.dimen.samrtisan_button_fixed_height);
        if (r0 < 0) goto L6;
        setIconRefArray(r0, this.mIconRefShowBackgroudMode);
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        post(new AnonymousClass2(this));
    }

    private LinearLayout.LayoutParams getIconParams(int index) {
        if (((Boolean) this.mBottomItems[index].getTag()).booleanValue() == false) goto L5;
        int r1 = this.mFixedBtnHeight;
    L6:
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r1, this.mFixedBtnHeight);
        ImageButton[] r2 = this.mBottomItems;
        if (r2 != null) goto L9;
    L18:
        return r0;
    L9:
        if (r2.length <= 0) goto L18;
        if (r2.length != 1) goto L13;
        r0.gravity = 17;
        goto L18
    L13:
        r0.gravity = 16;
        if (index != 0) goto L16;
        int r3 = 0;
    L17:
        r0.leftMargin = r3;
        goto L18
    L16:
        r3 = this.mButtonMarginLeft;
        goto L17
    L5:
        r1 = -2;
        goto L6
    }

    private void buildItems() {
        if (this.mBottomItems != null) goto L6;
        return;
    L6:
        if (getWidth() > 0) goto L8;
        return;
    L8:
        if (getWidth() == this.mWidth) goto L31;
        this.mWidth = getWidth();
        ImageButton[] r0 = this.mBottomItems;
        int r2 = 0;
        if (r0.length <= 1) goto L22;
        int r1 = r0.length;
        int r4 = 0;
        int r5 = 0;
    L13:
        if (r4 >= r1) goto L21;
        ImageButton r6 = r0[r4];
        int r7 = getShrinkDistance(r6, true);
        if (r7 != getShrinkDistance(r6, false)) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L20;
        r7 = this.mFixedBtnHeight;
    L20:
        r5 = r5 + r7;
        r6.setTag(Boolean.valueOf(r8));
        r4 = r4 + 1;
        goto L13
    L17:
        r8 = false;
        goto L18
    L21:
        this.mButtonMarginLeft = (int) ((((this.mWidth - getPaddingLeft()) - getPaddingRight()) - r5) / (this.mBottomItems.length - 1));
    L22:
        ImageButton[] r3 = this.mBottomItems;
        if (r2 >= r3.length) goto L32;
        r3[r2].setLayoutParams(getIconParams(r2));
        r2 = r2 + 1;
        goto L22
    L32:
        return;
    }

    private int getShrinkDistance(View view, boolean isWidth) {
        if (view != null) goto L6;
        return 0;
    L6:
        if (this.mForceRemeasureChild == false) goto L8;
    L11:
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L12:
        if (isWidth == false) goto L15;
        return view.getMeasuredWidth();
    L15:
        return view.getMeasuredHeight();
    L8:
        if (view.getMeasuredWidth() <= 0) goto L11;
        if (view.getMeasuredHeight() > 0) goto L12;
        goto L11
    }

    private void createItems() {
        ImageButton[] r0 = this.mBottomItems;
        if (r0 == null) goto L7;
        if (r0.length != this.mIconRefArray.length) goto L7;
        return;
    L7:
        if (getChildCount() <= 0) goto L9;
        removeAllViews();
    L9:
        this.mBottomItems = new ImageButton[this.mIconRefArray.length];
        final int r1 = 0;
    L11:
        if (r1 >= this.mIconRefArray.length) goto L21;
        this.mBottomItems[r1] = new ImageButton(getContext());
        this.mBottomItems[r1].setBackgroundColor(0);
        if (this.mIconRefShowBackgroudMode == false) goto L15;
        this.mBottomItems[r1].setBackgroundResource(this.mIconRefArray[r1]);
    L16:
        this.mBottomItems[r1].setOnClickListener(new AnonymousClass3(this, r1));
        addView(this.mBottomItems[r1]);
        r1 = r1 + 1;
        goto L11
    L15:
        this.mBottomItems[r1].setImageResource(this.mIconRefArray[r1]);
        goto L16
    }

    public void setIconRefArray(int[] iconRefArray, boolean iconRefArrayShowBackgroudMode) {
        if (iconRefArray != null) goto L4;
        return;
    L4:
        if (iconRefArray.length <= 0) goto L9;
        this.mIconRefShowBackgroudMode = iconRefArrayShowBackgroudMode;
        this.mIconRefArray = iconRefArray;
        createItems();
        buildItems();
        return;
    }

    public void setIconRefArray(int[] iconRefArray) {
        if (iconRefArray != null) goto L4;
        return;
    L4:
        if (iconRefArray.length <= 0) goto L9;
        setIconRefArray(iconRefArray, false);
        return;
    }

    public void setIconRefArray(int arrayRef, boolean iconRefShowBackgroudMode) {
        int[] r1 = getArrayResId(arrayRef);
        this.mIconRefShowBackgroudMode = iconRefShowBackgroudMode;
        setIconRefArray(r1, iconRefShowBackgroudMode);
    }

    public void setIconRefArray(int arrayRef) {
        setIconRefArray(getArrayResId(arrayRef));
    }

    private int[] getArrayResId(int arrayRef) {
        TypedArray r3 = getContext().getResources().obtainTypedArray(arrayRef);
        int r4 = r3.length();
        int[] r0 = new int[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = r3.getResourceId(r1, -1);
        r1 = r1 + 1;
        goto L3
    L5:
        r3.recycle();
        return r0;
    }

    public ImageButton getBottomItem(int index) {
        ImageButton[] r0 = this.mBottomItems;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0[index];
    }

    public ImageButton[] getBottomItems() {
        return this.mBottomItems;
    }

    public void setShadowDrawable(int resId) {
        this.mShadowComponent.setShadowDrawable(resId);
    }

    public void setShadowVisible(boolean visible) {
        this.mShadowComponent.setShadowVisible(visible);
    }

    public ImageView getShadowView() {
        return this.mShadowComponent.getShadowView();
    }

    public void setForceRemeasureChild(boolean forceRemeasureChild) {
        this.mForceRemeasureChild = forceRemeasureChild;
    }
}
