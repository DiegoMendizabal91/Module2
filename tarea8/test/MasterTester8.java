import java.util.List;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MasterTester8 {
    public static boolean hasSuperClass(final Class<?> clazz, final String anObject) {
        return clazz.getSuperclass().getSimpleName().equals(anObject);
    }

    public static boolean isAbstract(final Class<?> clazz) {
        return Modifier.isAbstract(clazz.getModifiers());
    }

    public static boolean hasFieldType(final Class<?> clazz, final String anObject) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        for (int length = declaredFields.length, i = 0; i < length; ++i) {
            if (declaredFields[i].getType().getSimpleName().equals(anObject)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasFieldName(final Class<?> clazz, final String anObject) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        for (int length = declaredFields.length, i = 0; i < length; ++i) {
            if (declaredFields[i].getName().equals(anObject)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPrivateField(final Class<?> clazz, final String anObject, final String anObject2) {
        for (final Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(anObject2)) {
                return field.getType().getSimpleName().equals(anObject) && Modifier.isPrivate(field.getModifiers());
            }
        }
        return false;
    }

    public static boolean hasPublicField(final Class<?> clazz, final String anObject, final String anObject2) {
        for (final Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(anObject2)) {
                return field.getType().getSimpleName().equals(anObject) && Modifier.isPublic(field.getModifiers());
            }
        }
        return false;
    }

    public static boolean hasField(final Class<?> clazz, final String anObject, final String anObject2) {
        for (final Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(anObject2)) {
                return field.getType().getSimpleName().equals(anObject);
            }
        }
        return false;
    }

    public static boolean hasNumberOfFieldType(final Class<?> clazz, final String anObject, final int n) {
        int n2 = 0;
        final Field[] declaredFields = clazz.getDeclaredFields();
        for (int length = declaredFields.length, i = 0; i < length; ++i) {
            if (declaredFields[i].getType().getSimpleName().equals(anObject)) {
                ++n2;
            }
        }
        return n2 == n;
    }

    public static boolean hasMethod(final Class<?> clazz, final String anObject) {
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int length = declaredMethods.length, i = 0; i < length; ++i) {
            if (declaredMethods[i].getName().equals(anObject)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasMethod(final Class<?> clazz, final String s, final Class<?> clazz2, final Class<?>... parameterTypes) {
        if (parameterTypes == null) {
            for (final Method method : clazz.getDeclaredMethods()) {
                if (method.getName().equals(s) && method.getReturnType().equals(clazz2)) {
                    return true;
                }
            }
            return false;
        }
        try {
            return clazz.getDeclaredMethod(s, (Class[])parameterTypes).getReturnType().equals(clazz2);
        }
        catch (NoSuchMethodException ex) {
            return false;
        }
    }

    public static boolean hasMethodReturnsCollection(final Class<?> clazz, final String name, final String anObject, final String anObject2, final Class<?>... parameterTypes) {
        try {
            final Method declaredMethod = clazz.getDeclaredMethod(name, (Class[])parameterTypes);
            for (final Type type : ((ParameterizedType)declaredMethod.getGenericReturnType()).getActualTypeArguments()) {
                if (declaredMethod.getReturnType().getName().equals(anObject) && type.getTypeName().equals(anObject2)) {
                    return true;
                }
            }
        }
        catch (NoSuchMethodException ex) {
            return false;
        }
        return false;
    }

    public static boolean hasNumFields(final Class<?> clazz, final int n) {
        return clazz.getDeclaredFields().length == n;
    }

    public static boolean hasNumMethods(final Class<?> clazz, final int n) {
        return clazz.getDeclaredMethods().length == n;
    }

    public boolean implementsInterfaces(final Class<?> clazz, final List<String> list) {
        final Class<?>[] interfaces = (Class<?>[])clazz.getInterfaces();
        int n = 0;
        final Class<?>[] array = interfaces;
        for (int length = array.length, i = 0; i < length; ++i) {
            if (!list.contains(array[i].getSimpleName())) {
                return false;
            }
            ++n;
        }
        return list.size() == n;
    }
}
