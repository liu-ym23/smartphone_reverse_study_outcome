package yn;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace$TYPE;
import l9.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public Typeface a(LynxContext r5, FontFace$TYPE r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L17:
        return null;
    L5:
        if (r10 == FontFace$TYPE.f10851b) goto L17;
        int r12 = r11.indexOf("base64,");
        if (r11.startsWith("data:") == false) goto L17;
        if (r12 == (-1)) goto L17;
        return o.b(r5, Base64.decode(r11.substring(r12 + 7), 0));
    L15:
        e = move-exception;
        String r13 = e.getMessage();
        r5.getClass();
        r5.f(r11, "font", new LynxError(30203, r13, "", "error"));
        goto L17
    }
}
