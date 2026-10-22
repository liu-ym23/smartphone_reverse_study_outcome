package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0017R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "delegate", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "getDelegate", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "lazyDelegate", "Lkotlin/Lazy;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "writeAheadLoggingEnabled", "close", "", "setWriteAheadLoggingEnabled", "enabled", "Companion", "DBRefHolder", "OpenHelper", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static final Companion Companion = null;
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;
    private final SupportSQLiteOpenHelper.Callback callback;
    private final Context context;
    private final Lazy<OpenHelper> lazyDelegate;
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$Companion;", "", "()V", "TAG", "", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "", CloudControlInf.DB, "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "(Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;)V", "getDb", "()Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "setDb", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class DBRefHolder {
        private FrameworkSQLiteDatabase db;

        public DBRefHolder(FrameworkSQLiteDatabase r1) {
            this.db = r1;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(FrameworkSQLiteDatabase r1) {
            this.db = r1;
        }
    }

    /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 /2\u00020\u0001:\u0003-./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J \u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "dbRef", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "allowDataLossOnRecovery", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;Z)V", "getAllowDataLossOnRecovery", "()Z", "getCallback", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "getContext", "()Landroid/content/Context;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "lock", "Landroidx/sqlite/util/ProcessLock;", "migrated", "opened", "close", "", "getSupportDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "writable", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableOrReadableDatabase", "innerGetDatabase", "onConfigure", CloudControlInf.DB, "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "CallbackException", "CallbackName", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class OpenHelper extends SQLiteOpenHelper {
        public static final Companion Companion = null;
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        private static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }

            public CallbackException(CallbackName r2, Throwable r3) {
                Intrinsics.checkNotNullParameter(r2, "callbackName");
                Intrinsics.checkNotNullParameter(r3, "cause");
                super(r3);
                this.callbackName = r2;
                this.cause = r3;
            }
        }

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final enum CallbackName extends Enum<CallbackName> {
            private static final /* synthetic */ CallbackName[] $VALUES = null;
            public static final CallbackName ON_CONFIGURE = null;
            public static final CallbackName ON_CREATE = null;
            public static final CallbackName ON_DOWNGRADE = null;
            public static final CallbackName ON_OPEN = null;
            public static final CallbackName ON_UPGRADE = null;

            private static final /* synthetic */ CallbackName[] $values() {
                return new CallbackName[]{ON_CONFIGURE, ON_CREATE, ON_UPGRADE, ON_DOWNGRADE, ON_OPEN};
            }

            public static CallbackName valueOf(String r1) {
                return (CallbackName) Enum.valueOf(CallbackName.class, r1);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }

            private CallbackName(String r1, int r2) {
                super(r1, r2);
            }

            static {
                ON_CONFIGURE = new CallbackName("ON_CONFIGURE", 0);
                ON_CREATE = new CallbackName("ON_CREATE", 1);
                ON_UPGRADE = new CallbackName("ON_UPGRADE", 2);
                ON_DOWNGRADE = new CallbackName("ON_DOWNGRADE", 3);
                ON_OPEN = new CallbackName("ON_OPEN", 4);
                $VALUES = $values();
            }
        }

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion;", "", "()V", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "refHolder", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder r2, SQLiteDatabase r3) {
                Intrinsics.checkNotNullParameter(r2, "refHolder");
                Intrinsics.checkNotNullParameter(r3, "sqLiteDatabase");
                FrameworkSQLiteDatabase r1 = r2.getDb();
                if (r1 != null) goto L5;
            L6:
                FrameworkSQLiteDatabase r4 = new FrameworkSQLiteDatabase(r3);
                r2.setDb(r4);
                return r4;
            L5:
                if (r1.isDelegate(r3) == false) goto L6;
                return r1;
            }
        }

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[CallbackName.values().length];
                r0[CallbackName.ON_CONFIGURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[CallbackName.ON_CREATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[CallbackName.ON_UPGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[CallbackName.ON_DOWNGRADE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[CallbackName.ON_OPEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public static /* synthetic */ void $r8$lambda$wesXNSdtx2gMKZWCPManFjtpLB8(SupportSQLiteOpenHelper.Callback r0, DBRefHolder r1, SQLiteDatabase r2) {
            _init_$lambda$0(r0, r1, r2);
        }

        static {
            Companion = new Companion(null);
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        public OpenHelper(Context r8, String r9, final DBRefHolder r10, final SupportSQLiteOpenHelper.Callback r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r10, "dbRef");
            Intrinsics.checkNotNullParameter(r11, "callback");
            super(r8, r9, null, r11.version, new FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0(r11, r10));
            this.context = r8;
            this.dbRef = r10;
            this.callback = r11;
            this.allowDataLossOnRecovery = r12;
            if (r9 != null) goto L5;
            r9 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r9, "randomUUID().toString()");
        L5:
            File r13 = r8.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(r13, "context.cacheDir");
            this.lock = new ProcessLock(r9, r13, false);
        }

        private static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback r2, DBRefHolder r3, SQLiteDatabase r4) {
            Intrinsics.checkNotNullParameter(r2, "$callback");
            Intrinsics.checkNotNullParameter(r3, "$dbRef");
            Companion r0 = Companion;
            Intrinsics.checkNotNullExpressionValue(r4, "dbObj");
            r2.onCorruption(r0.getWrappedDb(r3, r4));
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean r4) {
            ProcessLock r0 = this.lock;     // Catch: Throwable -> L16
            if (this.opened == false) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.lock(r1);     // Catch: Throwable -> L16
            this.migrated = false;     // Catch: Throwable -> L16
            SQLiteDatabase r2 = innerGetDatabase(r4);     // Catch: Throwable -> L16
            if (this.migrated == false) goto L13;
            close();     // Catch: Throwable -> L16
            SupportSQLiteDatabase r5 = getSupportDatabase(r4);     // Catch: Throwable -> L16
            this.lock.unlock();
            return r5;
        L13:
            FrameworkSQLiteDatabase r6 = getWrappedDb(r2);     // Catch: Throwable -> L16
            this.lock.unlock();
            return r6;
        L5:
            if (getDatabaseName() == null) goto L7;
            r1 = true;
        L16:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        private final SQLiteDatabase innerGetDatabase(boolean r5) {
            String r0 = getDatabaseName();
            if (r0 == null) goto L47;
            File r1 = this.context.getDatabasePath(r0).getParentFile();
            if (r1 == null) goto L47;
            r1.mkdirs();
            if (r1.isDirectory() == true) goto L47;
            Log.w(FrameworkSQLiteOpenHelper.TAG, "Invalid database parent file, not a directory: " + r1);
        L47:
            return getWritableOrReadableDatabase(r5);
        L11:
            super.close();
            Thread.sleep(500);     // Catch: InterruptedException -> L44
        L45:
            return getWritableOrReadableDatabase(r5);
        L15:
            th = move-exception;
            super.close();
            if ((th instanceof CallbackException) == false) goto L32;
            CallbackException r2 = th;
            Throwable r3 = r2.getCause();
            int r4 = WhenMappings.$EnumSwitchMapping$0[r2.getCallbackName().ordinal()];
            if (r4 != 1) goto L21;
            throw r3;
        L21:
            if (r4 != 2) goto L23;
            throw r3;
        L23:
            if (r4 != 3) goto L25;
            throw r3;
        L25:
            if (r4 != 4) goto L27;
            throw r3;
        L27:
            if ((r3 instanceof SQLiteException) == true) goto L36;
            throw r3;
        L36:
            this.context.deleteDatabase(r0);
            return getWritableOrReadableDatabase(r5);
        L39:
            e = move-exception;
            throw e.getCause();
        L32:
            if ((th instanceof SQLiteException) == false) goto L43;
            if (r0 != null) goto L35;
        L42:
            throw th;
        L35:
            if (this.allowDataLossOnRecovery == false) goto L42;
        L43:
            throw th;
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean r2) {
            if (r2 == false) goto L5;
            SQLiteDatabase r1 = super.getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(r1, "{\n                super.…eDatabase()\n            }");
            return r1;
        L5:
            SQLiteDatabase r3 = super.getReadableDatabase();
            Intrinsics.checkNotNullExpressionValue(r3, "{\n                super.…eDatabase()\n            }");
            return r3;
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter(r2, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, r2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter(r2, "sqLiteDatabase");
            this.callback.onCreate(getWrappedDb(r2));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CREATE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "sqLiteDatabase");
            this.migrated = true;
            this.callback.onUpgrade(getWrappedDb(r2), r3, r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_UPGRADE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
            this.callback.onConfigure(getWrappedDb(r2));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CONFIGURE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
            this.migrated = true;
            this.callback.onDowngrade(getWrappedDb(r2), r3, r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
            if (this.migrated == false) goto L11;
        L9:
            this.opened = true;
            return;
        L11:
            this.callback.onOpen(getWrappedDb(r2));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_OPEN, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            ProcessLock.lock$default(this.lock, false, 1, null);     // Catch: Throwable -> L5
            super.close();     // Catch: Throwable -> L5
            this.dbRef.setDb(null);     // Catch: Throwable -> L5
            this.opened = false;     // Catch: Throwable -> L5
            this.lock.unlock();
            return;
        L5:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FrameworkSQLiteOpenHelper(Context r10, String r11, SupportSQLiteOpenHelper.Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this(r10, r11, r12, false, false, 24, null);
    }

    public FrameworkSQLiteOpenHelper(Context r10, String r11, SupportSQLiteOpenHelper.Callback r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this(r10, r11, r12, r13, false, 16, null);
    }

    public FrameworkSQLiteOpenHelper(Context r2, String r3, SupportSQLiteOpenHelper.Callback r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.context = r2;
        this.name = r3;
        this.callback = r4;
        this.useNoBackupDirectory = r5;
        this.allowDataLossOnRecovery = r6;
        this.lazyDelegate = LazyKt.lazy(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context r8, String r9, SupportSQLiteOpenHelper.Callback r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r13 & 16) == 0) goto L9;
        boolean r6 = false;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public static final /* synthetic */ boolean access$getAllowDataLossOnRecovery$p(FrameworkSQLiteOpenHelper r0) {
        return r0.allowDataLossOnRecovery;
    }

    public static final /* synthetic */ SupportSQLiteOpenHelper.Callback access$getCallback$p(FrameworkSQLiteOpenHelper r0) {
        return r0.callback;
    }

    public static final /* synthetic */ Context access$getContext$p(FrameworkSQLiteOpenHelper r0) {
        return r0.context;
    }

    public static final /* synthetic */ String access$getName$p(FrameworkSQLiteOpenHelper r0) {
        return r0.name;
    }

    public static final /* synthetic */ boolean access$getUseNoBackupDirectory$p(FrameworkSQLiteOpenHelper r0) {
        return r0.useNoBackupDirectory;
    }

    public static final /* synthetic */ boolean access$getWriteAheadLoggingEnabled$p(FrameworkSQLiteOpenHelper r0) {
        return r0.writeAheadLoggingEnabled;
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper r0) {
        return r0.lazyDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r2) {
        if (this.lazyDelegate.isInitialized() == false) goto L5;
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), r2);
    L5:
        this.writeAheadLoggingEnabled = r2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.lazyDelegate.isInitialized() == false) goto L6;
        getDelegate().close();
        return;
    }
}
