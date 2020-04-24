/**
 * @file: ResponseEnum
 * @author: michael
 * @date: 2020/4/22 17:04
 * @copyright: 南京凯盛
 */
package org.kisen.cloud.mms.common.controller.page;

/**
 *
 *
 * @author michael
 * @version 1.0 Created on 2020/4/22 17:04
 */
public enum ResponseEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private int code;

    private String name;

    ResponseEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}