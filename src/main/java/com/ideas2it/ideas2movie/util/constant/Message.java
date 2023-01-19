/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.util.constant;

/**
 * <h2>
 *     Message
 * </h2>
 * <p>
 *     Contains the Default Messages to display to the User
 *     according to Success, Failure, Exception, and Error
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
public class Message {
    //SHOULD NOT BE EMPTY MESSAGES
    //FOR USER DTO
    public static final String NAME_SHOULD_NOT_BE_EMPTY = "Name should not be Empty";
    public static final String EMAIL_SHOULD_NOT_BE_EMPTY = "Email should not be Empty";
    public static final String PHONE_SHOULD_NOT_BE_EMPTY = "Phone Number should not be Empty";
    public static final String PASSWORD_SHOULD_NOT_BE_EMPTY = "Password should not be Empty";
    public static final String ROLE_ID_SHOULD_NOT_BE_EMPTY = "Role Id should not be Empty";
    //ROLE DTO
    public static final String ROLE_NAME_SHOULD_NOT_BE_EMPTY = "Role Name should not be Empty";
    //PAYMENT DTO
    public static final String AMOUNT_SHOULD_NOT_BE_EMPTY = "Amount should not be Empty";
    public static final String PAYMENT_MODE_SHOULD_NOT_BE_EMPTY = "Mode of Payment should not be Empty";
    public static final String RESERVATION_ID_SHOULD_NOT_BE_EMPTY = "Reservation Id should not e Empty";
    //THEATER DTO
    public static final String THEATER_NAME_SHOULD_NOT_BE_EMPTY = "Theater Name Should Not be Empty";
    public static final String CITY_NAME_SHOULD_NOT_BE_EMPTY = "City Name should not be Empty";
    public static final String AREA_NAME_SHOULD_NOT_BE_EMPTY = "Area Name should not be Empty";
    //CAST AND CREW DTO
    public static final String DIRECTOR_NAME_SHOULD_NOT_BE_EMPTY = "Director Name should not be Empty";
    public static final String HERO_NAME_SHOULD_NOT_BE_EMPTY = "Hero Name should not be Empty";
    public static final String HEROINE_NAME_SHOULD_NOT_BE_EMPTY = "Heroine Name should not be Empty";
    //MOVIE DTO
    public static final String MOVIE_NAME_SHOULD_NOT_BE_EMPTY = "Movie Name should not be Empty";
    public static final String LANGUAGE_SHOULD_NOT_BE_EMPTY = "Language should not be Empty";
    public static final String DURATION_SHOULD_NOT_BE_EMPTY = "Duration should not be Empty";
    public static final String GENRE_SHOULD_NOT_BE_EMPTY = "Genre should not be Empty";
    //RESERVATION DTO
    public static final String USER_SHOULD_NOT_BE_EMPTY = "User Id should not be Empty";
    public static final String SHOW_SHOULD_NOT_BE_EMPTY = "Show Id should not be Empty";
    public static final String SELECT_AT_LEAST_ONE_SEAT = "Select At-least One Seat";
    public static final String MODE_OF_RESERVATION_SHOULD_NOT_BE_EMPTY = "Mode of Reservation should not be Empty";
    //REGEX VALIDATION MESSAGES
    //USER
    public static final String ENTER_VALID_NAME = "Please, Enter Valid Name";
    public static final String ENTER_VALID_EMAIL = "Please, Enter Valid Email";
    public static final String ENTER_VALID_PHONE_NUMBER = "Please, Enter Valid Phone";
    public static final String ENTER_VALID_PASSWORD = "Please, Enter Valid Password(minimum 8 characters)";
    public static final String ENTER_VALID_ROLE = "Please, Enter Valid Role";
    //ALREADY EXIST MESSAGES
    public static final String NUMBER_ALREADY_EXIST = "Phone Number Already Exist";
    public static final String USER_NAME_ALREADY_EXIST = "Name Already Exist, Please try Different Name";
    public static final String NAME_AND_NUMBER_ALREADY_EXIST = "Name and Phone number is Already Exist";
    public static final String ROLE_NAME_ALREADY_EXIST = "Role Name Already Exist, Please try Different Name";
    public static final String SCREEN_ALREADY_EXISTS = "Screen Already Exist";
    public static final String THEATER_ALREADY_REGISTERED = "Theater Already Registered";
    public static final String SHOW_ALREADY_EXISTS = "Show Already Exist for given time and date";
    //COMMON MESSAGES
    public static final String FAILED_TO_UPDATE = "Failed to Update";
    public static final String DELETED_SUCCESSFULLY = "Deleted Successfully";
    public static final String FAILED_TO_DELETE = "Failed To Delete";
    public static final String INVALID_SHOW_TIME = "Start time is lesser than end time";
    //NOT FOUND MESSAGES
    public static final String ROLE_NOT_FOUND = "Role Not Found";
    public static final String USER_NOT_FOUND = "User Not Found";
    public static final String NO_SHOWS_AVAILABLE = "No Shows Available";
    public static final String MOVIE_NOT_FOUND = "Movie Not Found";
    public static final String CAST_AND_CREW_NOT_FOUND = "Cast and Crew Not Found";
    public static final String SCREEN_NOT_FOUND = "Screen Not Found";
    public static final String THEATER_NOT_FOUND = "Theater Not Found";
    public static final String SHOW_NOT_FOUND = "Show Not Found";
    public static final String PAYMENT_NOT_FOUND = "Payment Not Found";
    public static final String RESERVATION_NOT_FOUND = "Reservation Not Found";
    public static final String TICKET_NOT_FOUND = "Ticket Not Found";
    public static final String SEAT_NOT_FOUND = "Seat Not Found";
    public static final String ACCOUNT_NOT_FOUND = "Account Not Found";
}
