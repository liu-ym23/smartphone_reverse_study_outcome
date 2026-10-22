package w2;

import com.bytedance.ai.model.objects.MainInitData;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static List a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Type r10 = new b().getType();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "typeOfT");
        return (List) z0.a.a().fromJson(r5, r10);
    }

    public static MainInitData b(String r5) {
        return (MainInitData) z0.a.a().fromJson(r5, MainInitData.class);
    }

    public static List c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Type r10 = new c().getType();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "typeOfT");
        return (List) z0.a.a().fromJson(r5, r10);
    }

    public static Map d(String r5) {
        Type r10 = new d().getType();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "typeOfT");
        return (Map) z0.a.a().fromJson(r5, r10);
    }

    public static List e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Type r10 = new e().getType();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "typeOfT");
        return (List) z0.a.a().fromJson(r5, r10);
    }

    public static List f(String r5) {
        Type r10 = new f().getType();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "typeOfT");
        return (List) z0.a.a().fromJson(r5, r10);
    }
}
