package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SlideListView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SearchBar;
import obric.widget.letters.QuickBarEx;

/* JADX INFO: loaded from: classes2.dex */
public final class OcrAppListBinding implements ViewBinding {
    public final SlideListView listView;
    public final QuickBarEx quickbar;
    private final RelativeLayout rootView;
    public final TitleSecondaryBarShadowBinding searchBarShadow;
    public final SearchBar searchbar;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;
    public final RelativeLayout wholeView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OcrAppListBinding(RelativeLayout r1, SlideListView r2, QuickBarEx r3, TitleSecondaryBarShadowBinding r4, SearchBar r5, TextView r6, OFloatingTitleBar r7, RelativeLayout r8) {
        this.rootView = r1;
        this.listView = r2;
        this.quickbar = r3;
        this.searchBarShadow = r4;
        this.searchbar = r5;
        this.viewEmpty = r6;
        this.viewTitle = r7;
        this.wholeView = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OcrAppListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OcrAppListBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ocr_app_list, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OcrAppListBinding bind(View r11) {
        int r0 = R.id.listView;
        SlideListView r4 = (SlideListView) ViewBindings.findChildViewById(r11, R.id.listView);
        if (r4 == null) goto L17;
        r0 = R.id.quickbar;
        QuickBarEx r5 = (QuickBarEx) ViewBindings.findChildViewById(r11, R.id.quickbar);
        if (r5 == null) goto L17;
        r0 = R.id.search_bar_shadow;
        View r1 = ViewBindings.findChildViewById(r11, R.id.search_bar_shadow);
        if (r1 == null) goto L17;
        TitleSecondaryBarShadowBinding r6 = TitleSecondaryBarShadowBinding.bind(r1);
        r0 = R.id.searchbar;
        SearchBar r7 = (SearchBar) ViewBindings.findChildViewById(r11, R.id.searchbar);
        if (r7 == null) goto L17;
        r0 = R.id.view_empty;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.view_empty);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r9 == null) goto L17;
        RelativeLayout r10 = (RelativeLayout) r11;
        return new OcrAppListBinding(r10, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
