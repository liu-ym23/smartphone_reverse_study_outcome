package coil.drawable;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import com.bytedance.apm.constant.TraceStatsConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CrossfadeDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001XBC\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010\"\u001a\u00020#H\u0016J!\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\tH\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\tH\u0016J\b\u0010/\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\tH\u0017J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u0001H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0014J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\tH\u0014J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020;H\u0014J\u0010\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020\u0010H\u0016J \u0010>\u001a\u00020#2\u0006\u00102\u001a\u00020\u00012\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020 H\u0016J\u0010\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020\tH\u0016J\u0012\u0010D\u001a\u00020#2\b\u0010E\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020\tH\u0016J\u0012\u0010H\u001a\u00020#2\b\u0010I\u001a\u0004\u0018\u00010JH\u0017J\u0012\u0010K\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010N\u001a\u00020#2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010\u0004\u001a\u00020#H\u0016J\b\u0010Q\u001a\u00020#H\u0016J\u0010\u0010R\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u0010H\u0016J\u0018\u0010S\u001a\u00020#2\u0006\u00102\u001a\u00020\u00012\u0006\u0010?\u001a\u00020@H\u0016J\u001d\u0010T\u001a\u00020#2\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u000207H\u0001¢\u0006\u0002\bWR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcoil/drawable/CrossfadeDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "start", TraceStatsConsts.STATS_KEY_END, "scale", "Lcoil/size/Scale;", "durationMillis", "", "fadeStart", "", "preferExactIntrinsicSize", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;IZZ)V", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "getDurationMillis", "()I", "getEnd", "()Landroid/graphics/drawable/Drawable;", "getFadeStart", "()Z", "intrinsicHeight", "intrinsicWidth", "maxAlpha", "getPreferExactIntrinsicSize", "getScale", "()Lcoil/size/Scale;", "<set-?>", "getStart", "startTimeMillis", "", "state", "clearAnimationCallbacks", "", "computeIntrinsicDimension", "startSize", "endSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getColorFilter", "Landroid/graphics/ColorFilter;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "invalidateDrawable", "who", "isRunning", "markDone", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "onLevelChange", "level", "onStateChange", "", "registerAnimationCallback", "callback", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "setAlpha", "alpha", "setColorFilter", "colorFilter", "setTint", "tintColor", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "stop", "unregisterAnimationCallback", "unscheduleDrawable", "updateBounds", "drawable", "targetBounds", "updateBounds$coil_base_release", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CrossfadeDrawable extends Drawable implements Drawable.Callback, Animatable2Compat {
    public static final Companion Companion = null;
    public static final int DEFAULT_DURATION = 100;
    private static final int STATE_DONE = 2;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_START = 0;
    private final List<Animatable2Compat.AnimationCallback> callbacks;
    private final int durationMillis;
    private final Drawable end;
    private final boolean fadeStart;
    private final int intrinsicHeight;
    private final int intrinsicWidth;
    private int maxAlpha;
    private final boolean preferExactIntrinsicSize;
    private final Scale scale;
    private Drawable start;
    private long startTimeMillis;
    private int state;

    /* JADX INFO: compiled from: CrossfadeDrawable.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/drawable/CrossfadeDrawable$Companion;", "", "()V", "DEFAULT_DURATION", "", "STATE_DONE", "STATE_RUNNING", "STATE_START", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public CrossfadeDrawable(Drawable r10, Drawable r11) {
        this(r10, r11, null, 0, false, false, 60, null);
    }

    public CrossfadeDrawable(Drawable r10, Drawable r11, Scale r12) {
        this(r10, r11, r12, 0, false, false, 56, null);
    }

    public CrossfadeDrawable(Drawable r10, Drawable r11, Scale r12, int r13) {
        this(r10, r11, r12, r13, false, false, 48, null);
    }

    public CrossfadeDrawable(Drawable r10, Drawable r11, Scale r12, int r13, boolean r14) {
        this(r10, r11, r12, r13, r14, false, 32, null);
    }

    public /* synthetic */ CrossfadeDrawable(Drawable r8, Drawable r9, Scale r10, int r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = Scale.FIT;
    L5:
        Scale r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r11 = 100;
    L8:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L11;
        r12 = true;
    L11:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L14;
        r13 = false;
    L14:
        this(r8, r9, r3, r4, r5, r13);
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getFadeStart() {
        return this.fadeStart;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    public CrossfadeDrawable(Drawable r1, Drawable r2, Scale r3, int r4, boolean r5, boolean r6) {
        this.scale = r3;
        this.durationMillis = r4;
        this.fadeStart = r5;
        this.preferExactIntrinsicSize = r6;
        this.callbacks = new ArrayList();
        Drawable r7 = null;
        if (r1 == null) goto L5;
        Integer r8 = Integer.valueOf(r1.getIntrinsicWidth());
    L6:
        if (r2 == null) goto L8;
        Integer r9 = Integer.valueOf(r2.getIntrinsicWidth());
    L9:
        this.intrinsicWidth = computeIntrinsicDimension(r8, r9);
        if (r1 == null) goto L12;
        Integer r10 = Integer.valueOf(r1.getIntrinsicHeight());
    L13:
        if (r2 == null) goto L15;
        Integer r11 = Integer.valueOf(r2.getIntrinsicHeight());
    L16:
        this.intrinsicHeight = computeIntrinsicDimension(r10, r11);
        this.maxAlpha = 255;
        if (r1 == null) goto L19;
        Drawable r12 = r1.mutate();
    L20:
        this.start = r12;
        if (r2 == null) goto L23;
        r7 = r2.mutate();
    L23:
        this.end = r7;
        if (r4 <= 0) goto L26;
        boolean r13 = true;
    L27:
        if (r13 == false) goto L37;
        Drawable r14 = this.start;
        if (r14 == null) goto L32;
        r14.setCallback(this);
    L32:
        if (r7 == null) goto L38;
        r7.setCallback(this);
        return;
    L38:
        return;
    L37:
        throw new IllegalArgumentException("durationMillis must be > 0.".toString());
    L26:
        r13 = false;
        goto L27
    L19:
        r12 = null;
        goto L20
    L15:
        r11 = null;
        goto L16
    L12:
        r10 = null;
        goto L13
    L8:
        r9 = null;
        goto L9
    L5:
        r8 = null;
        goto L6
    }

    public final Drawable getStart() {
        return this.start;
    }

    public final Drawable getEnd() {
        return this.end;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        int r0 = this.state;
        if (r0 != 0) goto L14;
        Drawable r1 = this.start;
        if (r1 == null) goto L12;
        r1.setAlpha(this.maxAlpha);
        int r10 = r11.save();
        r1.draw(r11);     // Catch: Throwable -> L9
        r11.restoreToCount(r10);
        return;
    L9:
        th = move-exception;
        r11.restoreToCount(r10);
        throw th;
    L12:
        return;
    L14:
        if (r0 != 2) goto L24;
        Drawable r2 = this.end;
        if (r2 == null) goto L23;
        r2.setAlpha(this.maxAlpha);
        int r12 = r11.save();
        r2.draw(r11);     // Catch: Throwable -> L20
        r11.restoreToCount(r12);
        return;
    L20:
        th = move-exception;
        r11.restoreToCount(r12);
        throw th;
    L23:
        return;
    L24:
        double r3 = (SystemClock.uptimeMillis() - this.startTimeMillis) / ((double) this.durationMillis);
        double r4 = RangesKt.coerceIn(r3, 0.0d, 1.0d);
        int r5 = this.maxAlpha;
        int r6 = (int) (r4 * ((double) r5));
        if (this.fadeStart == false) goto L28;
        r5 = r5 - r6;
    L28:
        if (r3 < 1.0d) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == true) goto L40;
        Drawable r8 = this.start;
        if (r8 == null) goto L40;
        r8.setAlpha(r5);
        int r9 = r11.save();
        r8.draw(r11);     // Catch: Throwable -> L37
        r11.restoreToCount(r9);
    L37:
        th = move-exception;
        r11.restoreToCount(r9);
        throw th;
    L40:
        Drawable r13 = this.end;
        if (r13 == null) goto L48;
        r13.setAlpha(r6);
        int r14 = r11.save();
        r13.draw(r11);     // Catch: Throwable -> L45
        r11.restoreToCount(r14);
    L45:
        th = move-exception;
        r11.restoreToCount(r14);
        throw th;
    L48:
        if (r7 == false) goto L50;
        markDone();
        return;
    L50:
        invalidateSelf();
        return;
    L30:
        r7 = false;
        goto L31
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.maxAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L11;
        this.maxAlpha = r3;
        return;
    L11:
        throw new IllegalArgumentException(("Invalid alpha: " + r3).toString());
    L5:
        if (r3 >= 256) goto L7;
        r0 = true;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        Drawable r0 = this.start;
        Drawable r1 = this.end;
        int r4 = this.state;
        if (r4 != 0) goto L8;
        if (r0 != null) goto L6;
        return -2;
    L6:
        return r0.getOpacity();
    L8:
        if (r4 != 2) goto L12;
        if (r1 != null) goto L11;
        return -2;
    L11:
        return r1.getOpacity();
    L12:
        if (r0 == null) goto L15;
        if (r1 == null) goto L15;
        return Drawable.resolveOpacity(r0.getOpacity(), r1.getOpacity());
    L15:
        if (r0 != null) goto L23;
        if (r1 != null) goto L19;
        return -2;
    L19:
        return r1.getOpacity();
    L23:
        return r0.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
        Drawable r3 = this.start;
        if (r3 != null) goto L24;
        return null;
    L24:
        return r3.getColorFilter();
    L5:
        if (r0 != 1) goto L7;
        Drawable r1 = this.end;
        if (r1 == null) goto L18;
        ColorFilter r2 = r1.getColorFilter();
        if (r2 == null) goto L18;
        return r2;
    L18:
        Drawable r4 = this.start;
        if (r4 != null) goto L29;
        return null;
    L29:
        return r4.getColorFilter();
    L7:
        if (r0 != 2) goto L31;
        Drawable r5 = this.end;
        if (r5 != null) goto L26;
        return null;
    L26:
        return r5.getColorFilter();
    L31:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        Drawable r0 = this.start;
        if (r0 == null) goto L6;
        r0.setColorFilter(r2);
    L6:
        Drawable r1 = this.end;
        if (r1 == null) goto L11;
        r1.setColorFilter(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Drawable r0 = this.start;
        if (r0 == null) goto L5;
        updateBounds$coil_base_release(r0, r2);
    L5:
        Drawable r1 = this.end;
        if (r1 == null) goto L9;
        updateBounds$coil_base_release(r1, r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r3) {
        Drawable r0 = this.start;
        if (r0 == null) goto L5;
        boolean r1 = r0.setLevel(r3);
    L6:
        Drawable r2 = this.end;
        if (r2 == null) goto L9;
        boolean r4 = r2.setLevel(r3);
    L10:
        if (r1 == true) goto L12;
        if (r4 == true) goto L12;
        return false;
    L12:
        return true;
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r3) {
        Drawable r0 = this.start;
        if (r0 == null) goto L5;
        boolean r1 = r0.setState(r3);
    L6:
        Drawable r2 = this.end;
        if (r2 == null) goto L9;
        boolean r4 = r2.setState(r3);
    L10:
        if (r1 == true) goto L12;
        if (r4 == true) goto L12;
        return false;
    L12:
        return true;
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.intrinsicWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.intrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        unscheduleSelf(r2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        scheduleSelf(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int r2) {
        Drawable r0 = this.start;
        if (r0 == null) goto L5;
        r0.setTint(r2);
    L5:
        Drawable r1 = this.end;
        if (r1 == null) goto L9;
        r1.setTint(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r2) {
        Drawable r0 = this.start;
        if (r0 == null) goto L5;
        r0.setTintList(r2);
    L5:
        Drawable r1 = this.end;
        if (r1 == null) goto L9;
        r1.setTintList(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r2) {
        Drawable r0 = this.start;
        if (r0 == null) goto L5;
        r0.setTintMode(r2);
    L5:
        Drawable r1 = this.end;
        if (r1 == null) goto L9;
        r1.setTintMode(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintBlendMode(BlendMode r2) {
        Drawable r0 = this.start;
        if (r0 == null) goto L5;
        r0.setTintBlendMode(r2);
    L5:
        Drawable r1 = this.end;
        if (r1 == null) goto L9;
        r1.setTintBlendMode(r2);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.state == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Object r0 = this.start;
        Animatable r2 = null;
        if ((r0 instanceof Animatable) == false) goto L5;
        Animatable r1 = (Animatable) r0;
    L6:
        if (r1 == null) goto L8;
        r1.start();
    L8:
        Object r3 = this.end;
        if ((r3 instanceof Animatable) == false) goto L11;
        r2 = (Animatable) r3;
    L11:
        if (r2 == null) goto L14;
        r2.start();
    L14:
        if (this.state == 0) goto L16;
        return;
    L16:
        this.state = 1;
        this.startTimeMillis = SystemClock.uptimeMillis();
        List<Animatable2Compat.AnimationCallback> r4 = this.callbacks;
        int r5 = r4.size();
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L19;
        r4.get(r6).onAnimationStart(this);
        r6 = r6 + 1;
        goto L17
    L19:
        invalidateSelf();
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Object r0 = this.start;
        Animatable r2 = null;
        if ((r0 instanceof Animatable) == false) goto L5;
        Animatable r1 = (Animatable) r0;
    L6:
        if (r1 == null) goto L8;
        r1.stop();
    L8:
        Object r3 = this.end;
        if ((r3 instanceof Animatable) == false) goto L11;
        r2 = (Animatable) r3;
    L11:
        if (r2 == null) goto L14;
        r2.stop();
    L14:
        if (this.state == 2) goto L17;
        markDone();
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r1) {
        this.callbacks.add(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r1) {
        return this.callbacks.remove(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.callbacks.clear();
    }

    public final void updateBounds$coil_base_release(Drawable r11, Rect r12) {
        int r0 = r11.getIntrinsicWidth();
        int r1 = r11.getIntrinsicHeight();
        if (r0 <= 0) goto L8;
        if (r1 <= 0) goto L8;
        int r2 = r12.width();
        int r3 = r12.height();
        double r4 = DecodeUtils.computeSizeMultiplier(r0, r1, r2, r3, this.scale);
        double r8 = 2;
        int r10 = MathKt.roundToInt((((double) r2) - (((double) r0) * r4)) / r8);
        int r5 = MathKt.roundToInt((((double) r3) - (r4 * ((double) r1))) / r8);
        r11.setBounds(r12.left + r10, r12.top + r5, r12.right - r10, r12.bottom - r5);
        return;
    L8:
        r11.setBounds(r12);
    }

    private final int computeIntrinsicDimension(Integer r2, Integer r3) {
        int r0 = -1;
        if (this.preferExactIntrinsicSize == true) goto L13;
        if (r2 != null) goto L7;
    L8:
        if (r3 == null) goto L13;
        if (r3.intValue() != (-1)) goto L13;
    L12:
        return -1;
    L7:
        if (r2.intValue() == (-1)) goto L12;
    L13:
        if (r2 == null) goto L15;
        int r1 = r2.intValue();
    L16:
        if (r3 == null) goto L19;
        r0 = r3.intValue();
    L19:
        return Math.max(r1, r0);
    L15:
        r1 = -1;
        goto L16
    }

    private final void markDone() {
        this.state = 2;
        this.start = null;
        List<Animatable2Compat.AnimationCallback> r0 = this.callbacks;
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.get(r2).onAnimationEnd(this);
        r2 = r2 + 1;
        goto L3
    }
}
