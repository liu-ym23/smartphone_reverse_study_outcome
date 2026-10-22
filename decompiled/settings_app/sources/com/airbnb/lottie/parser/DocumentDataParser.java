package com.airbnb.lottie.parser;

import android.icu.text.DateFormat;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = null;
    private static final JsonReader.Options NAMES = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ DocumentData parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new DocumentDataParser();
        NAMES = JsonReader.Options.of(new String[]{"t", "f", DateFormat.SECOND, DateFormat.HOUR, "tr", "lh", "ls", "fc", "sc", "sw", "of"});
    }

    private DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public DocumentData parse(JsonReader r18, float r19) throws IOException {
        DocumentData.Justification r0 = DocumentData.Justification.CENTER;
        r18.beginObject();
        DocumentData.Justification r9 = r0;
        String r6 = null;
        String r7 = null;
        float r8 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
        float r15 = 0.0f;
        int r10 = 0;
        int r13 = 0;
        int r14 = 0;
        boolean r16 = true;
    L4:
        if (r18.hasNext() == false) goto L24;
        switch(r18.selectName(NAMES)) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        r16 = r18.nextBoolean();
        goto L4
    L9:
        r15 = (float) r18.nextDouble();
        goto L4
    L10:
        r14 = JsonUtils.jsonToColor(r18);
        goto L4
    L11:
        r13 = JsonUtils.jsonToColor(r18);
        goto L4
    L12:
        r12 = (float) r18.nextDouble();
        goto L4
    L13:
        r11 = (float) r18.nextDouble();
        goto L4
    L14:
        r10 = r18.nextInt();
        goto L4
    L15:
        int r1 = r18.nextInt();
        if (r1 > DocumentData.Justification.CENTER.ordinal()) goto L20;
        if (r1 < 0) goto L20;
        r9 = DocumentData.Justification.values()[r1];
    L20:
        r9 = DocumentData.Justification.CENTER;
        goto L4
    L21:
        r8 = (float) r18.nextDouble();
        goto L4
    L22:
        r7 = r18.nextString();
        goto L4
    L23:
        r6 = r18.nextString();
        goto L4
    L7:
        r18.skipName();
        r18.skipValue();
        goto L4
    L24:
        r18.endObject();
        return new DocumentData(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    }
}
