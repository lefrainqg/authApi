/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth.services;

import auth.entity.Sesion;
import auth.logic.AutenticacionLN;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Efrain
 */
@Stateless
@Path("sesion")
public class SesionFacadeREST extends AbstractFacade<Sesion> {

    @PersistenceContext(unitName = "wsAuth_authapi_war_1.0PU")
    private EntityManager em;

    public SesionFacadeREST() {
        super(Sesion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Sesion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Sesion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Sesion find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("/find")
    @Produces({MediaType.APPLICATION_JSON})
    public Sesion findByUsername(@QueryParam("username") String strUsername) {
        try {
            Query q = em.createNamedQuery("Sesion.findBySesUsername", Sesion.class);
            q.setParameter("sesUsername", strUsername);
            Sesion ses = (Sesion) q.getSingleResult();
            return ses != null ? ses : null;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    @GET
    @Path("/autenticacion")
    @Produces({MediaType.APPLICATION_JSON})
    public Sesion auth(@QueryParam("id") Integer id, @QueryParam("username") String strUsername, @QueryParam("password") String strPassword) {
        Sesion ses = super.find(id);
        String validar = AutenticacionLN.verificarAuth(ses, strUsername, strPassword);
        if (validar.equals("ok")) {
            return ses;
        } else {
            return null;
        }
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Sesion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Sesion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
