package com.obric.matrix.opush.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/opush/utils/PacketManagerUtils;", "", "()V", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getAppIcon", "Landroid/graphics/drawable/Icon;", "context", "Landroid/content/Context;", "packageName", "", "getAppIconBitmap", "getAppName", "getIcon", "bitmap", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f9430a = null;

    static {
        f9430a = new f();
    }

    private f() {
    }

    public final Bitmap a(Drawable r5) {
        o.f(r5, "drawable");
        int r4 = r5.getIntrinsicWidth();
        int r0 = r5.getIntrinsicHeight();
        Bitmap r1 = Bitmap.createBitmap(r4, r0, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        r5.setBounds(0, 0, r4, r0);
        r5.draw(r2);
        o.e(r1, "bitmap");
        return r1;
    }

    @RequiresApi(23)
    public final Bitmap b(Context r10, String r11) {
        o.f(r10, "context");
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return null;
    L8:
        PackageManager r12 = r10.getPackageManager();     // Catch: Throwable -> L7
        o.c(r11);     // Catch: Throwable -> L7
        Drawable r13 = r12.getApplicationIcon(r11);     // Catch: Throwable -> L7
        o.e(r13, "context.packageManager.g…cationIcon(packageName!!)");     // Catch: Throwable -> L7
        Bitmap r9 = a(r13);     // Catch: Throwable -> L7
        Bitmap r14 = Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L7
        Canvas r15 = new Canvas(r14);     // Catch: Throwable -> L7
        Paint r0 = new Paint();     // Catch: Throwable -> L7
        Rect r2 = new Rect(0, 0, r9.getWidth(), r9.getHeight());     // Catch: Throwable -> L7
        r0.setAntiAlias(true);     // Catch: Throwable -> L7
        r15.drawARGB(0, 0, 0, 0);     // Catch: Throwable -> L7
        int r3 = r9.getWidth() / 2;     // Catch: Throwable -> L7
        int r4 = r9.getHeight() / 2;     // Catch: Throwable -> L7
        r15.drawCircle(r3, r4, (int) Math.min(r3, r4), r0);     // Catch: Throwable -> L7
        r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: Throwable -> L7
        r15.drawBitmap(r9, r2, r2, r0);     // Catch: Throwable -> L7
        return r14;
    L7:
        return null;
    }

    public final String c(Context r3, String r4) {
        o.f(r3, "context");
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return null;
    L8:
        PackageInfo r2 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0);     // Catch: Throwable -> L7
        return r3.getResources().getString(r2.applicationInfo.labelRes);
    L7:
        return null;
    }
}
