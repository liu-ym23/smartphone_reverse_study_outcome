package tmsdkobf;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c6 {
    public static m4 a(Context r3) {
        m4 r0 = m4.b;
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r4 = r3.getSystemService("locale");
        if (r4 != null) goto L10;
        return r0;
    L10:
        return new m4(new n5(((LocaleManager) r4).getSystemLocales()));
    L8:
        return m4.a(Resources.getSystem().getConfiguration().getLocales().toLanguageTags());
    }
}
