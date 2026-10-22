package com.obric.safecheck.parser;

import com.google.gson.stream.JsonReader;
import com.obric.safecheck.data.ParsedData;
import com.obric.safecheck.data.ParsedUrlData;
import com.obric.safecheck.database.entity.Item;
import com.obric.safecheck.database.entity.UrlDomainItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UrlDomainParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014J$\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/obric/safecheck/parser/UrlDomainParser;", "Lcom/obric/safecheck/parser/Parser;", "Lcom/obric/safecheck/database/entity/UrlDomainItem;", "isBlacklistParser", "", "(Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getParsedData", "Lcom/obric/safecheck/data/ParsedData;", "getTag", "parseItem", "reader", "Lcom/google/gson/stream/JsonReader;", "startTime", "endTime", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class UrlDomainParser extends Parser<UrlDomainItem> {
    private final String TAG;

    public UrlDomainParser(boolean r2) {
        this.TAG = "UrlDomainParser_AntiFraud";
        this.isBlacklistParser = r2;
    }

    @Override // com.obric.safecheck.parser.Parser
    public /* bridge */ /* synthetic */ Item parseItem(JsonReader r1, String r2, String r3) {
        return parseItem(r1, r2, r3);
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.obric.safecheck.parser.Parser
    protected String getTag() {
        return this.TAG;
    }

    @Override // com.obric.safecheck.parser.Parser
    public ParsedData<UrlDomainItem> getParsedData() {
        return new ParsedUrlData();
    }

    @Override // com.obric.safecheck.parser.Parser
    public UrlDomainItem parseItem(JsonReader r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "reader");
        UrlDomainItem r11 = new UrlDomainItem(null, null, null, false, 15, null);
        r8.beginObject();
    L4:
        if (r8.hasNext() == false) goto L15;
        String r0 = r8.nextName();
        if (r0 == null) goto L14;
        if (r0.hashCode() != (-1326197564)) goto L14;
        if (r0.equals("domain") == false) goto L14;
        String r1 = r8.nextString();
        Intrinsics.checkNotNullExpressionValue(r1, "reader.nextString()");
        r11.setDomainOrigin(r1);
    L14:
        r8.skipValue();
        goto L4
    L15:
        r8.endObject();
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        r11.setTimestamp(r9);
        r11.setBlacklist(this.isBlacklistParser);
        r11.setDomain(r11.getDomainOrigin() + "_" + r11.getTimestamp());
        return r11;
    }
}
