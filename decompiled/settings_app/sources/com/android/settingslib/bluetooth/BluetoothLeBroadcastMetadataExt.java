package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothLeAudioCodecConfigMetadata;
import android.bluetooth.BluetoothLeAudioContentMetadata;
import android.bluetooth.BluetoothLeBroadcastChannel;
import android.bluetooth.BluetoothLeBroadcastMetadata;
import android.bluetooth.BluetoothLeBroadcastSubgroup;
import android.util.Base64;
import com.GlobalProxyLancet;
import com.android.settingslib.accessibility.AccessibilityUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: compiled from: BluetoothLeBroadcastMetadataExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\tJ-\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b&J%\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002ø\u0001\u0000J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\tH\u0003J\n\u0010,\u001a\u00020\t*\u00020\u001fJ&\u0010,\u001a\u00020\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0(0\"2\u0006\u0010-\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006X\u0082Tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Lcom/android/settingslib/bluetooth/BluetoothLeBroadcastMetadataExt;", "", "()V", "BIS_SYNC_MAX_CHANNEL", "", "BIS_SYNC_NO_PREFERENCE", "Lkotlin/UInt;", "I", "DELIMITER_ELEMENT", "", "DELIMITER_KEY_VALUE", "KEY_BTSG_BIS_SYNC", "KEY_BTSG_METADATA", "KEY_BTSG_NUM_BISES", "KEY_BTVSD_VENDOR_DATA", "KEY_BT_ADVERTISER_ADDRESS", "KEY_BT_ADVERTISER_ADDRESS_TYPE", "KEY_BT_ADVERTISING_SID", "KEY_BT_BROADCAST_CODE", "KEY_BT_BROADCAST_ID", "KEY_BT_BROADCAST_NAME", "KEY_BT_HIGH_QUALITY", "KEY_BT_NUM_SUBGROUPS", "KEY_BT_PA_INTERVAL", "KEY_BT_STANDARD_QUALITY", "KEY_BT_STREAM_METADATA", "SUBGROUP_LC3_CODEC_ID", "", "SUFFIX_QR_CODE", "TAG", "convertToBroadcastMetadata", "Landroid/bluetooth/BluetoothLeBroadcastMetadata;", "qrCodeString", "convertToChannels", "", "Landroid/bluetooth/BluetoothLeBroadcastChannel;", "bisSync", "bisNum", "convertToChannels-1A3ddvw", "getBisSyncFromChannels", "Lkotlin/Pair;", "channels", "parseQrCodeToMetadata", "input", "toQrCodeString", "delimiter", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BluetoothLeBroadcastMetadataExt {
    private static final int BIS_SYNC_MAX_CHANNEL = 32;
    private static final int BIS_SYNC_NO_PREFERENCE = -1;
    private static final String DELIMITER_ELEMENT = ";";
    private static final String DELIMITER_KEY_VALUE = ":";
    public static final BluetoothLeBroadcastMetadataExt INSTANCE = null;
    private static final String KEY_BTSG_BIS_SYNC = "BS";
    private static final String KEY_BTSG_METADATA = "SM";
    private static final String KEY_BTSG_NUM_BISES = "NB";
    private static final String KEY_BTVSD_VENDOR_DATA = "VS";
    private static final String KEY_BT_ADVERTISER_ADDRESS = "AD";
    private static final String KEY_BT_ADVERTISER_ADDRESS_TYPE = "AT";
    private static final String KEY_BT_ADVERTISING_SID = "AS";
    private static final String KEY_BT_BROADCAST_CODE = "BC";
    private static final String KEY_BT_BROADCAST_ID = "BI";
    private static final String KEY_BT_BROADCAST_NAME = "BN";
    private static final String KEY_BT_HIGH_QUALITY = "HQ";
    private static final String KEY_BT_NUM_SUBGROUPS = "NS";
    private static final String KEY_BT_PA_INTERVAL = "PI";
    private static final String KEY_BT_STANDARD_QUALITY = "SQ";
    private static final String KEY_BT_STREAM_METADATA = "MD";
    private static final long SUBGROUP_LC3_CODEC_ID = 6;
    private static final String SUFFIX_QR_CODE = ";;";
    private static final String TAG = "BtLeBroadcastMetadataExt";

    static {
        INSTANCE = new BluetoothLeBroadcastMetadataExt();
    }

    private BluetoothLeBroadcastMetadataExt() {
    }

    public final String toQrCodeString(BluetoothLeBroadcastMetadata r17) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        ArrayList r0 = new ArrayList();
        if (r17.getBroadcastName() == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L47;
        String r5 = r17.getBroadcastName();
        byte[] r6 = null;
        if (r5 == null) goto L10;
        byte[] r7 = r5.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).getBytes(charset)");
    L11:
        r0.add(new Pair(KEY_BT_BROADCAST_NAME, Base64.encodeToString(r7, 2)));
        r0.add(new Pair(KEY_BT_ADVERTISER_ADDRESS_TYPE, String.valueOf(r17.getSourceAddressType())));
        String r8 = r17.getSourceDevice().getAddress();
        Intrinsics.checkNotNullExpressionValue(r8, "this.sourceDevice.address");
        r0.add(new Pair(KEY_BT_ADVERTISER_ADDRESS, StringsKt.replace$default(r8, ":", "", false, 4, null)));
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        String r10 = String.format("%X", Arrays.copyOf(new Object[]{Long.valueOf(r17.getBroadcastId())}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(format, *args)");
        r0.add(new Pair(KEY_BT_BROADCAST_ID, r10));
        if (r17.getBroadcastCode() == null) goto L15;
        r0.add(new Pair(KEY_BT_BROADCAST_CODE, Base64.encodeToString(r17.getBroadcastCode(), 2)));
    L15:
        if (r17.getPublicBroadcastMetadata() == null) goto L30;
        BluetoothLeAudioContentMetadata r3 = r17.getPublicBroadcastMetadata();
        if (r3 == null) goto L23;
        byte[] r4 = r3.getRawMetadata();
        if (r4 == null) goto L23;
        if (r4.length != 0) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == true) goto L30;
        BluetoothLeAudioContentMetadata r12 = r17.getPublicBroadcastMetadata();
        if (r12 == null) goto L28;
        r6 = r12.getRawMetadata();
    L28:
        r0.add(new Pair(KEY_BT_STREAM_METADATA, Base64.encodeToString(r6, 2)));
    L23:
        r11 = false;
    L30:
        if ((r17.getAudioConfigQuality() & 1) == 0) goto L33;
        r0.add(new Pair(KEY_BT_STANDARD_QUALITY, "1"));
    L33:
        if ((r17.getAudioConfigQuality() & 2) == 0) goto L35;
        r0.add(new Pair(KEY_BT_HIGH_QUALITY, "1"));
    L35:
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        String r14 = String.format("%X", Arrays.copyOf(new Object[]{Long.valueOf(r17.getSourceAdvertisingSid())}, 1));
        Intrinsics.checkNotNullExpressionValue(r14, "format(format, *args)");
        r0.add(new Pair(KEY_BT_ADVERTISING_SID, r14));
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        String r16 = String.format("%X", Arrays.copyOf(new Object[]{Long.valueOf(r17.getPaSyncInterval())}, 1));
        Intrinsics.checkNotNullExpressionValue(r16, "format(format, *args)");
        r0.add(new Pair(KEY_BT_PA_INTERVAL, r16));
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        String r19 = String.format("%X", Arrays.copyOf(new Object[]{Long.valueOf(r17.getSubgroups().size())}, 1));
        Intrinsics.checkNotNullExpressionValue(r19, "format(format, *args)");
        r0.add(new Pair(KEY_BT_NUM_SUBGROUPS, r19));
        List r1 = r17.getSubgroups();
        Intrinsics.checkNotNullExpressionValue(r1, "this.subgroups");
        Iterator r20 = r1.iterator();
    L37:
        if (r20.hasNext() == false) goto L44;
        BluetoothLeBroadcastSubgroup r21 = (BluetoothLeBroadcastSubgroup) r20.next();
        BluetoothLeBroadcastMetadataExt r22 = INSTANCE;
        List<BluetoothLeBroadcastChannel> r23 = r21.getChannels();
        Intrinsics.checkNotNullExpressionValue(r23, "it.channels");
        Pair<UInt, UInt> r24 = r22.getBisSyncFromChannels(r23);
        int r25 = r24.component1().m1655unboximpl();
        int r26 = r24.component2().m1655unboximpl();
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        String r27 = String.format("%X", Arrays.copyOf(new Object[]{Long.valueOf(((long) r25) & 4294967295L)}, 1));
        Intrinsics.checkNotNullExpressionValue(r27, "format(format, *args)");
        r0.add(new Pair(KEY_BTSG_BIS_SYNC, r27));
        if (Integer.compareUnsigned(r26, 0) <= 0) goto L42;
        StringCompanionObject r111 = StringCompanionObject.INSTANCE;
        String r28 = String.format("%X", Arrays.copyOf(new Object[]{Long.valueOf(((long) r26) & 4294967295L)}, 1));
        Intrinsics.checkNotNullExpressionValue(r28, "format(format, *args)");
        r0.add(new Pair(KEY_BTSG_NUM_BISES, r28));
    L42:
        if (r21.getContentMetadata().getRawMetadata().length == 0) goto L37;
        r0.add(new Pair(KEY_BTSG_METADATA, Base64.encodeToString(r21.getContentMetadata().getRawMetadata(), 2)));
        goto L37
    L44:
        String r29 = BluetoothBroadcastUtils.SCHEME_BT_BROADCAST_METADATA + toQrCodeString(r0, DELIMITER_ELEMENT) + SUFFIX_QR_CODE;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Generated QR string : " + r29);
        return r29;
    L10:
        r7 = null;
        goto L11
    L47:
        throw new IllegalArgumentException("Broadcast name is mandatory for QR code".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final BluetoothLeBroadcastMetadata convertToBroadcastMetadata(String r7) {
        Intrinsics.checkNotNullParameter(r7, "qrCodeString");
        if (StringsKt.startsWith$default(r7, BluetoothBroadcastUtils.SCHEME_BT_BROADCAST_METADATA, false, 2, null) == true) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "String \"" + r7 + "\" does not begin with \"BLUETOOTH:UUID:184F;\"");
        return null;
    L11:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Parsing QR string: " + r7);     // Catch: Exception -> L8
        String r1 = StringsKt.removeSuffix(StringsKt.removePrefix(r7, BluetoothBroadcastUtils.SCHEME_BT_BROADCAST_METADATA), SUFFIX_QR_CODE);     // Catch: Exception -> L8
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Stripped to: " + r1);     // Catch: Exception -> L8
        return parseQrCodeToMetadata(r1);
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Cannot parse: " + r7, e);
        BluetoothLeBroadcastMetadata r6 = (BluetoothLeBroadcastMetadata) null;
        return null;
    }

    private final String toQrCodeString(List<Pair<String, String>> r10, String r11) {
        List<Pair<String, String>> r12 = r10;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Pair r0 = (Pair) r13.next();
        r9.add(((String) r0.getFirst()) + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + ((String) r0.getSecond()));
        goto L4
    L7:
        return CollectionsKt.joinToString$default(r9, r11, null, null, 0, null, null, 62, null);
    }

    private final BluetoothLeBroadcastMetadata parseQrCodeToMetadata(String r38) {
        List r1 = StringsKt.split$default(r38, new String[]{DELIMITER_ELEMENT}, false, 0, 6, null);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L3:
        String r4 = ":";
        if (r3.hasNext() == false) goto L6;
        r2.add(StringsKt.split$default((String) r3.next(), new String[]{":"}, false, 2, 2, null));
        goto L3
    L6:
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        BluetoothLeBroadcastMetadata.Builder r8 = new BluetoothLeBroadcastMetadata.Builder();
        Iterator r9 = r2.iterator();
        int r10 = -1;
        byte[] r11 = null;
        int r12 = -1;
        int r13 = 65535;
        String r14 = null;
        int r15 = -1;
        int r16 = -1;
        String r17 = null;
        BluetoothLeAudioContentMetadata r18 = null;
        int r19 = -1;
        int r20 = -1;
    L8:
        if (r9.hasNext() == false) goto L164;
        List r21 = (List) r9.next();
        if (r21.isEmpty() == true) goto L11;
        Iterator r22 = r9;
        String r23 = (String) r21.get(0);
        String r24 = r4;
        String r26 = r14;
        if (r21.size() <= 1) goto L17;
        String r25 = (String) r21.get(1);
    L19:
        switch(r23.hashCode()) {
            case 2083: goto L151;
            case 2098: goto L140;
            case 2099: goto L129;
            case 2113: goto L111;
            case 2119: goto L99;
            case 2124: goto L89;
            case 2129: goto L85;
            case 2313: goto L72;
            case 2455: goto L62;
            case 2484: goto L58;
            case 2501: goto L48;
            case 2553: goto L37;
            case 2650: goto L33;
            case 2654: goto L22;
            default: goto L12;
        };
    L151:
        r6 = r6;
        r19 = r19;
        int r27 = r20;
        ArrayList r110 = r7;
        if (r23.equals(KEY_BT_ADVERTISER_ADDRESS) == false) goto L161;
        if (r26 != null) goto L156;
        boolean r28 = true;
    L157:
        if (r28 == false) goto L160;
        String r29 = CollectionsKt.joinToString$default(StringsKt.chunked(r25, 2), r24, null, null, 0, null, null, 62, null);
        r20 = r27;
        r7 = r110;
        r4 = r24;
        r6 = r6;
        r19 = r19;
        r14 = r29;
        r9 = r22;
        goto L8
    L160:
        throw new IllegalArgumentException(("Duplicate sourceAddr: " + r38).toString());
    L156:
        r28 = false;
    L161:
        r20 = r27;
        r7 = r110;
        r9 = r22;
        r4 = r24;
        r6 = r6;
    L162:
        r19 = r19;
    L163:
        r14 = r26;
        goto L8
    L22:
        if (r23.equals(KEY_BT_STANDARD_QUALITY) == false) goto L12;
        if (r10 != (-1)) goto L27;
        boolean r30 = true;
    L28:
        if (r30 == false) goto L31;
        r10 = Integer.parseInt(r25);
    L82:
        r9 = r22;
        r4 = r24;
        goto L163
    L31:
        throw new IllegalArgumentException(("Duplicate audioConfigQualityStandard: " + r38).toString());
    L27:
        r30 = false;
        goto L28
    L33:
        if (r23.equals(KEY_BTSG_METADATA) == false) goto L12;
        r7.add(Base64.decode(r25, 2));
        goto L12
    L37:
        if (r23.equals(KEY_BT_PA_INTERVAL) == false) goto L12;
        if (r12 != (-1)) goto L42;
        boolean r31 = true;
    L43:
        if (r31 == false) goto L46;
        r12 = Integer.parseInt(r25, CharsKt.checkRadix(16));
        goto L82
    L46:
        throw new IllegalArgumentException(("Duplicate paSyncInterval: " + r38).toString());
    L42:
        r31 = false;
        goto L43
    L48:
        if (r23.equals(KEY_BT_NUM_SUBGROUPS) == false) goto L12;
        if (r20 != (-1)) goto L53;
        boolean r32 = true;
    L54:
        if (r32 == false) goto L57;
        r20 = Integer.parseInt(r25, CharsKt.checkRadix(16));
        goto L82
    L57:
        throw new IllegalArgumentException(("Duplicate numSubgroups: " + r38).toString());
    L53:
        r32 = false;
        goto L54
    L58:
        r27 = r20;
        if (r23.equals(KEY_BTSG_NUM_BISES) == false) goto L74;
        r6.add(UInt.m1597boximpl(UStringsKt.toUInt(r25, 16)));
    L74:
        r6 = r6;
    L13:
        r110 = r7;
        goto L161
    L62:
        r27 = r20;
        if (r23.equals(KEY_BT_STREAM_METADATA) == false) goto L74;
        if (r18 != null) goto L67;
        boolean r210 = true;
    L68:
        if (r210 == false) goto L71;
        r18 = BluetoothLeAudioContentMetadata.fromRawBytes(Base64.decode(r25, 2));
    L81:
        r20 = r27;
        goto L82
    L71:
        throw new IllegalArgumentException(("Duplicate streamMetadata " + r38).toString());
    L67:
        r210 = false;
        goto L68
    L72:
        r27 = r20;
        if (r23.equals(KEY_BT_HIGH_QUALITY) == false) goto L74;
        if (r19 != (-1)) goto L78;
        boolean r211 = true;
    L79:
        if (r211 == false) goto L84;
        r19 = Integer.parseInt(r25);
        goto L81
    L84:
        throw new IllegalArgumentException(("Duplicate audioConfigQualityHigh: " + r38).toString());
    L78:
        r211 = false;
        goto L79
    L85:
        r19 = r19;
        r27 = r20;
        r110 = r7;
        if (r23.equals(KEY_BTSG_BIS_SYNC) == false) goto L113;
        r5.add(UInt.m1597boximpl(UStringsKt.toUInt(r25, 16)));
    L113:
        r6 = r6;
        goto L161
    L89:
        r19 = r19;
        r27 = r20;
        r110 = r7;
        if (r23.equals(KEY_BT_BROADCAST_NAME) == false) goto L113;
        if (r17 != null) goto L94;
        boolean r212 = true;
    L95:
        if (r212 == false) goto L98;
        byte[] r33 = Base64.decode(r25, 2);
        Intrinsics.checkNotNullExpressionValue(r33, "decode(value, Base64.NO_WRAP)");
        r17 = new String(r33, Charsets.UTF_8);
    L108:
        r20 = r27;
        r7 = r110;
        r9 = r22;
        r4 = r24;
        goto L162
    L98:
        throw new IllegalArgumentException(("Duplicate broadcastName: " + r38).toString());
    L94:
        r212 = false;
        goto L95
    L99:
        r19 = r19;
        r27 = r20;
        r110 = r7;
        if (r23.equals(KEY_BT_BROADCAST_ID) == false) goto L113;
        if (r16 != (-1)) goto L105;
        boolean r213 = true;
    L106:
        if (r213 == false) goto L110;
        r16 = Integer.parseInt(r25, CharsKt.checkRadix(16));
        goto L108
    L110:
        throw new IllegalArgumentException(("Duplicate broadcastId: " + r38).toString());
    L105:
        r213 = false;
        goto L106
    L111:
        r19 = r19;
        r27 = r20;
        r110 = r7;
        if (r23.equals(KEY_BT_BROADCAST_CODE) == false) goto L113;
        if (r11 != null) goto L116;
        boolean r214 = true;
    L117:
        if (r214 == false) goto L128;
        int r34 = StringsKt.getLastIndex(r25);
    L120:
        if ((-1) >= r34) goto L125;
        r6 = r6;
        if (Character.valueOf(r25.charAt(r34)).equals((byte) 0) == false) goto L123;
        r34 = r34 - 1;
        r6 = r6;
        goto L120
    L123:
        String r35 = r25.substring(0, r34 + 1);
        Intrinsics.checkNotNullExpressionValue(r35, "this as java.lang.String…ing(startIndex, endIndex)");
    L126:
        byte[] r36 = r35.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r36, "this as java.lang.String).getBytes(charset)");
        r11 = Base64.decode(r36, 2);
        goto L161
    L125:
        r6 = r6;
        r35 = "";
        goto L126
    L128:
        throw new IllegalArgumentException(("Duplicate broadcastCode: " + r38).toString());
    L116:
        r214 = false;
        goto L117
    L129:
        r6 = r6;
        r19 = r19;
        r27 = r20;
        r110 = r7;
        if (r23.equals(KEY_BT_ADVERTISER_ADDRESS_TYPE) == false) goto L161;
        if (r13 != 65535) goto L135;
        boolean r215 = true;
    L136:
        if (r215 == false) goto L139;
        r13 = Integer.parseInt(r25);
        goto L161
    L139:
        throw new IllegalArgumentException(("Duplicate sourceAddrType: " + r38).toString());
    L135:
        r215 = false;
        goto L136
    L140:
        r6 = r6;
        r19 = r19;
        r27 = r20;
        r110 = r7;
        if (r23.equals(KEY_BT_ADVERTISING_SID) == false) goto L161;
        if (r15 != (-1)) goto L146;
        boolean r216 = true;
    L147:
        if (r216 == false) goto L150;
        r15 = Integer.parseInt(r25, CharsKt.checkRadix(16));
        goto L161
    L150:
        throw new IllegalArgumentException(("Duplicate sourceAdvertiserSid: " + r38).toString());
    L146:
        r216 = false;
    L12:
        r27 = r20;
        goto L13
    L17:
        r25 = "";
        goto L19
    L11:
        r22 = r9;
        r24 = r4;
        r26 = r14;
        goto L12
    L164:
        ArrayList r217 = r6;
        String r218 = r14;
        int r111 = r19;
        int r37 = r20;
        ArrayList r112 = r7;
        String r39 = r218;
        StringBuilder r0 = new StringBuilder("parseQrCodeToMetadata: main data elements sourceAddrType=").append(r13).append(", sourceAddr=").append(r39).append(", sourceAdvertiserSid=").append(r15).append(", broadcastId=").append(r16).append(", broadcastName=").append(r17).append(", streamMetadata=");
        if (r18 == null) goto L167;
        boolean r40 = true;
    L168:
        StringBuilder r41 = r0.append(r40).append(", paSyncInterval=").append(r12).append(", broadcastCode=");
        if (r11 == null) goto L171;
        String r42 = new String(r11, Charsets.UTF_8);
    L172:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, r41.append(r42).append(", audioConfigQualityStandard=").append(r10).append(", audioConfigQualityHigh=").append(r111).toString());
        BluetoothAdapter r43 = BluetoothAdapter.getDefaultAdapter();
        if (r17 == null) goto L175;
        boolean r44 = true;
    L176:
        if (r44 == false) goto L224;
        if (r39 != null) goto L179;
        r39 = "FF:FF:FF:FF:FF:FF";
        r13 = 1;
    L187:
        if (r39 == null) goto L222;
        BluetoothDevice r45 = r43.getRemoteLeDevice(r39, r13);
        Intrinsics.checkNotNullExpressionValue(r45, "adapter.getRemoteLeDevic…eNotNull(addr), addrType)");
        if (r10 != (-1)) goto L192;
        r10 = 0;
    L192:
        int r46 = r10 | 0;
        if (r111 != (-1)) goto L196;
        r111 = 0;
    L196:
        int r47 = r46 | r111;
        if (r37 > 0) goto L200;
        r37 = 1;
    L200:
        int r48 = 0;
    L201:
        if (r48 >= r37) goto L215;
        UInt r49 = (UInt) CollectionsKt.getOrNull(r5, r48);
        UInt r113 = (UInt) CollectionsKt.getOrNull(r217, r48);
        ArrayList r114 = r5;
        byte[] r115 = (byte[]) CollectionsKt.getOrNull(r112, r48);
        List<BluetoothLeBroadcastChannel> r219 = m739convertToChannels1A3ddvw(r49, r113);
        byte[] r220 = r11;
        BluetoothLeAudioCodecConfigMetadata r50 = new BluetoothLeAudioCodecConfigMetadata.Builder().setAudioLocation(0).build();
        Intrinsics.checkNotNullExpressionValue(r50, "Builder()\n              …tAudioLocation(0).build()");
        BluetoothLeBroadcastSubgroup.Builder r51 = new BluetoothLeBroadcastSubgroup.Builder();
        int r221 = r12;
        r51.setCodecId(6);
        r51.setCodecSpecificConfig(r50);
        if (r115 != null) goto L205;
        byte[] r52 = new byte[0];
    L206:
        r51.setContentMetadata(BluetoothLeAudioContentMetadata.fromRawBytes(r52));
        Iterator<T> r53 = r219.iterator();
    L208:
        if (r53.hasNext() == false) goto L210;
        r51.addChannel((BluetoothLeBroadcastChannel) r53.next());
        goto L208
    L210:
        BluetoothLeBroadcastSubgroup r54 = r51.build();
        Intrinsics.checkNotNullExpressionValue(r54, "Builder().apply {\n      …el)\n            }.build()");
        StringBuilder r55 = new StringBuilder("parseQrCodeToMetadata: subgroup ").append(r48).append(" elements bisSync=").append(r49).append(", bisNum=").append(r113).append(", metadata=");
        if (r115 == null) goto L213;
        boolean r56 = true;
    L214:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, r55.append(r56).toString());
        r8.addSubgroup(r54);
        r48 = r48 + 1;
        r5 = r114;
        r11 = r220;
        r12 = r221;
        goto L201
    L213:
        r56 = false;
        goto L214
    L205:
        r52 = r115;
        goto L206
    L215:
        byte[] r222 = r11;
        r8.setSourceDevice(r45, r13);
        r8.setSourceAdvertisingSid(r15);
        r8.setBroadcastId(r16);
        r8.setBroadcastName(r17);
        r8.setPublicBroadcast(true);
        r8.setPublicBroadcastMetadata(r18);
        r8.setPaSyncInterval(r12);
        if (r222 == null) goto L218;
        boolean r57 = true;
    L219:
        r8.setEncrypted(r57);
        r8.setBroadcastCode(r222);
        r8.setPresentationDelayMicros(0);
        r8.setAudioConfigQuality(r47);
        BluetoothLeBroadcastMetadata r58 = r8.build();
        Intrinsics.checkNotNullExpressionValue(r58, "builder.build()");
        return r58;
    L218:
        r57 = false;
        goto L219
    L222:
        throw new IllegalArgumentException("Required value was null.".toString());
    L179:
        if (r13 == 65535) goto L181;
        boolean r59 = true;
    L182:
        if (r59 == true) goto L187;
        throw new IllegalArgumentException(("sourceAddrType(" + r13 + ") must present if address present").toString());
    L181:
        r59 = false;
        goto L182
    L224:
        throw new IllegalArgumentException(("broadcastName(" + r17 + ") must present in QR code string").toString());
    L175:
        r44 = false;
        goto L176
    L171:
        r42 = null;
        goto L172
    L167:
        r40 = false;
        goto L168
    }

    private final Pair<UInt, UInt> getBisSyncFromChannels(List<BluetoothLeBroadcastChannel> r4) {
        Iterator<T> r3 = r4.iterator();
        int r5 = 0;
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L10;
        BluetoothLeBroadcastChannel r1 = (BluetoothLeBroadcastChannel) r3.next();
        if (r1.getChannelIndex() <= 0) goto L4;
        r0 = UInt.m1603constructorimpl(r0 + 1);
        if (r1.isSelected() == false) goto L4;
        r5 = UInt.m1603constructorimpl(r5 | UInt.m1603constructorimpl(1 << (r1.getChannelIndex() - 1)));
        goto L4
    L10:
        if (r5 != 0) goto L13;
        return new Pair(UInt.m1597boximpl(-1), UInt.m1597boximpl(r0));
    L13:
        return new Pair(UInt.m1597boximpl(r5), UInt.m1597boximpl(r0));
    }

    /* JADX INFO: renamed from: convertToChannels-1A3ddvw, reason: not valid java name */
    private final List<BluetoothLeBroadcastChannel> m739convertToChannels1A3ddvw(UInt r6, UInt r7) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "convertToChannels: bisSync=" + r6 + ", bisNum=" + r7);
        int r5 = 0;
        if (r6 == null) goto L6;
        if (r7 == null) goto L6;
        int r8 = r6.m1655unboximpl();
    L7:
        ArrayList r0 = new ArrayList();
        BluetoothLeAudioCodecConfigMetadata r1 = new BluetoothLeAudioCodecConfigMetadata.Builder().setAudioLocation(0).build();
        Intrinsics.checkNotNullExpressionValue(r1, "Builder()\n              …tAudioLocation(0).build()");
        if (r6 != null) goto L11;
    L9:
        boolean r9 = false;
    L14:
        if (r9 == true) goto L24;
        if (r8 == 0) goto L24;
    L18:
        if (r5 >= 32) goto L23;
        if (UInt.m1603constructorimpl(UInt.m1603constructorimpl(1 << r5) & r8) == 0) goto L22;
        BluetoothLeBroadcastChannel.Builder r10 = new BluetoothLeBroadcastChannel.Builder();
        r10.setSelected(true);
        r10.setChannelIndex(r5 + 1);
        r10.setCodecMetadata(r1);
        BluetoothLeBroadcastChannel r11 = r10.build();
        Intrinsics.checkNotNullExpressionValue(r11, "channel.build()");
        r0.add(r11);
    L22:
        r5 = r5 + 1;
        goto L18
    L23:
        return r0;
    L24:
        BluetoothLeBroadcastChannel.Builder r12 = new BluetoothLeBroadcastChannel.Builder();
        r12.setSelected(false);
        r12.setChannelIndex(1);
        r12.setCodecMetadata(r1);
        BluetoothLeBroadcastChannel r13 = r12.build();
        Intrinsics.checkNotNullExpressionValue(r13, "channel.build()");
        return CollectionsKt.listOf(r13);
    L11:
        if (r6.m1655unboximpl() != (-1)) goto L9;
        r9 = true;
    L6:
        r8 = 0;
        goto L7
    }
}
