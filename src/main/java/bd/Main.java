package bd;

import app_logic.TeacherWindow;

import java.util.List;

public class Main {
    private static Teacher teacher;

    public static  void main (String[] args) {
        Teacher.getInstance().setup();

        new Thread( ()-> TeacherWindow.main(null)).start();
        //teacher = new Teacher();
        //List subjects_list =teacher.listPrzedmioty();

    }
}
