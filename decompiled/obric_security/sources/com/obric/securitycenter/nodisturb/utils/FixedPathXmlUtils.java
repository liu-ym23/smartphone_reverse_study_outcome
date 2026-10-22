package com.obric.securitycenter.nodisturb.utils;

import androidx.exifinterface.media.ExifInterface;
import com.obric.olog.OLog;
import com.obric.oui.material.MaterialConfigBuilder;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: XmlUniversalUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0091\u0001\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u00132\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0016\u0012\u0004\u0012\u00020\n0\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00182\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u001aj\u0002`\u001b\u0012\u0004\u0012\u00020\n0\u0013H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u000fJ)\u0010\u001f\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u000b0!¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u000e\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014H\u0002J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0018\u0010*\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0001H\u0002J+\u0010+\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\u0006\u0010,\u001a\u0002H\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0002\u00100R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/FixedPathXmlUtils;", "", "()V", "xmlFactory", "Lorg/xmlpull/v1/XmlPullParserFactory;", "getXmlFactory", "()Lorg/xmlpull/v1/XmlPullParserFactory;", "xmlFactory$delegate", "Lkotlin/Lazy;", "batchParseXmlStream", "", ExifInterface.GPS_DIRECTION_TRUE, "inputStream", "Ljava/io/FileInputStream;", "elementTag", "", "batchSize", "", "onElementParsed", "Lkotlin/Function1;", "", "onBatchProcess", "", "onComplete", "Lkotlin/Function0;", "onError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/io/FileInputStream;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseMap", MaterialConfigBuilder.SERIALIZATION_FORMAT_XML, "parseObject", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "serializeMap", "serializer", "Lorg/xmlpull/v1/XmlSerializer;", "map", "serializeObject", "obj", "rootTag", "serializeObjectAsAttributes", "setFieldValue", "instance", "field", "Ljava/lang/reflect/Field;", "value", "(Ljava/lang/Object;Ljava/lang/reflect/Field;Ljava/lang/String;)V", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FixedPathXmlUtils {
    private static final String BASE_FIXED_PATH = "/storage/emulated/0/systemTrd";
    public static final Companion Companion = null;
    private static volatile FixedPathXmlUtils instance;
    private final Lazy xmlFactory$delegate;

    /* JADX INFO: compiled from: XmlUniversalUtils.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J£\u0001\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2 \u0010\u000f\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u00102\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0013\u0012\u0004\u0012\u00020\b0\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\b0\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u0018\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J \u0010\"\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010#\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020'2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u0018\u0010(\u001a\u00020'2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0012\u0010)\u001a\u00020\u001d2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0006\u0010+\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020\u001bJ\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\b\b\u0002\u0010\u000b\u001a\u00020\u0004J*\u0010.\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J*\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u0004J \u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/FixedPathXmlUtils$Companion;", "", "()V", "BASE_FIXED_PATH", "", "instance", "Lcom/obric/securitycenter/nodisturb/utils/FixedPathXmlUtils;", "batchParseFixedPathFile", "", ExifInterface.GPS_DIRECTION_TRUE, "fileName", "subDir", "elementTag", "batchSize", "", "onElementParsed", "Lkotlin/Function1;", "", "onBatchProcess", "", "onComplete", "Lkotlin/Function0;", "onError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToFixedPath", "", "sourceFile", "Ljava/io/File;", "destFileName", "createSubDirectory", "deleteFixedPathFile", "fileExists", "fromXmlString", MaterialConfigBuilder.SERIALIZATION_FORMAT_XML, "(Ljava/lang/String;)Ljava/lang/Object;", "getBaseFixedDir", "getDirectorySize", "", "getFileSize", "getFixedDir", "getFixedFile", "getInstance", "isPathWritable", "listFixedPathXmlFiles", "readFromFixedPath", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "readXmlFromFixedPath", "saveToFixedPath", "obj", "rootTag", "saveXmlToFixedPath", "xmlStr", "toXmlString", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public static /* synthetic */ boolean $r8$lambda$WBpZ7jsUS7VMT01XI012OBTS7C8(File r0) {
            return listFixedPathXmlFiles$lambda$7(r0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final FixedPathXmlUtils getInstance() {
            FixedPathXmlUtils r0 = FixedPathXmlUtils.access$getInstance$cp();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = FixedPathXmlUtils.access$getInstance$cp();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new FixedPathXmlUtils(null);     // Catch: Throwable -> L10
            Companion r1 = FixedPathXmlUtils.Companion;     // Catch: Throwable -> L10
            FixedPathXmlUtils.access$setInstance$cp(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }

        private final File getBaseFixedDir() {
            File r3 = new File(FixedPathXmlUtils.BASE_FIXED_PATH);
            if (r3.exists() == true) goto L5;
            r3.mkdirs();
            OLog.d("FixedPathXmlUtils", "创建基础目录: " + r3.getAbsolutePath());
        L5:
            return r3;
        }

        static /* synthetic */ File getFixedDir$default(Companion r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "";
        L6:
            return r0.getFixedDir(r1);
        }

        private final File getFixedDir(String r3) {
            if (r3.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L11;
            File r1 = new File(getBaseFixedDir(), r3);
            if (r1.exists() == true) goto L12;
            r1.mkdirs();
            OLog.d("FixedPathXmlUtils", "创建子目录: " + r1.getAbsolutePath());
            return r1;
        L12:
            return r1;
        L11:
            return getBaseFixedDir();
        L5:
            r0 = false;
            goto L6
        }

        private final File getFixedFile(String r1, String r2) {
            return new File(getFixedDir(r1), r2);
        }

        public static /* synthetic */ boolean fileExists$default(Companion r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "";
        L6:
            return r0.fileExists(r1, r2);
        }

        public final boolean fileExists(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "subDir");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            return getFixedFile(r2, r3).exists();
        }

        public static /* synthetic */ long getFileSize$default(Companion r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "";
        L6:
            return r0.getFileSize(r1, r2);
        }

        public final long getFileSize(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "subDir");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            File r1 = getFixedFile(r2, r3);
            if (r1.exists() == true) goto L7;
            return 0;
        L7:
            return r1.length();
        }

        public static /* synthetic */ String toXmlString$default(Companion r0, Object r1, String r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = "";
        L6:
            return r0.toXmlString(r1, r2);
        }

        public final String toXmlString(Object r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "obj");
            Intrinsics.checkNotNullParameter(r3, "rootTag");
            return FixedPathXmlUtils.access$serializeObject(getInstance(), r2, r3);
        }

        public final /* synthetic */ <T> T fromXmlString(String r6) {
            Intrinsics.checkNotNullParameter(r6, MaterialConfigBuilder.SERIALIZATION_FORMAT_XML);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            if (Map.class.isAssignableFrom(Object.class) == false) goto L6;
            Map<String, String> r5 = getInstance().parseMap(r6);
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) r5;
        L6:
            FixedPathXmlUtils r7 = getInstance();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) r7.parseObject(r6, Object.class);
        }

        public static /* synthetic */ boolean saveToFixedPath$default(Companion r1, Object r2, String r3, String r4, String r5, int r6, Object r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = "";
        L6:
            if ((r6 & 8) == 0) goto L9;
            r5 = "";
        L9:
            return r1.saveToFixedPath(r2, r3, r4, r5);
        }

        public final boolean saveToFixedPath(Object r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "obj");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "subDir");
            Intrinsics.checkNotNullParameter(r5, "rootTag");
            return saveXmlToFixedPath(toXmlString(r2, r5), r3, r4);
        L5:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "保存对象到固定路径失败", e);
            return false;
        }

        public static /* synthetic */ Object readFromFixedPath$default(Companion r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L5;
            r4 = "";
        L5:
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "subDir");
            String r7 = r2.readXmlFromFixedPath(r3, r4);     // Catch: Exception -> L11
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L11
            if (Map.class.isAssignableFrom(Object.class) == false) goto L9;
            Map<String, String> r8 = r2.getInstance().parseMap(r7);     // Catch: Exception -> L11
            Intrinsics.reifiedOperationMarker(1, "T?");     // Catch: Exception -> L11
            Map<String, String> r9 = r8;     // Catch: Exception -> L11
        L14:
            return r9;
        L9:
            FixedPathXmlUtils r10 = r2.getInstance();     // Catch: Exception -> L11
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L11
            r9 = r10.parseObject(r7, Object.class);     // Catch: Exception -> L11
        L11:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "从固定路径读取对象失败", e);
            return null;
        }

        public final /* synthetic */ <T> T readFromFixedPath(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "fileName");
            Intrinsics.checkNotNullParameter(r6, "subDir");
            String r7 = readXmlFromFixedPath(r5, r6);     // Catch: Exception -> L8
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L8
            if (Map.class.isAssignableFrom(Object.class) == false) goto L6;
            Map<String, String> r4 = getInstance().parseMap(r7);     // Catch: Exception -> L8
            Intrinsics.reifiedOperationMarker(1, "T?");     // Catch: Exception -> L8
            T r8 = (T) r4;
        L11:
            return r8;
        L6:
            FixedPathXmlUtils r9 = getInstance();     // Catch: Exception -> L8
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L8
            r8 = (T) r9.parseObject(r7, Object.class);
        L8:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "从固定路径读取对象失败", e);
            return null;
        }

        public final <T> Object batchParseFixedPathFile(String r13, String r14, String r15, int r16, Function1<? super Map<String, String>, ? extends T> r17, Function1<? super List<? extends T>, Unit> r18, Function0<Unit> r19, Function1<? super Exception, Unit> r20, Continuation<? super Unit> r21) {
            if ((r21 instanceof FixedPathXmlUtils$Companion$batchParseFixedPathFile$1) == false) goto L7;
            FixedPathXmlUtils$Companion$batchParseFixedPathFile$1 r2 = (FixedPathXmlUtils$Companion$batchParseFixedPathFile$1) r21;
            if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
            r2.label -= Integer.MIN_VALUE;
        L8:
            FixedPathXmlUtils$Companion$batchParseFixedPathFile$1 r11 = r2;
            Object r1 = r11.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r11.label;
            if (r4 == 0) goto L18;
            if (r4 != 1) goto L17;
            Closeable r5 = (Closeable) r11.L$0;
            ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14
        L27:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L14
            CloseableKt.closeFinally(r5, null);
            return Unit.INSTANCE;
        L14:
            th = th;
        L15:
            Throwable r6 = th;
            throw r6;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            CloseableKt.closeFinally(r5, r6);
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r1);
            File r7 = getFixedFile(r14, r13);
            if (r7.exists() == true) goto L22;
            r20.invoke(new FileNotFoundException("文件不存在：" + r7.getAbsolutePath()));
            return Unit.INSTANCE;
        L22:
            FileInputStream r8 = new FileInputStream(r7);
            FixedPathXmlUtils r9 = FixedPathXmlUtils.Companion.getInstance();     // Catch: Throwable -> L30
            r11.L$0 = r8;     // Catch: Throwable -> L30
            r11.label = 1;     // Catch: Throwable -> L30
            if (FixedPathXmlUtils.access$batchParseXmlStream(r9, r8, r15, r16, r17, r18, r19, r20, r11) != r3) goto L26;
            return r3;
        L26:
            r5 = r8;
        L30:
            th = th;
            r5 = r8;
        L7:
            r2 = new FixedPathXmlUtils$Companion$batchParseFixedPathFile$1(this, r21);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object batchParseFixedPathFile$default(Companion r12, String r13, String r14, String r15, int r16, Function1 r17, Function1 r18, Function0 r19, Function1 r20, Continuation r21, int r22, Object r23) {
            if ((r22 & 2) == 0) goto L5;
            String r4 = "";
        L7:
            if ((r22 & 8) == 0) goto L9;
            int r6 = 100;
        L11:
            if ((r22 & 32) == 0) goto L13;
            Function1 r8 = FixedPathXmlUtils$Companion$batchParseFixedPathFile$2.INSTANCE;
        L15:
            if ((r22 & 64) == 0) goto L17;
            Function0 r9 = FixedPathXmlUtils$Companion$batchParseFixedPathFile$3.INSTANCE;
        L19:
            if ((r22 & 128) == 0) goto L21;
            Function1 r10 = FixedPathXmlUtils$Companion$batchParseFixedPathFile$4.INSTANCE;
        L23:
            return r12.batchParseFixedPathFile(r13, r4, r15, r6, r17, r8, r9, r10, r21);
        L21:
            r10 = r20;
            goto L23
        L17:
            r9 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r6 = r16;
            goto L11
        L5:
            r4 = r14;
            goto L7
        }

        private final boolean saveXmlToFixedPath(String r6, String r7, String r8) {
            File r9 = new File(getFixedDir(r8), r7);     // Catch: Exception -> L13 SecurityException -> L15
            OLog.d("FixedPathXmlUtils", "保存到固定路径：" + r9.getAbsolutePath());     // Catch: Exception -> L13 SecurityException -> L15
            FileOutputStream r5 = new FileOutputStream(r9);     // Catch: Exception -> L13 SecurityException -> L15
            Charset r2 = StandardCharsets.UTF_8;     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r2, "UTF_8");     // Catch: Throwable -> L8
            byte[] r10 = r6.getBytes(r2);     // Catch: Throwable -> L8
            Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L8
            r5.write(r10);     // Catch: Throwable -> L8
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
            CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L13 SecurityException -> L15
            OLog.d("FixedPathXmlUtils", "保存成功，文件大小：" + r9.length() + " bytes");     // Catch: Exception -> L13 SecurityException -> L15
            return true;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            CloseableKt.closeFinally(r5, th);     // Catch: Exception -> L13 SecurityException -> L15
            throw th;     // Catch: Exception -> L13 SecurityException -> L15
        L15:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "权限不足，无法写入文件", e);
            return false;
        L13:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "保存XML失败", e);
            return false;
        }

        public final String readXmlFromFixedPath(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "fileName");
            Intrinsics.checkNotNullParameter(r6, "subDir");
            File r4 = getFixedFile(r6, r5);     // Catch: Exception -> L17 SecurityException -> L19
            if (r4.exists() == true) goto L7;
            OLog.w("FixedPathXmlUtils", "文件不存在：" + r4.getAbsolutePath());     // Catch: Exception -> L17 SecurityException -> L19
            return "";
        L7:
            FileInputStream r7 = new FileInputStream(r4);     // Catch: Exception -> L17 SecurityException -> L19
            byte[] r8 = ByteStreamsKt.readBytes(r7);     // Catch: Throwable -> L12
            Charset r9 = StandardCharsets.UTF_8;     // Catch: Throwable -> L12
            Intrinsics.checkNotNullExpressionValue(r9, "UTF_8");     // Catch: Throwable -> L12
            String r2 = new String(r8, r9);     // Catch: Throwable -> L12
            CloseableKt.closeFinally(r7, null);     // Catch: Exception -> L17 SecurityException -> L19
            return r2;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            CloseableKt.closeFinally(r7, th);     // Catch: Exception -> L17 SecurityException -> L19
            throw th;     // Catch: Exception -> L17 SecurityException -> L19
        L19:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "权限不足，无法读取文件", e);
            return "";
        L17:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "读取XML失败", e);
            return "";
        }

        public static /* synthetic */ List listFixedPathXmlFiles$default(Companion r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "";
        L6:
            return r0.listFixedPathXmlFiles(r1);
        }

        public final List<String> listFixedPathXmlFiles(String r5) {
            Intrinsics.checkNotNullParameter(r5, "subDir");
            File r4 = getFixedDir(r5);     // Catch: Exception -> L15 SecurityException -> L17
            if (r4.exists() == false) goto L6;
            File[] r6 = r4.listFiles(new FixedPathXmlUtils$Companion$$ExternalSyntheticLambda0());     // Catch: Exception -> L15 SecurityException -> L17
            if (r6 == null) goto L24;
            ArrayList r7 = new ArrayList(r6.length);     // Catch: Exception -> L15 SecurityException -> L17
            int r1 = r6.length;     // Catch: Exception -> L15 SecurityException -> L17
            int r2 = 0;
        L10:
            if (r2 >= r1) goto L22;
            r7.add(r6[r2].getName());     // Catch: Exception -> L15 SecurityException -> L17
            r2 = r2 + 1;     // Catch: Exception -> L15 SecurityException -> L17
            goto L10
        L22:
            return r7;
        L24:
            return CollectionsKt.emptyList();
        L6:
            return CollectionsKt.emptyList();
        L17:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "权限不足，无法列出文件", e);
            return CollectionsKt.emptyList();
        L15:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "列出文件失败", e);
            return CollectionsKt.emptyList();
        }

        private static final boolean listFixedPathXmlFiles$lambda$7(File r2) {
            if (r2.isFile() == false) goto L7;
            String r3 = r2.getName();
            Intrinsics.checkNotNullExpressionValue(r3, "file.name");
            if (StringsKt.endsWith(r3, ".xml", true) == false) goto L7;
            return true;
        L7:
            return false;
        }

        public static /* synthetic */ boolean deleteFixedPathFile$default(Companion r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = "";
        L6:
            return r0.deleteFixedPathFile(r1, r2);
        }

        public final boolean deleteFixedPathFile(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "fileName");
            Intrinsics.checkNotNullParameter(r5, "subDir");
            File r3 = getFixedFile(r5, r4);     // Catch: Exception -> L7 SecurityException -> L9
            if (r3.exists() == false) goto L14;
            boolean r6 = r3.delete();     // Catch: Exception -> L7 SecurityException -> L9
            OLog.d("FixedPathXmlUtils", "删除文件 " + r3.getAbsolutePath() + " 结果：" + r6);     // Catch: Exception -> L7 SecurityException -> L9
        L15:
            return r6;
        L14:
            return false;
        L9:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "权限不足，无法删除文件", e);
            return false;
        L7:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "删除文件失败", e);
            return false;
        }

        public static /* synthetic */ boolean copyToFixedPath$default(Companion r0, File r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = "";
        L6:
            return r0.copyToFixedPath(r1, r2, r3);
        }

        public final boolean copyToFixedPath(File r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r11, "sourceFile");
            Intrinsics.checkNotNullParameter(r12, "destFileName");
            Intrinsics.checkNotNullParameter(r13, "subDir");
        L11:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "权限不足，无法复制文件", e);
            return false;
        L9:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "复制文件失败", e);
            return false;
        L4:
            if (r11.exists() == true) goto L7;
            OLog.w("FixedPathXmlUtils", "源文件不存在：" + r11.getAbsolutePath());     // Catch: Exception -> L9 SecurityException -> L11
            return false;
        L7:
            File r14 = new File(getFixedDir(r13), r12);     // Catch: Exception -> L9 SecurityException -> L11
            FilesKt.copyTo$default(r11, r14, true, 0, 4, null);     // Catch: Exception -> L9 SecurityException -> L11
            OLog.d("FixedPathXmlUtils", "复制文件成功：" + r14.getAbsolutePath());     // Catch: Exception -> L9 SecurityException -> L11
            return true;
        }

        public static /* synthetic */ long getDirectorySize$default(Companion r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "";
        L6:
            return r0.getDirectorySize(r1);
        }

        public final long getDirectorySize(String r8) {
            Intrinsics.checkNotNullParameter(r8, "subDir");
            File r7 = getFixedDir(r8);     // Catch: Exception -> L12 SecurityException -> L14
            if (r7.exists() == true) goto L6;
            return 0;
        L6:
            Iterator r9 = SequencesKt.filter(FilesKt.walk$default(r7, null, 1, null), FixedPathXmlUtils$Companion$getDirectorySize$1.INSTANCE).iterator();     // Catch: Exception -> L12 SecurityException -> L14
            long r3 = 0;
        L8:
            if (r9.hasNext() == false) goto L20;
            r3 = r3 + ((File) r9.next()).length();
            goto L8
        L20:
            return r3;
        L14:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "权限不足，无法获取目录大小", e);
            return 0;
        L12:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "获取目录大小失败", e);
            return 0;
        }

        public final boolean createSubDirectory(String r3) {
            Intrinsics.checkNotNullParameter(r3, "subDir");
            File r2 = getFixedDir(r3);     // Catch: Exception -> L8 SecurityException -> L10
            if (r2.exists() == true) goto L16;
            if (r2.mkdirs() == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "权限不足，无法创建目录", e);
            return false;
        L8:
            e = move-exception;
            OLog.e("FixedPathXmlUtils", "创建目录失败", e);
            return false;
        }

        public final boolean isPathWritable() {
            File r1 = new File(getFixedDir("test"), "test_write.tmp");     // Catch: Exception -> L5
            FilesKt.writeText$default(r1, "test", null, 2, null);     // Catch: Exception -> L5
            boolean r3 = r1.exists();     // Catch: Exception -> L5
            r1.delete();     // Catch: Exception -> L5
            return r3;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: com.obric.securitycenter.nodisturb.utils.FixedPathXmlUtils$batchParseXmlStream$2, reason: invalid class name */
    /* JADX INFO: compiled from: XmlUniversalUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.securitycenter.nodisturb.utils.FixedPathXmlUtils$batchParseXmlStream$2", f = "XmlUniversalUtils.kt", i = {}, l = {633, 637}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $batchSize;
        final /* synthetic */ String $elementTag;
        final /* synthetic */ FileInputStream $inputStream;
        final /* synthetic */ Function1<List<? extends T>, Unit> $onBatchProcess;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ Function1<Map<String, String>, T> $onElementParsed;
        final /* synthetic */ Function1<Exception, Unit> $onError;
        int label;
        final /* synthetic */ FixedPathXmlUtils this$0;

        /* JADX INFO: renamed from: com.obric.securitycenter.nodisturb.utils.FixedPathXmlUtils$batchParseXmlStream$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: XmlUniversalUtils.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.securitycenter.nodisturb.utils.FixedPathXmlUtils$batchParseXmlStream$2$2", f = "XmlUniversalUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $onComplete;
            int label;

            C00782(Function0<Unit> r1, Continuation<? super C00782> r2) {
                this.$onComplete = r1;
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return new C00782(this.$onComplete, r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00782) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.securitycenter.nodisturb.utils.FixedPathXmlUtils$batchParseXmlStream$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: XmlUniversalUtils.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.securitycenter.nodisturb.utils.FixedPathXmlUtils$batchParseXmlStream$2$3", f = "XmlUniversalUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Function1<Exception, Unit> $onError;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(Function1<? super Exception, Unit> r1, Exception r2, Continuation<? super AnonymousClass3> r3) {
                this.$onError = r1;
                this.$e = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass3(this.$onError, this.$e, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((AnonymousClass3) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$onError.invoke(this.$e);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(FixedPathXmlUtils r1, FileInputStream r2, String r3, Function1<? super List<? extends T>, Unit> r4, Function1<? super Map<String, String>, ? extends T> r5, int r6, Function0<Unit> r7, Function1<? super Exception, Unit> r8, Continuation<? super AnonymousClass2> r9) {
            this.this$0 = r1;
            this.$inputStream = r2;
            this.$elementTag = r3;
            this.$onBatchProcess = r4;
            this.$onElementParsed = r5;
            this.$batchSize = r6;
            this.$onComplete = r7;
            this.$onError = r8;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new AnonymousClass2(this.this$0, this.$inputStream, this.$elementTag, this.$onBatchProcess, this.$onElementParsed, this.$batchSize, this.$onComplete, this.$onError, r12);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L57:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);     // Catch: Exception -> L11
            goto L57
        L13:
            ResultKt.throwOnFailure(r12);
            XmlPullParser r13 = FixedPathXmlUtils.access$getXmlFactory(this.this$0).newPullParser();     // Catch: Exception -> L11
            r13.setInput(this.$inputStream, "UTF-8");     // Catch: Exception -> L11
            ArrayList r2 = new ArrayList();     // Catch: Exception -> L11
            int r5 = r13.getEventType();     // Catch: Exception -> L11
            LinkedHashMap r7 = null;
            String r8 = "";
        L16:
            if (r5 == 1) goto L48;
            if (r5 == 2) goto L43;
            if (r5 == 3) goto L33;
            if (r5 != 4) goto L46;
            String r6 = r13.getText();     // Catch: Exception -> L11
            Intrinsics.checkNotNullExpressionValue(r6, "parser.text");     // Catch: Exception -> L11
            String r9 = StringsKt.trim(r6).toString();     // Catch: Exception -> L11
            if ((!StringsKt.isBlank(r9)) == false) goto L46;
            if (r7 == null) goto L46;
            if (r8.length() <= 0) goto L29;
            boolean r10 = true;
        L30:
            if (r10 == false) goto L46;
            r7.put(r8, r9);     // Catch: Exception -> L11
            goto L46
        L29:
            r10 = false;
        L46:
            r5 = r13.next();     // Catch: Exception -> L11
            goto L16
        L33:
            if (Intrinsics.areEqual(r13.getName(), this.$elementTag) == false) goto L41;
            if (r7 == null) goto L40;
            Function1<Map<String, String>, T> r11 = this.$onElementParsed;     // Catch: Exception -> L11
            int r14 = this.$batchSize;     // Catch: Exception -> L11
            Function1<List<? extends T>, Unit> r15 = this.$onBatchProcess;     // Catch: Exception -> L11
            Object r16 = r11.invoke(r7);     // Catch: Exception -> L11
            if (r16 == null) goto L40;
            r2.add(r16);     // Catch: Exception -> L11
            if (r2.size() < r14) goto L40;
            r15.invoke((List<? extends T>) CollectionsKt.toList(r2));     // Catch: Exception -> L11
            r2.clear();     // Catch: Exception -> L11
        L40:
            r7 = null;
            goto L46
        L41:
            r8 = "";
            goto L46
        L43:
            if (Intrinsics.areEqual(r13.getName(), this.$elementTag) == false) goto L45;
            r7 = new LinkedHashMap();     // Catch: Exception -> L11
            goto L46
        L45:
            r8 = r13.getName();     // Catch: Exception -> L11
            Intrinsics.checkNotNullExpressionValue(r8, "parser.name");     // Catch: Exception -> L11
            goto L46
        L48:
            if ((!r2.isEmpty()) == false) goto L50;
            this.$onBatchProcess.invoke(r2);     // Catch: Exception -> L11
        L50:
            this.label = 1;     // Catch: Exception -> L11
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00782(this.$onComplete, null), this) != r0) goto L57;
            return r0;
        L11:
            e = move-exception;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.$onError, e, null), this) != r0) goto L57;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ FixedPathXmlUtils(DefaultConstructorMarker r1) {
        this();
    }

    private FixedPathXmlUtils() {
        this.xmlFactory$delegate = LazyKt.lazy(FixedPathXmlUtils$xmlFactory$2.INSTANCE);
    }

    public static final /* synthetic */ Object access$batchParseXmlStream(FixedPathXmlUtils r0, FileInputStream r1, String r2, int r3, Function1 r4, Function1 r5, Function0 r6, Function1 r7, Continuation r8) {
        return r0.batchParseXmlStream(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static final /* synthetic */ FixedPathXmlUtils access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ XmlPullParserFactory access$getXmlFactory(FixedPathXmlUtils r0) {
        return r0.getXmlFactory();
    }

    public static final /* synthetic */ String access$serializeObject(FixedPathXmlUtils r0, Object r1, String r2) {
        return r0.serializeObject(r1, r2);
    }

    public static final /* synthetic */ void access$setInstance$cp(FixedPathXmlUtils r0) {
        instance = r0;
    }

    private final XmlPullParserFactory getXmlFactory() {
        Object r1 = this.xmlFactory$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-xmlFactory>(...)");
        return (XmlPullParserFactory) r1;
    }

    private final String serializeObject(Object r8, String r9) {
        String r0 = "";
        StringWriter r1 = new StringWriter();
        StringWriter r2 = r1;     // Catch: Throwable -> L25
        XmlSerializer r3 = getXmlFactory().newSerializer();     // Catch: Exception -> L21 Throwable -> L25
        r3.setOutput(r2);     // Catch: Exception -> L21 Throwable -> L25
        boolean r5 = true;
        r3.startDocument("UTF-8", true);     // Catch: Exception -> L21 Throwable -> L25
        if (r9.length() > 0) goto L8;
        r5 = false;
    L8:
        if (r5 == false) goto L11;
    L14:
        r3.startTag("", r9);     // Catch: Exception -> L21 Throwable -> L25
        if ((r8 instanceof Map) == false) goto L18;
        Intrinsics.checkNotNullExpressionValue(r3, "serializer");     // Catch: Exception -> L21 Throwable -> L25
        serializeMap(r3, (Map) r8);     // Catch: Exception -> L21 Throwable -> L25
    L19:
        r3.endTag("", r9);     // Catch: Exception -> L21 Throwable -> L25
        r3.endDocument();     // Catch: Exception -> L21 Throwable -> L25
        r0 = r2.toString();     // Catch: Exception -> L21 Throwable -> L25
    L23:
        CloseableKt.closeFinally(r1, null);
        Intrinsics.checkNotNullExpressionValue(r0, "StringWriter().use { wri…\"\n            }\n        }");
        return r0;
    L18:
        Intrinsics.checkNotNullExpressionValue(r3, "serializer");     // Catch: Exception -> L21 Throwable -> L25
        serializeObjectAsAttributes(r3, r8);     // Catch: Exception -> L21 Throwable -> L25
        goto L19
    L11:
        if ((r8 instanceof Map) == false) goto L13;
        r9 = "Backup";
        goto L14
    L13:
        r9 = r8.getClass().getSimpleName();     // Catch: Exception -> L21 Throwable -> L25
    L21:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "序列化对象失败", e);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public final Map<String, String> parseMap(String r7) {
        Intrinsics.checkNotNullParameter(r7, MaterialConfigBuilder.SERIALIZATION_FORMAT_XML);
        if (StringsKt.isBlank(r7) == false) goto L19;
        return null;
    L19:
        XmlPullParser r6 = getXmlFactory().newPullParser();     // Catch: Exception -> L16
        r6.setInput(new StringReader(r7));     // Catch: Exception -> L16
        int r8 = r6.getEventType();     // Catch: Exception -> L16
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L16
    L7:
        if (r8 == 1) goto L25;
        if (r8 == 2) goto L10;
        r8 = r6.next();     // Catch: Exception -> L16
        goto L7
    L10:
        int r9 = r6.getAttributeCount();     // Catch: Exception -> L16
        int r2 = 0;
    L11:
        if (r2 >= r9) goto L25;
        String r3 = r6.getAttributeName(r2);     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r3, "parser.getAttributeName(i)");     // Catch: Exception -> L16
        String r4 = r6.getAttributeValue(r2);     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r4, "parser.getAttributeValue(i)");     // Catch: Exception -> L16
        r0.put(r3, r4);     // Catch: Exception -> L16
        r2 = r2 + 1;     // Catch: Exception -> L16
    L25:
        return r0;
    L16:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "解析XML为Map失败", e);
        Map r10 = (Map) null;
        return null;
    }

    public final <T> T parseObject(String r18, Class<T> r19) {
        Intrinsics.checkNotNullParameter(r18, MaterialConfigBuilder.SERIALIZATION_FORMAT_XML);
        Intrinsics.checkNotNullParameter(r19, "clazz");
        if (StringsKt.isBlank(r18) == false) goto L70;
        return null;
    L70:
        XmlPullParser r1 = getXmlFactory().newPullParser();     // Catch: Exception -> L67
        r1.setInput(new StringReader(r18));     // Catch: Exception -> L67
        T r0 = r19.newInstance();     // Catch: Exception -> L67
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L67
        Field[] r5 = r19.getDeclaredFields();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r5, "clazz.declaredFields");     // Catch: Exception -> L67
        Field[] r6 = r5;     // Catch: Exception -> L67
        int r7 = r6.length;     // Catch: Exception -> L67
        int r8 = 0;
    L7:
        int r10 = 1;
        if (r8 >= r7) goto L10;
        Field r11 = r6[r8];     // Catch: Exception -> L67
        r11.setAccessible(true);     // Catch: Exception -> L67
        String r12 = r11.getName();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r12, "field.name");     // Catch: Exception -> L67
        String r13 = r12.toLowerCase();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase()");     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r11, "field");     // Catch: Exception -> L67
        r4.put(r13, r11);     // Catch: Exception -> L67
        r8 = r8 + 1;     // Catch: Exception -> L67
        goto L7
    L10:
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L67
        int r14 = r1.getEventType();     // Catch: Exception -> L67
        String r15 = "";
        int r16 = 0;
        boolean r17 = false;
    L12:
        if (r14 == r10) goto L74;
        if (r14 != 2) goto L16;
        r16 = r16 + 1;     // Catch: Exception -> L67
        String r20 = r1.getName();     // Catch: Exception -> L67
        if (r16 != r10) goto L61;
        String r110 = r19.getSimpleName();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r110, "clazz.simpleName");     // Catch: Exception -> L67
        String r21 = r110.toLowerCase();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r21, "this as java.lang.String).toLowerCase()");     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r20, "tagName");     // Catch: Exception -> L67
        String r111 = r20.toLowerCase();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r111, "this as java.lang.String).toLowerCase()");     // Catch: Exception -> L67
        if (Intrinsics.areEqual(r111, r21) == false) goto L54;
    L59:
        boolean r22 = true;
    L60:
        r17 = r22;
        goto L61
    L54:
        if (Intrinsics.areEqual(r111, r21 + "s") == true) goto L59;
        if (r4.containsKey(r111) == true) goto L59;
        r22 = false;
    L61:
        if (r17 == false) goto L64;
        if (r16 < 2) goto L64;
        Intrinsics.checkNotNullExpressionValue(r20, "tagName");     // Catch: Exception -> L67
        r15 = r20.toLowerCase();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase()");     // Catch: Exception -> L67
        StringsKt.clear(r9);     // Catch: Exception -> L67
    L64:
        r14 = r1.next();     // Catch: Exception -> L67
        r10 = 1;
        goto L12
    L16:
        if (r14 != 3) goto L18;
        if (r17 == false) goto L45;
        if (r15.length() <= 0) goto L32;
        int r23 = r10;
    L33:
        if (r23 == 0) goto L45;
        if (r9.length() <= 0) goto L37;
        int r24 = r10;
    L38:
        if (r24 == 0) goto L45;
        Field r25 = (Field) r4.get(r15);     // Catch: Exception -> L67
        if (r25 == null) goto L43;
        String r112 = r9.toString();     // Catch: Exception -> L67
        Intrinsics.checkNotNullExpressionValue(r112, "currentValue.toString()");     // Catch: Exception -> L67
        setFieldValue(r0, r25, StringsKt.trim(r112).toString());     // Catch: Exception -> L67
    L43:
        StringsKt.clear(r9);     // Catch: Exception -> L67
        r15 = "";
        goto L45
    L37:
        r24 = 0;
        goto L38
    L32:
        r23 = 0;
    L45:
        r16 = r16 - 1;     // Catch: Exception -> L67
        if (r16 != 0) goto L64;
        r17 = false;
        goto L64
    L18:
        if (r14 != 4) goto L64;
        if (r17 == false) goto L64;
        if (r15.length() <= 0) goto L24;
        int r26 = r10;
    L25:
        if (r26 == 0) goto L64;
        r9.append(r1.getText());     // Catch: Exception -> L67
        goto L64
    L24:
        r26 = 0;
        goto L25
    L74:
        return r0;
    L67:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "解析XML失败", e);
        return null;
    }

    private final <T> void setFieldValue(T r4, Field r5, String r6) {
        Class<?> r3 = r5.getType();     // Catch: Exception -> L71
        if (Intrinsics.areEqual(r3, String.class) == false) goto L5;
        r5.set(r4, r6);     // Catch: Exception -> L71
        return;
    L5:
        boolean r1 = true;
        if (Intrinsics.areEqual(r3, Integer.TYPE) == false) goto L8;
        boolean r0 = true;
    L9:
        byte r2 = 0;
        int r7 = 0;
        short r8 = 0;
        if (r0 == false) goto L16;
        Integer r9 = StringsKt.toIntOrNull(r6);     // Catch: Exception -> L71
        if (r9 == null) goto L14;
        r7 = r9.intValue();     // Catch: Exception -> L71
    L14:
        r5.set(r4, Integer.valueOf(r7));     // Catch: Exception -> L71
        return;
    L16:
        if (Intrinsics.areEqual(r3, Long.TYPE) == false) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L26;
        Long r11 = StringsKt.toLongOrNull(r6);     // Catch: Exception -> L71
        if (r11 == null) goto L23;
        long r12 = r11.longValue();     // Catch: Exception -> L71
    L24:
        r5.set(r4, Long.valueOf(r12));     // Catch: Exception -> L71
        return;
    L23:
        r12 = 0;
        goto L24
    L26:
        if (Intrinsics.areEqual(r3, Double.TYPE) == false) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L36;
        Double r14 = StringsKt.toDoubleOrNull(r6);     // Catch: Exception -> L71
        if (r14 == null) goto L33;
        double r15 = r14.doubleValue();     // Catch: Exception -> L71
    L34:
        r5.set(r4, Double.valueOf(r15));     // Catch: Exception -> L71
        return;
    L33:
        r15 = 0.0d;
        goto L34
    L36:
        if (Intrinsics.areEqual(r3, Float.TYPE) == false) goto L38;
        boolean r16 = true;
    L39:
        if (r16 == false) goto L46;
        Float r17 = StringsKt.toFloatOrNull(r6);     // Catch: Exception -> L71
        if (r17 == null) goto L43;
        float r18 = r17.floatValue();     // Catch: Exception -> L71
    L44:
        r5.set(r4, Float.valueOf(r18));     // Catch: Exception -> L71
        return;
    L43:
        r18 = 0.0f;
        goto L44
    L46:
        if (Intrinsics.areEqual(r3, Boolean.TYPE) == false) goto L48;
        boolean r19 = true;
    L49:
        if (r19 == false) goto L52;
        r5.set(r4, Boolean.valueOf(Boolean.parseBoolean(r6)));     // Catch: Exception -> L71
        return;
    L52:
        if (Intrinsics.areEqual(r3, Short.TYPE) == false) goto L54;
        boolean r20 = true;
    L55:
        if (r20 == false) goto L61;
        Short r21 = StringsKt.toShortOrNull(r6);     // Catch: Exception -> L71
        if (r21 == null) goto L59;
        r8 = r21.shortValue();     // Catch: Exception -> L71
    L59:
        r5.set(r4, Short.valueOf(r8));     // Catch: Exception -> L71
        return;
    L61:
        if (Intrinsics.areEqual(r3, Byte.TYPE) == true) goto L64;
        r1 = Intrinsics.areEqual(r3, Byte.TYPE);     // Catch: Exception -> L71
    L64:
        if (r1 == false) goto L69;
        Byte r22 = StringsKt.toByteOrNull(r6);     // Catch: Exception -> L71
        if (r22 == null) goto L68;
        r2 = r22.byteValue();     // Catch: Exception -> L71
    L68:
        r5.set(r4, Byte.valueOf(r2));     // Catch: Exception -> L71
        return;
    L69:
        r5.set(r4, r6);     // Catch: Exception -> L71
        return;
    L54:
        r20 = Intrinsics.areEqual(r3, Short.TYPE);     // Catch: Exception -> L71
        goto L55
    L48:
        r19 = Intrinsics.areEqual(r3, Boolean.TYPE);     // Catch: Exception -> L71
        goto L49
    L38:
        r16 = Intrinsics.areEqual(r3, Float.TYPE);     // Catch: Exception -> L71
        goto L39
    L28:
        r13 = Intrinsics.areEqual(r3, Double.TYPE);     // Catch: Exception -> L71
        goto L29
    L18:
        r10 = Intrinsics.areEqual(r3, Long.TYPE);     // Catch: Exception -> L71
        goto L19
    L8:
        r0 = Intrinsics.areEqual(r3, Integer.TYPE);     // Catch: Exception -> L71
    L71:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "设置字段值失败：" + r5.getName() + "=" + r6, e);
    }

    private final <T> Object batchParseXmlStream(FileInputStream r13, String r14, int r15, Function1<? super Map<String, String>, ? extends T> r16, Function1<? super List<? extends T>, Unit> r17, Function0<Unit> r18, Function1<? super Exception, Unit> r19, Continuation<? super Unit> r20) {
        Object r0 = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r13, r14, r17, r16, r15, r18, r19, null), r20);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }

    private final void serializeObjectAsAttributes(XmlSerializer r6, Object r7) {
        Field[] r5 = r7.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r5, "obj.javaClass.declaredFields");
        Field[] r8 = r5;
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Field r2 = r8[r1];
        r2.setAccessible(true);
        Object r3 = r2.get(r7);
        if (r3 == null) goto L7;
        r6.attribute("", r2.getName(), r3.toString());
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private final void serializeMap(XmlSerializer r3, Map<?, ?> r4) {
        Iterator<Map.Entry<?, ?>> r2 = r4.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<?, ?> r5 = r2.next();
        Object r0 = r5.getKey();
        Object r6 = r5.getValue();
        if (r0 == null) goto L4;
        if (r6 == null) goto L4;
        r3.attribute("", r0.toString(), r6.toString());
        goto L4
    }
}
