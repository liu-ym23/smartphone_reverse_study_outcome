package com.obric.oui.window.permission;

import android.view.View;
import com.obric.oui.utils.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ WebViewActivity c;

    public /* synthetic */ a(WebViewActivity r1, int r2) {
        this.b = r2;
        this.c = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WebViewActivity r3 = this.c;
        switch(this.b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r1 = WebViewActivity.f;
        r3.finish();
        return;
    L6:
        int r4 = WebViewActivity.f;
        r3.getClass();
        if (NetworkUtil.a(r3) == false) goto L10;
        r3.e.setVisibility(8);
        r3.b.setVisibility(0);
        r3.b.reload();
        return;
    }
}
