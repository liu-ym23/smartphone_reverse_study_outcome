package com.android.setupwizardlib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.android.setupwizardlib.span.LinkSpan;
import com.android.setupwizardlib.span.SpanHelper;
import com.android.setupwizardlib.util.LinkAccessibilityHelper;

/* JADX INFO: loaded from: classes.dex */
public class RichTextView extends AppCompatTextView implements LinkSpan.OnLinkClickListener {
    private static final String ANNOTATION_LINK = "link";
    private static final String ANNOTATION_TEXT_APPEARANCE = "textAppearance";
    private static final String TAG = "RichTextView";
    private LinkAccessibilityHelper accessibilityHelper;
    private LinkSpan.OnLinkClickListener onLinkClickListener;

    public static CharSequence getRichText(Context r8, CharSequence r9) {
        if ((r9 instanceof Spanned) == false) goto L17;
        SpannableString r0 = new SpannableString(r9);
        int r2 = 0;
        Annotation[] r10 = (Annotation[]) r0.getSpans(0, r0.length(), Annotation.class);
        int r1 = r10.length;
    L5:
        if (r2 >= r1) goto L16;
        Annotation r3 = r10[r2];
        String r4 = r3.getKey();
        if (ANNOTATION_TEXT_APPEARANCE.equals(r4) == false) goto L13;
        int r5 = r8.getResources().getIdentifier(r3.getValue(), "style", r8.getPackageName());
        if (r5 != 0) goto L11;
        Log.w(TAG, "Cannot find resource: " + r5);
    L11:
        SpanHelper.replaceSpan(r0, r3, new TextAppearanceSpan(r8, r5));
    L15:
        r2 = r2 + 1;
        goto L5
    L13:
        if (ANNOTATION_LINK.equals(r4) == false) goto L15;
        SpanHelper.replaceSpan(r0, r3, new LinkSpan(r3.getValue()));
        goto L15
    L16:
        return r0;
    L17:
        return r9;
    }

    public RichTextView(Context r1) {
        super(r1);
        init();
    }

    public RichTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        LinkAccessibilityHelper r0 = new LinkAccessibilityHelper(this);
        this.accessibilityHelper = r0;
        ViewCompat.setAccessibilityDelegate(this, r0);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r2, TextView.BufferType r3) {
        CharSequence r4 = getRichText(getContext(), r2);
        super.setText(r4, r3);
        boolean r5 = hasLinks(r4);
        if (r5 == false) goto L5;
        setMovementMethod(TouchableMovementMethod.TouchableLinkMovementMethod.getInstance());
    L6:
        setFocusable(r5);
        setRevealOnFocusHint(false);
        setFocusableInTouchMode(r5);
        return;
    L5:
        setMovementMethod(null);
        goto L6
    }

    private boolean hasLinks(CharSequence r3) {
        if ((r3 instanceof Spanned) == true) goto L5;
        return false;
    L5:
        if (((ClickableSpan[]) ((Spanned) r3).getSpans(0, r3.length(), ClickableSpan.class)).length <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        boolean r0 = super.onTouchEvent(r3);
        MovementMethod r2 = getMovementMethod();
        if ((r2 instanceof TouchableMovementMethod) == false) goto L8;
        TouchableMovementMethod r4 = (TouchableMovementMethod) r2;
        if (r4.getLastTouchEvent() != r3) goto L8;
        return r4.isLastTouchEventHandled();
    L8:
        return r0;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent r2) {
        LinkAccessibilityHelper r0 = this.accessibilityHelper;
        if (r0 == null) goto L9;
        if (r0.dispatchHoverEvent(r2) == false) goto L9;
        return true;
    L9:
        return super.dispatchHoverEvent(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable[] r1 = getCompoundDrawablesRelative();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        Drawable r4 = r1[r3];
        if (r4 == null) goto L9;
        if (r4.setState(r0) == false) goto L9;
        invalidateDrawable(r4);
    L9:
        r3 = r3 + 1;
        goto L3
    }

    public void setOnLinkClickListener(LinkSpan.OnLinkClickListener r1) {
        this.onLinkClickListener = r1;
    }

    public LinkSpan.OnLinkClickListener getOnLinkClickListener() {
        return this.onLinkClickListener;
    }

    @Override // com.android.setupwizardlib.span.LinkSpan.OnLinkClickListener
    public boolean onLinkClick(LinkSpan r1) {
        LinkSpan.OnLinkClickListener r0 = this.onLinkClickListener;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onLinkClick(r1);
    }
}
