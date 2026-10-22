package com.obric.safecheck.dataSync;

import com.google.gson.stream.JsonReader;
import com.obric.olog.OLog;
import com.obric.safecheck.database.entity.Item;
import com.obric.safecheck.parser.Parser;
import com.obric.safecheck.parser.ParserFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes4.dex */
public class JsonStreamParser {
    private static final int BUFFER_SIZE = 8192;
    private static final String TAG = "JsonStreamParser_AntiFraud";

    public JsonStreamParser() {
    }

    public void parse(InputStream jsonStream, String startTime, String endTime, DownloadParseCallback callback) throws IOException {
        JsonReader r5 = new JsonReader(new BufferedReader(new InputStreamReader(jsonStream, "UTF-8"), 8192));
        r5.beginObject();
    L4:
        if (r5.hasNext() == false) goto L12;
        String r4 = r5.nextName();
        Parser<? extends Item> r0 = ParserFactory.getParser(r4);
        if (r0 != null) goto L7;
        if ("directory".equals(r4) == true) goto L10;
        r5.skipValue();
        OLog.w(TAG, "未找到解析器，跳过字段: " + r4);
        goto L4
    L10:
        OLog.w(TAG, "解析器，directory: ");
        r5.skipValue();
        goto L4
    L7:
        OLog.w(TAG, "到解析器，字段: " + r4);
        callback.onSuccess(r0.parse(r5, startTime, endTime));
        goto L4
    L12:
        r5.endObject();
    }
}
