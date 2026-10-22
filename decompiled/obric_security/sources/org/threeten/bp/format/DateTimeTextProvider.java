package org.threeten.bp.format;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DateTimeTextProvider {
    private static final AtomicReference<DateTimeTextProvider> MUTABLE_PROVIDER = null;

    static class ProviderSingleton {
        static final DateTimeTextProvider PROVIDER = null;

        ProviderSingleton() {
        }

        static {
            PROVIDER = initialize();
        }

        static DateTimeTextProvider initialize() {
            b0$$ExternalSyntheticBackport0.m(DateTimeTextProvider.access$000(), null, new SimpleDateTimeTextProvider());
            return (DateTimeTextProvider) DateTimeTextProvider.access$000().get();
        }
    }

    public abstract String getText(TemporalField r1, long r2, TextStyle r4, Locale r5);

    public abstract Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField r1, TextStyle r2, Locale r3);

    public DateTimeTextProvider() {
    }

    static /* synthetic */ AtomicReference access$000() {
        return MUTABLE_PROVIDER;
    }

    static {
        MUTABLE_PROVIDER = new AtomicReference();
    }

    static DateTimeTextProvider getInstance() {
        return ProviderSingleton.PROVIDER;
    }

    public static void setInitializer(DateTimeTextProvider r2) {
        if (b0$$ExternalSyntheticBackport0.m(MUTABLE_PROVIDER, null, r2) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Provider was already set, possibly with a default during initialization");
    }
}
