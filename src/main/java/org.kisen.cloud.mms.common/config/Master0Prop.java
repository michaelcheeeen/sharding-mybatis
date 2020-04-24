/**
 * @file: Master0Prop
 * @author: michael
 * @date: 2020/4/22 15:21
 * @copyright: 南京凯盛
 */
package org.kisen.cloud.mms.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 *
 * @author michael
 * @version 1.0 Created on 2020/4/22 15:21
 */
@ConfigurationProperties(prefix = "spring.shardingsphere.datasource.master0")
@Data
public class Master0Prop {
    private String url;
    private String username;
    private String password;
    private String type;
    private String driverClassName;
}
