package obric.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BarsHelper {
    private static final int BAR_ICON_SCALE_DURATION = 200;
    private static final float BAR_ICON_SCALE_NORMAL = 1.0f;
    private static final float BAR_ICON_SCALE_PRESSED = 1.33f;
    public static final float BAR_SPRING_DAMPINGRATIO = 0.55f;
    public static final float BAR_SPRING_STIFFNESS = 800.0f;
    public static final String EXTRA_BACK_BTN_RES_ID = "back_text_id";
    public static final String EXTRA_BACK_BTN_RES_NAME = "back_text_res_name";
    public static final String EXTRA_BACK_BTN_TEXT = "back_text";
    public static final String EXTRA_TITLE_TEXT = "title";
    public static final String EXTRA_TITLE_TEXT_ID = "title_id";
    public static final FloatPropertyCompat<View> SCALE = null;
    public static final int SHADOW_BOTTOM_TYPE = 0;
    public static final int SHADOW_TOP_TYPE = 1;

    public static class BarShadowBuilder implements View.OnLayoutChangeListener {
        private int mBottomShadowHeight;
        private Context mContext;
        private int mDividerHeight;
        private View mDividerView;
        private boolean mIsBottomType;
        private int mShadowResId;
        private View mShadowView;
        private ViewGroup mTargetView;
        private int mTopShadowHeight;

        /* synthetic */ BarShadowBuilder(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private BarShadowBuilder(Context mContext) {
            this.mShadowResId = -1;
            this.mContext = mContext;
            this.mTopShadowHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.title_bar_shadow_height);
            this.mBottomShadowHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.bottom_bar_shadow_height);
            this.mDividerHeight = mContext.getResources().getDimensionPixelSize(R.dimen.bar_divider_height);
        }

        public BarShadowBuilder setShadowType(int type) {
            if (type != 0) goto L4;
            boolean r1 = true;
        L5:
            this.mIsBottomType = r1;
            return this;
        L4:
            r1 = false;
            goto L5
        }

        public BarShadowBuilder setShadowResource(int resId) {
            this.mShadowResId = resId;
            return this;
        }

        public View build(ViewGroup target) {
            this.mTargetView = target;
            if ((target instanceof FrameLayout) == false) goto L6;
            addShadowAndDividerForFrameLayout();
        L8:
            this.mTargetView.addOnLayoutChangeListener(this);
            return this.mShadowView;
        L6:
            if ((target instanceof RelativeLayout) == false) goto L10;
            addShadowAndDividerForRelativeLayout();
            goto L8
        L10:
            return null;
        }

        private View generateShadowView() {
            View r0 = new View(this.mContext);
            if (this.mShadowResId == (-1)) goto L5;
        L9:
            r0.setBackgroundResource(this.mShadowResId);
            if (this.mIsBottomType == false) goto L12;
            int r3 = -this.mBottomShadowHeight;
        L13:
            r0.setTranslationY(r3);
            return r0;
        L12:
            r3 = this.mTopShadowHeight;
            goto L13
        L5:
            if (this.mIsBottomType == false) goto L7;
            int r1 = ShadowFrameLayout.BOTTOM_SHADOW_RES_ID;
        L8:
            this.mShadowResId = r1;
            goto L9
        L7:
            r1 = ShadowFrameLayout.TOP_SHADOW_RES_ID;
            goto L8
        }

        private View generateDividerView() {
            View r0 = new View(this.mContext);
            r0.setBackgroundResource(R.drawable.divider_bg);
            boolean r1 = this.mIsBottomType;
            int r2 = this.mDividerHeight;
            if (r1 == false) goto L5;
            r2 = -r2;
        L5:
            r0.setTranslationY(r2);
            r0.setId(R.id.shadow_divider);
            return r0;
        }

        private void addShadowAndDividerForRelativeLayout() {
            View r0 = generateShadowView();
            this.mShadowView = r0;
            r0.setLayoutParams(generateShadowOrDividerRelativeLayoutParams(true));
            this.mTargetView.addView(this.mShadowView);
            View r1 = generateDividerView();
            this.mDividerView = r1;
            this.mTargetView.addView(r1, generateShadowOrDividerRelativeLayoutParams(false));
            this.mTargetView.setElevation(0.1f);
        }

        private RelativeLayout.LayoutParams generateShadowOrDividerRelativeLayoutParams(boolean isShadowView) {
            if (this.mIsBottomType == false) goto L7;
            if (isShadowView == false) goto L6;
            int r1 = this.mBottomShadowHeight;
        L10:
            RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-1, r1);
            r2.addRule(10);
            return r2;
        L6:
            r1 = this.mDividerHeight;
            goto L10
        L7:
            if (isShadowView == false) goto L9;
            r1 = this.mTopShadowHeight;
            goto L10
        L9:
            r1 = this.mDividerHeight;
            goto L10
        }

        private void addShadowAndDividerForFrameLayout() {
            View r0 = generateShadowView();
            this.mShadowView = r0;
            r0.setLayoutParams(generateShadowOrDividerFrameLayoutParams(true));
            this.mTargetView.addView(this.mShadowView);
            View r1 = generateDividerView();
            this.mDividerView = r1;
            this.mTargetView.addView(r1, generateShadowOrDividerFrameLayoutParams(false));
            this.mTargetView.setElevation(0.1f);
        }

        private FrameLayout.LayoutParams generateShadowOrDividerFrameLayoutParams(boolean isShadowView) {
            if (this.mIsBottomType == false) goto L8;
            if (isShadowView == false) goto L6;
            int r2 = this.mBottomShadowHeight;
        L7:
            int r3 = 48;
        L12:
            FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, r2);
            r0.gravity = r3;
            return r0;
        L6:
            r2 = this.mDividerHeight;
            goto L7
        L8:
            if (isShadowView == false) goto L10;
            r2 = this.mTopShadowHeight;
        L11:
            r3 = 80;
            goto L12
        L10:
            r2 = this.mDividerHeight;
            goto L11
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            ViewGroup r1 = (ViewGroup) this.mTargetView.getParent();
            if (r1 == null) goto L5;
            r1.setClipChildren(false);
        L5:
            ViewGroup r2 = this.mTargetView;
            if ((r2 instanceof RelativeLayout) == true) goto L8;
        L10:
            this.mTargetView.setClipToPadding(false);
            View r3 = this.mShadowView;
            r3.layout(0, r3.getTop(), this.mTargetView.getMeasuredWidth(), this.mShadowView.getBottom());
            View r4 = this.mDividerView;
            r4.layout(0, r4.getTop(), this.mTargetView.getMeasuredWidth(), this.mDividerView.getBottom());
            return;
        L8:
            if (this.mIsBottomType == true) goto L10;
            float r5 = r2.getMeasuredHeight();
            this.mShadowView.setTranslationY(r5);
            this.mDividerView.setTranslationY(r5);
            goto L10
        }
    }

    public static class SpinnerViewBuilder {
        private List<String> mCenterContent;
        private int mCenterLeftIconRef;
        private String mCenterTitle;
        private Context mContext;
        private boolean mIsRangeVerticalScroll;
        private int mSpinnerStyle;
        private String mSubTitle;
        private int mSubTitleTextColor;
        private int mTitleTextColor;

        /* synthetic */ SpinnerViewBuilder(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private SpinnerViewBuilder(Context mContext) {
            this.mSpinnerStyle = 0;
            this.mCenterContent = new ArrayList();
            this.mContext = mContext;
        }

        public SpinnerViewBuilder setSpinnerStyle(int style) {
            this.mSpinnerStyle = style;
            return this;
        }

        public SpinnerViewBuilder setRangeVerticalScroll(boolean rangeVerticalScroll) {
            this.mIsRangeVerticalScroll = rangeVerticalScroll;
            return this;
        }

        public SpinnerViewBuilder setCenterLeftIconRef(int leftIconRef) {
            this.mCenterLeftIconRef = leftIconRef;
            return this;
        }

        public SpinnerViewBuilder setCenterTitle(String centerTitle) {
            this.mCenterTitle = centerTitle;
            return this;
        }

        public SpinnerViewBuilder setSubTitle(String subTitle) {
            this.mSubTitle = subTitle;
            return this;
        }

        public SpinnerViewBuilder setTitleTextColor(int centerTextColor) {
            this.mTitleTextColor = centerTextColor;
            return this;
        }

        public SpinnerViewBuilder setSubTitleTextColor(int subTitleTextColor) {
            this.mSubTitleTextColor = subTitleTextColor;
            return this;
        }

        public SpinnerViewBuilder setCenterContent(List<String> centerContent) {
            this.mCenterContent.clear();
            this.mCenterContent.addAll(centerContent);
            return this;
        }

        public SpinnerView build() {
            boolean r1 = true;
            if (this.mCenterContent.size() > 1) goto L6;
            r1 = false;
        L6:
            this.mIsRangeVerticalScroll = r1;
            SpinnerView r0 = new SpinnerView(this.mContext);
            r0.setSpinnerStyle(this.mSpinnerStyle);
            r0.setIsNeedVerticalScroll(this.mIsRangeVerticalScroll);
            r0.setCenterLeftIcon(this.mCenterLeftIconRef);
            if (this.mCenterContent.size() <= 0) goto L9;
            List<String> r2 = this.mCenterContent;
            r0.setSpinnerPickText((String[]) r2.toArray(new String[r2.size()]), this.mCenterTitle);
        L10:
            r0.setSubContentText(this.mSubTitle);
            return r0;
        L9:
            r0.setSpinnerPickText(null, this.mCenterTitle);
            goto L10
        }
    }

    public static class TabBuilder {
        private static final int MAX_NUM_TAB = 4;
        private TitleBar mBar;
        private int mBigTabWidth;
        private List<Integer> mBtnDrawables;
        private Context mContext;
        private boolean mHasGap;
        private boolean mIsAttachTab;
        private boolean mIsBigFilterTwoTabs;
        private int mNormalTabWidth;
        private int mSpecTabWidth;
        private List<String> mStrData;
        private int mWithDrawableWidth;

        /* synthetic */ TabBuilder(Context r1, TitleBar r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private TabBuilder(Context mContext, TitleBar bar) {
            this.mStrData = new ArrayList();
            this.mBtnDrawables = new ArrayList();
            this.mContext = mContext;
            this.mBar = bar;
            this.mNormalTabWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.filter_tab_normal_width);
            this.mBigTabWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.filter_tab_big_width);
            this.mSpecTabWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.filter_tab_special_width);
            this.mWithDrawableWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.filter_tab_with_drawable_width);
        }

        public TabBuilder setAttachMode(boolean attach) {
            this.mIsAttachTab = attach;
            return this;
        }

        public TabBuilder setBigFilterTwoTabs(boolean biger) {
            this.mIsBigFilterTwoTabs = biger;
            return this;
        }

        public TabBuilder setHasGap(boolean hasGap) {
            this.mHasGap = hasGap;
            return this;
        }

        public TabBuilder setData(List<String> strData, List<Integer> btnDrawables) {
            setStringData(strData);
            setBtnDrawables(btnDrawables);
            return this;
        }

        public TabBuilder setStringData(List<String> strData) {
            this.mStrData.clear();
            this.mStrData.addAll(strData);
            return this;
        }

        public TabBuilder setBtnDrawables(List<Integer> btnDrawables) {
            if (btnDrawables == null) goto L4;
            this.mBtnDrawables.clear();
            this.mBtnDrawables.addAll(btnDrawables);
        L4:
            return this;
        }

        public ButtonTabGroup build() {
            if (this.mStrData.size() > 1) goto L6;
            return null;
        L6:
            ButtonTabGroup r0 = new ButtonTabGroup(this.mContext);
            r0.setButtonDrawable(this.mBtnDrawables);
            r0.setButtonGroupData(this.mStrData, this.mHasGap);
            r0.setup();
            if (this.mIsAttachTab == false) goto L9;
            adjustBytedanceStyle(r0);
        L10:
            return r0;
        L9:
            boolean r1 = true ^ this.mHasGap;
            r0.setLayoutParams(this.mBar.generateSingleCenterViewLayoutParams(r1));
            goto L10
        }

        private void adjustBytedanceStyle(ButtonTabGroup tabs) {
            int r0 = Math.min(this.mStrData.size(), 4);
            if (this.mBtnDrawables.size() == 0) goto L6;
            int r4 = this.mWithDrawableWidth;
        L19:
            tabs.setWidth(r4 * r0);
            return;
        L6:
            if (r0 == 2) goto L8;
        L10:
            boolean r2 = false;
        L11:
            int r3 = this.mNormalTabWidth;
            if (r2 == false) goto L14;
            r4 = this.mBigTabWidth;
            goto L19
        L14:
            if (r0 == 4) goto L16;
        L18:
            r4 = r3;
            goto L19
        L16:
            if (this.mIsAttachTab == false) goto L18;
            r4 = this.mSpecTabWidth;
            goto L19
        L8:
            if (this.mIsBigFilterTwoTabs == false) goto L10;
            r2 = true;
            goto L11
        }
    }

    public BarsHelper() {
    }

    public static SpinnerViewBuilder createSpinnerViewBuilder(Context context) {
        return new SpinnerViewBuilder(context, null);
    }

    public static TabBuilder createTabBuilder(Context context, TitleBar bar) {
        return new TabBuilder(context, bar, null);
    }

    public static BarShadowBuilder createShadowBuilder(Context context) {
        return new BarShadowBuilder(context, null);
    }

    public static ValueAnimator prepareNavigationBarStatusChangeAnim(final View target, boolean show) {
        int r0 = target.getPaddingLeft();
        if (show == false) goto L5;
        int r4 = 0;
    L6:
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{r0, r4});
        r5.addUpdateListener(new AnonymousClass1(target));
        r5.setDuration(200);
        r5.setInterpolator(new DecelerateInterpolator());
        r5.start();
        return r5;
    L5:
        r4 = target.getContext().getResources().getDimensionPixelOffset(R.dimen.bar_and_bottom_sheet_extra_space);
        goto L6
    }

    public static void setBarIconScaleTouchListener(View target) {
        setBarIconScaleTouchListener(target, true);
    }

    static {
        final String r1 = "scale";
        SCALE = new AnonymousClass2(r1);
    }

    public static void setBarIconScaleTouchListener(final View target, boolean enable) {
        target.setClickable(true);
        if (enable == false) goto L5;
        View.OnTouchListener r2 = new AnonymousClass3(target);
    L6:
        target.setOnTouchListener(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
