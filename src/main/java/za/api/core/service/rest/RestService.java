package za.api.core.service.rest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLDecoder;
import java.util.Arrays;

/**
 * Created by Azael on 2017/12/05.
 */
@Service
public class RestService {
    public static String url;
    public static String username;
    public static String password;
    public static String xApiKey;
    public static String apiKey;

    public static String createUrl(String url){
        return createUrlWithParameters(url, null);
    }

    public static String createUrlWithParameters(String url, MultiValueMap multiParameterValueMap) {
        if (multiParameterValueMap == null) return url;
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(multiParameterValueMap);
        return URLDecoder.decode(uri.toUriString());
    }

    public static HttpHeaders getHeaders() {
        String plainCredentials = username + ":" + password;
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.add("X-API-Key", xApiKey);
        headers.add("apiKey", apiKey);
        headers.setAccept(Arrays.asList(MediaType.ALL));
        return headers;
    }

    public static ResponseEntity<?> responseEntity(String url, HttpMethod httpMethod, Object parameter, Class clazz) {
        HttpEntity<?> request = parameter == null ? new HttpEntity<>(getHeaders()) : new HttpEntity<>(parameter, getHeaders());

        url = createUrl(url);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<?> responseEntity = restTemplate.exchange(url, httpMethod, request, clazz);
            return responseEntity;
        }catch (HttpStatusCodeException e){
            return new ResponseEntity<>(e.getStatusCode());
        }


    }

    //GET
    public static Object getResponseEntityObject(String url, Class clazz) {
        ResponseEntity responseEntity = getResponseEntity(url, clazz);
        return responseEntity.getBody();
    }

    public static Object getResponseEntityObject(String url, Object parameter, Class returnType) {
        ResponseEntity responseEntity = getResponseEntity(url, parameter, returnType);
        return responseEntity.getBody();
    }

    public static Object getResponseEntityObject(String url, Object parameter) {
        ResponseEntity responseEntity = getResponseEntity(url, parameter);
        return responseEntity.getBody();
    }

    public static Object getResponseEntityObject(String url) {
        ResponseEntity responseEntity = getResponseEntity(url);
        return responseEntity.getBody();
    }

    public static ResponseEntity<?> getResponseEntity(String url, Object parameter, Class returnType) {
        ResponseEntity<?> responseEntity = responseEntity(url, HttpMethod.GET, parameter, returnType);
        return responseEntity;
    }

    public static ResponseEntity<?> getResponseEntity(String url, Object parameter) {
        return getResponseEntity(url, parameter, Object.class);
    }

    public static ResponseEntity<?> getResponseEntity(String url, Class returnType) {
        return getResponseEntity(url, null, returnType);
    }

    public static ResponseEntity<?> getResponseEntity(String url) {
        return getResponseEntity(url, null, Object.class);
    }

    //POST

    public static Object postResponseEntityObject(String url, Class clazz) {
        ResponseEntity responseEntity = postResponseEntity(url, clazz);
        return responseEntity.getBody();
    }

    public static Object postResponseEntityObject(String url, Object parameter, Class returnType) {
        ResponseEntity responseEntity = postResponseEntity(url, parameter, returnType);
        return responseEntity.getBody();
    }

    public static Object postResponseEntityObject(String url, Object parameter) {
        ResponseEntity responseEntity = postResponseEntity(url, parameter);
        return responseEntity.getBody();
    }

    public static Object postResponseEntityObject(String url) {
        ResponseEntity responseEntity = postResponseEntity(url);
        return responseEntity.getBody();
    }

    public static ResponseEntity<?> postResponseEntity(String url, Object parameter, Class returnType) {
        return responseEntity(url, HttpMethod.POST, parameter, returnType);
    }

    public static ResponseEntity<?> postResponseEntity(String url, Object parameter) {
        return postResponseEntity(url, parameter, Object.class);
    }

    public static ResponseEntity<?> postResponseEntity(String url, Class returnType) {
        return postResponseEntity(url, null, returnType);
    }

    public static ResponseEntity<?> postResponseEntity(String url) {
        return postResponseEntity(url, null, Object.class);
    }
}
