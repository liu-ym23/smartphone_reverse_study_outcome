package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class RadioGroupExpand extends android.widget.RadioGroup {
    final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private boolean mHasTextAndIcon;
    private View.OnLongClickListener mListener;
    private int mTabBackgroundDrawable;
    private int mTabColor;
    private int mTabId;
    private int mTabTextSize;
    private LinkedList<TabSpec> mTabs;

    private class RadioButtonLongClickListener implements View.OnLongClickListener {
        final /* synthetic */ RadioGroupExpand this$0;

        private RadioButtonLongClickListener(final RadioGroupExpand this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ RadioButtonLongClickListener(RadioGroupExpand r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            if (RadioGroupExpand.access$200(this.this$0) == null) goto L7;
            RadioGroupExpand.access$200(this.this$0).onLongClick(v);
            return false;
        L7:
            return false;
        }
    }

    public class TabSpec {
        public int mTabId;
        public int mTabName;
        public int mTopDrawable;
        final /* synthetic */ RadioGroupExpand this$0;

        public TabSpec(final RadioGroupExpand this$0) {
            this.this$0 = this$0;
        }
    }

    static /* synthetic */ void access$000(RadioGroupExpand r0) {
        r0.invalidateShadow();
    }

    static /* synthetic */ View.OnLongClickListener access$200(RadioGroupExpand r0) {
        return r0.mListener;
    }

    public RadioGroupExpand(Context context) {
        super(context);
        this.mTabColor = 0;
        this.mTabTextSize = 0;
        this.mTabBackgroundDrawable = 0;
        this.mHasTextAndIcon = false;
        this.mListener = null;
        this.mTabs = new LinkedList();
        this.globalLayoutListener = new AnonymousClass1(this);
    }

    public RadioGroupExpand(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTabColor = 0;
        this.mTabTextSize = 0;
        this.mTabBackgroundDrawable = 0;
        this.mHasTextAndIcon = false;
        this.mListener = null;
        this.mTabs = new LinkedList();
        this.globalLayoutListener = new AnonymousClass1(this);
    }

    public TabSpec newNoTitleTabSpec(int tabId, int tabName, int topDrawable) {
        return newTabSpec(tabId, tabName, topDrawable);
    }

    public void setTabColor(int tabNameColor) {
        this.mTabColor = tabNameColor;
    }

    public void setTabTextSize(int tabNameTextSize) {
        this.mTabTextSize = tabNameTextSize;
    }

    public void setTabBackgroundDrawable(int backgroundDrawable) {
        this.mTabBackgroundDrawable = backgroundDrawable;
    }

    public void setDefaultSelectedTab(int tabId) {
        this.mTabId = tabId;
    }

    public TabSpec newTabSpec(int tabId, int tabName, int topDrawable) {
        TabSpec r0 = new TabSpec(this);
        r0.mTabId = tabId;
        r0.mTabName = tabName;
        r0.mTopDrawable = topDrawable;
        return r0;
    }

    public void addTab(TabSpec tabSpec) {
        this.mTabs.add(tabSpec);
    }

    public void setup() {
        RadioButtonLongClickListener r0 = new RadioButtonLongClickListener(this, null);
        int r2 = getSelectedTabIndex();
        setOrientation(0);
        setWeightSum(this.mTabs.size());
        android.widget.RadioGroup.LayoutParams r4 = new android.widget.RadioGroup.LayoutParams(0, -1, 1.0f);
        int r5 = 0;
    L4:
        if (r5 >= this.mTabs.size()) goto L19;
        TabSpec r6 = this.mTabs.get(r5);
        RadioButton r7 = new RadioButton(getContext());
        initTabIcon(r7, r6);
        initTabName(r7, r6);
        r7.setId(r6.mTabId);
        r7.setLayoutParams(r4);
        r7.setOnLongClickListener(r0);
        if (r2 != r5) goto L8;
        boolean r8 = true;
    L9:
        r7.setChecked(r8);
        r7.setButtonDrawable(null);
        if (this.mTabBackgroundDrawable <= 0) goto L12;
        r7.setBackground(getResources().getDrawable(this.mTabBackgroundDrawable));
    L17:
        addView(r7);
        r5 = r5 + 1;
        goto L4
    L12:
        Resources r9 = getResources();
        if (r6.mTabName <= 0) goto L15;
        int r10 = R.drawable.obric_bottom_tab_bg_selector;
    L16:
        r7.setBackground(r9.getDrawable(r10));
        goto L17
    L15:
        r10 = R.drawable.obric_bottom_tab_lite_bg_selector;
        goto L16
    L8:
        r8 = false;
        goto L9
    L19:
        if (this.mHasTextAndIcon == false) goto L21;
        getLayoutParams().height = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_height);
    L22:
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        return;
    L21:
        getLayoutParams().height = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_height_only_icon);
        goto L22
    }

    private void invalidateShadow() {
        ViewParent r0 = getParent();
        if ((r0 instanceof RelativeLayout) == false) goto L7;
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-1, -2);
        r1.addRule(2, getId());
        ImageView r2 = new ImageView(getContext());
        r2.setId(R.id.id_obric_bar_shadow);
        r2.setBackgroundResource(R.drawable.tab_bar_shadow);
        ((RelativeLayout) r0).addView(r2, r1);
        return;
    L7:
        throw new IllegalArgumentException("Parent must be a RelativeLayout when showing the shadow.");
    }

    private int getSelectedTabIndex() {
        if (this.mTabs.size() != 0) goto L5;
    L14:
        return 0;
    L5:
        if (this.mTabId <= 0) goto L14;
        int r0 = 0;
    L9:
        if (r0 >= this.mTabs.size()) goto L14;
        if (this.mTabs.get(r0).mTabId == this.mTabId) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r0;
    }

    private void initTabIcon(RadioButton radioButton, TabSpec tabSpec) {
        if (tabSpec.mTopDrawable != 0) goto L5;
        tabSpec.mTopDrawable = R.drawable.obric_bottom_tab_icon_selector;
    L5:
        Drawable r0 = getResources().getDrawable(tabSpec.mTopDrawable);
        int r1 = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_icon_max_height);
        r0.setBounds(0, 0, r1, r1);
        radioButton.setCompoundDrawables(null, r0, null, null);
        radioButton.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_drawablePadding));
        if (tabSpec.mTabName <= 0) goto L8;
        int r4 = getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_paddingTop);
    L9:
        radioButton.setPadding(0, r4, 0, 0);
        return;
    L8:
        r4 = (getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_height_only_icon) - r1) / 2;
        goto L9
    }

    private void initTabName(RadioButton radioButton, TabSpec tabSpec) {
        if (tabSpec.mTabName <= 0) goto L14;
        this.mHasTextAndIcon = true;
        radioButton.setText(tabSpec.mTabName);
        int r4 = this.mTabTextSize;
        if (r4 <= 0) goto L7;
        radioButton.setTextSize(0, r4);
    L9:
        if (this.mTabColor <= 0) goto L11;
        radioButton.setTextColor(getResources().getColorStateList(this.mTabColor));
    L12:
        radioButton.setGravity(49);
        radioButton.setEllipsize(TextUtils.TruncateAt.END);
        radioButton.setSingleLine();
        radioButton.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L11:
        radioButton.setTextColor(getResources().getColorStateList(R.color.bottom_tab_text_color));
        goto L12
    L7:
        radioButton.setTextSize(0, getResources().getDimensionPixelOffset(R.dimen.obric_bottom_bar_name_size));
        goto L9
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener listener) {
        this.mListener = listener;
    }
}
