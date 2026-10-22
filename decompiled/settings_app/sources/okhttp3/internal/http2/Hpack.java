package okhttp3.internal.http2;

import com.android.settings.wifi.WifiAuthorizeUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import cz.msebera.android.httpclient.cookie.ClientCookie;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.time.HttpHeadTimeFetcher;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Hpack {
    public static final Hpack INSTANCE = null;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = null;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE = null;

    /* JADX INFO: compiled from: Hpack.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0005H\u0002J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u0013J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "source", "Lokio/Source;", "headerTableSizeSetting", "", "maxDynamicTableByteCount", "(Lokio/Source;II)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "headerCount", "headerList", "", "nextHeaderIndex", "Lokio/BufferedSource;", "adjustDynamicTableByteCount", "", "clearDynamicTable", "dynamicTableIndex", "index", "evictToRecoverBytes", "bytesToRecover", "getAndResetHeaderList", "", "getName", "Lokio/ByteString;", "insertIntoDynamicTable", "entry", "isStaticHeader", "", "readByte", "readByteString", "readHeaders", "readIndexedHeader", "readInt", "firstByte", "prefixMask", "readLiteralHeaderWithIncrementalIndexingIndexedName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingNewName", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(Source r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "source");
            this(r8, r9, 0, 4, null);
        }

        public Reader(Source r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "source");
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

        public final List<Header> getAndResetHeaderList() {
            List<Header> r0 = CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return r0;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
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
            ArraysKt.fill$default(this.dynamicTable, null, 0, 0, 6, null);
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
            Intrinsics.checkNotNull(r3);
            r5 = r5 - r3.hpackSize;
            this.dynamicTableByteCount -= r3.hpackSize;
            this.headerCount--;
            r0 = r0 + 1;
        L9:
            Header[] r6 = this.dynamicTable;
            System.arraycopy(r6, r2 + 1, r6, (r2 + 1) + r0, this.headerCount);
            this.nextHeaderIndex += r0;
        L10:
            return r0;
        }

        public final void readHeaders() throws IOException {
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
            throw new IOException(Intrinsics.stringPlus("Invalid dynamic table size update ", Integer.valueOf(this.maxDynamicTableByteCount)));
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

        private final void readIndexedHeader(int r4) throws IOException {
            if (isStaticHeader(r4) == false) goto L5;
            Header r5 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r4];
            this.headerList.add(r5);
            return;
        L5:
            int r0 = dynamicTableIndex(r4 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (r0 < 0) goto L12;
            Header[] r1 = this.dynamicTable;
            if (r0 >= r1.length) goto L12;
            List<Header> r3 = this.headerList;
            Header r6 = r1[r0];
            Intrinsics.checkNotNull(r6);
            r3.add(r6);
            return;
        L12:
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(r4 + 1)));
        }

        private final int dynamicTableIndex(int r1) {
            return (this.nextHeaderIndex + 1) + r1;
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int r3) throws IOException {
            ByteString r4 = getName(r3);
            ByteString r0 = readByteString();
            this.headerList.add(new Header(r4, r0));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            ByteString r0 = Hpack.INSTANCE.checkLowercase(readByteString());
            ByteString r1 = readByteString();
            this.headerList.add(new Header(r0, r1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int r3) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(r3), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final ByteString getName(int r3) throws IOException {
            if (isStaticHeader(r3) == true) goto L13;
            int r0 = dynamicTableIndex(r3 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (r0 < 0) goto L12;
            Header[] r2 = this.dynamicTable;
            if (r0 >= r2.length) goto L12;
            Header r4 = r2[r0];
            Intrinsics.checkNotNull(r4);
            return r4.name;
        L12:
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(r3 + 1)));
        L13:
            return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r3].name;
        }

        private final boolean isStaticHeader(int r2) {
            if (r2 >= 0) goto L4;
        L6:
            return false;
        L4:
            if (r2 > (Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1)) goto L6;
            return true;
        }

        private final void insertIntoDynamicTable(int r6, Header r7) {
            this.headerList.add(r7);
            int r0 = r7.hpackSize;
            if (r6 == (-1)) goto L5;
            Header r2 = this.dynamicTable[dynamicTableIndex(r6)];
            Intrinsics.checkNotNull(r2);
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
            this.dynamicTable[r6 + (dynamicTableIndex(r6) + r4)] = r7;
            goto L16
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        public final int readInt(int r3, int r4) throws IOException {
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

        public final ByteString readByteString() throws IOException {
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
    }

    /* JADX INFO: compiled from: Hpack.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "headerTableSizeSetting", "", "useCompression", "", "out", "Lokio/Buffer;", "(IZLokio/Buffer;)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "emitDynamicTableSizeUpdate", "headerCount", "maxDynamicTableByteCount", "nextHeaderIndex", "smallestHeaderTableSizeSetting", "adjustDynamicTableByteCount", "", "clearDynamicTable", "evictToRecoverBytes", "bytesToRecover", "insertIntoDynamicTable", "entry", "resizeHeaderTable", "writeByteString", "data", "Lokio/ByteString;", "writeHeaders", "headerBlock", "", "writeInt", "value", "prefixMask", "bits", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int r8, Buffer r9) {
            Intrinsics.checkNotNullParameter(r9, "out");
            this(r8, false, r9, 2, null);
        }

        public Writer(Buffer r8) {
            Intrinsics.checkNotNullParameter(r8, "out");
            this(0, false, r8, 3, null);
        }

        public Writer(int r2, boolean r3, Buffer r4) {
            Intrinsics.checkNotNullParameter(r4, "out");
            this.headerTableSizeSetting = r2;
            this.useCompression = r3;
            this.out = r4;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
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

        private final void clearDynamicTable() {
            ArraysKt.fill$default(this.dynamicTable, null, 0, 0, 6, null);
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
            Intrinsics.checkNotNull(r3);
            r5 = r5 - r3.hpackSize;
            int r4 = this.dynamicTableByteCount;
            Header r6 = this.dynamicTable[r1];
            Intrinsics.checkNotNull(r6);
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

        public final void writeHeaders(List<Header> r15) throws IOException {
            Intrinsics.checkNotNullParameter(r15, "headerBlock");
            if (this.emitDynamicTableSizeUpdate == false) goto L8;
            int r0 = this.smallestHeaderTableSizeSetting;
            if (r0 >= this.maxDynamicTableByteCount) goto L7;
            writeInt(r0, 31, 32);
        L7:
            this.emitDynamicTableSizeUpdate = false;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            writeInt(this.maxDynamicTableByteCount, 31, 32);
        L8:
            int r1 = r15.size();
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L51;
            int r3 = r2 + 1;
            Header r4 = r15.get(r2);
            ByteString r5 = r4.name.toAsciiLowercase();
            ByteString r6 = r4.value;
            Integer r7 = Hpack.INSTANCE.getNAME_TO_FIRST_INDEX().get(r5);
            if (r7 == null) goto L26;
            int r8 = r7.intValue() + 1;
            if (2 <= r8) goto L15;
        L17:
            boolean r9 = false;
        L18:
            if (r9 == true) goto L20;
        L25:
            int r10 = r8;
            r8 = -1;
        L28:
            if (r8 != (-1)) goto L39;
            int r11 = this.nextHeaderIndex + 1;
            int r12 = this.dynamicTable.length;
        L30:
            if (r11 >= r12) goto L39;
            int r13 = r11 + 1;
            Header r14 = this.dynamicTable[r11];
            Intrinsics.checkNotNull(r14);
            if (Intrinsics.areEqual(r14.name, r5) == false) goto L38;
            Header r16 = this.dynamicTable[r11];
            Intrinsics.checkNotNull(r16);
            if (Intrinsics.areEqual(r16.value, r6) == true) goto L35;
            if (r10 != (-1)) goto L38;
            r10 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (r11 - this.nextHeaderIndex);
            goto L38
        L35:
            r8 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (r11 - this.nextHeaderIndex);
        L38:
            r11 = r13;
        L39:
            if (r8 == (-1)) goto L42;
            writeInt(r8, 127, 128);
        L50:
            r2 = r3;
            goto L9
        L42:
            if (r10 != (-1)) goto L45;
            this.out.writeByte(64);
            writeByteString(r5);
            writeByteString(r6);
            insertIntoDynamicTable(r4);
            goto L50
        L45:
            if (r5.startsWith(Header.PSEUDO_PREFIX) == true) goto L47;
        L49:
            writeInt(r10, 63, 64);
            writeByteString(r6);
            insertIntoDynamicTable(r4);
            goto L50
        L47:
            if (Intrinsics.areEqual(Header.TARGET_AUTHORITY, r5) == true) goto L49;
            writeInt(r10, 15, 0);
            writeByteString(r6);
            goto L50
        L20:
            if (Intrinsics.areEqual(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r8 - 1].value, r6) == false) goto L23;
        L27:
            r10 = r8;
            goto L28
        L23:
            if (Intrinsics.areEqual(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r8].value, r6) == false) goto L25;
            r10 = r8;
            r8 = r8 + 1;
            goto L28
        L15:
            if (r8 >= 8) goto L17;
            r9 = true;
            goto L18
        L26:
            r8 = -1;
            goto L27
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

        public final void writeByteString(ByteString r5) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "data");
            if (this.useCompression == true) goto L5;
        L7:
            writeInt(r5.size(), 127, 0);
            this.out.write(r5);
            return;
        L5:
            if (Huffman.INSTANCE.encodedLength(r5) >= r5.size()) goto L7;
            Buffer r0 = new Buffer();
            Huffman.INSTANCE.encode(r5, r0);
            ByteString r6 = r0.readByteString();
            writeInt(r6.size(), 127, 128);
            this.out.write(r6);
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
    }

    private Hpack() {
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    static {
        Hpack r0 = new Hpack();
        INSTANCE = r0;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, LibrarianImpl.Constants.SEPARATOR), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, HttpHeadTimeFetcher.FETCHER_TYPE), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header(BaseHttpRequestInfo.KEY_COOKIE, ""), new Header("date", ""), new Header(URLDispatch.KEY_ETAG, ""), new Header("expect", ""), new Header(ClientCookie.EXPIRES_ATTR, ""), new Header("from", ""), new Header(WifiAuthorizeUtils.AUTO_LOGIN_HOST, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = r0.nameToFirstIndex();
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] r0 = STATIC_HEADER_TABLE;
        LinkedHashMap r5 = new LinkedHashMap(r0.length);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int r3 = r2 + 1;
        Header[] r4 = STATIC_HEADER_TABLE;
        if (r5.containsKey(r4[r2].name) == true) goto L7;
        r5.put(r4[r2].name, Integer.valueOf(r2));
    L7:
        r2 = r3;
        goto L3
    L8:
        Map<ByteString, Integer> r6 = Collections.unmodifiableMap(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "unmodifiableMap(result)");
        return r6;
    }

    public final ByteString checkLowercase(ByteString r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "name");
        int r4 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L14;
        int r2 = r1 + 1;
        byte r3 = r5.getByte(r1);
        if (65 <= r3) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == true) goto L13;
        r1 = r2;
        goto L3
    L13:
        throw new IOException(Intrinsics.stringPlus("PROTOCOL_ERROR response malformed: mixed case name: ", r5.utf8()));
    L7:
        if (r3 > 90) goto L9;
        r6 = true;
        goto L10
    L14:
        return r5;
    }
}
