package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class VerticalOptionsCheckView extends LinearLayout implements View.OnClickListener {
    public static final int BOTTOM = 2;
    public static final int MIDDLE = 1;
    public static final int OPTIONS_COUNT_DEFAULT = 2;
    public static final int TOP = 0;
    private ImageView mBottomCheckIcon;
    private View mBottomOptionView;
    private ImageView mBottomPreview;
    private Context mContext;
    private ImageView mMiddleCheckIcon;
    private View mMiddleOptionView;
    private ImageView mMiddlePreview;
    private OptionSelectListener mOptionSelectListener;
    private int mOptionsCount;
    private TextView mTitle;
    private ImageView mTopCheckIcon;
    private View mTopOptionView;
    private ImageView mTopPreview;

    public interface OptionSelectListener {
        void onOptionSelected(int r1);
    }

    public VerticalOptionsCheckView(Context r2) {
        this(r2, null);
    }

    public VerticalOptionsCheckView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public VerticalOptionsCheckView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mContext = r3;
        LayoutInflater.from(r3).inflate(R.layout.vertical_options_chooser_layout, this, true);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.VerticalOptionsCheckView);
        this.mOptionsCount = r6.getInt(0, 2);
        r6.recycle();
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mTopOptionView = findViewById(R.id.top_option);
        this.mTopPreview = (ImageView) findViewById(R.id.top_preview);
        this.mTopCheckIcon = (ImageView) findViewById(R.id.top_check_icon);
        this.mBottomOptionView = findViewById(R.id.bottom_option);
        this.mBottomPreview = (ImageView) findViewById(R.id.bottom_preview);
        this.mBottomCheckIcon = (ImageView) findViewById(R.id.bottom_check_icon);
        this.mTopOptionView.setOnClickListener(this);
        this.mBottomOptionView.setOnClickListener(this);
        if (this.mOptionsCount != 3) goto L6;
        this.mMiddleOptionView = findViewById(R.id.middle_option);
        this.mMiddlePreview = (ImageView) findViewById(R.id.middle_preview);
        this.mMiddleCheckIcon = (ImageView) findViewById(R.id.middle_check_icon);
        this.mMiddleOptionView.setVisibility(0);
        this.mMiddleOptionView.setOnClickListener(this);
        return;
    }

    public void setTitle(int r2) {
        setTitle(getResources().getString(r2));
    }

    public void setTitle(String r2) {
        this.mTitle.setText(r2);
        TextView r1 = this.mTitle;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void bindOptionPreview(int r2, int r3) {
        this.mTopPreview.setBackgroundResource(r2);
        this.mBottomPreview.setBackgroundResource(r3);
    }

    public void bindOptionPreview(int r1, int r2, int r3) {
        setTitle(r1);
        bindOptionPreview(r2, r3);
    }

    public void bindOptionPreview(int r1, int r2, int r3, int r4) {
        setTitle(r1);
        bindOptionPreview(r2, r4);
        if (r3 != 0) goto L5;
        return;
    L5:
        if (this.mOptionsCount != 3) goto L9;
        this.mMiddlePreview.setBackgroundResource(r3);
        return;
    }

    public ImageView getOptionPreview(int r2) {
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L10;
        return this.mTopPreview;
    L10:
        return this.mBottomPreview;
    L12:
        return this.mMiddlePreview;
    L14:
        return this.mTopPreview;
    }

    public void setCheck(int r5) {
        ImageView r0 = this.mTopCheckIcon;
        int r1 = 0;
        if (r5 != 0) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        ImageView r2 = this.mBottomCheckIcon;
        if (r5 != 2) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        if (this.mOptionsCount != 3) goto L18;
        ImageView r6 = this.mMiddleCheckIcon;
        if (r5 == 1) goto L16;
        r1 = 8;
    L16:
        r6.setVisibility(r1);
        return;
    L18:
        return;
    L9:
        r4 = 8;
        goto L10
    L5:
        r3 = 8;
        goto L6
    }

    public void setOptionSelectListener(OptionSelectListener r1) {
        this.mOptionSelectListener = r1;
    }

    public void setPreviewHeight(int r5) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mTopOptionView.getLayoutParams();
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mBottomOptionView.getLayoutParams();
        r0.height = r5;
        r1.height = r5;
        if (this.mOptionsCount != 3) goto L5;
        int r2 = getContext().getResources().getDimensionPixelSize(R.dimen.vertical_option_top_bottom_offset) + r5;
        r0.height = r2;
        r1.height = r2;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) this.mMiddleOptionView.getLayoutParams();
        r3.height = r5;
        this.mMiddleOptionView.setLayoutParams(r3);
    L5:
        this.mTopOptionView.setLayoutParams(r0);
        this.mBottomOptionView.setLayoutParams(r1);
    }

    public void setTopMargin(int r3) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mTopPreview.getLayoutParams();
        r0.removeRule(13);
        r0.addRule(14);
        r0.addRule(10);
        r0.topMargin = r3;
        this.mTopPreview.setLayoutParams(r0);
    }

    public void setBottomMargin(int r3) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mBottomPreview.getLayoutParams();
        r0.removeRule(13);
        r0.addRule(14);
        r0.addRule(12);
        r0.bottomMargin = r3;
        this.mBottomPreview.setLayoutParams(r0);
    }

    public void setContentDesc(int r3, int r4) {
        this.mTopOptionView.setContentDescription(this.mContext.getString(r3));
        this.mBottomOptionView.setContentDescription(this.mContext.getString(r4));
    }

    public void setContentDesc(int r1, int r2, int r3) {
        setContentDesc(r1, r3);
        if (this.mOptionsCount != 3) goto L6;
        this.mMiddleOptionView.setContentDescription(this.mContext.getString(r2));
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        this.mTopOptionView.setEnabled(r3);
        this.mBottomOptionView.setEnabled(r3);
        if (this.mOptionsCount != 3) goto L6;
        this.mMiddleOptionView.setEnabled(r3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 == R.id.bottom_option) goto L20;
        if (r3 == R.id.middle_option) goto L15;
        if (r3 == R.id.top_option) goto L10;
        return;
    L10:
        if (this.mTopCheckIcon.getVisibility() == 0) goto L25;
        setCheck(0);
        OptionSelectListener r1 = this.mOptionSelectListener;
        if (r1 == null) goto L26;
        r1.onOptionSelected(0);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        if (this.mMiddleCheckIcon.getVisibility() == 0) goto L28;
        setCheck(1);
        OptionSelectListener r4 = this.mOptionSelectListener;
        if (r4 == null) goto L29;
        r4.onOptionSelected(1);
        return;
    L29:
        return;
    L28:
        return;
    L20:
        if (this.mBottomCheckIcon.getVisibility() == 0) goto L31;
        setCheck(2);
        OptionSelectListener r5 = this.mOptionSelectListener;
        if (r5 == null) goto L32;
        r5.onOptionSelected(2);
        return;
    L32:
        return;
    }
}
