package template.libraries.utils;

import template.libraries.exceptions.UtilsCheckException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mate-1 on 5/15/2017.
 */
public class Utils {
    public static int checkInt(String intAsString) {
        try {
            return Integer.parseInt(intAsString);
        } catch (Exception e) {
            throw new UtilsCheckException();
        }
    }

    public static String urlWithSchema(String url) {
        return url.startsWith("http") ? url : "http://" + url;
    }

    /**
     *
     * @param items if 0, or exceeds contents list size, returns all.
     * @param page starts at 1, 0 means all pages
     * @return
     */
    public static <T> List<T> pagination(int page, int items, List<T> list, int pageSize) {
        List<T> sublist;
        if(page==0) {
            sublist=list;
        } else {
            //derived mathematical formula
            int pageStartIndex = pageSize * (page - 1);
            //limit start index to end of list
            if(pageStartIndex>list.size()) {
                //eg., page=3453432423542 -> empty list will be returned
                pageStartIndex=list.size();
            }

            //limit to page size
            if(items==0 || items>pageSize) {
                items=pageSize;
            }

            sublist=list.subList(pageStartIndex,list.size());
        }

        return first(items,sublist);
    }

    /**
     * Will make a new list.
     * @param items
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> first(int items, List<T> list) {
        if(items==0 || items>=list.size()) {
            return new ArrayList<T>(list);
        } else {
            return new ArrayList<T>(list.subList(0,items));
        }
    }

    public static <T> List<T> getForObjects(RestTemplate restTemplate, String url, Class<T[]> objectsClass, Object... urlParams) {
        T[] objects = null;

        try {
            //fetch objects
            objects = restTemplate.getForObject(url, objectsClass, urlParams);
        } catch (HttpClientErrorException e) { // 404
            // Nothing found - handled below
        }

        if (objects == null || objects.length == 0)
            return new ArrayList<T>();
        else
            return Arrays.asList(objects);
    }

    public static void checkN0(int naturalInt) {
        if(naturalInt<0) {
            throw new UtilsCheckException();
        }
    }
}
