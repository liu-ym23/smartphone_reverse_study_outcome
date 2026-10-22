package com.android.setupwizardlib.template;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import com.android.setupwizardlib.TemplateLayout;
import com.android.setupwizardlib.view.NavigationBar;

/* JADX INFO: loaded from: classes.dex */
public class RequireScrollMixin implements Mixin {
    private ScrollHandlingDelegate delegate;
    private boolean everScrolledToBottom;
    private final Handler handler;
    private OnRequireScrollStateChangedListener listener;
    private boolean requiringScrollToBottom;

    public interface OnRequireScrollStateChangedListener {
        void onRequireScrollStateChanged(boolean r1);
    }

    interface ScrollHandlingDelegate {
        void pageScrollDown();

        void startListening();
    }

    static /* synthetic */ boolean access$000(RequireScrollMixin r0) {
        return r0.requiringScrollToBottom;
    }

    static /* synthetic */ ScrollHandlingDelegate access$100(RequireScrollMixin r0) {
        return r0.delegate;
    }

    static /* synthetic */ OnRequireScrollStateChangedListener access$200(RequireScrollMixin r0) {
        return r0.listener;
    }

    public RequireScrollMixin(TemplateLayout r2) {
        this.handler = new Handler(Looper.getMainLooper());
        this.requiringScrollToBottom = false;
        this.everScrolledToBottom = false;
    }

    public void setScrollHandlingDelegate(ScrollHandlingDelegate r1) {
        this.delegate = r1;
    }

    public void setOnRequireScrollStateChangedListener(OnRequireScrollStateChangedListener r1) {
        this.listener = r1;
    }

    public OnRequireScrollStateChangedListener getOnRequireScrollStateChangedListener() {
        return this.listener;
    }

    public View.OnClickListener createOnClickListener(final View.OnClickListener r2) {
        return new AnonymousClass1(this, r2);
    }

    public void requireScrollWithNavigationBar(final NavigationBar r2) {
        setOnRequireScrollStateChangedListener(new AnonymousClass2(this, r2));
        r2.getMoreButton().setOnClickListener(createOnClickListener(null));
        requireScroll();
    }

    public void requireScrollWithButton(Button r2, int r3, View.OnClickListener r4) {
        requireScrollWithButton(r2, r2.getContext().getText(r3), r4);
    }

    public void requireScrollWithButton(final Button r2, final CharSequence r3, View.OnClickListener r4) {
        final CharSequence r0 = r2.getText();
        r2.setOnClickListener(createOnClickListener(r4));
        setOnRequireScrollStateChangedListener(new AnonymousClass3(this, r2, r3, r0));
        requireScroll();
    }

    public boolean isScrollingRequired() {
        return this.requiringScrollToBottom;
    }

    public void requireScroll() {
        this.delegate.startListening();
    }

    void notifyScrollabilityChange(boolean r2) {
        if (r2 != this.requiringScrollToBottom) goto L6;
        return;
    L6:
        if (r2 == true) goto L8;
        postScrollStateChange(false);
        this.requiringScrollToBottom = false;
        this.everScrolledToBottom = true;
        return;
    L8:
        if (this.everScrolledToBottom == true) goto L12;
        postScrollStateChange(true);
        this.requiringScrollToBottom = true;
        return;
    }

    private void postScrollStateChange(final boolean r3) {
        this.handler.post(new AnonymousClass4(this, r3));
    }
}
