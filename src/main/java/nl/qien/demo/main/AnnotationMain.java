package nl.qien.demo.main;

import nl.qien.demo.annotation.Ruimte;
import nl.qien.demo.model.Dierentuin;

import java.lang.annotation.Annotation;

public class AnnotationMain {
    public static void main(String[] args) {
        Class annotationClass = Dierentuin.class;

        Annotation [] annotations = annotationClass.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);

            if (annotation instanceof Ruimte){
                Ruimte ruimteAnn = (Ruimte) annotation;
                System.out.println(ruimteAnn.value());
            }
        }
    }
}
