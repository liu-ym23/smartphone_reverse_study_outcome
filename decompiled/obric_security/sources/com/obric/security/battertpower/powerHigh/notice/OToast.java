package com.obric.security.battertpower.powerHigh.notice;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.DeadObjectException;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.toast.OToastConstants;
import com.obric.security.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OToast.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/notice/OToast;", "", "mContext", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "", "position", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "button", "Lcom/obric/oui/button/OButton;", "getButton", "()Lcom/obric/oui/button/OButton;", "setButton", "(Lcom/obric/oui/button/OButton;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "msgMaxWidth", InvokeHistoryActivity.PREF_SHOW, "", "Companion", "OutlineProvider", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OToast {
    public static final Companion Companion = null;
    private static final float DEFAULT_CONOR_RADIUS_PX = 0.0f;
    public static final int DURATION_LONG = 3500;
    public static final int DURATION_SHORT = 2000;
    public static final double MAX_WIDTH_RATIO = 0.75d;
    public static final int SNACKBAR_DURATION = 2000;
    private static final String TAG = null;
    private static final int TOAST_BOTTOM_MARGIN_PX = 0;
    private static final int TOAST_TOP_MARGIN_PX = 0;
    private OButton button;
    private View contentView;
    private final Context mContext;
    private final String msg;
    private int msgMaxWidth;
    private int position;

    /* JADX INFO: compiled from: OToast.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/notice/OToast$Companion;", "", "()V", "DEFAULT_CONOR_RADIUS_PX", "", "DURATION_LONG", "", "DURATION_SHORT", "MAX_WIDTH_RATIO", "", "SNACKBAR_DURATION", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOAST_BOTTOM_MARGIN_PX", "TOAST_TOP_MARGIN_PX", InvokeHistoryActivity.PREF_SHOW, "", "context", "Landroid/app/Activity;", NotificationCompat.CATEGORY_MESSAGE, "pos", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        public final void show(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String getTAG() {
            return OToast.access$getTAG$cp();
        }

        public static /* synthetic */ void show$default(Companion r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = 80;
        L5:
            r0.show(r1, r2);
        }

        public static /* synthetic */ void show$default(Companion r0, Activity r1, String r2, int r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = 80;
        L5:
            r0.show(r1, r2, r3);
        }

        public final void show(Activity r1, String r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            new OToast(r1, r2, r3).show();
        }
    }

    /* JADX INFO: compiled from: OToast.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0014\u0010\u0004\u001a\u00020\u0015*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0014\u0010\u0006\u001a\u00020\u0015*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/notice/OToast$OutlineProvider;", "Landroid/view/ViewOutlineProvider;", "yShift", "", "scaleX", "", "scaleY", "(Lcom/obric/security/battertpower/powerHigh/notice/OToast;IFF)V", "rect", "Landroid/graphics/Rect;", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getYShift", "()I", "setYShift", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "scale", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public final class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect;
        private float scaleX;
        private float scaleY;
        final /* synthetic */ OToast this$0;
        private int yShift;

        public OutlineProvider(OToast r1, int r2, float r3, float r4) {
            this.this$0 = r1;
            this.yShift = r2;
            this.scaleX = r3;
            this.scaleY = r4;
            this.rect = new Rect();
        }

        public final int getYShift() {
            return this.yShift;
        }

        public final void setYShift(int r1) {
            this.yShift = r1;
        }

        public final float getScaleX() {
            return this.scaleX;
        }

        public final void setScaleX(float r1) {
            this.scaleX = r1;
        }

        public final float getScaleY() {
            return this.scaleY;
        }

        public final void setScaleY(float r1) {
            this.scaleY = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r3, Outline r4) {
            if (r3 == null) goto L6;
            Drawable r5 = r3.getBackground();
            if (r5 == null) goto L6;
            r5.copyBounds(this.rect);
        L6:
            scaleX(this.rect, this.scaleX);
            scaleY(this.rect, this.scaleY);
            this.rect.offset(0, this.yShift);
            if (r4 == null) goto L10;
            r4.setRoundRect(this.rect, OToast.access$getMContext$p(this.this$0).getResources().getDimension(R.dimen.oui_r_l1));
            return;
        }

        private final void scaleX(Rect r2, float r3) {
            if (r3 == 1.0f) goto L6;
            r2.left = (int) ((r2.left * r3) + 0.5f);
            r2.right = (int) ((r2.right * r3) + 0.5f);
            return;
        }

        private final void scaleY(Rect r2, float r3) {
            if (r3 == 1.0f) goto L6;
            r2.top = (int) ((r2.top * r3) + 0.5f);
            r2.bottom = (int) ((r2.bottom * r3) + 0.5f);
            return;
        }
    }

    public OToast(Context r7, String r8) {
        this(r7, r8, 0, 4, null);
    }

    public OToast(Context r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "mContext");
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_MESSAGE);
        this.mContext = r4;
        this.msg = r5;
        this.position = r6;
        this.msgMaxWidth = MathKt.roundToInt(TypedValue.applyDimension(1, OToastConstants.MSG_MAX_WIDTH_DP, Resources.getSystem().getDisplayMetrics()));
        View r7 = LayoutInflater.from(r4).inflate(R.layout.o_toast, null);
        Intrinsics.checkNotNullExpressionValue(r7, "LayoutInflater.from(mCon…e(R.layout.o_toast, null)");
        this.contentView = r7;
        TextView r8 = (TextView) r7.findViewById(R.id.tv_msg);
        if (r8 == null) goto L5;
        r8.setText(r5);
    L5:
        this.button = (OButton) this.contentView.findViewById(R.id.right_button);
        View r9 = this.contentView;
        GradientDrawable r10 = new GradientDrawable();
        r10.setCornerRadius(r4.getResources().getDimension(R.dimen.oui_r_l1));
        r10.setColor(ContextCompat.getColorStateList(r4, R.color.oui_fill_toast_tooltip));
        r10.setStroke(1, ContextCompat.getColor(r4, R.color.LineTertiary));
        Unit r11 = Unit.INSTANCE;
        r9.setBackground(r10);
        this.contentView.setOutlineProvider(new OutlineProvider(this, -4, 1.0f, 0.9f));
        this.contentView.setElevation(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
    }

    public static final /* synthetic */ Context access$getMContext$p(OToast r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public /* synthetic */ OToast(Context r1, String r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 80;
    L5:
        this(r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
        TAG = "OToast";
        DEFAULT_CONOR_RADIUS_PX = TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics());
        TOAST_TOP_MARGIN_PX = MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics()));
        TOAST_BOTTOM_MARGIN_PX = MathKt.roundToInt(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()));
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentView = r2;
    }

    public final OButton getButton() {
        return this.button;
    }

    public final void setButton(OButton r1) {
        this.button = r1;
    }

    public final void show() {
        int r2 = this.position;     // Catch: DeadObjectException -> L17 RuntimeException -> L19
        if (r2 != 17) goto L6;
    L9:
        int r3 = 0;
    L12:
        TextView r4 = (TextView) this.contentView.findViewById(R.id.tv_msg);     // Catch: DeadObjectException -> L17 RuntimeException -> L19
        if (r4 == null) goto L15;
        r4.setMaxWidth(this.msgMaxWidth);     // Catch: DeadObjectException -> L17 RuntimeException -> L19
    L15:
        Toast r5 = Toast.makeText(this.mContext, this.msg, 0);     // Catch: DeadObjectException -> L17 RuntimeException -> L19
        r5.setView(this.contentView);     // Catch: DeadObjectException -> L17 RuntimeException -> L19
        r5.setGravity(this.position, r5.getXOffset(), r3);     // Catch: DeadObjectException -> L17 RuntimeException -> L19
        r5.show();     // Catch: DeadObjectException -> L17 RuntimeException -> L19
        Unit r6 = Unit.INSTANCE;     // Catch: DeadObjectException -> L17 RuntimeException -> L19
    L25:
        return;
    L6:
        if (r2 != 48) goto L8;
        r3 = TOAST_TOP_MARGIN_PX;     // Catch: DeadObjectException -> L17 RuntimeException -> L19
        goto L12
    L8:
        if (r2 != 80) goto L9;
        r3 = TOAST_BOTTOM_MARGIN_PX;     // Catch: DeadObjectException -> L17 RuntimeException -> L19
    L17:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try DeadObjectException occur, ", e.getMessage()));
        StringBuilder r7 = new StringBuilder();
    L21:
        ToolsExtKt.printLog(r7.append(TAG).append(", showAsDropDown exception occur, try showAtLocation").toString());
        Boolean.valueOf(true);
        return;
    L19:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try runtimeException occur, ", e.getMessage()));
        r7 = new StringBuilder();
        goto L21
    }
}
