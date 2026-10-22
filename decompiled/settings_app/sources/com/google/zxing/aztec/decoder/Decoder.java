package com.google.zxing.aztec.decoder;

import android.icu.text.DateFormat;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.ApnEditor;
import com.android.settings.CustomKeyUtils;
import com.android.settings.search.Index;
import com.android.settings.utils.HanziToPinyin;
import com.android.vcard.VCardConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Arrays;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes4.dex */
public final class Decoder {
    private static final String[] DIGIT_TABLE = null;
    private static final String[] LOWER_TABLE = null;
    private static final String[] MIXED_TABLE = null;
    private static final String[] PUNCT_TABLE = null;
    private static final String[] UPPER_TABLE = null;
    private AztecDetectorResult ddata;

    /* JADX INFO: renamed from: com.google.zxing.aztec.decoder.Decoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = null;

        static {
            int[] r0 = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = r0;
            r0[Table.UPPER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static final enum Table extends Enum<Table> {
        private static final /* synthetic */ Table[] $VALUES = null;
        public static final Table BINARY = null;
        public static final Table DIGIT = null;
        public static final Table LOWER = null;
        public static final Table MIXED = null;
        public static final Table PUNCT = null;
        public static final Table UPPER = null;

        private Table(String r1, int r2) {
            super(r1, r2);
        }

        public static Table valueOf(String r1) {
            return (Table) Enum.valueOf(Table.class, r1);
        }

        public static Table[] values() {
            return (Table[]) $VALUES.clone();
        }

