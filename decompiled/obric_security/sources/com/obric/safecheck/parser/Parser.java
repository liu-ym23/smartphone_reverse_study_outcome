package com.obric.safecheck.parser;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.obric.olog.OLog;
import com.obric.safecheck.data.ParsedData;
import com.obric.safecheck.database.entity.Item;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Parser<T extends Item> {
    public boolean isBlacklistParser;

    public abstract ParsedData<T> getParsedData();

    abstract String getTag();

    public abstract T parseItem(JsonReader reader, String startTime, String endTime) throws IOException;

    public Parser() {
    }

    public ParsedData<T> parse(JsonReader r4, String r5, String r6) throws IOException {
        ParsedData<T> r0 = getParsedData();
        r0.setEndTime(r6);
        if (r4.peek() != JsonToken.BEGIN_ARRAY) goto L12;
        r4.beginArray();
    L6:
        if (r4.hasNext() == false) goto L11;
        if (r4.peek() == JsonToken.BEGIN_OBJECT) goto L9;
        r4.skipValue();
        OLog.w(getTag(), "数组中包含非对象元素，已跳过");
        goto L6
    L9:
        r0.getItems().add(parseItem(r4, r5, r6));
        goto L6
    L11:
        r4.endArray();
        OLog.d(getTag(), "解析完成，共 " + r0.getCount() + " 个元素");
    L13:
        return r0;
    L12:
        r4.skipValue();
        OLog.w(getTag(), "字段不是数组类型，已跳过");
        goto L13
    }
}
