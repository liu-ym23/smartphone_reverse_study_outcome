package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(double r0) {
        Half r1 = Half.valueOf((float) r0);
        o.e(r1, "valueOf(this)");
        return r1;
    }

    @RequiresApi(26)
    public static final Half toHalf(float r1) {
        Half r2 = Half.valueOf(r1);
        o.e(r2, "valueOf(this)");
        return r2;
    }

    @RequiresApi(26)
    public static final Half toHalf(String r1) {
        o.f(r1, "<this>");
        Half r2 = Half.valueOf(r1);
        o.e(r2, "valueOf(this)");
        return r2;
    }

    @RequiresApi(26)
    public static final Half toHalf(short r1) {
        Half r2 = Half.valueOf(r1);
        o.e(r2, "valueOf(this)");
        return r2;
    }
}
