package obric.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BottomBar extends FrameLayout implements View.OnLongClickListener, View.OnClickListener {
    public static final int NONE = -1;
    public static final int STYLE_ALIGN_EDGE = 1;
    public static final int STYLE_BOTTOM_TAB = 2;
    public static final int STYLE_DEFAULT = 0;
    private int mAlignEdgeItemWidth;
    private ValueAnimator mAnimator;
    private boolean mAutoAdapterEnabled;
    private List<BarItem> mBarList;
    private int mCheckedId;
    private BottomBarItemView.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private boolean mHasTextAndIcon;
    private int mHeightOnlyIcon;
    private int mHeightWithTextIcon;
    private LinearLayout mItemViewContainer;
    private int mItemWidth;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private View.OnClickListener mOnClickListener;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mScalable;
    private View mShadowView;
    private int mStyleFlag;

    public class BarItem {
        private int mColorStateList;
        private int mContentDescription;
        private int mDrawableId;
        private int mTabId;
        private String mTabName;
        private ColorStateList mTextColorStateList;
        private int mTextSize;
        final /* synthetic */ BottomBar this$0;

        /* synthetic */ BarItem(BottomBar r1, int r2, String r3, int r4, int r5, ColorStateList r6, AnonymousClass1 r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        static /* synthetic */ int access$1000(BarItem r0) {
            return r0.mColorStateList;
        }

        static /* synthetic */ int access$400(BarItem r0) {
            return r0.mTabId;
        }

        static /* synthetic */ int access$500(BarItem r0) {
            return r0.mDrawableId;
        }

        static /* synthetic */ int access$600(BarItem r0) {
            return r0.mContentDescription;
        }

        static /* synthetic */ String access$700(BarItem r0) {
            return r0.mTabName;
        }

        static /* synthetic */ ColorStateList access$800(BarItem r0) {
            return r0.mTextColorStateList;
        }

        static /* synthetic */ int access$900(BarItem r0) {
            return r0.mTextSize;
        }

        private BarItem(final BottomBar this$0, int id, String name, int drawableId, int colorStateList, ColorStateList textColorStateList) {
            this.this$0 = this$0;
            this.mContentDescription = -1;
            this.mTextSize = -1;
            this.mTabId = id;
            this.mTabName = name;
            this.mDrawableId = drawableId;
            this.mColorStateList = colorStateList;
            this.mTextColorStateList = textColorStateList;
        }

        public void setContentDescription(int contentDescription) {
            this.mContentDescription = contentDescription;
        }

        public void setTextSize(int size) {
            this.mTextSize = size;
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(ViewGroup parent, int checkedId);
    }

    static /* synthetic */ int access$000(BottomBar r0) {
        return r0.mCheckedId;
    }

    static /* synthetic */ int access$002(BottomBar r0, int r1) {
        r0.mCheckedId = r1;
        return r1;
    }

    static /* synthetic */ void access$100(BottomBar r0, int r1, boolean r2) {
        r0.setCheckedStateForView(r1, r2);
    }

    static /* synthetic */ OnCheckedChangeListener access$200(BottomBar r0) {
        return r0.mOnCheckedChangeListener;
    }

    static /* synthetic */ LinearLayout access$300(BottomBar r0) {
        return r0.mItemViewContainer;
    }

    public BottomBar(Context context) {
        super(context);
        this.mCheckedId = -1;
        this.mHasTextAndIcon = false;
        this.mStyleFlag = 0;
        init(context, null, 0);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCheckedId = -1;
        this.mHasTextAndIcon = false;
        this.mStyleFlag = 0;
        init(context, attrs, 0);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCheckedId = -1;
        this.mHasTextAndIcon = false;
        this.mStyleFlag = 0;
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mBarList = new ArrayList();
        this.mHeightOnlyIcon = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_height_only_icon);
        this.mHeightWithTextIcon = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_height);
        this.mAlignEdgeItemWidth = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_align_edge_width);
        this.mChildOnCheckedChangeListener = new AnonymousClass1(this);
        this.mShadowView = BarsHelper.createShadowBuilder(context).setShadowType(0).build(this);
        setBackgroundColor(-1);
    }

    public void setDefaultSelectedItem(int itemId) {
        if (itemId != this.mCheckedId) goto L5;
        return;
    L5:
        setCheckedStateForView(itemId, true);
        this.mCheckedId = itemId;
    }

    private void setCheckedStateForView(int viewId, boolean checked) {
        LinearLayout r0 = this.mItemViewContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = r0.findViewById(viewId);
        if (r1 == null) goto L9;
        ((BottomBarItemView) r1).setChecked(checked);
        return;
    }

    public void setStyleFlag(int flag) {
        this.mStyleFlag = flag;
    }

    public void setup() {
        setup(this.mScalable);
    }

    public void setup(boolean scaleable) {
        LinearLayout r0 = this.mItemViewContainer;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        this.mScalable = scaleable;
        if (this.mBarList.size() > 0) goto L8;
        return;
    L8:
        this.mItemViewContainer = generateItemViewContainer();
        int r7 = this.mBarList.size();
        int r1 = 0;
    L9:
        if (r1 >= r7) goto L15;
        BottomBarItemView r2 = generateBottomBarItemView(this.mBarList.get(r1));
        int r4 = this.mItemWidth;
        if (this.mHasTextAndIcon == false) goto L13;
        int r5 = this.mHeightWithTextIcon;
    L14:
        this.mItemViewContainer.addView(r2, new LinearLayout.LayoutParams(r4, r5));
        r1 = r1 + 1;
        goto L9
    L13:
        r5 = this.mHeightOnlyIcon;
        goto L14
    L15:
        fillStyle();
        addView(this.mItemViewContainer);
        BottomBarItemView r8 = (BottomBarItemView) this.mItemViewContainer.findViewById(this.mCheckedId);
        if (this.mCheckedId == (-1)) goto L18;
        if (r8 == null) goto L18;
    L19:
        r8.setChecked(true);
        return;
    L18:
        r8 = (BottomBarItemView) this.mItemViewContainer.getChildAt(0);
        goto L19
    }

    private void fillStyle() {
        int r0 = this.mBarList.size();
        int r1 = this.mStyleFlag;
        int r4 = 0;
        if ((r1 & 1) != 1) goto L12;
    L4:
        if (r4 >= r0) goto L30;
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) this.mItemViewContainer.getChildAt(r4).getLayoutParams();
        r2.width = this.mAlignEdgeItemWidth;
        if (r4 == 0) goto L10;
        if (r4 == (this.mBarList.size() - 1)) goto L10;
        r2.weight = 1.0f;
    L10:
        r4 = r4 + 1;
        goto L4
    L30:
        return;
    L12:
        if ((r1 & 2) == 2) goto L14;
        return;
    L14:
        if (r0 >= 3) goto L16;
        return;
    L16:
        int r3 = (int) ((((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mAlignEdgeItemWidth * r0)) / ((r0 - 1) * 1.0f));
    L17:
        if (r4 >= r0) goto L31;
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) this.mItemViewContainer.getChildAt(r4).getLayoutParams();
        r5.width = this.mAlignEdgeItemWidth;
        if (r4 == 0) goto L21;
        r5.leftMargin = r3;
    L21:
        r4 = r4 + 1;
        goto L17
    }

    private BottomBarItemView generateBottomBarItemView(BarItem item) {
        BottomBarItemView r0 = new BottomBarItemView(getContext());
        r0.setScaleable(this.mScalable);
        r0.setId(BarItem.access$400(item));
        r0.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        r0.setOnLongClickListener(this);
        r0.setOnClickListener(this);
        if (BarItem.access$500(item) == (-1)) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L11:
        boolean r2 = !TextUtils.isEmpty(BarItem.access$700(item));
        this.mHasTextAndIcon = r2;
        if (r2 == false) goto L17;
        r0.setText(BarItem.access$700(item));
        r0.setTextColor(BarItem.access$800(item));
        if (BarItem.access$900(item) == (-1)) goto L17;
        r0.setTextSize(BarItem.access$900(item));
    L17:
        if (BarItem.access$1000(item) == (-1)) goto L19;
        r0.setDrawableColorList(BarItem.access$1000(item));
    L19:
        return r0;
    L8:
        if (BarItem.access$600(item) == (-1)) goto L10;
        r0.setDrawableResource(BarItem.access$500(item), getResources().getString(BarItem.access$600(item)));
        goto L11
    L10:
        r0.setDrawableResource(BarItem.access$500(item));
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private LinearLayout generateItemViewContainer() {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(0);
        r0.setGravity(17);
        return r0;
    }

    public View getShadowView() {
        return this.mShadowView;
    }

    public void setShadowViewVisible(boolean visible) {
        View r0 = this.mShadowView;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener listener) {
        this.mOnLongClickListener = listener;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        View.OnLongClickListener r0 = this.mOnLongClickListener;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onLongClick(view);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        View.OnClickListener r0 = this.mOnClickListener;
        if (r0 == null) goto L6;
        r0.onClick(v);
        return;
    }

    public BarItem addBarItem(int id, String name, int drawableId, int colorStateList, ColorStateList textColorStateList) {
        BarItem r8 = new BarItem(this, id, name, drawableId, colorStateList, textColorStateList, null);
        this.mBarList.add(r8);
        return r8;
    }

    public BarItem addBarItem(int id, String name, int drawableId, int colorStateList) {
        return addBarItem(id, name, drawableId, colorStateList, getResources().getColorStateList(R.color.bottom_tab_text_color));
    }

    public BarItem addBarItem(int id, String name, int drawableId) {
        return addBarItem(id, name, drawableId, -1);
    }

    public void clearItems() {
        this.mBarList.clear();
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        fillStyle();
    }

    public void setAutoAdapterEnabled(boolean enabled) {
        this.mAutoAdapterEnabled = enabled;
    }

    public boolean isAutoAdapterEnabled() {
        return this.mAutoAdapterEnabled;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int r0 = getMeasuredWidth();
        int r1 = getMeasuredHeight();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int r2 = getMeasuredWidth();
        int r3 = getMeasuredHeight();
        int r4 = 0;
        if (r0 != r2) goto L7;
        if (r1 != r3) goto L7;
        boolean r5 = false;
    L9:
        if (this.mItemViewContainer != null) goto L11;
        return;
    L11:
        this.mItemWidth = getMeasuredWidth() / 5;
        int r6 = this.mItemViewContainer.getChildCount();
    L12:
        if (r4 >= r6) goto L18;
        BottomBarItemView r7 = (BottomBarItemView) this.mItemViewContainer.getChildAt(r4);
        r7.getLayoutParams().width = this.mItemWidth;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (this.mHasTextAndIcon == false) goto L16;
        int r9 = this.mHeightWithTextIcon;
    L17:
        r8.height = r9;
        r4 = r4 + 1;
        goto L12
    L16:
        r9 = this.mHeightOnlyIcon;
        goto L17
    L18:
        fillStyle();
        if (r5 == false) goto L25;
        this.mItemViewContainer.forceLayout();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        return;
    L25:
        return;
    L7:
        r5 = true;
        goto L9
    }
}
