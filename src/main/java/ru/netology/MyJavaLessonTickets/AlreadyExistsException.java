package ru.netology.MyJavaLessonTickets;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String a) {
        super(a);
    }
}
