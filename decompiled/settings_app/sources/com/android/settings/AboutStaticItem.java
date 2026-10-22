package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public class AboutStaticItem extends FrameLayout {
    private OCardListItem mCardView;
    private TextView mSummary;

    public AboutStaticItem(Context r1) {
        super(r1);
    }

    public AboutStaticItem(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AboutStaticItem(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        TypedArray r8 = r5.obtainStyledAttributes(r6, R.styleable.AboutStaticItem, r7, 0);
        boolean r0 = r8.getBoolean(1, false);
        this.mCardView = new OCardListItem(r5);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, -2);
        this.mCardView.setDefaultTailIcon(0);
        this.mCardView.setDefaultCustomEndView(3);
        this.mCardView.showCustomEnd(true);
        int r1 = r8.getInteger(0, 2);
        this.mCardView.setCardPosition(r1);
        View r2 = this.mCardView.getCustomEndView();
        if ((r2 instanceof OTextView) == false) goto L5;
        this.mSummary = (OTextView) r2;
    L5:
        this.mCardView.showTailIcon(r0);
        this.mSummary.setText(r8.getText(2));
        addView(this.mCardView, r9);
        this.mCardView.setTitle(r8.getText(4));
        r8.recycle();
    }

    public void setTitle(int r2) {
        this.mCardView.setTitle(getResources().getString(r2));
    }

    public void setTitle(String r1) {
        this.mCardView.setTitle(r1);
    }

    public TextView getSummary() {
        return this.mSummary;
    }

    public void setSummary(String r2) {
        TextView r0 = this.mSummary;
        if (r0 == null) goto L6;
        r0.setText(r2);
        this.mCardView.showCustomEnd(true);
        return;
    }

    public void setSummary(int r2) {
        TextView r0 = this.mSummary;
        if (r0 == null) goto L6;
        r0.setText(r2);
        this.mCardView.showCustomEnd(true);
        return;
    }

    public void setCardPosition(int r1) {
        this.mCardView.setCardPosition(r1);
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener r3) {
        this.mCardView.setOnContentClickListener(new AnonymousClass1(this, r3));
    }

    @Override // android.view.View
    public void setOnLongClickListener(final View.OnLongClickListener r3) {
        this.mCardView.setOnContentLongClickListener(new AnonymousClass2(this, r3));
    }
}
