package cn.meixs;

import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseMapper {
    private static BeanCopierRepository beanCopierRepository = new BeanCopierRepository();

    /**
     * Create targetClass instance, and copy properties from source when they have same property name and type.
     *
     * @param targetClass
     * @param source
     * @param <T>
     * @return
     */
    protected <T> T create(Class<T> targetClass, Object source) {
        try {
            T target = targetClass.newInstance();
            getBeanCopier(source.getClass(), targetClass).copy(source, target, null);

            return target;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Copy properties from source to target.
     * Only properties with same name and type will be copied.
     *
     * @param source
     * @param target
     */
    protected void copy(Object source, Object target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());

        copier.copy(source, target, null);
    }

    protected synchronized BeanCopier register(Class<?> sourceClass, Class<?> targetClass) {
        return beanCopierRepository.register(sourceClass, targetClass);
    }

    private BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass) {
        return beanCopierRepository.getBeanCopier(sourceClass, targetClass);
    }

    private static class BeanCopierRepository {
        /**
         * Use a nested map for the performance reason.
         * If use map with key = fromClass.name + toClass.name, the String operation is too expensive.
         */
        private Map<String, Map<String, BeanCopier>> beanCopiers = new HashMap<>();

        public BeanCopier register(Class<?> fromClass, Class<?> toClass) {
            Map<String, BeanCopier> map = beanCopiers.get(fromClass.getName());
            if (map == null) {
                map = new HashMap<>();
                beanCopiers.put(fromClass.getName(), map);
            }

            if (map.get(toClass.getName()) == null) {
                BeanCopier result = BeanCopier.create(fromClass, toClass, false);
                map.put(toClass.getName(), result);
            }

            return map.get(toClass.getName());
        }

        public BeanCopier getBeanCopier(Class<?> fromClass, Class<?> toClass) {
            Map<String, BeanCopier> map = beanCopiers.get(fromClass.getName());
            if (map == null) {
                throw new BeanCopierNotFoundException(fromClass.getName() + " to " + toClass);
            }

            BeanCopier result = map.get(toClass.getName());
            if (result == null) {
                throw new BeanCopierNotFoundException(fromClass.getName() + " to " + toClass);
            }

            return result;
        }
    }
}
