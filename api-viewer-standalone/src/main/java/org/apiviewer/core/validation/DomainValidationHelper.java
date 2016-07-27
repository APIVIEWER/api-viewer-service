package org.apiviewer.core.validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DomainValidationHelper {

    @Value(value = "${error.validation.message.nickname}")
    public static String nickNameRequiredValidationMessage;
    
    @Value(value = "${error.validation.message.ipaddress}")
    public static String ipAddressRequiredValidationMessage;
    
    @Value(value = "${error.validation.message.port}")
    public static String port;
}
