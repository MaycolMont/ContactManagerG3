/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ContactModel;
import java.time.LocalDate;
import util.DataStructures.MyArrayList;
import java.util.Random;
/**
 *
 * @author elmay
 */

public class ContactGenerator {

    private static final String[] NAMES = {"Juan", "Ana", "Carlos", "Sofía", "Luis", "Valeria", "Mateo", "Camila"};
    private static final String[] LASTNAMES = {"Pérez", "González", "López", "Ramírez", "Torres", "Salazar"};
    private static final String[] DOMAINS = {"gmail.com", "hotmail.com", "yahoo.com", "ups.edu.ec"};
    private static final String[] ADDRESSES = {"Quito", "Guayaquil", "Cuenca", "Ambato", "Loja"};

    private static final Random random = new Random();

    public static MyArrayList<ContactModel> generarateByName(String[] names) {
        MyArrayList<ContactModel> contacts = new MyArrayList<>();
        for (String name : names) {
            ContactModel contact = new ContactModel.Builder().
                    setName(name)
                    .build();
            contacts.add(contact);
        }
        return contacts;
    }
    
    public static MyArrayList<ContactModel> generarateByEmail(String[] emails) {
        MyArrayList<ContactModel> contacts = new MyArrayList<>();
        for (String email : emails) {
            ContactModel contact = new ContactModel.Builder().
                    setEmail(email)
                    .build();
            contacts.add(contact);
        }
        return contacts;
    }
    
    public static MyArrayList<ContactModel> generarateContacts(int cantidad) {
        MyArrayList<ContactModel> contactos = new MyArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            String name = getName();
            String number = getRandomPhoneNumber();
            String email = getEmail(name);
            String direction = getDirection();
            boolean favorite = random.nextBoolean();
            LocalDate birthday = getRandomBirthday();
            String image = "img/default" + (random.nextInt(5) + 1) + ".png"; // imagina que tienes 5 imágenes base

            ContactModel contacto = new ContactModel.Builder()
                    .setName(name)
                    .setNumber(number)
                    .setEmail(email)
                    .setDirection(direction)
                    .setImagePath(image)
                    .setFavorite(favorite)
                    .setBirthdayDate(birthday)
                    .build();

            contactos.add(contacto);
        }

        return contactos;
    }

    private static String getName() {
        String name = NAMES[random.nextInt(NAMES.length)];
        String lastname = LASTNAMES[random.nextInt(LASTNAMES.length)];
        return name + " " + lastname;
    }

    private static String getRandomPhoneNumber() {
        return "09" + (10000000 + random.nextInt(90000000)); // 09XXXXXXXX
    }

    private static String getEmail(String fullName) {
        String username = fullName.toLowerCase().replace(" ", ".");
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];
        return username + "@" + domain;
    }

    private static String getDirection() {
        return ADDRESSES[random.nextInt(ADDRESSES.length)];
    }

    private static LocalDate getRandomBirthday() {
        int year = 1970 + random.nextInt(40);  // entre 1970 y 2009
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);      // evita problemas de febrero
        return LocalDate.of(year, month, day);
    }
}
