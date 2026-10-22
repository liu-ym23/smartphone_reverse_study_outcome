package com.android.setupwizardlib.items;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class ButtonItem extends AbstractItem implements View.OnClickListener {
    private Button button;
    private boolean enabled;
    private OnClickListener listener;
    private CharSequence text;
    private int theme;

    public interface OnClickListener {
        void onClick(ButtonItem r1);
    }

    @Override // com.android.setupwizardlib.items.AbstractItem, com.android.setupwizardlib.items.ItemHierarchy
    public int getCount() {
        return 0;
    }

    @Override // com.android.setupwizardlib.items.IItem
    public int getLayoutResource() {
        return 0;
    }

    public ButtonItem() {
        this.enabled = true;
        this.theme = R.style.SuwButtonItem;
    }

    public ButtonItem(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.enabled = true;
        this.theme = R.style.SuwButtonItem;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.SuwButtonItem);
        this.enabled = r5.getBoolean(R.styleable.SuwButtonItem_android_enabled, true);
        this.text = r5.getText(R.styleable.SuwButtonItem_android_text);
        this.theme = r5.getResourceId(R.styleable.SuwButtonItem_android_theme, R.style.SuwButtonItem);
        r5.recycle();
    }

    public void setOnClickListener(OnClickListener r1) {
        this.listener = r1;
    }

    public void setText(CharSequence r1) {
        this.text = r1;
    }

    public CharSequence getText() {
        return this.text;
    }

    public void setTheme(int r1) {
        this.theme = r1;
        this.button = null;
    }

    public int getTheme() {
        return this.theme;
    }

    public void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    @Override // com.android.setupwizardlib.items.IItem
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override // com.android.setupwizardlib.items.IItem
    public final void onBindView(View r1) {
        throw new UnsupportedOperationException("Cannot bind to ButtonItem's view");
    }

    protected Button createButton(ViewGroup r3) {
        Button r0 = this.button;
        if (r0 != null) goto L9;
        Context r4 = r3.getContext();
        if (this.theme == 0) goto L7;
        r4 = new ContextThemeWrapper(r4, this.theme);
    L7:
        Button r5 = createButton(r4);
        this.button = r5;
        r5.setOnClickListener(this);
    L11:
        this.button.setEnabled(this.enabled);
        this.button.setText(this.text);
        this.button.setId(getViewId());
        return this.button;
    L9:
        if ((r0.getParent() instanceof ViewGroup) == false) goto L11;
        ((ViewGroup) this.button.getParent()).removeView(this.button);
        goto L11
    }

    private Button createButton(Context r3) {
        return (Button) LayoutInflater.from(r3).inflate(R.layout.suw_button, null, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        OnClickListener r2 = this.listener;
        if (r2 == null) goto L6;
        r2.onClick(this);
        return;
    }
}
