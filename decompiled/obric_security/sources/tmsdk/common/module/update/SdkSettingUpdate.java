package tmsdk.common.module.update;

import android.text.TextUtils;
import com.obric.oui.calendar.format.DayFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.TMSDKContext;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdkobf.j2;
import tmsdkobf.k2;
import tmsdkobf.mg;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002+,B\t\b\u0002¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Ltmsdk/common/module/update/SdkSettingUpdate;", "", "", "a", "", "getMobileModelSpEN", "getMobileModelSysEN", "", "getScannerCacheInterval", "getScannerCacheSha1", "getScannerCacheSha256", "getVirusHashAPP", "getVirusHashAPK", "getVirusGetHashWayApp", "updateSdkSetting", "parserSDKSettingUpdate", "Z", "mMobileModelSpEN", "b", "mMobileModelSysEN", "c", "I", "mScannerCacheInterval", DayFormatter.DEFAULT_FORMAT, "mScannerCacheSwitchSha1", "e", "mScannerCacheSwitchSha256", "f", "mVirusHashAPP", "g", "mVirusHashAPK", "h", "mVirusGetHashWayApp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsCache", "", "j", "J", "mCacheTime", "<init>", "()V", "VirusCloudType", "VirusGetHashWayApp", "tmsdk_release"}, k = 1, mv = {1, 7, 1})
public final class SdkSettingUpdate {
    public static final SdkSettingUpdate INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f54a;
    private static boolean b;
    private static int c;
    private static boolean d;
    private static boolean e;
    private static int f;
    private static int g;
    private static int h;
    private static AtomicBoolean i;
    private static long j;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ltmsdk/common/module/update/SdkSettingUpdate$VirusCloudType;", "", "", "a", "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "ONLY_MD_5", "ONLY_SHA256", "BOTH_HASH", "tmsdk_release"}, k = 1, mv = {1, 7, 1})
    public static final enum VirusCloudType extends Enum<VirusCloudType> {
        public static final VirusCloudType BOTH_HASH = null;
        public static final VirusCloudType ONLY_MD_5 = null;
        public static final VirusCloudType ONLY_SHA256 = null;
        private static final /* synthetic */ VirusCloudType[] b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f55a;

        static {
            ONLY_MD_5 = new VirusCloudType("ONLY_MD_5", 0, 1);
            ONLY_SHA256 = new VirusCloudType("ONLY_SHA256", 1, 2);
            BOTH_HASH = new VirusCloudType("BOTH_HASH", 2, 3);
            b = a();
        }

        private VirusCloudType(String r1, int r2, int r3) {
            super(r1, r2);
            this.f55a = r3;
        }

        private static final /* synthetic */ VirusCloudType[] a() {
            return new VirusCloudType[]{ONLY_MD_5, ONLY_SHA256, BOTH_HASH};
        }

        public static VirusCloudType valueOf(String r1) {
            return (VirusCloudType) Enum.valueOf(VirusCloudType.class, r1);
        }

        public static VirusCloudType[] values() {
            return (VirusCloudType[]) b.clone();
        }

        public final int getValue() {
            return this.f55a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ltmsdk/common/module/update/SdkSettingUpdate$VirusGetHashWayApp;", "", "", "a", "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "WAY_JAR", "WAY_SYS", "tmsdk_release"}, k = 1, mv = {1, 7, 1})
    public static final enum VirusGetHashWayApp extends Enum<VirusGetHashWayApp> {
        public static final VirusGetHashWayApp WAY_JAR = null;
        public static final VirusGetHashWayApp WAY_SYS = null;
        private static final /* synthetic */ VirusGetHashWayApp[] b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f56a;

        static {
            WAY_JAR = new VirusGetHashWayApp("WAY_JAR", 0, 1);
            WAY_SYS = new VirusGetHashWayApp("WAY_SYS", 1, 2);
            b = a();
        }

        private VirusGetHashWayApp(String r1, int r2, int r3) {
            super(r1, r2);
            this.f56a = r3;
        }

        private static final /* synthetic */ VirusGetHashWayApp[] a() {
            return new VirusGetHashWayApp[]{WAY_JAR, WAY_SYS};
        }

        public static VirusGetHashWayApp valueOf(String r1) {
            return (VirusGetHashWayApp) Enum.valueOf(VirusGetHashWayApp.class, r1);
        }

        public static VirusGetHashWayApp[] values() {
            return (VirusGetHashWayApp[]) b.clone();
        }

        public final int getValue() {
            return this.f56a;
        }
    }

    static {
        INSTANCE = new SdkSettingUpdate();
        f54a = true;
        b = true;
        c = 7;
        VirusCloudType r0 = VirusCloudType.BOTH_HASH;
        f = r0.getValue();
        g = r0.getValue();
        h = VirusGetHashWayApp.WAY_JAR.getValue();
        i = new AtomicBoolean(false);
    }

    private SdkSettingUpdate() {
    }

    private final void a() {
        if (i.getAndSet(true) == true) goto L5;
    L6:
        parserSDKSettingUpdate();
        return;
    L5:
        if (Math.abs(System.currentTimeMillis() - j) > 86400000) goto L6;
    }

    public final boolean getMobileModelSpEN() {
        a();
        return f54a;
    }

    public final boolean getMobileModelSysEN() {
        a();
        return b;
    }

    public final int getScannerCacheInterval() {
        a();
        return c;
    }

    public final boolean getScannerCacheSha1() {
        a();
        return d;
    }

    public final boolean getScannerCacheSha256() {
        a();
        return e;
    }

    public final int getVirusGetHashWayApp() {
        a();
        return h;
    }

    public final int getVirusHashAPK() {
        a();
        return g;
    }

    public final int getVirusHashAPP() {
        a();
        return f;
    }

    public final void parserSDKSettingUpdate() {
        j = System.currentTimeMillis();
        k2 r7 = (k2) mg.b(TMSDKContext.getApplicaionContext(), UpdateConfig.intToString(42600) + ".dat", UpdateConfig.intToString(42600), new k2(), "UTF-8");
        if (r7 == null) goto L5;
        ArrayList r0 = r7.f299a;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        Iterator r8 = r7.f299a.iterator();
    L10:
        if (r8.hasNext() == false) goto L77;
        j2 r1 = (j2) r8.next();
        if (r1 == null) goto L10;
        if (TextUtils.isEmpty(r1.f281a) == true) goto L10;
        if (TextUtils.isEmpty(r1.b) == true) goto L10;
        if (TextUtils.equals(r1.f281a, "1") == true) goto L21;
        if (TextUtils.equals(r1.f281a, "2") == false) goto L10;
        if (TextUtils.equals(r1.b, "1") == false) goto L52;
        Integer r2 = Integer.valueOf(r1.c);     // Catch: Throwable -> L78
        Intrinsics.checkNotNullExpressionValue(r2, "valueOf(info.data3)");     // Catch: Throwable -> L78
        c = r2.intValue();     // Catch: Throwable -> L78
    L40:
        if (TextUtils.equals(r1.d, "1") == false) goto L43;
        d = true;
    L46:
        if (TextUtils.equals(r1.e, "1") == true) goto L47;
        if (TextUtils.equals(r1.e, "0") == false) goto L10;
        e = false;
        goto L10
    L47:
        e = true;
        goto L10
    L43:
        if (TextUtils.equals(r1.d, "0") == false) goto L46;
        d = false;
        goto L46
    L52:
        if (TextUtils.equals(r1.b, "2") == false) goto L10;
        if (TextUtils.equals(r1.c, "1") == false) goto L57;
        f = VirusCloudType.ONLY_MD_5.getValue();
    L63:
        if (TextUtils.equals(r1.d, "1") == false) goto L66;
        g = VirusCloudType.ONLY_MD_5.getValue();
    L72:
        if (TextUtils.equals(r1.e, "1") == true) goto L73;
        if (TextUtils.equals(r1.e, "2") == false) goto L10;
        h = VirusGetHashWayApp.WAY_SYS.getValue();
        goto L10
    L73:
        h = VirusGetHashWayApp.WAY_JAR.getValue();
        goto L10
    L66:
        if (TextUtils.equals(r1.d, "2") == false) goto L69;
        g = VirusCloudType.ONLY_SHA256.getValue();
        goto L72
    L69:
        if (TextUtils.equals(r1.d, "3") == false) goto L72;
        g = VirusCloudType.BOTH_HASH.getValue();
        goto L72
    L57:
        if (TextUtils.equals(r1.c, "2") == false) goto L60;
        f = VirusCloudType.ONLY_SHA256.getValue();
        goto L63
    L60:
        if (TextUtils.equals(r1.c, "3") == false) goto L63;
        f = VirusCloudType.BOTH_HASH.getValue();
        goto L63
    L21:
        if (TextUtils.equals(r1.b, "1") == false) goto L10;
        if (TextUtils.equals(r1.c, "1") == false) goto L26;
        f54a = true;
    L29:
        if (TextUtils.equals(r1.d, "1") == true) goto L30;
        if (TextUtils.equals(r1.d, "0") == false) goto L10;
        b = false;
        goto L10
    L30:
        b = true;
        goto L10
    L26:
        if (TextUtils.equals(r1.c, "0") == false) goto L29;
        f54a = false;
        goto L29
    L77:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void updateSdkSetting() {
        final UpdateManager r0 = (UpdateManager) ManagerCreatorC.getManager(UpdateManager.class);     // Catch: Throwable -> L5
        r0.check(32, new AnonymousClass1(r0), -1);     // Catch: Throwable -> L5
        return;
    }
}
