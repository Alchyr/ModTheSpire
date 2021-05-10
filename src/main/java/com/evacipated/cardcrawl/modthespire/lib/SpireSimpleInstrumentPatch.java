package com.evacipated.cardcrawl.modthespire.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpireSimpleInstrumentPatch {
    enum InstrumentType {
        METHOD,
        CONSTRUCTOR, //only valid if patching constructor
        FIELD_READ,
        FIELD_WRITE,
        NEWEXPR,
        NEWARRAY,
        INSTANCEOF,
        CAST
    }

    InstrumentType type();
    String name() default ""; //Name of method/field
    String classname() default ""; //Name of class method/field is defined in, or name of class for new expression/instanceof
    String pattern() default "";
    Class<?>[] paramtypez() default {void.class};
}