        static {
            Table r0 = new Table("UPPER", 0);
            UPPER = r0;
            Table r1 = new Table("LOWER", 1);
            LOWER = r1;
            Table r3 = new Table("MIXED", 2);
            MIXED = r3;
            Table r5 = new Table("DIGIT", 3);
            DIGIT = r5;
            Table r7 = new Table("PUNCT", 4);
            PUNCT = r7;
            Table r9 = new Table("BINARY", 5);
            BINARY = r9;
            $VALUES = new Table[]{r0, r1, r3, r5, r7, r9};
        }
    }

    private static int totalBitsInLayer(int r1, boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 88;
    L6:
        return (r3 + (r1 << 4)) * r1;
    L4:
        r3 = 112;
        goto L6
    }

    public Decoder() {
    }

    static {
        UPPER_TABLE = new String[]{"CTRL_PS", HanziToPinyin.Token.SEPARATOR, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, VCardConstants.PARAM_ENCODING_B, "C", "D", "E", "F", "G", DateFormat.HOUR24, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
        LOWER_TABLE = new String[]{"CTRL_PS", HanziToPinyin.Token.SEPARATOR, "a", "b", "c", "d", "e", "f", "g", "h", "i", DateFormat.HOUR, "k", "l", DateFormat.MINUTE, "n", "o", "p", "q", "r", DateFormat.SECOND, "t", "u", "v", "w", MaterialConfigFormatNames.X, "y", DateFormat.ABBR_SPECIFIC_TZ, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
        MIXED_TABLE = new String[]{"CTRL_PS", HanziToPinyin.Token.SEPARATOR, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", Index.ENTRIES_SEPARATOR, "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
        PUNCT_TABLE = new String[]{"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", ApnEditor.APN_TYPE_ALL, CustomKeyUtils.KEY_SEPARATE_FOR_SHOW, ",", "-", ".", LibrarianImpl.Constants.SEPARATOR, ":", ";", "<", "=", ">", "?", "[", "]", VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, "CTRL_UL"};
        DIGIT_TABLE = new String[]{"CTRL_PS", HanziToPinyin.Token.SEPARATOR, "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    }

    public DecoderResult decode(AztecDetectorResult r4) throws FormatException {
        this.ddata = r4;
        boolean[] r3 = correctBits(extractBits(r4.getBits()));
        DecoderResult r1 = new DecoderResult(convertBoolArrayToByteArray(r3), getEncodedData(r3), null, null);
        r1.setNumBits(r3.length);
        return r1;
    }

    public static String highLevelDecode(boolean[] r0) {
        return getEncodedData(r0);
    }

    private static String getEncodedData(boolean[] r10) {
        int r0 = r10.length;
        Table r1 = Table.UPPER;
        Table r2 = Table.UPPER;
        StringBuilder r3 = new StringBuilder(20);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L34;
        if (r2 == Table.BINARY) goto L7;
        if (r2 != Table.DIGIT) goto L23;
        int r6 = 4;
    L25:
        if ((r0 - r5) < r6) goto L34;
        int r8 = readCode(r10, r5, r6);
        r5 = r5 + r6;
        String r7 = getCharacter(r2, r8);
        if (r7.startsWith("CTRL_") == false) goto L32;
        r1 = getTable(r7.charAt(5));
        if (r7.charAt(6) == 'L') goto L19;
        Table r9 = r2;
        r2 = r1;
        r1 = r9;
    L19:
        r2 = r1;
        goto L3
    L32:
        r3.append(r7);
        goto L19
    L23:
        r6 = 5;
        goto L25
    L7:
        if ((r0 - r5) < 5) goto L34;
        int r4 = readCode(r10, r5, 5);
        r5 = r5 + 5;
        if (r4 == 0) goto L11;
    L13:
        int r11 = 0;
    L14:
        if (r11 >= r4) goto L19;
        if ((r0 - r5) < 8) goto L17;
        r3.append((char) readCode(r10, r5, 8));
        r5 = r5 + 8;
        r11 = r11 + 1;
        goto L14
    L17:
        r5 = r0;
        goto L19
    L11:
        if ((r0 - r5) < 11) goto L34;
        r4 = readCode(r10, r5, 11) + 31;
        r5 = r5 + 11;
    L34:
        return r3.toString();
    }

    private static Table getTable(char r1) {
        if (r1 == 'B') goto L23;
        if (r1 == 'D') goto L21;
        if (r1 == 'P') goto L19;
        if (r1 == 'L') goto L17;
        if (r1 == 'M') goto L15;
        return Table.UPPER;
    L15:
        return Table.MIXED;
    L17:
        return Table.LOWER;
    L19:
        return Table.PUNCT;
    L21:
        return Table.DIGIT;
    L23:
        return Table.BINARY;
    }

    private static String getCharacter(Table r1, int r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[r1.ordinal()];
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L21;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L17;
        if (r3 != 5) goto L15;
        return DIGIT_TABLE[r2];
    L15:
        throw new IllegalStateException("Bad table");
    L17:
        return PUNCT_TABLE[r2];
    L19:
        return MIXED_TABLE[r2];
    L21:
        return LOWER_TABLE[r2];
    L23:
        return UPPER_TABLE[r2];
    }

    private boolean[] correctBits(boolean[] r12) throws FormatException {
        if (this.ddata.getNbLayers() > 2) goto L5;
        GenericGF r0 = GenericGF.AZTEC_DATA_6;
        int r1 = 6;
    L12:
        int r11 = this.ddata.getNbDatablocks();
        int r2 = r12.length / r1;
        if (r2 < r11) goto L55;
        int r3 = r12.length % r1;
        int[] r4 = new int[r2];
        int r6 = 0;
    L15:
        if (r6 >= r2) goto L56;
        r4[r6] = readCode(r12, r3, r1);
        r6 = r6 + 1;
        r3 = r3 + r1;
        goto L15
    L56:
        new ReedSolomonDecoder(r0).decode(r4, r2 - r11);     // Catch: ReedSolomonException -> L51
        int r5 = (1 << r1) - 1;
        int r7 = 0;
        int r8 = 0;
    L19:
        if (r7 >= r11) goto L30;
        int r9 = r4[r7];
        if (r9 == 0) goto L29;
        if (r9 == r5) goto L29;
        if (r9 != 1) goto L25;
    L26:
        r8 = r8 + 1;
    L27:
        r7 = r7 + 1;
        goto L19
    L25:
        if (r9 != (r5 - 1)) goto L27;
    L29:
        throw FormatException.getFormatInstance();
    L30:
        boolean[] r10 = new boolean[(r11 * r1) - r8];
        int r13 = 0;
        int r14 = 0;
    L31:
        if (r13 >= r11) goto L50;
        int r15 = r4[r13];
        if (r15 != 1) goto L35;
    L44:
        int r16 = (r14 + r1) - 1;
        if (r15 <= 1) goto L47;
        boolean r17 = true;
    L48:
        Arrays.fill(r10, r14, r16, r17);
        r14 = r14 + (r1 - 1);
    L49:
        r13 = r13 + 1;
        goto L31
    L47:
        r17 = false;
        goto L48
    L35:
        if (r15 == (r5 - 1)) goto L44;
        int r18 = r1 - 1;
    L38:
        if (r18 < 0) goto L49;
        int r19 = r14 + 1;
        if (((1 << r18) & r15) == 0) goto L42;
        boolean r110 = true;
    L43:
        r10[r14] = r110;
        r18 = r18 - 1;
        r14 = r19;
        goto L38
    L42:
        r110 = false;
        goto L43
    L50:
        return r10;
    L51:
        e = move-exception;
        throw FormatException.getFormatInstance(e);
    L55:
        throw FormatException.getFormatInstance();
    L5:
        r1 = 8;
        if (this.ddata.getNbLayers() > 8) goto L9;
        r0 = GenericGF.AZTEC_DATA_8;
        goto L12
    L9:
        if (this.ddata.getNbLayers() > 22) goto L11;
        r0 = GenericGF.AZTEC_DATA_10;
        r1 = 10;
        goto L12
    L11:
        r0 = GenericGF.AZTEC_DATA_12;
        r1 = 12;
        goto L12
    }

    private boolean[] extractBits(BitMatrix r20) {
        boolean r2 = this.ddata.isCompact();
        int r0 = this.ddata.getNbLayers();
        if (r2 == false) goto L5;
        int r3 = 11;
    L6:
        int r4 = r3 + (r0 << 2);
        int[] r5 = new int[r4];
        boolean[] r6 = new boolean[totalBitsInLayer(r0, r2)];
        int r7 = 2;
        if (r2 == false) goto L11;
        int r8 = 0;
    L9:
        if (r8 >= r4) goto L14;
        r5[r8] = r8;
        r8 = r8 + 1;
    L14:
        int r9 = 0;
        int r10 = 0;
    L15:
        if (r9 >= r0) goto L27;
        int r11 = (r0 - r9) << r7;
        if (r2 == false) goto L19;
        int r12 = 9;
    L20:
        int r13 = r11 + r12;
        int r14 = r9 << 1;
        int r15 = (r4 - 1) - r14;
        int r16 = 0;
    L21:
        if (r16 >= r13) goto L26;
        int r17 = r16 << 1;
        int r18 = 0;
    L23:
        if (r18 >= r7) goto L25;
        int r19 = r14 + r18;
        int r110 = r14 + r16;
        r6[(r10 + r17) + r18] = r20.get(r5[r19], r5[r110]);
        int r21 = r5[r110];
        int r111 = r15 - r18;
        r6[(((r13 * 2) + r10) + r17) + r18] = r20.get(r21, r5[r111]);
        int r22 = r5[r111];
        int r23 = r15 - r16;
        r6[(((r13 * 4) + r10) + r17) + r18] = r20.get(r22, r5[r23]);
        r6[(((r13 * 6) + r10) + r17) + r18] = r20.get(r5[r23], r5[r19]);
        r18 = r18 + 1;
        r2 = r2;
        r0 = r0;
        r7 = 2;
        goto L23
    L25:
        r16 = r16 + 1;
        r7 = 2;
        goto L21
    L26:
        r10 = r10 + (r13 << 3);
        r9 = r9 + 1;
        r0 = r0;
        r7 = 2;
        goto L15
    L19:
        r12 = 12;
        goto L20
    L27:
        return r6;
    L11:
        int r24 = r4 / 2;
        int r25 = ((r4 + 1) + (((r24 - 1) / 15) * 2)) / 2;
        int r112 = 0;
    L12:
        if (r112 >= r24) goto L14;
        int r113 = (r112 / 15) + r112;
        r5[(r24 - r112) - 1] = (r25 - r113) - 1;
        r5[r24 + r112] = (r113 + r25) + 1;
        r112 = r112 + 1;
        goto L12
    L5:
        r3 = 14;
        goto L6
    }

    private static int readCode(boolean[] r3, int r4, int r5) {
        int r0 = 0;
        int r1 = r4;
    L4:
        if (r1 >= (r4 + r5)) goto L9;
        r0 = r0 << 1;
        if (r3[r1] == false) goto L8;
        r0 = r0 | 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private static byte readByte(boolean[] r2, int r3) {
        int r0 = r2.length - r3;
        if (r0 < 8) goto L7;
        int r4 = readCode(r2, r3, 8);
    L6:
        return (byte) r4;
    L7:
        r4 = readCode(r2, r3, r0) << (8 - r0);
        goto L6
    }

    static byte[] convertBoolArrayToByteArray(boolean[] r4) {
        int r0 = (r4.length + 7) / 8;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = readByte(r4, r2 << 3);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
