package com.perujug.micronaut;

import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.oraclecloud.function.OciFunction;
import io.micronaut.oraclecloud.core.TenancyIdProvider;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class Function extends OciFunction {
    @Inject
    TenancyIdProvider tenantIdProvider;

    @ReflectiveAccess
    public static class Input {
        public String name;

    }

    @ReflectiveAccess
    public static class Result {
        public String salutation;

    }

    @ReflectiveAccess
    public Result handleRequest(Input input) {
        Result result = new Result();
        result.salutation = "Hello " + input.name;
        System.out.println(result.salutation);
        return result;
    }
}
