package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)

    public String hello() {
        List<List<Integer>> listOfList = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1000, 2000, 3000);
        List<Integer> list2 = Arrays.asList(4000);
        List<Integer> list3 = Arrays.asList(5000, 6000);
        List<Integer> list4 = Arrays.asList(7000, 8000, 9000);
        List<Integer> list5 = Arrays.asList(10000);
        listOfList.add(list1);
        listOfList.add(list2);
        listOfList.add(list3);
        listOfList.add(list4);
        listOfList.add(list5);

        Integer max = 0;
        int i = 0;
        int index = 0;
        int most = 0;
        for (List<Integer> list : listOfList) {
            // sum the values in each list
          Integer resList =  list.stream().reduce(0, Integer::sum);
          // get index
            index++;
          if (resList > max) {
            max = resList;
            most = index;

          }

        }

        return "calories:"+max.toString() + " "+"lutin:" + most;
    }

}
