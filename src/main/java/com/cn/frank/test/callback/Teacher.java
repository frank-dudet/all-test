package com.cn.frank.test.callback;

/**
 * Author: frank_du
 * Time : 2017/4/26 上午9:45
 */
public class Teacher implements CallBack {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }


    public void askQuestion(Student student) {
        student.resolveProblem(this);
    }


    public String tellAnswer(String answer) {
        System.out.println("student answer is " + answer);
        return "success";
    }
}
