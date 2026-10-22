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
public final class VCardParser_V21 extends VCardParser {
    static final Set<String> sAvailableEncoding = null;
    static final Set<String> sKnownPropertyNameSet = null;
    static final Set<String> sKnownTypeSet = null;
    static final Set<String> sKnownValueSet = null;
    private final VCardParserImpl_V21 mVCardParserImpl;

    static {
        sKnownPropertyNameSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{VCardConstants.PROPERTY_BEGIN, VCardConstants.PROPERTY_END, VCardConstants.PROPERTY_LOGO, VCardConstants.PROPERTY_PHOTO, "LABEL", VCardConstants.PROPERTY_FN, VCardConstants.PROPERTY_TITLE, VCardConstants.PROPERTY_SOUND, VCardConstants.PROPERTY_VERSION, VCardConstants.PROPERTY_TEL, VCardConstants.PROPERTY_EMAIL, "TZ", "GEO", VCardConstants.PROPERTY_NOTE, VCardConstants.PROPERTY_URL, VCardConstants.PROPERTY_BDAY, VCardConstants.PROPERTY_ROLE, VCardConstants.PROPERTY_REV, InstalledAppDetails.ARG_APP_UID, "KEY", "MAILER"})));
        sKnownTypeSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{VCardConstants.PARAM_ADR_TYPE_DOM, VCardConstants.PARAM_ADR_TYPE_INTL, "POSTAL", VCardConstants.PARAM_ADR_TYPE_PARCEL, VCardConstants.PARAM_TYPE_HOME, VCardConstants.PARAM_TYPE_WORK, VCardConstants.PARAM_TYPE_PREF, VCardConstants.PARAM_TYPE_VOICE, VCardConstants.PARAM_TYPE_FAX, VCardConstants.PARAM_TYPE_MSG, VCardConstants.PARAM_TYPE_CELL, VCardConstants.PARAM_TYPE_PAGER, VCardConstants.PARAM_TYPE_BBS, VCardConstants.PARAM_TYPE_MODEM, VCardConstants.PARAM_TYPE_CAR, VCardConstants.PARAM_TYPE_ISDN, VCardConstants.PARAM_TYPE_VIDEO, "AOL", "APPLELINK", "ATTMAIL", "CIS", "EWORLD", VCardConstants.PARAM_TYPE_INTERNET, "IBMMAIL", "MCIMAIL", "POWERSHARE", "PRODIGY", VCardConstants.PARAM_TYPE_TLX, "X400", "GIF", "CGM", "WMF", "BMP", "MET", "PMB", "DIB", "PICT", "TIFF", "PDF", "PS", "JPEG", "QTIME", "MPEG", "MPEG2", "AVI", "WAVE", "AIFF", "PCM", "X509", "PGP"})));
        sKnownValueSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"INLINE", VCardConstants.PROPERTY_URL, "CONTENT-ID", "CID"})));
        sAvailableEncoding = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{VCardConstants.PARAM_ENCODING_7BIT, VCardConstants.PARAM_ENCODING_8BIT, VCardConstants.PARAM_ENCODING_QP, VCardConstants.PARAM_ENCODING_BASE64, VCardConstants.PARAM_ENCODING_B})));
    }

    public VCardParser_V21() {
        this.mVCardParserImpl = new VCardParserImpl_V21();
    }

    public VCardParser_V21(int r2) {
        this.mVCardParserImpl = new VCardParserImpl_V21(r2);
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
