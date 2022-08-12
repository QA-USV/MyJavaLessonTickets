package ru.netology.MyJavaLessonTickets;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String u) {
        super(u);
    }
}
