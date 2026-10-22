package com.obric.oui.pullrefresh.header;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.RefreshState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ODefaultRefreshHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J(\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016J \u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201J\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J6\u00102\u001a\u00020\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020\u001bH\u0002J\b\u00108\u001a\u00020\u001bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/pullrefresh/header/ODefaultRefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "arrowAnimator", "Landroid/animation/ObjectAnimator;", "arrowPointUp", "", "arrowView", "Landroid/widget/ImageView;", "progressBar", "Lcom/obric/oui/progress/ODownloadProgressView;", "successView", "textPull", "", "textRefreshing", "textRelease", "textSuccess", "titleView", "Landroid/widget/TextView;", "getView", "Landroid/view/View;", "onFinish", "", "layout", "Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "success", "onPulling", "fraction", "", "offsetY", "headerHeight", "onStateChanged", "oldState", "Lcom/obric/oui/pullrefresh/RefreshState;", "newState", "rotateArrow", "pointUp", "withAnim", "setIconColor", "color", "", "setProgressBackgroundColor", "setTextColor", "colors", "Landroid/content/res/ColorStateList;", "setTexts", "pull", "release", "refreshing", "showArrow", "showProgress", "showSuccess", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODefaultRefreshHeader extends FrameLayout implements ORefreshHeader {
    private ObjectAnimator arrowAnimator;
    private boolean arrowPointUp;
    private final ImageView arrowView;
    private final ODownloadProgressView progressBar;
    private final ImageView successView;
    private CharSequence textPull;
    private CharSequence textRefreshing;
    private CharSequence textRelease;
    private CharSequence textSuccess;
    private final TextView titleView;

    /* JADX INFO: compiled from: ODefaultRefreshHeader.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            r0[RefreshState.PULL_TO_REFRESH.ordinal()] = 1;
            r0[RefreshState.IDLE.ordinal()] = 2;
            r0[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            r0[RefreshState.REFRESHING.ordinal()] = 4;
            r0[RefreshState.FINISH.ordinal()] = 5;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ODefaultRefreshHeader(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ODefaultRefreshHeader(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public ODefaultRefreshHeader(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        String r5 = r3.getString(R.string.oui_pull_to_refresh);
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.string.oui_pull_to_refresh)");
        this.textPull = r5;
        String r6 = r3.getString(R.string.oui_release_to_refresh);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(R.string.oui_release_to_refresh)");
        this.textRelease = r6;
        String r7 = r3.getString(R.string.oui_refreshing);
        Intrinsics.checkNotNullExpressionValue(r7, "context.getString(R.string.oui_refreshing)");
        this.textRefreshing = r7;
        String r8 = r3.getString(R.string.oui_refresh_success);
        Intrinsics.checkNotNullExpressionValue(r8, "context.getString(R.string.oui_refresh_success)");
        this.textSuccess = r8;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(r3).inflate(R.layout.o_pullrefresh_default_header, this, true);
        View r9 = findViewById(R.id.pr_iv_arrow);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.pr_iv_arrow)");
        this.arrowView = (ImageView) r9;
        View r10 = findViewById(R.id.pr_iv_success);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.pr_iv_success)");
        this.successView = (ImageView) r10;
        View r11 = findViewById(R.id.pr_progress);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.pr_progress)");
        this.progressBar = (ODownloadProgressView) r11;
        View r12 = findViewById(R.id.pr_tv_title);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.pr_tv_title)");
        this.titleView = (TextView) r12;
        setAlpha(0.0f);
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    public View getView() {
        return this;
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    public void onPulling(OPullRefreshLayout r1, float r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        setAlpha(RangesKt.coerceIn(r2, 0.0f, 1.0f));
        if (r1.getState() != RefreshState.IDLE) goto L5;
    L6:
        this.titleView.setText(this.textPull);
        this.progressBar.setVisibility(8);
        this.successView.setVisibility(8);
        this.arrowView.setVisibility(0);
        if (this.arrowPointUp == false) goto L11;
        this.arrowView.setRotation(0.0f);
        this.arrowPointUp = false;
        return;
    L11:
        return;
    L5:
        if (r1.getState() == RefreshState.PULL_TO_REFRESH) goto L6;
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    public void onStateChanged(OPullRefreshLayout r3, RefreshState r4, RefreshState r5) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r4, "oldState");
        Intrinsics.checkNotNullParameter(r5, "newState");
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        boolean r7 = false;
        boolean r0 = true;
        if (r6 != 1) goto L5;
    L19:
        this.titleView.setText(this.textPull);
        showArrow();
        if (r4 == RefreshState.RELEASE_TO_REFRESH) goto L23;
        r0 = false;
    L23:
        rotateArrow(false, r0);
        return;
    L5:
        if (r6 == 2) goto L19;
        if (r6 != 3) goto L9;
        this.titleView.setText(this.textRelease);
        showArrow();
        if (r4 != RefreshState.PULL_TO_REFRESH) goto L18;
        r7 = true;
    L18:
        rotateArrow(true, r7);
        return;
    L9:
        if (r6 != 4) goto L11;
        this.titleView.setText(this.textRefreshing);
        showProgress();
        return;
    L11:
        if (r6 != 5) goto L28;
        this.titleView.setText(this.textSuccess);
        showSuccess();
        return;
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    public void onFinish(OPullRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        ObjectAnimator r3 = this.arrowAnimator;
        if (r3 == null) goto L6;
        r3.cancel();
    L6:
        this.arrowView.setRotation(0.0f);
        this.arrowPointUp = false;
    }

    private final void showArrow() {
        this.progressBar.setVisibility(8);
        this.successView.setVisibility(8);
        this.arrowView.setVisibility(0);
    }

    private final void showProgress() {
        this.successView.setVisibility(8);
        this.arrowView.setVisibility(8);
        this.progressBar.setVisibility(0);
        setAlpha(1.0f);
    }

    private final void showSuccess() {
        this.arrowView.setVisibility(8);
        this.progressBar.setVisibility(8);
        this.successView.setVisibility(0);
        setAlpha(1.0f);
    }

    private final void rotateArrow(boolean r6, boolean r7) {
        if (this.arrowPointUp != r6) goto L5;
        return;
    L5:
        ObjectAnimator r0 = this.arrowAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        float r1 = 0.0f;
        if (r6 == false) goto L12;
        float r2 = 0.0f;
    L13:
        if (r6 == false) goto L15;
        r1 = 180.0f;
    L15:
        if (r7 == false) goto L17;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.arrowView, View.ROTATION, new float[]{r2, r1});
        r8.setDuration(200);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.start();
        this.arrowAnimator = r8;
    L18:
        this.arrowPointUp = r6;
        return;
    L17:
        this.arrowView.setRotation(r1);
        goto L18
    L12:
        r2 = 180.0f;
        goto L13
    }

    public static /* synthetic */ void setTexts$default(ODefaultRefreshHeader r1, CharSequence r2, CharSequence r3, CharSequence r4, CharSequence r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        r1.setTexts(r2, r3, r4, r5);
    }

    public final void setTexts(CharSequence r1, CharSequence r2, CharSequence r3, CharSequence r4) {
        if (r1 == null) goto L4;
        this.textPull = r1;
    L4:
        if (r2 == null) goto L6;
        this.textRelease = r2;
    L6:
        if (r3 == null) goto L8;
        this.textRefreshing = r3;
    L8:
        if (r4 == null) goto L10;
        this.textSuccess = r4;
    L10:
        TextView r5 = this.titleView;
        if (this.progressBar.getVisibility() != 0) goto L14;
        CharSequence r0 = this.textRefreshing;
    L20:
        r5.setText(r0);
        return;
    L14:
        if (this.successView.getVisibility() != 0) goto L17;
        r0 = this.textSuccess;
        goto L20
    L17:
        if (this.arrowPointUp == false) goto L19;
        r0 = this.textRelease;
        goto L20
    L19:
        r0 = this.textPull;
        goto L20
    }

    public final void setTextColor(int r1) {
        this.titleView.setTextColor(r1);
    }

    public final void setTextColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        this.titleView.setTextColor(r2);
    }

    public final void setIconColor(int r2) {
        this.progressBar.setProcessingColor(r2);
        this.arrowView.setColorFilter(r2);
        this.successView.setColorFilter(r2);
    }

    public final void setProgressBackgroundColor(int r1) {
        this.progressBar.setProgressBackgroundColor(r1);
    }
}
