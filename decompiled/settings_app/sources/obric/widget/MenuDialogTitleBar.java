package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import obric.util.DescriptionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MenuDialogTitleBar extends LinearLayout {
    private static final int ICON_RES_CANCEL = 0;
    private static final int ICON_RES_COMPLETE = 0;
    private float mBtnSize;
    private View.OnClickListener mLeftClickListener;
    private ImageView mLeftImageView;
    private boolean mReqAccessibilityFocusWhenAttach;
    private View.OnClickListener mRightClickListener;
    private ImageView mRightImageView;
    private View mShadowView;
    private TextView mTitle;
    private ViewGroup mTitleBarContainer;
    private float mTitleSize;

    @Deprecated
    public int getTopShadowHeight() {
        return 0;
    }

    @Deprecated
    public void setLeftButtonText(CharSequence text) {
    }

    @Deprecated
    public void setRightButtonText(CharSequence text) {
    }

    @Deprecated
    public void showDivider(boolean show) {
    }

    @Deprecated
    public void showTopShadow(boolean show) {
    }

    static /* synthetic */ View.OnClickListener access$000(MenuDialogTitleBar r0) {
        return r0.mRightClickListener;
    }

    static /* synthetic */ View.OnClickListener access$100(MenuDialogTitleBar r0) {
        return r0.mLeftClickListener;
    }

    static /* synthetic */ ImageView access$200(MenuDialogTitleBar r0) {
        return r0.mRightImageView;
    }

    static /* synthetic */ TextView access$300(MenuDialogTitleBar r0) {
        return r0.mTitle;
    }

    static /* synthetic */ ImageView access$400(MenuDialogTitleBar r0) {
        return r0.mLeftImageView;
    }

    static {
        ICON_RES_CANCEL = R.drawable.standard_icon_cancel_selector;
        ICON_RES_COMPLETE = R.drawable.standard_icon_complete_selector;
    }

    public MenuDialogTitleBar(Context context) {
        this(context, null);
    }

    public MenuDialogTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuDialogTitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mReqAccessibilityFocusWhenAttach = true;
        setOrientation(1);
        View r0 = LayoutInflater.from(context).inflate(R.layout.menu_dialog_title_bar, this, true);
        this.mTitle = (TextView) r0.findViewById(R.id.title);
        this.mRightImageView = (ImageView) r0.findViewById(R.id.btn_cancel_right);
        this.mLeftImageView = (ImageView) r0.findViewById(R.id.btn_cancel_left);
        this.mRightImageView.setOnClickListener(new AnonymousClass1(this));
        this.mLeftImageView.setOnClickListener(new AnonymousClass2(this));
        context.obtainStyledAttributes(attrs, R.styleable.MenuDialogTitleBar, defStyle, 0).recycle();
        DisplayMetrics r4 = getResources().getDisplayMetrics();
        this.mTitleSize = this.mTitle.getTextSize() / r4.scaledDensity;
        this.mTitle.setAccessibilityDelegate(new AnonymousClass3(this));
        this.mRightImageView.setAccessibilityDelegate(new AnonymousClass4(this));
        this.mTitleBarContainer = (ViewGroup) findViewById(R.id.menu_dialog_title_bar_container);
        this.mShadowView = BarsHelper.createShadowBuilder(getContext()).build(this.mTitleBarContainer);
        setElevation(0.1f);
        BarsHelper.setBarIconScaleTouchListener(this.mLeftImageView);
        BarsHelper.setBarIconScaleTouchListener(this.mRightImageView);
    }

    public void setTitle(CharSequence text) {
        this.mTitle.setTextSize(2, this.mTitleSize);
        this.mTitle.setText(text);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.setClassName(getClass().getName());
        event.setPackageName(getContext().getPackageName());
        return false;
    }

    public void forceRequestAccessibilityFocusWhenAttached(boolean request) {
        this.mReqAccessibilityFocusWhenAttach = request;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) getParent()).setClipChildren(false);
    L6:
        if (this.mReqAccessibilityFocusWhenAttach == false) goto L9;
        this.mTitle.sendAccessibilityEvent(32768);
        return;
    }

    public void setTitle(int resId) {
        setTitle(getResources().getString(resId));
    }

    public void setTitleSingleLine(boolean singleLine) {
        this.mTitle.setSingleLine(singleLine);
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    @Deprecated
    public void setRightButtonText(int resId) {
        setRightButtonText(getResources().getString(resId));
    }

    public void setRightImageRes(int res) {
        this.mRightImageView.setImageResource(res);
        BarsHelper.setBarIconScaleTouchListener(this.mLeftImageView, !DescriptionUtils.applyDescriptionIfNeed(this.mRightImageView, res));
    }

    public void setRightButtonVisibility(int visibility) {
        this.mRightImageView.setVisibility(visibility);
    }

    @Deprecated
    public TextView getRightButton() {
        return new TextView(getContext());
    }

    public ImageView getRightImageView() {
        return this.mRightImageView;
    }

    public void setOnRightButtonClickListener(View.OnClickListener listener) {
        this.mRightClickListener = listener;
    }

    @Deprecated
    public void setLeftButtonText(int resId) {
        setLeftButtonText(getResources().getString(resId));
    }

    public void setLeftImageViewRes(int res) {
        this.mLeftImageView.setImageResource(res);
        BarsHelper.setBarIconScaleTouchListener(this.mLeftImageView, !DescriptionUtils.applyDescriptionIfNeed(this.mLeftImageView, res));
    }

    public void setLeftButtonVisibility(int visibility) {
        this.mLeftImageView.setVisibility(visibility);
    }

    @Deprecated
    public TextView getLeftButton() {
        return new TextView(getContext());
    }

    public ImageView getLeftImageView() {
        return this.mLeftImageView;
    }

    public void setOnLeftButtonClickListener(View.OnClickListener listener) {
        this.mLeftClickListener = listener;
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

    public void setTitleBarBackgroundResource(int resId) {
        this.mTitleBarContainer.setBackgroundResource(resId);
    }

    public ViewGroup getTitleBarContainer() {
        return this.mTitleBarContainer;
    }

    public void addCancelImage(boolean left) {
        setImageViewRes(left, ICON_RES_CANCEL);
    }

    public void addCompleteImage(boolean left) {
        setImageViewRes(left, ICON_RES_COMPLETE);
    }

    private void setImageViewRes(boolean left, int res) {
        if (left == false) goto L4;
        setLeftImageViewRes(res);
        return;
    L4:
        setRightImageRes(res);
    }
}
