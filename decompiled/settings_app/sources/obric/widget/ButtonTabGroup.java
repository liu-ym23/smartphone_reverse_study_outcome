package obric.widget;

import android.content.Context;
import android.graphics.drawable.InsetDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ButtonTabGroup extends LinearLayout implements View.OnClickListener {
    private static final boolean DEF_HAS_GAP_VALUE = false;
    public static final int NO_WIDTH = Integer.MIN_VALUE;
    private View mActivableView;
    private boolean mAlwaysKeepClickListen;
    private int mBtnCount;
    private List<Integer> mBtnDrawables;
    private List<String> mBtnText;
    private List<ShadowButton> mBtns;
    private Context mContext;
    private int mEachGapValue;
    private boolean mHasBtnGap;
    private OnButtonGroupItemClickListener mItemListener;
    private int mWidth;

    public interface OnButtonGroupItemClickListener {
        void onButtonGroupItemClick(View child, int pos);
    }

    public ButtonTabGroup(Context context) {
        this(context, null);
    }

    public ButtonTabGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ButtonTabGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mWidth = Integer.MIN_VALUE;
        setOrientation(0);
        setGravity(17);
        setMeasureWithLargestChildEnabled(true);
        this.mContext = context;
        this.mEachGapValue = context.getResources().getDimensionPixelOffset(R.dimen.button_tab_group_each_gap);
        this.mBtns = new ArrayList();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int r0 = this.mWidth;
        if (r0 <= 0) goto L5;
        widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
    L5:
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public void setButtonGroupData(List<String> data) {
        setButtonGroupData(data, false);
    }

    public void setButtonDrawable(List<Integer> drawables) {
        List<Integer> r0 = this.mBtnDrawables;
        if (r0 != null) goto L5;
        this.mBtnDrawables = new ArrayList();
    L6:
        this.mBtnDrawables.addAll(drawables);
        return;
    L5:
        r0.clear();
        goto L6
    }

    public void setButtonGroupData(List<String> data, boolean hasBtnGap) {
        getListButtonsTextOrCreate().addAll(data);
        int r2 = data.size();
        if (this.mBtnCount <= 0) goto L5;
        removeAllViews();
    L5:
        this.mBtnCount = r2;
        this.mHasBtnGap = hasBtnGap;
    }

    public void setup() {
        if (this.mBtnCount > 0) goto L5;
        return;
    L5:
        this.mBtns.clear();
        int r0 = 0;
    L7:
        if (r0 >= this.mBtnCount) goto L9;
        addView(generateShadowButton(r0), r0, generateShadowButtonLayoutParams(r0));
        r0 = r0 + 1;
        goto L7
    }

    private void setButtonDrawable(int index, int drawableId) {
        int r4 = getResources().getDimensionPixelSize(R.dimen.action_button_icon_inset_left);
        int r6 = getResources().getDimensionPixelSize(R.dimen.action_button_icon_inset_right);
        InsetDrawable r0 = new InsetDrawable(getResources().getDrawable(drawableId), r4, 0, r6, 0);
        this.mBtns.get(index).setCompoundDrawablesWithIntrinsicBounds(r0, null, null, null);
    }

    private List<String> getListButtonsTextOrCreate() {
        if (this.mBtnText != null) goto L6;
        this.mBtnText = new ArrayList();
    L6:
        return this.mBtnText;
    }

    private ShadowButton generateShadowButton(int i) {
        ShadowButton r0 = new ShadowButton(this.mContext);
        if (this.mHasBtnGap == false) goto L5;
    L15:
        r0.setTextAppearance(getContext(), R.style.SmallButton_Standard);
        r0.setBackgroundResource(R.drawable.selector_small_btn_standard);
    L16:
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setMaxLines(1);
        r0.setOnClickListener(this);
        List<String> r1 = this.mBtnText;
        if (r1 == null) goto L19;
        r0.setText(r1.get(i));
    L19:
        this.mBtns.add(r0);
        List<Integer> r2 = this.mBtnDrawables;
        if (r2 != null) goto L22;
    L24:
        return r0;
    L22:
        if (i >= r2.size()) goto L24;
        setButtonDrawable(i, this.mBtnDrawables.get(i).intValue());
        goto L24
    L5:
        if (this.mBtnCount == 1) goto L15;
        r0.setTextAppearance(getContext(), R.style.SmallButton_Filter);
        if (i != 0) goto L11;
        r0.setBackgroundResource(R.drawable.selector_small_btn_filter_left);
    L14:
        int r3 = R.color.filter_button_text_shadow_colors;
        r0.setShadowColors(getResources().getColorStateList(r3), 0.1f, 0.0f, -2.0f);
        goto L16
    L11:
        if (i != (this.mBtnCount - 1)) goto L13;
        r0.setBackgroundResource(R.drawable.selector_small_btn_filter_right);
        goto L14
    L13:
        r0.setBackgroundResource(R.drawable.selector_small_btn_filter_middle);
        goto L14
    }

    private LinearLayout.LayoutParams generateShadowButtonLayoutParams(int i) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(0, -2);
        r0.weight = 1.0f;
        if (this.mHasBtnGap == false) goto L6;
        if (i == 0) goto L6;
        r0.leftMargin = -this.mEachGapValue;
    L6:
        return r0;
    }

    public ShadowButton getButtonTab(int index) {
        checkButtonIndex(index);
        return this.mBtns.get(index);
    }

    public void setButtonActivated(int index) {
        checkButtonIndex(index);
        setButtonActivatedInner(index, false);
    }

    private void setButtonActivatedInner(int index, boolean fromScreen) {
        ShadowButton r0 = this.mBtns.get(index);
        if (fromScreen == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        View r3 = this.mActivableView;
        if (r0 == r3) goto L11;
        if (r3 == null) goto L19;
        r3.setActivated(false);
    L19:
        if (r6 == false) goto L21;
        this.mItemListener.onButtonGroupItemClick(r0, index);
    L21:
        r0.setActivated(true);
        this.mActivableView = r0;
        return;
    L11:
        if (this.mHasBtnGap == false) goto L13;
    L14:
        if (r6 == false) goto L24;
        this.mItemListener.onButtonGroupItemClick(r0, index);
        return;
    L24:
        return;
    L13:
        if (this.mAlwaysKeepClickListen == true) goto L14;
        return;
    L5:
        if (this.mItemListener == null) goto L7;
        r6 = true;
        goto L8
    }

    private void checkButtonIndex(int index) {
        if (index < 0) goto L7;
        if (index >= this.mBtnCount) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        setButtonActivatedInner(this.mBtns.indexOf(v), true);
    }

    public void setOnButtonGroupItemClickListener(OnButtonGroupItemClickListener listener) {
        this.mItemListener = listener;
    }

    public void setEnabled(int index, boolean enabled) {
        ShadowButton r0 = getButtonTab(index);
        r0.setEnabled(enabled);
        if (enabled == false) goto L5;
        float r1 = 1.0f;
    L6:
        r0.setAlpha(r1);
        return;
    L5:
        r1 = 0.3f;
        goto L6
    }

    public void setAlwaysKeepClickListen(boolean alwaysKeepClickListen) {
        this.mAlwaysKeepClickListen = alwaysKeepClickListen;
    }
}
