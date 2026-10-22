package com.obric.safecheck.parser;

import com.google.gson.stream.JsonReader;
import com.obric.safecheck.data.ParsedData;
import com.obric.safecheck.data.ParsedPkgData;
import com.obric.safecheck.database.entity.Item;
import com.obric.safecheck.database.entity.PkgSignItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.util.HashUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class PkgSignParser extends Parser<PkgSignItem> {
    private static final String TAG = "PkgSignParser_AntiFraud";

    @Override // com.obric.safecheck.parser.Parser
    String getTag() {
        return TAG;
    }

    @Override // com.obric.safecheck.parser.Parser
    public /* bridge */ /* synthetic */ Item parseItem(JsonReader reader, String startTime, String endTime) throws IOException {
        return parseItem(reader, startTime, endTime);
    }

    public PkgSignParser(boolean isBlacklistParser) {
        this.isBlacklistParser = isBlacklistParser;
    }

    @Override // com.obric.safecheck.parser.Parser
    public ParsedData<PkgSignItem> getParsedData() {
        return new ParsedPkgData();
    }

    @Override // com.obric.safecheck.parser.Parser
    public PkgSignItem parseItem(JsonReader reader, String startTime, String endTime) throws IOException {
        PkgSignItem r6 = new PkgSignItem();
        reader.beginObject();
    L4:
        if (reader.hasNext() == false) goto L35;
        String r0 = reader.nextName();
        r0.hashCode();
        byte r2 = -1;
        switch(r0.hashCode()) {
            case -1032417381: goto L25;
            case 111052: goto L21;
            case 3563658: goto L17;
            case 110657401: goto L13;
            case 540453365: goto L9;
            default: goto L28;
        };
    L28:
        switch(r2) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            default: goto L29;
        };
    L30:
        r6.setRiskLevel(reader.nextString());
        goto L4
    L31:
        r6.setTsha1(reader.nextString());
        goto L4
    L32:
        r6.setTmd5(reader.nextString());
        goto L4
    L33:
        r6.setPkg(reader.nextString());
        goto L4
    L34:
        r6.setTsha256(reader.nextString());
        goto L4
    L29:
        reader.skipValue();
        goto L4
    L9:
        if (r0.equals("riskLevel") == false) goto L28;
        r2 = 4;
        goto L28
    L13:
        if (r0.equals("tsha1") == false) goto L28;
        r2 = 3;
        goto L28
    L17:
        if (r0.equals("tmd5") == false) goto L28;
        r2 = 2;
        goto L28
    L21:
        if (r0.equals(ApkVirusCheckProvider.KEY_PKG) == false) goto L28;
        r2 = 1;
        goto L28
    L25:
        if (r0.equals("tsha256") == false) goto L28;
        r2 = 0;
        goto L28
    L35:
        reader.endObject();
        r6.setTimestamp(startTime);
        r6.setUmd5(HashUtils.computeCombinedHashMd5(r6.getPkg(), r6.getTmd5(), r6.getRiskLevel(), r6.getTimestamp()));
        r6.setBlacklist(this.isBlacklistParser);
        return r6;
    }
}
