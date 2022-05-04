package com.example.gestion_tickets_incidents.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.gestion_tickets_incidents.security.ApplicationPermissions.*;

public enum ApplicationRoles {
    ADMIN(Sets.newHashSet(TICKET_READ,TICKET_WRITE,TICKET_UPDATE,USER_READ,USER_WRITE,USER_UPDATE,USER_DELETE)),
    CLIENT(Sets.newHashSet(TICKET_READ,TICKET_WRITE)),
    DEVELOPER(Sets.newHashSet(TICKET_READ,TICKET_UPDATE));

    private final Set<ApplicationPermissions> applicationPermissions;

    ApplicationRoles(Set<ApplicationPermissions> applicationPermissions) {
        this.applicationPermissions = applicationPermissions;
    }
}
