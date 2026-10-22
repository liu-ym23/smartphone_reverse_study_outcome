package okhttp3.internal.publicsuffix;

import a.a;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.sequences.DropSequence;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PublicSuffixDatabase {
    public static final Companion Companion = null;
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = null;

    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = null;
    private static final PublicSuffixDatabase instance = null;
    private final AtomicBoolean listRead;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$binarySearch(Companion r0, byte[] r1, byte[][] r2, int r3) {
            return r0.binarySearch(r1, r2, r3);
        }

        private final String binarySearch(byte[] r19, byte[][] r20, int r21) {
            int r2 = r19.length;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L44;
            int r5 = (r4 + r2) / 2;
        L6:
            if (r5 <= (-1)) goto L10;
            if (r19[r5] == ((byte) 10)) goto L10;
            r5 = r5 - 1;
        L10:
            int r8 = r5 + 1;
            int r10 = 1;
        L11:
            int r11 = r8 + r10;
            if (r19[r11] == ((byte) 10)) goto L14;
            r10 = r10 + 1;
            goto L11
        L14:
            int r6 = r11 - r8;
            int r12 = r21;
            boolean r13 = false;
            int r14 = 0;
            int r15 = 0;
        L16:
            if (r13 == false) goto L18;
            int r16 = 46;
            boolean r3 = false;
        L19:
            int r17 = r16 - Util.and(r19[r8 + r15], 255);
            if (r17 != 0) goto L29;
            r15 = r15 + 1;
            r14 = r14 + 1;
            if (r15 == r6) goto L29;
            if (r20[r12].length == r14) goto L28;
            r13 = r3;
            goto L16
        L28:
            if (r12 == (r20.length - 1)) goto L29;
            r12 = r12 + 1;
            r13 = true;
            r14 = -1;
        L29:
            if (r17 < 0) goto L30;
            if (r17 > 0) goto L32;
            int r7 = r6 - r15;
            int r9 = r20[r12].length - r14;
            int r18 = r12 + 1;
            int r22 = r20.length;
        L34:
            if (r18 >= r22) goto L36;
            r9 = r9 + r20[r18].length;
            r18 = r18 + 1;
            goto L34
        L36:
            if (r9 < r7) goto L30;
            if (r9 > r7) goto L32;
            Charset r1 = StandardCharsets.UTF_8;
            Intrinsics.e(r1, "UTF_8");
            return new String(r19, r8, r6, r1);
        L32:
            r4 = r11 + 1;
        L30:
            r2 = r5;
            goto L3
        L18:
            boolean r110 = r13;
            r16 = Util.and(r20[r12][r14], 255);
            r3 = r110;
            goto L19
        L44:
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.access$getInstance$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$findMatchingRule$1, reason: invalid class name */
    @Metadata
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(PublicSuffixDatabase r7) {
            super(r7, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", false);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver);
        }

        public void set(@Nullable Object r1) {
            PublicSuffixDatabase.access$setPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver, (byte[]) r1);
        }
    }

    static {
        Companion = new Companion(null);
        WILDCARD_LABEL = new byte[]{(byte) 42};
        PREVAILING_RULE = CollectionsKt.j("*");
        instance = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    public static final /* synthetic */ PublicSuffixDatabase access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase r0) {
        byte[] r1 = r0.publicSuffixListBytes;
        if (r1 == null) goto L5;
        return r1;
    L5:
        Intrinsics.m("publicSuffixListBytes");
        throw null;
    }

    public static final /* synthetic */ void access$setPublicSuffixListBytes$p(PublicSuffixDatabase r0, byte[] r1) {
        r0.publicSuffixListBytes = r1;
    }

    private final List<String> findMatchingRule(List<String> r12) {
        if (this.listRead.get() == false) goto L5;
    L75:
        this.readCompleteLatch.await();     // Catch: InterruptedException -> L9
    L11:
        if (this.publicSuffixListBytes == null) goto L74;
        int r0 = r12.size();
        byte[][] r3 = new byte[r0][];
        int r4 = 0;
    L13:
        if (r4 >= r0) goto L19;
        String r5 = r12.get(r4);
        Charset r6 = StandardCharsets.UTF_8;
        Intrinsics.e(r6, "UTF_8");
        if (r5 == null) goto L18;
        byte[] r7 = r5.getBytes(r6);
        Intrinsics.e(r7, "(this as java.lang.String).getBytes(charset)");
        r3[r4] = r7;
        r4 = r4 + 1;
        goto L13
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        int r13 = 0;
    L20:
        String r8 = null;
        if (r13 >= r0) goto L30;
        Companion r9 = Companion;
        byte[] r10 = this.publicSuffixListBytes;
        if (r10 == null) goto L28;
        String r11 = Companion.access$binarySearch(r9, r10, r3, r13);
        if (r11 != null) goto L31;
        r13 = r13 + 1;
    L31:
        if (r0 <= 1) goto L42;
        byte[][] r14 = (byte[][]) r3.clone();
        int r15 = r14.length - 1;
        int r16 = 0;
    L33:
        if (r16 >= r15) goto L42;
        r14[r16] = WILDCARD_LABEL;
        Companion r17 = Companion;
        byte[] r18 = this.publicSuffixListBytes;
        if (r18 == null) goto L40;
        String r19 = Companion.access$binarySearch(r17, r18, r14, r16);
        if (r19 != null) goto L43;
        r16 = r16 + 1;
    L43:
        if (r19 == null) goto L55;
        int r1 = r0 - 1;
        int r110 = 0;
    L45:
        if (r110 >= r1) goto L55;
        Companion r20 = Companion;
        byte[] r21 = this.publicSuffixExceptionListBytes;
        if (r21 == null) goto L52;
        String r22 = Companion.access$binarySearch(r20, r21, r3, r110);
        if (r22 != null) goto L50;
        r110 = r110 + 1;
        goto L45
    L50:
        r8 = r22;
        goto L55
    L52:
        Intrinsics.m("publicSuffixExceptionListBytes");
        throw null;
    L55:
        if (r8 != null) goto L57;
        if (r11 != null) goto L62;
        if (r19 != null) goto L62;
        return PREVAILING_RULE;
    L62:
        List<String> r111 = EmptyList.b;
        if (r11 == null) goto L65;
        List<String> r2 = StringsKt.C(r11, new char[]{'.'});
    L66:
        if (r19 == null) goto L69;
        r111 = StringsKt.C(r19, new char[]{'.'});
    L69:
        if (r2.size() <= r111.size()) goto L72;
        return r2;
    L72:
        return r111;
    L65:
        r2 = r111;
        goto L66
    L57:
        return StringsKt.C("!".concat(r8), new char[]{'.'});
    L40:
        Intrinsics.m("publicSuffixListBytes");
        throw null;
    L42:
        r19 = null;
        goto L43
    L28:
        Intrinsics.m("publicSuffixListBytes");
        throw null;
    L30:
        r11 = null;
        goto L31
    L74:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    L9:
        Thread.currentThread().interrupt();
        goto L11
    L5:
        if (this.listRead.compareAndSet(false, true) == false) goto L75;
        readTheListUninterruptibly();
        goto L11
    }

    private final void readTheList() {
        InputStream r0 = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (r0 == null) goto L20;
        BufferedSource r1 = Okio.buffer(new GzipSource(Okio.source(r0)));
        byte[] r2 = r1.readByteArray(r1.readInt());     // Catch: Throwable -> L15
        byte[] r3 = r1.readByteArray(r1.readInt());     // Catch: Throwable -> L15
        CloseableKt.a(r1, null);
        monitor-enter(this);
        Intrinsics.c(r2);     // Catch: Throwable -> L12
        this.publicSuffixListBytes = r2;     // Catch: Throwable -> L12
        Intrinsics.c(r3);     // Catch: Throwable -> L12
        this.publicSuffixExceptionListBytes = r3;     // Catch: Throwable -> L12
        monitor-exit(this);
        this.readCompleteLatch.countDown();
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.a(r1, th);
        throw th;
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

    private final List<String> splitDomain(String r5) {
        int r2 = 0;
        List<String> r6 = StringsKt.C(r5, new char[]{'.'});
        if (r6.isEmpty() == true) goto L32;
        if (Intrinsics.a(r6.get(CollectionsKt.f(r6)), "") == false) goto L30;
        int r0 = r6.size() - 1;
        if (r0 >= 0) goto L9;
        r0 = 0;
    L9:
        if (r0 < 0) goto L29;
        if (r0 != 0) goto L13;
        return EmptyList.b;
    L13:
        if (r0 >= r6.size()) goto L37;
        if (r0 == 1) goto L17;
        ArrayList r1 = new ArrayList(r0);
        Iterator<T> r7 = r6.iterator();
    L23:
        if (r7.hasNext() == false) goto L27;
        r1.add(r7.next());
        r2 = r2 + 1;
        if (r2 != r0) goto L23;
    L27:
        return CollectionsKt.m(r1);
    L17:
        if (r6.isEmpty() == true) goto L20;
        return CollectionsKt.j(r6.get(0));
    L20:
        throw new NoSuchElementException("List is empty.");
    L37:
        return CollectionsKt.q(r6);
    L29:
        throw new IllegalArgumentException(a.f(r0, "Requested element count ", " is less than zero.").toString());
    L30:
        return r6;
    L32:
        throw new NoSuchElementException("List is empty.");
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String r8) {
        Intrinsics.f(r8, "domain");
        String r0 = IDN.toUnicode(r8);
        Intrinsics.e(r0, "unicodeDomain");
        List<String> r1 = splitDomain(r0);
        List<String> r2 = findMatchingRule(r1);
        int r5 = 0;
        if (r1.size() != r2.size()) goto L8;
        if (r2.get(0).charAt(0) == '!') goto L8;
        return null;
    L8:
        if (r2.get(0).charAt(0) != '!') goto L11;
        int r3 = r1.size();
        int r4 = r2.size();
    L10:
        int r6 = r3 - r4;
        List<String> r7 = splitDomain(r8);
        Intrinsics.f(r7, "<this>");
        Sequence r9 = new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(r7);
        if (r6 < 0) goto L30;
        if (r6 != 0) goto L17;
    L20:
        StringBuilder r10 = new StringBuilder();
        r10.append("");
        Iterator r11 = r9.iterator();
    L22:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();
        r5 = r5 + 1;
        if (r5 <= 1) goto L26;
        r10.append(LibrarianImpl.Constants.DOT);
    L26:
        StringsKt.l(r10, r12, null);
        goto L22
    L27:
        r10.append("");
        String r13 = r10.toString();
        Intrinsics.e(r13, "joinTo(StringBuilder(), …ed, transform).toString()");
        return r13;
    L17:
        if ((r9 instanceof DropTakeSequence) == false) goto L19;
        r9 = ((DropTakeSequence) r9).a(r6);
        goto L20
    L19:
        r9 = new DropSequence(r9, r6);
        goto L20
    L30:
        throw new IllegalArgumentException(a.f(r6, "Requested element count ", " is less than zero.").toString());
    L11:
        r3 = r1.size();
        r4 = r2.size() + 1;
        goto L10
    }

    public final void setListBytes(@NotNull byte[] r2, @NotNull byte[] r3) {
        Intrinsics.f(r2, "publicSuffixListBytes");
        Intrinsics.f(r3, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = r2;
        this.publicSuffixExceptionListBytes = r3;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
