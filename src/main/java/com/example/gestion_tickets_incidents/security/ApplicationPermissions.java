package com.example.gestion_tickets_incidents.security;

public enum ApplicationPermissions {
    TICKET_READ("ticket:read"),
    TICKET_WRITE("ticket:write"),
    TICKET_DELETE("ticket:delete"),
    TICKET_UPDATE("ticket:update"),

    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_DELETE("user:delete"),
    USER_UPDATE("user:update"),
    ;
    private String permission;

    ApplicationPermissions(String permission) {
        this.permission=permission;
    }

    public String getPermission() {
        return permission;
    }


}
