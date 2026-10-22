package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ToolsExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J(\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J4\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001bH\u0002J\u001c\u0010!\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueViewV2WithClip;", "Landroid/view/View;", "Lcom/obric/oui/avatar/IOAvatarQueueViewV2WithClipOperation;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "inParam", "Lcom/obric/oui/avatar/OAvatarInParam;", "mAvatarBitmapQueue", "", "Landroid/graphics/Bitmap;", "mPaint", "Landroid/graphics/Paint;", "convertBitmap2Circle", "avatarSize", "originBitmap", "convertBitmap2CircleClip", "overLapSizeDp", "shape", "Lcom/obric/oui/avatar/OAvatarQueueShape;", "convertBitmapWithTransBorder", "clipType", "init", "", AutoTestConstant.PARAM, "onDraw", "canvas", "Landroid/graphics/Canvas;", "recycleAvatarQueueBitmap", "clip", "toCircle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueViewV2WithClip extends View implements IOAvatarQueueViewV2WithClipOperation {
    private OAvatarInParam inParam;
    private List<Bitmap> mAvatarBitmapQueue;
    private final Paint mPaint;

    /* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OAvatarQueueShape.values().length];
            r0[OAvatarQueueShape.Group.ordinal()] = 1;
            r0[OAvatarQueueShape.Queue.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public OAvatarQueueViewV2WithClip(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "ctx");
        this(r8, null, 0, 6, null);
    }

    public OAvatarQueueViewV2WithClip(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "ctx");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OAvatarQueueViewV2WithClip(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OAvatarQueueViewV2WithClip(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2, r3, r4);
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        this.mPaint = r5;
        this.mAvatarBitmapQueue = new ArrayList();
    }

    @Override // com.obric.oui.avatar.IOAvatarQueueViewV2WithClipOperation
    public void init(OAvatarInParam r9) {
        Intrinsics.checkNotNullParameter(r9, AutoTestConstant.PARAM);
        this.inParam = r9;
        if (r9 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r9 = null;
    L6:
        if (r9.getAvatarBitmapQueue().isEmpty() == false) goto L8;
        return;
    L8:
        recycleAvatarQueueBitmap();
        OAvatarInParam r10 = this.inParam;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r10 = null;
    L11:
        int r11 = r10.getAvatarBitmapQueue().size();
        int r2 = 0;
    L12:
        if (r2 >= r11) goto L33;
        int r3 = r2 + 1;
        if (r2 != 0) goto L22;
        List<Bitmap> r5 = this.mAvatarBitmapQueue;
        OAvatarInParam r6 = this.inParam;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r6 = null;
    L18:
        Bitmap r7 = r6.getAvatarBitmapQueue().get(r2);
        Intrinsics.checkNotNullExpressionValue(r7, "inParam.avatarBitmapQueue[i]");
        Bitmap r8 = r7;
        OAvatarQueueViewV2WithClip r4 = this;
        OAvatarInParam r12 = this.inParam;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r12 = null;
    L21:
        r5.add(r2, toCircle(r8, OUnitExtensionKt.vdp(r4, r12.getAvatarSize().getDpValue())));
    L32:
        r2 = r3;
        goto L12
    L22:
        List<Bitmap> r13 = this.mAvatarBitmapQueue;
        OAvatarInParam r14 = this.inParam;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r14 = null;
    L25:
        Bitmap r15 = r14.getAvatarBitmapQueue().get(r2);
        Intrinsics.checkNotNullExpressionValue(r15, "inParam.avatarBitmapQueue[i]");
        Bitmap r16 = r15;
        OAvatarQueueViewV2WithClip r17 = this;
        OAvatarInParam r18 = this.inParam;
        if (r18 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r18 = null;
    L28:
        int r19 = OUnitExtensionKt.vdp(r17, r18.getAvatarSize().getDpValue());
        OAvatarInParam r20 = this.inParam;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r20 = null;
    L31:
        r13.add(r2, clip(r16, r19, r20.getShape()));
        goto L32
    L33:
        invalidate();
    }

    private final void recycleAvatarQueueBitmap() {
    L13:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r3 = Unit.INSTANCE;
        return;
    L3:
        if ((!this.mAvatarBitmapQueue.isEmpty()) == false) goto L11;
        Iterator<T> r0 = this.mAvatarBitmapQueue.iterator();     // Catch: Exception -> L13
    L6:
        if (r0.hasNext() == false) goto L10;
        Bitmap r1 = (Bitmap) r0.next();     // Catch: Exception -> L13
        if (r1.isRecycled() == true) goto L6;
        r1.recycle();     // Catch: Exception -> L13
        goto L6
    L10:
        this.mAvatarBitmapQueue.clear();     // Catch: Exception -> L13
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L13
    }

    @Override // android.view.View
    protected void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        if (this.inParam != null) goto L6;
        return;
    L6:
        if (this.mAvatarBitmapQueue.size() > 0) goto L8;
        return;
    L8:
        OAvatarInParam r0 = this.inParam;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r0 = null;
    L11:
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.getShape().ordinal()];
        int r3 = 0;
        if (r1 == 1) goto L31;
        if (r1 != 2) goto L47;
        OAvatarInParam r2 = this.inParam;
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r2 = null;
    L18:
        int r4 = r2.getAvatarBitmapQueue().size();
    L19:
        if (r3 >= r4) goto L54;
        int r5 = r3 + 1;
        if (r3 != 0) goto L23;
        r11.drawBitmap(this.mAvatarBitmapQueue.get(r3), 0.0f, 0.0f, this.mPaint);
    L30:
        r3 = r5;
        goto L19
    L23:
        Bitmap r6 = this.mAvatarBitmapQueue.get(r3);
        OAvatarQueueViewV2WithClip r7 = this;
        OAvatarInParam r8 = this.inParam;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r8 = null;
    L26:
        float r9 = OUnitExtensionKt.vdpFloat(r7, r8.getAvatarSize().getDpValue());
        OAvatarInParam r10 = this.inParam;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r10 = null;
    L29:
        r11.drawBitmap(r6, (r9 - OUnitExtensionKt.vdpFloat(r7, r10.getOverLapSizeDp())) * r3, 0.0f, this.mPaint);
        goto L30
    L54:
        return;
    L47:
        return;
    L31:
        OAvatarInParam r12 = this.inParam;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r12 = null;
    L34:
        int r13 = r12.getAvatarBitmapQueue().size();
    L35:
        if (r3 >= r13) goto L55;
        int r14 = r3 + 1;
        if (r3 != 0) goto L42;
        Bitmap r15 = this.mAvatarBitmapQueue.get(r3);
        OAvatarQueueViewV2WithClip r16 = this;
        OAvatarInParam r17 = this.inParam;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r17 = null;
    L41:
        r11.drawBitmap(r15, 0.0f, (OUnitExtensionKt.vdpFloat(r16, r17.getAvatarSize().getDpValue()) / 2) - 1, this.mPaint);
    L46:
        r3 = r14;
        goto L35
    L42:
        Bitmap r18 = this.mAvatarBitmapQueue.get(r3);
        OAvatarQueueViewV2WithClip r19 = this;
        OAvatarInParam r20 = this.inParam;
        if (r20 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r20 = null;
    L45:
        r11.drawBitmap(r18, (OUnitExtensionKt.vdpFloat(r19, r20.getAvatarSize().getDpValue()) / 2) - 1, 0.0f, this.mPaint);
        goto L46
    }

    static /* synthetic */ Bitmap convertBitmapWithTransBorder$default(OAvatarQueueViewV2WithClip r6, int r7, int r8, Bitmap r9, int r10, OAvatarQueueShape r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = 0;
    L5:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L9;
        r11 = OAvatarQueueShape.Queue;
    L9:
        return r6.convertBitmapWithTransBorder(r7, r8, r9, r4, r11);
    }

    private final Bitmap convertBitmapWithTransBorder(int r1, int r2, Bitmap r3, int r4, OAvatarQueueShape r5) {
        if (r1 != 0) goto L6;
        return convertBitmap2Circle(r2, r3);
    L6:
        return convertBitmap2CircleClip(r2, convertBitmap2Circle(r2, r3), r4, r5);
    }

    private final Bitmap convertBitmap2Circle(int r11, Bitmap r12) {
        if (r12.getWidth() != 0) goto L5;
    L9:
        return r12;
    L5:
        if (r12.getHeight() == 0) goto L9;
        Bitmap r10 = Bitmap.createBitmap(r11, r11, Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r10);
        Paint r1 = new Paint(1);
        Matrix r8 = new Matrix();
        float r13 = r11;
        r8.postScale(r13 / r12.getWidth(), r13 / r12.getHeight());
        r1.setShader(new BitmapShader(Bitmap.createBitmap(r12, 0, 0, r12.getWidth(), r12.getHeight(), r8, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        float r14 = r13 / 2;
        r0.drawCircle(r14, r14, r14, r1);
        Intrinsics.checkNotNullExpressionValue(r10, "result");
        return r10;
    }

    private final Bitmap toCircle(Bitmap r9, int r10) {
        return convertBitmapWithTransBorder$default(this, 0, r10, r9, 0, null, 24, null);
    }

    private final Bitmap clip(Bitmap r7, int r8, OAvatarQueueShape r9) {
        OAvatarInParam r0 = this.inParam;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("inParam");
        r0 = null;
    L6:
        return convertBitmapWithTransBorder(1, r8, r7, r0.getOverLapSizeDp(), r9);
    }

    private final Bitmap convertBitmap2CircleClip(int r8, Bitmap r9, int r10, OAvatarQueueShape r11) {
        Bitmap r0 = Bitmap.createBitmap(r8, r8, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        OAvatarQueueViewV2WithClip r7 = this;
        float r12 = OUnitExtensionKt.vdpFloat(r7, r10);
        Paint r2 = new Paint();
        r2.setShader(new BitmapShader(r9, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        float r13 = r8;
        float r3 = r13 / 2;
        r1.drawCircle(r3, r3, r3, r2);
        r2.reset();
        r2.setAntiAlias(true);
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        int r14 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r14 == 1) goto L7;
        if (r14 != 2) goto L8;
        r1.drawCircle(r12 - r3, r3, OUnitExtensionKt.vdpFloat(r7, 2) + r3, r2);
    L8:
        Intrinsics.checkNotNullExpressionValue(r0, "result");
        return r0;
    L7:
        r1.drawCircle(0.0f, r13, r3 + OUnitExtensionKt.vdpFloat(r7, 2), r2);
        goto L8
    }
}
