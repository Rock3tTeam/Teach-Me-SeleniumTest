package com.eci.arsw.notifiers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notifier {
    private static final List<String> notifications = new ArrayList<>();

    private Notifier() {
    }

    public static void addNotification(String notification) {
        notifications.add(notification);
    }

    public static void printNotifications() {
        System.out.println(new Date());
        notifications.forEach(System.out::println);
    }

    public static void writeNotifications() throws IOException {
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("notifications/report.txt");
            pw = new PrintWriter(fichero);
            pw.println(new Date()+"\n");
            notifications.forEach(pw::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Nuevamente aprovechamos el finally para
            // asegurarnos que se cierra el fichero.
            if (null != fichero) {
                fichero.close();
            }

        }
    }
}
