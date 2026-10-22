package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0005H\u0086\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0003*\u00020\u0005H\u0086\n¨\u0006\u0007"}, d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "Landroidx/core/util/SizeFCompat;", "component2", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class SizeKt {
    @RequiresApi(21)
    public static final float component1(SizeF r1) {
        o.f(r1, "<this>");
        return r1.getWidth();
    }

    public static final float component1(SizeFCompat r1) {
        o.f(r1, "<this>");
        return r1.getWidth();
    }

    @RequiresApi(21)
    public static final int component1(Size r1) {
        o.f(r1, "<this>");
        return r1.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF r1) {
        o.f(r1, "<this>");
        return r1.getHeight();
    }

    public static final float component2(SizeFCompat r1) {
        o.f(r1, "<this>");
        return r1.getHeight();
    }

    @RequiresApi(21)
    public static final int component2(Size r1) {
        o.f(r1, "<this>");
        return r1.getHeight();
    }
}
