/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.util.constant;

import javax.xml.transform.sax.SAXResult;

/**
 * <h1>
 *     Message
 * </h1>
 * <p>
 *     Contains the Default Messages to display to the User
 *     according to Success, Failure, Exception, and Error
 * </p>
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
public class Message {
    //SHOULD NOT BE EMPTY MESSAGES
    public static final String NAME_SHOULD_NOT_BE_EMPTY = "Name should not be Empty";
    public static final String EMAIL_SHOULD_NOT_BE_EMPTY = "Email should not be Empty";
    public static final String PHONE_SHOULD_NOT_BE_EMPTY = "Phone Number should not be Empty";
    public static final String PASSWORD_SHOULD_NOT_BE_EMPTY = "Password should not be Empty";
    public static final String AMOUNT_SHOULD_NOT_BE_EMPTY = "Amount should not be Empty";
    public static final String PAYMENT_MODE_SHOULD_NOT_BE_EMPTY = "Mode of Payment should not be Empty";
    public static final String MOVIE_NAME_SHOULD_NOT_BE_EMPTY = "Movie Name should not be Empty";
    public static final String BOOKING_MODE_SHOULD_NOT_BE_EMPTY = "Mode of Booking should not be Empty";
    public static final String ROLE_NAME_SHOULD_NOT_BE_EMPTY = "Role Name should not be Empty";
    public static final String SEAT_NAME_SHOULD_NOT_BE_EMPTY = "Seat Name should not be Empty";
    //INVALID INPUT MESSAGES
    public static final String ENTER_VALID_NAME = "Please, Enter Valid Name";
    public static final String ENTER_VALID_EMAIL = "Please, Enter Valid Email";
    public static final String ENTER_VALID_PHONE_NUMBER = "Please, Enter Valid Phone";
    public static final String ENTER_VALID_PASSWORD = "Please, Enter Valid Password(minimum 8 characters)";
    public static final String ENTER_VALID_ROLE = "Please, Enter Valid Role";
    public static final String ENTER_VALID_PAYMENT_MODE = "Please, Select 1.Cash 2.Card 3.Upi";
    public static final String ENTER_VALID_AMOUNT = "Please, Enter Numbers Only for Amount";
    public static final String NUMBER_ALREADY_EXIST = "Phone Number Already Exist";
    public static final String USER_NAME_ALREADY_EXIST = "Name Already Exist, Please try Different Name";
    public static final String ROLE_NAME_ALREADY_EXIST = "Role Name Already Exist, Please try Different Name";
    //CLIENT RESPONSE MESSAGES
    public static final String CREATED_SUCCESSFULLY = "Created Successfully";
    public static final String FAILED_TO_CREATE = "Failed to Create";
    public static final String UPDATED_SUCCESSFULLY = "Updated Successfully";
    public static final String FAILED_TO_UPDATE = "Failed to Update";
    public static final String DELETED_SUCCESSFULLY = "Deleted Successfully";
    public static final String FAILED_TO_DELETE = "Failed To Delete";
    public static final String ROLE_NOT_FOUND = "Role Not Found";
    public static final String USER_NOT_FOUND = "User Not Found";
    public static final String TICKETS_NOT_AVAILABLE = "Tickets not Available";
    public static final String TICKET_BOOKED = "Ticket Booked";
    public static final String TICKET_CANCELED = "Ticket Canceled";
    public static final String NO_SHOWS_AVAILABLE = "No Shows Available";
    public static final String MOVIE_NOT_FOUND = "Movie Not Found";
    public static final String SCREEN_NOT_FOUND = "Screen Not Found";
}
