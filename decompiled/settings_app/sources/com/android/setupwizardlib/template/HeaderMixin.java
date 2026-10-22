package com.android.setupwizardlib.template;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;

/* JADX INFO: loaded from: classes.dex */
public class HeaderMixin implements Mixin {
    private final TemplateLayout templateLayout;

    public HeaderMixin(TemplateLayout r3, AttributeSet r4, int r5) {
        this.templateLayout = r3;
        TypedArray r6 = r3.getContext().obtainStyledAttributes(r4, R.styleable.SuwHeaderMixin, r5, 0);
        CharSequence r7 = r6.getText(R.styleable.SuwHeaderMixin_suwHeaderText);
        if (r7 == null) goto L5;
        setText(r7);
    L5:
        r6.recycle();
    }

    public TextView getTextView() {
        return (TextView) this.templateLayout.findManagedViewById(R.id.suw_layout_title);
    }

    public void setText(int r1) {
        TextView r0 = getTextView();
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public void setText(CharSequence r1) {
        TextView r0 = getTextView();
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public CharSequence getText() {
        TextView r0 = getTextView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText();
    }
}
