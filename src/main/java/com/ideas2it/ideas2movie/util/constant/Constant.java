/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.util.constant;

/**
 * <h1>
 *      Constant
 * </h1>
 * <p>
 *      Contains the Constant values like Regex pattern
 *      to be Used in the Ideas2Movie Application
 *      according to Success, Failure, Exception, and Error
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
public class Constant {
    public static final String NAME_PATTERN = "^([\\D]{0,20}[\s.]?){2}[\\D]{0,20}$";
    public static final String PHONE_NUMBER_PATTERN = "^[6-9]{1}[\\d]{9}$";
    public static final String PASSWORD_PATTERN = "^[A-Za-z0-9@#$*]{8,15}$";
    public static final String ROLE_PATTERN = "^(Admin|Customer)$";
    public static final String PAYMENT_MODE_PATTERN = "^(CASH|CARD|UPI)$";
    public static final String AMOUNT_PATTERN = "^\\$?[0-9]+(\\.[0-9]{2})?$";
}
