package za.api.core.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Azael on 2017/12/01.
 */
@Component
public class WebUtil {
    public static String getClientIp(HttpServletRequest request) {

        String remoteAddress = "";

        if (request != null) {
            remoteAddress = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddress == null || "".equals(remoteAddress)) {
                remoteAddress = request.getRemoteAddr();
            }
        }
        return remoteAddress;
    }

    public static String getRequestFullUrl(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

    public static String getRequestUrl(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }

    public static String getRequestUrlParameters(HttpServletRequest request) {
        return request.getQueryString();
    }
}
