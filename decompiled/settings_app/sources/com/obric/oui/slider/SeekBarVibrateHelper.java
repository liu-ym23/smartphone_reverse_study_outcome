package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: SeekBarVibrateHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fH\u0007J6\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/slider/SeekBarVibrateHelper;", "", "()V", "lastHandledProgress", "", "Ljava/lang/Integer;", "vibrationCountAfterLastUserChangeProgress", "onProgressChanged", "", "context", "Landroid/content/Context;", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "", "markCount", "isSegmentStyle", "vibrateIfNeeded", "effectId", "scene", "", "useCustomHapticEffect", "view", "Landroid/view/View;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SeekBarVibrateHelper {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private Integer lastHandledProgress;
    private int vibrationCountAfterLastUserChangeProgress;

    /* JADX INFO: compiled from: SeekBarVibrateHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/slider/SeekBarVibrateHelper$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public SeekBarVibrateHelper() {
        this.vibrationCountAfterLastUserChangeProgress = Integer.MAX_VALUE;
    }

    public final void onProgressChanged(Context r15, SeekBar r16, int r17, boolean r18, int r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "seekBar");
        if (r18 == true) goto L6;
        this.lastHandledProgress = Integer.valueOf(r17);
        this.vibrationCountAfterLastUserChangeProgress = Integer.MAX_VALUE;
        return;
    L6:
        this.vibrationCountAfterLastUserChangeProgress = 0;
        int r3 = r16.getMin();
        int r4 = r16.getMax();
        if (r17 != r3) goto L9;
        vibrateIfNeeded$default(this, r15, 5, "hit minProgress", false, null, 24, null);
        return;
    L9:
        if (r17 != r4) goto L11;
        vibrateIfNeeded$default(this, r15, 4, "hit maxProgress", false, null, 24, null);
        return;
    L11:
        int r8 = r19 - 1;
        if (r20 == false) goto L49;
        if (r8 > 1) goto L15;
        return;
    L15:
        if (this.lastHandledProgress == null) goto L43;
        float r5 = (r4 - r3) / r8;
        if (1 > r8) goto L43;
        int r9 = 1;
    L19:
        int r10 = r9 + 1;
        int r11 = MathKt.roundToInt((r9 * r5) - (r5 / 2)) + r3;
        Integer r12 = this.lastHandledProgress;
        Intrinsics.checkNotNull(r12);
        if (r12.intValue() >= r11) goto L23;
        if (r17 < r11) goto L23;
        boolean r13 = true;
    L24:
        Integer r14 = this.lastHandledProgress;
        Intrinsics.checkNotNull(r14);
        if (r14.intValue() <= r11) goto L28;
        if (r17 > r11) goto L28;
        boolean r110 = true;
    L29:
        if (r9 == 1) goto L38;
        if (r9 != r8) goto L33;
        r13 = r110;
        goto L38
    L33:
        if (r13 == true) goto L37;
        if (r110 == true) goto L37;
        r13 = false;
    L37:
        r13 = true;
    L38:
        if (r13 == true) goto L39;
        if (r9 == r8) goto L43;
        r9 = r10;
        goto L19
    L39:
        vibrateIfNeeded(r15, 26, "passed boundary: " + r9 + IOUtils.DIR_SEPARATOR_UNIX + r8 + ", progress: " + r17, false, r16);
    L28:
        r110 = false;
    L23:
        r13 = false;
    L43:
        this.lastHandledProgress = Integer.valueOf(r17);
        return;
    }

    static /* synthetic */ void vibrateIfNeeded$default(SeekBarVibrateHelper r6, Context r7, int r8, String r9, boolean r10, View r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = true;
    L5:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = null;
    L8:
        r6.vibrateIfNeeded(r7, r8, r9, r4, r11);
    }

    private final void vibrateIfNeeded(Context r3, int r4, String r5, boolean r6, View r7) {
        if (this.vibrationCountAfterLastUserChangeProgress >= 2) goto L10;
        L.d(TAG, Intrinsics.stringPlus("vibrateIfNeeded: ", r5));
        if (r6 == false) goto L7;
        VibratorSmt.vibrateEffectWithHapticPlayer(r3, r4);
    L8:
        this.vibrationCountAfterLastUserChangeProgress++;
        return;
    L7:
        VibratorSmt.INSTANCE.performHapticFeedbackAOSP(r7, r4);
        goto L8
    }

    static {
        Companion = new Companion(null);
        TAG = "SeekBarVibrateHelper";
    }
}
