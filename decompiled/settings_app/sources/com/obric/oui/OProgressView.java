package com.obric.oui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.progress.ODownloadProgressView;

/* JADX INFO: loaded from: classes4.dex */
public class OProgressView extends ODownloadProgressView {
    @Override // com.obric.oui.progress.ODownloadProgressView, android.view.View
    protected void onDetachedFromWindow() {
    }

    @Override // com.obric.oui.progress.ODownloadProgressView, android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
    }

    public OProgressView(Context r1) {
        super(r1);
    }

    public OProgressView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public OProgressView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public OProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
