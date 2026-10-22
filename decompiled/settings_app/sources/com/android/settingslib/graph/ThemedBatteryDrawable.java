package com.android.settingslib.graph;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.PathParser;
import com.android.settingslib.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThemedBatteryDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0016J\u0006\u0010B\u001a\u00020\u0005J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002J\b\u0010D\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0005H\u0016J\b\u0010F\u001a\u00020\u0005H\u0016J\b\u0010G\u001a\u00020)H\u0002J\u0010\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020/H\u0014J\b\u0010J\u001a\u00020)H\u0002J\u0010\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020\u0005H\u0016J\u0010\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020\u0005H\u0016J\u0012\u0010O\u001a\u00020)2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u001e\u0010R\u001a\u00020)2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u0005J&\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005J\b\u0010[\u001a\u00020)H\u0002R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u00102\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/android/settingslib/graph/ThemedBatteryDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "frameColor", "", "(Landroid/content/Context;I)V", "backgroundColor", "batteryLevel", "boltPath", "Landroid/graphics/Path;", "value", "", "charging", "getCharging", "()Z", "setCharging", "(Z)V", "colorLevels", "", "criticalLevel", "getCriticalLevel", "()I", "setCriticalLevel", "(I)V", "dualTone", "dualToneBackgroundFill", "Landroid/graphics/Paint;", "errorPaint", "errorPerimeterPath", "fillColor", "fillColorStrokePaint", "fillColorStrokeProtection", "fillMask", "fillPaint", "fillRect", "Landroid/graphics/RectF;", "intrinsicHeight", "intrinsicWidth", "invalidateRunnable", "Lkotlin/Function0;", "", "invertFillIcon", "levelColor", "levelPath", "levelRect", "padding", "Landroid/graphics/Rect;", "perimeterPath", "plusPath", "powerSaveEnabled", "getPowerSaveEnabled", "setPowerSaveEnabled", "scaleMatrix", "Landroid/graphics/Matrix;", "scaledBolt", "scaledErrorPerimeter", "scaledFill", "scaledPerimeter", "scaledPlus", "unifiedPath", "batteryColorForLevel", "level", "draw", "c", "Landroid/graphics/Canvas;", "getBatteryLevel", "getColorForLevel", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "loadPaths", "onBoundsChange", "bounds", "postInvalidate", "setAlpha", "alpha", "setBatteryLevel", "l", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setColors", "fgColor", "bgColor", "singleToneColor", "setPadding", "left", "top", "right", "bottom", "updateSize", "Companion", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ThemedBatteryDrawable extends Drawable {
    private static final int CRITICAL_LEVEL = 20;
    public static final Companion Companion = null;
    public static final float HEIGHT = 20.0f;
    public static final float PROTECTION_MIN_STROKE_WIDTH = 6.0f;
    private static final float PROTECTION_STROKE_WIDTH = 3.0f;
    public static final float WIDTH = 12.0f;
    private int backgroundColor;
    private int batteryLevel;
    private final Path boltPath;
    private boolean charging;
    private int[] colorLevels;
    private final Context context;
    private int criticalLevel;
    private boolean dualTone;
    private final Paint dualToneBackgroundFill;
    private final Paint errorPaint;
    private final Path errorPerimeterPath;
    private int fillColor;
    private final Paint fillColorStrokePaint;
    private final Paint fillColorStrokeProtection;
    private final Path fillMask;
    private final Paint fillPaint;
    private final RectF fillRect;
    private int intrinsicHeight;
    private int intrinsicWidth;
    private final Function0<Unit> invalidateRunnable;
    private boolean invertFillIcon;
    private int levelColor;
    private final Path levelPath;
    private final RectF levelRect;
    private final Rect padding;
    private final Path perimeterPath;
    private final Path plusPath;
    private boolean powerSaveEnabled;
    private final Matrix scaleMatrix;
    private final Path scaledBolt;
    private final Path scaledErrorPerimeter;
    private final Path scaledFill;
    private final Path scaledPerimeter;
    private final Path scaledPlus;
    private final Path unifiedPath;

    /* JADX INFO: compiled from: ThemedBatteryDrawable.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/settingslib/graph/ThemedBatteryDrawable$Companion;", "", "()V", "CRITICAL_LEVEL", "", "HEIGHT", "", "PROTECTION_MIN_STROKE_WIDTH", "PROTECTION_STROKE_WIDTH", "WIDTH", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$3uxMB6cD3_t5WFvig7NuPzGU_YA(Function0 r0) {
        postInvalidate$lambda$6(r0);
    }

    public static /* synthetic */ void $r8$lambda$HeUAgB0Abf4Nh9QGHM9KrLzc79U(Function0 r0) {
        postInvalidate$lambda$5(r0);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    public ThemedBatteryDrawable(Context r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this.context = r8;
        this.perimeterPath = new Path();
        this.scaledPerimeter = new Path();
        this.errorPerimeterPath = new Path();
        this.scaledErrorPerimeter = new Path();
        this.fillMask = new Path();
        this.scaledFill = new Path();
        this.fillRect = new RectF();
        this.levelRect = new RectF();
        this.levelPath = new Path();
        this.scaleMatrix = new Matrix();
        this.padding = new Rect();
        this.unifiedPath = new Path();
        this.boltPath = new Path();
        this.scaledBolt = new Path();
        this.plusPath = new Path();
        this.scaledPlus = new Path();
        this.fillColor = -65281;
        this.backgroundColor = -65281;
        this.levelColor = -65281;
        this.invalidateRunnable = new ThemedBatteryDrawable$invalidateRunnable$1(this);
        this.criticalLevel = r8.getResources().getInteger(R.integer.config_datagram_wait_for_connected_state_for_last_message_timeout_millis);
        Paint r0 = new Paint(1);
        r0.setColor(r9);
        r0.setAlpha(255);
        r0.setDither(true);
        r0.setStrokeWidth(5.0f);
        r0.setStyle(Paint.Style.STROKE);
        r0.setBlendMode(BlendMode.SRC);
        r0.setStrokeMiter(5.0f);
        r0.setStrokeJoin(Paint.Join.ROUND);
        this.fillColorStrokePaint = r0;
        Paint r1 = new Paint(1);
        r1.setDither(true);
        r1.setStrokeWidth(5.0f);
        r1.setStyle(Paint.Style.STROKE);
        r1.setBlendMode(BlendMode.CLEAR);
        r1.setStrokeMiter(5.0f);
        r1.setStrokeJoin(Paint.Join.ROUND);
        this.fillColorStrokeProtection = r1;
        Paint r2 = new Paint(1);
        r2.setColor(r9);
        r2.setAlpha(255);
        r2.setDither(true);
        r2.setStrokeWidth(0.0f);
        r2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.fillPaint = r2;
        Paint r3 = new Paint(1);
        r3.setColor(Utils.getColorStateListDefaultColor(r8, com.android.settingslib.R.color.batterymeter_saver_color));
        r3.setAlpha(255);
        r3.setDither(true);
        r3.setStrokeWidth(0.0f);
        r3.setStyle(Paint.Style.FILL_AND_STROKE);
        r3.setBlendMode(BlendMode.SRC);
        this.errorPaint = r3;
        Paint r4 = new Paint(1);
        r4.setColor(r9);
        r4.setAlpha(85);
        r4.setDither(true);
        r4.setStrokeWidth(0.0f);
        r4.setStyle(Paint.Style.FILL_AND_STROKE);
        this.dualToneBackgroundFill = r4;
        float r10 = r8.getResources().getDisplayMetrics().density;
        this.intrinsicHeight = (int) (20.0f * r10);
        this.intrinsicWidth = (int) (r10 * 12.0f);
        Resources r11 = r8.getResources();
        TypedArray r12 = r11.obtainTypedArray(com.android.settingslib.R.array.batterymeter_color_levels);
        Intrinsics.checkNotNullExpressionValue(r12, "res.obtainTypedArray(R.a…atterymeter_color_levels)");
        TypedArray r13 = r11.obtainTypedArray(com.android.settingslib.R.array.batterymeter_color_values);
        Intrinsics.checkNotNullExpressionValue(r13, "res.obtainTypedArray(R.a…atterymeter_color_values)");
        int r5 = r12.length();
        this.colorLevels = new int[r5 * 2];
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L9;
        int r7 = r6 * 2;
        this.colorLevels[r7] = r12.getInt(r6, 0);
        if (r13.getType(r6) != 2) goto L7;
        this.colorLevels[r7 + 1] = Utils.getColorAttrDefaultColor(this.context, r13.getThemeAttributeId(r6, 0));
    L8:
        r6 = r6 + 1;
        goto L3
    L7:
        this.colorLevels[r7 + 1] = r13.getColor(r6, 0);
        goto L8
    L9:
        r12.recycle();
        r13.recycle();
        loadPaths();
    }

    public int getCriticalLevel() {
        return this.criticalLevel;
    }

    public void setCriticalLevel(int r1) {
        this.criticalLevel = r1;
    }

    public final boolean getCharging() {
        return this.charging;
    }

    public final void setCharging(boolean r1) {
        this.charging = r1;
        postInvalidate();
    }

    public final boolean getPowerSaveEnabled() {
        return this.powerSaveEnabled;
    }

    public final void setPowerSaveEnabled(boolean r1) {
        this.powerSaveEnabled = r1;
        postInvalidate();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "c");
        r6.saveLayer(null, null);
        this.unifiedPath.reset();
        this.levelPath.reset();
        this.levelRect.set(this.fillRect);
        int r0 = this.batteryLevel;
        float r1 = r0 / 100.0f;
        if (r0 < 95) goto L5;
        float r2 = this.fillRect.top;
    L6:
        this.levelRect.top = (float) Math.floor(r2);
        this.levelPath.addRect(this.levelRect, Path.Direction.CCW);
        this.unifiedPath.addPath(this.scaledPerimeter);
        if (this.dualTone == true) goto L9;
        this.unifiedPath.op(this.levelPath, Path.Op.UNION);
    L9:
        this.fillPaint.setColor(this.levelColor);
        if (this.charging == false) goto L15;
        this.unifiedPath.op(this.scaledBolt, Path.Op.DIFFERENCE);
        if (this.invertFillIcon == true) goto L15;
        r6.drawPath(this.scaledBolt, this.fillPaint);
    L15:
        if (this.dualTone == false) goto L17;
        r6.drawPath(this.unifiedPath, this.dualToneBackgroundFill);
        r6.save();
        r6.clipRect(0.0f, getBounds().bottom - (getBounds().height() * r1), getBounds().right, getBounds().bottom);
        r6.drawPath(this.unifiedPath, this.fillPaint);
        r6.restore();
    L23:
        if (this.charging == false) goto L29;
        r6.clipOutPath(this.scaledBolt);
        if (this.invertFillIcon == false) goto L27;
        r6.drawPath(this.scaledBolt, this.fillColorStrokePaint);
    L31:
        r6.restore();
        return;
    L27:
        r6.drawPath(this.scaledBolt, this.fillColorStrokeProtection);
        goto L31
    L29:
        if (this.powerSaveEnabled == false) goto L31;
        r6.drawPath(this.levelPath, this.errorPaint);
        this.fillPaint.setColor(this.fillColor);
        r6.drawPath(this.scaledPlus, this.fillPaint);
        goto L31
    L17:
        this.fillPaint.setColor(this.fillColor);
        r6.drawPath(this.unifiedPath, this.fillPaint);
        this.fillPaint.setColor(this.levelColor);
        if (this.batteryLevel > 20) goto L23;
        if (this.charging == true) goto L23;
        r6.save();
        r6.clipPath(this.scaledFill);
        r6.drawPath(this.levelPath, this.fillPaint);
        r6.restore();
        goto L23
    L5:
        r2 = this.fillRect.top + (this.fillRect.height() * (1 - r1));
        goto L6
    }

    private final int batteryColorForLevel(int r2) {
        if (this.charging == true) goto L9;
        if (this.powerSaveEnabled == true) goto L9;
        return getColorForLevel(r2);
    L9:
        return this.fillColor;
    }

    private final int getColorForLevel(int r5) {
        int r0 = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.colorLevels;
        if (r0 >= r2.length) goto L12;
        int r3 = r2[r0];
        int r4 = r2[r0 + 1];
        if (r5 <= r3) goto L8;
        r0 = r0 + 2;
        r1 = r4;
        goto L3
    L8:
        if (r0 == (r2.length - 2)) goto L10;
        return r4;
    L10:
        return this.fillColor;
    L12:
        return r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.fillPaint.setColorFilter(r2);
        this.fillColorStrokePaint.setColorFilter(r2);
        this.dualToneBackgroundFill.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.intrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.intrinsicWidth;
    }

    public void setBatteryLevel(int r2) {
        if (r2 < 67) goto L6;
        boolean r0 = true;
    L9:
        this.invertFillIcon = r0;
        this.batteryLevel = r2;
        this.levelColor = batteryColorForLevel(r2);
        invalidateSelf();
        return;
    L6:
        if (r2 > 33) goto L8;
        r0 = false;
        goto L9
    L8:
        r0 = this.invertFillIcon;
        goto L9
    }

    public final int getBatteryLevel() {
        return this.batteryLevel;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        updateSize();
    }

    public final void setPadding(int r2, int r3, int r4, int r5) {
        this.padding.left = r2;
        this.padding.top = r3;
        this.padding.right = r4;
        this.padding.bottom = r5;
        updateSize();
    }

    public final void setColors(int r2, int r3, int r4) {
        if (this.dualTone == true) goto L6;
        r2 = r4;
    L6:
        this.fillColor = r2;
        this.fillPaint.setColor(r2);
        this.fillColorStrokePaint.setColor(this.fillColor);
        this.backgroundColor = r3;
        this.dualToneBackgroundFill.setColor(r3);
        this.levelColor = batteryColorForLevel(this.batteryLevel);
        invalidateSelf();
    }

    private final void postInvalidate() {
        final Function0<Unit> r0 = this.invalidateRunnable;
        unscheduleSelf(new ThemedBatteryDrawable$$ExternalSyntheticLambda0(r0));
        final Function0<Unit> r1 = this.invalidateRunnable;
        scheduleSelf(new ThemedBatteryDrawable$$ExternalSyntheticLambda1(r1), 0);
    }

    private static final void postInvalidate$lambda$5(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }

    private static final void postInvalidate$lambda$6(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }

    private final void updateSize() {
        Rect r0 = getBounds();
        Intrinsics.checkNotNullExpressionValue(r0, "bounds");
        if (r0.isEmpty() == false) goto L5;
        this.scaleMatrix.setScale(1.0f, 1.0f);
    L6:
        this.perimeterPath.transform(this.scaleMatrix, this.scaledPerimeter);
        this.errorPerimeterPath.transform(this.scaleMatrix, this.scaledErrorPerimeter);
        this.fillMask.transform(this.scaleMatrix, this.scaledFill);
        this.scaledFill.computeBounds(this.fillRect, true);
        this.boltPath.transform(this.scaleMatrix, this.scaledBolt);
        this.plusPath.transform(this.scaleMatrix, this.scaledPlus);
        float r1 = Math.max((r0.right / 12.0f) * 3.0f, 6.0f);
        this.fillColorStrokePaint.setStrokeWidth(r1);
        this.fillColorStrokeProtection.setStrokeWidth(r1);
        return;
    L5:
        this.scaleMatrix.setScale(r0.right / 12.0f, r0.bottom / 20.0f);
        goto L6
    }

    private final void loadPaths() {
        String r0 = this.context.getResources().getString(R.string.config_customAdbPublicKeyConfirmationComponent);
        Intrinsics.checkNotNullExpressionValue(r0, "context.resources.getStr…atterymeterPerimeterPath)");
        this.perimeterPath.set(PathParser.createPathFromPathData(r0));
        this.perimeterPath.computeBounds(new RectF(), true);
        String r1 = this.context.getResources().getString(R.string.config_controlsPackage);
        Intrinsics.checkNotNullExpressionValue(r1, "context.resources.getStr…ymeterErrorPerimeterPath)");
        this.errorPerimeterPath.set(PathParser.createPathFromPathData(r1));
        this.errorPerimeterPath.computeBounds(new RectF(), true);
        String r2 = this.context.getResources().getString(R.string.config_credentialManagerReceiverComponent);
        Intrinsics.checkNotNullExpressionValue(r2, "context.resources.getStr…fig_batterymeterFillMask)");
        this.fillMask.set(PathParser.createPathFromPathData(r2));
        this.fillMask.computeBounds(this.fillRect, true);
        String r3 = this.context.getResources().getString(R.string.config_companionDeviceManagerPackage);
        Intrinsics.checkNotNullExpressionValue(r3, "context.resources.getStr…fig_batterymeterBoltPath)");
        this.boltPath.set(PathParser.createPathFromPathData(r3));
        String r4 = this.context.getResources().getString(R.string.config_customAdbPublicKeyConfirmationSecondaryUserComponent);
        Intrinsics.checkNotNullExpressionValue(r4, "context.resources.getStr…atterymeterPowersavePath)");
        this.plusPath.set(PathParser.createPathFromPathData(r4));
        this.dualTone = this.context.getResources().getBoolean(R.bool.config_battery_percentage_setting_available);
    }
}
