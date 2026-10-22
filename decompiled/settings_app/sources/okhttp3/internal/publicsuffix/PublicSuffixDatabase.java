package okhttp3.internal.publicsuffix;

import com.android.settings.ApnEditor;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: compiled from: PublicSuffixDatabase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", ClientCookie.DOMAIN_ATTR, "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PublicSuffixDatabase {
    public static final Companion Companion = null;
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = null;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = null;
    private static final PublicSuffixDatabase instance = null;
    private final AtomicBoolean listRead;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch;

    /* JADX INFO: compiled from: PublicSuffixDatabase.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ String access$binarySearch(Companion r0, byte[] r1, byte[][] r2, int r3) {
            return r0.binarySearch(r1, r2, r3);
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.access$getInstance$cp();
        }

        private final String binarySearch(byte[] r18, byte[][] r19, int r20) {
            int r1 = r18.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L43;
            int r4 = (r3 + r1) / 2;
        L6:
            if (r4 <= (-1)) goto L10;
            if (r18[r4] == 10) goto L10;
            r4 = r4 - 1;
        L10:
            int r5 = r4 + 1;
            int r8 = 1;
        L11:
            int r9 = r5 + r8;
            if (r18[r9] == 10) goto L14;
            r8 = r8 + 1;
            goto L11
        L14:
            int r6 = r9 - r5;
            int r10 = r20;
            boolean r11 = false;
            int r12 = 0;
            int r13 = 0;
        L16:
            if (r11 == false) goto L18;
            int r14 = 46;
            boolean r15 = false;
        L19:
            int r16 = r14 - Util.and(r18[r5 + r13], 255);
            if (r16 != 0) goto L29;
            r13 = r13 + 1;
            r12 = r12 + 1;
            if (r13 == r6) goto L29;
            if (r19[r10].length == r12) goto L28;
            r11 = r15;
            goto L16
        L28:
            if (r10 == (r19.length - 1)) goto L29;
            r10 = r10 + 1;
            r12 = -1;
            r11 = true;
        L29:
            if (r16 < 0) goto L30;
            if (r16 > 0) goto L32;
            int r7 = r6 - r13;
            int r17 = r19[r10].length - r12;
            int r110 = r10 + 1;
            int r21 = r19.length;
        L34:
            if (r110 >= r21) goto L36;
            r17 = r17 + r19[r110].length;
            r110 = r110 + 1;
            goto L34
        L36:
            if (r17 < r7) goto L30;
            if (r17 > r7) goto L32;
            Charset r2 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(r2, "UTF_8");
            return new String(r18, r5, r6, r2);
        L32:
            r3 = r9 + 1;
        L30:
            r1 = r5 - 1;
            goto L3
        L18:
            r15 = r11;
            r14 = Util.and(r19[r10][r12], 255);
            goto L19
        L43:
            return null;
        }
    }

    public PublicSuffixDatabase() {
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    public static final /* synthetic */ PublicSuffixDatabase access$getInstance$cp() {
        return instance;
    }

    public final String getEffectiveTldPlusOne(String r11) {
        Intrinsics.checkNotNullParameter(r11, ClientCookie.DOMAIN_ATTR);
        String r0 = IDN.toUnicode(r11);
        Intrinsics.checkNotNullExpressionValue(r0, "unicodeDomain");
        List<String> r1 = splitDomain(r0);
        List<String> r2 = findMatchingRule(r1);
        if (r1.size() != r2.size()) goto L9;
        if (r2.get(0).charAt(0) == '!') goto L9;
        return null;
    L9:
        if (r2.get(0).charAt(0) != '!') goto L11;
        int r3 = r1.size();
        int r4 = r2.size();
    L12:
        Sequence r10 = CollectionsKt.asSequence(splitDomain(r11));
        return SequencesKt.joinToString$default(SequencesKt.drop(r10, r3 - r4), ".", null, null, 0, null, null, 62, null);
    L11:
        r3 = r1.size();
        r4 = r2.size() + 1;
        goto L12
    }

    private final List<String> splitDomain(String r7) {
        List<String> r8 = StringsKt.split$default(r7, new char[]{'.'}, false, 0, 6, null);
        if (Intrinsics.areEqual(CollectionsKt.last(r8), "") == true) goto L5;
        return r8;
    L5:
        return CollectionsKt.dropLast(r8, 1);
    }

    private final List<String> findMatchingRule(List<String> r18) {
        if (this.listRead.get() == false) goto L5;
    L77:
        this.readCompleteLatch.await();     // Catch: InterruptedException -> L9
    L11:
        if (this.publicSuffixListBytes == null) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L76;
        int r2 = r18.size();
        byte[][] r4 = new byte[r2][];
        int r5 = 0;
    L16:
        if (r5 >= r2) goto L18;
        String r7 = r18.get(r5);
        Charset r8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(r8, "UTF_8");
        byte[] r9 = r7.getBytes(r8);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).getBytes(charset)");
        r4[r5] = r9;
        r5 = r5 + 1;
        goto L16
    L18:
        byte[][] r3 = r4;
        int r6 = r3.length;
        int r10 = 0;
    L19:
        List<String> r11 = null;
        if (r10 >= r6) goto L28;
        int r12 = r10 + 1;
        Companion r13 = Companion;
        byte[] r14 = this.publicSuffixListBytes;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
        r14 = null;
    L24:
        String r15 = Companion.access$binarySearch(r13, r14, r4, r10);
        if (r15 != null) goto L30;
        r10 = r12;
    L30:
        if (r3.length <= 1) goto L40;
        byte[][] r16 = (byte[][]) r3.clone();
        int r17 = r16.length - 1;
        int r19 = 0;
    L32:
        if (r19 >= r17) goto L40;
        int r110 = r19 + 1;
        r16[r19] = WILDCARD_LABEL;
        Companion r111 = Companion;
        byte[] r112 = this.publicSuffixListBytes;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
        r112 = null;
    L36:
        String r113 = Companion.access$binarySearch(r111, r112, r16, r19);
        if (r113 != null) goto L41;
        r19 = r110;
    L41:
        if (r113 == null) goto L51;
        int r20 = r3.length - 1;
        int r21 = 0;
    L43:
        if (r21 >= r20) goto L51;
        int r22 = r21 + 1;
        Companion r23 = Companion;
        byte[] r114 = this.publicSuffixExceptionListBytes;
        if (r114 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
        r114 = null;
    L47:
        String r24 = Companion.access$binarySearch(r23, r114, r4, r21);
        if (r24 != null) goto L53;
        r21 = r22;
    L53:
        if (r24 != null) goto L55;
        if (r15 != null) goto L60;
        if (r113 != null) goto L60;
        return PREVAILING_RULE;
    L60:
        if (r15 != null) goto L62;
        List<String> r25 = null;
    L63:
        if (r25 != null) goto L65;
        r25 = CollectionsKt.emptyList();
    L65:
        if (r113 == null) goto L68;
        r11 = StringsKt.split$default(r113, new char[]{'.'}, false, 0, 6, null);
    L68:
        if (r11 != null) goto L71;
        r11 = CollectionsKt.emptyList();
    L71:
        if (r25.size() <= r11.size()) goto L74;
        return r25;
    L74:
        return r11;
    L62:
        r25 = StringsKt.split$default(r15, new char[]{'.'}, false, 0, 6, null);
        goto L63
    L55:
        return StringsKt.split$default(Intrinsics.stringPlus("!", r24), new char[]{'.'}, false, 0, 6, null);
    L51:
        r24 = null;
    L40:
        r113 = null;
        goto L41
    L28:
        r15 = null;
        goto L30
    L76:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    L13:
        r1 = false;
    L9:
        Thread.currentThread().interrupt();
        goto L11
    L5:
        if (this.listRead.compareAndSet(false, true) == false) goto L77;
        readTheListUninterruptibly();
        goto L11
    }

    private final void readTheListUninterruptibly() {
        boolean r0 = false;
    L19:
        readTheList();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L14
    L4:
        if (r0 == false) goto L23;
        Thread.currentThread().interrupt();
        return;
    L23:
        return;
    L7:
        th = move-exception;
        if (r0 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L14:
        Thread.interrupted();     // Catch: Throwable -> L7
        r0 = true;
    L9:
        e = move-exception;
        Platform.Companion.get().log("Failed to read public suffix list", 5, e);     // Catch: Throwable -> L7
        if (r0 == false) goto L24;
        Thread.currentThread().interrupt();
        return;
    }

    private final void readTheList() throws IOException {
        InputStream r0 = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (r0 != null) goto L5;
        return;
    L5:
        BufferedSource r1 = Okio.buffer(new GzipSource(Okio.source(r0)));
        BufferedSource r2 = r1;     // Catch: Throwable -> L16
        byte[] r3 = r2.readByteArray(r2.readInt());     // Catch: Throwable -> L16
        byte[] r4 = r2.readByteArray(r2.readInt());     // Catch: Throwable -> L16
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r1, null);
        monitor-enter(this);
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L13
        this.publicSuffixListBytes = r3;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L13
        this.publicSuffixExceptionListBytes = r4;     // Catch: Throwable -> L13
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        this.readCompleteLatch.countDown();
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public final void setListBytes(byte[] r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(r3, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = r2;
        this.publicSuffixExceptionListBytes = r3;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }

    static {
        Companion = new Companion(null);
        WILDCARD_LABEL = new byte[]{42};
        PREVAILING_RULE = CollectionsKt.listOf(ApnEditor.APN_TYPE_ALL);
        instance = new PublicSuffixDatabase();
    }
}
