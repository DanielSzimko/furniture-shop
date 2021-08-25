package hu.ulyssys.java.course.maven.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/demo")
public class RestHelloWorldRestService {

    // /api/demo/hello-world
    @GET
    @Path("/hello-world")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorld() {
        return Response.ok("hello world").build();
    }

    @GET
    @Path("/hello-world/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorldPathParam(@PathParam("name") String name) {
        return Response.ok("ez volt a szöveg:" + name).build();
    }

    @GET
    @Path("/query-test/{from}/{to}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorldQueryParam2(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return Response.ok("from értéke " + from + " to értéke " + to).build();
    }

    @GET
    @Path("/query-test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorldQueryParam(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {
        return Response.ok("from értéke " + from + " to értéke " + to).build();
    }

    @GET
    @Path("/test-model")
    @Produces(MediaType.APPLICATION_JSON)
    public Response demoModel() {
        List<TestModel> modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestModel testModel = new TestModel();
            testModel.setId(Long.parseLong(i+""));
            testModel.setName("név12");
            testModel.setDescription("Ez leírása");
            modelList.add(testModel);
        }

        return Response.ok(modelList).build();
    }


    @GET
    @Path("/test-model-param")
    @Produces(MediaType.APPLICATION_JSON)
    public Response demoModel(@QueryParam("id") Long id, @QueryParam("name") String name) {
        TestModel testModel = new TestModel();
        testModel.setId(id);
        testModel.setName(name);
        testModel.setDescription("Ez leírása");
        return Response.ok(testModel).build();
    }

    @POST
    @Path("/test-model")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response demoPost(TestModel testModel) {
        testModel.setId(System.currentTimeMillis());
        return Response.ok(testModel).build();
    }

    //módosítás jelentené
    @PUT
    @Path("/test-model")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response demoPut(TestModel testModel) {
        return Response.ok(testModel).build();
    }

    @DELETE
    @Path("/test-model/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        return Response.ok().build();
    }
}
