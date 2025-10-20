package com.example.projecet1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TeacherClass {
    private static List<String> names=new ArrayList<String>();
    private static List<String> family=new ArrayList<String>();
    private static List<String> teacherIds=new ArrayList<String>();

    public static void addTeacher(String Name, String Family, String TeacherId) {
        names.add(Name);
        family.add(Family);
        teacherIds.add(TeacherId);
    }

    public TeacherClass() {

    }

    public  List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }

    public List<String> getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(List<String> teacherIds) {
        this.teacherIds = teacherIds;
    }
}
