package com.bikash.bikashBackend.util;

public class UrlConstraint {
    private UrlConstraint() {
    }
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    private static final String VERSION = "/v1";
    private static final String API = "/api";

    public static class ProductManagement {
        public static final String ROOT = API + VERSION + "/products";
        public static final String CREATE = "/create";
        public static final String UPDATE = "/{id}";
        public static final String DELETE = "/{id}";
        public static final String GET = "/{id}";
        public static final String GET_ALL = "/all";
    }
    public static class UserManagement {
        public static final String ROOT = API + VERSION + "/users";
        public static final String GET_USER = "/all-User";
        public static final String CREATE = "/create";
    }
    public static class AuthManagement {
        public static final String ROOT = API + "/auth";
        public static final String LOGIN = "/login";
    }
}
