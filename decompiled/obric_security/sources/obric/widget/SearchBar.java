package obric.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import obric.util.DescriptionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SearchBar extends RelativeLayout implements View.OnClickListener {
    private static final int ANIM_DURATION_ALL = 300;
    private static final int ANIM_DURATION_ITEM = 200;
    private static final int ITEM_START_DELAY = 100;
    public static final int SORTING_ICON = 0;
    private static final String TAG = null;
    private AnimationListenr animationListenr;
    private boolean hasSecondaryFilter;
    private boolean hasShadow;
    private boolean isAutoFocus;
    private boolean isWithAnimation;
    private int mAnimDistance;
    private ImageView mCancelButton;
    private int mCancelButtonWidth;
    private View mClearTextView;
    private boolean mFocusableInit;
    private boolean mHasSearchLeftIcon;
    private boolean mHasSearchRightView;
    private boolean mImageScaleEnable;
    private int mImageViewSize;
    private boolean mInitShowCancelButton;
    private boolean mIsPlayingAnimation;
    private boolean mIsSearchMode;
    private ImageView mLeftImageView;
    private Listener mListener;
    private int mMarginToEach;
    private int mMarginToParent;
    private int mMarginToSearchView;
    private RelativeLayout mParentLayout;
    private LinearLayout mRightViewContainer;
    private int mRightViewWidth;
    private View mSearchEditLayout;
    private SearchBarEditText mSearchEditor;
    private boolean mSearchEnable;
    private View mSearchLeftIcon;
    private ImageView mSearchRightView;
    private TextView mSecondaryFilterBtn;
    private View mSecondaryFilterDivider;
    private View mSecondaryFilterLayout;
    private View mShadowView;
    private OnCancelClickListener onCancelClickListener;
    private OnCommitCompletionListener onCommitCompletionListener;
    private OnEditorClickListener onEditorClickListener;
    private OnFilterClickListener onFilterClickListener;
    private OnSearchIconClickListener onSearchIconClickListener;
    private OnSecondaryFilterClickListener onSecondaryFilterClickListener;

    public interface AnimationListenr {
        void onAnimationEnd();

        void onAnimationStart();
    }

    @Deprecated
    private interface Listener {
        void exeAnimationEnd();

        void exeAnimationStart();

        void onClickCancelButton();

        void onClickSearchEdit();

        void onClickSearchLeftIcon();

        void onClickSearchRightView();

        void searchText(String trimText);
    }

    @Deprecated
    public static class ListenerAdapter implements Listener {
        @Override // obric.widget.SearchBar.Listener
        public void exeAnimationEnd() {
        }

        @Override // obric.widget.SearchBar.Listener
        public void exeAnimationStart() {
        }

        @Override // obric.widget.SearchBar.Listener
        public void onClickCancelButton() {
        }

        @Override // obric.widget.SearchBar.Listener
        public void onClickSearchEdit() {
        }

        @Override // obric.widget.SearchBar.Listener
        public void onClickSearchLeftIcon() {
        }

        @Override // obric.widget.SearchBar.Listener
        public void onClickSearchRightView() {
        }

        @Override // obric.widget.SearchBar.Listener
        public void searchText(String trimText) {
        }

        public ListenerAdapter() {
        }
    }

    public interface OnCancelClickListener {
        void onClick(View v);
    }

    public interface OnCommitCompletionListener {
        void onCommitCompletion(CompletionInfo text);
    }

    public interface OnEditorClickListener {
        void onClick(View v);
    }

    public interface OnFilterClickListener {
        void onClick(View v);
    }

    public interface OnSearchIconClickListener {
        void onClick(View v);
    }

    public interface OnSecondaryFilterClickListener {
        void onClick(View v);
    }

    static /* synthetic */ OnCommitCompletionListener access$000(SearchBar r0) {
        return r0.onCommitCompletionListener;
    }

    static /* synthetic */ void access$100(SearchBar r0) {
        r0.onClickSearchRightView();
    }

    static /* synthetic */ void access$1000(SearchBar r0) {
        r0.updateEditorStatus();
    }

    static /* synthetic */ Listener access$200(SearchBar r0) {
        return r0.mListener;
    }

    static /* synthetic */ View access$300(SearchBar r0) {
        return r0.mClearTextView;
    }

    static /* synthetic */ boolean access$402(SearchBar r0, boolean r1) {
        r0.mIsPlayingAnimation = r1;
        return r1;
    }

    static /* synthetic */ ImageView access$500(SearchBar r0) {
        return r0.mCancelButton;
    }

    static /* synthetic */ LinearLayout access$600(SearchBar r0) {
        return r0.mRightViewContainer;
    }

    static /* synthetic */ AnimationListenr access$700(SearchBar r0) {
        return r0.animationListenr;
    }

    static /* synthetic */ void access$800(SearchBar r0, boolean r1) {
        r0.resetSearchViewParam(r1);
    }

    static /* synthetic */ void access$900(SearchBar r0, boolean r1) {
        r0.resetSecondaryFilterParam(r1);
    }

    static {
        SORTING_ICON = R.drawable.standard_icon_filter_selector;
        TAG = "SearchBar";
    }

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mIsSearchMode = false;
        this.mIsPlayingAnimation = false;
        this.mHasSearchRightView = false;
        this.mHasSearchLeftIcon = true;
        this.mInitShowCancelButton = false;
        this.mFocusableInit = false;
        this.mSearchEnable = true;
        this.isAutoFocus = true;
        this.isWithAnimation = true;
        this.hasShadow = true;
        this.hasSecondaryFilter = false;
        this.mImageScaleEnable = true;
        LayoutInflater.from(context).inflate(R.layout.search_bar, this, true);
        this.mMarginToParent = getResources().getDimensionPixelOffset(R.dimen.bar_margin_edge);
        this.mMarginToEach = getResources().getDimensionPixelOffset(R.dimen.search_bar_margin_each);
        this.mMarginToSearchView = getResources().getDimensionPixelOffset(R.dimen.search_bar_margin_search_view);
        this.mAnimDistance = getResources().getDimensionPixelOffset(R.dimen.search_bar_anim_distance);
        initViews(context, attrs);
    }

    private void initViews(Context context, AttributeSet attrs) {
        this.mCancelButton = (ImageView) findViewById(R.id.search_bar_cancel_button);
        this.mRightViewContainer = (LinearLayout) findViewById(R.id.search_bar_right_view_container);
        this.mSearchEditLayout = findViewById(R.id.search_bar_edit_layout);
        this.mSearchLeftIcon = findViewById(R.id.search_bar_left_icon);
        this.mClearTextView = findViewById(R.id.search_bar_clear_text);
        this.mSearchEditor = (SearchBarEditText) findViewById(R.id.search_bar_edit_text);
        this.mSecondaryFilterLayout = findViewById(R.id.search_bar_secondary_filter);
        this.mSecondaryFilterBtn = (TextView) findViewById(R.id.search_bar_secondary_filter_btn);
        this.mSecondaryFilterDivider = findViewById(R.id.search_bar_secondary_filter_divider);
        this.mImageViewSize = getContext().getResources().getDimensionPixelOffset(R.dimen.standard_icon_size);
        TypedArray r5 = context.obtainStyledAttributes(attrs, R.styleable.SearchBar);
        Drawable r6 = r5.getDrawable(R.styleable.SearchBar_searchBarBackground);
        if (r6 == null) goto L5;
        setBackground(r6);
    L6:
        Drawable r7 = r5.getDrawable(R.styleable.SearchBar_editBackground);
        if (r7 == null) goto L9;
        this.mSearchEditLayout.setBackground(r7);
    L9:
        Drawable r8 = r5.getDrawable(R.styleable.SearchBar_cancelBackground);
        if (r8 == null) goto L12;
        this.mCancelButton.setImageDrawable(r8);
    L12:
        Drawable r9 = r5.getDrawable(R.styleable.SearchBar_leftIcon);
        if (r9 == null) goto L15;
        this.mSearchLeftIcon.setBackground(r9);
    L15:
        int r10 = r5.getResourceId(R.styleable.SearchBar_rightIcon, -1);
        if (r10 <= 0) goto L18;
        this.mSearchRightView = addRightImageView(r10);
    L18:
        int r0 = 0;
        if (r5.getBoolean(R.styleable.SearchBar_hasRightIcon, false) == true) goto L21;
    L23:
        this.mSearchEditor.setHint(r5.getString(R.styleable.SearchBar_hintText));
        this.mSearchEditLayout.setOnClickListener(this);
        this.mCancelButton.setOnClickListener(this);
        if (this.mImageScaleEnable == false) goto L26;
        BarsHelper.setBarIconScaleTouchListener(this.mCancelButton);
    L26:
        this.mSearchLeftIcon.setOnClickListener(this);
        this.mSearchEditor.setOnClickListener(this);
        this.mClearTextView.setOnClickListener(this);
        this.mSecondaryFilterLayout.setOnClickListener(this);
        this.mSearchEditor.setListener(new AnonymousClass1(this));
        this.mSearchEditor.setAccessibilityDelegate(new AnonymousClass2(this));
        ImageView r11 = this.mSearchRightView;
        if (r11 == null) goto L29;
        r11.setOnClickListener(new AnonymousClass3(this));
        this.mSearchRightView.setAccessibilityDelegate(new AnonymousClass4(this));
    L29:
        this.mSearchEditor.setOnEditorActionListener(new AnonymousClass5(this));
        this.mSearchEditor.addTextChangedListener(new AnonymousClass6(this));
        boolean r12 = r5.getBoolean(R.styleable.SearchBar_hasLeftIcon, true);
        this.mHasSearchLeftIcon = r12;
        View r2 = this.mSearchLeftIcon;
        if (r12 == false) goto L32;
        int r13 = 0;
    L33:
        r2.setVisibility(r13);
        this.mInitShowCancelButton = r5.getBoolean(R.styleable.SearchBar_hasCancelButton, false);
        this.mFocusableInit = r5.getBoolean(R.styleable.SearchBar_focusableInit, false);
        this.isAutoFocus = r5.getBoolean(R.styleable.SearchBar_autoFocus, true);
        this.isWithAnimation = r5.getBoolean(R.styleable.SearchBar_withAnimation, true);
        this.hasShadow = r5.getBoolean(R.styleable.SearchBar_hasShadow, true);
        this.hasSecondaryFilter = r5.getBoolean(R.styleable.SearchBar_hasSecondaryFilter, false);
        setMinimumHeight(getResources().getDimensionPixelOffset(R.dimen.obric_title_bar_height));
        initViews();
        initWhenFocusable();
        r5.recycle();
        View r14 = BarsHelper.createShadowBuilder(getContext()).build(this);
        this.mShadowView = r14;
        if (this.hasShadow == true) goto L37;
        r0 = 8;
    L37:
        r14.setVisibility(r0);
        return;
    L32:
        r13 = 8;
        goto L33
    L21:
        if (this.mSearchRightView != null) goto L23;
        this.mSearchRightView = addRightImageView(SORTING_ICON);
        goto L23
    L5:
        setBackgroundColor(-1);
        goto L6
    }

    public void addShadow() {
        this.mShadowView.setVisibility(0);
    }

    public void removeShadow() {
        this.mShadowView.setVisibility(8);
    }

    public View getShadowView() {
        return this.mShadowView;
    }

    private void initViews() {
        boolean r0 = this.mInitShowCancelButton;
        if (r0 == true) goto L5;
    L9:
        ImageView r1 = this.mCancelButton;
        if (r0 == false) goto L12;
        int r2 = 0;
    L13:
        r1.setVisibility(r2);
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) this.mSearchEditLayout.getLayoutParams();
        if (this.mInitShowCancelButton == false) goto L16;
        int r4 = this.mCancelButton.getId();
    L17:
        r3.addRule(0, r4);
        if (this.mHasSearchRightView == false) goto L20;
    L22:
        resetSecondaryFilterParam(false);
        return;
    L20:
        if (this.mInitShowCancelButton == true) goto L22;
        r3.rightMargin = this.mMarginToParent;
        goto L22
    L16:
        r4 = this.mRightViewContainer.getId();
        goto L17
    L12:
        r2 = 8;
        goto L13
    L5:
        if (this.mHasSearchRightView == false) goto L9;
        throw new IllegalArgumentException("The cancel button and the filter button can not be presented at the same time.");
    }

    private void initWhenFocusable() {
        if (this.mFocusableInit == true) goto L5;
        return;
    L5:
        this.mIsSearchMode = true;
        updateEditorStatus();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int r3 = v.getId();
        if (r3 != R.id.search_bar_edit_text) goto L5;
    L19:
        onClickSearchEditor(true);
        return;
    L5:
        if (r3 == R.id.search_bar_edit_layout) goto L19;
        if (r3 != R.id.search_bar_cancel_button) goto L11;
        onClickCancelView(true);
        return;
    L11:
        if (r3 != R.id.search_bar_clear_text) goto L14;
        onClickClearView();
        return;
    L14:
        if (r3 != R.id.search_bar_left_icon) goto L17;
        onClickSearchLeftIcon();
        return;
    L17:
        if (r3 != R.id.search_bar_secondary_filter) goto L24;
        onClickSecondaryFilter();
        return;
    }

    public void onClickSecondaryFilter() {
        OnSecondaryFilterClickListener r0 = this.onSecondaryFilterClickListener;
        if (r0 == null) goto L5;
        r0.onClick(this.mSecondaryFilterLayout);
    L5:
        onClickSearchEditor(true);
    }

    public void onClickSearchEditor(boolean animation) {
        Listener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onClickSearchEdit();
    L5:
        OnEditorClickListener r1 = this.onEditorClickListener;
        if (r1 == null) goto L9;
        r1.onClick(this.mSearchEditor);
    L9:
        if (this.mSearchEnable == true) goto L11;
        return;
    L11:
        if (this.mIsSearchMode == false) goto L13;
        return;
    L13:
        if (this.mIsPlayingAnimation == false) goto L16;
        if (animation == false) goto L16;
        return;
    L16:
        this.mIsSearchMode = true;
        if (isWithAnimation() == false) goto L20;
        startAnimation(true);
        return;
    L20:
        if (isAutoFocus() == false) goto L26;
        updateEditorStatus();
        return;
    }

    @Deprecated
    private void onClickSearchRightView() {
        Listener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onClickSearchRightView();
    L5:
        OnFilterClickListener r1 = this.onFilterClickListener;
        if (r1 == null) goto L9;
        r1.onClick(this.mSearchRightView);
        return;
    }

    private void onClickClearView() {
        this.mSearchEditor.setText(null);
    }

    private void onClickSearchLeftIcon() {
        Listener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onClickSearchLeftIcon();
    L5:
        OnSearchIconClickListener r1 = this.onSearchIconClickListener;
        if (r1 == null) goto L9;
        r1.onClick(this.mSearchLeftIcon);
        return;
    }

    private void updateEditorStatus() {
        this.mSearchEditor.setFocusable(this.mIsSearchMode);
        this.mSearchEditor.setCursorVisible(this.mIsSearchMode);
        this.mSearchEditor.setFocusableInTouchMode(this.mIsSearchMode);
        if (this.mIsSearchMode == false) goto L5;
        this.mSearchEditor.requestFocus();
        return;
    L5:
        TextKeyListener.clear(this.mSearchEditor.getText());
    }

    public void startAnimation(final boolean toSearchMode) {
        this.mIsSearchMode = toSearchMode;
        initViewWidth();
        if (toSearchMode == false) goto L5;
        resetSecondaryFilterParam(toSearchMode);
    L5:
        int r2 = getOffsetX(toSearchMode);
        DecelerateInterpolator r3 = new DecelerateInterpolator(1.5f);
        View r4 = this.mSearchEditLayout;
        ObjectAnimator r5 = ObjectAnimator.ofInt(r4, "right", new int[]{r4.getRight(), this.mSearchEditLayout.getRight() + r2});
        boolean r6 = this.mHasSearchRightView;
        if (r6 == false) goto L8;
        if (toSearchMode == false) goto L8;
    L10:
        r5.setStartDelay(100);
        r5.setDuration(200);
    L12:
        AnimatorSet r7 = new AnimatorSet();
        if (toSearchMode == false) goto L15;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this.mCancelButton, View.TRANSLATION_X, new float[]{this.mAnimDistance, 0.0f});
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.mCancelButton, View.ALPHA, new float[]{0.0f, 1.0f});
        r7.setStartDelay(100);
        r7.play(r10).with(r11);
    L16:
        r7.setDuration(200);
        r7.addListener(new AnonymousClass7(this, toSearchMode));
        if (this.mHasSearchRightView == false) goto L23;
        AnimatorSet r12 = new AnimatorSet();
        if (toSearchMode == false) goto L21;
        r12.play(ObjectAnimator.ofFloat(this.mRightViewContainer, View.TRANSLATION_X, new float[]{0.0f, this.mAnimDistance})).with(ObjectAnimator.ofFloat(this.mRightViewContainer, View.ALPHA, new float[]{1.0f, 0.0f}));
    L22:
        r12.setDuration(200);
        r12.addListener(new AnonymousClass8(this, toSearchMode));
    L24:
        AnimatorSet r8 = new AnimatorSet();
        r8.setInterpolator(r3);
        r8.addListener(new AnonymousClass9(this, toSearchMode));
        AnimatorSet.Builder r0 = r8.play(r7);
        if (r2 == 0) goto L27;
        r0.with(r5);
    L27:
        if (r12 == null) goto L29;
        r0.with(r12);
    L29:
        r8.start();
        return;
    L21:
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mRightViewContainer, View.TRANSLATION_X, new float[]{this.mAnimDistance, 0.0f});
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.mRightViewContainer, View.ALPHA, new float[]{0.0f, 1.0f});
        r12.setStartDelay(100);
        r12.play(r9).with(r13);
        goto L22
    L23:
        r12 = null;
        goto L24
    L15:
        r7.play(ObjectAnimator.ofFloat(this.mCancelButton, View.TRANSLATION_X, new float[]{0.0f, this.mAnimDistance})).with(ObjectAnimator.ofFloat(this.mCancelButton, View.ALPHA, new float[]{1.0f, 0.0f}));
    L8:
        if (toSearchMode == true) goto L11;
        if (r6 == false) goto L10;
    L11:
        r5.setDuration(300);
        goto L12
    }

    private void initViewWidth() {
        if (this.mCancelButtonWidth != 0) goto L5;
    L6:
        int r0 = getResources().getDimensionPixelOffset(R.dimen.standard_icon_size);
        this.mCancelButtonWidth = r0;
        this.mRightViewWidth = r0;
        return;
    L5:
        if (this.mRightViewWidth == 0) goto L6;
    }

    private void resetSearchViewParam(boolean toSearchMode) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mSearchEditLayout.getLayoutParams();
        if (toSearchMode == false) goto L5;
        int r1 = this.mCancelButton.getId();
    L6:
        r0.addRule(0, r1);
        if (toSearchMode == false) goto L9;
    L11:
        r0.rightMargin = 0;
    L12:
        this.mSearchEditLayout.requestLayout();
        return;
    L9:
        if (this.mHasSearchRightView == true) goto L11;
        r0.removeRule(0);
        r0.rightMargin = this.mMarginToParent;
        goto L12
    L5:
        r1 = this.mRightViewContainer.getId();
        goto L6
    }

    private void resetSecondaryFilterParam(boolean toSearchMode) {
        if (this.hasSecondaryFilter == false) goto L6;
        if (toSearchMode == true) goto L6;
        boolean r4 = true;
    L7:
        View r0 = this.mSecondaryFilterLayout;
        if (r0 == null) goto L13;
        if (r4 == false) goto L11;
        int r2 = 0;
    L12:
        r0.setVisibility(r2);
        goto L13
    L11:
        r2 = 4;
    L13:
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) this.mSearchEditor.getLayoutParams();
        if (r4 == false) goto L16;
        View r5 = this.mSecondaryFilterLayout;
    L17:
        r1.addRule(0, r5.getId());
        this.mSecondaryFilterLayout.requestLayout();
        return;
    L16:
        r5 = this.mClearTextView;
    L6:
        r4 = false;
        goto L7
    }

    private int getOffsetX(boolean toSearchMode) {
        if (this.mHasSearchRightView == false) goto L9;
        int r0 = this.mRightViewContainer.getMeasuredWidth() - this.mCancelButtonWidth;
        if (toSearchMode == false) goto L8;
        return r0;
    L8:
        return -r0;
    L9:
        int r1 = this.mCancelButtonWidth + this.mMarginToSearchView;
        if (toSearchMode == true) goto L12;
        return r1;
    L12:
        return -r1;
    }

    public void onClickCancelView(boolean animation) {
        Listener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onClickCancelButton();
    L5:
        OnCancelClickListener r1 = this.onCancelClickListener;
        if (r1 == null) goto L9;
        r1.onClick(this.mCancelButton);
    L9:
        if (this.mIsSearchMode == true) goto L11;
        return;
    L11:
        if (this.mIsPlayingAnimation == false) goto L14;
        if (animation == false) goto L14;
        return;
    L14:
        this.mIsSearchMode = false;
        TextKeyListener.clear(this.mSearchEditor.getText());
        if (isWithAnimation() == false) goto L17;
        startAnimation(false);
        return;
    L17:
        updateEditorStatus();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        this.mSearchEditLayout.setEnabled(enabled);
        this.mSearchEditor.setEnabled(enabled);
        this.mRightViewContainer.setEnabled(enabled);
        this.mCancelButton.setEnabled(enabled);
        this.mSearchLeftIcon.setEnabled(enabled);
        this.mClearTextView.setEnabled(enabled);
    }

    public boolean hasSearchRightView() {
        return this.mHasSearchRightView;
    }

    @Deprecated
    public void setHasSearchRightView(boolean hasRightView) {
        if (hasRightView == true) goto L4;
        ImageView r1 = this.mSearchRightView;
        if (r1 == null) goto L12;
        removeRightView(r1);
        return;
    L12:
        return;
    L4:
        if (this.mSearchRightView != null) goto L10;
        this.mSearchRightView = addRightImageView(SORTING_ICON);
        return;
    }

    public boolean isAutoFocus() {
        return this.isAutoFocus;
    }

    public void setAutoFocus(boolean autoFocus) {
        this.isAutoFocus = autoFocus;
    }

    public boolean isWithAnimation() {
        return this.isWithAnimation;
    }

    public void setWithAnimation(boolean withAnimation) {
        this.isWithAnimation = withAnimation;
    }

    public View getSearchEditor() {
        return this.mSearchEditor;
    }

    public View getSearchEditLayout() {
        return this.mSearchEditLayout;
    }

    public View getSearchRightView() {
        return this.mSearchRightView;
    }

    public View getSearchLeftIcon() {
        return this.mSearchLeftIcon;
    }

    public View getCancelView() {
        return this.mCancelButton;
    }

    public View getClearView() {
        return this.mClearTextView;
    }

    public View getSecondaryFilterLayout() {
        return this.mSecondaryFilterLayout;
    }

    public boolean isSearchMode() {
        return this.mIsSearchMode;
    }

    public boolean isPlayingAnimation() {
        return this.mIsPlayingAnimation;
    }

    public void setSearchLeftIcon(Drawable icon) {
        this.mSearchLeftIcon.setBackground(icon);
    }

    public void setSearchLeftIcon(int iconId) {
        this.mSearchLeftIcon.setBackgroundResource(iconId);
    }

    public void setCancelViewVisibility(int visibility) {
        this.mCancelButton.setVisibility(visibility);
    }

    public void setSecondaryFilterVisibility(int visibility) {
        this.mSecondaryFilterLayout.setVisibility(visibility);
    }

    @Deprecated
    public void setSearchRightViewVisibility(int visibility) {
        ImageView r0 = this.mSearchRightView;
        if (r0 == null) goto L6;
        r0.setVisibility(visibility);
        return;
    }

    public void setSearchEnable(boolean enable) {
        this.mSearchEnable = enable;
    }

    public void setSecondaryFilterText(String text) {
        TextView r0 = this.mSecondaryFilterBtn;
        if (r0 == null) goto L6;
        r0.setText(text);
        return;
    }

    public void setSecondaryFilterText(int resId) {
        setSecondaryFilterText(getResources().getString(resId));
    }

    @Deprecated
    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void hideKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEditor.getWindowToken(), 2);
    }

    public void showKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.mSearchEditor, 0);
    }

    public void setAnimationListenr(AnimationListenr listenr) {
        this.animationListenr = listenr;
    }

    public void setOnEditorClickListener(OnEditorClickListener listener) {
        this.onEditorClickListener = listener;
    }

    public void setOnCancelClickListener(OnCancelClickListener listener) {
        this.onCancelClickListener = listener;
    }

    public void setOnFilterClickListener(OnFilterClickListener listener) {
        this.onFilterClickListener = listener;
    }

    public void setOnSearchIconClickListener(OnSearchIconClickListener listener) {
        this.onSearchIconClickListener = listener;
    }

    public void setOnSecondaryFilterClickListener(OnSecondaryFilterClickListener listener) {
        this.onSecondaryFilterClickListener = listener;
    }

    public void setOnCommitCompletionListener(OnCommitCompletionListener listener) {
        this.onCommitCompletionListener = listener;
    }

    public ImageView addRightImageView(int resId) {
        this.mHasSearchRightView = true;
        ImageView r2 = generateImageView(resId);
        resetSearchViewParam(this.mIsSearchMode);
        this.mRightViewContainer.addView(r2);
        if (this.mIsSearchMode == true) goto L5;
        this.mRightViewContainer.setVisibility(0);
    L5:
        return r2;
    }

    public void removeRightView(View v) {
        this.mRightViewContainer.removeView(v);
        if (this.mRightViewContainer.getChildCount() != 0) goto L6;
        this.mHasSearchRightView = false;
        resetSearchViewParam(this.mIsSearchMode);
        return;
    }

    public void removeAllRightImageView() {
        this.mHasSearchRightView = false;
        resetSearchViewParam(this.mIsSearchMode);
        this.mRightViewContainer.removeAllViews();
    }

    private ImageView generateImageView(int resId) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(resId);
        int r2 = this.mImageViewSize;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(r2, r2);
        if (this.mRightViewContainer.getChildCount() == 0) goto L5;
        r1.leftMargin = this.mMarginToEach;
    L5:
        r0.setLayoutParams(r1);
        boolean r4 = DescriptionUtils.applyDescriptionIfNeed(r0, resId);
        if (this.mImageScaleEnable == false) goto L9;
        if (r4 == true) goto L9;
        BarsHelper.setBarIconScaleTouchListener(r0);
    L9:
        return r0;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mSecondaryFilterDivider != null) goto L5;
        return;
    L5:
        if (this.mSearchEditLayout.getHeight() > 0) goto L7;
        return;
    L7:
        if (this.mSecondaryFilterDivider.getHeight() == this.mSearchEditLayout.getHeight()) goto L12;
        this.mSecondaryFilterDivider.setMinimumHeight(this.mSearchEditLayout.getHeight());
        this.mSecondaryFilterLayout.setMinimumHeight(this.mSearchEditLayout.getHeight());
        return;
    }

    public void setImageScaleEnable(boolean enable) {
        this.mImageScaleEnable = enable;
    }

    public void avoidImageViewScale(ImageView target) {
        BarsHelper.setBarIconScaleTouchListener(target, false);
    }
}
