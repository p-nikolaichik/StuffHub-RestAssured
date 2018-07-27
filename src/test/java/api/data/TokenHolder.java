package api.data;

public class TokenHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getToken() {
        return threadLocal.get();
    }

    public static void setToken(String token) {
        threadLocal.set(token);
    }

    public static void clearToken() {
        threadLocal.remove();
    }
}
