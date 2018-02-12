package template.libraries.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mate-1 on 12/2/2016.
 */
public class HTTPUtils {
    public String baseUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + request.getContextPath();
    }

    /**
     *
     * @param relativeUrl the url relative to the current request url. If it
     *                    starts with a slash(/), it is interpreted as
     *                    relative to the server's context.
     * @param request
     * @return
     */
    public String fullUrl(String relativeUrl, HttpServletRequest request) {
        if(relativeUrl.startsWith("/")) {
            return  baseUrl(request)+relativeUrl;
        } else {
            return request.getServletPath()+"/"+relativeUrl;
        }
    }
}
