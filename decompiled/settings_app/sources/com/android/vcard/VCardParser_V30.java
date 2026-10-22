package com.android.vcard;

import com.android.settings.applications.InstalledAppDetails;
import com.android.vcard.exception.VCardException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class VCardParser_V30 extends VCardParser {
    static final Set<String> sAcceptableEncoding = null;
    static final Set<String> sKnownPropertyNameSet = null;
    private final VCardParserImpl_V30 mVCardParserImpl;

    static {
        sKnownPropertyNameSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{VCardConstants.PROPERTY_BEGIN, VCardConstants.PROPERTY_END, VCardConstants.PROPERTY_LOGO, VCardConstants.PROPERTY_PHOTO, "LABEL", VCardConstants.PROPERTY_FN, VCardConstants.PROPERTY_TITLE, VCardConstants.PROPERTY_SOUND, VCardConstants.PROPERTY_VERSION, VCardConstants.PROPERTY_TEL, VCardConstants.PROPERTY_EMAIL, "TZ", "GEO", VCardConstants.PROPERTY_NOTE, VCardConstants.PROPERTY_URL, VCardConstants.PROPERTY_BDAY, VCardConstants.PROPERTY_ROLE, VCardConstants.PROPERTY_REV, InstalledAppDetails.ARG_APP_UID, "KEY", "MAILER", VCardConstants.PROPERTY_NAME, "PROFILE", "SOURCE", VCardConstants.PROPERTY_NICKNAME, "CLASS", VCardConstants.PROPERTY_SORT_STRING, VCardConstants.PROPERTY_CATEGORIES, VCardConstants.PROPERTY_PRODID, VCardConstants.PROPERTY_IMPP})));
        sAcceptableEncoding = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{VCardConstants.PARAM_ENCODING_7BIT, VCardConstants.PARAM_ENCODING_8BIT, VCardConstants.PARAM_ENCODING_BASE64, VCardConstants.PARAM_ENCODING_B})));
    }

    public VCardParser_V30() {
        this.mVCardParserImpl = new VCardParserImpl_V30();
    }

    public VCardParser_V30(int r2) {
        this.mVCardParserImpl = new VCardParserImpl_V30(r2);
    }

    @Override // com.android.vcard.VCardParser
    public void addInterpreter(VCardInterpreter r1) {
        this.mVCardParserImpl.addInterpreter(r1);
    }

    @Override // com.android.vcard.VCardParser
    public void parse(InputStream r1) throws IOException, VCardException {
        this.mVCardParserImpl.parse(r1);
    }

    @Override // com.android.vcard.VCardParser
    public void parseOne(InputStream r1) throws IOException, VCardException {
        this.mVCardParserImpl.parseOne(r1);
    }

    @Override // com.android.vcard.VCardParser
    public void cancel() {
        this.mVCardParserImpl.cancel();
    }
}
