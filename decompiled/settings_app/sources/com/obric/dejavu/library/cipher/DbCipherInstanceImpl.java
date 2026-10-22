package com.obric.dejavu.library.cipher;

import adcpeJava.adcpe.Ciphertext;
import adcpeJava.adcpe.Decryptor;
import adcpeJava.adcpe.Encryptor;
import adcpeJava.adcpe.SecretKey;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.google.gson.Gson;
import com.obric.dejavu.library.DbIndexConfig;
import com.obric.dejavu.library.DbInfo;
import com.obric.dejavu.library.DbInstance;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbOptions;
import com.obric.dejavu.library.DbSearchOption;
import com.obric.dejavu.library.DbStatus;
import com.obric.dejavu.library.jni.DbInstanceImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbCipherInstanceImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 G2\u00020\u0001:\u0001GB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\u0012\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\u001f0\u001ej\u0002` H\u0016J(\u0010!\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\"0\u001ej\u0002`#2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010'\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0018H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016JM\u0010-\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020/0.0\"0\"0\u001ej\u0002`02\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\"2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0002\u00106J \u0010-\u001a\u0002072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0018H\u0016J\u0010\u0010:\u001a\u0002072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010;\u001a\u00020\u0012H\u0016J\u0018\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u000eH\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010\u00142\u0006\u0010B\u001a\u00020CH\u0002J\u001a\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstanceImpl;", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "dbInstance", "Lcom/obric/dejavu/library/DbInstance;", "cryptoOpt", "Lcom/obric/dejavu/library/cipher/CryptoOptions;", "encryptor", "LadcpeJava/adcpe/Encryptor;", "decryptor", "LadcpeJava/adcpe/Decryptor;", "(Lcom/obric/dejavu/library/DbInstance;Lcom/obric/dejavu/library/cipher/CryptoOptions;LadcpeJava/adcpe/Encryptor;LadcpeJava/adcpe/Decryptor;)V", "gson", "Lcom/google/gson/Gson;", "clear", "Lcom/obric/dejavu/library/DbStatus;", "close", "", "dims", "", "doubleArray2FloatArray", "", "doubleArray", "", "exists", "", "key", "", "floatArray2DoubleArray", "floatArray", "getDbInfo", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInfo;", "Lcom/obric/dejavu/library/DbInfoResult;", "getKeys", "", "Lcom/obric/dejavu/library/DbKeysResult;", "start", TraceStatsConsts.STATS_KEY_END, "getProperty", "insert", "vec", "value", "normalize", "name", "remove", "search", "Lkotlin/Pair;", "", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", "", "opt", "Lcom/obric/dejavu/library/DbSearchOption;", "([[FILcom/obric/dejavu/library/DbSearchOption;)Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", "searchAndDecrypt", PerfConsts.PERF_DISK_FILE_SIZE, "updateIndexConfig", "cfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "rebuildNow", "validate", "vecDecrypt", "ciphertext", "LadcpeJava/adcpe/Ciphertext;", "vecEncrypt", "plainVec", "isFixed", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbCipherInstanceImpl extends DbCipherInstance {
    public static final Companion Companion = null;
    private static final String TAG = "DbCipherInstanceImpl";
    private CryptoOptions cryptoOpt;
    private final DbInstance dbInstance;
    private Decryptor decryptor;
    private Encryptor encryptor;
    private final Gson gson;

    /* JADX INFO: compiled from: DbCipherInstanceImpl.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ0\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstanceImpl$Companion;", "", "()V", "TAG", "", "openDb", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "Lcom/obric/dejavu/library/cipher/DbCipherOpenResult;", "context", "Landroid/content/Context;", "dirPrefix", "opt", "Lcom/obric/dejavu/library/DbOptions;", "cryptoOpt", "Lcom/obric/dejavu/library/cipher/CryptoOptions;", "dbName", "removeDb", "Lcom/obric/dejavu/library/DbStatus;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final DbObjResult<DbCipherInstance> openDb(Context r5, String r6, DbOptions r7, CryptoOptions r8) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "dirPrefix");
            Intrinsics.checkNotNullParameter(r7, "opt");
            Intrinsics.checkNotNullParameter(r8, "cryptoOpt");
            DbStatus r4 = DbCipherUtils.Companion.checkCryptoOptions(r8);
            if (Intrinsics.areEqual(r4, DbStatus.Companion.getSuccess()) == true) goto L6;
            Log.e(DbCipherInstanceImpl.TAG, "code: " + r4.getCode() + ", msg: " + r4.getMsg());
            return new DbObjResult(r4, null);
        L6:
            DbObjResult<DbInstance> r9 = DbInstanceImpl.Companion.openDb(r6, r7);
            if (Intrinsics.areEqual(r9.getStatus(), DbStatus.Companion.getSuccess()) == true) goto L11;
            Log.e(DbCipherInstanceImpl.TAG, "code: " + r9.getStatus().getCode() + ", msg: " + r9.getStatus().getMsg());
            return new DbObjResult(r9.getStatus(), null);
        L11:
            if (r9.getData() == null) goto L13;
            SecretKey r10 = SecretKey.fromSeed(r8.getSeed(), (int) r9.getData().dims(), r8.getAlgVersion());
            Intrinsics.checkNotNullExpressionValue(r10, "fromSeed(cryptoOpt.seed,…(), cryptoOpt.algVersion)");
            SecretKey r11 = SecretKey.fromSeed(r8.getSeed(), (int) r9.getData().dims(), r8.getAlgVersion());
            Intrinsics.checkNotNullExpressionValue(r11, "fromSeed(cryptoOpt.seed,…(), cryptoOpt.algVersion)");
            Encryptor r12 = new Encryptor(r10, r8.getApproxFactor());
            Decryptor r13 = new Decryptor(r11, r8.getApproxFactor());
            return new DbObjResult(r9.getStatus(), new DbCipherInstanceImpl(r9.getData(), new CryptoOptions(r8.getApproxFactor(), r8.getSeed(), r8.getAlgVersion()), r12, r13));
        L13:
            return new DbObjResult(DbCipherErrors.INSTANCE.getERR_DB_DATA_NULL(), null);
        }

        public final DbObjResult<DbCipherInstance> openDb(Context r5, String r6, String r7, CryptoOptions r8) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "dirPrefix");
            Intrinsics.checkNotNullParameter(r7, "dbName");
            Intrinsics.checkNotNullParameter(r8, "cryptoOpt");
            DbStatus r4 = DbCipherUtils.Companion.checkCryptoOptions(r8);
            if (Intrinsics.areEqual(r4, DbStatus.Companion.getSuccess()) == true) goto L6;
            Log.e(DbCipherInstanceImpl.TAG, "code: " + r4.getCode() + ", msg: " + r4.getMsg());
            return new DbObjResult(r4, null);
        L6:
            DbObjResult<DbInstance> r9 = DbInstanceImpl.Companion.openDb(r6, r7);
            if (Intrinsics.areEqual(r9.getStatus(), DbStatus.Companion.getSuccess()) == true) goto L11;
            Log.e(DbCipherInstanceImpl.TAG, "code: " + r9.getStatus().getCode() + ", msg: " + r9.getStatus().getMsg());
            return new DbObjResult(r9.getStatus(), null);
        L11:
            if (r9.getData() == null) goto L13;
            SecretKey r10 = SecretKey.fromSeed(r8.getSeed(), (int) r9.getData().dims(), r8.getAlgVersion());
            Intrinsics.checkNotNullExpressionValue(r10, "fromSeed(cryptoOpt.seed,…(), cryptoOpt.algVersion)");
            SecretKey r11 = SecretKey.fromSeed(r8.getSeed(), (int) r9.getData().dims(), r8.getAlgVersion());
            Intrinsics.checkNotNullExpressionValue(r11, "fromSeed(cryptoOpt.seed,…(), cryptoOpt.algVersion)");
            Encryptor r12 = new Encryptor(r10, r8.getApproxFactor());
            Decryptor r13 = new Decryptor(r11, r8.getApproxFactor());
            return new DbObjResult(r9.getStatus(), new DbCipherInstanceImpl(r9.getData(), new CryptoOptions(r8.getApproxFactor(), r8.getSeed(), r8.getAlgVersion()), r12, r13));
        L13:
            return new DbObjResult(DbCipherErrors.INSTANCE.getERR_DB_DATA_NULL(), null);
        }

        public final DbStatus removeDb(Context r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "dirPrefix");
            Intrinsics.checkNotNullParameter(r3, "dbName");
            return DbInstanceImpl.Companion.removeDb(r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DbCipherInstanceImpl(DbInstance r2, CryptoOptions r3, Encryptor r4, Decryptor r5) {
        Intrinsics.checkNotNullParameter(r2, "dbInstance");
        Intrinsics.checkNotNullParameter(r3, "cryptoOpt");
        Intrinsics.checkNotNullParameter(r4, "encryptor");
        Intrinsics.checkNotNullParameter(r5, "decryptor");
        this.dbInstance = r2;
        this.cryptoOpt = r3;
        this.encryptor = r4;
        this.decryptor = r5;
        this.gson = new Gson();
    }

    private final double[] floatArray2DoubleArray(float[] r5) {
        int r4 = r5.length;
        double[] r0 = new double[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = r5[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private final float[] doubleArray2FloatArray(double[] r5) {
        int r4 = r5.length;
        float[] r0 = new float[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = (float) r5[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private final Ciphertext vecEncrypt(float[] r1, boolean r2) {
        double[] r3 = floatArray2DoubleArray(r1);
        if (r2 == false) goto L5;
        Ciphertext r0 = this.encryptor.deterministicallyEncrypt(r3);     // Catch: Exception -> L7
    L10:
        return r0;
    L5:
        r0 = this.encryptor.encrypt(r3);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "catch Exception: " + e.getMessage());
        Ciphertext r4 = (Ciphertext) null;
        return null;
    }

    private final float[] vecDecrypt(Ciphertext r4) {
        double[] r5 = this.decryptor.decrypt(r4);     // Catch: Exception -> L5
    L7:
        if (r5 != null) goto L9;
        return null;
    L9:
        return doubleArray2FloatArray(r5);
    L5:
        e = move-exception;
        Log.e(TAG, "catch Exception: " + e.getMessage());
        double[] r6 = (double[]) null;
        r5 = null;
        goto L7
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus insert(String r4, float[] r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        float[] r0 = null;
        if (r5 == null) goto L5;
        Ciphertext r8 = vecEncrypt(r5, false);
    L7:
        if (r8 == null) goto L9;
        String r2 = r8.nAndNormHexStr();
    L10:
        DbCipherExtraInfo r1 = new DbCipherExtraInfo(r6, r2);
        DbInstance r9 = this.dbInstance;
        if (r8 == null) goto L13;
        r0 = r8.floatNormalizedC();
    L13:
        String r3 = this.gson.toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "gson.toJson(extraInfo)");
        return r9.insert(r4, r0, r3, r7);
    L9:
        r2 = null;
        goto L10
    L5:
        Ciphertext r10 = (Ciphertext) null;
        r8 = null;
        goto L7
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbKvResult search(String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 == false) goto L5;
        DbKvResult r5 = this.dbInstance.search(r2, true, r4);
        if (Intrinsics.areEqual(r5.getStatus(), DbStatus.Companion.getSuccess()) == true) goto L9;
        return r5;
    L9:
        String r6 = null;
        String r7 = r5.getValue();     // Catch: Exception -> L16
        if (r7 == null) goto L19;
        DbCipherExtraInfo r1 = (DbCipherExtraInfo) this.gson.fromJson(r7, DbCipherExtraInfo.class);     // Catch: Exception -> L16
        if (r1 == null) goto L19;
        r6 = r1.getValue();     // Catch: Exception -> L16
    L19:
        return new DbKvResult(r5.getStatus(), r5.getVec(), r6);
    L16:
        e = move-exception;
        Log.e(TAG, "Failed to parse JSON: " + r5.getValue() + " catch Exception: " + e.getMessage());
        String r8 = (String) null;
        goto L19
    L5:
        return this.dbInstance.search(r2, false, r4);
    }

    @Override // com.obric.dejavu.library.cipher.DbCipherInstance
    public DbKvResult searchAndDecrypt(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        DbKvResult r7 = this.dbInstance.search(r6, true, true);
        DbStatus r0 = r7.getStatus();
        if (Intrinsics.areEqual(r0, DbStatus.Companion.getSuccess()) == true) goto L6;
        Log.e(TAG, "code: " + r0.getCode() + ", msg: " + r0.getMsg());
        return r7;
    L6:
        float[] r1 = r7.getVec();
        String r8 = r7.getValue();
        String r2 = null;
        if (r8 != null) goto L29;
    L12:
        DbCipherExtraInfo r9 = null;
    L13:
        if (r1 == null) goto L18;
        if (r9 == null) goto L18;
        String r3 = r9.getNAndNormHex();
        if (r3 == null) goto L18;
        Ciphertext r4 = Ciphertext.fromNAndNormHexStr(r1, r3);
    L19:
        if (r4 == null) goto L21;
        float[] r5 = vecDecrypt(r4);
    L22:
        if (r5 != null) goto L24;
        Log.e(TAG, "plainVec is null");
        return new DbKvResult(DbCipherErrors.INSTANCE.getERR_DECRYPT_VEC(), null, null);
    L24:
        DbStatus r10 = DbStatus.Companion.getSuccess();
        if (r9 == null) goto L28;
        r2 = r9.getValue();
    L28:
        return new DbKvResult(r10, r5, r2);
    L21:
        r5 = null;
    L18:
        r4 = null;
        goto L19
    L29:
        r9 = (DbCipherExtraInfo) this.gson.fromJson(r8, DbCipherExtraInfo.class);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e(TAG, "catch Exception: " + e.getMessage());
        DbCipherExtraInfo r11 = (DbCipherExtraInfo) null;
        goto L12
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbObjResult<Pair<String, Float>[][]> search(float[][] r7, int r8, DbSearchOption r9) {
        Intrinsics.checkNotNullParameter(r7, "vecs");
        Intrinsics.checkNotNullParameter(r9, "opt");
        float[][] r10 = r7;
        ArrayList r0 = new ArrayList(r10.length);
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        Ciphertext r4 = vecEncrypt(r10[r3], true);
        if (r4 == null) goto L7;
        float[] r5 = r4.floatC();
    L8:
        if (r5 != null) goto L10;
        r5 = new float[0];
    L11:
        r0.add(r5);
        r3 = r3 + 1;
        goto L3
    L10:
        Intrinsics.checkNotNullExpressionValue(r5, "vecEncrypt(vec, true)?.floatC() ?: FloatArray(0)");
        goto L11
    L7:
        r5 = null;
        goto L8
    L12:
        Object[] r11 = r0.toArray(new float[0][]);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return this.dbInstance.search((float[][]) r11, r8, r9);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbObjResult<String[]> getKeys(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "start");
        Intrinsics.checkNotNullParameter(r3, TraceStatsConsts.STATS_KEY_END);
        return this.dbInstance.getKeys(r2, r3);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus remove(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.dbInstance.remove(r2);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus clear() {
        return this.dbInstance.clear();
    }

    @Override // com.obric.dejavu.library.DbInstance
    public boolean exists(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.dbInstance.exists(r2);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public long size() {
        return this.dbInstance.size();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Log.d(TAG, "DbCipherInstanceImpl close in");
        this.cryptoOpt.setSeed("");
        this.cryptoOpt.setApproxFactor(0.1d);
        this.dbInstance.close();
    }

    @Override // com.obric.dejavu.library.DbInstance
    public long dims() {
        return this.dbInstance.dims();
    }

    @Override // com.obric.dejavu.library.DbInstance
    public String name() {
        return this.dbInstance.name();
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus validate() {
        return this.dbInstance.validate();
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus updateIndexConfig(DbIndexConfig r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "cfg");
        return this.dbInstance.updateIndexConfig(r2, r3);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public String getProperty(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.dbInstance.getProperty(r2);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbObjResult<DbInfo> getDbInfo() {
        return this.dbInstance.getDbInfo();
    }
}
