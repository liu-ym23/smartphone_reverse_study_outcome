package com.android.settings.voice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.provider.Settings;
import android.service.voice.VoiceInteractionServiceInfo;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Xml;
import com.android.internal.R;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class VoiceInputHelper {
    static final String TAG = "VoiceInputHelper";
    final ArrayList<InteractionInfo> mAvailableInteractionInfos;
    final List<ResolveInfo> mAvailableRecognition;
    final ArrayList<RecognizerInfo> mAvailableRecognizerInfos;
    final List<ResolveInfo> mAvailableVoiceInteractions;
    final Context mContext;
    ComponentName mCurrentRecognizer;
    ComponentName mCurrentVoiceInteraction;

    public static class BaseInfo implements Comparable {
        public final CharSequence appLabel;
        public final ComponentName componentName;
        public final String key;
        public final CharSequence label;
        public final String labelStr;
        public final ServiceInfo service;

        /* JADX INFO: renamed from: settings, reason: collision with root package name */
        public final ComponentName f5settings;

        public BaseInfo(PackageManager r4, ServiceInfo r5, String r6) {
            this.service = r5;
            ComponentName r0 = new ComponentName(r5.packageName, r5.name);
            this.componentName = r0;
            this.key = r0.flattenToShortString();
            if (r6 == null) goto L5;
            ComponentName r1 = new ComponentName(r5.packageName, r6);
        L6:
            this.f5settings = r1;
            CharSequence r7 = r5.loadLabel(r4);
            this.label = r7;
            this.labelStr = r7.toString();
            this.appLabel = r5.applicationInfo.loadLabel(r4);
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r1) {
            return this.labelStr.compareTo(((BaseInfo) r1).labelStr);
        }
    }

    public static class InteractionInfo extends BaseInfo {
        public final VoiceInteractionServiceInfo serviceInfo;

        public InteractionInfo(PackageManager r3, VoiceInteractionServiceInfo r4) {
            super(r3, r4.getServiceInfo(), r4.getSettingsActivity());
            this.serviceInfo = r4;
        }
    }

    public static class RecognizerInfo extends BaseInfo {
        public RecognizerInfo(PackageManager r1, ServiceInfo r2, String r3) {
            super(r1, r2, r3);
        }
    }

    public VoiceInputHelper(Context r4) {
        this.mAvailableInteractionInfos = new ArrayList();
        this.mAvailableRecognizerInfos = new ArrayList();
        this.mContext = r4;
        this.mAvailableVoiceInteractions = r4.getPackageManager().queryIntentServices(new Intent("android.service.voice.VoiceInteractionService"), 128);
        this.mAvailableRecognition = r4.getPackageManager().queryIntentServices(new Intent("android.speech.RecognitionService"), 128);
    }

    public boolean hasItems() {
        if (this.mAvailableVoiceInteractions.size() <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.mAvailableRecognition.size() > 0) goto L8;
        return false;
    }

    public void buildUi() {
        String r2 = Settings.Secure.getString(this.mContext.getContentResolver(), "voice_interaction_service");
        XmlResourceParser r3 = null;
        if (r2 != null) goto L5;
    L7:
        this.mCurrentVoiceInteraction = null;
    L8:
        ArraySet r4 = new ArraySet();
        int r5 = this.mAvailableVoiceInteractions.size();
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L15;
        ResolveInfo r7 = this.mAvailableVoiceInteractions.get(r6);
        VoiceInteractionServiceInfo r8 = new VoiceInteractionServiceInfo(this.mContext.getPackageManager(), r7.serviceInfo);
        if (r8.getParseError() == null) goto L13;
        OLog.w("VoiceInteractionService", "Error in VoiceInteractionService " + r7.serviceInfo.packageName + LibrarianImpl.Constants.SEPARATOR + r7.serviceInfo.name + ": " + r8.getParseError());
    L14:
        r6 = r6 + 1;
        goto L9
    L13:
        this.mAvailableInteractionInfos.add(new InteractionInfo(this.mContext.getPackageManager(), r8));
        r4.add(new ComponentName(r7.serviceInfo.packageName, r8.getRecognitionService()));
        goto L14
    L15:
        Collections.sort(this.mAvailableInteractionInfos);
        String r9 = Settings.Secure.getString(this.mContext.getContentResolver(), "voice_recognition_service");
        if (r9 != null) goto L18;
    L20:
        this.mCurrentRecognizer = null;
    L21:
        int r10 = this.mAvailableRecognition.size();
        int r11 = 0;
    L22:
        if (r11 >= r10) goto L77;
        ResolveInfo r12 = this.mAvailableRecognition.get(r11);
        r4.contains(new ComponentName(r12.serviceInfo.packageName, r12.serviceInfo.name));
        ServiceInfo r13 = r12.serviceInfo;
        XmlResourceParser r14 = r13.loadXmlMetaData(this.mContext.getPackageManager(), "android.speech");     // Catch: Throwable -> L54 PackageManager.NameNotFoundException -> L56 IOException -> L61 XmlPullParserException -> L66
        if (r14 == null) goto L53;
        Resources r15 = this.mContext.getPackageManager().getResourcesForApplication(r13.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L46 IOException -> L48 XmlPullParserException -> L50 Throwable -> L72
        AttributeSet r16 = Xml.asAttributeSet(r14);     // Catch: PackageManager.NameNotFoundException -> L46 IOException -> L48 XmlPullParserException -> L50 Throwable -> L72
    L27:
        int r17 = r14.next();     // Catch: PackageManager.NameNotFoundException -> L46 IOException -> L48 XmlPullParserException -> L50 Throwable -> L72
        if (r17 == 1) goto L33;
        if (r17 != 2) goto L27;
    L33:
        if ("recognition-service".equals(r14.getName()) == false) goto L45;
        TypedArray r18 = r15.obtainAttributes(r16, R.styleable.RecognitionService);     // Catch: PackageManager.NameNotFoundException -> L46 IOException -> L48 XmlPullParserException -> L50 Throwable -> L72
        String r19 = r18.getString(0);     // Catch: PackageManager.NameNotFoundException -> L46 IOException -> L48 XmlPullParserException -> L50 Throwable -> L72
        r18.recycle();     // Catch: PackageManager.NameNotFoundException -> L38 IOException -> L40 XmlPullParserException -> L42 Throwable -> L72
        if (r14 == null) goto L71;
    L37:
        r14.close();
    L71:
        this.mAvailableRecognizerInfos.add(new RecognizerInfo(this.mContext.getPackageManager(), r12.serviceInfo, r19));
        r11 = r11 + 1;
        goto L22
    L38:
        e = e;
    L58:
        OLog.e(TAG, "error parsing recognition service meta-data", e);     // Catch: Throwable -> L72
        if (r14 == null) goto L71;
    L40:
        e = e;
    L63:
        OLog.e(TAG, "error parsing recognition service meta-data", e);     // Catch: Throwable -> L72
        if (r14 == null) goto L71;
    L42:
        e = e;
    L68:
        OLog.e(TAG, "error parsing recognition service meta-data", e);     // Catch: Throwable -> L72
        if (r14 == null) goto L71;
    L45:
        throw new XmlPullParserException("Meta-data does not start with recognition-service tag");     // Catch: PackageManager.NameNotFoundException -> L46 IOException -> L48 XmlPullParserException -> L50 Throwable -> L72
    L72:
        th = th;
        r3 = r14;
    L74:
        if (r3 == null) goto L76;
        r3.close();
    L76:
        throw th;
    L46:
        e = e;
        r19 = null;
    L48:
        e = e;
        r19 = null;
    L50:
        e = e;
        r19 = null;
        goto L68
    L53:
        throw new XmlPullParserException("No android.speech meta-data for " + r13.packageName);     // Catch: PackageManager.NameNotFoundException -> L46 IOException -> L48 XmlPullParserException -> L50 Throwable -> L72
    L56:
        e = e;
        r14 = null;
        r19 = null;
    L61:
        e = e;
        r14 = null;
        r19 = null;
    L66:
        e = e;
        r14 = null;
        r19 = null;
    L54:
        th = th;
        goto L74
    L77:
        Collections.sort(this.mAvailableRecognizerInfos);
        return;
    L18:
        if (r9.isEmpty() == true) goto L20;
        this.mCurrentRecognizer = ComponentName.unflattenFromString(r9);
        goto L21
    L5:
        if (r2.isEmpty() == true) goto L7;
        this.mCurrentVoiceInteraction = ComponentName.unflattenFromString(r2);
        goto L8
    }
}
