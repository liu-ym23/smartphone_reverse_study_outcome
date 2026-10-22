package com.android.settings.display;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;

/* JADX INFO: loaded from: classes2.dex */
public class ConversationMessageView extends FrameLayout {
    private TextView mContactIconView;
    private final int mIconBackgroundColor;
    private final CharSequence mIconText;
    private final int mIconTextColor;
    private final boolean mIncoming;
    private LinearLayout mMessageBubble;
    private final CharSequence mMessageText;
    private ViewGroup mMessageTextAndInfoView;
    private TextView mMessageTextView;
    private TextView mStatusTextView;
    private final CharSequence mTimestampText;

    public ConversationMessageView(Context r2) {
        this(r2, null);
    }

    public ConversationMessageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ConversationMessageView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public ConversationMessageView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        TypedArray r5 = r1.obtainStyledAttributes(r2, R.styleable.ConversationMessageView);
        this.mIncoming = r5.getBoolean(3, true);
        this.mMessageText = r5.getString(4);
        this.mTimestampText = r5.getString(5);
        this.mIconText = r5.getString(1);
        this.mIconTextColor = r5.getColor(2, 0);
        this.mIconBackgroundColor = r5.getColor(0, 0);
        r5.recycle();
        LayoutInflater.from(r1).inflate(R.layout.conversation_message_icon, this);
        LayoutInflater.from(r1).inflate(R.layout.conversation_message_content, this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mMessageBubble = (LinearLayout) findViewById(R.id.message_content);
        this.mMessageTextAndInfoView = (ViewGroup) findViewById(R.id.message_text_and_info);
        this.mMessageTextView = (TextView) findViewById(R.id.message_text);
        this.mStatusTextView = (TextView) findViewById(R.id.message_status);
        this.mContactIconView = (TextView) findViewById(R.id.conversation_icon);
        updateViewContent();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        updateViewAppearance();
        int r5 = View.MeasureSpec.getSize(r3);
        int r0 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r6 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContactIconView.measure(r6, r6);
        int r7 = View.MeasureSpec.makeMeasureSpec(Math.max(this.mContactIconView.getMeasuredWidth(), this.mContactIconView.getMeasuredHeight()), 1073741824);
        this.mContactIconView.measure(r7, r7);
        int r8 = getResources().getDimensionPixelSize(R.dimen.message_bubble_arrow_width);
        int r9 = View.MeasureSpec.makeMeasureSpec((((r5 - (this.mContactIconView.getMeasuredWidth() * 2)) - r8) - getPaddingLeft()) - getPaddingRight(), Integer.MIN_VALUE);
        this.mMessageBubble.measure(r9, r0);
        setMeasuredDimension(r5, (Math.max(this.mContactIconView.getMeasuredHeight(), this.mMessageBubble.getMeasuredHeight()) + getPaddingBottom()) + getPaddingTop());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        boolean r9 = isLayoutRtl(this);
        int r10 = this.mContactIconView.getMeasuredWidth();
        int r11 = this.mContactIconView.getMeasuredHeight();
        int r0 = getPaddingTop();
        int r12 = r7 - r5;
        int r13 = ((r12 - r10) - getPaddingLeft()) - getPaddingRight();
        int r1 = this.mMessageBubble.getMeasuredHeight();
        if (this.mIncoming == false) goto L7;
        if (r9 == false) goto L6;
        int r14 = getPaddingRight();
    L11:
        int r15 = (r12 - r14) - r10;
        int r16 = r15 - r13;
    L12:
        this.mContactIconView.layout(r15, r0, r10 + r15, r11 + r0);
        this.mMessageBubble.layout(r16, r0, r13 + r16, r1 + r0);
        return;
    L6:
        r15 = getPaddingLeft();
    L9:
        r16 = r15 + r10;
        goto L12
    L7:
        if (r9 == false) goto L10;
        r15 = getPaddingLeft();
        goto L9
    L10:
        r14 = getPaddingRight();
        goto L11
    }

