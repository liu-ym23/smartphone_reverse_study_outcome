package okhttp3.internal.http2;

import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Hpack {
    public static final Hpack INSTANCE = null;

    @NotNull
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = null;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;

    @NotNull
    private static final Header[] STATIC_HEADER_TABLE = null;

    @Metadata
    public static final class Reader {

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;

        @JvmField
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        @JvmOverloads
        public Reader(@NotNull Source r7, int r8) {
            int r3 = 0;
            this(r7, r8, r3, 4, null);
        }

        private final void adjustDynamicTableByteCount() {
            int r0 = this.maxDynamicTableByteCount;
            int r1 = this.dynamicTableByteCount;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r1 - r0);
            return;
        }

        private final void clearDynamicTable() {
            ArraysKt.m(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int r1) {
            return (this.nextHeaderIndex + 1) + r1;
        }

        private final int evictToRecoverBytes(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.dynamicTable.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.nextHeaderIndex;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            Header r3 = this.dynamicTable[r1];
            Intrinsics.c(r3);
            int r4 = r3.hpackSize;
            r5 = r5 - r4;
            this.dynamicTableByteCount -= r4;
            this.headerCount--;
            r0 = r0 + 1;
        L9:
            Header[] r6 = this.dynamicTable;
            System.arraycopy(r6, r2 + 1, r6, (r2 + 1) + r0, this.headerCount);
            this.nextHeaderIndex += r0;
        L10:
            return r0;
        }

        private final ByteString getName(int r3) {
            if (isStaticHeader(r3) == true) goto L13;
            int r0 = dynamicTableIndex(r3 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (r0 < 0) goto L12;
            Header[] r2 = this.dynamicTable;
            if (r0 >= r2.length) goto L12;
            Header r4 = r2[r0];
            Intrinsics.c(r4);
            return r4.name;
        L12:
            throw new IOException("Header index too large " + (r3 + 1));
        L13:
            return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r3].name;
        }

        private final void insertIntoDynamicTable(int r6, Header r7) {
            this.headerList.add(r7);
            int r0 = r7.hpackSize;
            if (r6 == (-1)) goto L5;
            Header r2 = this.dynamicTable[dynamicTableIndex(r6)];
            Intrinsics.c(r2);
            r0 = r0 - r2.hpackSize;
        L5:
            int r3 = this.maxDynamicTableByteCount;
            if (r0 <= r3) goto L9;
            clearDynamicTable();
            return;
        L9:
            int r4 = evictToRecoverBytes((this.dynamicTableByteCount + r0) - r3);
            if (r6 != (-1)) goto L15;
            int r8 = this.headerCount + 1;
            Header[] r1 = this.dynamicTable;
            if (r8 <= r1.length) goto L14;
            Header[] r9 = new Header[r1.length * 2];
            System.arraycopy(r1, 0, r9, r1.length, r1.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r9;
        L14:
            int r10 = this.nextHeaderIndex;
            this.nextHeaderIndex = r10 - 1;
            this.dynamicTable[r10] = r7;
            this.headerCount++;
        L16:
            this.dynamicTableByteCount += r0;
            return;
        L15:
            this.dynamicTable[(dynamicTableIndex(r6) + r4) + r6] = r7;
            goto L16
        }

        private final boolean isStaticHeader(int r2) {
            if (r2 >= 0) goto L4;
        L6:
            return false;
        L4:
            if (r2 > (Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1)) goto L6;
            return true;
        }

        private final int readByte() {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int r4) {
            if (isStaticHeader(r4) == false) goto L5;
            this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r4]);
            return;
        L5:
            int r0 = dynamicTableIndex(r4 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (r0 < 0) goto L12;
            Header[] r1 = this.dynamicTable;
            if (r0 >= r1.length) goto L12;
            List<Header> r3 = this.headerList;
            Header r5 = r1[r0];
            Intrinsics.c(r5);
            r3.add(r5);
            return;
        L12:
            throw new IOException("Header index too large " + (r4 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int r3) {
            insertIntoDynamicTable(-1, new Header(getName(r3), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int r3) {
            ByteString r4 = getName(r3);
            ByteString r0 = readByteString();
            this.headerList.add(new Header(r4, r0));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() {
            ByteString r0 = Hpack.INSTANCE.checkLowercase(readByteString());
            ByteString r1 = readByteString();
            this.headerList.add(new Header(r0, r1));
        }

        @NotNull
        public final List<Header> getAndResetHeaderList() {
            List<Header> r0 = CollectionsKt.q(this.headerList);
            this.headerList.clear();
            return r0;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        @NotNull
        public final ByteString readByteString() {
            int r0 = readByte();
            if ((r0 & 128) != 128) goto L5;
            boolean r1 = true;
        L6:
            long r2 = readInt(r0, 127);
            if (r1 == false) goto L10;
            Buffer r3 = new Buffer();
            Huffman.INSTANCE.decode(this.source, r2, r3);
            return r3.readByteString();
        L10:
            return this.source.readByteString(r2);
        L5:
            r1 = false;
            goto L6
        }

        public final void readHeaders() {
        L3:
            if (this.source.exhausted() == true) goto L32;
            int r0 = Util.and(this.source.readByte(), 255);
            if (r0 == 128) goto L31;
            if ((r0 & 128) == 128) goto L8;
            if (r0 == 64) goto L11;
            if ((r0 & 64) == 64) goto L14;
            if ((r0 & 32) == 32) goto L17;
            if (r0 == 16) goto L29;
            if (r0 == 0) goto L29;
            readLiteralHeaderWithoutIndexingIndexedName(readInt(r0, 15) - 1);
        L29:
            readLiteralHeaderWithoutIndexingNewName();
            goto L3
        L17:
            int r1 = readInt(r0, 31);
            this.maxDynamicTableByteCount = r1;
            if (r1 < 0) goto L23;
            if (r1 > this.headerTableSizeSetting) goto L23;
            adjustDynamicTableByteCount();
        L23:
            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
        L14:
            readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(r0, 63) - 1);
            goto L3
        L11:
            readLiteralHeaderWithIncrementalIndexingNewName();
            goto L3
        L8:
            readIndexedHeader(readInt(r0, 127) - 1);
            goto L3
        L31:
            throw new IOException("index == 0");
        }

        public final int readInt(int r3, int r4) {
            int r5 = r3 & r4;
            if (r5 >= r4) goto L5;
            return r5;
        L5:
            int r6 = 0;
        L6:
            int r0 = readByte();
            if ((r0 & 128) == 0) goto L10;
            r4 = r4 + ((r0 & 127) << r6);
            r6 = r6 + 7;
            goto L6
        L10:
            return r4 + (r0 << r6);
        }

        @JvmOverloads
        public Reader(@NotNull Source r2, int r3, int r4) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            this.headerTableSizeSetting = r3;
            this.maxDynamicTableByteCount = r4;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(r2);
            Header[] r5 = new Header[8];
            this.dynamicTable = r5;
            this.nextHeaderIndex = r5.length - 1;
        }

        public /* synthetic */ Reader(Source r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = r2;
        L5:
            this(r1, r2, r3);
        }
    }

    @Metadata
    public static final class Writer {

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;

        @JvmField
        public int headerCount;

        @JvmField
        public int headerTableSizeSetting;

        @JvmField
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        @JvmOverloads
        public Writer(int r7, @NotNull Buffer r8) {
            boolean r2 = false;
            this(r7, r2, r8, 2, null);
        }

        private final void adjustDynamicTableByteCount() {
            int r0 = this.maxDynamicTableByteCount;
            int r1 = this.dynamicTableByteCount;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r1 - r0);
            return;
        }

        private final void clearDynamicTable() {
            ArraysKt.m(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.dynamicTable.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.nextHeaderIndex;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            Header r3 = this.dynamicTable[r1];
            Intrinsics.c(r3);
            r5 = r5 - r3.hpackSize;
            int r4 = this.dynamicTableByteCount;
            Header r6 = this.dynamicTable[r1];
            Intrinsics.c(r6);
            this.dynamicTableByteCount = r4 - r6.hpackSize;
            this.headerCount--;
            r0 = r0 + 1;
        L9:
            Header[] r7 = this.dynamicTable;
            System.arraycopy(r7, r2 + 1, r7, (r2 + 1) + r0, this.headerCount);
            Header[] r8 = this.dynamicTable;
            int r9 = this.nextHeaderIndex;
            Arrays.fill(r8, r9 + 1, (r9 + 1) + r0, null);
            this.nextHeaderIndex += r0;
        L10:
            return r0;
        }

        private final void insertIntoDynamicTable(Header r7) {
            int r0 = r7.hpackSize;
            int r1 = this.maxDynamicTableByteCount;
            if (r0 <= r1) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes((this.dynamicTableByteCount + r0) - r1);
            int r2 = this.headerCount + 1;
            Header[] r3 = this.dynamicTable;
            if (r2 <= r3.length) goto L9;
            Header[] r4 = new Header[r3.length * 2];
            System.arraycopy(r3, 0, r4, r3.length, r3.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r4;
        L9:
            int r5 = this.nextHeaderIndex;
            this.nextHeaderIndex = r5 - 1;
            this.dynamicTable[r5] = r7;
            this.headerCount++;
            this.dynamicTableByteCount += r0;
        }

        public final void resizeHeaderTable(int r2) {
            this.headerTableSizeSetting = r2;
            int r3 = Math.min(r2, 16384);
            int r0 = this.maxDynamicTableByteCount;
            if (r0 != r3) goto L5;
            return;
        L5:
            if (r3 >= r0) goto L7;
            this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, r3);
        L7:
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = r3;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(@NotNull ByteString r5) {
            Intrinsics.f(r5, "data");
            if (this.useCompression == false) goto L7;
            Huffman r0 = Huffman.INSTANCE;
            if (r0.encodedLength(r5) >= r5.size()) goto L7;
            Buffer r2 = new Buffer();
            r0.encode(r5, r2);
            ByteString r6 = r2.readByteString();
            writeInt(r6.size(), 127, 128);
            this.out.write(r6);
            return;
        L7:
            writeInt(r5.size(), 127, 0);
            this.out.write(r5);
        }

        public final void writeHeaders(@NotNull List<Header> r13) {
            Intrinsics.f(r13, "headerBlock");
            if (this.emitDynamicTableSizeUpdate == false) goto L8;
            int r0 = this.smallestHeaderTableSizeSetting;
            if (r0 >= this.maxDynamicTableByteCount) goto L7;
            writeInt(r0, 31, 32);
        L7:
            this.emitDynamicTableSizeUpdate = false;
            this.smallestHeaderTableSizeSetting = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            writeInt(this.maxDynamicTableByteCount, 31, 32);
        L8:
            int r1 = r13.size();
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L48;
            Header r3 = r13.get(r2);
            ByteString r4 = r3.name.toAsciiLowercase();
            ByteString r5 = r3.value;
            Hpack r6 = Hpack.INSTANCE;
            Integer r7 = r6.getNAME_TO_FIRST_INDEX().get(r4);
            if (r7 == null) goto L24;
            int r8 = r7.intValue();
            int r9 = r8 + 1;
            if (2 <= r9) goto L16;
        L23:
            int r10 = r9;
            r9 = -1;
        L25:
            if (r9 != (-1)) goto L36;
            int r11 = this.nextHeaderIndex + 1;
            int r12 = this.dynamicTable.length;
        L27:
            if (r11 >= r12) goto L36;
            Header r14 = this.dynamicTable[r11];
            Intrinsics.c(r14);
            if (Intrinsics.a(r14.name, r4) == false) goto L35;
            Header r15 = this.dynamicTable[r11];
            Intrinsics.c(r15);
            if (Intrinsics.a(r15.value, r5) == true) goto L32;
            if (r10 != (-1)) goto L35;
            r10 = (r11 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
            goto L35
        L32:
            r9 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (r11 - this.nextHeaderIndex);
        L35:
            r11 = r11 + 1;
        L36:
            if (r9 == (-1)) goto L39;
            writeInt(r9, 127, 128);
        L47:
            r2 = r2 + 1;
            goto L9
        L39:
            if (r10 != (-1)) goto L42;
            this.out.writeByte(64);
            writeByteString(r4);
            writeByteString(r5);
            insertIntoDynamicTable(r3);
            goto L47
        L42:
            if (r4.startsWith(Header.PSEUDO_PREFIX) == true) goto L44;
        L46:
            writeInt(r10, 63, 64);
            writeByteString(r5);
            insertIntoDynamicTable(r3);
            goto L47
        L44:
            if ((!Intrinsics.a(Header.TARGET_AUTHORITY, r4)) == false) goto L46;
            writeInt(r10, 15, 0);
            writeByteString(r5);
            goto L47
        L16:
            if (7 < r9) goto L23;
            if (Intrinsics.a(r6.getSTATIC_HEADER_TABLE()[r8].value, r5) == false) goto L21;
            r10 = r9;
            goto L25
        L21:
            if (Intrinsics.a(r6.getSTATIC_HEADER_TABLE()[r9].value, r5) == false) goto L23;
            r10 = r9;
            r9 = r8 + 2;
            goto L25
        L24:
            r10 = -1;
            r9 = -1;
            goto L25
        }

        public final void writeInt(int r2, int r3, int r4) {
            if (r2 >= r3) goto L5;
            this.out.writeByte(r2 | r4);
            return;
        L5:
            this.out.writeByte(r4 | r3);
            int r5 = r2 - r3;
        L7:
            if (r5 < 128) goto L9;
            this.out.writeByte(128 | (r5 & 127));
            r5 = r5 >>> 7;
            goto L7
        L9:
            this.out.writeByte(r5);
        }

        @JvmOverloads
        public Writer(@NotNull Buffer r7) {
            int r1 = 0;
            boolean r2 = false;
            this(r1, r2, r7, 3, null);
        }

        @JvmOverloads
        public Writer(int r2, boolean r3, @NotNull Buffer r4) {
            Intrinsics.f(r4, "out");
            this.headerTableSizeSetting = r2;
            this.useCompression = r3;
            this.out = r4;
            this.smallestHeaderTableSizeSetting = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.maxDynamicTableByteCount = r2;
            Header[] r5 = new Header[8];
            this.dynamicTable = r5;
            this.nextHeaderIndex = r5.length - 1;
        }

        public /* synthetic */ Writer(int r1, boolean r2, Buffer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = 4096;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r2 = true;
        L8:
            this(r1, r2, r3);
        }
    }

    static {
        Hpack r0 = new Hpack();
        INSTANCE = r0;
        Header r2 = new Header(Header.TARGET_AUTHORITY, "");
        ByteString r4 = Header.TARGET_METHOD;
        Header r3 = new Header(r4, HttpMethodContrants.GET);
        Header r5 = new Header(r4, HttpMethodContrants.POST);
        ByteString r6 = Header.TARGET_PATH;
        Header r7 = new Header(r6, LibrarianImpl.Constants.SEPARATOR);
        Header r8 = new Header(r6, "/index.html");
        ByteString r9 = Header.TARGET_SCHEME;
        Header r10 = new Header(r9, HttpHost.DEFAULT_SCHEME_NAME);
        Header r11 = new Header(r9, "https");
        ByteString r14 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{r2, r3, r5, r7, r8, r10, r11, new Header(r14, "200"), new Header(r14, "204"), new Header(r14, "206"), new Header(r14, "304"), new Header(r14, "400"), new Header(r14, "404"), new Header(r14, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header(BaseHttpRequestInfo.KEY_COOKIE, ""), new Header("date", ""), new Header(URLDispatch.KEY_ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(BatteryTypeInf.BATTERY_LOC_API, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = r0.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] r0 = STATIC_HEADER_TABLE;
        LinkedHashMap r4 = new LinkedHashMap(r0.length);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Header[] r3 = STATIC_HEADER_TABLE;
        if (r4.containsKey(r3[r2].name) == true) goto L7;
        r4.put(r3[r2].name, Integer.valueOf(r2));
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        Map<ByteString, Integer> r5 = Collections.unmodifiableMap(r4);
        Intrinsics.e(r5, "Collections.unmodifiableMap(result)");
        return r5;
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString r5) {
        Intrinsics.f(r5, "name");
        int r4 = r5.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L11;
        byte r1 = (byte) 65;
        byte r2 = (byte) 90;
        byte r3 = r5.getByte(r0);
        if (r1 > r3) goto L8;
        if (r2 < r3) goto L8;
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r5.utf8());
    L8:
        r0 = r0 + 1;
        goto L3
    L11:
        return r5;
    }

    @NotNull
    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
