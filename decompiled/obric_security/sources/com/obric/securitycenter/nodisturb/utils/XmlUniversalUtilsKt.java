package com.obric.securitycenter.nodisturb.utils;

import androidx.exifinterface.media.ExifInterface;
import com.obric.olog.OLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlUniversalUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0007\u001a&\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0014\u0010\f\u001a\u00020\u0003*\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003¨\u0006\r"}, d2 = {"readFromFixedPath", ExifInterface.GPS_DIRECTION_TRUE, "fileName", "", "subDir", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "fromXml", "(Ljava/lang/String;)Ljava/lang/Object;", "saveToFixedPath", "", "", "rootTag", "toXml", "nodisturb_neridaCnRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XmlUniversalUtilsKt {
    public static /* synthetic */ String toXml$default(Object r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return toXml(r0, r1);
    }

    public static final String toXml(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "rootTag");
        return FixedPathXmlUtils.Companion.toXmlString(r1, r2);
    }

    public static final /* synthetic */ <T> T fromXml(String r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        FixedPathXmlUtils.Companion r0 = FixedPathXmlUtils.Companion;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        if (Map.class.isAssignableFrom(Object.class) == false) goto L5;
        Map<String, String> r7 = r0.getInstance().parseMap(r6);
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) r7;
    L5:
        FixedPathXmlUtils r1 = r0.getInstance();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r1.parseObject(r6, Object.class);
    }

    public static /* synthetic */ boolean saveToFixedPath$default(Object r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = "";
    L9:
        return saveToFixedPath(r1, r2, r3, r4);
    }

    public static final boolean saveToFixedPath(Object r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "subDir");
        Intrinsics.checkNotNullParameter(r4, "rootTag");
        return FixedPathXmlUtils.Companion.saveToFixedPath(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object readFromFixedPath$default(String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = "";
    L5:
        Intrinsics.checkNotNullParameter(r3, "fileName");
        Intrinsics.checkNotNullParameter(r4, "subDir");
        FixedPathXmlUtils.Companion r7 = FixedPathXmlUtils.Companion;
        String r8 = r7.readXmlFromFixedPath(r3, r4);     // Catch: Exception -> L11
        Intrinsics.reifiedOperationMarker(4, "T?");     // Catch: Exception -> L11
        if (Map.class.isAssignableFrom(Object.class) == false) goto L9;
        Map<String, String> r9 = r7.getInstance().parseMap(r8);     // Catch: Exception -> L11
        Intrinsics.reifiedOperationMarker(1, "T?");     // Catch: Exception -> L11
        Map<String, String> r10 = r9;     // Catch: Exception -> L11
    L14:
        return r10;
    L9:
        FixedPathXmlUtils r11 = r7.getInstance();     // Catch: Exception -> L11
        Intrinsics.reifiedOperationMarker(4, "T?");     // Catch: Exception -> L11
        r10 = r11.parseObject(r8, Object.class);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "从固定路径读取对象失败", e);
        return null;
    }

    public static final /* synthetic */ <T> T readFromFixedPath(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "fileName");
        Intrinsics.checkNotNullParameter(r6, "subDir");
        FixedPathXmlUtils.Companion r1 = FixedPathXmlUtils.Companion;
        String r7 = r1.readXmlFromFixedPath(r5, r6);     // Catch: Exception -> L8
        Intrinsics.reifiedOperationMarker(4, "T?");     // Catch: Exception -> L8
        if (Map.class.isAssignableFrom(Object.class) == false) goto L6;
        Map<String, String> r8 = r1.getInstance().parseMap(r7);     // Catch: Exception -> L8
        Intrinsics.reifiedOperationMarker(1, "T?");     // Catch: Exception -> L8
        T r9 = (T) r8;
    L11:
        return r9;
    L6:
        FixedPathXmlUtils r10 = r1.getInstance();     // Catch: Exception -> L8
        Intrinsics.reifiedOperationMarker(4, "T?");     // Catch: Exception -> L8
        r9 = (T) r10.parseObject(r7, Object.class);
    L8:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "从固定路径读取对象失败", e);
        return null;
    }
}
