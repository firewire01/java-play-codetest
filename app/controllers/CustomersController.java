package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import java.util.*;
import models.*;
import play.libs.F.Promise;
import play.libs.Json;

/**
 *
 * @author marlon
 */
public class CustomersController extends Controller
{

    public Promise<Result> sortList()
    {
        return Promise.promise(() -> {

            JsonNode jsonNode = request().body().asJson();
            if (jsonNode == null) {
                return badRequest("Invalid request....");
            }

            List<Customer> list = new ArrayList();

            jsonNode.forEach(jsn -> {
                list.add(Json.fromJson(jsn, Customer.class));
            });

            // sort the list
            list.sort((c1, c2) -> {
                return c1.getDuetime().compareTo(c2.getDuetime());
            });

            return ok(Json.toJson(list));

        });
    }
}
