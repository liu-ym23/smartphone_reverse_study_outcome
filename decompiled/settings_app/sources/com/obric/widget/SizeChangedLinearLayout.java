package com.obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SizeChangedLinearLayout.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/widget/SizeChangedLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mListener", "Lcom/obric/widget/SizeChangedLinearLayout$SizeChangedCallback;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "setSizeChangedListener", "listener", "Companion", "SizeChangedCallback", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SizeChangedLinearLayout extends LinearLayout {
    public static final Companion Companion = null;
    private static final String TAG = "SizeChangedRelativeLayout";
    private SizeChangedCallback mListener;

    /* JADX INFO: compiled from: SizeChangedLinearLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/widget/SizeChangedLinearLayout$Companion;", "", "()V", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: SizeChangedLinearLayout.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/widget/SizeChangedLinearLayout$SizeChangedCallback;", "", "execute", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SizeChangedCallback {
        void execute();
    }

    static {
        Companion = new Companion(null);
    }

    public SizeChangedLinearLayout(Context r1) {
        super(r1);
    }

    public SizeChangedLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SizeChangedLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public SizeChangedLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        OLog.i(TAG, "onSizeChanged: " + r3 + TokenParser.SP + r4 + TokenParser.SP + r5 + TokenParser.SP + r6);
        SizeChangedCallback r2 = this.mListener;
        if (r2 == null) goto L6;
        r2.execute();
        return;
    }

    public final void setSizeChangedListener(SizeChangedCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mListener = r2;
    }
}
