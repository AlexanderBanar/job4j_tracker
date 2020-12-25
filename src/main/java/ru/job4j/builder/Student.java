package ru.job4j.builder;

public class Student {
    private String name;
    private String surname;
    private byte grade;
    private String degree;
    private boolean intern;
    private int account;
    private char loyalty;

    public static class Builder {
        private String name;
        private String surname;
        private byte grade;
        private String degree;
        private boolean intern;
        private int account;
        private char loyalty;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildGrade(byte grade) {
            this.grade = grade;
            return this;
        }

        Builder buildDegree(String degree) {
            this.degree = degree;
            return this;
        }

        Builder buildIntern(boolean intern) {
            this.intern = intern;
            return this;
        }

        Builder buildAccount(int account) {
            this.account = account;
            return this;
        }

        Builder buildLoyalty(char loyalty) {
            this.loyalty = loyalty;
            return this;
        }

        Student build() {
            Student student = new Student();
            student.name = name;
            student.surname = surname;
            student.grade = grade;
            student.degree = degree;
            student.intern = intern;
            student.account = account;
            student.loyalty = loyalty;
            return student;
        }
    }
}
