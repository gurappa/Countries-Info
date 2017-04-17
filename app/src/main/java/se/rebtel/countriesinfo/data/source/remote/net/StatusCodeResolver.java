/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.remote.net;

import java.util.HashMap;
import java.util.Map;

/**
 * Map of HTTP status code to description.
 */
public class StatusCodeResolver {
    public enum Status {
        CONTINUE("Continue"),
        SWITCHING_PROTOCOLS("Switching Protocols"),
        OK("OK"),
        CREATED("Created"),
        ACCEPTED("Accepted"),
        NON_AUTHORITATIVE_INFORMATION("Non-Authoritative Information"),
        NO_CONTENT("No Content"),
        RESET_CONTENT("Reset Content"),
        PARTIAL_CONTENT("Partial Content"),
        MULTIPLE_CHOICES("Multiple Choices"),
        MOVED_PERMANENTLY("Moved Permanently"),
        FOUND("Found"),
        SEE_OTHER("See Other"),
        NOT_MODIFIED("Not Modified"),
        USE_PROXY("Use Proxy"),
        TEMPORARY_REDIRECT("Temporary Redirect"),
        BAD_REQUEST("Bad Request"),
        UNAUTHORIZED("Unauthorized"),
        PAYMENT_REQUIRED("Payment Required"),
        FORBIDDEN("Forbidden"),
        NOT_FOUND("Not Found"),
        METHOD_NOT_ALLOWED("Method Not Allowed"),
        NOT_ACCEPTABLE("Not Acceptable"),
        PROXY_AUTHENTICATION_REQUIRED("Proxy Authentication Required"),
        REQUEST_TIME_OUT("Request Time-out"),
        CONFLICT("Conflict"),
        GONE("Gone"),
        LENGTH_REQUIRED("Length Required"),
        PRECONDITION_FAILED("Precondition Failed"),
        REQUEST_ENTITY_TOO_LARGE("Request Entity Too Large"),
        REQUEST_URI_TOO_LARGE("Request-URI Too Large"),
        UNSUPPORTED_MEDIA_TYPE("Unsupported Media Type"),
        REQUESTED_RANGE_NOT_SATISFIABLE("Requested range not satisfiable"),
        EXPECTATION_FAILED("Expectation Failed"),
        INTERNAL_SERVER_ERROR("Internal Server Error"),
        NOT_IMPLEMENTED("Not Implemented"),
        BAD_GATEWAY("Bad Gateway"),
        SERVICE_UNAVAILABLE("Service Unavailable"),
        GATEWAY_TIME_OUT("Gateway Time-out"),
        HTTP_VERSION_NOT_SUPPORTED("HTTP Version not supported");

        String name;

        Status(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static final Map<Integer, String> statusCodes = new HashMap<>();

    static {
        statusCodes.put(100, Status.CONTINUE.getName());
        statusCodes.put(101, Status.SWITCHING_PROTOCOLS.getName());
        statusCodes.put(200, Status.OK.getName());
        statusCodes.put(201, Status.CREATED.getName());
        statusCodes.put(202, Status.ACCEPTED.getName());
        statusCodes.put(203, Status.NON_AUTHORITATIVE_INFORMATION.getName());
        statusCodes.put(204, Status.NO_CONTENT.getName());
        statusCodes.put(206, Status.PARTIAL_CONTENT.getName());
        statusCodes.put(300, Status.MULTIPLE_CHOICES.getName());
        statusCodes.put(301, Status.MOVED_PERMANENTLY.getName());
        statusCodes.put(302, Status.FOUND.getName());
        statusCodes.put(303, Status.SEE_OTHER.getName());
        statusCodes.put(304, Status.NOT_MODIFIED.getName());
        statusCodes.put(305, Status.USE_PROXY.getName());
        statusCodes.put(307, Status.TEMPORARY_REDIRECT.getName());
        statusCodes.put(400, Status.BAD_REQUEST.getName());
        statusCodes.put(401, Status.UNAUTHORIZED.getName());
        statusCodes.put(402, Status.PAYMENT_REQUIRED.getName());
        statusCodes.put(403, Status.FORBIDDEN.getName());
        statusCodes.put(404, Status.NOT_FOUND.getName());
        statusCodes.put(405, Status.METHOD_NOT_ALLOWED.getName());
        statusCodes.put(406, Status.NOT_ACCEPTABLE.getName());
        statusCodes.put(407, Status.PROXY_AUTHENTICATION_REQUIRED.getName());
        statusCodes.put(408, Status.REQUEST_TIME_OUT.getName());
        statusCodes.put(409, Status.CONFLICT.getName());
        statusCodes.put(410, Status.GONE.getName());
        statusCodes.put(411, Status.LENGTH_REQUIRED.getName());
        statusCodes.put(412, Status.PRECONDITION_FAILED.getName());
        statusCodes.put(413, Status.REQUEST_ENTITY_TOO_LARGE.getName());
        statusCodes.put(414, Status.REQUEST_URI_TOO_LARGE.getName());
        statusCodes.put(415, Status.UNSUPPORTED_MEDIA_TYPE.getName());
        statusCodes.put(416, Status.REQUESTED_RANGE_NOT_SATISFIABLE.getName());
        statusCodes.put(417, Status.EXPECTATION_FAILED.getName());
        statusCodes.put(500, Status.INTERNAL_SERVER_ERROR.getName());
        statusCodes.put(501, Status.NOT_IMPLEMENTED.getName());
        statusCodes.put(502, Status.BAD_GATEWAY.getName());
        statusCodes.put(503, Status.SERVICE_UNAVAILABLE.getName());
        statusCodes.put(504, Status.GATEWAY_TIME_OUT.getName());
        statusCodes.put(505, Status.HTTP_VERSION_NOT_SUPPORTED.getName());
    }

    public static String getStatus(int statusCode) {
        return statusCodes.get(statusCode);
    }
}
