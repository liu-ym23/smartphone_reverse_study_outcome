package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import com.android.settingslib.applications.RecentAppOpsAccess;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class ColorResourcesTableCreator {
    private static final byte ANDROID_PACKAGE_ID = 1;
    private static final PackageInfo ANDROID_PACKAGE_INFO = null;
    private static final byte APPLICATION_PACKAGE_ID = 127;
    private static final Comparator<ColorResource> COLOR_RESOURCE_COMPARATOR = null;
    private static final short HEADER_TYPE_PACKAGE = 512;
    private static final short HEADER_TYPE_RES_TABLE = 2;
    private static final short HEADER_TYPE_STRING_POOL = 1;
    private static final short HEADER_TYPE_TYPE = 513;
    private static final short HEADER_TYPE_TYPE_SPEC = 514;
    private static final String RESOURCE_TYPE_NAME_COLOR = "color";
    private static byte typeIdColor;

    static class ColorResource {
        private final short entryId;
        private final String name;
        private final byte packageId;
        private final byte typeId;
        private final int value;

        static /* synthetic */ short access$000(ColorResource r0) {
            return r0.entryId;
        }

        static /* synthetic */ String access$100(ColorResource r0) {
            return r0.name;
        }

        static /* synthetic */ int access$1400(ColorResource r0) {
            return r0.value;
        }

        static /* synthetic */ byte access$200(ColorResource r0) {
            return r0.typeId;
        }

        static /* synthetic */ byte access$300(ColorResource r0) {
            return r0.packageId;
        }

        ColorResource(int r1, String r2, int r3) {
            this.name = r2;
            this.value = r3;
            this.entryId = (short) (65535 & r1);
            this.typeId = (byte) ((r1 >> 16) & 255);
            this.packageId = (byte) ((r1 >> 24) & 255);
        }
    }

    private static class PackageChunk {
        private static final short HEADER_SIZE = 288;
        private static final int PACKAGE_NAME_MAX_LENGTH = 128;
        private final ResChunkHeader header;
        private final StringPoolChunk keyStrings;
        private final PackageInfo packageInfo;
        private final TypeSpecChunk typeSpecChunk;
        private final StringPoolChunk typeStrings;

        PackageChunk(PackageInfo r7, List<ColorResource> r8) {
            this.packageInfo = r7;
            int r1 = 0;
            this.typeStrings = new StringPoolChunk(false, new String[]{"?1", "?2", "?3", "?4", "?5", "color"});
            String[] r9 = new String[r8.size()];
        L4:
            if (r1 >= r8.size()) goto L6;
            r9[r1] = ColorResource.access$100(r8.get(r1));
            r1 = r1 + 1;
            goto L4
        L6:
            this.keyStrings = new StringPoolChunk(true, r9);
            this.typeSpecChunk = new TypeSpecChunk(r8);
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_PACKAGE, HEADER_SIZE, getChunkSize());
        }

        void writeTo(ByteArrayOutputStream r5) throws IOException {
            this.header.writeTo(r5);
            r5.write(ColorResourcesTableCreator.access$500(PackageInfo.access$1000(this.packageInfo)));
            char[] r0 = PackageInfo.access$1100(this.packageInfo).toCharArray();
            int r2 = 0;
        L4:
            if (r2 >= 128) goto L10;
            if (r2 >= r0.length) goto L8;
            r5.write(ColorResourcesTableCreator.access$1200(r0[r2]));
        L9:
            r2 = r2 + 1;
            goto L4
        L8:
            r5.write(ColorResourcesTableCreator.access$1200(0));
            goto L9
        L10:
            r5.write(ColorResourcesTableCreator.access$500(288));
            r5.write(ColorResourcesTableCreator.access$500(0));
            r5.write(ColorResourcesTableCreator.access$500(this.typeStrings.getChunkSize() + 288));
            r5.write(ColorResourcesTableCreator.access$500(0));
            r5.write(ColorResourcesTableCreator.access$500(0));
            this.typeStrings.writeTo(r5);
            this.keyStrings.writeTo(r5);
            this.typeSpecChunk.writeTo(r5);
        }

        int getChunkSize() {
            return ((this.typeStrings.getChunkSize() + 288) + this.keyStrings.getChunkSize()) + this.typeSpecChunk.getChunkSizeWithTypeChunk();
        }
    }

    static class PackageInfo {
        private final int id;
        private final String name;

        static /* synthetic */ int access$1000(PackageInfo r0) {
            return r0.id;
        }

        static /* synthetic */ String access$1100(PackageInfo r0) {
            return r0.name;
        }

        PackageInfo(int r1, String r2) {
            this.id = r1;
            this.name = r2;
        }
    }

    private static class ResChunkHeader {
        private final int chunkSize;
        private final short headerSize;
        private final short type;

        ResChunkHeader(short r1, short r2, int r3) {
            this.type = r1;
            this.headerSize = r2;
            this.chunkSize = r3;
        }

        void writeTo(ByteArrayOutputStream r2) throws IOException {
            r2.write(ColorResourcesTableCreator.access$600(this.type));
            r2.write(ColorResourcesTableCreator.access$600(this.headerSize));
            r2.write(ColorResourcesTableCreator.access$500(this.chunkSize));
        }
    }

    private static class ResEntry {
        private static final byte DATA_TYPE_AARRGGBB = 28;
        private static final short ENTRY_SIZE = 8;
        private static final short FLAG_PUBLIC = 2;
        private static final int SIZE = 16;
        private static final short VALUE_SIZE = 8;
        private final int data;
        private final int keyStringIndex;

        ResEntry(int r1, int r2) {
            this.keyStringIndex = r1;
            this.data = r2;
        }

        void writeTo(ByteArrayOutputStream r4) throws IOException {
            r4.write(ColorResourcesTableCreator.access$600(8));
            r4.write(ColorResourcesTableCreator.access$600(2));
            r4.write(ColorResourcesTableCreator.access$500(this.keyStringIndex));
            r4.write(ColorResourcesTableCreator.access$600(8));
            r4.write(new byte[]{0, 28});
            r4.write(ColorResourcesTableCreator.access$500(this.data));
        }
    }

    private static class ResTable {
        private static final short HEADER_SIZE = 12;
        private final ResChunkHeader header;
        private final List<PackageChunk> packageChunks;
        private final int packageCount;
        private final StringPoolChunk stringPool;

        ResTable(Map<PackageInfo, List<ColorResource>> r5) {
            this.packageChunks = new ArrayList();
            this.packageCount = r5.size();
            this.stringPool = new StringPoolChunk(new String[0]);
            Iterator<Map.Entry<PackageInfo, List<ColorResource>>> r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<PackageInfo, List<ColorResource>> r0 = r6.next();
            List<ColorResource> r1 = r0.getValue();
            Collections.sort(r1, ColorResourcesTableCreator.access$400());
            this.packageChunks.add(new PackageChunk(r0.getKey(), r1));
            goto L4
        L6:
            this.header = new ResChunkHeader(2, 12, getOverallSize());
        }

        void writeTo(ByteArrayOutputStream r2) throws IOException {
            this.header.writeTo(r2);
            r2.write(ColorResourcesTableCreator.access$500(this.packageCount));
            this.stringPool.writeTo(r2);
            Iterator<PackageChunk> r1 = this.packageChunks.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().writeTo(r2);
            goto L4
        }

        private int getOverallSize() {
            Iterator<PackageChunk> r0 = this.packageChunks.iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L7;
            r1 = r1 + r0.next().getChunkSize();
            goto L4
        L7:
            return (this.stringPool.getChunkSize() + 12) + r1;
        }
    }

    private static class StringPoolChunk {
        private static final int FLAG_UTF8 = 256;
        private static final short HEADER_SIZE = 28;
        private static final int STYLED_SPAN_LIST_END = -1;
        private final int chunkSize;
        private final ResChunkHeader header;
        private final int stringCount;
        private final List<Integer> stringIndex;
        private final List<byte[]> strings;
        private final int stringsPaddingSize;
        private final int stringsStart;
        private final int styledSpanCount;
        private final List<Integer> styledSpanIndex;
        private final List<List<StringStyledSpan>> styledSpans;
        private final int styledSpansStart;
        private final boolean utf8Encode;

        StringPoolChunk(String... r2) {
            this(false, r2);
        }

        StringPoolChunk(boolean r9, String... r10) {
            this.stringIndex = new ArrayList();
            this.styledSpanIndex = new ArrayList();
            this.strings = new ArrayList();
            this.styledSpans = new ArrayList();
            this.utf8Encode = r9;
            int r11 = r10.length;
            int r0 = 0;
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r11) goto L5;
            Pair<byte[], List<StringStyledSpan>> r3 = processString(r10[r1]);
            this.stringIndex.add(Integer.valueOf(r2));
            r2 = r2 + ((byte[]) r3.first).length;
            this.strings.add((byte[]) r3.first);
            this.styledSpans.add((List<StringStyledSpan>) r3.second);
            r1 = r1 + 1;
            goto L3
        L5:
            Iterator<List<StringStyledSpan>> r12 = this.styledSpans.iterator();
            int r4 = 0;
        L7:
            if (r12.hasNext() == false) goto L13;
            List<StringStyledSpan> r5 = r12.next();
            Iterator<StringStyledSpan> r6 = r5.iterator();
        L10:
            if (r6.hasNext() == false) goto L12;
            StringStyledSpan r7 = r6.next();
            this.stringIndex.add(Integer.valueOf(r2));
            r2 = r2 + StringStyledSpan.access$700(r7).length;
            this.strings.add(StringStyledSpan.access$700(r7));
            goto L10
        L12:
            this.styledSpanIndex.add(Integer.valueOf(r4));
            r4 = r4 + ((r5.size() * 12) + 4);
            goto L7
        L13:
            int r13 = r2 % 4;
            if (r13 != 0) goto L16;
            int r14 = 0;
        L17:
            this.stringsPaddingSize = r14;
            int r8 = this.strings.size();
            this.stringCount = r8;
            this.styledSpanCount = this.strings.size() - r10.length;
            if ((this.strings.size() - r10.length) <= 0) goto L20;
            boolean r15 = true;
        L21:
            if (r15 == true) goto L23;
            this.styledSpanIndex.clear();
            this.styledSpans.clear();
        L23:
            int r16 = ((r8 * 4) + 28) + (this.styledSpanIndex.size() * 4);
            this.stringsStart = r16;
            int r17 = r2 + r14;
            if (r15 == false) goto L26;
            int r18 = r16 + r17;
        L27:
            this.styledSpansStart = r18;
            int r19 = r16 + r17;
            if (r15 == false) goto L30;
            r0 = r4;
        L30:
            int r20 = r19 + r0;
            this.chunkSize = r20;
            this.header = new ResChunkHeader(1, HEADER_SIZE, r20);
            return;
        L26:
            r18 = 0;
            goto L27
        L20:
            r15 = false;
            goto L21
        L16:
            r14 = 4 - r13;
            goto L17
        }

        void writeTo(ByteArrayOutputStream r3) throws IOException {
            this.header.writeTo(r3);
            r3.write(ColorResourcesTableCreator.access$500(this.stringCount));
            r3.write(ColorResourcesTableCreator.access$500(this.styledSpanCount));
            if (this.utf8Encode == false) goto L5;
            int r0 = 256;
        L6:
            r3.write(ColorResourcesTableCreator.access$500(r0));
            r3.write(ColorResourcesTableCreator.access$500(this.stringsStart));
            r3.write(ColorResourcesTableCreator.access$500(this.styledSpansStart));
            Iterator<Integer> r1 = this.stringIndex.iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            r3.write(ColorResourcesTableCreator.access$500(r1.next().intValue()));
            goto L8
        L10:
            Iterator<Integer> r2 = this.styledSpanIndex.iterator();
        L12:
            if (r2.hasNext() == false) goto L14;
            r3.write(ColorResourcesTableCreator.access$500(r2.next().intValue()));
            goto L12
        L14:
            Iterator<byte[]> r4 = this.strings.iterator();
        L16:
            if (r4.hasNext() == false) goto L18;
            r3.write(r4.next());
            goto L16
        L18:
            int r5 = this.stringsPaddingSize;
            if (r5 <= 0) goto L21;
            r3.write(new byte[r5]);
        L21:
            Iterator<List<StringStyledSpan>> r6 = this.styledSpans.iterator();
        L23:
            if (r6.hasNext() == false) goto L29;
            Iterator<StringStyledSpan> r7 = r6.next().iterator();
        L26:
            if (r7.hasNext() == false) goto L28;
            r7.next().writeTo(r3);
            goto L26
        L28:
            r3.write(ColorResourcesTableCreator.access$500(-1));
            goto L23
        L29:
            return;
        L5:
            r0 = 0;
            goto L6
        }

        int getChunkSize() {
            return this.chunkSize;
        }

        private Pair<byte[], List<StringStyledSpan>> processString(String r2) {
            if (this.utf8Encode == false) goto L5;
            byte[] r1 = ColorResourcesTableCreator.access$800(r2);
        L7:
            return new Pair(r1, Collections.emptyList());
        L5:
            r1 = ColorResourcesTableCreator.access$900(r2);
            goto L7
        }
    }

    private static class StringStyledSpan {
        private int firstCharacterIndex;
        private int lastCharacterIndex;
        private int nameReference;
        private byte[] styleString;

        private StringStyledSpan() {
        }

        static /* synthetic */ byte[] access$700(StringStyledSpan r0) {
            return r0.styleString;
        }

        void writeTo(ByteArrayOutputStream r2) throws IOException {
            r2.write(ColorResourcesTableCreator.access$500(this.nameReference));
            r2.write(ColorResourcesTableCreator.access$500(this.firstCharacterIndex));
            r2.write(ColorResourcesTableCreator.access$500(this.lastCharacterIndex));
        }
    }

    private static class TypeChunk {
        private static final byte CONFIG_SIZE = 64;
        private static final short HEADER_SIZE = 84;
        private static final int OFFSET_NO_ENTRY = -1;
        private final byte[] config;
        private final int entryCount;
        private final ResChunkHeader header;
        private final int[] offsetTable;
        private final ResEntry[] resEntries;

        TypeChunk(List<ColorResource> r6, Set<Short> r7, int r8) {
            byte[] r1 = new byte[64];
            this.config = r1;
            this.entryCount = r8;
            short r2 = 0;
            r1[0] = 64;
            this.resEntries = new ResEntry[r6.size()];
            int r0 = 0;
        L4:
            if (r0 >= r6.size()) goto L6;
            this.resEntries[r0] = new ResEntry(r0, ColorResource.access$1400(r6.get(r0)));
            r0 = r0 + 1;
            goto L4
        L6:
            this.offsetTable = new int[r8];
            int r9 = 0;
        L7:
            if (r2 >= r8) goto L13;
            if (r7.contains(Short.valueOf(r2)) == false) goto L11;
            this.offsetTable[r2] = r9;
            r9 = r9 + 16;
        L12:
            r2 = (short) (r2 + 1);
            goto L7
        L11:
            this.offsetTable[r2] = -1;
            goto L12
        L13:
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE, HEADER_SIZE, getChunkSize());
        }

        void writeTo(ByteArrayOutputStream r6) throws IOException {
            this.header.writeTo(r6);
            int r2 = 0;
            r6.write(new byte[]{ColorResourcesTableCreator.access$1300(), 0, 0, 0});
            r6.write(ColorResourcesTableCreator.access$500(this.entryCount));
            r6.write(ColorResourcesTableCreator.access$500(getEntryStart()));
            r6.write(this.config);
            int[] r0 = this.offsetTable;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r6.write(ColorResourcesTableCreator.access$500(r0[r3]));
            r3 = r3 + 1;
            goto L3
        L5:
            ResEntry[] r5 = this.resEntries;
            int r4 = r5.length;
        L6:
            if (r2 >= r4) goto L8;
            r5[r2].writeTo(r6);
            r2 = r2 + 1;
            goto L6
        }

        int getChunkSize() {
            return getEntryStart() + (this.resEntries.length * 16);
        }

        private int getEntryStart() {
            return getOffsetTableSize() + 84;
        }

        private int getOffsetTableSize() {
            return this.offsetTable.length * 4;
        }
    }

    private static class TypeSpecChunk {
        private static final short HEADER_SIZE = 16;
        private static final int SPEC_PUBLIC = 1073741824;
        private final int entryCount;
        private final int[] entryFlags;
        private final ResChunkHeader header;
        private final TypeChunk typeChunk;

        TypeSpecChunk(List<ColorResource> r6) {
            this.entryCount = ColorResource.access$000(r6.get(r6.size() - 1)) + 1;
            HashSet r0 = new HashSet();
            Iterator<ColorResource> r1 = r6.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.add(Short.valueOf(ColorResource.access$000(r1.next())));
            goto L4
        L6:
            this.entryFlags = new int[this.entryCount];
            short r2 = 0;
        L8:
            if (r2 >= this.entryCount) goto L13;
            if (r0.contains(Short.valueOf(r2)) == false) goto L12;
            this.entryFlags[r2] = 1073741824;
        L12:
            r2 = (short) (r2 + 1);
            goto L8
        L13:
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE_SPEC, 16, getChunkSize());
            this.typeChunk = new TypeChunk(r6, r0, this.entryCount);
        }

        void writeTo(ByteArrayOutputStream r5) throws IOException {
            this.header.writeTo(r5);
            int r2 = 0;
            r5.write(new byte[]{ColorResourcesTableCreator.access$1300(), 0, 0, 0});
            r5.write(ColorResourcesTableCreator.access$500(this.entryCount));
            int[] r0 = this.entryFlags;
            int r1 = r0.length;
        L3:
            if (r2 >= r1) goto L5;
            r5.write(ColorResourcesTableCreator.access$500(r0[r2]));
            r2 = r2 + 1;
            goto L3
        L5:
            this.typeChunk.writeTo(r5);
        }

        int getChunkSizeWithTypeChunk() {
            return getChunkSize() + this.typeChunk.getChunkSize();
        }

        private int getChunkSize() {
            return (this.entryCount * 4) + 16;
        }
    }

    private static byte[] charToByteArray(char r3) {
        return new byte[]{(byte) (r3 & 255), (byte) ((r3 >> '\b') & 255)};
    }

    private static byte[] intToByteArray(int r3) {
        return new byte[]{(byte) (r3 & 255), (byte) ((r3 >> 8) & 255), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 24) & 255)};
    }

    private static byte[] shortToByteArray(short r3) {
        return new byte[]{(byte) (r3 & 255), (byte) ((r3 >> 8) & 255)};
    }

    static /* synthetic */ byte[] access$1200(char r0) {
        return charToByteArray(r0);
    }

    static /* synthetic */ byte access$1300() {
        return typeIdColor;
    }

    static /* synthetic */ Comparator access$400() {
        return COLOR_RESOURCE_COMPARATOR;
    }

    static /* synthetic */ byte[] access$500(int r0) {
        return intToByteArray(r0);
    }

    static /* synthetic */ byte[] access$600(short r0) {
        return shortToByteArray(r0);
    }

    static /* synthetic */ byte[] access$800(String r0) {
        return stringToByteArrayUtf8(r0);
    }

    static /* synthetic */ byte[] access$900(String r0) {
        return stringToByteArray(r0);
    }

    private ColorResourcesTableCreator() {
    }

    static {
        ANDROID_PACKAGE_INFO = new PackageInfo(1, RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        COLOR_RESOURCE_COMPARATOR = new AnonymousClass1();
    }

    static byte[] create(Context r8, Map<Integer, Integer> r9) throws IOException {
        if (r9.entrySet().isEmpty() == true) goto L30;
        PackageInfo r0 = new PackageInfo(127, r8.getPackageName());
        HashMap r1 = new HashMap();
        Iterator<Map.Entry<Integer, Integer>> r10 = r9.entrySet().iterator();
        ColorResource r3 = null;
    L6:
        if (r10.hasNext() == false) goto L23;
        Map.Entry<Integer, Integer> r4 = r10.next();
        ColorResource r5 = new ColorResource(r4.getKey().intValue(), r8.getResources().getResourceName(r4.getKey().intValue()), r4.getValue().intValue());
        if (r8.getResources().getResourceTypeName(r4.getKey().intValue()).equals("color") == false) goto L22;
        if (ColorResource.access$300(r5) != 1) goto L13;
        PackageInfo r6 = ANDROID_PACKAGE_INFO;
    L16:
        if (r1.containsKey(r6) == true) goto L18;
        r1.put(r6, new ArrayList());
    L18:
        ((List) r1.get(r6)).add(r5);
        r3 = r5;
        goto L6
    L13:
        if (ColorResource.access$300(r5) != 127) goto L20;
        r6 = r0;
        goto L16
    L20:
        throw new IllegalArgumentException("Not supported with unknown package id: " + ColorResource.access$300(r5));
    L22:
        throw new IllegalArgumentException("Non color resource found: name=" + ColorResource.access$100(r5) + ", typeId=" + Integer.toHexString(ColorResource.access$200(r5) & 255));
    L23:
        byte r11 = ColorResource.access$200(r3);
        typeIdColor = r11;
        if (r11 == 0) goto L28;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        new ResTable(r1).writeTo(r12);
        return r12.toByteArray();
    L28:
        throw new IllegalArgumentException("No color resources found for harmonization.");
    L30:
        throw new IllegalArgumentException("No color resources provided for harmonization.");
    }

    private static byte[] stringToByteArray(String r9) {
        char[] r10 = r9.toCharArray();
        int r0 = (r10.length * 2) + 4;
        byte[] r1 = new byte[r0];
        byte[] r2 = shortToByteArray((short) r10.length);
        r1[0] = r2[0];
        r1[1] = r2[1];
        int r3 = 0;
    L4:
        if (r3 >= r10.length) goto L6;
        byte[] r5 = charToByteArray(r10[r3]);
        int r6 = r3 * 2;
        r1[r6 + 2] = r5[0];
        r1[r6 + 3] = r5[1];
        r3 = r3 + 1;
        goto L4
    L6:
        r1[r0 - 2] = 0;
        r1[r0 - 1] = 0;
        return r1;
    }

    private static byte[] stringToByteArrayUtf8(String r5) {
        byte[] r6 = r5.getBytes(Charset.forName("UTF-8"));
        byte r0 = (byte) r6.length;
        int r1 = r6.length + 3;
        byte[] r2 = new byte[r1];
        System.arraycopy(r6, 0, r2, 2, r0);
        r2[1] = r0;
        r2[0] = r0;
        r2[r1 - 1] = 0;
        return r2;
    }
}
