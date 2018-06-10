package cn.meixs;

public class BeanCopierNotFoundException extends RuntimeException {
    public BeanCopierNotFoundException(String key) {
        super("Bean copier: " + key + " not found.");
    }
}
