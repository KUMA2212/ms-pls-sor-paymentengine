package com.lcf.pls.paymentengine.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class MasterUtils {


    public List<String> getMandatoryHeaders() {
        List<String> mandatoryHeaders = new ArrayList();
        mandatoryHeaders.add("AUTHORIZATION");
        mandatoryHeaders.add("CONTENT-TYPE");
        mandatoryHeaders.add("CHANNEL");
        mandatoryHeaders.add("PIN-CODE-ID");
        mandatoryHeaders.add("SERVICE-TYPE");
        return mandatoryHeaders;
    }


    public LCFRequestHeaders validateAndSetHeaders(Map<String, String> headers) {
        List<String> mandatoryHeaderList = this.getMandatoryHeaders();
        Map<String, String> upperCaseNameKeyHeaders = getUpperCaseMapKeys(headers);
        LCFRequestHeaders requestHeaders = new LCFRequestHeaders();
        mandatoryHeaderList.forEach((mandatoryHeader) -> {

            switch (mandatoryHeader) {
                case "AUTHORIZATION":
                    requestHeaders.setAuthorization(this.getAuthorization(upperCaseNameKeyHeaders, "AUTHORIZATION"));
                    break;
                case "CONTENT-TYPE":
                    requestHeaders.setContentType(this.validateContentType(upperCaseNameKeyHeaders, "CONTENT-TYPE"));
                    break;
                case "CHANNEL":
                    requestHeaders.setChannel(this.validateChannel(upperCaseNameKeyHeaders, "CHANNEL"));
                    break;
                case "PIN-CODE-ID":
                    requestHeaders.setPinCodeID(this.validatePinCodeId(upperCaseNameKeyHeaders, "PIN-CODE-ID"));
                    break;
                case "SERVICE-TYPE":
                    requestHeaders.setServiceType(this.validateServiceType(upperCaseNameKeyHeaders, "SERVICE-TYPE"));
            }

        });
        return requestHeaders;
    }
    public String getAuthorization(Map<String, String> headers, String headerName) {
        return (String)headers.get(headerName);
    }

    public String validateContentType(Map<String, String> headers, String headerName) {
        String contentType = (String) headers.get(headerName);
        if (StringUtils.isEmpty(contentType)) {
            throw new RuntimeException();
        } else {
            return contentType;
        }
    }

    public String validateChannel(Map<String, String> headers, String headerName) {
        String channel = (String)headers.get(headerName);
        if (StringUtils.isEmpty(channel)) {
            throw new RuntimeException();
        } else {
            return channel;
        }
    }

    public String validateServiceType(Map<String, String> headers, String headerName) {
        String serviceType = (String) headers.get(headerName);
        if (StringUtils.isEmpty(serviceType)) {
            throw new RuntimeException();
        } else if (!serviceType.equals("OLD") && !serviceType.equals("NEW")) {
            throw new RuntimeException();
        } else {
            return serviceType;
        }
    }

    public String validatePinCodeId(Map<String, String> headers, String headerName) {
        String pinCodeId = (String) headers.get(headerName);
        if (StringUtils.isEmpty(pinCodeId)) {
            throw new RuntimeException();
        } else if (!pinCodeId.matches("\\d{6}")) {
            throw new RuntimeException();
        } else {
            return pinCodeId;
        }
    }
    public static Map<String, String> getUpperCaseMapKeys(Map<String, String> map) {
        return (Map)map.entrySet().stream().filter((e) -> e.getKey() != null).collect(Collectors.toMap((e) -> String.valueOf(((String)e.getKey()).toUpperCase()), (e) -> String.valueOf(e.getValue())));
    }

    public static HttpEntity<Object> createRequest(Object obj, HttpHeaders httpHeaders) {
        return new HttpEntity<>(obj, httpHeaders);
    }
}
