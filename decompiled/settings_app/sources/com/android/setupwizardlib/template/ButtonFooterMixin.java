package com.android.setupwizardlib.template;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;

/* JADX INFO: loaded from: classes.dex */
public class ButtonFooterMixin implements Mixin {
    private LinearLayout buttonContainer;
    private final Context context;
    private final ViewStub footerStub;

    public ButtonFooterMixin(TemplateLayout r2) {
        this.context = r2.getContext();
        this.footerStub = (ViewStub) r2.findManagedViewById(R.id.suw_layout_footer);
    }

    public Button addButton(CharSequence r2, int r3) {
        Button r4 = createThemedButton(this.context, r3);
        r4.setText(r2);
        return addButton(r4);
    }

    public Button addButton(int r2, int r3) {
        Button r4 = createThemedButton(this.context, r3);
        r4.setText(r2);
        return addButton(r4);
    }

    public Button addButton(Button r1) {
        ensureFooterInflated().addView(r1);
        return r1;
    }

    public View addSpace() {
        LinearLayout r4 = ensureFooterInflated();
        View r0 = new View(r4.getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        r0.setVisibility(4);
        r4.addView(r0);
        return r0;
    }

    public void removeButton(Button r1) {
        LinearLayout r0 = this.buttonContainer;
        if (r0 == null) goto L6;
        r0.removeView(r1);
        return;
    }

    public void removeSpace(View r1) {
        LinearLayout r0 = this.buttonContainer;
        if (r0 == null) goto L6;
        r0.removeView(r1);
        return;
    }

    public void removeAllViews() {
        LinearLayout r0 = this.buttonContainer;
        if (r0 == null) goto L6;
        r0.removeAllViews();
        return;
    }

    private LinearLayout ensureFooterInflated() {
        if (this.buttonContainer != null) goto L10;
        ViewStub r0 = this.footerStub;
        if (r0 == null) goto L8;
        r0.setLayoutResource(R.layout.suw_glif_footer_button_bar);
        this.buttonContainer = (LinearLayout) this.footerStub.inflate();
        goto L10
    L8:
        throw new IllegalStateException("Footer stub is not found in this template");
    L10:
        return this.buttonContainer;
    }

    private Button createThemedButton(Context r2, int r3) {
        return (Button) LayoutInflater.from(new ContextThemeWrapper(r2, r3)).inflate(R.layout.suw_button, null, false);
    }
}
