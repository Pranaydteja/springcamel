package com.csueb.camelhomework.routes;

import com.csueb.camelhomework.dao.Member;
import com.csueb.camelhomework.dao.Proj;
import com.csueb.camelhomework.dao.Project;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/*
    This is a camel router class, I have defined a camel route which will read data from the
    h2 DB, modify the data in the processor and insert the result in mongodb
*/
@Component
public class DataRouter extends RouteBuilder {

    private final String JPA_URI = "jpa:com.csueb.camelhomework.dao.Project?namedQuery=selectAll";
    private final String ROUTE_ID = "getRecords";
    private final String MONGODB_URI = "mongodb:mongodbBean?database=pdasari1&collection=Proj&operation=insert";

    @Override
    public void configure() {
        from(JPA_URI)
                .routeId(ROUTE_ID)
                .process(exchange -> {
                    Project p = exchange.getMessage().getBody(Project.class);
                    Member m1 = new Member(p.getEmployee1(), p.getRole1());
                    Member m2 = new Member(p.getEmployee2(), p.getRole2());
                    Proj proj = new Proj(p.getId(), p.getName(), Arrays.asList(m1, m2));
                    exchange.getIn().setBody(proj);
                })
                .to(MONGODB_URI)
                .log("${body}");
    }

}
