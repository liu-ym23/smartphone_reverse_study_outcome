package com.android.settings;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBarEx extends RelativeLayout implements View.OnClickListener {
    private View mBtnCancel;
    private View mBtnClearSearch;
    private View mEditLayout;
    private boolean mIsPlaySearchAnimation;
    private boolean mIsSearchMode;
    private Listener mListener;
    private EditText mSearchEdit;
    private boolean mSearchEnabled;
    private View mSearchViewLeft;
    private View mSearchViewRight;

    public interface Listener {
        void exeExitSearchAnimation(boolean r1);

        void exeStartSearchAnimation();

        void searchText(String r1);

        void startSearch();
    }

    static /* synthetic */ Listener access$000(SearchBarEx r0) {
        return r0.mListener;
    }

    static /* synthetic */ EditText access$100(SearchBarEx r0) {
        return r0.mSearchEdit;
    }

    static /* synthetic */ View access$200(SearchBarEx r0) {
        return r0.mBtnClearSearch;
    }

    static /* synthetic */ View access$300(SearchBarEx r0) {
        return r0.mBtnCancel;
    }

    static /* synthetic */ boolean access$402(SearchBarEx r0, boolean r1) {
        r0.mIsPlaySearchAnimation = r1;
        return r1;
    }

    static /* synthetic */ void access$500(SearchBarEx r0, int r1) {
        r0.resetSearchViewParam(r1);
    }

    static /* synthetic */ void access$600(SearchBarEx r0) {
        r0.showKeyboard();
    }

    public SearchBarEx(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mSearchEnabled = true;
        this.mIsPlaySearchAnimation = false;
        initViews(LayoutInflater.from(r1).inflate(R.layout.searchbar_ex, this));
    }

    private void initViews(View r2) {
        this.mBtnCancel = r2.findViewById(R.id.btn_cancel);
        this.mSearchEdit = (EditText) r2.findViewById(R.id.edit);
        this.mEditLayout = r2.findViewById(R.id.searchbar_edit_ll);
        this.mBtnClearSearch = r2.findViewById(R.id.btn_edit_clear);
        this.mSearchViewLeft = r2.findViewById(R.id.searchbar_left_tv);
        this.mSearchViewRight = r2.findViewById(R.id.searchbar_right_tv);
        View r3 = this.mBtnCancel;
        if (r3 == null) goto L5;
        r3.setOnClickListener(this);
    L5:
        View r4 = this.mBtnClearSearch;
        if (r4 == null) goto L8;
        r4.setOnClickListener(this);
    L8:
        View r5 = this.mSearchViewLeft;
        if (r5 == null) goto L11;
        r5.setOnClickListener(this);
    L11:
        View r6 = this.mSearchViewRight;
        if (r6 == null) goto L14;
        r6.setOnClickListener(this);
    L14:
        EditText r7 = this.mSearchEdit;
        if (r7 == null) goto L18;
        r7.setOnClickListener(this);
        this.mSearchEdit.setOnEditorActionListener(new AnonymousClass1(this));
        this.mSearchEdit.addTextChangedListener(new AnonymousClass2(this));
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        switch(r1.getId()) {
            case 2131427838: goto L7;
            case 2131427855: goto L6;
            case 2131428525: goto L5;
            case 2131430746: goto L5;
            case 2131430747: goto L5;
            default: goto L11;
        };
    L5:
        startSearch();
        return;
    L6:
        clearSearchText();
        return;
    L7:
        cancelSearch(true);
        return;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
    }

    public void setSearchEnabled(boolean r1) {
        this.mSearchEnabled = r1;
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    public boolean isSearchMode() {
        return this.mIsSearchMode;
    }

    public boolean isPlayingSearchAnimation() {
        return this.mIsPlaySearchAnimation;
    }

    public void hideKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEdit.getWindowToken(), 2);
    }

    private void showKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.mSearchEdit, 0);
    }

    private void clearSearchText() {
        this.mSearchEdit.setText(null);
    }

    private void startSearch() {
        if (this.mSearchEnabled == true) goto L6;
        return;
    L6:
        if (this.mIsSearchMode == false) goto L8;
        return;
    L8:
        if (this.mIsPlaySearchAnimation == true) goto L16;
        Listener r0 = this.mListener;
        if (r0 == null) goto L13;
        r0.startSearch();
    L13:
        this.mIsSearchMode = true;
        this.mSearchEdit.setFocusable(true);
        this.mSearchEdit.setCursorVisible(true);
        this.mSearchEdit.setFocusableInTouchMode(true);
        this.mSearchEdit.requestFocus();
        this.mEditLayout.setVisibility(0);
        startAnimation();
        return;
    }

    public void cancelSearch(boolean r4) {
        if (this.mIsSearchMode == true) goto L5;
        return;
    L5:
        if (this.mIsPlaySearchAnimation == false) goto L8;
        if (r4 == false) goto L8;
        return;
    L8:
        this.mIsSearchMode = false;
        this.mSearchEdit.setFocusable(false);
        this.mSearchEdit.setCursorVisible(false);
        this.mSearchEdit.setFocusableInTouchMode(false);
        this.mEditLayout.setVisibility(8);
        TextKeyListener.clear(this.mSearchEdit.getText());
        if (r4 == false) goto L11;
        cancelAnimation();
    L15:
        post(new AnonymousClass3(this));
        return;
    L11:
        resetSearchViewParam(0);
        this.mSearchViewRight.setTranslationX(0.0f);
        this.mBtnCancel.setVisibility(4);
        Listener r5 = this.mListener;
        if (r5 == null) goto L14;
        r5.exeExitSearchAnimation(false);
    L14:
        this.mIsPlaySearchAnimation = false;
        goto L15
    }

    private void startAnimation() {
        final int r0 = this.mBtnCancel.getWidth();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mSearchViewRight, View.TRANSLATION_X, new float[]{0.0f, -Math.abs(r0)});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mBtnCancel, View.TRANSLATION_X, new float[]{r0, 0.0f});
        r2.setInterpolator(new DecelerateInterpolator(1.5f));
        r2.addListener(new AnonymousClass4(this));
        AnimatorSet r3 = new AnimatorSet();
        r3.setDuration(200);
        r3.addListener(new AnonymousClass5(this, r0));
        r3.play(r1).with(r2);
        r3.start();
    }

    private void cancelAnimation() {
        int r0 = this.mBtnCancel.getWidth();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mSearchViewRight, View.TRANSLATION_X, new float[]{-Math.abs(r0), 0.0f});
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mBtnCancel, View.TRANSLATION_X, new float[]{0.0f, r0});
        r1.setInterpolator(new DecelerateInterpolator(1.5f));
        AnimatorSet r3 = new AnimatorSet();
        r3.setDuration(200);
        r3.addListener(new AnonymousClass6(this));
        r3.play(r2).with(r1);
        r3.start();
    }

    private void resetSearchViewParam(int r2) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mEditLayout.getLayoutParams();
        r0.rightMargin = r2;
        this.mEditLayout.setLayoutParams(r0);
    }
}
