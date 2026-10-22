package com.obric.oui.orecyclerview.widget;

import android.view.MotionEvent;
import com.obric.oui.orecyclerview.base.EdgeEffectAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecyclerViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/RecyclerViewExt;", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView;)V", "mAllowClickDuringOverScroll", "", "allowClickDuringOverScroll", "", "enable", "isDisallowInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "defaultVal", "Companion", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewExt {
    public static final Companion Companion = null;
    private static final int MAX_ALLOW_CLICK_OVER_SCROLL_DISTANCE = 100;
    private static final String TAG = "RecyclerViewExt";
    private boolean mAllowClickDuringOverScroll;
    private final RecyclerView recyclerView;

    /* JADX INFO: compiled from: RecyclerViewExt.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/RecyclerViewExt$Companion;", "", "()V", "MAX_ALLOW_CLICK_OVER_SCROLL_DISTANCE", "", "TAG", "", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RecyclerViewExt(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.recyclerView = r2;
    }

    public final void allowClickDuringOverScroll(boolean r1) {
        this.mAllowClickDuringOverScroll = r1;
    }

    public final boolean isDisallowInterceptTouchEvent(MotionEvent r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.mAllowClickDuringOverScroll == true) goto L6;
        return r7;
    L6:
        if (r6.getAction() == 0) goto L8;
        return r7;
    L8:
        EdgeEffectAdapter r8 = this.recyclerView.mHorizontalEdgeEffect;
        EdgeEffectAdapter r5 = this.recyclerView.mVerticalEdgeEffect;
        boolean r1 = false;
        if (r8 != null) goto L11;
    L18:
        if (r5 == null) goto L27;
        if (r5.getDistance() != 0.0f) goto L22;
        r1 = true;
    L22:
        if (r1 == true) goto L27;
        if (Math.abs(r5.getDistance()) >= 100.0f) goto L27;
        return true;
    L27:
        return r7;
    L11:
        if (r8.getDistance() != 0.0f) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L18;
        if (Math.abs(r8.getDistance()) >= 100.0f) goto L18;
        r7 = true;
        goto L18
    L13:
        r4 = false;
        goto L14
    }
}
