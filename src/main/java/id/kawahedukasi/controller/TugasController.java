package id.kawahedukasi.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.kawahedukasi.model.Peserta;
import id.kawahedukasi.model.Tugas;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/tugas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TugasController {
    @GET
    @Path("/{parcitipantId}")
    public Response get(@PathParam("parcitipantId") Long id) {
        Peserta peserta = Peserta.findById(id);
        if (peserta == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(Tugas.find("participant_id = ?1", peserta.id).list()).build();
    }//mengambil semua data

    @POST
    @Path("/{parcitipantId}")
    @Transactional //harus pake untuk ke database
    public Response post(@PathParam("parcitipantId") Long id, Map<String, Object> request){
        Peserta peserta = Peserta.findById(id);
        if (peserta == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Tugas tugas = new Tugas();
        tugas.name = request.get("name").toString();
        tugas.score = Integer.parseInt(request.get("score").toString());
        tugas.peserta = peserta; //relasi

        tugas.persist();//method untuk save ke database

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }
}
