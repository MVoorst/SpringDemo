package nl.qien.demo.reflection;

import nl.qien.demo.model.Dierentuin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionApp {

    public static void main(String[] args) {

        // 1. get the fields of the motorbike class
        {

            System.out.println("Fields: ======================");
            Field[] fields = Dierentuin.class.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        }


        // 2. print the methods
        {
            System.out.println("Methods: ======================");
            Method[] methods = Dierentuin.class.getDeclaredMethods();
            for(Method method: methods) {
                System.out.println(method.getName());
            }
        }
        //3. print the constructors
        {

            // how many constructors?
            System.out.println(Dierentuin.class.getConstructors().length);

            Constructor<?>[] constructors = Dierentuin.class.getConstructors();

            for(Constructor<?> constructor: constructors) {

                System.out.println("Constructor:");



                // now ... we are interesting in the parameters of the constructors???

                for(Parameter parameter: constructor.getParameters()) {

                    System.out.printf("\tConstructor with type %s and name %s %n", parameter.getName(), parameter.getType().toString());

                }
            }
        }

        // 4. Print the annotations
        {

            //Question for group: Why do we see only one annotation (@Entity) ???
            Annotation[] annotations = Dierentuin.class.getAnnotations();
            for(Annotation annotation: annotations) {
                System.out.printf("The class %s has annotation %s which is of type %s %n", Dierentuin.class.toString(), annotation, annotation.annotationType());
            }
        }

    }
}