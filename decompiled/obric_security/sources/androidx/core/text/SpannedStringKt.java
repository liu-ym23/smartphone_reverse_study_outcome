package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpannedString.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\b¨\u0006\u000b"}, d2 = {"getSpans", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/text/Spanned;", "start", "", TraceStatsConsts.STATS_KEY_END, "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SpannedStringKt {
    public static final Spanned toSpanned(CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        SpannedString r2 = SpannedString.valueOf(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "valueOf(this)");
        return r2;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = r0.length();
    L8:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] r5 = r0.getSpans(r1, r2, Object.class);
        Intrinsics.checkNotNullExpressionValue(r5, "getSpans(start, end, T::class.java)");
        return r5;
    }

    public static final /* synthetic */ <T> T[] getSpans(Spanned r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] r5 = r2.getSpans(r3, r4, Object.class);
        Intrinsics.checkNotNullExpressionValue(r5, "getSpans(start, end, T::class.java)");
        return (T[]) r5;
    }
}
