package sr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.activity.e;
import com.obric.common.oui.R$dimen;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f21993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f21994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21995c;
    public final float d;
    public boolean e;
    public final Paint f;
    public final Paint g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f21997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f21998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f21999k;

    public a(Context r5, Drawable r10, Integer r11, int r12, boolean r13) {
        float r14 = r5.getResources().getDimension(R$dimen.oui_image_stroke_width);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "icon");
        this.f21993a = r10;
        this.f21994b = r11;
        this.f21995c = r12;
        this.d = r14;
        this.e = r13;
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.STROKE);
        r15.setColor(this.f21995c);
        this.f = r15;
        Paint r16 = new Paint(1);
        r16.setStyle(Paint.Style.FILL);
        this.g = r16;
        this.f21997i = new Path();
        this.f21998j = new Path();
        this.f21999k = new Matrix();
        Integer r17 = this.f21994b;
        if (r17 == null) goto L6;
        r16.setColor(r17.intValue());
    L6:
        b();
    }

    public final void a(Canvas r5) {
        if (this.f21994b != null) goto L5;
        return;
    L5:
        Path r10 = this.f21997i;
        if (r10.isEmpty() == false) goto L10;
        Log.w("OImageAppIcon", "draw skipped background because maskPath is empty");
        return;
    L10:
        if (this.f21996h == false) goto L12;
        r10 = this.f21998j;
    L12:
        r5.drawPath(r10, this.g);
    }

    public final void b() {
        Path r5 = this.f21997i;
        r5.reset();
        Path r10 = this.f21998j;
        r10.reset();
        if (getBounds().isEmpty() == false) goto L6;
        Log.w("OImageAppIcon", "refreshMaskPath skipped because bounds is empty, check if in whitelist");
        return;
    L6:
        Path r11 = e.e().getIconMask();
        if (r11.isEmpty() == false) goto L10;
        Log.w("OImageAppIcon", "refreshMaskPath found empty icon mask");
        return;
    L10:
        float r12 = getBounds().width();
        float r13 = getBounds().height();
        float r14 = Math.min(r12, r13);
        float r15 = 0.0f;
        if (r12 <= r13) goto L13;
        float r16 = (r12 - r13) / 2.0f;
    L15:
        if (r13 <= r12) goto L17;
        r15 = (r13 - r12) / 2.0f;
    L17:
        Matrix r17 = this.f21999k;
        r17.reset();
        float r18 = r14 / 100.0f;
        r17.setScale(r18, r18);
        r5.set(r11);
        r5.transform(r17);
        r5.offset(getBounds().left + r16, getBounds().top + r15);
        float r19 = this.d + 1;
        r17.reset();
        float r20 = (r14 - (2.0f * r19)) / 100.0f;
        r17.setScale(r20, r20);
        r10.set(r11);
        r10.transform(r17);
        r10.offset((getBounds().left + r16) + r19, (getBounds().top + r15) + r19);
        return;
    L13:
        r16 = 0.0f;
        goto L15
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        boolean r5 = this.e;
        Paint r11 = this.f;
        float r12 = this.d;
        Path r13 = this.f21997i;
        Drawable r14 = this.f21993a;
        if (r5 == true) goto L13;
        a(r10);
        r14.draw(r10);
        if (r13.isEmpty() == false) goto L8;
        Log.w("OImageAppIcon", "draw skipped stroke because maskPath is empty");
        return;
    L8:
        if (r12 > 0.0f) goto L10;
        Log.d("OImageAppIcon", Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r12)));
        return;
    L10:
        int r15 = r10.save();
        r10.clipPath(r13);
        r11.setStrokeWidth(r12 * 2);
        r11.setStrokeJoin(Paint.Join.ROUND);
        r11.setStrokeCap(Paint.Cap.ROUND);
        r10.drawPath(r13, r11);
        r10.restoreToCount(r15);
        return;
    L13:
        if (r13.isEmpty() == false) goto L15;
        Log.w("OImageAppIcon", "draw skipped mask because maskPath is empty");
        r14.draw(r10);
        return;
    L15:
        int r16 = r10.save();
        r10.clipPath(r13);
        a(r10);
        r14.draw(r10);
        if (r12 > 0.0f) goto L18;
        Log.d("OImageAppIcon", Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r12)));
        r10.restoreToCount(r16);
        return;
    L18:
        r11.setStrokeWidth(r12 * 2);
        r11.setStrokeJoin(Paint.Join.ROUND);
        r11.setStrokeCap(Paint.Cap.ROUND);
        r10.drawPath(r13, r11);
        r10.restoreToCount(r16);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f21993a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        Intrinsics.checkNotNullParameter(r5, "bounds");
        super.onBoundsChange(r5);
        this.f21993a.setBounds(r5);
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        this.f21993a.setAlpha(r5);
        this.g.setAlpha(r5);
        this.f.setAlpha(r5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        this.f21993a.setColorFilter(r5);
        this.g.setColorFilter(r5);
        this.f.setColorFilter(r5);
        invalidateSelf();
    }
}
