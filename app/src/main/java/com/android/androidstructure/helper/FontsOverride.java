package com.android.androidstructure.helper;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

public class FontsOverride {

    public static void establishFonts(Context context, String defaultFont, String customFont) {
        Typeface sEfFontStyle = Typeface.createFromAsset(context.getAssets(), customFont);
        try {
            final Field staticField = Typeface.class.getDeclaredField(defaultFont);
            staticField.setAccessible(true);
            staticField.set(null, sEfFontStyle);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
