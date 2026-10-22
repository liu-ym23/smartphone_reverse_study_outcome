package com.obric.oui.pullrefresh.header;

import android.view.View;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.RefreshState;
import kotlin.Metadata;

/* JADX INFO: compiled from: ORefreshHeader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "", "getView", "Landroid/view/View;", "onFinish", "", "layout", "Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "success", "", "onPulling", "fraction", "", "offsetY", "headerHeight", "onStateChanged", "oldState", "Lcom/obric/oui/pullrefresh/RefreshState;", "newState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ORefreshHeader {
    View getView();

    void onFinish(OPullRefreshLayout r1, boolean r2);

    void onPulling(OPullRefreshLayout r1, float r2, float r3, float r4);

    void onStateChanged(OPullRefreshLayout r1, RefreshState r2, RefreshState r3);
}
