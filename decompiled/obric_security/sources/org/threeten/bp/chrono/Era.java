package org.threeten.bp.chrono;

import java.util.Locale;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;

/* JADX INFO: loaded from: classes5.dex */
public interface Era extends TemporalAccessor, TemporalAdjuster {
    String getDisplayName(TextStyle r1, Locale r2);

    int getValue();
}
