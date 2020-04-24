/**
 * @file: PageResponse
 * @author: michael
 * @date: 2020/4/22 17:03
 * @copyright: 南京凯盛
 */
package org.kisen.cloud.mms.common.controller.page;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author michael
 * @version 1.0 Created on 2020/4/22 17:03
 */
@Data
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = 6219256383129192228L;

    private int code;
    private String msg;
    private T data;

}