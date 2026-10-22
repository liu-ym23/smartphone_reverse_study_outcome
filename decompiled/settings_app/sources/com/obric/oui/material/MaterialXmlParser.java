package com.obric.oui.material;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.text.PluralRules;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.revone.TabletDpiSettingsFragment;
import com.android.settingslib.SliceBroadcastRelay;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.FloatSpreadBuilder;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: MaterialXmlParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003uvwB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\fH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0002J+\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0004\"\u00020\bH\u0002¢\u0006\u0002\u0010\u0015J2\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J)\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0004\"\u00020\bH\u0002¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0002J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020+H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020-H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010.\u001a\u00020\bH\u0007J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010/\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0007J%\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u00101J%\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u00102J\u001d\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00103J\u001d\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-H\u0007¢\u0006\u0002\u00104J\u001d\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010.\u001a\u00020\bH\u0007¢\u0006\u0002\u00105J%\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010/\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0007¢\u0006\u0002\u00106J\u001d\u00107\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010<\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0019\u0010=\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0019\u0010B\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0019\u0010C\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0017\u0010D\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0012\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0019\u0010I\u001a\u0004\u0018\u00010J2\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010KJ\u0012\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001d\u0010Q\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010RJ\u001d\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010UJ\u0012\u0010V\u001a\u0004\u0018\u00010T2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J/\u0010W\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010XJ\u001c\u0010Y\u001a\u0004\u0018\u00010:2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010Z\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J;\u0010`\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u0001Ha0cH\u0002¢\u0006\u0002\u0010dJ3\u0010`\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0006\u0010*\u001a\u00020+2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u0001Ha0cH\u0002¢\u0006\u0002\u0010eJ3\u0010`\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0006\u0010,\u001a\u00020-2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u0001Ha0cH\u0002¢\u0006\u0002\u0010fJ\u0012\u0010g\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JW\u0010h\u001a\n\u0012\u0004\u0012\u0002Ha\u0018\u00010\f\"\u0004\b\u0000\u0010a2\b\u0010i\u001a\u0004\u0018\u0001Ha2\b\u0010j\u001a\u0004\u0018\u0001Ha2\b\u0010k\u001a\u0004\u0018\u0001Ha2\b\u0010l\u001a\u0004\u0018\u0001Ha2\b\u0010m\u001a\u0004\u0018\u0001Ha2\b\u0010n\u001a\u0004\u0018\u0001HaH\u0002¢\u0006\u0002\u0010oJ\u001f\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\b\u0010q\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010rJ\u0010\u0010s\u001a\u00020t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser;", "", "()V", "MATERIAL_STATE_SPECS", "", "", "[[I", "XML_SUFFIX", "", "buildBlendConfigStateList", "Lcom/obric/oui/res/BlendConfigStateList;", PowerUsageDetail.EXTRA_DETAIL_VALUES, "Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", "Lcom/obric/oui/color/BlendConfig;", "buildColorStateList", "Landroid/content/res/ColorStateList;", "", "getAttribute", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "names", "(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;)Ljava/lang/String;", "getStatefulAttribute", "state", "Lcom/obric/oui/material/MaterialXmlParser$MaterialState;", "suffixName", "baseName", "hasAnyAttribute", "", "(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;)Z", "normalizeName", "name", "normalizeXmlFileName", "fileName", "parse", "Lcom/obric/oui/material/MaterialConfig;", "contentResolver", "Landroid/content/ContentResolver;", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "input", "Ljava/io/InputStream;", Params.FILE_PATH, "dirPath", "parseArray", "(Landroid/content/ContentResolver;Landroid/net/Uri;)[Lcom/obric/oui/material/MaterialConfig;", "(Landroid/content/Context;Landroid/net/Uri;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/io/File;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/io/InputStream;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/lang/String;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/lang/String;Ljava/lang/String;)[Lcom/obric/oui/material/MaterialConfig;", "parseBlendConfigArray", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/color/BlendConfig;", "parseBlendConfigContainer", "Lcom/obric/oui/material/MaterialXmlParser$ParsedBlendConfigContainer;", "parseBlendConfigItem", "parseBlendConfigValueFromAttributes", "parseBlendMode", "value", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseBlurConfig", "Lcom/obric/oui/blur/BlurConfig;", "parseBlurDirection", "parseColor", "parseColorItem", "(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/Integer;", "parseCurveType", "parseFallbackBgColorContainer", "parseFallbackBgColorFromAttributes", "parseFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "parseFluidConfig", "Lcom/obric/oui/fluid/FluidConfig;", "parseFluidParams", "", "parseMaterialConfig", "parseMaterialConfigArray", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/material/MaterialConfig;", "parseShadowArray", "Lcom/obric/oui/shadow/ShadowConfig;", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/shadow/ShadowConfig;", "parseShadowItem", "parseStatefulBlendConfigValue", "(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Lcom/obric/oui/material/MaterialXmlParser$MaterialState;)[Lcom/obric/oui/color/BlendConfig;", "parseStatefulBlendConfigsFromAttributes", "parseStatefulColorsFromAttributes", "parseStroke", "Lcom/obric/oui/color/StrokeConfig;", "parseStrokeStateItem", "parseStrokeStateList", "Lcom/obric/oui/res/StrokeStateList;", "parseWithParser", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Landroid/content/ContentResolver;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/io/InputStream;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readTextContent", "resolveStatefulValues", "normal", "pressed", "hovered", "checked", MaterialConfigFormatNames.SELECTED, "disabled", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", "singleBlendConfigArray", "item", "(Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfig;", "skipCurrentTag", "", "MaterialState", "ParsedBlendConfigContainer", "ResolvedStatefulValues", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialXmlParser {
    public static final MaterialXmlParser INSTANCE = null;
    private static final int[][] MATERIAL_STATE_SPECS = null;
    private static final String XML_SUFFIX = ".xml";

    /* JADX INFO: compiled from: MaterialXmlParser.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$MaterialState;", "", "xmlName", "", "nodeName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getNodeName", "()Ljava/lang/String;", "getXmlName", "NORMAL", "PRESS", "HOVER", "CHECKED", "SELECTED", "DISABLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum MaterialState extends Enum<MaterialState> {
        private static final /* synthetic */ MaterialState[] $VALUES = null;
        public static final MaterialState CHECKED = null;
        public static final MaterialState DISABLE = null;
        public static final MaterialState HOVER = null;
        public static final MaterialState NORMAL = null;
        public static final MaterialState PRESS = null;
        public static final MaterialState SELECTED = null;
        private final String nodeName;
        private final String xmlName;

        private static final /* synthetic */ MaterialState[] $values() {
            return new MaterialState[]{NORMAL, PRESS, HOVER, CHECKED, SELECTED, DISABLE};
        }

        public static MaterialState valueOf(String r1) {
            return (MaterialState) Enum.valueOf(MaterialState.class, r1);
        }

        public static MaterialState[] values() {
            return (MaterialState[]) $VALUES.clone();
        }

        private MaterialState(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.xmlName = r3;
            this.nodeName = r4;
        }

        /* synthetic */ MaterialState(String r1, int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L5;
            r4 = r3;
        L5:
            this(r1, r2, r3, r4);
        }

        public final String getXmlName() {
            return this.xmlName;
        }

        public final String getNodeName() {
            return this.nodeName;
        }

        static {
            NORMAL = new MaterialState("NORMAL", 0, "normal", null, 2, null);
            String r12 = null;
            int r13 = 2;
            DefaultConstructorMarker r14 = null;
            PRESS = new MaterialState("PRESS", 1, MaterialConfigFormatNames.PRESS, r12, r13, r14);
            String r5 = null;
            int r6 = 2;
            DefaultConstructorMarker r7 = null;
            HOVER = new MaterialState("HOVER", 2, MaterialConfigFormatNames.HOVER, r5, r6, r7);
            CHECKED = new MaterialState("CHECKED", 3, "checked", r12, r13, r14);
            SELECTED = new MaterialState("SELECTED", 4, MaterialConfigFormatNames.SELECTED, r5, r6, r7);
            DISABLE = new MaterialState("DISABLE", 5, "disable", r12, r13, r14);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: MaterialXmlParser.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J(\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$ParsedBlendConfigContainer;", "", "defaultConfig", "", "Lcom/obric/oui/color/BlendConfig;", "stateList", "Lcom/obric/oui/res/BlendConfigStateList;", "([Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/BlendConfigStateList;)V", "getDefaultConfig", "()[Lcom/obric/oui/color/BlendConfig;", "[Lcom/obric/oui/color/BlendConfig;", "getStateList", "()Lcom/obric/oui/res/BlendConfigStateList;", "component1", "component2", "copy", "([Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/BlendConfigStateList;)Lcom/obric/oui/material/MaterialXmlParser$ParsedBlendConfigContainer;", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ParsedBlendConfigContainer {
        private final BlendConfig[] defaultConfig;
        private final BlendConfigStateList stateList;

        public static /* synthetic */ ParsedBlendConfigContainer copy$default(ParsedBlendConfigContainer r0, BlendConfig[] r1, BlendConfigStateList r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.defaultConfig;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.stateList;
        L9:
            return r0.copy(r1, r2);
        }

        public final BlendConfig[] component1() {
            return this.defaultConfig;
        }

        public final BlendConfigStateList component2() {
            return this.stateList;
        }

        public final ParsedBlendConfigContainer copy(BlendConfig[] r1, BlendConfigStateList r2) {
            Intrinsics.checkNotNullParameter(r1, "defaultConfig");
            Intrinsics.checkNotNullParameter(r2, "stateList");
            return new ParsedBlendConfigContainer(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ParsedBlendConfigContainer) == true) goto L8;
            return false;
        L8:
            ParsedBlendConfigContainer r6 = (ParsedBlendConfigContainer) r5;
            if (Intrinsics.areEqual(this.defaultConfig, r6.defaultConfig) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.stateList, r6.stateList) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.defaultConfig) * 31) + this.stateList.hashCode();
        }

        public String toString() {
            return "ParsedBlendConfigContainer(defaultConfig=" + Arrays.toString(this.defaultConfig) + ", stateList=" + this.stateList + ')';
        }

        public ParsedBlendConfigContainer(BlendConfig[] r2, BlendConfigStateList r3) {
            Intrinsics.checkNotNullParameter(r2, "defaultConfig");
            Intrinsics.checkNotNullParameter(r3, "stateList");
            this.defaultConfig = r2;
            this.stateList = r3;
        }

        public final BlendConfig[] getDefaultConfig() {
            return this.defaultConfig;
        }

        public final BlendConfigStateList getStateList() {
            return this.stateList;
        }
    }

    /* JADX INFO: compiled from: MaterialXmlParser.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ \u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u0016\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0017\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0018\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0019\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJP\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", ExifInterface.GPS_DIRECTION_TRUE, "", "normal", "pressed", "hovered", "checked", MaterialConfigFormatNames.SELECTED, "disabled", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getChecked", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDisabled", "getHovered", "getNormal", "getPressed", "getSelected", "allEqual", "", "comparator", "Lkotlin/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ResolvedStatefulValues<T> {
        private final T checked;
        private final T disabled;
        private final T hovered;
        private final T normal;
        private final T pressed;
        private final T selected;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResolvedStatefulValues copy$default(ResolvedStatefulValues r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.normal;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.pressed;
        L8:
            Object r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.hovered;
        L11:
            Object r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.checked;
        L14:
            Object r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.selected;
        L17:
            Object r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.disabled;
        L20:
            Object r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final T component1() {
            return this.normal;
        }

        public final T component2() {
            return this.pressed;
        }

        public final T component3() {
            return this.hovered;
        }

        public final T component4() {
            return this.checked;
        }

        public final T component5() {
            return this.selected;
        }

        public final T component6() {
            return this.disabled;
        }

        public final ResolvedStatefulValues<T> copy(T r8, T r9, T r10, T r11, T r12, T r13) {
            return new ResolvedStatefulValues(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ResolvedStatefulValues) == true) goto L8;
            return false;
        L8:
            ResolvedStatefulValues r6 = (ResolvedStatefulValues) r5;
            if (Intrinsics.areEqual(this.normal, r6.normal) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.pressed, r6.pressed) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.hovered, r6.hovered) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.checked, r6.checked) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.selected, r6.selected) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.disabled, r6.disabled) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            T r0 = this.normal;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            T r4 = this.pressed;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = this.hovered;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            T r10 = this.checked;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            T r13 = this.selected;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            T r16 = this.disabled;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ResolvedStatefulValues(normal=" + this.normal + ", pressed=" + this.pressed + ", hovered=" + this.hovered + ", checked=" + this.checked + ", selected=" + this.selected + ", disabled=" + this.disabled + ')';
        }

        public ResolvedStatefulValues(T r1, T r2, T r3, T r4, T r5, T r6) {
            this.normal = r1;
            this.pressed = r2;
            this.hovered = r3;
            this.checked = r4;
            this.selected = r5;
            this.disabled = r6;
        }

        public final T getNormal() {
            return this.normal;
        }

        public final T getPressed() {
            return this.pressed;
        }

        public final T getHovered() {
            return this.hovered;
        }

        public final T getChecked() {
            return this.checked;
        }

        public final T getSelected() {
            return this.selected;
        }

        public final T getDisabled() {
            return this.disabled;
        }

        public final boolean allEqual(Function2<? super T, ? super T, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r3, "comparator");
            if (r3.invoke(this.normal, this.pressed).booleanValue() == true) goto L5;
        L13:
            return false;
        L5:
            if (r3.invoke(this.normal, this.hovered).booleanValue() == false) goto L13;
            if (r3.invoke(this.normal, this.checked).booleanValue() == false) goto L13;
            if (r3.invoke(this.normal, this.selected).booleanValue() == false) goto L13;
            if (r3.invoke(this.normal, this.disabled).booleanValue() == false) goto L13;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.material.MaterialXmlParser$buildBlendConfigStateList$1, reason: invalid class name */
    /* JADX INFO: compiled from: MaterialXmlParser.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<BlendConfig[], BlendConfig[], Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(2, ArraysKt.class, "contentDeepEquals", "contentDeepEqualsNullable([Ljava/lang/Object;[Ljava/lang/Object;)Z", 1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(BlendConfig[] r1, BlendConfig[] r2) {
            Intrinsics.checkNotNullParameter(r1, "p0");
            return Boolean.valueOf(ArraysKt.contentDeepEquals(r1, r2));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(BlendConfig[] r1, BlendConfig[] r2) {
            return invoke2(r1, r2);
        }
    }

    private final BlendConfig[] singleBlendConfigArray(BlendConfig r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return new BlendConfig[]{r2};
    }

    private MaterialXmlParser() {
    }

    public static final /* synthetic */ String access$normalizeName(MaterialXmlParser r0, String r1) {
        return r0.normalizeName(r1);
    }

    public static final /* synthetic */ MaterialConfig access$parseMaterialConfig(MaterialXmlParser r0, XmlPullParser r1) {
        return r0.parseMaterialConfig(r1);
    }

    public static final /* synthetic */ MaterialConfig[] access$parseMaterialConfigArray(MaterialXmlParser r0, XmlPullParser r1) {
        return r0.parseMaterialConfigArray(r1);
    }

    static {
        INSTANCE = new MaterialXmlParser();
        MATERIAL_STATE_SPECS = new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    @JvmStatic
    public static final MaterialConfig parse(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "dirPath");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return null;
    L5:
        if (StringsKt.isBlank(r3) == false) goto L8;
        return null;
    L8:
        return parse(new File(r2, INSTANCE.normalizeXmlFileName(r3)));
    }

    @JvmStatic
    public static final MaterialConfig parse(String r1) {
        Intrinsics.checkNotNullParameter(r1, Params.FILE_PATH);
        if (StringsKt.isBlank(r1) == false) goto L7;
        return null;
    L7:
        return parse(new File(r1));
    }

    @JvmStatic
    public static final MaterialConfig parse(Context r1, Uri r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, SliceBroadcastRelay.EXTRA_URI);
        ContentResolver r3 = r1.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r3, "context.contentResolver");
        return parse(r3, r2);
    }

    @JvmStatic
    public static final MaterialConfig parse(ContentResolver r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "contentResolver");
        Intrinsics.checkNotNullParameter(r3, SliceBroadcastRelay.EXTRA_URI);
        return (MaterialConfig) INSTANCE.parseWithParser(r2, r3, C02921.INSTANCE);
    }

    @JvmStatic
    public static final MaterialConfig parse(InputStream r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return (MaterialConfig) INSTANCE.parseWithParser(r2, AnonymousClass2.INSTANCE);
    }

    @JvmStatic
    public static final MaterialConfig[] parseArray(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "dirPath");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return null;
    L5:
        if (StringsKt.isBlank(r3) == false) goto L8;
        return null;
    L8:
        return parseArray(new File(r2, INSTANCE.normalizeXmlFileName(r3)));
    }

    @JvmStatic
    public static final MaterialConfig[] parseArray(String r1) {
        Intrinsics.checkNotNullParameter(r1, Params.FILE_PATH);
        if (StringsKt.isBlank(r1) == false) goto L7;
        return null;
    L7:
        return parseArray(new File(r1));
    }

    @JvmStatic
    public static final MaterialConfig[] parseArray(Context r1, Uri r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, SliceBroadcastRelay.EXTRA_URI);
        ContentResolver r3 = r1.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r3, "context.contentResolver");
        return parseArray(r3, r2);
    }

    @JvmStatic
    public static final MaterialConfig[] parseArray(ContentResolver r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "contentResolver");
        Intrinsics.checkNotNullParameter(r3, SliceBroadcastRelay.EXTRA_URI);
        return (MaterialConfig[]) INSTANCE.parseWithParser(r2, r3, C02931.INSTANCE);
    }

    @JvmStatic
    public static final MaterialConfig[] parseArray(InputStream r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return (MaterialConfig[]) INSTANCE.parseWithParser(r2, C02942.INSTANCE);
    }

    @JvmStatic
    public static final MaterialConfig parse(File r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        return (MaterialConfig) INSTANCE.parseWithParser(r2, AnonymousClass3.INSTANCE);
    }

    @JvmStatic
    public static final MaterialConfig[] parseArray(File r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        return (MaterialConfig[]) INSTANCE.parseWithParser(r2, C02953.INSTANCE);
    }

    private final MaterialConfig parseMaterialConfig(XmlPullParser r15) {
        MaterialConfig r13 = new MaterialConfig(parseFallbackBgColorFromAttributes(r15), null, null, null, null, null, null, parseFloat(getAttribute(r15, new String[]{MaterialConfigFormatNames.BLUR_RADIUS})), null, null, 894, null);
        ParsedBlendConfigContainer r1 = parseStatefulBlendConfigsFromAttributes(r15, MaterialConfigFormatNames.BLEND_CONFIGS);
        if (r1 == null) goto L6;
        r13.setBlendConfig(r1.getDefaultConfig());
        r13.setBlendConfigStateList(r1.getStateList());
    L6:
        int r2 = r15.getDepth();
    L7:
        int r3 = r15.next();
        if (r3 == 1) goto L75;
        if (r3 != 2) goto L12;
        String r4 = r15.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "parser.name");
        String r5 = normalizeName(r4);
        switch(r5.hashCode()) {
            case -1622636237: goto L69;
            case -1115483408: goto L61;
            case -891980232: goto L57;
            case -220247165: goto L44;
            case 97532362: goto L40;
            case 737726312: goto L33;
            case 1690590746: goto L29;
            case 1873723302: goto L25;
            case 2053811027: goto L21;
            default: goto L74;
        };
    L25:
        if (r5.equals(MaterialConfigFormatNames.FALLBACK_BG_COLOR) == false) goto L74;
        r13.setFallbackBgColor(parseFallbackBgColorContainer(r15));
        goto L7
    L29:
        if (r5.equals(MaterialConfigFormatNames.BLUR_CONFIG) == false) goto L74;
        r13.setBlurConfig(parseBlurConfig(r15));
        goto L7
    L33:
        if (r5.equals(MaterialConfigFormatNames.STROKE_STATE_LIST) == false) goto L74;
        StrokeStateList r6 = parseStrokeStateList(r15);
        if (r6 == null) goto L7;
        r13.setStrokeStateList(r6);
        goto L7
    L40:
        if (r5.equals(MaterialConfigFormatNames.FLUID) == false) goto L74;
        r13.setFluid(parseFluidConfig(r15));
        goto L7
    L44:
        if (r5.equals(MaterialConfigFormatNames.BLEND_CONFIGS) == false) goto L74;
        ParsedBlendConfigContainer r7 = parseBlendConfigContainer(r15);
        BlendConfigStateList r8 = null;
        if (r7 != null) goto L49;
        BlendConfig[] r9 = null;
    L50:
        r13.setBlendConfig(r9);
        if (r7 == null) goto L54;
        r8 = r7.getStateList();
    L54:
        if (r8 == null) goto L7;
        r13.setBlendConfigStateList(r7.getStateList());
        goto L7
    L49:
        r9 = r7.getDefaultConfig();
        goto L50
    L57:
        if (r5.equals(MaterialConfigFormatNames.STROKE) == false) goto L74;
        r13.setStroke(parseStroke(r15));
        goto L7
    L61:
        if (r5.equals(MaterialConfigFormatNames.BLEND_CONFIG) == false) goto L74;
        if (hasAnyAttribute(r15, new String[]{"color"}) == false) goto L66;
        BlendConfig[] r10 = singleBlendConfigArray(parseBlendConfigItem(r15));
    L67:
        r13.setBlendConfig(r10);
        goto L7
    L66:
        r10 = parseBlendConfigArray(r15);
        goto L67
    L69:
        if (r5.equals(MaterialConfigFormatNames.OVERLAY_BLEND_CONFIGS) == false) goto L74;
        ParsedBlendConfigContainer r11 = parseBlendConfigContainer(r15);
        if (r11 == null) goto L7;
        r13.setOverlayBlendConfigStateList(r11.getStateList());
    L74:
        skipCurrentTag(r15);
        goto L7
    L21:
        if (r5.equals(MaterialConfigFormatNames.SHADOWS) == false) goto L74;
        r13.setShadow(parseShadowArray(r15));
        goto L7
    L12:
        if (r3 != 3) goto L7;
        if (r15.getDepth() != r2) goto L7;
        return r13;
    L75:
        return r13;
    }

    private final MaterialConfig[] parseMaterialConfigArray(XmlPullParser r6) {
        ArrayList r0 = new ArrayList();
        int r1 = r6.getDepth();
    L3:
        int r2 = r6.next();
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L8;
        String r3 = r6.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "parser.name");
        if (Intrinsics.areEqual(normalizeName(r3), MaterialConfigFormatNames.ROOT_MATERIAL_CONFIG) == true) goto L15;
        skipCurrentTag(r6);
        goto L3
    L15:
        r0.add(parseMaterialConfig(r6));
        goto L3
    L8:
        if (r2 != 3) goto L3;
        if (r6.getDepth() != r1) goto L3;
    L17:
        boolean r5 = false;
        Object[] r7 = r0.toArray(new MaterialConfig[0]);
        if (r7 == null) goto L29;
        if (((MaterialConfig[]) r7).length != 0) goto L23;
        r5 = true;
    L23:
        if ((!r5) == true) goto L27;
        r7 = null;
    L27:
        return (MaterialConfig[]) r7;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final BlendConfig[] parseBlendConfigArray(XmlPullParser r6) {
        ArrayList r0 = new ArrayList();
        int r1 = r6.getDepth();
    L3:
        int r2 = r6.next();
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L8;
        String r3 = r6.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "parser.name");
        if (Intrinsics.areEqual(normalizeName(r3), MaterialConfigFormatNames.BLEND_CONFIG) == true) goto L15;
        skipCurrentTag(r6);
        goto L3
    L15:
        BlendConfig r4 = parseBlendConfigItem(r6);
        if (r4 == null) goto L3;
        r0.add(r4);
        goto L3
    L8:
        if (r2 != 3) goto L3;
        if (r6.getDepth() != r1) goto L3;
    L20:
        boolean r5 = false;
        Object[] r7 = r0.toArray(new BlendConfig[0]);
        if (r7 == null) goto L32;
        if (((BlendConfig[]) r7).length != 0) goto L26;
        r5 = true;
    L26:
        if ((!r5) == true) goto L30;
        r7 = null;
    L30:
        return (BlendConfig[]) r7;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final ParsedBlendConfigContainer parseBlendConfigContainer(XmlPullParser r13) {
        ParsedBlendConfigContainer r1 = parseStatefulBlendConfigsFromAttributes(r13, null);
        if (r1 == null) goto L5;
        INSTANCE.skipCurrentTag(r13);
        return r1;
    L5:
        if (hasAnyAttribute(r13, new String[]{"color"}) == false) goto L11;
        BlendConfig[] r12 = singleBlendConfigArray(parseBlendConfigItem(r13));
        if (r12 != null) goto L10;
        return null;
    L10:
        return new ParsedBlendConfigContainer(r12, BlendConfigStateList.Companion.valueOf(r12));
    L11:
        ArrayList r2 = new ArrayList();
        int r3 = r13.getDepth();
        BlendConfig[] r4 = null;
        BlendConfig[] r6 = null;
        BlendConfig[] r7 = null;
        BlendConfig[] r8 = null;
        BlendConfig[] r9 = null;
        BlendConfig[] r10 = null;
    L12:
        int r5 = r13.next();
        if (r5 == 1) goto L47;
        if (r5 != 2) goto L17;
        String r11 = r13.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "parser.name");
        String r14 = normalizeName(r11);
        if (Intrinsics.areEqual(r14, MaterialConfigFormatNames.BLEND_CONFIG) == true) goto L24;
        if (Intrinsics.areEqual(r14, MaterialState.NORMAL.getNodeName()) == true) goto L30;
        if (Intrinsics.areEqual(r14, MaterialState.PRESS.getNodeName()) == true) goto L33;
        if (Intrinsics.areEqual(r14, MaterialState.HOVER.getNodeName()) == true) goto L36;
        if (Intrinsics.areEqual(r14, MaterialState.CHECKED.getNodeName()) == true) goto L39;
        if (Intrinsics.areEqual(r14, MaterialState.SELECTED.getNodeName()) == true) goto L42;
        if (Intrinsics.areEqual(r14, MaterialState.DISABLE.getNodeName()) == true) goto L45;
        skipCurrentTag(r13);
        goto L12
    L45:
        r10 = parseBlendConfigArray(r13);
        goto L12
    L42:
        r9 = parseBlendConfigArray(r13);
        goto L12
    L39:
        r8 = parseBlendConfigArray(r13);
        goto L12
    L36:
        r7 = parseBlendConfigArray(r13);
        goto L12
    L33:
        r6 = parseBlendConfigArray(r13);
        goto L12
    L30:
        r4 = parseBlendConfigArray(r13);
        goto L12
    L24:
        BlendConfig r15 = parseBlendConfigItem(r13);
        if (r15 == null) goto L12;
        r2.add(r15);
        goto L12
    L17:
        if (r5 != 3) goto L12;
        if (r13.getDepth() != r3) goto L12;
    L47:
        boolean r16 = false;
        if (r4 != null) goto L56;
        ArrayList r17 = r2;
        if ((!r17.isEmpty()) == false) goto L56;
        Object[] r18 = r17.toArray(new BlendConfig[0]);
        if (r18 == null) goto L55;
        r4 = (BlendConfig[]) r18;
        goto L56
    L55:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L56:
        ResolvedStatefulValues<BlendConfig[]> r19 = resolveStatefulValues(r4, r6, r7, r8, r9, r10);
        if (r19 == null) goto L60;
        BlendConfigStateList r110 = buildBlendConfigStateList(r19);
        return new ParsedBlendConfigContainer(r110.getDefaultBlendConfig(), r110);
    L60:
        Object[] r111 = r2.toArray(new BlendConfig[0]);
        if (r111 == null) goto L75;
        if (((BlendConfig[]) r111).length != 0) goto L66;
        r16 = true;
    L66:
        if ((!r16) == true) goto L69;
        r111 = null;
    L69:
        BlendConfig[] r112 = (BlendConfig[]) r111;
        if (r112 != null) goto L73;
        return null;
    L73:
        return new ParsedBlendConfigContainer(r112, BlendConfigStateList.Companion.valueOf(r112));
    L75:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final ParsedBlendConfigContainer parseStatefulBlendConfigsFromAttributes(XmlPullParser r10, String r11) {
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        ResolvedStatefulValues<BlendConfig[]> r12 = resolveStatefulValues(parseStatefulBlendConfigValue(r10, r11, MaterialState.NORMAL), parseStatefulBlendConfigValue(r10, r11, MaterialState.PRESS), parseStatefulBlendConfigValue(r10, r11, MaterialState.HOVER), parseStatefulBlendConfigValue(r10, r11, MaterialState.CHECKED), parseStatefulBlendConfigValue(r10, r11, MaterialState.SELECTED), parseStatefulBlendConfigValue(r10, r11, MaterialState.DISABLE));
        if (r12 != null) goto L10;
        return null;
    L10:
        BlendConfigStateList r9 = buildBlendConfigStateList(r12);
        return new ParsedBlendConfigContainer(r9.getDefaultBlendConfig(), r9);
    L6:
        if ((!StringsKt.isBlank(r11)) == false) goto L4;
        goto L4
    }

    private final BlendConfig[] parseStatefulBlendConfigValue(XmlPullParser r1, String r2, MaterialState r3) {
        BlendConfig r0 = parseBlendConfigValueFromAttributes(r1, r2, r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        return new BlendConfig[]{r0};
    }

    private final BlendConfig parseBlendConfigValueFromAttributes(XmlPullParser r3, String r4, MaterialState r5) {
        Integer r0 = parseColor(getStatefulAttribute(r3, r5, "color", r4));
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.intValue();
        Integer r2 = parseBlendMode(getStatefulAttribute(r3, r5, MaterialConfigFormatNames.BLEND_MODE, r4));
        if (r2 != null) goto L9;
        int r6 = BlendMode.SRC_OVER.porterDuffMode;
    L11:
        return new BlendConfig(r1, r6);
    L9:
        r6 = r2.intValue();
        goto L11
    }

    private final BlendConfig parseBlendConfigItem(XmlPullParser r3) {
        Integer r0 = parseColor(getAttribute(r3, new String[]{"color"}));
        if (r0 != null) goto L6;
        skipCurrentTag(r3);
        return null;
    L6:
        int r1 = r0.intValue();
        Integer r2 = parseBlendMode(getAttribute(r3, new String[]{MaterialConfigFormatNames.BLEND_MODE}));
        if (r2 != null) goto L9;
        int r4 = BlendMode.SRC_OVER.porterDuffMode;
    L10:
        skipCurrentTag(r3);
        return new BlendConfig(r1, r4);
    L9:
        r4 = r2.intValue();
        goto L10
    }

    private final StrokeConfig parseStroke(XmlPullParser r9) {
        Float r0 = parseFloat(getAttribute(r9, new String[]{MaterialConfigFormatNames.WIDTH}));
        Integer r1 = parseColor(getAttribute(r9, new String[]{"color"}));
        Integer r2 = parseBlendMode(getAttribute(r9, new String[]{MaterialConfigFormatNames.BLEND_MODE}));
        skipCurrentTag(r9);
        BlendMode r8 = null;
        if (r0 == null) goto L22;
        if (r1 == null) goto L22;
        float r10 = r0.floatValue();
        int r3 = r1.intValue();
        if (r2 == null) goto L18;
        int r4 = r2.intValue();
        BlendMode[] r5 = BlendMode.values();
        int r6 = r5.length;
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L18;
        BlendMode r11 = r5[r7];
        if (r11.porterDuffMode != r4) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == true) goto L16;
        r7 = r7 + 1;
        goto L10
    L16:
        r8 = r11;
        goto L18
    L14:
        r12 = false;
    L18:
        if (r8 != null) goto L21;
        r8 = BlendMode.SRC_OVER;
    L21:
        return new StrokeConfig(r10, r3, r8);
    L22:
        return null;
    }

    private final StrokeStateList parseStrokeStateList(XmlPullParser r12) {
        if (hasAnyAttribute(r12, new String[]{MaterialConfigFormatNames.WIDTH, "color"}) == false) goto L9;
        StrokeConfig r11 = parseStroke(r12);
        if (r11 != null) goto L8;
        return null;
    L8:
        return StrokeStateList.Companion.valueOf(r11);
    L9:
        int r0 = r12.getDepth();
        StrokeConfig r2 = null;
        StrokeConfig r3 = null;
        StrokeConfig r6 = null;
        StrokeConfig r7 = null;
        StrokeConfig r8 = null;
        StrokeConfig r9 = null;
        StrokeConfig r10 = null;
    L10:
        int r4 = r12.next();
        if (r4 == 1) goto L42;
        if (r4 != 2) goto L15;
        String r5 = r12.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "parser.name");
        String r13 = normalizeName(r5);
        if (Intrinsics.areEqual(r13, MaterialConfigFormatNames.STROKE) == true) goto L22;
        if (Intrinsics.areEqual(r13, MaterialState.NORMAL.getNodeName()) == true) goto L25;
        if (Intrinsics.areEqual(r13, MaterialState.PRESS.getNodeName()) == true) goto L28;
        if (Intrinsics.areEqual(r13, MaterialState.HOVER.getNodeName()) == true) goto L31;
        if (Intrinsics.areEqual(r13, MaterialState.CHECKED.getNodeName()) == true) goto L34;
        if (Intrinsics.areEqual(r13, MaterialState.SELECTED.getNodeName()) == true) goto L37;
        if (Intrinsics.areEqual(r13, MaterialState.DISABLE.getNodeName()) == true) goto L40;
        skipCurrentTag(r12);
        goto L10
    L40:
        r10 = parseStrokeStateItem(r12);
        goto L10
    L37:
        r9 = parseStrokeStateItem(r12);
        goto L10
    L34:
        r8 = parseStrokeStateItem(r12);
        goto L10
    L31:
        r7 = parseStrokeStateItem(r12);
        goto L10
    L28:
        r6 = parseStrokeStateItem(r12);
        goto L10
    L25:
        r2 = parseStrokeStateItem(r12);
        goto L10
    L22:
        r3 = parseStroke(r12);
        goto L10
    L15:
        if (r4 != 3) goto L10;
        if (r12.getDepth() != r0) goto L10;
    L42:
        if (r2 != null) goto L44;
        StrokeConfig r14 = r3;
    L45:
        ResolvedStatefulValues r15 = resolveStatefulValues(r14, r6, r7, r8, r9, r10);
        if (r15 != null) goto L49;
        return null;
    L49:
        return StrokeStateList.Companion.of$default(StrokeStateList.Companion, (StrokeConfig) r15.getNormal(), null, (StrokeConfig) r15.getChecked(), (StrokeConfig) r15.getPressed(), (StrokeConfig) r15.getHovered(), (StrokeConfig) r15.getDisabled(), 2, null);
    L44:
        r14 = r2;
        goto L45
    }

    private final StrokeConfig parseStrokeStateItem(XmlPullParser r5) {
        if (hasAnyAttribute(r5, new String[]{MaterialConfigFormatNames.WIDTH, "color"}) == true) goto L5;
        int r0 = r5.getDepth();
    L7:
        int r1 = r5.next();
        if (r1 == 1) goto L30;
        if (r1 == 2) goto L17;
        if (r1 != 3) goto L7;
        if (r5.getDepth() != r0) goto L7;
        return null;
    L17:
        String r2 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "parser.name");
        if (Intrinsics.areEqual(normalizeName(r2), MaterialConfigFormatNames.STROKE) == true) goto L29;
        skipCurrentTag(r5);
        StrokeConfig r4 = (StrokeConfig) null;
        return null;
    L29:
        return parseStroke(r5);
    L30:
        return null;
    L5:
        return parseStroke(r5);
    }

    private final BlurConfig parseBlurConfig(XmlPullParser r10) {
        Float r0 = parseFloat(getAttribute(r10, new String[]{MaterialConfigFormatNames.BLUR_RADIUS}));
        Integer r1 = parseBlurDirection(getAttribute(r10, new String[]{MaterialConfigFormatNames.DIRECTION}));
        int r2 = 0;
        if (r1 != null) goto L5;
        int r5 = 0;
    L6:
        Float r3 = parseFloat(getAttribute(r10, new String[]{"alpha"}));
        if (r3 != null) goto L9;
        float r6 = 1.0f;
    L10:
        Integer r4 = parseCurveType(getAttribute(r10, new String[]{MaterialConfigFormatNames.CURVE_TYPE}));
        if (r4 == null) goto L14;
        r2 = r4.intValue();
    L14:
        int r7 = r2;
        Float r8 = parseFloat(getAttribute(r10, new String[]{MaterialConfigFormatNames.END_POINT}));
        if (r8 != null) goto L17;
        float r9 = 1.0f;
    L18:
        skipCurrentTag(r10);
        if (r0 != null) goto L23;
        return null;
    L23:
        return new BlurConfig(r0.floatValue(), r5, r6, r7, r9);
    L17:
        r9 = r8.floatValue();
        goto L18
    L9:
        r6 = r3.floatValue();
        goto L10
    L5:
        r5 = r1.intValue();
        goto L6
    }

    private final ShadowConfig[] parseShadowArray(XmlPullParser r6) {
        ArrayList r0 = new ArrayList();
        int r1 = r6.getDepth();
    L3:
        int r2 = r6.next();
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L8;
        String r3 = r6.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "parser.name");
        if (Intrinsics.areEqual(normalizeName(r3), MaterialConfigFormatNames.SHADOW) == true) goto L15;
        skipCurrentTag(r6);
        goto L3
    L15:
        ShadowConfig r4 = parseShadowItem(r6);
        if (r4 == null) goto L3;
        r0.add(r4);
        goto L3
    L8:
        if (r2 != 3) goto L3;
        if (r6.getDepth() != r1) goto L3;
    L20:
        boolean r5 = false;
        Object[] r7 = r0.toArray(new ShadowConfig[0]);
        if (r7 == null) goto L32;
        if (((ShadowConfig[]) r7).length != 0) goto L26;
        r5 = true;
    L26:
        if ((!r5) == true) goto L30;
        r7 = null;
    L30:
        return (ShadowConfig[]) r7;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final ShadowConfig parseShadowItem(XmlPullParser r10) {
        Integer r0 = parseColor(getAttribute(r10, new String[]{"color"}));
        if (r0 != null) goto L6;
        skipCurrentTag(r10);
        return null;
    L6:
        int r4 = r0.intValue();
        Float r1 = parseFloat(getAttribute(r10, new String[]{MaterialConfigFormatNames.X}));
        if (r1 != null) goto L9;
        float r2 = 0.0f;
    L10:
        Float r3 = parseFloat(getAttribute(r10, new String[]{"y"}));
        if (r3 != null) goto L13;
        float r5 = 0.0f;
    L14:
        Float r6 = parseFloat(getAttribute(r10, new String[]{MaterialConfigFormatNames.BLUR_RADIUS}));
        if (r6 != null) goto L17;
        float r7 = 0.0f;
    L18:
        Float r8 = parseFloat(getAttribute(r10, new String[]{MaterialConfigFormatNames.SPREAD}));
        if (r8 != null) goto L21;
        float r9 = 0.0f;
    L22:
        Integer r11 = parseBlendMode(getAttribute(r10, new String[]{MaterialConfigFormatNames.BLEND_MODE}));
        if (r11 != null) goto L25;
        int r12 = -1;
    L26:
        ShadowConfig r13 = new ShadowConfig(r2, r5, r7, r4, r9, r12);
        skipCurrentTag(r10);
        return r13;
    L25:
        r12 = r11.intValue();
        goto L26
    L21:
        r9 = r8.floatValue();
        goto L22
    L17:
        r7 = r6.floatValue();
        goto L18
    L13:
        r5 = r3.floatValue();
        goto L14
    L9:
        r2 = r1.floatValue();
        goto L10
    }

    private final FluidConfig parseFluidConfig(XmlPullParser r2) {
        float[] r0 = parseFluidParams(r2);
        skipCurrentTag(r2);
        return new FluidConfig(r0);
    }

    private final float[] parseFluidParams(XmlPullParser r11) {
        Float r0 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.REFRACTION_HEIGHT}));
        if (r0 != null) goto L5;
        return null;
    L5:
        float r1 = r0.floatValue();
        Float r2 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.REFRACTION_STRENGTH}));
        if (r2 != null) goto L8;
        return null;
    L8:
        float r3 = r2.floatValue();
        Float r4 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_ANGLE}));
        if (r4 != null) goto L11;
        return null;
    L11:
        float r5 = r4.floatValue();
        Float r6 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_FALLOFF}));
        if (r6 != null) goto L14;
        return null;
    L14:
        float r7 = r6.floatValue();
        Float r8 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_WIDTH}));
        if (r8 != null) goto L17;
        return null;
    L17:
        float r9 = r8.floatValue();
        Float r10 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_ALPHA}));
        if (r10 != null) goto L20;
        return null;
    L20:
        float r12 = r10.floatValue();
        Float r13 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_INSET}));
        if (r13 != null) goto L23;
        return null;
    L23:
        float r14 = r13.floatValue();
        Float r15 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_STRENGTH}));
        if (r15 != null) goto L26;
        return null;
    L26:
        int r16 = 0;
        float[] r17 = {r1, r3, r5, r7, r9, r12, r14, r15.floatValue()};
        Integer r18 = parseColor(getAttribute(r11, new String[]{MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_COLOR}));
        Integer r19 = parseBlendMode(getAttribute(r11, new String[]{MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_BLEND_MODE}));
        Integer r20 = parseColor(getAttribute(r11, new String[]{MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_COLOR}));
        Integer r21 = parseBlendMode(getAttribute(r11, new String[]{MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_BLEND_MODE}));
        Float r110 = parseFloat(getAttribute(r11, new String[]{MaterialConfigFormatNames.CHROMATIC_ABERRATION}));
        if (r18 != null) goto L32;
        if (r19 != null) goto L32;
        if (r20 != null) goto L32;
        if (r21 != null) goto L32;
        if (r110 != null) goto L32;
        return r17;
    L32:
        FloatSpreadBuilder r111 = new FloatSpreadBuilder(6);
        r111.addSpread(r17);
        FloatCompanionObject r22 = FloatCompanionObject.INSTANCE;
        if (r18 != null) goto L35;
        int r23 = 0;
    L36:
        r111.add(Float.intBitsToFloat(r23));
        if (r19 != null) goto L39;
        int r24 = BlendMode.SRC_OVER.porterDuffMode;
    L40:
        r111.add(r24);
        FloatCompanionObject r25 = FloatCompanionObject.INSTANCE;
        if (r20 == null) goto L44;
        r16 = r20.intValue();
    L44:
        r111.add(Float.intBitsToFloat(r16));
        if (r21 != null) goto L47;
        int r26 = BlendMode.SRC_OVER.porterDuffMode;
    L48:
        r111.add(r26);
        if (r110 != null) goto L51;
        float r112 = 0.0f;
    L52:
        r111.add(r112);
        return r111.toArray();
    L51:
        r112 = r110.floatValue();
        goto L52
    L47:
        r26 = r21.intValue();
        goto L48
    L39:
        r24 = r19.intValue();
        goto L40
    L35:
        r23 = r18.intValue();
        goto L36
    }

    private final String getAttribute(XmlPullParser r7, String... r8) {
        boolean r0 = true;
        if (r8.length != 0) goto L5;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L9;
        return null;
    L9:
        Set r9 = ArraysKt.toSet(r8);
        int r10 = r7.getAttributeCount();
        int r3 = 0;
    L10:
        if (r3 >= r10) goto L30;
        int r4 = r3 + 1;
        String r5 = r7.getAttributeName(r3);
        if (r5 == null) goto L29;
        if (r9.contains(r5) == false) goto L29;
        String r11 = r7.getAttributeValue(r3);
        if (r11 == null) goto L36;
        String r12 = StringsKt.trim(r11).toString();
        if (r12 != null) goto L23;
        return null;
    L23:
        if (r12.length() > 0) goto L26;
        r0 = false;
    L26:
        if (r0 == true) goto L28;
        return null;
    L28:
        return r12;
    L36:
        return null;
    L29:
        r3 = r4;
        goto L10
    L30:
        return null;
    L5:
        r6 = false;
        goto L7
    }

    private final boolean hasAnyAttribute(XmlPullParser r2, String... r3) {
        if (getAttribute(r2, (String[]) Arrays.copyOf(r3, r3.length)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final ColorStateList parseFallbackBgColorFromAttributes(XmlPullParser r15) {
        Integer r0 = parseColor(getStatefulAttribute$default(this, r15, MaterialState.NORMAL, null, MaterialConfigFormatNames.FALLBACK_BG_COLOR, 4, null));
        if (r0 != null) goto L5;
        r0 = parseColor(getAttribute(r15, new String[]{MaterialConfigFormatNames.FALLBACK_BG_COLOR}));
    L5:
        ResolvedStatefulValues<Integer> r16 = resolveStatefulValues(r0, parseColor(getStatefulAttribute$default(this, r15, MaterialState.PRESS, null, MaterialConfigFormatNames.FALLBACK_BG_COLOR, 4, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.HOVER, null, MaterialConfigFormatNames.FALLBACK_BG_COLOR, 4, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.CHECKED, null, MaterialConfigFormatNames.FALLBACK_BG_COLOR, 4, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.SELECTED, null, MaterialConfigFormatNames.FALLBACK_BG_COLOR, 4, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.DISABLE, null, MaterialConfigFormatNames.FALLBACK_BG_COLOR, 4, null)));
        if (r16 != null) goto L9;
        return null;
    L9:
        return buildColorStateList(r16);
    }

    private final ColorStateList parseFallbackBgColorContainer(XmlPullParser r11) {
        ColorStateList r0 = parseStatefulColorsFromAttributes(r11);
        if (r0 != null) goto L46;
        Integer r1 = parseColor(getAttribute(r11, new String[]{"color"}));
        if (r1 == null) goto L8;
        skipCurrentTag(r11);
        return ColorStateList.valueOf(r1.intValue());
    L8:
        int r2 = r11.getDepth();
        Integer r3 = null;
        Integer r5 = null;
        Integer r6 = null;
        Integer r7 = null;
        Integer r8 = null;
        Integer r9 = null;
    L9:
        int r4 = r11.next();
        if (r4 == 1) goto L38;
        if (r4 != 2) goto L14;
        String r10 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r10, "parser.name");
        String r12 = normalizeName(r10);
        if (Intrinsics.areEqual(r12, MaterialState.NORMAL.getNodeName()) == true) goto L21;
        if (Intrinsics.areEqual(r12, MaterialState.PRESS.getNodeName()) == true) goto L24;
        if (Intrinsics.areEqual(r12, MaterialState.HOVER.getNodeName()) == true) goto L27;
        if (Intrinsics.areEqual(r12, MaterialState.CHECKED.getNodeName()) == true) goto L30;
        if (Intrinsics.areEqual(r12, MaterialState.SELECTED.getNodeName()) == true) goto L33;
        if (Intrinsics.areEqual(r12, MaterialState.DISABLE.getNodeName()) == true) goto L36;
        skipCurrentTag(r11);
        goto L9
    L36:
        r9 = parseColorItem(r11);
        goto L9
    L33:
        r8 = parseColorItem(r11);
        goto L9
    L30:
        r7 = parseColorItem(r11);
        goto L9
    L27:
        r6 = parseColorItem(r11);
        goto L9
    L24:
        r5 = parseColorItem(r11);
        goto L9
    L21:
        r3 = parseColorItem(r11);
        goto L9
    L14:
        if (r4 != 3) goto L9;
        if (r11.getDepth() != r2) goto L9;
    L38:
        if (r3 != null) goto L40;
        Integer r13 = null;
    L41:
        ResolvedStatefulValues<Integer> r14 = resolveStatefulValues(r13, r5, r6, r7, r8, r9);
        if (r14 != null) goto L45;
        return null;
    L45:
        return buildColorStateList(r14);
    L40:
        r13 = r3;
        goto L41
    L46:
        INSTANCE.skipCurrentTag(r11);
        return r0;
    }

    private final ColorStateList parseStatefulColorsFromAttributes(XmlPullParser r15) {
        ResolvedStatefulValues<Integer> r16 = resolveStatefulValues(parseColor(getStatefulAttribute$default(this, r15, MaterialState.NORMAL, null, null, 12, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.PRESS, null, null, 12, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.HOVER, null, null, 12, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.CHECKED, null, null, 12, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.SELECTED, null, null, 12, null)), parseColor(getStatefulAttribute$default(this, r15, MaterialState.DISABLE, null, null, 12, null)));
        if (r16 != null) goto L6;
        return null;
    L6:
        return buildColorStateList(r16);
    }

    private final Integer parseColorItem(XmlPullParser r2) {
        Integer r0 = parseColor(getAttribute(r2, new String[]{"color"}));
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
        INSTANCE.skipCurrentTag(r2);
        return Integer.valueOf(r1);
    L5:
        return parseColor(readTextContent(r2));
    }

    private final ColorStateList buildColorStateList(ResolvedStatefulValues<Integer> r5) {
        if (r5.allEqual(C02911.INSTANCE) == false) goto L7;
        ColorStateList r4 = ColorStateList.valueOf(r5.getNormal().intValue());
        Intrinsics.checkNotNullExpressionValue(r4, "valueOf(values.normal)");
        return r4;
    L7:
        return new ColorStateList(MATERIAL_STATE_SPECS, new int[]{r5.getChecked().intValue(), r5.getChecked().intValue(), r5.getSelected().intValue(), r5.getSelected().intValue(), r5.getSelected().intValue(), r5.getSelected().intValue(), r5.getPressed().intValue(), r5.getHovered().intValue(), r5.getChecked().intValue(), r5.getSelected().intValue(), r5.getDisabled().intValue(), r5.getNormal().intValue()});
    }

    private final BlendConfigStateList buildBlendConfigStateList(ResolvedStatefulValues<BlendConfig[]> r5) {
        if (r5.allEqual(AnonymousClass1.INSTANCE) == false) goto L7;
        return BlendConfigStateList.Companion.valueOf(r5.getNormal());
    L7:
        return BlendConfigStateList.Companion.of(MATERIAL_STATE_SPECS, new BlendConfig[][]{r5.getChecked(), r5.getChecked(), r5.getSelected(), r5.getSelected(), r5.getSelected(), r5.getSelected(), r5.getPressed(), r5.getHovered(), r5.getChecked(), r5.getSelected(), r5.getDisabled(), r5.getNormal()});
    }

    private final Integer parseColor(String r5) {
        if (r5 != null) goto L5;
    L4:
        String r6 = null;
    L13:
        if (r6 != null) goto L32;
        return null;
    L32:
    L30:
        Integer r4 = (Integer) null;
        return null;
    L16:
        if (StringsKt.startsWith$default(r6, "#", false, 2, null) == false) goto L19;
        int r7 = Color.parseColor(r6);     // Catch: Throwable -> L30
    L28:
        return Integer.valueOf(r7);
    L19:
        if (StringsKt.startsWith(r6, "0x", true) == false) goto L21;
        String r8 = r6.substring(2);     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L30
        r7 = (int) Long.parseLong(r8, CharsKt.checkRadix(16));     // Catch: Throwable -> L30
        goto L28
    L21:
        Long r9 = StringsKt.toLongOrNull(r6);     // Catch: Throwable -> L30
        if (r9 != null) goto L24;
        Integer r10 = null;
    L25:
        if (r10 != null) goto L27;
        r7 = Color.parseColor(r6);     // Catch: Throwable -> L30
        goto L28
    L27:
        r7 = r10.intValue();     // Catch: Throwable -> L30
        goto L28
    L24:
        r10 = Integer.valueOf((int) r9.longValue());     // Catch: Throwable -> L30
        goto L25
    L5:
        r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L4;
        if (r6.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L4;
    L11:
        r2 = false;
        goto L12
    }

    private final Float parseFloat(String r2) {
        if (r2 != null) goto L5;
    L4:
        String r3 = null;
    L13:
        if (r3 != null) goto L16;
        return null;
    L16:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(r3, TabletDpiSettingsFragment.UNIT), "px"), CloudControlInf.SP));
    L5:
        r3 = StringsKt.trim(r2).toString();
        if (r3 == null) goto L4;
        if (r3.length() <= 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L4;
    L11:
        r0 = false;
        goto L12
    }

    private final Integer parseBlendMode(String r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
    L4:
        String r9 = null;
    L13:
        if (r9 != null) goto L15;
        return null;
    L15:
        Integer r2 = StringsKt.toIntOrNull(r9);
        if (r2 != null) goto L29;
        String r7 = normalizeName(r9).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        BlendMode[] r3 = BlendMode.values();
        int r4 = r3.length;
    L18:
        if (r0 >= r4) goto L23;
        BlendMode r5 = r3[r0];
        String r6 = INSTANCE.normalizeName(r5.name()).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (Intrinsics.areEqual(r6, r7) == true) goto L24;
        r0 = r0 + 1;
    L24:
        if (r5 != null) goto L27;
        return null;
    L27:
        return Integer.valueOf(r5.porterDuffMode);
    L23:
        r5 = null;
        goto L24
    L29:
        return Integer.valueOf(r2.intValue());
    L5:
        r9 = StringsKt.trim(r8).toString();
        if (r9 == null) goto L4;
        if (r9.length() <= 0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L4;
    L11:
        r10 = false;
        goto L12
    }

    private final Integer parseBlurDirection(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r1 = normalizeName(r2);
        switch(r1.hashCode()) {
            case -1372950257: goto L29;
            case -1039745817: goto L25;
            case -885896177: goto L21;
            case -149309725: goto L17;
            case 3387192: goto L13;
            case 818060433: goto L9;
            default: goto L33;
        };
    L9:
        if (r1.equals("progress_rightleft") == false) goto L33;
        return 4;
    L13:
        if (r1.equals("none") == false) goto L33;
        return -1;
    L17:
        if (r1.equals("progress_leftright") == false) goto L33;
        return 3;
    L21:
        if (r1.equals("progress_updown") == false) goto L33;
        return 2;
    L25:
        if (r1.equals("normal") == false) goto L33;
        return 0;
    L29:
        if (r1.equals("progress_downup") == false) goto L33;
        return 1;
    L33:
        return StringsKt.toIntOrNull(r2);
    }

    private final Integer parseCurveType(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r1 = normalizeName(r2);
        switch(r1.hashCode()) {
            case -1102672091: goto L33;
            case -356211779: goto L29;
            case -32570448: goto L25;
            case 54365080: goto L21;
            case 1672389401: goto L17;
            case 1829408660: goto L13;
            case 1939029025: goto L9;
            default: goto L37;
        };
    L9:
        if (r1.equals("in_quad") == false) goto L37;
        return 1;
    L13:
        if (r1.equals("inout_cubic") == false) goto L37;
        return 6;
    L17:
        if (r1.equals("out_cubic") == false) goto L37;
        return 5;
    L21:
        if (r1.equals("out_quad") == false) goto L37;
        return 2;
    L25:
        if (r1.equals("in_cubic") == false) goto L37;
        return 4;
    L29:
        if (r1.equals("inout_quad") == false) goto L37;
        return 3;
    L33:
        if (r1.equals("linear") == false) goto L37;
        return 0;
    L37:
        return StringsKt.toIntOrNull(r2);
    }

    static /* synthetic */ String getStatefulAttribute$default(MaterialXmlParser r1, XmlPullParser r2, MaterialState r3, String r4, String r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.getStatefulAttribute(r2, r3, r4, r5);
    }

    private final String getStatefulAttribute(XmlPullParser r5, MaterialState r6, String r7, String r8) {
        String r9 = r6.getXmlName();
        List r0 = CollectionsKt.createListBuilder();
        String r1 = r8;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L15;
        r0.add(r8 + '_' + r9);
        if (r7 == null) goto L15;
        r0.add(r8 + '_' + r9 + '_' + r7);
    L15:
        if (r7 == null) goto L18;
        r0.add(r9 + '_' + r7);
    L18:
        if (r7 != null) goto L20;
        r0.add(r9);
    L20:
        Object[] r10 = CollectionsKt.build(r0).toArray(new String[0]);
        if (r10 == null) goto L25;
        String[] r11 = (String[]) r10;
        return getAttribute(r5, (String[]) Arrays.copyOf(r11, r11.length));
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final void skipCurrentTag(XmlPullParser r4) {
        int r0 = 1;
    L3:
        if (r0 <= 0) goto L13;
        int r1 = r4.next();
        if (r1 == 1) goto L23;
        if (r1 != 2) goto L9;
        r0 = r0 + 1;
        goto L3
    L9:
        if (r1 != 3) goto L3;
        r0 = r0 - 1;
        goto L3
    L23:
        return;
    }

    private final String readTextContent(XmlPullParser r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.getDepth();
    L3:
        int r2 = r6.next();
        boolean r3 = true;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L8;
        skipCurrentTag(r6);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        if (r6.getDepth() != r1) goto L3;
    L10:
        if (r2 == 4) goto L14;
        if (r2 != 5) goto L3;
    L14:
        r0.append(r6.getText());
    L19:
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "builder.toString()");
        String r7 = StringsKt.trim(r5).toString();
        if (r7.length() > 0) goto L23;
        r3 = false;
    L23:
        if (r3 == true) goto L40;
        return null;
    L40:
        return r7;
    }

    private final String normalizeName(String r7) {
        String r0 = StringsKt.trim(r7).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return StringsKt.replace$default(r0, '-', '_', false, 4, null);
    }

    private final String normalizeXmlFileName(String r2) {
        if (StringsKt.endsWith(r2, XML_SUFFIX, true) == false) goto L6;
        return r2;
    L6:
        return Intrinsics.stringPlus(r2, XML_SUFFIX);
    }

    private final <T> ResolvedStatefulValues<T> resolveStatefulValues(T r8, T r9, T r10, T r11, T r12, T r13) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r9 != null) goto L7;
        T r2 = r8;
    L8:
        if (r10 != null) goto L10;
        T r3 = r2;
    L12:
        if (r11 != null) goto L14;
        T r4 = r8;
    L15:
        if (r12 != null) goto L17;
        T r5 = r8;
    L18:
        if (r13 != null) goto L20;
        T r6 = r8;
    L22:
        return new ResolvedStatefulValues(r8, r2, r3, r4, r5, r6);
    L20:
        r6 = r13;
        goto L22
    L17:
        r5 = r12;
        goto L18
    L14:
        r4 = r11;
        goto L15
    L10:
        r3 = r10;
        goto L12
    L7:
        r2 = r9;
        goto L8
    }

    private final <T> T parseWithParser(File r3, Function1<? super XmlPullParser, ? extends T> r4) {
        if (r3.exists() == true) goto L5;
        return null;
    L5:
        if (r3.isFile() == true) goto L7;
        return null;
    L7:
        if (r3.canRead() == false) goto L27;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L19
        T r5 = (T) INSTANCE.parseWithParser(r2, r4);
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L19
        return r5;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L28:
        return null;
    L27:
        return null;
    }

    private final <T> T parseWithParser(ContentResolver r2, Uri r3, Function1<? super XmlPullParser, ? extends T> r4) {
        InputStream r5 = r2.openInputStream(r3);     // Catch: Throwable -> L16
        if (r5 == null) goto L15;
        InputStream r6 = r5;     // Catch: Throwable -> L16
        MaterialXmlParser r0 = INSTANCE;     // Catch: Throwable -> L10
        T r7 = (T) r0.parseWithParser(r6, r4);
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L16
        return r7;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L15:
        return null;
    L23:
        return null;
    }

    private final <T> T parseWithParser(InputStream r3, Function1<? super XmlPullParser, ? extends T> r4) {
        XmlPullParser r2 = XmlPullParserFactory.newInstance().newPullParser();
        r2.setInput(r3, Charsets.UTF_8.name());
        int r5 = r2.getEventType();
    L4:
        if (r5 == 2) goto L8;
        if (r5 == 1) goto L8;
        r5 = r2.next();
    L8:
        if (r5 == 2) goto L10;
        return null;
    L10:
        Intrinsics.checkNotNullExpressionValue(r2, "parser");
        return r4.invoke(r2);
    }
}
