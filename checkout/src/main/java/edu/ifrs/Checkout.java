package edu.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/checkout")
public class Checkout {
    
    @Inject
    @RestClient
    IPayment service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("User")
    public Invoice confirm(){
        return service.confirmPayment("123455","100");
    }

    @GET
    @Path("/jwt")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generate() {
        return Jwt.issuer("http://localhost:8080")
                .upn("rodrigo@rpmhub.dev")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.full_name, "Rodrigo Prestes Machado")
                .sign();
    }

}
