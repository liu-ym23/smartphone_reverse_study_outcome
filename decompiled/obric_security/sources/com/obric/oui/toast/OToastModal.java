package com.obric.oui.toast;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OToastModal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ^2\u00020\u0001:\u0002]^B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0006\u00102\u001a\u000203J\b\u00104\u001a\u000203H\u0002J\u0006\u00105\u001a\u000203J\b\u00106\u001a\u000203H\u0002J\u0010\u00107\u001a\u0002032\u0006\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u000203H\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0007J\u0015\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010@J\u0015\u0010>\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010BJ\u0015\u0010C\u001a\u00020\u00002\b\u0010D\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010BJ\u0010\u0010,\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0014J\"\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010I2\b\b\u0002\u0010J\u001a\u00020\u0007J\u0010\u0010K\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010@J\u0015\u0010K\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010BJ\u0012\u0010L\u001a\u0002032\n\b\u0002\u00108\u001a\u0004\u0018\u00010#J\u0010\u0010M\u001a\u0002032\b\u0010N\u001a\u0004\u0018\u00010OJ\u0010\u0010P\u001a\u0002032\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0010\u0010S\u001a\u0002032\b\u0010T\u001a\u0004\u0018\u00010UJ\u0012\u0010V\u001a\u0002032\b\u00108\u001a\u0004\u0018\u00010#H\u0003J\b\u0010W\u001a\u000203H\u0002J\u0018\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\u0007H\u0002J\u000e\u0010[\u001a\u0004\u0018\u00010#*\u00020\u0014H\u0002J\u000e\u0010\\\u001a\u0004\u0018\u00010#*\u00020\u0014H\u0002R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/obric/oui/toast/OToastModal;", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "", "position", "", "includeCutoutInLandscape", "", "style", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Boolean;I)V", "baseMsgMaxWidth", "button", "Lcom/obric/oui/button/OButton;", "getButton", "()Lcom/obric/oui/button/OButton;", "setButton", "(Lcom/obric/oui/button/OButton;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "dismissRunnable", "Ljava/lang/Runnable;", "drawableReservedWidth", "duration", "forceRemoveRunnable", "handler", "Landroid/os/Handler;", "hostAttachListener", "Landroid/view/View$OnAttachStateChangeListener;", "hostParent", "Landroid/view/ViewGroup;", "hostView", "Ljava/lang/Boolean;", "isDismissing", "ivIcon", "Landroid/widget/ImageView;", "msgMaxWidth", "rightAction", "getRightAction", "setRightAction", "toastProgress", "Lcom/obric/oui/progress/ODownloadProgressView;", "tvMsg", "Landroid/widget/TextView;", "verticalWidthSpace", "cancel", "", "dismissWithAnimation", "enableProgressbar", "recalculateMsgMaxWidth", "registerHostParent", "parent", "removeHostView", "setDuration", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/toast/OToastModal;", "setLeftDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "res", "(Ljava/lang/Integer;)Lcom/obric/oui/toast/OToastModal;", "setPos", "pos", "action", "setRightButtonAndClickListener", "string", "listener", "Landroid/view/View$OnClickListener;", "bgColorResId", "setStartDrawable", InvokeHistoryActivity.PREF_SHOW, "showInActivity", "activity", "Landroid/app/Activity;", "showInDialog", "dialog", "Landroid/app/Dialog;", "showInPopupWindow", "popupWindow", "Landroid/widget/PopupWindow;", "showInternal", "unregisterHostParent", "wrapWithShadowFrame", "view", "yOffset", "findPopupWindowAttachParent", "findPopupWindowParent", "Builder", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OToastModal {
    public static final Companion Companion = null;
    private static final long FORCE_REMOVE_DELAY_MS = 80;
    public static final String TAG = "OToastModal";
    private final int baseMsgMaxWidth;
    private OButton button;
    private View contentView;
    private final Context context;
    private final Runnable dismissRunnable;
    private final int drawableReservedWidth;
    private int duration;
    private final Runnable forceRemoveRunnable;
    private final Handler handler;
    private View.OnAttachStateChangeListener hostAttachListener;
    private ViewGroup hostParent;
    private View hostView;
    private Boolean includeCutoutInLandscape;
    private boolean isDismissing;
    private ImageView ivIcon;
    private final String msg;
    private int msgMaxWidth;
    private int position;
    private View rightAction;
    private int style;
    private ODownloadProgressView toastProgress;
    private TextView tvMsg;
    private final int verticalWidthSpace;

    /* JADX INFO: compiled from: OToastModal.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010!\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010&\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0013J\"\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010+\u001a\u00020\bJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010,\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010$J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bJ\u0012\u0010.\u001a\u00020\u001c2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/oui/toast/OToastModal$Builder;", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "", "(Landroid/content/Context;Ljava/lang/String;)V", "duration", "", "enableProgressbar", "", "includeCutoutInLandscape", "Ljava/lang/Boolean;", "leftDrawable", "Landroid/graphics/drawable/Drawable;", "leftDrawableRes", "Ljava/lang/Integer;", "position", "rightAction", "Landroid/view/View;", "rightButtonBgColorResId", "rightButtonListener", "Landroid/view/View$OnClickListener;", "rightButtonText", "startDrawable", "startDrawableRes", "style", "build", "Lcom/obric/oui/toast/OToastModal;", "setDuration", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/toast/OToastModal$Builder;", "setLeftDrawable", "drawable", "res", "(Ljava/lang/Integer;)Lcom/obric/oui/toast/OToastModal$Builder;", "setPosition", "setRightAction", "action", "setRightButtonAndClickListener", "text", "listener", "bgColorResId", "setStartDrawable", "setStyle", InvokeHistoryActivity.PREF_SHOW, "host", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private final Context context;
        private int duration;
        private boolean enableProgressbar;
        private Boolean includeCutoutInLandscape;
        private Drawable leftDrawable;
        private Integer leftDrawableRes;
        private final String msg;
        private int position;
        private View rightAction;
        private int rightButtonBgColorResId;
        private View.OnClickListener rightButtonListener;
        private String rightButtonText;
        private Drawable startDrawable;
        private Integer startDrawableRes;
        private int style;

        public Builder(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
            this.context = r2;
            this.msg = r3;
            this.position = 80;
            this.duration = 2000;
            this.rightButtonBgColorResId = R.color.oui_toast_button_background;
        }

        public final Builder setPosition(int r2) {
            this.position = r2;
            return this;
        }

        public final Builder setIncludeCutoutInLandscape(Boolean r2) {
            this.includeCutoutInLandscape = r2;
            return this;
        }

        public final Builder setStyle(int r2) {
            this.style = r2;
            return this;
        }

        public final Builder setDuration(int r2) {
            this.duration = r2;
            return this;
        }

        public final Builder setLeftDrawable(Integer r2) {
            this.leftDrawableRes = r2;
            this.leftDrawable = null;
            return this;
        }

        public final Builder setLeftDrawable(Drawable r2) {
            this.leftDrawable = r2;
            this.leftDrawableRes = null;
            return this;
        }

        public final Builder setStartDrawable(Integer r2) {
            this.startDrawableRes = r2;
            this.startDrawable = null;
            return this;
        }

        public final Builder setStartDrawable(Drawable r2) {
            this.startDrawable = r2;
            this.startDrawableRes = null;
            return this;
        }

        public final Builder enableProgressbar() {
            this.enableProgressbar = true;
            return this;
        }

        public final Builder setRightAction(View r2) {
            this.rightAction = r2;
            this.rightButtonText = null;
            this.rightButtonListener = null;
            return this;
        }

        public static /* synthetic */ Builder setRightButtonAndClickListener$default(Builder r0, String r1, View.OnClickListener r2, int r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = R.color.oui_toast_button_background;
        L6:
            return r0.setRightButtonAndClickListener(r1, r2, r3);
        }

        public final Builder setRightButtonAndClickListener(String r2, View.OnClickListener r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.rightButtonText = r2;
            this.rightButtonListener = r3;
            this.rightButtonBgColorResId = r4;
            this.rightAction = null;
            return this;
        }

        public final OToastModal build() {
            OToastModal r7 = new OToastModal(this.context, this.msg, this.position, this.includeCutoutInLandscape, this.style, null);
            r7.setDuration(OToastModal.access$getDuration$p(r7));
            Integer r0 = this.leftDrawableRes;
            if (r0 == null) goto L6;
            r7.setLeftDrawable(Integer.valueOf(r0.intValue()));
        L6:
            Drawable r1 = this.leftDrawable;
            if (r1 == null) goto L10;
            r7.setLeftDrawable(r1);
        L10:
            Integer r2 = this.startDrawableRes;
            if (r2 == null) goto L14;
            r7.setStartDrawable(Integer.valueOf(r2.intValue()));
        L14:
            Drawable r3 = this.startDrawable;
            if (r3 == null) goto L19;
            r7.setStartDrawable(r3);
        L19:
            if (this.enableProgressbar == false) goto L21;
            r7.enableProgressbar();
        L21:
            View r4 = r7.getRightAction();
            if (r4 == null) goto L25;
            r7.setRightAction(r4);
        L25:
            String r5 = this.rightButtonText;
            if (r5 == null) goto L29;
            r7.setRightButtonAndClickListener(r5, this.rightButtonListener, this.rightButtonBgColorResId);
        L29:
            return r7;
        }

        public static /* synthetic */ OToastModal show$default(Builder r0, Object r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            return r0.show(r1);
        }

        public final OToastModal show(Object r2) {
            OToastModal r1 = build();
            if ((r2 instanceof Activity) == false) goto L6;
            r1.showInActivity((Activity) r2);
        L14:
            return r1;
        L6:
            if ((r2 instanceof Dialog) == false) goto L9;
            r1.showInDialog((Dialog) r2);
            goto L14
        L9:
            if ((r2 instanceof PopupWindow) == false) goto L12;
            r1.showInPopupWindow((PopupWindow) r2);
            goto L14
        L12:
            if ((r2 instanceof ViewGroup) == false) goto L14;
            r1.show((ViewGroup) r2);
            goto L14
        }
    }

    /* JADX INFO: compiled from: OToastModal.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/toast/OToastModal$Companion;", "", "()V", "FORCE_REMOVE_DELAY_MS", "", "TAG", "", "builder", "Lcom/obric/oui/toast/OToastModal$Builder;", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "resolveLayoutResId", "", "style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ int access$resolveLayoutResId(Companion r0, int r1) {
            return r0.resolveLayoutResId(r1);
        }

        @JvmStatic
        public final Builder builder(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            return new Builder(r1, r2);
        }

        private final int resolveLayoutResId(int r1) {
            if (r1 == 0) goto L8;
            if (r1 == 2) goto L10;
            return R.layout.o_toast_light;
        L10:
            return R.layout.o_toast_dark;
        L8:
            return R.layout.o_toast;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Dgo2BK5PdJBK-O2qG4ldjsFcVcs, reason: not valid java name */
    public static /* synthetic */ void m579$r8$lambda$Dgo2BK5PdJBKO2qG4ldjsFcVcs(OToastModal r0) {
        m580dismissRunnable$lambda0(r0);
    }

    public static /* synthetic */ void $r8$lambda$KAXJ8_eWwaSUw0RsotXkrH12roQ(OToastModal r0) {
        m582forceRemoveRunnable$lambda1(r0);
    }

    public static /* synthetic */ void $r8$lambda$VW17871o7_RFGxSWNUNd_eXPktY(OToastModal r0) {
        m581dismissWithAnimation$lambda8(r0);
    }

    public static /* synthetic */ void $r8$lambda$ZQjcuzLQ0tllFekSN3fsA5VnviA(PopupWindow r0, OToastModal r1, View r2) {
        m583showInPopupWindow$lambda5(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ OToastModal(Context r1, String r2, int r3, Boolean r4, int r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    @JvmStatic
    public static final Builder builder(Context r1, String r2) {
        return Companion.builder(r1, r2);
    }

    private OToastModal(Context r1, String r2, int r3, Boolean r4, int r5) {
        this.context = r1;
        this.msg = r2;
        this.position = r3;
        this.includeCutoutInLandscape = r4;
        this.style = r5;
        int r6 = OUnitExtensionKt.cdp(r1, 73);
        this.verticalWidthSpace = r6;
        this.drawableReservedWidth = OUnitExtensionKt.cdp(r1, 28);
        if (ResourceUtils.INSTANCE.isLandscape(r1) == true) goto L5;
        int r7 = OUnitExtensionKt.getScreenWidth(r1) - r6;
    L6:
        this.baseMsgMaxWidth = r7;
        this.msgMaxWidth = r7;
        this.duration = 2000;
        this.handler = new Handler(Looper.getMainLooper());
        this.dismissRunnable = new OToastModal$$ExternalSyntheticLambda2(this);
        this.forceRemoveRunnable = new OToastModal$$ExternalSyntheticLambda3(this);
        LayoutInflater r8 = LayoutInflater.from(r1);
        int r9 = Companion.access$resolveLayoutResId(Companion, this.style);
        TextView r10 = null;
        View r11 = r8.inflate(r9, null);
        Intrinsics.checkNotNullExpressionValue(r11, "from(context)\n        .i…LayoutResId(style), null)");
        this.contentView = r11;
        if (this.position == 80) goto L9;
        this.position = 80;
        L.w(TAG, "自定义位置不支持，已强制改为底部");
    L9:
        View r12 = this.contentView.findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r12, "contentView.findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) r12;
        View r13 = this.contentView.findViewById(R.id.toast_progress);
        Intrinsics.checkNotNullExpressionValue(r13, "contentView.findViewById(R.id.toast_progress)");
        this.toastProgress = (ODownloadProgressView) r13;
        View r14 = this.contentView.findViewById(R.id.tv_msg);
        Intrinsics.checkNotNullExpressionValue(r14, "contentView.findViewById(R.id.tv_msg)");
        TextView r15 = (TextView) r14;
        this.tvMsg = r15;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tvMsg");
    L13:
        r10.setText(r2);
        View r16 = this.contentView.findViewById(R.id.right_button);
        Intrinsics.checkNotNullExpressionValue(r16, "contentView.findViewById(R.id.right_button)");
        this.button = (OButton) r16;
        recalculateMsgMaxWidth();
        return;
    L12:
        r10 = r15;
        goto L13
    L5:
        r7 = OUnitExtensionKt.cdp(r1, OToastConstants.MSG_MAX_WIDTH_DP);
        goto L6
    }

    /* synthetic */ OToastModal(Context r7, String r8, int r9, Boolean r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = 80;
    L5:
        int r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = null;
    L8:
        Boolean r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = 0;
    L11:
        this(r7, r8, r3, r4, r11);
    }

    public static final /* synthetic */ int access$getDuration$p(OToastModal r0) {
        return r0.duration;
    }

    public static final /* synthetic */ void access$removeHostView(OToastModal r0) {
        r0.removeHostView();
    }

    public final View getRightAction() {
        return this.rightAction;
    }

    /* JADX INFO: renamed from: setRightAction, reason: collision with other method in class */
    public final void m584setRightAction(View r1) {
        this.rightAction = r1;
    }

    /* JADX INFO: renamed from: dismissRunnable$lambda-0, reason: not valid java name */
    private static final void m580dismissRunnable$lambda0(OToastModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.dismissWithAnimation();
    }

    /* JADX INFO: renamed from: forceRemoveRunnable$lambda-1, reason: not valid java name */
    private static final void m582forceRemoveRunnable$lambda1(OToastModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.removeHostView();
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

    public final void setButton(OButton r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.button = r2;
    }

    public final void enableProgressbar() {
        ODownloadProgressView r0 = this.toastProgress;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("toastProgress");
        r0 = null;
    L5:
        ViewExtensionsKt.makeVisible(r0);
        ImageView r2 = this.ivIcon;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
    L9:
        ViewExtensionsKt.makeGone(r1);
        recalculateMsgMaxWidth();
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final OToastModal setLeftDrawable(Integer r4) {
        if (r4 == null) goto L12;
        r4.intValue();
        ImageView r0 = this.ivIcon;
        ImageView r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        r0 = null;
    L7:
        r0.setImageResource(r4.intValue());
        ImageView r5 = this.ivIcon;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
    L11:
        ViewExtensionsKt.makeVisible(r1);
        recalculateMsgMaxWidth();
        goto L12
    L10:
        r1 = r5;
    L12:
        return this;
    }

    public final OToastModal setLeftDrawable(Drawable r4) {
        if (r4 == null) goto L12;
        ImageView r0 = this.ivIcon;
        ImageView r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        r0 = null;
    L7:
        r0.setImageDrawable(r4);
        ImageView r5 = this.ivIcon;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
    L11:
        ViewExtensionsKt.makeVisible(r1);
        recalculateMsgMaxWidth();
        goto L12
    L10:
        r1 = r5;
    L12:
        return this;
    }

    public final OToastModal setStartDrawable(Integer r4) {
        ImageView r0 = null;
        if (r4 == null) goto L12;
        ImageView r2 = this.ivIcon;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        r2 = null;
    L7:
        r2.setImageResource(r4.intValue());
        ImageView r5 = this.ivIcon;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
    L11:
        ViewExtensionsKt.makeVisible(r0);
    L17:
        recalculateMsgMaxWidth();
        return this;
    L10:
        r0 = r5;
        goto L11
    L12:
        ImageView r6 = this.ivIcon;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
    L16:
        ViewExtensionsKt.makeGone(r0);
        goto L17
    L15:
        r0 = r6;
        goto L16
    }

    public final OToastModal setStartDrawable(Drawable r4) {
        ImageView r0 = null;
        if (r4 == null) goto L12;
        ImageView r2 = this.ivIcon;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        r2 = null;
    L7:
        r2.setImageDrawable(r4);
        ImageView r5 = this.ivIcon;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
    L11:
        ViewExtensionsKt.makeVisible(r0);
    L17:
        recalculateMsgMaxWidth();
        return this;
    L10:
        r0 = r5;
        goto L11
    L12:
        ImageView r6 = this.ivIcon;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
    L16:
        ViewExtensionsKt.makeGone(r0);
        goto L17
    L15:
        r0 = r6;
        goto L16
    }

    public final OToastModal setDuration(int r1) {
        this.duration = r1;
        return this;
    }

    public final OToastModal setIncludeCutoutInLandscape(Boolean r1) {
        this.includeCutoutInLandscape = r1;
        return this;
    }

    public final void cancel() {
        removeHostView();
    }

    public final OToastModal setPos(Integer r2) {
        L.w(TAG, "设置位置不支持");
        return this;
    }

    public final OToastModal setRightAction(View r1) {
        this.rightAction = r1;
        return this;
    }

    public static /* synthetic */ OToastModal setRightButtonAndClickListener$default(OToastModal r0, String r1, View.OnClickListener r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = R.color.oui_toast_button_background;
    L6:
        return r0.setRightButtonAndClickListener(r1, r2, r3);
    }

    public final OToastModal setRightButtonAndClickListener(String r3, View.OnClickListener r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "string");
        int r6 = this.msgMaxWidth;
        TextView r0 = this.tvMsg;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvMsg");
        r0 = null;
    L5:
        this.msgMaxWidth = r6 - OUnitExtensionKt.vdp(r0, 52);
        ViewExtensionsKt.makeVisible(this.button);
        this.button.setText(r3);
        this.button.setOnClickListener(r4);
        return this;
    }

    public static /* synthetic */ void show$default(OToastModal r0, ViewGroup r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.show(r1);
    }

    public final void show(ViewGroup r1) {
        showInternal(r1);
    }

    public final void showInActivity(Activity r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isFinishing() == false) goto L6;
        return;
    L6:
        if (r3.isDestroyed() == true) goto L19;
        Window r4 = r3.getWindow();
        ViewGroup r0 = null;
        if (r4 != null) goto L11;
        View r5 = null;
    L13:
        if ((r5 instanceof ViewGroup) == false) goto L15;
        r0 = (ViewGroup) r5;
    L15:
        show(r0);
        return;
    L11:
        r5 = r4.getDecorView();
        goto L13
    }

    public final void showInDialog(Dialog r4) {
        boolean r0 = false;
        if (r4 != null) goto L6;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        Window r5 = r4.getWindow();
        ViewGroup r1 = null;
        if (r5 != null) goto L13;
        View r6 = null;
    L15:
        if ((r6 instanceof ViewGroup) == false) goto L17;
        r1 = (ViewGroup) r6;
    L17:
        show(r1);
        return;
    L13:
        r6 = r5.getDecorView();
        goto L15
    L6:
        if (r4.isShowing() != true) goto L8;
        r0 = true;
        goto L8
    }

    public final void showInPopupWindow(final PopupWindow r4) {
        boolean r0 = false;
        if (r4 != null) goto L6;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        final View r1 = r4.getContentView();
        if (r1 != null) goto L13;
        return;
    L13:
        ViewGroup r2 = findPopupWindowAttachParent(r1);
        if (r2 == null) goto L17;
        showInternal(r2);
        return;
    L17:
        r1.post(new OToastModal$$ExternalSyntheticLambda0(r4, this, r1));
        return;
    L6:
        if (r4.isShowing() != true) goto L8;
        r0 = true;
        goto L8
    }

    /* JADX INFO: renamed from: showInPopupWindow$lambda-5, reason: not valid java name */
    private static final void m583showInPopupWindow$lambda5(PopupWindow r1, OToastModal r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$contentView");
        if (r1.isShowing() == false) goto L9;
        ViewGroup r4 = r2.findPopupWindowAttachParent(r3);
        if (r4 == null) goto L10;
        r2.showInternal(r4);
        return;
    L10:
        return;
    }

    private final void showInternal(ViewGroup r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isAttachedToWindow() == false) goto L39;
        int r0 = OUnitExtensionKt.cdp(this.context, 96);
        View r1 = this.rightAction;
        View r2 = null;
        if (r1 == null) goto L19;
        ViewParent r3 = r1.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L12;
        ViewGroup r4 = (ViewGroup) r3;
    L13:
        if (r4 == null) goto L16;
        r4.removeView(r1);
    L16:
        LinearLayout r5 = (LinearLayout) getContentView().findViewById(R.id.toast_root);
        if (r1.getParent() == r5) goto L19;
        r5.addView(r1);
        goto L19
    L12:
        r4 = null;
    L19:
        removeHostView();
        registerHostParent(r6);
        ((TextView) this.contentView.findViewById(R.id.tv_msg)).setMaxWidth(this.msgMaxWidth);
        this.contentView.measure(0, 0);
        View r7 = wrapWithShadowFrame(this.contentView, r0);
        this.hostView = r7;
        this.isDismissing = false;
        ViewParent r8 = r7.getParent();
        if ((r8 instanceof ViewGroup) == false) goto L22;
        ViewGroup r9 = (ViewGroup) r8;
    L23:
        if (r9 == null) goto L26;
        r9.removeView(r7);
    L26:
        KtExt r10 = KtExt.INSTANCE;
        View r11 = this.contentView;
        if (r11 != null) goto L30;
    L32:
        ToastBackgroundView r12 = (ToastBackgroundView) r2;
        if (r12 == null) goto L36;
        r12.setupBackground(r11.getMeasuredHeight(), false, r6);
    L36:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 81;
        Unit r14 = Unit.INSTANCE;
        r6.addView(r7, r13);
        r7.bringToFront();
        r7.setAlpha(0.0f);
        r7.setTranslationY(OUnitExtensionKt.vdp(r7, 8));
        r7.animate().alpha(1.0f).translationY(0.0f).setDuration(160).start();
        this.handler.removeCallbacks(this.dismissRunnable);
        this.handler.postDelayed(this.dismissRunnable, this.duration);
        return;
    L30:
        if ((r11 instanceof ToastBackgroundView) == false) goto L32;
        r2 = r11;
        goto L32
    L22:
        r9 = null;
        goto L23
    }

    private final void dismissWithAnimation() {
        View r0 = this.hostView;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.isDismissing == false) goto L8;
        return;
    L8:
        this.isDismissing = true;
        if (r0.isAttachedToWindow() == true) goto L12;
        removeHostView();
        return;
    L12:
        r0.animate().alpha(0.0f).translationY(OUnitExtensionKt.vdp(r0, 8)).setDuration(120).withEndAction(new OToastModal$$ExternalSyntheticLambda1(this)).start();
        this.handler.removeCallbacks(this.forceRemoveRunnable);
        this.handler.postDelayed(this.forceRemoveRunnable, 200);
    }

    /* JADX INFO: renamed from: dismissWithAnimation$lambda-8, reason: not valid java name */
    private static final void m581dismissWithAnimation$lambda8(OToastModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.removeHostView();
    }

    private final void removeHostView() {
        this.handler.removeCallbacks(this.dismissRunnable);
        this.handler.removeCallbacks(this.forceRemoveRunnable);
        unregisterHostParent();
        View r0 = this.hostView;
        if (r0 == null) goto L12;
        r0.animate().cancel();
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L8;
        ViewGroup r3 = (ViewGroup) r2;
    L9:
        if (r3 == null) goto L12;
        r3.removeView(r0);
        goto L12
    L8:
        r3 = null;
    L12:
        this.hostView = null;
        this.isDismissing = false;
    }

    private final void registerHostParent(ViewGroup r2) {
        unregisterHostParent();
        this.hostParent = r2;
        View.OnAttachStateChangeListener r0 = new AnonymousClass1(this);
        r2.addOnAttachStateChangeListener(r0);
        this.hostAttachListener = r0;
    }

    private final void unregisterHostParent() {
        View.OnAttachStateChangeListener r0 = this.hostAttachListener;
        if (r0 == null) goto L9;
        ViewGroup r1 = this.hostParent;
        if (r1 == null) goto L9;
        r1.removeOnAttachStateChangeListener(r0);
    L9:
        this.hostAttachListener = null;
        this.hostParent = null;
    }

    private final ViewGroup findPopupWindowParent(View r5) {
        View r4 = r5.getRootView();
        if ((r4 instanceof ViewGroup) == false) goto L5;
        ViewGroup r6 = (ViewGroup) r4;
    L6:
        boolean r0 = false;
        if (r6 != null) goto L10;
    L12:
        if (r0 == false) goto L15;
        return r6;
    L15:
        if ((r5 instanceof ViewGroup) == false) goto L19;
        ViewGroup r7 = (ViewGroup) r5;
        if (r7.isAttachedToWindow() == false) goto L19;
        return r7;
    L19:
        ViewParent r8 = r5.getParent();
    L21:
        if ((r8 instanceof View) == false) goto L28;
        if ((r8 instanceof ViewGroup) == false) goto L27;
        ViewGroup r9 = (ViewGroup) r8;
        if (r9.isAttachedToWindow() == false) goto L27;
        return r9;
    L27:
        r8 = r8.getParent();
        goto L21
    L28:
        return null;
    L10:
        if (r6.isAttachedToWindow() != true) goto L12;
        r0 = true;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    private final ViewGroup findPopupWindowAttachParent(View r3) {
        if (r3.isAttachedToWindow() == true) goto L5;
        return null;
    L5:
        ViewParent r2 = r3.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L8;
        ViewGroup r4 = (ViewGroup) r2;
    L9:
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.isAttachedToWindow() == false) goto L14;
        return r4;
    L14:
        ViewParent r5 = r4.getParent();
    L16:
        if ((r5 instanceof View) == false) goto L23;
        if ((r5 instanceof ViewGroup) == false) goto L22;
        ViewGroup r6 = (ViewGroup) r5;
        if (r6.isAttachedToWindow() == false) goto L22;
        return r6;
    L22:
        r5 = r5.getParent();
        goto L16
    L23:
        return null;
    L8:
        r4 = null;
        goto L9
    }

    private final void recalculateMsgMaxWidth() {
        ImageView r0 = this.ivIcon;
        TextView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        r0 = null;
    L6:
        if (ViewExtensionsKt.isGone(r0) == false) goto L14;
        ODownloadProgressView r2 = this.toastProgress;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("toastProgress");
        r2 = null;
    L11:
        if (ViewExtensionsKt.isGone(r2) == false) goto L14;
        boolean r3 = false;
    L15:
        if (r3 == false) goto L17;
        int r4 = this.baseMsgMaxWidth - this.drawableReservedWidth;
    L18:
        this.msgMaxWidth = r4;
        TextView r5 = this.tvMsg;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("tvMsg");
    L22:
        r1.setMaxWidth(this.msgMaxWidth);
        return;
    L21:
        r1 = r5;
        goto L22
    L17:
        r4 = this.baseMsgMaxWidth;
    L14:
        r3 = true;
        goto L15
    }

    private final View wrapWithShadowFrame(View r12, int r13) {
        KtExt r0 = KtExt.INSTANCE;
        if (r12 != null) goto L6;
    L4:
        View r1 = null;
    L8:
        ToastBackgroundView r2 = (ToastBackgroundView) r1;
        if (r2 != null) goto L11;
        int r3 = 24;
    L12:
        View r4 = LayoutInflater.from(this.context).inflate(R.layout.o_layout_popover_shadow_frame, null);
        if (r4 == null) goto L32;
        SingleChildFrameLayout r5 = (SingleChildFrameLayout) r4;
        r5.addView(r12, new FrameLayout.LayoutParams(-2, -2));
        r5.setShadowCornerRadius(r3);
        List<Shadow> r14 = OUILayoutHelper.extractShadowInfo(this.context, R.style.OUIShadow_3);
        Intrinsics.checkNotNullExpressionValue(r14, MaterialConfigFormatNames.SHADOWS);
        Iterator<T> r15 = r14.iterator();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L16:
        if (r15.hasNext() == false) goto L29;
        Shadow r10 = (Shadow) r15.next();
        if ((r10.getRadius() - r10.getOffsetX()) <= r6) goto L21;
        r6 = MathKt.roundToInt(r10.getRadius() - r10.getOffsetX());
    L21:
        if ((r10.getRadius() + r10.getOffsetX()) <= r8) goto L24;
        r8 = MathKt.roundToInt(r10.getRadius() + r10.getOffsetX());
    L24:
        if ((r10.getRadius() - r10.getOffsetY()) <= r7) goto L27;
        r7 = MathKt.roundToInt(r10.getRadius() - r10.getOffsetY());
    L27:
        if ((r10.getRadius() + r10.getOffsetY()) <= r9) goto L16;
        r9 = MathKt.roundToInt(r10.getRadius() + r10.getOffsetY());
        goto L16
    L29:
        SingleChildFrameLayout r16 = new SingleChildFrameLayout(this.context, null, 2, null);
        r16.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 1;
        Unit r17 = Unit.INSTANCE;
        r16.addView(r5, r11);
        r16.setClipChildren(false);
        r16.setClipToPadding(false);
        r16.setPadding(r6, r7, r8, r13 + r9);
        return r16;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    L11:
        r3 = r2.getCornerRadius();
        goto L12
    L6:
        if ((r12 instanceof ToastBackgroundView) == false) goto L4;
        r1 = r12;
        goto L8
    }
}
