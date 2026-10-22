package s4;

import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import java.util.HashMap;
import td.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f21815a = null;

    static {
        HashMap r5 = new HashMap(13);
        f21815a = r5;
        e.f(400, r5, "normal", 700, "bold");
        e.f(1, r5, "bolder", -1, "lighter");
        e.f(100, r5, "100", 200, "200");
        e.f(300, r5, "300", 400, "400");
        e.f(500, r5, "500", 600, "600");
        e.f(700, r5, "700", 800, "800");
        r5.put("900", Integer.valueOf(LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST));
    }
}
