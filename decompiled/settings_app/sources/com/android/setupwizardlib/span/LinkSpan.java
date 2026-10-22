package com.android.setupwizardlib.span;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class LinkSpan extends ClickableSpan {
    private static final String TAG = "LinkSpan";
    private static final Typeface TYPEFACE_MEDIUM = null;
    private final String id;

    @Deprecated
    public interface OnClickListener {
        void onClick(LinkSpan r1);
    }

    public interface OnLinkClickListener {
        boolean onLinkClick(LinkSpan r1);
    }

    static {
        TYPEFACE_MEDIUM = Typeface.create("sans-serif-medium", 0);
    }

    public LinkSpan(String r1) {
        this.id = r1;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r2) {
        if (dispatchClick(r2) == false) goto L5;
        r2.cancelPendingInputEvents();
    L7:
        if ((r2 instanceof TextView) == false) goto L12;
        CharSequence r1 = ((TextView) r2).getText();
        if ((r1 instanceof Spannable) == false) goto L13;
        Selection.setSelection((Spannable) r1, 0);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        Log.w(TAG, "Dropping click event. No listener attached.");
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean dispatchClick(View r2) {
        if ((r2 instanceof OnLinkClickListener) == false) goto L5;
        boolean r0 = ((OnLinkClickListener) r2).onLinkClick(this);
    L6:
        if (r0 == true) goto L11;
        OnClickListener r3 = getLegacyListenerFromContext(r2.getContext());
        if (r3 == null) goto L12;
        r3.onClick(this);
        return true;
    L12:
        return r0;
    L11:
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated
    private OnClickListener getLegacyListenerFromContext(Context r1) {
    L3:
        if ((r1 instanceof OnClickListener) == true) goto L5;
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        Object r2 = ((ContextWrapper) r2).getBaseContext();
        goto L3
    L9:
        return null;
    L5:
        return (OnClickListener) r2;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        super.updateDrawState(r1);
        r1.setUnderlineText(false);
        r1.setTypeface(TYPEFACE_MEDIUM);
    }

    public String getId() {
        return this.id;
    }
}
