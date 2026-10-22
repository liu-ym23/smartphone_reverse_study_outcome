package com.obric.oui.material;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.OPalette;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.graphic.BlendMode;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MaterialConfigBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\n2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001fJ'\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010!J\u001d\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0012\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010*\u001a\u00020\u0004H\u0007J\u001a\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0007J%\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u001d\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010#\u001a\u00020$H\u0002¢\u0006\u0002\u0010%J\u001a\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001b\u00101\u001a\u00020$2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0002\u00103J\u0016\u00104\u001a\u0004\u0018\u00010$*\u0002052\u0006\u00106\u001a\u00020\u0004H\u0002J\u0016\u00107\u001a\u0004\u0018\u00010\u0004*\u0002052\u0006\u00106\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/material/MaterialConfigBuilder;", "", "()V", "QUERY_COLUMN_SERIALIZATION_FORMAT", "", "QUERY_COLUMN_SERIALIZED_CONFIG_ARRAY", "SERIALIZATION_FORMAT_BINARY", "SERIALIZATION_FORMAT_JSON", "SERIALIZATION_FORMAT_XML", "arrayFromJson", "", "Lcom/obric/oui/material/MaterialConfig;", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "(Ljava/lang/String;)[Lcom/obric/oui/material/MaterialConfig;", "arrayFromJsonFile", "file", "Ljava/io/File;", "(Ljava/io/File;)[Lcom/obric/oui/material/MaterialConfig;", "arrayFromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)[Lcom/obric/oui/material/MaterialConfig;", "createBlendConfigFromColorful", "Lcom/obric/oui/color/BlendConfig;", "color", "", "(I)[Lcom/obric/oui/color/BlendConfig;", "createSimpleColorful", "baseConfig", "(Lcom/obric/oui/material/MaterialConfig;I)[Lcom/obric/oui/material/MaterialConfig;", "baseConfigs", "([Lcom/obric/oui/material/MaterialConfig;I)[Lcom/obric/oui/material/MaterialConfig;", "deserializeFromByteArray", WsConstants.KEY_PAYLOAD, "", "([B)[Lcom/obric/oui/material/MaterialConfig;", "fromJson", "fromJsonFile", "fromUri", "fromXml", "filePath", "dirPath", "fileName", "parseJsonFromUri", "parseXmlPayload", "querySerializedPayload", "Lcom/obric/oui/material/MaterialConfigBuilder$SerializedQueryResult;", "serializeToByteArray", Constants.KEY_CONFIG, "([Lcom/obric/oui/material/MaterialConfig;)[B", "getBlobOrNull", "Landroid/database/Cursor;", "columnName", "getStringOrNull", "SerializedQueryResult", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialConfigBuilder {
    public static final MaterialConfigBuilder INSTANCE = null;
    public static final String QUERY_COLUMN_SERIALIZATION_FORMAT = "serialized_material_format";
    public static final String QUERY_COLUMN_SERIALIZED_CONFIG_ARRAY = "serialized_material_config_array";
    public static final String SERIALIZATION_FORMAT_BINARY = "binary";
    public static final String SERIALIZATION_FORMAT_JSON = "json";
    public static final String SERIALIZATION_FORMAT_XML = "xml";

    /* JADX INFO: compiled from: MaterialConfigBuilder.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/material/MaterialConfigBuilder$SerializedQueryResult;", "", "configArrayPayload", "", "format", "", "([BLjava/lang/String;)V", "getConfigArrayPayload", "()[B", "getFormat", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class SerializedQueryResult {
        private final byte[] configArrayPayload;
        private final String format;

        public static /* synthetic */ SerializedQueryResult copy$default(SerializedQueryResult r0, byte[] r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.configArrayPayload;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.format;
        L9:
            return r0.copy(r1, r2);
        }

        public final byte[] component1() {
            return this.configArrayPayload;
        }

        public final String component2() {
            return this.format;
        }

        public final SerializedQueryResult copy(byte[] r1, String r2) {
            return new SerializedQueryResult(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SerializedQueryResult) == true) goto L8;
            return false;
        L8:
            SerializedQueryResult r6 = (SerializedQueryResult) r5;
            if (Intrinsics.areEqual(this.configArrayPayload, r6.configArrayPayload) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.format, r6.format) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            byte[] r0 = this.configArrayPayload;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.format;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = Arrays.hashCode(r0);
            goto L6
        }

        public String toString() {
            return "SerializedQueryResult(configArrayPayload=" + Arrays.toString(this.configArrayPayload) + ", format=" + this.format + ')';
        }

        public SerializedQueryResult(byte[] r1, String r2) {
            this.configArrayPayload = r1;
            this.format = r2;
        }

        public final byte[] getConfigArrayPayload() {
            return this.configArrayPayload;
        }

        public final String getFormat() {
            return this.format;
        }
    }

    static {
        INSTANCE = new MaterialConfigBuilder();
    }

    private MaterialConfigBuilder() {
    }

    public final MaterialConfig[] createSimpleColorful(MaterialConfig r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "baseConfig");
        int r3 = OPalette.decreaseSaturation(r5, 0.1f);
        int r6 = Color.argb(102, Color.red(r3), Color.green(r3), Color.blue(r3));
        MaterialConfig r0 = r4.deepCopy();
        r0.setBlendConfig(INSTANCE.createBlendConfigFromColorful(r3));
        StrokeConfig r7 = r4.getStroke();
        if (r7 != null) goto L5;
        StrokeConfig r8 = null;
    L6:
        r0.setStroke(r8);
        return new MaterialConfig[]{r0};
    L5:
        r8 = new StrokeConfig(r7.getWidth(), r6, r7.getBlendMode());
        goto L6
    }

    public final MaterialConfig[] createSimpleColorful(MaterialConfig[] r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "baseConfigs");
        int r8 = OPalette.decreaseSaturation(r10, 0.1f);
        int r11 = Color.argb(102, Color.red(r8), Color.green(r8), Color.blue(r8));
        ArrayList r0 = new ArrayList(r9.length);
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        MaterialConfig r4 = r9[r3];
        MaterialConfig r5 = r4.deepCopy();
        r5.setBlendConfig(INSTANCE.createBlendConfigFromColorful(r8));
        StrokeConfig r6 = r4.getStroke();
        if (r6 != null) goto L7;
        StrokeConfig r7 = null;
    L8:
        r5.setStroke(r7);
        r0.add(r5);
        r3 = r3 + 1;
        goto L3
    L7:
        r7 = new StrokeConfig(r6.getWidth(), r11, r6.getBlendMode());
        goto L8
    L9:
        Object[] r12 = r0.toArray(new MaterialConfig[0]);
        if (r12 == null) goto L14;
        return (MaterialConfig[]) r12;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final BlendConfig[] createBlendConfigFromColorful(int r4) {
        return new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(r4, BlendMode.PLUS_DARKER)};
    }

    @JvmStatic
    public static final MaterialConfig fromXml(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "dirPath");
        Intrinsics.checkNotNullParameter(r2, "fileName");
        return MaterialXmlParser.parse(r1, r2);
    }

    @JvmStatic
    public static final MaterialConfig fromXml(String r1) {
        Intrinsics.checkNotNullParameter(r1, "filePath");
        return MaterialXmlParser.parse(r1);
    }

    @JvmStatic
    public static final MaterialConfig fromXml(File r1) {
        Intrinsics.checkNotNullParameter(r1, "file");
        return MaterialXmlParser.parse(r1);
    }

    @JvmStatic
    public static final MaterialConfig fromJson(String r1) {
        Intrinsics.checkNotNullParameter(r1, SERIALIZATION_FORMAT_JSON);
        return MaterialJsonParser.parse(r1);
    }

    @JvmStatic
    public static final MaterialConfig[] arrayFromJson(String r1) {
        Intrinsics.checkNotNullParameter(r1, SERIALIZATION_FORMAT_JSON);
        return MaterialJsonParser.parseArray(r1);
    }

    @JvmStatic
    public static final MaterialConfig fromJsonFile(File r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Object r1 = null;
        if (r2.exists() == true) goto L5;
        return null;
    L5:
        if (r2.isFile() == true) goto L7;
        return null;
    L7:
        if (r2.canRead() == false) goto L23;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.m774constructorimpl(MaterialJsonParser.parse(FilesKt.readText$default(r2, null, 1, null)));     // Catch: Throwable -> L11
    L14:
        if (Result.m780isFailureimpl(r3) == true) goto L18;
        r1 = r3;
    L18:
        return (MaterialConfig) r1;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L14
    L23:
        return null;
    }

    @JvmStatic
    public static final MaterialConfig[] arrayFromJsonFile(File r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Object r1 = null;
        if (r2.exists() == true) goto L5;
        return null;
    L5:
        if (r2.isFile() == true) goto L7;
        return null;
    L7:
        if (r2.canRead() == false) goto L23;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.m774constructorimpl(MaterialJsonParser.parseArray(FilesKt.readText$default(r2, null, 1, null)));     // Catch: Throwable -> L11
    L14:
        if (Result.m780isFailureimpl(r3) == true) goto L18;
        r1 = r3;
    L18:
        return (MaterialConfig[]) r1;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L14
    L23:
        return null;
    }

    @JvmStatic
    public static final MaterialConfig fromUri(Context r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "uri");
        MaterialConfigBuilder r0 = INSTANCE;
        SerializedQueryResult r1 = r0.querySerializedPayload(r7, r8);
        String r3 = null;
        if (r1 == null) goto L36;
        byte[] r4 = r1.getConfigArrayPayload();
        if (r4 == null) goto L36;
        String r5 = r1.getFormat();
        if (r5 != null) goto L11;
        String r6 = null;
    L13:
        if (Intrinsics.areEqual(r6, SERIALIZATION_FORMAT_JSON) == false) goto L22;
        MaterialConfig[] r9 = MaterialJsonParser.parseArray(new String(r4, Charsets.UTF_8));
        if (r9 == null) goto L35;
        MaterialConfig r10 = (MaterialConfig) ArraysKt.singleOrNull(r9);
        if (r10 == null) goto L35;
        return r10;
    L35:
        Void r11 = (Void) null;
        goto L36
    L22:
        if (Intrinsics.areEqual(r6, SERIALIZATION_FORMAT_XML) == false) goto L30;
        MaterialConfig[] r12 = r0.parseXmlPayload(r4);
        if (r12 == null) goto L35;
        MaterialConfig r13 = (MaterialConfig) ArraysKt.singleOrNull(r12);
        if (r13 == null) goto L35;
        return r13;
    L30:
        MaterialConfig[] r14 = deserializeFromByteArray(r4);
        if (r14 == null) goto L35;
        MaterialConfig r15 = (MaterialConfig) ArraysKt.singleOrNull(r14);
        if (r15 == null) goto L35;
        return r15;
    L11:
        r6 = r5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(Locale.ROOT)");
    L36:
        if (r1 == null) goto L39;
        r3 = r1.getFormat();
    L39:
        boolean r2 = true;
        if (StringsKt.equals(r3, SERIALIZATION_FORMAT_JSON, true) == true) goto L47;
        String r16 = r8.getLastPathSegment();
        if (r16 != null) goto L45;
    L43:
        r2 = false;
    L46:
        if (r2 == true) goto L47;
    L53:
        return MaterialXmlParser.parse(r7, r8);
    L45:
        if (StringsKt.endsWith(r16, ".json", true) != true) goto L43;
    L47:
        MaterialConfig[] r17 = r0.parseJsonFromUri(r7, r8);
        if (r17 == null) goto L53;
        MaterialConfig r18 = (MaterialConfig) ArraysKt.singleOrNull(r17);
        if (r18 == null) goto L53;
        return r18;
    }

    @JvmStatic
    public static final MaterialConfig[] arrayFromUri(Context r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "uri");
        MaterialConfigBuilder r0 = INSTANCE;
        SerializedQueryResult r1 = r0.querySerializedPayload(r7, r8);
        String r3 = null;
        if (r1 == null) goto L27;
        byte[] r4 = r1.getConfigArrayPayload();
        if (r4 == null) goto L27;
        String r5 = r1.getFormat();
        if (r5 != null) goto L11;
        String r6 = null;
    L13:
        if (Intrinsics.areEqual(r6, SERIALIZATION_FORMAT_JSON) == false) goto L19;
        MaterialConfig[] r9 = MaterialJsonParser.parseArray(new String(r4, Charsets.UTF_8));
        if (r9 == null) goto L26;
        return r9;
    L26:
        Void r10 = (Void) null;
        goto L27
    L19:
        if (Intrinsics.areEqual(r6, SERIALIZATION_FORMAT_XML) == false) goto L24;
        MaterialConfig[] r11 = r0.parseXmlPayload(r4);
        if (r11 == null) goto L26;
        return r11;
    L24:
        MaterialConfig[] r12 = deserializeFromByteArray(r4);
        if (r12 == null) goto L26;
        return r12;
    L11:
        r6 = r5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(Locale.ROOT)");
    L27:
        if (r1 == null) goto L30;
        r3 = r1.getFormat();
    L30:
        boolean r2 = true;
        if (StringsKt.equals(r3, SERIALIZATION_FORMAT_JSON, true) == true) goto L38;
        String r13 = r8.getLastPathSegment();
        if (r13 != null) goto L36;
    L34:
        r2 = false;
    L37:
        if (r2 == true) goto L38;
    L41:
        return MaterialXmlParser.parseArray(r7, r8);
    L36:
        if (StringsKt.endsWith(r13, ".json", true) != true) goto L34;
    L38:
        MaterialConfig[] r14 = r0.parseJsonFromUri(r7, r8);
        if (r14 == null) goto L41;
        return r14;
    }

    @JvmStatic
    public static final byte[] serializeToByteArray(MaterialConfig[] r1) {
        Intrinsics.checkNotNullParameter(r1, Constants.KEY_CONFIG);
        return MaterialConfigSerialization.INSTANCE.serializeArray(r1);
    }

    @JvmStatic
    public static final MaterialConfig[] deserializeFromByteArray(byte[] r1) {
        Intrinsics.checkNotNullParameter(r1, WsConstants.KEY_PAYLOAD);
        return MaterialConfigSerialization.INSTANCE.deserializeArray(r1);
    }

    private final SerializedQueryResult querySerializedPayload(Context r9, Uri r10) {
        Cursor r11 = r9.getContentResolver().query(r10, new String[]{QUERY_COLUMN_SERIALIZED_CONFIG_ARRAY, QUERY_COLUMN_SERIALIZATION_FORMAT}, null, null, null);     // Catch: Throwable -> L18
        if (r11 == null) goto L25;
        Cursor r12 = r11;     // Catch: Throwable -> L18
        Cursor r13 = r12;     // Catch: Throwable -> L13
        if (r13.moveToFirst() == true) goto L10;
        SerializedQueryResult r2 = null;
    L11:
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L18
        return r2;
    L10:
        MaterialConfigBuilder r3 = INSTANCE;     // Catch: Throwable -> L13
        r2 = new SerializedQueryResult(r3.getBlobOrNull(r13, QUERY_COLUMN_SERIALIZED_CONFIG_ARRAY), r3.getStringOrNull(r13, QUERY_COLUMN_SERIALIZATION_FORMAT));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L25:
        return null;
    L18:
        SerializedQueryResult r8 = (SerializedQueryResult) null;
        return null;
    }

    private final MaterialConfig[] parseJsonFromUri(Context r3, Uri r4) {
        InputStream r5 = r3.getContentResolver().openInputStream(r4);     // Catch: Throwable -> L15
        if (r5 == null) goto L22;
        InputStream r6 = r5;     // Catch: Throwable -> L15
        MaterialConfig[] r7 = MaterialJsonParser.parseArray(new String(ByteStreamsKt.readBytes(r6), Charsets.UTF_8));     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L15
        return r7;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L22:
        return null;
    L15:
        MaterialConfig[] r8 = (MaterialConfig[]) null;
        return null;
    }

    private final MaterialConfig[] parseXmlPayload(byte[] r3) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r3);     // Catch: Throwable -> L12
        MaterialConfig[] r4 = MaterialXmlParser.parseArray(r0);     // Catch: Throwable -> L7
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L12
        return r4;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        MaterialConfig[] r5 = (MaterialConfig[]) null;
        return null;
    }

    private final String getStringOrNull(Cursor r1, String r2) {
        int r0 = r1.getColumnIndex(r2);
        if (r0 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r1.isNull(r0) == true) goto L7;
        return r1.getString(r0);
    }

    private final byte[] getBlobOrNull(Cursor r1, String r2) {
        int r0 = r1.getColumnIndex(r2);
        if (r0 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r1.isNull(r0) == true) goto L7;
        return r1.getBlob(r0);
    }
}
