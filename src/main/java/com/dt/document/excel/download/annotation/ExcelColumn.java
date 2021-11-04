package com.dt.document.excel.download.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: lucheng
 * @data: 2021/11/2 16:17
 * @version: 1.0
 * @Retention 声明该注解ExcelColumn的生命周期可以在运行时期存在
 * @Target 注解声明ExcelColumn只能被标注在类的字段上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelColumn {
    String name() default "";

    /**
     * index start from 0 (index = 1 represents for the first column)
     * @return
     */
    int index() default -1;
    /**
     * 单元格的类型，如果为value则为单一值类型
     *              如果为list则为List, 需要与fromIndex toIndex绑定
     * @return
     */
    String type() default "value";
    int fromIndex() default -1;
    int toIndex() default -1;
}
