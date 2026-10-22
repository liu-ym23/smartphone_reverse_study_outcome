package com.obric.dejavu.library.jni;

import android.os.Debug;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.dejavu.library.DbIndexConfig;
import com.obric.dejavu.library.DbInfo;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbLogWriter;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbOptions;
import com.obric.dejavu.library.DbSearchOption;
import com.obric.dejavu.library.DbStatus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: Bridge.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0087 J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0087 J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0013J\u001d\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J5\u0010\u0019\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u001aj\u0002`\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0087 J\b\u0010\u001f\u001a\u00020 H\u0007J\u0019\u0010!\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0087 J\t\u0010\"\u001a\u00020#H\u0087 J3\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010'\u001a\u00020\rH\u0087 J\u0011\u0010(\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010)\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0087 J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\tJ\u0011\u0010.\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J\u0019\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0087 J\u0019\u00100\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0087 J\u0019\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0087 J)\u00104\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0087 JV\u00108\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0016090\u001b0\u001b0\u001aj\u0002`:2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010;\u001a\b\u0012\u0004\u0012\u00020&0\u001b2\u0006\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\tH\u0087 ¢\u0006\u0002\u0010>J\u0011\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020 H\u0087 J\u0013\u0010A\u001a\u00020#2\b\u0010B\u001a\u0004\u0018\u00010CH\u0087 J\u0011\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 J!\u0010E\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\rH\u0087 J\u0011\u0010H\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087 ¨\u0006I"}, d2 = {"Lcom/obric/dejavu/library/jni/Bridge;", "", "()V", "clear", "Lcom/obric/dejavu/library/DbStatus;", "handle", "", "createDb", "dirPrefix", "", "dbOption", "dims", "exists", "", "key", "formatOptStr", "opt", "Lcom/obric/dejavu/library/DbIndexConfig;", "Lcom/obric/dejavu/library/DbOptions;", "Lcom/obric/dejavu/library/DbSearchOption;", "formatOptionalFloat", "value", "", "(Ljava/lang/String;Ljava/lang/Float;)Ljava/lang/String;", "getDbInfo", "getKeys", "Lcom/obric/dejavu/library/DbObjResult;", "", "Lcom/obric/dejavu/library/DbKeysResult;", "start", TraceStatsConsts.STATS_KEY_END, "getNativePss", "", "getProperty", "initNative", "", "insert", "vec", "", "normalize", "name", "openDb", "dbName", "parseDbInfo", "Lcom/obric/dejavu/library/DbInfo;", "info", "releaseDb", "remove", "removeDb", "runTest", "cwd", "filter", "searchKv", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", "searchVec", "Lkotlin/Pair;", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", "extra", "(J[[FILjava/lang/String;)Lcom/obric/dejavu/library/DbObjResult;", "setLogLevel", "level", "setLogWriter", "writer", "Lcom/obric/dejavu/library/DbLogWriter;", PerfConsts.PERF_DISK_FILE_SIZE, "updateIndexConfig", "cfg", "rebuildNow", "validate", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Bridge {
    public static final Bridge INSTANCE = null;

    @JvmStatic
    public static final native DbStatus clear(long r0);

    @JvmStatic
    public static final native long createDb(String r0, String r1);

    @JvmStatic
    public static final native long dims(long r0);

    @JvmStatic
    public static final native boolean exists(long r0, String r2);

    @JvmStatic
    public static final native String getDbInfo(long r0);

    @JvmStatic
    public static final native DbObjResult<String[]> getKeys(long r0, String r2, String r3);

    @JvmStatic
    public static final native String getProperty(long r0, String r2);

    @JvmStatic
    public static final native void initNative();

    @JvmStatic
    public static final native DbStatus insert(long r0, String r2, float[] r3, String r4, boolean r5);

    @JvmStatic
    public static final native String name(long r0);

    @JvmStatic
    public static final native long openDb(String r0, String r1);

    @JvmStatic
    public static final native void releaseDb(long r0);

    @JvmStatic
    public static final native DbStatus remove(long r0, String r2);

    @JvmStatic
    public static final native DbStatus removeDb(String r0, String r1);

    @JvmStatic
    public static final native void runTest(String r0, String r1);

    @JvmStatic
    public static final native DbKvResult searchKv(long r0, String r2, boolean r3, boolean r4);

    @JvmStatic
    public static final native DbObjResult<Pair<String, Float>[][]> searchVec(long r0, float[][] r2, int r3, String r4);

    @JvmStatic
    public static final native void setLogLevel(int r0);

    @JvmStatic
    public static final native void setLogWriter(DbLogWriter r0);

    @JvmStatic
    public static final native long size(long r0);

    @JvmStatic
    public static final native DbStatus updateIndexConfig(long r0, String r2, boolean r3);

    @JvmStatic
    public static final native DbStatus validate(long r0);

    private Bridge() {
    }

    static {
        INSTANCE = new Bridge();
        System.loadLibrary("dejavu_lib");
        initNative();
    }

    @JvmStatic
    public static final int getNativePss() {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        return r0.nativePss * 1024;
    }

    public final String formatOptionalFloat(String r2, Float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L5;
        return "";
    L5:
        if (Float.isNaN(r3.floatValue()) == false) goto L8;
        return "";
    L8:
        return "\"" + r2 + "\" : " + r3 + ',';
    }

    public final String formatOptStr(DbOptions r3) {
        Intrinsics.checkNotNullParameter(r3, "opt");
        return "{\n            \"dbname\":\"" + r3.getDbname() + "\",\n            \"dims\": " + r3.getDims() + ",\n            \"createIfMissing\": " + r3.getCreateIfMissing() + ",\n            \"errorIfExists\": " + r3.getErrorIfExists() + ",\n            \"compressLevel\": " + r3.getCompressLevel() + ",\n            \"kvEngine\": " + r3.getKvEngine().getData() + ",\n            \"indexCfg\": " + formatOptStr(r3.getIndexCfg()) + " \n        }";
    }

    public final String formatOptStr(DbIndexConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "opt");
        return "{\n            \"strategy\" : " + r2.getStrategy().getData() + ",\n            \"metricType\" : " + r2.getMetricType().getData() + ",\n            \"searchProbe\" : " + r2.getSearchProbe() + ",\n            \"downgradeLimit\" : " + r2.getDowngradeLimit() + ",\n            \"upgradeLimit\" : " + r2.getUpgradeLimit() + ",\n            \"ivfNodeMin\" : " + r2.getIvfNodeMin() + ",\n            \"ivfNodeMax\" : " + r2.getIvfNodeMax() + ",\n            \"bspNodeSize\" : " + r2.getBspNodeSize() + ",\n            \"pqSubDim\": " + r2.getPqSubDim() + ",\n            \"pqTrainInsert\": " + r2.getPqTrainInsert() + "\n        }";
    }

    public final String formatOptStr(DbSearchOption r11) {
        Intrinsics.checkNotNullParameter(r11, "opt");
        StringBuilder r10 = new StringBuilder("{\n            \"searchProbe\" : ").append(r11.getSearchProbe()).append(",\n            ").append(formatOptionalFloat("searchProbeFilter", Float.valueOf(r11.getSearchProbeFilter()))).append("\n            ").append(formatOptionalFloat("distFilter", Float.valueOf(r11.getDistFilter()))).append("\n            \"normalize\" : ").append(r11.getNormalize()).append(",\n            \"filters\" : [");
        String[] r12 = r11.getFilters();
        ArrayList r0 = new ArrayList(r12.length);
        int r1 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add("\"" + r12[r2] + '\"');
        r2 = r2 + 1;
        goto L3
    L6:
        return r10.append(CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, null, 62, null)).append("]\n        }").toString();
    }

    public final DbInfo parseDbInfo(String r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        JSONObject r6 = new JSONObject(r7);     // Catch: Exception -> L5
        return new DbInfo(r6.getInt("dims"), r6.getInt("kvType"), r6.getInt("viewType"), r6.getInt("bankType"), r6.getInt("metricType"));
    L5:
        return null;
    }

    public static /* synthetic */ DbObjResult getKeys$default(long r1, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = "";
    L9:
        return getKeys(r1, r3, r4);
    }
}
