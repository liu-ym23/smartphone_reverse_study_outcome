package com.obric.matrix.q.e;

import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.google.gson.Gson;
import com.google.gson.e;
import com.obric.matrix.r.c.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000f\u001a\u00020\tJ\u001c\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u00112\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J+\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0014J^\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016j\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0018`\u0019\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\r\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00170\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J+\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001fJ+\u0010 \u001a\u00020!2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\"J \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J+\u0010%\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010'J*\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00192\u0006\u0010\r\u001a\u00020\u0004J4\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00192\u0006\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J/\u0010)\u001a\u0004\u0018\u0001H*\"\u0004\b\u0000\u0010*2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010-J&\u0010.\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004JJ\u0010/\u001a\u00020\f\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\r\u001a\u00020\u00042\"\u00100\u001a\u001e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016j\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0018`\u00192\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004J-\u00101\u001a\u00020\t\"\u0004\b\u0000\u0010*2\u0006\u0010\r\u001a\u00020\u00042\u0006\u00102\u001a\u0002H*2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u00103J\u0006\u00104\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/matrix/base/kv/KevaManager;", "", "()V", "TAG", "", "complexGson", "Lcom/google/gson/Gson;", "defaultRepo", "clearRepo", "", "repo", "containsInKeva", "", "key", "earseFromKeva", "ensureInit", "getAll", "", "getBooleanFromKeva", "default", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Z", "getComplexMapFromKeva", "Ljava/util/HashMap;", "K", "V", "Lkotlin/collections/HashMap;", "kClazz", "Ljava/lang/Class;", "vClazz", "getFloatFromKeva", "", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)F", "getIntFromKeva", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)I", "getListFromKeva", "", "getLongFromKeva", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)J", "getMapFromKeva", "getObjectFromKeva", "T", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "getStringFromKeva", "storeComplexMap", "map", "storeInKeva", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "updateContextIfNeed", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9851a = null;

    static {
        f9851a = new a();
        KevaBuilder.getInstance().setContext(com.bytedance.mpaas.app.a.f5245g);
        e r0 = new e();
        r0.f();
        o.e(r0.d(), "GsonBuilder()\n        .e…需要开启该方法\n        .create()");
    }

    private a() {
    }

    public static /* synthetic */ void c(a r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "Matrix_Keva_Repo";
    L5:
        r0.b(r1, r2);
    }

    public static /* synthetic */ int g(a r0, String r1, Integer r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = "Matrix_Keva_Repo";
    L9:
        return r0.f(r1, r2, r3);
    }

    public static /* synthetic */ long i(a r2, String r3, Long r4, String r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r4 = 0L;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r5 = "Matrix_Keva_Repo";
    L9:
        return r2.h(r3, r4, r5);
    }

    public static /* synthetic */ String k(a r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = "Matrix_Keva_Repo";
    L9:
        return r0.j(r1, r2, r3);
    }

    public static /* synthetic */ void m(a r0, String r1, Object r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "Matrix_Keva_Repo";
    L5:
        r0.l(r1, r2, r3);
    }

    public final void a(String r1) {
        o.f(r1, "repo");
        Keva.getRepo(r1, 0).clear();
    }

    public final void b(String r1, String r2) {
        o.f(r1, "key");
        Keva.getRepo(r2, 0).erase(r1);
    }

    public final void d() {
    }

    public final Map<String, ?> e(String r1) {
        Map<String, ?> r0 = Keva.getRepo(r1, 0).getAll();
        o.e(r0, "getRepo(repo, KevaConsta….MODE_SINGLE_PROCESS).all");
        return r0;
    }

    public final int f(String r1, Integer r2, String r3) {
        o.f(r1, "key");
        int r0 = 0;
        Keva r4 = Keva.getRepo(r3, 0);
        if (r2 == null) goto L6;
        r0 = r2.intValue();
    L6:
        return r4.getInt(r1, r0);
    }

    public final long h(String r1, Long r2, String r3) {
        o.f(r1, "key");
        Keva r0 = Keva.getRepo(r3, 0);
        if (r2 == null) goto L5;
        long r4 = r2.longValue();
    L7:
        return r0.getLong(r1, r4);
    L5:
        r4 = 0;
        goto L7
    }

    public final String j(String r1, String r2, String r3) {
        o.f(r1, "key");
        Keva r0 = Keva.getRepo(r3, 0);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r4 = r0.getString(r1, r2);
        o.e(r4, "keva.getString(key, default ?: \"\")");
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void l(String r1, T r2, String r3) {
        o.f(r1, "key");
        Keva r0 = Keva.getRepo(r3, 0);     // Catch: Exception -> L21
        if ((r2 instanceof String) == false) goto L8;
        String r4 = (String) r2;     // Catch: Exception -> L21
    L6:
        r0.storeString(r1, r4);     // Catch: Exception -> L21
        return;
    L8:
        if ((r2 instanceof Boolean) == false) goto L11;
        r0.storeBoolean(r1, ((Boolean) r2).booleanValue());     // Catch: Exception -> L21
        return;
    L11:
        if ((r2 instanceof Integer) == false) goto L14;
        r0.storeInt(r1, ((Number) r2).intValue());     // Catch: Exception -> L21
        return;
    L14:
        if ((r2 instanceof Float) == false) goto L17;
        r0.storeFloat(r1, ((Number) r2).floatValue());     // Catch: Exception -> L21
        return;
    L17:
        if ((r2 instanceof Long) == false) goto L19;
        r0.storeLong(r1, ((Number) r2).longValue());     // Catch: Exception -> L21
        return;
    L19:
        r4 = new Gson().v(r2);     // Catch: Exception -> L21
        o.e(r4, "Gson().toJson(value)");     // Catch: Exception -> L21
    L21:
        e = move-exception;
        c.f("KevaManager", "store in keva exception " + Log.getStackTraceString(e));
    }
}
