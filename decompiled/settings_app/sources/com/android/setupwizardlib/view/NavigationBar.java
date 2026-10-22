package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class NavigationBar extends LinearLayout implements View.OnClickListener {
    private Button backButton;
    private NavigationBarListener listener;
    private Button moreButton;
    private Button nextButton;

    public interface NavigationBarListener {
        void onNavigateBack();

        void onNavigateNext();
    }

    private static int getNavbarTheme(Context r6) {
        boolean r3 = false;
        TypedArray r7 = r6.obtainStyledAttributes(new int[]{R.attr.suwNavBarTheme, android.R.attr.colorForeground, android.R.attr.colorBackground});
        int r1 = r7.getResourceId(0, 0);
        if (r1 != 0) goto L11;
        float[] r2 = new float[3];
        float[] r0 = new float[3];
        Color.colorToHSV(r7.getColor(1, 0), r2);
        Color.colorToHSV(r7.getColor(2, 0), r0);
        if (r2[2] <= r0[2]) goto L7;
        r3 = true;
    L7:
        if (r3 == false) goto L9;
        int r4 = R.style.SuwNavBarThemeDark;
    L10:
        r1 = r4;
        goto L11
    L9:
        r4 = R.style.SuwNavBarThemeLight;
    L11:
        r7.recycle();
        return r1;
    }

    private static Context getThemedContext(Context r2) {
        return new ContextThemeWrapper(r2, getNavbarTheme(r2));
    }

    public NavigationBar(Context r1) {
        super(getThemedContext(r1));
        init();
    }

    public NavigationBar(Context r1, AttributeSet r2) {
        super(getThemedContext(r1), r2);
        init();
    }

    public NavigationBar(Context r1, AttributeSet r2, int r3) {
        super(getThemedContext(r1), r2, r3);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.suw_navbar_view, this);
        this.nextButton = (Button) findViewById(R.id.suw_navbar_next);
        this.backButton = (Button) findViewById(R.id.suw_navbar_back);
        this.moreButton = (Button) findViewById(R.id.suw_navbar_more);
    }

    public Button getBackButton() {
        return this.backButton;
    }

    public Button getNextButton() {
        return this.nextButton;
    }

    public Button getMoreButton() {
        return this.moreButton;
    }

    public void setNavigationBarListener(NavigationBarListener r1) {
        this.listener = r1;
        if (r1 == null) goto L6;
        getBackButton().setOnClickListener(this);
        getNextButton().setOnClickListener(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.listener != null) goto L5;
        return;
    L5:
        if (r2 != getBackButton()) goto L8;
        this.listener.onNavigateBack();
        return;
    L8:
        if (r2 != getNextButton()) goto L13;
        this.listener.onNavigateNext();
        return;
    }
}
