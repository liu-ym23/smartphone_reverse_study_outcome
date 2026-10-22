package com.obric.safecheck.parser;

import com.google.gson.stream.JsonReader;
import com.obric.safecheck.data.ParsedData;
import com.obric.safecheck.data.ParsedPhoneData;
import com.obric.safecheck.database.entity.Item;
import com.obric.safecheck.database.entity.PhoneItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhoneParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0014J&\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/parser/PhoneParser;", "Lcom/obric/safecheck/parser/Parser;", "Lcom/obric/safecheck/database/entity/PhoneItem;", "isBlacklistParser", "", "(Z)V", "getParsedData", "Lcom/obric/safecheck/data/ParsedData;", "getTag", "", "parseItem", "reader", "Lcom/google/gson/stream/JsonReader;", "startTime", "endTime", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PhoneParser extends Parser<PhoneItem> {
    @Override // com.obric.safecheck.parser.Parser
    protected String getTag() {
        return "PhoneParser_AntiFraud";
    }

    public PhoneParser(boolean r1) {
        this.isBlacklistParser = r1;
    }

    @Override // com.obric.safecheck.parser.Parser
    public /* bridge */ /* synthetic */ Item parseItem(JsonReader r1, String r2, String r3) {
        return parseItem(r1, r2, r3);
    }

    @Override // com.obric.safecheck.parser.Parser
    public ParsedData<PhoneItem> getParsedData() {
        return new ParsedPhoneData();
    }

    @Override // com.obric.safecheck.parser.Parser
    public PhoneItem parseItem(JsonReader r7, String r8, String r9) {
        PhoneItem r10 = new PhoneItem(null, null, false, 7, null);
        if (r7 == null) goto L5;
        r7.beginObject();
    L5:
        if (r7 == null) goto L18;
        if (r7.hasNext() != true) goto L18;
        String r0 = r7.nextName();
        if (r0 == null) goto L17;
        if (r0.hashCode() != 106642798) goto L17;
        if (r0.equals("phone") == false) goto L17;
        String r1 = r7.nextString();
        Intrinsics.checkNotNullExpressionValue(r1, "reader.nextString()");
        r10.setPhone(r1);
    L17:
        r7.skipValue();
    L18:
        if (r7 == null) goto L20;
        r7.endObject();
    L20:
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        r10.setTimestamp(r8);
        r10.setBlacklist(this.isBlacklistParser);
        return r10;
    }
}
