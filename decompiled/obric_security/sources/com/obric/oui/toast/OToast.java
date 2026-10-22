package com.obric.oui.toast;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OToast.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0003@ABBA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\b\u0010(\u001a\u00020&H\u0002J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0007J\u0015\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u000100J\u0015\u0010.\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00102J\u0010\u0010!\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0015J\"\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u0001092\b\b\u0002\u0010:\u001a\u00020\u0007J\u0010\u0010;\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u000100J\u0015\u0010;\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00102J\u0010\u0010<\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u0006\u0010?\u001a\u00020&R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/oui/toast/OToast;", "", "mContext", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "", "position", "", "forceUseAddViewToast", "", "includeCutoutInLandscape", "style", "(Landroid/content/Context;Ljava/lang/String;IZLjava/lang/Boolean;I)V", "baseMsgMaxWidth", "button", "Lcom/obric/oui/button/OButton;", "getButton", "()Lcom/obric/oui/button/OButton;", "setButton", "(Lcom/obric/oui/button/OButton;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "drawableReservedWidth", "Ljava/lang/Boolean;", "mTN", "Lcom/obric/oui/toast/OToast$TN;", "msgMaxWidth", "rightAction", "getRightAction", "setRightAction", "systemToast", "Landroid/widget/Toast;", "verticalWidthSpace", "cancel", "", "enableProgressbar", "recalculateMsgMaxWidth", "setDuration", "duration", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/toast/OToast;", "setLeftDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "res", "(Ljava/lang/Integer;)Lcom/obric/oui/toast/OToast;", "setPos", "pos", "action", "setRightButtonAndClickListener", "string", "listener", "Landroid/view/View$OnClickListener;", "bgColorResId", "setStartDrawable", "setWindowToken", "token", "Landroid/os/IBinder;", InvokeHistoryActivity.PREF_SHOW, "Companion", "OutlineProvider", "TN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OToast {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private static WeakReference<OToast> toastRef;
    private final int baseMsgMaxWidth;
    private OButton button;
    private View contentView;
    private final int drawableReservedWidth;
    private final boolean forceUseAddViewToast;
    private Boolean includeCutoutInLandscape;
    private final Context mContext;
    private final TN mTN;
    private final String msg;
    private int msgMaxWidth;
    private int position;
    private View rightAction;
    private int style;
    private Toast systemToast;
    private final int verticalWidthSpace;

    /* JADX INFO: compiled from: OToast.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u0017JC\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u0018J;\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u001aJ*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ<\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ2\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u001bJC\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u001cJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ2\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ9\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u001dJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u000fH\u0007JM\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001fJ;\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/toast/OToast$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "toastRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/toast/OToast;", InvokeHistoryActivity.PREF_SHOW, "", "context", "Landroid/app/Activity;", "style", "", NotificationCompat.CATEGORY_MESSAGE, "includeCutoutInLandscape", "", "drawable", "rightAction", "Landroid/view/View;", "pos", "(Landroid/app/Activity;ILjava/lang/String;Ljava/lang/Boolean;ILandroid/view/View;I)V", "(Landroid/app/Activity;ILjava/lang/String;ILjava/lang/Boolean;I)V", "Landroid/content/Context;", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/Boolean;I)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;I)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;ILandroid/view/View;I)V", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Boolean;I)V", "showIconToast", "(Landroid/content/Context;Ljava/lang/String;ILandroid/view/View;ILjava/lang/Boolean;I)V", "showTextToast", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final void show(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
        }

        private Companion() {
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

        public static /* synthetic */ void show$default(Companion r0, Context r1, String r2, int r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = 80;
        L5:
            r0.show(r1, r2, r3);
        }

        public final void show(Context r10, String r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            showTextToast$default(this, r10, r11, r12, null, 0, 24, null);
        }

        public static /* synthetic */ void show$default(Companion r0, Context r1, String r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L5;
            r4 = 80;
        L5:
            r0.show(r1, r2, r3, r4);
        }

        public final void show(Context r12, String r13, int r14, int r15) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast$default(this, r12, r13, r14, null, r15, null, 0, 96, null);
        }

        public static /* synthetic */ void show$default(Companion r6, Context r7, String r8, int r9, View r10, int r11, int r12, Object r13) {
            if ((r12 & 16) == 0) goto L5;
            r11 = 80;
        L5:
            r6.show(r7, r8, r9, r10, r11);
        }

        public final void show(Context r12, String r13, int r14, View r15, int r16) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast$default(this, r12, r13, r14, r15, r16, null, 0, 96, null);
        }

        public static /* synthetic */ void show$default(Companion r0, Context r1, String r2, Boolean r3, int r4, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 8) == 0) goto L8;
            r4 = 80;
        L8:
            r0.show(r1, r2, r3, r4);
        }

        public final void show(Context r10, String r11, Boolean r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            showTextToast$default(this, r10, r11, r13, r12, 0, 16, null);
        }

        public static /* synthetic */ void show$default(Companion r6, Context r7, String r8, int r9, Boolean r10, int r11, int r12, Object r13) {
            if ((r12 & 8) == 0) goto L5;
            r10 = null;
        L5:
            Boolean r4 = r10;
            if ((r12 & 16) == 0) goto L8;
            r11 = 80;
        L8:
            r6.show(r7, r8, r9, r4, r11);
        }

        public final void show(Context r12, String r13, int r14, Boolean r15, int r16) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast$default(this, r12, r13, r14, null, r16, r15, 0, 64, null);
        }

        public static /* synthetic */ void show$default(Companion r7, Context r8, String r9, Boolean r10, int r11, View r12, int r13, int r14, Object r15) {
            if ((r14 & 4) == 0) goto L5;
            r10 = null;
        L5:
            Boolean r3 = r10;
            if ((r14 & 32) == 0) goto L8;
            r13 = 80;
        L8:
            r7.show(r8, r9, r3, r11, r12, r13);
        }

        public final void show(Context r12, String r13, Boolean r14, int r15, View r16, int r17) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast$default(this, r12, r13, r15, r16, r17, r14, 0, 64, null);
        }

        public static /* synthetic */ void show$default(Companion r0, Context r1, int r2, String r3, int r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 8) == 0) goto L8;
            r4 = 80;
        L8:
            r0.show(r1, r2, r3, r4);
        }

        public final void show(Context r10, int r11, String r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
            showTextToast$default(this, r10, r12, r13, null, r11, 8, null);
        }

        public static /* synthetic */ void show$default(Companion r6, Context r7, int r8, String r9, int r10, int r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L5;
            r8 = 0;
        L5:
            int r2 = r8;
            if ((r12 & 16) == 0) goto L8;
            r11 = 80;
        L8:
            r6.show(r7, r2, r9, r10, r11);
        }

        public final void show(Context r12, int r13, String r14, int r15, int r16) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r14, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast$default(this, r12, r14, r15, null, r16, null, r13, 32, null);
        }

        public static /* synthetic */ void show$default(Companion r7, Context r8, int r9, String r10, int r11, View r12, int r13, int r14, Object r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = 0;
        L5:
            int r2 = r9;
            if ((r14 & 32) == 0) goto L8;
            r13 = 80;
        L8:
            r7.show(r8, r2, r10, r11, r12, r13);
        }

        public final void show(Context r12, int r13, String r14, int r15, View r16, int r17) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r14, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast$default(this, r12, r14, r15, r16, r17, null, r13, 32, null);
        }

        public static /* synthetic */ void show$default(Companion r6, Context r7, int r8, String r9, Boolean r10, int r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L5;
            r8 = 0;
        L5:
            int r2 = r8;
            if ((r12 & 8) == 0) goto L8;
            r10 = null;
        L8:
            Boolean r4 = r10;
            if ((r12 & 16) == 0) goto L11;
            r11 = 80;
        L11:
            r6.show(r7, r2, r9, r4, r11);
        }

        public final void show(Context r7, int r8, String r9, Boolean r10, int r11) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
            showTextToast(r7, r9, r11, r10, r8);
        }

        public static /* synthetic */ void show$default(Companion r7, Activity r8, int r9, String r10, int r11, Boolean r12, int r13, int r14, Object r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = 0;
        L5:
            int r2 = r9;
            if ((r14 & 16) == 0) goto L8;
            r12 = null;
        L8:
            Boolean r5 = r12;
            if ((r14 & 32) == 0) goto L11;
            r13 = 80;
        L11:
            r7.show(r8, r2, r10, r11, r5, r13);
        }

        public final void show(Activity r10, int r11, String r12, int r13, Boolean r14, int r15) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast(r10, r12, r13, null, r15, r14, r11);
        }

        public static /* synthetic */ void show$default(Companion r9, Activity r10, int r11, String r12, Boolean r13, int r14, View r15, int r16, int r17, Object r18) {
            if ((r17 & 2) == 0) goto L5;
            int r3 = 0;
        L7:
            if ((r17 & 8) == 0) goto L9;
            Boolean r5 = null;
        L11:
            if ((r17 & 64) == 0) goto L13;
            int r8 = 80;
        L14:
            r9.show(r10, r3, r12, r5, r14, r15, r8);
            return;
        L13:
            r8 = r16;
            goto L14
        L9:
            r5 = r13;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }

        public final void show(Activity r11, int r12, String r13, Boolean r14, int r15, View r16, int r17) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_MESSAGE);
            showIconToast(r11, r13, r15, r16, r17, r14, r12);
        }

        static /* synthetic */ void showTextToast$default(Companion r6, Context r7, String r8, int r9, Boolean r10, int r11, int r12, Object r13) {
            if ((r12 & 8) == 0) goto L5;
            r10 = null;
        L5:
            Boolean r4 = r10;
            if ((r12 & 16) == 0) goto L8;
            r11 = 0;
        L8:
            r6.showTextToast(r7, r8, r9, r4, r11);
        }

        private final void showTextToast(Context r10, String r11, int r12, Boolean r13, int r14) {
            OToast r9 = (OToast) OToast.access$getToastRef$cp().get();
            if (r9 == null) goto L6;
            r9.cancel();
        L6:
            OToast r15 = new OToast(r10, r11, r12, false, r13, r14, 8, null);
            Companion r16 = OToast.Companion;
            OToast.access$setToastRef$cp(new WeakReference(r15));
            r15.show();
        }

        static /* synthetic */ void showIconToast$default(Companion r9, Context r10, String r11, int r12, View r13, int r14, Boolean r15, int r16, int r17, Object r18) {
            if ((r17 & 32) == 0) goto L5;
            Boolean r7 = null;
        L7:
            if ((r17 & 64) == 0) goto L9;
            int r8 = 0;
        L10:
            r9.showIconToast(r10, r11, r12, r13, r14, r7, r8);
            return;
        L9:
            r8 = r16;
            goto L10
        L5:
            r7 = r15;
            goto L7
        }

        private final void showIconToast(Context r12, String r13, int r14, View r15, int r16, Boolean r17, int r18) {
            OToast r10 = new OToast(r12, r13, r16, false, r17, r18, 8, null);
            r10.setLeftDrawable(Integer.valueOf(r14));
            if (r15 == null) goto L6;
            r10.setRightAction(r15);
        L6:
            r10.show();
        }
    }

    /* JADX INFO: compiled from: OToast.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0014\u0010\u0004\u001a\u00020\u0015*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0014\u0010\u0006\u001a\u00020\u0015*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/toast/OToast$OutlineProvider;", "Landroid/view/ViewOutlineProvider;", "yShift", "", "scaleX", "", "scaleY", "(Lcom/obric/oui/toast/OToast;IFF)V", "rect", "Landroid/graphics/Rect;", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getYShift", "()I", "setYShift", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "scale", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect;
        private float scaleX;
        private float scaleY;
        final /* synthetic */ OToast this$0;
        private int yShift;

        public OutlineProvider(OToast r2, int r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.yShift = r3;
            this.scaleX = r4;
            this.scaleY = r5;
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
            if (r3 == null) goto L8;
            Drawable r5 = r3.getBackground();
            if (r5 == null) goto L8;
            r5.copyBounds(this.rect);
        L8:
            scaleX(this.rect, this.scaleX);
            scaleY(this.rect, this.scaleY);
            this.rect.offset(0, this.yShift);
            if (r4 == null) goto L13;
            r4.setRoundRect(this.rect, OToast.access$getMContext$p(this.this$0).getResources().getDimension(R.dimen.oui_r_l1));
            return;
        }

        private final void scaleX(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.left = (int) ((r2.left * r3) + 0.5f);
            r2.right = (int) ((r2.right * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }

        private final void scaleY(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.top = (int) ((r2.top * r3) + 0.5f);
            r2.bottom = (int) ((r2.bottom * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: OToast.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u00020DH\u0002J\u0010\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020DH\u0002J\u0006\u0010J\u001a\u00020DJ\u0006\u0010K\u001a\u00020DJ\"\u0010L\u001a\u00020$2\b\u0010M\u001a\u0004\u0018\u00010\u000b2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020\u0011H\u0003R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001c\u0010.\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\u001a\u0010@\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0013\"\u0004\bB\u0010\u0015¨\u0006Q"}, d2 = {"Lcom/obric/oui/toast/OToast$TN;", "", "()V", "includeCutoutInLandscape", "", "getIncludeCutoutInLandscape", "()Ljava/lang/Boolean;", "setIncludeCutoutInLandscape", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mDuration", "", "getMDuration", "()I", "setMDuration", "(I)V", "mGravity", "getMGravity", "setMGravity", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHorizontalMargin", "", "getMHorizontalMargin", "()F", "setMHorizontalMargin", "(F)V", "mNextView", "Landroid/view/View;", "getMNextView", "()Landroid/view/View;", "setMNextView", "(Landroid/view/View;)V", "mParams", "Landroid/view/WindowManager$LayoutParams;", "mVerticalMargin", "getMVerticalMargin", "setMVerticalMargin", "mView", "getMView", "setMView", "mWM", "Landroid/view/WindowManager;", "getMWM", "()Landroid/view/WindowManager;", "setMWM", "(Landroid/view/WindowManager;)V", "mWindowToken", "Landroid/os/IBinder;", "getMWindowToken", "()Landroid/os/IBinder;", "setMWindowToken", "(Landroid/os/IBinder;)V", "mX", "getMX", "setMX", "mY", "getMY", "setMY", "clearPendingMessages", "", "handleHide", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "handleShow", "hide", InvokeHistoryActivity.PREF_SHOW, "wrapWithShadowFrame", "context", "view", "yOffset", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class TN {
        public static final Companion Companion = null;
        private static final int MSG_HIDE = 0;
        private static final int MSG_SHOW = 0;
        private Boolean includeCutoutInLandscape;
        private Context mContext;
        private int mDuration;
        private int mGravity;
        private final Handler mHandler;
        private float mHorizontalMargin;
        private View mNextView;
        private final WindowManager.LayoutParams mParams;
        private float mVerticalMargin;
        private View mView;
        private WindowManager mWM;
        private IBinder mWindowToken;
        private int mX;
        private int mY;

        /* JADX INFO: compiled from: OToast.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/toast/OToast$TN$Companion;", "", "()V", "MSG_HIDE", "", "MSG_SHOW", "getResId", "type", "", "name", "ToastHandler", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {

            /* JADX INFO: compiled from: OToast.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/toast/OToast$TN$Companion$ToastHandler;", "Landroid/os/Handler;", "tn", "Lcom/obric/oui/toast/OToast$TN;", "(Lcom/obric/oui/toast/OToast$TN;)V", "tnRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            private static final class ToastHandler extends Handler {
                private final WeakReference<TN> tnRef;

                public ToastHandler(TN r2) {
                    Intrinsics.checkNotNullParameter(r2, "tn");
                    super(Looper.getMainLooper());
                    this.tnRef = new WeakReference(r2);
                }

                @Override // android.os.Handler
                public void handleMessage(Message r2) {
                    Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
                    TN r1 = this.tnRef.get();
                    if (r1 == null) goto L7;
                    TN.access$handleMessage(r1, r2);
                    return;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final int getResId(String r1, String r2) {
                Intrinsics.checkNotNullParameter(r1, "type");
                return Class.forName(Intrinsics.stringPlus("com.android.internal.R$", r1)).getField(r2).getInt(null);
            L5:
                e = move-exception;
                e.printStackTrace();
                return 0;
            }
        }

        public TN() {
            WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
            this.mParams = r0;
            this.mHandler = new Companion.ToastHandler(this);
            this.mDuration = 2000;
            r0.height = -2;
            r0.width = -2;
            r0.format = -3;
            r0.windowAnimations = Companion.getResId("style", "Animation_Toast");
            r0.type = 2;
            r0.flags = OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP;
            r0.setTitle("CustomToast");
        }

        public static final /* synthetic */ void access$handleMessage(TN r0, Message r1) {
            r0.handleMessage(r1);
        }

        public final Boolean getIncludeCutoutInLandscape() {
            return this.includeCutoutInLandscape;
        }

        public final void setIncludeCutoutInLandscape(Boolean r1) {
            this.includeCutoutInLandscape = r1;
        }

        public final Handler getMHandler() {
            return this.mHandler;
        }

        public final int getMGravity() {
            return this.mGravity;
        }

        public final void setMGravity(int r1) {
            this.mGravity = r1;
        }

        public final int getMX() {
            return this.mX;
        }

        public final void setMX(int r1) {
            this.mX = r1;
        }

        public final int getMY() {
            return this.mY;
        }

        public final void setMY(int r1) {
            this.mY = r1;
        }

        public final float getMHorizontalMargin() {
            return this.mHorizontalMargin;
        }

        public final void setMHorizontalMargin(float r1) {
            this.mHorizontalMargin = r1;
        }

        public final float getMVerticalMargin() {
            return this.mVerticalMargin;
        }

        public final void setMVerticalMargin(float r1) {
            this.mVerticalMargin = r1;
        }

        public final int getMDuration() {
            return this.mDuration;
        }

        public final void setMDuration(int r1) {
            this.mDuration = r1;
        }

        public final View getMView() {
            return this.mView;
        }

        public final void setMView(View r1) {
            this.mView = r1;
        }

        public final View getMNextView() {
            return this.mNextView;
        }

        public final void setMNextView(View r1) {
            this.mNextView = r1;
        }

        public final Context getMContext() {
            return this.mContext;
        }

        public final void setMContext(Context r1) {
            this.mContext = r1;
        }

        public final IBinder getMWindowToken() {
            return this.mWindowToken;
        }

        public final void setMWindowToken(IBinder r1) {
            this.mWindowToken = r1;
        }

        public final WindowManager getMWM() {
            return this.mWM;
        }

        public final void setMWM(WindowManager r1) {
            this.mWM = r1;
        }

        public final void show() {
            Log.v(OToast.Companion.getTAG(), Intrinsics.stringPlus("SHOW: ", this));
            Handler r0 = this.mHandler;
            int r1 = MSG_SHOW;
            r0.removeMessages(r1);
            Handler r2 = this.mHandler;
            int r3 = MSG_HIDE;
            r2.removeMessages(r3);
            this.mHandler.sendEmptyMessage(r1);
            this.mHandler.sendEmptyMessageDelayed(r3, this.mDuration);
        }

        public final void hide() {
            Log.v(OToast.Companion.getTAG(), Intrinsics.stringPlus("HIDE: ", this));
            this.mHandler.removeMessages(MSG_SHOW);
            Handler r0 = this.mHandler;
            int r1 = MSG_HIDE;
            r0.removeMessages(r1);
            this.mHandler.sendEmptyMessage(r1);
        }

        public final void clearPendingMessages() {
            this.mHandler.removeMessages(MSG_SHOW);
            this.mHandler.removeMessages(MSG_HIDE);
        }

        private final void handleMessage(Message r2) {
            int r3 = r2.what;
            if (r3 != MSG_SHOW) goto L6;
            handleShow();
            return;
        L6:
            if (r3 != MSG_HIDE) goto L10;
            handleHide();
            this.mNextView = null;
            this.mContext = null;
            this.mWM = null;
            this.mWindowToken = null;
            return;
        }

        private final void handleShow() {
            Log.v(OToast.Companion.getTAG(), "HANDLE SHOW: " + this + " mView=" + this.mView + " mNextView=" + this.mNextView);
            handleHide();
            Context r0 = this.mContext;
            if (r0 != null) goto L5;
            Activity r1 = null;
        L6:
            Context r2 = this.mContext;
            View r3 = this.mNextView;
            Intrinsics.checkNotNull(r3);
            View r4 = wrapWithShadowFrame(r2, r3, this.mY);
            this.mView = r4;
            Intrinsics.checkNotNull(r4);
            Context r5 = r4.getContext().getApplicationContext();
            View r6 = this.mView;
            Intrinsics.checkNotNull(r6);
            String r7 = r6.getContext().getPackageName();
            if (r5 != null) goto L9;
            View r8 = this.mView;
            Intrinsics.checkNotNull(r8);
            r5 = r8.getContext();
        L9:
            Intrinsics.checkNotNull(r5);
            Object r9 = r5.getSystemService("window");
            if (r9 == null) goto L33;
            this.mWM = (WindowManager) r9;
            View r10 = this.mView;
            Intrinsics.checkNotNull(r10);
            int r11 = Gravity.getAbsoluteGravity(this.mGravity, r10.getContext().getResources().getConfiguration().getLayoutDirection());
            this.mParams.gravity = r11;
            if ((r11 & 7) != 7) goto L15;
            this.mParams.horizontalWeight = 1.0f;
        L15:
            if ((r11 & 112) != 112) goto L17;
            this.mParams.verticalWeight = 1.0f;
        L17:
            this.mParams.x = this.mX;
            this.mParams.y = this.mY;
            this.mParams.verticalMargin = this.mVerticalMargin;
            this.mParams.horizontalMargin = this.mHorizontalMargin;
            OWindowConfigController.applyLandscapeCutoutMode(r5, this.mParams, this.includeCutoutInLandscape);
            this.mParams.y = 0;
            this.mParams.width = -1;
            if (r1 == null) goto L20;
            this.mParams.token = r1.getWindow().getAttributes().token;
        L23:
            this.mParams.packageName = r7;
            View r12 = this.mView;
            Intrinsics.checkNotNull(r12);
            if (r12.getParent() == null) goto L26;
            Log.v(OToast.Companion.getTAG(), "REMOVE! " + this.mView + " in " + this);
            WindowManager r13 = this.mWM;
            Intrinsics.checkNotNull(r13);
            r13.removeView(this.mView);
        L26:
            Log.v(OToast.Companion.getTAG(), "ADD! " + this.mView + " in " + this);
            WindowManager r14 = this.mWM;     // Catch: Exception -> L29
            Intrinsics.checkNotNull(r14);     // Catch: Exception -> L29
            r14.addView(this.mView, this.mParams);     // Catch: Exception -> L29
            return;
        L29:
            e = move-exception;
            e.printStackTrace();
            return;
        L20:
            IBinder r15 = this.mWindowToken;
            if (r15 == null) goto L23;
            this.mParams.token = r15;
            goto L23
        L33:
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        L5:
            r1 = OWindowConfigController.INSTANCE.getActivity(r0);
            goto L6
        }

        private final void handleHide() {
            View r0 = this.mView;
            if (r0 == null) goto L9;
            Intrinsics.checkNotNull(r0);
            if (r0.getParent() == null) goto L7;
            Log.v(OToast.Companion.getTAG(), "REMOVE! " + this.mView + " in " + this);
            WindowManager r1 = this.mWM;
            Intrinsics.checkNotNull(r1);
            r1.removeView(this.mView);
        L7:
            this.mView = null;
            return;
        }

        private final View wrapWithShadowFrame(Context r11, View r12, int r13) {
            if (r11 != null) goto L4;
            return r12;
        L4:
            KtExt r10 = KtExt.INSTANCE;
            if (r12 != null) goto L8;
        L6:
            View r0 = null;
        L10:
            ToastBackgroundView r1 = (ToastBackgroundView) r0;
            if (r1 != null) goto L13;
            int r2 = 24;
        L14:
            View r3 = LayoutInflater.from(r11).inflate(R.layout.o_layout_popover_shadow_frame, null);
            if (r3 == null) goto L34;
            SingleChildFrameLayout r4 = (SingleChildFrameLayout) r3;
            r4.addView(r12, new FrameLayout.LayoutParams(-2, -2));
            r4.setShadowCornerRadius(r2);
            List<Shadow> r14 = OUILayoutHelper.extractShadowInfo(r11, R.style.OUIShadow_Oui_Shadow_Regular);
            Intrinsics.checkNotNullExpressionValue(r14, MaterialConfigFormatNames.SHADOWS);
            Iterator<T> r15 = r14.iterator();
            int r5 = 0;
            int r6 = 0;
            int r7 = 0;
            int r8 = 0;
        L18:
            if (r15.hasNext() == false) goto L31;
            Shadow r9 = (Shadow) r15.next();
            if ((r9.getRadius() - r9.getOffsetX()) <= r6) goto L23;
            r6 = MathKt.roundToInt(r9.getRadius() - r9.getOffsetX());
        L23:
            if ((r9.getRadius() + r9.getOffsetX()) <= r7) goto L26;
            r7 = MathKt.roundToInt(r9.getRadius() + r9.getOffsetX());
        L26:
            if ((r9.getRadius() - r9.getOffsetY()) <= r5) goto L29;
            r5 = MathKt.roundToInt(r9.getRadius() - r9.getOffsetY());
        L29:
            if ((r9.getRadius() + r9.getOffsetY()) <= r8) goto L18;
            r8 = MathKt.roundToInt(r9.getRadius() + r9.getOffsetY());
            goto L18
        L31:
            SingleChildFrameLayout r16 = new SingleChildFrameLayout(r11, null, 2, null);
            r16.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
            FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
            r17.gravity = 1;
            Unit r18 = Unit.INSTANCE;
            r16.addView(r4, r17);
            r16.setClipChildren(false);
            r16.setClipToPadding(false);
            r16.setPadding(0, r5, 0, r13);
            return r16;
        L34:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        L13:
            r2 = r1.getCornerRadius();
            goto L14
        L8:
            if ((r12 instanceof ToastBackgroundView) == false) goto L6;
            r0 = r12;
            goto L10
        }

        static {
            Companion = new Companion(null);
            MSG_SHOW = 1;
            MSG_HIDE = 2;
        }
    }

    public OToast(Context r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "mContext");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
        this(r11, r12, 0, false, null, 0, 60, null);
    }

    public OToast(Context r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "mContext");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
        this(r11, r12, r13, false, null, 0, 56, null);
    }

    public OToast(Context r11, String r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "mContext");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
        this(r11, r12, r13, r14, null, 0, 48, null);
    }

    public OToast(Context r11, String r12, int r13, boolean r14, Boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "mContext");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
        this(r11, r12, r13, r14, r15, 0, 32, null);
    }

    @JvmStatic
    public static final void show(String r1, int r2) {
        Companion.show(r1, r2);
    }

    public OToast(Context r2, String r3, int r4, boolean r5, Boolean r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        this.mContext = r2;
        this.msg = r3;
        this.position = r4;
        this.forceUseAddViewToast = r5;
        this.includeCutoutInLandscape = r6;
        this.style = r7;
        TN r8 = new TN();
        this.mTN = r8;
        int r9 = OUnitExtensionKt.cdp(r2, 73);
        this.verticalWidthSpace = r9;
        this.drawableReservedWidth = OUnitExtensionKt.cdp(r2, 28);
        if (ResourceUtils.INSTANCE.isLandscape(r2) == true) goto L5;
        int r10 = OUnitExtensionKt.getScreenWidth(r2) - r9;
    L6:
        this.baseMsgMaxWidth = r10;
        this.msgMaxWidth = r10;
        LayoutInflater r11 = LayoutInflater.from(r2);
        int r12 = this.style;
        if (r12 != 0) goto L9;
        int r13 = R.layout.o_toast;
    L13:
        View r14 = r11.inflate(r13, null);
        Intrinsics.checkNotNullExpressionValue(r14, "from(mContext)\n        .…   }\n            }, null)");
        this.contentView = r14;
        if (this.position == 80) goto L16;
        this.position = 80;
        L.w(TAG, "custom position is not supported! position " + this.position + '!');
    L16:
        r8.setMY(96);
        r8.setMGravity(this.position);
        ((TextView) this.contentView.findViewById(R.id.tv_msg)).setText(r3);
        View r15 = this.contentView.findViewById(R.id.right_button);
        Intrinsics.checkNotNullExpressionValue(r15, "contentView.findViewById(R.id.right_button)");
        this.button = (OButton) r15;
        recalculateMsgMaxWidth();
        return;
    L9:
        if (r12 == 2) goto L11;
        r13 = R.layout.o_toast_light;
        goto L13
    L11:
        r13 = R.layout.o_toast_dark;
        goto L13
    L5:
        r10 = OUnitExtensionKt.cdp(r2, OToastConstants.MSG_MAX_WIDTH_DP);
        goto L6
    }

    public /* synthetic */ OToast(Context r8, String r9, int r10, boolean r11, Boolean r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 80;
    L5:
        int r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        boolean r4 = false;
    L10:
        if ((r14 & 16) == 0) goto L12;
        r12 = null;
    L12:
        Boolean r5 = r12;
        if ((r14 & 32) == 0) goto L15;
        int r6 = 0;
    L16:
        this(r8, r9, r3, r4, r5, r6);
        return;
    L15:
        r6 = r13;
        goto L16
    L8:
        r4 = r11;
        goto L10
    }

    public static final /* synthetic */ Context access$getMContext$p(OToast r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ WeakReference access$getToastRef$cp() {
        return toastRef;
    }

    public static final /* synthetic */ void access$setToastRef$cp(WeakReference r0) {
        toastRef = r0;
    }

    public final View getRightAction() {
        return this.rightAction;
    }

    /* JADX INFO: renamed from: setRightAction, reason: collision with other method in class */
    public final void m578setRightAction(View r1) {
        this.rightAction = r1;
    }

    static {
        Companion = new Companion(null);
        TAG = "OToast";
        toastRef = new WeakReference(null);
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

    private final void recalculateMsgMaxWidth() {
        View r0 = this.contentView.findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r0, "contentView.findViewById<ImageView>(R.id.iv_icon)");
        if (ViewExtensionsKt.isGone(r0) == false) goto L8;
        View r1 = this.contentView.findViewById(R.id.toast_progress);
        Intrinsics.checkNotNullExpressionValue(r1, "contentView.findViewById…iew>(R.id.toast_progress)");
        if (ViewExtensionsKt.isGone(r1) == false) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == false) goto L11;
        int r3 = this.baseMsgMaxWidth - this.drawableReservedWidth;
    L12:
        this.msgMaxWidth = r3;
        ((TextView) this.contentView.findViewById(R.id.tv_msg)).setMaxWidth(this.msgMaxWidth);
        return;
    L11:
        r3 = this.baseMsgMaxWidth;
    L8:
        r2 = true;
        goto L9
    }

    public final void enableProgressbar() {
        ODownloadProgressView r0 = (ODownloadProgressView) this.contentView.findViewById(R.id.toast_progress);
        Intrinsics.checkNotNullExpressionValue(r0, "it");
        ViewExtensionsKt.makeVisible(r0);
        ImageView r1 = (ImageView) this.contentView.findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r1, "it");
        ViewExtensionsKt.makeGone(r1);
        recalculateMsgMaxWidth();
    }

    public final OToast setLeftDrawable(Integer r3) {
        if (r3 == null) goto L5;
        r3.intValue();
        ImageView r0 = (ImageView) getContentView().findViewById(R.id.iv_icon);
        r0.setImageResource(r3.intValue());
        Intrinsics.checkNotNullExpressionValue(r0, "it");
        ViewExtensionsKt.makeVisible(r0);
        recalculateMsgMaxWidth();
    L5:
        return this;
    }

    public final OToast setLeftDrawable(Drawable r3) {
        if (r3 == null) goto L5;
        ImageView r0 = (ImageView) getContentView().findViewById(R.id.iv_icon);
        r0.setImageDrawable(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "it");
        ViewExtensionsKt.makeVisible(r0);
        recalculateMsgMaxWidth();
    L5:
        return this;
    }

    public final OToast setStartDrawable(Integer r3) {
        ImageView r0 = (ImageView) this.contentView.findViewById(R.id.iv_icon);
        if (r3 == null) goto L5;
        r0.setImageResource(r3.intValue());
        Intrinsics.checkNotNullExpressionValue(r0, "view");
        ViewExtensionsKt.makeVisible(r0);
    L6:
        recalculateMsgMaxWidth();
        return this;
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "view");
        ViewExtensionsKt.makeGone(r0);
        goto L6
    }

    public final OToast setStartDrawable(Drawable r3) {
        ImageView r0 = (ImageView) this.contentView.findViewById(R.id.iv_icon);
        if (r3 == null) goto L5;
        r0.setImageDrawable(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "it");
        ViewExtensionsKt.makeVisible(r0);
    L6:
        recalculateMsgMaxWidth();
        return this;
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "it");
        ViewExtensionsKt.makeGone(r0);
        goto L6
    }

    public final void setDuration(int r1) {
        this.mTN.setMDuration(r1);
    }

    public final OToast setIncludeCutoutInLandscape(Boolean r1) {
        this.includeCutoutInLandscape = r1;
        return this;
    }

    public final void cancel() {
        this.mTN.clearPendingMessages();
        this.mTN.hide();
        Toast r0 = this.systemToast;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.systemToast = null;
    }

    public final OToast setPos(Integer r2) {
        L.w(TAG, "set position is not supported");
        return this;
    }

    public final OToast setRightAction(View r1) {
        this.rightAction = r1;
        return this;
    }

    public static /* synthetic */ OToast setRightButtonAndClickListener$default(OToast r0, String r1, View.OnClickListener r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = R.color.oui_toast_button_background;
    L6:
        return r0.setRightButtonAndClickListener(r1, r2, r3);
    }

    public final OToast setRightButtonAndClickListener(String r3, View.OnClickListener r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "string");
        TextView r6 = (TextView) this.contentView.findViewById(R.id.tv_msg);
        int r0 = this.msgMaxWidth;
        Intrinsics.checkNotNullExpressionValue(r6, "it");
        this.msgMaxWidth = r0 - OUnitExtensionKt.vdp(r6, 52);
        ViewExtensionsKt.makeVisible(this.button);
        this.button.setText(r3);
        this.button.setOnClickListener(r4);
        return this;
    }

    public final OToast setWindowToken(IBinder r2) {
        this.mTN.setMWindowToken(r2);
        return this;
    }

    public final void show() {
    L42:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try DeadObjectException occur, ", e.getMessage()));
    L46:
        ToolsExtKt.printLog(Intrinsics.stringPlus(TAG, ", showAsDropDown exception occur, try showAtLocation"));
        Boolean.valueOf(true);
        return;
    L44:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try runtimeException occur, ", e.getMessage()));
        goto L46
    L4:
        if (this.style == 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
    L18:
        Log.d(TAG, "show toast by ocean");     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        int r3 = this.position;     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        if (r3 != 17) goto L21;
    L24:
        int r4 = 0;
    L28:
        if (getRightAction() == null) goto L30;
        ((LinearLayout) getContentView().findViewById(R.id.toast_root)).addView(getRightAction());     // Catch: DeadObjectException -> L42 RuntimeException -> L44
    L30:
        ((TextView) getContentView().findViewById(R.id.tv_msg)).setMaxWidth(this.msgMaxWidth);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        getContentView().measure(0, 0);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        KtExt r5 = KtExt.INSTANCE;     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        View r6 = getContentView();     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        if (r6 != null) goto L34;
    L32:
        r6 = null;
    L35:
        ToastBackgroundView r7 = (ToastBackgroundView) r6;     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        if (r7 == null) goto L39;
        r7.setupBackground(getContentView().getMeasuredHeight());     // Catch: DeadObjectException -> L42 RuntimeException -> L44
    L39:
        TN r8 = this.mTN;     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        r8.setMNextView(getContentView());     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        r8.setMContext(this.mContext);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        r8.setMGravity(this.position);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        r8.setMY(r4);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        r8.setIncludeCutoutInLandscape(this.includeCutoutInLandscape);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        r8.show();     // Catch: DeadObjectException -> L42 RuntimeException -> L44
    L40:
        Unit r9 = Unit.INSTANCE;     // Catch: DeadObjectException -> L42 RuntimeException -> L44
    L50:
        return;
    L34:
        if ((r6 instanceof ToastBackgroundView) == false) goto L32;
    L21:
        if (r3 != 48) goto L23;
        r4 = OUnitExtensionKt.cdp(this.mContext, 20);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        goto L28
    L23:
        if (r3 != 80) goto L24;
        r4 = OUnitExtensionKt.cdp(this.mContext, 96);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        goto L28
    L9:
        if (this.forceUseAddViewToast == true) goto L18;
        if (ViewExtensionsKt.isGone(getButton()) == false) goto L13;
    L14:
        Log.d(TAG, "show toast by system");     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        Context r10 = this.mContext.getApplicationContext();     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        if (r10 != null) goto L17;
        r10 = this.mContext;     // Catch: DeadObjectException -> L42 RuntimeException -> L44
    L17:
        Toast r11 = Toast.makeText(r10, this.msg, 0);     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        this.systemToast = r11;     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        r11.show();     // Catch: DeadObjectException -> L42 RuntimeException -> L44
        goto L40
    L13:
        if (getButton().isClickable() == true) goto L18;
    L6:
        r2 = false;
        goto L7
    }
}
