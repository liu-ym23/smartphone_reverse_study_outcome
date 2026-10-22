package z0;

import com.google.gson.JsonParseException;
import com.google.gson.ToNumberStrategy;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import com.lynx.tasm.utils.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ToNumberStrategy {
    @Override // com.google.gson.ToNumberStrategy
    public final Number readNumber(JsonReader r10) {
        Intrinsics.checkNotNullParameter(r10, "reader");
        String r5 = r10.nextString();
        Intrinsics.checkNotNull(r5);     // Catch: NumberFormatException -> L5
        return Long.valueOf(Long.parseLong(r5));
    L5:
        Intrinsics.checkNotNull(r5);
        double r11 = Double.parseDouble(r5);     // Catch: NumberFormatException -> L11
        if (Double.isInfinite(r11) == true) goto L14;
        if (Double.isNaN(r11) == true) goto L14;
    L16:
        if ((r11 % ((double) 1)) != 0.0d) goto L19;
        return Long.valueOf((long) r11);
    L19:
        return Double.valueOf(r11);
    L14:
        if (r10.isLenient() == true) goto L16;
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r11 + "; at path " + r10.getPreviousPath());     // Catch: NumberFormatException -> L11
    L11:
        e = move-exception;
        StringBuilder r12 = e.b("Cannot parse ", r5, "; at path ");
        r12.append(r10.getPreviousPath());
        throw new JsonParseException(r12.toString(), e);
    }
}