    private static boolean isLayoutRtl(View r1) {
        if (1 == r1.getLayoutDirection()) goto L7;
        return false;
    L7:
        return true;
    }

    private void updateViewContent() {
        this.mMessageTextView.setText(this.mMessageText);
        this.mStatusTextView.setText(this.mTimestampText);
        this.mContactIconView.setText(this.mIconText);
        this.mContactIconView.setTextColor(this.mIconTextColor);
        Drawable r0 = getContext().getDrawable(R.drawable.conversation_message_icon);
        this.mContactIconView.setBackground(getTintedDrawable(getContext(), r0, this.mIconBackgroundColor));
    }

    private void updateViewAppearance() {
        Resources r0 = getResources();
        int r1 = r0.getDimensionPixelOffset(R.dimen.message_bubble_arrow_width);
        int r2 = r0.getDimensionPixelOffset(R.dimen.message_text_left_right_padding);
        int r3 = r0.getDimensionPixelOffset(R.dimen.message_text_top_padding);
        int r4 = r0.getDimensionPixelOffset(R.dimen.message_text_bottom_padding);
        boolean r5 = this.mIncoming;
        if (r5 == false) goto L5;
        r2 = r1 + r2;
        int r6 = r2;
    L6:
        if (r5 == false) goto L8;
        int r7 = 8388627;
    L9:
        int r8 = r0.getDimensionPixelSize(R.dimen.message_padding_default);
        int r9 = r0.getDimensionPixelOffset(R.dimen.message_metadata_top_padding);
        boolean r10 = this.mIncoming;
        if (r10 == false) goto L12;
        int r11 = R.drawable.msg_bubble_incoming;
    L13:
        if (r10 == false) goto L15;
        int r12 = R.color.message_bubble_incoming;
    L16:
        Context r13 = getContext();
        Drawable r14 = getTintedDrawable(r13, (Drawable) NullSafe.nonNull(r13.getDrawable(r11)), r13.getColor(r12));
        this.mMessageTextAndInfoView.setBackground(r14);
        if (isLayoutRtl(this) == false) goto L19;
        this.mMessageTextAndInfoView.setPadding(r6, r3 + r9, r2, r4);
    L20:
        setPadding(getPaddingLeft(), r8, getPaddingRight(), 0);
        this.mMessageBubble.setGravity(r7);
        updateTextAppearance();
        return;
    L19:
        this.mMessageTextAndInfoView.setPadding(r2, r3 + r9, r6, r4);
        goto L20
    L15:
        r12 = R.color.message_bubble_outgoing;
        goto L16
    L12:
        r11 = R.drawable.msg_bubble_outgoing;
        goto L13
    L8:
        r7 = 8388629;
        goto L9
    L5:
        r6 = r1 + r2;
        goto L6
    }

    private void updateTextAppearance() {
        boolean r0 = this.mIncoming;
        if (r0 == false) goto L5;
        int r1 = R.color.message_text_incoming;
    L6:
        if (r0 == false) goto L8;
        int r2 = R.color.timestamp_text_incoming;
    L9:
        int r3 = getContext().getColor(r1);
        this.mMessageTextView.setTextColor(r3);
        this.mMessageTextView.setLinkTextColor(r3);
        this.mStatusTextView.setTextColor(getResources().getColor(r2));
        return;
    L8:
        r2 = R.color.timestamp_text_outgoing;
        goto L9
    L5:
        r1 = R.color.message_text_outgoing;
        goto L6
    }

    private static Drawable getTintedDrawable(Context r1, Drawable r2, int r3) {
        Drawable.ConstantState r0 = r2.getConstantState();
        if (r0 == null) goto L5;
        r2 = r0.newDrawable(r1.getResources()).mutate();
    L5:
        r2.setColorFilter(r3, PorterDuff.Mode.SRC_ATOP);
        return r2;
    }
}
