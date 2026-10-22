package com.obric.safecheck.parser;

import com.google.gson.stream.JsonReader;
import com.obric.safecheck.data.Directory;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.entity.EndDataEntity;
import com.obric.safecheck.util.CompareDateStringsKt;
import com.obric.securitycenter.api.ApplicationContainer;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DirectoryParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/obric/safecheck/parser/DirectoryParser;", "", "()V", "DEFAULT_END_DATE", "", "currentEndData", "getCurrentEndData", "()Ljava/lang/String;", "setCurrentEndData", "(Ljava/lang/String;)V", "getEndData", "parseDirectory", "", "reader", "Lcom/google/gson/stream/JsonReader;", "setEndData", "endData", "updateEndData", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DirectoryParser {
    public static final String DEFAULT_END_DATE = "0000-00-00";
    public static final DirectoryParser INSTANCE = null;
    private static String currentEndData;

    static {
        INSTANCE = new DirectoryParser();
        currentEndData = DEFAULT_END_DATE;
    }

    private DirectoryParser() {
    }

    public final String getCurrentEndData() {
        return currentEndData;
    }

    public final void setCurrentEndData(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        currentEndData = r1;
    }

    public final void parseDirectory(JsonReader r3) throws IOException {
        Directory r2 = new Directory(null, 1, null);
        if (r3 != null) goto L5;
        return;
    L5:
        r3.beginObject();
    L7:
        if (r3.hasNext() == false) goto L12;
        if (Intrinsics.areEqual("endDate", r3.nextName()) == true) goto L10;
        r3.skipValue();
        goto L7
    L10:
        String r0 = r3.nextString();
        Intrinsics.checkNotNullExpressionValue(r0, "reader.nextString()");
        r2.setEndDate(r0);
        goto L7
    L12:
        r3.endObject();
        if (currentEndData.equals(DEFAULT_END_DATE) == false) goto L15;
    L16:
        currentEndData = r2.getEndDate();
        return;
    L15:
        if (CompareDateStringsKt.compareDateStrings(currentEndData, r2.getEndDate()) < 0) goto L16;
    }

    public final void setEndData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "endData");
        if (currentEndData.equals(DEFAULT_END_DATE) == false) goto L5;
    L6:
        currentEndData = r2;
        return;
    L5:
        if (CompareDateStringsKt.compareDateStrings(currentEndData, r2) < 0) goto L6;
    }

    public final void updateEndData() {
        EndDataEntity r4 = new EndDataEntity(0, currentEndData, 1, null);
        AntiFraudDatabase.getDatabase(ApplicationContainer.INSTANCE.getApplication()).endDataDao().updateEndData(r4);
    }

    public final String getEndData() {
        String r0 = AntiFraudDatabase.getDatabase(ApplicationContainer.INSTANCE.getApplication()).endDataDao().getEndData();
        if (r0 != null) goto L6;
        return DEFAULT_END_DATE;
    L6:
        return r0;
    }
}
