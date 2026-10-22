package okio.internal;

import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;

/* JADX INFO: compiled from: zip.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static /* synthetic */ ZipFileSystem openZip$default(Path r0, FileSystem r1, AnonymousClass1 r2, int r3, Object r4) throws IOException {
        if ((r3 & 4) == 0) goto L6;
        r2 = AnonymousClass1.INSTANCE;
    L6:
        return openZip(r0, r1, r2);
    }

    public static final ZipFileSystem openZip(Path r19, FileSystem r20, Function1<? super ZipEntry, Boolean> r21) throws IOException {
        Intrinsics.checkNotNullParameter(r19, "zipPath");
        Intrinsics.checkNotNullParameter(r20, "fileSystem");
        Intrinsics.checkNotNullParameter(r21, "predicate");
        FileHandle r4 = r20.openReadOnly(r19);
        FileHandle r5 = r4;     // Catch: Throwable -> L78
        long r6 = r5.size() - ((long) 22);     // Catch: Throwable -> L78
        long r8 = 0;
        if (r6 < 0) goto L77;
        long r10 = Math.max(r6 - 65536, 0);     // Catch: Throwable -> L78
    L6:
        BufferedSource r3 = Okio.buffer(r5.source(r6));     // Catch: Throwable -> L78
    L73:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L8:
        if (r3.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) goto L9;
        r3.close();     // Catch: Throwable -> L78
        r6 = r6 - 1;     // Catch: Throwable -> L78
        if (r6 >= r10) goto L6;
        throw new IOException("not a zip: end of central directory signature not found");     // Catch: Throwable -> L78
    L9:
        EocdRecord r11 = readEocdRecord(r3);     // Catch: Throwable -> L73
        String r12 = r3.readUtf8(r11.getCommentByteCount());     // Catch: Throwable -> L73
        r3.close();     // Catch: Throwable -> L78
        long r7 = r6 - ((long) 20);     // Catch: Throwable -> L78
        if (r7 <= 0) goto L45;
        BufferedSource r9 = Okio.buffer(r5.source(r7));     // Catch: Throwable -> L78
        BufferedSource r13 = r9;     // Catch: Throwable -> L38
        if (r13.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L35;
        int r14 = r13.readIntLe();     // Catch: Throwable -> L38
        long r15 = r13.readLongLe();     // Catch: Throwable -> L38
        if (r13.readIntLe() != 1) goto L34;
        if (r14 != 0) goto L34;
        BufferedSource r16 = Okio.buffer(r5.source(r15));     // Catch: Throwable -> L38
        BufferedSource r17 = r16;     // Catch: Throwable -> L26
        int r18 = r17.readIntLe();     // Catch: Throwable -> L26
        if (r18 != ZIP64_EOCD_RECORD_SIGNATURE) goto L25;
        EocdRecord r22 = readZip64EocdRecord(r17, r11);     // Catch: Throwable -> L26
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L38
        r11 = r22;
        goto L35
    L25:
        throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r18));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L34:
        throw new IOException("unsupported zip: spanned");     // Catch: Throwable -> L38
    L35:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L78
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L45:
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L78
        BufferedSource r25 = Okio.buffer(r5.source(r11.getCentralDirectoryOffset()));     // Catch: Throwable -> L78
        BufferedSource r26 = r25;     // Catch: Throwable -> L61
        long r111 = r11.getEntryCount();     // Catch: Throwable -> L61
    L48:
        if (r8 >= r111) goto L57;
        ZipEntry r27 = readEntry(r26);     // Catch: Throwable -> L61
        if (r27.getOffset() >= r11.getCentralDirectoryOffset()) goto L56;
        if (r21.invoke(r27).booleanValue() == false) goto L54;
        r24.add(r27);     // Catch: Throwable -> L61
    L54:
        r8 = r8 + 1;     // Catch: Throwable -> L61
        goto L48
    L56:
        throw new IOException("bad zip: local file header offset >= central directory offset");     // Catch: Throwable -> L61
    L57:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L61
        CloseableKt.closeFinally(r25, null);     // Catch: Throwable -> L78
        ZipFileSystem r28 = new ZipFileSystem(r19, r20, buildIndex(r24), r12);     // Catch: Throwable -> L78
        CloseableKt.closeFinally(r4, null);
        return r28;
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        CloseableKt.closeFinally(r25, th);     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L77:
        throw new IOException("not a zip: size=" + r5.size());     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> r22) {
        Path r0 = Path.Companion.get$default(Path.Companion, LibrarianImpl.Constants.SEPARATOR, false, 1, null);
        Map<Path, ZipEntry> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r0, new ZipEntry(r0, true, null, 0, 0, 0, 0, null, 0, 508, null))});
        Iterator r2 = CollectionsKt.sortedWith(r22, new ZipKt$buildIndex$$inlined$sortedBy$1()).iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        ZipEntry r3 = (ZipEntry) r2.next();
        if (r1.put(r3.getCanonicalPath(), r3) != null) goto L4;
    L7:
        Path r4 = r3.getCanonicalPath().parent();
        if (r4 == null) goto L4;
        ZipEntry r5 = r1.get(r4);
        if (r5 != null) goto L12;
        ZipEntry r15 = new ZipEntry(r4, true, null, 0, 0, 0, 0, null, 0, 508, null);
        r1.put(r4, r15);
        r15.getChildren().add(r3.getCanonicalPath());
        r3 = r15;
        goto L7
    L12:
        r5.getChildren().add(r3.getCanonicalPath());
        goto L4
    L14:
        return r1;
    }

    public static final ZipEntry readEntry(final BufferedSource r26) throws IOException {
        Intrinsics.checkNotNullParameter(r26, "<this>");
        int r0 = r26.readIntLe();
        if (r0 != CENTRAL_FILE_HEADER_SIGNATURE) goto L33;
        r26.skip(4);
        int r1 = r26.readShortLe() & 65535;
        if ((r1 & 1) != 0) goto L31;
        int r12 = r26.readShortLe() & 65535;
        Long r13 = dosDateTimeToEpochMillis(r26.readShortLe() & 65535, r26.readShortLe() & 65535);
        long r9 = ((long) r26.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef r11 = new Ref.LongRef();
        r11.element = ((long) r26.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef r14 = new Ref.LongRef();
        r14.element = ((long) r26.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int r2 = r26.readShortLe() & 65535;
        int r15 = r26.readShortLe() & 65535;
        int r7 = r26.readShortLe() & 65535;
        r26.skip(8);
        final Ref.LongRef r6 = new Ref.LongRef();
        r6.element = ((long) r26.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String r3 = r26.readUtf8(r2);
        if (StringsKt.contains$default(r3, 0, false, 2, null) == true) goto L29;
        if (r14.element != MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) goto L11;
        long r22 = ((long) 8) + 0;
    L13:
        if (r11.element != MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) goto L15;
        long r4 = r22 + ((long) 8);
    L17:
        if (r6.element != MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) goto L19;
        r4 = r4 + ((long) 8);
    L19:
        final long r16 = r4;
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        readExtra(r26, r15, new C04381(r5, r16, r14, r26, r11, r6));
        if (r16 <= 0) goto L27;
        if (r5.element == true) goto L27;
        throw new IOException("bad zip: zip64 extra required but absent");
    L27:
        return new ZipEntry(Path.Companion.get$default(Path.Companion, LibrarianImpl.Constants.SEPARATOR, false, 1, null).resolve(r3), StringsKt.endsWith$default(r3, LibrarianImpl.Constants.SEPARATOR, false, 2, null), r26.readUtf8(r7), r9, r11.element, r14.element, r12, r13, r6.element);
    L15:
        r4 = r22;
        goto L17
    L11:
        r22 = 0;
        goto L13
    L29:
        throw new IOException("bad zip: filename contains 0x00");
    L31:
        throw new IOException("unsupported zip: general purpose bit flag=" + getHex(r1));
    L33:
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(r0));
    }

    private static final EocdRecord readEocdRecord(BufferedSource r10) throws IOException {
        int r0 = r10.readShortLe() & 65535;
        int r2 = r10.readShortLe() & 65535;
        long r5 = r10.readShortLe() & 65535;
        if (r5 != (r10.readShortLe() & 65535)) goto L9;
        if (r0 != 0) goto L9;
        if (r2 != 0) goto L9;
        r10.skip(4);
        return new EocdRecord(r5, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) r10.readIntLe()), r10.readShortLe() & 65535);
    L9:
        throw new IOException("unsupported zip: spanned");
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource r8, EocdRecord r9) throws IOException {
        r8.skip(12);
        int r0 = r8.readIntLe();
        int r1 = r8.readIntLe();
        long r3 = r8.readLongLe();
        if (r3 != r8.readLongLe()) goto L9;
        if (r0 != 0) goto L9;
        if (r1 != 0) goto L9;
        r8.skip(8);
        return new EocdRecord(r3, r8.readLongLe(), r9.getCommentByteCount());
    L9:
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource r10, int r11, Function2<? super Integer, ? super Long, Unit> r12) {
        long r0 = r11;
    L4:
        if (r0 == 0) goto L20;
        if (r0 < 4) goto L19;
        int r13 = r10.readShortLe() & 65535;
        long r4 = ((long) r10.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long r1 = r0 - ((long) 4);
        if (r1 < r4) goto L17;
        r10.require(r4);
        long r6 = r10.getBuffer().size();
        r12.invoke(Integer.valueOf(r13), Long.valueOf(r4));
        long r8 = (r10.getBuffer().size() + r4) - r6;
        if (r8 < 0) goto L15;
        if (r8 <= 0) goto L13;
        r10.getBuffer().skip(r8);
    L13:
        r0 = r1 - r4;
        goto L4
    L15:
        throw new IOException("unsupported zip: too many bytes processed for " + r13);
    L17:
        throw new IOException("bad zip: truncated value in extra field");
    L19:
        throw new IOException("bad zip: truncated header in extra field");
    }

    public static final void skipLocalHeader(BufferedSource r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        readOrSkipLocalHeader(r1, null);
    }

    public static final FileMetadata readLocalHeader(BufferedSource r1, FileMetadata r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "basicMetadata");
        FileMetadata r3 = readOrSkipLocalHeader(r1, r2);
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final FileMetadata readOrSkipLocalHeader(final BufferedSource r17, FileMetadata r18) {
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        if (r18 == null) goto L5;
        T r3 = r18.getLastModifiedAtMillis();
    L6:
        r1.element = r3;
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        int r6 = r17.readIntLe();
        if (r6 != LOCAL_FILE_HEADER_SIGNATURE) goto L19;
        r17.skip(2);
        int r7 = r17.readShortLe() & 65535;
        if ((r7 & 1) != 0) goto L17;
        r17.skip(18);
        long r8 = ((long) r17.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int r9 = r17.readShortLe() & 65535;
        r17.skip(r8);
        if (r18 != null) goto L14;
        r17.skip(r9);
        return null;
    L14:
        readExtra(r17, r9, new C04391(r17, r1, r4, r5));
        return new FileMetadata(r18.isRegularFile(), r18.isDirectory(), null, r18.getSize(), (Long) r5.element, (Long) r1.element, (Long) r4.element, null, 128, null);
    L17:
        throw new IOException("unsupported zip: general purpose bit flag=" + getHex(r7));
    L19:
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(r6));
    L5:
        r3 = 0;
        goto L6
    }

    private static final Long dosDateTimeToEpochMillis(int r8, int r9) {
        if (r9 != (-1)) goto L6;
        return null;
    L6:
        GregorianCalendar r7 = new GregorianCalendar();
        r7.set(14, 0);
        r7.set(((r8 >> 9) & 127) + 1980, ((r8 >> 5) & 15) - 1, r8 & 31, (r9 >> 11) & 31, (r9 >> 5) & 63, (r9 & 31) << 1);
        return Long.valueOf(r7.getTime().getTime());
    }

    private static final String getHex(int r2) {
        StringBuilder r0 = new StringBuilder("0x");
        String r3 = Integer.toString(r2, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r3, "toString(this, checkRadix(radix))");
        return r0.append(r3).toString();
    }
}
