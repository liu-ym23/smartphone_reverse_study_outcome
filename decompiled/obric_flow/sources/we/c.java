package we;

import android.text.SpannableString;
import com.bytedance.android.anniex.base.service.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f22858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f22859b;

    static {
        f22858a = Pattern.compile("(\\[)([^\\[\\]]+)(])");
    }

    public static SpannableString a(String r5) {
        a r10 = e.k();
        Matcher r11 = f22858a.matcher(r5);
        SpannableString r12 = new SpannableString(r5);
    L4:
        if (r11.find() == false) goto L10;
        r11.start();
        r11.end();
        r11.group();
        com.lynx.tasm.utils.c r13 = (com.lynx.tasm.utils.c) r10.f22857a;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r13 = null;
    L9:
        r13.getClass();
        goto L4
    L10:
        return r12;
    }
}
