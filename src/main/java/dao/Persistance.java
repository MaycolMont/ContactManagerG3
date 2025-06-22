/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import util.DataStructures.MyArrayList;
import java.util.List;
import model.ContactModel;

/**
 *
 * @author maycmont
 */
public class Persistance {
    private static final File archivo = new File("data/contactos.json");
    private static final ObjectMapper mapper = new ObjectMapper();

    // Leer la lista de contactos del archivo
    protected static MyArrayList<ContactModel> readContacts() {
        mapper.registerModule(new JavaTimeModule());
        if (!archivo.exists()) return new MyArrayList<>();
        try {
            return mapper.readValue(archivo, new TypeReference<MyArrayList<ContactModel>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new MyArrayList<>();
        }
    }

    protected static void saveList(List<ContactModel> list) {
        try {
            File carpeta = archivo.getParentFile();
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, list);
            System.out.println("Contacto guardado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
