package ul;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final Object a() {
        return k5.d.f18609n;
    }

    public static final Object b() {
        return "";
    }

    public static final Object c() {
        return String.valueOf(false);
    }

    public static final Object d() {
        return "android";
    }

    public static final Object e() {
        return k5.d.f18608m;
    }

    public final String getAccessKey(GeckoGlobalConfig.ENVType r5) {
        Intrinsics.checkNotNullParameter(r5, "env");
        int r10 = b.f22367a[r5.ordinal()];
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return getProdAccessKey();
    L9:
        return getTestAccessKey();
    L11:
        return getBoeAccessKey();
    }

    public abstract String getBoeAccessKey();

    public final Map<String, OptionCheckUpdateParams.CustomValue> getCustomPrams() {
        LinkedHashMap r5 = new LinkedHashMap();
        final int r10 = 0;
        r5.put("business_version", new a(r10));
        final int r11 = 1;
        r5.put(LynxMonitorService.KEY_CHANNEL, new a(r11));
        final int r12 = 2;
        r5.put("isOversea", new a(r12));
        final int r13 = 3;
        r5.put("device_platform", new a(r13));
        final int r14 = 4;
        r5.put("updateVersionCode", new a(r14));
        return r5;
    }

    public abstract String getDirName();

    public abstract String getProdAccessKey();

    public final String getRootDir(Context r5) {
        if (r5 != null) goto L4;
        return "";
    L4:
        return r5.getFilesDir().getAbsolutePath() + File.separator + getDirName();
    }

    public abstract String getTestAccessKey();
}
