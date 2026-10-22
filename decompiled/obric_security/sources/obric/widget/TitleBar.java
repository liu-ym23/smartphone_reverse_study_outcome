package obric.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obric.util.DescriptionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class TitleBar extends RelativeLayout {
    public static final int BACK_ICON_RES = 0;
    private ValueAnimator mAnimator;
    private boolean mAutoAdapterEnabled;
    private boolean mAutoAdjustCenterViewVisibility;
    private boolean mBottomType;
    private View mCenterView;
    private Context mContext;
    private int mDefaultTextSize;
    private boolean mHasLimite;
    private boolean mImageScaleEnable;
    private int mImageViewSize;
    private View mLeftLastView;
    private List<View> mLeftViewList;
    private int mMarginEdgeValue;
    private int mMarginViewValue;
    private View mRightLastView;
    private List<View> mRightViewList;
    private View mShadowView;
    private int mTitleBarCenterLimite;
    private int mTitleBarHeight;
    private TextView mTitleView;

    static {
        BACK_ICON_RES = R.drawable.standard_icon_back_selector;
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAutoAdjustCenterViewVisibility = true;
        this.mImageScaleEnable = true;
        this.mContext = context;
        this.mMarginEdgeValue = context.getResources().getDimensionPixelOffset(R.dimen.bar_margin_edge);
        this.mMarginViewValue = this.mContext.getResources().getDimensionPixelOffset(R.dimen.title_bar_margin_view);
        this.mImageViewSize = this.mContext.getResources().getDimensionPixelOffset(R.dimen.standard_icon_size);
        this.mTitleBarHeight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.obric_title_bar_height);
        this.mTitleBarCenterLimite = this.mContext.getResources().getDimensionPixelOffset(R.dimen.title_bar_center_limite);
        this.mDefaultTextSize = this.mContext.getResources().getDimensionPixelOffset(R.dimen.title_bar_title_size);
        TypedArray r3 = this.mContext.obtainStyledAttributes(attrs, R.styleable.TitleBar, defStyleAttr, 0);
        if (r3.hasValue(R.styleable.TitleBar_title_bar_center_text) == false) goto L5;
        setCenterText(r3.getString(R.styleable.TitleBar_title_bar_center_text));
    L5:
        this.mBottomType = r3.getBoolean(R.styleable.TitleBar_title_bar_bottom_type, false);
        r3.recycle();
        setBackgroundAndShadow();
    }

    private void setBackgroundAndShadow() {
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.titlebar_bg_color));
        int r0 = !this.mBottomType ? 1 : 0;
        this.mShadowView = BarsHelper.createShadowBuilder(this.mContext).setShadowType(r0).build(this);
        setElevation(0.11f);
    }

    public void setShadowVisible(boolean visible) {
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

    public View getShadowView() {
        return this.mShadowView;
    }

    public void setCenterView(View view) {
        if (view != null) goto L4;
        return;
    L4:
        setCenterView(view, findLayoutParams(view, true));
    }

    private void setCenterView(View view, RelativeLayout.LayoutParams params) {
        if (this.mCenterView != view) goto L5;
        return;
    L5:
        removeCenterView();
        this.mCenterView = view;
        addView(view, params);
    }

    public void setAutoAdjustCenterViewVisibility(boolean auto) {
        this.mAutoAdjustCenterViewVisibility = auto;
    }

    private void setCenterViewVisibility(int visibility) {
        if (this.mAutoAdjustCenterViewVisibility == false) goto L6;
        this.mCenterView.setVisibility(visibility);
        return;
    }

    public boolean isCenterTitleTextView() {
        View r0 = this.mCenterView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0 != this.mTitleView) goto L7;
        return true;
    }

    public void setCenterText(int resId) {
        setCenterText(this.mContext.getString(resId));
    }

    public void setCenterText(String title) {
        getTitleViewOrCreate().setText(title);
    }

    public void setCenterTextColor(int color) {
        getTitleViewOrCreate().setTextColor(color);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    private TextView getTitleViewOrCreate() {
        View r0 = this.mCenterView;
        if (r0 == null) goto L8;
        TextView r1 = this.mTitleView;
        if (r0 != r1) goto L8;
        return r1;
    L8:
        if (this.mTitleView != null) goto L11;
        this.mTitleView = generateTitleView();
    L11:
        if (this.mCenterView == null) goto L13;
        removeCenterView();
    L13:
        addView(this.mTitleView, generateCenterViewLayoutParams());
        TextView r2 = this.mTitleView;
        this.mCenterView = r2;
        return r2;
    }

    private void removeCenterView() {
        View r0 = this.mCenterView;
        if (r0 == null) goto L6;
        removeView(r0);
        this.mCenterView = null;
        return;
    }

    private TextView generateTitleView() {
        TextView r0 = new TextView(this.mContext);
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setTextSize(this.mDefaultTextSize);
        r0.setPaintFlags(33);
        r0.setTextColor(this.mContext.getResources().getColor(R.color.title_or_btn_text_color));
        return r0;
    }

    private RelativeLayout.LayoutParams generateCenterViewLayoutParams() {
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) generateDefaultLayoutParams();
        r1.addRule(13);
        return r1;
    }

    public RelativeLayout.LayoutParams generateSingleCenterViewLayoutParams(boolean needMargin) {
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-1, -1);
        int r1 = 0;
        if (needMargin == false) goto L5;
        int r2 = this.mMarginEdgeValue;
    L6:
        r0.leftMargin = r2;
        if (needMargin == false) goto L9;
        r1 = this.mMarginEdgeValue;
    L9:
        r0.rightMargin = r1;
        return r0;
    L5:
        r2 = 0;
        goto L6
    }

    public void addLeftView(View view) {
        addLeftView(view, findLayoutParams(view, false), -1);
    }

    private void addLeftView(View view, RelativeLayout.LayoutParams layoutParams, int index) {
        if (this.mHasLimite == false) goto L5;
        return;
    L5:
        layoutParams.alignWithParent = true;
        view.setId(View.generateViewId());
        if (this.mLeftLastView == null) goto L8;
        if (index >= 0) goto L14;
    L19:
        index = this.mLeftViewList.size();
        layoutParams.addRule(1, this.mLeftLastView.getId());
        layoutParams.leftMargin = this.mMarginViewValue;
    L20:
        layoutParams.addRule(15);
        List<View> r0 = this.mLeftViewList;
        if (r0 != null) goto L23;
    L24:
        this.mLeftLastView = view;
    L25:
        getLeftViewListOrCreate().add(index, view);
        addView(view, layoutParams);
        return;
    L23:
        if (index != r0.size()) goto L25;
    L14:
        if (index >= this.mLeftViewList.size()) goto L19;
        if (index != 0) goto L18;
        layoutParams.leftMargin = this.mMarginEdgeValue;
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) this.mLeftViewList.get(index).getLayoutParams();
        r1.removeRule(9);
        r1.addRule(1, view.getId());
        goto L20
    L18:
        View r2 = this.mLeftViewList.get(index - 1);
        View r3 = this.mLeftViewList.get(index);
        layoutParams.addRule(1, r2.getId());
        layoutParams.leftMargin = this.mMarginViewValue;
        ((RelativeLayout.LayoutParams) r3.getLayoutParams()).addRule(1, view.getId());
        goto L20
    L8:
        if ((view instanceof Button) == false) goto L10;
        int r6 = 0;
    L11:
        layoutParams.leftMargin = r6;
        layoutParams.addRule(9);
        index = 0;
        goto L20
    L10:
        r6 = this.mMarginEdgeValue;
        goto L11
    }

    private List<View> getLeftViewListOrCreate() {
        if (this.mLeftViewList != null) goto L6;
        this.mLeftViewList = new ArrayList();
    L6:
        return this.mLeftViewList;
    }

    public void removeAllLeftViews() {
        if (this.mLeftLastView != null) goto L5;
        return;
    L5:
        Iterator<View> r0 = this.mLeftViewList.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        removeViewInLayout(r0.next());
        goto L7
    L9:
        this.mLeftLastView = null;
        this.mLeftViewList.clear();
        requestLayout();
        invalidate();
    }

    public void removeLeftView(int index) {
        if (index >= 0) goto L4;
        return;
    L4:
        if (index < this.mLeftViewList.size()) goto L7;
        return;
    L7:
        if (index != 0) goto L13;
        int r1 = index + 1;
        if (r1 >= this.mLeftViewList.size()) goto L11;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) this.mLeftViewList.get(r1).getLayoutParams();
        r2.removeRule(1);
        r2.addRule(9);
    L16:
        removeView(this.mLeftViewList.get(index));
        this.mLeftViewList.remove(index);
        return;
    L11:
        this.mLeftLastView = null;
        goto L16
    L13:
        if (index != (this.mLeftViewList.size() - 1)) goto L15;
        this.mLeftLastView = this.mLeftViewList.get(index - 1);
        goto L16
    L15:
        ((RelativeLayout.LayoutParams) this.mLeftViewList.get(index + 1).getLayoutParams()).addRule(1, this.mLeftViewList.get(index - 1).getId());
        goto L16
    }

    public void addRightView(View view) {
        addRightView(view, findLayoutParams(view, false), -1);
    }

    private void addRightView(View view, RelativeLayout.LayoutParams layoutParams, int index) {
        if (this.mHasLimite == false) goto L5;
        return;
    L5:
        layoutParams.alignWithParent = true;
        view.setId(View.generateViewId());
        if (this.mRightLastView == null) goto L8;
        if (index >= 0) goto L14;
    L19:
        index = this.mRightViewList.size();
        layoutParams.addRule(0, this.mRightLastView.getId());
        layoutParams.rightMargin = this.mMarginViewValue;
    L20:
        layoutParams.addRule(15);
        List<View> r0 = this.mRightViewList;
        if (r0 != null) goto L23;
    L24:
        this.mRightLastView = view;
    L25:
        getRightViewListOrCreate().add(index, view);
        addView(view, layoutParams);
        return;
    L23:
        if (index != r0.size()) goto L25;
    L14:
        if (index >= this.mRightViewList.size()) goto L19;
        if (index != 0) goto L18;
        layoutParams.rightMargin = this.mMarginEdgeValue;
        layoutParams.addRule(11);
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) this.mRightViewList.get(index).getLayoutParams();
        r1.removeRule(11);
        r1.addRule(0, view.getId());
        goto L20
    L18:
        View r2 = this.mRightViewList.get(index - 1);
        View r3 = this.mRightViewList.get(index);
        layoutParams.addRule(0, r2.getId());
        layoutParams.rightMargin = this.mMarginViewValue;
        ((RelativeLayout.LayoutParams) r3.getLayoutParams()).addRule(0, view.getId());
        goto L20
    L8:
        if ((view instanceof Button) == false) goto L10;
        int r6 = 0;
    L11:
        layoutParams.rightMargin = r6;
        layoutParams.addRule(11);
        index = 0;
        goto L20
    L10:
        r6 = this.mMarginEdgeValue;
        goto L11
    }

    private List<View> getRightViewListOrCreate() {
        if (this.mRightViewList != null) goto L6;
        this.mRightViewList = new ArrayList();
    L6:
        return this.mRightViewList;
    }

    public void removeAllRightViews() {
        if (this.mRightLastView != null) goto L5;
        return;
    L5:
        Iterator<View> r0 = this.mRightViewList.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        removeViewInLayout(r0.next());
        goto L7
    L9:
        this.mRightLastView = null;
        this.mRightViewList.clear();
        requestLayout();
        invalidate();
    }

    public void removeRightView(int index) {
        if (index >= 0) goto L4;
        return;
    L4:
        if (index < this.mRightViewList.size()) goto L7;
        return;
    L7:
        if (index != 0) goto L13;
        int r1 = index + 1;
        if (r1 >= this.mRightViewList.size()) goto L11;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) this.mRightViewList.get(r1).getLayoutParams();
        r2.removeRule(0);
        r2.addRule(11);
    L16:
        removeView(this.mRightViewList.get(index));
        this.mRightViewList.remove(index);
        return;
    L11:
        this.mRightLastView = null;
        goto L16
    L13:
        if (index != (this.mRightViewList.size() - 1)) goto L15;
        this.mRightLastView = this.mRightViewList.get(index - 1);
        goto L16
    L15:
        ((RelativeLayout.LayoutParams) this.mRightViewList.get(index + 1).getLayoutParams()).addRule(0, this.mRightViewList.get(index - 1).getId());
        goto L16
    }

    public ImageView addLeftImageView(int drawableId) {
        return addLeftImageView(drawableId, -1);
    }

    public ImageView addLeftImageView(int drawableId, int index) {
        ImageView r2 = generateImageView(drawableId);
        addLeftView(r2, generateImageViewLayoutParams(), index);
        return r2;
    }

    public Button addLeftButton(int style, int resId) {
        Button r2 = generateBytedanceButton(style, getResources().getString(resId));
        addLeftView(r2);
        return r2;
    }

    public boolean hasLeftView() {
        return hasView(this.mLeftViewList);
    }

    public int getLeftViewCount() {
        return getViewCount(this.mLeftViewList);
    }

    public View getLeftViewByIndex(int index) {
        return getViewByIndex(index, this.mLeftViewList);
    }

    public ImageView addRightImageView(int drawableId) {
        return addRightImageView(drawableId, -1);
    }

    public ImageView addRightImageView(int drawableId, int index) {
        ImageView r2 = generateImageView(drawableId);
        addRightView(r2, generateImageViewLayoutParams(), index);
        return r2;
    }

    public Button addRightButton(int style, int resId) {
        Button r2 = generateBytedanceButton(style, getResources().getString(resId));
        addRightView(r2);
        return r2;
    }

    public boolean hasRightView() {
        return hasView(this.mRightViewList);
    }

    public int getRightViewCount() {
        return getViewCount(this.mRightViewList);
    }

    public View getRightViewByIndex(int index) {
        return getViewByIndex(index, this.mRightViewList);
    }

    private boolean hasView(List<View> list) {
        if (list != null) goto L5;
    L13:
        return false;
    L5:
        if (list.size() <= 0) goto L13;
        int r0 = list.size();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L13;
        if (list.get(r1).getVisibility() != 8) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return true;
    }

    private View getViewByIndex(int index, List<View> list) {
        if (list == null) goto L15;
        if (index >= 0) goto L5;
        return null;
    L5:
        if (index >= list.size()) goto L22;
        int r5 = list.size();
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r0 >= r5) goto L23;
        View r2 = list.get(r0);
        if (r2.getVisibility() == 8) goto L14;
        int r3 = r1 + 1;
        if (index == r1) goto L12;
        r1 = r3;
        goto L14
    L12:
        return r2;
    L14:
        r0 = r0 + 1;
        goto L7
    L23:
        return null;
    L22:
        return null;
    L15:
        return null;
    }

    private int getViewCount(List<View> list) {
        int r4 = 0;
        if (list != null) goto L5;
        return 0;
    L5:
        if (list.size() <= 0) goto L18;
        int r0 = list.size();
        int r1 = 0;
    L7:
        if (r4 >= r0) goto L13;
        if (list.get(r4).getVisibility() == 8) goto L11;
        r1 = r1 + 1;
    L11:
        r4 = r4 + 1;
        goto L7
    L13:
        return r1;
    L18:
        return 0;
    }

    protected ImageView generateImageView(int id) {
        ImageView r0 = new ImageView(this.mContext);
        r0.setImageResource(id);
        boolean r3 = DescriptionUtils.applyDescriptionIfNeed(r0, id);
        if (this.mImageScaleEnable == false) goto L6;
        if (r3 == true) goto L6;
        BarsHelper.setBarIconScaleTouchListener(r0);
    L6:
        return r0;
    }

    protected Button generateBytedanceButton(int style, String text) {
        Button r0 = new Button(this.mContext);
        r0.setButtonStyle(style);
        r0.setButtonText(text);
        return r0;
    }

    protected RelativeLayout.LayoutParams generateImageViewLayoutParams() {
        int r1 = this.mImageViewSize;
        return new RelativeLayout.LayoutParams(r1, r1);
    }

    private RelativeLayout.LayoutParams findLayoutParams(View view, boolean centerView) {
        ViewGroup.LayoutParams r2 = view.getLayoutParams();
        if ((r2 instanceof RelativeLayout.LayoutParams) == true) goto L10;
        if (centerView == false) goto L7;
        ViewGroup.LayoutParams r1 = generateCenterViewLayoutParams();
    L9:
        return (RelativeLayout.LayoutParams) r1;
    L7:
        r1 = generateDefaultLayoutParams();
        goto L9
    L10:
        return (RelativeLayout.LayoutParams) r2;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int r15 = View.MeasureSpec.makeMeasureSpec(this.mTitleBarHeight, 1073741824);
        super.onMeasure(widthMeasureSpec, r15);
        if (this.mCenterView != null) goto L5;
        return;
    L5:
        List<View> r0 = this.mLeftViewList;
        int r1 = 8;
        boolean r2 = true;
        if (r0 == null) goto L26;
        int r3 = r0.size();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        boolean r7 = false;
    L8:
        if (r4 >= r3) goto L27;
        View r8 = this.mLeftViewList.get(r4);
        if (r8.getVisibility() == 8) goto L25;
        RelativeLayout.LayoutParams r9 = (RelativeLayout.LayoutParams) r8.getLayoutParams();
        int r10 = r6 + 1;
        if (r6 != 0) goto L15;
        int r11 = this.mMarginEdgeValue;
    L16:
        if (r4 != 0) goto L22;
        if ((r8 instanceof Button) == false) goto L20;
        r11 = 0;
        goto L22
    L20:
        r5 = r5 + this.mMarginEdgeValue;
    L22:
        if (r9.leftMargin == r11) goto L24;
        r9.leftMargin = r11;
        r7 = true;
    L24:
        r5 = r5 + (r8.getMeasuredWidth() + this.mMarginViewValue);
        r6 = r10;
        goto L25
    L15:
        r11 = this.mMarginViewValue;
    L25:
        r4 = r4 + 1;
    L27:
        List<View> r12 = this.mRightViewList;
        if (r12 == null) goto L48;
        int r13 = r12.size();
        int r14 = 0;
        int r16 = 0;
        int r17 = 0;
    L30:
        if (r14 >= r13) goto L49;
        View r18 = this.mRightViewList.get(r14);
        if (r18.getVisibility() == 8) goto L47;
        RelativeLayout.LayoutParams r19 = (RelativeLayout.LayoutParams) r18.getLayoutParams();
        int r110 = r17 + 1;
        if (r17 != 0) goto L37;
        int r20 = this.mMarginEdgeValue;
    L38:
        if (r14 != 0) goto L44;
        if ((r18 instanceof Button) == false) goto L42;
        r20 = 0;
        goto L44
    L42:
        r16 = r16 + this.mMarginEdgeValue;
    L44:
        if (r19.rightMargin == r20) goto L46;
        r19.rightMargin = r20;
        r7 = true;
    L46:
        r16 = r16 + (r18.getMeasuredWidth() + this.mMarginViewValue);
        r17 = r110;
        goto L47
    L37:
        r20 = this.mMarginViewValue;
    L47:
        r14 = r14 + 1;
    L49:
        int r21 = Math.max(r5, r16);
        int r22 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r23 = r22 - (r21 * 2);
        if (r21 == 0) goto L52;
        r23 = r23 + (this.mMarginViewValue * 2);
    L52:
        int r24 = (r22 - r5) - r16;
        if (r21 > this.mTitleBarCenterLimite) goto L56;
        r1 = 0;
    L56:
        setCenterViewVisibility(r1);
        if (this.mCenterView.getMeasuredWidth() <= r23) goto L59;
        boolean r25 = true;
    L60:
        if (r25 == false) goto L63;
        limiteCenterViewWidth(r23);
        r7 = true;
    L63:
        if (r24 < this.mImageViewSize) goto L66;
        r2 = false;
    L66:
        this.mHasLimite = r2;
        if (r7 == false) goto L76;
        super.onMeasure(widthMeasureSpec, r15);
        return;
    L76:
        return;
    L59:
        r25 = false;
        goto L60
    L48:
        r16 = 0;
        goto L49
    L26:
        r5 = 0;
        r7 = false;
        goto L27
    }

    private void limiteCenterViewWidth(int validSpace) {
        View r0 = this.mCenterView;
        TextView r1 = this.mTitleView;
        if (r0 != r1) goto L6;
        r1.setMaxWidth(validSpace);
        return;
    L6:
        if ((r0 instanceof SpinnerView) == false) goto L9;
        ((SpinnerView) r0).setPickerAvailWidth(validSpace);
        return;
    L9:
        if ((r0 instanceof RadioGroup) == false) goto L11;
        ((RadioGroup) r0).setAvailWidth(validSpace);
        return;
    L11:
        r0.getLayoutParams().width = validSpace;
    }

    public void setAutoAdapterEnabled(boolean enabled) {
        this.mAutoAdapterEnabled = enabled;
    }

    public boolean isAutoAdapterEnabled() {
        return this.mAutoAdapterEnabled;
    }

    public void setTitleBarHeight(int height) {
        this.mTitleBarHeight = height;
    }

    public void setImageScaleEnable(boolean enable) {
        this.mImageScaleEnable = enable;
    }

    public void avoidImageViewScale(ImageView target) {
        BarsHelper.setBarIconScaleTouchListener(target, false);
    }
}
